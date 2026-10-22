package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class DeviceSelectActionFromPlayback extends HdmiCecFeatureAction {
    private static final int LOOP_COUNTER_MAX = 2;
    static final int STATE_WAIT_FOR_ACTIVE_SOURCE_MESSAGE_AFTER_ROUTING_CHANGE = 4;
    private static final int STATE_WAIT_FOR_ACTIVE_SOURCE_MESSAGE_AFTER_SET_STREAM_PATH = 5;
    static final int STATE_WAIT_FOR_DEVICE_POWER_ON = 3;
    private static final int STATE_WAIT_FOR_DEVICE_TO_TRANSIT_TO_STANDBY = 2;
    static final int STATE_WAIT_FOR_REPORT_POWER_STATUS = 1;
    private static final String TAG = "DeviceSelectActionFromPlayback";
    private static final int TIMEOUT_POWER_ON_MS = 5000;
    private static final int TIMEOUT_TRANSIT_TO_STANDBY_MS = 5000;
    private final HdmiCecMessage mGivePowerStatus;
    private final boolean mIsCec20;
    private int mPowerStatusCounter;
    private final HdmiDeviceInfo mTarget;

    DeviceSelectActionFromPlayback(HdmiCecLocalDevicePlayback source, HdmiDeviceInfo target, IHdmiControlCallback callback) {
        if (source.getDeviceInfo().getCecVersion() >= 6) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this(source, target, callback, r0);
        return;
    L5:
        if (target.getCecVersion() < 6) goto L7;
        r0 = true;
        goto L8
    }

    DeviceSelectActionFromPlayback(HdmiCecLocalDevicePlayback source, HdmiDeviceInfo target, IHdmiControlCallback callback, boolean isCec20) {
        super(source, callback);
        this.mPowerStatusCounter = 0;
        this.mTarget = target;
        this.mGivePowerStatus = HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), getTargetAddress());
        this.mIsCec20 = isCec20;
    }

    int getTargetAddress() {
        return this.mTarget.getLogicalAddress();
    }

    private int getTargetPath() {
        return this.mTarget.getPhysicalAddress();
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean start() {
        sendRoutingChange();
        if (this.mIsCec20 == true) goto L5;
        queryDevicePowerStatus();
    L14:
        this.mState = 1;
        addTimer(this.mState, 2000);
        return true;
    L5:
        int targetPowerStatus = -1;
        HdmiDeviceInfo targetDevice = localDevice().mService.getHdmiCecNetwork().getCecDeviceInfo(getTargetAddress());
        if (targetDevice == null) goto L9;
        targetPowerStatus = targetDevice.getDevicePowerStatus();
    L9:
        if (targetPowerStatus != (-1)) goto L11;
        queryDevicePowerStatus();
        goto L14
    L11:
        if (targetPowerStatus != 0) goto L14;
        this.mState = 4;
        addTimer(this.mState, 2000);
        return true;
    }

    private void queryDevicePowerStatus() {
        sendCommand(this.mGivePowerStatus, new AnonymousClass1(this));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean processCommand(HdmiCecMessage cmd) {
        if (cmd.getSource() == getTargetAddress()) goto L5;
        return false;
    L5:
        int opcode = cmd.getOpcode();
        byte[] params = cmd.getParams();
        if (opcode != 130) goto L10;
        finishWithCallback(0);
        return true;
    L10:
        if (this.mState == 1) goto L12;
    L15:
        return false;
    L12:
        if (opcode != 144) goto L15;
        return handleReportPowerStatus(params[0]);
    }

    private boolean handleReportPowerStatus(int powerStatus) {
        switch(powerStatus) {
            case 0: goto L21;
            case 1: goto L17;
            case 2: goto L12;
            case 3: goto L7;
            default: goto L4;
        };
    L4:
        return false;
    L21:
        selectDevice();
        return true;
    L7:
        if (this.mPowerStatusCounter >= 4) goto L9;
        this.mState = 2;
        addTimer(this.mState, 5000);
    L10:
        return true;
    L9:
        selectDevice();
        goto L10
    L12:
        if (this.mPowerStatusCounter >= 2) goto L14;
        this.mState = 3;
        addTimer(this.mState, 5000);
    L15:
        return true;
    L14:
        selectDevice();
        goto L15
    L17:
        if (this.mPowerStatusCounter != 0) goto L19;
        sendRoutingChange();
        this.mState = 3;
        addTimer(this.mState, 5000);
    L20:
        return true;
    L19:
        selectDevice();
        goto L20
    }

    private void selectDevice() {
        sendRoutingChange();
        this.mState = 4;
        addTimer(this.mState, 2000);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int timeoutState) {
        if (this.mState == timeoutState) goto L7;
        Slog.w(TAG, "Timer in a wrong state. Ignored.");
        return;
    L7:
        switch(this.mState) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            default: goto L17;
        };
    L9:
        finishWithCallback(1);
        return;
    L10:
        sendSetStreamPath();
        this.mState = 5;
        addTimer(this.mState, 2000);
        return;
    L11:
        this.mPowerStatusCounter++;
        queryDevicePowerStatus();
        this.mState = 1;
        addTimer(this.mState, 2000);
        return;
    L12:
        selectDevice();
        addTimer(this.mState, 2000);
        return;
    }

    private void sendRoutingChange() {
        sendCommand(HdmiCecMessageBuilder.buildRoutingChange(getSourceAddress(), playback().getActiveSource().physicalAddress, getTargetPath()));
    }

    private void sendSetStreamPath() {
        sendCommand(HdmiCecMessageBuilder.buildSetStreamPath(getSourceAddress(), getTargetPath()));
    }
}
