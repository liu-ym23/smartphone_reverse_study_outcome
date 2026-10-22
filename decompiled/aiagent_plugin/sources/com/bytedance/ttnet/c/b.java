package com.bytedance.ttnet.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DebugSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11400a = "ttnet_debug_setting";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11401b = "log_switcher";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f11402c = "x86_support";

    static {
    }

    private static String a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getSharedPreferences(f11400a, 0).getString(r4, null);
    }

    public static boolean a(Context r2) {
        return "true".equals(a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), f11401b));
    }

    public static boolean b(Context r2) {
        return "true".equals(a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), f11402c));
    }
}
