package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes8.dex */
public class s1 {

    @SerializedName("action_title")
    public String actionTitle;

    @SerializedName("describe")
    public String describe;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    public String imgUrl;

    @SerializedName("key")
    public String key;

    @SerializedName("sources")
    public String[] sources;

    @SerializedName("title")
    public String title;

    public s1() {
    }
}
