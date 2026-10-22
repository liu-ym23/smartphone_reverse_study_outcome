package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class SystemAudioActionFromTv extends SystemAudioAction {
    private static final String TAG = "SystemAudioActionFromTv";

    SystemAudioActionFromTv(HdmiCecLocalDevice sourceAddress, int avrAddress, boolean targetStatus, IHdmiControlCallback callback) {
        super(sourceAddress, avrAddress, targetStatus, callback);
        if (HdmiUtils.verifyAddressType(getSourceAddress(), 0) == true) goto L6;
        Slog.w(TAG, "Device type mismatch, stop the action.");
        finish();
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        removeSystemAudioActionInProgress();
        sendSystemAudioModeRequest();
        return true;
    }
}
