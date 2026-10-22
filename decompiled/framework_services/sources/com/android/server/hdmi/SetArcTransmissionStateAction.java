package com.android.server.hdmi;

import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class SetArcTransmissionStateAction extends HdmiCecFeatureAction {
    private static final int STATE_WAITING_TIMEOUT = 1;
    private static final String TAG = "SetArcTransmissionStateAction";
    private final int mAvrAddress;
    private final boolean mEnabled;

    /* JADX INFO: renamed from: -$$Nest$mdisableArc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4431$$Nest$mdisableArc(SetArcTransmissionStateAction r0) {
        r0.disableArc();
    }

    SetArcTransmissionStateAction(HdmiCecLocalDevice source, int avrAddress, boolean enabled) {
        super(source);
        if (HdmiUtils.verifyAddressType(getSourceAddress(), 0) == true) goto L5;
    L6:
        Slog.w(TAG, "Device type mismatch, stop the action.");
        finish();
    L7:
        this.mAvrAddress = avrAddress;
        this.mEnabled = enabled;
        return;
    L5:
        if (HdmiUtils.verifyAddressType(avrAddress, 5) == true) goto L7;
        goto L6
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        if (this.mEnabled == false) goto L5;
        Slog.i(TAG, "Enabling ARC");
        tv().enableArc();
        this.mState = 1;
        addTimer(this.mState, 2000);
        sendReportArcInitiated();
    L6:
        return true;
    L5:
        disableArc();
        finish();
        goto L6
    }

    private void sendReportArcInitiated() {
        HdmiCecMessage command = HdmiCecMessageBuilder.buildReportArcInitiated(getSourceAddress(), this.mAvrAddress);
        sendCommand(command, new AnonymousClass1(this));
    }

    private void disableArc() {
        Slog.i(TAG, "Disabling ARC");
        tv().disableArc();
        sendCommand(HdmiCecMessageBuilder.buildReportArcTerminated(getSourceAddress(), this.mAvrAddress));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
        return false;
    L5:
        int opcode = cmd.getOpcode();
        if (opcode != 0) goto L11;
        int originalOpcode = cmd.getParams()[0] & 255;
        if (originalOpcode != 193) goto L11;
        HdmiLogger.debug("Feature aborted for <Report Arc Initiated>", new Object[0]);
        disableArc();
        finish();
        return true;
    L11:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L5;
        return;
    L5:
        if (this.mState != 1) goto L10;
        finish();
        return;
    }
}
