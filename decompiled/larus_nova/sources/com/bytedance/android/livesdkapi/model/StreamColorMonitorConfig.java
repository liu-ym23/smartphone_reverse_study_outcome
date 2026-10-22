package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;

/* JADX INFO: loaded from: classes12.dex */
public class StreamColorMonitorConfig {

    @SerializedName(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_BRIGHTNESS_THRESHOLD)
    public float mBrightnessThreshold;

    @SerializedName(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CONTRAST_THRESHOLD)
    public float mContrastThreshold;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SATURATION_THRESHOLD)
    public float mSaturationThreshold;

    public StreamColorMonitorConfig() {
    }
}
