package com.bytedance.android.live.profile.api.setting.models;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes47.dex */
public class ProfileLoginGuideConfig {

    @SerializedName("from_follow")
    private String fromFollow;

    @SerializedName("image_url_from_follow")
    private String imageUrlFromFollow;

    public ProfileLoginGuideConfig() {
    }

    public String getFromFollow() {
        return this.fromFollow;
    }

    public String getImageUrlFromFollow() {
        return this.imageUrlFromFollow;
    }

    public void setFromFollow(String r100) {
        this.fromFollow = r100;
    }

    public void setImageUrlFromFollow(String r100) {
        this.imageUrlFromFollow = r100;
    }
}
