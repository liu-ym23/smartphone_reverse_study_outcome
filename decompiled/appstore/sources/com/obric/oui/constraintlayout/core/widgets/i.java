package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i extends wc.a {
    public int X0;
    public int Y0;
    public int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f13474a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f13475b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f13476c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f13477d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f13478e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public boolean f13479f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f13480g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f13481h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public BasicMeasure.a f13482i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public BasicMeasure.Measurer f13483j1;

    public i() {
        this.X0 = 0;
        this.Y0 = 0;
        this.Z0 = 0;
        this.f13474a1 = 0;
        this.f13475b1 = 0;
        this.f13476c1 = 0;
        this.f13477d1 = 0;
        this.f13478e1 = 0;
        this.f13479f1 = false;
        this.f13480g1 = 0;
        this.f13481h1 = 0;
        this.f13482i1 = new BasicMeasure.a();
        this.f13483j1 = null;
    }

    public int A1() {
        return this.Y0;
    }

    public int B1() {
        return this.f13477d1;
    }

    public int C1() {
        return this.f13478e1;
    }

    public int D1() {
        return this.X0;
    }

    public abstract void E1(int r10, int r11, int r12, int r13);

    public void F1(ConstraintWidget r10, ConstraintWidget.DimensionBehaviour r11, int r12, ConstraintWidget.DimensionBehaviour r13, int r14) {
    L3:
        if (this.f13483j1 != null) goto L7;
        if (J() == null) goto L7;
        this.f13483j1 = ((d) J()).L1();
    L7:
        BasicMeasure.a r15 = this.f13482i1;
        r15.f13312a = r11;
        r15.f13313b = r13;
        r15.f13314c = r12;
        r15.f13315d = r14;
        this.f13483j1.measure(r10, r15);
        r10.m1(this.f13482i1.f13316e);
        r10.N0(this.f13482i1.f13317f);
        r10.M0(this.f13482i1.f13319h);
        r10.C0(this.f13482i1.f13318g);
    }

    public boolean G1() {
        ConstraintWidget r10 = this.f13256c0;
        if (r10 == null) goto L5;
        BasicMeasure.Measurer r11 = ((d) r10).L1();
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.W0) goto L32;
        ConstraintWidget r13 = this.V0[r12];
        if (r13 == null) goto L31;
        if ((r13 instanceof f) == true) goto L31;
        ConstraintWidget.DimensionBehaviour r14 = r13.t(0);
        ConstraintWidget.DimensionBehaviour r15 = r13.t(1);
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 == r16) goto L21;
    L26:
        if (r14 != r16) goto L28;
        r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L28:
        if (r15 != r16) goto L30;
        r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L30:
        BasicMeasure.a r17 = this.f13482i1;
        r17.f13312a = r14;
        r17.f13313b = r15;
        r17.f13314c = r13.V();
        this.f13482i1.f13315d = r13.w();
        r11.measure(r13, this.f13482i1);
        r13.m1(this.f13482i1.f13316e);
        r13.N0(this.f13482i1.f13317f);
        r13.C0(this.f13482i1.f13318g);
        goto L31
    L21:
        if (r13.f13295w == 1) goto L26;
        if (r15 != r16) goto L26;
        if (r13.f13297x == 1) goto L26;
    L31:
        r12 = r12 + 1;
        goto L11
    L32:
        return true;
    L5:
        r11 = null;
        goto L7
    }

    public boolean H1() {
        return this.f13479f1;
    }

    public void I1(boolean r10) {
        this.f13479f1 = r10;
    }

    public void J1(int r10, int r11) {
        this.f13480g1 = r10;
        this.f13481h1 = r11;
    }

    public void K1(int r10) {
        this.Z0 = r10;
        this.X0 = r10;
        this.f13474a1 = r10;
        this.Y0 = r10;
        this.f13475b1 = r10;
        this.f13476c1 = r10;
    }

    public void L1(int r10) {
        this.Y0 = r10;
    }

    public void M1(int r10) {
        this.f13476c1 = r10;
    }

    public void N1(int r10) {
        this.Z0 = r10;
        this.f13477d1 = r10;
    }

    public void O1(int r10) {
        this.f13474a1 = r10;
        this.f13478e1 = r10;
    }

    public void P1(int r10) {
        this.f13475b1 = r10;
        this.f13477d1 = r10;
        this.f13478e1 = r10;
    }

    public void Q1(int r10) {
        this.X0 = r10;
    }

    @Override // wc.a, com.obric.oui.constraintlayout.core.widgets.Helper
    public void updateConstraints(d r10) {
        w1();
    }

    public void v1(boolean r10) {
        int r11 = this.f13475b1;
        if (r11 <= 0) goto L5;
    L6:
        if (r10 == false) goto L8;
        this.f13477d1 = this.f13476c1;
        this.f13478e1 = r11;
        return;
    L8:
        this.f13477d1 = r11;
        this.f13478e1 = this.f13476c1;
        return;
    L5:
        if (this.f13476c1 > 0) goto L6;
    }

    public void w1() {
        int r10 = 0;
    L4:
        if (r10 >= this.W0) goto L9;
        ConstraintWidget r11 = this.V0[r10];
        if (r11 == null) goto L8;
        r11.W0(true);
    L8:
        r10 = r10 + 1;
        goto L4
    }

    public boolean x1(HashSet r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.W0) goto L10;
        if (r10.contains(this.V0[r11]) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public int y1() {
        return this.f13481h1;
    }

    public int z1() {
        return this.f13480g1;
    }
}
