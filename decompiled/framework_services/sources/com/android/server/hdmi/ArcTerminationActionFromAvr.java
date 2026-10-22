package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;

/* JADX INFO: loaded from: classes2.dex */
public class ArcTerminationActionFromAvr extends HdmiCecFeatureAction {
    private static final int STATE_ARC_TERMINATED = 2;
    private static final int STATE_WAITING_FOR_INITIATE_ARC_RESPONSE = 1;
    public static final int TIMEOUT_MS = 1000;

    public static /* synthetic */ void $r8$lambda$EJrSAd0M01hhjhFQmw6tUqDMPVE(ArcTerminationActionFromAvr r0, int r1) {
        r0.lambda$sendTerminateArc$0(r1);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    ArcTerminationActionFromAvr(HdmiCecLocalDevice source) {
        super(source);
    }

    ArcTerminationActionFromAvr(HdmiCecLocalDevice source, IHdmiControlCallback callback) {
        super(source, callback);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        addTimer(this.mState, 1000);
        sendTerminateArc();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L6;
        return false;
    L6:
        switch(cmd.getOpcode()) {
            case 0: goto L10;
            case 194: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    L8:
        this.mState = 2;
        audioSystem().processArcTermination();
        finishWithCallback(0);
        return true;
    L10:
        int originalOpcode = cmd.getParams()[0] & 255;
        if (originalOpcode != 197) goto L14;
        this.mState = 2;
        audioSystem().processArcTermination();
        finishWithCallback(3);
        return true;
    L14:
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
        handleTerminateArcTimeout();
        return;
    }

    protected void sendTerminateArc() {
        sendCommand(HdmiCecMessageBuilder.buildTerminateArc(getSourceAddress(), 0), new ArcTerminationActionFromAvr$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$sendTerminateArc$0(int result) {
        if (result != 0) goto L4;
        return;
    L4:
        if (result != 1) goto L6;
        audioSystem().setArcStatus(false);
    L6:
        HdmiLogger.debug("Terminate ARC was not successfully sent.", new Object[0]);
        finishWithCallback(3);
    }

    private void handleTerminateArcTimeout() {
        audioSystem().setArcStatus(false);
        HdmiLogger.debug("handleTerminateArcTimeout", new Object[0]);
        finishWithCallback(1);
    }
}
