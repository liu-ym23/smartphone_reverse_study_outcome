package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class DeviceOfflineDetectSettings {
    private long detectIntervalMills;
    private boolean enableDetect;

    public String toString() {
        return "DeviceOfflineDetectSettings{enableDetect=" + this.enableDetect + ", detectIntervalMills=" + this.detectIntervalMills + '}';
    }

    public DeviceOfflineDetectSettings() {
    }

    public long getDetectIntervalMills() {
        return this.detectIntervalMills;
    }

    public boolean isEnableDetect() {
        return this.enableDetect;
    }

    public void setDetectIntervalMills(long r100) {
        this.detectIntervalMills = r100;
    }

    public void setEnableDetect(boolean r100) {
        this.enableDetect = r100;
    }

    public DeviceOfflineDetectSettings(boolean r100, long r101) {
        this.enableDetect = r100;
        this.detectIntervalMills = r101;
    }
}
