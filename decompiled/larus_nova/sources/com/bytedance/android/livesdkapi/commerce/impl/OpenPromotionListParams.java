package com.bytedance.android.livesdkapi.commerce.impl;

import com.bytedance.android.livesdkapi.commerce.param.IOpenPromotionListParams;

/* JADX INFO: loaded from: classes12.dex */
public class OpenPromotionListParams implements IOpenPromotionListParams {
    private String couponId;
    private String entryName;

    @Override // com.bytedance.android.livesdkapi.commerce.param.IOpenPromotionListParams
    public String entryName() {
        return this.entryName;
    }

    @Override // com.bytedance.android.livesdkapi.commerce.param.IOpenPromotionListParams
    public String getCouponId() {
        return this.couponId;
    }

    public OpenPromotionListParams(String r100, String r101) {
        this.couponId = r100;
        this.entryName = r101;
    }
}
