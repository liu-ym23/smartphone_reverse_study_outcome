package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class PowerStatusMonitorActionFromPlayback extends HdmiCecFeatureAction {
    protected static final int MONITORING_INTERVAL_MS = 60000;
    private static final int STATE_WAIT_FOR_NEXT_MONITORING = 1;
    private static final int STATE_WAIT_FOR_REPORT_POWER_STATUS = 2;
    private static final String TAG = "PowerStatusMonitorActionFromPlayback";

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    PowerStatusMonitorActionFromPlayback(HdmiCecLocalDevice source) {
        super(source);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        addTimer(this.mState, 60000);
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 2) goto L5;
        return false;
    L5:
        if (cmd.getOpcode() == 144) goto L7;
        return false;
    L7:
        if (cmd.getSource() == 0) goto L9;
        return false;
    L9:
        return handleReportPowerStatusFromTv(cmd);
    }

    private boolean handleReportPowerStatusFromTv(HdmiCecMessage cmd) {
        int powerStatus = cmd.getParams()[0] & 255;
        if (powerStatus != 1) goto L6;
        Slog.d(TAG, "TV reported it turned off, going to sleep.");
        source().getService().standby();
        finish();
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 1: goto L9;
            case 2: goto L8;
            default: goto L12;
        };
    L8:
        this.mState = 1;
        addTimer(this.mState, 60000);
        return;
    L9:
        queryPowerStatus();
        return;
    }

    private void queryPowerStatus() {
        sendCommand(HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), 0));
        this.mState = 2;
        addTimer(this.mState, 2000);
    }
}
