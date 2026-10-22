package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes14.dex */
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

    public void setExitTime(long r100) {
        this.exitTime = r100;
    }

    public void setExtraData(String r100) {
        this.extraData = r100;
    }

    public Trace(String r100, String r101, long r102, String r103) {
        this.className = r100;
        this.methodName = r101;
        this.entryTime = r102;
        this.traceType = r103;
    }

    public Trace(String r100, String r101, String r102, long r103, String r104) {
        this.scene = r100;
        this.className = r101;
        this.methodName = r102;
        this.entryTime = r103;
        this.traceType = r104;
    }
}
