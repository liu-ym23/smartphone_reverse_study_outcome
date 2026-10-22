package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class SysUtils {
    private static final String TAG = "SysUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37660a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f37661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Integer f37662c;

    static {
    }

    private SysUtils() {
    }

    private static int a() {
        Pattern r1 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r2 = StrictMode.allowThreadDiskReads();
        FileReader r3 = new FileReader("/proc/meminfo");     // Catch: Throwable -> L27 Exception -> L29
        BufferedReader r4 = new BufferedReader(r3);     // Catch: Throwable -> L24
    L36:
        String r5 = r4.readLine();     // Catch: Throwable -> L21
        if (r5 == null) goto L7;
        Matcher r6 = r1.matcher(r5);     // Catch: Throwable -> L21
        if (r6.find() == false) goto L36;
        int r7 = Integer.parseInt(r6.group(1));     // Catch: Throwable -> L21
        if (r7 > 1024) goto L17;
        a(TAG, "Invalid /proc/meminfo total size in kB: " + r6.group(1));     // Catch: Throwable -> L21
    L14:
        r4.close();     // Catch: Throwable -> L24
        r3.close();     // Catch: Throwable -> L27 Exception -> L29
    L31:
        StrictMode.setThreadPolicy(r2);
        return 0;
    L17:
        r4.close();     // Catch: Throwable -> L24
        r3.close();     // Catch: Throwable -> L27 Exception -> L29
        StrictMode.setThreadPolicy(r2);
        return r7;
    L7:
        a(TAG, "/proc/meminfo lacks a MemTotal entry?");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L27 Exception -> L29
        throw th;     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = move-exception;
        StrictMode.setThreadPolicy(r2);
        throw th;
    L29:
        e = move-exception;
        a(TAG, "Cannot get total physical size from /proc/meminfo", e);     // Catch: Throwable -> L27
        goto L31
    }

    public static boolean isLowEndDevice() {
        if (f37661b != null) goto L6;
        f37661b = Boolean.valueOf(b());
    L6:
        return f37661b.booleanValue();
    }

    public static int amountOfPhysicalMemoryKB() {
        if (f37662c != null) goto L6;
        f37662c = Integer.valueOf(a());
    L6:
        return f37662c.intValue();
    }

    public static boolean isCurrentlyLowMemory() {
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        return r1.lowMemory;
    }

    private static boolean b() {
        if (f37660a == false) goto L5;
    L9:
        boolean r1 = true;
        if (c.b().a("enable-low-end-device-mode") == false) goto L13;
        return true;
    L13:
        if (c.b().a("disable-low-end-device-mode") == false) goto L15;
        return false;
    L15:
        Integer r0 = Integer.valueOf(a());
        f37662c = r0;
        if (r0.intValue() > 0) goto L19;
    L17:
        boolean r2 = false;
    L27:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L29;
    L31:
        boolean r3 = false;
    L32:
        if (r2 == r3) goto L35;
        r1 = false;
    L35:
        com.ttnet.org.chromium.base.a.b.a("Android.SysUtilsLowEndMatches", r1);
        return r2;
    L29:
        if (Build.VERSION.SDK_INT < 19) goto L31;
        r3 = ((ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin")).isLowRamDevice();
        goto L32
    L19:
        if (Build.VERSION.SDK_INT < 26) goto L24;
        if ((f37662c.intValue() / 1024) > 1024) goto L17;
    L22:
        r2 = true;
        goto L27
    L24:
        if ((f37662c.intValue() / 1024) > 512) goto L17;
    L5:
        if (c.a() == true) goto L9;
        throw new AssertionError();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
