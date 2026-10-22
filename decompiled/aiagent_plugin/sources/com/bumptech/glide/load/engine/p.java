package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes.dex */
class p<Z> implements v<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f3716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v<Z> f3718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f3719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3720e;
    private int f;
    private boolean g;

    /* JADX INFO: compiled from: EngineResource.java */
    interface a {
        void a(com.bumptech.glide.load.g r1, p<?> r2);
    }

    p(v<Z> r3, boolean r4, boolean r5, com.bumptech.glide.load.g r6, a r7) {
        v r8 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r9 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
        this.f3718c = (v) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r8), v.class, "com.obric.aiagent.plugin");
        this.f3716a = r4;
        this.f3717b = r5;
        this.f3720e = r9;
        this.f3719d = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r10), a.class, "com.obric.aiagent.plugin");
    }

    v<Z> a() {
        return this.f3718c;
    }

    boolean b() {
        return this.f3716a;
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<Z> c() {
        return this.f3718c.c();
    }

    @Override // com.bumptech.glide.load.engine.v
    public Z d() {
        return this.f3718c.d();
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return this.f3718c.e();
    }

    @Override // com.bumptech.glide.load.engine.v
    public synchronized void f() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f > 0) goto L15;
        if (this.g == true) goto L13;
        this.g = true;     // Catch: Throwable -> L16
        if (this.f3717b == false) goto L10;
        this.f3718c.f();     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        return;
    L13:
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");     // Catch: Throwable -> L16
    L15:
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");     // Catch: Throwable -> L16
    }

    synchronized void g() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.g == true) goto L9;
        this.f++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("Cannot acquire a recycled resource");     // Catch: Throwable -> L10
    }

    void h() {
        monitor-enter(this);
        int r0 = this.f;     // Catch: Throwable -> L15
        if (r0 <= 0) goto L14;
        boolean r1 = true;
        int r2 = r0 - 1;     // Catch: Throwable -> L15
        this.f = r2;     // Catch: Throwable -> L15
        if (r2 == 0) goto L9;
        r1 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == false) goto L19;
        this.f3719d.a(this.f3720e, this);
        return;
    L19:
        return;
    L14:
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = "EngineResource{isMemoryCacheable=" + this.f3716a + ", listener=" + this.f3719d + ", key=" + this.f3720e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.f3718c + '}';     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
