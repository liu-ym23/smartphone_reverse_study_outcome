package com.bytedance.apm6.util;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApmBaseContext.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5453a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5454b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Application f5455c;

    static {
    }

    public a() {
    }

    public static void a(boolean r0) {
        f5453a = r0;
    }

    public static boolean u() {
        if (f5453a == true) goto L5;
    L7:
        return false;
    L5:
        if (f5454b == true) goto L7;
        return true;
    }

    public static boolean v() {
        return f5454b;
    }

    public static Application getContext() {
        return f5455c;
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        f5455c = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(r3), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        return;
    }

    private static Application b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == true) goto L11;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L11:
        return (Application) ZeusTransformUtils.preCheckCast(r3, Application.class, "com.obric.aiagent.plugin");
    }
}
