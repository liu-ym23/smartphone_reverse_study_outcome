package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements com.bumptech.glide.load.engine.b.h.a, m, p.a {
    private static final String TAG = "Engine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3680a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f3681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f3682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b.h f3683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f3684e;
    private final ResourceRecycler f;
    private final c g;
    private final a h;
    private final com.bumptech.glide.load.engine.a i;

    /* JADX INFO: compiled from: Engine.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h.d f3685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.core.util.f.a<h<?>> f3686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3687c;

        a(h.d r3) {
            h.d r4 = (h.d) ZeusTransformUtils.wrapperContextForParams(r3, h.d.class, "com.obric.aiagent.plugin");
            this.f3686b = com.bumptech.glide.f.a.a.a(150, new AnonymousClass1(this));
            this.f3685a = r4;
        }

        <R> h<R> a(GlideContext r20, Object r21, n r22, com.bumptech.glide.load.g r23, int r24, int r25, Class<?> r26, Class<R> r27, com.bumptech.glide.e r28, j r29, Map<Class<?>, com.bumptech.glide.load.m<?>> r30, boolean r31, boolean r32, boolean r33, com.bumptech.glide.load.i r34, h.a<R> r35) {
            GlideContext r2 = (GlideContext) ZeusTransformUtils.wrapperContextForParams(r20, GlideContext.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r23, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            Map<Class<?>, com.bumptech.glide.load.m<?>> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
            h.a<R> r17 = (h.a) ZeusTransformUtils.wrapperContextForParams(r35, h.a.class, "com.obric.aiagent.plugin");
            h r3 = (h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a((h) ZeusTransformUtils.preCheckCast(this.f3686b.a(), h.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
            int r4 = this.f3687c;
            this.f3687c = r4 + 1;
            return r3.a(r2, r21, r22, r5, r24, r25, r26, r27, r28, r29, r1, r31, r32, r33, r34, r17, r4);
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f3689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f3690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f3691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f3692d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final m f3693e;
        final p.a f;
        final androidx.core.util.f.a<l<?>> g;

        b(com.bumptech.glide.load.engine.c.a r3, com.bumptech.glide.load.engine.c.a r4, com.bumptech.glide.load.engine.c.a r5, com.bumptech.glide.load.engine.c.a r6, m r7, p.a r8) {
            m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
            p.a r10 = (p.a) ZeusTransformUtils.wrapperContextForParams(r8, p.a.class, "com.obric.aiagent.plugin");
            this.g = com.bumptech.glide.f.a.a.a(150, new AnonymousClass1(this));
            this.f3689a = r3;
            this.f3690b = r4;
            this.f3691c = r5;
            this.f3692d = r6;
            this.f3693e = r9;
            this.f = r10;
        }

        void a() {
            com.bumptech.glide.f.e.a(this.f3689a);
            com.bumptech.glide.f.e.a(this.f3690b);
            com.bumptech.glide.f.e.a(this.f3691c);
            com.bumptech.glide.f.e.a(this.f3692d);
        }

        <R> l<R> a(com.bumptech.glide.load.g r9, boolean r10, boolean r11, boolean r12, boolean r13) {
            com.bumptech.glide.load.g r3 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            return ((l) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a((l) ZeusTransformUtils.preCheckCast(this.g.a(), l.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).a(r3, r10, r11, r12, r13);
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    private static class c implements h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.b.a.InterfaceC0093a f3695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.b.a f3696b;

        c(com.bumptech.glide.load.engine.b.a.InterfaceC0093a r3) {
            this.f3695a = (com.bumptech.glide.load.engine.b.a.InterfaceC0093a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.b.a.InterfaceC0093a.class, "com.obric.aiagent.plugin");
        }

        synchronized void b() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f3696b != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            this.f3696b.a();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // com.bumptech.glide.load.engine.h.d
        public com.bumptech.glide.load.engine.b.a a() {
            if (this.f3696b != null) goto L17;
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L6:
            if (this.f3696b != null) goto L9;
            this.f3696b = this.f3695a.a();     // Catch: Throwable -> L13
        L9:
            if (this.f3696b != null) goto L11;
            this.f3696b = new com.bumptech.glide.load.engine.b.b();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.f3696b;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f3697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l<?> f3698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bumptech.glide.request.i f3699c;

        d(k r3, com.bumptech.glide.request.i r4, l<?> r5) {
            com.bumptech.glide.request.i r6 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
            this.f3697a = r3;
            this.f3699c = r6;
            this.f3698b = r5;
        }

        public void a() {
            k r0 = this.f3697a;
            monitor-enter(r0);
            this.f3698b.c(this.f3699c);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f3680a = a(TAG, 2);
    }

    public k(com.bumptech.glide.load.engine.b.h r17, com.bumptech.glide.load.engine.b.a.InterfaceC0093a r18, com.bumptech.glide.load.engine.c.a r19, com.bumptech.glide.load.engine.c.a r20, com.bumptech.glide.load.engine.c.a r21, com.bumptech.glide.load.engine.c.a r22, boolean r23) {
        this((com.bumptech.glide.load.engine.b.h) ZeusTransformUtils.wrapperContextForParams(r17, com.bumptech.glide.load.engine.b.h.class, "com.obric.aiagent.plugin"), (com.bumptech.glide.load.engine.b.a.InterfaceC0093a) ZeusTransformUtils.wrapperContextForParams(r18, com.bumptech.glide.load.engine.b.a.InterfaceC0093a.class, "com.obric.aiagent.plugin"), r19, r20, r21, r22, null, null, null, null, null, null, r23);
    }

    k(com.bumptech.glide.load.engine.b.h r12, com.bumptech.glide.load.engine.b.a.InterfaceC0093a r13, com.bumptech.glide.load.engine.c.a r14, com.bumptech.glide.load.engine.c.a r15, com.bumptech.glide.load.engine.c.a r16, com.bumptech.glide.load.engine.c.a r17, s r18, o r19, com.bumptech.glide.load.engine.a r20, b r21, a r22, ResourceRecycler r23, boolean r24) {
        com.bumptech.glide.load.engine.b.h r8 = (com.bumptech.glide.load.engine.b.h) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.engine.b.h.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.b.a.InterfaceC0093a r0 = (com.bumptech.glide.load.engine.b.a.InterfaceC0093a) ZeusTransformUtils.wrapperContextForParams(r13, com.bumptech.glide.load.engine.b.a.InterfaceC0093a.class, "com.obric.aiagent.plugin");
        this.f3683d = r8;
        c r9 = new c(r0);
        this.g = r9;
        if (r20 != null) goto L5;
        com.bumptech.glide.load.engine.a r1 = new com.bumptech.glide.load.engine.a(r24);
    L6:
        this.i = r1;
        r1.a(this);
        if (r19 != null) goto L9;
        o r2 = new o();
    L10:
        this.f3682c = r2;
        if (r18 != null) goto L13;
        s r3 = new s();
    L14:
        this.f3681b = r3;
        if (r21 != null) goto L17;
        b r10 = new b(r14, r15, r16, r17, this, this);
    L18:
        this.f3684e = r10;
        if (r22 != null) goto L21;
        a r4 = new a(r9);
    L22:
        this.h = r4;
        if (r23 != null) goto L25;
        ResourceRecycler r5 = new ResourceRecycler();
    L26:
        this.f = r5;
        r8.a(this);
        return;
    L25:
        r5 = r23;
        goto L26
    L21:
        r4 = r22;
        goto L22
    L17:
        r10 = r21;
        goto L18
    L13:
        r3 = r18;
        goto L14
    L9:
        r2 = r19;
        goto L10
    L5:
        r1 = r20;
        goto L6
    }

    public <R> d a(GlideContext r25, Object r26, com.bumptech.glide.load.g r27, int r28, int r29, Class<?> r30, Class<R> r31, com.bumptech.glide.e r32, j r33, Map<Class<?>, com.bumptech.glide.load.m<?>> r34, boolean r35, boolean r36, com.bumptech.glide.load.i r37, boolean r38, boolean r39, boolean r40, boolean r41, com.bumptech.glide.request.i r42, Executor r43) {
        GlideContext r2 = (GlideContext) ZeusTransformUtils.wrapperContextForParams(r25, GlideContext.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r0 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r27, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Map<Class<?>, com.bumptech.glide.load.m<?>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.i r14 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r42, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
        Executor r20 = (Executor) ZeusTransformUtils.wrapperContextForParams(r43, Executor.class, "com.obric.aiagent.plugin");
        if (f3680a == false) goto L5;
        long r3 = com.bumptech.glide.f.f.a();
    L6:
        long r10 = r3;
        n r11 = this.f3682c.a(r26, r0, r28, r29, r12, r30, r31, r37);
        monitor-enter(this);
        p<?> r1 = a(r11, r38, r10);     // Catch: Throwable -> L18
        if (r1 != null) goto L15;
        d r4 = a(r2, r26, r0, r28, r29, r30, r31, r32, r33, r12, r35, r36, r37, r38, r39, r40, r41, r14, r20, r11, r10);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r4;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L18
        r14.a(r1, com.bumptech.glide.load.a.f3353e);
        return null;
    L18:
        th = move-exception;
        throw th;
    L5:
        r3 = 0;
        goto L6
    }

    private <R> d a(GlideContext r22, Object r23, com.bumptech.glide.load.g r24, int r25, int r26, Class<?> r27, Class<R> r28, com.bumptech.glide.e r29, j r30, Map<Class<?>, com.bumptech.glide.load.m<?>> r31, boolean r32, boolean r33, com.bumptech.glide.load.i r34, boolean r35, boolean r36, boolean r37, boolean r38, com.bumptech.glide.request.i r39, Executor r40, n r41, long r42) {
        GlideContext r7 = (GlideContext) ZeusTransformUtils.wrapperContextForParams(r22, GlideContext.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r8 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r24, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Map<Class<?>, com.bumptech.glide.load.m<?>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.i r11 = (com.bumptech.glide.request.i) ZeusTransformUtils.wrapperContextForParams(r39, com.bumptech.glide.request.i.class, "com.obric.aiagent.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r40, Executor.class, "com.obric.aiagent.plugin");
        l<?> r1 = this.f3681b.a(r41, r38);
        if (r1 == null) goto L9;
        r1.a(r11, r10);
        if (f3680a == false) goto L8;
        a("Added to existing load", r42, r41);
    L8:
        return new d(this, r11, r1);
    L9:
        l<R> r6 = this.f3684e.a(r41, r35, r36, r37, r38);
        h<R> r2 = this.h.a(r7, r23, r41, r8, r25, r26, r27, r28, r29, r30, r12, r32, r33, r38, r34, r6);
        this.f3681b.a(r41, r6);
        r6.a(r11, r10);
        r6.b(r2);
        if (f3680a == false) goto L13;
        a("Started new load", r42, r41);
    L13:
        return new d(this, r11, r6);
    }

    private p<?> a(n r2, boolean r3, long r4) {
        if (r3 == true) goto L5;
        return null;
    L5:
        p<?> r5 = a(r2);
        if (r5 != null) goto L8;
        p<?> r1 = b(r2);
        if (r1 != null) goto L14;
        return null;
    L14:
        if (f3680a == false) goto L16;
        a("Loaded resource from cache", r4, r2);
    L16:
        return r1;
    L8:
        if (f3680a == false) goto L10;
        a("Loaded resource from active resources", r4, r2);
    L10:
        return r5;
    }

    private static void a(String r2, long r3, com.bumptech.glide.load.g r5) {
        a(TAG, r2 + " in " + com.bumptech.glide.f.f.a(r3) + "ms, key: " + ((com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin")));
    }

    private p<?> a(com.bumptech.glide.load.g r3) {
        com.bumptech.glide.load.g r4 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        p<?> r2 = this.i.b(r4);
        if (r2 == null) goto L5;
        r2.g();
    L5:
        return r2;
    }

    private p<?> b(com.bumptech.glide.load.g r3) {
        com.bumptech.glide.load.g r4 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        p<?> r0 = c(r4);
        if (r0 == null) goto L5;
        r0.g();
        this.i.a(r4, r0);
    L5:
        return r0;
    }

    private p<?> c(com.bumptech.glide.load.g r9) {
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        v<?> r3 = this.f3683d.a(r6);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L9;
        return (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin");
    L9:
        return new p(r3, true, true, r6, this);
    }

    public void a(v<?> r2) {
        v r1 = (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, p.class) == false) goto L7;
        ((p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.aiagent.plugin")).h();
        return;
    L7:
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void a(l<?> r3, com.bumptech.glide.load.g r4, p<?> r5) {
        monitor-enter(this);
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r5 != null) goto L6;
    L8:
        this.f3681b.b(r6, r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (r5.b() == false) goto L8;
        this.i.a(r6, r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void a(l<?> r3, com.bumptech.glide.load.g r4) {
        monitor-enter(this);
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f3681b.b(r5, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.b.h.a
    public void b(v<?> r3) {
        v<?> r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        this.f.a(r4, true);
    }

    @Override // com.bumptech.glide.load.engine.p.a
    public void a(com.bumptech.glide.load.g r3, p<?> r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.i.a(r5);
        if (r4.b() == false) goto L5;
        this.f3683d.b(r5, r4);
        return;
    L5:
        this.f.a(r4, false);
    }

    public void a() {
        this.g.a().a();
    }

    public void b() {
        this.f3684e.a();
        this.g.b();
        this.i.b();
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
}
