package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class SystemAudioActionFromAvr extends SystemAudioAction {
    private static final String TAG = "SystemAudioActionFromAvr";

    SystemAudioActionFromAvr(HdmiCecLocalDevice source, int avrAddress, boolean targetStatus, IHdmiControlCallback callback) {
        super(source, avrAddress, targetStatus, callback);
        if (HdmiUtils.verifyAddressType(getSourceAddress(), 0) == true) goto L6;
        Slog.w(TAG, "Device type mismatch, stop the action.");
        finish();
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        removeSystemAudioActionInProgress();
        handleSystemAudioActionFromAvr();
        return true;
    }

    private void handleSystemAudioActionFromAvr() {
        if (this.mTargetAudioStatus != tv().isSystemAudioActivated()) goto L7;
        finishWithCallback(0);
        return;
    L7:
        if (tv().isProhibitMode() == false) goto L10;
        sendCommand(HdmiCecMessageBuilder.buildFeatureAbortCommand(getSourceAddress(), this.mAvrLogicalAddress, 114, 4));
        this.mTargetAudioStatus = false;
        sendSystemAudioModeRequest();
        return;
    L10:
        removeAction(SystemAudioAutoInitiationAction.class);
        if (this.mTargetAudioStatus == false) goto L13;
        setSystemAudioMode(true);
        finish();
        return;
    L13:
        setSystemAudioMode(false);
        finishWithCallback(0);
    }
}
