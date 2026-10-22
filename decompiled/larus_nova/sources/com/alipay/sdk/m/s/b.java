package com.alipay.sdk.m.s;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f25784b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25785a;

    public static b d() {
        if (f25784b != null) goto L6;
        f25784b = new b();
    L6:
        return f25784b;
    }

    public static boolean e() {
        String[] r100 = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        int r101 = 0;
    L4:
        if (r101 >= 10) goto L10;
        if (new PolarisFileWrapper(r100[r101]).exists() == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public String c() {
        return com.alipay.sdk.m.w.b.c(null, this.f25785a);
    }

    public com.alipay.sdk.m.m.b a() {
        return com.alipay.sdk.m.m.b.b();
    }

    public b() {
    }

    public Context b() {
        return this.f25785a;
    }

    public void a(Context r100) {
        com.alipay.sdk.m.m.b.b();
        this.f25785a = r100.getApplicationContext();
    }
}
