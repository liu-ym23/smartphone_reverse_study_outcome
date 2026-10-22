package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WidgetRun.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.obric.oui.constraintlayout.a.c.e f34724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    m f34725e;
    protected com.obric.oui.constraintlayout.a.c.e.a f;
    g g;
    public int h;
    boolean i;
    public f j;
    public f k;
    protected a l;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.a.c.a.p$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRun.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34726a = null;

        static {
            int[] r0 = new int[com.obric.oui.constraintlayout.a.c.d.a.values().length];
            f34726a = r0;
            r0[com.obric.oui.constraintlayout.a.c.d.a.f34744b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f34726a[com.obric.oui.constraintlayout.a.c.d.a.f34746d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f34726a[com.obric.oui.constraintlayout.a.c.d.a.f34745c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f34726a[com.obric.oui.constraintlayout.a.c.d.a.f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f34726a[com.obric.oui.constraintlayout.a.c.d.a.f34747e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    /* JADX INFO: compiled from: WidgetRun.java */
    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34727a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34728b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f34729c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f34730d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f34731e = null;

        static {
            a r0 = new a("NONE", 0);
            f34727a = r0;
            a r1 = new a("START", 1);
            f34728b = r1;
            a r3 = new a("END", 2);
            f34729c = r3;
            a r5 = new a("CENTER", 3);
            f34730d = r5;
            f34731e = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f34731e.clone(), a[].class, "com.obric.aiagent.plugin");
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

    @Override // com.obric.oui.constraintlayout.a.c.a.d
    public void update(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    public p(com.obric.oui.constraintlayout.a.c.e r2) {
        this.g = new g(this);
        this.h = 0;
        this.i = false;
        this.j = new f(this);
        this.k = new f(this);
        this.l = a.f34727a;
        this.f34724d = r2;
    }

    public final f a(com.obric.oui.constraintlayout.a.c.d r3) {
        if (r3.f34739c != null) goto L5;
        return null;
    L5:
        com.obric.oui.constraintlayout.a.c.e r2 = r3.f34739c.f34737a;
        com.obric.oui.constraintlayout.a.c.d.a r4 = r3.f34739c.f34738b;
        int r5 = AnonymousClass1.f34726a[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return r2.g.k;
    L23:
        return r2.g.f34710a;
    L24:
        return r2.g.j;
    L25:
        return r2.f.k;
    L21:
        return r2.f.j;
    }

    public void a(d r5, com.obric.oui.constraintlayout.a.c.d r6, com.obric.oui.constraintlayout.a.c.d r7, int r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        f r10 = a(r6);
        f r0 = a(r7);
        if (r10.j == true) goto L5;
        return;
    L5:
        if (r0.j == false) goto L28;
        int r1 = r10.g + r6.i();
        int r11 = r0.g - r7.i();
        int r12 = r11 - r1;
        if (this.g.j == true) goto L13;
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L13;
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
        if (r8 != 0) goto L21;
        float r13 = this.f34724d.P();
    L23:
        if (r10 != r0) goto L25;
        r1 = r10.g;
        r11 = r0.g;
        r13 = 0.5f;
    L25:
        this.j.a((int) ((r1 + 0.5f) + (((r11 - r1) - this.g.g) * r13)));
        this.k.a(this.j.g + this.g.g);
        return;
    L21:
        r13 = this.f34724d.Q();
        goto L23
    }

    private void b(int r5, int r6) {
        int r0 = this.f34723c;
        if (r0 != 0) goto L5;
        this.g.a(a(r6, r5));
        return;
    L5:
        if (r0 != 1) goto L7;
        this.g.a(Math.min(a(this.g.m, r5), r6));
        return;
    L7:
        if (r0 != 2) goto L9;
        com.obric.oui.constraintlayout.a.c.e r7 = this.f34724d.A();
        if (r7 == null) goto L46;
        if (r5 != 0) goto L34;
        p r8 = r7.f;
    L36:
        if (r8.g.j == false) goto L47;
        if (r5 != 0) goto L39;
        float r1 = this.f34724d.s;
    L40:
        this.g.a(a((int) ((r8.g.g * r1) + 0.5f), r5));
        return;
    L39:
        r1 = this.f34724d.v;
        goto L40
    L47:
        return;
    L34:
        r8 = r7.g;
        goto L36
    L46:
        return;
    L9:
        if (r0 == 3) goto L12;
        return;
    L12:
        if (this.f34724d.f.f == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L14;
    L20:
        if (r5 != 0) goto L22;
        p r9 = this.f34724d.g;
    L24:
        if (r9.g.j == false) goto L44;
        float r2 = this.f34724d.U();
        if (r5 != 1) goto L28;
        int r10 = (int) ((r9.g.g / r2) + 0.5f);
    L29:
        this.g.a(r10);
        return;
    L28:
        r10 = (int) ((r2 * r9.g.g) + 0.5f);
        goto L29
    L44:
        return;
    L22:
        r9 = this.f34724d.f;
        goto L24
    L14:
        if (this.f34724d.f.f34723c != 3) goto L20;
        if (this.f34724d.g.f != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L20;
        if (this.f34724d.g.f34723c != 3) goto L20;
    }

    public final int a(int r1, int r2) {
        if (r2 != 0) goto L8;
        int r3 = this.f34724d.r;
        int r0 = Math.max(this.f34724d.q, r1);
        if (r3 <= 0) goto L6;
        r0 = Math.min(r3, r1);
    L6:
        if (r0 != r1) goto L13;
        return r1;
    L13:
        return r0;
    L8:
        int r4 = this.f34724d.u;
        r0 = Math.max(this.f34724d.t, r1);
        if (r4 <= 0) goto L11;
        r0 = Math.min(r4, r1);
    L11:
        if (r0 != r1) goto L13;
        return r1;
    }

    public final f a(com.obric.oui.constraintlayout.a.c.d r2, int r3) {
        if (r2.f34739c != null) goto L5;
        return null;
    L5:
        com.obric.oui.constraintlayout.a.c.e r1 = r2.f34739c.f34737a;
        if (r3 != 0) goto L8;
        p r4 = r1.f;
    L9:
        com.obric.oui.constraintlayout.a.c.d.a r5 = r2.f34739c.f34738b;
        int r6 = AnonymousClass1.f34726a[r5.ordinal()];
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
