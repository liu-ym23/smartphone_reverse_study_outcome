package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiMhlLocalDeviceStub {
    private static final HdmiDeviceInfo INFO = null;
    private final int mPortId;
    private final HdmiControlService mService;

    static {
        INFO = HdmiDeviceInfo.mhlDevice(65535, -1, -1, -1);
    }

    protected HdmiMhlLocalDeviceStub(HdmiControlService service, int portId) {
        this.mService = service;
        this.mPortId = portId;
    }

    void onDeviceRemoved() {
    }

    HdmiDeviceInfo getInfo() {
        return INFO;
    }

    void setBusMode(int cbusmode) {
    }

    void onBusOvercurrentDetected(boolean on) {
    }

    void setDeviceStatusChange(int adopterId, int deviceId) {
    }

    int getPortId() {
        return this.mPortId;
    }

    void turnOn(IHdmiControlCallback callback) {
    }

    void sendKeyEvent(int keycode, boolean isPressed) {
    }

    void sendStandby() {
    }
}
