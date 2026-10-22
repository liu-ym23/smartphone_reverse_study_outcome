package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class RankInfoList {

    @SerializedName("url")
    private List<String> moreAnchorUrls;

    public RankInfoList() {
    }

    public List<String> getMoreAnchorUrls() {
        return this.moreAnchorUrls;
    }
}
