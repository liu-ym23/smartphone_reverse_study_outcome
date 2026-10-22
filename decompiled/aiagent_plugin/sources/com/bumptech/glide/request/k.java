package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements d, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f3940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile d f3942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f3943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e.a f3944e;
    private e.a f;
    private boolean g;

    public k(Object r3, e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        this.f3944e = e.a.f3920c;
        this.f = e.a.f3920c;
        this.f3941b = r3;
        this.f3940a = r5;
    }

    public void a(d r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.f3942c = r5;
        this.f3943d = r6;
    }

    @Override // com.bumptech.glide.request.e
    public boolean b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (i() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r4.equals(this.f3942c) == false) goto L9;
    L10:
        r2 = true;
        goto L12
    L9:
        if (this.f3944e == e.a.f3921d) goto L11;
        goto L10
    }

    private boolean i() {
        e r0 = this.f3940a;
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
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (k() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r4.equals(this.f3942c) == false) goto L11;
        if (g() == true) goto L11;
        r2 = true;
        goto L12
    }

    @Override // com.bumptech.glide.request.e
    public boolean d(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (j() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r4.equals(this.f3942c) == false) goto L11;
        if (this.f3944e == e.a.f3919b) goto L11;
        r2 = true;
        goto L12
    }

    private boolean j() {
        e r0 = this.f3940a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.d(this) == true) goto L8;
        return false;
    }

    private boolean k() {
        e r0 = this.f3940a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.c(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.d, com.bumptech.glide.request.e
    public boolean g() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f3943d.g() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.f3942c.g() == true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.e
    public void e(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.f3943d) == false) goto L9;
        this.f = e.a.f3921d;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        this.f3944e = e.a.f3921d;     // Catch: Throwable -> L17
        e r5 = this.f3940a;     // Catch: Throwable -> L17
        if (r5 == null) goto L13;
        r5.e(this);     // Catch: Throwable -> L17
    L13:
        if (this.f.a() == true) goto L15;
        this.f3943d.b();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    @Override // com.bumptech.glide.request.e
    public void f(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.f3942c) == true) goto L9;
        this.f = e.a.f3922e;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L9:
        this.f3944e = e.a.f3922e;     // Catch: Throwable -> L14
        e r5 = this.f3940a;     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r5.f(this);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bumptech.glide.request.e] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bumptech.glide.request.e
    public e h() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
        e r1 = this.f3940a;     // Catch: Throwable -> L9
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

    @Override // com.bumptech.glide.request.d
    public void a() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
        this.g = true;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        this.g = false;     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L8:
        if (this.f3944e == e.a.f3921d) goto L13;
        if (this.f == e.a.f3918a) goto L13;
        this.f = e.a.f3918a;     // Catch: Throwable -> L20
        this.f3943d.a();     // Catch: Throwable -> L20
    L13:
        if (this.g == true) goto L15;
    L17:
        this.g = false;     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L15:
        if (this.f3944e == e.a.f3918a) goto L17;
        this.f3944e = e.a.f3918a;     // Catch: Throwable -> L20
        this.f3942c.a();     // Catch: Throwable -> L20
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void b() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
        this.g = false;     // Catch: Throwable -> L8
        this.f3944e = e.a.f3920c;     // Catch: Throwable -> L8
        this.f = e.a.f3920c;     // Catch: Throwable -> L8
        this.f3943d.b();     // Catch: Throwable -> L8
        this.f3942c.b();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void c() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f.a() == true) goto L8;
        this.f = e.a.f3919b;     // Catch: Throwable -> L12
        this.f3943d.c();     // Catch: Throwable -> L12
    L8:
        if (this.f3944e.a() == true) goto L10;
        this.f3944e = e.a.f3919b;     // Catch: Throwable -> L12
        this.f3942c.c();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f3944e != e.a.f3918a) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f3944e != e.a.f3921d) goto L7;
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
        Object r0 = this.f3941b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f3944e != e.a.f3920c) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, k.class) == false) goto L20;
        k r7 = (k) ZeusTransformUtils.preCheckCast(r6, k.class, "com.obric.aiagent.plugin");
        if (this.f3942c != null) goto L10;
        if (r7.f3942c == null) goto L12;
        return false;
    L12:
        if (this.f3943d != null) goto L17;
        if (r7.f3943d != null) goto L23;
    L18:
        return true;
    L23:
        return false;
    L17:
        if (this.f3943d.a(r7.f3943d) == true) goto L18;
        return false;
    L10:
        if (this.f3942c.a(r7.f3942c) == true) goto L12;
        return false;
    L20:
        return false;
    }
}
