package com.bytedance.apm.entity;

/* JADX INFO: loaded from: classes2.dex */
public class TraceTimeEntity {
    public long endTimestamp;
    public long startTimestamp;
    public String threadName;

    public TraceTimeEntity(long r1) {
        this.startTimestamp = r1;
    }

    public void appendEndTimeAndThread(long r1, String r3) {
        this.endTimestamp = r1;
        this.threadName = r3;
    }
}
