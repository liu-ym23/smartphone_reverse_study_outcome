package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class RoutingControlAction extends HdmiCecFeatureAction {
    static final int STATE_WAIT_FOR_ROUTING_INFORMATION = 1;
    private static final String TAG = "RoutingControlAction";
    static final int TIMEOUT_ROUTING_INFORMATION_MS = 1000;
    private int mCurrentRoutingPath;
    private final boolean mNotifyInputChange;

    RoutingControlAction(HdmiCecLocalDevice localDevice, int path, IHdmiControlCallback callback) {
        super(localDevice, callback);
        this.mCurrentRoutingPath = path;
        if (callback != null) goto L5;
        boolean r0 = true;
    L6:
        this.mNotifyInputChange = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean start() {
        this.mState = 1;
        addTimer(this.mState, 1000);
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean processCommand(HdmiCecMessage cmd) {
        int opcode = cmd.getOpcode();
        byte[] params = cmd.getParams();
        if (this.mState == 1) goto L5;
        return false;
    L5:
        if (opcode != 129) goto L13;
        int routingPath = HdmiUtils.twoBytesToInt(params);
        if (HdmiUtils.isInActiveRoutingPath(this.mCurrentRoutingPath, routingPath) == true) goto L9;
        return true;
    L9:
        this.mCurrentRoutingPath = routingPath;
        removeActionExcept(RoutingControlAction.class, this);
        addTimer(this.mState, 1000);
        return true;
    L13:
        return false;
    }

    private void updateActiveInput() {
        HdmiCecLocalDeviceTv tv = tv();
        tv.setPrevPortId(tv.getActivePortId());
        tv.updateActiveInput(this.mCurrentRoutingPath, this.mNotifyInputChange);
    }

    private void sendSetStreamPath() {
        sendCommand(HdmiCecMessageBuilder.buildSetStreamPath(getSourceAddress(), this.mCurrentRoutingPath));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public void handleTimerEvent(int timeoutState) {
        if (this.mState == timeoutState) goto L5;
    L12:
        Slog.w("CEC", "Timer in a wrong state. Ignored.");
        return;
    L5:
        if (this.mState == 0) goto L12;
        switch(timeoutState) {
            case 1: goto L10;
            default: goto L8;
        };
    L8:
        Slog.e("CEC", "Invalid timeoutState (" + timeoutState + ").");
        return;
    L10:
        updateActiveInput();
        sendSetStreamPath();
        finishWithCallback(0);
    }
}
