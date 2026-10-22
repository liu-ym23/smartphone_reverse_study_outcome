package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f3914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile d f3915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f3916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e.a f3917e;
    private e.a f;

    public b(Object r3, e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        this.f3917e = e.a.f3920c;
        this.f = e.a.f3920c;
        this.f3913a = r3;
        this.f3914b = r5;
    }

    public void a(d r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.f3915c = r5;
        this.f3916d = r6;
    }

    @Override // com.bumptech.glide.request.d
    public void a() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f3917e == e.a.f3918a) goto L7;
        this.f3917e = e.a.f3918a;     // Catch: Throwable -> L9
        this.f3915c.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bumptech.glide.request.d
    public void b() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
        this.f3917e = e.a.f3920c;     // Catch: Throwable -> L9
        this.f3915c.b();     // Catch: Throwable -> L9
        if (this.f == e.a.f3920c) goto L7;
        this.f = e.a.f3920c;     // Catch: Throwable -> L9
        this.f3916d.b();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void c() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f3917e != e.a.f3918a) goto L8;
        this.f3917e = e.a.f3919b;     // Catch: Throwable -> L12
        this.f3915c.c();     // Catch: Throwable -> L12
    L8:
        if (this.f != e.a.f3918a) goto L10;
        this.f = e.a.f3919b;     // Catch: Throwable -> L12
        this.f3916d.c();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f3917e != e.a.f3918a) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.f == e.a.f3918a) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f3917e != e.a.f3921d) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.f == e.a.f3921d) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f3917e == e.a.f3920c) goto L7;
    L9:
        boolean r3 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L7:
        if (this.f != e.a.f3920c) goto L9;
        r3 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L10;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");
        if (this.f3915c.a(r7.f3915c) == true) goto L7;
        return false;
    L7:
        if (this.f3916d.a(r7.f3916d) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.request.e
    public boolean b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (i() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (g(r4) == false) goto L9;
        r2 = true;
        goto L10
    }

    private boolean i() {
        e r0 = this.f3914b;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.b(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.e
    public boolean c(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (k() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (g(r4) == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.e
    public boolean d(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (j() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (g(r4) == false) goto L9;
        r2 = true;
        goto L10
    }

    private boolean j() {
        e r0 = this.f3914b;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.d(this) == true) goto L8;
        return false;
    }

    private boolean k() {
        e r0 = this.f3914b;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.c(this) == true) goto L8;
        return false;
    }

    private boolean g(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (r4.equals(this.f3915c) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f3917e == e.a.f3922e) goto L7;
    L9:
        return false;
    L7:
        if (r4.equals(this.f3916d) == false) goto L9;
        goto L9
    }

    @Override // com.bumptech.glide.request.d, com.bumptech.glide.request.e
    public boolean g() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f3915c.g() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.f3916d.g() == true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.e
    public void e(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.f3915c) == false) goto L8;
        this.f3917e = e.a.f3921d;     // Catch: Throwable -> L15
    L10:
        e r5 = this.f3914b;     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        r5.e(this);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        if (r4.equals(this.f3916d) == false) goto L10;
        this.f = e.a.f3921d;     // Catch: Throwable -> L15
        goto L10
    }

    @Override // com.bumptech.glide.request.e
    public void f(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3913a;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.f3916d) == true) goto L11;
        this.f3917e = e.a.f3922e;     // Catch: Throwable -> L16
        if (this.f == e.a.f3918a) goto L9;
        this.f = e.a.f3918a;     // Catch: Throwable -> L16
        this.f3916d.a();     // Catch: Throwable -> L16
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        this.f = e.a.f3922e;     // Catch: Throwable -> L16
        e r5 = this.f3914b;     // Catch: Throwable -> L16
        if (r5 == null) goto L14;
        r5.f(this);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bumptech.glide.request.e] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bumptech.glide.request.e
    public e h() {
        Object r0 = this.f3913a;
        monitor-enter(r0);
        e r1 = this.f3914b;     // Catch: Throwable -> L9
        ?? r2 = this;
        if (r1 == null) goto L7;
        r2 = r1.h();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }
}
