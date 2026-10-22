package com.bytedance.apm6.consumer.slardar.weedout;

/* JADX INFO: loaded from: classes.dex */
public interface WeedOutStrategy {
    void doWeedOut(long r10);

    void doWeedOutSize(long r10);

    String getName();

    long getSize();
}
