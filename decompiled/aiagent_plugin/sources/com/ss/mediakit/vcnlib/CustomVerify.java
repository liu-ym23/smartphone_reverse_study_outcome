package com.ss.mediakit.vcnlib;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class CustomVerify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f37571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f37572b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f37573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f37574d;

    private static final native void _init();

    public CustomVerify() {
    }

    static {
        f37571a = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.X509Util", "com.obric.aiagent.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L8
        Class<?> r10 = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.AndroidCertVerifyResult", "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        f37573c = r10;     // Catch: Exception -> L8
        f37574d = r10.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L8
        a("custom_verify", "find ttnet verify suc");     // Catch: Exception -> L6
        boolean r11 = true;
    L11:
        if (r11 == false) goto L26;
    L16:
        f37572b = true;
        if (f37571a != null) goto L19;
        return;
    L19:
        if (f37573c == null) goto L29;
        a("custom_verify", "get verify method or verify result class suc");
        return;
    L29:
        return;
    L26:
        f37571a = ZeusTransformUtils.forName("com.ss.mediakit.vcnlib.X509Util", "com.obric.aiagent.plugin").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L14
        Class<?> r1 = ZeusTransformUtils.forName("com.ss.mediakit.vcnlib.AndroidCertVerifyResult", "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        f37573c = r1;     // Catch: Exception -> L14
        f37574d = r1.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L14
        a("custom_verify", "find default verify suc");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        a("custom_verify", "found verify class or method exception:" + e.getMessage());
        a("custom_verify", "find default verify fail");
    L6:
        e = e;
        r11 = true;
    L10:
        a("custom_verify", "found verify class or method exception:" + e.getMessage());
        a("custom_verify", "find ttnet verify fail");
    L8:
        e = e;
        r11 = false;
        goto L10
    }

    public static void a() {
        a("custom_verify", "start init native");
        _init();
        a("custom_verify", "end init native");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
