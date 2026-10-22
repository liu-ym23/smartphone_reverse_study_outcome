package com.android.server.hdmi;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class HdmiCecPowerStatusController {
    private final HdmiControlService mHdmiControlService;
    private int mPowerStatus;

    HdmiCecPowerStatusController(HdmiControlService hdmiControlService) {
        this.mPowerStatus = 1;
        this.mHdmiControlService = hdmiControlService;
    }

    int getPowerStatus() {
        return this.mPowerStatus;
    }

    boolean isPowerStatusOn() {
        if (this.mPowerStatus != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isPowerStatusStandby() {
        if (this.mPowerStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isPowerStatusTransientToOn() {
        if (this.mPowerStatus != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isPowerStatusTransientToStandby() {
        if (this.mPowerStatus != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setPowerStatus(int powerStatus) {
        setPowerStatus(powerStatus, true);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setPowerStatus(int powerStatus, boolean sendPowerStatusUpdate) {
        if (powerStatus != this.mPowerStatus) goto L5;
        return;
    L5:
        this.mPowerStatus = powerStatus;
        if (sendPowerStatusUpdate == true) goto L8;
        return;
    L8:
        if (this.mHdmiControlService.getCecVersion() < 6) goto L12;
        sendReportPowerStatus(this.mPowerStatus);
        return;
    }

    private void sendReportPowerStatus(int powerStatus) {
        Iterator<HdmiCecLocalDevice> r0 = this.mHdmiControlService.getAllCecLocalDevices().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        HdmiCecLocalDevice localDevice = r0.next();
        this.mHdmiControlService.sendCecCommand(HdmiCecMessageBuilder.buildReportPowerStatus(localDevice.getDeviceInfo().getLogicalAddress(), 15, powerStatus));
        goto L4
    }
}
