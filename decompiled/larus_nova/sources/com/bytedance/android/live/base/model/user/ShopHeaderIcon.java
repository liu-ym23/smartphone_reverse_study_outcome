package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ShopHeaderIcon {

    @SerializedName("type")
    int type;

    @SerializedName("url")
    py.k url;

    public ShopHeaderIcon() {
    }

    public int getType() {
        return this.type;
    }

    public py.k getUrl() {
        return this.url;
    }
}
