package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class VisitorStatistic {

    @SerializedName("last_visitor_count")
    @IgnoreProtoDecode
    public long lastVisitorCount;

    @SerializedName("visitor_count")
    @IgnoreProtoDecode
    public long visitorCount;

    public VisitorStatistic() {
        this.visitorCount = 0;
        this.lastVisitorCount = 0;
    }
}
