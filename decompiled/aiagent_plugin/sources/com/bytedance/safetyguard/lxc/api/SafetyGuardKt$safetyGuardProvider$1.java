package com.bytedance.safetyguard.lxc.api;

import android.content.Context;
import com.bytedance.safetyguard.lxc.internal.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.l;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: SafetyGuard.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class SafetyGuardKt$safetyGuardProvider$1 extends l implements q<Context, SafetyGuard, SafetyGuardLogger, x> {
    public static final SafetyGuardKt$safetyGuardProvider$1 INSTANCE = null;

    static {
        INSTANCE = new SafetyGuardKt$safetyGuardProvider$1();
    }

    SafetyGuardKt$safetyGuardProvider$1() {
        super(3, c.class, "logSafetyGuardInitialized", "logSafetyGuardInitialized(Landroid/content/Context;Lcom/bytedance/safetyguard/lxc/api/SafetyGuard;Lcom/bytedance/safetyguard/lxc/api/SafetyGuardLogger;)V", 1);
    }

    @Override // d.h.a.q
    public /* synthetic */ x invoke(Context r3, SafetyGuard r4, SafetyGuardLogger r5) {
        invoke2((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), (SafetyGuard) ZeusTransformUtils.preCheckCast(r4, SafetyGuard.class, "com.obric.aiagent.plugin"), (SafetyGuardLogger) ZeusTransformUtils.preCheckCast(r5, SafetyGuardLogger.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context r2, SafetyGuard r3, SafetyGuardLogger r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        SafetyGuard r5 = (SafetyGuard) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuard.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r6 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r1, "p0");
        o.e(r5, "p1");
        c.a(r1, r5, r6);
    }
}
