package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface Service {
    void callMethod(Descriptors.MethodDescriptor r1, RpcController r2, Message r3, RpcCallback<Message> r4);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r1);

    Message getResponsePrototype(Descriptors.MethodDescriptor r1);
}
