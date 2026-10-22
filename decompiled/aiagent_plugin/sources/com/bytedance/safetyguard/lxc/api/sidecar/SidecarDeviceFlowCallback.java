package com.bytedance.safetyguard.lxc.api.sidecar;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SidecarDeviceFlowCallback {
    void onComplete(SidecarResult r1);

    void onVerificationUrl(String r1, int r2);
}
