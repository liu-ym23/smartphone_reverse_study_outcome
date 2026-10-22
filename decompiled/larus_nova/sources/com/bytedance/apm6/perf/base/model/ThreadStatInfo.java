package com.bytedance.apm6.perf.base.model;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadStatInfo {
    public long threadCpuTime;
    public String threadName;

    public ThreadStatInfo(String r100, long r101) {
        this.threadName = r100;
        this.threadCpuTime = r101;
    }
}
