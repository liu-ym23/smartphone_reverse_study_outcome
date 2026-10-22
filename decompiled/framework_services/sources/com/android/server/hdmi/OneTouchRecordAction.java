package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class OneTouchRecordAction extends HdmiCecFeatureAction {
    private static final int RECORD_STATUS_TIMEOUT_MS = 120000;
    private static final int STATE_RECORDING_IN_PROGRESS = 2;
    private static final int STATE_WAITING_FOR_RECORD_STATUS = 1;
    private static final String TAG = "OneTouchRecordAction";
    private final byte[] mRecordSource;
    private final int mRecorderAddress;

    /* JADX INFO: renamed from: -$$Nest$fgetmRecorderAddress, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4423$$Nest$fgetmRecorderAddress(OneTouchRecordAction r0) {
        return r0.mRecorderAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    OneTouchRecordAction(HdmiCecLocalDevice source, int recorderAddress, byte[] recordSource) {
        super(source);
        this.mRecorderAddress = recorderAddress;
        this.mRecordSource = recordSource;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        sendRecordOn();
        return true;
    }

    private void sendRecordOn() {
        sendCommand(HdmiCecMessageBuilder.buildRecordOn(getSourceAddress(), this.mRecorderAddress, this.mRecordSource), new AnonymousClass1(this));
        this.mState = 1;
        addTimer(this.mState, RECORD_STATUS_TIMEOUT_MS);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L12:
        return false;
    L5:
        if (this.mRecorderAddress != cmd.getSource()) goto L12;
        switch(cmd.getOpcode()) {
            case 10: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        return handleRecordStatus(cmd);
    }

    private boolean handleRecordStatus(HdmiCecMessage cmd) {
        if (cmd.getSource() == this.mRecorderAddress) goto L5;
        return false;
    L5:
        int recordStatus = cmd.getParams()[0];
        tv().announceOneTouchRecordResult(this.mRecorderAddress, recordStatus);
        Slog.i(TAG, "Got record status:" + recordStatus + " from " + cmd.getSource());
        switch(recordStatus) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            default: goto L7;
        };
    L7:
        finish();
        return true;
    L8:
        this.mState = 2;
        this.mActionTimer.clearTimerMessage();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        Slog.w(TAG, "Timeout in invalid state:[Expected:" + this.mState + ", Actual:" + state + "]");
        return;
    L6:
        tv().announceOneTouchRecordResult(this.mRecorderAddress, 49);
        finish();
    }

    int getRecorderAddress() {
        return this.mRecorderAddress;
    }
}
