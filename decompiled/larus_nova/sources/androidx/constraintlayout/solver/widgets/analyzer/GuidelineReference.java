package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes17.dex */
class GuidelineReference extends WidgetRun {
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Guideline r100 = (Guideline) this.widget;
        int r101 = r100.getRelativeBegin();
        int r102 = r100.getRelativeEnd();
        r100.getRelativePercent();
        if (r100.getOrientation() != 1) goto L10;
        if (r101 == (-1)) goto L6;
        this.start.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        this.start.margin = r101;
    L9:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    L6:
        if (r102 == (-1)) goto L8;
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        int r103 = -r102;
        this.start.margin = r103;
        goto L9
    L8:
        DependencyNode r104 = this.start;
        r104.delegateToWidgetRun = true;
        r104.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        goto L9
    L10:
        if (r101 == (-1)) goto L12;
        this.start.targets.add(this.widget.mParent.verticalRun.start);
        this.widget.mParent.verticalRun.start.dependencies.add(this.start);
        this.start.margin = r101;
    L15:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L12:
        if (r102 == (-1)) goto L14;
        this.start.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        int r105 = -r102;
        this.start.margin = r105;
        goto L15
    L14:
        DependencyNode r106 = this.start;
        r106.delegateToWidgetRun = true;
        r106.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        goto L15
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.widget).getOrientation() != 1) goto L5;
        this.widget.setX(this.start.value);
        return;
    L5:
        this.widget.setY(this.start.value);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    public GuidelineReference(ConstraintWidget r100) {
        super(r100);
        r100.horizontalRun.clear();
        r100.verticalRun.clear();
        this.orientation = ((Guideline) r100).getOrientation();
    }

    private void addDependency(DependencyNode r100) {
        this.start.dependencies.add(r100);
        r100.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r100) {
        DependencyNode r101 = this.start;
        if (r101.readyToSolve == true) goto L6;
        return;
    L6:
        if (r101.resolved == false) goto L8;
        return;
    L8:
        this.start.resolve((int) ((((DependencyNode) ListProtector.get(r101.targets, 0)).value * ((Guideline) this.widget).getRelativePercent()) + 0.5f));
    }
}
