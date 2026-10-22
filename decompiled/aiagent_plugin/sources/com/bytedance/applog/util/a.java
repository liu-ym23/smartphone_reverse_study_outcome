package com.bytedance.applog.util;

/* JADX INFO: compiled from: AbsSingleton.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f6030a;

    public abstract T b(Object... r1);

    public a() {
    }

    public final T c(Object... r2) {
        if (this.f6030a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f6030a != null) goto L8;
        this.f6030a = b(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f6030a;
    }
}
