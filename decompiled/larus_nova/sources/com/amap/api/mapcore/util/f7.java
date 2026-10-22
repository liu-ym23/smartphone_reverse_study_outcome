package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
final class f7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f27277d;

    public final synchronized String a() {
        monitor-enter(this);
        String r100 = this.f27274a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int b() {
        monitor-enter(this);
        int r100 = this.f27275b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public f7() {
        this.f27274a = "";
        this.f27276c = 0;
        this.f27277d = 0;
        this.f27275b = 0;
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        this.f27274a = r100;     // Catch: Throwable -> L8
        this.f27276c = 2;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(int r100) {
        monitor-enter(this);
        this.f27275b = r100;     // Catch: Throwable -> L6
        this.f27277d = 2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r100, int r101) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f27276c != 0) goto L9;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        this.f27274a = r100;     // Catch: Throwable -> L13
        this.f27276c = 1;     // Catch: Throwable -> L13
    L9:
        if (this.f27277d != 0) goto L11;
        this.f27275b = r101;     // Catch: Throwable -> L13
        this.f27277d = 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }
}
