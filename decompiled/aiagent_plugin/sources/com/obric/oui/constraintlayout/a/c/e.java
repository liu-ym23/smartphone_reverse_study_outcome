package com.obric.oui.constraintlayout.a.c;

import com.obric.oui.constraintlayout.a.c.a.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintWidget.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {
    public static float aa = 0.5f;
    public float A;
    public d B;
    public d C;
    public d D;
    public d E;
    public d F;
    d G;
    d H;
    public d I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public d[] f34748J;
    protected ArrayList<d> K;
    public a[] L;
    public e M;
    int N;
    int O;
    public float P;
    protected int Q;
    protected int R;
    protected int S;
    int T;
    int U;
    protected int V;
    protected int W;
    int X;
    protected int Y;
    protected int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f34749a;
    private boolean aA;
    private int aB;
    private int aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private int aH;
    private int[] aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private int aM;
    private int aN;
    private boolean[] aO;
    private Object aP;
    private int aQ;
    private int aR;
    private boolean aS;
    private String aT;
    private String aU;
    float ab;
    float ac;
    int ad;
    int ae;
    int af;
    int ag;
    boolean ah;
    boolean ai;
    boolean aj;
    boolean ak;
    boolean al;
    boolean am;
    boolean an;
    int ao;
    int ap;
    boolean aq;
    boolean ar;
    public float[] as;
    protected e[] at;
    protected e[] au;
    e av;
    e aw;
    public int ax;
    public int ay;
    private boolean az;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f34750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p[] f34751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.obric.oui.constraintlayout.a.c.a.c f34752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.oui.constraintlayout.a.c.a.c f34753e;
    public com.obric.oui.constraintlayout.a.c.a.l f;
    public com.obric.oui.constraintlayout.a.c.a.n g;
    public boolean[] h;
    boolean i;
    public com.obric.oui.constraintlayout.a.b.a j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int[] p;
    public int q;
    public int r;
    public float s;
    public int t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    int y;
    float z;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.a.c.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintWidget.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34754a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f34755b = null;

        static {
            int[] r0 = new int[a.values().length];
            f34755b = r0;
            r0[a.f34756a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            f34755b[a.f34757b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            f34755b[a.f34759d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            f34755b[a.f34758c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r4 = new int[d.a.values().length];
            f34754a = r4;
            r4[d.a.f34744b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            f34754a[d.a.f34745c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            f34754a[d.a.f34746d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            f34754a[d.a.f34747e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            f34754a[d.a.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            f34754a[d.a.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            f34754a[d.a.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            f34754a[d.a.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            f34754a[d.a.f34743a.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    /* JADX INFO: compiled from: ConstraintWidget.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34756a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34757b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f34758c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f34759d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f34760e = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f34760e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("FIXED", 0);
            f34756a = r0;
            a r1 = new a("WRAP_CONTENT", 1);
            f34757b = r1;
            a r3 = new a("MATCH_CONSTRAINT", 2);
            f34758c = r3;
            a r5 = new a("MATCH_PARENT", 3);
            f34759d = r5;
            f34760e = new a[]{r0, r1, r3, r5};
        }
    }

    static {
    }

    public p c(int r2) {
        if (r2 != 0) goto L6;
        return this.f;
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return this.g;
    }

    public void d(int r2) {
        this.B.a(r2);
        this.R = r2;
    }

    public void e(int r2) {
        this.C.a(r2);
        this.S = r2;
    }

    public boolean j() {
        return this.aF;
    }

    public boolean k() {
        return this.aG;
    }

    public void l() {
        this.aF = true;
    }

    public void m() {
        this.aG = true;
    }

    public void a(int r2, int r3) {
        if (this.aD == false) goto L5;
        return;
    L5:
        this.B.a(r2);
        this.D.a(r3);
        this.R = r2;
        this.N = r3 - r2;
        this.aD = true;
    }

    public void b(int r2, int r3) {
        if (this.aE == false) goto L5;
        return;
    L5:
        this.C.a(r2);
        this.E.a(r3);
        this.S = r2;
        this.O = r3 - r2;
        if (this.aJ == false) goto L8;
        this.F.a(r2 + this.X);
    L8:
        this.aE = true;
    }

    public void f(int r4) {
        if (this.aJ == true) goto L5;
        return;
    L5:
        int r0 = r4 - this.X;
        int r1 = this.O + r0;
        this.S = r0;
        this.C.a(r0);
        this.E.a(r1);
        this.F.a(r4);
        this.aE = true;
    }

    public boolean d() {
        if (this.aD == false) goto L5;
    L10:
        return true;
    L5:
        if (this.B.f() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.D.f() == false) goto L9;
        goto L9
    }

    public boolean e() {
        if (this.aE == false) goto L5;
    L10:
        return true;
    L5:
        if (this.C.f() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.E.f() == false) goto L9;
        goto L9
    }

    public void n() {
        int r0 = 0;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        int r1 = this.K.size();
    L3:
        if (r0 >= r1) goto L5;
        ((d) ZeusTransformUtils.preCheckCast(this.K.get(r0), d.class, "com.obric.aiagent.plugin")).e();
        r0 = r0 + 1;
        goto L3
    }

    public boolean o() {
        int r0 = this.K.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((d) ZeusTransformUtils.preCheckCast(this.K.get(r2), d.class, "com.obric.aiagent.plugin")).b() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean g(int r5) {
        if (r5 != 0) goto L18;
        if (this.B.f34739c == null) goto L7;
        int r6 = 1;
    L9:
        if (this.D.f34739c == null) goto L11;
        int r4 = 1;
    L13:
        if ((r6 + r4) >= 2) goto L16;
        return true;
    L16:
        return false;
    L11:
        r4 = 0;
        goto L13
    L7:
        r6 = 0;
        goto L9
    L18:
        if (this.C.f34739c == null) goto L20;
        int r7 = 1;
    L22:
        if (this.E.f34739c == null) goto L24;
        int r3 = 1;
    L25:
        int r8 = r7 + r3;
        if (this.F.f34739c == null) goto L28;
        int r9 = 1;
    L30:
        if ((r8 + r9) >= 2) goto L33;
        return true;
    L33:
        return false;
    L28:
        r9 = 0;
        goto L30
    L24:
        r3 = 0;
        goto L25
    L20:
        r7 = 0;
        goto L22
    }

    public boolean c(int r4, int r5) {
        if (r4 != 0) goto L18;
        if (this.B.f34739c != null) goto L7;
    L30:
        return false;
    L7:
        if (this.B.f34739c.f() == false) goto L30;
        if (this.D.f34739c == null) goto L30;
        if (this.D.f34739c.f() == false) goto L30;
        if (((this.D.f34739c.d() - this.D.i()) - (this.B.f34739c.d() + this.B.i())) < r5) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.C.f34739c == null) goto L30;
        if (this.C.f34739c.f() == false) goto L30;
        if (this.E.f34739c == null) goto L30;
        if (this.E.f34739c.f() == false) goto L30;
        if (((this.E.f34739c.d() - this.E.i()) - (this.C.f34739c.d() + this.C.i())) < r5) goto L29;
        return true;
    L29:
        return false;
    }

    public boolean p() {
        return this.aL;
    }

    public void b(boolean r1) {
        this.aL = r1;
    }

    public int q() {
        return this.aI[1];
    }

    public int r() {
        return this.aI[0];
    }

    public void h(int r2) {
        this.aI[0] = r2;
    }

    public void i(int r2) {
        this.aI[1] = r2;
    }

    public void c(boolean r1) {
        this.aJ = r1;
    }

    public boolean s() {
        return this.aK;
    }

    public void d(boolean r1) {
        this.aK = r1;
    }

    public void a(int r1, boolean r2) {
        this.aO[r1] = r2;
    }

    public boolean j(int r1) {
        return this.aO[r1];
    }

    public void e(boolean r1) {
        this.f34749a = r1;
    }

    public boolean t() {
        if (this.f34749a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.aR == 8) goto L7;
        return true;
    }

    public void k(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 > 3) goto L8;
        this.aH = r2;
        return;
    }

    public int u() {
        return this.aM;
    }

    public int v() {
        return this.aN;
    }

    public void d(int r1, int r2) {
        this.aM = r1;
        this.aN = r2;
        e(false);
    }

    public void w() {
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.M = null;
        this.A = Float.NaN;
        this.N = 0;
        this.O = 0;
        this.P = 0.0f;
        this.Q = -1;
        this.R = 0;
        this.S = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        float r3 = aa;
        this.ab = r3;
        this.ac = r3;
        this.L[0] = a.f34756a;
        this.L[1] = a.f34756a;
        this.aP = null;
        this.aQ = 0;
        this.aR = 0;
        this.aU = null;
        this.al = false;
        this.am = false;
        this.ao = 0;
        this.ap = 0;
        this.aq = false;
        this.ar = false;
        float[] r0 = this.as;
        r0[0] = -1.0f;
        r0[1] = -1.0f;
        this.l = -1;
        this.m = -1;
        int[] r1 = this.aI;
        r1[0] = Integer.MAX_VALUE;
        r1[1] = Integer.MAX_VALUE;
        this.n = 0;
        this.o = 0;
        this.s = 1.0f;
        this.v = 1.0f;
        this.r = Integer.MAX_VALUE;
        this.u = Integer.MAX_VALUE;
        this.q = 0;
        this.t = 0;
        this.i = false;
        this.y = -1;
        this.z = 1.0f;
        this.an = false;
        boolean[] r2 = this.h;
        r2[0] = true;
        r2[1] = true;
        this.aL = false;
        boolean[] r4 = this.aO;
        r4[0] = false;
        r4[1] = false;
        this.f34749a = true;
        int[] r5 = this.p;
        r5[0] = 0;
        r5[1] = 0;
        this.aB = -1;
        this.aC = -1;
    }

    private void a(StringBuilder r1, String r2, float r3, float r4) {
        if (r3 != r4) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void a(StringBuilder r1, String r2, int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void a(StringBuilder r1, String r2, String r3, String r4) {
        if (r4.equals(r3) == false) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void a(StringBuilder r1, String r2, float r3, int r4) {
        if (r3 != 0.0f) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :  [");
        r1.append(r3);
        r1.append(",");
        r1.append(r4);
        r1.append("");
        r1.append("],\n");
    }

    public boolean x() {
        if (this.L[0] == a.f34758c) goto L5;
        return false;
    L5:
        if (this.L[1] == a.f34758c) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean y() {
        if (this.aB == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.aC != (-1)) goto L8;
        return false;
    }

    public e() {
        this.f34750b = false;
        this.f34751c = new p[2];
        this.f = null;
        this.g = null;
        this.h = new boolean[]{true, true};
        this.i = false;
        this.f34749a = true;
        this.az = false;
        this.aA = true;
        this.aB = -1;
        this.aC = -1;
        this.j = new com.obric.oui.constraintlayout.a.b.a(this);
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.l = -1;
        this.m = -1;
        this.aH = 0;
        this.n = 0;
        this.o = 0;
        this.p = new int[2];
        this.q = 0;
        this.r = 0;
        this.s = 1.0f;
        this.t = 0;
        this.u = 0;
        this.v = 1.0f;
        this.y = -1;
        this.z = 1.0f;
        this.aI = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.A = Float.NaN;
        this.aJ = false;
        this.aL = false;
        this.aM = 0;
        this.aN = 0;
        this.B = new d(this, d.a.f34744b);
        this.C = new d(this, d.a.f34745c);
        this.D = new d(this, d.a.f34746d);
        this.E = new d(this, d.a.f34747e);
        this.F = new d(this, d.a.f);
        this.G = new d(this, d.a.h);
        this.H = new d(this, d.a.i);
        d r5 = new d(this, d.a.g);
        this.I = r5;
        this.f34748J = new d[]{this.B, this.D, this.C, this.E, this.F, r5};
        this.K = new ArrayList();
        this.aO = new boolean[2];
        this.L = new a[]{a.f34756a, a.f34756a};
        this.M = null;
        this.N = 0;
        this.O = 0;
        this.P = 0.0f;
        this.Q = -1;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        float r6 = aa;
        this.ab = r6;
        this.ac = r6;
        this.aQ = 0;
        this.aR = 0;
        this.aS = false;
        this.aT = null;
        this.aU = null;
        this.an = false;
        this.ao = 0;
        this.ap = 0;
        this.as = new float[]{-1.0f, -1.0f};
        this.at = new e[]{null, null};
        this.au = new e[]{null, null};
        this.av = null;
        this.aw = null;
        this.ax = -1;
        this.ay = -1;
        b();
    }

    public void z() {
        if (this.f != null) goto L6;
        this.f = new com.obric.oui.constraintlayout.a.c.a.l(this);
    L6:
        if (this.g != null) goto L9;
        this.g = new com.obric.oui.constraintlayout.a.c.a.n(this);
        return;
    }

    public void a(com.obric.oui.constraintlayout.a.c r2) {
        this.B.a(r2);
        this.C.a(r2);
        this.D.a(r2);
        this.E.a(r2);
        this.F.a(r2);
        this.I.a(r2);
        this.G.a(r2);
        this.H.a(r2);
    }

    private void b() {
        this.K.add(this.B);
        this.K.add(this.C);
        this.K.add(this.D);
        this.K.add(this.E);
        this.K.add(this.G);
        this.K.add(this.H);
        this.K.add(this.I);
        this.K.add(this.F);
    }

    public e A() {
        return this.M;
    }

    public void a_(e r1) {
        this.M = r1;
    }

    public void a(e r7, float r8, int r9) {
        a(d.a.g, r7, d.a.g, r9, 0);
        this.A = r8;
    }

    public String getType() {
        return this.aU;
    }

    public void l(int r1) {
        this.aR = r1;
    }

    public int B() {
        return this.aR;
    }

    public void f(boolean r1) {
        this.aS = r1;
    }

    public String C() {
        return this.aT;
    }

    public void a(String r1) {
        this.aT = r1;
    }

    public void a(com.obric.oui.constraintlayout.a.d r2) {
        r2.a(this.B);
        r2.a(this.C);
        r2.a(this.D);
        r2.a(this.E);
        if (this.X <= 0) goto L6;
        r2.a(this.F);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r3 = "";
        if (this.aU == null) goto L5;
        String r1 = "type: " + this.aU + " ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.aT == null) goto L10;
        r3 = "id: " + this.aT + " ";
    L10:
        return r2.append(r3).append("(").append(this.R).append(", ").append(this.S).append(") - (").append(this.N).append(" x ").append(this.O).append(")").toString();
    L5:
        r1 = "";
        goto L6
    }

    public int D() {
        e r0 = this.M;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L9;
        return ((f) ZeusTransformUtils.preCheckCast(this.M, f.class, "com.obric.aiagent.plugin")).aD + this.R;
    L9:
        return this.R;
    }

    public int E() {
        e r0 = this.M;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L9;
        return ((f) ZeusTransformUtils.preCheckCast(this.M, f.class, "com.obric.aiagent.plugin")).aE + this.S;
    L9:
        return this.S;
    }

    public int F() {
        if (this.aR != 8) goto L7;
        return 0;
    L7:
        return this.N;
    }

    public int G() {
        if (this.aR != 8) goto L7;
        return 0;
    L7:
        return this.O;
    }

    public int m(int r2) {
        if (r2 != 0) goto L6;
        return F();
    L6:
        if (r2 == 1) goto L8;
        return 0;
    L8:
        return G();
    }

    public int H() {
        return this.Y;
    }

    public int I() {
        return this.Z;
    }

    public int J() {
        return D();
    }

    public int K() {
        return E();
    }

    public int L() {
        return D() + this.N;
    }

    public int M() {
        return E() + this.O;
    }

    public int N() {
        d r0 = this.B;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 + r0.f34740d;
    L5:
        d r2 = this.D;
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r1 + r2.f34740d;
    }

    public int O() {
        int r1 = 0;
        if (this.B == null) goto L6;
        r1 = 0 + this.C.f34740d;
    L6:
        if (this.D != null) goto L8;
        return r1;
    L8:
        return r1 + this.E.f34740d;
    }

    public float P() {
        return this.ab;
    }

    public float Q() {
        return this.ac;
    }

    public float n(int r2) {
        if (r2 != 0) goto L6;
        return this.ab;
    L6:
        if (r2 == 1) goto L8;
        return -1.0f;
    L8:
        return this.ac;
    }

    public boolean R() {
        return this.aJ;
    }

    public int S() {
        return this.X;
    }

    public Object T() {
        return this.aP;
    }

    public void o(int r1) {
        this.R = r1;
    }

    public void p(int r1) {
        this.S = r1;
    }

    public void e(int r1, int r2) {
        this.R = r1;
        this.S = r2;
    }

    public void q(int r2) {
        this.N = r2;
        int r0 = this.Y;
        if (r2 >= r0) goto L6;
        this.N = r0;
        return;
    }

    public void r(int r2) {
        this.O = r2;
        int r0 = this.Z;
        if (r2 >= r0) goto L6;
        this.O = r0;
        return;
    }

    public void a(int r1, int r2, int r3, float r4) {
        this.n = r1;
        this.q = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.r = r3;
        this.s = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.n = 2;
        return;
    L14:
        return;
    }

    public void b(int r1, int r2, int r3, float r4) {
        this.o = r1;
        this.t = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.u = r3;
        this.v = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.o = 2;
        return;
    L14:
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void b(String r9) {
        int r0 = 0;
        if (r9 != null) goto L5;
    L43:
        this.P = 0.0f;
        return;
    L5:
        if (r9.length() == 0) goto L43;
        int r1 = -1;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L10;
    L18:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L21;
    L34:
        String r10 = r9.substring(r4);
        if (r10.length() <= 0) goto L38;
        float r11 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L45
    L39:
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L48;
        this.P = r11;
        this.Q = r1;
        return;
    L48:
        return;
    L21:
        if (r5 >= (r2 - 1)) goto L34;
        String r6 = r9.substring(r4, r5);
        String r12 = r9.substring(r5 + 1);
        if (r6.length() <= 0) goto L38;
        if (r12.length() <= 0) goto L38;
        float r7 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L45
        float r13 = Float.parseFloat(r12);     // Catch: NumberFormatException -> L45
        if (r7 <= 0.0f) goto L38;
        if (r13 <= 0.0f) goto L38;
        if (r1 != 1) goto L32;
        r11 = Math.abs(r13 / r7);     // Catch: NumberFormatException -> L45
        goto L39
    L32:
        r11 = Math.abs(r7 / r13);     // Catch: NumberFormatException -> L45
    L38:
        r11 = r0;
        goto L39
    L10:
        if (r3 >= (r2 - 1)) goto L18;
        String r8 = r9.substring(0, r3);
        if (r8.equalsIgnoreCase("W") == false) goto L15;
        r1 = 0;
    L17:
        r4 = r3 + 1;
        goto L18
    L15:
        if (r8.equalsIgnoreCase("H") == false) goto L17;
        r1 = 1;
        goto L17
    }

    public float U() {
        return this.P;
    }

    public int V() {
        return this.Q;
    }

    public void a(float r1) {
        this.ab = r1;
    }

    public void b(float r1) {
        this.ac = r1;
    }

    public void s(int r1) {
        if (r1 >= 0) goto L4;
        this.Y = 0;
        return;
    L4:
        this.Y = r1;
    }

    public void t(int r1) {
        if (r1 >= 0) goto L4;
        this.Z = 0;
        return;
    L4:
        this.Z = r1;
    }

    public void a(int r3, int r4, int r5, int r6) {
        int r7 = r5 - r3;
        int r8 = r6 - r4;
        this.R = r3;
        this.S = r4;
        if (this.aR != 8) goto L7;
        this.N = 0;
        this.O = 0;
        return;
    L7:
        if (this.L[0] != a.f34756a) goto L12;
        int r9 = this.N;
        if (r7 >= r9) goto L12;
        r7 = r9;
    L12:
        if (this.L[1] != a.f34756a) goto L16;
        int r10 = this.O;
        if (r8 >= r10) goto L16;
        r8 = r10;
    L16:
        this.N = r7;
        this.O = r8;
        int r11 = this.Z;
        if (r8 >= r11) goto L19;
        this.O = r11;
    L19:
        int r12 = this.Y;
        if (r7 >= r12) goto L23;
        this.N = r12;
    L23:
        if (this.r <= 0) goto L28;
        if (this.L[0] != a.f34758c) goto L28;
        this.N = Math.min(this.N, this.r);
    L28:
        if (this.u > 0) goto L30;
    L32:
        int r13 = this.N;
        if (r7 == r13) goto L35;
        this.aB = r13;
    L35:
        int r14 = this.O;
        if (r8 == r14) goto L39;
        this.aC = r14;
        return;
    L39:
        return;
    L30:
        if (this.L[1] != a.f34758c) goto L32;
        this.O = Math.min(this.O, this.u);
        goto L32
    }

    public void f(int r1, int r2) {
        this.R = r1;
        int r3 = r2 - r1;
        this.N = r3;
        int r4 = this.Y;
        if (r3 >= r4) goto L6;
        this.N = r4;
        return;
    }

    public void g(int r1, int r2) {
        this.S = r1;
        int r3 = r2 - r1;
        this.O = r3;
        int r4 = this.Z;
        if (r3 >= r4) goto L6;
        this.O = r4;
        return;
    }

    public void u(int r1) {
        this.X = r1;
        if (r1 <= 0) goto L5;
        boolean r2 = true;
    L6:
        this.aJ = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void a(Object r1) {
        this.aP = r1;
    }

    public void c(float r2) {
        this.as[0] = r2;
    }

    public void d(float r2) {
        this.as[1] = r2;
    }

    public void v(int r1) {
        this.ao = r1;
    }

    public int W() {
        return this.ao;
    }

    public void w(int r1) {
        this.ap = r1;
    }

    public int X() {
        return this.ap;
    }

    public boolean a() {
        if (this.aR == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(d.a r1, e r2, d.a r3, int r4, int r5) {
        a(r1).a(r2.a(r3), r4, r5, true);
    }

    public void a(d r2, d r3, int r4) {
        if (r2.h() != this) goto L6;
        a(r2.getType(), r3.h(), r3.getType(), r4);
        return;
    }

    public void a(d.a r2, e r3, d.a r4) {
        a(r2, r3, r4, 0);
    }

    public void a(d.a r4, e r5, d.a r6, int r7) {
        if (r4 != d.a.g) goto L42;
        if (r6 != d.a.g) goto L31;
        d r8 = a(d.a.f34744b);
        d r9 = a(d.a.f34746d);
        d r10 = a(d.a.f34745c);
        d r0 = a(d.a.f34747e);
        boolean r2 = true;
        if (r8 != null) goto L9;
    L10:
        if (r9 != null) goto L12;
    L14:
        a(d.a.f34744b, r5, d.a.f34744b, 0);
        a(d.a.f34746d, r5, d.a.f34746d, 0);
        boolean r11 = true;
    L15:
        if (r10 != null) goto L17;
    L18:
        if (r0 != null) goto L20;
    L22:
        a(d.a.f34745c, r5, d.a.f34745c, 0);
        a(d.a.f34747e, r5, d.a.f34747e, 0);
    L23:
        if (r11 == false) goto L26;
        if (r2 == false) goto L26;
        a(d.a.g).a(r5.a(d.a.g), 0);
        return;
    L26:
        if (r11 == false) goto L28;
        a(d.a.h).a(r5.a(d.a.h), 0);
        return;
    L28:
        if (r2 == false) goto L102;
        a(d.a.i).a(r5.a(d.a.i), 0);
        return;
    L102:
        return;
    L20:
        if (r0.l() == false) goto L22;
    L21:
        r2 = false;
        goto L23
    L17:
        if (r10.l() == true) goto L21;
    L12:
        if (r9.l() == false) goto L14;
    L13:
        r11 = false;
        goto L15
    L9:
        if (r8.l() == true) goto L13;
    L31:
        if (r6 != d.a.f34744b) goto L33;
    L40:
        a(d.a.f34744b, r5, r6, 0);
        a(d.a.f34746d, r5, r6, 0);
        a(d.a.g).a(r5.a(r6), 0);
        return;
    L33:
        if (r6 == d.a.f34746d) goto L40;
        if (r6 != d.a.f34745c) goto L38;
    L39:
        a(d.a.f34745c, r5, r6, 0);
        a(d.a.f34747e, r5, r6, 0);
        a(d.a.g).a(r5.a(r6), 0);
        return;
    L38:
        if (r6 == d.a.f34747e) goto L39;
        return;
    L42:
        if (r4 != d.a.h) goto L49;
        if (r6 != d.a.f34744b) goto L46;
    L47:
        d r12 = a(d.a.f34744b);
        d r13 = r5.a(r6);
        d r14 = a(d.a.f34746d);
        r12.a(r13, 0);
        r14.a(r13, 0);
        a(d.a.h).a(r13, 0);
        return;
    L46:
        if (r6 == d.a.f34746d) goto L47;
    L49:
        if (r4 != d.a.i) goto L56;
        if (r6 != d.a.f34745c) goto L53;
    L54:
        d r15 = r5.a(r6);
        a(d.a.f34745c).a(r15, 0);
        a(d.a.f34747e).a(r15, 0);
        a(d.a.i).a(r15, 0);
        return;
    L53:
        if (r6 == d.a.f34747e) goto L54;
    L56:
        if (r4 != d.a.h) goto L61;
        if (r6 != d.a.h) goto L61;
        a(d.a.f34744b).a(r5.a(d.a.f34744b), 0);
        a(d.a.f34746d).a(r5.a(d.a.f34746d), 0);
        a(d.a.h).a(r5.a(r6), 0);
        return;
    L61:
        if (r4 == d.a.i) goto L63;
    L65:
        d r1 = a(r4);
        d r16 = r5.a(r6);
        if (r1.a(r16) == true) goto L68;
        return;
    L68:
        if (r4 != d.a.f) goto L75;
        d r17 = a(d.a.f34745c);
        d r3 = a(d.a.f34747e);
        if (r17 == null) goto L72;
        r17.k();
    L72:
        if (r3 == null) goto L98;
        r3.k();
    L98:
        r1.a(r16, r7);
        return;
    L75:
        if (r4 != d.a.f34745c) goto L77;
    L89:
        d r18 = a(d.a.f);
        if (r18 == null) goto L92;
        r18.k();
    L92:
        d r19 = a(d.a.g);
        if (r19.j() == r16) goto L95;
        r19.k();
    L95:
        d r20 = a(r4).m();
        d r21 = a(d.a.i);
        if (r21.l() == false) goto L98;
        r20.k();
        r21.k();
        goto L98
    L77:
        if (r4 == d.a.f34747e) goto L89;
        if (r4 != d.a.f34744b) goto L82;
    L83:
        d r22 = a(d.a.g);
        if (r22.j() == r16) goto L86;
        r22.k();
    L86:
        d r23 = a(r4).m();
        d r24 = a(d.a.h);
        if (r24.l() == false) goto L98;
        r23.k();
        r24.k();
        goto L98
    L82:
        if (r4 != d.a.f34746d) goto L98;
    L63:
        if (r6 != d.a.i) goto L65;
        a(d.a.f34745c).a(r5.a(d.a.f34745c), 0);
        a(d.a.f34747e).a(r5.a(d.a.f34747e), 0);
        a(d.a.i).a(r5.a(r6), 0);
    }

    public void Y() {
        Z();
        b(aa);
        a(aa);
    }

    public void Z() {
        e r0 = A();
        if (r0 != null) goto L5;
    L9:
        int r1 = 0;
        int r2 = this.K.size();
    L10:
        if (r1 >= r2) goto L12;
        ((d) ZeusTransformUtils.preCheckCast(this.K.get(r1), d.class, "com.obric.aiagent.plugin")).k();
        r1 = r1 + 1;
        goto L10
    L12:
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L9;
        if (((f) ZeusTransformUtils.preCheckCast(A(), f.class, "com.obric.aiagent.plugin")).ai() == false) goto L9;
    }

    public d a(d.a r3) {
        switch(AnonymousClass1.f34754a[r3.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r3.name());
    L9:
        return this.H;
    L11:
        return this.G;
    L13:
        return this.I;
    L15:
        return this.F;
    L17:
        return this.E;
    L19:
        return this.D;
    L21:
        return this.C;
    L23:
        return this.B;
    }

    public a aa() {
        return this.L[0];
    }

    public a ab() {
        return this.L[1];
    }

    public a x(int r2) {
        if (r2 != 0) goto L6;
        return aa();
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return ab();
    }

    public void a(a r2) {
        this.L[0] = r2;
    }

    public void b(a r2) {
        this.L[1] = r2;
    }

    public boolean ac() {
        if (this.B.f34739c == null) goto L7;
        if (this.B.f34739c.f34739c != this.B) goto L7;
        return true;
    L7:
        if (this.D.f34739c != null) goto L9;
        return false;
    L9:
        if (this.D.f34739c.f34739c != this.D) goto L15;
        return true;
    L15:
        return false;
    }

    public e y(int r2) {
        if (r2 != 0) goto L10;
        if (this.B.f34739c == null) goto L17;
        d r3 = this.B.f34739c.f34739c;
        d r1 = this.B;
        if (r3 == r1) goto L8;
        return null;
    L8:
        return r1.f34739c.f34737a;
    L17:
        return null;
    L10:
        if (r2 == 1) goto L12;
        return null;
    L12:
        if (this.C.f34739c == null) goto L21;
        d r4 = this.C.f34739c.f34739c;
        d r5 = this.C;
        if (r4 == r5) goto L16;
        return null;
    L16:
        return r5.f34739c.f34737a;
    L21:
        return null;
    }

    public e z(int r2) {
        if (r2 != 0) goto L10;
        if (this.D.f34739c == null) goto L17;
        d r3 = this.D.f34739c.f34739c;
        d r1 = this.D;
        if (r3 == r1) goto L8;
        return null;
    L8:
        return r1.f34739c.f34737a;
    L17:
        return null;
    L10:
        if (r2 == 1) goto L12;
        return null;
    L12:
        if (this.E.f34739c == null) goto L21;
        d r4 = this.E.f34739c.f34739c;
        d r5 = this.E;
        if (r4 == r5) goto L16;
        return null;
    L16:
        return r5.f34739c.f34737a;
    L21:
        return null;
    }

    public boolean ad() {
        if (this.C.f34739c == null) goto L7;
        if (this.C.f34739c.f34739c != this.C) goto L7;
        return true;
    L7:
        if (this.E.f34739c != null) goto L9;
        return false;
    L9:
        if (this.E.f34739c.f34739c != this.E) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean a(int r5) {
        int r6 = r5 * 2;
        if (this.f34748J[r6].f34739c == null) goto L11;
        d r0 = this.f34748J[r6].f34739c.f34739c;
        d[] r2 = this.f34748J;
        if (r0 == r2[r6]) goto L11;
        int r7 = r6 + 1;
        if (r2[r7].f34739c == null) goto L11;
        if (this.f34748J[r7].f34739c.f34739c != this.f34748J[r7]) goto L11;
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.obric.oui.constraintlayout.a.d r51, boolean r52) {
        com.obric.oui.constraintlayout.a.h r13 = r51.a(this.B);
        com.obric.oui.constraintlayout.a.h r12 = r51.a(this.D);
        com.obric.oui.constraintlayout.a.h r11 = r51.a(this.C);
        com.obric.oui.constraintlayout.a.h r10 = r51.a(this.E);
        com.obric.oui.constraintlayout.a.h r9 = r51.a(this.F);
        e r0 = this.M;
        if (r0 == null) goto L22;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        e r2 = this.M;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        int r4 = this.aH;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L22;
        boolean r5 = r1;
        boolean r6 = r3;
    L24:
        if (this.aR == 8) goto L26;
    L34:
        boolean r7 = this.aD;
        if (r7 == false) goto L37;
    L38:
        if (r7 == false) goto L48;
        r51.a(r13, this.R);
        r51.a(r12, this.R + this.N);
        if (r5 == false) goto L48;
        e r8 = this.M;
        if (r8 == null) goto L48;
        if (this.aA == false) goto L46;
        f r14 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
        r14.b(this.B);
        r14.d(this.D);
        goto L48
    L46:
        r51.a(r51.a(r8.D), r12, 0, 5);
    L48:
        if (this.aE == false) goto L60;
        r51.a(r11, this.S);
        r51.a(r10, this.S + this.O);
        if (this.F.b() == false) goto L52;
        r51.a(r9, this.S + this.X);
    L52:
        if (r6 == false) goto L60;
        e r15 = this.M;
        if (r15 == null) goto L60;
        if (this.aA == false) goto L58;
        f r16 = (f) ZeusTransformUtils.preCheckCast(r15, f.class, "com.obric.aiagent.plugin");
        r16.a(this.C);
        r16.c(this.E);
        goto L60
    L58:
        r51.a(r51.a(r15.E), r10, 0, 5);
    L60:
        if (this.aD == true) goto L62;
    L66:
        if (com.obric.oui.constraintlayout.a.d.o == null) goto L69;
        com.obric.oui.constraintlayout.a.d.o.A++;
    L69:
        if (r52 == false) goto L102;
        com.obric.oui.constraintlayout.a.c.a.l r17 = this.f;
        if (r17 == null) goto L102;
        if (this.g == null) goto L102;
        if (r17.j.j == false) goto L102;
        if (this.f.k.j == false) goto L102;
        if (this.g.j.j == false) goto L102;
        if (this.g.k.j == false) goto L102;
        if (com.obric.oui.constraintlayout.a.d.o == null) goto L85;
        com.obric.oui.constraintlayout.a.d.o.t++;
    L85:
        r51.a(r13, this.f.j.g);
        r51.a(r12, this.f.k.g);
        r51.a(r11, this.g.j.g);
        r51.a(r10, this.g.k.g);
        r51.a(r9, this.g.f34710a.g);
        if (this.M == null) goto L99;
        if (r5 == true) goto L89;
    L93:
        if (r6 == false) goto L99;
        if (this.h[1] == false) goto L99;
        if (ad() == true) goto L99;
        r51.a(r51.a(this.M.E), r10, 0, 8);
        goto L99
    L89:
        if (this.h[0] == false) goto L93;
        if (ac() == true) goto L93;
        r51.a(r51.a(this.M.D), r12, 0, 8);
    L99:
        this.aD = false;
        this.aE = false;
        return;
    L102:
        if (com.obric.oui.constraintlayout.a.d.o == null) goto L105;
        com.obric.oui.constraintlayout.a.d.o.u++;
    L105:
        if (this.M != null) goto L107;
        boolean r28 = false;
        boolean r29 = false;
    L136:
        int r18 = this.N;
        int r19 = this.Y;
        if (r18 >= r19) goto L139;
        r18 = r19;
    L139:
        int r20 = this.O;
        int r21 = this.Z;
        if (r20 >= r21) goto L143;
        r20 = r21;
    L143:
        if (this.L[0] == a.f34758c) goto L145;
        boolean r22 = true;
    L147:
        if (this.L[1] == a.f34758c) goto L149;
        boolean r23 = true;
    L150:
        this.y = this.Q;
        float r24 = this.P;
        this.z = r24;
        int r25 = this.n;
        int r26 = this.o;
        int r27 = r18;
        if (r24 > 0.0f) goto L153;
    L189:
        int r30 = r20;
        int r31 = r26;
        int r32 = r25;
    L190:
        int r33 = r27;
    L191:
        boolean r34 = false;
    L192:
        int[] r35 = this.p;
        r35[0] = r32;
        r35[1] = r31;
        this.i = r34;
        if (r34 == false) goto L198;
        int r36 = this.y;
        int r37 = -1;
        if (r36 == 0) goto L197;
        if (r36 == (-1)) goto L197;
    L199:
        boolean r110 = false;
    L200:
        if (r34 == false) goto L205;
        int r38 = this.y;
        if (r38 == 1) goto L204;
        if (r38 != r37) goto L205;
    L204:
        boolean r39 = true;
    L207:
        if (this.L[0] == a.f34757b) goto L209;
    L211:
        boolean r210 = false;
    L212:
        if (r210 == false) goto L214;
        int r211 = 0;
    L215:
        boolean r310 = !this.I.l();
        boolean[] r40 = this.aO;
        boolean r212 = r40[0];
        boolean r311 = r40[1];
        if (this.l == 2) goto L251;
        if (this.aD == true) goto L251;
        if (r52 == false) goto L236;
        com.obric.oui.constraintlayout.a.c.a.l r41 = this.f;
        if (r41 == null) goto L236;
        if (r41.j.j == false) goto L236;
        if (this.f.k.j == false) goto L236;
        if (r52 == false) goto L251;
        r51.a(r13, this.f.j.g);
        r51.a(r12, this.f.k.g);
        if (this.M == null) goto L251;
        if (r5 == false) goto L251;
        if (this.h[0] == false) goto L251;
        if (ac() == true) goto L251;
        r51.a(r51.a(this.M.D), r12, 0, 8);
    L236:
        e r42 = this.M;
        if (r42 == null) goto L239;
        com.obric.oui.constraintlayout.a.h r111 = r51.a(r42.D);
    L240:
        e r43 = this.M;
        if (r43 == null) goto L243;
        com.obric.oui.constraintlayout.a.h r44 = r51.a(r43.B);
    L244:
        boolean r213 = this.h[0];
        a[] r45 = this.L;
        a r312 = r45[0];
        d r46 = this.B;
        d r47 = this.D;
        int r48 = this.R;
        int r49 = this.Y;
        int r410 = this.aI[0];
        float r50 = this.ab;
        if (r45[1] != a.f34758c) goto L247;
        boolean r411 = true;
    L248:
        a(r51, true, r5, r6, r213, r44, r111, r312, r210, r46, r47, r48, r211, r49, r410, r50, r110, r411, r29, r28, r212, r32, r31, this.q, this.r, this.s, r310);
        goto L251
    L247:
        r411 = false;
        goto L248
    L243:
        r44 = null;
        goto L244
    L239:
        r111 = null;
    L251:
        if (r52 == false) goto L268;
        com.obric.oui.constraintlayout.a.c.a.n r53 = this.g;
        if (r53 == null) goto L268;
        if (r53.j.j == false) goto L268;
        if (this.g.k.j == false) goto L268;
        com.obric.oui.constraintlayout.a.d r112 = r51;
        com.obric.oui.constraintlayout.a.h r113 = r11;
        r112.a(r113, this.g.j.g);
        com.obric.oui.constraintlayout.a.h r114 = r10;
        r112.a(r114, this.g.k.g);
        com.obric.oui.constraintlayout.a.h r54 = r9;
        r112.a(r54, this.g.f34710a.g);
        e r55 = this.M;
        if (r55 == null) goto L266;
        if (r28 == true) goto L266;
        if (r6 == false) goto L266;
        char r115 = 1;
        if (this.h[1] == false) goto L265;
        int r56 = 8;
        int r116 = 0;
        r112.a(r112.a(r55.E), r114, 0, 8);
    L267:
        int r57 = r116;
        com.obric.oui.constraintlayout.a.d r117 = r112;
    L270:
        if (this.m != 2) goto L272;
        int r58 = r116;
    L273:
        if (r58 == 0) goto L313;
        if (this.aE == true) goto L313;
        if (this.L[r115] == a.f34757b) goto L279;
    L281:
        boolean r59 = r116;
    L282:
        if (r59 == 0) goto L284;
        r30 = r116;
    L284:
        e r60 = this.M;
        if (r60 == null) goto L287;
        com.obric.oui.constraintlayout.a.h r61 = r117.a(r60.E);
    L288:
        e r62 = this.M;
        if (r62 == null) goto L291;
        com.obric.oui.constraintlayout.a.h r63 = r117.a(r62.C);
    L293:
        if (this.X > 0) goto L297;
        if (this.aR == r56) goto L297;
    L306:
        boolean r214 = r310;
    L307:
        boolean r64 = this.h[r115];
        a[] r65 = this.L;
        a r66 = r65[r115];
        d r67 = this.C;
        d r68 = this.E;
        int r69 = this.S;
        int r70 = this.Z;
        int r118 = this.aI[r115];
        float r119 = this.ac;
        if (r65[0] != a.f34758c) goto L310;
        boolean r120 = true;
    L311:
        a(r51, false, r6, r5, r64, r63, r61, r66, r59, r67, r68, r69, r30, r70, r118, r119, r39, r120, r28, r29, r311, r31, r32, this.t, this.u, this.v, r214);
        goto L313
    L310:
        r120 = false;
    L297:
        if (this.F.f34739c == null) goto L303;
        r117.c(r54, r113, S(), r56);
        r117.c(r54, r117.a(this.F.f34739c), this.F.i(), r56);
        if (r6 == 0) goto L301;
        r117.a(r61, r117.a(this.E), r116, 5);
    L301:
        r214 = r116;
        goto L307
    L303:
        if (this.aR != r56) goto L305;
        r117.c(r54, r113, this.F.i(), r56);
        goto L306
    L305:
        r117.c(r54, r113, S(), r56);
        goto L306
    L291:
        r63 = null;
        goto L293
    L287:
        r61 = null;
        goto L288
    L279:
        if (ZeusTransformUtils.instanceOf(this, f.class) == false) goto L281;
        r59 = r115;
    L313:
        if (r34 == false) goto L318;
        e r71 = this;
        if (r71.y != 1) goto L317;
        r51.a(r114, r113, r12, r13, r71.z, 8);
        e r72 = r71;
    L320:
        if (r72.I.l() == false) goto L323;
        r51.a(r72, r72.I.j().h(), (float) Math.toRadians(r72.A + 90.0f), r72.I.i());
    L323:
        r72.aD = false;
        r72.aE = false;
        if (com.obric.oui.constraintlayout.a.d.o == null) goto L327;
        com.obric.oui.constraintlayout.a.d.o.N = r51.g();
        com.obric.oui.constraintlayout.a.d.o.O = r51.h();
        return;
    L327:
        return;
    L317:
        r51.a(r12, r13, r114, r113, r71.z, 8);
        r72 = r71;
        goto L320
    L318:
        r72 = this;
        goto L320
    L272:
        r58 = r57;
        goto L273
    L265:
        r56 = 8;
        r116 = 0;
    L266:
        r56 = 8;
        r116 = 0;
        r115 = 1;
    L268:
        r117 = r51;
        r54 = r9;
        r114 = r10;
        r113 = r11;
        r56 = 8;
        r116 = 0;
        r115 = 1;
        r57 = 1;
        goto L270
    L214:
        r211 = r33;
        goto L215
    L209:
        if (ZeusTransformUtils.instanceOf(this, f.class) == false) goto L211;
        r210 = true;
    L205:
        r39 = false;
    L197:
        r110 = true;
        goto L200
    L198:
        r37 = -1;
        goto L199
    L153:
        if (this.aR == 8) goto L189;
        if (this.L[0] != a.f34758c) goto L159;
        if (r25 != 0) goto L159;
        r25 = 3;
    L159:
        if (this.L[1] != a.f34758c) goto L163;
        if (r26 != 0) goto L163;
        r26 = 3;
    L163:
        if (this.L[0] == a.f34758c) goto L165;
    L170:
        int r73 = 3;
    L172:
        if (this.L[0] != a.f34758c) goto L179;
        if (r25 != r73) goto L179;
        this.y = 0;
        r33 = (int) (this.z * this.O);
        r30 = r20;
        r31 = r26;
        if (this.L[1] == a.f34758c) goto L177;
        r32 = 4;
        goto L191
    L177:
        r32 = r25;
        r34 = true;
    L179:
        if (this.L[1] == a.f34758c) goto L181;
    L188:
        r30 = r20;
        r31 = r26;
        r32 = r25;
        r33 = r27;
        r34 = true;
        goto L192
    L181:
        if (r26 != 3) goto L188;
        this.y = 1;
        if (this.Q != (-1)) goto L185;
        this.z = 1.0f / this.z;
    L185:
        r20 = (int) (this.z * this.N);
        if (this.L[0] == a.f34758c) goto L188;
        r30 = r20;
        r32 = r25;
        r31 = 4;
        goto L190
    L165:
        if (this.L[1] != a.f34758c) goto L170;
        r73 = 3;
        if (r25 != 3) goto L172;
        if (r26 != 3) goto L172;
        a(r5, r6, r22, r23);
        goto L188
    L149:
        r23 = false;
        goto L150
    L145:
        r22 = false;
        goto L147
    L107:
        if (a(0) == false) goto L109;
        ((f) ZeusTransformUtils.preCheckCast(this.M, f.class, "com.obric.aiagent.plugin")).a(this, 0);
        boolean r74 = true;
    L111:
        if (a(1) == false) goto L113;
        ((f) ZeusTransformUtils.preCheckCast(this.M, f.class, r8)).a(this, 1);
        boolean r75 = true;
    L114:
        if (r74 == true) goto L123;
        if (r5 == false) goto L123;
        if (this.aR == 8) goto L123;
        if (this.B.f34739c != null) goto L123;
        if (this.D.f34739c != null) goto L123;
        r51.a(r51.a(this.M.D), r12, 0, 1);
    L123:
        if (r75 == true) goto L134;
        if (r6 == false) goto L134;
        if (this.aR == 8) goto L134;
        if (this.C.f34739c != null) goto L134;
        if (this.E.f34739c != null) goto L134;
        if (this.F != null) goto L134;
        r51.a(r51.a(this.M.E), r10, 0, 1);
    L134:
        r29 = r74;
        r28 = r75;
        goto L136
    L113:
        r75 = ad();
        goto L114
    L109:
        r74 = ac();
        goto L111
    L62:
        if (this.aE == false) goto L66;
        this.aD = false;
        this.aE = false;
        return;
    L37:
        if (this.aE == false) goto L66;
    L26:
        if (this.aS == true) goto L34;
        if (o() == true) goto L34;
        boolean[] r76 = this.aO;
        if (r76[0] == true) goto L34;
        if (r76[1] == true) goto L34;
        return;
    L20:
        r6 = r3;
        r5 = false;
        goto L24
    L21:
        r5 = r1;
        r6 = false;
        goto L24
    L12:
        if (r2.L[1] != a.f34757b) goto L14;
        r3 = true;
        goto L15
    L6:
        if (r0.L[0] != a.f34757b) goto L8;
        r1 = true;
    L22:
        r5 = false;
        r6 = false;
        goto L24
    }

    boolean ae() {
        if (ZeusTransformUtils.instanceOf(this, m.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(this, h.class) == true) goto L8;
        return false;
    }

    public void a(boolean r4, boolean r5, boolean r6, boolean r7) {
        if (this.y != (-1)) goto L13;
        if (r6 == false) goto L7;
        if (r7 == true) goto L7;
        this.y = 0;
    L7:
        if (r6 == true) goto L13;
        if (r7 == false) goto L13;
        this.y = 1;
        if (this.Q != (-1)) goto L13;
        this.z = 1.0f / this.z;
    L13:
        if (this.y != 0) goto L20;
        if (this.C.l() == true) goto L17;
    L18:
        this.y = 1;
    L27:
        if (this.y != (-1)) goto L47;
        if (this.C.l() == false) goto L37;
        if (this.E.l() == false) goto L37;
        if (this.B.l() == false) goto L37;
        if (this.D.l() == true) goto L47;
    L37:
        if (this.C.l() == false) goto L42;
        if (this.E.l() == false) goto L42;
        this.y = 0;
    L42:
        if (this.B.l() == false) goto L47;
        if (this.D.l() == false) goto L47;
        this.z = 1.0f / this.z;
        this.y = 1;
    L47:
        if (this.y != (-1)) goto L58;
        int r8 = this.q;
        if (r8 > 0) goto L51;
    L53:
        if (r8 == 0) goto L55;
        return;
    L55:
        if (this.t <= 0) goto L61;
        this.z = 1.0f / this.z;
        this.y = 1;
        return;
    L61:
        return;
    L51:
        if (this.t != 0) goto L53;
        this.y = 0;
        return;
    L58:
        return;
    L17:
        if (this.E.l() == false) goto L18;
    L20:
        if (this.y != 1) goto L27;
        if (this.B.l() == true) goto L24;
    L25:
        this.y = 0;
        goto L27
    L24:
        if (this.D.l() == true) goto L27;
        goto L25
    }

    private void a(com.obric.oui.constraintlayout.a.d r34, boolean r35, boolean r36, boolean r37, boolean r38, com.obric.oui.constraintlayout.a.h r39, com.obric.oui.constraintlayout.a.h r40, a r41, boolean r42, d r43, d r44, int r45, int r46, int r47, int r48, float r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, int r55, int r56, int r57, int r58, float r59, boolean r60) {
        com.obric.oui.constraintlayout.a.h r9 = r34.a(r43);
        com.obric.oui.constraintlayout.a.h r8 = r34.a(r44);
        com.obric.oui.constraintlayout.a.h r7 = r34.a(r43.j());
        com.obric.oui.constraintlayout.a.h r6 = r34.a(r44.j());
        if (com.obric.oui.constraintlayout.a.d.a() == null) goto L5;
        com.obric.oui.constraintlayout.a.d.a().y++;
    L5:
        boolean r11 = r43.l();
        boolean r12 = r44.l();
        boolean r16 = this.I.l();
        if (r12 == false) goto L8;
        int r5 = (r11 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r5 = r5 + 1;
    L11:
        if (r50 == false) goto L13;
        int r18 = 3;
    L14:
        int r2 = AnonymousClass1.f34755b[r41.ordinal()];
        if (r2 != 1) goto L17;
    L22:
        int r3 = r18;
    L23:
        boolean r19 = false;
    L27:
        int r14 = this.aB;
        if (r14 == (-1)) goto L31;
        if (r35 == false) goto L31;
        this.aB = -1;
        r19 = false;
    L32:
        int r10 = this.aC;
        if (r10 == (-1)) goto L37;
        if (r35 == true) goto L37;
        this.aC = -1;
        r14 = r10;
        r19 = false;
    L37:
        if (this.aR != 8) goto L39;
        r14 = 0;
        r19 = false;
    L39:
        if (r60 == false) goto L47;
        if (r11 == true) goto L44;
        if (r12 == true) goto L44;
        if (r16 == true) goto L44;
        r34.a(r9, r45);
    L44:
        if (r11 == false) goto L47;
        if (r12 == true) goto L47;
        r34.c(r9, r7, r43.i(), 8);
    L47:
        if (r19 == true) goto L58;
        if (r42 == false) goto L55;
        r34.c(r8, r9, 0, 3);
        if (r47 <= 0) goto L53;
        r34.a(r8, r9, r47, 8);
    L53:
        if (r48 >= Integer.MAX_VALUE) goto L56;
        r34.b(r8, r9, r48, 8);
    L56:
        int r1 = r58;
        int r410 = r5;
        boolean r23 = r19;
        boolean r110 = r38;
        int r21 = r57;
    L113:
        if (r60 == false) goto L355;
        if (r52 == false) goto L116;
        int r4 = 0;
        char r13 = 2;
    L356:
        if (r410 >= r13) goto L388;
        if (r36 == false) goto L389;
        if (r110 == false) goto L390;
        r34.a(r9, r39, r4, 8);
        if (r35 == false) goto L362;
    L365:
        int r15 = 1;
    L366:
        if (r35 == false) goto L368;
    L377:
        int r17 = r15;
    L378:
        if (r17 == 0) goto L391;
        r34.a(r40, r8, r4, 8);
        return;
    L391:
        return;
    L368:
        if (this.F.f34739c == null) goto L377;
        e r0 = this.F.f34739c.f34737a;
        if (r0.P != 0.0f) goto L372;
    L376:
        r17 = r4;
        goto L378
    L372:
        if (r0.L[r4] != a.f34758c) goto L376;
        if (r0.L[1] != a.f34758c) goto L376;
        r17 = 1;
        goto L378
    L362:
        if (this.F.f34739c == null) goto L365;
        r15 = r4;
        goto L366
    L390:
        return;
    L389:
        return;
    L388:
        return;
    L116:
        String r32 = "com.obric.aiagent.plugin";
        if (r11 == true) goto L121;
        if (r12 == true) goto L121;
        if (r16 == true) goto L121;
        int r20 = 5;
        int r22 = 0;
    L333:
        boolean r24 = r36;
    L334:
        int r25 = r20;
    L335:
        if (r24 == false) goto L385;
        if (r110 == true) goto L338;
        return;
    L338:
        if (r44.f34739c == null) goto L340;
        int r111 = r44.i();
    L341:
        if (r6 != r40) goto L343;
        return;
    L343:
        if (this.az == true) goto L345;
    L353:
        r34.a(r40, r8, r111, r25);
        return;
    L345:
        if (r8.f == false) goto L353;
        e r26 = this.M;
        if (r26 == null) goto L353;
        f r27 = (f) ZeusTransformUtils.preCheckCast(r26, f.class, r32);
        if (r35 == false) goto L351;
        r27.d(r44);
        return;
    L351:
        r27.c(r44);
        return;
    L340:
        r111 = r22;
        goto L341
    L385:
        return;
    L121:
        if (r11 == false) goto L131;
        if (r12 == true) goto L131;
        e r28 = r43.f34739c.f34737a;
        if (r36 == true) goto L126;
    L128:
        int r112 = 5;
    L129:
        r24 = r36;
        r22 = 0;
        r32 = r32;
        r25 = r112;
        r8 = r8;
        goto L335
    L126:
        if (ZeusTransformUtils.instanceOf(r28, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L128;
        r112 = 8;
    L131:
        if (r11 == true) goto L147;
        if (r12 == false) goto L147;
        r34.c(r8, r6, -r44.i(), 8);
        if (r36 == true) goto L136;
    L332:
        r22 = 0;
        r20 = 5;
        goto L333
    L136:
        if (this.az == true) goto L138;
    L145:
        r20 = 5;
        r34.a(r9, r39, 0, 5);
        r22 = 0;
        goto L333
    L138:
        if (r9.f == false) goto L145;
        e r29 = this.M;
        if (r29 == null) goto L145;
        f r30 = (f) ZeusTransformUtils.preCheckCast(r29, f.class, r32);
        if (r35 == false) goto L144;
        r30.b(r43);
        goto L332
    L144:
        r30.a(r43);
    L147:
        if (r11 == false) goto L332;
        if (r12 == false) goto L332;
        e r113 = r43.f34739c.f34737a;
        e r31 = r44.f34739c.f34737a;
        e r33 = A();
        int r114 = 6;
        if (r23 == false) goto L222;
        if (r3 != 0) goto L171;
        if (r1 != 0) goto L161;
        if (r21 != 0) goto L161;
        if (r7.f == true) goto L157;
    L160:
        boolean r210 = false;
        boolean r211 = false;
        int r61 = 8;
        int r115 = 8;
        boolean r212 = true;
    L163:
        if (ZeusTransformUtils.instanceOf(r113, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L165;
    L169:
        r40 = r40;
        r3 = r3;
        boolean r213 = r212;
        int r62 = r61;
        r114 = 6;
        boolean r214 = r210;
        int r215 = 4;
    L240:
        if (r211 == false) goto L244;
        if (r7 != r6) goto L244;
        if (r113 == r33) goto L244;
        r211 = false;
        boolean r216 = false;
    L245:
        if (r214 == false) goto L254;
        if (r23 == true) goto L252;
        if (r51 == true) goto L252;
        if (r53 == true) goto L252;
        if (r7 != r39) goto L252;
        if (r6 != r40) goto L252;
        r24 = false;
        int r217 = 8;
        int r218 = 8;
        boolean r219 = false;
    L253:
        e r411 = r33;
        r34.a(r9, r7, r43.i(), r49, r6, r8, r44.i(), r218);
        r62 = r217;
        r216 = r219;
    L256:
        if (this.aR == 8) goto L258;
    L260:
        if (r211 == false) goto L270;
        if (r24 == false) goto L269;
        if (r7 == r6) goto L269;
        if (r23 == true) goto L269;
        if (ZeusTransformUtils.instanceOf(r113, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L267;
    L268:
        r62 = 6;
        goto L269
    L267:
        if (ZeusTransformUtils.instanceOf(r31, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L268;
    L269:
        r34.a(r9, r7, r43.i(), r62);
        com.obric.oui.constraintlayout.a.h r63 = r8;
        r34.b(r63, r6, -r44.i(), r62);
    L271:
        if (r24 == false) goto L280;
        if (r54 == false) goto L280;
        if (ZeusTransformUtils.instanceOf(r113, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L280;
        if (ZeusTransformUtils.instanceOf(r31, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L280;
        e r64 = r411;
        if (r31 == r64) goto L281;
        r62 = 6;
        int r65 = 6;
        r216 = true;
    L282:
        if (r216 == false) goto L313;
        if (r213 == false) goto L304;
        if (r53 == false) goto L286;
        if (r37 == false) goto L304;
    L286:
        if (r113 == r64) goto L290;
        if (r31 == r64) goto L290;
        int r66 = r65;
    L292:
        if (ZeusTransformUtils.instanceOf(r113, h.class) == false) goto L294;
    L295:
        r66 = 5;
    L297:
        if (ZeusTransformUtils.instanceOf(r113, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L299;
    L300:
        r66 = 5;
    L301:
        if (r53 == false) goto L303;
        r66 = 5;
    L303:
        r65 = Math.max(r66, r65);
        goto L304
    L299:
        if (ZeusTransformUtils.instanceOf(r31, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L301;
    L294:
        if (ZeusTransformUtils.instanceOf(r31, h.class) == false) goto L297;
    L290:
        r66 = 6;
    L304:
        if (r24 == false) goto L312;
        int r67 = Math.min(r62, r65);
        if (r50 == false) goto L311;
        if (r53 == true) goto L311;
        if (r113 == r64) goto L310;
        if (r31 != r64) goto L311;
    L310:
        r65 = 4;
    L311:
        r65 = r67;
    L312:
        r34.c(r9, r7, r43.i(), r65);
        r34.c(r63, r6, -r44.i(), r65);
    L313:
        if (r24 == true) goto L315;
    L320:
        if (r24 == false) goto L330;
        if (r23 == false) goto L330;
        r8 = r63;
        if (r47 != 0) goto L331;
        if (r21 != 0) goto L331;
        if (r23 == true) goto L327;
    L329:
        r22 = 0;
        r20 = 5;
        r34.a(r8, r9, 0, 5);
        goto L334
    L327:
        if (r3 != 3) goto L329;
        r22 = 0;
        r34.a(r8, r9, 0, 8);
        r20 = 5;
    L331:
        r20 = 5;
        r22 = 0;
    L330:
        r8 = r63;
        goto L331
    L315:
        if (r39 != r7) goto L317;
        int r68 = r43.i();
    L318:
        if (r7 == r39) goto L320;
        r34.a(r9, r39, r68, 5);
        goto L320
    L317:
        r68 = 0;
    L281:
        r65 = r215;
    L280:
        r64 = r411;
        goto L281
    L270:
        r63 = r8;
        goto L271
    L258:
        if (r44.b() == true) goto L260;
        return;
    L252:
        r24 = r36;
        r218 = r114;
        r219 = r216;
        r217 = r62;
        goto L253
    L254:
        r411 = r33;
        r24 = r36;
    L244:
        r216 = true;
        goto L245
    L165:
        if (ZeusTransformUtils.instanceOf(r31, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L169;
        r213 = r212;
        r214 = r210;
        r215 = r115;
        r3 = r3;
    L168:
        r62 = r61;
        r114 = 6;
        goto L240
    L157:
        if (r6.f == false) goto L160;
        r34.c(r9, r7, r43.i(), 8);
        r34.c(r8, r6, -r44.i(), 8);
        return;
    L161:
        r212 = false;
        r61 = 5;
        r115 = 5;
        r210 = true;
        r211 = true;
        goto L163
    L171:
        if (r3 != 2) goto L180;
        if (ZeusTransformUtils.instanceOf(r113, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L236;
        if (ZeusTransformUtils.instanceOf(r31, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L236;
        r40 = r40;
        r3 = r3;
        r114 = 6;
        r62 = 5;
        r215 = 5;
    L238:
        r214 = true;
        r211 = true;
    L239:
        r213 = false;
    L236:
        r62 = 5;
    L237:
        r215 = 4;
        goto L238
    L180:
        if (r3 != 1) goto L183;
        r40 = r40;
        r3 = r3;
        r62 = 8;
        goto L237
    L183:
        if (r3 != 3) goto L220;
        r3 = r3;
        if (this.y != (-1)) goto L195;
        if (r53 == false) goto L191;
        r40 = r40;
        if (r36 == false) goto L190;
        r114 = 5;
    L192:
        r62 = 8;
    L193:
        r215 = 5;
    L194:
        r214 = true;
        r211 = true;
        r213 = true;
        goto L240
    L190:
        r114 = 4;
        goto L192
    L191:
        r40 = r40;
        r114 = 8;
        goto L192
    L195:
        if (r50 == true) goto L197;
        if (r1 <= 0) goto L209;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        goto L193
    L209:
        if (r1 != 0) goto L218;
        if (r21 != 0) goto L218;
        if (r53 == true) goto L213;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        r215 = 8;
        goto L194
    L213:
        if (r113 == r33) goto L216;
        if (r31 == r33) goto L216;
        int r69 = 4;
    L217:
        r62 = r69;
    L219:
        r215 = 4;
    L216:
        r69 = 5;
    L218:
        r62 = 5;
        goto L219
    L197:
        if (r56 != 2) goto L199;
    L202:
        boolean r70 = true;
    L203:
        if (r70 == true) goto L205;
        r61 = 8;
        int r71 = 5;
    L206:
        r215 = r71;
        r214 = true;
        r211 = true;
        r213 = true;
        goto L168
    L205:
        r61 = 5;
        r71 = 4;
        goto L206
    L199:
        if (r56 == 1) goto L202;
        r70 = false;
        goto L203
    L220:
        r3 = r3;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        r215 = 4;
        r214 = false;
        r211 = false;
        goto L239
    L222:
        if (r7.f == false) goto L236;
        if (r6.f == false) goto L236;
        r34.a(r9, r7, r43.i(), r49, r6, r8, r44.i(), 8);
        if (r36 == false) goto L381;
        if (r110 == true) goto L229;
        return;
    L229:
        if (r44.f34739c == null) goto L231;
        int r116 = r44.i();
    L232:
        if (r6 == r40) goto L383;
        r34.a(r40, r8, r116, 5);
        return;
    L383:
        return;
    L231:
        r116 = 0;
        goto L232
    L381:
        return;
    L355:
        r4 = 0;
        r13 = 2;
        goto L356
    L55:
        r34.c(r8, r9, r14, 8);
        goto L56
    L58:
        if (r5 == 2) goto L68;
        if (r50 == true) goto L68;
        if (r3 == 1) goto L63;
        if (r3 != 0) goto L68;
    L63:
        int r72 = Math.max(r57, r14);
        if (r58 <= 0) goto L66;
        r72 = Math.min(r58, r72);
    L66:
        r34.c(r8, r9, r72, 8);
        r110 = r38;
        r1 = r58;
        r410 = r5;
        r23 = false;
        r21 = r57;
    L68:
        if (r57 != (-2)) goto L70;
        int r73 = r14;
    L71:
        if (r58 != (-2)) goto L73;
        r1 = r14;
    L74:
        if (r14 > 0) goto L76;
    L78:
        if (r73 <= 0) goto L80;
        r34.a(r8, r9, r73, 8);
        r14 = Math.max(r14, r73);
    L80:
        if (r1 <= 0) goto L90;
        if (r36 == true) goto L83;
    L85:
        boolean r74 = true;
    L86:
        if (r74 == false) goto L88;
        int r75 = 8;
        r34.b(r8, r9, r1, 8);
    L89:
        r14 = Math.min(r14, r1);
    L92:
        if (r3 != 1) goto L100;
        if (r36 == false) goto L95;
        r34.c(r8, r9, r14, r75);
    L98:
        r410 = r5;
        r23 = r19;
        r110 = r38;
        r21 = r73;
        goto L113
    L95:
        if (r52 == false) goto L97;
        r34.c(r8, r9, r14, 5);
        r34.b(r8, r9, r14, r75);
        goto L98
    L97:
        r34.c(r8, r9, r14, 5);
        r34.b(r8, r9, r14, r75);
        goto L98
    L100:
        if (r3 == 2) goto L102;
        r410 = r5;
        r21 = r73;
        r23 = r19;
        r110 = true;
        goto L113
    L102:
        if (r43.getType() != d.a.f34745c) goto L104;
    L107:
        com.obric.oui.constraintlayout.a.h r76 = r34.a(this.M.a(d.a.f34745c));
        com.obric.oui.constraintlayout.a.h r77 = r34.a(this.M.a(d.a.f34747e));
    L108:
        com.obric.oui.constraintlayout.a.h r220 = r76;
        com.obric.oui.constraintlayout.a.b r78 = r34.c();
        r410 = r5 == true ? 1 : 0;
        r21 = r73;
        r34.a(r78.a(r8, r9, r77, r220, r59));
        if (r36 == false) goto L111;
        r19 = false;
    L111:
        r23 = r19;
        r110 = r38;
        goto L113
    L104:
        if (r43.getType() == d.a.f34747e) goto L107;
        r76 = r34.a(this.M.a(d.a.f34744b));
        r77 = r34.a(this.M.a(d.a.f34746d));
        goto L108
    L88:
        r75 = 8;
        goto L89
    L83:
        if (r3 != 1) goto L85;
        r74 = false;
        goto L86
    L90:
        r75 = 8;
        goto L92
    L76:
        if (r3 == 1) goto L78;
        r14 = 0;
        goto L78
    L73:
        r1 = r58;
        goto L74
    L70:
        r73 = r57;
    L31:
        r14 = r46;
        goto L32
    L17:
        if (r2 == 2) goto L22;
        if (r2 == 3) goto L22;
        if (r2 != 4) goto L22;
        r3 = r18;
        if (r3 == 4) goto L23;
        r19 = true;
        goto L27
    L13:
        r18 = r55;
        goto L14
    L8:
        r5 = r11 ? 1 : 0;
        goto L9
    }

    public void b(com.obric.oui.constraintlayout.a.d r6, boolean r7) {
        int r0 = r6.b(this.B);
        int r1 = r6.b(this.C);
        int r2 = r6.b(this.D);
        int r8 = r6.b(this.E);
        if (r7 == false) goto L11;
        com.obric.oui.constraintlayout.a.c.a.l r3 = this.f;
        if (r3 == null) goto L11;
        if (r3.j.j == false) goto L11;
        if (this.f.k.j == false) goto L11;
        r0 = this.f.j.g;
        r2 = this.f.k.g;
    L11:
        if (r7 == false) goto L19;
        com.obric.oui.constraintlayout.a.c.a.n r9 = this.g;
        if (r9 == null) goto L19;
        if (r9.j.j == false) goto L19;
        if (this.g.k.j == false) goto L19;
        r1 = this.g.j.g;
        r8 = this.g.k.g;
    L19:
        int r4 = r8 - r1;
        if ((r2 - r0) < 0) goto L32;
        if (r4 < 0) goto L32;
        if (r0 == Integer.MIN_VALUE) goto L32;
        if (r0 == Integer.MAX_VALUE) goto L32;
        if (r1 == Integer.MIN_VALUE) goto L32;
        if (r1 == Integer.MAX_VALUE) goto L32;
        if (r2 == Integer.MIN_VALUE) goto L32;
        if (r2 == Integer.MAX_VALUE) goto L32;
        if (r8 == Integer.MIN_VALUE) goto L32;
        if (r8 == Integer.MAX_VALUE) goto L32;
    L33:
        a(r0, r1, r2, r8);
        return;
    L32:
        r8 = 0;
        r0 = 0;
        r1 = 0;
        r2 = 0;
        goto L33
    }

    public void a(e r9, HashMap<e, e> r10) {
        this.l = r9.l;
        this.m = r9.m;
        this.n = r9.n;
        this.o = r9.o;
        int[] r1 = this.p;
        int[] r2 = r9.p;
        r1[0] = r2[0];
        r1[1] = r2[1];
        this.q = r9.q;
        this.r = r9.r;
        this.t = r9.t;
        this.u = r9.u;
        this.v = r9.v;
        this.w = r9.w;
        this.x = r9.x;
        this.y = r9.y;
        this.z = r9.z;
        int[] r3 = r9.aI;
        this.aI = Arrays.copyOf(r3, r3.length);
        this.A = r9.A;
        this.aJ = r9.aJ;
        this.aK = r9.aK;
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.L = (a[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.L, 2), a[].class, "com.obric.aiagent.plugin");
        e r4 = null;
        if (this.M != null) goto L5;
        e r5 = null;
    L6:
        this.M = r5;
        this.N = r9.N;
        this.O = r9.O;
        this.P = r9.P;
        this.Q = r9.Q;
        this.R = r9.R;
        this.S = r9.S;
        this.T = r9.T;
        this.U = r9.U;
        this.V = r9.V;
        this.W = r9.W;
        this.X = r9.X;
        this.Y = r9.Y;
        this.Z = r9.Z;
        this.ab = r9.ab;
        this.ac = r9.ac;
        this.aP = r9.aP;
        this.aQ = r9.aQ;
        this.aR = r9.aR;
        this.aS = r9.aS;
        this.aT = r9.aT;
        this.aU = r9.aU;
        this.ad = r9.ad;
        this.ae = r9.ae;
        this.af = r9.af;
        this.ag = r9.ag;
        this.ah = r9.ah;
        this.ai = r9.ai;
        this.aj = r9.aj;
        this.ak = r9.ak;
        this.al = r9.al;
        this.am = r9.am;
        this.ao = r9.ao;
        this.ap = r9.ap;
        this.aq = r9.aq;
        this.ar = r9.ar;
        float[] r6 = this.as;
        float[] r7 = r9.as;
        r6[0] = r7[0];
        r6[1] = r7[1];
        e[] r8 = this.at;
        e[] r11 = r9.at;
        r8[0] = r11[0];
        r8[1] = r11[1];
        e[] r12 = this.au;
        e[] r13 = r9.au;
        r12[0] = r13[0];
        r12[1] = r13[1];
        e r14 = r9.av;
        if (r14 != null) goto L9;
        e r15 = null;
    L10:
        this.av = r15;
        e r16 = r9.aw;
        if (r16 == null) goto L14;
        r4 = (e) ZeusTransformUtils.preCheckCast(r10.get(r16), e.class, "com.obric.aiagent.plugin");
    L14:
        this.aw = r4;
        return;
    L9:
        r15 = (e) ZeusTransformUtils.preCheckCast(r10.get(r14), e.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r5 = (e) ZeusTransformUtils.preCheckCast(r10.get(r9.M), e.class, "com.obric.aiagent.plugin");
        goto L6
    }

    public void a(boolean r8, boolean r9) {
        boolean r10 = r8 & this.f.g();
        boolean r11 = r9 & this.g.g();
        int r0 = this.f.j.g;
        int r1 = this.g.j.g;
        int r2 = this.f.k.g;
        int r3 = this.g.k.g;
        int r5 = r3 - r1;
        if ((r2 - r0) < 0) goto L15;
        if (r5 < 0) goto L15;
        if (r0 == Integer.MIN_VALUE) goto L15;
        if (r0 == Integer.MAX_VALUE) goto L15;
        if (r1 == Integer.MIN_VALUE) goto L15;
        if (r1 == Integer.MAX_VALUE) goto L15;
        if (r2 == Integer.MIN_VALUE) goto L15;
        if (r2 == Integer.MAX_VALUE) goto L15;
        if (r3 == Integer.MIN_VALUE) goto L15;
        if (r3 == Integer.MAX_VALUE) goto L15;
    L16:
        int r4 = r2 - r0;
        int r6 = r3 - r1;
        if (r10 == false) goto L19;
        this.R = r0;
    L19:
        if (r11 == false) goto L22;
        this.S = r1;
    L22:
        if (this.aR != 8) goto L25;
        this.N = 0;
        this.O = 0;
        return;
    L25:
        if (r10 == true) goto L27;
    L34:
        if (r11 == true) goto L36;
        return;
    L36:
        if (this.L[1] != a.f34756a) goto L40;
        int r12 = this.O;
        if (r6 >= r12) goto L40;
        r6 = r12;
    L40:
        this.O = r6;
        int r13 = this.Z;
        if (r6 >= r13) goto L45;
        this.O = r13;
        return;
    L45:
        return;
    L27:
        if (this.L[0] != a.f34756a) goto L31;
        int r14 = this.N;
        if (r4 >= r14) goto L31;
        r4 = r14;
    L31:
        this.N = r4;
        int r15 = this.Y;
        if (r4 >= r15) goto L34;
        this.N = r15;
    L15:
        r0 = 0;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        goto L16
    }

    public void a(f r9, com.obric.oui.constraintlayout.a.d r10, HashSet<e> r11, int r12, boolean r13) {
        if (r13 == false) goto L8;
        if (r11.contains(this) == true) goto L6;
        return;
    L6:
        k.a(r9, r10, this);
        r11.remove(this);
        a(r10, r9.b(64));
    L8:
        if (r12 != 0) goto L21;
        HashSet<d> r0 = this.B.a();
        if (r0 == null) goto L15;
        Iterator<d> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        ((d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.aiagent.plugin")).f34737a.a(r9, r10, r11, r12, true);
    L15:
        HashSet<d> r8 = this.D.a();
        if (r8 == null) goto L39;
        Iterator<d> r14 = r8.iterator();
    L19:
        if (r14.hasNext() == false) goto L46;
        ((d) ZeusTransformUtils.preCheckCast(r14.next(), d.class, "com.obric.aiagent.plugin")).f34737a.a(r9, r10, r11, r12, true);
        goto L19
    L46:
        return;
    L39:
        return;
    L21:
        HashSet<d> r2 = this.C.a();
        if (r2 == null) goto L27;
        Iterator<d> r3 = r2.iterator();
    L25:
        if (r3.hasNext() == false) goto L27;
        ((d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.aiagent.plugin")).f34737a.a(r9, r10, r11, r12, true);
    L27:
        HashSet<d> r4 = this.E.a();
        if (r4 == null) goto L33;
        Iterator<d> r5 = r4.iterator();
    L31:
        if (r5.hasNext() == false) goto L33;
        ((d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin")).f34737a.a(r9, r10, r11, r12, true);
    L33:
        HashSet<d> r15 = this.F.a();
        if (r15 == null) goto L45;
        Iterator<d> r16 = r15.iterator();
    L37:
        if (r16.hasNext() == false) goto L47;
        ((d) ZeusTransformUtils.preCheckCast(r16.next(), d.class, "com.obric.aiagent.plugin")).f34737a.a(r9, r10, r11, r12, true);
        goto L37
    L47:
        return;
    }

    public void a(StringBuilder r16) {
        r16.append("  " + this.k + ":{\n");
        r16.append("    actualWidth:" + this.N);
        r16.append("\n");
        r16.append("    actualHeight:" + this.O);
        r16.append("\n");
        r16.append("    actualLeft:" + this.R);
        r16.append("\n");
        r16.append("    actualTop:" + this.S);
        r16.append("\n");
        a(r16, "left", this.B);
        a(r16, "top", this.C);
        a(r16, "right", this.D);
        a(r16, "bottom", this.E);
        a(r16, "baseline", this.F);
        a(r16, "centerX", this.G);
        a(r16, "centerY", this.H);
        a(r16, "    width", this.N, this.Y, this.aI[0], this.aB, this.q, this.n, this.s, this.L[0], this.as[0]);
        a(r16, "    height", this.O, this.Z, this.aI[1], this.aC, this.t, this.o, this.v, this.L[1], this.as[1]);
        a(r16, "    dimensionRatio", this.P, this.Q);
        a(r16, "    horizontalBias", this.ab, aa);
        a(r16, "    verticalBias", this.ac, aa);
        a(r16, "    horizontalChainStyle", this.ao, 0);
        a(r16, "    verticalChainStyle", this.ap, 0);
        r16.append("  }");
    }

    private void a(StringBuilder r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, float r9, a r10, float r11) {
        r1.append(r2);
        r1.append(" :  {\n");
        a(r1, "      behavior", r10.toString(), a.f34756a.toString());
        a(r1, "      size", r3, 0);
        a(r1, "      min", r4, 0);
        a(r1, "      max", r5, Integer.MAX_VALUE);
        a(r1, "      matchMin", r7, 0);
        a(r1, "      matchDef", r8, 0);
        a(r1, "      matchPercent", r9, 1.0f);
        r1.append("    },\n");
    }

    private void a(StringBuilder r2, String r3, d r4) {
        if (r4.f34739c != null) goto L5;
        return;
    L5:
        r2.append("    ");
        r2.append(r3);
        r2.append(" : [ '");
        r2.append(r4.f34739c);
        r2.append("'");
        if (r4.f34741e == Integer.MIN_VALUE) goto L8;
    L9:
        r2.append(",");
        r2.append(r4.f34740d);
        if (r4.f34741e == Integer.MIN_VALUE) goto L12;
        r2.append(",");
        r2.append(r4.f34741e);
        r2.append(",");
    L12:
        r2.append(" ] ,\n");
        return;
    L8:
        if (r4.f34740d == 0) goto L12;
        goto L9
    }
}
