package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerTextureRenderConfig {
    public static final PlayerTextureRenderConfig DEFAULT = null;

    @SerializedName("enable_custom")
    public boolean enableCustom;

    @SerializedName("enable_dynamic_open")
    public boolean enableDynamicOpen;

    @SerializedName("disable_feed_audio")
    public boolean mDisableFeedAudio;

    @SerializedName("disable_feed_media")
    public boolean mDisableFeedMedia;

    @SerializedName("disable_feed_other")
    public boolean mDisableFeedOther;

    @SerializedName("disable_feed_screen_record")
    public boolean mDisableFeedScreenRecord;

    @SerializedName("disable_feed_vs")
    public boolean mDisableFeedVS;

    @SerializedName("disable_feed_video")
    public boolean mDisableFeedVideo;

    @SerializedName("disable_inner_normal")
    public boolean mDisableInnerNormal;

    @SerializedName("disable_inner_prepull")
    public boolean mDisableInnerPrePull;

    @SerializedName("disable_preview")
    public boolean mDisablePreView;

    @SerializedName("disable_shared_scene")
    public boolean mDisableShared;

    static {
        DEFAULT = new PlayerTextureRenderConfig();
    }

    public PlayerTextureRenderConfig() {
        this.enableCustom = true;
    }
}
