package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
class HelperReferences extends WidgetRun {
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r100 = this.widget;
        if ((r100 instanceof Barrier) == false) goto L69;
        this.start.delegateToWidgetRun = true;
        Barrier r101 = (Barrier) r100;
        int r102 = r101.getBarrierType();
        boolean r103 = r101.allowsGoneWidget();
        int r104 = 0;
        if (r102 == 0) goto L45;
        if (r102 != 1) goto L8;
        DependencyNode r105 = this.start;
        r105.type = DependencyNode.Type.RIGHT;
    L36:
        if (r104 >= r101.mWidgetsCount) goto L44;
        ConstraintWidget r106 = r101.mWidgets[r104];
        if (r103 == false) goto L40;
    L42:
        DependencyNode r107 = r106.horizontalRun.end;
        r107.dependencies.add(this.start);
        this.start.targets.add(r107);
    L43:
        r104 = r104 + 1;
        goto L36
    L40:
        if (r106.getVisibility() != 8) goto L42;
    L44:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    L8:
        if (r102 != 2) goto L10;
        DependencyNode r108 = this.start;
        r108.type = DependencyNode.Type.TOP;
    L25:
        if (r104 >= r101.mWidgetsCount) goto L33;
        ConstraintWidget r109 = r101.mWidgets[r104];
        if (r103 == false) goto L29;
    L31:
        DependencyNode r110 = r109.verticalRun.start;
        r110.dependencies.add(this.start);
        this.start.targets.add(r110);
    L32:
        r104 = r104 + 1;
        goto L25
    L29:
        if (r109.getVisibility() != 8) goto L31;
    L33:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L10:
        if (r102 != 3) goto L73;
        DependencyNode r111 = this.start;
        r111.type = DependencyNode.Type.BOTTOM;
    L14:
        if (r104 >= r101.mWidgetsCount) goto L22;
        ConstraintWidget r112 = r101.mWidgets[r104];
        if (r103 == false) goto L18;
    L20:
        DependencyNode r113 = r112.verticalRun.end;
        r113.dependencies.add(this.start);
        this.start.targets.add(r113);
    L21:
        r104 = r104 + 1;
        goto L14
    L18:
        if (r112.getVisibility() != 8) goto L20;
    L22:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L73:
        return;
    L45:
        DependencyNode r114 = this.start;
        r114.type = DependencyNode.Type.LEFT;
    L47:
        if (r104 >= r101.mWidgetsCount) goto L55;
        ConstraintWidget r115 = r101.mWidgets[r104];
        if (r103 == false) goto L51;
    L53:
        DependencyNode r116 = r115.horizontalRun.start;
        r116.dependencies.add(this.start);
        this.start.targets.add(r116);
    L54:
        r104 = r104 + 1;
        goto L47
    L51:
        if (r115.getVisibility() != 8) goto L53;
    L55:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        ConstraintWidget r100 = this.widget;
        if ((r100 instanceof Barrier) == false) goto L12;
        int r101 = ((Barrier) r100).getBarrierType();
        if (r101 != 0) goto L7;
    L10:
        this.widget.setX(this.start.value);
        return;
    L7:
        if (r101 == 1) goto L10;
        this.widget.setY(this.start.value);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
    }

    public HelperReferences(ConstraintWidget r100) {
        super(r100);
    }

    private void addDependency(DependencyNode r100) {
        this.start.dependencies.add(r100);
        r100.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r100) {
        Barrier r101 = (Barrier) this.widget;
        int r102 = r101.getBarrierType();
        Iterator<DependencyNode> r103 = this.start.targets.iterator();
        int r104 = 0;
        int r105 = -1;
    L4:
        if (r103.hasNext() == false) goto L11;
        int r106 = r103.next().value;
        if (r105 == (-1)) goto L8;
        if (r106 < r105) goto L8;
    L9:
        if (r104 >= r106) goto L4;
        r104 = r106;
    L8:
        r105 = r106;
        goto L9
    L11:
        if (r102 != 0) goto L13;
    L16:
        this.start.resolve(r105 + r101.getMargin());
        return;
    L13:
        if (r102 == 2) goto L16;
        this.start.resolve(r104 + r101.getMargin());
    }
}
