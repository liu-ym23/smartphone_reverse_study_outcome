package com.bytedance.crypto.modeldist;

/* JADX INFO: loaded from: classes.dex */
public class ModelInitResult {
    private String attestCertChain;
    private int errorCode;

    public ModelInitResult(int r1, String r2) {
        this.errorCode = r1;
        this.attestCertChain = r2;
    }

    public String getAttestCertChain() {
        return this.attestCertChain;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
