package com.baidu.mshield.b.a;

import android.content.Context;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes39.dex */
public class d {
    public static String a(Context r100) {
        return com.baidu.mshield.b.e.c.a(r100, r100.getPackageName(), 0).versionName;
    L4:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    }

    public static boolean b(Context r100) {
    L12:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return false;
    L4:
        if (com.baidu.sec.privacy.f.e.a(r100, new String[]{"android.permission.ACCESS_NETWORK_STATE"}) == true) goto L7;
        return true;
    L7:
        NetworkInfo r101 = com.baidu.mshield.b.e.b.a(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.isConnected();
    }

    public static boolean c(Context r100) {
    L13:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    L15:
        return false;
    L4:
        if (com.baidu.sec.privacy.f.e.a(r100, new String[]{"android.permission.ACCESS_NETWORK_STATE"}) == false) goto L15;
        NetworkInfo r101 = com.baidu.mshield.b.e.b.a(r100);     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
        return false;
    L8:
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    }
}
