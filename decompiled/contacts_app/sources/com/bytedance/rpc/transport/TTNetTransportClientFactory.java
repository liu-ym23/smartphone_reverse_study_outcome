package com.bytedance.rpc.transport;

import com.bytedance.rpc.RpcContext;
import com.bytedance.rpc.RpcException;
import com.bytedance.rpc.transport.ttnet.DefaultTransportClient;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetTransportClientFactory implements TransportClientFactory {
    public TTNetTransportClientFactory() {
        RpcException.addConverter(new AnonymousClass1(this));
    }

    @Override // com.bytedance.rpc.transport.TransportClientFactory
    public TransportClient create(RpcContext r1, boolean r2) {
        return new DefaultTransportClient(r1);
    }
}
