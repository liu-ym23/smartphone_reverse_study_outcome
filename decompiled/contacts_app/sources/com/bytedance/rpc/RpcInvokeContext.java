package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.transport.TransportRequestInterceptor;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcInvokeContext {
    private RpcContext mContext;
    private RpcRequestModifier mModifier;
    private final List<RpcInterceptor> mRpcInterceptorList;

    RpcInvokeContext(RpcContext r3) {
        this.mRpcInterceptorList = new ArrayList(4);
        this.mContext = r3;
        this.mModifier = new RpcRequestModifier(r3);
    }

    public void addRpcInterceptor(RpcInterceptor r3) {
        if (r3 == null) goto L13;
        List<RpcInterceptor> r0 = this.mRpcInterceptorList;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mRpcInterceptorList.contains(r3) == true) goto L8;
        this.mRpcInterceptorList.add(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    }

    public void removeRpcInterceptor(RpcInterceptor r2) {
        if (r2 == null) goto L11;
        List<RpcInterceptor> r0 = this.mRpcInterceptorList;
        monitor-enter(r0);
        this.mRpcInterceptorList.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setTimeout(long r8, long r10, long r12) {
        this.mModifier.setTimeout(r8, r10, r12);
    }

    public void setBaseUrl(String r1) {
        this.mModifier.setBaseUrl(r1);
    }

    public void addHeader(String r1, String r2) {
        this.mModifier.addHeader(r1, r2);
    }

    public void addQuery(String r1, String r2) {
        this.mModifier.addQuery(r1, r2);
    }

    void updateConfig(RpcConfig r1) {
        this.mModifier.updateConfig(r1);
    }

    boolean collectCommonParams(String r3, Map<String, String> r4, Map<String, String> r5) {
        RpcConfig r0 = getRpcConfig();
        r4.putAll(r0.getHeaders());
        r5.putAll(r0.getQueries());
        if (r3 != null) goto L6;
        return true;
    L6:
        return this.mContext.collectCommonParams(r3, r4, r5);
    }

    Application getApplication() {
        return this.mContext.getApplicationContext();
    }

    RpcConfig getRpcConfig() {
        return this.mContext.getRpcConfig();
    }

    RpcRequestModifier getModifier() {
        return this.mModifier;
    }

    RpcInterceptor[] getRpcInterceptors() {
        List<RpcInterceptor> r0 = this.mContext.getRpcInterceptors();
        List<RpcInterceptor> r6 = this.mRpcInterceptorList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r6 != null) goto L8;
        int r3 = 0;
    L9:
        RpcInterceptor[] r4 = new RpcInterceptor[r2 + r3];
        if (r2 <= 0) goto L12;
        r0.toArray(r4);
    L12:
        if (r3 <= 0) goto L17;
        if (r2 != 0) goto L15;
        r6.toArray(r4);
    L15:
        if (r1 >= r3) goto L17;
        r4[r2 + r1] = r6.get(r1);
        r1 = r1 + 1;
    L17:
        return r4;
    L8:
        r3 = r6.size();
        goto L9
    L5:
        r2 = r0.size();
        goto L6
    }

    TransportRequestInterceptor[] getTransportRequestInterceptors() {
        List<TransportRequestInterceptor> r2 = this.mContext.getTransportRequestInterceptors();
        if (r2 != null) goto L5;
        int r0 = 0;
    L6:
        TransportRequestInterceptor[] r1 = new TransportRequestInterceptor[r0];
        if (r0 <= 0) goto L9;
        r2.toArray(r1);
    L9:
        return r1;
    L5:
        r0 = r2.size();
        goto L6
    }

    TransportResultInterceptor[] getTransportResultInterceptors() {
        List<TransportResultInterceptor> r2 = this.mContext.getTransportResultInterceptors();
        if (r2 != null) goto L5;
        int r0 = 0;
    L6:
        TransportResultInterceptor[] r1 = new TransportResultInterceptor[r0];
        if (r0 <= 0) goto L9;
        r2.toArray(r1);
    L9:
        return r1;
    L5:
        r0 = r2.size();
        goto L6
    }

    RpcInvokeInterceptor[] getRpcInvokeInterceptors() {
        List<RpcInvokeInterceptor> r2 = this.mContext.getRpcInvokeInterceptors();
        if (r2 != null) goto L5;
        int r0 = 0;
    L6:
        RpcInvokeInterceptor[] r1 = new RpcInvokeInterceptor[r0];
        if (r0 <= 0) goto L9;
        r2.toArray(r1);
    L9:
        return r1;
    L5:
        r0 = r2.size();
        goto L6
    }

    public long getMonitorTimeout() {
        long r0 = this.mModifier.getConnectTimeout();
        long r2 = this.mModifier.getReadTimeout();
        long r4 = this.mModifier.getWriteTimeout();
        if (r0 > 0) goto L5;
    L10:
        return 0;
    L5:
        if (r2 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        return ((r0 + r2) + r4) + 100;
    }
}
