package com.bytedance.applog;

import android.content.Context;
import com.bytedance.bdinstall.af;
import com.bytedance.bdinstall.as;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f5488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f5489b;

    static {
        f5488a = b();
        f5489b = false;
    }

    public static h a() {
        return f5488a;
    }

    public static Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f5488a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static h b() {
        return new c();
    }

    public static void a(af r2) {
        af r3 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.aiagent.plugin");
        f5488a.a(r3);
    }

    public static void a(String r1) {
        f5488a.b(r1);
    }

    public static String c() {
        return f5488a.l();
    }

    public static String d() {
        return f5488a.m();
    }

    public static String e() {
        return f5488a.p();
    }

    public static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return f5488a.a(r3);
    }

    public static void a(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        f5488a.a(r3);
    }

    public static void a(i r2) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
        f5488a.a(r3);
    }

    public static JSONObject f() {
        return f5488a.r();
    }

    public static void a(boolean r1) {
        f5488a.d(r1);
    }

    public static void a(Context r8, boolean r9, long r10, as r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r12, as.class, "com.obric.aiagent.plugin");
        f5488a.a(r3, r9, r10, r7);
    }

    public static void a(long r2, as r4) {
        as r5 = (as) ZeusTransformUtils.wrapperContextForParams(r4, as.class, "com.obric.aiagent.plugin");
        f5488a.a(r2, r5);
    }
}
