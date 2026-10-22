package com.slardaros.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Process;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f17859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f17860b = false;

    static {
    }

    public static String a() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L8
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L8
        if (r12 <= 0) goto L10;
        r11.append((char) r12);     // Catch: Throwable -> L8
        goto L5
    L10:
        String r13 = r11.toString();     // Catch: Throwable -> L8
        r10.close();     // Catch: Exception -> L13
    L15:
        return r13;
    L13:
        e = move-exception;
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L8:
        Throwable th = th;
    L39:
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + th.getMessage());     // Catch: Throwable -> L26
        if (r10 == null) goto L46;
        r10.close();     // Catch: Exception -> L22
        return "unknown";
    L22:
        e = move-exception;
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
        return "unknown";
    L46:
        return "unknown";
    L26:
        th = move-exception;
        if (r10 != null) goto L41;
    L32:
        throw th;
    L41:
        r10.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L16:
        th = move-exception;
        r10 = null;
        th = th;
        goto L39
    }

    public static String b(Context r10) {
        return r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionCode + "";
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static boolean c() {
        if (f17860b == false) goto L6;
        return true;
    L6:
        Context r10 = d.b();
        if (r10 == null) goto L9;
        String r11 = a();
        if (r11.contains(":") == false) goto L13;
        f17860b = false;
    L15:
        return f17860b;
    L13:
        f17860b = r11.equals(r10.getPackageName());
        goto L15
    L9:
        return d();
    }

    public static boolean d() {
        if (f17860b == false) goto L6;
        return true;
    L6:
        return !a().contains(":");
    }

    public static boolean e(Context r10) {
        Boolean r11 = f17859a;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L8:
        Intent r13 = new Intent("com.bytedance.os.slardar.ACTION_SLARDAR_SERVICE");
        List<ResolveInfo> r14 = null;
        if (r10 == null) goto L11;
        PackageManager r15 = r10.getPackageManager();
    L13:
        if (r15 == null) goto L15;
        r14 = r15.queryIntentServices(r13, 0);
    L16:
        if (r14 != null) goto L18;
    L20:
        OLog.d("Slardaros_Agent", "resolveInfoList is null or empty");
    L21:
        if (r14 != null) goto L23;
    L25:
        r12 = false;
    L26:
        Boolean r16 = Boolean.valueOf(r12);
        f17859a = r16;
        return r16.booleanValue();
    L23:
        if (r14.size() != 1) goto L25;
    L18:
        if (r14.size() < 1) goto L20;
        OLog.d("Slardaros_Agent", "resolveInfoList size: " + r14.size() + " first name: " + r14.get(0).serviceInfo.packageName);
        goto L21
    L15:
        OLog.d("Slardaros_Agent", "packageManager is null");
        goto L16
    L11:
        r15 = null;
        goto L13
    L5:
        if (r11.booleanValue() != true) goto L8;
        return f17859a.booleanValue();
    }
}
