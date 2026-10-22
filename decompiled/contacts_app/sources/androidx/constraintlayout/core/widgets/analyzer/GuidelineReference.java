package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
class GuidelineReference extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return false;
    }

    public GuidelineReference(ConstraintWidget r2) {
        super(r2);
        r2.horizontalRun.clear();
        r2.verticalRun.clear();
        this.orientation = ((Guideline) r2).getOrientation();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    private void addDependency(DependencyNode r2) {
        this.start.dependencies.add(r2);
        r2.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r2) {
        if (this.start.readyToSolve == true) goto L6;
        return;
    L6:
        if (this.start.resolved == false) goto L8;
        return;
    L8:
        this.start.resolve((int) ((this.start.targets.get(0).value * ((Guideline) this.widget).getRelativePercent()) + 0.5f));
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Guideline r0 = (Guideline) this.widget;
        int r1 = r0.getRelativeBegin();
        int r2 = r0.getRelativeEnd();
        r0.getRelativePercent();
        if (r0.getOrientation() != 1) goto L10;
        if (r1 == (-1)) goto L6;
        this.start.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        this.start.margin = r1;
    L9:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    L6:
        if (r2 == (-1)) goto L8;
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        int r3 = -r2;
        this.start.margin = r3;
        goto L9
    L8:
        this.start.delegateToWidgetRun = true;
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        goto L9
    L10:
        if (r1 == (-1)) goto L12;
        this.start.targets.add(this.widget.mParent.verticalRun.start);
        this.widget.mParent.verticalRun.start.dependencies.add(this.start);
        this.start.margin = r1;
    L15:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L12:
        if (r2 == (-1)) goto L14;
        this.start.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        int r4 = -r2;
        this.start.margin = r4;
        goto L15
    L14:
        this.start.delegateToWidgetRun = true;
        this.start.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        goto L15
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.widget).getOrientation() != 1) goto L5;
        this.widget.setX(this.start.value);
        return;
    L5:
        this.widget.setY(this.start.value);
    }
}
