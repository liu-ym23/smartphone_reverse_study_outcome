package com.bytedance.ttnet.diagnosis;

/* JADX INFO: loaded from: classes.dex */
public interface IDiagnosisRequest {
    void cancel();

    void doExtraCommand(String r10, String r11);

    void setUserExtraInfo(String r10);

    void start(IDiagnosisCallback r10);
}
