package com.bytedance.bdinstall.j;

/* JADX INFO: compiled from: InstanceHolder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f6316a;

    public abstract T b(Object... r1);

    public i() {
    }

    public final T c(Object... r2) {
        if (this.f6316a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f6316a != null) goto L8;
        this.f6316a = b(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f6316a;
    }
}
