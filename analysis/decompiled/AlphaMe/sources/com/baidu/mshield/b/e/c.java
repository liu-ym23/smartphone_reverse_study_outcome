package com.baidu.mshield.b.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public class c {
    public static PackageInfo a(Context context, String str, int i4) {
        try {
            com.baidu.mshield.b.c.a.a("---privacy getPackageInfo---" + System.currentTimeMillis());
            return com.baidu.sec.privacy.e.c.a(context).a(str, i4);
        } catch (PackageManager.NameNotFoundException e4) {
            com.baidu.mshield.b.c.a.a(e4);
            return null;
        }
    }
}
