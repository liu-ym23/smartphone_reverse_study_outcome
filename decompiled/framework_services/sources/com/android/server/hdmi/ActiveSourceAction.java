package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;

/* JADX INFO: loaded from: classes2.dex */
public class ActiveSourceAction extends HdmiCecFeatureAction {
    private static final int STATE_FINISHED = 2;
    private static final int STATE_STARTED = 1;
    private final int mDestination;

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    ActiveSourceAction(HdmiCecLocalDevice source, int destination) {
        super(source);
        this.mDestination = destination;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        int logicalAddress = getSourceAddress();
        int physicalAddress = getSourcePath();
        sendCommand(HdmiCecMessageBuilder.buildActiveSource(logicalAddress, physicalAddress));
        if (source().getType() != 4) goto L5;
        sendCommand(HdmiCecMessageBuilder.buildReportMenuStatus(logicalAddress, this.mDestination, 0));
    L5:
        source().setActiveSource(logicalAddress, physicalAddress, "ActiveSourceAction");
        this.mState = 2;
        finish();
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
    }
}
