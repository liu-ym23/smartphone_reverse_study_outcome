package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class DeviceSelectActionFromTv extends HdmiCecFeatureAction {
    private static final int LOOP_COUNTER_MAX = 20;
    static final int STATE_WAIT_FOR_DEVICE_POWER_ON = 3;
    private static final int STATE_WAIT_FOR_DEVICE_TO_TRANSIT_TO_STANDBY = 2;
    static final int STATE_WAIT_FOR_POWER_STATE_CHANGE = 4;
    static final int STATE_WAIT_FOR_REPORT_POWER_STATUS = 1;
    private static final String TAG = "DeviceSelect";
    private static final int TIMEOUT_POWER_ON_MS = 5000;
    private static final int TIMEOUT_TRANSIT_TO_STANDBY_MS = 5000;
    private final HdmiCecMessage mGivePowerStatus;
    private final boolean mIsCec20;
    private int mPowerStatusCounter;
    private final HdmiDeviceInfo mTarget;

    DeviceSelectActionFromTv(HdmiCecLocalDeviceTv source, HdmiDeviceInfo target, IHdmiControlCallback callback) {
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

    DeviceSelectActionFromTv(HdmiCecLocalDeviceTv source, HdmiDeviceInfo target, IHdmiControlCallback callback, boolean isCec20) {
        super(source, callback);
        this.mPowerStatusCounter = 0;
        this.mTarget = target;
        this.mGivePowerStatus = HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), getTargetAddress());
        this.mIsCec20 = isCec20;
    }

    int getTargetAddress() {
        return this.mTarget.getLogicalAddress();
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean start() {
        sendSetStreamPath();
        this.mState = 4;
        addTimer(this.mState, 2000);
        return true;
    }

    private void checkForPowerStateChange() {
        if (this.mIsCec20 == true) goto L5;
        queryDevicePowerStatus();
    L14:
        this.mState = 1;
        addTimer(this.mState, 2000);
        return;
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
        finishWithCallback(0);
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
        switch(this.mState) {
            case 1: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L9:
        if (opcode == 144) goto L11;
        return false;
    L11:
        return handleReportPowerStatus(params[0]);
    }

    private boolean handleReportPowerStatus(int powerStatus) {
        switch(powerStatus) {
            case 0: goto L21;
            case 1: goto L16;
            case 2: goto L11;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if (this.mPowerStatusCounter >= 4) goto L8;
        this.mState = 2;
        addTimer(this.mState, 5000);
    L9:
        return true;
    L8:
        selectDevice();
        goto L9
    L11:
        if (this.mPowerStatusCounter >= 20) goto L13;
        this.mState = 3;
        addTimer(this.mState, 5000);
    L14:
        return true;
    L13:
        selectDevice();
        goto L14
    L16:
        if (this.mPowerStatusCounter != 0) goto L18;
        turnOnDevice();
        this.mState = 3;
        addTimer(this.mState, 5000);
    L19:
        return true;
    L18:
        selectDevice();
        goto L19
    L21:
        if (tv().getActiveSource().physicalAddress != this.mTarget.getPhysicalAddress()) goto L23;
        finishWithCallback(0);
    L24:
        return true;
    L23:
        selectDevice();
        goto L24
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public void handleTimerEvent(int timeoutState) {
        if (this.mState == timeoutState) goto L7;
        Slog.w(TAG, "Timer in a wrong state. Ignored.");
        return;
    L7:
        switch(this.mState) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L9;
            default: goto L19;
        };
    L9:
        checkForPowerStateChange();
        return;
    L10:
        this.mPowerStatusCounter++;
        queryDevicePowerStatus();
        this.mState = 1;
        addTimer(this.mState, 2000);
        return;
    L19:
        return;
    L12:
        if (tv().isPowerStandbyOrTransient() == false) goto L15;
        finishWithCallback(6);
        return;
    L15:
        selectDevice();
    }

    private void turnOnDevice() {
        if (this.mIsCec20 == true) goto L6;
        sendUserControlPressedAndReleased(this.mTarget.getLogicalAddress(), 64);
        sendUserControlPressedAndReleased(this.mTarget.getLogicalAddress(), 109);
        return;
    }

    private void selectDevice() {
        if (this.mIsCec20 == true) goto L5;
        sendSetStreamPath();
    L5:
        finishWithCallback(0);
    }

    private void sendSetStreamPath() {
        tv().getActiveSource().invalidate();
        tv().setActivePath(this.mTarget.getPhysicalAddress());
        sendCommand(HdmiCecMessageBuilder.buildSetStreamPath(getSourceAddress(), this.mTarget.getPhysicalAddress()));
    }
}
