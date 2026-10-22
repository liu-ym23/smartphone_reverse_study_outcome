package com.volcengine.tos.model;

import java.util.Map;

/* loaded from: classes3.dex */
public class RequestInfo {
    private Map<String, String> header;
    private String id2;
    private String requestId;
    private int statusCode;

    @Deprecated
    public RequestInfo(String str, Map<String, String> map) {
        this.requestId = str;
        this.header = map;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getId2() {
        return this.id2;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Deprecated
    public RequestInfo setHeader(Map<String, String> map) {
        this.header = map;
        return this;
    }

    @Deprecated
    public RequestInfo setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public String toString() {
        return "RequestInfo{requestId='" + this.requestId + "', id2='" + this.id2 + "', statusCode=" + this.statusCode + ", header=" + this.header + '}';
    }

    public RequestInfo(String str, String str2, int i, Map<String, String> map) {
        this.requestId = str;
        this.id2 = str2;
        this.statusCode = i;
        this.header = map;
    }
}
