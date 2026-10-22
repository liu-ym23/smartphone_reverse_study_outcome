package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class OneTouchPlayAction extends HdmiCecFeatureAction {
    static final int LOOP_COUNTER_MAX = 10;
    static final int STATE_CHECK_STANDBY_PROCESS_STARTED = 2;
    static final int STATE_WAITING_FOR_REPORT_POWER_STATUS = 1;
    private static final String TAG = "OneTouchPlayAction";
    private final boolean mIsCec20;
    private int mPowerStatusCounter;
    private HdmiCecLocalDeviceSource mSource;
    private final int mTargetAddress;

    static OneTouchPlayAction create(HdmiCecLocalDeviceSource source, int targetAddress, IHdmiControlCallback callback) {
        if (source == null) goto L7;
        if (callback == null) goto L7;
        return new OneTouchPlayAction(source, targetAddress, callback);
    L7:
        Slog.e(TAG, "Wrong arguments");
        return null;
    }

    private OneTouchPlayAction(HdmiCecLocalDevice localDevice, int targetAddress, IHdmiControlCallback callback) {
        if (localDevice.getDeviceInfo().getCecVersion() >= 6) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this(localDevice, targetAddress, callback, r0);
        return;
    L5:
        if (getTargetCecVersion(localDevice, targetAddress) < 6) goto L7;
        r0 = true;
        goto L8
    }

    OneTouchPlayAction(HdmiCecLocalDevice localDevice, int targetAddress, IHdmiControlCallback callback, boolean isCec20) {
        super(localDevice, callback);
        this.mPowerStatusCounter = 0;
        this.mTargetAddress = targetAddress;
        this.mIsCec20 = isCec20;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mSource = source();
        if (this.mSource.mService.getPowerManager().isInteractive() == true) goto L5;
        Slog.d(TAG, "PowerManager is not interactive. Delay the action to check if standby started!");
        this.mState = 2;
        addTimer(this.mState, 2000);
        return true;
    L5:
        startAction();
        return true;
    }

    private void startAction() {
        Slog.i(TAG, "Start action.");
        sendCommand(HdmiCecMessageBuilder.buildTextViewOn(getSourceAddress(), this.mTargetAddress));
        if (this.mIsCec20 == true) goto L5;
    L7:
        boolean is20TargetOnBefore = false;
    L8:
        setAndBroadcastActiveSource();
        if (shouldTurnOnConnectedAudioSystem() == false) goto L12;
        sendCommand(HdmiCecMessageBuilder.buildSystemAudioModeRequest(getSourceAddress(), 5, getSourcePath(), true));
    L12:
        if (this.mIsCec20 == true) goto L14;
        queryDevicePowerStatus();
    L22:
        this.mState = 1;
        addTimer(this.mState, 2000);
        return;
    L14:
        int targetPowerStatus = getTargetDevicePowerStatus(this.mSource, this.mTargetAddress, -1);
        if (targetPowerStatus != (-1)) goto L17;
        queryDevicePowerStatus();
        goto L22
    L17:
        if (targetPowerStatus != 0) goto L22;
        if (is20TargetOnBefore == true) goto L20;
        maySendActiveSource();
    L20:
        finishWithCallback(0);
        return;
    L5:
        if (getTargetDevicePowerStatus(this.mSource, this.mTargetAddress, -1) != 0) goto L7;
        is20TargetOnBefore = true;
        goto L8
    }

    private void setAndBroadcastActiveSource() {
        this.mSource.mService.setAndBroadcastActiveSourceFromOneDeviceType(this.mTargetAddress, getServicePath(), "OneTouchPlayAction#broadcastActiveSource()");
        if (this.mSource.mService.audioSystem() == null) goto L5;
        this.mSource = this.mSource.mService.audioSystem();
    L5:
        this.mSource.setRoutingPort(0);
        this.mSource.setLocalActivePort(0);
    }

    private void maySendActiveSource() {
        this.mSource.maySendActiveSource(this.mTargetAddress);
    }

    private void queryDevicePowerStatus() {
        sendCommand(HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), this.mTargetAddress));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L14:
        return false;
    L5:
        if (this.mTargetAddress != cmd.getSource()) goto L14;
        if (cmd.getOpcode() != 144) goto L13;
        int status = cmd.getParams()[0];
        if (status != 0) goto L12;
        HdmiLogger.debug("TV's power status is on. Action finished successfully", new Object[0]);
        maySendActiveSource();
        finishWithCallback(0);
    L12:
        return true;
    L13:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L5;
        return;
    L5:
        switch(state) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L6;
        };
    L6:
        return;
    L7:
        Slog.d(TAG, "Action was not removed, start the action.");
        startAction();
        return;
    L9:
        int r0 = this.mPowerStatusCounter;
        this.mPowerStatusCounter = r0 + 1;
        if (r0 < 10) goto L12;
        finishWithCallback(1);
        return;
    L12:
        if ((this.mPowerStatusCounter % 3) != 0) goto L14;
        HdmiLogger.debug("Retry sending <Text View On> in case the TV missed the message.", new Object[0]);
        sendCommand(HdmiCecMessageBuilder.buildTextViewOn(getSourceAddress(), this.mTargetAddress));
    L14:
        queryDevicePowerStatus();
        addTimer(this.mState, 2000);
    }

    private boolean shouldTurnOnConnectedAudioSystem() {
        HdmiControlService service = this.mSource.mService;
        if (service.isAudioSystemDevice() == false) goto L5;
        return false;
    L5:
        String powerControlMode = service.getHdmiCecConfig().getStringValue("power_control_mode");
        if (powerControlMode.equals("to_tv_and_audio_system") == false) goto L8;
    L9:
        return true;
    L8:
        if (powerControlMode.equals("broadcast") == true) goto L9;
        return false;
    }

    private static int getTargetCecVersion(HdmiCecLocalDevice localDevice, int targetLogicalAddress) {
        HdmiDeviceInfo targetDevice = localDevice.mService.getHdmiCecNetwork().getCecDeviceInfo(targetLogicalAddress);
        if (targetDevice != null) goto L5;
        return 5;
    L5:
        return targetDevice.getCecVersion();
    }

    private static int getTargetDevicePowerStatus(HdmiCecLocalDevice localDevice, int targetLogicalAddress, int defaultPowerStatus) {
        HdmiDeviceInfo targetDevice = localDevice.mService.getHdmiCecNetwork().getCecDeviceInfo(targetLogicalAddress);
        if (targetDevice != null) goto L5;
        return defaultPowerStatus;
    L5:
        return targetDevice.getDevicePowerStatus();
    }
}
