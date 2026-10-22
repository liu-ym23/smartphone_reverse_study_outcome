package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class RequestActiveSourceAction extends HdmiCecFeatureAction {
    private static final int MAX_SEND_RETRY_COUNT = 1;
    private static final int STATE_WAIT_FOR_ACTIVE_SOURCE = 2;
    private static final int STATE_WAIT_FOR_LAUNCHERX_API_CALL = 1;
    private static final String TAG = "RequestActiveSourceAction";
    protected static final int TIMEOUT_WAIT_FOR_TV_ASSERT_ACTIVE_SOURCE_MS = 15000;
    private int mSendRetryCount;

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    RequestActiveSourceAction(HdmiCecLocalDevice source, IHdmiControlCallback callback) {
        super(source, callback);
        this.mSendRetryCount = 0;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        Slog.v(TAG, "RequestActiveSourceAction started.");
        if (localDevice().mService.isPlaybackDevice() == false) goto L6;
        this.mState = 2;
        sendCommand(HdmiCecMessageBuilder.buildRequestActiveSource(getSourceAddress()));
        addTimer(this.mState, 2000);
        return true;
    L6:
        this.mState = 1;
        addTimer(this.mState, 15000);
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (cmd.getOpcode() != 130) goto L5;
        finishWithCallback(0);
    L5:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        switch(this.mState) {
            case 1: goto L13;
            case 2: goto L8;
            default: goto L7;
        };
    L7:
        return;
    L8:
        int r0 = this.mSendRetryCount;
        this.mSendRetryCount = r0 + 1;
        if (r0 >= 1) goto L11;
        sendCommand(HdmiCecMessageBuilder.buildRequestActiveSource(getSourceAddress()));
        addTimer(this.mState, 2000);
        return;
    L11:
        finishWithCallback(1);
        return;
    L13:
        this.mState = 2;
        sendCommand(HdmiCecMessageBuilder.buildRequestActiveSource(getSourceAddress()));
        addTimer(this.mState, 2000);
    }
}
