package com.android.server;

/* JADX INFO: loaded from: classes.dex */
public class SmartAppCrashStatus extends UploadEvent {
    public int dailyCrashCount;
    public double dailyCrashRate;
    public double dailyUsageTime;
    public String packageName;
    public int versionCrashCount;
    public double versionCrashRate;
    public double versionUsageTime;

    public SmartAppCrashStatus() {
        this.dailyCrashCount = 0;
        this.versionCrashCount = 0;
        this.dailyUsageTime = 0.0d;
        this.versionUsageTime = 0.0d;
        this.dailyCrashRate = 0.0d;
        this.versionCrashRate = 0.0d;
    }
}
