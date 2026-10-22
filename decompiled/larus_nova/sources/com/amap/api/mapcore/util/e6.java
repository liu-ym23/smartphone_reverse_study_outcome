package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public class e6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e6 f27214b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27215a;

    public String a() {
        return this.f27215a;
    }

    private e6(Context r100) {
        r100.getApplicationContext();
        this.f27215a = UUID.randomUUID().toString().replaceAll("-", "");     // Catch: Throwable -> L5
        return;
    }

    public static e6 a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (f27214b != null) goto L18;
        monitor-enter(e6.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f27214b != null) goto L12;
        f27214b = new e6(r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(e6.class);     // Catch: Throwable -> L14
    L18:
        return f27214b;
    }
}
