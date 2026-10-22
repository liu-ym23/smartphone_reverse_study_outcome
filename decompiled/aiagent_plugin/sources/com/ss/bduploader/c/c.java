package com.ss.bduploader.c;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CustomVerify.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f37487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f37488b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f37489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f37490d;

    static {
        f37487a = ZeusTransformUtils.forName("com.ss.bduploader.util.X509Util", "com.obric.aiagent.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L5
        Class<?> r0 = ZeusTransformUtils.forName("com.ss.bduploader.util.AndroidCertVerifyResult", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        f37489c = r0;     // Catch: Exception -> L5
        f37490d = r0.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L5
        a("custom_verify", "find default verify suc");     // Catch: Exception -> L5
    L7:
        f37488b = true;
        if (f37487a != null) goto L10;
        return;
    L10:
        if (f37489c == null) goto L16;
        a("custom_verify", "get verify method or verify result class suc");
        return;
    L16:
        return;
    L5:
        e = move-exception;
        a("custom_verify", "found verify class or method exception:" + e.getMessage());
        a("custom_verify", "find default verify fail");
        goto L7
    }

    public static int a(byte[][] r5, String r6, String r7) {
        if (f37487a != null) goto L5;
    L14:
        a("custom_verify", "verify method is null ecception");
        return -99995;
    L5:
        if (f37489c == null) goto L14;
        if (f37490d == null) goto L14;
        a("custom_verify", "host: " + r7 + "  authType: " + r6);     // Catch: Throwable -> L11
        Object r8 = f37487a.invoke(null, new Object[]{r5, r6, r7});     // Catch: Throwable -> L11
        a("custom_verify", "get status end");     // Catch: Throwable -> L11
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(f37490d.invoke(r8, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L11
        a("custom_verify", "verify result status: " + r9);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        th.printStackTrace();
        a("custom_verify", "verify exception stacktrace:" + th.getMessage());
        return -99996;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
