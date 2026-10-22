package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.transport.TransportRequestInterceptor;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcContext {
    private final Application mApplicationContext;
    private final Map<String, Map<String, String>> mCommonHeaders;
    private final Map<String, Object> mCommonParams;
    private final Map<String, Map<String, String>> mCommonQueries;
    private RpcConfig mConfig;
    private final List<RpcInterceptor> mRpcInterceptorList;
    private final List<RpcInvokeInterceptor> mRpcInvokeInterceptor;
    private final List<TransportRequestInterceptor> mTransportRequestInterceptorList;
    private final List<TransportResultInterceptor> mTransportResultInterceptorList;

    RpcContext(Application r4, RpcConfig r5) {
        this.mRpcInterceptorList = new ArrayList(4);
        this.mTransportRequestInterceptorList = new ArrayList(2);
        this.mTransportResultInterceptorList = new ArrayList(2);
        this.mRpcInvokeInterceptor = new ArrayList(2);
        this.mCommonParams = new HashMap(4);
        this.mCommonHeaders = new HashMap(2);
        this.mCommonQueries = new HashMap(2);
        this.mApplicationContext = r4;
        this.mConfig = r5;
    }

    public Application getApplicationContext() {
        return this.mApplicationContext;
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

    public void addTransportRequestInterceptor(TransportRequestInterceptor r3) {
        if (r3 == null) goto L13;
        List<TransportRequestInterceptor> r0 = this.mTransportRequestInterceptorList;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mTransportRequestInterceptorList.contains(r3) == true) goto L8;
        this.mTransportRequestInterceptorList.add(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    }

    public void removeTransportRequestInterceptor(TransportRequestInterceptor r2) {
        if (r2 == null) goto L11;
        List<TransportRequestInterceptor> r0 = this.mTransportRequestInterceptorList;
        monitor-enter(r0);
        this.mTransportRequestInterceptorList.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addTransportResultInterceptor(TransportResultInterceptor r3) {
        if (r3 == null) goto L13;
        List<TransportResultInterceptor> r0 = this.mTransportResultInterceptorList;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mTransportResultInterceptorList.contains(r3) == true) goto L8;
        this.mTransportResultInterceptorList.add(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    }

    public void removeTransportResultInterceptor(TransportResultInterceptor r2) {
        if (r2 == null) goto L11;
        List<TransportResultInterceptor> r0 = this.mTransportResultInterceptorList;
        monitor-enter(r0);
        this.mTransportResultInterceptorList.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addRpcInvokeInterceptor(RpcInvokeInterceptor r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mRpcInvokeInterceptor.contains(r2) == true) goto L8;
        this.mRpcInvokeInterceptor.add(r2);
        return;
    }

    public void removeRpcInvokeInterceptor(RpcInvokeInterceptor r1) {
        if (r1 == null) goto L5;
        this.mRpcInvokeInterceptor.remove(r1);
        return;
    }

    public RpcConfig getRpcConfig() {
        return this.mConfig;
    }

    void updateRpcConfig(RpcConfig r1) {
        this.mConfig = r1;
    }

    List<RpcInterceptor> getRpcInterceptors() {
        return this.mRpcInterceptorList;
    }

    List<TransportRequestInterceptor> getTransportRequestInterceptors() {
        return this.mTransportRequestInterceptorList;
    }

    List<TransportResultInterceptor> getTransportResultInterceptors() {
        return this.mTransportResultInterceptorList;
    }

    List<RpcInvokeInterceptor> getRpcInvokeInterceptors() {
        return this.mRpcInvokeInterceptor;
    }

    void registerBizModel(String r3, Object r4) {
        Map<String, Object> r0 = this.mCommonParams;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mCommonParams.put(r3, r4) == null) goto L11;
        Map<String, String> r5 = this.mCommonHeaders.remove(r3);     // Catch: Throwable -> L13
        Map<String, String> r2 = this.mCommonQueries.remove(r3);     // Catch: Throwable -> L13
        if (r5 == null) goto L9;
        r5.clear();     // Catch: Throwable -> L13
    L9:
        if (r2 == null) goto L11;
        r2.clear();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    boolean collectCommonParams(String r5, Map<String, String> r6, Map<String, String> r7) {
        Map<String, Object> r0 = this.mCommonParams;
        monitor-enter(r0);
        Map<String, String> r1 = this.mCommonHeaders.get(r5);     // Catch: Throwable -> L19
        Map<String, String> r2 = this.mCommonQueries.get(r5);     // Catch: Throwable -> L19
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
    L10:
        if (r1 == null) goto L16;
        if (r2 == null) goto L16;
        r6.putAll(r1);     // Catch: Throwable -> L19
        r7.putAll(r2);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return false;
    L7:
        Object r3 = this.mCommonParams.remove(r5);     // Catch: Throwable -> L19
        if (r3 == null) goto L10;
        loadCommonParams(r5, r3);     // Catch: Throwable -> L19
        r1 = this.mCommonHeaders.get(r5);     // Catch: Throwable -> L19
        r2 = this.mCommonQueries.get(r5);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private void loadCommonParams(String r4, Object r5) {
        HashMap r0 = new HashMap(8);
        HashMap r2 = new HashMap(8);
        SerializeManager.dump(r5, r0, r2, null);
        this.mCommonHeaders.put(r4, r0);
        this.mCommonQueries.put(r4, r2);
    }
}
