package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.LinearSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class e extends i {
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
    public int f13435k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public int f13436l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public int f13437m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public int f13438n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f13439o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f13440p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public float f13441q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public float f13442r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public float f13443s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public float f13444t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public float f13445u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f13446v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public int f13447w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f13448x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f13449y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public int f13450z1;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget f13452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f13454d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f13455e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f13456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f13457g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f13458h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f13459i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13460j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f13461k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f13462l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f13463m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f13464n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f13465o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f13466p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f13467q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ e f13468r;

        public a(e r10, int r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, ConstraintAnchor r15, int r16) {
            this.f13468r = r10;
            this.f13452b = null;
            this.f13453c = 0;
            this.f13458h = 0;
            this.f13459i = 0;
            this.f13460j = 0;
            this.f13461k = 0;
            this.f13462l = 0;
            this.f13463m = 0;
            this.f13464n = 0;
            this.f13465o = 0;
            this.f13466p = 0;
            this.f13467q = 0;
            this.f13451a = r11;
            this.f13454d = r12;
            this.f13455e = r13;
            this.f13456f = r14;
            this.f13457g = r15;
            this.f13458h = r10.B1();
            this.f13459i = r10.D1();
            this.f13460j = r10.C1();
            this.f13461k = r10.A1();
            this.f13467q = r16;
        }

        public static /* synthetic */ ConstraintWidget a(a r10) {
            return r10.f13452b;
        }

        public void b(ConstraintWidget r10) {
            int r11 = 0;
            if (this.f13451a != 0) goto L16;
            int r12 = e.d2(this.f13468r, r10, this.f13467q);
            if (r10.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.f13466p++;
            r12 = 0;
        L7:
            int r13 = e.R1(this.f13468r);
            if (r10.U() == 8) goto L11;
            r11 = r13;
        L11:
            this.f13462l += r12 + r11;
            int r14 = e.e2(this.f13468r, r10, this.f13467q);
            if (this.f13452b != null) goto L14;
        L15:
            this.f13452b = r10;
            this.f13453c = r14;
            this.f13463m = r14;
        L28:
            this.f13465o++;
            return;
        L14:
            if (this.f13453c >= r14) goto L28;
        L16:
            int r15 = e.d2(this.f13468r, r10, this.f13467q);
            int r16 = e.e2(this.f13468r, r10, this.f13467q);
            if (r10.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.f13466p++;
            r16 = 0;
        L19:
            int r17 = e.S1(this.f13468r);
            if (r10.U() == 8) goto L23;
            r11 = r17;
        L23:
            this.f13463m += r16 + r11;
            if (this.f13452b != null) goto L26;
        L27:
            this.f13452b = r10;
            this.f13453c = r15;
            this.f13462l = r15;
            goto L28
        L26:
            if (this.f13453c >= r15) goto L28;
            goto L27
        }

        public void c() {
            this.f13453c = 0;
            this.f13452b = null;
            this.f13462l = 0;
            this.f13463m = 0;
            this.f13464n = 0;
            this.f13465o = 0;
            this.f13466p = 0;
        }

        public void d(boolean r17, int r18, boolean r19) {
            int r10 = this.f13465o;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            if ((this.f13464n + r11) >= e.f2(this.f13468r)) goto L11;
            ConstraintWidget r12 = e.g2(this.f13468r)[this.f13464n + r11];
            if (r12 == null) goto L10;
            r12.u0();
        L10:
            r11 = r11 + 1;
        L11:
            if (r10 != 0) goto L13;
            return;
        L13:
            if (this.f13452b == null) goto L222;
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
            if ((this.f13464n + r20) >= e.f2(this.f13468r)) goto L35;
            ConstraintWidget r21 = e.g2(this.f13468r)[this.f13464n + r20];
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
            if (this.f13451a != 0) goto L127;
            ConstraintWidget r23 = this.f13452b;
            r23.g1(e.h2(this.f13468r));
            int r110 = this.f13459i;
            if (r18 <= 0) goto L40;
            r110 = r110 + e.S1(this.f13468r);
        L40:
            r23.R.a(this.f13455e, r110);
            if (r19 == false) goto L43;
            r23.T.a(this.f13457g, this.f13461k);
        L43:
            if (r18 <= 0) goto L45;
            this.f13455e.f13243d.T.a(r23.R, 0);
        L45:
            char r111 = 3;
            if (e.i2(this.f13468r) == 3) goto L48;
        L61:
            ConstraintWidget r112 = r23;
        L62:
            int r113 = 0;
        L63:
            if (r113 >= r10) goto L223;
            if (r17 == false) goto L66;
            int r114 = (r10 - 1) - r113;
        L68:
            if ((this.f13464n + r114) >= e.f2(this.f13468r)) goto L224;
            ConstraintWidget r115 = e.g2(this.f13468r)[this.f13464n + r114];
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
            r115.i(r115.Q, this.f13454d, this.f13458h);
        L75:
            if (r114 != 0) goto L98;
            int r25 = e.j2(this.f13468r);
            float r116 = e.k2(this.f13468r);
            if (r17 == false) goto L80;
            r116 = 1.0f - r116;
        L80:
            if (this.f13464n == 0) goto L82;
        L89:
            if (r19 == true) goto L91;
        L96:
            r115.P0(r25);
            r115.O0(r116);
            goto L98
        L91:
            if (e.V1(this.f13468r) == (-1)) goto L96;
            r25 = e.V1(this.f13468r);
            if (r17 == false) goto L95;
            float r117 = e.W1(this.f13468r);
        L86:
            float r118 = 1.0f - r117;
        L87:
            r116 = r118;
            goto L96
        L95:
            r118 = e.W1(this.f13468r);
            goto L87
        L82:
            if (e.T1(this.f13468r) == (-1)) goto L89;
            r25 = e.T1(this.f13468r);
            if (r17 == false) goto L88;
            r117 = e.U1(this.f13468r);
            goto L86
        L88:
            r118 = e.U1(this.f13468r);
        L98:
            if (r113 != (r10 - 1)) goto L100;
            r115.i(r115.S, this.f13456f, this.f13460j);
        L100:
            if (r22 == null) goto L107;
            r115.Q.a(r22.S, e.R1(this.f13468r));
            if (r113 != r15) goto L104;
            r115.Q.u(this.f13458h);
        L104:
            r22.S.a(r115.Q, 0);
            if (r113 != (r16 + 1)) goto L107;
            r22.S.u(this.f13460j);
        L107:
            if (r115 == r23) goto L125;
            r24 = 3;
            if (e.i2(this.f13468r) == 3) goto L111;
        L116:
            int r26 = e.i2(this.f13468r);
            if (r26 != 0) goto L119;
            r115.R.a(r23.R, 0);
            goto L126
        L119:
            if (r26 == 1) goto L123;
            if (r13 == false) goto L122;
            r115.R.a(this.f13455e, this.f13459i);
            r115.T.a(this.f13457g, this.f13461k);
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
            if ((this.f13464n + r120) >= e.f2(this.f13468r)) goto L61;
            r112 = e.g2(this.f13468r)[this.f13464n + r120];
            if (r112.Y() == true) goto L62;
            r119 = r119 + 1;
            goto L50
        L53:
            r120 = r119;
            goto L55
        L127:
            ConstraintWidget r27 = this.f13452b;
            r27.P0(e.j2(this.f13468r));
            int r28 = this.f13458h;
            if (r18 <= 0) goto L130;
            r28 = r28 + e.R1(this.f13468r);
        L130:
            if (r17 == false) goto L136;
            r27.S.a(this.f13456f, r28);
            if (r19 == false) goto L134;
            r27.Q.a(this.f13454d, this.f13460j);
        L134:
            if (r18 <= 0) goto L141;
            this.f13456f.f13243d.Q.a(r27.S, 0);
        L141:
            int r29 = 0;
        L142:
            if (r29 >= r10) goto L225;
            if ((this.f13464n + r29) >= e.f2(this.f13468r)) goto L226;
            ConstraintWidget r121 = e.g2(this.f13468r)[this.f13464n + r29];
            if (r121 == null) goto L195;
            if (r29 != 0) goto L161;
            r121.i(r121.R, this.f13455e, this.f13459i);
            int r122 = e.h2(this.f13468r);
            float r123 = e.X1(this.f13468r);
            if (this.f13464n == 0) goto L153;
        L155:
            if (r19 == true) goto L157;
        L159:
            r121.g1(r122);
            r121.f1(r123);
            goto L161
        L157:
            if (e.a2(this.f13468r) == (-1)) goto L159;
            r122 = e.a2(this.f13468r);
            r123 = e.b2(this.f13468r);
            goto L159
        L153:
            if (e.Y1(this.f13468r) == (-1)) goto L155;
            r122 = e.Y1(this.f13468r);
            r123 = e.Z1(this.f13468r);
        L161:
            if (r29 != (r10 - 1)) goto L163;
            r121.i(r121.T, this.f13457g, this.f13461k);
        L163:
            if (r22 == null) goto L170;
            r121.R.a(r22.T, e.S1(this.f13468r));
            if (r29 != r15) goto L167;
            r121.R.u(this.f13459i);
        L167:
            r22.T.a(r121.R, 0);
            if (r29 != (r16 + 1)) goto L170;
            r22.T.u(this.f13461k);
        L170:
            if (r121 == r27) goto L194;
            if (r17 == false) goto L183;
            int r124 = e.c2(this.f13468r);
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
            int r125 = e.c2(this.f13468r);
            if (r125 != 0) goto L186;
            r121.Q.a(r27.Q, 0);
            goto L194
        L186:
            if (r125 == 1) goto L192;
            if (r125 != 2) goto L194;
            if (r13 == false) goto L191;
            r121.Q.a(this.f13454d, this.f13458h);
            r121.S.a(this.f13456f, this.f13460j);
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
            r27.Q.a(this.f13454d, r28);
            if (r19 == false) goto L139;
            r27.S.a(this.f13456f, this.f13460j);
        L139:
            if (r18 <= 0) goto L141;
            this.f13454d.f13243d.S.a(r27.Q, 0);
        L18:
            r13 = false;
            goto L19
        }

        public int e() {
            if (this.f13451a != 1) goto L7;
            return this.f13463m - e.S1(this.f13468r);
        L7:
            return this.f13463m;
        }

        public int f() {
            if (this.f13451a != 0) goto L7;
            return this.f13462l - e.R1(this.f13468r);
        L7:
            return this.f13462l;
        }

        public void g(int r10) {
            int r11 = this.f13466p;
            if (r11 != 0) goto L5;
            return;
        L5:
            int r12 = this.f13465o;
            int r13 = r10 / r11;
            int r14 = 0;
        L6:
            if (r14 >= r12) goto L25;
            if ((this.f13464n + r14) >= e.f2(this.f13468r)) goto L25;
            ConstraintWidget r15 = e.g2(this.f13468r)[this.f13464n + r14];
            if (this.f13451a != 0) goto L18;
            if (r15 == null) goto L24;
            if (r15.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r15.f13295w != 0) goto L24;
            this.f13468r.F1(r15, ConstraintWidget.DimensionBehaviour.FIXED, r13, r15.S(), r15.w());
        L24:
            r14 = r14 + 1;
            goto L6
        L18:
            if (r15 == null) goto L24;
            if (r15.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r15.f13297x != 0) goto L24;
            this.f13468r.F1(r15, r15.z(), r15.V(), ConstraintWidget.DimensionBehaviour.FIXED, r13);
        L25:
            h();
        }

        public final void h() {
            this.f13462l = 0;
            this.f13463m = 0;
            this.f13452b = null;
            this.f13453c = 0;
            int r10 = this.f13465o;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L26;
            if ((this.f13464n + r11) >= e.f2(this.f13468r)) goto L33;
            ConstraintWidget r12 = e.g2(this.f13468r)[this.f13464n + r11];
            if (this.f13451a != 0) goto L17;
            int r13 = r12.V();
            int r14 = e.R1(this.f13468r);
            if (r12.U() != 8) goto L12;
            r14 = 0;
        L12:
            this.f13462l += r13 + r14;
            int r15 = e.e2(this.f13468r, r12, this.f13467q);
            if (this.f13452b != null) goto L15;
        L16:
            this.f13452b = r12;
            this.f13453c = r15;
            this.f13463m = r15;
        L25:
            r11 = r11 + 1;
            goto L3
        L15:
            if (this.f13453c >= r15) goto L25;
        L17:
            int r16 = e.d2(this.f13468r, r12, this.f13467q);
            int r17 = e.e2(this.f13468r, r12, this.f13467q);
            int r18 = e.S1(this.f13468r);
            if (r12.U() != 8) goto L20;
            r18 = 0;
        L20:
            this.f13463m += r17 + r18;
            if (this.f13452b != null) goto L23;
        L24:
            this.f13452b = r12;
            this.f13453c = r16;
            this.f13462l = r16;
            goto L25
        L23:
            if (this.f13453c >= r16) goto L25;
        L33:
            return;
        }

        public void i(int r10) {
            this.f13464n = r10;
        }

        public void j(int r10, ConstraintAnchor r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, int r15, int r16, int r17, int r18, int r19) {
            this.f13451a = r10;
            this.f13454d = r11;
            this.f13455e = r12;
            this.f13456f = r13;
            this.f13457g = r14;
            this.f13458h = r15;
            this.f13459i = r16;
            this.f13460j = r17;
            this.f13461k = r18;
            this.f13467q = r19;
        }
    }

    public e() {
        this.f13435k1 = -1;
        this.f13436l1 = -1;
        this.f13437m1 = -1;
        this.f13438n1 = -1;
        this.f13439o1 = -1;
        this.f13440p1 = -1;
        this.f13441q1 = 0.5f;
        this.f13442r1 = 0.5f;
        this.f13443s1 = 0.5f;
        this.f13444t1 = 0.5f;
        this.f13445u1 = 0.5f;
        this.f13446v1 = 0.5f;
        this.f13447w1 = 0;
        this.f13448x1 = 0;
        this.f13449y1 = 2;
        this.f13450z1 = 2;
        this.A1 = 0;
        this.B1 = -1;
        this.C1 = 0;
        this.D1 = new ArrayList();
        this.E1 = null;
        this.F1 = null;
        this.G1 = null;
        this.I1 = 0;
    }

    public static /* synthetic */ int R1(e r10) {
        return r10.f13447w1;
    }

    public static /* synthetic */ int S1(e r10) {
        return r10.f13448x1;
    }

    public static /* synthetic */ int T1(e r10) {
        return r10.f13437m1;
    }

    public static /* synthetic */ float U1(e r10) {
        return r10.f13443s1;
    }

    public static /* synthetic */ int V1(e r10) {
        return r10.f13439o1;
    }

    public static /* synthetic */ float W1(e r10) {
        return r10.f13445u1;
    }

    public static /* synthetic */ float X1(e r10) {
        return r10.f13442r1;
    }

    public static /* synthetic */ int Y1(e r10) {
        return r10.f13438n1;
    }

    public static /* synthetic */ float Z1(e r10) {
        return r10.f13444t1;
    }

    public static /* synthetic */ int a2(e r10) {
        return r10.f13440p1;
    }

    public static /* synthetic */ float b2(e r10) {
        return r10.f13446v1;
    }

    public static /* synthetic */ int c2(e r10) {
        return r10.f13449y1;
    }

    public static /* synthetic */ int d2(e r10, ConstraintWidget r11, int r12) {
        return r10.n2(r11, r12);
    }

    public static /* synthetic */ int e2(e r10, ConstraintWidget r11, int r12) {
        return r10.m2(r11, r12);
    }

    public static /* synthetic */ int f2(e r10) {
        return r10.I1;
    }

    public static /* synthetic */ ConstraintWidget[] g2(e r10) {
        return r10.H1;
    }

    public static /* synthetic */ int h2(e r10) {
        return r10.f13436l1;
    }

    public static /* synthetic */ int i2(e r10) {
        return r10.f13450z1;
    }

    public static /* synthetic */ int j2(e r10) {
        return r10.f13435k1;
    }

    public static /* synthetic */ float k2(e r10) {
        return r10.f13441q1;
    }

    public void A2(float r10) {
        this.f13445u1 = r10;
    }

    public void B2(int r10) {
        this.f13439o1 = r10;
    }

    public void C2(float r10) {
        this.f13446v1 = r10;
    }

    public void D2(int r10) {
        this.f13440p1 = r10;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.i
    public void E1(int r19, int r20, int r21, int r22) {
        if (this.W0 > 0) goto L5;
    L8:
        int r12 = B1();
        int r13 = C1();
        int r14 = D1();
        int r15 = A1();
        int[] r10 = new int[2];
        int r11 = (r20 - r12) - r13;
        int r16 = this.C1;
        if (r16 != 1) goto L11;
        r11 = (r22 - r14) - r15;
    L11:
        int r17 = r11;
        if (r16 != 0) goto L20;
        if (this.f13435k1 != (-1)) goto L17;
        this.f13435k1 = 0;
    L17:
        if (this.f13436l1 != (-1)) goto L25;
        this.f13436l1 = 0;
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
        r2(r18, r27, this.C1, r17, r10);
    L56:
        int r29 = (r10[0] + r12) + r13;
        int r30 = (r10[r112 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L59;
        r29 = r20;
    L64:
        if (r21 != 1073741824) goto L66;
        r30 = r22;
    L71:
        J1(r29, r30);
        m1(r29);
        N0(r30);
        if (this.W0 > 0) goto L75;
        r112 = false;
    L75:
        I1(r112);
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
        p2(r18, r27, this.C1, r17, r10);
        goto L56
    L47:
        if (r28 != 2) goto L49;
        r112 = true;
        o2(r18, r27, this.C1, r17, r10);
        goto L56
    L49:
        if (r28 == 3) goto L52;
        r112 = true;
        goto L56
    L52:
        r112 = true;
        q2(r18, r27, this.C1, r17, r10);
        goto L56
    L41:
        r27 = r110;
        goto L42
    L20:
        if (this.f13435k1 != (-1)) goto L23;
        this.f13435k1 = 0;
    L23:
        if (this.f13436l1 != (-1)) goto L25;
        this.f13436l1 = 0;
        goto L25
    L5:
        if (G1() == true) goto L8;
        J1(0, 0);
        I1(false);
    }

    public void E2(int r10) {
        this.B1 = r10;
    }

    public void F2(int r10) {
        this.C1 = r10;
    }

    public void G2(int r10) {
        this.f13450z1 = r10;
    }

    public void H2(float r10) {
        this.f13442r1 = r10;
    }

    public void I2(int r10) {
        this.f13448x1 = r10;
    }

    public void J2(int r10) {
        this.f13436l1 = r10;
    }

    public void K2(int r10) {
        this.A1 = r10;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
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
        I1(false);
        return;
    L12:
        if (r13 != 2) goto L14;
        l2(r12);
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
        if (((d) J()).S1() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // wc.a, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void k(ConstraintWidget r10, HashMap r11) {
        super.k(r10, r11);
        e r12 = (e) r10;
        this.f13435k1 = r12.f13435k1;
        this.f13436l1 = r12.f13436l1;
        this.f13437m1 = r12.f13437m1;
        this.f13438n1 = r12.f13438n1;
        this.f13439o1 = r12.f13439o1;
        this.f13440p1 = r12.f13440p1;
        this.f13441q1 = r12.f13441q1;
        this.f13442r1 = r12.f13442r1;
        this.f13443s1 = r12.f13443s1;
        this.f13444t1 = r12.f13444t1;
        this.f13445u1 = r12.f13445u1;
        this.f13446v1 = r12.f13446v1;
        this.f13447w1 = r12.f13447w1;
        this.f13448x1 = r12.f13448x1;
        this.f13449y1 = r12.f13449y1;
        this.f13450z1 = r12.f13450z1;
        this.A1 = r12.A1;
        this.B1 = r12.B1;
        this.C1 = r12.C1;
    }

    public final void l2(boolean r12) {
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
        float r15 = this.f13441q1;
        ConstraintWidget r16 = null;
        int r17 = 0;
    L15:
        if (r17 >= r13) goto L34;
        if (r12 == false) goto L18;
        int r18 = (r13 - r17) - 1;
        float r19 = 1.0f - this.f13441q1;
    L19:
        ConstraintWidget r20 = this.F1[r18];
        if (r20 == null) goto L33;
        if (r20.U() == 8) goto L33;
        if (r17 != 0) goto L27;
        r20.i(r20.Q, this.Q, B1());
        r20.P0(this.f13435k1);
        r20.O0(r19);
    L27:
        if (r17 != (r13 - 1)) goto L29;
        r20.i(r20.S, this.S, C1());
    L29:
        if (r17 <= 0) goto L32;
        if (r16 == null) goto L32;
        r20.i(r20.Q, r16.S, this.f13447w1);
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
        r21.i(r21.R, this.R, D1());
        r21.g1(this.f13436l1);
        r21.f1(this.f13442r1);
    L44:
        if (r110 != (r14 - 1)) goto L46;
        r21.i(r21.T, this.T, A1());
    L46:
        if (r110 <= 0) goto L49;
        if (r16 == null) goto L49;
        r21.i(r21.R, r16.T, this.f13448x1);
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

    public final int m2(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r12 = r10.f13297x;
        if (r12 != 0) goto L11;
        return 0;
    L11:
        if (r12 != 2) goto L16;
        int r13 = (int) (r10.E * r11);
        if (r13 == r10.w()) goto L15;
        r10.a1(true);
        F1(r10, r10.z(), r10.V(), ConstraintWidget.DimensionBehaviour.FIXED, r13);
    L15:
        return r13;
    L16:
        if (r12 != 1) goto L20;
        return r10.w();
    L20:
        if (r12 != 3) goto L24;
        return (int) ((r10.V() * r10.f13262f0) + 0.5f);
    L24:
        return r10.w();
    }

    public final int n2(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r12 = r10.f13295w;
        if (r12 != 0) goto L11;
        return 0;
    L11:
        if (r12 != 2) goto L16;
        int r13 = (int) (r10.B * r11);
        if (r13 == r10.V()) goto L15;
        r10.a1(true);
        F1(r10, ConstraintWidget.DimensionBehaviour.FIXED, r13, r10.S(), r10.w());
    L15:
        return r13;
    L16:
        if (r12 != 1) goto L20;
        return r10.V();
    L20:
        if (r12 != 3) goto L24;
        return (int) ((r10.w() * r10.f13262f0) + 0.5f);
    L24:
        return r10.V();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    public final void o2(ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        if (r13 != 0) goto L19;
        int r10 = this.B1;
        if (r10 > 0) goto L18;
        r10 = 0;
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r12) goto L18;
        if (r16 <= 0) goto L10;
        r17 = r17 + this.f13447w1;
    L10:
        ConstraintWidget r18 = r11[r16];
        if (r18 == null) goto L17;
        r17 = r17 + n2(r18, r14);
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
        int r28 = n2(r27, r14);
        ConstraintWidget r29 = this.F1[r24];
        if (r29 != null) goto L78;
    L79:
        this.F1[r24] = r27;
    L80:
        int r30 = m2(r27, r14);
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
        r33 = r33 + this.f13447w1;
    L93:
        r33 = r33 + n2(r34, r14);
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
        r36 = r36 + this.f13448x1;
    L101:
        r36 = r36 + m2(r37, r14);
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
        r39 = r39 + this.f13448x1;
    L25:
        ConstraintWidget r40 = r11[r38];
        if (r40 == null) goto L32;
        r39 = r39 + m2(r40, r14);
        if (r39 > r14) goto L33;
        r20 = r20 + 1;
    L32:
        r38 = r38 + 1;
    L33:
        r19 = 0;
        goto L35
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
    L8:
        if (r13 >= r30) goto L59;
        ConstraintWidget r14 = r29[r13];
        int r15 = n2(r14, r32);
        if (r14.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r11 = r11 + 1;
    L12:
        int r16 = r11;
        if (r12 == r32) goto L17;
        if (((this.f13447w1 + r12) + r15) > r32) goto L17;
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
        r12 = r12 + (this.f13447w1 + r15);
    L17:
        if (a.a(r10) == null) goto L19;
        r17 = true;
    L59:
        int r19 = this.D1.size();
        ConstraintAnchor r20 = this.Q;
        ConstraintAnchor r21 = this.R;
        ConstraintAnchor r22 = this.S;
        ConstraintAnchor r23 = this.T;
        int r24 = B1();
        int r25 = D1();
        int r26 = C1();
        int r110 = A1();
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
        r116 = r116 + this.f13447w1;
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
        r213 = C1();
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
        r115 = r115 + this.f13448x1;
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
        r44 = A1();
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
        int r125 = m2(r124, r32);
        if (r124.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r11 = r11 + 1;
    L38:
        int r126 = r11;
        if (r48 == r32) goto L43;
        if (((this.f13448x1 + r48) + r125) > r32) goto L43;
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
        r48 = r48 + (this.f13448x1 + r125);
    L43:
        if (a.a(r10) == null) goto L45;
        r49 = true;
        goto L46
    }

    public final void q2(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.D1.clear();
        a r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        this.D1.add(r10);
        if (r31 != 0) goto L32;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r14 >= r30) goto L57;
        r11 = r11 + 1;
        ConstraintWidget r15 = r29[r14];
        int r16 = n2(r15, r32);
        if (r15.z() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r12 = r12 + 1;
    L12:
        int r17 = r12;
        if (r13 == r32) goto L17;
        if (((this.f13447w1 + r13) + r16) > r32) goto L17;
    L19:
        boolean r18 = false;
    L20:
        if (r18 == true) goto L26;
        if (r14 <= 0) goto L26;
        int r19 = this.B1;
        if (r19 <= 0) goto L26;
        if (r11 <= r19) goto L26;
        r18 = true;
    L26:
        if (r18 == false) goto L28;
        r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        r10.i(r14);
        this.D1.add(r10);
        r13 = r16;
        r11 = 1;
    L31:
        r10.b(r15);
        r14 = r14 + 1;
        r12 = r17;
        goto L8
    L28:
        if (r14 <= 0) goto L30;
        r13 = r13 + (this.f13447w1 + r16);
        goto L31
    L30:
        r13 = r16;
    L17:
        if (a.a(r10) == null) goto L19;
        r18 = true;
    L57:
        int r20 = this.D1.size();
        ConstraintAnchor r21 = this.Q;
        ConstraintAnchor r22 = this.R;
        ConstraintAnchor r23 = this.S;
        ConstraintAnchor r24 = this.T;
        int r25 = B1();
        int r26 = D1();
        int r27 = C1();
        int r110 = A1();
        ConstraintWidget.DimensionBehaviour r111 = z();
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r111 != r112) goto L60;
    L63:
        boolean r113 = true;
    L64:
        if (r12 <= 0) goto L73;
        if (r113 == false) goto L73;
        int r28 = 0;
    L67:
        if (r28 >= r20) goto L73;
        a r114 = (a) this.D1.get(r28);
        if (r31 != 0) goto L71;
        r114.g(r32 - r114.f());
    L72:
        r28 = r28 + 1;
        goto L67
    L71:
        r114.g(r32 - r114.e());
    L73:
        int r210 = r26;
        int r34 = r27;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        int r35 = r25;
        ConstraintAnchor r36 = r22;
        ConstraintAnchor r37 = r21;
        int r38 = r110;
    L74:
        if (r117 >= r20) goto L94;
        a r211 = (a) this.D1.get(r117);
        if (r31 == 0) goto L78;
        ConstraintAnchor r212 = r37;
        int r39 = r115;
        int r40 = r116;
        int r41 = r117;
        if (r41 >= (r20 - 1)) goto L88;
        ConstraintAnchor r213 = a.a((a) this.D1.get(r41 + 1)).Q;
        int r214 = 0;
    L89:
        ConstraintAnchor r118 = a.a(r211).S;
        r211.j(r31, r212, r36, r213, r24, r35, r210, r214, r38, r32);
        r116 = r40 + r211.f();
        int r42 = Math.max(r39, r211.e());
        if (r41 <= 0) goto L92;
        r116 = r116 + this.f13447w1;
    L92:
        r115 = r42;
        r35 = 0;
        r34 = r214;
        r37 = r118;
    L93:
        r117 = r41 + 1;
        r23 = r213;
        goto L74
    L88:
        r213 = this.S;
        r214 = C1();
        goto L89
    L78:
        if (r117 >= (r20 - 1)) goto L80;
        ConstraintAnchor r43 = a.a((a) this.D1.get(r117 + 1)).R;
        int r44 = 0;
    L81:
        ConstraintAnchor r119 = a.a(r211).T;
        ConstraintAnchor r120 = r37;
        ConstraintAnchor r215 = r37;
        int r45 = r115;
        ConstraintAnchor r121 = r36;
        int r46 = r116;
        ConstraintAnchor r122 = r23;
        ConstraintAnchor r310 = r23;
        r41 = r117;
        r211.j(r31, r120, r121, r122, r43, r35, r210, r34, r44, r32);
        int r47 = Math.max(r46, r211.f());
        r115 = r45 + r211.e();
        if (r41 <= 0) goto L84;
        r115 = r115 + this.f13448x1;
    L84:
        r37 = r215;
        r116 = r47;
        r210 = 0;
        r36 = r119;
        r213 = r310;
        int r216 = r44;
        r24 = r43;
        r38 = r216;
        goto L93
    L80:
        r43 = this.T;
        r44 = A1();
        goto L81
    L94:
        r33[0] = r116;
        r33[1] = r115;
        return;
    L60:
        if (S() == r112) goto L63;
        r113 = false;
        goto L64
    L32:
        int r48 = 0;
        r12 = 0;
        int r49 = 0;
        int r123 = 0;
    L33:
        if (r123 >= r30) goto L57;
        r48 = r48 + 1;
        ConstraintWidget r124 = r29[r123];
        int r125 = m2(r124, r32);
        if (r124.S() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        r12 = r12 + 1;
    L37:
        int r126 = r12;
        if (r49 == r32) goto L42;
        if (((this.f13448x1 + r49) + r125) > r32) goto L42;
    L44:
        boolean r50 = false;
    L45:
        if (r50 == true) goto L51;
        if (r123 <= 0) goto L51;
        int r51 = this.B1;
        if (r51 <= 0) goto L51;
        if (r48 <= r51) goto L51;
        r50 = true;
    L51:
        if (r50 == false) goto L53;
        r10 = new a(this, r31, this.Q, this.R, this.S, this.T, r32);
        r10.i(r123);
        this.D1.add(r10);
        r49 = r125;
        r48 = 1;
    L56:
        r10.b(r124);
        r123 = r123 + 1;
        r12 = r126;
        goto L33
    L53:
        if (r123 <= 0) goto L55;
        r49 = r49 + (this.f13448x1 + r125);
        goto L56
    L55:
        r49 = r125;
    L42:
        if (a.a(r10) == null) goto L44;
        r50 = true;
        goto L45
    }

    public final void r2(ConstraintWidget[] r23, int r24, int r25, int r26, int[] r27) {
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
        r11.j(r25, this.Q, this.R, this.S, this.T, B1(), D1(), C1(), A1(), r26);
        goto L9
    }

    public void s2(float r10) {
        this.f13443s1 = r10;
    }

    public void t2(int r10) {
        this.f13437m1 = r10;
    }

    public void u2(float r10) {
        this.f13444t1 = r10;
    }

    public void v2(int r10) {
        this.f13438n1 = r10;
    }

    public void w2(int r10) {
        this.f13449y1 = r10;
    }

    public void x2(float r10) {
        this.f13441q1 = r10;
    }

    public void y2(int r10) {
        this.f13447w1 = r10;
    }

    public void z2(int r10) {
        this.f13435k1 = r10;
    }
}
