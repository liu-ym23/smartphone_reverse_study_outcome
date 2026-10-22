package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BasicMeasure.a f13357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f13358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f13359c;

    static {
        f13357a = new BasicMeasure.a();
        f13358b = 0;
        f13359c = 0;
    }

    public static boolean a(int r10, ConstraintWidget r11) {
        ConstraintWidget.DimensionBehaviour r12 = r11.z();
        ConstraintWidget.DimensionBehaviour r13 = r11.S();
        if (r11.J() == null) goto L5;
        com.obric.oui.constraintlayout.core.widgets.d r14 = (com.obric.oui.constraintlayout.core.widgets.d) r11.J();
    L6:
        if (r14 == null) goto L8;
        r14.z();
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r14 == null) goto L10;
        r14.S();
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r12 != r17) goto L13;
    L31:
        boolean r18 = true;
    L32:
        if (r13 != r17) goto L34;
    L52:
        boolean r19 = true;
    L54:
        if (r11.f13262f0 <= 0.0f) goto L58;
        if (r18 == true) goto L57;
        if (r19 == false) goto L58;
    L57:
        return true;
    L58:
        if (r18 == false) goto L62;
        if (r19 == true) goto L61;
        return false;
    L61:
        return true;
    L62:
        return false;
    L34:
        if (r11.n0() == true) goto L52;
        if (r13 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r20) goto L40;
    L45:
        if (r13 == r20) goto L47;
    L51:
        r19 = false;
        goto L54
    L47:
        if (r11.f13297x != 1) goto L51;
        if (r11.c0(1, r11.w()) == false) goto L51;
    L40:
        if (r11.f13297x != 0) goto L45;
        if (r11.f13262f0 != 0.0f) goto L45;
        if (r11.Z(1) == true) goto L52;
    L13:
        if (r11.m0() == true) goto L31;
        if (r12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 == r21) goto L19;
    L24:
        if (r12 == r21) goto L26;
    L30:
        r18 = false;
        goto L32
    L26:
        if (r11.f13295w != 1) goto L30;
        if (r11.c0(0, r11.V()) == false) goto L30;
    L19:
        if (r11.f13295w != 0) goto L24;
        if (r11.f13262f0 != 0.0f) goto L24;
        if (r11.Z(0) == true) goto L31;
    L5:
        r14 = null;
        goto L6
    }

    public static void b(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18, boolean r19) {
        if (r17.f0() == false) goto L5;
        return;
    L5:
        boolean r10 = true;
        f13358b++;
        if ((r17 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L8;
    L12:
        ConstraintAnchor r11 = r17.n(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r12 = r17.n(ConstraintAnchor.Type.RIGHT);
        int r13 = r11.e();
        int r14 = r12.e();
        if (r11.d() == null) goto L79;
        if (r11.n() == false) goto L79;
        Iterator r15 = r11.d().iterator();
    L18:
        if (r15.hasNext() == false) goto L79;
        ConstraintAnchor r20 = (ConstraintAnchor) r15.next();
        ConstraintWidget r110 = r20.f13243d;
        int r111 = r16 + 1;
        boolean r112 = a(r111, r110);
        if (r110.l0() == false) goto L24;
        if (r112 == false) goto L24;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r111, r110, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
    L24:
        if (r20 != r110.Q) goto L30;
        ConstraintAnchor r113 = r110.S.f13245f;
        if (r113 == null) goto L30;
        if (r113.n() == false) goto L30;
    L35:
        boolean r114 = r10;
    L37:
        ConstraintWidget.DimensionBehaviour r115 = r110.z();
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r115 != r21) goto L62;
        if (r112 == true) goto L62;
        if (r110.z() != r21) goto L63;
        if (r110.A < 0) goto L63;
        if (r110.f13301z < 0) goto L63;
        if (r110.U() == 8) goto L54;
        if (r110.f13295w != 0) goto L63;
        if (r110.u() != 0.0f) goto L63;
    L54:
        if (r110.h0() == true) goto L63;
        if (r110.k0() == true) goto L63;
        if (r114 == false) goto L63;
        if (r110.h0() == true) goto L63;
        e(r111, r17, r18, r110, r19);
    L63:
        r10 = true;
    L62:
        if (r110.l0() == true) goto L63;
        ConstraintAnchor r22 = r110.Q;
        if (r20 == r22) goto L67;
    L69:
        ConstraintAnchor r116 = r110.S;
        if (r20 == r116) goto L72;
    L74:
        if (r114 == false) goto L63;
        if (r110.h0() == true) goto L63;
        d(r111, r18, r110, r19);
        goto L63
    L72:
        if (r22.f13245f != null) goto L74;
        int r23 = r13 - r116.f();
        r110.H0(r23 - r110.V(), r23);
        b(r111, r110, r18, r19);
        goto L63
    L67:
        if (r110.S.f13245f != null) goto L69;
        int r24 = r22.f() + r13;
        r110.H0(r24, r110.V() + r24);
        b(r111, r110, r18, r19);
    L30:
        if (r20 != r110.S) goto L36;
        ConstraintAnchor r117 = r110.Q.f13245f;
        if (r117 == null) goto L36;
        if (r117.n() == true) goto L35;
    L36:
        r114 = false;
    L79:
        if ((r17 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L82;
        return;
    L82:
        if (r12.d() != null) goto L84;
    L147:
        r17.p0();
        return;
    L84:
        if (r12.n() == false) goto L147;
        Iterator r25 = r12.d().iterator();
    L87:
        if (r25.hasNext() == false) goto L147;
        ConstraintAnchor r26 = (ConstraintAnchor) r25.next();
        ConstraintWidget r27 = r26.f13243d;
        int r28 = r16 + 1;
        boolean r118 = a(r28, r27);
        if (r27.l0() == false) goto L93;
        if (r118 == false) goto L93;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r28, r27, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
    L93:
        if (r26 != r27.Q) goto L99;
        ConstraintAnchor r119 = r27.S.f13245f;
        if (r119 == null) goto L99;
        if (r119.n() == false) goto L99;
    L104:
        boolean r120 = true;
    L106:
        ConstraintWidget.DimensionBehaviour r121 = r27.z();
        ConstraintWidget.DimensionBehaviour r122 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r121 != r122) goto L131;
        if (r118 == true) goto L131;
        if (r27.z() != r122) goto L87;
        if (r27.A < 0) goto L87;
        if (r27.f13301z < 0) goto L87;
        if (r27.U() == 8) goto L123;
        if (r27.f13295w != 0) goto L87;
        if (r27.u() != 0.0f) goto L87;
    L123:
        if (r27.h0() == true) goto L87;
        if (r27.k0() == true) goto L87;
        if (r120 == false) goto L87;
        if (r27.h0() == true) goto L87;
        e(r28, r17, r18, r27, r19);
    L131:
        if (r27.l0() == true) goto L87;
        ConstraintAnchor r123 = r27.Q;
        if (r26 != r123) goto L138;
        if (r27.S.f13245f != null) goto L138;
        int r29 = r123.f() + r14;
        r27.H0(r29, r27.V() + r29);
        b(r28, r27, r18, r19);
    L138:
        ConstraintAnchor r124 = r27.S;
        if (r26 != r124) goto L143;
        if (r123.f13245f != null) goto L143;
        int r30 = r14 - r124.f();
        r27.H0(r30 - r27.V(), r30);
        b(r28, r27, r18, r19);
    L143:
        if (r120 == false) goto L87;
        if (r27.h0() == true) goto L87;
        d(r28, r18, r27, r19);
    L99:
        if (r26 != r27.S) goto L105;
        ConstraintAnchor r125 = r27.Q.f13245f;
        if (r125 == null) goto L105;
        if (r125.n() == true) goto L104;
    L105:
        r120 = false;
        goto L106
    L8:
        if (r17.l0() == false) goto L12;
        int r31 = r16 + 1;
        if (a(r31, r17) == false) goto L12;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r31, r17, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
        goto L12
    }

    public static void c(int r10, com.obric.oui.constraintlayout.core.widgets.a r11, BasicMeasure.Measurer r12, int r13, boolean r14) {
        if (r11.v1() == false) goto L8;
        if (r13 != 0) goto L6;
        b(r10 + 1, r11, r12, r14);
        return;
    L6:
        i(r10 + 1, r11, r12);
        return;
    }

    public static void d(int r10, BasicMeasure.Measurer r11, ConstraintWidget r12, boolean r13) {
        float r14 = r12.x();
        int r15 = r12.Q.f13245f.e();
        int r16 = r12.S.f13245f.e();
        int r17 = r12.Q.f() + r15;
        int r18 = r16 - r12.S.f();
        if (r15 != r16) goto L5;
        r14 = 0.5f;
    L6:
        int r19 = r12.V();
        int r20 = (r16 - r15) - r19;
        if (r15 <= r16) goto L9;
        r20 = (r15 - r16) - r19;
    L9:
        if (r20 <= 0) goto L12;
        float r21 = (r14 * r20) + 0.5f;
    L13:
        int r22 = ((int) r21) + r15;
        int r23 = r22 + r19;
        if (r15 <= r16) goto L16;
        r23 = r22 - r19;
    L16:
        r12.H0(r22, r23);
        b(r10 + 1, r12, r11, r13);
        return;
    L12:
        r21 = r14 * r20;
        goto L13
    L5:
        r15 = r17;
        r16 = r18;
        goto L6
    }

    public static void e(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, ConstraintWidget r13, boolean r14) {
        float r15 = r13.x();
        int r16 = r13.Q.f13245f.e() + r13.Q.f();
        int r17 = r13.S.f13245f.e() - r13.S.f();
        if (r17 < r16) goto L20;
        int r18 = r13.V();
        if (r13.U() == 8) goto L18;
        int r19 = r13.f13295w;
        if (r19 == 2) goto L9;
        if (r19 != 0) goto L15;
        r18 = r17 - r16;
    L15:
        r18 = Math.max(r13.f13301z, r18);
        int r20 = r13.A;
        if (r20 <= 0) goto L18;
        r18 = Math.min(r20, r18);
        goto L18
    L9:
        if ((r11 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L11;
        int r21 = r11.V();
    L12:
        r18 = (int) ((r13.x() * 0.5f) * r21);
        goto L15
    L11:
        r21 = r11.J().V();
    L18:
        int r22 = r16 + ((int) ((r15 * ((r17 - r16) - r18)) + 0.5f));
        r13.H0(r22, r18 + r22);
        b(r10 + 1, r13, r12, r14);
        return;
    }

    public static void f(int r10, BasicMeasure.Measurer r11, ConstraintWidget r12) {
        float r13 = r12.Q();
        int r14 = r12.R.f13245f.e();
        int r15 = r12.T.f13245f.e();
        int r16 = r12.R.f() + r14;
        int r17 = r15 - r12.T.f();
        if (r14 != r15) goto L5;
        r13 = 0.5f;
    L6:
        int r18 = r12.w();
        int r19 = (r15 - r14) - r18;
        if (r14 <= r15) goto L9;
        r19 = (r14 - r15) - r18;
    L9:
        if (r19 <= 0) goto L12;
        float r20 = (r13 * r19) + 0.5f;
    L11:
        int r21 = (int) r20;
        int r22 = r14 + r21;
        int r23 = r22 + r18;
        if (r14 <= r15) goto L16;
        r22 = r14 - r21;
        r23 = r22 - r18;
    L16:
        r12.K0(r22, r23);
        i(r10 + 1, r12, r11);
        return;
    L12:
        r20 = r13 * r19;
        goto L11
    L5:
        r14 = r16;
        r15 = r17;
        goto L6
    }

    public static void g(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, ConstraintWidget r13) {
        float r14 = r13.Q();
        int r15 = r13.R.f13245f.e() + r13.R.f();
        int r16 = r13.T.f13245f.e() - r13.T.f();
        if (r16 < r15) goto L20;
        int r17 = r13.w();
        if (r13.U() == 8) goto L18;
        int r18 = r13.f13297x;
        if (r18 == 2) goto L9;
        if (r18 != 0) goto L15;
        r17 = r16 - r15;
    L15:
        r17 = Math.max(r13.C, r17);
        int r19 = r13.D;
        if (r19 <= 0) goto L18;
        r17 = Math.min(r19, r17);
        goto L18
    L9:
        if ((r11 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L11;
        int r20 = r11.w();
    L12:
        r17 = (int) ((r14 * 0.5f) * r20);
        goto L15
    L11:
        r20 = r11.J().w();
    L18:
        int r21 = r15 + ((int) ((r14 * ((r16 - r15) - r17)) + 0.5f));
        r13.K0(r21, r17 + r21);
        i(r10 + 1, r13, r12);
        return;
    }

    public static void h(com.obric.oui.constraintlayout.core.widgets.d r13, BasicMeasure.Measurer r14) {
        ConstraintWidget.DimensionBehaviour r10 = r13.z();
        ConstraintWidget.DimensionBehaviour r11 = r13.S();
        f13358b = 0;
        f13359c = 0;
        r13.v0();
        ArrayList r12 = r13.t1();
        int r15 = r12.size();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        ((ConstraintWidget) r12.get(r16)).v0();
        r16 = r16 + 1;
        goto L3
    L5:
        boolean r17 = r13.S1();
        if (r10 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r13.H0(0, r13.V());
    L9:
        int r18 = 0;
        boolean r19 = false;
        boolean r20 = false;
    L11:
        if (r18 >= r15) goto L34;
        ConstraintWidget r110 = (ConstraintWidget) r12.get(r18);
        if ((r110 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L29;
        com.obric.oui.constraintlayout.core.widgets.f r111 = (com.obric.oui.constraintlayout.core.widgets.f) r110;
        if (r111.u1() != 1) goto L33;
        if (r111.v1() == (-1)) goto L20;
        r111.y1(r111.v1());
    L27:
        r19 = true;
        goto L33
    L20:
        if (r111.w1() == (-1)) goto L25;
        if (r13.m0() == false) goto L25;
        r111.y1(r13.V() - r111.w1());
    L25:
        if (r13.m0() == false) goto L27;
        r111.y1((int) ((r111.x1() * r13.V()) + 0.5f));
    L33:
        r18 = r18 + 1;
        goto L11
    L29:
        if ((r110 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L33;
        if (((com.obric.oui.constraintlayout.core.widgets.a) r110).z1() != 0) goto L33;
        r20 = true;
        goto L33
    L34:
        if (r19 == false) goto L43;
        int r21 = 0;
    L36:
        if (r21 >= r15) goto L43;
        ConstraintWidget r22 = (ConstraintWidget) r12.get(r21);
        if ((r22 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L42;
        com.obric.oui.constraintlayout.core.widgets.f r23 = (com.obric.oui.constraintlayout.core.widgets.f) r22;
        if (r23.u1() != 1) goto L42;
        b(0, r23, r14, r17);
    L42:
        r21 = r21 + 1;
    L43:
        b(0, r13, r14, r17);
        if (r20 == false) goto L54;
        int r24 = 0;
    L46:
        if (r24 >= r15) goto L54;
        ConstraintWidget r25 = (ConstraintWidget) r12.get(r24);
        if ((r25 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L52;
        com.obric.oui.constraintlayout.core.widgets.a r26 = (com.obric.oui.constraintlayout.core.widgets.a) r25;
        if (r26.z1() != 0) goto L52;
        c(0, r26, r14, 0, r17);
    L52:
        r24 = r24 + 1;
    L54:
        if (r11 != ConstraintWidget.DimensionBehaviour.FIXED) goto L56;
        r13.K0(0, r13.w());
    L57:
        int r27 = 0;
        boolean r28 = false;
        boolean r29 = false;
    L58:
        if (r27 >= r15) goto L81;
        ConstraintWidget r30 = (ConstraintWidget) r12.get(r27);
        if ((r30 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L76;
        com.obric.oui.constraintlayout.core.widgets.f r31 = (com.obric.oui.constraintlayout.core.widgets.f) r30;
        if (r31.u1() != 0) goto L80;
        if (r31.v1() == (-1)) goto L67;
        r31.y1(r31.v1());
    L74:
        r28 = true;
        goto L80
    L67:
        if (r31.w1() == (-1)) goto L72;
        if (r13.n0() == false) goto L72;
        r31.y1(r13.w() - r31.w1());
    L72:
        if (r13.n0() == false) goto L74;
        r31.y1((int) ((r31.x1() * r13.w()) + 0.5f));
    L80:
        r27 = r27 + 1;
        goto L58
    L76:
        if ((r30 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L80;
        if (((com.obric.oui.constraintlayout.core.widgets.a) r30).z1() != 1) goto L80;
        r29 = true;
        goto L80
    L81:
        if (r28 == false) goto L90;
        int r32 = 0;
    L83:
        if (r32 >= r15) goto L90;
        ConstraintWidget r33 = (ConstraintWidget) r12.get(r32);
        if ((r33 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L89;
        com.obric.oui.constraintlayout.core.widgets.f r34 = (com.obric.oui.constraintlayout.core.widgets.f) r33;
        if (r34.u1() != 0) goto L89;
        i(1, r34, r14);
    L89:
        r32 = r32 + 1;
    L90:
        i(0, r13, r14);
        if (r29 == false) goto L100;
        int r112 = 0;
    L93:
        if (r112 >= r15) goto L100;
        ConstraintWidget r35 = (ConstraintWidget) r12.get(r112);
        if ((r35 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L99;
        com.obric.oui.constraintlayout.core.widgets.a r36 = (com.obric.oui.constraintlayout.core.widgets.a) r35;
        if (r36.z1() != 1) goto L99;
        c(0, r36, r14, 1, r17);
    L99:
        r112 = r112 + 1;
    L100:
        int r113 = 0;
    L101:
        if (r113 >= r15) goto L114;
        ConstraintWidget r37 = (ConstraintWidget) r12.get(r113);
        if (r37.l0() == false) goto L113;
        if (a(0, r37) == false) goto L113;
        com.obric.oui.constraintlayout.core.widgets.d.V1(0, r37, r14, f13357a, BasicMeasure.a.f13309k);
        if ((r37 instanceof com.obric.oui.constraintlayout.core.widgets.f) == true) goto L109;
        b(0, r37, r14, r17);
        i(0, r37, r14);
        goto L113
    L109:
        if (((com.obric.oui.constraintlayout.core.widgets.f) r37).u1() != 0) goto L111;
        i(0, r37, r14);
        goto L113
    L111:
        b(0, r37, r14, r17);
    L113:
        r113 = r113 + 1;
        goto L101
    L114:
        return;
    L56:
        r13.J0(0);
        goto L57
    L8:
        r13.I0(0);
        goto L9
    }

    public static void i(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18) {
        if (r17.o0() == false) goto L5;
        return;
    L5:
        f13359c++;
        if ((r17 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L8;
    L12:
        ConstraintAnchor r10 = r17.n(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r11 = r17.n(ConstraintAnchor.Type.BOTTOM);
        int r12 = r10.e();
        int r13 = r11.e();
        if (r10.d() == null) goto L79;
        if (r10.n() == false) goto L79;
        Iterator r14 = r10.d().iterator();
    L18:
        if (r14.hasNext() == false) goto L79;
        ConstraintAnchor r15 = (ConstraintAnchor) r14.next();
        ConstraintWidget r19 = r15.f13243d;
        int r110 = r16 + 1;
        boolean r111 = a(r110, r19);
        if (r19.l0() == false) goto L24;
        if (r111 == false) goto L24;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r110, r19, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
    L24:
        if (r15 != r19.R) goto L30;
        ConstraintAnchor r112 = r19.T.f13245f;
        if (r112 == null) goto L30;
        if (r112.n() == false) goto L30;
    L35:
        boolean r113 = true;
    L37:
        ConstraintWidget.DimensionBehaviour r114 = r19.S();
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r114 != r115) goto L62;
        if (r111 == true) goto L62;
        if (r19.S() != r115) goto L18;
        if (r19.D < 0) goto L18;
        if (r19.C < 0) goto L18;
        if (r19.U() == 8) goto L54;
        if (r19.f13297x != 0) goto L18;
        if (r19.u() != 0.0f) goto L18;
    L54:
        if (r19.j0() == true) goto L18;
        if (r19.k0() == true) goto L18;
        if (r113 == false) goto L18;
        if (r19.j0() == true) goto L18;
        g(r110, r17, r18, r19);
    L62:
        if (r19.l0() == true) goto L18;
        ConstraintAnchor r116 = r19.R;
        if (r15 != r116) goto L69;
        if (r19.T.f13245f != null) goto L69;
        int r20 = r116.f() + r12;
        r19.K0(r20, r19.w() + r20);
        i(r110, r19, r18);
    L69:
        ConstraintAnchor r117 = r19.T;
        if (r15 != r117) goto L74;
        if (r116.f13245f != null) goto L74;
        int r21 = r12 - r117.f();
        r19.K0(r21 - r19.w(), r21);
        i(r110, r19, r18);
    L74:
        if (r113 == false) goto L18;
        if (r19.j0() == true) goto L18;
        f(r110, r18, r19);
    L30:
        if (r15 != r19.T) goto L36;
        ConstraintAnchor r118 = r19.R.f13245f;
        if (r118 == null) goto L36;
        if (r118.n() == true) goto L35;
    L36:
        r113 = false;
    L79:
        if ((r17 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L82;
        return;
    L82:
        if (r11.d() != null) goto L84;
    L147:
        ConstraintAnchor r22 = r17.n(ConstraintAnchor.Type.BASELINE);
        if (r22.d() != null) goto L150;
    L167:
        r17.q0();
        return;
    L150:
        if (r22.n() == false) goto L167;
        int r23 = r22.e();
        Iterator r24 = r22.d().iterator();
    L153:
        if (r24.hasNext() == false) goto L167;
        ConstraintAnchor r25 = (ConstraintAnchor) r24.next();
        ConstraintWidget r26 = r25.f13243d;
        int r27 = r16 + 1;
        boolean r28 = a(r27, r26);
        if (r26.l0() == false) goto L159;
        if (r28 == false) goto L159;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r27, r26, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
    L159:
        if (r26.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L162;
        if (r28 == false) goto L153;
    L162:
        if (r26.l0() == true) goto L153;
        if (r25 != r26.U) goto L153;
        r26.G0(r25.f() + r23);
        i(r27, r26, r18);
        goto L153
    L84:
        if (r11.n() == false) goto L147;
        Iterator r29 = r11.d().iterator();
    L87:
        if (r29.hasNext() == false) goto L147;
        ConstraintAnchor r30 = (ConstraintAnchor) r29.next();
        ConstraintWidget r31 = r30.f13243d;
        int r32 = r16 + 1;
        boolean r119 = a(r32, r31);
        if (r31.l0() == false) goto L93;
        if (r119 == false) goto L93;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r32, r31, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
    L93:
        if (r30 != r31.R) goto L99;
        ConstraintAnchor r120 = r31.T.f13245f;
        if (r120 == null) goto L99;
        if (r120.n() == false) goto L99;
    L104:
        boolean r121 = true;
    L106:
        ConstraintWidget.DimensionBehaviour r122 = r31.S();
        ConstraintWidget.DimensionBehaviour r123 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r122 != r123) goto L131;
        if (r119 == true) goto L131;
        if (r31.S() != r123) goto L87;
        if (r31.D < 0) goto L87;
        if (r31.C < 0) goto L87;
        if (r31.U() == 8) goto L123;
        if (r31.f13297x != 0) goto L87;
        if (r31.u() != 0.0f) goto L87;
    L123:
        if (r31.j0() == true) goto L87;
        if (r31.k0() == true) goto L87;
        if (r121 == false) goto L87;
        if (r31.j0() == true) goto L87;
        g(r32, r17, r18, r31);
    L131:
        if (r31.l0() == true) goto L87;
        ConstraintAnchor r124 = r31.R;
        if (r30 != r124) goto L138;
        if (r31.T.f13245f != null) goto L138;
        int r33 = r124.f() + r13;
        r31.K0(r33, r31.w() + r33);
        i(r32, r31, r18);
    L138:
        ConstraintAnchor r125 = r31.T;
        if (r30 != r125) goto L143;
        if (r124.f13245f != null) goto L143;
        int r34 = r13 - r125.f();
        r31.K0(r34 - r31.w(), r34);
        i(r32, r31, r18);
    L143:
        if (r121 == false) goto L87;
        if (r31.j0() == true) goto L87;
        f(r32, r18, r31);
    L99:
        if (r30 != r31.T) goto L105;
        ConstraintAnchor r126 = r31.R.f13245f;
        if (r126 == null) goto L105;
        if (r126.n() == true) goto L104;
    L105:
        r121 = false;
        goto L106
    L8:
        if (r17.l0() == false) goto L12;
        int r35 = r16 + 1;
        if (a(r35, r17) == false) goto L12;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r35, r17, r18, new BasicMeasure.a(), BasicMeasure.a.f13309k);
        goto L12
    }
}
