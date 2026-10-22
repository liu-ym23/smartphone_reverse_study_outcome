package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
class CronetSsCall extends BaseCronetSsCall {
    private HttpURLConnection httpConnection;

    public CronetSsCall(Request r1) {
        super(r1);
        this.httpConnection = null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    HttpURLConnection connection() {
        return this.httpConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    void setConnection(HttpURLConnection r1) {
        this.httpConnection = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected IOException convertException(Exception r4) {
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r4.getClass().getName()) == false) goto L5;
        doCollect();
        int r0 = SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
    L7:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r4.getClass().getName()) == false) goto L9;
    L10:
        r0 = SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
    L12:
        return new CronetIOException(r4, this.requestInfo, r0);
    L9:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r4.getClass().getName()) == false) goto L12;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected int getStatusCodeFromException(IOException r3) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        return -1;
    L10:
        return SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        cancelInner(this.httpConnection);
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r2, boolean r3) {
        cancelNormalRequestInner(this.httpConnection, r2, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall, com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r6) {
        super.setThrottleNetSpeed(r6);
        HttpURLConnection r5 = this.httpConnection;
        if (r5 != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(r5).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        getRequestMetrics(this.requestInfo, this);
    }
}
