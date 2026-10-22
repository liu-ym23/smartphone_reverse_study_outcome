package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/HamletExternalRenderConfig;", "", "()V", "brightness", "", "getBrightness", "()F", "setBrightness", "(F)V", "contrast", "getContrast", "setContrast", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "sharpness", "getSharpness", "setSharpness", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HamletExternalRenderConfig {

    @SerializedName("brightness")
    private float brightness;

    @SerializedName("contrast")
    private float contrast;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("sharpness")
    private float sharpness;

    public HamletExternalRenderConfig() {
        this.enable = true;
        this.sharpness = 0.5f;
        this.contrast = 1.2f;
        this.brightness = 0.035f;
    }

    public final float getBrightness() {
        return this.brightness;
    }

    public final float getContrast() {
        return this.contrast;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getSharpness() {
        return this.sharpness;
    }

    public final void setBrightness(float r100) {
        this.brightness = r100;
    }

    public final void setContrast(float r100) {
        this.contrast = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setSharpness(float r100) {
        this.sharpness = r100;
    }
}
