package com.bytedance.android.livesdkapi.commerce.impl;

/* JADX INFO: loaded from: classes12.dex */
public class ECSimplePromotion {
    private String imageUrl;
    private String price;
    private String promotionId;

    public ECSimplePromotion() {
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPromotionId() {
        return this.promotionId;
    }

    public void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public void setPrice(String r100) {
        this.price = r100;
    }

    public void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public ECSimplePromotion(String r100, String r101) {
        this.promotionId = r100;
        this.imageUrl = r101;
    }
}
