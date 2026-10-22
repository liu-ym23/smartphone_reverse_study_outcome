package com.bytedance.ttnet.c;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.ae;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DebugMode.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11399a = "ttnet_debug_mode";

    static {
    }

    private static boolean c() {
        if (TTNetInit.a.f11230b == TTNetInit.getEnv()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (c() == true) goto L6;
        Logger.d(f11399a, "debug_mode close");
        return;
    L6:
        b(r3);
    }

    private static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Logger.d(f11399a, "debug_mode open");
        if (b.a(r3) == false) goto L6;
        b();
        return;
    }

    public static boolean a() {
        if (c() == true) goto L7;
        return false;
    L7:
        return b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static void b() {
        Logger.setLogLevel(2);
        ae.a(Logger.getLogLevel());
    }
}
