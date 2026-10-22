package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "Ljava/io/Serializable;", "()V", "level", "", "getLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "percent", "", "getPercent", "()Ljava/lang/String;", SalesInfoStruct.SALES, "getSales", "salesText", "", "getSalesText", "()Ljava/util/List;", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "scoreNormalText", "getScoreNormalText", "text", "getText", "title", "getTitle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AuthorReputationDTO implements Serializable {

    @SerializedName("level")
    private final Integer level;

    @SerializedName("percent")
    private final String percent;

    @SerializedName(SalesInfoStruct.SALES)
    private final String sales;

    @SerializedName("sales_text")
    private final List<String> salesText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final Double score;

    @SerializedName("score_normal_text")
    private final String scoreNormalText;

    @SerializedName("text")
    private final String text;

    @SerializedName("title")
    private final String title;

    public AuthorReputationDTO() {
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final String getPercent() {
        return this.percent;
    }

    public final String getSales() {
        return this.sales;
    }

    public final List<String> getSalesText() {
        return this.salesText;
    }

    public final Double getScore() {
        return this.score;
    }

    public final String getScoreNormalText() {
        return this.scoreNormalText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }
}
