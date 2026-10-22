package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppLogConstants.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f37361a = "applog_stats";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f37362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f37363c;

    static {
    }

    public static String a() {
        return f37361a;
    }

    public static void a(boolean r0) {
        f37363c = r0;
    }

    public static boolean b() {
        return f37363c;
    }

    public static String c() {
        if (TextUtils.isEmpty(f37362b) == false) goto L6;
        f37362b = com.ss.android.deviceregister.a.a.a.c.a("c25zc2RrX29wZW51ZGlk");
    L6:
        return f37362b;
    }

    public static SharedPreferences a(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(a(), 0);
    }
}
