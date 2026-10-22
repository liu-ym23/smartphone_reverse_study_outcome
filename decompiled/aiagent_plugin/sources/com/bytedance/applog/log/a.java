package com.bytedance.applog.log;

/* JADX INFO: compiled from: AbsSingleton.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f5698a;

    public abstract T a(Object... r1);

    public a() {
    }

    public final T b(Object... r2) {
        if (this.f5698a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f5698a != null) goto L8;
        this.f5698a = a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f5698a;
    }
}
