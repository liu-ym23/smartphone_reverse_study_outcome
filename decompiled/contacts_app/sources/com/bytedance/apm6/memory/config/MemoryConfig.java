package com.bytedance.apm6.memory.config;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryConfig {
    public static final double BENCHMARK_RATE = 0.8d;
    public static final long MEM_MONITOR_INTERVAL_SECONDS = 120;
    public static final double REACH_TOP_MIN_RATE = 0.5d;
    private boolean isApm6SampleEnable;
    private boolean isRealTimeMemEnable;
    private boolean isStopWhenBackground;
    private boolean isUploadEnable;
    private long memoryCollectionInterval;
    private double memoryTopCheckThreshold;

    public MemoryConfig(long r3, double r5, boolean r7, boolean r8, boolean r9, boolean r10) {
        if (r3 > 0) goto L5;
        this.memoryCollectionInterval = 120;
    L6:
        this.memoryTopCheckThreshold = r5;
        this.isApm6SampleEnable = r10;
        this.isStopWhenBackground = r7;
        this.isRealTimeMemEnable = r8;
        this.isUploadEnable = r9;
        return;
    L5:
        this.memoryCollectionInterval = r3;
        goto L6
    }

    public boolean isApm6SampleEnable() {
        return this.isApm6SampleEnable;
    }

    public double memoryTopCheckThreshold() {
        double r0 = this.memoryTopCheckThreshold;
        if (r0 <= 0.5d) goto L5;
        return r0;
    L5:
        return 0.8d;
    }

    public long memoryCollectionInterval() {
        return this.memoryCollectionInterval;
    }

    public boolean isStopWhenBackground() {
        return this.isStopWhenBackground;
    }

    public boolean isRealTimeMemEnable() {
        return this.isRealTimeMemEnable;
    }

    public boolean isUploadEnable() {
        return this.isUploadEnable;
    }

    public void setRealTimeMemEnable(boolean r1) {
        this.isRealTimeMemEnable = r1;
    }

    public void setStopWhenBackground(boolean r1) {
        this.isStopWhenBackground = r1;
    }

    public String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.memoryCollectionInterval + ", memoryTopCheckThreshold=" + this.memoryTopCheckThreshold + ", isStopWhenBackground=" + this.isStopWhenBackground + ", isRealTimeMemEnable=" + this.isRealTimeMemEnable + ", isUploadEnable=" + this.isUploadEnable + ", isApm6SampleEnable=" + this.isApm6SampleEnable + '}';
    }
}
