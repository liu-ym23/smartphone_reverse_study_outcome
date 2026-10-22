package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class ResendCecCommandAction extends HdmiCecFeatureAction {
    private static final int RETRANSMISSION_COUNT = 1;
    static final int SEND_COMMAND_RETRY_MS = 300;
    private static final int STATE_WAIT_FOR_RESEND_COMMAND = 1;
    private static final String TAG = "ResendCecCommandAction";
    private final HdmiControlService.SendMessageCallback mCallback;
    private final HdmiCecMessage mCommand;
    private final HdmiControlService.SendMessageCallback mResultCallback;
    private int mRetransmissionCount;

    /* JADX INFO: renamed from: -$$Nest$fgetmResultCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiControlService.SendMessageCallback m4427$$Nest$fgetmResultCallback(ResendCecCommandAction r0) {
        return r0.mResultCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRetransmissionCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4428$$Nest$fgetmRetransmissionCount(ResendCecCommandAction r0) {
        return r0.mRetransmissionCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRetransmissionCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4429$$Nest$fputmRetransmissionCount(ResendCecCommandAction r0, int r1) {
        r0.mRetransmissionCount = r1;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public /* bridge */ /* synthetic */ void addCallback(IHdmiControlCallback r1) {
        super.addCallback(r1);
    }

    ResendCecCommandAction(HdmiCecLocalDevice source, HdmiCecMessage command, HdmiControlService.SendMessageCallback callback) {
        super(source);
        this.mRetransmissionCount = 0;
        this.mCallback = new AnonymousClass1(this);
        this.mCommand = command;
        this.mResultCallback = callback;
        this.mState = 1;
        addTimer(this.mState, 300);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        Slog.d(TAG, "ResendCecCommandAction started");
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L7;
        Slog.w(TAG, "Timeout in invalid state:[Expected:" + this.mState + ", Actual:" + state + "]");
        return;
    L7:
        if (this.mState != 1) goto L10;
        Slog.d(TAG, "sendCommandWithoutRetries failed, retry");
        sendCommandWithoutRetries(this.mCommand, this.mCallback);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage command) {
        return false;
    }
}
