package com.bytedance.crash.o;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;

/* JADX INFO: compiled from: App.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7657a;

    public static String a() {
        if (TextUtils.isEmpty(f7657a) == false) goto L6;
        f7657a = d();
    L6:
        return f7657a;
    }

    public static void a(String r0) {
        f7657a = r0;
    }

    public static boolean a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.contains(":") == false) goto L8;
        return false;
    L8:
        if (r5 != null) goto L10;
        r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L10:
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r4.equals(r5.getPackageName()) == false) goto L17;
        return true;
    L17:
        return r4.equals(r5.getApplicationInfo().processName);
    }

    public static boolean b() {
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static boolean a(Context r2) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), a());
    }

    private static String d() {
        StringBuilder r0 = new StringBuilder();
        FileInputStream r1 = null;
        FileInputStream r2 = new FileInputStream("/proc/self/cmdline");     // Catch: Throwable -> L21 Exception -> L27
        goto L24
    L30:
        byte[] r3 = new byte[64];     // Catch: Throwable -> L18 Exception -> L20
    L6:
        int r4 = 0;
        int r5 = r2.read(r3, 0, 64);     // Catch: Throwable -> L18 Exception -> L20
    L7:
        if (r4 >= r5) goto L16;
        char r6 = (char) r3[r4];     // Catch: Throwable -> L18 Exception -> L20
        if (r6 == 0) goto L15;
        if (r6 == '\n') goto L15;
        r0.append(r6);     // Catch: Throwable -> L18 Exception -> L20
        r4 = r4 + 1;
        goto L7
    L15:
        r5 = -1;
    L16:
        if (r5 > 0) goto L6;
        i.a(r2);
    L26:
        return r0.toString();
    L20:
        r1 = r2;
    L18:
        th = th;
        r1 = r2;
    L22:
        i.a(r1);
        throw th;
    L21:
        th = th;
    L24:
        i.a(r1);
        goto L26
    }

    public static String b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(f7657a) == false) goto L5;
        String r4 = d();
        f7657a = r4;
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        return f7657a;
    }

    public static String c() {
        String r0 = f7657a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }
}
