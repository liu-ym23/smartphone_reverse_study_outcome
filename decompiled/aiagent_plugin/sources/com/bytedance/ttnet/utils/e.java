package com.bytedance.ttnet.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.common.utility.f;
import com.bytedance.common.utility.j;
import com.bytedance.retrofit2.ab;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TtnetUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11537a = false;

    static {
    }

    public static String a(Throwable r3) {
        String r0 = null;
        if (r3 != null) goto L29;
        return null;
    L29:
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L15
        r3.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r4 = r3.getCause();     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        r5.printStackTrace(r2);     // Catch: Throwable -> L13
    L11:
        r0 = r1.toString();     // Catch: Throwable -> L13
    L12:
        r2.close();
    L20:
        return r0;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
    L21:
        th = move-exception;
        if (r2 == null) goto L24;
        r2.close();
    L24:
        throw th;
    L15:
        th = th;
        r2 = null;
        goto L25
    }

    public static boolean a(String r2, String r3) {
        if (j.a(r2) == false) goto L5;
        return false;
    L5:
        if (j.a(r3) == false) goto L8;
        return false;
    L8:
        if (r2.equalsIgnoreCase(r3) == false) goto L11;
        return true;
    L11:
        String r4 = r2.toLowerCase();
        if (r3.startsWith(".") == false) goto L16;
        return r4.endsWith(r3.toLowerCase());
    L16:
        return r4.endsWith("." + r3.toLowerCase());
    }

    public static boolean a(String r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (j.a(r4) == false) goto L5;
    L17:
        return false;
    L5:
        if (f.a(r6) == true) goto L17;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L17;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (j.a(r0) == true) goto L9;
        if (a(r4, r0) == false) goto L9;
        return true;
    }

    public static void b(String r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (j.a(r4) == true) goto L14;
        if (r6 == null) goto L19;
        String[] r7 = r4.split(",");
        int r0 = r7.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L20;
        String r2 = r7[r1];
        if (j.a(r2) == true) goto L13;
        if (a(r2, r6) == true) goto L13;
        r6.add(r2.trim());
    L13:
        r1 = r1 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void a(com.bytedance.frameworks.baselib.network.http.i.f<String, ab> r4, com.bytedance.retrofit2.d.b r5) {
        com.bytedance.retrofit2.d.b r6 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.b() <= 0) goto L31;
        Map<String, ab> r7 = r4.c();
        Collection<ab> r0 = r7.values();
        monitor-enter(r7);
        Iterator<ab> r1 = r0.iterator();     // Catch: Throwable -> L18
    L10:
        if (r1.hasNext() == false) goto L16;
        List<com.bytedance.retrofit2.d.b> r2 = ((ab) ZeusTransformUtils.preCheckCast(r1.next(), ab.class, "com.obric.aiagent.plugin")).c();     // Catch: Throwable -> L18
        if (r2 == null) goto L10;
        if (r2.contains(r6) == true) goto L10;
        r2.add(r6);     // Catch: Throwable -> L18
        goto L10
    L16:
        monitor-exit(r7);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void b(com.bytedance.frameworks.baselib.network.http.i.f<String, ab> r4, com.bytedance.retrofit2.d.b r5) {
        com.bytedance.retrofit2.d.b r6 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.b() <= 0) goto L27;
        Map<String, ab> r7 = r4.c();
        Collection<ab> r0 = r7.values();
        monitor-enter(r7);
        Iterator<ab> r1 = r0.iterator();     // Catch: Throwable -> L16
    L10:
        if (r1.hasNext() == false) goto L14;
        List<com.bytedance.retrofit2.d.b> r2 = ((ab) ZeusTransformUtils.preCheckCast(r1.next(), ab.class, "com.obric.aiagent.plugin")).c();     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        r2.remove(r6);     // Catch: Throwable -> L16
        goto L10
    L14:
        monitor-exit(r7);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static Intent a(Context r6, PluginBroadcastReceiver r7, IntentFilter r8) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, r8, null, null, 4);
    }

    private static Intent a(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ZeusTransformUtils.registerReceiver(r0, r8, r9, r10, r11, r12, "com.obric.aiagent.plugin");
    L7:
        return ZeusTransformUtils.registerReceiver(r0, r8, r9, r10, r11, "com.obric.aiagent.plugin");
    }
}
