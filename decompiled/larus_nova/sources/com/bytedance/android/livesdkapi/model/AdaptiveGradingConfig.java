package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00103\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001e\u0010'\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001e\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001e\u0010-\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001e\u00100\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingConfig;", "", "()V", "enableDraw", "", "getEnableDraw", "()Z", "setEnableDraw", "(Z)V", "enableFloatWindow", "getEnableFloatWindow", "setEnableFloatWindow", "enablePreview", "getEnablePreview", "setEnablePreview", "gopTime", "", "getGopTime", "()I", "setGopTime", "(I)V", "targetBrightness", "getTargetBrightness", "setTargetBrightness", "targetContrast", "getTargetContrast", "setTargetContrast", "targetSaturation", "getTargetSaturation", "setTargetSaturation", "thresholdEndBrightness", "", "getThresholdEndBrightness", "()F", "setThresholdEndBrightness", "(F)V", "thresholdEndContrast", "getThresholdEndContrast", "setThresholdEndContrast", "thresholdEndSaturation", "getThresholdEndSaturation", "setThresholdEndSaturation", "thresholdStartBrightness", "getThresholdStartBrightness", "setThresholdStartBrightness", "thresholdStartContrast", "getThresholdStartContrast", "setThresholdStartContrast", "thresholdStartSaturation", "getThresholdStartSaturation", "setThresholdStartSaturation", "enable", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdaptiveGradingConfig {

    @SerializedName("enable_draw")
    private boolean enableDraw;

    @SerializedName("enable_float_window")
    private boolean enableFloatWindow;

    @SerializedName("enable_preview")
    private boolean enablePreview;

    @SerializedName("gop_time")
    private int gopTime;

    @SerializedName("target_brightness")
    private int targetBrightness;

    @SerializedName("target_contrast")
    private int targetContrast;

    @SerializedName("target_saturation")
    private int targetSaturation;

    @SerializedName("threshold_end_brightness")
    private float thresholdEndBrightness;

    @SerializedName("threshold_end_contrast")
    private float thresholdEndContrast;

    @SerializedName("threshold_end_saturation")
    private float thresholdEndSaturation;

    @SerializedName("threshold_start_brightness")
    private float thresholdStartBrightness;

    @SerializedName("threshold_start_contrast")
    private float thresholdStartContrast;

    @SerializedName("threshold_start_saturation")
    private float thresholdStartSaturation;

    public final boolean enable() {
        if (this.enablePreview == false) goto L5;
    L10:
        return true;
    L5:
        if (this.enableDraw == true) goto L10;
        if (this.enableFloatWindow == true) goto L10;
        return false;
    }

    public AdaptiveGradingConfig() {
        this.targetBrightness = -1;
        this.targetContrast = -1;
        this.targetSaturation = -1;
        this.gopTime = 2000;
        this.thresholdStartBrightness = -0.1f;
        this.thresholdEndBrightness = 0.2f;
        this.thresholdEndContrast = 0.2f;
        this.thresholdStartSaturation = -0.2f;
        this.thresholdEndSaturation = 0.2f;
    }

    public final boolean getEnableDraw() {
        return this.enableDraw;
    }

    public final boolean getEnableFloatWindow() {
        return this.enableFloatWindow;
    }

    public final boolean getEnablePreview() {
        return this.enablePreview;
    }

    public final int getGopTime() {
        return this.gopTime;
    }

    public final int getTargetBrightness() {
        return this.targetBrightness;
    }

    public final int getTargetContrast() {
        return this.targetContrast;
    }

    public final int getTargetSaturation() {
        return this.targetSaturation;
    }

    public final float getThresholdEndBrightness() {
        return this.thresholdEndBrightness;
    }

    public final float getThresholdEndContrast() {
        return this.thresholdEndContrast;
    }

    public final float getThresholdEndSaturation() {
        return this.thresholdEndSaturation;
    }

    public final float getThresholdStartBrightness() {
        return this.thresholdStartBrightness;
    }

    public final float getThresholdStartContrast() {
        return this.thresholdStartContrast;
    }

    public final float getThresholdStartSaturation() {
        return this.thresholdStartSaturation;
    }

    public final void setEnableDraw(boolean r100) {
        this.enableDraw = r100;
    }

    public final void setEnableFloatWindow(boolean r100) {
        this.enableFloatWindow = r100;
    }

    public final void setEnablePreview(boolean r100) {
        this.enablePreview = r100;
    }

    public final void setGopTime(int r100) {
        this.gopTime = r100;
    }

    public final void setTargetBrightness(int r100) {
        this.targetBrightness = r100;
    }

    public final void setTargetContrast(int r100) {
        this.targetContrast = r100;
    }

    public final void setTargetSaturation(int r100) {
        this.targetSaturation = r100;
    }

    public final void setThresholdEndBrightness(float r100) {
        this.thresholdEndBrightness = r100;
    }

    public final void setThresholdEndContrast(float r100) {
        this.thresholdEndContrast = r100;
    }

    public final void setThresholdEndSaturation(float r100) {
        this.thresholdEndSaturation = r100;
    }

    public final void setThresholdStartBrightness(float r100) {
        this.thresholdStartBrightness = r100;
    }

    public final void setThresholdStartContrast(float r100) {
        this.thresholdStartContrast = r100;
    }

    public final void setThresholdStartSaturation(float r100) {
        this.thresholdStartSaturation = r100;
    }
}
