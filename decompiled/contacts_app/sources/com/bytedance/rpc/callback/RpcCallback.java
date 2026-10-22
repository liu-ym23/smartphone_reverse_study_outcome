package com.bytedance.rpc.callback;

import com.bytedance.rpc.RpcException;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcCallback<DATA> {
    void onFailure(RpcException r1);

    void onSuccess(DATA r1);
}
