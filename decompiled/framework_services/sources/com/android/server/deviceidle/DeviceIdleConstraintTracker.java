package com.android.server.deviceidle;

/* JADX INFO: loaded from: classes.dex */
public class DeviceIdleConstraintTracker {
    public boolean active;
    public final int minState;
    public boolean monitoring;
    public final String name;

    public DeviceIdleConstraintTracker(String name, int minState) {
        this.active = false;
        this.monitoring = false;
        this.name = name;
        this.minState = minState;
    }
}
