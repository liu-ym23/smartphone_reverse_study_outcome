package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePreviewCoverImageConfig;", "", "()V", "mEnable", "", "getMEnable", "()Z", "setMEnable", "(Z)V", "mRadius", "", "getMRadius", "()I", "setMRadius", "(I)V", "mRegionHeight", "", "getMRegionHeight", "()F", "setMRegionHeight", "(F)V", "mRegionWidth", "getMRegionWidth", "setMRegionWidth", "mRegionX", "getMRegionX", "setMRegionX", "mRegionY", "getMRegionY", "setMRegionY", "mScale", "getMScale", "setMScale", "mType", "getMType", "setMType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewCoverImageConfig {

    @SerializedName("enable")
    private boolean mEnable;

    @SerializedName("radius")
    private int mRadius;

    @SerializedName("regionHeight")
    private float mRegionHeight;

    @SerializedName("regionWidth")
    private float mRegionWidth;

    @SerializedName("regionX")
    private float mRegionX;

    @SerializedName("regionY")
    private float mRegionY;

    @SerializedName("scale")
    private float mScale;

    @SerializedName("type")
    private int mType;

    public LivePreviewCoverImageConfig() {
        this.mRegionX = 0.1f;
        this.mRegionY = 0.1f;
        this.mRegionWidth = 0.1f;
        this.mRegionHeight = 0.1f;
        this.mRadius = 2;
        this.mScale = 0.1f;
    }

    public final boolean getMEnable() {
        return this.mEnable;
    }

    public final int getMRadius() {
        return this.mRadius;
    }

    public final float getMRegionHeight() {
        return this.mRegionHeight;
    }

    public final float getMRegionWidth() {
        return this.mRegionWidth;
    }

    public final float getMRegionX() {
        return this.mRegionX;
    }

    public final float getMRegionY() {
        return this.mRegionY;
    }

    public final float getMScale() {
        return this.mScale;
    }

    public final int getMType() {
        return this.mType;
    }

    public final void setMEnable(boolean r100) {
        this.mEnable = r100;
    }

    public final void setMRadius(int r100) {
        this.mRadius = r100;
    }

    public final void setMRegionHeight(float r100) {
        this.mRegionHeight = r100;
    }

    public final void setMRegionWidth(float r100) {
        this.mRegionWidth = r100;
    }

    public final void setMRegionX(float r100) {
        this.mRegionX = r100;
    }

    public final void setMRegionY(float r100) {
        this.mRegionY = r100;
    }

    public final void setMScale(float r100) {
        this.mScale = r100;
    }

    public final void setMType(int r100) {
        this.mType = r100;
    }
}
