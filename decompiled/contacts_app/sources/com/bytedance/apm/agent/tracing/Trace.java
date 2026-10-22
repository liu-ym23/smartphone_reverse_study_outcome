package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes2.dex */
public class Trace {
    public String className;
    public long entryTime;
    public long exitTime;
    public String extraData;
    public String methodName;
    public String scene;
    public String traceType;

    public Trace() {
    }

    public Trace(String r1, String r2, String r3, long r4, String r6) {
        this.scene = r1;
        this.className = r2;
        this.methodName = r3;
        this.entryTime = r4;
        this.traceType = r6;
    }

    public Trace(String r1, String r2, long r3, String r5) {
        this.className = r1;
        this.methodName = r2;
        this.entryTime = r3;
        this.traceType = r5;
    }

    public void setExitTime(long r1) {
        this.exitTime = r1;
    }

    public void setExtraData(String r1) {
        this.extraData = r1;
    }
}
