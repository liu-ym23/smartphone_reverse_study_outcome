package com.volcengine.tos;

import B7.a;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TosServerException extends TosException implements Serializable {
    private String code;
    private String hostID;
    private String message;
    private String requestID;
    private int statusCode;

    public TosServerException(int i) {
        this.statusCode = i;
    }

    @Override // com.volcengine.tos.TosException
    public String getCode() {
        return this.code;
    }

    public String getHostID() {
        return this.hostID;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public String getRequestID() {
        return this.requestID;
    }

    @Override // com.volcengine.tos.TosException
    public int getStatusCode() {
        return this.statusCode;
    }

    public TosServerException setCode(String str) {
        this.code = str;
        return this;
    }

    public TosServerException setHostID(String str) {
        this.hostID = str;
        return this;
    }

    public TosServerException setMessage(String str) {
        this.message = str;
        return this;
    }

    public TosServerException setRequestID(String str) {
        this.requestID = str;
        return this;
    }

    public TosServerException setStatusCode(int i) {
        this.statusCode = i;
        return this;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder("TosServerException{statusCode=");
        sb.append(this.statusCode);
        sb.append(", code='");
        sb.append(this.code);
        sb.append("', message='");
        sb.append(this.message);
        sb.append("', requestID='");
        sb.append(this.requestID);
        sb.append("', hostID='");
        return a.q(sb, this.hostID, "'}");
    }

    public TosServerException(int i, String str, String str2, String str3, String str4) {
        this.statusCode = i;
        this.code = str;
        this.message = str2;
        this.requestID = str3;
        this.hostID = str4;
    }
}
