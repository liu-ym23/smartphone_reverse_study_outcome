package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MonitorHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8693a;

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f8693a != null) goto L6;
        String r4 = com.bytedance.framwork.core.sdklib.b.e.a(r3).replace(r3.getPackageName(), "p").replace(":", "_");
        f8693a = r4;
        f8693a = r4.replace(".", "_");
    L6:
        return f8693a;
    }
}
