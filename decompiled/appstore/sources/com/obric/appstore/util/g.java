package com.obric.appstore.util;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11076a;

    public g(int r10) {
        this.f11076a = r10;
    }

    public final synchronized boolean a(int r10) {
        monitor-enter(this);
        if ((r10 & this.f11076a) == 0) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(this);
        return r11;
    L7:
        r11 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(int r10) {
        monitor-enter(this);
        this.f11076a = r10 | this.f11076a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(int r10) {
        monitor-enter(this);
        int r11 = this.f11076a;     // Catch: Throwable -> L6
        this.f11076a = (~r10) & r11;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
