package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class BasicMeasure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f13307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.d f13308c;

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r10, a r11);
    }

    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f13309k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f13310l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f13311m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f13312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f13313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13318g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f13319h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f13320i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13321j;

        static {
        }

        public a() {
        }
    }

    public BasicMeasure(com.obric.oui.constraintlayout.core.widgets.d r10) {
        this.f13306a = new ArrayList();
        this.f13307b = new a();
        this.f13308c = r10;
    }

    public final boolean a(Measurer r10, ConstraintWidget r11, int r12) {
        this.f13307b.f13312a = r11.z();
        this.f13307b.f13313b = r11.S();
        this.f13307b.f13314c = r11.V();
        this.f13307b.f13315d = r11.w();
        a r13 = this.f13307b;
        r13.f13320i = false;
        r13.f13321j = r12;
        ConstraintWidget.DimensionBehaviour r14 = r13.f13312a;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L5;
        boolean r16 = true;
    L7:
        if (r13.f13313b != r15) goto L9;
        boolean r17 = true;
    L11:
        if (r16 == true) goto L13;
    L15:
        boolean r18 = false;
    L16:
        if (r17 == true) goto L18;
    L20:
        boolean r19 = false;
    L22:
        if (r18 == true) goto L24;
    L26:
        if (r19 == true) goto L28;
    L30:
        r10.measure(r11, r13);
        r11.m1(this.f13307b.f13316e);
        r11.N0(this.f13307b.f13317f);
        r11.M0(this.f13307b.f13319h);
        r11.C0(this.f13307b.f13318g);
        a r20 = this.f13307b;
        r20.f13321j = a.f13309k;
        return r20.f13320i;
    L28:
        if (r11.f13299y[1] != 4) goto L30;
        r13.f13313b = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r11.f13299y[0] != 4) goto L26;
        r13.f13312a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r11.f13262f0 <= 0.0f) goto L20;
        r19 = true;
        goto L22
    L13:
        if (r11.f13262f0 <= 0.0f) goto L15;
        r18 = true;
        goto L16
    L9:
        r17 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    public final void b(com.obric.oui.constraintlayout.core.widgets.d r13) {
        int r10 = r13.V0.size();
        boolean r11 = r13.W1(64);
        Measurer r12 = r13.L1();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L61;
        ConstraintWidget r15 = (ConstraintWidget) r13.V0.get(r14);
        if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.f) == true) goto L60;
        if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L60;
        if (r15.k0() == true) goto L60;
        if (r11 == false) goto L23;
        i r16 = r15.f13259e;
        if (r16 == null) goto L23;
        k r17 = r15.f13261f;
        if (r17 == null) goto L23;
        if (r16.f13338e.f13331j == false) goto L23;
        if (r17.f13338e.f13331j == true) goto L60;
    L23:
        ConstraintWidget.DimensionBehaviour r18 = r15.t(0);
        boolean r19 = true;
        ConstraintWidget.DimensionBehaviour r20 = r15.t(1);
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 == r21) goto L26;
    L31:
        boolean r110 = false;
    L32:
        if (r110 == false) goto L34;
    L56:
        r19 = r110;
    L57:
        if (r19 == true) goto L60;
        a(r12, r15, a.f13309k);
        goto L60
    L34:
        if (r13.W1(1) == false) goto L56;
        if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.i) == true) goto L56;
        if (r18 == r21) goto L39;
    L44:
        if (r20 == r21) goto L46;
    L51:
        if (r18 == r21) goto L54;
        if (r20 != r21) goto L56;
    L54:
        if (r15.f13262f0 <= 0.0f) goto L56;
    L46:
        if (r15.f13297x != 0) goto L51;
        if (r18 == r21) goto L51;
        if (r15.h0() == true) goto L51;
        r110 = true;
        goto L51
    L39:
        if (r15.f13295w != 0) goto L44;
        if (r20 == r21) goto L44;
        if (r15.h0() == true) goto L44;
        r110 = true;
        goto L44
    L26:
        if (r15.f13295w == 1) goto L31;
        if (r20 != r21) goto L31;
        if (r15.f13297x == 1) goto L31;
        r110 = true;
    L60:
        r14 = r14 + 1;
        goto L3
    L61:
        r12.didMeasures();
    }

    public final void c(com.obric.oui.constraintlayout.core.widgets.d r10, String r11, int r12, int r13, int r14) {
        r10.getClass();
        int r15 = r10.H();
        int r16 = r10.G();
        r10.c1(0);
        r10.b1(0);
        r10.m1(r13);
        r10.N0(r14);
        r10.c1(r15);
        r10.b1(r16);
        this.f13308c.a2(r12);
        this.f13308c.u1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v5, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    public long d(com.obric.oui.constraintlayout.core.widgets.d r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29) {
        BasicMeasure r10 = this;
        Measurer r11 = r20.L1();
        int r12 = r20.V0.size();
        int r13 = r20.V();
        int r14 = r20.w();
        boolean r15 = com.obric.oui.constraintlayout.core.widgets.g.b(r21, 128);
        int r16 = 1;
        if (r15 == false) goto L5;
    L8:
        boolean r17 = true;
    L9:
        if (r17 == false) goto L43;
        int r18 = 0;
    L11:
        if (r18 >= r12) goto L43;
        ConstraintWidget r19 = (ConstraintWidget) r20.V0.get(r18);
        ConstraintWidget.DimensionBehaviour r110 = r19.z();
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 != r111) goto L15;
        boolean r112 = true;
    L17:
        if (r19.S() != r111) goto L19;
        boolean r113 = true;
    L20:
        if (r112 == false) goto L25;
        if (r113 == false) goto L25;
        if (r19.u() <= 0.0f) goto L25;
        boolean r114 = true;
    L27:
        if (r19.h0() == false) goto L31;
        if (r114 == false) goto L31;
    L29:
        r17 = false;
    L31:
        if (r19.j0() == false) goto L35;
        if (r114 == true) goto L29;
    L35:
        if ((r19 instanceof com.obric.oui.constraintlayout.core.widgets.i) == true) goto L29;
        if (r19.h0() == true) goto L29;
        if (r19.j0() == true) goto L29;
        r18 = r18 + 1;
    L25:
        r114 = false;
        goto L27
    L19:
        r113 = false;
        goto L20
    L15:
        r112 = false;
    L43:
        if (r17 == false) goto L46;
        boolean r115 = LinearSystem.f13101s;
    L46:
        if (r24 != 1073741824) goto L48;
        if (r26 != 1073741824) goto L48;
    L49:
        boolean r116 = true;
    L51:
        boolean r30 = r17 & r116;
        int r117 = 2;
        if (r30 == false) goto L80;
        int r118 = Math.min(r20.F(), r25);
        int r119 = Math.min(r20.E(), r27);
        if (r24 == 1073741824) goto L56;
    L58:
        if (r26 == 1073741824) goto L60;
    L62:
        if (r24 != 1073741824) goto L65;
        if (r26 != 1073741824) goto L65;
        boolean r31 = r20.H1(r15);
        int r120 = 2;
        boolean r121 = false;
    L72:
        if (r31 == false) goto L81;
        if (r24 != 1073741824) goto L75;
        boolean r32 = true;
    L76:
        if (r26 != 1073741824) goto L78;
        boolean r33 = true;
    L79:
        r20.r1(r32, r33);
        goto L81
    L78:
        r33 = r121;
        goto L79
    L75:
        r32 = r121;
    L81:
        if (r31 == false) goto L83;
        if (r120 != 2) goto L83;
        return 0;
    L83:
        int r34 = r20.M1();
        if (r12 <= 0) goto L86;
        b(r20);
    L86:
        e(r20);
        int r35 = r10.f13306a.size();
        if (r12 <= 0) goto L89;
        c(r20, "First pass", 0, r13, r14);
    L89:
        if (r35 <= 0) goto L175;
        ConstraintWidget.DimensionBehaviour r36 = r20.z();
        ConstraintWidget.DimensionBehaviour r37 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r36 != r37) goto L93;
        boolean r38 = true;
    L95:
        if (r20.S() != r37) goto L97;
        boolean r39 = true;
    L98:
        int r122 = Math.max(r20.V(), r10.f13308c.H());
        int r123 = Math.max(r20.w(), r10.f13308c.G());
        boolean r124 = r121;
        ?? r125 = r124;
        ?? r126 = r124;
    L99:
        if (r126 >= r35) goto L121;
        ConstraintWidget r127 = (ConstraintWidget) r10.f13306a.get(r126);
        if ((r127 instanceof com.obric.oui.constraintlayout.core.widgets.i) == true) goto L103;
        int r40 = r16;
    L120:
        r34 = r34;
        r16 = r40;
        r117 = 2;
        r126 = r126 + r40;
        r125 = r125;
        goto L99
    L103:
        int r128 = r127.V();
        int r129 = r127.w();
        int r41 = (r125 == true ? 1 : 0) | (r10.a(r11, r127, a.f13310l) ? 1 : 0);
        int r42 = r127.V();
        int r43 = r127.w();
        if (r42 == r128) goto L111;
        r127.m1(r42);
        if (r38 == true) goto L108;
    L110:
        int r44 = 1;
    L112:
        if (r43 == r129) goto L119;
        r127.N0(r43);
        if (r39 == true) goto L116;
    L118:
        r44 = 1;
        goto L119
    L116:
        if (r127.q() <= r123) goto L118;
        r123 = Math.max(r123, r127.q() + r127.n(ConstraintAnchor.Type.BOTTOM).f());
    L119:
        r125 = r44 | (((com.obric.oui.constraintlayout.core.widgets.i) r127).H1() ? 1 : 0);
        r40 = 1;
        goto L120
    L108:
        if (r127.L() <= r122) goto L110;
        r122 = Math.max(r122, r127.L() + r127.n(ConstraintAnchor.Type.RIGHT).f());
        goto L110
    L111:
        r44 = r41;
        goto L112
    L121:
        int r210 = r34;
        int r45 = r117;
        int r46 = 0;
        ?? r130 = r125;
    L122:
        if (r46 >= r45) goto L174;
        int r131 = 0;
        ?? r132 = r130;
    L124:
        if (r131 >= r35) goto L171;
        ConstraintWidget r133 = (ConstraintWidget) r10.f13306a.get(r131);
        if ((r133 instanceof Helper) == false) goto L130;
        if ((r133 instanceof com.obric.oui.constraintlayout.core.widgets.i) == true) goto L130;
    L143:
        boolean r134 = r30;
        ?? r135 = r132;
    L144:
        int r47 = 1;
    L170:
        r131 = r131 + r47;
        r10 = this;
        r30 = r134;
        r132 = r135;
    L130:
        if ((r133 instanceof com.obric.oui.constraintlayout.core.widgets.f) == true) goto L143;
        if (r133.U() == 8) goto L143;
        if (r30 == false) goto L142;
        if (r133.f13259e.f13338e.f13331j == false) goto L142;
        if (r133.f13261f.f13338e.f13331j == true) goto L143;
    L142:
        if ((r133 instanceof com.obric.oui.constraintlayout.core.widgets.i) == true) goto L143;
        int r136 = r133.V();
        int r137 = r133.w();
        int r48 = r133.o();
        int r138 = a.f13310l;
        r134 = r30;
        if (r46 != 1) goto L148;
        r138 = a.f13311m;
    L148:
        int r49 = (r132 == true ? 1 : 0) | (r10.a(r11, r133, r138) ? 1 : 0);
        int r50 = r133.V();
        int r51 = r133.w();
        if (r50 == r136) goto L156;
        r133.m1(r50);
        if (r38 == true) goto L153;
    L155:
        int r52 = 1;
    L157:
        if (r51 == r137) goto L165;
        r133.N0(r51);
        if (r39 == true) goto L161;
    L163:
        r52 = 1;
        goto L165
    L161:
        if (r133.q() <= r123) goto L163;
        r123 = Math.max(r123, r133.q() + r133.n(ConstraintAnchor.Type.BOTTOM).f());
    L165:
        if (r133.Y() == true) goto L167;
    L169:
        r135 = r52;
        goto L144
    L167:
        if (r48 == r133.o()) goto L169;
        r47 = 1;
        r135 = 1;
        goto L170
    L153:
        if (r133.L() <= r122) goto L155;
        r122 = Math.max(r122, r133.L() + r133.n(ConstraintAnchor.Type.RIGHT).f());
        goto L155
    L156:
        r52 = r49;
        goto L157
    L171:
        boolean r139 = r30;
        if (r132 == 0) goto L174;
        r46 = r46 + 1;
        c(r20, "intermediate pass", r46, r13, r14);
        r45 = 2;
        r130 = 0;
        r10 = this;
        r30 = r139;
    L174:
        int r53 = r210;
    L176:
        r20.Z1(r53);
        return 0;
    L97:
        r39 = r121;
        goto L98
    L93:
        r38 = r121;
        goto L95
    L175:
        r53 = r34;
    L65:
        boolean r140 = r20.I1(r15);
        r121 = false;
        if (r24 != 1073741824) goto L68;
        r140 = r140 & r20.J1(r15, 0);
        r120 = 1;
    L69:
        if (r26 != 1073741824) goto L71;
        r31 = r20.J1(r15, 1) & r140;
        r120 = r120 + 1;
        goto L72
    L71:
        r31 = r140;
        goto L72
    L68:
        r120 = 0;
        goto L69
    L60:
        if (r20.w() == r119) goto L62;
        r20.N0(r119);
        r20.P1();
        goto L62
    L56:
        if (r20.V() == r118) goto L58;
        r20.m1(r118);
        r20.P1();
        goto L58
    L80:
        r121 = false;
        r31 = false;
        r120 = 0;
    L48:
        if (r15 == true) goto L49;
        r116 = false;
        goto L51
    L5:
        if (com.obric.oui.constraintlayout.core.widgets.g.b(r21, 64) == true) goto L8;
        r17 = false;
        goto L9
    }

    public void e(com.obric.oui.constraintlayout.core.widgets.d r10) {
        this.f13306a.clear();
        int r11 = r10.V0.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = (ConstraintWidget) r10.V0.get(r12);
        ConstraintWidget.DimensionBehaviour r14 = r13.z();
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L7;
    L8:
        this.f13306a.add(r13);
    L9:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13.S() != r15) goto L9;
    L10:
        r10.P1();
    }
}
