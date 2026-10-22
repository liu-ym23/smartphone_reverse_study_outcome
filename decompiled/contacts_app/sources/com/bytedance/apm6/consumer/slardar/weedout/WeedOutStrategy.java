package com.bytedance.apm6.consumer.slardar.weedout;

/* JADX INFO: loaded from: classes2.dex */
public interface WeedOutStrategy {
    void doWeedOut(long r1);

    void doWeedOutSize(long r1);

    String getName();

    long getSize();
}
