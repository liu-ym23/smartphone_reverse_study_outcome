package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardEvents.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SafetyGuardEventsKt {
    public static final boolean isNoopObserver(SafetyGuardEventObserver r2) {
        SafetyGuardEventObserver r3 = (SafetyGuardEventObserver) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardEventObserver.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        if (r3 != SafetyGuardEventObserver.Companion.noop()) goto L5;
        return true;
    L5:
        return false;
    }
}
