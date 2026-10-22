package com.android.server.hdmi;

/* JADX INFO: loaded from: classes2.dex */
final class SystemAudioAutoInitiationAction extends HdmiCecFeatureAction {
    static final int RETRIES_ON_TIMEOUT = 1;
    private static final int STATE_WAITING_FOR_SYSTEM_AUDIO_MODE_STATUS = 1;
    private final int mAvrAddress;
    private int mRetriesOnTimeOut;

    /* JADX INFO: renamed from: -$$Nest$mhandleSystemAudioModeStatusTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4433$$Nest$mhandleSystemAudioModeStatusTimeout(SystemAudioAutoInitiationAction r0) {
        r0.handleSystemAudioModeStatusTimeout();
    }

    SystemAudioAutoInitiationAction(HdmiCecLocalDevice source, int avrAddress) {
        super(source);
        this.mRetriesOnTimeOut = 1;
        this.mAvrAddress = avrAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        addTimer(this.mState, 2000);
        sendGiveSystemAudioModeStatus();
        return true;
    }

    private void sendGiveSystemAudioModeStatus() {
        sendCommand(HdmiCecMessageBuilder.buildGiveSystemAudioModeStatus(getSourceAddress(), this.mAvrAddress), new AnonymousClass1(this));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L12:
        return false;
    L5:
        if (this.mAvrAddress != cmd.getSource()) goto L12;
        if (cmd.getOpcode() != 126) goto L11;
        handleSystemAudioModeStatusMessage(HdmiUtils.parseCommandParamSystemAudioStatus(cmd));
        return true;
    L11:
        return false;
    }

    private void handleSystemAudioModeStatusMessage(boolean currentSystemAudioMode) {
        if (canChangeSystemAudio() == true) goto L6;
        HdmiLogger.debug("Cannot change system audio mode in auto initiation action.", new Object[0]);
        finish();
        return;
    L6:
        boolean targetSystemAudioMode = tv().isSystemAudioControlFeatureEnabled();
        if (currentSystemAudioMode != targetSystemAudioMode) goto L15;
        if (currentSystemAudioMode == true) goto L10;
    L14:
        tv().setSystemAudioMode(targetSystemAudioMode);
    L16:
        finish();
        return;
    L10:
        if (tv().getAvrDeviceInfo() == null) goto L14;
        if (tv().getAvrDeviceInfo().getDevicePowerStatus() != 1) goto L14;
    L15:
        addAndStartAction(new SystemAudioActionFromTv(tv(), this.mAvrAddress, targetSystemAudioMode, null));
        goto L16
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 1: goto L9;
            default: goto L14;
        };
    L14:
        return;
    L9:
        if (this.mRetriesOnTimeOut <= 0) goto L12;
        this.mRetriesOnTimeOut--;
        addTimer(this.mState, 2000);
        sendGiveSystemAudioModeStatus();
        return;
    L12:
        handleSystemAudioModeStatusTimeout();
    }

    private void handleSystemAudioModeStatusTimeout() {
        if (canChangeSystemAudio() == true) goto L6;
        HdmiLogger.debug("Cannot change system audio mode in auto initiation action.", new Object[0]);
        finish();
        return;
    L6:
        addAndStartAction(new SystemAudioActionFromTv(tv(), this.mAvrAddress, tv().isSystemAudioControlFeatureEnabled(), null));
        finish();
    }

    private boolean canChangeSystemAudio() {
        if (tv().hasAction(SystemAudioActionFromTv.class) == false) goto L5;
    L7:
        return false;
    L5:
        if (tv().hasAction(SystemAudioActionFromAvr.class) == true) goto L7;
        return true;
    }
}
