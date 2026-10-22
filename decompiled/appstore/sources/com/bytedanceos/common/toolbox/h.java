package com.bytedanceos.common.toolbox;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import com.bytedanceos.common.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10064a = "LibraryUtil";

    static {
    }

    public static File a(Context r10, String r11) {
        String r12 = System.mapLibraryName(r11);
        File r13 = b(r10);
        if (r13 != null) goto L5;
        return null;
    L5:
        return new File(r13, r12);
    }

    public static File b(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new File(r10.getApplicationInfo().nativeLibraryDir);
    }

    public static void c() {
        ApplicationInfo r10 = BaseApplication.c().getApplicationInfo();
        i.b(f10064a, "appInfo.nativeLibraryDir: " + r10.nativeLibraryDir);
    }

    public static void d(String r10) {
        c();
        e(r10);
        f();
    }

    public static void e(String r10) {
        String r11 = System.mapLibraryName(r10);
        File r12 = a(BaseApplication.c(), r10);
        if (r12 != null) goto L6;
        i.b(f10064a, r11 + ": the lib is null");
        return;
    L6:
        if (r12.exists() == true) goto L8;
        i.b(f10064a, r11 + ": the lib is not exist");
        return;
    L8:
        String r13 = k.e(r12);
        i.b(f10064a, "the md5 of " + r11 + " is " + r13);
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        g r14 = new g(new FileInputStream(r12.getAbsolutePath()));     // Catch: IOException -> L12
        i.b(f10064a, "the elf of " + r11 + " is " + r14.toString());     // Catch: IOException -> L12
    L24:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: FileNotFoundException -> L15
    }

    public static void f() {
        Intent r10 = new Intent("bytedance.crashreport.customerror");
        r10.putExtra("timestamp", SystemClock.uptimeMillis());
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.obric.appstore";
    L6:
        r10.putExtra("process", r11);
        r10.putExtra("error_info", "send load library error log");
        r10.putExtra("catch_logcat", true);
        r10.putExtra("log_info", " include the lib elf info, the log print in logcat.");
        BaseApplication.c().sendBroadcast(r10, "bytedance.crashreport.send_custom");
        return;
    L5:
        r11 = "com.bytedanceos.gamestore";
        goto L6
    }
}
