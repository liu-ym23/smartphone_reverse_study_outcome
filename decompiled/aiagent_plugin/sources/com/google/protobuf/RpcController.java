package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> r1);

    void reset();

    void setFailed(String r1);

    void startCancel();
}
