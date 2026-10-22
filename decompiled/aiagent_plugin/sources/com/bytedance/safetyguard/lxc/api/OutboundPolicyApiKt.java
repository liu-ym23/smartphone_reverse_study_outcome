package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OutboundPolicyApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutboundPolicyApiKt {
    public static final boolean isBuiltInSidecarAware(OutboundPolicyEvaluator r2) {
        OutboundPolicyEvaluator r3 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r2, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        if (r3 != OutboundPolicyEvaluator.Companion.sidecarAware()) goto L5;
        return true;
    L5:
        return false;
    }
}
