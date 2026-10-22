package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
abstract class RequestArcAction extends HdmiCecFeatureAction {
    protected static final int STATE_WATING_FOR_REQUEST_ARC_REQUEST_RESPONSE = 1;
    private static final String TAG = "RequestArcAction";
    protected final int mAvrAddress;

    RequestArcAction(HdmiCecLocalDevice source, int avrAddress, IHdmiControlCallback callback) {
        super(source, callback);
        if (HdmiUtils.verifyAddressType(getSourceAddress(), 0) == true) goto L5;
    L6:
        Slog.w(TAG, "Device type mismatch, stop the action.");
        finish();
    L7:
        this.mAvrAddress = avrAddress;
        return;
    L5:
        if (HdmiUtils.verifyAddressType(avrAddress, 5) == true) goto L7;
        goto L6
    }

    RequestArcAction(HdmiCecLocalDevice source, int avrAddress) {
        this(source, avrAddress, null);
    }

    protected final void disableArcTransmission() {
        SetArcTransmissionStateAction action = new SetArcTransmissionStateAction(localDevice(), this.mAvrAddress, false);
        addAndStartAction(action);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    final void handleTimerEvent(int state) {
        if (this.mState == state) goto L5;
        return;
    L5:
        if (state != 1) goto L10;
        HdmiLogger.debug("[T] RequestArcAction.", new Object[0]);
        disableArcTransmission();
        finishWithCallback(1);
        return;
    }
}
