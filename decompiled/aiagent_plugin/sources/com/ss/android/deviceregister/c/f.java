package com.ss.android.deviceregister.c;

/* JADX INFO: compiled from: Singleton.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f37418a;

    public abstract T b(Object... r1);

    public f() {
    }

    public final T c(Object... r2) {
        if (this.f37418a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f37418a != null) goto L8;
        this.f37418a = b(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f37418a;
    }
}
