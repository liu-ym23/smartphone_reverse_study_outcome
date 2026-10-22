package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d extends h {
    public int A1;
    public int B1;
    public int C1;
    public ArrayList D1;
    public ConstraintWidget[] E1;
    public ConstraintWidget[] F1;
    public int[] G1;
    public ConstraintWidget[] H1;
    public int I1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f1617k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public int f1618l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public int f1619m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public int f1620n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f1621o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f1622p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public float f1623q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public float f1624r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public float f1625s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public float f1626t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public float f1627u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f1628v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public int f1629w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f1630x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f1631y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public int f1632z1;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget f1634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f1636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f1637e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f1638f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f1639g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1640h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1641i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1642j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1643k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1644l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1645m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1646n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1647o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1648p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1649q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ d f1650r;

        public a(d r10, int r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, ConstraintAnchor r15, int r16) {
            this.f1650r = r10;
            this.f1634b = null;
            this.f1635c = 0;
            this.f1640h = 0;
            this.f1641i = 0;
            this.f1642j = 0;
            this.f1643k = 0;
            this.f1644l = 0;
            this.f1645m = 0;
            this.f1646n = 0;
            this.f1647o = 0;
            this.f1648p = 0;
            this.f1649q = 0;
            this.f1633a = r11;
            this.f1636d = r12;
            this.f1637e = r13;
            this.f1638f = r14;
            this.f1639g = r15;
            this.f1640h = r10.A1();
            this.f1641i = r10.C1();
            this.f1642j = r10.B1();
            this.f1643k = r10.z1();
            this.f1649q = r16;
        }

        public static /* synthetic */ ConstraintWidget a(a r10) {
            return r10.f1634b;
        }

        public void b(ConstraintWidget r10) {
            int r11 = 0;
            if (this.f1633a != 0) goto L16;
            int r12 = d.c2(this.f1650r, r10, this.f1649q);
            if (r10.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.f1648p++;
            r12 = 0;
        L7:
            int r13 = d.Q1(this.f1650r);
            if (r10.U() == 8) goto L11;
            r11 = r13;
        L11:
            this.f1644l += r12 + r11;
            int r14 = d.d2(this.f1650r, r10, this.f1649q);
            if (this.f1634b != null) goto L14;
        L15:
            this.f1634b = r10;
            this.f1635c = r14;
            this.f1645m = r14;
        L28:
            this.f1647o++;
            return;
        L14:
            if (this.f1635c >= r14) goto L28;
        L16:
            int r15 = d.c2(this.f1650r, r10, this.f1649q);
            int r16 = d.d2(this.f1650r, r10, this.f1649q);
            if (r10.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.f1648p++;
            r16 = 0;
        L19:
            int r17 = d.R1(this.f1650r);
            if (r10.U() == 8) goto L23;
            r11 = r17;
        L23:
            this.f1645m += r16 + r11;
            if (this.f1634b != null) goto L26;
        L27:
            this.f1634b = r10;
            this.f1635c = r15;
            this.f1644l = r15;
            goto L28
        L26:
            if (this.f1635c >= r15) goto L28;
            goto L27
        }

        public void c() {
            this.f1635c = 0;
            this.f1634b = null;
            this.f1644l = 0;
            this.f1645m = 0;
            this.f1646n = 0;
            this.f1647o = 0;
            this.f1648p = 0;
        }

        public void d(boolean r17, int r18, boolean r19) {
            int r10 = this.f1647o;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            if ((this.f1646n + r11) >= d.e2(this.f1650r)) goto L11;
            ConstraintWidget r12 = d.f2(this.f1650r)[this.f1646n + r11];
            if (r12 == null) goto L10;
            r12.u0();
        L10:
            r11 = r11 + 1;
        L11:
            if (r10 != 0) goto L13;
            return;
        L13:
            if (this.f1634b == null) goto L222;
            if (r19 == false) goto L18;
            if (r18 != 0) goto L18;
            boolean r13 = true;
        L19:
            int r14 = 0;
            int r15 = -1;
            int r16 = -1;
        L20:
            if (r14 >= r10) goto L35;
            if (r17 == false) goto L23;
            int r20 = (r10 - 1) - r14;
        L25:
            if ((this.f1646n + r20) >= d.e2(this.f1650r)) goto L35;
            ConstraintWidget r21 = d.f2(this.f1650r)[this.f1646n + r20];
            if (r21 == null) goto L34;
            if (r21.U() != 0) goto L34;
            if (r15 != (-1)) goto L33;
            r15 = r14;
        L33:
            r16 = r14;
        L34:
            r14 = r14 + 1;
            goto L20
        L23:
            r20 = r14;
        L35:
            ConstraintWidget r22 = null;
            if (this.f1633a != 0) goto L127;
            ConstraintWidget r23 = this.f1634b;
            r23.f1(d.g2(this.f1650r));
            int r110 = this.f1641i;
            if (r18 <= 0) goto L40;
            r110 = r110 + d.R1(this.f1650r);
        L40:
            r23.R.a(this.f1637e, r110);
            if (r19 == false) goto L43;
            r23.T.a(this.f1639g, this.f1643k);
        L43:
            if (r18 <= 0) goto L45;
            this.f1637e.f1424d.T.a(r23.R, 0);
        L45:
            char r111 = 3;
            if (d.h2(this.f1650r) == 3) goto L48;
        L61:
            ConstraintWidget r112 = r23;
        L62:
            int r113 = 0;
        L63:
            if (r113 >= r10) goto L223;
            if (r17 == false) goto L66;
            int r114 = (r10 - 1) - r113;
        L68:
            if ((this.f1646n + r114) >= d.e2(this.f1650r)) goto L224;
            ConstraintWidget r115 = d.f2(this.f1650r)[this.f1646n + r114];
            if (r115 != null) goto L73;
            r115 = r22;
            char r24 = r111;
        L126:
            r113 = r113 + 1;
            r111 = r24;
            r22 = r115;
            goto L63
        L73:
            if (r113 != 0) goto L75;
            r115.i(r115.Q, this.f1636d, this.f1640h);
        L75:
            if (r114 != 0) goto L98;
            int r25 = d.i2(this.f1650r);
            float r116 = d.j2(this.f1650r);
            if (r17 == false) goto L80;
            r116 = 1.0f - r116;
        L80:
            if (this.f1646n == 0) goto L82;
        L89:
            if (r19 == true) goto L91;
        L96:
            r115.O0(r25);
            r115.N0(r116);
            goto L98
        L91:
            if (d.U1(this.f1650r) == (-1)) goto L96;
            r25 = d.U1(this.f1650r);
            if (r17 == false) goto L95;
            float r117 = d.V1(this.f1650r);
        L86:
            float r118 = 1.0f - r117;
        L87:
            r116 = r118;
            goto L96
        L95:
            r118 = d.V1(this.f1650r);
            goto L87
        L82:
            if (d.S1(this.f1650r) == (-1)) goto L89;
            r25 = d.S1(this.f1650r);
            if (r17 == false) goto L88;
            r117 = d.T1(this.f1650r);
            goto L86
        L88:
            r118 = d.T1(this.f1650r);
        L98:
            if (r113 != (r10 - 1)) goto L100;
            r115.i(r115.S, this.f1638f, this.f1642j);
        L100:
            if (r22 == null) goto L107;
            r115.Q.a(r22.S, d.Q1(this.f1650r));
            if (r113 != r15) goto L104;
            r115.Q.u(this.f1640h);
        L104:
            r22.S.a(r115.Q, 0);
            if (r113 != (r16 + 1)) goto L107;
            r22.S.u(this.f1642j);
        L107:
            if (r115 == r23) goto L125;
            r24 = 3;
            if (d.h2(this.f1650r) == 3) goto L111;
        L116:
            int r26 = d.h2(this.f1650r);
            if (r26 != 0) goto L119;
            r115.R.a(r23.R, 0);
            goto L126
        L119:
            if (r26 == 1) goto L123;
            if (r13 == false) goto L122;
            r115.R.a(this.f1637e, this.f1641i);
            r115.T.a(this.f1639g, this.f1643k);
            goto L126
        L122:
            r115.R.a(r23.R, 0);
            r115.T.a(r23.T, 0);
            goto L126
        L123:
            r115.T.a(r23.T, 0);
            goto L126
        L111:
            if (r112.Y() == false) goto L116;
            if (r115 == r112) goto L116;
            if (r115.Y() == false) goto L116;
            r115.U.a(r112.U, 0);
            goto L126
        L125:
            r24 = 3;
            goto L126
        L224:
            return;
        L66:
            r114 = r113;
            goto L68
        L223:
            return;
        L48:
            if (r23.Y() == true) goto L61;
            int r119 = 0;
        L50:
            if (r119 >= r10) goto L61;
            if (r17 == false) goto L53;
            int r120 = (r10 - 1) - r119;
        L55:
            if ((this.f1646n + r120) >= d.e2(this.f1650r)) goto L61;
            r112 = d.f2(this.f1650r)[this.f1646n + r120];
            if (r112.Y() == true) goto L62;
            r119 = r119 + 1;
            goto L50
        L53:
            r120 = r119;
            goto L55
        L127:
            ConstraintWidget r27 = this.f1634b;
            r27.O0(d.i2(this.f1650r));
            int r28 = this.f1640h;
            if (r18 <= 0) goto L130;
            r28 = r28 + d.Q1(this.f1650r);
        L130:
            if (r17 == false) goto L136;
            r27.S.a(this.f1638f, r28);
            if (r19 == false) goto L134;
            r27.Q.a(this.f1636d, this.f1642j);
        L134:
            if (r18 <= 0) goto L141;
            this.f1638f.f1424d.Q.a(r27.S, 0);
        L141:
            int r29 = 0;
        L142:
            if (r29 >= r10) goto L225;
            if ((this.f1646n + r29) >= d.e2(this.f1650r)) goto L226;
            ConstraintWidget r121 = d.f2(this.f1650r)[this.f1646n + r29];
            if (r121 == null) goto L195;
            if (r29 != 0) goto L161;
            r121.i(r121.R, this.f1637e, this.f1641i);
            int r122 = d.g2(this.f1650r);
            float r123 = d.W1(this.f1650r);
            if (this.f1646n == 0) goto L153;
        L155:
            if (r19 == true) goto L157;
        L159:
            r121.f1(r122);
            r121.e1(r123);
            goto L161
        L157:
            if (d.Z1(this.f1650r) == (-1)) goto L159;
            r122 = d.Z1(this.f1650r);
            r123 = d.a2(this.f1650r);
            goto L159
        L153:
            if (d.X1(this.f1650r) == (-1)) goto L155;
            r122 = d.X1(this.f1650r);
            r123 = d.Y1(this.f1650r);
        L161:
            if (r29 != (r10 - 1)) goto L163;
            r121.i(r121.T, this.f1639g, this.f1643k);
        L163:
            if (r22 == null) goto L170;
            r121.R.a(r22.T, d.R1(this.f1650r));
            if (r29 != r15) goto L167;
            r121.R.u(this.f1641i);
        L167:
            r22.T.a(r121.R, 0);
            if (r29 != (r16 + 1)) goto L170;
            r22.T.u(this.f1643k);
        L170:
            if (r121 == r27) goto L194;
            if (r17 == false) goto L183;
            int r124 = d.b2(this.f1650r);
            if (r124 != 0) goto L176;
            r121.S.a(r27.S, 0);
            goto L194
        L176:
            if (r124 == 1) goto L180;
            if (r124 != 2) goto L194;
            r121.Q.a(r27.Q, 0);
            r121.S.a(r27.S, 0);
            goto L194
        L180:
            r121.Q.a(r27.Q, 0);
            goto L194
        L183:
            int r125 = d.b2(this.f1650r);
            if (r125 != 0) goto L186;
            r121.Q.a(r27.Q, 0);
            goto L194
        L186:
            if (r125 == 1) goto L192;
            if (r125 != 2) goto L194;
            if (r13 == false) goto L191;
            r121.Q.a(this.f1636d, this.f1640h);
            r121.S.a(this.f1638f, this.f1642j);
            goto L194
        L191:
            r121.Q.a(r27.Q, 0);
            r121.S.a(r27.S, 0);
            goto L194
        L192:
            r121.S.a(r27.S, 0);
        L194:
            r22 = r121;
        L195:
            r29 = r29 + 1;
            goto L142
        L226:
            return;
        L225:
            return;
        L136:
            r27.Q.a(this.f1636d, r28);
            if (r19 == false) goto L139;
            r27.S.a(this.f1638f, this.f1642j);
        L139:
            if (r18 <= 0) goto L141;
            this.f1636d.f1424d.S.a(r27.Q, 0);
        L18:
            r13 = false;
            goto L19
        }

        public int e() {
            if (this.f1633a != 1) goto L7;
            return this.f1645m - d.R1(this.f1650r);
        L7:
            return this.f1645m;
        }

        public int f() {
            if (this.f1633a != 0) goto L7;
            return this.f1644l - d.Q1(this.f1650r);
        L7:
            return this.f1644l;
        }

        public void g(int r10) {
            int r11 = this.f1648p;
            if (r11 != 0) goto L5;
            return;
        L5:
            int r12 = this.f1647o;
            int r13 = r10 / r11;
            int r14 = 0;
        L6:
            if (r14 >= r12) goto L25;
            if ((this.f1646n + r14) >= d.e2(this.f1650r)) goto L25;
            ConstraintWidget r15 = d.f2(this.f1650r)[this.f1646n + r14];
            if (this.f1633a != 0) goto L18;
            if (r15 == null) goto L24;
            if (r15.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r15.f1476w != 0) goto L24;
            this.f1650r.E1(r15, ConstraintWidget.DimensionBehaviour.FIXED, r13, r15.S(), r15.w());
        L24:
            r14 = r14 + 1;
            goto L6
        L18:
            if (r15 == null) goto L24;
            if (r15.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r15.f1478x != 0) goto L24;
            this.f1650r.E1(r15, r15.z(), r15.V(), ConstraintWidget.DimensionBehaviour.FIXED, r13);
        L25:
            h();
        }

        public final void h() {
            this.f1644l = 0;
            this.f1645m = 0;
            this.f1634b = null;
            this.f1635c = 0;
            int r10 = this.f1647o;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L26;
            if ((this.f1646n + r11) >= d.e2(this.f1650r)) goto L33;
            ConstraintWidget r12 = d.f2(this.f1650r)[this.f1646n + r11];
            if (this.f1633a != 0) goto L17;
            int r13 = r12.V();
            int r14 = d.Q1(this.f1650r);
            if (r12.U() != 8) goto L12;
            r14 = 0;
        L12:
            this.f1644l += r13 + r14;
            int r15 = d.d2(this.f1650r, r12, this.f1649q);
            if (this.f1634b != null) goto L15;
        L16:
            this.f1634b = r12;
            this.f1635c = r15;
            this.f1645m = r15;
        L25:
            r11 = r11 + 1;
            goto L3
        L15:
            if (this.f1635c >= r15) goto L25;
        L17:
            int r16 = d.c2(this.f1650r, r12, this.f1649q);
            int r17 = d.d2(this.f1650r, r12, this.f1649q);
            int r18 = d.R1(this.f1650r);
            if (r12.U() != 8) goto L20;
            r18 = 0;
        L20:
            this.f1645m += r17 + r18;
            if (this.f1634b != null) goto L23;
        L24:
            this.f1634b = r12;
            this.f1635c = r16;
            this.f1644l = r16;
            goto L25
        L23:
            if (this.f1635c >= r16) goto L25;
        L33:
            return;
        }

        public void i(int r10) {
            this.f1646n = r10;
        }

        public void j(int r10, ConstraintAnchor r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, int r15, int r16, int r17, int r18, int r19) {
            this.f1633a = r10;
            this.f1636d = r11;
            this.f1637e = r12;
            this.f1638f = r13;
            this.f1639g = r14;
            this.f1640h = r15;
            this.f1641i = r16;
            this.f1642j = r17;
            this.f1643k = r18;
            this.f1649q = r19;
        }
    }

    public d() {
        this.f1617k1 = -1;
        this.f1618l1 = -1;
        this.f1619m1 = -1;
        this.f1620n1 = -1;
        this.f1621o1 = -1;
        this.f1622p1 = -1;
        this.f1623q1 = 0.5f;
        this.f1624r1 = 0.5f;
        this.f1625s1 = 0.5f;
        this.f1626t1 = 0.5f;
        this.f1627u1 = 0.5f;
        this.f1628v1 = 0.5f;
        this.f1629w1 = 0;
        this.f1630x1 = 0;
        this.f1631y1 = 2;
        this.f1632z1 = 2;
        this.A1 = 0;
        this.B1 = -1;
        this.C1 = 0;
        this.D1 = new ArrayList();
        this.E1 = null;
        this.F1 = null;
        this.G1 = null;
        this.I1 = 0;
    }

    public static /* synthetic */ int Q1(d r10) {
        return r10.f1629w1;
    }

    public static /* synthetic */ int R1(d r10) {
        return r10.f1630x1;
    }

    public static /* synthetic */ int S1(d r10) {
        return r10.f1619m1;
    }

    public static /* synthetic */ float T1(d r10) {
        return r10.f1625s1;
    }

    public static /* synthetic */ int U1(d r10) {
        return r10.f1621o1;
    }

    public static /* synthetic */ float V1(d r10) {
        return r10.f1627u1;
    }

    public static /* synthetic */ float W1(d r10) {
        return r10.f1624r1;
    }

    public static /* synthetic */ int X1(d r10) {
        return r10.f1620n1;
    }

    public static /* synthetic */ float Y1(d r10) {
        return r10.f1626t1;
    }

    public static /* synthetic */ int Z1(d r10) {
        return r10.f1622p1;
    }

    public static /* synthetic */ float a2(d r10) {
        return r10.f1628v1;
    }

    public static /* synthetic */ int b2(d r10) {
        return r10.f1631y1;
    }

    public static /* synthetic */ int c2(d r10, ConstraintWidget r11, int r12) {
        return r10.m2(r11, r12);
    }

    public static /* synthetic */ int d2(d r10, ConstraintWidget r11, int r12) {
        return r10.l2(r11, r12);
    }

    public static /* synthetic */ int e2(d r10) {
        return r10.I1;
    }

    public static /* synthetic */ ConstraintWidget[] f2(d r10) {
        return r10.H1;
    }

    public static /* synthetic */ int g2(d r10) {
        return r10.f1618l1;
    }

    public static /* synthetic */ int h2(d r10) {
        return r10.f1632z1;
    }

    public static /* synthetic */ int i2(d r10) {
        return r10.f1617k1;
    }

    public static /* synthetic */ float j2(d r10) {
        return r10.f1623q1;
    }

    public void A2(int r10) {
        this.f1621o1 = r10;
    }

    public void B2(float r10) {
        this.f1628v1 = r10;
    }

    public void C2(int r10) {
        this.f1622p1 = r10;
    }

    @Override // androidx.constraintlayout.core.widgets.h
    public void D1(int r19, int r20, int r21, int r22) {
        if (this.W0 > 0) goto L5;
    L8:
        int r12 = A1();
        int r13 = B1();
        int r14 = C1();
        int r15 = z1();
        int[] r10 = new int[2];
        int r11 = (r20 - r12) - r13;
        int r16 = this.C1;
        if (r16 != 1) goto L11;
        r11 = (r22 - r14) - r15;
    L11:
        int r17 = r11;
        if (r16 != 0) goto L20;
        if (this.f1617k1 != (-1)) goto L17;
        this.f1617k1 = 0;
    L17:
        if (this.f1618l1 != (-1)) goto L25;
        this.f1618l1 = 0;
    L25:
        ConstraintWidget[] r18 = this.V0;
        int r23 = 0;
        int r24 = 0;
    L26:
        int r110 = this.W0;
        if (r23 >= r110) goto L32;
        if (this.V0[r23].U() != 8) goto L31;
        r24 = r24 + 1;
    L31:
        r23 = r23 + 1;
        goto L26
    L32:
        if (r24 <= 0) goto L41;
        r18 = new ConstraintWidget[r110 - r24];
        int r25 = 0;
        int r26 = 0;
    L35:
        if (r25 >= this.W0) goto L40;
        ConstraintWidget r111 = this.V0[r25];
        if (r111.U() == 8) goto L39;
        r18[r26] = r111;
        r26 = r26 + 1;
    L39:
        r25 = r25 + 1;
        goto L35
    L40:
        int r27 = r26;
    L42:
        this.H1 = r18;
        this.I1 = r27;
        int r28 = this.A1;
        if (r28 != 0) goto L45;
        boolean r112 = true;
        q2(r18, r27, this.C1, r17, r10);
    L56:
        int r29 = (r10[0] + r12) + r13;
        int r30 = (r10[r112 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L59;
        r29 = r20;
    L64:
        if (r21 != 1073741824) goto L66;
        r30 = r22;
    L71:
        I1(r29, r30);
        l1(r29);
        M0(r30);
        if (this.W0 > 0) goto L75;
        r112 = false;
    L75:
        H1(r112);
        return;
    L66:
        if (r21 != Integer.MIN_VALUE) goto L68;
        r30 = Math.min(r30, r22);
        goto L71
    L68:
        if (r21 == 0) goto L71;
        r30 = 0;
        goto L71
    L59:
        if (r19 != Integer.MIN_VALUE) goto L61;
        r29 = Math.min(r29, r20);
        goto L64
    L61:
        if (r19 == 0) goto L64;
        r29 = 0;
        goto L64
    L45:
        if (r28 != 1) goto L47;
        r112 = true;
        o2(r18, r27, this.C1, r17, r10);
        goto L56
    L47:
        if (r28 != 2) goto L49;
        r112 = true;
        n2(r18, r27, this.C1, r17, r10);
        goto L56
    L49:
        if (r28 == 3) goto L52;
        r112 = true;
        goto L56
    L52:
        r112 = true;
        p2(r18, r27, this.C1, r17, r10);
        goto L56
    L41:
        r27 = r110;
        goto L42
    L20:
        if (this.f1617k1 != (-1)) goto L23;
        this.f1617k1 = 0;
    L23:
        if (this.f1618l1 != (-1)) goto L25;
        this.f1618l1 = 0;
        goto L25
    L5:
        if (F1() == true) goto L8;
        I1(0, 0);
        H1(false);
    }

    public void D2(int r10) {
        this.B1 = r10;
    }

    public void E2(int r10) {
        this.C1 = r10;
    }

    public void F2(int r10) {
        this.f1632z1 = r10;
    }

    public void G2(float r10) {
        this.f1624r1 = r10;
    }

    public void H2(int r10) {
        this.f1630x1 = r10;
    }

    public void I2(int r10) {
        this.f1618l1 = r10;
    }

    public void J2(int r10) {
        this.A1 = r10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void d(LinearSystem r10, boolean r11) {
        super.d(r10, r11);
        if (J() != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        int r13 = this.A1;
        if (r13 == 0) goto L32;
        if (r13 != 1) goto L12;
        int r14 = this.D1.size();
        int r15 = 0;
    L25:
        if (r15 >= r14) goto L34;
        a r16 = (a) this.D1.get(r15);
        if (r15 != (r14 - 1)) goto L29;
        boolean r17 = true;
    L30:
        r16.d(r12, r15, r17);
        r15 = r15 + 1;
        goto L25
    L29:
        r17 = false;
    L34:
        H1(false);
        return;
    L12:
        if (r13 != 2) goto L14;
        k2(r12);
        goto L34
    L14:
        if (r13 != 3) goto L34;
        int r18 = this.D1.size();
        int r19 = 0;
    L17:
        if (r19 >= r18) goto L34;
        a r20 = (a) this.D1.get(r19);
        if (r19 != (r18 - 1)) goto L21;
        boolean r21 = true;
    L22:
        r20.d(r12, r19, r21);
        r19 = r19 + 1;
        goto L17
    L21:
        r21 = false;
        goto L22
    L32:
        if (this.D1.size() <= 0) goto L34;
        ((a) this.D1.get(0)).d(r12, 0, true);
        goto L34
    L5:
        if (((ConstraintWidgetContainer) J()).R1() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // k.a, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void k(ConstraintWidget r10, HashMap r11) {
        super.k(r10, r11);
        d r12 = (d) r10;
        this.f1617k1 = r12.f1617k1;
        this.f1618l1 = r12.f1618l1;
        this.f1619m1 = r12.f1619m1;
        this.f1620n1 = r12.f1620n1;
        this.f1621o1 = r12.f1621o1;
        this.f1622p1 = r12.f1622p1;
        this.f1623q1 = r12.f1623q1;
        this.f1624r1 = r12.f1624r1;
        this.f1625s1 = r12.f1625s1;
        this.f1626t1 = r12.f1626t1;
        this.f1627u1 = r12.f1627u1;
        this.f1628v1 = r12.f1628v1;
        this.f1629w1 = r12.f1629w1;
        this.f1630x1 = r12.f1630x1;
        this.f1631y1 = r12.f1631y1;
        this.f1632z1 = r12.f1632z1;
        this.A1 = r12.A1;
        this.B1 = r12.B1;
        this.C1 = r12.C1;
    }

    public final void k2(boolean r12) {
        if (this.G1 != null) goto L5;
        return;
    L5:
        if (this.F1 != null) goto L7;
        return;
    L7:
        if (this.E1 == null) goto L91;
        int r10 = 0;
    L11:
        if (r10 >= this.I1) goto L13;
        this.H1[r10].u0();
        r10 = r10 + 1;
        goto L11
    L13:
        int[] r11 = this.G1;
        int r13 = r11[0];
        int r14 = r11[1];
        float r15 = this.f1623q1;
        ConstraintWidget r16 = null;
        int r17 = 0;
    L15:
        if (r17 >= r13) goto L34;
        if (r12 == false) goto L18;
        int r18 = (r13 - r17) - 1;
        float r19 = 1.0f - this.f1623q1;
    L19:
        ConstraintWidget r20 = this.F1[r18];
        if (r20 == null) goto L33;
        if (r20.U() == 8) goto L33;
        if (r17 != 0) goto L27;
        r20.i(r20.Q, this.Q, A1());
        r20.O0(this.f1617k1);
        r20.N0(r19);
    L27:
        if (r17 != (r13 - 1)) goto L29;
        r20.i(r20.S, this.S, B1());
    L29:
        if (r17 <= 0) goto L32;
        if (r16 == null) goto L32;
        r20.i(r20.Q, r16.S, this.f1629w1);
        r16.i(r16.S, r20.Q, 0);
    L32:
        r16 = r20;
    L33:
        r17 = r17 + 1;
        r15 = r19;
        goto L15
    L18:
        r19 = r15;
        r18 = r17;
        goto L19
    L34:
        int r110 = 0;
    L35:
        if (r110 >= r14) goto L51;
        ConstraintWidget r21 = this.E1[r110];
        if (r21 == null) goto L50;
        if (r21.U() == 8) goto L50;
        if (r110 != 0) goto L44;
        r21.i(r21.R, this.R, C1());
        r21.f1(this.f1618l1);
        r21.e1(this.f1624r1);
    L44:
        if (r110 != (r14 - 1)) goto L46;
        r21.i(r21.T, this.T, z1());
    L46:
        if (r110 <= 0) goto L49;
        if (r16 == null) goto L49;
        r21.i(r21.R, r16.T, this.f1630x1);
        r16.i(r16.T, r21.R, 0);
    L49:
        r16 = r21;
    L50:
        r110 = r110 + 1;
        goto L35
    L51:
        int r111 = 0;
    L52:
        if (r111 >= r13) goto L92;
        int r22 = 0;
    L54:
        if (r22 >= r14) goto L72;
        int r23 = (r22 * r13) + r111;
        if (this.C1 != 1) goto L58;
        r23 = (r111 * r14) + r22;
    L58:
        ConstraintWidget[] r24 = this.H1;
        if (r23 >= r24.length) goto L71;
        ConstraintWidget r25 = r24[r23];
        if (r25 == null) goto L71;
        if (r25.U() == 8) goto L71;
        ConstraintWidget r26 = this.F1[r111];
        ConstraintWidget r27 = this.E1[r22];
        if (r25 == r26) goto L69;
        r25.i(r25.Q, r26.Q, 0);
        r25.i(r25.S, r26.S, 0);
    L69:
        if (r25 == r27) goto L71;
        r25.i(r25.R, r27.R, 0);
        r25.i(r25.T, r27.T, 0);
    L71:
        r22 = r22 + 1;
        goto L54
    L72:
        r111 = r111 + 1;
        goto L52
    L92:
        return;
    }

    public final int l2(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r12 = r10.f1478x;
        if (r12 != 0) goto L11;
        return 0;
    L11:
        if (r12 != 2) goto L16;
        int r13 = (int) (r10.E * r11);
        if (r13 == r10.w()) goto L15;
        r10.Z0(true);
        E1(r10, r10.z(), r10.V(), ConstraintWidget.DimensionBehaviour.FIXED, r13);
    L15:
        return r13;
    L16:
        if (r12 != 1) goto L20;
        return r10.w();
    L20:
        if (r12 != 3) goto L24;
        return (int) ((r10.V() * r10.f1443f0) + 0.5f);
    L24:
        return r10.w();
    }

    public final int m2(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r12 = r10.f1476w;
        if (r12 != 0) goto L11;
        return 0;
    L11:
        if (r12 != 2) goto L16;
        int r13 = (int) (r10.B * r11);
        if (r13 == r10.V()) goto L15;
        r10.Z0(true);
        E1(r10, ConstraintWidget.DimensionBehaviour.FIXED, r13, r10.S(), r10.w());
    L15:
        return r13;
    L16:
        if (r12 != 1) goto L20;
        return r10.V();
    L20:
        if (r12 != 3) goto L24;
        return (int) ((r10.w() * r10.f1443f0) + 0.5f);
    L24:
        return r10.V();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    public final void n2(ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        if (r13 != 0) goto L19;
        int r10 = this.B1;
        if (r10 > 0) goto L18;
        r10 = 0;
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r12) goto L18;
        if (r16 <= 0) goto L10;
        r17 = r17 + this.f1629w1;
    L10:
        ConstraintWidget r18 = r11[r16];
        if (r18 == null) goto L17;
        r17 = r17 + m2(r18, r14);
        if (r17 > r14) goto L18;
        r10 = r10 + 1;
    L17:
        r16 = r16 + 1;
    L18:
        int r19 = r10;
        int r20 = 0;
    L35:
        if (this.G1 != null) goto L38;
        this.G1 = new int[2];
    L38:
        if (r20 != 0) goto L40;
        if (r13 != 1) goto L40;
    L42:
        boolean r21 = true;
    L44:
        if (r21 == true) goto L111;
        if (r13 != 0) goto L47;
        r20 = (int) Math.ceil(r12 / r19);
    L48:
        ConstraintWidget[] r22 = this.F1;
        if (r22 != null) goto L51;
    L54:
        this.F1 = new ConstraintWidget[r19];
    L55:
        ConstraintWidget[] r23 = this.E1;
        if (r23 != null) goto L58;
    L61:
        this.E1 = new ConstraintWidget[r20];
    L62:
        int r24 = 0;
    L63:
        if (r24 >= r19) goto L87;
        int r25 = 0;
    L65:
        if (r25 >= r20) goto L86;
        int r26 = (r25 * r19) + r24;
        if (r13 != 1) goto L70;
        r26 = (r24 * r20) + r25;
    L70:
        if (r26 >= r11.length) goto L85;
        ConstraintWidget r27 = r11[r26];
        if (r27 == null) goto L85;
        int r28 = m2(r27, r14);
        ConstraintWidget r29 = this.F1[r24];
        if (r29 != null) goto L78;
    L79:
        this.F1[r24] = r27;
    L80:
        int r30 = l2(r27, r14);
        ConstraintWidget r31 = this.E1[r25];
        if (r31 != null) goto L83;
    L84:
        this.E1[r25] = r27;
        goto L85
    L83:
        if (r31.w() >= r30) goto L85;
    L78:
        if (r29.V() >= r28) goto L80;
    L85:
        r25 = r25 + 1;
        goto L65
    L86:
        r24 = r24 + 1;
        goto L63
    L87:
        int r32 = 0;
        int r33 = 0;
    L88:
        if (r32 >= r19) goto L95;
        ConstraintWidget r34 = this.F1[r32];
        if (r34 == null) goto L94;
        if (r32 <= 0) goto L93;
        r33 = r33 + this.f1629w1;
    L93:
        r33 = r33 + m2(r34, r14);
    L94:
        r32 = r32 + 1;
        goto L88
    L95:
        int r35 = 0;
        int r36 = 0;
    L96:
        if (r35 >= r20) goto L103;
        ConstraintWidget r37 = this.E1[r35];
        if (r37 == null) goto L102;
        if (r35 <= 0) goto L101;
        r36 = r36 + this.f1630x1;
    L101:
        r36 = r36 + l2(r37, r14);
    L102:
        r35 = r35 + 1;
        goto L96
    L103:
        r15[0] = r33;
        r15[1] = r36;
        if (r13 == 0) goto L105;
        if (r36 <= r14) goto L42;
        if (r20 <= 1) goto L42;
        r20 = r20 - 1;
        goto L44
    L105:
        if (r33 <= r14) goto L42;
        if (r19 <= 1) goto L42;
        r19 = r19 - 1;
        goto L44
    L58:
        if (r23.length < r20) goto L61;
        Arrays.fill(r23, null);
        goto L62
    L51:
        if (r22.length < r19) goto L54;
        Arrays.fill(r22, null);
        goto L55
    L47:
        r19 = (int) Math.ceil(r12 / r20);
        goto L48
    L111:
        int[] r110 = this.G1;
        r110[0] = r19;
        r110[1] = r20;
        return;
    L40:
        if (r19 != 0) goto L43;
        if (r13 == 0) goto L42;
    L43:
        r21 = false;
        goto L44
    L19:
        r20 = this.B1;
        if (r20 > 0) goto L33;
        r20 = 0;
        int r38 = 0;
        int r39 = 0;
    L22:
        if (r38 >= r12) goto L33;
        if (r38 <= 0) goto L25;
        r39 = r39 + this.f1630x1;
    L25:
        ConstraintWidget r40 = r11[r38];
        if (r40 == null) goto L32;
        r39 = r39 + l2(r40, r14);
        if (r39 > r14) goto L33;
        r20 = r20 + 1;
    L32:
        r38 = r38 + 1;
    L33:
        r19 = 0;
        goto L35
    }

    public final void o2(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.D1.clear();
        a r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        this.D1.add(r10);
        if (r31 != 0) goto L33;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r13 >= r30) goto L59;
        ConstraintWidget r14 = r29[r13];
        int r15 = m2(r14, r32);
        if (r14.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r11 = r11 + 1;
    L12:
        int r16 = r11;
        if (r12 == r32) goto L17;
        if (((this.f1629w1 + r12) + r15) > r32) goto L17;
    L19:
        boolean r17 = false;
    L20:
        if (r17 == true) goto L27;
        if (r13 <= 0) goto L27;
        int r18 = this.B1;
        if (r18 <= 0) goto L27;
        if ((r13 % r18) != 0) goto L27;
        r17 = true;
    L27:
        if (r17 == false) goto L30;
        r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        r10.i(r13);
        this.D1.add(r10);
    L29:
        r12 = r15;
    L32:
        r10.b(r14);
        r13 = r13 + 1;
        r11 = r16;
        goto L8
    L30:
        if (r13 <= 0) goto L29;
        r12 = r12 + (this.f1629w1 + r15);
    L17:
        if (a.a(r10) == null) goto L19;
        r17 = true;
    L59:
        int r19 = this.D1.size();
        ConstraintAnchor r20 = this.Q;
        ConstraintAnchor r21 = this.R;
        ConstraintAnchor r22 = this.S;
        ConstraintAnchor r23 = this.T;
        int r24 = A1();
        int r25 = C1();
        int r26 = B1();
        int r110 = z1();
        ConstraintWidget.DimensionBehaviour r111 = z();
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r111 != r112) goto L62;
    L65:
        boolean r113 = true;
    L66:
        if (r11 <= 0) goto L75;
        if (r113 == false) goto L75;
        int r27 = 0;
    L69:
        if (r27 >= r19) goto L75;
        a r114 = (a) this.D1.get(r27);
        if (r31 != 0) goto L73;
        r114.g(r32 - r114.f());
    L74:
        r27 = r27 + 1;
        goto L69
    L73:
        r114.g(r32 - r114.e());
    L75:
        int r28 = r25;
        int r34 = r26;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        int r35 = r24;
        ConstraintAnchor r36 = r21;
        ConstraintAnchor r37 = r20;
        int r38 = r110;
    L76:
        if (r117 >= r19) goto L96;
        a r210 = (a) this.D1.get(r117);
        if (r31 == 0) goto L80;
        ConstraintAnchor r211 = r37;
        int r39 = r115;
        int r40 = r116;
        int r41 = r117;
        if (r41 >= (r19 - 1)) goto L90;
        ConstraintAnchor r212 = a.a((a) this.D1.get(r41 + 1)).Q;
        int r213 = 0;
    L91:
        ConstraintAnchor r118 = a.a(r210).S;
        r210.j(r31, r211, r36, r212, r23, r35, r28, r213, r38, r32);
        r116 = r40 + r210.f();
        int r42 = Math.max(r39, r210.e());
        if (r41 <= 0) goto L94;
        r116 = r116 + this.f1629w1;
    L94:
        r115 = r42;
        r35 = 0;
        r34 = r213;
        r37 = r118;
    L95:
        r117 = r41 + 1;
        r22 = r212;
        goto L76
    L90:
        r212 = this.S;
        r213 = B1();
        goto L91
    L80:
        if (r117 >= (r19 - 1)) goto L82;
        ConstraintAnchor r43 = a.a((a) this.D1.get(r117 + 1)).R;
        int r44 = 0;
    L83:
        ConstraintAnchor r119 = a.a(r210).T;
        ConstraintAnchor r120 = r37;
        ConstraintAnchor r214 = r37;
        int r45 = r115;
        ConstraintAnchor r121 = r36;
        int r46 = r116;
        ConstraintAnchor r122 = r22;
        ConstraintAnchor r310 = r22;
        r41 = r117;
        r210.j(r31, r120, r121, r122, r43, r35, r28, r34, r44, r32);
        int r47 = Math.max(r46, r210.f());
        r115 = r45 + r210.e();
        if (r41 <= 0) goto L86;
        r115 = r115 + this.f1630x1;
    L86:
        r37 = r214;
        r116 = r47;
        r28 = 0;
        r36 = r119;
        r212 = r310;
        int r215 = r44;
        r23 = r43;
        r38 = r215;
        goto L95
    L82:
        r43 = this.T;
        r44 = z1();
        goto L83
    L96:
        r33[0] = r116;
        r33[1] = r115;
        return;
    L62:
        if (S() == r112) goto L65;
        r113 = false;
        goto L66
    L33:
        r11 = 0;
        int r48 = 0;
        int r123 = 0;
    L34:
        if (r123 >= r30) goto L59;
        ConstraintWidget r124 = r29[r123];
        int r125 = l2(r124, r32);
        if (r124.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r11 = r11 + 1;
    L38:
        int r126 = r11;
        if (r48 == r32) goto L43;
        if (((this.f1630x1 + r48) + r125) > r32) goto L43;
    L45:
        boolean r49 = false;
    L46:
        if (r49 == true) goto L53;
        if (r123 <= 0) goto L53;
        int r50 = this.B1;
        if (r50 <= 0) goto L53;
        if ((r123 % r50) != 0) goto L53;
        r49 = true;
    L53:
        if (r49 == false) goto L56;
        r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        r10.i(r123);
        this.D1.add(r10);
    L55:
        r48 = r125;
    L58:
        r10.b(r124);
        r123 = r123 + 1;
        r11 = r126;
        goto L34
    L56:
        if (r123 <= 0) goto L55;
        r48 = r48 + (this.f1630x1 + r125);
    L43:
        if (a.a(r10) == null) goto L45;
        r49 = true;
        goto L46
    }

    public final void p2(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.D1.clear();
        a r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        this.D1.add(r10);
        if (r31 != 0) goto L33;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r14 >= r30) goto L58;
        int r15 = r11 + 1;
        ConstraintWidget r16 = r29[r14];
        int r17 = m2(r16, r32);
        if (r16.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r12 = r12 + 1;
    L12:
        int r18 = r12;
        if (r13 == r32) goto L17;
        if (((this.f1629w1 + r13) + r17) > r32) goto L17;
    L19:
        boolean r19 = false;
    L20:
        if (r19 == true) goto L26;
        if (r14 <= 0) goto L26;
        int r20 = this.B1;
        if (r20 <= 0) goto L26;
        if (r15 <= r20) goto L26;
        r19 = true;
    L26:
        if (r19 == false) goto L28;
        r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        r10.i(r14);
        this.D1.add(r10);
        r11 = r15;
        r13 = r17;
    L32:
        r10.b(r16);
        r14 = r14 + 1;
        r12 = r18;
        goto L8
    L28:
        if (r14 <= 0) goto L31;
        r13 = r13 + (this.f1629w1 + r17);
    L30:
        r11 = 0;
        goto L32
    L31:
        r13 = r17;
    L17:
        if (a.a(r10) == null) goto L19;
        r19 = true;
    L58:
        int r21 = this.D1.size();
        ConstraintAnchor r22 = this.Q;
        ConstraintAnchor r23 = this.R;
        ConstraintAnchor r24 = this.S;
        ConstraintAnchor r25 = this.T;
        int r26 = A1();
        int r27 = C1();
        int r28 = B1();
        int r110 = z1();
        ConstraintWidget.DimensionBehaviour r111 = z();
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r111 != r112) goto L61;
    L64:
        boolean r113 = true;
    L65:
        if (r12 <= 0) goto L74;
        if (r113 == false) goto L74;
        int r34 = 0;
    L68:
        if (r34 >= r21) goto L74;
        a r114 = (a) this.D1.get(r34);
        if (r31 != 0) goto L72;
        r114.g(r32 - r114.f());
    L73:
        r34 = r34 + 1;
        goto L68
    L72:
        r114.g(r32 - r114.e());
    L74:
        int r210 = r27;
        int r35 = r28;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        int r36 = r26;
        ConstraintAnchor r37 = r23;
        ConstraintAnchor r38 = r22;
        int r39 = r110;
    L75:
        if (r117 >= r21) goto L95;
        a r211 = (a) this.D1.get(r117);
        if (r31 == 0) goto L79;
        ConstraintAnchor r212 = r38;
        int r40 = r115;
        int r41 = r116;
        int r42 = r117;
        if (r42 >= (r21 - 1)) goto L89;
        ConstraintAnchor r213 = a.a((a) this.D1.get(r42 + 1)).Q;
        int r214 = 0;
    L90:
        ConstraintAnchor r118 = a.a(r211).S;
        r211.j(r31, r212, r37, r213, r25, r36, r210, r214, r39, r32);
        r116 = r41 + r211.f();
        int r43 = Math.max(r40, r211.e());
        if (r42 <= 0) goto L93;
        r116 = r116 + this.f1629w1;
    L93:
        r115 = r43;
        r36 = 0;
        r35 = r214;
        r38 = r118;
    L94:
        r117 = r42 + 1;
        r24 = r213;
        goto L75
    L89:
        r213 = this.S;
        r214 = B1();
        goto L90
    L79:
        if (r117 >= (r21 - 1)) goto L81;
        ConstraintAnchor r44 = a.a((a) this.D1.get(r117 + 1)).R;
        int r45 = 0;
    L82:
        ConstraintAnchor r119 = a.a(r211).T;
        ConstraintAnchor r120 = r38;
        ConstraintAnchor r215 = r38;
        int r46 = r115;
        ConstraintAnchor r121 = r37;
        int r47 = r116;
        ConstraintAnchor r122 = r24;
        ConstraintAnchor r310 = r24;
        r42 = r117;
        r211.j(r31, r120, r121, r122, r44, r36, r210, r35, r45, r32);
        int r48 = Math.max(r47, r211.f());
        r115 = r46 + r211.e();
        if (r42 <= 0) goto L85;
        r115 = r115 + this.f1630x1;
    L85:
        r38 = r215;
        r116 = r48;
        r210 = 0;
        r37 = r119;
        r213 = r310;
        int r216 = r45;
        r25 = r44;
        r39 = r216;
        goto L94
    L81:
        r44 = this.T;
        r45 = z1();
        goto L82
    L95:
        r33[0] = r116;
        r33[1] = r115;
        return;
    L61:
        if (S() == r112) goto L64;
        r113 = false;
        goto L65
    L33:
        int r49 = 0;
        r12 = 0;
        int r123 = 0;
    L34:
        if (r123 >= r30) goto L58;
        ConstraintWidget r124 = r29[r123];
        int r125 = l2(r124, r32);
        if (r124.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r12 = r12 + 1;
    L38:
        int r126 = r12;
        if (r49 == r32) goto L43;
        if (((this.f1630x1 + r49) + r125) > r32) goto L43;
    L45:
        boolean r50 = false;
    L46:
        if (r50 == true) goto L52;
        if (r123 <= 0) goto L52;
        int r51 = this.B1;
        if (r51 <= 0) goto L52;
        if (r51 >= 0) goto L52;
        r50 = true;
    L52:
        if (r50 == false) goto L55;
        r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        r10.i(r123);
        this.D1.add(r10);
    L54:
        r49 = r125;
    L57:
        r10.b(r124);
        r123 = r123 + 1;
        r12 = r126;
        goto L34
    L55:
        if (r123 <= 0) goto L54;
        r49 = r49 + (this.f1630x1 + r125);
    L43:
        if (a.a(r10) == null) goto L45;
        r50 = true;
        goto L46
    }

    public final void q2(ConstraintWidget[] r23, int r24, int r25, int r26, int[] r27) {
        if (r24 != 0) goto L6;
        return;
    L6:
        if (this.D1.size() != 0) goto L8;
        a r11 = new a(this, r25, this.Q, this.R, this.S, this.T, r26);
        this.D1.add(r11);
    L9:
        int r10 = 0;
    L10:
        if (r10 >= r24) goto L12;
        r11.b(r23[r10]);
        r10 = r10 + 1;
        goto L10
    L12:
        r27[0] = r11.f();
        r27[1] = r11.e();
        return;
    L8:
        a r12 = (a) this.D1.get(0);
        r12.c();
        r11 = r12;
        r11.j(r25, this.Q, this.R, this.S, this.T, A1(), C1(), B1(), z1(), r26);
        goto L9
    }

    public void r2(float r10) {
        this.f1625s1 = r10;
    }

    public void s2(int r10) {
        this.f1619m1 = r10;
    }

    public void t2(float r10) {
        this.f1626t1 = r10;
    }

    public void u2(int r10) {
        this.f1620n1 = r10;
    }

    public void v2(int r10) {
        this.f1631y1 = r10;
    }

    public void w2(float r10) {
        this.f1623q1 = r10;
    }

    public void x2(int r10) {
        this.f1629w1 = r10;
    }

    public void y2(int r10) {
        this.f1617k1 = r10;
    }

    public void z2(float r10) {
        this.f1627u1 = r10;
    }
}
