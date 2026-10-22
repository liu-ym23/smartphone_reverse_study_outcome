package com.android.server.hdmi;

/* JADX INFO: loaded from: classes2.dex */
abstract class HdmiLocalDevice {
    private static final String TAG = "HdmiLocalDevice";
    protected final int mDeviceType;
    protected final Object mLock;
    protected final HdmiControlService mService;

    protected HdmiLocalDevice(HdmiControlService service, int deviceType) {
        this.mService = service;
        this.mDeviceType = deviceType;
        this.mLock = service.getServiceLock();
    }
}
