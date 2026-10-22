package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a extends wc.a {
    public int X0;
    public boolean Y0;
    public int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f13305a1;

    public a() {
        this.X0 = 0;
        this.Y0 = true;
        this.Z0 = 0;
        this.f13305a1 = false;
    }

    public void A1() {
        int r10 = 0;
    L4:
        if (r10 >= this.W0) goto L21;
        ConstraintWidget r11 = this.V0[r10];
        if (this.Y0 == false) goto L8;
    L10:
        int r12 = this.X0;
        if (r12 == 0) goto L19;
        if (r12 == 1) goto L19;
        if (r12 != 2) goto L17;
    L18:
        r11.U0(1, true);
    L20:
        r10 = r10 + 1;
        goto L4
    L17:
        if (r12 != 3) goto L20;
    L19:
        r11.U0(0, true);
        goto L20
    L8:
        if (r11.e() == true) goto L10;
    }

    public void B1(boolean r10) {
        this.Y0 = r10;
    }

    public void C1(int r10) {
        this.X0 = r10;
    }

    public void D1(int r10) {
        this.Z0 = r10;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void d(LinearSystem r13, boolean r14) {
        ConstraintAnchor[] r15 = this.Y;
        r15[0] = this.Q;
        r15[2] = this.R;
        r15[1] = this.S;
        r15[3] = this.T;
        int r16 = 0;
    L3:
        ConstraintAnchor[] r10 = this.Y;
        if (r16 >= r10.length) goto L6;
        ConstraintAnchor r11 = r10[r16];
        r11.f13248i = r13.q(r11);
        r16 = r16 + 1;
        goto L3
    L6:
        int r17 = this.X0;
        if (r17 >= 0) goto L9;
        return;
    L9:
        if (r17 >= 4) goto L129;
        ConstraintAnchor r18 = r10[r17];
        if (this.f13305a1 == true) goto L14;
        v1();
    L14:
        if (this.f13305a1 == false) goto L24;
        this.f13305a1 = false;
        int r19 = this.X0;
        if (r19 == 0) goto L22;
        if (r19 == 1) goto L22;
        if (r19 == 2) goto L21;
        if (r19 == 3) goto L21;
        return;
    L21:
        r13.f(this.R.f13248i, this.f13268i0);
        r13.f(this.T.f13248i, this.f13268i0);
        return;
    L22:
        r13.f(this.Q.f13248i, this.f13266h0);
        r13.f(this.S.f13248i, this.f13266h0);
        return;
    L24:
        int r12 = 0;
    L26:
        if (r12 >= this.W0) goto L53;
        ConstraintWidget r20 = this.V0[r12];
        if (this.Y0 == false) goto L30;
    L32:
        int r21 = this.X0;
        if (r21 == 0) goto L36;
        if (r21 == 1) goto L36;
    L42:
        int r22 = this.X0;
        if (r22 == 2) goto L46;
        if (r22 == 3) goto L46;
    L52:
        r12 = r12 + 1;
    L46:
        if (r20.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L52;
        if (r20.R.f13245f == null) goto L52;
        if (r20.T.f13245f == null) goto L52;
    L41:
        boolean r23 = true;
    L55:
        if (this.Q.l() == false) goto L57;
    L60:
        boolean r24 = true;
    L62:
        if (this.R.l() == false) goto L64;
    L67:
        boolean r25 = true;
    L68:
        if (r23 == true) goto L79;
        int r26 = this.X0;
        if (r26 != 0) goto L72;
        if (r24 == false) goto L72;
    L78:
        boolean r27 = true;
    L80:
        if (r27 == true) goto L82;
        int r28 = 4;
    L83:
        int r29 = 0;
    L85:
        if (r29 >= this.W0) goto L104;
        ConstraintWidget r30 = this.V0[r29];
        if (this.Y0 == false) goto L89;
    L91:
        SolverVariable r31 = r13.q(r30.Y[this.X0]);
        ConstraintAnchor[] r32 = r30.Y;
        int r110 = this.X0;
        ConstraintAnchor r33 = r32[r110];
        r33.f13248i = r31;
        ConstraintAnchor r111 = r33.f13245f;
        if (r111 != null) goto L94;
    L96:
        int r34 = 0;
    L97:
        if (r110 == 0) goto L101;
        if (r110 == 2) goto L101;
        r13.g(r18.f13248i, r31, this.Z0 + r34, r23);
    L102:
        r13.e(r18.f13248i, r31, this.Z0 + r34, r28);
    L103:
        r29 = r29 + 1;
    L101:
        r13.i(r18.f13248i, r31, this.Z0 - r34, r23);
        goto L102
    L94:
        if (r111.f13243d != this) goto L96;
        r34 = r33.f13246g;
        goto L97
    L89:
        if (r30.e() == true) goto L91;
    L104:
        int r112 = this.X0;
        if (r112 != 0) goto L107;
        r13.e(this.S.f13248i, this.Q.f13248i, 0, 8);
        r13.e(this.Q.f13248i, this.f13256c0.S.f13248i, 0, 4);
        r13.e(this.Q.f13248i, this.f13256c0.Q.f13248i, 0, 0);
        return;
    L107:
        if (r112 != 1) goto L109;
        r13.e(this.Q.f13248i, this.S.f13248i, 0, 8);
        r13.e(this.Q.f13248i, this.f13256c0.Q.f13248i, 0, 4);
        r13.e(this.Q.f13248i, this.f13256c0.S.f13248i, 0, 0);
        return;
    L109:
        if (r112 != 2) goto L111;
        r13.e(this.T.f13248i, this.R.f13248i, 0, 8);
        r13.e(this.R.f13248i, this.f13256c0.T.f13248i, 0, 4);
        r13.e(this.R.f13248i, this.f13256c0.R.f13248i, 0, 0);
        return;
    L111:
        if (r112 != 3) goto L133;
        r13.e(this.R.f13248i, this.T.f13248i, 0, 8);
        r13.e(this.R.f13248i, this.f13256c0.R.f13248i, 0, 4);
        r13.e(this.R.f13248i, this.f13256c0.T.f13248i, 0, 0);
        return;
    L133:
        return;
    L82:
        r28 = 5;
    L72:
        if (r26 != 2) goto L74;
        if (r25 == true) goto L78;
    L74:
        if (r26 != 1) goto L76;
        if (r24 == true) goto L78;
    L76:
        if (r26 != 3) goto L79;
        if (r25 == true) goto L78;
    L79:
        r27 = false;
        goto L80
    L64:
        if (this.T.l() == true) goto L67;
        r25 = false;
        goto L68
    L57:
        if (this.S.l() == true) goto L60;
        r24 = false;
    L36:
        if (r20.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L42;
        if (r20.Q.f13245f == null) goto L42;
        if (r20.S.f13245f == null) goto L42;
    L30:
        if (r20.e() == true) goto L32;
    L53:
        r23 = false;
        goto L55
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean e() {
        return true;
    }

    @Override // wc.a, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void k(ConstraintWidget r10, HashMap r11) {
        super.k(r10, r11);
        a r12 = (a) r10;
        this.X0 = r12.X0;
        this.Y0 = r12.Y0;
        this.Z0 = r12.Z0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean m0() {
        return this.f13305a1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean n0() {
        return this.f13305a1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String r10 = "[Barrier] " + s() + " {";
        int r11 = 0;
    L4:
        if (r11 >= this.W0) goto L10;
        ConstraintWidget r12 = this.V0[r11];
        if (r11 <= 0) goto L8;
        r10 = r10 + ", ";
    L8:
        r10 = r10 + r12.s();
        r11 = r11 + 1;
        goto L4
    L10:
        return r10 + "}";
    }

    public boolean v1() {
        int r10 = 0;
        boolean r11 = true;
        int r12 = 0;
    L3:
        int r13 = this.W0;
        if (r12 >= r13) goto L23;
        ConstraintWidget r14 = this.V0[r12];
        if (this.Y0 == false) goto L8;
    L10:
        int r15 = this.X0;
        if (r15 == 0) goto L14;
        if (r15 == 1) goto L14;
    L16:
        int r16 = this.X0;
        if (r16 == 2) goto L20;
        if (r16 == 3) goto L20;
    L22:
        r12 = r12 + 1;
    L20:
        if (r14.n0() == true) goto L22;
    L15:
        r11 = false;
    L14:
        if (r14.m0() == true) goto L16;
    L8:
        if (r14.e() == true) goto L10;
    L23:
        if (r11 == false) goto L62;
        if (r13 <= 0) goto L62;
        int r17 = 0;
        boolean r18 = false;
    L27:
        if (r10 >= this.W0) goto L54;
        ConstraintWidget r19 = this.V0[r10];
        if (this.Y0 == false) goto L31;
    L33:
        if (r18 == true) goto L44;
        int r20 = this.X0;
        if (r20 != 0) goto L37;
        r17 = r19.n(ConstraintAnchor.Type.LEFT).e();
    L43:
        r18 = true;
        goto L44
    L37:
        if (r20 != 1) goto L39;
        r17 = r19.n(ConstraintAnchor.Type.RIGHT).e();
        goto L43
    L39:
        if (r20 != 2) goto L41;
        r17 = r19.n(ConstraintAnchor.Type.TOP).e();
        goto L43
    L41:
        if (r20 != 3) goto L43;
        r17 = r19.n(ConstraintAnchor.Type.BOTTOM).e();
    L44:
        int r21 = this.X0;
        if (r21 != 0) goto L47;
        r17 = Math.min(r17, r19.n(ConstraintAnchor.Type.LEFT).e());
    L53:
        r10 = r10 + 1;
        goto L27
    L47:
        if (r21 != 1) goto L49;
        r17 = Math.max(r17, r19.n(ConstraintAnchor.Type.RIGHT).e());
        goto L53
    L49:
        if (r21 != 2) goto L51;
        r17 = Math.min(r17, r19.n(ConstraintAnchor.Type.TOP).e());
        goto L53
    L51:
        if (r21 != 3) goto L53;
        r17 = Math.max(r17, r19.n(ConstraintAnchor.Type.BOTTOM).e());
        goto L53
    L31:
        if (r19.e() == true) goto L33;
    L54:
        int r22 = r17 + this.Z0;
        int r23 = this.X0;
        if (r23 == 0) goto L59;
        if (r23 == 1) goto L59;
        K0(r22, r22);
    L60:
        this.f13305a1 = true;
        return true;
    L59:
        H0(r22, r22);
    L62:
        return false;
    }

    public boolean w1() {
        return this.Y0;
    }

    public int x1() {
        return this.X0;
    }

    public int y1() {
        return this.Z0;
    }

    public int z1() {
        int r10 = this.X0;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        if (r10 != 1) goto L7;
        return 0;
    L7:
        if (r10 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r10 == 3) goto L12;
        return -1;
    }
}
