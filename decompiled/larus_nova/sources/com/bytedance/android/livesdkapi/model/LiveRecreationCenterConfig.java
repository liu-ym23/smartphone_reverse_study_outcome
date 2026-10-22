package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class LiveRecreationCenterConfig {

    @SerializedName("bubble_text")
    private String bubble;

    @SerializedName("bubble_duration")
    private long bubbleDuration;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("item_list")
    private List<RecreationItem> recreationItem;

    public LiveRecreationCenterConfig() {
    }

    public String getBubble() {
        return this.bubble;
    }

    public long getBubbleDuration() {
        return this.bubbleDuration;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public List<RecreationItem> getRecreationItem() {
        return this.recreationItem;
    }
}
