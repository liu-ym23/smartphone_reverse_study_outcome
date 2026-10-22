package com.bytedance.frameworks.baselib.network.http.cronet.diagnosis;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetDiagnosisRequest {

    public interface Callback {
        void onNetDiagnosisRequestComplete(String r10);
    }

    void cancel();

    void doExtraCommand(String r10, String r11);

    void start();
}
