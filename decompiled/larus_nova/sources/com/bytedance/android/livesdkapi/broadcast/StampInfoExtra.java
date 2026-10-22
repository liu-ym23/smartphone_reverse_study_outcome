package com.bytedance.android.livesdkapi.broadcast;

import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class StampInfoExtra {

    @SerializedName("can_modify_cover")
    public boolean can_modify_cover;

    @SerializedName("customized_cover")
    public ImageModel customized_cover;

    @SerializedName("customized_cover_uri")
    public String customized_cover_uri;

    @SerializedName("from_review")
    public boolean from_review;

    @SerializedName("review_status")
    public int review_status;

    public StampInfoExtra() {
        this.review_status = 0;
        this.customized_cover_uri = "";
        this.customized_cover = null;
        this.can_modify_cover = true;
        this.from_review = false;
    }
}
