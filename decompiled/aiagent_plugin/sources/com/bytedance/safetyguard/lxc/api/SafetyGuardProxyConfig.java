package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardProxyConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SafetyGuardProxyConfig {
    private final SafetyGuardEventObserver eventObserver;
    private final OutboundPolicyEvaluator policyEvaluator;
    private final LxcProxyConfig proxy;

    public SafetyGuardProxyConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SafetyGuardProxyConfig copy$default(SafetyGuardProxyConfig r1, LxcProxyConfig r2, OutboundPolicyEvaluator r3, SafetyGuardEventObserver r4, int r5, Object r6) {
        OutboundPolicyEvaluator r7 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r3, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        SafetyGuardEventObserver r8 = (SafetyGuardEventObserver) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardEventObserver.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.proxy;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.policyEvaluator;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.eventObserver;
    L12:
        return r1.copy(r2, r7, r8);
    }

    public final LxcProxyConfig component1() {
        return this.proxy;
    }

    public final OutboundPolicyEvaluator component2() {
        return this.policyEvaluator;
    }

    public final SafetyGuardEventObserver component3() {
        return this.eventObserver;
    }

    public final SafetyGuardProxyConfig copy(LxcProxyConfig r2, OutboundPolicyEvaluator r3, SafetyGuardEventObserver r4) {
        OutboundPolicyEvaluator r1 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r3, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        SafetyGuardEventObserver r5 = (SafetyGuardEventObserver) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardEventObserver.class, "com.obric.aiagent.plugin");
        o.e(r2, "proxy");
        o.e(r1, "policyEvaluator");
        o.e(r5, "eventObserver");
        return new SafetyGuardProxyConfig(r2, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SafetyGuardProxyConfig.class) == true) goto L8;
        return false;
    L8:
        SafetyGuardProxyConfig r6 = (SafetyGuardProxyConfig) ZeusTransformUtils.preCheckCast(r5, SafetyGuardProxyConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.proxy, r6.proxy) == true) goto L12;
        return false;
    L12:
        if (o.a(this.policyEvaluator, r6.policyEvaluator) == true) goto L15;
        return false;
    L15:
        if (o.a(this.eventObserver, r6.eventObserver) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.proxy.hashCode() * 31) + this.policyEvaluator.hashCode()) * 31) + this.eventObserver.hashCode();
    }

    public String toString() {
        return "SafetyGuardProxyConfig(proxy=" + this.proxy + ", policyEvaluator=" + this.policyEvaluator + ", eventObserver=" + this.eventObserver + ')';
    }

    public SafetyGuardProxyConfig(LxcProxyConfig r3, OutboundPolicyEvaluator r4, SafetyGuardEventObserver r5) {
        OutboundPolicyEvaluator r6 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r4, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        SafetyGuardEventObserver r7 = (SafetyGuardEventObserver) ZeusTransformUtils.wrapperContextForParams(r5, SafetyGuardEventObserver.class, "com.obric.aiagent.plugin");
        o.e(r3, "proxy");
        o.e(r6, "policyEvaluator");
        o.e(r7, "eventObserver");
        this.proxy = r3;
        this.policyEvaluator = r6;
        this.eventObserver = r7;
    }

    public /* synthetic */ SafetyGuardProxyConfig(LxcProxyConfig r9, OutboundPolicyEvaluator r10, SafetyGuardEventObserver r11, int r12, h r13) {
        OutboundPolicyEvaluator r14 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r10, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        SafetyGuardEventObserver r15 = (SafetyGuardEventObserver) ZeusTransformUtils.wrapperContextForParams(r11, SafetyGuardEventObserver.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L6;
        r9 = new LxcProxyConfig(0, 0, 0, 0, 0, 31, null);
    L6:
        if ((r12 & 2) == 0) goto L9;
        r14 = OutboundPolicyEvaluator.Companion.sidecarAware();
    L9:
        if ((r12 & 4) == 0) goto L11;
        r15 = SafetyGuardEventObserver.Companion.noop();
    L11:
        this(r9, r14, r15);
    }

    public final LxcProxyConfig getProxy() {
        return this.proxy;
    }

    public final OutboundPolicyEvaluator getPolicyEvaluator() {
        return this.policyEvaluator;
    }

    public final SafetyGuardEventObserver getEventObserver() {
        return this.eventObserver;
    }
}
