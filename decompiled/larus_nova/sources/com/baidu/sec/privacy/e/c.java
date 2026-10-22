package com.baidu.sec.privacy.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f33527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f33528b;

    public c(Context r100) {
        f33528b = r100;
    }

    public static c a(Context r100) {
        if (f33527a != null) goto L13;
        monitor-enter(c.class);
        f33527a = new c(r100);     // Catch: Throwable -> L9
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f33527a;
    }

    public PackageInfo a(String r100, int r101) throws PackageManager.NameNotFoundException {
    L8:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return null;
    L4:
        if (com.baidu.sec.privacy.d.a.b(19) == true) goto L6;
        return null;
    L6:
        return f33528b.getPackageManager().getPackageInfo(r100, r101);
    }
}
