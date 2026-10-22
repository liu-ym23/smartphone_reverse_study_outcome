package com.jeffmony.async.future;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements DependentCancellable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Cancellable f10402d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Cancellable f10403e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cancellable f10406c;

    public static class a extends d {
        public a() {
            e();
        }
    }

    public static class b extends d {
        public b() {
            cancel();
        }
    }

    static {
        f10402d = new a();
        f10403e = new b();
    }

    public d() {
    }

    public void b() {
    }

    public void c() {
    }

    @Override // com.jeffmony.async.future.Cancellable
    public boolean cancel() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f10404a == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L11:
        if (this.f10405b == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L8
        return true;
    L14:
        this.f10405b = true;     // Catch: Throwable -> L8
        Cancellable r10 = this.f10406c;     // Catch: Throwable -> L8
        this.f10406c = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r10 == null) goto L18;
        r10.cancel();
    L18:
        b();
        c();
        return true;
    }

    public void d() {
    }

    public boolean e() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f10405b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L10:
        if (this.f10404a == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L13:
        this.f10404a = true;     // Catch: Throwable -> L7
        this.f10406c = null;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        d();
        c();
        return true;
    }

    @Override // com.jeffmony.async.future.Cancellable
    public boolean isCancelled() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f10405b == true) goto L13;
        Cancellable r10 = this.f10406c;     // Catch: Throwable -> L10
        if (r10 != null) goto L8;
    L12:
        boolean r11 = false;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
        return r11;
    L8:
        if (r10.isCancelled() == false) goto L12;
    L13:
        r11 = true;
        goto L14
    }

    @Override // com.jeffmony.async.future.Cancellable
    public boolean isDone() {
        return this.f10404a;
    }

    @Override // com.jeffmony.async.future.DependentCancellable
    public boolean setParent(Cancellable r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isDone() == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.f10406c = r10;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return true;
    }
}
