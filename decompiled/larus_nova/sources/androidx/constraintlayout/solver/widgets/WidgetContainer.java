package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public void layout() {
        ArrayList<ConstraintWidget> r100 = this.mChildren;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        ConstraintWidget r103 = (ConstraintWidget) ListProtector.get(this.mChildren, r102);
        if ((r103 instanceof WidgetContainer) == false) goto L10;
        ((WidgetContainer) r103).layout();
    L10:
        r102 = r102 + 1;
        goto L6
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public WidgetContainer() {
        this.mChildren = new ArrayList();
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget r100 = getParent();
        if ((this instanceof ConstraintWidgetContainer) == false) goto L5;
        ConstraintWidgetContainer r101 = (ConstraintWidgetContainer) this;
    L6:
        if (r100 == null) goto L11;
        ConstraintWidget r102 = r100.getParent();
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L10;
        r101 = (ConstraintWidgetContainer) r100;
    L10:
        r100 = r102;
        goto L6
    L11:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public void add(ConstraintWidget r100) {
        this.mChildren.add(r100);
        if (r100.getParent() == null) goto L5;
        ((WidgetContainer) r100.getParent()).remove(r100);
    L5:
        r100.setParent(this);
    }

    public void remove(ConstraintWidget r100) {
        this.mChildren.remove(r100);
        r100.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache r100) {
        super.resetSolverVariables(r100);
        int r101 = this.mChildren.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((ConstraintWidget) ListProtector.get(this.mChildren, r102)).resetSolverVariables(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void add(ConstraintWidget... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        add(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public WidgetContainer(int r100, int r101) {
        super(r100, r101);
        this.mChildren = new ArrayList();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int r100, int r101) {
        super.setOffset(r100, r101);
        int r102 = this.mChildren.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((ConstraintWidget) ListProtector.get(this.mChildren, r103)).setOffset(getRootX(), getRootY());
        r103 = r103 + 1;
        goto L3
    }

    public WidgetContainer(int r100, int r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.mChildren = new ArrayList();
    }
}
