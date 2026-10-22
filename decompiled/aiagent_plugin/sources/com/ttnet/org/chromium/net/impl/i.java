package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronetLoggerFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f38144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f38145b;

    private i() {
    }

    static {
        f38144a = new w();
    }

    public static h a() {
        return f38144a;
    }

    public static h a(Context r4, h.b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        h r0 = f38145b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (j.a(r6, r5) == false) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L20;
        Class<? extends h> r7 = b();
        if (r7 != null) goto L21;
        return f38144a;
    L21:
        return (h) ZeusTransformUtils.preCheckCast(r7.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1}), h.class, "com.obric.aiagent.plugin");
    L18:
        return f38144a;
    L20:
        return f38144a;
    }

    private static Class<? extends h> b() {
        return i.class.getClassLoader().loadClass("com.google.net.cronet.telemetry.CronetLoggerImpl").asSubclass(h.class);
    L5:
        return null;
    }
}
