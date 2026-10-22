package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;

/* JADX INFO: loaded from: classes2.dex */
public class SetAudioVolumeLevelDiscoveryAction extends HdmiCecFeatureAction {
    private static final int STATE_WAITING_FOR_FEATURE_ABORT = 1;
    private static final String TAG = "SetAudioVolumeLevelDiscoveryAction";
    private final int mTargetAddress;

    public static /* synthetic */ void $r8$lambda$SDg24sXkgJnPiY3JGLXvy4BDYFM(SetAudioVolumeLevelDiscoveryAction r0, int r1) {
        r0.lambda$start$0(r1);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    public SetAudioVolumeLevelDiscoveryAction(HdmiCecLocalDevice source, int targetAddress, IHdmiControlCallback callback) {
        super(source, callback);
        this.mTargetAddress = targetAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        sendCommand(SetAudioVolumeLevelMessage.build(getSourceAddress(), this.mTargetAddress, 127), new SetAudioVolumeLevelDiscoveryAction$$ExternalSyntheticLambda0(this));
        return true;
    }

    private /* synthetic */ void lambda$start$0(int result) {
        if (result != 0) goto L4;
        this.mState = 1;
        addTimer(this.mState, 2000);
        return;
    L4:
        finishWithCallback(7);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L6;
        return false;
    L6:
        switch(cmd.getOpcode()) {
            case 0: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L9:
        return handleFeatureAbort(cmd);
    }

    private boolean handleFeatureAbort(HdmiCecMessage cmd) {
        if (cmd.getParams().length >= 2) goto L5;
        return false;
    L5:
        int originalOpcode = cmd.getParams()[0] & 255;
        if (originalOpcode == 115) goto L8;
    L11:
        return false;
    L8:
        if (cmd.getSource() != this.mTargetAddress) goto L11;
        finishWithCallback(0);
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (updateSetAudioVolumeLevelSupport(1) == false) goto L5;
        finishWithCallback(0);
        return;
    L5:
        finishWithCallback(5);
    }

    private boolean updateSetAudioVolumeLevelSupport(int setAudioVolumeLevelSupport) {
        HdmiCecNetwork network = localDevice().mService.getHdmiCecNetwork();
        HdmiDeviceInfo currentDeviceInfo = network.getCecDeviceInfo(this.mTargetAddress);
        if (currentDeviceInfo != null) goto L6;
        return false;
    L6:
        network.updateCecDevice(currentDeviceInfo.toBuilder().setDeviceFeatures(currentDeviceInfo.getDeviceFeatures().toBuilder().setSetAudioVolumeLevelSupport(setAudioVolumeLevelSupport).build()).build());
        return true;
    }

    public int getTargetAddress() {
        return this.mTargetAddress;
    }
}
