package com.bytedance.rpc;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcCaller {

    public interface RpcInvoke {
        Object invoke(RpcRequest r1);
    }

    Object invoke(RpcInvoke r1, RpcRequest r2);
}
