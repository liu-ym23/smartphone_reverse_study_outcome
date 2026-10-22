package com.android.server.hdmi;

import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class SendKeyAction extends HdmiCecFeatureAction {
    private static final int AWAIT_LONGPRESS_MS = 400;
    private static final int AWAIT_RELEASE_KEY_MS = 1000;
    private static final int STATE_CHECKING_LONGPRESS = 1;
    private static final int STATE_PROCESSING_KEYCODE = 2;
    private static final String TAG = "SendKeyAction";
    private int mLastKeycode;
    private long mLastSendKeyTime;
    private final int mTargetAddress;

    public static /* synthetic */ void $r8$lambda$DE5NYEJk3xgWDQ3g352_7Qfcz7w(SendKeyAction r0) {
        r0.lambda$queryAvrAudioStatus$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$EKUHRy-lHFbuxSBu6egbhu3mFSo, reason: not valid java name */
    public static /* synthetic */ void m4430$r8$lambda$EKUHRylHFbuxSBu6egbhu3mFSo(SendKeyAction r0, int r1) {
        r0.lambda$sendKeyUp$0(r1);
    }

    SendKeyAction(HdmiCecLocalDevice source, int targetAddress, int keycode) {
        super(source);
        this.mTargetAddress = targetAddress;
        this.mLastKeycode = keycode;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean start() {
        sendKeyDown(this.mLastKeycode);
        this.mLastSendKeyTime = getCurrentTime();
        if (HdmiCecKeycode.isRepeatableKey(this.mLastKeycode) == true) goto L6;
        sendKeyUp();
        finish();
        return true;
    L6:
        this.mState = 1;
        addTimer(this.mState, 400);
        return true;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    void processKeyEvent(int keycode, boolean isPressed) {
        if (this.mState != 1) goto L5;
    L8:
        if (isPressed == false) goto L20;
        if (keycode == this.mLastKeycode) goto L16;
        sendKeyDown(keycode);
        this.mLastSendKeyTime = getCurrentTime();
        if (HdmiCecKeycode.isRepeatableKey(keycode) == true) goto L18;
        sendKeyUp();
        finish();
        return;
    L18:
        this.mActionTimer.clearTimerMessage();
        addTimer(this.mState, 1000);
        this.mLastKeycode = keycode;
        return;
    L16:
        if ((getCurrentTime() - this.mLastSendKeyTime) < 300) goto L18;
        sendKeyDown(keycode);
        this.mLastSendKeyTime = getCurrentTime();
        goto L18
    L20:
        if (keycode != this.mLastKeycode) goto L24;
        sendKeyUp();
        finish();
        return;
    L24:
        return;
    L5:
        if (this.mState == 2) goto L8;
        Slog.w(TAG, "Not in a valid state");
    }

    private void sendKeyDown(int keycode) {
        byte[] cecKeycodeAndParams = HdmiCecKeycode.androidKeyToCecKey(keycode);
        if (cecKeycodeAndParams != null) goto L6;
        return;
    L6:
        if (this.mTargetAddress == 5) goto L8;
    L10:
        sendCommand(HdmiCecMessageBuilder.buildUserControlPressed(getSourceAddress(), this.mTargetAddress, cecKeycodeAndParams));
        return;
    L8:
        if (localDevice().getDeviceInfo().getLogicalAddress() == 0) goto L10;
        sendCommand(HdmiCecMessageBuilder.buildUserControlPressed(getSourceAddress(), this.mTargetAddress, cecKeycodeAndParams), new AnonymousClass1(this));
    }

    private void sendKeyUp() {
        if (HdmiCecKeycode.isVolumeKeycode(this.mLastKeycode) == true) goto L5;
    L7:
        sendCommand(HdmiCecMessageBuilder.buildUserControlReleased(getSourceAddress(), this.mTargetAddress));
        return;
    L5:
        if (localDevice().getService().isAbsoluteVolumeBehaviorEnabled() == false) goto L7;
        sendCommand(HdmiCecMessageBuilder.buildUserControlReleased(getSourceAddress(), this.mTargetAddress), new SendKeyAction$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$sendKeyUp$0(int __) {
        queryAvrAudioStatus();
    }

    private void queryAvrAudioStatus() {
        localDevice().mService.runOnServiceThreadDelayed(new SendKeyAction$$ExternalSyntheticLambda1(this), 500);
    }

    private /* synthetic */ void lambda$queryAvrAudioStatus$1() {
        sendCommand(HdmiCecMessageBuilder.buildGiveAudioStatus(getSourceAddress(), localDevice().findAudioReceiverAddress()));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean processCommand(HdmiCecMessage cmd) {
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public void handleTimerEvent(int state) {
        switch(this.mState) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Not in a valid state");
        return;
    L5:
        sendKeyUp();
        finish();
        return;
    L6:
        this.mActionTimer.clearTimerMessage();
        this.mState = 2;
        sendKeyDown(this.mLastKeycode);
        this.mLastSendKeyTime = getCurrentTime();
        addTimer(this.mState, 1000);
    }
}
