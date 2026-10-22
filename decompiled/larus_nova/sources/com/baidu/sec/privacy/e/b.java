package com.baidu.sec.privacy.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.sec.privacy.f.e;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f33525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f33526b;

    public NetworkInfo a() {
        ConnectivityManager r100 = (ConnectivityManager) f33526b.getSystemService("connectivity");     // Catch: Throwable -> L7
        if (e.a(f33526b, new String[]{"android.permission.ACCESS_NETWORK_STATE"}) == false) goto L12;
        return r100.getActiveNetworkInfo();
    L12:
        return null;
    L7:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return null;
    }

    public b(Context r100) {
        f33526b = r100;
    }

    public static b a(Context r100) {
        if (f33525a != null) goto L13;
        monitor-enter(b.class);
        f33525a = new b(r100);     // Catch: Throwable -> L9
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f33525a;
    }
}
