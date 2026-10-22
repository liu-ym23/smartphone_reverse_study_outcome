package com.baidu.mshield.b.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes39.dex */
public class c {
    public static PackageInfo a(Context r100, String r101, int r102) {
        com.baidu.mshield.b.c.a.a("---privacy getPackageInfo---" + System.currentTimeMillis());     // Catch: PackageManager.NameNotFoundException -> L5
        return com.baidu.sec.privacy.e.c.a(r100).a(r101, r102);
    L5:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
        return null;
    }
}
