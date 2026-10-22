package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.v;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SingleRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class j<R> implements d, i, com.bumptech.glide.request.target.h {
    private static final String TAG = "Request";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3930a = false;
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.f.a.c f3932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f3933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g<R> f3934e;
    private final e f;
    private final Context g;
    private final GlideContext h;
    private final Object i;
    private final Class<R> j;
    private final com.bumptech.glide.request.a<?> k;
    private final int l;
    private final int m;
    private final com.bumptech.glide.e n;
    private final com.bumptech.glide.request.target.i<R> o;
    private final List<g<R>> p;
    private final com.bumptech.glide.request.a.c<? super R> q;
    private final Executor r;
    private v<R> s;
    private com.bumptech.glide.load.engine.k.d t;
    private long u;
    private volatile com.bumptech.glide.load.engine.k v;
    private a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    /* JADX INFO: compiled from: SingleRequest.java */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3935a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3936b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f3937c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f3938d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f3939e = null;
        public static final a f = null;
        private static final /* synthetic */ a[] g = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("PENDING", 0);
            f3935a = r0;
            a r1 = new a("RUNNING", 1);
            f3936b = r1;
            a r3 = new a("WAITING_FOR_SIZE", 2);
            f3937c = r3;
            a r5 = new a("COMPLETE", 3);
            f3938d = r5;
            a r7 = new a("FAILED", 4);
            f3939e = r7;
            a r9 = new a("CLEARED", 5);
            f = r9;
            g = new a[]{r0, r1, r3, r5, r7, r9};
        }
    }

    static {
        f3930a = a(TAG, 2);
    }

    public static <R> j<R> a(Context r18, GlideContext r19, Object r20, Object r21, Class<R> r22, com.bumptech.glide.request.a<?> r23, int r24, int r25, com.bumptech.glide.e r26, com.bumptech.glide.request.target.i<R> r27, g<R> r28, List<g<R>> r29, e r30, com.bumptech.glide.load.engine.k r31, com.bumptech.glide.request.a.c<? super R> r32, Executor r33) {
        return new j((Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin"), (GlideContext) ZeusTransformUtils.wrapperContextForParams(r19, GlideContext.class, "com.obric.aiagent.plugin"), r20, r21, r22, r23, r24, r25, r26, (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r27, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r28, g.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin"), (e) ZeusTransformUtils.wrapperContextForParams(r30, e.class, "com.obric.aiagent.plugin"), r31, (com.bumptech.glide.request.a.c) ZeusTransformUtils.wrapperContextForParams(r32, com.bumptech.glide.request.a.c.class, "com.obric.aiagent.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r33, Executor.class, "com.obric.aiagent.plugin"));
    }

    private j(Context r12, GlideContext r13, Object r14, Object r15, Class<R> r16, com.bumptech.glide.request.a<?> r17, int r18, int r19, com.bumptech.glide.e r20, com.bumptech.glide.request.target.i<R> r21, g<R> r22, List<g<R>> r23, e r24, com.bumptech.glide.load.engine.k r25, com.bumptech.glide.request.a.c<? super R> r26, Executor r27) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        GlideContext r3 = (GlideContext) ZeusTransformUtils.wrapperContextForParams(r13, GlideContext.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.target.i<R> r4 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r21, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
        g<R> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r22, g.class, "com.obric.aiagent.plugin");
        List<g<R>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r24, e.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.a.c<? super R> r8 = (com.bumptech.glide.request.a.c) ZeusTransformUtils.wrapperContextForParams(r26, com.bumptech.glide.request.a.c.class, "com.obric.aiagent.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r27, Executor.class, "com.obric.aiagent.plugin");
        if (f3930a == false) goto L5;
        String r10 = String.valueOf(super.hashCode());
    L6:
        this.f3931b = r10;
        this.f3932c = com.bumptech.glide.f.a.c.a();
        this.f3933d = r14;
        this.g = ZeusTransformUtils.wrapperContext(r1, "com.obric.aiagent.plugin");
        this.h = r3;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r4;
        this.f3934e = r5;
        this.p = r6;
        this.f = r7;
        this.v = r25;
        this.q = r8;
        this.r = r9;
        this.w = a.f3935a;
        if (this.D == null) goto L9;
        return;
    L9:
        if (r3.isLoggingRequestOriginsEnabled() == false) goto L13;
        this.D = new RuntimeException("Glide request origin trace");
        return;
    L13:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bumptech.glide.request.d
    public void a() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
        j();     // Catch: Throwable -> L41
        this.f3932c.b();     // Catch: Throwable -> L41
        this.u = com.bumptech.glide.f.f.a();     // Catch: Throwable -> L41
        if (this.i != null) goto L17;
        if (com.bumptech.glide.f.k.a(this.l, this.m) == false) goto L10;
        this.A = this.l;     // Catch: Throwable -> L41
        this.B = this.m;     // Catch: Throwable -> L41
    L10:
        if (m() != null) goto L12;
        int r1 = 5;
    L13:
        a(new q("Received null model"), r1);     // Catch: Throwable -> L41
        monitor-exit(r0);     // Catch: Throwable -> L41
        return;
    L12:
        r1 = 3;
        goto L13
    L17:
        if (this.w == a.f3936b) goto L40;
        if (this.w != a.f3938d) goto L23;
        a(this.s, com.bumptech.glide.load.a.f3353e);     // Catch: Throwable -> L41
        monitor-exit(r0);     // Catch: Throwable -> L41
        return;
    L23:
        this.w = a.f3937c;     // Catch: Throwable -> L41
        if (com.bumptech.glide.f.k.a(this.l, this.m) == false) goto L26;
        a(this.l, this.m);     // Catch: Throwable -> L41
    L28:
        if (this.w == a.f3936b) goto L32;
        if (this.w == a.f3937c) goto L32;
    L35:
        if (f3930a == false) goto L37;
        a("finished run method in " + com.bumptech.glide.f.f.a(this.u));     // Catch: Throwable -> L41
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L41
        return;
    L32:
        if (q() == false) goto L35;
        this.o.a(l());     // Catch: Throwable -> L41
        goto L35
    L26:
        this.o.a(this);     // Catch: Throwable -> L41
        goto L28
    L40:
        throw new IllegalArgumentException("Cannot restart a running request");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    private void i() {
        j();
        this.f3932c.b();
        this.o.b(this);
        com.bumptech.glide.load.engine.k.d r0 = this.t;
        if (r0 == null) goto L6;
        r0.a();
        this.t = null;
        return;
    }

    private void j() {
        if (this.C == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    @Override // com.bumptech.glide.request.d
    public void b() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
        j();     // Catch: Throwable -> L20
        this.f3932c.b();     // Catch: Throwable -> L20
        if (this.w != a.f) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L8:
        i();     // Catch: Throwable -> L20
        v<R> r1 = this.s;     // Catch: Throwable -> L20
        if (r1 == null) goto L11;
        this.s = null;     // Catch: Throwable -> L20
    L13:
        if (p() == false) goto L15;
        this.o.c(l());     // Catch: Throwable -> L20
    L15:
        this.w = a.f;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r1 == null) goto L24;
        this.v.a(r1);
        return;
    L24:
        return;
    L11:
        r1 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void c() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (d() == false) goto L7;
        b();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.w != a.f3936b) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.w == a.f3937c) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.w != a.f3938d) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.w != a.f) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.d, com.bumptech.glide.request.e
    public boolean g() {
        Object r0 = this.f3933d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.w != a.f3938d) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    private Drawable k() {
        if (this.x != null) goto L10;
        Drawable r0 = this.k.r();
        this.x = r0;
        if (r0 != null) goto L10;
        if (this.k.s() <= 0) goto L10;
        this.x = a(this.k.s());
    L10:
        return this.x;
    }

    private Drawable l() {
        if (this.y != null) goto L10;
        Drawable r0 = this.k.u();
        this.y = r0;
        if (r0 != null) goto L10;
        if (this.k.t() <= 0) goto L10;
        this.y = a(this.k.t());
    L10:
        return this.y;
    }

    private Drawable m() {
        if (this.z != null) goto L10;
        Drawable r0 = this.k.w();
        this.z = r0;
        if (r0 != null) goto L10;
        if (this.k.v() <= 0) goto L10;
        this.z = a(this.k.v());
    L10:
        return this.z;
    }

    private Drawable a(int r2) {
        if (this.k.x() == null) goto L5;
        Resources.Theme r0 = this.k.x();
    L7:
        return com.bumptech.glide.load.resource.b.a.a(this.h, r2, r0);
    L5:
        r0 = this.g.getTheme();
        goto L7
    }

    private void n() {
        if (q() == true) goto L5;
        return;
    L5:
        Drawable r0 = null;
        if (this.i != null) goto L8;
        r0 = m();
    L8:
        if (r0 != null) goto L10;
        r0 = k();
    L10:
        if (r0 != null) goto L12;
        r0 = l();
    L12:
        this.o.b(r0);
    }

    @Override // com.bumptech.glide.request.target.h
    public void a(int r24, int r25) {
        this.f3932c.b();
        Object r15 = this.f3933d;
        monitor-enter(r15);
        boolean r21 = f3930a;     // Catch: Throwable -> L23
        if (r21 == false) goto L8;
        a("Got onSizeReady in " + com.bumptech.glide.f.f.a(this.u));     // Catch: Throwable -> L23
    L8:
        if (this.w == a.f3937c) goto L11;
        monitor-exit(r15);     // Catch: Throwable -> L23
        return;
    L11:
        this.w = a.f3936b;     // Catch: Throwable -> L23
        float r1 = this.k.F();     // Catch: Throwable -> L23
        this.A = a(r24, r1);     // Catch: Throwable -> L23
        this.B = a(r25, r1);     // Catch: Throwable -> L23
        if (r21 == false) goto L16;
        a("finished setup for calling load in " + com.bumptech.glide.f.f.a(this.u));     // Catch: Throwable -> L23
    L16:
        this.t = this.v.a(this.h, this.i, this.k.z(), this.A, this.B, this.k.p(), this.j, this.n, this.k.q(), this.k.m(), this.k.n(), this.k.G(), this.k.o(), this.k.y(), this.k.H(), this.k.I(), this.k.J(), this, this.r);     // Catch: Throwable -> L27
        if (this.w == a.f3936b) goto L19;
        this.t = null;     // Catch: Throwable -> L27
    L19:
        if (r21 == false) goto L21;
        a("finished onSizeReady in " + com.bumptech.glide.f.f.a(this.u));     // Catch: Throwable -> L27
    L21:
        monitor-exit(r15);     // Catch: Throwable -> L27
        return;
    L27:
        th = th;
    L25:
        monitor-exit(r15);     // Catch: Throwable -> L27
        throw th;
    L23:
        th = th;
        goto L25
    }

    private static int a(int r1, float r2) {
        if (r1 != Integer.MIN_VALUE) goto L6;
        return r1;
    L6:
        return Math.round(r2 * r1);
    }

    private boolean o() {
        e r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.b(this) == true) goto L8;
        return false;
    }

    private boolean p() {
        e r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.d(this) == true) goto L8;
        return false;
    }

    private boolean q() {
        e r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.c(this) == true) goto L8;
        return false;
    }

    private boolean r() {
        e r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.h().g() == false) goto L8;
        return false;
    }

    private void s() {
        e r0 = this.f;
        if (r0 == null) goto L6;
        r0.e(this);
        return;
    }

    private void t() {
        e r0 = this.f;
        if (r0 == null) goto L6;
        r0.f(this);
        return;
    }

    @Override // com.bumptech.glide.request.i
    public void a(v<?> r6, com.bumptech.glide.load.a r7) {
        v<R> r8 = (v) ZeusTransformUtils.wrapperContextForParams(r6, v.class, "com.obric.aiagent.plugin");
        this.f3932c.b();
        v<R> r0 = null;
        Object r1 = this.f3933d;     // Catch: Throwable -> L43
        monitor-enter(r1);     // Catch: Throwable -> L43
        this.t = null;     // Catch: Throwable -> L40
        if (r8 != null) goto L10;
        a(new q("Expected to receive a Resource<R> with an object of " + this.j + " inside, but instead got null."));     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L10:
        R r2 = r8.d();     // Catch: Throwable -> L40
        if (r2 != null) goto L13;
    L25:
        this.s = null;     // Catch: Throwable -> L38
        StringBuilder r3 = new StringBuilder().append("Expected to receive an object of ").append(this.j).append(" but instead got ");     // Catch: Throwable -> L38
        if (r2 == null) goto L28;
        Object r4 = r2.getClass();     // Catch: Throwable -> L38
    L29:
        StringBuilder r5 = r3.append(r4).append("{").append(r2).append("} inside Resource{").append(r8).append("}.");     // Catch: Throwable -> L38
        if (r2 == null) goto L32;
        String r9 = "";
    L33:
        a(new q(r5.append(r9).toString()));     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L38
        if (r8 == null) goto L52;
        this.v.a(r8);
        return;
    L52:
        return;
    L32:
        r9 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        goto L33
    L28:
        r4 = "";
        goto L29
    L13:
        if (this.j.isAssignableFrom(r2.getClass()) == false) goto L25;
        if (o() == true) goto L22;
        this.s = null;     // Catch: Throwable -> L38
        this.w = a.f3938d;     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L38
        if (r8 == null) goto L51;
        this.v.a(r8);
        return;
    L51:
        return;
    L22:
        a(r8, r2, r7);     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L38:
        th = move-exception;
        r0 = r8;
        th = th;
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L43
    L40:
        th = th;
    L43:
        th = move-exception;
        if (r0 == null) goto L46;
        this.v.a(r0);
    L46:
        throw th;
    }

    private void a(v<R> r12, R r13, com.bumptech.glide.load.a r14) {
        v<R> r15 = (v) ZeusTransformUtils.wrapperContextForParams(r12, v.class, "com.obric.aiagent.plugin");
        boolean r0 = r();
        this.w = a.f3938d;
        this.s = r15;
        if (this.h.getLogLevel() > 3) goto L5;
        a("Glide", "Finished loading " + r13.getClass().getSimpleName() + " from " + r14 + " for " + this.i + " with size [" + this.A + "x" + this.B + "] in " + com.bumptech.glide.f.f.a(this.u) + " ms");
    L5:
        boolean r16 = true;
        this.C = true;
        List<g<R>> r2 = this.p;     // Catch: Throwable -> L24
        if (r2 == null) goto L12;
        Iterator<g<R>> r9 = r2.iterator();     // Catch: Throwable -> L24
        boolean r10 = false;
    L10:
        if (r9.hasNext() == false) goto L13;
        r10 = r10 | ((g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.aiagent.plugin")).a(r13, this.i, this.o, r14, r0);     // Catch: Throwable -> L24
    L13:
        g<R> r3 = this.f3934e;     // Catch: Throwable -> L24
        if (r3 != null) goto L16;
    L18:
        r16 = false;
    L20:
        if ((r16 | r10) == true) goto L22;
        this.o.a(r13, this.q.a(r14, r0));     // Catch: Throwable -> L24
    L22:
        this.C = false;
        s();
        return;
    L16:
        if (r3.a(r13, this.i, this.o, r14, r0) == false) goto L18;
    L12:
        r10 = false;
    L24:
        th = move-exception;
        this.C = false;
        throw th;
    }

    @Override // com.bumptech.glide.request.i
    public void a(q r2) {
        a(r2, 5);
    }

    @Override // com.bumptech.glide.request.i
    public Object h() {
        this.f3932c.b();
        return this.f3933d;
    }

    private void a(q r9, int r10) {
        this.f3932c.b();
        Object r0 = this.f3933d;
        monitor-enter(r0);
        r9.a(this.D);     // Catch: Throwable -> L33
        int r1 = this.h.getLogLevel();     // Catch: Throwable -> L33
        if (r1 > r10) goto L9;
        a("Glide", "Load failed for " + this.i + " with size [" + this.A + "x" + this.B + "]", r9);     // Catch: Throwable -> L33
        if (r1 > 4) goto L9;
        r9.a("Glide");     // Catch: Throwable -> L33
    L9:
        this.t = null;     // Catch: Throwable -> L33
        this.w = a.f3939e;     // Catch: Throwable -> L33
        boolean r11 = true;
        this.C = true;     // Catch: Throwable -> L33
        List<g<R>> r2 = this.p;     // Catch: Throwable -> L30
        if (r2 == null) goto L17;
        Iterator<g<R>> r3 = r2.iterator();     // Catch: Throwable -> L30
        boolean r4 = false;
    L15:
        if (r3.hasNext() == false) goto L18;
        r4 = r4 | ((g) ZeusTransformUtils.preCheckCast(r3.next(), g.class, "com.obric.aiagent.plugin")).a(r9, this.i, this.o, r());     // Catch: Throwable -> L30
    L18:
        g<R> r5 = this.f3934e;     // Catch: Throwable -> L30
        if (r5 != null) goto L21;
    L23:
        r11 = false;
    L25:
        if ((r4 | r11) == true) goto L27;
        n();     // Catch: Throwable -> L30
    L27:
        this.C = false;     // Catch: Throwable -> L33
        t();     // Catch: Throwable -> L33
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L21:
        if (r5.a(r9, this.i, this.o, r()) == false) goto L23;
    L17:
        r4 = false;
    L30:
        th = move-exception;
        this.C = false;     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d r15) {
        d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, j.class) == true) goto L5;
        return false;
    L5:
        Object r1 = this.f3933d;
        monitor-enter(r1);
        int r3 = this.l;     // Catch: Throwable -> L34
        int r4 = this.m;     // Catch: Throwable -> L34
        Object r5 = this.i;     // Catch: Throwable -> L34
        Class<R> r6 = this.j;     // Catch: Throwable -> L34
        com.bumptech.glide.request.a<?> r7 = this.k;     // Catch: Throwable -> L34
        com.bumptech.glide.e r8 = this.n;     // Catch: Throwable -> L34
        List<g<R>> r14 = this.p;     // Catch: Throwable -> L34
        if (r14 == null) goto L10;
        int r17 = r14.size();     // Catch: Throwable -> L34
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L34
        j r18 = (j) ZeusTransformUtils.preCheckCast(r16, j.class, "com.obric.aiagent.plugin");
        Object r0 = r18.f3933d;
        monitor-enter(r0);
        int r2 = r18.l;     // Catch: Throwable -> L31
        int r9 = r18.m;     // Catch: Throwable -> L31
        Object r10 = r18.i;     // Catch: Throwable -> L31
        Class<R> r11 = r18.j;     // Catch: Throwable -> L31
        com.bumptech.glide.request.a<?> r12 = r18.k;     // Catch: Throwable -> L31
        com.bumptech.glide.e r13 = r18.n;     // Catch: Throwable -> L31
        List<g<R>> r19 = r18.p;     // Catch: Throwable -> L31
        if (r19 == null) goto L17;
        int r110 = r19.size();     // Catch: Throwable -> L31
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L31
        if (r3 != r2) goto L41;
        if (r4 == r9) goto L22;
        return false;
    L22:
        if (com.bumptech.glide.f.k.b(r5, r10) == true) goto L24;
        return false;
    L24:
        if (r6.equals(r11) == true) goto L26;
        return false;
    L26:
        if (r7.equals(r12) == false) goto L45;
        if (r8 != r13) goto L46;
        if (r17 != r110) goto L47;
        return true;
    L47:
        return false;
    L46:
        return false;
    L45:
        return false;
    L41:
        return false;
    L17:
        r110 = 0;
    L31:
        th = move-exception;
        throw th;
    L10:
        r17 = 0;
    L34:
        th = move-exception;
        throw th;
    }

    private void a(String r2) {
        b(TAG, r2 + " this: " + this.f3931b);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
