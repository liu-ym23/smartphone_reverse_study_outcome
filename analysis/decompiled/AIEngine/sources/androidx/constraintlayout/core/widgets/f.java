package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends ConstraintWidget {

    /* renamed from: r0, reason: collision with root package name */
    public float f1222r0 = -1.0f;

    /* renamed from: s0, reason: collision with root package name */
    public int f1223s0 = -1;

    /* renamed from: t0, reason: collision with root package name */
    public int f1224t0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    public ConstraintAnchor f1225u0 = this.K;

    /* renamed from: v0, reason: collision with root package name */
    public int f1226v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f1227w0;

    public f() {
        this.S.clear();
        this.S.add(this.f1225u0);
        int length = this.R.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.R[i10] = this.f1225u0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean A() {
        return this.f1227w0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean B() {
        return this.f1227w0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void Q(androidx.constraintlayout.core.c cVar, boolean z) {
        if (this.V == null) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.f1225u0;
        cVar.getClass();
        int iN = androidx.constraintlayout.core.c.n(constraintAnchor);
        if (this.f1226v0 == 1) {
            this.f1100a0 = iN;
            this.b0 = 0;
            L(this.V.k());
            O(0);
            return;
        }
        this.f1100a0 = 0;
        this.b0 = iN;
        O(this.V.q());
        L(0);
    }

    public final void R(int i10) {
        this.f1225u0.l(i10);
        this.f1227w0 = true;
    }

    public final void S(int i10) {
        if (this.f1226v0 == i10) {
            return;
        }
        this.f1226v0 = i10;
        ArrayList<ConstraintAnchor> arrayList = this.S;
        arrayList.clear();
        if (this.f1226v0 == 1) {
            this.f1225u0 = this.J;
        } else {
            this.f1225u0 = this.K;
        }
        arrayList.add(this.f1225u0);
        ConstraintAnchor[] constraintAnchorArr = this.R;
        int length = constraintAnchorArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            constraintAnchorArr[i11] = this.f1225u0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void b(androidx.constraintlayout.core.c cVar, boolean z) {
        d dVar = (d) this.V;
        if (dVar == null) {
            return;
        }
        Object objI = dVar.i(ConstraintAnchor.Type.f1091a);
        Object objI2 = dVar.i(ConstraintAnchor.Type.f1093c);
        ConstraintWidget constraintWidget = this.V;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1137b;
        boolean z3 = constraintWidget != null && constraintWidget.U[0] == dimensionBehaviour;
        if (this.f1226v0 == 0) {
            objI = dVar.i(ConstraintAnchor.Type.f1092b);
            objI2 = dVar.i(ConstraintAnchor.Type.f1094d);
            ConstraintWidget constraintWidget2 = this.V;
            z3 = constraintWidget2 != null && constraintWidget2.U[1] == dimensionBehaviour;
        }
        if (this.f1227w0) {
            ConstraintAnchor constraintAnchor = this.f1225u0;
            if (constraintAnchor.f1085c) {
                SolverVariable solverVariableK = cVar.k(constraintAnchor);
                cVar.d(solverVariableK, this.f1225u0.d());
                if (this.f1223s0 != -1) {
                    if (z3) {
                        cVar.f(cVar.k(objI2), solverVariableK, 0, 5);
                    }
                } else if (this.f1224t0 != -1 && z3) {
                    SolverVariable solverVariableK2 = cVar.k(objI2);
                    cVar.f(solverVariableK, cVar.k(objI), 0, 5);
                    cVar.f(solverVariableK2, solverVariableK, 0, 5);
                }
                this.f1227w0 = false;
                return;
            }
        }
        if (this.f1223s0 != -1) {
            SolverVariable solverVariableK3 = cVar.k(this.f1225u0);
            cVar.e(solverVariableK3, cVar.k(objI), this.f1223s0, 8);
            if (z3) {
                cVar.f(cVar.k(objI2), solverVariableK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f1224t0 != -1) {
            SolverVariable solverVariableK4 = cVar.k(this.f1225u0);
            SolverVariable solverVariableK5 = cVar.k(objI2);
            cVar.e(solverVariableK4, solverVariableK5, -this.f1224t0, 8);
            if (z3) {
                cVar.f(solverVariableK4, cVar.k(objI), 0, 5);
                cVar.f(solverVariableK5, solverVariableK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f1222r0 != -1.0f) {
            SolverVariable solverVariableK6 = cVar.k(this.f1225u0);
            SolverVariable solverVariableK7 = cVar.k(objI2);
            float f8 = this.f1222r0;
            androidx.constraintlayout.core.b bVarL = cVar.l();
            bVarL.f1060d.h(solverVariableK6, -1.0f);
            bVarL.f1060d.h(solverVariableK7, f8);
            cVar.c(bVarL);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean c() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final ConstraintAnchor i(ConstraintAnchor.Type type) {
        int iOrdinal = type.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return null;
                    }
                }
            }
            if (this.f1226v0 == 0) {
                return this.f1225u0;
            }
            return null;
        }
        if (this.f1226v0 == 1) {
            return this.f1225u0;
        }
        return null;
    }
}
