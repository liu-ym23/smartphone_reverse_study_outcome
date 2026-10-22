package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;

/* JADX INFO: loaded from: classes2.dex */
final class RequestArcTerminationAction extends RequestArcAction {
    private static final String TAG = "RequestArcTerminationAction";

    RequestArcTerminationAction(HdmiCecLocalDevice source, int avrAddress) {
        super(source, avrAddress);
    }

    RequestArcTerminationAction(HdmiCecLocalDevice source, int avrAddress, IHdmiControlCallback callback) {
        super(source, avrAddress, callback);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        addTimer(this.mState, 2000);
        HdmiCecMessage command = HdmiCecMessageBuilder.buildRequestArcTermination(getSourceAddress(), this.mAvrAddress);
        sendCommand(command, new AnonymousClass1(this));
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L17:
        return false;
    L5:
        if (HdmiUtils.checkCommandSource(cmd, this.mAvrAddress, TAG) == false) goto L17;
        int opcode = cmd.getOpcode();
        switch(opcode) {
            case 0: goto L12;
            case 197: goto L10;
            default: goto L9;
        };
    L9:
        return false;
    L10:
        finishWithCallback(0);
        return false;
    L12:
        int originalOpcode = cmd.getParams()[0] & 255;
        if (originalOpcode != 196) goto L16;
        disableArcTransmission();
        finishWithCallback(3);
        return true;
    L16:
        return false;
    }
}
