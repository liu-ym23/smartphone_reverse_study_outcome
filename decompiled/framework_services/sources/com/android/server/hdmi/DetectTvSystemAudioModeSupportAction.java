package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;

/* JADX INFO: loaded from: classes2.dex */
public class DetectTvSystemAudioModeSupportAction extends HdmiCecFeatureAction {
    static final int MAX_RETRY_COUNT = 5;
    private static final int STATE_WAITING_FOR_FEATURE_ABORT = 1;
    private static final int STATE_WAITING_FOR_SET_SAM = 2;
    private HdmiCecLocalDeviceAudioSystem.TvSystemAudioModeSupportedCallback mCallback;
    private int mSendSetSystemAudioModeRetryCount;

    public static /* synthetic */ void $r8$lambda$nYRA8LP6Gg0YOSexwv9N8fMZedg(DetectTvSystemAudioModeSupportAction r0, int r1) {
        r0.lambda$sendSetSystemAudioMode$0(r1);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    DetectTvSystemAudioModeSupportAction(HdmiCecLocalDevice source, HdmiCecLocalDeviceAudioSystem.TvSystemAudioModeSupportedCallback callback) {
        super(source);
        this.mSendSetSystemAudioModeRetryCount = 0;
        this.mCallback = callback;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        addTimer(this.mState, 2000);
        sendSetSystemAudioMode();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (cmd.getOpcode() == 0) goto L5;
    L14:
        return false;
    L5:
        if (this.mState == 1) goto L8;
        return false;
    L8:
        if (HdmiUtils.getAbortFeatureOpcode(cmd) != 114) goto L14;
        if (HdmiUtils.getAbortReason(cmd) != 1) goto L12;
        this.mActionTimer.clearTimerMessage();
        this.mState = 2;
        addTimer(this.mState, 300);
    L13:
        return true;
    L12:
        finishAction(false);
        goto L13
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 1: goto L12;
            case 2: goto L8;
            default: goto L7;
        };
    L7:
        return;
    L8:
        this.mSendSetSystemAudioModeRetryCount++;
        if (this.mSendSetSystemAudioModeRetryCount >= 5) goto L11;
        this.mState = 1;
        addTimer(this.mState, 2000);
        sendSetSystemAudioMode();
        return;
    L11:
        finishAction(false);
        return;
    L12:
        finishAction(true);
    }

    protected void sendSetSystemAudioMode() {
        sendCommand(HdmiCecMessageBuilder.buildSetSystemAudioMode(getSourceAddress(), 0, true), new DetectTvSystemAudioModeSupportAction$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$sendSetSystemAudioMode$0(int result) {
        if (result == 0) goto L5;
        finishAction(false);
        return;
    }

    private void finishAction(boolean supported) {
        this.mCallback.onResult(supported);
        audioSystem().setTvSystemAudioModeSupport(supported);
        finish();
    }
}
