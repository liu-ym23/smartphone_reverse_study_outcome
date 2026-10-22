package com.bytedance.privacy.pseudoid.network;

/* JADX INFO: loaded from: classes2.dex */
public class PseudoID {
    private final String rpDID;
    private final String rpUID;

    public PseudoID(String r1, String r2) {
        this.rpDID = r1;
        this.rpUID = r2;
    }

    public String getRPDID() {
        return this.rpDID;
    }

    public String getRPUID() {
        return this.rpUID;
    }
}
