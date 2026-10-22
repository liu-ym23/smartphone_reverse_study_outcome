package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;
import o0.C4994b;

/* loaded from: classes.dex */
public class a extends C4994b {

    /* renamed from: X0, reason: collision with root package name */
    public int f12031X0 = 0;

    /* renamed from: Y0, reason: collision with root package name */
    public boolean f12032Y0 = true;

    /* renamed from: Z0, reason: collision with root package name */
    public int f12033Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f12034a1 = false;

    public int A1() {
        return this.f12031X0;
    }

    public int B1() {
        return this.f12033Z0;
    }

    public int C1() {
        int i10 = this.f12031X0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    public void D1() {
        for (int i10 = 0; i10 < this.f37461W0; i10++) {
            ConstraintWidget constraintWidget = this.f37460V0[i10];
            if (this.f12032Y0 || constraintWidget.h()) {
                int i11 = this.f12031X0;
                if (i11 == 0 || i11 == 1) {
                    constraintWidget.X0(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    constraintWidget.X0(1, true);
                }
            }
        }
    }

    public void E1(boolean z10) {
        this.f12032Y0 = z10;
    }

    public void F1(int i10) {
        this.f12031X0 = i10;
    }

    public void G1(int i10) {
        this.f12033Z0 = i10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.c cVar, boolean z10) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z11;
        int i10;
        int i11;
        int i12;
        ConstraintAnchor[] constraintAnchorArr2 = this.f11976Y;
        constraintAnchorArr2[0] = this.f11964Q;
        constraintAnchorArr2[2] = this.f11966R;
        constraintAnchorArr2[1] = this.f11968S;
        constraintAnchorArr2[3] = this.f11970T;
        int i13 = 0;
        while (true) {
            constraintAnchorArr = this.f11976Y;
            if (i13 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i13];
            constraintAnchor.f11930i = cVar.q(constraintAnchor);
            i13++;
        }
        int i14 = this.f12031X0;
        if (i14 < 0 || i14 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i14];
        if (!this.f12034a1) {
            y1();
        }
        if (this.f12034a1) {
            this.f12034a1 = false;
            int i15 = this.f12031X0;
            if (i15 == 0 || i15 == 1) {
                cVar.f(this.f11964Q.f11930i, this.f11993h0);
                cVar.f(this.f11968S.f11930i, this.f11993h0);
                return;
            } else {
                if (i15 == 2 || i15 == 3) {
                    cVar.f(this.f11966R.f11930i, this.f11995i0);
                    cVar.f(this.f11970T.f11930i, this.f11995i0);
                    return;
                }
                return;
            }
        }
        for (int i16 = 0; i16 < this.f37461W0; i16++) {
            ConstraintWidget constraintWidget = this.f37460V0[i16];
            if ((this.f12032Y0 || constraintWidget.h()) && ((((i11 = this.f12031X0) == 0 || i11 == 1) && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f11964Q.f11927f != null && constraintWidget.f11968S.f11927f != null) || (((i12 = this.f12031X0) == 2 || i12 == 3) && constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f11966R.f11927f != null && constraintWidget.f11970T.f11927f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = this.f11964Q.l() || this.f11968S.l();
        boolean z13 = this.f11966R.l() || this.f11970T.l();
        int i17 = !(!z11 && (((i10 = this.f12031X0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13))))) ? 4 : 5;
        for (int i18 = 0; i18 < this.f37461W0; i18++) {
            ConstraintWidget constraintWidget2 = this.f37460V0[i18];
            if (this.f12032Y0 || constraintWidget2.h()) {
                SolverVariable solverVariableQ = cVar.q(constraintWidget2.f11976Y[this.f12031X0]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.f11976Y;
                int i19 = this.f12031X0;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i19];
                constraintAnchor3.f11930i = solverVariableQ;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.f11927f;
                int i20 = (constraintAnchor4 == null || constraintAnchor4.f11925d != this) ? 0 : constraintAnchor3.f11928g;
                if (i19 == 0 || i19 == 2) {
                    cVar.i(constraintAnchor2.f11930i, solverVariableQ, this.f12033Z0 - i20, z11);
                } else {
                    cVar.g(constraintAnchor2.f11930i, solverVariableQ, this.f12033Z0 + i20, z11);
                }
                cVar.e(constraintAnchor2.f11930i, solverVariableQ, this.f12033Z0 + i20, i17);
            }
        }
        int i21 = this.f12031X0;
        if (i21 == 0) {
            cVar.e(this.f11968S.f11930i, this.f11964Q.f11930i, 0, 8);
            cVar.e(this.f11964Q.f11930i, this.f11983c0.f11968S.f11930i, 0, 4);
            cVar.e(this.f11964Q.f11930i, this.f11983c0.f11964Q.f11930i, 0, 0);
            return;
        }
        if (i21 == 1) {
            cVar.e(this.f11964Q.f11930i, this.f11968S.f11930i, 0, 8);
            cVar.e(this.f11964Q.f11930i, this.f11983c0.f11964Q.f11930i, 0, 4);
            cVar.e(this.f11964Q.f11930i, this.f11983c0.f11968S.f11930i, 0, 0);
        } else if (i21 == 2) {
            cVar.e(this.f11970T.f11930i, this.f11966R.f11930i, 0, 8);
            cVar.e(this.f11966R.f11930i, this.f11983c0.f11970T.f11930i, 0, 4);
            cVar.e(this.f11966R.f11930i, this.f11983c0.f11966R.f11930i, 0, 0);
        } else if (i21 == 3) {
            cVar.e(this.f11966R.f11930i, this.f11970T.f11930i, 0, 8);
            cVar.e(this.f11966R.f11930i, this.f11983c0.f11966R.f11930i, 0, 4);
            cVar.e(this.f11966R.f11930i, this.f11983c0.f11970T.f11930i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // o0.C4994b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        a aVar = (a) constraintWidget;
        this.f12031X0 = aVar.f12031X0;
        this.f12032Y0 = aVar.f12032Y0;
        this.f12033Z0 = aVar.f12033Z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean p0() {
        return this.f12034a1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean q0() {
        return this.f12034a1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + v() + " {";
        for (int i10 = 0; i10 < this.f37461W0; i10++) {
            ConstraintWidget constraintWidget = this.f37460V0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.v();
        }
        return str + "}";
    }

    public boolean y1() {
        int i10;
        int i11;
        int i12;
        boolean z10 = true;
        int i13 = 0;
        while (true) {
            i10 = this.f37461W0;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.f37460V0[i13];
            if ((this.f12032Y0 || constraintWidget.h()) && ((((i11 = this.f12031X0) == 0 || i11 == 1) && !constraintWidget.p0()) || (((i12 = this.f12031X0) == 2 || i12 == 3) && !constraintWidget.q0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i14 = 0; i14 < this.f37461W0; i14++) {
            ConstraintWidget constraintWidget2 = this.f37460V0[i14];
            if (this.f12032Y0 || constraintWidget2.h()) {
                if (!z11) {
                    int i15 = this.f12031X0;
                    if (i15 == 0) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.LEFT).e();
                    } else if (i15 == 1) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i15 == 2) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.TOP).e();
                    } else if (i15 == 3) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z11 = true;
                }
                int i16 = this.f12031X0;
                if (i16 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.q(ConstraintAnchor.Type.LEFT).e());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.q(ConstraintAnchor.Type.RIGHT).e());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.q(ConstraintAnchor.Type.TOP).e());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i17 = iMax + this.f12033Z0;
        int i18 = this.f12031X0;
        if (i18 == 0 || i18 == 1) {
            K0(i17, i17);
        } else {
            N0(i17, i17);
        }
        this.f12034a1 = true;
        return true;
    }

    public boolean z1() {
        return this.f12032Y0;
    }
}
