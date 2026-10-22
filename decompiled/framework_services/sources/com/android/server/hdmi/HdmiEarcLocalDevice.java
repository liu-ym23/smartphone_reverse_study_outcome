package com.android.server.hdmi;

import android.util.IndentingPrintWriter;

/* JADX INFO: loaded from: classes2.dex */
abstract class HdmiEarcLocalDevice extends HdmiLocalDevice {
    private static final String TAG = "HdmiEarcLocalDevice";
    protected int mEarcStatus;

    protected abstract void handleEarcCapabilitiesReported(byte[] r1);

    protected abstract void handleEarcStateChange(int r1);

    protected HdmiEarcLocalDevice(HdmiControlService service, int deviceType) {
        super(service, deviceType);
    }

    static HdmiEarcLocalDevice create(HdmiControlService service, int deviceType) {
        switch(deviceType) {
            case 0: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return new HdmiEarcLocalDeviceTx(service);
    }

    protected void disableDevice() {
    }

    protected void dump(IndentingPrintWriter pw) {
    }
}
