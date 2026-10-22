package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class v3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile v3 f28179b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z8 f28180a;

    public static void a() {
        if (f28179b == null) goto L14;
    L8:
        th = move-exception;
        th.printStackTrace();
    L10:
        f28179b.f28180a = null;
        f28179b = null;
        return;
    L5:
        if (f28179b.f28180a == null) goto L10;
        f28179b.f28180a.a();     // Catch: Throwable -> L8
        goto L10
    }

    public static v3 b() {
        if (f28179b != null) goto L15;
        monitor-enter(v3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f28179b != null) goto L9;
        f28179b = new v3();     // Catch: Throwable -> L11
    L9:
        monitor-exit(v3.class);     // Catch: Throwable -> L11
    L15:
        return f28179b;
    }

    private v3() {
        this.f28180a = null;
        this.f28180a = n0.b("AMapThreadUtil");
    }

    public void a(a9 r100) {
        this.f28180a.d(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
