package com.bytedance.vmsdk.jsbridge;

/* JADX INFO: loaded from: classes.dex */
public interface Promise {
    @Deprecated
    void reject(String r1);

    void reject(String r1, String r2);

    void resolve(Object r1);
}
