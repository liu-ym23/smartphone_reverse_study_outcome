package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes.dex */
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

    public void setExitTime(long r10) {
        this.exitTime = r10;
    }

    public void setExtraData(String r10) {
        this.extraData = r10;
    }

    public Trace(String r10, String r11, String r12, long r13, String r14) {
        this.scene = r10;
        this.className = r11;
        this.methodName = r12;
        this.entryTime = r13;
        this.traceType = r14;
    }

    public Trace(String r10, String r11, long r12, String r13) {
        this.className = r10;
        this.methodName = r11;
        this.entryTime = r12;
        this.traceType = r13;
    }
}
