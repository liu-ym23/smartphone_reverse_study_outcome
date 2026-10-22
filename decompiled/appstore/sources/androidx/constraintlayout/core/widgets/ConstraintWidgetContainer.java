package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidgetContainer extends k.b {
    public BasicMeasure.a A1;
    public BasicMeasure W0;
    public androidx.constraintlayout.core.widgets.analyzer.c X0;
    public int Y0;
    public BasicMeasure.Measurer Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f1486a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public Metrics f1487b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public LinearSystem f1488c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f1489d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f1490e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public int f1491f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f1492g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f1493h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public int f1494i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public c[] f1495j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public c[] f1496k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f1497l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f1498m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public boolean f1499n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f1500o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f1501p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public int f1502q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public boolean f1503r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public boolean f1504s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public boolean f1505t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public int f1506u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public WeakReference f1507v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public WeakReference f1508w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public WeakReference f1509x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public WeakReference f1510y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public HashSet f1511z1;

    static {
    }

    public ConstraintWidgetContainer() {
        this.W0 = new BasicMeasure(this);
        this.X0 = new androidx.constraintlayout.core.widgets.analyzer.c(this);
        this.Z0 = null;
        this.f1486a1 = false;
        this.f1488c1 = new LinearSystem();
        this.f1493h1 = 0;
        this.f1494i1 = 0;
        this.f1495j1 = new c[4];
        this.f1496k1 = new c[4];
        this.f1497l1 = false;
        this.f1498m1 = false;
        this.f1499n1 = false;
        this.f1500o1 = 0;
        this.f1501p1 = 0;
        this.f1502q1 = 257;
        this.f1503r1 = false;
        this.f1504s1 = false;
        this.f1505t1 = false;
        this.f1506u1 = 0;
        this.f1507v1 = null;
        this.f1508w1 = null;
        this.f1509x1 = null;
        this.f1510y1 = null;
        this.f1511z1 = new HashSet();
        this.A1 = new BasicMeasure.a();
    }

    public static boolean U1(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, BasicMeasure.a r13, int r14) {
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r11.U() != 8) goto L8;
    L87:
        r13.f1523e = 0;
        r13.f1524f = 0;
        return false;
    L8:
        if ((r11 instanceof e) == true) goto L87;
        if ((r11 instanceof a) == true) goto L87;
        r13.f1519a = r11.z();
        r13.f1520b = r11.S();
        r13.f1521c = r11.V();
        r13.f1522d = r11.w();
        r13.f1527i = false;
        r13.f1528j = r14;
        ConstraintWidget.DimensionBehaviour r15 = r13.f1519a;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r15 != r16) goto L15;
        boolean r17 = true;
    L17:
        if (r13.f1520b != r16) goto L19;
        boolean r18 = true;
    L21:
        if (r17 == true) goto L23;
    L25:
        boolean r19 = false;
    L26:
        if (r18 == true) goto L28;
    L30:
        boolean r20 = false;
    L31:
        if (r17 == true) goto L33;
    L43:
        if (r18 == false) goto L56;
        if (r11.Z(1) == false) goto L56;
        if (r11.f1478x != 0) goto L56;
        if (r20 == true) goto L56;
        r13.f1520b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r17 == true) goto L52;
    L54:
        r18 = false;
        goto L56
    L52:
        if (r11.f1476w != 0) goto L54;
        r13.f1520b = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r11.m0() == false) goto L59;
        r13.f1519a = ConstraintWidget.DimensionBehaviour.FIXED;
        r17 = false;
    L59:
        if (r11.n0() == false) goto L62;
        r13.f1520b = ConstraintWidget.DimensionBehaviour.FIXED;
        r18 = false;
    L62:
        if (r19 == true) goto L64;
    L72:
        if (r20 == true) goto L74;
    L85:
        r12.measure(r11, r13);
        r11.l1(r13.f1523e);
        r11.M0(r13.f1524f);
        r11.L0(r13.f1526h);
        r11.B0(r13.f1525g);
        r13.f1528j = BasicMeasure.a.f1516k;
        return r13.f1527i;
    L74:
        if (r11.f1480y[1] != 4) goto L76;
        r13.f1520b = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L85
    L76:
        if (r17 == true) goto L85;
        ConstraintWidget.DimensionBehaviour r21 = r13.f1519a;
        ConstraintWidget.DimensionBehaviour r22 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r21 != r22) goto L80;
        int r23 = r13.f1521c;
    L81:
        r13.f1520b = r22;
        if (r11.v() != (-1)) goto L84;
        r13.f1522d = (int) (r23 / r11.u());
        goto L85
    L84:
        r13.f1522d = (int) (r11.u() * r23);
        goto L85
    L80:
        r13.f1520b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r12.measure(r11, r13);
        r23 = r13.f1523e;
        goto L81
    L64:
        if (r11.f1480y[0] != 4) goto L66;
        r13.f1519a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r18 == true) goto L72;
        ConstraintWidget.DimensionBehaviour r24 = r13.f1520b;
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r24 != r25) goto L70;
        int r26 = r13.f1522d;
    L71:
        r13.f1519a = r25;
        r13.f1521c = (int) (r11.u() * r26);
        goto L72
    L70:
        r13.f1519a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r12.measure(r11, r13);
        r26 = r13.f1524f;
        goto L71
    L33:
        if (r11.Z(0) == false) goto L43;
        if (r11.f1476w != 0) goto L43;
        if (r19 == true) goto L43;
        r13.f1519a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 == true) goto L40;
    L42:
        r17 = false;
        goto L43
    L40:
        if (r11.f1478x != 0) goto L42;
        r13.f1519a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r11.f1443f0 <= 0.0f) goto L30;
        r20 = true;
        goto L31
    L23:
        if (r11.f1443f0 <= 0.0f) goto L25;
        r19 = true;
        goto L26
    L19:
        r18 = false;
        goto L21
    L15:
        r17 = false;
        goto L17
    }

    public void A1(ConstraintAnchor r10) {
        WeakReference r11 = this.f1508w1;
        if (r11 != null) goto L5;
    L8:
        this.f1508w1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f1508w1.get()).e()) goto L8;
    }

    public final void B1(ConstraintAnchor r10, SolverVariable r11) {
        SolverVariable r12 = this.f1488c1.q(r10);
        this.f1488c1.h(r11, r12, 0, 5);
    }

    public final void C1(ConstraintAnchor r10, SolverVariable r11) {
        SolverVariable r12 = this.f1488c1.q(r10);
        this.f1488c1.h(r12, r11, 0, 5);
    }

    public final void D1(ConstraintWidget r10) {
        int r11 = this.f1494i1 + 1;
        c[] r12 = this.f1495j1;
        if (r11 < r12.length) goto L5;
        this.f1495j1 = (c[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        this.f1495j1[this.f1494i1] = new c(r10, 1, R1());
        this.f1494i1++;
    }

    public void E1(ConstraintAnchor r10) {
        WeakReference r11 = this.f1509x1;
        if (r11 != null) goto L5;
    L8:
        this.f1509x1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f1509x1.get()).e()) goto L8;
    }

    public void F1(ConstraintAnchor r10) {
        WeakReference r11 = this.f1507v1;
        if (r11 != null) goto L5;
    L8:
        this.f1507v1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f1507v1.get()).e()) goto L8;
    }

    public boolean G1(boolean r10) {
        return this.X0.f(r10);
    }

    public boolean H1(boolean r10) {
        return this.X0.g(r10);
    }

    public boolean I1(boolean r10, int r11) {
        return this.X0.h(r10, r11);
    }

    public void J1(Metrics r10) {
        this.f1487b1 = r10;
        this.f1488c1.v(r10);
    }

    public BasicMeasure.Measurer K1() {
        return this.Z0;
    }

    public int L1() {
        return this.f1502q1;
    }

    public LinearSystem M1() {
        return this.f1488c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void N(StringBuilder r10) {
        r10.append(this.f1460o + ":{\n");
        r10.append("  actualWidth:" + this.f1439d0);
        r10.append("\n");
        r10.append("  actualHeight:" + this.f1441e0);
        r10.append("\n");
        Iterator r11 = s1().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((ConstraintWidget) r11.next()).N(r10);
        r10.append(",\n");
        goto L4
    L6:
        r10.append("}");
    }

    public boolean N1() {
        return false;
    }

    public void O1() {
        this.X0.j();
    }

    public void P1() {
        this.X0.k();
    }

    public boolean Q1() {
        return this.f1505t1;
    }

    public boolean R1() {
        return this.f1486a1;
    }

    public boolean S1() {
        return this.f1504s1;
    }

    public long T1(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.f1489d1 = r19;
        this.f1490e1 = r20;
        return this.W0.d(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public boolean V1(int r10) {
        if ((this.f1502q1 & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public final void W1() {
        this.f1493h1 = 0;
        this.f1494i1 = 0;
    }

    public void X1(BasicMeasure.Measurer r10) {
        this.Z0 = r10;
        this.X0.n(r10);
    }

    public void Y1(int r10) {
        this.f1502q1 = r10;
        LinearSystem.f1259r = V1(512);
    }

    public void Z1(int r10) {
        this.Y0 = r10;
    }

    public void a2(boolean r10) {
        this.f1486a1 = r10;
    }

    public boolean b2(LinearSystem r10, boolean[] r11) {
        int r12 = 0;
        r11[2] = false;
        boolean r13 = V1(64);
        r1(r10, r13);
        int r14 = this.V0.size();
        boolean r15 = false;
    L3:
        if (r12 >= r14) goto L8;
        ConstraintWidget r16 = (ConstraintWidget) this.V0.get(r12);
        r16.r1(r10, r13);
        if (r16.b0() == false) goto L7;
        r15 = true;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r15;
    }

    public void c2() {
        this.W0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void q1(boolean r10, boolean r11) {
        super.q1(r10, r11);
        int r12 = this.V0.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((ConstraintWidget) this.V0.get(r13)).q1(r10, r11);
        r13 = r13 + 1;
        goto L3
    }

    @Override // k.b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void s0() {
        this.f1488c1.E();
        this.f1489d1 = 0;
        this.f1491f1 = 0;
        this.f1490e1 = 0;
        this.f1492g1 = 0;
        this.f1503r1 = false;
        super.s0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // k.b
    public void t1() {
        int r10 = 0;
        this.f1447h0 = 0;
        this.f1449i0 = 0;
        this.f1504s1 = false;
        this.f1505t1 = false;
        int r11 = this.V0.size();
        int r12 = Math.max(0, V());
        int r13 = Math.max(0, w());
        ConstraintWidget.DimensionBehaviour[] r14 = this.f1435b0;
        ConstraintWidget.DimensionBehaviour r15 = r14[1];
        ConstraintWidget.DimensionBehaviour r16 = r14[0];
        Metrics r17 = this.f1487b1;
        if (r17 == null) goto L6;
        r17.D++;
    L6:
        if (this.Y0 != 0) goto L32;
        if (f.b(this.f1502q1, 1) == false) goto L32;
        androidx.constraintlayout.core.widgets.analyzer.e.h(this, K1());
        int r18 = 0;
    L10:
        if (r18 >= r11) goto L32;
        ConstraintWidget r19 = (ConstraintWidget) this.V0.get(r18);
        if (r19.l0() == false) goto L30;
        if ((r19 instanceof e) == true) goto L30;
        if ((r19 instanceof a) == true) goto L30;
        if ((r19 instanceof h) == true) goto L30;
        if (r19.k0() == true) goto L30;
        ConstraintWidget.DimensionBehaviour r110 = r19.t(0);
        ConstraintWidget.DimensionBehaviour r111 = r19.t(1);
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 == r112) goto L24;
    L29:
        U1(0, r19, this.Z0, new BasicMeasure.a(), BasicMeasure.a.f1516k);
        goto L30
    L24:
        if (r19.f1476w == 1) goto L29;
        if (r111 != r112) goto L29;
        if (r19.f1478x == 1) goto L29;
    L30:
        r18 = r18 + 1;
    L32:
        if (r11 <= 2) goto L53;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r16 == r20) goto L37;
        if (r15 != r20) goto L53;
    L37:
        if (f.b(this.f1502q1, 1024) == false) goto L53;
        if (androidx.constraintlayout.core.widgets.analyzer.f.c(this, K1()) == false) goto L53;
        if (r16 == r20) goto L42;
    L46:
        if (r15 == r20) goto L48;
    L52:
        int r21 = r13;
        int r22 = r12;
        boolean r23 = true;
    L55:
        if (V1(64) == false) goto L57;
    L60:
        boolean r113 = true;
    L61:
        LinearSystem r114 = this.f1488c1;
        r114.f1275h = false;
        r114.f1276i = false;
        if (this.f1502q1 == 0) goto L65;
        if (r113 == false) goto L65;
        r114.f1276i = true;
    L65:
        ArrayList r115 = this.V0;
        ConstraintWidget.DimensionBehaviour r116 = z();
        ConstraintWidget.DimensionBehaviour r117 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r116 != r117) goto L68;
    L71:
        boolean r118 = true;
    L72:
        W1();
        int r119 = 0;
    L73:
        if (r119 >= r11) goto L78;
        ConstraintWidget r120 = (ConstraintWidget) this.V0.get(r119);
        if ((r120 instanceof k.b) == false) goto L77;
        ((k.b) r120).t1();
    L77:
        r119 = r119 + 1;
        goto L73
    L78:
        boolean r121 = V1(64);
        ?? r122 = r23;
        int r24 = 0;
        boolean r123 = true;
    L79:
        if (r123 == false) goto L159;
        int r124 = r24 + 1;
        this.f1488c1.E();     // Catch: Exception -> L84
        W1();     // Catch: Exception -> L84
        l(this.f1488c1);     // Catch: Exception -> L84
        int r25 = r10;
    L82:
        if (r25 >= r11) goto L86;
        ((ConstraintWidget) this.V0.get(r25)).l(this.f1488c1);     // Catch: Exception -> L84
        r25 = r25 + 1;     // Catch: Exception -> L84
        goto L82
    L86:
        r123 = x1(this.f1488c1);     // Catch: Exception -> L84
        WeakReference r26 = this.f1507v1;     // Catch: Exception -> L84
        if (r26 != null) goto L89;
    L91:
        WeakReference r27 = this.f1509x1;     // Catch: Exception -> L84
        if (r27 != null) goto L94;
    L96:
        WeakReference r28 = this.f1508w1;     // Catch: Exception -> L84
        if (r28 != null) goto L99;
    L101:
        WeakReference r29 = this.f1510y1;     // Catch: Exception -> L84
        if (r29 != null) goto L104;
    L106:
        if (r123 == false) goto L110;
        this.f1488c1.A();     // Catch: Exception -> L84
    L110:
        if (r123 == false) goto L112;
        boolean r30 = b2(this.f1488c1, f.f1655a);
    L117:
        if (r118 == false) goto L133;
        if (r124 >= 8) goto L133;
        if (f.f1655a[2] == false) goto L133;
        int r31 = 0;
        int r32 = 0;
        int r125 = 0;
    L122:
        if (r31 >= r11) goto L124;
        ConstraintWidget r33 = (ConstraintWidget) this.V0.get(r31);
        r125 = Math.max(r125, r33.f1447h0 + r33.V());
        r32 = Math.max(r32, r33.f1449i0 + r33.w());
        r31 = r31 + 1;
        r30 = r30;
        goto L122
    L124:
        boolean r126 = r30;
        int r34 = Math.max(this.f1461o0, r125);
        int r35 = Math.max(this.f1463p0, r32);
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r122 = r122;
        if (r16 != r36) goto L129;
        r122 = r122;
        if (V() >= r34) goto L129;
        l1(r34);
        this.f1435b0[0] = r36;
        r122 = 1;
        r126 = true;
    L129:
        if (r15 == r36) goto L131;
    L134:
        int r37 = Math.max(this.f1461o0, V());
        ?? r127 = r122;
        if (r37 <= V()) goto L137;
        l1(r37);
        this.f1435b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r127 = 1;
        r126 = true;
    L137:
        int r38 = Math.max(this.f1463p0, w());
        if (r38 <= w()) goto L140;
        M0(r38);
        ?? r39 = 1;
        this.f1435b0[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r40 = 1;
        r126 = true;
    L141:
        if (r40 != 0) goto L154;
        ConstraintWidget.DimensionBehaviour r41 = this.f1435b0[0];
        ConstraintWidget.DimensionBehaviour r128 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r40 = r40;
        r40 = r40;
        if (r41 != r128) goto L149;
        if (r22 <= 0) goto L149;
        r40 = r40;
        if (V() <= r22) goto L149;
        this.f1504s1 = r39;
        this.f1435b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        l1(r22);
        ?? r42 = r39;
        r126 = r42 == true ? 1 : 0;
        r40 = r42;
    L149:
        if (this.f1435b0[r39] != r128) goto L154;
        if (r21 <= 0) goto L154;
        if (w() <= r21) goto L154;
        this.f1505t1 = r39;
        this.f1435b0[r39] = ConstraintWidget.DimensionBehaviour.FIXED;
        M0(r21);
        int r43 = 8;
        boolean r44 = true;
        ?? r129 = 1;
    L155:
        if (r124 <= r43) goto L157;
        r123 = false;
    L158:
        r24 = r124;
        r10 = 0;
        r122 = r129;
        goto L79
    L157:
        r123 = r44;
    L154:
        r129 = r40;
        r44 = r126;
        r43 = 8;
        goto L155
    L140:
        r39 = 1;
        r40 = r127;
        goto L141
    L131:
        if (w() >= r35) goto L134;
        M0(r35);
        this.f1435b0[1] = r36;
        r122 = 1;
        r126 = true;
    L133:
        r126 = r30;
        goto L134
    L112:
        r1(this.f1488c1, r121);
        int r45 = 0;
    L113:
        if (r45 >= r11) goto L115;
        ((ConstraintWidget) this.V0.get(r45)).r1(this.f1488c1, r121);
        r45 = r45 + 1;
        goto L113
    L115:
        r30 = false;
        goto L117
    L104:
        if (r29.get() == null) goto L106;
        B1((ConstraintAnchor) this.f1510y1.get(), this.f1488c1.q(this.S));     // Catch: Exception -> L84
        this.f1510y1 = null;     // Catch: Exception -> L84
        goto L106
    L99:
        if (r28.get() == null) goto L101;
        C1((ConstraintAnchor) this.f1508w1.get(), this.f1488c1.q(this.Q));     // Catch: Exception -> L84
        this.f1508w1 = null;     // Catch: Exception -> L84
        goto L101
    L94:
        if (r27.get() == null) goto L96;
        B1((ConstraintAnchor) this.f1509x1.get(), this.f1488c1.q(this.T));     // Catch: Exception -> L84
        this.f1509x1 = null;     // Catch: Exception -> L84
        goto L96
    L89:
        if (r26.get() == null) goto L91;
        C1((ConstraintAnchor) this.f1507v1.get(), this.f1488c1.q(this.R));     // Catch: Exception -> L84
        this.f1507v1 = null;     // Catch: Exception -> L84
    L84:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L110
    L159:
        this.V0 = r115;
        if (r122 == 0) goto L162;
        ConstraintWidget.DimensionBehaviour[] r46 = this.f1435b0;
        r46[0] = r16;
        r46[1] = r15;
    L162:
        w0(this.f1488c1.w());
        return;
    L68:
        if (S() == r117) goto L71;
        r118 = false;
        goto L72
    L57:
        if (V1(128) == true) goto L60;
        r113 = false;
        goto L61
    L48:
        if (r13 >= w()) goto L51;
        if (r13 <= 0) goto L51;
        M0(r13);
        this.f1505t1 = true;
    L51:
        r13 = w();
        goto L52
    L42:
        if (r12 >= V()) goto L45;
        if (r12 <= 0) goto L45;
        l1(r12);
        this.f1504s1 = true;
    L45:
        r12 = V();
    L53:
        r21 = r13;
        r22 = r12;
        r23 = false;
        goto L55
    }

    public void w1(ConstraintWidget r10, int r11) {
        if (r11 != 0) goto L5;
        y1(r10);
        return;
    L5:
        if (r11 != 1) goto L9;
        D1(r10);
        return;
    }

    public boolean x1(LinearSystem r13) {
        boolean r10 = V1(64);
        d(r13, r10);
        int r11 = this.V0.size();
        int r12 = 0;
        boolean r14 = false;
    L4:
        if (r12 >= r11) goto L9;
        ConstraintWidget r15 = (ConstraintWidget) this.V0.get(r12);
        r15.T0(0, false);
        r15.T0(1, false);
        if ((r15 instanceof a) == false) goto L8;
        r14 = true;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r14 == false) goto L16;
        int r16 = 0;
    L11:
        if (r16 >= r11) goto L16;
        ConstraintWidget r17 = (ConstraintWidget) this.V0.get(r16);
        if ((r17 instanceof a) == false) goto L15;
        ((a) r17).z1();
    L15:
        r16 = r16 + 1;
    L16:
        this.f1511z1.clear();
        int r18 = 0;
    L17:
        if (r18 >= r11) goto L26;
        ConstraintWidget r19 = (ConstraintWidget) this.V0.get(r18);
        if (r19.c() == false) goto L24;
        if ((r19 instanceof h) == false) goto L23;
        this.f1511z1.add(r19);
        goto L24
    L23:
        r19.d(r13, r10);
    L24:
        r18 = r18 + 1;
    L26:
        if (this.f1511z1.size() <= 0) goto L41;
        int r20 = this.f1511z1.size();
        Iterator r21 = this.f1511z1.iterator();
    L29:
        if (r21.hasNext() == false) goto L34;
        h r22 = (h) ((ConstraintWidget) r21.next());
        if (r22.w1(this.f1511z1) == false) goto L29;
        r22.d(r13, r10);
        this.f1511z1.remove(r22);
    L34:
        if (r20 != this.f1511z1.size()) goto L26;
        Iterator r23 = this.f1511z1.iterator();
    L37:
        if (r23.hasNext() == false) goto L39;
        ((ConstraintWidget) r23.next()).d(r13, r10);
        goto L37
    L39:
        this.f1511z1.clear();
        goto L26
    L41:
        if (LinearSystem.f1259r == false) goto L56;
        HashSet r24 = new HashSet();
        int r25 = 0;
    L43:
        if (r25 >= r11) goto L49;
        ConstraintWidget r26 = (ConstraintWidget) this.V0.get(r25);
        if (r26.c() == true) goto L47;
        r24.add(r26);
    L47:
        r25 = r25 + 1;
        goto L43
    L49:
        if (z() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L51;
        int r110 = 0;
    L52:
        b(this, r13, r24, r110, false);
        Iterator r27 = r24.iterator();
    L54:
        if (r27.hasNext() == false) goto L75;
        ConstraintWidget r28 = (ConstraintWidget) r27.next();
        f.a(this, r13, r28);
        r28.d(r13, r10);
    L75:
        if (this.f1493h1 <= 0) goto L78;
        b.b(this, r13, null, 0);
    L78:
        if (this.f1494i1 <= 0) goto L80;
        b.b(this, r13, null, 1);
    L80:
        return true;
    L51:
        r110 = 1;
        goto L52
    L56:
        int r29 = 0;
    L57:
        if (r29 >= r11) goto L75;
        ConstraintWidget r30 = (ConstraintWidget) this.V0.get(r29);
        if ((r30 instanceof ConstraintWidgetContainer) == false) goto L70;
        ConstraintWidget.DimensionBehaviour[] r31 = r30.f1435b0;
        ConstraintWidget.DimensionBehaviour r32 = r31[0];
        ConstraintWidget.DimensionBehaviour r33 = r31[1];
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r32 != r34) goto L63;
        r30.Q0(ConstraintWidget.DimensionBehaviour.FIXED);
    L63:
        if (r33 != r34) goto L65;
        r30.h1(ConstraintWidget.DimensionBehaviour.FIXED);
    L65:
        r30.d(r13, r10);
        if (r32 != r34) goto L68;
        r30.Q0(r32);
    L68:
        if (r33 != r34) goto L73;
        r30.h1(r33);
    L73:
        r29 = r29 + 1;
        goto L57
    L70:
        f.a(this, r13, r30);
        if (r30.c() == true) goto L73;
        r30.d(r13, r10);
        goto L73
    }

    public final void y1(ConstraintWidget r10) {
        int r11 = this.f1493h1 + 1;
        c[] r12 = this.f1496k1;
        if (r11 < r12.length) goto L5;
        this.f1496k1 = (c[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        this.f1496k1[this.f1493h1] = new c(r10, 0, R1());
        this.f1493h1++;
    }

    public void z1(ConstraintAnchor r10) {
        WeakReference r11 = this.f1510y1;
        if (r11 != null) goto L5;
    L8:
        this.f1510y1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f1510y1.get()).e()) goto L8;
    }
}
