package com.bytedance.rpc.callback;

import com.bytedance.rpc.RpcCaller;
import com.bytedance.rpc.RpcRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcInvokeInterceptor {
    RpcCaller invoke(Class r1, RpcRequest r2);
}
