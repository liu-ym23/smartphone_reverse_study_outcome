package com.bytedance.safetyguard.lxc.api;

import android.content.Context;
import com.bytedance.safetyguard.lxc.internal.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.l;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuard.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class SafetyGuardKt$safetyGuardProvider$2 extends l implements m<Context, SafetyGuardLogger, SafetyGuard> {
    public static final SafetyGuardKt$safetyGuardProvider$2 INSTANCE = null;

    static {
        INSTANCE = new SafetyGuardKt$safetyGuardProvider$2();
    }

    SafetyGuardKt$safetyGuardProvider$2() {
        super(2, c.class, "createSafetyGuardInstance", "createSafetyGuardInstance(Landroid/content/Context;Lcom/bytedance/safetyguard/lxc/api/SafetyGuardLogger;)Lcom/bytedance/safetyguard/lxc/api/SafetyGuard;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SafetyGuard invoke2(Context r2, SafetyGuardLogger r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r4 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r1, "p0");
        return c.a(r1, r4);
    }

    @Override // d.h.a.m
    public /* synthetic */ SafetyGuard invoke(Context r3, SafetyGuardLogger r4) {
        return invoke2((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), (SafetyGuardLogger) ZeusTransformUtils.preCheckCast(r4, SafetyGuardLogger.class, "com.obric.aiagent.plugin"));
    }
}
