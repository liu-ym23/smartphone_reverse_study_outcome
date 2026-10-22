package com.bytedance.frameworks.baselib.network.http.i;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f8385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f8386b;

    public static boolean a(Context r2) {
        String r3 = d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.endsWith(":push") == false) goto L7;
        return true;
    L7:
        if (r3.endsWith(":pushservice") == false) goto L13;
        return true;
    L13:
        return false;
    }

    static {
        f8385a = new AtomicInteger(0);
        f8386b = null;
    }

    public static void a(int r1) {
        f8385a.set(r1);
    }

    public static int a() {
        return f8385a.get();
    }

    public static boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("ProcessUtils", "TTNet ProcessFlag: " + f8385a);
    L5:
        int r0 = a();
        if (r0 != 1) goto L8;
        return true;
    L8:
        if (r0 != 2) goto L10;
        return false;
    L10:
        return c(r3);
    }

    public static boolean c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        String r0 = d(r4);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static String d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(f8386b) == false) goto L5;
        f8386b = b();
        if (com.bytedance.common.utility.j.a(f8386b) == false) goto L9;
        f8386b = c();
        if (com.bytedance.common.utility.j.a(f8386b) == false) goto L13;
        f8386b = d();
        if (com.bytedance.common.utility.j.a(f8386b) == false) goto L17;
        f8386b = e(r3);
        return f8386b;
    L17:
        return f8386b;
    L13:
        return f8386b;
    L9:
        return f8386b;
    L5:
        return f8386b;
    }

    private static String b() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    private static String c() {
        Method r1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String e(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if (r8 != null) goto L18;
        return null;
    L18:
        int r2 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r9.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r9.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        if (r3.pid != r2) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r3.processName);     // Catch: Exception -> L15
    L13:
        r0 = r3.processName;     // Catch: Exception -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String d() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L19
        if (r3 <= 0) goto L9;
        r2.append((char) r3);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r2.toString());     // Catch: Throwable -> L19
    L11:
        String r0 = r2.toString();     // Catch: Throwable -> L19
        r1.close();     // Catch: Exception -> L18
    L13:
        return r0;
    L15:
        if (r1 != null) goto L21;
    L17:
        return null;
    L21:
        r1.close();     // Catch: Exception -> L20
    L14:
        r1 = null;
        goto L15
    }
}
