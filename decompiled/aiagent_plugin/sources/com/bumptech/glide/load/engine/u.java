package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LockedResource.java */
/* JADX INFO: loaded from: classes.dex */
final class u<Z> implements com.bumptech.glide.f.a.a.c, v<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.core.util.f.a<u<?>> f3734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.f.a.c f3735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v<Z> f3736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3738e;

    static {
        f3734a = com.bumptech.glide.f.a.a.a(20, new AnonymousClass1());
    }

    static <Z> u<Z> a(v<Z> r3) {
        v<Z> r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        u<Z> r0 = (u) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a((u) ZeusTransformUtils.preCheckCast(f3734a.a(), u.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin");
        r0.b(r4);
        return r0;
    }

    u() {
        this.f3735b = com.bumptech.glide.f.a.c.a();
    }

    private void b(v<Z> r3) {
        v<Z> r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        this.f3738e = false;
        this.f3737d = true;
        this.f3736c = r4;
    }

    private void b() {
        this.f3736c = null;
        f3734a.a(this);
    }

    synchronized void a() {
        monitor-enter(this);
        this.f3735b.b();     // Catch: Throwable -> L12
        if (this.f3737d == false) goto L11;
        this.f3737d = false;     // Catch: Throwable -> L12
        if (this.f3738e == false) goto L8;
        f();     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Already unlocked");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<Z> c() {
        return this.f3736c.c();
    }

    @Override // com.bumptech.glide.load.engine.v
    public Z d() {
        return this.f3736c.d();
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return this.f3736c.e();
    }

    @Override // com.bumptech.glide.load.engine.v
    public synchronized void f() {
        monitor-enter(this);
        this.f3735b.b();     // Catch: Throwable -> L8
        this.f3738e = true;     // Catch: Throwable -> L8
        if (this.f3737d == true) goto L6;
        this.f3736c.f();     // Catch: Throwable -> L8
        b();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.f.a.a.c
    public com.bumptech.glide.f.a.c b_() {
        return this.f3735b;
    }
}
