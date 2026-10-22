package com.bytedance.apm.util;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: compiled from: SlardarProperties.java */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f4996a;

    private static void b() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (f4996a != null) goto L15;
        f4996a = new Properties();
        InputStream r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f4996a.load(r1);     // Catch: Throwable -> L16
    L10:
        com.bytedance.apm6.util.d.a(r1);
        return;
    L17:
        f4996a = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.bytedance.apm6.util.d.a(r1);
        throw th;
    L8:
        r1 = null;
        goto L17
    }

    private static Object a(String r2) {
        b();
        Properties r1 = f4996a;     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.containsKey(r2) == false) goto L13;
        return f4996a.get(r2);
    L13:
        return null;
    L14:
        return null;
    }

    public static String a() {
        return String.valueOf(a("release_build"));
    }
}
