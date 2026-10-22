package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends k.a {
    public int X0;
    public int Y0;
    public int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f1656a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f1657b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f1658c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f1659d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f1660e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public boolean f1661f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f1662g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f1663h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public BasicMeasure.a f1664i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public BasicMeasure.Measurer f1665j1;

    public h() {
        this.X0 = 0;
        this.Y0 = 0;
        this.Z0 = 0;
        this.f1656a1 = 0;
        this.f1657b1 = 0;
        this.f1658c1 = 0;
        this.f1659d1 = 0;
        this.f1660e1 = 0;
        this.f1661f1 = false;
        this.f1662g1 = 0;
        this.f1663h1 = 0;
        this.f1664i1 = new BasicMeasure.a();
        this.f1665j1 = null;
    }

    public int A1() {
        return this.f1659d1;
    }

    public int B1() {
        return this.f1660e1;
    }

    public int C1() {
        return this.X0;
    }

    public abstract void D1(int r10, int r11, int r12, int r13);

    public void E1(ConstraintWidget r10, ConstraintWidget.DimensionBehaviour r11, int r12, ConstraintWidget.DimensionBehaviour r13, int r14) {
    L3:
        if (this.f1665j1 != null) goto L7;
        if (J() == null) goto L7;
        this.f1665j1 = ((ConstraintWidgetContainer) J()).K1();
    L7:
        BasicMeasure.a r15 = this.f1664i1;
        r15.f1519a = r11;
        r15.f1520b = r13;
        r15.f1521c = r12;
        r15.f1522d = r14;
        this.f1665j1.measure(r10, r15);
        r10.l1(this.f1664i1.f1523e);
        r10.M0(this.f1664i1.f1524f);
        r10.L0(this.f1664i1.f1526h);
        r10.B0(this.f1664i1.f1525g);
    }

    public boolean F1() {
        ConstraintWidget r10 = this.f1437c0;
        if (r10 == null) goto L5;
        BasicMeasure.Measurer r11 = ((ConstraintWidgetContainer) r10).K1();
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.W0) goto L32;
        ConstraintWidget r13 = this.V0[r12];
        if (r13 == null) goto L31;
        if ((r13 instanceof e) == true) goto L31;
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
        BasicMeasure.a r17 = this.f1664i1;
        r17.f1519a = r14;
        r17.f1520b = r15;
        r17.f1521c = r13.V();
        this.f1664i1.f1522d = r13.w();
        r11.measure(r13, this.f1664i1);
        r13.l1(this.f1664i1.f1523e);
        r13.M0(this.f1664i1.f1524f);
        r13.B0(this.f1664i1.f1525g);
        goto L31
    L21:
        if (r13.f1476w == 1) goto L26;
        if (r15 != r16) goto L26;
        if (r13.f1478x == 1) goto L26;
    L31:
        r12 = r12 + 1;
        goto L11
    L32:
        return true;
    L5:
        r11 = null;
        goto L7
    }

    public boolean G1() {
        return this.f1661f1;
    }

    public void H1(boolean r10) {
        this.f1661f1 = r10;
    }

    public void I1(int r10, int r11) {
        this.f1662g1 = r10;
        this.f1663h1 = r11;
    }

    public void J1(int r10) {
        this.Z0 = r10;
        this.X0 = r10;
        this.f1656a1 = r10;
        this.Y0 = r10;
        this.f1657b1 = r10;
        this.f1658c1 = r10;
    }

    public void K1(int r10) {
        this.Y0 = r10;
    }

    public void L1(int r10) {
        this.f1658c1 = r10;
    }

    public void M1(int r10) {
        this.Z0 = r10;
        this.f1659d1 = r10;
    }

    public void N1(int r10) {
        this.f1656a1 = r10;
        this.f1660e1 = r10;
    }

    public void O1(int r10) {
        this.f1657b1 = r10;
        this.f1659d1 = r10;
        this.f1660e1 = r10;
    }

    public void P1(int r10) {
        this.X0 = r10;
    }

    public void u1(boolean r10) {
        int r11 = this.f1657b1;
        if (r11 <= 0) goto L5;
    L6:
        if (r10 == false) goto L8;
        this.f1659d1 = this.f1658c1;
        this.f1660e1 = r11;
        return;
    L8:
        this.f1659d1 = r11;
        this.f1660e1 = this.f1658c1;
        return;
    L5:
        if (this.f1658c1 > 0) goto L6;
    }

    @Override // k.a, androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r10) {
        v1();
    }

    public void v1() {
        int r10 = 0;
    L4:
        if (r10 >= this.W0) goto L9;
        ConstraintWidget r11 = this.V0[r10];
        if (r11 == null) goto L8;
        r11.V0(true);
    L8:
        r10 = r10 + 1;
        goto L4
    }

    public boolean w1(HashSet r10) {
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

    public int x1() {
        return this.f1663h1;
    }

    public int y1() {
        return this.f1662g1;
    }

    public int z1() {
        return this.Y0;
    }
}
