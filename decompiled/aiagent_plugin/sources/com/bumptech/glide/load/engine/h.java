package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DecodeJob.java */
/* JADX INFO: loaded from: classes.dex */
class h<R> implements com.bumptech.glide.f.a.a.c, com.bumptech.glide.load.engine.f.a, Comparable<h<?>>, Runnable {
    private static final String TAG = "DecodeJob";
    private com.bumptech.glide.load.a A;
    private com.bumptech.glide.load.a.d<?> B;
    private volatile com.bumptech.glide.load.engine.f C;
    private volatile boolean D;
    private volatile boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.g<R> f3645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Throwable> f3646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.f.a.c f3647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f3648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.core.util.f.a<h<?>> f3649e;
    private final c<?> f;
    private final e g;
    private GlideContext h;
    private com.bumptech.glide.load.g i;
    private com.bumptech.glide.e j;
    private n k;
    private int l;
    private int m;
    private j n;
    private com.bumptech.glide.load.i o;
    private a<R> p;
    private int q;
    private g r;
    private f s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.g x;
    private com.bumptech.glide.load.g y;
    private Object z;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: DecodeJob.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3650a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3651b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f3652c = null;

        static {
            int[] r0 = new int[com.bumptech.glide.load.c.values().length];
            f3652c = r0;
            r0[com.bumptech.glide.load.c.f3506a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L28:
            f3652c[com.bumptech.glide.load.c.f3507b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L6:
            int[] r2 = new int[g.values().length];
            f3651b = r2;
            r2[g.f3666b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L36:
            f3651b[g.f3667c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L46:
            f3651b[g.f3668d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L32:
            f3651b[g.f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L38:
            f3651b[g.f3665a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r3 = new int[f.values().length];
            f3650a = r3;
            r3[f.f3661a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L42:
            f3650a[f.f3662b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L30:
            f3650a[f.f3663c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface a<R> {
        void a(h<?> r1);

        void a(q r1);

        void a(v<R> r1, com.bumptech.glide.load.a r2);
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private final class b<Z> implements i.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f3653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.a f3654b;

        b(h r1, com.bumptech.glide.load.a r2) {
            this.f3653a = r1;
            this.f3654b = r2;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        public v<Z> a(v<Z> r3) {
            v<Z> r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
            return this.f3653a.a(this.f3654b, r4);
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class c<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.g f3655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.l<Z> f3656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private u<Z> f3657c;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.g r3, com.bumptech.glide.load.l<X> r4, u<X> r5) {
            com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.load.l<Z> r7 = (com.bumptech.glide.load.l) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.l.class, "com.obric.aiagent.plugin");
            this.f3655a = r6;
            this.f3656b = r7;
            this.f3657c = r5;
        }

        void a(d r5, com.bumptech.glide.load.i r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.f.a.b.a("DecodeJob.encode");
            r7.a().a(this.f3655a, new com.bumptech.glide.load.engine.e(this.f3656b, this.f3657c, r6));     // Catch: Throwable -> L6
            this.f3657c.a();
            com.bumptech.glide.f.a.b.a();
            return;
        L6:
            th = move-exception;
            this.f3657c.a();
            com.bumptech.glide.f.a.b.a();
            throw th;
        }

        boolean a() {
            if (this.f3657c == null) goto L5;
            return true;
        L5:
            return false;
        }

        void b() {
            this.f3655a = null;
            this.f3656b = null;
            this.f3657c = null;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface d {
        com.bumptech.glide.load.engine.b.a a();
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3660c;

        e() {
        }

        synchronized boolean a(boolean r2) {
            monitor-enter(this);
            this.f3658a = true;     // Catch: Throwable -> L7
            boolean r3 = b(r2);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean a() {
            monitor-enter(this);
            this.f3659b = true;     // Catch: Throwable -> L7
            boolean r0 = b(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean b() {
            monitor-enter(this);
            this.f3660c = true;     // Catch: Throwable -> L7
            boolean r0 = b(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void c() {
            monitor-enter(this);
            this.f3659b = false;     // Catch: Throwable -> L7
            this.f3658a = false;     // Catch: Throwable -> L7
            this.f3660c = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean b(boolean r2) {
            if (this.f3660c == true) goto L8;
            if (r2 == true) goto L8;
            if (this.f3659b == true) goto L8;
        L10:
            return false;
        L8:
            if (this.f3658a == false) goto L10;
            return true;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f3661a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f3662b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f3663c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ f[] f3664d = null;

        private f(String r1, int r2) {
            super(r1, r2);
        }

        public static f valueOf(String r2) {
            return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
        }

        public static f[] values() {
            return (f[]) ZeusTransformUtils.preCheckCast(f3664d.clone(), f[].class, "com.obric.aiagent.plugin");
        }

        static {
            f r0 = new f("INITIALIZE", 0);
            f3661a = r0;
            f r1 = new f("SWITCH_TO_SOURCE_SERVICE", 1);
            f3662b = r1;
            f r3 = new f("DECODE_DATA", 2);
            f3663c = r3;
            f3664d = new f[]{r0, r1, r3};
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f3665a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f3666b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f3667c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f3668d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f3669e = null;
        public static final g f = null;
        private static final /* synthetic */ g[] g = null;

        private g(String r1, int r2) {
            super(r1, r2);
        }

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(g.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        static {
            g r0 = new g("INITIALIZE", 0);
            f3665a = r0;
            g r1 = new g("RESOURCE_CACHE", 1);
            f3666b = r1;
            g r3 = new g("DATA_CACHE", 2);
            f3667c = r3;
            g r5 = new g("SOURCE", 3);
            f3668d = r5;
            g r7 = new g("ENCODE", 4);
            f3669e = r7;
            g r9 = new g("FINISHED", 5);
            f = r9;
            g = new g[]{r0, r1, r3, r5, r7, r9};
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(h<?> r3) {
        return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    h(d r3, androidx.core.util.f.a<h<?>> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        androidx.core.util.f.a<h<?>> r6 = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f3645a = new com.bumptech.glide.load.engine.g();
        this.f3646b = new ArrayList();
        this.f3647c = com.bumptech.glide.f.a.c.a();
        this.f = new c();
        this.g = new e();
        this.f3648d = r5;
        this.f3649e = r6;
    }

    h<R> a(GlideContext r19, Object r20, n r21, com.bumptech.glide.load.g r22, int r23, int r24, Class<?> r25, Class<R> r26, com.bumptech.glide.e r27, j r28, Map<Class<?>, com.bumptech.glide.load.m<?>> r29, boolean r30, boolean r31, boolean r32, com.bumptech.glide.load.i r33, a<R> r34, int r35) {
        GlideContext r1 = (GlideContext) ZeusTransformUtils.wrapperContextForParams(r19, GlideContext.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r15 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r22, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Map<Class<?>, com.bumptech.glide.load.m<?>> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.aiagent.plugin");
        a<R> r2 = (a) ZeusTransformUtils.wrapperContextForParams(r34, a.class, "com.obric.aiagent.plugin");
        this.f3645a.a(r1, r20, r15, r23, r24, r28, r25, r26, r27, r33, r14, r30, r31, this.f3648d);
        this.h = r1;
        this.i = r15;
        this.j = r27;
        this.k = r21;
        this.l = r23;
        this.m = r24;
        this.n = r28;
        this.u = r32;
        this.o = r33;
        this.p = r2;
        this.q = r35;
        this.s = f.f3661a;
        this.v = r20;
        return this;
    }

    boolean a() {
        g r1 = a(g.f3665a);
        if (r1 != g.f3666b) goto L5;
    L8:
        return true;
    L5:
        if (r1 == g.f3667c) goto L8;
        return false;
    }

    void a(boolean r2) {
        if (this.g.a(r2) == false) goto L6;
        g();
        return;
    }

    private void e() {
        if (this.g.a() == false) goto L6;
        g();
        return;
    }

    private void f() {
        if (this.g.b() == false) goto L6;
        g();
        return;
    }

    private void g() {
        this.g.c();
        this.f.b();
        this.f3645a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0;
        this.E = false;
        this.v = null;
        this.f3646b.clear();
        this.f3649e.a(this);
    }

    public int a(h<?> r3) {
        int r0 = h() - r3.h();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.q - r3.q;
    }

    private int h() {
        return this.j.ordinal();
    }

    public void b() {
        this.E = true;
        com.bumptech.glide.load.engine.f r1 = this.C;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.f.a.b.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.load.a.d<?> r1 = this.B;
    L29:
        th = move-exception;
        if (r1 == null) goto L32;
        r1.b();
    L32:
        com.bumptech.glide.f.a.b.a();
        throw th;
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L29
    L15:
        th = move-exception;
        if (a(TAG, 3) == false) goto L21;
        a(TAG, "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r, th);     // Catch: Throwable -> L29
    L21:
        if (this.r == g.f3669e) goto L24;
        this.f3646b.add(th);     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
    L24:
        if (this.E == true) goto L26;
        throw th;     // Catch: Throwable -> L29
    L26:
        throw th;     // Catch: Throwable -> L29
    L4:
        if (this.E == false) goto L10;
        l();     // Catch: Throwable -> L15 com.bumptech.glide.load.engine.b -> L27
        if (r1 == null) goto L8;
        r1.b();
    L8:
        com.bumptech.glide.f.a.b.a();
        return;
    L10:
        i();     // Catch: Throwable -> L15 com.bumptech.glide.load.engine.b -> L27
        if (r1 == null) goto L13;
        r1.b();
    L13:
        com.bumptech.glide.f.a.b.a();
    }

    private void i() {
        int r0 = AnonymousClass1.f3650a[this.s.ordinal()];
        if (r0 != 1) goto L5;
        this.r = a(g.f3665a);
        this.C = j();
        k();
        return;
    L5:
        if (r0 != 2) goto L7;
        k();
        return;
    L7:
        if (r0 != 3) goto L10;
        n();
        return;
    L10:
        throw new IllegalStateException("Unrecognized run reason: " + this.s);
    }

    private com.bumptech.glide.load.engine.f j() {
        int r0 = AnonymousClass1.f3651b[this.r.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return null;
    L13:
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    L15:
        return new y(this.f3645a, this);
    L17:
        return new com.bumptech.glide.load.engine.c(this.f3645a, this);
    L19:
        return new w(this.f3645a, this);
    }

    private void k() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.f.f.a();
        boolean r0 = false;
    L4:
        if (this.E == true) goto L14;
        if (this.C == null) goto L14;
        r0 = this.C.a();
        if (r0 == true) goto L14;
        this.r = a(this.r);
        this.C = j();
        if (this.r != g.f3668d) goto L4;
        c();
        return;
    L14:
        if (this.r != g.f) goto L16;
    L17:
        if (r0 == true) goto L26;
        l();
        return;
    L26:
        return;
    L16:
        if (this.E == true) goto L17;
    }

    private void l() {
        m();
        q r0 = new q("Failed to load resource", new ArrayList(this.f3646b));
        this.p.a(r0);
        f();
    }

    private void a(v<R> r3, com.bumptech.glide.load.a r4) {
        v<R> r5 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        m();
        this.p.a(r5, r4);
    }

    private void m() {
        this.f3647c.b();
        if (this.D == true) goto L5;
        this.D = true;
        return;
    L5:
        if (this.f3646b.isEmpty() == false) goto L7;
        Throwable r2 = null;
    L9:
        throw new IllegalStateException("Already notified", r2);
    L7:
        List<Throwable> r3 = this.f3646b;
        r2 = (Throwable) ZeusTransformUtils.preCheckCast(r3.get(r3.size() - 1), Throwable.class, "com.obric.aiagent.plugin");
        goto L9
    }

    private g a(g r3) {
        int r0 = AnonymousClass1.f3651b[r3.ordinal()];
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L20;
        if (r0 == 4) goto L20;
        if (r0 != 5) goto L18;
        if (this.n.a() == false) goto L16;
        return g.f3666b;
    L16:
        return a(g.f3666b);
    L18:
        throw new IllegalArgumentException("Unrecognized stage: " + r3);
    L20:
        return g.f;
    L22:
        if (this.u == false) goto L25;
        return g.f;
    L25:
        return g.f3668d;
    L27:
        if (this.n.b() == false) goto L30;
        return g.f3667c;
    L30:
        return a(g.f3667c);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        this.s = f.f3662b;
        this.p.a(this);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.g r3, Object r4, com.bumptech.glide.load.a.d<?> r5, com.bumptech.glide.load.a r6, com.bumptech.glide.load.g r7) {
        com.bumptech.glide.load.g r8 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.a.d<?> r9 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r10 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.x = r8;
        this.z = r4;
        this.B = r9;
        this.A = r6;
        this.y = r10;
        if (Thread.currentThread() == this.w) goto L5;
        this.s = f.f3663c;
        this.p.a(this);
        return;
    L5:
        com.bumptech.glide.f.a.b.a("DecodeJob.decodeFromRetrievedData");
        n();     // Catch: Throwable -> L9
        com.bumptech.glide.f.a.b.a();
        return;
    L9:
        th = move-exception;
        com.bumptech.glide.f.a.b.a();
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.g r3, Exception r4, com.bumptech.glide.load.a.d<?> r5, com.bumptech.glide.load.a r6) {
        com.bumptech.glide.load.g r7 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.a.d r8 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
        r8.b();
        q r0 = new q("Fetching data failed", r4);
        r0.a(r7, r6, r8.a());
        this.f3646b.add(r0);
        if (Thread.currentThread() == this.w) goto L5;
        this.s = f.f3662b;
        this.p.a(this);
        return;
    L5:
        k();
    }

    private void n() {
        if (a(TAG, 2) == false) goto L5;
        a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
    L5:
        v<R> r0 = null;
        r0 = a(this.B, this.z, this.A);     // Catch: q -> L8
    L10:
        if (r0 == null) goto L12;
        b(r0, this.A);
        return;
    L12:
        k();
        return;
    L8:
        e = move-exception;
        e.a(this.y, this.A);
        this.f3646b.add(e);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(v<R> r3, com.bumptech.glide.load.a r4) {
        v<R> r5 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, r.class) == false) goto L5;
        ((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin")).a();
    L5:
        u r0 = 0;
        if (this.f.a() == false) goto L8;
        r5 = u.a(r5);
        r0 = r5;
    L8:
        a(r5, r4);
        this.r = g.f3669e;
    L16:
        th = move-exception;
        if (r0 == 0) goto L19;
        r0.a();
    L19:
        throw th;
    L10:
        if (this.f.a() == false) goto L12;
        this.f.a(this.f3648d, this.o);     // Catch: Throwable -> L16
    L12:
        if (r0 == 0) goto L14;
        r0.a();
    L14:
        e();
    }

    private <Data> v<R> a(com.bumptech.glide.load.a.d<?> r4, Data r5, com.bumptech.glide.load.a r6) {
        com.bumptech.glide.load.a.d r7 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
        r7.b();
        return null;
    L14:
        long r0 = com.bumptech.glide.f.f.a();     // Catch: Throwable -> L11
        v<R> r8 = a(r5, r6);     // Catch: Throwable -> L11
        if (a(TAG, 2) == false) goto L9;
        a("Decoded result " + r8, r0);     // Catch: Throwable -> L11
    L9:
        r7.b();
        return r8;
    L11:
        th = move-exception;
        r7.b();
        throw th;
    }

    private <Data> v<R> a(Data r3, com.bumptech.glide.load.a r4) {
        return a(r3, r4, this.f3645a.b(r3.getClass()));
    }

    private com.bumptech.glide.load.i a(com.bumptech.glide.load.a r5) {
        com.bumptech.glide.load.i r0 = this.o;
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return r0;
    L6:
        if (r5 != com.bumptech.glide.load.a.f3352d) goto L8;
    L11:
        boolean r6 = true;
    L12:
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r0.a(com.bumptech.glide.load.resource.bitmap.m.f3819e), Boolean.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L15;
    L18:
        com.bumptech.glide.load.i r2 = new com.bumptech.glide.load.i();
        r2.a(this.o);
        r2.a(com.bumptech.glide.load.resource.bitmap.m.f3819e, Boolean.valueOf(r6));
        return r2;
    L15:
        if (r1.booleanValue() == false) goto L17;
        if (r6 == false) goto L18;
    L17:
        return r0;
    L8:
        if (this.f3645a.m() == true) goto L11;
        r6 = false;
        goto L12
    }

    private <Data, ResourceType> v<R> a(Data r7, com.bumptech.glide.load.a r8, t<Data, ResourceType, R> r9) {
        com.bumptech.glide.load.i r2 = a(r8);
        com.bumptech.glide.load.a.e<Data> r10 = this.h.getRegistry().b(r7);
        v<R> r6 = r9.a(r10, r2, this.l, this.m, new b(this, r8));     // Catch: Throwable -> L6
        r10.b();
        return r6;
    L6:
        th = move-exception;
        r10.b();
        throw th;
    }

    private void a(String r2, long r3) {
        a(r2, r3, null);
    }

    private void a(String r2, long r3, String r5) {
        StringBuilder r1 = new StringBuilder().append(r2).append(" in ").append(com.bumptech.glide.f.f.a(r3)).append(", load key: ").append(this.k);
        if (r5 == null) goto L5;
        String r4 = ", " + r5;
    L6:
        a(TAG, r1.append(r4).append(", thread: ").append(Thread.currentThread().getName()).toString());
        return;
    L5:
        r4 = "";
        goto L6
    }

    @Override // com.bumptech.glide.f.a.a.c
    public com.bumptech.glide.f.a.c b_() {
        return this.f3647c;
    }

    <Z> v<Z> a(com.bumptech.glide.load.a r12, v<Z> r13) {
        v<Z> r14 = (v) ZeusTransformUtils.wrapperContextForParams(r13, v.class, "com.obric.aiagent.plugin");
        Class<?> r8 = r14.d().getClass();
        com.bumptech.glide.load.l<Z> r1 = null;
        if (r12 == com.bumptech.glide.load.a.f3352d) goto L5;
        com.bumptech.glide.load.m<Z> r0 = this.f3645a.c(r8);
        com.bumptech.glide.load.m<Z> r7 = r0;
        v<Z> r2 = r0.a(this.h, r14, this.l, this.m);
    L7:
        if (r14.equals(r2) == true) goto L10;
        r14.f();
    L10:
        if (this.f3645a.a(r2) == false) goto L12;
        r1 = this.f3645a.b(r2);
        com.bumptech.glide.load.c r15 = r1.a(this.o);
    L13:
        com.bumptech.glide.load.l r10 = r1;
        if (this.n.a(!this.f3645a.a(this.x), r12, r15) == false) goto L27;
        if (r10 == null) goto L26;
        int r16 = AnonymousClass1.f3652c[r15.ordinal()];
        if (r16 != 1) goto L19;
        com.bumptech.glide.load.g r17 = new com.bumptech.glide.load.engine.d(this.x, this.i);
    L24:
        u r3 = u.a(r2);
        this.f.a(r17, r10, r3);
        return r3;
    L19:
        if (r16 != 2) goto L22;
        r17 = new x(this.f3645a.i(), this.x, this.i, this.l, this.m, r7, r8, this.o);
        goto L24
    L22:
        throw new IllegalArgumentException("Unknown strategy: " + r15);
    L26:
        throw new com.bumptech.glide.f.d(r2.d().getClass());
    L27:
        return r2;
    L12:
        r15 = com.bumptech.glide.load.c.f3508c;
        goto L13
    L5:
        r2 = r14;
        r7 = null;
        goto L7
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
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
