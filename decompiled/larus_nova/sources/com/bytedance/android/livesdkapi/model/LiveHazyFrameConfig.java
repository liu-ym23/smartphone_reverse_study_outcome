package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveHazyFrameConfig;", "", "()V", "disableDefaultBackground", "", "getDisableDefaultBackground", "()Z", "setDisableDefaultBackground", "(Z)V", "disableDimBackgroundCover", "getDisableDimBackgroundCover", "setDisableDimBackgroundCover", "enableClientBlur", "getEnableClientBlur", "setEnableClientBlur", "enableInner", "getEnableInner", "setEnableInner", "enablePreview", "getEnablePreview", "setEnablePreview", "enablePreviewDrawProcessor", "getEnablePreviewDrawProcessor", "setEnablePreviewDrawProcessor", "enableSmoothEnter", "getEnableSmoothEnter", "setEnableSmoothEnter", "imageDecodeOpt", "getImageDecodeOpt", "setImageDecodeOpt", "newBlurImplXRadius", "", "getNewBlurImplXRadius", "()F", "setNewBlurImplXRadius", "(F)V", "newBlurImplYRadius", "getNewBlurImplYRadius", "setNewBlurImplYRadius", "useNewBlurImpl", "getUseNewBlurImpl", "setUseNewBlurImpl", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHazyFrameConfig {

    @SerializedName("disable_default_background")
    private boolean disableDefaultBackground;

    @SerializedName("disable_dim_background_cover")
    private boolean disableDimBackgroundCover;

    @SerializedName("enable_client_blur")
    private boolean enableClientBlur;

    @SerializedName("enable_inner")
    private boolean enableInner;

    @SerializedName("enable_preview")
    private boolean enablePreview;

    @SerializedName("enable_preview_draw_processor")
    private boolean enablePreviewDrawProcessor;

    @SerializedName("enable_smooth_enter")
    private boolean enableSmoothEnter;

    @SerializedName("image_decode_opt")
    private boolean imageDecodeOpt;

    @SerializedName("new_blur_impl_x_radius")
    private float newBlurImplXRadius;

    @SerializedName("new_blur_impl_y_radius")
    private float newBlurImplYRadius;

    @SerializedName("use_new_blur_impl")
    private boolean useNewBlurImpl;

    public LiveHazyFrameConfig() {
        this.enablePreview = true;
    }

    public final boolean getDisableDefaultBackground() {
        return this.disableDefaultBackground;
    }

    public final boolean getDisableDimBackgroundCover() {
        return this.disableDimBackgroundCover;
    }

    public final boolean getEnableClientBlur() {
        return this.enableClientBlur;
    }

    public final boolean getEnableInner() {
        return this.enableInner;
    }

    public final boolean getEnablePreview() {
        return this.enablePreview;
    }

    public final boolean getEnablePreviewDrawProcessor() {
        return this.enablePreviewDrawProcessor;
    }

    public final boolean getEnableSmoothEnter() {
        return this.enableSmoothEnter;
    }

    public final boolean getImageDecodeOpt() {
        return this.imageDecodeOpt;
    }

    public final float getNewBlurImplXRadius() {
        return this.newBlurImplXRadius;
    }

    public final float getNewBlurImplYRadius() {
        return this.newBlurImplYRadius;
    }

    public final boolean getUseNewBlurImpl() {
        return this.useNewBlurImpl;
    }

    public final void setDisableDefaultBackground(boolean r100) {
        this.disableDefaultBackground = r100;
    }

    public final void setDisableDimBackgroundCover(boolean r100) {
        this.disableDimBackgroundCover = r100;
    }

    public final void setEnableClientBlur(boolean r100) {
        this.enableClientBlur = r100;
    }

    public final void setEnableInner(boolean r100) {
        this.enableInner = r100;
    }

    public final void setEnablePreview(boolean r100) {
        this.enablePreview = r100;
    }

    public final void setEnablePreviewDrawProcessor(boolean r100) {
        this.enablePreviewDrawProcessor = r100;
    }

    public final void setEnableSmoothEnter(boolean r100) {
        this.enableSmoothEnter = r100;
    }

    public final void setImageDecodeOpt(boolean r100) {
        this.imageDecodeOpt = r100;
    }

    public final void setNewBlurImplXRadius(float r100) {
        this.newBlurImplXRadius = r100;
    }

    public final void setNewBlurImplYRadius(float r100) {
        this.newBlurImplYRadius = r100;
    }

    public final void setUseNewBlurImpl(boolean r100) {
        this.useNewBlurImpl = r100;
    }
}
