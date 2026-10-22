package com.bytedance.ttnet.a;

import com.bytedance.common.utility.reflect.Reflect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SDKConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11282a = true;

    static {
    }

    public static void a() {
        if (f11282a == true) goto L10;
        return;
    L10:
        Reflect.on(ZeusTransformUtils.forName("com.bytedance.crash.Npth", "com.obric.aiagent.plugin").newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{2616, "4.2.243.22-doubao"});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
