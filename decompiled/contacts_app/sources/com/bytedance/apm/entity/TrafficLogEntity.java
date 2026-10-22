package com.bytedance.apm.entity;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficLogEntity {
    private int front;
    private int netType;
    private int send;
    private long sid;
    private long time;
    private long value;

    public TrafficLogEntity(long r1, int r3, int r4, int r5, long r6) {
        this.value = r1;
        this.netType = r4;
        this.send = r5;
        this.front = r3;
        this.time = r6;
    }

    public TrafficLogEntity(long r1, int r3, int r4, int r5, long r6, long r8) {
        this.value = r1;
        this.netType = r4;
        this.send = r5;
        this.front = r3;
        this.time = r6;
        this.sid = r8;
    }

    public long getValue() {
        return this.value;
    }

    public int getNetType() {
        return this.netType;
    }

    public int getSend() {
        return this.send;
    }

    public int getFront() {
        return this.front;
    }

    public long getTime() {
        return this.time;
    }

    public long getSid() {
        return this.sid;
    }

    public String toString() {
        return "TrafficLogEntity{value=" + this.value + ", netType=" + this.netType + ", send=" + this.send + ", front=" + this.front + ", time=" + this.time + ", sid=" + this.sid + '}';
    }
}
