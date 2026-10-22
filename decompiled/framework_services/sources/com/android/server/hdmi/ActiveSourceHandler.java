package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.os.RemoteException;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class ActiveSourceHandler {
    private static final String TAG = "ActiveSourceHandler";
    private final IHdmiControlCallback mCallback;
    private final HdmiControlService mService;
    private final HdmiCecLocalDeviceTv mSource;

    static ActiveSourceHandler create(HdmiCecLocalDeviceTv source, IHdmiControlCallback callback) {
        if (source != null) goto L6;
        Slog.e(TAG, "Wrong arguments");
        return null;
    L6:
        return new ActiveSourceHandler(source, callback);
    }

    private ActiveSourceHandler(HdmiCecLocalDeviceTv source, IHdmiControlCallback callback) {
        this.mSource = source;
        this.mService = this.mSource.getService();
        this.mCallback = callback;
    }

    void process(HdmiCecLocalDevice.ActiveSource newActive, int deviceType) {
        HdmiCecLocalDeviceTv tv = this.mSource;
        HdmiDeviceInfo device = this.mService.getDeviceInfo(newActive.logicalAddress);
        if (device != null) goto L6;
        tv.startNewDeviceAction(newActive, deviceType);
    L6:
        if (tv.isProhibitMode() == true) goto L15;
        HdmiCecLocalDevice.ActiveSource old = HdmiCecLocalDevice.ActiveSource.of(tv.getActiveSource());
        tv.updateActiveSource(newActive, TAG);
        if (this.mCallback != null) goto L10;
        boolean notifyInputChange = true;
    L12:
        if (old.equals(newActive) == true) goto L14;
        tv.setPrevPortId(tv.getActivePortId());
    L14:
        tv.updateActiveInput(newActive.physicalAddress, notifyInputChange);
        invokeCallback(0);
        return;
    L10:
        notifyInputChange = false;
        goto L12
    L15:
        HdmiCecLocalDevice.ActiveSource current = tv.getActiveSource();
        if (current.logicalAddress != getSourceAddress()) goto L18;
        HdmiCecMessage activeSourceCommand = HdmiCecMessageBuilder.buildActiveSource(current.logicalAddress, current.physicalAddress);
        this.mService.sendCecCommand(activeSourceCommand);
        tv.updateActiveSource(current, TAG);
        invokeCallback(0);
        return;
    L18:
        tv.startRoutingControl(newActive.physicalAddress, current.physicalAddress, this.mCallback);
    }

    private final int getSourceAddress() {
        return this.mSource.getDeviceInfo().getLogicalAddress();
    }

    private void invokeCallback(int result) {
        if (this.mCallback != null) goto L10;
        return;
    L10:
        this.mCallback.onComplete(result);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Callback failed:" + e);
    }
}
