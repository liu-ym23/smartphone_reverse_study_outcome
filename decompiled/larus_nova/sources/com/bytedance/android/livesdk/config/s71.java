package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class s71 {

    @SerializedName("arrow_icon")
    public a arrow_icon;

    @SerializedName("disable_after_press")
    public boolean disable_after_press;

    @SerializedName("guide_style")
    public int guide_style;

    @SerializedName("intent_reco_type")
    public int intent_reco_type;

    @SerializedName("limit_per_day")
    public int limit_per_day;

    @SerializedName("limit_per_launch")
    public int limit_per_launch;

    @SerializedName("pop_guide_text")
    public String pop_guide_text;

    @SerializedName("pop_show_duration")
    public int pop_show_duration;

    @SerializedName("position")
    public int position;

    @SerializedName("sweep_times")
    public int sweep_times;

    public static class a {

        @SerializedName("height")
        public int height;

        @SerializedName("url")
        public String url;

        @SerializedName("width")
        public int width;

        public a() {
        }
    }

    public s71() {
    }
}
