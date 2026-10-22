package androidx.constraintlayout.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: LinearSystem.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f790a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f791b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f792c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f793d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f794e = true;
    public static boolean f = false;
    public static e o = null;
    public static long p = 0;
    public static long q = 0;
    private static int r = 1000;
    private a A;
    public boolean g;
    int h;
    androidx.constraintlayout.a.b[] i;
    public boolean j;
    public boolean k;
    int l;
    int m;
    final c n;
    private HashMap<String, h> s;
    private a t;
    private int u;
    private int v;
    private boolean[] w;
    private int x;
    private h[] y;
    private int z;

    /* JADX INFO: compiled from: LinearSystem.java */
    interface a {
        h a(d r1, boolean[] r2);

        void a(a r1);

        void d(h r1);

        boolean e();

        void f();

        h g();
    }

    /* JADX INFO: compiled from: LinearSystem.java */
    class b extends androidx.constraintlayout.a.b {
        final /* synthetic */ d g;

        public b(d r1, c r2) {
            this.g = r1;
            this.f683e = new i(this, r2);
        }
    }

    static {
    }

    public d() {
        this.g = false;
        this.h = 0;
        this.s = null;
        this.u = 32;
        this.v = 32;
        this.i = null;
        this.j = false;
        this.k = false;
        this.w = new boolean[32];
        this.l = 1;
        this.m = 0;
        this.x = 32;
        this.y = new h[r];
        this.z = 0;
        this.i = new androidx.constraintlayout.a.b[32];
        i();
        c r0 = new c();
        this.n = r0;
        this.t = new g(r0);
        if (f == false) goto L5;
        this.A = new b(this, r0);
        return;
    L5:
        this.A = new androidx.constraintlayout.a.b(r0);
    }

    public void a(e r1) {
        o = r1;
    }

    public static e a() {
        return o;
    }

    private void h() {
        int r0 = this.u * 2;
        this.u = r0;
        this.i = (androidx.constraintlayout.a.b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.i, r0), androidx.constraintlayout.a.b[].class, "com.obric.aiagent.plugin");
        c r1 = this.n;
        r1.f692d = (h[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1.f692d, this.u), h[].class, "com.obric.aiagent.plugin");
        int r2 = this.u;
        this.w = new boolean[r2];
        this.v = r2;
        this.x = r2;
        e r3 = o;
        if (r3 == null) goto L6;
        r3.f798d++;
        e r4 = o;
        r4.o = Math.max(r4.o, this.u);
        e r5 = o;
        r5.x = r5.o;
        return;
    }

    private void i() {
        int r2 = 0;
        if (f == false) goto L11;
    L5:
        if (r2 >= this.m) goto L16;
        androidx.constraintlayout.a.b r0 = this.i[r2];
        if (r0 == null) goto L9;
        this.n.f689a.a(r0);
    L9:
        this.i[r2] = null;
        r2 = r2 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r2 >= this.m) goto L23;
        androidx.constraintlayout.a.b r1 = this.i[r2];
        if (r1 == null) goto L15;
        this.n.f690b.a(r1);
    L15:
        this.i[r2] = null;
        r2 = r2 + 1;
        goto L11
    }

    public void b() {
        int r1 = 0;
    L4:
        if (r1 >= this.n.f692d.length) goto L9;
        h r2 = this.n.f692d[r1];
        if (r2 == null) goto L8;
        r2.b();
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        this.n.f691c.a(this.y, this.z);
        this.z = 0;
        Arrays.fill(this.n.f692d, null);
        HashMap<String, h> r3 = this.s;
        if (r3 == null) goto L12;
        r3.clear();
    L12:
        this.h = 0;
        this.t.f();
        this.l = 1;
        int r4 = 0;
    L14:
        if (r4 >= this.m) goto L19;
        androidx.constraintlayout.a.b[] r5 = this.i;
        if (r5[r4] == null) goto L18;
        r5[r4].f681c = false;
    L18:
        r4 = r4 + 1;
        goto L14
    L19:
        i();
        this.m = 0;
        if (f == false) goto L22;
        this.A = new b(this, this.n);
        return;
    L22:
        this.A = new androidx.constraintlayout.a.b(this.n);
    }

    public h a(Object r4) {
        h r0 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((this.l + 1) < this.v) goto L9;
        h();
    L9:
        if (ZeusTransformUtils.instanceOf(r4, androidx.constraintlayout.a.c.d.class) == false) goto L23;
        r0 = ((androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r4, androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).g();
        if (r0 != null) goto L14;
        ((androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r4, androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).a(this.n);
        r0 = ((androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r4, androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).g();
    L14:
        if (r0.f807b == (-1)) goto L20;
        if (r0.f807b > this.h) goto L20;
        if (this.n.f692d[r0.f807b] != null) goto L23;
    L20:
        if (r0.f807b == (-1)) goto L22;
        r0.b();
    L22:
        int r5 = this.h + 1;
        this.h = r5;
        this.l++;
        r0.f807b = r5;
        r0.i = h.a.f811a;
        this.n.f692d[this.h] = r0;
    L23:
        return r0;
    }

    public androidx.constraintlayout.a.b c() {
        if (f == false) goto L8;
        androidx.constraintlayout.a.b r0 = (androidx.constraintlayout.a.b) ZeusTransformUtils.preCheckCast(this.n.f689a.a(), androidx.constraintlayout.a.b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        r0 = new b(this, this.n);
        q++;
    L12:
        h.a();
        return r0;
    L7:
        r0.c();
        goto L12
    L8:
        r0 = (androidx.constraintlayout.a.b) ZeusTransformUtils.preCheckCast(this.n.f690b.a(), androidx.constraintlayout.a.b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        r0 = new androidx.constraintlayout.a.b(this.n);
        p++;
        goto L12
    L11:
        r0.c();
        goto L12
    }

    public h d() {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.m++;
    L6:
        if ((this.l + 1) < this.v) goto L8;
        h();
    L8:
        h r1 = a(h.a.f813c, null);
        int r2 = this.h + 1;
        this.h = r2;
        this.l++;
        r1.f807b = r2;
        this.n.f692d[this.h] = r1;
        return r1;
    }

    public h e() {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.n++;
    L6:
        if ((this.l + 1) < this.v) goto L8;
        h();
    L8:
        h r1 = a(h.a.f813c, null);
        int r2 = this.h + 1;
        this.h = r2;
        this.l++;
        r1.f807b = r2;
        this.n.f692d[this.h] = r1;
        return r1;
    }

    void a(androidx.constraintlayout.a.b r2, int r3, int r4) {
        r2.c(a(r4, null), r3);
    }

    public h a(int r6, String r7) {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.l++;
    L6:
        if ((this.l + 1) < this.v) goto L8;
        h();
    L8:
        h r8 = a(h.a.f814d, r7);
        int r1 = this.h + 1;
        this.h = r1;
        this.l++;
        r8.f807b = r1;
        r8.f809d = r6;
        this.n.f692d[this.h] = r8;
        this.t.d(r8);
        return r8;
    }

    private h a(h.a r4, String r5) {
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.n.f691c.a(), h.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new h(r4, r5);
        r0.a(r4, r5);
    L6:
        int r6 = this.z;
        int r7 = r;
        if (r6 < r7) goto L9;
        int r8 = r7 * 2;
        r = r8;
        this.y = (h[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.y, r8), h[].class, "com.obric.aiagent.plugin");
    L9:
        h[] r9 = this.y;
        int r10 = this.z;
        this.z = r10 + 1;
        r9[r10] = r0;
        return r0;
    L5:
        r0.b();
        r0.a(r4, r5);
        goto L6
    }

    public int b(Object r2) {
        h r1 = ((androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r2, androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).g();
        if (r1 != null) goto L5;
        return 0;
    L5:
        return (int) (r1.f810e + 0.5f);
    }

    public void f() {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.f799e++;
    L6:
        if (this.t.e() == false) goto L10;
        j();
        return;
    L10:
        if (this.j == false) goto L12;
    L15:
        e r1 = o;
        if (r1 == null) goto L18;
        r1.q++;
    L18:
        boolean r2 = false;
        int r3 = 0;
    L20:
        if (r3 >= this.m) goto L25;
        if (this.i[r3].f == false) goto L26;
        r3 = r3 + 1;
    L26:
        if (r2 == true) goto L28;
        a(this.t);
        return;
    L28:
        e r4 = o;
        if (r4 == null) goto L31;
        r4.p++;
    L31:
        j();
        return;
    L25:
        r2 = true;
        goto L26
    L12:
        if (this.k == true) goto L15;
        a(this.t);
    }

    void a(a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        e r0 = o;
        if (r0 == null) goto L5;
        r0.t++;
        e r1 = o;
        r1.u = Math.max(r1.u, this.l);
        e r2 = o;
        r2.v = Math.max(r2.v, this.m);
    L5:
        b(r7);
        a(r7, false);
        j();
    }

    public void a(androidx.constraintlayout.a.b r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        e r0 = o;
        if (r0 == null) goto L9;
        r0.f++;
        if (r8.f == false) goto L9;
        o.g++;
    L9:
        boolean r3 = true;
        if ((this.m + 1) < this.x) goto L12;
    L13:
        h();
    L14:
        boolean r1 = false;
        if (r8.f == true) goto L46;
        r8.c(this);
        if (r8.e() == false) goto L19;
        return;
    L19:
        r8.d();
        if (r8.a(this) == false) goto L41;
        h r4 = e();
        r8.f679a = r4;
        int r5 = this.m;
        b(r8);
        if (this.m != (r5 + 1)) goto L41;
        this.A.a(r8);
        a(this.A, true);
        if (r4.f808c != (-1)) goto L43;
        if (r8.f679a != r4) goto L34;
        h r2 = r8.c(r4);
        if (r2 == null) goto L34;
        e r6 = o;
        if (r6 == null) goto L32;
        r6.j++;
    L32:
        r8.b(r2);
    L34:
        if (r8.f == true) goto L37;
        r8.f679a.a(this, r8);
    L37:
        if (f == false) goto L39;
        this.n.f689a.a(r8);
    L40:
        this.m--;
        goto L43
    L39:
        this.n.f690b.a(r8);
    L43:
        if (r8.a() == true) goto L45;
        return;
    L45:
        r1 = r3;
    L41:
        r3 = false;
    L46:
        if (r1 == true) goto L49;
        b(r8);
        return;
    L49:
        return;
    L12:
        if ((this.l + 1) < this.v) goto L14;
        goto L13
    }

    private final void b(androidx.constraintlayout.a.b r8) {
        if (f792c == true) goto L5;
    L7:
        this.i[this.m] = r8;
        r8.f679a.f808c = this.m;
        this.m++;
        r8.f679a.a(this, r8);
    L9:
        if (f792c == true) goto L11;
        return;
    L11:
        if (this.g == false) goto L47;
        int r0 = 0;
    L14:
        if (r0 >= this.m) goto L37;
        if (this.i[r0] != null) goto L18;
        System.out.println("WTF");
    L18:
        androidx.constraintlayout.a.b[] r1 = this.i;
        if (r1[r0] == null) goto L36;
        if (r1[r0].f == false) goto L36;
        androidx.constraintlayout.a.b r2 = this.i[r0];
        r2.f679a.a(this, r2.f680b);
        if (f == false) goto L25;
        this.n.f689a.a(r2);
    L26:
        this.i[r0] = null;
        int r3 = r0 + 1;
        int r4 = r3;
    L27:
        int r5 = this.m;
        if (r3 >= r5) goto L33;
        androidx.constraintlayout.a.b[] r6 = this.i;
        int r7 = r3 - 1;
        r6[r7] = r6[r3];
        if (r6[r7].f679a.f808c != r3) goto L32;
        this.i[r7].f679a.f808c = r7;
    L32:
        r4 = r3;
        r3 = r3 + 1;
        goto L27
    L33:
        if (r4 >= r5) goto L35;
        this.i[r4] = null;
    L35:
        this.m = r5 - 1;
        r0 = r0 - 1;
        goto L36
    L25:
        this.n.f690b.a(r2);
    L36:
        r0 = r0 + 1;
        goto L14
    L37:
        this.g = false;
        return;
    L47:
        return;
    L5:
        if (r8.f == false) goto L7;
        r8.f679a.a(this, r8.f680b);
        goto L9
    }

    private final int a(a r13, boolean r14) {
        a r15 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.aiagent.plugin");
        e r16 = o;
        if (r16 == null) goto L5;
        r16.h++;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= this.l) goto L9;
        this.w[r2] = false;
        r2 = r2 + 1;
        goto L7
    L9:
        boolean r3 = false;
        int r4 = 0;
    L10:
        if (r3 == true) goto L50;
        e r5 = o;
        if (r5 == null) goto L14;
        r5.i++;
    L14:
        r4 = r4 + 1;
        if (r4 >= (this.l * 2)) goto L16;
        if (r15.g() == null) goto L20;
        this.w[r15.g().f807b] = true;
    L20:
        h r6 = r15.a(this, this.w);
        if (r6 != null) goto L23;
    L26:
        if (r6 != null) goto L27;
        r3 = true;
        goto L10
    L27:
        float r7 = Float.MAX_VALUE;
        int r8 = 0;
        int r9 = -1;
    L29:
        if (r8 >= this.m) goto L44;
        androidx.constraintlayout.a.b r10 = this.i[r8];
        if (r10.f679a.i == h.a.f811a) goto L43;
        if (r10.f == true) goto L43;
        if (r10.a(r6) == false) goto L43;
        float r11 = r10.f683e.b(r6);
        if (r11 >= 0.0f) goto L43;
        float r12 = (-r10.f680b) / r11;
        if (r12 >= r7) goto L43;
        r9 = r8;
        r7 = r12;
    L43:
        r8 = r8 + 1;
        goto L29
    L44:
        if (r9 <= (-1)) goto L10;
        androidx.constraintlayout.a.b r17 = this.i[r9];
        r17.f679a.f808c = -1;
        e r18 = o;
        if (r18 == null) goto L48;
        r18.j++;
    L48:
        r17.b(r6);
        r17.f679a.f808c = r9;
        r17.f679a.a(this, r17);
        goto L10
    L23:
        if (this.w[r6.f807b] == true) goto L24;
        this.w[r6.f807b] = true;
        goto L26
    L24:
        return r4;
    L16:
        return r4;
    L50:
        return r4;
    }

    private int b(a r20) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r20, a.class, "com.obric.aiagent.plugin");
        int r2 = 0;
    L4:
        if (r2 >= this.m) goto L12;
        if (this.i[r2].f679a.i == h.a.f811a) goto L11;
        if (this.i[r2].f680b >= 0.0f) goto L11;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L73;
        boolean r4 = false;
        int r5 = 0;
    L15:
        if (r4 == true) goto L98;
        e r6 = o;
        if (r6 == null) goto L19;
        r6.k++;
    L19:
        r5 = r5 + 1;
        float r7 = Float.MAX_VALUE;
        int r10 = 0;
        int r11 = -1;
        int r12 = -1;
        int r13 = 0;
    L21:
        if (r10 >= this.m) goto L63;
        androidx.constraintlayout.a.b r14 = this.i[r10];
        if (r14.f679a.i == h.a.f811a) goto L61;
        if (r14.f == true) goto L61;
        if (r14.f680b >= 0.0f) goto L61;
        int r15 = 9;
        if (f794e == false) goto L46;
        int r8 = r14.f683e.c();
        int r9 = 0;
    L33:
        if (r9 >= r8) goto L61;
        h r16 = r14.f683e.a(r9);
        float r17 = r14.f683e.b(r16);
        if (r17 <= 0.0f) goto L45;
        int r18 = 0;
    L38:
        if (r18 >= r15) goto L45;
        float r19 = r16.g[r18] / r17;
        if (r19 >= r7) goto L42;
        if (r18 != r13) goto L42;
    L43:
        r12 = r16.f807b;
        r13 = r18;
        r11 = r10;
        r7 = r19;
    L44:
        r18 = r18 + 1;
        r15 = 9;
    L42:
        if (r18 <= r13) goto L44;
    L45:
        r9 = r9 + 1;
        r15 = 9;
        goto L33
    L46:
        int r21 = 1;
    L48:
        if (r21 >= this.l) goto L61;
        h r22 = this.n.f692d[r21];
        float r23 = r14.f683e.b(r22);
        if (r23 <= 0.0f) goto L60;
        int r24 = 0;
    L53:
        if (r24 >= 9) goto L60;
        float r110 = r22.g[r24] / r23;
        if (r110 >= r7) goto L57;
        if (r24 != r13) goto L57;
    L58:
        r12 = r21;
        r13 = r24;
        r11 = r10;
        r7 = r110;
    L59:
        r24 = r24 + 1;
    L57:
        if (r24 <= r13) goto L59;
    L60:
        r21 = r21 + 1;
    L61:
        r10 = r10 + 1;
        goto L21
    L63:
        if (r11 == (-1)) goto L68;
        androidx.constraintlayout.a.b r25 = this.i[r11];
        r25.f679a.f808c = -1;
        e r26 = o;
        if (r26 == null) goto L67;
        r26.j++;
    L67:
        r25.b(this.n.f692d[r12]);
        r25.f679a.f808c = r11;
        r25.f679a.a(this, r25);
    L70:
        if (r5 <= (this.l / 2)) goto L15;
        r4 = true;
        goto L15
    L68:
        r4 = true;
        goto L70
    L98:
        return r5;
    L73:
        return 0;
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        r3 = false;
        goto L13
    }

    private void j() {
        int r0 = 0;
    L4:
        if (r0 >= this.m) goto L6;
        androidx.constraintlayout.a.b r1 = this.i[r0];
        h r2 = r1.f679a;
        r2.f810e = r1.f680b;
        r0 = r0 + 1;
        goto L4
    }

    public c g() {
        return this.n;
    }

    public void a(h r4, h r5, int r6, int r7) {
        androidx.constraintlayout.a.b r0 = c();
        h r1 = d();
        r1.f809d = 0;
        r0.a(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        a(r0, (int) (r0.f683e.b(r1) * (-1.0f)), r7);
    L5:
        a(r0);
    }

    public void a(h r3, h r4, int r5, boolean r6) {
        androidx.constraintlayout.a.b r7 = c();
        h r0 = d();
        r0.f809d = 0;
        r7.a(r3, r4, r0, r5);
        a(r7);
    }

    public void b(h r4, h r5, int r6, int r7) {
        androidx.constraintlayout.a.b r0 = c();
        h r1 = d();
        r1.f809d = 0;
        r0.b(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        a(r0, (int) (r0.f683e.b(r1) * (-1.0f)), r7);
    L5:
        a(r0);
    }

    public void b(h r3, h r4, int r5, boolean r6) {
        androidx.constraintlayout.a.b r7 = c();
        h r0 = d();
        r0.f809d = 0;
        r7.b(r3, r4, r0, r5);
        a(r7);
    }

    public void a(h r12, h r13, int r14, float r15, h r16, h r17, int r18, int r19) {
        androidx.constraintlayout.a.b r10 = c();
        r10.a(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.a(this, r19);
    L5:
        a(r10);
    }

    public void a(h r8, h r9, h r10, h r11, float r12, int r13) {
        androidx.constraintlayout.a.b r6 = c();
        r6.a(r8, r9, r10, r11, r12);
        if (r13 == 8) goto L5;
        r6.a(this, r13);
    L5:
        a(r6);
    }

    public androidx.constraintlayout.a.b c(h r4, h r5, int r6, int r7) {
        if (f791b == false) goto L11;
        if (r7 != 8) goto L11;
        if (r5.f == false) goto L11;
        if (r4.f808c != (-1)) goto L11;
        r4.a(this, r5.f810e + r6);
        return null;
    L11:
        androidx.constraintlayout.a.b r0 = c();
        r0.a(r4, r5, r6);
        if (r7 == 8) goto L14;
        r0.a(this, r7);
    L14:
        a(r0);
        return r0;
    }

    public void a(h r6, int r7) {
        if (f791b == true) goto L5;
    L18:
        int r0 = r6.f808c;
        if (r6.f808c == (-1)) goto L27;
        androidx.constraintlayout.a.b r1 = this.i[r0];
        if (r1.f == false) goto L24;
        r1.f680b = r7;
        return;
    L24:
        if (r1.f683e.c() != 0) goto L26;
        r1.f = true;
        r1.f680b = r7;
        return;
    L26:
        androidx.constraintlayout.a.b r2 = c();
        r2.b(r6, r7);
        a(r2);
        return;
    L27:
        androidx.constraintlayout.a.b r3 = c();
        r3.a(r6, r7);
        a(r3);
        return;
    L5:
        if (r6.f808c != (-1)) goto L18;
        float r8 = r7;
        r6.a(this, r8);
        int r4 = 0;
    L8:
        if (r4 >= (this.h + 1)) goto L17;
        h r5 = this.n.f692d[r4];
        if (r5 == null) goto L16;
        if (r5.m == false) goto L16;
        if (r5.n != r6.f807b) goto L16;
        r5.a(this, r5.o + r8);
    L16:
        r4 = r4 + 1;
        goto L8
    }

    public static androidx.constraintlayout.a.b a(d r0, h r1, h r2, float r3) {
        return r0.c().a(r1, r2, r3);
    }

    public void a(androidx.constraintlayout.a.c.e r19, androidx.constraintlayout.a.c.e r20, float r21, int r22) {
        h r5 = a(r19.a(androidx.constraintlayout.a.c.d.a.f763b));
        h r7 = a(r19.a(androidx.constraintlayout.a.c.d.a.f764c));
        h r3 = a(r19.a(androidx.constraintlayout.a.c.d.a.f765d));
        h r8 = a(r19.a(androidx.constraintlayout.a.c.d.a.f766e));
        h r1 = a(r20.a(androidx.constraintlayout.a.c.d.a.f763b));
        h r9 = a(r20.a(androidx.constraintlayout.a.c.d.a.f764c));
        h r12 = a(r20.a(androidx.constraintlayout.a.c.d.a.f765d));
        h r10 = a(r20.a(androidx.constraintlayout.a.c.d.a.f766e));
        androidx.constraintlayout.a.b r2 = c();
        double r13 = r21;
        double r4 = r22;
        r2.b(r7, r8, r9, r10, (float) (Math.sin(r13) * r4));
        a(r2);
        androidx.constraintlayout.a.b r6 = c();
        r6.b(r5, r3, r1, r12, (float) (Math.cos(r13) * r4));
        a(r6);
    }
}
