package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class PackageChangeEvent {
    public static final int EVENT_PACKAGE_ADD = 1;
    public static final int EVENT_PACKAGE_REMOVE = 2;
    private String mPackageName;
    private int mStatus;

    public PackageChangeEvent(String r10, int r11) {
        this.mPackageName = r10;
        this.mStatus = r11;
    }

    public int getEventStatus() {
        return this.mStatus;
    }

    public String getPackageName() {
        return this.mPackageName;
    }
}
