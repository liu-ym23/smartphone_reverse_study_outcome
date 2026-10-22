package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Cdid.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, String> f6384a;

    static /* synthetic */ Map a() {
        return f6384a;
    }

    static {
        f6384a = new ConcurrentHashMap(4);
    }

    private n() {
    }

    public static String a(an r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r0 = r5.b();
        String r1 = (String) ZeusTransformUtils.preCheckCast(f6384a.get(r0), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
    L19:
        return r1;
    L8:
        monitor-enter(n.class);
        if (r1 == null) goto L20;
    L14:
        monitor-exit(n.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L20:
        if (ba.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L13;
        r1 = b(r5);     // Catch: Throwable -> L16
        f6384a.put(r0, r1);     // Catch: Throwable -> L16
        az.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r5.b(), "cdid", r1);     // Catch: Throwable -> L16
        goto L14
    L13:
        r1 = b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);     // Catch: Throwable -> L16
        goto L14
    }

    private static String b(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        if (r5 == null) goto L10;
        az.a(r6).a(r5.b(), "cdid", new AnonymousClass1());
        return (String) ZeusTransformUtils.preCheckCast(f6384a.get(r5.b()), String.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    L8:
        return null;
    }

    private static String b(an r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        SharedPreferences r1 = com.bytedance.bdinstall.j.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        String r4 = r1.getString("cdid", null);
        if (TextUtils.isEmpty(r4) == true) goto L8;
        return r4;
    L8:
        if (r6.o() == false) goto L10;
        String r5 = com.bytedance.bdinstall.j.j.a();
    L11:
        SharedPreferences r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r5, 0);
        String r0 = r7.getString("cdid", null);
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = UUID.randomUUID().toString();
    L14:
        String r8 = r0;
        r7.edit().putString("cdid", r8).apply();
        r1.edit().putString("cdid", r8).putBoolean("cdid_migrate", true).apply();
        return r8;
    L10:
        r5 = com.bytedance.bdinstall.j.j.a() + "_" + r6.a();
        goto L11
    }

    public static void a(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        if (r4 == null) goto L16;
        f6384a.remove(r4.b());
        com.bytedance.bdinstall.j.j.a(r5, r4).edit().remove("cdid").apply();
        if (r4.o() == false) goto L9;
        String r6 = com.bytedance.bdinstall.j.j.a();
    L10:
        SharedPreferences r7 = r5.getSharedPreferences(r6, 0);
        if (r7.contains("cdid") == false) goto L15;
        r7.edit().remove("cdid").apply();
        return;
    L15:
        return;
    L9:
        r6 = com.bytedance.bdinstall.j.j.a() + "_" + r4.a();
        goto L10
    L16:
        return;
    }

    public static String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        SharedPreferences r5 = r4.getSharedPreferences(com.bytedance.bdinstall.j.j.a(), 0);
        String r0 = r5.getString("cdid", null);
        if (TextUtils.isEmpty(r0) == false) goto L9;
        String r1 = UUID.randomUUID().toString();
        r5.edit().putString("cdid", r1).apply();
        return r1;
    L9:
        return r0;
    }
}
