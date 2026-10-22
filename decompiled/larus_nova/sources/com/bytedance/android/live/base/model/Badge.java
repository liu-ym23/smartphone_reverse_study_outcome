package com.bytedance.android.live.base.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class Badge {

    @SerializedName("icon")
    private ImageModel icon;

    @SerializedName("small_icon")
    private ImageModel smallIcon;

    @SerializedName("title")
    private String title;

    public Badge() {
    }

    public ImageModel getIcon() {
        return this.icon;
    }

    public ImageModel getSmallIcon() {
        return this.smallIcon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    public void setSmallIcon(ImageModel r100) {
        this.smallIcon = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
