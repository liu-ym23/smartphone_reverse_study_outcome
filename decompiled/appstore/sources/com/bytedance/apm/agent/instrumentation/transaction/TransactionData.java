package com.bytedance.apm.agent.instrumentation.transaction;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TransactionData {
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private int errorCode;
    private JSONObject extraData;
    private String httpMethod;
    private Object lock;
    private long requestEnd;
    private long requestStart;
    private int statusCode;
    private long totalTime;
    private String url;
    private String wanType;

    public TransactionData(String r10, String r11, long r12, int r13, int r14, long r15, long r16, String r17, String r18, JSONObject r19) {
        this.requestStart = System.currentTimeMillis();
        this.lock = new Object();
        this.url = r10;
        this.carrier = r11;
        this.totalTime = r12;
        this.statusCode = r13;
        this.errorCode = r14;
        this.bytesSent = r15;
        this.bytesReceived = r16;
        this.wanType = r17;
        this.httpMethod = r18;
        this.extraData = r19;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public JSONObject getExtraData() {
        return this.extraData;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public long getRequestEnd() {
        return this.requestEnd;
    }

    public long getRequestStart() {
        return this.requestStart;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWanType() {
        return this.wanType;
    }

    public void setErrorCode(int r10) {
        Object r11 = this.lock;
        monitor-enter(r11);
        this.errorCode = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRequestEnd(long r10) {
        this.requestEnd = r10;
    }

    public String toString() {
        return "TransactionData{requestStart=" + this.requestStart + ", url='" + this.url + "', carrier='" + this.carrier + "', totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", wanType='" + this.wanType + "', httpMethod='" + this.httpMethod + "', extraData=" + this.extraData + '}';
    }
}
