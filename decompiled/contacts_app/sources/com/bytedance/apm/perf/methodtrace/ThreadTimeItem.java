package com.bytedance.apm.perf.methodtrace;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadTimeItem {
    public int threadId;
    public String threadName;
    public long threadTime;
    public float threadUsage;

    public ThreadTimeItem(int r1, String r2, long r3) {
        this.threadId = r1;
        this.threadName = r2;
        this.threadTime = r3;
        this.threadUsage = 0.0f;
    }

    public void updateThreadTime(long r1) {
        this.threadTime = r1;
    }
}
