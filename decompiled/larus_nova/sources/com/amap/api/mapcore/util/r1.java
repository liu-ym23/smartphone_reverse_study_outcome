package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile r1 f27922a;

    public static r1 a() {
        if (f27922a != null) goto L15;
        monitor-enter(r1.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f27922a != null) goto L9;
        f27922a = new r1();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1.class);     // Catch: Throwable -> L11
    L15:
        return f27922a;
    }

    private r1() {
    }
}
