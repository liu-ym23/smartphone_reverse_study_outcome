package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class GiftExhibitionHomeStats {

    @SerializedName("lighted_num")
    public int lightedNum;

    @SerializedName("unlighted_num")
    public int unlightedNum;

    @SerializedName("exhibition_entrance_url")
    public String url;

    public GiftExhibitionHomeStats() {
        this.url = "";
    }
}
