package androidx.constraintlayout.solver.widgets.analyzer;

/* JADX INFO: loaded from: classes17.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun r100) {
        super(r100);
    }

    public void update(DependencyNode r100) {
        WidgetRun r101 = this.run;
        DependencyNode r102 = ((VerticalWidgetRun) r101).baseline;
        r102.margin = r101.widget.getBaselineDistance();
        this.resolved = true;
    }
}
