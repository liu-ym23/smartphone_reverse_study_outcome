package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class r0 {

    @SerializedName("fold_screen_fit_resolution")
    public boolean foldScreenFitResolution;

    @SerializedName("font_size")
    public int fontSize;

    @SerializedName("font_size_fit_resolution")
    public boolean fontSizeFitResolution;

    @SerializedName("item_gap_fit_resolution")
    public boolean itemGapFitResolution;

    @SerializedName("item_vertical_padding_dp")
    public int itemVerticalPaddingDp;

    @SerializedName("max_resolution_fit_scale")
    public float maxResolutionFitScale;

    @SerializedName("min_resolution_fit_scale")
    public float minResolutionFitScale;

    @SerializedName("pad_base_resolution_width_dp")
    public float padBaseResolutionWidthDp;

    @SerializedName("phone_base_resolution_width_dp")
    public float phoneBaseResolutionWidthDp;

    public r0() {
        this.itemVerticalPaddingDp = 3;
        this.fontSizeFitResolution = false;
        this.itemGapFitResolution = false;
        this.foldScreenFitResolution = true;
        this.maxResolutionFitScale = 1.2f;
        this.minResolutionFitScale = 0.9f;
        this.phoneBaseResolutionWidthDp = 375.0f;
        this.padBaseResolutionWidthDp = 1024.0f;
        this.fontSize = 14;
    }
}
