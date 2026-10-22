package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public interface Service {
    void callMethod(Descriptors.MethodDescriptor r10, RpcController r11, Message r12, RpcCallback<Message> r13);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r10);

    Message getResponsePrototype(Descriptors.MethodDescriptor r10);
}
