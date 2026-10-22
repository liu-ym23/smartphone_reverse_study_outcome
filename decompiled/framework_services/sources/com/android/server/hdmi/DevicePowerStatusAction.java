package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class DevicePowerStatusAction extends HdmiCecFeatureAction {
    private static final int STATE_WAITING_FOR_REPORT_POWER_STATUS = 1;
    private static final String TAG = "DevicePowerStatusAction";
    private int mRetriesOnTimeout;
    private final int mTargetAddress;

    public static /* synthetic */ void $r8$lambda$a2Pqnp6CPi78PGqw2Pbvwb4UPr0(DevicePowerStatusAction r0, int r1) {
        r0.lambda$queryDevicePowerStatus$0(r1);
    }

    static DevicePowerStatusAction create(HdmiCecLocalDevice source, int targetAddress, IHdmiControlCallback callback) {
        if (source == null) goto L7;
        if (callback == null) goto L7;
        return new DevicePowerStatusAction(source, targetAddress, callback);
    L7:
        Slog.e(TAG, "Wrong arguments");
        return null;
    }

    private DevicePowerStatusAction(HdmiCecLocalDevice localDevice, int targetAddress, IHdmiControlCallback callback) {
        super(localDevice, callback);
        this.mRetriesOnTimeout = 1;
        this.mTargetAddress = targetAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        HdmiControlService service = localDevice().mService;
        if (service.getCecVersion() < 6) goto L12;
        HdmiDeviceInfo deviceInfo = service.getHdmiCecNetwork().getCecDeviceInfo(this.mTargetAddress);
        if (deviceInfo == null) goto L12;
        if (deviceInfo.getCecVersion() < 6) goto L12;
        int powerStatus = deviceInfo.getDevicePowerStatus();
        if (powerStatus == (-1)) goto L12;
        finishWithCallback(powerStatus);
        return true;
    L12:
        queryDevicePowerStatus();
        this.mState = 1;
        addTimer(this.mState, 2000);
        return true;
    }

    private void queryDevicePowerStatus() {
        sendCommand(HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), this.mTargetAddress), new DevicePowerStatusAction$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$queryDevicePowerStatus$0(int error) {
        if (error != 1) goto L6;
        finishWithCallback(-1);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L12:
        return false;
    L5:
        if (this.mTargetAddress != cmd.getSource()) goto L12;
        if (cmd.getOpcode() != 144) goto L11;
        int status = cmd.getParams()[0];
        finishWithCallback(status);
        return true;
    L11:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        if (state == 1) goto L8;
        return;
    L8:
        if (this.mRetriesOnTimeout <= 0) goto L11;
        this.mRetriesOnTimeout--;
        start();
        return;
    L11:
        finishWithCallback(-1);
    }
}
