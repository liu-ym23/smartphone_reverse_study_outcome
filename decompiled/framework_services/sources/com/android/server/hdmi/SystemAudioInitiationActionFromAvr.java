package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAudioInitiationActionFromAvr extends HdmiCecFeatureAction {
    static final int MAX_RETRY_COUNT = 5;
    private static final int STATE_WAITING_FOR_ACTIVE_SOURCE = 1;
    private static final int STATE_WAITING_FOR_TV_SUPPORT = 2;
    private static final String TAG = "SystemAudioInitiationActionFromAvr";
    private int mSendRequestActiveSourceRetryCount;
    private int mSendSetSystemAudioModeRetryCount;

    public static /* synthetic */ void $r8$lambda$TEEvAqLxtbgyZimyMWYZLz66aAM(SystemAudioInitiationActionFromAvr r0, int r1) {
        r0.lambda$sendRequestActiveSource$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$VC02mJrg5oXe1xJ6N13ASuGNYmw(SystemAudioInitiationActionFromAvr r0, boolean r1, int r2, int r3) {
        r0.lambda$sendSetSystemAudioMode$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$vMiznBfh5TAqMOfAyeAd4h94eiw(SystemAudioInitiationActionFromAvr r0, boolean r1) {
        r0.lambda$queryTvSystemAudioModeSupport$2(r1);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    SystemAudioInitiationActionFromAvr(HdmiCecLocalDevice source) {
        super(source);
        this.mSendRequestActiveSourceRetryCount = 0;
        this.mSendSetSystemAudioModeRetryCount = 0;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        if (audioSystem().getActiveSource().physicalAddress != 65535) goto L5;
        this.mState = 1;
        addTimer(this.mState, 2000);
        sendRequestActiveSource();
    L6:
        return true;
    L5:
        this.mState = 2;
        queryTvSystemAudioModeSupport();
        goto L6
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        switch(cmd.getOpcode()) {
            case 130: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if (this.mState == 1) goto L8;
        return false;
    L8:
        this.mActionTimer.clearTimerMessage();
        audioSystem().handleActiveSource(cmd);
        this.mState = 2;
        queryTvSystemAudioModeSupport();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 1: goto L8;
            default: goto L10;
        };
    L8:
        handleActiveSourceTimeout();
        return;
    }

    protected void sendRequestActiveSource() {
        sendCommand(HdmiCecMessageBuilder.buildRequestActiveSource(getSourceAddress()), new SystemAudioInitiationActionFromAvr$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$sendRequestActiveSource$0(int result) {
        if (result != 0) goto L4;
        return;
    L4:
        if (this.mSendRequestActiveSourceRetryCount >= 5) goto L6;
        this.mSendRequestActiveSourceRetryCount++;
        sendRequestActiveSource();
        return;
    L6:
        audioSystem().checkSupportAndSetSystemAudioMode(false);
        finish();
    }

    protected void sendSetSystemAudioMode(final boolean on, final int dest) {
        sendCommand(HdmiCecMessageBuilder.buildSetSystemAudioMode(getSourceAddress(), dest, on), new SystemAudioInitiationActionFromAvr$$ExternalSyntheticLambda2(this, on, dest));
    }

    private /* synthetic */ void lambda$sendSetSystemAudioMode$1(boolean on, int dest, int result) {
        if (result != 0) goto L4;
        return;
    L4:
        if (this.mSendSetSystemAudioModeRetryCount >= 5) goto L6;
        this.mSendSetSystemAudioModeRetryCount++;
        sendSetSystemAudioMode(on, dest);
        return;
    L6:
        audioSystem().checkSupportAndSetSystemAudioMode(false);
        finish();
    }

    private void handleActiveSourceTimeout() {
        HdmiLogger.debug("Cannot get active source.", new Object[0]);
        if (audioSystem().mService.isStandbyMessageReceived() == false) goto L7;
        Slog.d(TAG, "Device is going to sleep, avoid to wake it up.");
        return;
    L7:
        if (audioSystem().mService.isPlaybackDevice() == false) goto L9;
        audioSystem().mService.setAndBroadcastActiveSourceFromOneDeviceType(15, getSourcePath(), "SystemAudioInitiationActionFromAvr#handleActiveSourceTimeout()");
        this.mState = 2;
        queryTvSystemAudioModeSupport();
    L10:
        finish();
        return;
    L9:
        audioSystem().checkSupportAndSetSystemAudioMode(false);
        goto L10
    }

    private void queryTvSystemAudioModeSupport() {
        audioSystem().queryTvSystemAudioModeSupport(new SystemAudioInitiationActionFromAvr$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$queryTvSystemAudioModeSupport$2(boolean supported) {
        if (supported == true) goto L4;
        audioSystem().checkSupportAndSetSystemAudioMode(false);
        finish();
        return;
    L4:
        if (audioSystem().checkSupportAndSetSystemAudioMode(true) == false) goto L6;
        sendSetSystemAudioMode(true, 15);
    L6:
        finish();
    }
}
