package com.bytedance.privacy.pseudoid.network;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkResponse {
    private int code;
    private String message;
    private PseudoID pseudoID;

    public NetworkResponse(int r1, String r2, PseudoID r3) {
        this.code = r1;
        this.message = r2;
        this.pseudoID = r3;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public PseudoID getPseudoID() {
        return this.pseudoID;
    }
}
