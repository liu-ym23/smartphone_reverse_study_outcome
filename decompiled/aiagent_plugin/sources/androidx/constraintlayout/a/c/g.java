package androidx.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: Flow.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends m {
    private int aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private float aH;
    private float aI;
    private float aJ;
    private float aK;
    private float aL;
    private float aM;
    private int aN;
    private int aO;
    private int aP;
    private int aQ;
    private int aR;
    private int aS;
    private int aT;
    private ArrayList<a> aU;
    private e[] aV;
    private e[] aW;
    private int[] aX;
    private e[] aY;
    private int aZ;

    /* JADX INFO: compiled from: Flow.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e f784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d f785e;
        private d f;
        private d g;
        private d h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;

        static /* synthetic */ e a(a r0) {
            return r0.f784d;
        }

        public a(g r3, int r4, d r5, d r6, d r7, d r8, int r9) {
            this.f782b = r3;
            this.f783c = 0;
            this.f784d = null;
            this.f781a = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.f783c = r4;
            this.f785e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r3.f();
            this.j = r3.b();
            this.k = r3.g();
            this.l = r3.c();
            this.r = r9;
        }

        public void a(int r1, d r2, d r3, d r4, d r5, int r6, int r7, int r8, int r9, int r10) {
            this.f783c = r1;
            this.f785e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
            this.j = r7;
            this.k = r8;
            this.l = r9;
            this.r = r10;
        }

        public void a() {
            this.f781a = 0;
            this.f784d = null;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
        }

        public void a(int r1) {
            this.o = r1;
        }

        public int b() {
            if (this.f783c != 0) goto L7;
            return this.m - g.a(this.f782b);
        L7:
            return this.m;
        }

        public int c() {
            if (this.f783c != 1) goto L7;
            return this.n - g.b(this.f782b);
        L7:
            return this.n;
        }

        public void a(e r7) {
            int r2 = 0;
            if (this.f783c != 0) goto L16;
            int r0 = g.a(this.f782b, r7, this.r);
            if (r7.aa() != e.a.f777c) goto L7;
            this.q++;
            r0 = 0;
        L7:
            int r3 = g.a(this.f782b);
            if (r7.B() == 8) goto L11;
            r2 = r3;
        L11:
            this.m += r0 + r2;
            int r1 = g.b(this.f782b, r7, this.r);
            if (this.f784d != null) goto L14;
        L15:
            this.f784d = r7;
            this.f781a = r1;
            this.n = r1;
        L28:
            this.p++;
            return;
        L14:
            if (this.f781a >= r1) goto L28;
        L16:
            int r4 = g.a(this.f782b, r7, this.r);
            int r5 = g.b(this.f782b, r7, this.r);
            if (r7.ab() != e.a.f777c) goto L19;
            this.q++;
            r5 = 0;
        L19:
            int r6 = g.b(this.f782b);
            if (r7.B() == 8) goto L23;
            r2 = r6;
        L23:
            this.n += r5 + r2;
            if (this.f784d != null) goto L26;
        L27:
            this.f784d = r7;
            this.f781a = r4;
            this.m = r4;
            goto L28
        L26:
            if (this.f781a >= r4) goto L28;
            goto L27
        }

        public void a(boolean r17, int r18, boolean r19) {
            int r1 = this.p;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            if ((this.o + r3) >= g.c(this.f782b)) goto L11;
            e r4 = g.d(this.f782b)[this.o + r3];
            if (r4 == null) goto L10;
            r4.Z();
        L10:
            r3 = r3 + 1;
        L11:
            if (r1 != 0) goto L13;
            return;
        L13:
            if (this.f784d == null) goto L222;
            if (r19 == false) goto L18;
            if (r18 != 0) goto L18;
            boolean r5 = true;
        L19:
            int r6 = 0;
            int r7 = -1;
            int r8 = -1;
        L20:
            if (r6 >= r1) goto L35;
            if (r17 == false) goto L23;
            int r9 = (r1 - 1) - r6;
        L25:
            if ((this.o + r9) >= g.c(this.f782b)) goto L35;
            e r10 = g.d(this.f782b)[this.o + r9];
            if (r10 == null) goto L34;
            if (r10.B() != 0) goto L34;
            if (r7 != (-1)) goto L33;
            r7 = r6;
        L33:
            r8 = r6;
        L34:
            r6 = r6 + 1;
            goto L20
        L23:
            r9 = r6;
        L35:
            e r11 = null;
            if (this.f783c != 0) goto L127;
            e r12 = this.f784d;
            r12.w(g.e(this.f782b));
            int r13 = this.j;
            if (r18 <= 0) goto L40;
            r13 = r13 + g.b(this.f782b);
        L40:
            r12.B.a(this.f, r13);
            if (r19 == false) goto L43;
            r12.D.a(this.h, this.l);
        L43:
            if (r18 <= 0) goto L45;
            this.f.f756a.D.a(r12.B, 0);
        L45:
            char r14 = 3;
            if (g.f(this.f782b) == 3) goto L48;
        L61:
            e r15 = r12;
        L62:
            int r16 = 0;
        L63:
            if (r16 >= r1) goto L223;
            if (r17 == false) goto L66;
            int r110 = (r1 - 1) - r16;
        L68:
            if ((this.o + r110) >= g.c(this.f782b)) goto L224;
            e r111 = g.d(this.f782b)[this.o + r110];
            if (r111 != null) goto L73;
            r111 = r11;
            char r20 = r14;
        L126:
            r16 = r16 + 1;
            r14 = r20;
            r11 = r111;
            goto L63
        L73:
            if (r16 != 0) goto L75;
            r111.a(r111.A, this.f785e, this.i);
        L75:
            if (r110 != 0) goto L98;
            int r21 = g.g(this.f782b);
            float r112 = g.h(this.f782b);
            if (r17 == false) goto L80;
            r112 = 1.0f - r112;
        L80:
            if (this.o == 0) goto L82;
        L89:
            if (r19 == true) goto L91;
        L96:
            r111.v(r21);
            r111.a(r112);
            goto L98
        L91:
            if (g.k(this.f782b) == (-1)) goto L96;
            r21 = g.k(this.f782b);
            if (r17 == false) goto L95;
            float r113 = g.l(this.f782b);
        L86:
            float r114 = 1.0f - r113;
        L88:
            r112 = r114;
            goto L96
        L95:
            r114 = g.l(this.f782b);
            goto L88
        L82:
            if (g.i(this.f782b) == (-1)) goto L89;
            r21 = g.i(this.f782b);
            if (r17 == false) goto L87;
            r113 = g.j(this.f782b);
            goto L86
        L87:
            r114 = g.j(this.f782b);
        L98:
            if (r16 != (r1 - 1)) goto L100;
            r111.a(r111.C, this.g, this.k);
        L100:
            if (r11 == null) goto L107;
            r111.A.a(r11.C, g.a(this.f782b));
            if (r16 != r7) goto L104;
            r111.A.b(this.i);
        L104:
            r11.C.a(r111.A, 0);
            if (r16 != (r8 + 1)) goto L107;
            r11.C.b(this.k);
        L107:
            if (r111 == r12) goto L125;
            r20 = 3;
            if (g.f(this.f782b) == 3) goto L111;
        L116:
            int r22 = g.f(this.f782b);
            if (r22 != 0) goto L119;
            r111.B.a(r12.B, 0);
            goto L126
        L119:
            if (r22 == 1) goto L123;
            if (r5 == false) goto L122;
            r111.B.a(this.f, this.j);
            r111.D.a(this.h, this.l);
            goto L126
        L122:
            r111.B.a(r12.B, 0);
            r111.D.a(r12.D, 0);
            goto L126
        L123:
            r111.D.a(r12.D, 0);
            goto L126
        L111:
            if (r15.R() == false) goto L116;
            if (r111 == r15) goto L116;
            if (r111.R() == false) goto L116;
            r111.E.a(r15.E, 0);
            goto L126
        L125:
            r20 = 3;
            goto L126
        L224:
            return;
        L66:
            r110 = r16;
            goto L68
        L223:
            return;
        L48:
            if (r12.R() == true) goto L61;
            int r115 = 0;
        L50:
            if (r115 >= r1) goto L61;
            if (r17 == false) goto L53;
            int r116 = (r1 - 1) - r115;
        L55:
            if ((this.o + r116) >= g.c(this.f782b)) goto L61;
            r15 = g.d(this.f782b)[this.o + r116];
            if (r15.R() == true) goto L62;
            r115 = r115 + 1;
            goto L50
        L53:
            r116 = r115;
            goto L55
        L127:
            e r23 = this.f784d;
            r23.v(g.g(this.f782b));
            int r24 = this.i;
            if (r18 <= 0) goto L130;
            r24 = r24 + g.a(this.f782b);
        L130:
            if (r17 == false) goto L136;
            r23.C.a(this.g, r24);
            if (r19 == false) goto L134;
            r23.A.a(this.f785e, this.k);
        L134:
            if (r18 <= 0) goto L141;
            this.g.f756a.A.a(r23.C, 0);
        L141:
            int r25 = 0;
        L142:
            if (r25 >= r1) goto L225;
            if ((this.o + r25) >= g.c(this.f782b)) goto L226;
            e r117 = g.d(this.f782b)[this.o + r25];
            if (r117 == null) goto L195;
            if (r25 != 0) goto L161;
            r117.a(r117.B, this.f, this.j);
            int r118 = g.e(this.f782b);
            float r119 = g.m(this.f782b);
            if (this.o == 0) goto L153;
        L155:
            if (r19 == true) goto L157;
        L159:
            r117.w(r118);
            r117.b(r119);
            goto L161
        L157:
            if (g.p(this.f782b) == (-1)) goto L159;
            r118 = g.p(this.f782b);
            r119 = g.q(this.f782b);
            goto L159
        L153:
            if (g.n(this.f782b) == (-1)) goto L155;
            r118 = g.n(this.f782b);
            r119 = g.o(this.f782b);
        L161:
            if (r25 != (r1 - 1)) goto L163;
            r117.a(r117.D, this.h, this.l);
        L163:
            if (r11 == null) goto L170;
            r117.B.a(r11.D, g.b(this.f782b));
            if (r25 != r7) goto L167;
            r117.B.b(this.j);
        L167:
            r11.D.a(r117.B, 0);
            if (r25 != (r8 + 1)) goto L170;
            r11.D.b(this.l);
        L170:
            if (r117 == r23) goto L194;
            if (r17 == false) goto L182;
            int r120 = g.r(this.f782b);
            if (r120 != 0) goto L176;
            r117.C.a(r23.C, 0);
            goto L194
        L176:
            if (r120 == 1) goto L180;
            if (r120 != 2) goto L194;
            r117.A.a(r23.A, 0);
            r117.C.a(r23.C, 0);
            goto L194
        L180:
            r117.A.a(r23.A, 0);
            goto L194
        L182:
            int r121 = g.r(this.f782b);
            if (r121 != 0) goto L185;
            r117.A.a(r23.A, 0);
            goto L194
        L185:
            if (r121 == 1) goto L191;
            if (r121 != 2) goto L194;
            if (r5 == false) goto L190;
            r117.A.a(this.f785e, this.i);
            r117.C.a(this.g, this.k);
            goto L194
        L190:
            r117.A.a(r23.A, 0);
            r117.C.a(r23.C, 0);
            goto L194
        L191:
            r117.C.a(r23.C, 0);
        L194:
            r11 = r117;
        L195:
            r25 = r25 + 1;
            goto L142
        L226:
            return;
        L225:
            return;
        L136:
            r23.A.a(this.f785e, r24);
            if (r19 == false) goto L139;
            r23.C.a(this.g, this.k);
        L139:
            if (r18 <= 0) goto L141;
            this.f785e.f756a.C.a(r23.A, 0);
        L18:
            r5 = false;
            goto L19
        }

        public void b(int r9) {
            int r0 = this.q;
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = this.p;
            int r10 = r9 / r0;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L25;
            if ((this.o + r2) >= g.c(this.f782b)) goto L25;
            e r3 = g.d(this.f782b)[this.o + r2];
            if (this.f783c != 0) goto L18;
            if (r3 == null) goto L24;
            if (r3.aa() != e.a.f777c) goto L24;
            if (r3.n != 0) goto L24;
            this.f782b.a(r3, e.a.f775a, r10, r3.ab(), r3.G());
        L24:
            r2 = r2 + 1;
            goto L6
        L18:
            if (r3 == null) goto L24;
            if (r3.ab() != e.a.f777c) goto L24;
            if (r3.o != 0) goto L24;
            this.f782b.a(r3, r3.aa(), r3.F(), e.a.f775a, r10);
        L25:
            d();
        }

        private void d() {
            this.m = 0;
            this.n = 0;
            this.f784d = null;
            this.f781a = 0;
            int r1 = this.p;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L26;
            if ((this.o + r2) >= g.c(this.f782b)) goto L33;
            e r3 = g.d(this.f782b)[this.o + r2];
            if (this.f783c != 0) goto L17;
            int r4 = r3.F();
            int r6 = g.a(this.f782b);
            if (r3.B() != 8) goto L12;
            r6 = 0;
        L12:
            this.m += r4 + r6;
            int r5 = g.b(this.f782b, r3, this.r);
            if (this.f784d != null) goto L15;
        L16:
            this.f784d = r3;
            this.f781a = r5;
            this.n = r5;
        L25:
            r2 = r2 + 1;
            goto L3
        L15:
            if (this.f781a >= r5) goto L25;
        L17:
            int r7 = g.a(this.f782b, r3, this.r);
            int r8 = g.b(this.f782b, r3, this.r);
            int r9 = g.b(this.f782b);
            if (r3.B() != 8) goto L20;
            r9 = 0;
        L20:
            this.n += r8 + r9;
            if (this.f784d != null) goto L23;
        L24:
            this.f784d = r3;
            this.f781a = r7;
            this.m = r7;
            goto L25
        L23:
            if (this.f781a >= r7) goto L25;
        L33:
            return;
        }
    }

    public g() {
        this.aB = -1;
        this.aC = -1;
        this.aD = -1;
        this.aE = -1;
        this.aF = -1;
        this.aG = -1;
        this.aH = 0.5f;
        this.aI = 0.5f;
        this.aJ = 0.5f;
        this.aK = 0.5f;
        this.aL = 0.5f;
        this.aM = 0.5f;
        this.aN = 0;
        this.aO = 0;
        this.aP = 2;
        this.aQ = 2;
        this.aR = 0;
        this.aS = -1;
        this.aT = 0;
        this.aU = new ArrayList();
        this.aV = null;
        this.aW = null;
        this.aX = null;
        this.aZ = 0;
    }

    static /* synthetic */ int a(g r0) {
        return r0.aN;
    }

    static /* synthetic */ int a(g r0, e r1, int r2) {
        return r0.a(r1, r2);
    }

    static /* synthetic */ int b(g r0) {
        return r0.aO;
    }

    static /* synthetic */ int b(g r0, e r1, int r2) {
        return r0.b(r1, r2);
    }

    static /* synthetic */ int c(g r0) {
        return r0.aZ;
    }

    static /* synthetic */ e[] d(g r0) {
        return r0.aY;
    }

    static /* synthetic */ int e(g r0) {
        return r0.aC;
    }

    static /* synthetic */ int f(g r0) {
        return r0.aQ;
    }

    static /* synthetic */ int g(g r0) {
        return r0.aB;
    }

    static /* synthetic */ float h(g r0) {
        return r0.aH;
    }

    static /* synthetic */ int i(g r0) {
        return r0.aD;
    }

    static /* synthetic */ float j(g r0) {
        return r0.aJ;
    }

    static /* synthetic */ int k(g r0) {
        return r0.aF;
    }

    static /* synthetic */ float l(g r0) {
        return r0.aL;
    }

    static /* synthetic */ float m(g r0) {
        return r0.aI;
    }

    static /* synthetic */ int n(g r0) {
        return r0.aE;
    }

    static /* synthetic */ float o(g r0) {
        return r0.aK;
    }

    static /* synthetic */ int p(g r0) {
        return r0.aG;
    }

    static /* synthetic */ float q(g r0) {
        return r0.aM;
    }

    static /* synthetic */ int r(g r0) {
        return r0.aP;
    }

    @Override // androidx.constraintlayout.a.c.j, androidx.constraintlayout.a.c.e
    public void a(e r2, HashMap<e, e> r3) {
        super.a(r2, r3);
        g r4 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        this.aB = r4.aB;
        this.aC = r4.aC;
        this.aD = r4.aD;
        this.aE = r4.aE;
        this.aF = r4.aF;
        this.aG = r4.aG;
        this.aH = r4.aH;
        this.aI = r4.aI;
        this.aJ = r4.aJ;
        this.aK = r4.aK;
        this.aL = r4.aL;
        this.aM = r4.aM;
        this.aN = r4.aN;
        this.aO = r4.aO;
        this.aP = r4.aP;
        this.aQ = r4.aQ;
        this.aR = r4.aR;
        this.aS = r4.aS;
        this.aT = r4.aT;
    }

    public void a(int r1) {
        this.aT = r1;
    }

    public void b(int r1) {
        this.aD = r1;
    }

    public void A(int r1) {
        this.aE = r1;
    }

    public void B(int r1) {
        this.aF = r1;
    }

    public void C(int r1) {
        this.aG = r1;
    }

    public void D(int r1) {
        this.aB = r1;
    }

    public void E(int r1) {
        this.aC = r1;
    }

    public void e(float r1) {
        this.aH = r1;
    }

    public void f(float r1) {
        this.aI = r1;
    }

    public void g(float r1) {
        this.aJ = r1;
    }

    public void h(float r1) {
        this.aK = r1;
    }

    public void i(float r1) {
        this.aL = r1;
    }

    public void j(float r1) {
        this.aM = r1;
    }

    public void F(int r1) {
        this.aP = r1;
    }

    public void G(int r1) {
        this.aQ = r1;
    }

    public void H(int r1) {
        this.aR = r1;
    }

    public void I(int r1) {
        this.aN = r1;
    }

    public void J(int r1) {
        this.aO = r1;
    }

    public void K(int r1) {
        this.aS = r1;
    }

    private final int a(e r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.aa() != e.a.f777c) goto L25;
        if (r10.n != 0) goto L11;
        return 0;
    L11:
        if (r10.n != 2) goto L17;
        int r12 = (int) (r10.s * r11);
        if (r12 == r10.F()) goto L15;
        r10.e(true);
        a(r10, e.a.f775a, r12, r10.ab(), r10.G());
    L15:
        return r12;
    L17:
        if (r10.n != 1) goto L21;
        return r10.F();
    L21:
        if (r10.n != 3) goto L25;
        return (int) ((r10.G() * r10.O) + 0.5f);
    L25:
        return r10.F();
    }

    private final int b(e r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.ab() != e.a.f777c) goto L25;
        if (r10.o != 0) goto L11;
        return 0;
    L11:
        if (r10.o != 2) goto L17;
        int r12 = (int) (r10.v * r11);
        if (r12 == r10.G()) goto L15;
        r10.e(true);
        a(r10, r10.aa(), r10.F(), e.a.f775a, r12);
    L15:
        return r12;
    L17:
        if (r10.o != 1) goto L21;
        return r10.G();
    L21:
        if (r10.o != 3) goto L25;
        return (int) ((r10.F() * r10.O) + 0.5f);
    L25:
        return r10.G();
    }

    @Override // androidx.constraintlayout.a.c.m
    public void b(int r19, int r20, int r21, int r22) {
        if (this.az > 0) goto L5;
    L8:
        int r12 = f();
        int r13 = g();
        int r14 = b();
        int r15 = c();
        int[] r5 = new int[2];
        int r1 = (r20 - r12) - r13;
        int r2 = this.aT;
        if (r2 != 1) goto L11;
        r1 = (r22 - r14) - r15;
    L11:
        int r16 = r1;
        if (r2 != 0) goto L20;
        if (this.aB != (-1)) goto L17;
        this.aB = 0;
    L17:
        if (this.aC != (-1)) goto L25;
        this.aC = 0;
    L25:
        e[] r3 = this.ay;
        int r4 = 0;
        int r6 = 0;
    L27:
        if (r4 >= this.az) goto L32;
        if (this.ay[r4].B() != 8) goto L31;
        r6 = r6 + 1;
    L31:
        r4 = r4 + 1;
        goto L27
    L32:
        int r7 = this.az;
        if (r6 <= 0) goto L42;
        r3 = new e[this.az - r6];
        int r8 = 0;
        int r9 = 0;
    L36:
        if (r8 >= this.az) goto L41;
        e r11 = this.ay[r8];
        if (r11.B() == 8) goto L40;
        r3[r9] = r11;
        r9 = r9 + 1;
    L40:
        r8 = r8 + 1;
        goto L36
    L41:
        r7 = r9;
    L42:
        this.aY = r3;
        this.aZ = r7;
        int r0 = this.aR;
        if (r0 != 0) goto L45;
        boolean r17 = true;
        c(r3, r7, this.aT, r16, r5);
    L56:
        int r10 = (r5[0] + r12) + r13;
        int r18 = (r5[r17 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L59;
        r10 = r20;
    L64:
        if (r21 != 1073741824) goto L66;
        r18 = r22;
    L71:
        h(r10, r18);
        q(r10);
        r(r18);
        if (this.az > 0) goto L75;
        r17 = false;
    L75:
        g(r17);
        return;
    L66:
        if (r21 != Integer.MIN_VALUE) goto L68;
        r18 = Math.min(r18, r22);
        goto L71
    L68:
        if (r21 == 0) goto L71;
        r18 = 0;
        goto L71
    L59:
        if (r19 != Integer.MIN_VALUE) goto L61;
        r10 = Math.min(r10, r20);
        goto L64
    L61:
        if (r19 == 0) goto L64;
        r10 = 0;
        goto L64
    L45:
        if (r0 != 1) goto L47;
        r17 = true;
        a(r3, r7, this.aT, r16, r5);
        goto L56
    L47:
        if (r0 != 2) goto L49;
        r17 = true;
        d(r3, r7, this.aT, r16, r5);
        goto L56
    L49:
        if (r0 == 3) goto L52;
        r17 = true;
        goto L56
    L52:
        r17 = true;
        b(r3, r7, this.aT, r16, r5);
        goto L56
    L20:
        if (this.aB != (-1)) goto L23;
        this.aB = 0;
    L23:
        if (this.aC != (-1)) goto L25;
        this.aC = 0;
        goto L25
    L5:
        if (ah() == true) goto L8;
        h(0, 0);
        g(false);
    }

    private void a(e[] r30, int r31, int r32, int r33, int[] r34) {
        if (r31 != 0) goto L5;
        return;
    L5:
        this.aU.clear();
        a r10 = new a(this, r32, this.A, this.B, this.C, this.D, r33);
        this.aU.add(r10);
        if (r32 != 0) goto L33;
        int r0 = 0;
        int r1 = 0;
        int r11 = 0;
    L8:
        if (r11 >= r31) goto L59;
        e r12 = r30[r11];
        int r13 = a(r12, r33);
        if (r12.aa() != e.a.f777c) goto L12;
        r0 = r0 + 1;
    L12:
        int r14 = r0;
        if (r1 == r33) goto L17;
        if (((this.aN + r1) + r13) > r33) goto L17;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L27;
        if (r11 <= 0) goto L27;
        int r3 = this.aS;
        if (r3 <= 0) goto L27;
        if ((r11 % r3) != 0) goto L27;
        r2 = true;
    L27:
        if (r2 == false) goto L30;
        r10 = new a(this, r32, this.A, this.B, this.C, this.D, r33);
        r10.a(r11);
        this.aU.add(r10);
    L29:
        r1 = r13;
    L32:
        r10.a(r12);
        r11 = r11 + 1;
        r0 = r14;
        goto L8
    L30:
        if (r11 <= 0) goto L29;
        r1 = r1 + (this.aN + r13);
    L17:
        if (a.a(r10) == null) goto L19;
        r2 = true;
    L59:
        int r4 = this.aU.size();
        d r5 = this.A;
        d r6 = this.B;
        d r7 = this.C;
        d r8 = this.D;
        int r9 = f();
        int r15 = b();
        int r16 = g();
        int r17 = c();
        if (aa() != e.a.f776b) goto L62;
    L65:
        boolean r18 = true;
    L66:
        String r19 = "com.obric.aiagent.plugin";
        if (r0 <= 0) goto L76;
        if (r18 == false) goto L76;
        int r20 = 0;
    L70:
        if (r20 >= r4) goto L76;
        a r110 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(r20), a.class, "com.obric.aiagent.plugin");
        if (r32 != 0) goto L74;
        r110.b(r33 - r110.b());
    L75:
        r20 = r20 + 1;
        goto L70
    L74:
        r110.b(r33 - r110.c());
    L76:
        int r22 = r15;
        int r21 = r16;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r23 = r9;
        d r24 = r6;
        d r25 = r5;
        int r26 = r17;
    L77:
        if (r113 >= r4) goto L97;
        a r27 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(r113), a.class, r19);
        if (r32 == 0) goto L81;
        int r35 = r4;
        d r36 = r25;
        int r28 = r111;
        int r29 = r112;
        int r37 = r113;
        String r38 = r19;
        if (r37 >= (r35 - 1)) goto L91;
        d r210 = a.a((a) ZeusTransformUtils.preCheckCast(this.aU.get(r37 + 1), a.class, r38)).A;
        int r211 = 0;
    L92:
        d r114 = a.a(r27).C;
        r27.a(r32, r36, r24, r210, r8, r23, r22, r211, r26, r33);
        r112 = r29 + r27.b();
        int r39 = Math.max(r28, r27.c());
        if (r37 <= 0) goto L95;
        r112 = r112 + this.aN;
    L95:
        r111 = r39;
        r23 = 0;
        r25 = r114;
    L96:
        r113 = r37 + 1;
        r4 = r35;
        r19 = r38;
        r7 = r210;
        r21 = r211;
        goto L77
    L91:
        r210 = this.C;
        r211 = g();
        goto L92
    L81:
        if (r113 >= (r4 - 1)) goto L83;
        d r40 = a.a((a) ZeusTransformUtils.preCheckCast(this.aU.get(r113 + 1), a.class, r19)).B;
        int r41 = 0;
    L84:
        d r115 = a.a(r27).D;
        r35 = r4;
        int r42 = r111;
        d r116 = r25;
        d r310 = r25;
        int r43 = r112;
        d r117 = r24;
        int r44 = r113;
        d r118 = r7;
        d r212 = r7;
        r38 = r19;
        r27.a(r32, r116, r117, r118, r40, r23, r22, r21, r41, r33);
        int r45 = Math.max(r43, r27.b());
        r111 = r42 + r27.c();
        if (r44 <= 0) goto L87;
        r111 = r111 + this.aO;
    L87:
        r112 = r45;
        r22 = 0;
        r25 = r310;
        r211 = r21;
        r37 = r44;
        r24 = r115;
        r210 = r212;
        int r213 = r41;
        r8 = r40;
        r26 = r213;
        goto L96
    L83:
        r40 = this.D;
        r41 = c();
        goto L84
    L97:
        r34[0] = r112;
        r34[1] = r111;
        return;
    L62:
        if (ab() == e.a.f776b) goto L65;
        r18 = false;
        goto L66
    L33:
        r0 = 0;
        int r46 = 0;
        int r119 = 0;
    L34:
        if (r119 >= r31) goto L59;
        e r120 = r30[r119];
        int r121 = b(r120, r33);
        if (r120.ab() != e.a.f777c) goto L38;
        r0 = r0 + 1;
    L38:
        int r122 = r0;
        if (r46 == r33) goto L43;
        if (((this.aO + r46) + r121) > r33) goto L43;
    L45:
        boolean r47 = false;
    L46:
        if (r47 == true) goto L53;
        if (r119 <= 0) goto L53;
        int r48 = this.aS;
        if (r48 <= 0) goto L53;
        if ((r119 % r48) != 0) goto L53;
        r47 = true;
    L53:
        if (r47 == false) goto L56;
        r10 = new a(this, r32, this.A, this.B, this.C, this.D, r33);
        r10.a(r119);
        this.aU.add(r10);
    L55:
        r46 = r121;
    L58:
        r10.a(r120);
        r119 = r119 + 1;
        r0 = r122;
        goto L34
    L56:
        if (r119 <= 0) goto L55;
        r46 = r46 + (this.aO + r121);
    L43:
        if (a.a(r10) == null) goto L45;
        r47 = true;
        goto L46
    }

    private void b(e[] r30, int r31, int r32, int r33, int[] r34) {
        if (r31 != 0) goto L5;
        return;
    L5:
        this.aU.clear();
        a r10 = new a(this, r32, this.A, this.B, this.C, this.D, r33);
        this.aU.add(r10);
        if (r32 != 0) goto L33;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        int r11 = 0;
    L8:
        if (r11 >= r31) goto L58;
        int r12 = r0 + 1;
        e r13 = r30[r11];
        int r14 = a(r13, r33);
        if (r13.aa() != e.a.f777c) goto L12;
        r1 = r1 + 1;
    L12:
        int r16 = r1;
        if (r2 == r33) goto L17;
        if (((this.aN + r2) + r14) > r33) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L26;
        if (r11 <= 0) goto L26;
        int r4 = this.aS;
        if (r4 <= 0) goto L26;
        if (r12 <= r4) goto L26;
        r3 = true;
    L26:
        if (r3 == false) goto L28;
        r10 = new a(this, r32, this.A, this.B, this.C, this.D, r33);
        r10.a(r11);
        this.aU.add(r10);
        r0 = r12;
        r2 = r14;
    L32:
        r10.a(r13);
        r11 = r11 + 1;
        r1 = r16;
        goto L8
    L28:
        if (r11 <= 0) goto L30;
        r2 = r2 + (this.aN + r14);
    L31:
        r0 = 0;
        goto L32
    L30:
        r2 = r14;
    L17:
        if (a.a(r10) == null) goto L19;
        r3 = true;
    L58:
        int r5 = this.aU.size();
        d r6 = this.A;
        d r7 = this.B;
        d r8 = this.C;
        d r9 = this.D;
        int r15 = f();
        int r17 = b();
        int r18 = g();
        int r19 = c();
        if (aa() != e.a.f776b) goto L61;
    L64:
        boolean r110 = true;
    L65:
        String r111 = "com.obric.aiagent.plugin";
        if (r1 <= 0) goto L75;
        if (r110 == false) goto L75;
        int r20 = 0;
    L69:
        if (r20 >= r5) goto L75;
        a r112 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(r20), a.class, "com.obric.aiagent.plugin");
        if (r32 != 0) goto L73;
        r112.b(r33 - r112.b());
    L74:
        r20 = r20 + 1;
        goto L69
    L73:
        r112.b(r33 - r112.c());
    L75:
        int r22 = r17;
        int r21 = r18;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r23 = r15;
        d r24 = r7;
        d r25 = r6;
        int r26 = r19;
    L76:
        if (r115 >= r5) goto L96;
        a r27 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(r115), a.class, r111);
        if (r32 == 0) goto L80;
        int r35 = r5;
        d r36 = r25;
        int r28 = r113;
        int r29 = r114;
        int r37 = r115;
        String r38 = r111;
        if (r37 >= (r35 - 1)) goto L90;
        d r210 = a.a((a) ZeusTransformUtils.preCheckCast(this.aU.get(r37 + 1), a.class, r38)).A;
        int r211 = 0;
    L91:
        d r116 = a.a(r27).C;
        r27.a(r32, r36, r24, r210, r9, r23, r22, r211, r26, r33);
        r114 = r29 + r27.b();
        int r39 = Math.max(r28, r27.c());
        if (r37 <= 0) goto L94;
        r114 = r114 + this.aN;
    L94:
        r113 = r39;
        r23 = 0;
        r25 = r116;
    L95:
        r115 = r37 + 1;
        r5 = r35;
        r111 = r38;
        r8 = r210;
        r21 = r211;
        goto L76
    L90:
        r210 = this.C;
        r211 = g();
        goto L91
    L80:
        if (r115 >= (r5 - 1)) goto L82;
        d r40 = a.a((a) ZeusTransformUtils.preCheckCast(this.aU.get(r115 + 1), a.class, r111)).B;
        int r41 = 0;
    L83:
        d r117 = a.a(r27).D;
        r35 = r5;
        int r42 = r113;
        d r118 = r25;
        d r310 = r25;
        int r43 = r114;
        d r119 = r24;
        int r44 = r115;
        d r120 = r8;
        d r212 = r8;
        r38 = r111;
        r27.a(r32, r118, r119, r120, r40, r23, r22, r21, r41, r33);
        int r45 = Math.max(r43, r27.b());
        r113 = r42 + r27.c();
        if (r44 <= 0) goto L86;
        r113 = r113 + this.aO;
    L86:
        r114 = r45;
        r22 = 0;
        r25 = r310;
        r211 = r21;
        r37 = r44;
        r24 = r117;
        r210 = r212;
        int r213 = r41;
        r9 = r40;
        r26 = r213;
        goto L95
    L82:
        r40 = this.D;
        r41 = c();
        goto L83
    L96:
        r34[0] = r114;
        r34[1] = r113;
        return;
    L61:
        if (ab() == e.a.f776b) goto L64;
        r110 = false;
        goto L65
    L33:
        int r46 = 0;
        r1 = 0;
        int r121 = 0;
    L34:
        if (r121 >= r31) goto L58;
        e r122 = r30[r121];
        int r123 = b(r122, r33);
        if (r122.ab() != e.a.f777c) goto L38;
        r1 = r1 + 1;
    L38:
        int r124 = r1;
        if (r46 == r33) goto L43;
        if (((this.aO + r46) + r123) > r33) goto L43;
    L45:
        boolean r47 = false;
    L46:
        if (r47 == true) goto L52;
        if (r121 <= 0) goto L52;
        int r48 = this.aS;
        if (r48 <= 0) goto L52;
        if (r48 >= 0) goto L52;
        r47 = true;
    L52:
        if (r47 == false) goto L55;
        r10 = new a(this, r32, this.A, this.B, this.C, this.D, r33);
        r10.a(r121);
        this.aU.add(r10);
    L54:
        r46 = r123;
    L57:
        r10.a(r122);
        r121 = r121 + 1;
        r1 = r124;
        goto L34
    L55:
        if (r121 <= 0) goto L54;
        r46 = r46 + (this.aO + r123);
    L43:
        if (a.a(r10) == null) goto L45;
        r47 = true;
        goto L46
    }

    private void c(e[] r23, int r24, int r25, int r26, int[] r27) {
        if (r24 != 0) goto L6;
        return;
    L6:
        if (this.aU.size() != 0) goto L8;
        a r11 = new a(this, r25, this.A, this.B, this.C, this.D, r26);
        this.aU.add(r11);
    L9:
        int r0 = 0;
    L10:
        if (r0 >= r24) goto L12;
        r11.a(r23[r0]);
        r0 = r0 + 1;
        goto L10
    L12:
        r27[0] = r11.b();
        r27[1] = r11.c();
        return;
    L8:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(0), a.class, "com.obric.aiagent.plugin");
        r1.a();
        r11 = r1;
        r11.a(r25, this.A, this.B, this.C, this.D, f(), b(), g(), c(), r26);
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x011b -> B:42:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x011d -> B:42:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0123 -> B:42:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0125 -> B:42:0x0063). Please report as a decompilation issue!!! */
    private void d(e[] r17, int r18, int r19, int r20, int[] r21) {
        if (r19 != 0) goto L19;
        int r6 = this.aS;
        if (r6 > 0) goto L18;
        r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L7:
        if (r7 >= r18) goto L18;
        if (r7 <= 0) goto L10;
        r8 = r8 + this.aN;
    L10:
        e r9 = r17[r7];
        if (r9 == null) goto L17;
        r8 = r8 + a(r9, r20);
        if (r8 > r20) goto L18;
        r6 = r6 + 1;
    L17:
        r7 = r7 + 1;
    L18:
        int r10 = r6;
        int r11 = 0;
    L35:
        if (this.aX != null) goto L38;
        this.aX = new int[2];
    L38:
        if (r11 != 0) goto L40;
        if (r19 != 1) goto L40;
    L42:
        boolean r12 = true;
    L44:
        if (r12 == true) goto L111;
        if (r19 != 0) goto L47;
        r11 = (int) Math.ceil(r18 / r10);
    L48:
        e[] r13 = this.aW;
        if (r13 != null) goto L51;
    L54:
        this.aW = new e[r10];
    L55:
        e[] r14 = this.aV;
        if (r14 != null) goto L58;
    L61:
        this.aV = new e[r11];
    L62:
        int r15 = 0;
    L63:
        if (r15 >= r10) goto L87;
        int r16 = 0;
    L65:
        if (r16 >= r11) goto L86;
        int r110 = (r16 * r10) + r15;
        if (r19 != 1) goto L70;
        r110 = (r15 * r11) + r16;
    L70:
        if (r110 >= r17.length) goto L85;
        e r111 = r17[r110];
        if (r111 == null) goto L85;
        int r112 = a(r111, r20);
        e[] r113 = this.aW;
        if (r113[r15] != null) goto L78;
    L79:
        this.aW[r15] = r111;
    L80:
        int r114 = b(r111, r20);
        e[] r115 = this.aV;
        if (r115[r16] != null) goto L83;
    L84:
        this.aV[r16] = r111;
        goto L85
    L83:
        if (r115[r16].G() >= r114) goto L85;
    L78:
        if (r113[r15].F() >= r112) goto L80;
    L85:
        r16 = r16 + 1;
        goto L65
    L86:
        r15 = r15 + 1;
        goto L63
    L87:
        int r116 = 0;
        int r117 = 0;
    L88:
        if (r116 >= r10) goto L95;
        e r118 = this.aW[r116];
        if (r118 == null) goto L94;
        if (r116 <= 0) goto L93;
        r117 = r117 + this.aN;
    L93:
        r117 = r117 + a(r118, r20);
    L94:
        r116 = r116 + 1;
        goto L88
    L95:
        int r119 = 0;
        int r120 = 0;
    L96:
        if (r119 >= r11) goto L103;
        e r121 = this.aV[r119];
        if (r121 == null) goto L102;
        if (r119 <= 0) goto L101;
        r120 = r120 + this.aO;
    L101:
        r120 = r120 + b(r121, r20);
    L102:
        r119 = r119 + 1;
        goto L96
    L103:
        r21[0] = r117;
        r21[1] = r120;
        if (r19 == 0) goto L105;
        if (r120 <= r20) goto L42;
        if (r11 <= 1) goto L42;
        r11 = r11 - 1;
        goto L44
    L105:
        if (r117 <= r20) goto L42;
        if (r10 <= 1) goto L42;
        r10 = r10 - 1;
        goto L44
    L58:
        if (r14.length < r11) goto L61;
        Arrays.fill(r14, null);
        goto L62
    L51:
        if (r13.length < r10) goto L54;
        Arrays.fill(r13, null);
        goto L55
    L47:
        r10 = (int) Math.ceil(r18 / r11);
        goto L48
    L111:
        int[] r0 = this.aX;
        r0[0] = r10;
        r0[1] = r11;
        return;
    L40:
        if (r10 != 0) goto L43;
        if (r19 == 0) goto L42;
    L43:
        r12 = false;
        goto L44
    L19:
        r11 = this.aS;
        if (r11 > 0) goto L33;
        r11 = 0;
        int r22 = 0;
        int r23 = 0;
    L22:
        if (r22 >= r18) goto L33;
        if (r22 <= 0) goto L25;
        r23 = r23 + this.aO;
    L25:
        e r24 = r17[r22];
        if (r24 == null) goto L32;
        r23 = r23 + b(r24, r20);
        if (r23 > r20) goto L33;
        r11 = r11 + 1;
    L32:
        r22 = r22 + 1;
    L33:
        r10 = 0;
        goto L35
    }

    private void h(boolean r12) {
        if (this.aX != null) goto L5;
        return;
    L5:
        if (this.aW != null) goto L7;
        return;
    L7:
        if (this.aV == null) goto L91;
        int r1 = 0;
    L11:
        if (r1 >= this.aZ) goto L13;
        this.aY[r1].Z();
        r1 = r1 + 1;
        goto L11
    L13:
        int[] r2 = this.aX;
        int r3 = r2[0];
        int r4 = r2[1];
        e r5 = null;
        float r6 = this.aH;
        int r7 = 0;
    L15:
        if (r7 >= r3) goto L34;
        if (r12 == false) goto L18;
        int r8 = (r3 - r7) - 1;
        float r9 = 1.0f - this.aH;
    L19:
        e r10 = this.aW[r8];
        if (r10 == null) goto L33;
        if (r10.B() == 8) goto L33;
        if (r7 != 0) goto L27;
        r10.a(r10.A, this.A, f());
        r10.v(this.aB);
        r10.a(r9);
    L27:
        if (r7 != (r3 - 1)) goto L29;
        r10.a(r10.C, this.C, g());
    L29:
        if (r7 <= 0) goto L32;
        if (r5 == null) goto L32;
        r10.a(r10.A, r5.C, this.aN);
        r5.a(r5.C, r10.A, 0);
    L32:
        r5 = r10;
    L33:
        r7 = r7 + 1;
        r6 = r9;
        goto L15
    L18:
        r9 = r6;
        r8 = r7;
        goto L19
    L34:
        int r13 = 0;
    L35:
        if (r13 >= r4) goto L51;
        e r11 = this.aV[r13];
        if (r11 == null) goto L50;
        if (r11.B() == 8) goto L50;
        if (r13 != 0) goto L44;
        r11.a(r11.B, this.B, b());
        r11.w(this.aC);
        r11.b(this.aI);
    L44:
        if (r13 != (r4 - 1)) goto L46;
        r11.a(r11.D, this.D, c());
    L46:
        if (r13 <= 0) goto L49;
        if (r5 == null) goto L49;
        r11.a(r11.B, r5.D, this.aO);
        r5.a(r5.D, r11.B, 0);
    L49:
        r5 = r11;
    L50:
        r13 = r13 + 1;
        goto L35
    L51:
        int r14 = 0;
    L52:
        if (r14 >= r3) goto L92;
        int r15 = 0;
    L54:
        if (r15 >= r4) goto L72;
        int r16 = (r15 * r3) + r14;
        if (this.aT != 1) goto L58;
        r16 = (r14 * r4) + r15;
    L58:
        e[] r17 = this.aY;
        if (r16 >= r17.length) goto L71;
        e r18 = r17[r16];
        if (r18 == null) goto L71;
        if (r18.B() == 8) goto L71;
        e r19 = this.aW[r14];
        e r20 = this.aV[r15];
        if (r18 == r19) goto L69;
        r18.a(r18.A, r19.A, 0);
        r18.a(r18.C, r19.C, 0);
    L69:
        if (r18 == r20) goto L71;
        r18.a(r18.B, r20.B, 0);
        r18.a(r18.D, r20.D, 0);
    L71:
        r15 = r15 + 1;
        goto L54
    L72:
        r14 = r14 + 1;
        goto L52
    L92:
        return;
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(androidx.constraintlayout.a.d r7, boolean r8) {
        super.a(r7, r8);
        if (A() != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        int r2 = this.aR;
        if (r2 == 0) goto L32;
        if (r2 != 1) goto L12;
        int r3 = this.aU.size();
        int r4 = 0;
    L25:
        if (r4 >= r3) goto L34;
        a r5 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r4 != (r3 - 1)) goto L29;
        boolean r6 = true;
    L30:
        r5.a(r9, r4, r6);
        r4 = r4 + 1;
        goto L25
    L29:
        r6 = false;
    L34:
        g(false);
        return;
    L12:
        if (r2 != 2) goto L14;
        h(r9);
        goto L34
    L14:
        if (r2 != 3) goto L34;
        int r10 = this.aU.size();
        int r11 = 0;
    L17:
        if (r11 >= r10) goto L34;
        a r12 = (a) ZeusTransformUtils.preCheckCast(this.aU.get(r11), a.class, "com.obric.aiagent.plugin");
        if (r11 != (r10 - 1)) goto L21;
        boolean r13 = true;
    L22:
        r12.a(r9, r11, r13);
        r11 = r11 + 1;
        goto L17
    L21:
        r13 = false;
        goto L22
    L32:
        if (this.aU.size() <= 0) goto L34;
        ((a) ZeusTransformUtils.preCheckCast(this.aU.get(0), a.class, "com.obric.aiagent.plugin")).a(r9, 0, true);
        goto L34
    L5:
        if (((f) ZeusTransformUtils.preCheckCast(A(), f.class, "com.obric.aiagent.plugin")).ag() == false) goto L7;
        r9 = true;
        goto L8
    }
}
