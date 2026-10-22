package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* loaded from: classes.dex */
public class h extends i {
    @Override // androidx.constraintlayout.core.widgets.i
    public void H1(int i10, int i11, int i12, int i13) {
        int iE1 = E1() + F1();
        int iG1 = G1() + D1();
        if (this.f37461W0 > 0) {
            iE1 += this.f37460V0[0].Y();
            iG1 += this.f37460V0[0].z();
        }
        int iMax = Math.max(K(), iE1);
        int iMax2 = Math.max(J(), iG1);
        if (i10 != 1073741824) {
            i11 = i10 == Integer.MIN_VALUE ? Math.min(iMax, i11) : i10 == 0 ? iMax : 0;
        }
        if (i12 != 1073741824) {
            i13 = i12 == Integer.MIN_VALUE ? Math.min(iMax2, i13) : i12 == 0 ? iMax2 : 0;
        }
        M1(i11, i13);
        p1(i11);
        Q0(i13);
        L1(this.f37461W0 > 0);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.c cVar, boolean z10) {
        super.g(cVar, z10);
        if (this.f37461W0 > 0) {
            ConstraintWidget constraintWidget = this.f37460V0[0];
            constraintWidget.w0();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.j(type, this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.j(type2, this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.j(type3, this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.j(type4, this, type4);
        }
    }
}
