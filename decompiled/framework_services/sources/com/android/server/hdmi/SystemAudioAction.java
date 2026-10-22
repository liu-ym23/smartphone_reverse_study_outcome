package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.Slog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class SystemAudioAction extends HdmiCecFeatureAction {
    private static final int MAX_SEND_RETRY_COUNT = 2;
    private static final int OFF_TIMEOUT_MS = 2000;
    private static final int ON_TIMEOUT_MS = 5000;
    private static final int STATE_CHECK_ROUTING_IN_PRGRESS = 1;
    private static final int STATE_WAIT_FOR_SET_SYSTEM_AUDIO_MODE = 2;
    private static final String TAG = "SystemAudioAction";
    protected final int mAvrLogicalAddress;
    private int mSendRetryCount;
    protected boolean mTargetAudioStatus;

    /* JADX INFO: renamed from: -$$Nest$msendSystemAudioModeRequestInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4432$$Nest$msendSystemAudioModeRequestInternal(SystemAudioAction r0) {
        r0.sendSystemAudioModeRequestInternal();
    }

    SystemAudioAction(HdmiCecLocalDevice source, int avrAddress, boolean targetStatus, IHdmiControlCallback callback) {
        super(source, callback);
        this.mSendRetryCount = 0;
        if (HdmiUtils.verifyAddressType(avrAddress, 5) == true) goto L5;
        Slog.w(TAG, "Device type mismatch, stop the action.");
        finish();
    L5:
        this.mAvrLogicalAddress = avrAddress;
        this.mTargetAudioStatus = targetStatus;
    }

    protected void sendSystemAudioModeRequest() {
        List<RoutingControlAction> routingActions = getActions(RoutingControlAction.class);
        if (routingActions.isEmpty() == true) goto L6;
        this.mState = 1;
        RoutingControlAction routingAction = routingActions.get(0);
        routingAction.addOnFinishedCallback(this, new AnonymousClass1(this));
        return;
    L6:
        sendSystemAudioModeRequestInternal();
    }

    private void sendSystemAudioModeRequestInternal() {
        HdmiCecMessage command = HdmiCecMessageBuilder.buildSystemAudioModeRequest(getSourceAddress(), this.mAvrLogicalAddress, getSystemAudioModeRequestParam(), this.mTargetAudioStatus);
        sendCommand(command, new AnonymousClass2(this));
        this.mState = 2;
        int r1 = this.mState;
        if (this.mTargetAudioStatus == false) goto L5;
        int r2 = 5000;
    L6:
        addTimer(r1, r2);
        return;
    L5:
        r2 = 2000;
        goto L6
    }

    private int getSystemAudioModeRequestParam() {
        if (tv().getActiveSource().isValid() == true) goto L5;
        int param = tv().getActivePath();
        if (param != 65535) goto L11;
        return 0;
    L11:
        return param;
    L5:
        return tv().getActiveSource().physicalAddress;
    }

    private void handleSendSystemAudioModeRequestTimeout() {
        if (this.mTargetAudioStatus == false) goto L9;
        int r0 = this.mSendRetryCount;
        this.mSendRetryCount = r0 + 1;
        if (r0 >= 2) goto L9;
        sendSystemAudioModeRequest();
        return;
    L9:
        HdmiLogger.debug("[T]:wait for <Set System Audio Mode>.", new Object[0]);
        setSystemAudioMode(false);
        finishWithCallback(1);
    }

    protected void setSystemAudioMode(boolean mode) {
        tv().setSystemAudioMode(mode);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    final boolean processCommand(HdmiCecMessage cmd) {
        if (cmd.getSource() == this.mAvrLogicalAddress) goto L6;
        return false;
    L6:
        switch(this.mState) {
            case 2: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L9:
        if (cmd.getOpcode() != 0) goto L15;
        if ((cmd.getParams()[0] & CecDeviceType.INACTIVE) != 112) goto L15;
        HdmiLogger.debug("Failed to start system audio mode request.", new Object[0]);
        setSystemAudioMode(false);
        finishWithCallback(5);
        return true;
    L15:
        if (cmd.getOpcode() == 114) goto L17;
    L25:
        return false;
    L17:
        if (HdmiUtils.checkCommandSource(cmd, this.mAvrLogicalAddress, TAG) == false) goto L25;
        boolean receivedStatus = HdmiUtils.parseCommandParamSystemAudioStatus(cmd);
        if (receivedStatus != this.mTargetAudioStatus) goto L23;
        setSystemAudioMode(receivedStatus);
        finish();
        return true;
    L23:
        HdmiLogger.debug("Unexpected system audio mode request:" + receivedStatus, new Object[0]);
        finishWithCallback(5);
        return false;
    }

    protected void removeSystemAudioActionInProgress() {
        removeActionExcept(SystemAudioActionFromTv.class, this);
        removeActionExcept(SystemAudioActionFromAvr.class, this);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    final void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 2: goto L8;
            default: goto L7;
        };
    L7:
        return;
    L8:
        handleSendSystemAudioModeRequestTimeout();
    }
}
