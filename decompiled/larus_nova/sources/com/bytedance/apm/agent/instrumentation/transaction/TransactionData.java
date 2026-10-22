package com.bytedance.apm.agent.instrumentation.transaction;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
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

    public String toString() {
        return "TransactionData{requestStart=" + this.requestStart + ", url='" + this.url + "', carrier='" + this.carrier + "', totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", wanType='" + this.wanType + "', httpMethod='" + this.httpMethod + "', extraData=" + this.extraData + '}';
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

    public void setErrorCode(int r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        this.errorCode = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRequestEnd(long r100) {
        this.requestEnd = r100;
    }

    public TransactionData(String r100, String r101, long r102, int r103, int r104, long r105, long r110, String r111, String r112, JSONObject r113) {
        this.requestStart = System.currentTimeMillis();
        this.lock = new Object();
        this.url = r100;
        this.carrier = r101;
        this.totalTime = r102;
        this.statusCode = r103;
        this.errorCode = r104;
        this.bytesSent = r105;
        this.bytesReceived = r110;
        this.wanType = r111;
        this.httpMethod = r112;
        this.extraData = r113;
    }
}
