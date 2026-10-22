package com.bytedance.apm.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: AppUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f4964b;

    static {
    }

    public static Application a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == true) goto L11;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L11:
        return (Application) ZeusTransformUtils.preCheckCast(r3, Application.class, "com.obric.aiagent.plugin");
    }

    public static String a(int r5) {
        if (TextUtils.isEmpty(f4963a) == true) goto L45;
        return f4963a;
    L45:
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/" + r5 + "/cmdline"));     // Catch: Throwable -> L19
        String r6 = r1.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r6 = r6.trim();     // Catch: Throwable -> L17
    L11:
        f4963a = r6;     // Catch: Throwable -> L17
        r1.close();     // Catch: IOException -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L43:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r1 != null) goto L35;
    L27:
        return null;
    L35:
        r1.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r1 != null) goto L39;
    L34:
        throw th;
    L39:
        r1.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r1 = null;
        goto L43
    }

    public static boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        String r0 = a(Process.myPid());
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
}
