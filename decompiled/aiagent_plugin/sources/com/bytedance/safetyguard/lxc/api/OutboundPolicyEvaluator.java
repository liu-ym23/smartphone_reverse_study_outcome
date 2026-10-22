package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OutboundPolicyApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OutboundPolicyEvaluator {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: OutboundPolicyApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final OutboundPolicyEvaluator ALLOW_ALL = null;
        private static final OutboundPolicyEvaluator SIDECAR_AWARE = null;

        public static /* synthetic */ OutboundPolicyDecision lambda$L7QnVDmeL2cBXx6wEQuD0EyBucs(OutboundTarget r0) {
            return ALLOW_ALL$lambda$0(r0);
        }

        public static /* synthetic */ OutboundPolicyDecision lambda$PwHCAjG7F98d3iefuXl6MHocL58(OutboundTarget r0) {
            return SIDECAR_AWARE$lambda$1(r0);
        }

        private Companion() {
        }

        public final OutboundPolicyEvaluator allowAll() {
            return ALLOW_ALL;
        }

        public final OutboundPolicyEvaluator sidecarAware() {
            return SIDECAR_AWARE;
        }

        static {
            $$INSTANCE = new Companion();
            ALLOW_ALL = $$Lambda$OutboundPolicyEvaluator$Companion$L7QnVDmeL2cBXx6wEQuD0EyBucs.INSTANCE;
            SIDECAR_AWARE = $$Lambda$OutboundPolicyEvaluator$Companion$PwHCAjG7F98d3iefuXl6MHocL58.INSTANCE;
        }

        private static final OutboundPolicyDecision ALLOW_ALL$lambda$0(OutboundTarget r2) {
            o.e(r2, "it");
            return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.Allow.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
        }

        private static final OutboundPolicyDecision SIDECAR_AWARE$lambda$1(OutboundTarget r2) {
            o.e(r2, "target");
            if (r2.getIngressProxy() != OutboundIngressProxy.SIDECAR_AUTH) goto L6;
            return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.SidecarAuth.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
        L6:
            return (OutboundPolicyDecision) ZeusTransformUtils.preCheckCast(OutboundPolicyDecision.Allow.INSTANCE, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    OutboundPolicyDecision evaluate(OutboundTarget r1);
}
