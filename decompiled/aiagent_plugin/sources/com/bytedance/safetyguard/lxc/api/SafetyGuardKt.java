package com.bytedance.safetyguard.lxc.api;

import android.content.Context;
import com.bytedance.safetyguard.lxc.internal.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuard.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SafetyGuardKt {
    private static final b safetyGuardProvider = null;

    static {
        safetyGuardProvider = new b((q) ZeusTransformUtils.preCheckCast(SafetyGuardKt$safetyGuardProvider$1.INSTANCE, q.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(SafetyGuardKt$safetyGuardProvider$2.INSTANCE, m.class, "com.obric.aiagent.plugin"));
    }

    public static final SafetyGuard initializeSafetyGuard(Context r3, SafetyGuardLogger r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r6 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "logger");
        b r0 = safetyGuardProvider;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getApplicationContext(...)");
        return r0.a(r7, r6);
    }

    public static final SafetyGuard getSafetyGuard(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        b r0 = safetyGuardProvider;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "getApplicationContext(...)");
        return r0.a(r5);
    }
}
