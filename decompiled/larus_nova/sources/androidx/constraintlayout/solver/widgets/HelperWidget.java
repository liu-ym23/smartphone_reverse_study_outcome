package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r100) {
    }

    public HelperWidget() {
        this.mWidgets = new ConstraintWidget[4];
        this.mWidgetsCount = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void add(ConstraintWidget r100) {
        if (r100 == this) goto L10;
        if (r100 == null) goto L11;
        int r101 = this.mWidgetsCount + 1;
        ConstraintWidget[] r102 = this.mWidgets;
        if (r101 <= r102.length) goto L8;
        this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(r102, r102.length * 2);
    L8:
        ConstraintWidget[] r103 = this.mWidgets;
        int r104 = this.mWidgetsCount;
        r103[r104] = r100;
        this.mWidgetsCount = r104 + 1;
        return;
    L11:
        return;
    }

    public int findGroupInDependents(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mWidgetsCount) goto L16;
        ConstraintWidget r102 = this.mWidgets[r101];
        if (r100 != 0) goto L11;
        int r103 = r102.horizontalGroup;
        if (r103 == (-1)) goto L11;
        return r103;
    L11:
        if (r100 != 1) goto L15;
        int r104 = r102.verticalGroup;
        if (r104 == (-1)) goto L15;
        return r104;
    L15:
        r101 = r101 + 1;
        goto L4
    L16:
        return -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.copy(r100, r101);
        HelperWidget r102 = (HelperWidget) r100;
        int r103 = 0;
        this.mWidgetsCount = 0;
        int r104 = r102.mWidgetsCount;
    L3:
        if (r103 >= r104) goto L5;
        add(r101.get(r102.mWidgets[r103]));
        r103 = r103 + 1;
        goto L3
    }

    public void addDependents(ArrayList<WidgetGroup> r100, int r101, WidgetGroup r102) {
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= this.mWidgetsCount) goto L7;
        r102.add(this.mWidgets[r104]);
        r104 = r104 + 1;
    L7:
        if (r103 >= this.mWidgetsCount) goto L9;
        Grouping.findDependents(this.mWidgets[r103], r101, r100, r102);
        r103 = r103 + 1;
        goto L7
    }
}
