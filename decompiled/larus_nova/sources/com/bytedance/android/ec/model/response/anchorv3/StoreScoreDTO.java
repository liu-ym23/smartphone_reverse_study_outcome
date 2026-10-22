package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/StoreScoreDTO;", "Ljava/io/Serializable;", "()V", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "", "getPercentage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "rating", "", "getRating", "()Ljava/lang/String;", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScore", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class StoreScoreDTO implements Serializable {

    @SerializedName(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE)
    private final Double percentage;

    @SerializedName("rating")
    private final String rating;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final Double score;

    public StoreScoreDTO() {
    }

    public final Double getPercentage() {
        return this.percentage;
    }

    public final String getRating() {
        return this.rating;
    }

    public final Double getScore() {
        return this.score;
    }
}
