package com.bytedance.android.live.base.model.user;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class AuthorReputation {

    @SerializedName("level")
    int level;

    @SerializedName("percent")
    String percent;

    @SerializedName("recommend_count")
    String recommendCount;

    @SerializedName(SalesInfoStruct.SALES)
    String sales;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    double score;

    @SerializedName("text")
    String text;

    public AuthorReputation() {
    }

    public int getLevel() {
        return this.level;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getRecommendCount() {
        return this.recommendCount;
    }

    public String getSales() {
        return this.sales;
    }

    public double getScore() {
        return this.score;
    }

    public String getText() {
        return this.text;
    }
}
