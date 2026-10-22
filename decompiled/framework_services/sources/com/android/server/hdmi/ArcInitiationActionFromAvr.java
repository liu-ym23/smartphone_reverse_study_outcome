package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.tv.hdmi.cec.CecDeviceType;

/* JADX INFO: loaded from: classes2.dex */
public class ArcInitiationActionFromAvr extends HdmiCecFeatureAction {
    private static final int STATE_ARC_INITIATED = 2;
    private static final int STATE_WAITING_FOR_INITIATE_ARC_RESPONSE = 1;
    private static final int TIMEOUT_MS = 1000;

    public static /* synthetic */ void $r8$lambda$EDcpBDcTIAbjAZtVqddEKEuNsdI(ArcInitiationActionFromAvr r0, int r1) {
        r0.lambda$sendInitiateArc$0(r1);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    ArcInitiationActionFromAvr(HdmiCecLocalDevice source) {
        super(source);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        audioSystem().setArcStatus(true);
        this.mState = 1;
        addTimer(this.mState, 1000);
        sendInitiateArc();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L6;
        return false;
    L6:
        switch(cmd.getOpcode()) {
            case 0: goto L13;
            case 193: goto L10;
            case 194: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    L8:
        audioSystem().setArcStatus(false);
        finish();
        return true;
    L10:
        this.mState = 2;
        finish();
        return true;
    L13:
        if ((cmd.getParams()[0] & CecDeviceType.INACTIVE) != 192) goto L16;
        audioSystem().setArcStatus(false);
        finish();
        return true;
    L16:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 1: goto L8;
            default: goto L10;
        };
    L8:
        handleInitiateArcTimeout();
        return;
    }

    protected void sendInitiateArc() {
        sendCommand(HdmiCecMessageBuilder.buildInitiateArc(getSourceAddress(), 0), new ArcInitiationActionFromAvr$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$sendInitiateArc$0(int result) {
        if (result == 0) goto L5;
        audioSystem().setArcStatus(false);
        finish();
        return;
    }

    private void handleInitiateArcTimeout() {
        HdmiLogger.debug("handleInitiateArcTimeout", new Object[0]);
        finish();
    }
}
