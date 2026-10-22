package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/StoreExperienceDTO;", "Ljava/io/Serializable;", "()V", "hasData", "", "getHasData", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", com.bytedance.android.ec.core.event.a.KEY_SCORE, "Lcom/bytedance/android/ec/model/response/anchorv3/StoreScoreDTO;", "getScore", "()Lcom/bytedance/android/ec/model/response/anchorv3/StoreScoreDTO;", "text", "", "getText", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class StoreExperienceDTO implements Serializable {

    @SerializedName("has_data")
    private final Boolean hasData;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final StoreScoreDTO score;

    @SerializedName("text")
    private final String text;

    public StoreExperienceDTO() {
    }

    public final Boolean getHasData() {
        return this.hasData;
    }

    public final StoreScoreDTO getScore() {
        return this.score;
    }

    public final String getText() {
        return this.text;
    }
}
