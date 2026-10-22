package com.bytedance.apm.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f6625b;

    static {
    }

    public static Application a(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Application) == true) goto L9;
        r10 = r10.getApplicationContext();
    L9:
        return (Application) r10;
    }

    public static String b(int r10) {
        if (TextUtils.isEmpty(f6624a) == true) goto L41;
        return f6624a;
    L41:
        BufferedReader r11 = new BufferedReader(new FileReader("/proc/" + r10 + "/cmdline"));     // Catch: Throwable -> L19
        String r12 = r11.readLine();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r12) == true) goto L13;
        r12 = r12.trim();     // Catch: Throwable -> L11
    L13:
        f6624a = r12;     // Catch: Throwable -> L11
        r11.close();     // Catch: IOException -> L16
    L18:
        return r12;
    L16:
        e = move-exception;
        e.printStackTrace();
    L11:
        th = th;
    L39:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r11 != null) goto L35;
    L27:
        return null;
    L35:
        r11.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r11 != null) goto L43;
    L34:
        throw th;
    L43:
        r11.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r11 = null;
        goto L39
    }

    public static boolean c(Context r10) {
        Boolean r11 = f6625b;
        if (r11 == null) goto L7;
        return r11.booleanValue();
    L7:
        if (r10 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L10:
        if ((r10.getApplicationInfo().flags & 2) == 0) goto L12;
        boolean r12 = true;
    L13:
        Boolean r13 = Boolean.valueOf(r12);     // Catch: Exception -> L15
        f6625b = r13;     // Catch: Exception -> L15
        return r13.booleanValue();
    L12:
        r12 = false;
        goto L13
    }

    public static boolean d(Context r10) {
        String r11 = b(Process.myPid());
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.contains(":") == false) goto L7;
        return false;
    }
}
