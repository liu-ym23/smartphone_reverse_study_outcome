package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes.dex */
public class f extends ConstraintWidget {

    /* renamed from: V0, reason: collision with root package name */
    public float f12159V0 = -1.0f;

    /* renamed from: W0, reason: collision with root package name */
    public int f12160W0 = -1;

    /* renamed from: X0, reason: collision with root package name */
    public int f12161X0 = -1;

    /* renamed from: Y0, reason: collision with root package name */
    public boolean f12162Y0 = true;

    /* renamed from: Z0, reason: collision with root package name */
    public ConstraintAnchor f12163Z0 = this.f11966R;

    /* renamed from: a1, reason: collision with root package name */
    public int f12164a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    public int f12165b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f12166c1;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12167a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f12167a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12167a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12167a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12167a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12167a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12167a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12167a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12167a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12167a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public f() {
        this.f11977Z.clear();
        this.f11977Z.add(this.f12163Z0);
        int length = this.f11976Y.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f11976Y[i10] = this.f12163Z0;
        }
    }

    public float A1() {
        return this.f12159V0;
    }

    public void B1(int i10) {
        this.f12163Z0.t(i10);
        this.f12166c1 = true;
    }

    public void C1(int i10) {
        if (i10 > -1) {
            this.f12159V0 = -1.0f;
            this.f12160W0 = i10;
            this.f12161X0 = -1;
        }
    }

    public void D1(int i10) {
        if (i10 > -1) {
            this.f12159V0 = -1.0f;
            this.f12160W0 = -1;
            this.f12161X0 = i10;
        }
    }

    public void E1(float f10) {
        if (f10 > -1.0f) {
            this.f12159V0 = f10;
            this.f12160W0 = -1;
            this.f12161X0 = -1;
        }
    }

    public void F1(int i10) {
        if (this.f12164a1 == i10) {
            return;
        }
        this.f12164a1 = i10;
        this.f11977Z.clear();
        if (this.f12164a1 == 1) {
            this.f12163Z0 = this.f11964Q;
        } else {
            this.f12163Z0 = this.f11966R;
        }
        this.f11977Z.add(this.f12163Z0);
        int length = this.f11976Y.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f11976Y[i11] = this.f12163Z0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.c cVar, boolean z10) {
        d dVar = (d) M();
        if (dVar == null) {
            return;
        }
        ConstraintAnchor constraintAnchorQ = dVar.q(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorQ2 = dVar.q(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.f11983c0;
        boolean z11 = constraintWidget != null && constraintWidget.f11981b0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.f12164a1 == 0) {
            constraintAnchorQ = dVar.q(ConstraintAnchor.Type.TOP);
            constraintAnchorQ2 = dVar.q(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f11983c0;
            z11 = constraintWidget2 != null && constraintWidget2.f11981b0[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.f12166c1 && this.f12163Z0.n()) {
            SolverVariable solverVariableQ = cVar.q(this.f12163Z0);
            cVar.f(solverVariableQ, this.f12163Z0.e());
            if (this.f12160W0 != -1) {
                if (z11) {
                    cVar.h(cVar.q(constraintAnchorQ2), solverVariableQ, 0, 5);
                }
            } else if (this.f12161X0 != -1 && z11) {
                SolverVariable solverVariableQ2 = cVar.q(constraintAnchorQ2);
                cVar.h(solverVariableQ, cVar.q(constraintAnchorQ), 0, 5);
                cVar.h(solverVariableQ2, solverVariableQ, 0, 5);
            }
            this.f12166c1 = false;
            return;
        }
        if (this.f12160W0 != -1) {
            SolverVariable solverVariableQ3 = cVar.q(this.f12163Z0);
            cVar.e(solverVariableQ3, cVar.q(constraintAnchorQ), this.f12160W0, 8);
            if (z11) {
                cVar.h(cVar.q(constraintAnchorQ2), solverVariableQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.f12161X0 == -1) {
            if (this.f12159V0 != -1.0f) {
                cVar.d(androidx.constraintlayout.core.c.s(cVar, cVar.q(this.f12163Z0), cVar.q(constraintAnchorQ2), this.f12159V0));
                return;
            }
            return;
        }
        SolverVariable solverVariableQ4 = cVar.q(this.f12163Z0);
        SolverVariable solverVariableQ5 = cVar.q(constraintAnchorQ2);
        cVar.e(solverVariableQ4, solverVariableQ5, -this.f12161X0, 8);
        if (z11) {
            cVar.h(solverVariableQ4, cVar.q(constraintAnchorQ), 0, 5);
            cVar.h(solverVariableQ5, solverVariableQ4, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        f fVar = (f) constraintWidget;
        this.f12159V0 = fVar.f12159V0;
        this.f12160W0 = fVar.f12160W0;
        this.f12161X0 = fVar.f12161X0;
        this.f12162Y0 = fVar.f12162Y0;
        F1(fVar.f12164a1);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean p0() {
        return this.f12166c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        int i10 = a.f12167a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.f12164a1 == 1) {
                return this.f12163Z0;
            }
            return null;
        }
        if ((i10 == 3 || i10 == 4) && this.f12164a1 == 0) {
            return this.f12163Z0;
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean q0() {
        return this.f12166c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v1(androidx.constraintlayout.core.c cVar, boolean z10) {
        if (M() == null) {
            return;
        }
        int iY = cVar.y(this.f12163Z0);
        if (this.f12164a1 == 1) {
            r1(iY);
            s1(0);
            Q0(M().z());
            p1(0);
            return;
        }
        r1(0);
        s1(iY);
        p1(M().Y());
        Q0(0);
    }

    public ConstraintAnchor w1() {
        return this.f12163Z0;
    }

    public int x1() {
        return this.f12164a1;
    }

    public int y1() {
        return this.f12160W0;
    }

    public int z1() {
        return this.f12161X0;
    }
}
