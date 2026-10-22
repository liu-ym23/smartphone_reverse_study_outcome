package com.bytedance.applog.log;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f192455a;

    public b() {
    }

    public abstract T a(Object... r100);

    public final T b(Object... r100) {
        if (this.f192455a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f192455a != null) goto L8;
        this.f192455a = a(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f192455a;
    }
}
