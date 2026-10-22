package com.bytedance.reparo.core.i;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9287a;

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(f9287a) == false) goto L5;
        String r0 = a();
        f9287a = r0;
        if (TextUtils.isEmpty(r0) == false) goto L9;
        String r1 = b();
        f9287a = r1;
        if (TextUtils.isEmpty(r1) == false) goto L13;
        String r4 = c();
        f9287a = r4;
        if (TextUtils.isEmpty(r4) == false) goto L17;
        String r5 = b(r3);
        f9287a = r5;
        return r5;
    L17:
        return f9287a;
    L13:
        return f9287a;
    L9:
        return f9287a;
    L5:
        return f9287a;
    }

    private static String c() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: IOException -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L24;
    L14:
        return null;
    L24:
        r1.close();     // Catch: IOException -> L17
    L11:
        r1 = null;
        goto L12
    }

    public static String a() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Application.getProcessName();
    }

    public static String b() {
        Method r2 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", (Class[]) ZeusTransformUtils.preCheckCast(new Class[0], Class[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        r2.setAccessible(true);     // Catch: Throwable -> L7
        Object r3 = r2.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        int r2 = Process.myPid();
        ActivityManager r7 = (ActivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L16;
        List<ActivityManager.RunningAppProcessInfo> r8 = r7.getRunningAppProcesses();
        if (r8 == null) goto L16;
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r9.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");
        if (r3.pid != r2) goto L11;
        return r3.processName;
    L16:
        return null;
    }
}
