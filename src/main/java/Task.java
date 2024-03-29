import java.util.*;
abstract public class Task{

    //========================================================================//
    //========================================================================//
    //============================             ===============================//
    //============================  variables  ===============================//
    //============================             ===============================//
    //========================================================================//
    //========================================================================// 
    protected Date initialTDate,finalTDate;
    protected int estTDuration, progress;
    protected double effort;
    protected String Tname;
    Person responsible;
    //========================================================================//
    //========================================================================//
    //===========================                =============================//
    //===========================  Constructors  =============================//
    //===========================                =============================//
    //========================================================================//
    //========================================================================//
    
    
    public Task() {
        this.Tname = null;
        this.initialTDate = null;
        this.finalTDate = null;
        this.estTDuration = 0;
        this.progress = 0;
        this.responsible = null;
        
    }
    //========================================================================//
    //========================================================================//
    //=============================           ================================//
    //=============================  methods  ================================//
    //=============================           ================================//
    //========================================================================//
    //========================================================================//
    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public String getTName() {
        return Tname;
    }

    public void setTName(String name) {
        this.Tname = name;
    }
    
    public Date getInitialTDate() {
        return initialTDate;
    }

    public void setInitialTDate(Date initialTDate) {
        this.initialTDate = initialTDate;
    }

    public Date getFinalTDate() {
        return finalTDate;
    }

    public void setFinalTDate(Date finalTDate) {
        this.finalTDate = finalTDate;
    }

    public int getEstTDuration() {
        return estTDuration;
    }

    public void setEstTDuration(int estTDuration) {
        this.estTDuration = estTDuration;
    }

    public int getProgress() {
        return progress;
    }
    
    public void setResponsible(Person responsible){
        this.responsible = responsible ;
    }
    
    public Person getResponsible(){
        return this.responsible;
    }

    public void setProgress(int progress) {
        if (progress>=0 && progress<=100){
            this.progress = progress;
        }else{
            System.out.print("\nO valor excede uma percentagem");
        }
    }
    
    public void addTask(Task task){
        if((responsible.verifyEffort()+task.effort) > 1){
            System.out.printf("\nA tarefa %s excede o esforço maximo de %s",task.Tname,responsible.name);
        }else{
            responsible.tasks.add(task);
        }
    }
    
    public int finalDurationMonths(){
        Calendar startCalendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar();
        startCalendar.setTime(this.initialTDate);
        endCalendar.setTime(this.initialTDate);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }
    

    @Override
    public String toString() {
        return "\nTask{" + ", Tname=" + Tname + "initialTDate=" + initialTDate + ", finalTDate=" + finalTDate + ", estTDuration=" + estTDuration + ", progress=" + progress + ", effort=" + effort + '}';
    }
  
    public abstract double effort();

}
