package com.obric.aiagent.ttnet;

/* JADX INFO: compiled from: ITTNet.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ITTNet {
    void addInterceptor(com.bytedance.retrofit2.d.b r1);

    int getEffectiveConnectionType();

    b getRequestRestrictManager();

    void init(g r1, e r2);

    void onNetworkError(c r1);
}
