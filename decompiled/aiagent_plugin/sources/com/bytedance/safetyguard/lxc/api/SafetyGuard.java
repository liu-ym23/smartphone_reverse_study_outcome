package com.bytedance.safetyguard.lxc.api;

import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SafetyGuard.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SafetyGuard {

    /* JADX INFO: compiled from: SafetyGuard.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ SafetyGuardProxyRuntime createProxyRuntime$default(SafetyGuard r6, SafetyGuardProxyConfig r7, int r8, Object r9) {
            SafetyGuard r10 = (SafetyGuard) ZeusTransformUtils.wrapperContextForParams(r6, SafetyGuard.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L10;
            if ((r8 & 1) == 0) goto L8;
            r7 = new SafetyGuardProxyConfig(null, null, null, 7, null);
        L8:
            return r10.createProxyRuntime(r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createProxyRuntime");
        }
    }

    SafetyGuardProxyRuntime createProxyRuntime(SafetyGuardProxyConfig r1);

    SafetyGuardSidecar getSidecar();
}
