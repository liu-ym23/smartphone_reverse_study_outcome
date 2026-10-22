package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class d extends wc.b {
    public BasicMeasure W0;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c X0;
    public int Y0;
    public BasicMeasure.Measurer Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f13409a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public LinearSystem f13410b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f13411c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f13412d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f13413e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public int f13414f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f13415g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f13416h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public c[] f13417i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public c[] f13418j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f13419k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f13420l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f13421m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public int f13422n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f13423o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f13424p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public boolean f13425q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public boolean f13426r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public boolean f13427s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public int f13428t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public WeakReference f13429u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public WeakReference f13430v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public WeakReference f13431w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public WeakReference f13432x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public HashSet f13433y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public BasicMeasure.a f13434z1;

    static {
    }

    public d() {
        this.W0 = new BasicMeasure(this);
        this.X0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.c(this);
        this.Z0 = null;
        this.f13409a1 = false;
        this.f13410b1 = new LinearSystem();
        this.f13415g1 = 0;
        this.f13416h1 = 0;
        this.f13417i1 = new c[4];
        this.f13418j1 = new c[4];
        this.f13419k1 = false;
        this.f13420l1 = false;
        this.f13421m1 = false;
        this.f13422n1 = 0;
        this.f13423o1 = 0;
        this.f13424p1 = 257;
        this.f13425q1 = false;
        this.f13426r1 = false;
        this.f13427s1 = false;
        this.f13428t1 = 0;
        this.f13429u1 = null;
        this.f13430v1 = null;
        this.f13431w1 = null;
        this.f13432x1 = null;
        this.f13433y1 = new HashSet();
        this.f13434z1 = new BasicMeasure.a();
    }

    public static boolean V1(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, BasicMeasure.a r13, int r14) {
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r11.U() != 8) goto L8;
    L87:
        r13.f13316e = 0;
        r13.f13317f = 0;
        return false;
    L8:
        if ((r11 instanceof f) == true) goto L87;
        if ((r11 instanceof a) == true) goto L87;
        r13.f13312a = r11.z();
        r13.f13313b = r11.S();
        r13.f13314c = r11.V();
        r13.f13315d = r11.w();
        r13.f13320i = false;
        r13.f13321j = r14;
        ConstraintWidget.DimensionBehaviour r15 = r13.f13312a;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r15 != r16) goto L15;
        boolean r17 = true;
    L17:
        if (r13.f13313b != r16) goto L19;
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
        if (r11.f13297x != 0) goto L56;
        if (r20 == true) goto L56;
        r13.f13313b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r17 == true) goto L52;
    L54:
        r18 = false;
        goto L56
    L52:
        if (r11.f13295w != 0) goto L54;
        r13.f13313b = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r11.m0() == false) goto L59;
        r13.f13312a = ConstraintWidget.DimensionBehaviour.FIXED;
        r17 = false;
    L59:
        if (r11.n0() == false) goto L62;
        r13.f13313b = ConstraintWidget.DimensionBehaviour.FIXED;
        r18 = false;
    L62:
        if (r19 == true) goto L64;
    L72:
        if (r20 == true) goto L74;
    L85:
        r12.measure(r11, r13);
        r11.m1(r13.f13316e);
        r11.N0(r13.f13317f);
        r11.M0(r13.f13319h);
        r11.C0(r13.f13318g);
        r13.f13321j = BasicMeasure.a.f13309k;
        return r13.f13320i;
    L74:
        if (r11.f13299y[1] != 4) goto L76;
        r13.f13313b = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L85
    L76:
        if (r17 == true) goto L85;
        ConstraintWidget.DimensionBehaviour r21 = r13.f13312a;
        ConstraintWidget.DimensionBehaviour r22 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r21 != r22) goto L80;
        int r23 = r13.f13314c;
    L81:
        r13.f13313b = r22;
        if (r11.v() != (-1)) goto L84;
        r13.f13315d = (int) (r23 / r11.u());
        goto L85
    L84:
        r13.f13315d = (int) (r11.u() * r23);
        goto L85
    L80:
        r13.f13313b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r12.measure(r11, r13);
        r23 = r13.f13316e;
        goto L81
    L64:
        if (r11.f13299y[0] != 4) goto L66;
        r13.f13312a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r18 == true) goto L72;
        ConstraintWidget.DimensionBehaviour r24 = r13.f13313b;
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r24 != r25) goto L70;
        int r26 = r13.f13315d;
    L71:
        r13.f13312a = r25;
        r13.f13314c = (int) (r11.u() * r26);
        goto L72
    L70:
        r13.f13312a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r12.measure(r11, r13);
        r26 = r13.f13317f;
        goto L71
    L33:
        if (r11.Z(0) == false) goto L43;
        if (r11.f13295w != 0) goto L43;
        if (r19 == true) goto L43;
        r13.f13312a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 == true) goto L40;
    L42:
        r17 = false;
        goto L43
    L40:
        if (r11.f13297x != 0) goto L42;
        r13.f13312a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r11.f13262f0 <= 0.0f) goto L30;
        r20 = true;
        goto L31
    L23:
        if (r11.f13262f0 <= 0.0f) goto L25;
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
        WeakReference r11 = this.f13432x1;
        if (r11 != null) goto L5;
    L8:
        this.f13432x1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f13432x1.get()).e()) goto L8;
    }

    public void B1(ConstraintAnchor r10) {
        WeakReference r11 = this.f13430v1;
        if (r11 != null) goto L5;
    L8:
        this.f13430v1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f13430v1.get()).e()) goto L8;
    }

    public final void C1(ConstraintAnchor r10, SolverVariable r11) {
        SolverVariable r12 = this.f13410b1.q(r10);
        this.f13410b1.h(r11, r12, 0, 5);
    }

    public final void D1(ConstraintAnchor r10, SolverVariable r11) {
        SolverVariable r12 = this.f13410b1.q(r10);
        this.f13410b1.h(r12, r11, 0, 5);
    }

    public final void E1(ConstraintWidget r10) {
        int r11 = this.f13416h1 + 1;
        c[] r12 = this.f13417i1;
        if (r11 < r12.length) goto L5;
        this.f13417i1 = (c[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        this.f13417i1[this.f13416h1] = new c(r10, 1, S1());
        this.f13416h1++;
    }

    public void F1(ConstraintAnchor r10) {
        WeakReference r11 = this.f13431w1;
        if (r11 != null) goto L5;
    L8:
        this.f13431w1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f13431w1.get()).e()) goto L8;
    }

    public void G1(ConstraintAnchor r10) {
        WeakReference r11 = this.f13429u1;
        if (r11 != null) goto L5;
    L8:
        this.f13429u1 = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.e() > ((ConstraintAnchor) this.f13429u1.get()).e()) goto L8;
    }

    public boolean H1(boolean r10) {
        return this.X0.f(r10);
    }

    public boolean I1(boolean r10) {
        return this.X0.g(r10);
    }

    public boolean J1(boolean r10, int r11) {
        return this.X0.h(r10, r11);
    }

    public void K1(com.obric.oui.constraintlayout.core.c r10) {
        this.f13410b1.v(r10);
    }

    public BasicMeasure.Measurer L1() {
        return this.Z0;
    }

    public int M1() {
        return this.f13424p1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void N(StringBuilder r10) {
        r10.append(this.f13279o + ":{\n");
        r10.append("  actualWidth:" + this.f13258d0);
        r10.append("\n");
        r10.append("  actualHeight:" + this.f13260e0);
        r10.append("\n");
        Iterator r11 = t1().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((ConstraintWidget) r11.next()).N(r10);
        r10.append(",\n");
        goto L4
    L6:
        r10.append("}");
    }

    public LinearSystem N1() {
        return this.f13410b1;
    }

    public boolean O1() {
        return false;
    }

    public void P1() {
        this.X0.j();
    }

    public void Q1() {
        this.X0.k();
    }

    public boolean R1() {
        return this.f13427s1;
    }

    public boolean S1() {
        return this.f13409a1;
    }

    public boolean T1() {
        return this.f13426r1;
    }

    public long U1(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.f13411c1 = r19;
        this.f13412d1 = r20;
        return this.W0.d(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public boolean W1(int r10) {
        if ((this.f13424p1 & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public final void X1() {
        this.f13415g1 = 0;
        this.f13416h1 = 0;
    }

    public void Y1(BasicMeasure.Measurer r10) {
        this.Z0 = r10;
        this.X0.n(r10);
    }

    public void Z1(int r10) {
        this.f13424p1 = r10;
        LinearSystem.f13101s = W1(512);
    }

    public void a2(int r10) {
        this.Y0 = r10;
    }

    public void b2(boolean r10) {
        this.f13409a1 = r10;
    }

    public boolean c2(LinearSystem r10, boolean[] r11) {
        int r12 = 0;
        r11[2] = false;
        boolean r13 = W1(64);
        s1(r10, r13);
        int r14 = this.V0.size();
        boolean r15 = false;
    L3:
        if (r12 >= r14) goto L8;
        ConstraintWidget r16 = (ConstraintWidget) this.V0.get(r12);
        r16.s1(r10, r13);
        if (r16.b0() == false) goto L7;
        r15 = true;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r15;
    }

    public void d2() {
        this.W0.e(this);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void r1(boolean r10, boolean r11) {
        super.r1(r10, r11);
        int r12 = this.V0.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((ConstraintWidget) this.V0.get(r13)).r1(r10, r11);
        r13 = r13 + 1;
        goto L3
    }

    @Override // wc.b, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void s0() {
        this.f13410b1.E();
        this.f13411c1 = 0;
        this.f13413e1 = 0;
        this.f13412d1 = 0;
        this.f13414f1 = 0;
        this.f13425q1 = false;
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
    @Override // wc.b
    public void u1() {
        int r10 = 0;
        this.f13266h0 = 0;
        this.f13268i0 = 0;
        this.f13426r1 = false;
        this.f13427s1 = false;
        int r11 = this.V0.size();
        int r12 = Math.max(0, V());
        int r13 = Math.max(0, w());
        ConstraintWidget.DimensionBehaviour[] r14 = this.f13254b0;
        ConstraintWidget.DimensionBehaviour r15 = r14[1];
        ConstraintWidget.DimensionBehaviour r16 = r14[0];
        if (this.Y0 != 0) goto L29;
        if (g.b(this.f13424p1, 1) == false) goto L29;
        com.obric.oui.constraintlayout.core.widgets.analyzer.e.h(this, L1());
        int r17 = 0;
    L7:
        if (r17 >= r11) goto L29;
        ConstraintWidget r18 = (ConstraintWidget) this.V0.get(r17);
        if (r18.l0() == false) goto L27;
        if ((r18 instanceof f) == true) goto L27;
        if ((r18 instanceof a) == true) goto L27;
        if ((r18 instanceof i) == true) goto L27;
        if (r18.k0() == true) goto L27;
        ConstraintWidget.DimensionBehaviour r19 = r18.t(0);
        ConstraintWidget.DimensionBehaviour r110 = r18.t(1);
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 == r111) goto L21;
    L26:
        V1(0, r18, this.Z0, new BasicMeasure.a(), BasicMeasure.a.f13309k);
        goto L27
    L21:
        if (r18.f13295w == 1) goto L26;
        if (r110 != r111) goto L26;
        if (r18.f13297x == 1) goto L26;
    L27:
        r17 = r17 + 1;
    L29:
        if (r11 <= 2) goto L50;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r16 == r20) goto L34;
        if (r15 != r20) goto L50;
    L34:
        if (g.b(this.f13424p1, 1024) == false) goto L50;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.f.c(this, L1()) == false) goto L50;
        if (r16 == r20) goto L39;
    L43:
        if (r15 == r20) goto L45;
    L49:
        int r21 = r13;
        int r22 = r12;
        boolean r23 = true;
    L52:
        if (W1(64) == false) goto L54;
    L57:
        boolean r112 = true;
    L58:
        LinearSystem r113 = this.f13410b1;
        r113.f13116i = false;
        r113.f13117j = false;
        if (this.f13424p1 == 0) goto L62;
        if (r112 == false) goto L62;
        r113.f13117j = true;
    L62:
        ArrayList r114 = this.V0;
        ConstraintWidget.DimensionBehaviour r115 = z();
        ConstraintWidget.DimensionBehaviour r116 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r115 != r116) goto L65;
    L68:
        boolean r117 = true;
    L69:
        X1();
        int r118 = 0;
    L70:
        if (r118 >= r11) goto L75;
        ConstraintWidget r119 = (ConstraintWidget) this.V0.get(r118);
        if ((r119 instanceof wc.b) == false) goto L74;
        ((wc.b) r119).u1();
    L74:
        r118 = r118 + 1;
        goto L70
    L75:
        boolean r120 = W1(64);
        ?? r121 = r23;
        int r24 = 0;
        boolean r122 = true;
    L76:
        if (r122 == false) goto L156;
        int r123 = r24 + 1;
        this.f13410b1.E();     // Catch: Exception -> L81
        X1();     // Catch: Exception -> L81
        l(this.f13410b1);     // Catch: Exception -> L81
        int r25 = r10;
    L79:
        if (r25 >= r11) goto L83;
        ((ConstraintWidget) this.V0.get(r25)).l(this.f13410b1);     // Catch: Exception -> L81
        r25 = r25 + 1;     // Catch: Exception -> L81
        goto L79
    L83:
        r122 = y1(this.f13410b1);     // Catch: Exception -> L81
        WeakReference r26 = this.f13429u1;     // Catch: Exception -> L81
        if (r26 != null) goto L86;
    L88:
        WeakReference r27 = this.f13431w1;     // Catch: Exception -> L81
        if (r27 != null) goto L91;
    L93:
        WeakReference r28 = this.f13430v1;     // Catch: Exception -> L81
        if (r28 != null) goto L96;
    L98:
        WeakReference r29 = this.f13432x1;     // Catch: Exception -> L81
        if (r29 != null) goto L101;
    L103:
        if (r122 == false) goto L107;
        this.f13410b1.A();     // Catch: Exception -> L81
    L107:
        if (r122 == false) goto L109;
        boolean r30 = c2(this.f13410b1, g.f13473a);
    L114:
        if (r117 == false) goto L130;
        if (r123 >= 8) goto L130;
        if (g.f13473a[2] == false) goto L130;
        int r31 = 0;
        int r32 = 0;
        int r124 = 0;
    L119:
        if (r31 >= r11) goto L121;
        ConstraintWidget r33 = (ConstraintWidget) this.V0.get(r31);
        r124 = Math.max(r124, r33.f13266h0 + r33.V());
        r32 = Math.max(r32, r33.f13268i0 + r33.w());
        r31 = r31 + 1;
        r30 = r30;
        goto L119
    L121:
        boolean r125 = r30;
        int r34 = Math.max(this.f13280o0, r124);
        int r35 = Math.max(this.f13282p0, r32);
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r121 = r121;
        if (r16 != r36) goto L126;
        r121 = r121;
        if (V() >= r34) goto L126;
        m1(r34);
        this.f13254b0[0] = r36;
        r121 = 1;
        r125 = true;
    L126:
        if (r15 == r36) goto L128;
    L131:
        int r37 = Math.max(this.f13280o0, V());
        ?? r126 = r121;
        if (r37 <= V()) goto L134;
        m1(r37);
        this.f13254b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r126 = 1;
        r125 = true;
    L134:
        int r38 = Math.max(this.f13282p0, w());
        if (r38 <= w()) goto L137;
        N0(r38);
        ?? r39 = 1;
        this.f13254b0[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r40 = 1;
        r125 = true;
    L138:
        if (r40 != 0) goto L151;
        ConstraintWidget.DimensionBehaviour r41 = this.f13254b0[0];
        ConstraintWidget.DimensionBehaviour r127 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r40 = r40;
        r40 = r40;
        if (r41 != r127) goto L146;
        if (r22 <= 0) goto L146;
        r40 = r40;
        if (V() <= r22) goto L146;
        this.f13426r1 = r39;
        this.f13254b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        m1(r22);
        ?? r42 = r39;
        r125 = r42 == true ? 1 : 0;
        r40 = r42;
    L146:
        if (this.f13254b0[r39] != r127) goto L151;
        if (r21 <= 0) goto L151;
        if (w() <= r21) goto L151;
        this.f13427s1 = r39;
        this.f13254b0[r39] = ConstraintWidget.DimensionBehaviour.FIXED;
        N0(r21);
        int r43 = 8;
        boolean r44 = true;
        ?? r128 = 1;
    L152:
        if (r123 <= r43) goto L154;
        r122 = false;
    L155:
        r24 = r123;
        r10 = 0;
        r121 = r128;
        goto L76
    L154:
        r122 = r44;
    L151:
        r128 = r40;
        r44 = r125;
        r43 = 8;
        goto L152
    L137:
        r39 = 1;
        r40 = r126;
        goto L138
    L128:
        if (w() >= r35) goto L131;
        N0(r35);
        this.f13254b0[1] = r36;
        r121 = 1;
        r125 = true;
    L130:
        r125 = r30;
        goto L131
    L109:
        s1(this.f13410b1, r120);
        int r45 = 0;
    L110:
        if (r45 >= r11) goto L112;
        ((ConstraintWidget) this.V0.get(r45)).s1(this.f13410b1, r120);
        r45 = r45 + 1;
        goto L110
    L112:
        r30 = false;
        goto L114
    L101:
        if (r29.get() == null) goto L103;
        C1((ConstraintAnchor) this.f13432x1.get(), this.f13410b1.q(this.S));     // Catch: Exception -> L81
        this.f13432x1 = null;     // Catch: Exception -> L81
        goto L103
    L96:
        if (r28.get() == null) goto L98;
        D1((ConstraintAnchor) this.f13430v1.get(), this.f13410b1.q(this.Q));     // Catch: Exception -> L81
        this.f13430v1 = null;     // Catch: Exception -> L81
        goto L98
    L91:
        if (r27.get() == null) goto L93;
        C1((ConstraintAnchor) this.f13431w1.get(), this.f13410b1.q(this.T));     // Catch: Exception -> L81
        this.f13431w1 = null;     // Catch: Exception -> L81
        goto L93
    L86:
        if (r26.get() == null) goto L88;
        D1((ConstraintAnchor) this.f13429u1.get(), this.f13410b1.q(this.R));     // Catch: Exception -> L81
        this.f13429u1 = null;     // Catch: Exception -> L81
    L81:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L107
    L156:
        this.V0 = r114;
        if (r121 == 0) goto L159;
        ConstraintWidget.DimensionBehaviour[] r46 = this.f13254b0;
        r46[0] = r16;
        r46[1] = r15;
    L159:
        w0(this.f13410b1.w());
        return;
    L65:
        if (S() == r116) goto L68;
        r117 = false;
        goto L69
    L54:
        if (W1(128) == true) goto L57;
        r112 = false;
        goto L58
    L45:
        if (r13 >= w()) goto L48;
        if (r13 <= 0) goto L48;
        N0(r13);
        this.f13427s1 = true;
    L48:
        r13 = w();
        goto L49
    L39:
        if (r12 >= V()) goto L42;
        if (r12 <= 0) goto L42;
        m1(r12);
        this.f13426r1 = true;
    L42:
        r12 = V();
    L50:
        r21 = r13;
        r22 = r12;
        r23 = false;
        goto L52
    }

    public void x1(ConstraintWidget r10, int r11) {
        if (r11 != 0) goto L5;
        z1(r10);
        return;
    L5:
        if (r11 != 1) goto L9;
        E1(r10);
        return;
    }

    public boolean y1(LinearSystem r13) {
        boolean r10 = W1(64);
        d(r13, r10);
        int r11 = this.V0.size();
        int r12 = 0;
        boolean r14 = false;
    L4:
        if (r12 >= r11) goto L9;
        ConstraintWidget r15 = (ConstraintWidget) this.V0.get(r12);
        r15.U0(0, false);
        r15.U0(1, false);
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
        ((a) r17).A1();
    L15:
        r16 = r16 + 1;
    L16:
        this.f13433y1.clear();
        int r18 = 0;
    L17:
        if (r18 >= r11) goto L26;
        ConstraintWidget r19 = (ConstraintWidget) this.V0.get(r18);
        if (r19.c() == false) goto L24;
        if ((r19 instanceof i) == false) goto L23;
        this.f13433y1.add(r19);
        goto L24
    L23:
        r19.d(r13, r10);
    L24:
        r18 = r18 + 1;
    L26:
        if (this.f13433y1.size() <= 0) goto L41;
        int r20 = this.f13433y1.size();
        Iterator r21 = this.f13433y1.iterator();
    L29:
        if (r21.hasNext() == false) goto L34;
        i r22 = (i) ((ConstraintWidget) r21.next());
        if (r22.x1(this.f13433y1) == false) goto L29;
        r22.d(r13, r10);
        this.f13433y1.remove(r22);
    L34:
        if (r20 != this.f13433y1.size()) goto L26;
        Iterator r23 = this.f13433y1.iterator();
    L37:
        if (r23.hasNext() == false) goto L39;
        ((ConstraintWidget) r23.next()).d(r13, r10);
        goto L37
    L39:
        this.f13433y1.clear();
        goto L26
    L41:
        if (LinearSystem.f13101s == false) goto L56;
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
        g.a(this, r13, r28);
        r28.d(r13, r10);
    L75:
        if (this.f13415g1 <= 0) goto L78;
        b.b(this, r13, null, 0);
    L78:
        if (this.f13416h1 <= 0) goto L80;
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
        if ((r30 instanceof d) == false) goto L70;
        ConstraintWidget.DimensionBehaviour[] r31 = r30.f13254b0;
        ConstraintWidget.DimensionBehaviour r32 = r31[0];
        ConstraintWidget.DimensionBehaviour r33 = r31[1];
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r32 != r34) goto L63;
        r30.R0(ConstraintWidget.DimensionBehaviour.FIXED);
    L63:
        if (r33 != r34) goto L65;
        r30.i1(ConstraintWidget.DimensionBehaviour.FIXED);
    L65:
        r30.d(r13, r10);
        if (r32 != r34) goto L68;
        r30.R0(r32);
    L68:
        if (r33 != r34) goto L73;
        r30.i1(r33);
    L73:
        r29 = r29 + 1;
        goto L57
    L70:
        g.a(this, r13, r30);
        if (r30.c() == true) goto L73;
        r30.d(r13, r10);
        goto L73
    }

    public final void z1(ConstraintWidget r10) {
        int r11 = this.f13415g1 + 1;
        c[] r12 = this.f13418j1;
        if (r11 < r12.length) goto L5;
        this.f13418j1 = (c[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        this.f13418j1[this.f13415g1] = new c(r10, 0, S1());
        this.f13415g1++;
    }
}
