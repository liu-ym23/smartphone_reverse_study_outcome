package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.SparseIntArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PowerStatusMonitorAction extends HdmiCecFeatureAction {
    private static final int INVALID_POWER_STATUS = -2;
    private static final int MONITORING_INTERVAL_MS = 60000;
    private static final int REPORT_POWER_STATUS_TIMEOUT_MS = 5000;
    private static final int STATE_WAIT_FOR_NEXT_MONITORING = 2;
    private static final int STATE_WAIT_FOR_REPORT_POWER_STATUS = 1;
    private static final String TAG = "PowerStatusMonitorAction";
    private final SparseIntArray mPowerStatus;

    /* JADX INFO: renamed from: -$$Nest$mupdatePowerStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4424$$Nest$mupdatePowerStatus(PowerStatusMonitorAction r0, int r1, int r2, boolean r3) {
        r0.updatePowerStatus(r1, r2, r3);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    PowerStatusMonitorAction(HdmiCecLocalDevice source) {
        super(source);
        this.mPowerStatus = new SparseIntArray();
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        queryPowerStatus();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
        return false;
    L5:
        if (cmd.getOpcode() == 144) goto L7;
        return false;
    L7:
        return handleReportPowerStatus(cmd);
    }

    private boolean handleReportPowerStatus(HdmiCecMessage cmd) {
        int sourceAddress = cmd.getSource();
        int oldStatus = this.mPowerStatus.get(sourceAddress, -2);
        if (oldStatus != (-2)) goto L5;
        return false;
    L5:
        int newStatus = cmd.getParams()[0] & CecDeviceType.INACTIVE;
        updatePowerStatus(sourceAddress, newStatus, true);
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        switch(this.mState) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L9;
        };
    L5:
        queryPowerStatus();
        return;
    L6:
        handleTimeout();
        return;
    }

    private void handleTimeout() {
        int i = 0;
    L4:
        if (i >= this.mPowerStatus.size()) goto L6;
        int logicalAddress = this.mPowerStatus.keyAt(i);
        updatePowerStatus(logicalAddress, -1, false);
        i = i + 1;
        goto L4
    L6:
        this.mPowerStatus.clear();
        this.mState = 2;
    }

    private void resetPowerStatus(List<HdmiDeviceInfo> deviceInfos) {
        this.mPowerStatus.clear();
        Iterator<HdmiDeviceInfo> r0 = deviceInfos.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        HdmiDeviceInfo info = r0.next();
        if (localDevice().mService.getCecVersion() < 6) goto L9;
        if (info.getCecVersion() >= 6) goto L4;
    L9:
        this.mPowerStatus.append(info.getLogicalAddress(), info.getDevicePowerStatus());
        goto L4
    }

    private void queryPowerStatus() {
        List<HdmiDeviceInfo> deviceInfos = localDevice().mService.getHdmiCecNetwork().getDeviceInfoList(false);
        resetPowerStatus(deviceInfos);
        Iterator<HdmiDeviceInfo> r1 = deviceInfos.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        HdmiDeviceInfo info = r1.next();
        if (localDevice().mService.getCecVersion() < 6) goto L9;
        if (info.getCecVersion() >= 6) goto L4;
    L9:
        final int logicalAddress = info.getLogicalAddress();
        sendCommand(HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), logicalAddress), new AnonymousClass1(this, logicalAddress));
        goto L4
    L11:
        this.mState = 1;
        addTimer(2, 60000);
        addTimer(1, 5000);
    }

    private void updatePowerStatus(int logicalAddress, int newStatus, boolean remove) {
        localDevice().mService.getHdmiCecNetwork().updateDevicePowerStatus(logicalAddress, newStatus);
        if (remove == false) goto L6;
        this.mPowerStatus.delete(logicalAddress);
        return;
    }
}
