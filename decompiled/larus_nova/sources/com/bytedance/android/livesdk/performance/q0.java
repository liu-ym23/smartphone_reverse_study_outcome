package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class q0 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("min_cpu_monitor_limit")
    public long minCpuMonitorLimit;

    public q0() {
        this.enable = false;
        this.minCpuMonitorLimit = 360;
    }
}
