package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CCStabilityListener {

    /* JADX INFO: compiled from: ComputerControlModels.kt */
    public static final class DefaultImpls {
        public static void onSessionUnstable(CCStabilityListener r1, int r2) {
            CCStabilityListener r3 = (CCStabilityListener) ZeusTransformUtils.wrapperContextForParams(r1, CCStabilityListener.class, "com.obric.aiagent.plugin");
        }
    }

    void onSessionStable();

    void onSessionUnstable(int r1);
}
