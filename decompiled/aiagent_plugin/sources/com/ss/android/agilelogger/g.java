package com.ss.android.agilelogger;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static boolean a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        String r0 = b();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.contains(":") == false) goto L9;
        return false;
    L9:
        if (r0.equals(r5.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r0.equals(r5.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static String b() {
        if (Build.VERSION.SDK_INT < 28) goto L33;
        return Application.getProcessName();
    L33:
        Method r2 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin").getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L9
        r2.setAccessible(true);     // Catch: Exception -> L9
        return (String) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[0]), String.class, "com.obric.aiagent.plugin");
    L9:
        BufferedReader r0 = new BufferedReader(new FileReader("/proc/self/cmdline"));     // Catch: Throwable -> L20 Exception -> L25
        String r3 = r0.readLine();     // Catch: Throwable -> L18 Exception -> L32
        if (TextUtils.isEmpty(r3) == true) goto L35;
        String r4 = r3.trim();     // Catch: Throwable -> L18 Exception -> L32
        if (TextUtils.isEmpty(r4) == true) goto L35;
        r0.close();     // Catch: Exception -> L29
    L15:
        return r4;
    L35:
        r0.close();     // Catch: Exception -> L30
    L28:
        return null;
    L18:
        Throwable th = th;
    L22:
        if (r0 != null) goto L37;
    L24:
        throw th;
    L37:
        r0.close();     // Catch: Exception -> L31
    L26:
        if (r0 == null) goto L28;
    L25:
        r0 = null;
    L20:
        th = move-exception;
        th = th;
        r0 = null;
        goto L22
    }
}
