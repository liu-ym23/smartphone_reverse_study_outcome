package com.bytedance.android.livesdkapi.depend.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class CustomChargeDeal extends ChargeDeal {

    @SerializedName("coupon_id")
    private String couponId;
    private long customPrice;

    @SerializedName("diamond_count_rate")
    private float diamondCountRate;

    @SerializedName("price_max")
    private int maxPrice;

    @SerializedName("price_min")
    private int minPrice;

    public CustomChargeDeal() {
        this.minPrice = 0;
        this.maxPrice = 0;
        this.diamondCountRate = 0.0f;
    }

    public String getCouponId() {
        return this.couponId;
    }

    public long getCustomPrice() {
        return this.customPrice;
    }

    public float getDiamondCountRate() {
        return this.diamondCountRate;
    }

    public int getMaxPrice() {
        return this.maxPrice;
    }

    public int getMinPrice() {
        return this.minPrice;
    }

    public void setCouponId(String r100) {
        this.couponId = r100;
    }

    public void setCustomPrice(long r100) {
        this.customPrice = r100;
    }

    public void setDiamondCountRate(float r100) {
        this.diamondCountRate = r100;
    }

    public void setMaxPrice(int r100) {
        this.maxPrice = r100;
    }

    public void setMinPrice(int r100) {
        this.minPrice = r100;
    }
}
