package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.m.c0.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static synchronized void a(Context r100, String r101, String r102, String r103) {
        monitor-enter(a.class);
        com.alipay.sdk.m.c0.a r104 = b(r100, r101, r102, r103);     // Catch: Throwable -> L7
        d.a(r100.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", r104.toString());     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(String r100) {
        monitor-enter(a.class);
        d.a(r100);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Throwable r100) {
        monitor-enter(a.class);
        d.a(r100);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static com.alipay.sdk.m.c0.a b(Context r100, String r101, String r110, String r111) {
        String r102 = r100.getPackageName();     // Catch: Throwable -> L4
    L3:
        String r103 = r102;
        return new com.alipay.sdk.m.c0.a(Build.MODEL, r103, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202303020703", r101, r110, r111);
    L4:
        r102 = "";
        goto L3
    }
}
