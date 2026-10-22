package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class HalfScreenBackgroundConfig {

    @SerializedName("animDuration")
    public int animDuration;

    @SerializedName("darkMask")
    public boolean darkMask;

    @SerializedName("delay")
    public long delay;

    @SerializedName("duration")
    public long mDuration;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("radius")
    public int mRadius;

    @SerializedName("regionHeight")
    public float mRegionHeight;

    @SerializedName("regionWidth")
    public float mRegionWidth;

    @SerializedName("regionX")
    public float mRegionX;

    @SerializedName("regionY")
    public float mRegionY;

    @SerializedName("type")
    public int mType;

    @SerializedName("scale")
    public float scale;

    public HalfScreenBackgroundConfig() {
        this.mType = 0;
        this.mRegionX = 0.1f;
        this.mRegionY = 0.1f;
        this.mRegionWidth = 0.1f;
        this.mRegionHeight = 0.1f;
        this.mRadius = 2;
        this.mDuration = 30000;
        this.scale = 0.1f;
        this.animDuration = 5000;
        this.darkMask = false;
        this.delay = 0;
    }
}
