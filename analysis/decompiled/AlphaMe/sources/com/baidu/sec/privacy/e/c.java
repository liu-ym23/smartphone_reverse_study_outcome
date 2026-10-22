package com.baidu.sec.privacy.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f9438a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f9439b;

    public c(Context context) {
        f9439b = context;
    }

    public static c a(Context context) {
        if (f9438a == null) {
            synchronized (c.class) {
                f9438a = new c(context);
            }
        }
        return f9438a;
    }

    public PackageInfo a(String str, int i4) throws PackageManager.NameNotFoundException {
        try {
            if (com.baidu.sec.privacy.d.a.b(19)) {
                return f9439b.getPackageManager().getPackageInfo(str, i4);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }
}
