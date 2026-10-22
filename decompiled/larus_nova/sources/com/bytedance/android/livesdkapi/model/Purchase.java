package com.bytedance.android.livesdkapi.model;

/* JADX INFO: loaded from: classes12.dex */
public class Purchase {
    private String orderId;
    private String originalJson;
    private long purchaseTime;
    private String purchaseToken;
    private String signature;
    private String sku;

    public Purchase(String r100, String r101, long r102, String r103, String r104, String r105) {
        this.sku = r100;
        this.orderId = r101;
        this.purchaseTime = r102;
        this.purchaseToken = r103;
        this.originalJson = r104;
        this.signature = r105;
    }
}
