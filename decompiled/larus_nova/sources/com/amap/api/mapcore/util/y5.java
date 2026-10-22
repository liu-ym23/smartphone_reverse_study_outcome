package com.amap.api.mapcore.util;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class y5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static y5 f28436a;

    private y5(Context r100) {
    }

    public static y5 a(Context r100) {
        if (f28436a != null) goto L15;
        monitor-enter(y5.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f28436a != null) goto L9;
        f28436a = new y5(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(y5.class);     // Catch: Throwable -> L11
    L15:
        return f28436a;
    }
}
