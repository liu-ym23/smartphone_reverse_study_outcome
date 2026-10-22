package com.bytedance.rpc.transport;

/* JADX INFO: loaded from: classes2.dex */
public interface TransportClient {
    void cancel(int r1);

    void destroy();

    TransportResponse transport(TransportRequest r1) throws Exception;

    void transport(TransportRequest r1, TransportCallback r2) throws Exception;
}
