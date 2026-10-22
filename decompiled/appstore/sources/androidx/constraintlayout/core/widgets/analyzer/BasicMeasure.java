package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BasicMeasure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintWidgetContainer f1515c;

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r10, a r11);
    }

    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f1516k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f1517l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f1518m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f1519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f1520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1522d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1523e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1524f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1525g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1526h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1527i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1528j;

        static {
        }

        public a() {
        }
    }

    public BasicMeasure(ConstraintWidgetContainer r10) {
        this.f1513a = new ArrayList();
        this.f1514b = new a();
        this.f1515c = r10;
    }

    public final boolean a(Measurer r10, ConstraintWidget r11, int r12) {
        this.f1514b.f1519a = r11.z();
        this.f1514b.f1520b = r11.S();
        this.f1514b.f1521c = r11.V();
        this.f1514b.f1522d = r11.w();
        a r13 = this.f1514b;
        r13.f1527i = false;
        r13.f1528j = r12;
        ConstraintWidget.DimensionBehaviour r14 = r13.f1519a;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L5;
        boolean r16 = true;
    L7:
        if (r13.f1520b != r15) goto L9;
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
        r11.l1(this.f1514b.f1523e);
        r11.M0(this.f1514b.f1524f);
        r11.L0(this.f1514b.f1526h);
        r11.B0(this.f1514b.f1525g);
        a r20 = this.f1514b;
        r20.f1528j = a.f1516k;
        return r20.f1527i;
    L28:
        if (r11.f1480y[1] != 4) goto L30;
        r13.f1520b = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r11.f1480y[0] != 4) goto L26;
        r13.f1519a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r11.f1443f0 <= 0.0f) goto L20;
        r19 = true;
        goto L22
    L13:
        if (r11.f1443f0 <= 0.0f) goto L15;
        r18 = true;
        goto L16
    L9:
        r17 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    public final void b(ConstraintWidgetContainer r13) {
        int r10 = r13.V0.size();
        boolean r11 = r13.V1(64);
        Measurer r12 = r13.K1();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L63;
        ConstraintWidget r15 = (ConstraintWidget) r13.V0.get(r14);
        if ((r15 instanceof androidx.constraintlayout.core.widgets.e) == true) goto L62;
        if ((r15 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L62;
        if (r15.k0() == true) goto L62;
        if (r11 == false) goto L23;
        i r16 = r15.f1440e;
        if (r16 == null) goto L23;
        k r17 = r15.f1442f;
        if (r17 == null) goto L23;
        if (r16.f1545e.f1538j == false) goto L23;
        if (r17.f1545e.f1538j == true) goto L62;
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
        if (r19 == true) goto L62;
        a(r12, r15, a.f1516k);
        Metrics r22 = r13.f1487b1;
        if (r22 == null) goto L62;
        r22.f1286a++;
        goto L62
    L34:
        if (r13.V1(1) == false) goto L56;
        if ((r15 instanceof androidx.constraintlayout.core.widgets.h) == true) goto L56;
        if (r18 == r21) goto L39;
    L44:
        if (r20 == r21) goto L46;
    L51:
        if (r18 == r21) goto L54;
        if (r20 != r21) goto L56;
    L54:
        if (r15.f1443f0 <= 0.0f) goto L56;
    L46:
        if (r15.f1478x != 0) goto L51;
        if (r18 == r21) goto L51;
        if (r15.h0() == true) goto L51;
        r110 = true;
        goto L51
    L39:
        if (r15.f1476w != 0) goto L44;
        if (r20 == r21) goto L44;
        if (r15.h0() == true) goto L44;
        r110 = true;
        goto L44
    L26:
        if (r15.f1476w == 1) goto L31;
        if (r20 != r21) goto L31;
        if (r15.f1478x == 1) goto L31;
        r110 = true;
    L62:
        r14 = r14 + 1;
        goto L3
    L63:
        r12.didMeasures();
    }

    public final void c(ConstraintWidgetContainer r10, String r11, int r12, int r13, int r14) {
        int r15 = r10.H();
        int r16 = r10.G();
        r10.b1(0);
        r10.a1(0);
        r10.l1(r13);
        r10.M0(r14);
        r10.b1(r15);
        r10.a1(r16);
        this.f1515c.Z1(r12);
        this.f1515c.t1();
    }

    public long d(ConstraintWidgetContainer r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        Measurer r10 = r24.K1();
        int r11 = r24.V0.size();
        int r12 = r24.V();
        int r13 = r24.w();
        boolean r14 = androidx.constraintlayout.core.widgets.f.b(r25, 128);
        if (r14 == false) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L44;
        int r16 = 0;
    L11:
        if (r16 >= r11) goto L44;
        ConstraintWidget r17 = (ConstraintWidget) r24.V0.get(r16);
        ConstraintWidget.DimensionBehaviour r18 = r17.z();
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 != r19) goto L15;
        boolean r110 = true;
    L17:
        if (r17.S() != r19) goto L19;
        boolean r111 = true;
    L20:
        if (r110 == false) goto L25;
        if (r111 == false) goto L25;
        if (r17.u() <= 0.0f) goto L25;
        boolean r112 = true;
    L27:
        if (r17.h0() == false) goto L31;
        if (r112 == false) goto L31;
    L29:
        r15 = false;
    L31:
        if (r17.j0() == false) goto L35;
        if (r112 == true) goto L29;
    L35:
        if ((r17 instanceof androidx.constraintlayout.core.widgets.h) == true) goto L29;
        if (r17.h0() == true) goto L29;
        if (r17.j0() == true) goto L29;
        r16 = r16 + 1;
    L25:
        r112 = false;
        goto L27
    L19:
        r111 = false;
        goto L20
    L15:
        r110 = false;
    L44:
        if (r15 == false) goto L49;
        Metrics r113 = LinearSystem.f1265x;
        if (r113 == null) goto L49;
        r113.f1288c++;
    L49:
        if (r28 != 1073741824) goto L51;
        if (r30 != 1073741824) goto L51;
    L52:
        boolean r114 = true;
    L54:
        boolean r20 = r15 & r114;
        int r115 = 2;
        if (r20 == false) goto L83;
        int r116 = Math.min(r24.F(), r29);
        int r117 = Math.min(r24.E(), r31);
        if (r28 == 1073741824) goto L59;
    L61:
        if (r30 == 1073741824) goto L63;
    L65:
        if (r28 != 1073741824) goto L68;
        if (r30 != 1073741824) goto L68;
        boolean r21 = r24.G1(r14);
        int r118 = 2;
    L75:
        if (r21 == false) goto L84;
        if (r28 != 1073741824) goto L78;
        boolean r119 = true;
    L79:
        if (r30 != 1073741824) goto L81;
        boolean r22 = true;
    L82:
        r24.q1(r119, r22);
        goto L84
    L81:
        r22 = false;
        goto L82
    L78:
        r119 = false;
    L84:
        if (r21 == false) goto L86;
        if (r118 != 2) goto L86;
        return 0;
    L86:
        int r23 = r24.L1();
        if (r11 <= 0) goto L89;
        b(r24);
    L89:
        e(r24);
        int r34 = this.f1513a.size();
        if (r11 <= 0) goto L92;
        c(r24, "First pass", 0, r12, r13);
    L92:
        if (r34 <= 0) goto L183;
        ConstraintWidget.DimensionBehaviour r35 = r24.z();
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r35 != r36) goto L96;
        boolean r120 = true;
    L98:
        if (r24.S() != r36) goto L100;
        boolean r37 = true;
    L101:
        int r38 = Math.max(r24.V(), this.f1515c.H());
        int r121 = Math.max(r24.w(), this.f1515c.G());
        int r122 = 0;
        boolean r123 = false;
    L102:
        if (r122 >= r34) goto L127;
        ConstraintWidget r124 = (ConstraintWidget) this.f1513a.get(r122);
        if ((r124 instanceof androidx.constraintlayout.core.widgets.h) == false) goto L126;
        int r125 = r124.V();
        int r39 = r124.w();
        boolean r40 = a(r10, r124, a.f1517l) | r123;
        Metrics r126 = r24.f1487b1;
        if (r126 == null) goto L109;
        r126.f1287b++;
    L109:
        int r41 = r124.V();
        int r42 = r124.w();
        if (r41 == r125) goto L117;
        r124.l1(r41);
        if (r120 == true) goto L114;
    L116:
        boolean r43 = true;
    L118:
        if (r42 == r39) goto L125;
        r124.M0(r42);
        if (r37 == true) goto L122;
    L124:
        r43 = true;
        goto L125
    L122:
        if (r124.q() <= r121) goto L124;
        r121 = Math.max(r121, r124.q() + r124.n(ConstraintAnchor.Type.BOTTOM).f());
    L125:
        r123 = r43 | ((androidx.constraintlayout.core.widgets.h) r124).G1();
        goto L126
    L114:
        if (r124.L() <= r38) goto L116;
        r38 = Math.max(r38, r124.L() + r124.n(ConstraintAnchor.Type.RIGHT).f());
        goto L116
    L117:
        r43 = r40;
    L126:
        r122 = r122 + 1;
        r23 = r23;
        r13 = r13;
        r12 = r12;
        r115 = 2;
        goto L102
    L127:
        int r310 = r23;
        int r127 = r12;
        int r128 = r13;
        int r44 = r115;
        int r45 = 0;
    L128:
        if (r45 >= r44) goto L182;
        int r46 = 0;
    L130:
        if (r46 >= r34) goto L179;
        ConstraintWidget r129 = (ConstraintWidget) this.f1513a.get(r46);
        if ((r129 instanceof Helper) == false) goto L136;
        if ((r129 instanceof androidx.constraintlayout.core.widgets.h) == true) goto L136;
    L149:
        boolean r210 = r20;
        int r211 = r34;
        Measurer r212 = r10;
    L178:
        r46 = r46 + 1;
        r10 = r212;
        r20 = r210;
        r34 = r211;
    L136:
        if ((r129 instanceof androidx.constraintlayout.core.widgets.e) == true) goto L149;
        if (r129.U() == 8) goto L149;
        if (r20 == false) goto L148;
        if (r129.f1440e.f1545e.f1538j == false) goto L148;
        if (r129.f1442f.f1545e.f1538j == true) goto L149;
    L148:
        if ((r129 instanceof androidx.constraintlayout.core.widgets.h) == true) goto L149;
        int r130 = r129.V();
        int r131 = r129.w();
        int r47 = r129.o();
        int r213 = a.f1517l;
        r210 = r20;
        if (r45 != 1) goto L153;
        r213 = a.f1518m;
    L153:
        boolean r48 = a(r10, r129, r213) | r123;
        Metrics r132 = r24.f1487b1;
        r211 = r34;
        r212 = r10;
        if (r132 == null) goto L157;
        r132.f1287b++;
    L157:
        int r49 = r129.V();
        int r50 = r129.w();
        if (r49 == r130) goto L165;
        r129.l1(r49);
        if (r120 == true) goto L162;
    L164:
        r48 = true;
        goto L165
    L162:
        if (r129.L() <= r38) goto L164;
        r38 = Math.max(r38, r129.L() + r129.n(ConstraintAnchor.Type.RIGHT).f());
    L165:
        if (r50 == r131) goto L173;
        r129.M0(r50);
        if (r37 == true) goto L169;
    L171:
        r48 = true;
        goto L173
    L169:
        if (r129.q() <= r121) goto L171;
        r121 = Math.max(r121, r129.q() + r129.n(ConstraintAnchor.Type.BOTTOM).f());
    L173:
        if (r129.Y() == true) goto L175;
    L177:
        r123 = r48;
        goto L178
    L175:
        if (r47 == r129.o()) goto L177;
        r123 = true;
        goto L178
    L179:
        boolean r214 = r20;
        int r215 = r34;
        Measurer r216 = r10;
        if (r123 == false) goto L182;
        r45 = r45 + 1;
        c(r24, "intermediate pass", r45, r127, r128);
        r10 = r216;
        r20 = r214;
        r34 = r215;
        r44 = 2;
        r123 = false;
    L182:
        int r51 = r310;
    L184:
        r24.Y1(r51);
        return 0;
    L100:
        r37 = false;
        goto L101
    L96:
        r120 = false;
        goto L98
    L183:
        r51 = r23;
    L68:
        boolean r133 = r24.H1(r14);
        if (r28 != 1073741824) goto L71;
        r133 = r133 & r24.I1(r14, 0);
        r118 = 1;
    L72:
        if (r30 != 1073741824) goto L74;
        r21 = r24.I1(r14, 1) & r133;
        r118 = r118 + 1;
        goto L75
    L74:
        r21 = r133;
        goto L75
    L71:
        r118 = 0;
        goto L72
    L63:
        if (r24.w() == r117) goto L65;
        r24.M0(r117);
        r24.O1();
        goto L65
    L59:
        if (r24.V() == r116) goto L61;
        r24.l1(r116);
        r24.O1();
        goto L61
    L83:
        r21 = false;
        r118 = 0;
    L51:
        if (r14 == true) goto L52;
        r114 = false;
        goto L54
    L5:
        if (androidx.constraintlayout.core.widgets.f.b(r25, 64) == true) goto L8;
        r15 = false;
        goto L9
    }

    public void e(ConstraintWidgetContainer r10) {
        this.f1513a.clear();
        int r11 = r10.V0.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = (ConstraintWidget) r10.V0.get(r12);
        ConstraintWidget.DimensionBehaviour r14 = r13.z();
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L7;
    L8:
        this.f1513a.add(r13);
    L9:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13.S() != r15) goto L9;
    L10:
        r10.O1();
    }
}
