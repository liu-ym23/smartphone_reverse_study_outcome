package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class e extends ConstraintWidget {
    public float V0;
    public int W0;
    public int X0;
    public boolean Y0;
    public ConstraintAnchor Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f1651a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f1652b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public boolean f1653c1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1654a = null;

        static {
            int[] r10 = new int[ConstraintAnchor.Type.values().length];
            f1654a = r10;
            r10[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f1654a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f1654a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f1654a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f1654a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f1654a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f1654a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f1654a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f1654a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public e() {
        this.V0 = -1.0f;
        this.W0 = -1;
        this.X0 = -1;
        this.Y0 = true;
        this.Z0 = this.R;
        int r10 = 0;
        this.f1651a1 = 0;
        this.f1652b1 = 0;
        this.Z.clear();
        this.Z.add(this.Z0);
        int r11 = this.Y.length;
    L3:
        if (r10 >= r11) goto L5;
        this.Y[r10] = this.Z0;
        r10 = r10 + 1;
        goto L3
    }

    public void A1(float r10) {
        if (r10 <= (-1.0f)) goto L6;
        this.V0 = r10;
        this.W0 = -1;
        this.X0 = -1;
        return;
    }

    public void B1(int r10) {
        if (this.f1651a1 != r10) goto L5;
        return;
    L5:
        this.f1651a1 = r10;
        this.Z.clear();
        if (this.f1651a1 != 1) goto L8;
        this.Z0 = this.Q;
    L9:
        this.Z.add(this.Z0);
        int r11 = this.Y.length;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L12;
        this.Y[r12] = this.Z0;
        r12 = r12 + 1;
        goto L10
    L12:
        return;
    L8:
        this.Z0 = this.R;
        goto L9
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void d(LinearSystem r10, boolean r11) {
        ConstraintWidgetContainer r12 = (ConstraintWidgetContainer) J();
        if (r12 != null) goto L5;
        return;
    L5:
        ConstraintAnchor r13 = r12.n(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r14 = r12.n(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget r15 = this.f1437c0;
        boolean r16 = true;
        if (r15 != null) goto L8;
    L10:
        boolean r17 = false;
    L12:
        if (this.f1651a1 != 0) goto L21;
        r13 = r12.n(ConstraintAnchor.Type.TOP);
        r14 = r12.n(ConstraintAnchor.Type.BOTTOM);
        ConstraintWidget r18 = this.f1437c0;
        if (r18 != null) goto L16;
    L18:
        r16 = false;
    L19:
        r17 = r16;
        goto L21
    L16:
        if (r18.f1435b0[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.f1653c1 == false) goto L35;
        if (this.Z0.n() == false) goto L35;
        SolverVariable r19 = r10.q(this.Z0);
        r10.f(r19, this.Z0.e());
        if (this.W0 == (-1)) goto L29;
        if (r17 == false) goto L32;
        r10.h(r10.q(r14), r19, 0, 5);
    L32:
        this.f1653c1 = false;
        return;
    L29:
        if (this.X0 == (-1)) goto L32;
        if (r17 == false) goto L32;
        SolverVariable r20 = r10.q(r14);
        r10.h(r19, r10.q(r13), 0, 5);
        r10.h(r20, r19, 0, 5);
    L35:
        if (this.W0 == (-1)) goto L40;
        SolverVariable r21 = r10.q(this.Z0);
        r10.e(r21, r10.q(r13), this.W0, 8);
        if (r17 == false) goto L48;
        r10.h(r10.q(r14), r21, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.X0 == (-1)) goto L45;
        SolverVariable r22 = r10.q(this.Z0);
        SolverVariable r23 = r10.q(r14);
        r10.e(r22, r23, -this.X0, 8);
        if (r17 == false) goto L50;
        r10.h(r22, r10.q(r13), 0, 5);
        r10.h(r23, r22, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.V0 == (-1.0f)) goto L52;
        r10.d(LinearSystem.s(r10, r10.q(this.Z0), r10.q(r14), this.V0));
        return;
    L52:
        return;
    L8:
        if (r15.f1435b0[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r17 = true;
        goto L12
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean e() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void k(ConstraintWidget r10, HashMap r11) {
        super.k(r10, r11);
        e r12 = (e) r10;
        this.V0 = r12.V0;
        this.W0 = r12.W0;
        this.X0 = r12.X0;
        this.Y0 = r12.Y0;
        B1(r12.f1651a1);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean m0() {
        return this.f1653c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor n(ConstraintAnchor.Type r10) {
        int r11 = a.f1654a[r10.ordinal()];
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L16;
        if (r11 == 3) goto L12;
        if (r11 == 4) goto L12;
        return null;
    L12:
        if (this.f1651a1 == 0) goto L14;
        return null;
    L14:
        return this.Z0;
    L16:
        if (this.f1651a1 == 1) goto L18;
        return null;
    L18:
        return this.Z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean n0() {
        return this.f1653c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void r1(LinearSystem r10, boolean r11) {
        if (J() != null) goto L5;
        return;
    L5:
        int r12 = r10.y(this.Z0);
        if (this.f1651a1 != 1) goto L8;
        n1(r12);
        o1(0);
        M0(J().w());
        l1(0);
        return;
    L8:
        n1(0);
        o1(r12);
        l1(J().V());
        M0(0);
    }

    public ConstraintAnchor s1() {
        return this.Z0;
    }

    public int t1() {
        return this.f1651a1;
    }

    public int u1() {
        return this.W0;
    }

    public int v1() {
        return this.X0;
    }

    public float w1() {
        return this.V0;
    }

    public void x1(int r10) {
        this.Z0.t(r10);
        this.f1653c1 = true;
    }

    public void y1(int r10) {
        if (r10 <= (-1)) goto L6;
        this.V0 = -1.0f;
        this.W0 = r10;
        this.X0 = -1;
        return;
    }

    public void z1(int r10) {
        if (r10 <= (-1)) goto L6;
        this.V0 = -1.0f;
        this.W0 = -1;
        this.X0 = r10;
        return;
    }
}
