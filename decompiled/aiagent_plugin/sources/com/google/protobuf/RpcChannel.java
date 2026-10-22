package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor r1, RpcController r2, Message r3, Message r4, RpcCallback<Message> r5);
}
