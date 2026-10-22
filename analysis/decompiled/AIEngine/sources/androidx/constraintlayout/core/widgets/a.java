package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends g0.a {

    /* renamed from: t0, reason: collision with root package name */
    public int f1141t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f1142u0 = true;

    /* renamed from: v0, reason: collision with root package name */
    public int f1143v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f1144w0 = false;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean A() {
        return this.f1144w0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean B() {
        return this.f1144w0;
    }

    public final boolean T() {
        int i10;
        int i11;
        int i12;
        boolean z = true;
        int i13 = 0;
        while (true) {
            i10 = this.f8945s0;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.f8944r0[i13];
            if ((this.f1142u0 || constraintWidget.c()) && ((((i11 = this.f1141t0) == 0 || i11 == 1) && !constraintWidget.A()) || (((i12 = this.f1141t0) == 2 || i12 == 3) && !constraintWidget.B()))) {
                z = false;
            }
            i13++;
        }
        if (!z || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z3 = false;
        for (int i14 = 0; i14 < this.f8945s0; i14++) {
            ConstraintWidget constraintWidget2 = this.f8944r0[i14];
            if (this.f1142u0 || constraintWidget2.c()) {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.f1094d;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.f1092b;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.f1093c;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.f1091a;
                if (!z3) {
                    int i15 = this.f1141t0;
                    if (i15 == 0) {
                        iMax = constraintWidget2.i(type4).d();
                    } else if (i15 == 1) {
                        iMax = constraintWidget2.i(type3).d();
                    } else if (i15 == 2) {
                        iMax = constraintWidget2.i(type2).d();
                    } else if (i15 == 3) {
                        iMax = constraintWidget2.i(type).d();
                    }
                    z3 = true;
                }
                int i16 = this.f1141t0;
                if (i16 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.i(type4).d());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.i(type3).d());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.i(type2).d());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.i(type).d());
                }
            }
        }
        int i17 = iMax + this.f1143v0;
        int i18 = this.f1141t0;
        if (i18 == 0 || i18 == 1) {
            J(i17, i17);
        } else {
            K(i17, i17);
        }
        this.f1144w0 = true;
        return true;
    }

    public final int U() {
        int i10 = this.f1141t0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void b(androidx.constraintlayout.core.c cVar, boolean z) {
        boolean z3;
        int i10;
        ConstraintAnchor[] constraintAnchorArr = this.R;
        ConstraintAnchor constraintAnchor = this.J;
        constraintAnchorArr[0] = constraintAnchor;
        int i11 = 2;
        ConstraintAnchor constraintAnchor2 = this.K;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.L;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.M;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.f1090i = cVar.k(constraintAnchor5);
        }
        int i12 = this.f1141t0;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr[i12];
        if (!this.f1144w0) {
            T();
        }
        if (this.f1144w0) {
            this.f1144w0 = false;
            int i13 = this.f1141t0;
            if (i13 == 0 || i13 == 1) {
                cVar.d(constraintAnchor.f1090i, this.f1100a0);
                cVar.d(constraintAnchor3.f1090i, this.f1100a0);
                return;
            } else {
                if (i13 == 2 || i13 == 3) {
                    cVar.d(constraintAnchor2.f1090i, this.b0);
                    cVar.d(constraintAnchor4.f1090i, this.b0);
                    return;
                }
                return;
            }
        }
        for (int i14 = 0; i14 < this.f8945s0; i14++) {
            ConstraintWidget constraintWidget = this.f8944r0[i14];
            if (this.f1142u0 || constraintWidget.c()) {
                int i15 = this.f1141t0;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1138c;
                if (((i15 == 0 || i15 == 1) && constraintWidget.U[0] == dimensionBehaviour && constraintWidget.J.f1088f != null && constraintWidget.L.f1088f != null) || ((i15 == 2 || i15 == 3) && constraintWidget.U[1] == dimensionBehaviour && constraintWidget.K.f1088f != null && constraintWidget.M.f1088f != null)) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        boolean z10 = constraintAnchor.g() || constraintAnchor3.g();
        boolean z11 = constraintAnchor2.g() || constraintAnchor4.g();
        int i16 = !(!z3 && (((i10 = this.f1141t0) == 0 && z10) || ((i10 == 2 && z11) || ((i10 == 1 && z10) || (i10 == 3 && z11))))) ? 4 : 5;
        int i17 = 0;
        while (i17 < this.f8945s0) {
            ConstraintWidget constraintWidget2 = this.f8944r0[i17];
            if (this.f1142u0 || constraintWidget2.c()) {
                SolverVariable solverVariableK = cVar.k(constraintWidget2.R[this.f1141t0]);
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.R;
                int i18 = this.f1141t0;
                ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[i18];
                constraintAnchor7.f1090i = solverVariableK;
                ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1088f;
                int i19 = (constraintAnchor8 == null || constraintAnchor8.f1086d != this) ? 0 : constraintAnchor7.f1089g;
                if (i18 == 0 || i18 == i11) {
                    SolverVariable solverVariable = constraintAnchor6.f1090i;
                    int i20 = this.f1143v0 - i19;
                    androidx.constraintlayout.core.b bVarL = cVar.l();
                    SolverVariable solverVariableM = cVar.m();
                    solverVariableM.f1035d = 0;
                    bVarL.d(solverVariable, solverVariableK, solverVariableM, i20);
                    cVar.c(bVarL);
                } else {
                    SolverVariable solverVariable2 = constraintAnchor6.f1090i;
                    int i21 = this.f1143v0 + i19;
                    androidx.constraintlayout.core.b bVarL2 = cVar.l();
                    SolverVariable solverVariableM2 = cVar.m();
                    solverVariableM2.f1035d = 0;
                    bVarL2.c(solverVariable2, solverVariableK, solverVariableM2, i21);
                    cVar.c(bVarL2);
                }
                cVar.e(constraintAnchor6.f1090i, solverVariableK, this.f1143v0 + i19, i16);
            }
            i17++;
            i11 = 2;
        }
        int i22 = this.f1141t0;
        if (i22 == 0) {
            cVar.e(constraintAnchor3.f1090i, constraintAnchor.f1090i, 0, 8);
            cVar.e(constraintAnchor.f1090i, this.V.L.f1090i, 0, 4);
            cVar.e(constraintAnchor.f1090i, this.V.J.f1090i, 0, 0);
            return;
        }
        if (i22 == 1) {
            cVar.e(constraintAnchor.f1090i, constraintAnchor3.f1090i, 0, 8);
            cVar.e(constraintAnchor.f1090i, this.V.J.f1090i, 0, 4);
            cVar.e(constraintAnchor.f1090i, this.V.L.f1090i, 0, 0);
        } else if (i22 == 2) {
            cVar.e(constraintAnchor4.f1090i, constraintAnchor2.f1090i, 0, 8);
            cVar.e(constraintAnchor2.f1090i, this.V.M.f1090i, 0, 4);
            cVar.e(constraintAnchor2.f1090i, this.V.K.f1090i, 0, 0);
        } else if (i22 == 3) {
            cVar.e(constraintAnchor2.f1090i, constraintAnchor4.f1090i, 0, 8);
            cVar.e(constraintAnchor2.f1090i, this.V.K.f1090i, 0, 4);
            cVar.e(constraintAnchor2.f1090i, this.V.M.f1090i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean c() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final String toString() {
        String strO = ai.onnxruntime.a.o(new StringBuilder("[Barrier] "), this.f1115j0, " {");
        for (int i10 = 0; i10 < this.f8945s0; i10++) {
            ConstraintWidget constraintWidget = this.f8944r0[i10];
            if (i10 > 0) {
                strO = a0.a.j(strO, ", ");
            }
            StringBuilder sbB = v1.d.b(strO);
            sbB.append(constraintWidget.f1115j0);
            strO = sbB.toString();
        }
        return a0.a.j(strO, "}");
    }
}
