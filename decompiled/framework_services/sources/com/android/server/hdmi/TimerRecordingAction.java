package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.Slog;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class TimerRecordingAction extends HdmiCecFeatureAction {
    private static final int STATE_WAITING_FOR_TIMER_STATUS = 1;
    private static final String TAG = "TimerRecordingAction";
    private static final int TIMER_STATUS_TIMEOUT_MS = 120000;
    private final byte[] mRecordSource;
    private final int mRecorderAddress;
    private final int mSourceType;

    /* JADX INFO: renamed from: -$$Nest$fgetmRecorderAddress, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4434$$Nest$fgetmRecorderAddress(TimerRecordingAction r0) {
        return r0.mRecorderAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    TimerRecordingAction(HdmiCecLocalDevice source, int recorderAddress, int sourceType, byte[] recordSource) {
        super(source);
        this.mRecorderAddress = recorderAddress;
        this.mSourceType = sourceType;
        this.mRecordSource = recordSource;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        sendTimerMessage();
        return true;
    }

    private void sendTimerMessage() {
        switch(this.mSourceType) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        tv().announceTimerRecordingResult(this.mRecorderAddress, 2);
        finish();
        return;
    L6:
        HdmiCecMessage message = HdmiCecMessageBuilder.buildSetExternalTimer(getSourceAddress(), this.mRecorderAddress, this.mRecordSource);
    L9:
        sendCommand(message, new AnonymousClass1(this));
        return;
    L7:
        message = HdmiCecMessageBuilder.buildSetAnalogueTimer(getSourceAddress(), this.mRecorderAddress, this.mRecordSource);
        goto L9
    L8:
        message = HdmiCecMessageBuilder.buildSetDigitalTimer(getSourceAddress(), this.mRecorderAddress, this.mRecordSource);
        goto L9
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L14:
        return false;
    L5:
        if (cmd.getSource() != this.mRecorderAddress) goto L14;
        switch(cmd.getOpcode()) {
            case 0: goto L13;
            case 53: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        return handleTimerStatus(cmd);
    L13:
        return handleFeatureAbort(cmd);
    }

    private boolean handleTimerStatus(HdmiCecMessage cmd) {
        byte[] timerStatusData = cmd.getParams();
        if (timerStatusData.length != 1) goto L5;
    L8:
        tv().announceTimerRecordingResult(this.mRecorderAddress, bytesToInt(timerStatusData));
        Slog.i(TAG, "Received [Timer Status Data]:" + Arrays.toString(timerStatusData));
    L9:
        finish();
        return true;
    L5:
        if (timerStatusData.length == 3) goto L8;
        Slog.w(TAG, "Invalid [Timer Status Data]:" + Arrays.toString(timerStatusData));
        goto L9
    }

    private boolean handleFeatureAbort(HdmiCecMessage cmd) {
        byte[] params = cmd.getParams();
        int messageType = params[0] & CecDeviceType.INACTIVE;
        switch(messageType) {
            case 52: goto L5;
            case 151: goto L5;
            case 162: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        int reason = params[1] & CecDeviceType.INACTIVE;
        Slog.i(TAG, "[Feature Abort] for " + messageType + " reason:" + reason);
        tv().announceTimerRecordingResult(this.mRecorderAddress, 1);
        finish();
        return true;
    }

    private static int bytesToInt(byte[] data) {
        if (data.length > 4) goto L11;
        int result = 0;
        int i = 0;
    L6:
        if (i >= data.length) goto L9;
        int shift = (3 - i) * 8;
        result = result | ((data[i] & CecDeviceType.INACTIVE) << shift);
        i = i + 1;
        goto L6
    L9:
        return result;
    L11:
        throw new IllegalArgumentException("Invalid data size:" + Arrays.toString(data));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        Slog.w(TAG, "Timeout in invalid state:[Expected:" + this.mState + ", Actual:" + state + "]");
        return;
    L6:
        tv().announceTimerRecordingResult(this.mRecorderAddress, 1);
        finish();
    }
}
