package com.amap.api.mapcore.util;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class f6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f6 f27271c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27273b;

    public final synchronized void a() {
        monitor-enter(this);
        if (o5.f27736d != null) goto L8;
        int r100 = k6.f27506h;     // Catch: Throwable -> L10
        j6 r101 = new j6();     // Catch: Throwable -> L10
        if (o5.f27736d != null) goto L8;
        o5.f27736d = r101;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    }

    private f6(Context r100) {
        this.f27272a = r100.getApplicationContext();
        this.f27273b = l6.a(x5.b("RYW1hcF9kZXZpY2VfYWRpdQ"));
    }

    public static f6 a(Context r100) {
        if (f27271c != null) goto L15;
        monitor-enter(f6.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f27271c != null) goto L9;
        f27271c = new f6(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f6.class);     // Catch: Throwable -> L11
    L15:
        return f27271c;
    }

    public final void a(String r100) {
        g6.a(this.f27272a).a(this.f27273b);
        g6.a(this.f27272a).b(r100);
    }
}
