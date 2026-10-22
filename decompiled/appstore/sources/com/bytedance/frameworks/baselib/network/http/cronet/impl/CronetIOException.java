package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CronetIOException extends IOException {
    private final int cronetInternalErrorCode;
    private BaseHttpRequestInfo requestInfo;
    private int statusCode;
    private String traceCode;

    public CronetIOException(Exception r10, BaseHttpRequestInfo r11, String r12, int r13) {
        super(r10.getMessage(), r10.getCause());
        this.requestInfo = r11;
        this.traceCode = r12;
        if ((r10 instanceof HttpResponseException) == false) goto L5;
        this.statusCode = ((HttpResponseException) r10).getStatusCode();
    L5:
        this.cronetInternalErrorCode = r13;
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }

    public BaseHttpRequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getRequestLog() {
        return this.requestInfo.f7186y;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getTraceCode() {
        return this.traceCode;
    }
}
