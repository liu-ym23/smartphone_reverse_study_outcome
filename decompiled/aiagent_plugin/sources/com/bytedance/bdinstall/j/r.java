package com.bytedance.bdinstall.j;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Singleton.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f6335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f6336b;

    public abstract T b(Object... r1);

    public r() {
        this.f6336b = new AtomicBoolean(false);
    }

    public final T c(Object... r2) {
        if (this.f6336b.get() == true) goto L18;
        if (this.f6335a != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f6336b.get() == false) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L10:
        if (this.f6335a != null) goto L12;
        this.f6335a = b(r2);     // Catch: Throwable -> L14
        this.f6336b.set(true);     // Catch: Throwable -> L14
    L18:
        return this.f6335a;
    }
}
