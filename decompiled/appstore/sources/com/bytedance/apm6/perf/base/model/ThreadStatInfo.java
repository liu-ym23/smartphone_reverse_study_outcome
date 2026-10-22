package com.bytedance.apm6.perf.base.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ThreadStatInfo {
    public long threadCpuTime;
    public String threadName;

    public ThreadStatInfo(String r10, long r11) {
        this.threadName = r10;
        this.threadCpuTime = r11;
    }
}
