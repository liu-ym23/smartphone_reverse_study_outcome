package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<com.bumptech.glide.load.g, b> f3513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f3515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f3516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p.a f3517e;
    private volatile boolean f;
    private volatile InterfaceC0092a g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveResources.java */
    interface InterfaceC0092a {
        void a();
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    static final class b extends WeakReference<p<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.g f3521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f3522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        v<?> f3523c;

        b(com.bumptech.glide.load.g r3, p<?> r4, ReferenceQueue<? super p<?>> r5, boolean r6) {
            com.bumptech.glide.load.g r7 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            super(r4, r5);
            this.f3521a = (com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r7), com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            if (r4.b() == false) goto L6;
            if (r6 == false) goto L6;
            v<?> r8 = (v) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r4.a()), v.class, "com.obric.aiagent.plugin");
        L7:
            this.f3523c = r8;
            this.f3522b = r4.b();
            return;
        L6:
            r8 = null;
            goto L7
        }

        void a() {
            this.f3523c = null;
            clear();
        }
    }

    a(boolean r2) {
        this(r2, Executors.newSingleThreadExecutor(new AnonymousClass1()));
    }

    a(boolean r3, Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.f3513a = new HashMap();
        this.f3516d = new ReferenceQueue();
        this.f3514b = r3;
        this.f3515c = r5;
        r5.execute(new AnonymousClass2(this));
    }

    void a(p.a r3) {
        p.a r4 = (p.a) ZeusTransformUtils.wrapperContextForParams(r3, p.a.class, "com.obric.aiagent.plugin");
        monitor-enter(r4);
        monitor-enter(this);     // Catch: Throwable -> L12
        this.f3517e = r4;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    synchronized void a(com.bumptech.glide.load.g r4, p<?> r5) {
        monitor-enter(this);
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        b r0 = new b(r6, r5, this.f3516d, this.f3514b);     // Catch: Throwable -> L8
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.f3513a.put(r6, r0), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r7 == null) goto L6;
        r7.a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void a(com.bumptech.glide.load.g r3) {
        monitor-enter(this);
        com.bumptech.glide.load.g r4 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.f3513a.remove(r4), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r5 == null) goto L6;
        r5.a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized p<?> b(com.bumptech.glide.load.g r4) {
        monitor-enter(this);
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        b r6 = (b) ZeusTransformUtils.preCheckCast(this.f3513a.get(r5), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r6 == null) goto L6;
        p<?> r0 = (p) ZeusTransformUtils.preCheckCast(r6.get(), p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        a(r6);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    void a(b r8) {
        monitor-enter(this);
        this.f3513a.remove(r8.f3521a);     // Catch: Throwable -> L13
        if (r8.f3522b == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (r8.f3523c == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L13
        p<?> r0 = new p(r8.f3523c, true, false, r8.f3521a, this.f3517e);
        this.f3517e.a(r8.f3521a, r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void a() {
    L3:
        if (this.f == true) goto L9;
        a((b) ZeusTransformUtils.preCheckCast(this.f3516d.remove(), b.class, "com.obric.aiagent.plugin"));     // Catch: InterruptedException -> L8
        InterfaceC0092a r0 = this.g;     // Catch: InterruptedException -> L8
        if (r0 == null) goto L3;
        r0.a();     // Catch: InterruptedException -> L8
    L8:
        Thread.currentThread().interrupt();
        goto L3
    }

    void b() {
        this.f = true;
        if (ZeusTransformUtils.instanceOf(this.f3515c, ExecutorService.class) == false) goto L6;
        com.bumptech.glide.f.e.a((ExecutorService) ZeusTransformUtils.preCheckCast(this.f3515c, ExecutorService.class, "com.obric.aiagent.plugin"));
        return;
    }
}
