package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    androidx.constraintlayout.a.c.e f743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    m f744e;
    protected androidx.constraintlayout.a.c.e.a f;
    g g;
    public int h;
    boolean i;
    public f j;
    public f k;
    protected a l;

    /* JADX INFO: renamed from: androidx.constraintlayout.a.c.a.p$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRun.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f745a = null;

        static {
            int[] r0 = new int[androidx.constraintlayout.a.c.d.a.values().length];
            f745a = r0;
            r0[androidx.constraintlayout.a.c.d.a.f763b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f745a[androidx.constraintlayout.a.c.d.a.f765d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f745a[androidx.constraintlayout.a.c.d.a.f764c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f745a[androidx.constraintlayout.a.c.d.a.f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f745a[androidx.constraintlayout.a.c.d.a.f766e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    /* JADX INFO: compiled from: WidgetRun.java */
    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f746a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f747b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f748c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f749d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f750e = null;

        static {
            a r0 = new a("NONE", 0);
            f746a = r0;
            a r1 = new a("START", 1);
            f747b = r1;
            a r3 = new a("END", 2);
            f748c = r3;
            a r5 = new a("CENTER", 3);
            f749d = r5;
            f750e = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f750e.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public void a(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    abstract boolean a();

    public void b(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    abstract void c();

    abstract void d();

    abstract void e();

    abstract void f();

    @Override // androidx.constraintlayout.a.c.a.d
    public void update(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    public p(androidx.constraintlayout.a.c.e r2) {
        this.g = new g(this);
        this.h = 0;
        this.i = false;
        this.j = new f(this);
        this.k = new f(this);
        this.l = a.f746a;
        this.f743d = r2;
    }

    public final f a(androidx.constraintlayout.a.c.d r3) {
        if (r3.f758c != null) goto L5;
        return null;
    L5:
        androidx.constraintlayout.a.c.e r2 = r3.f758c.f756a;
        androidx.constraintlayout.a.c.d.a r4 = r3.f758c.f757b;
        int r5 = AnonymousClass1.f745a[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return r2.g.k;
    L23:
        return r2.g.f729a;
    L24:
        return r2.g.j;
    L25:
        return r2.f.k;
    L21:
        return r2.f.j;
    }

    public void a(d r5, androidx.constraintlayout.a.c.d r6, androidx.constraintlayout.a.c.d r7, int r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        f r10 = a(r6);
        f r0 = a(r7);
        if (r10.j == true) goto L5;
        return;
    L5:
        if (r0.j == false) goto L29;
        int r1 = r10.g + r6.i();
        int r11 = r0.g - r7.i();
        int r12 = r11 - r1;
        if (this.g.j == true) goto L13;
        if (this.f != androidx.constraintlayout.a.c.e.a.f777c) goto L13;
        b(r8, r12);
    L13:
        if (this.g.j == true) goto L16;
        return;
    L16:
        if (this.g.g != r12) goto L19;
        this.j.a(r1);
        this.k.a(r11);
        return;
    L19:
        androidx.constraintlayout.a.c.e r13 = this.f743d;
        if (r8 != 0) goto L22;
        float r14 = r13.P();
    L24:
        if (r10 != r0) goto L26;
        r1 = r10.g;
        r11 = r0.g;
        r14 = 0.5f;
    L26:
        this.j.a((int) ((r1 + 0.5f) + (((r11 - r1) - this.g.g) * r14)));
        this.k.a(this.j.g + this.g.g);
        return;
    L22:
        r14 = r13.Q();
        goto L24
    }

    private void b(int r5, int r6) {
        int r0 = this.f742c;
        if (r0 != 0) goto L5;
        this.g.a(a(r6, r5));
        return;
    L5:
        if (r0 != 1) goto L7;
        this.g.a(Math.min(a(this.g.m, r5), r6));
        return;
    L7:
        if (r0 != 2) goto L9;
        androidx.constraintlayout.a.c.e r7 = this.f743d.A();
        if (r7 == null) goto L48;
        if (r5 != 0) goto L35;
        p r8 = r7.f;
    L37:
        if (r8.g.j == false) goto L49;
        androidx.constraintlayout.a.c.e r1 = this.f743d;
        if (r5 != 0) goto L41;
        float r2 = r1.s;
    L42:
        this.g.a(a((int) ((r8.g.g * r2) + 0.5f), r5));
        return;
    L41:
        r2 = r1.v;
        goto L42
    L49:
        return;
    L35:
        r8 = r7.g;
        goto L37
    L48:
        return;
    L9:
        if (r0 == 3) goto L12;
        return;
    L12:
        if (this.f743d.f.f == androidx.constraintlayout.a.c.e.a.f777c) goto L14;
    L20:
        androidx.constraintlayout.a.c.e r9 = this.f743d;
        if (r5 != 0) goto L23;
        p r10 = r9.g;
    L25:
        if (r10.g.j == false) goto L46;
        float r3 = this.f743d.U();
        if (r5 != 1) goto L29;
        int r11 = (int) ((r10.g.g / r3) + 0.5f);
    L30:
        this.g.a(r11);
        return;
    L29:
        r11 = (int) ((r3 * r10.g.g) + 0.5f);
        goto L30
    L46:
        return;
    L23:
        r10 = r9.f;
        goto L25
    L14:
        if (this.f743d.f.f742c != 3) goto L20;
        if (this.f743d.g.f != androidx.constraintlayout.a.c.e.a.f777c) goto L20;
        if (this.f743d.g.f742c != 3) goto L20;
    }

    public final int a(int r1, int r2) {
        if (r2 != 0) goto L8;
        int r3 = this.f743d.r;
        int r0 = Math.max(this.f743d.q, r1);
        if (r3 <= 0) goto L6;
        r0 = Math.min(r3, r1);
    L6:
        if (r0 != r1) goto L13;
        return r1;
    L13:
        return r0;
    L8:
        int r4 = this.f743d.u;
        r0 = Math.max(this.f743d.t, r1);
        if (r4 <= 0) goto L11;
        r0 = Math.min(r4, r1);
    L11:
        if (r0 != r1) goto L13;
        return r1;
    }

    public final f a(androidx.constraintlayout.a.c.d r2, int r3) {
        if (r2.f758c != null) goto L5;
        return null;
    L5:
        androidx.constraintlayout.a.c.e r1 = r2.f758c.f756a;
        if (r3 != 0) goto L8;
        p r4 = r1.f;
    L9:
        androidx.constraintlayout.a.c.d.a r5 = r2.f758c.f757b;
        int r6 = AnonymousClass1.f745a[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 == 2) goto L21;
        if (r6 == 3) goto L20;
        if (r6 == 5) goto L21;
        return null;
    L21:
        return r4.k;
    L20:
        return r4.j;
    L8:
        r4 = r1.g;
        goto L9
    }

    public final void a(f r1, f r2, int r3) {
        r1.l.add(r2);
        r1.f = r3;
        r2.k.add(r1);
    }

    public final void a(f r2, f r3, int r4, g r5) {
        r2.l.add(r3);
        r2.l.add(this.g);
        r2.h = r4;
        r2.i = r5;
        r3.k.add(r2);
        r5.k.add(r2);
    }

    public long b() {
        if (this.g.j == true) goto L5;
        return 0;
    L5:
        return this.g.g;
    }

    public boolean g() {
        return this.i;
    }
}
