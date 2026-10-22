package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/core/feature/VqscoreOnlineStage;", "", "()V", "effect", "Lcom/bytedance/android/live/core/feature/VqscoreEffect;", "getEffect", "()Lcom/bytedance/android/live/core/feature/VqscoreEffect;", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "getScore", "()D", "type", "", "getType", "()Ljava/lang/String;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VqscoreOnlineStage {

    @SerializedName("effect")
    private final VqscoreEffect effect;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final double score;

    @SerializedName("type")
    private final String type;

    public VqscoreOnlineStage() {
        this.type = "";
        this.score = -1.0d;
    }

    public final VqscoreEffect getEffect() {
        return this.effect;
    }

    public final double getScore() {
        return this.score;
    }

    public final String getType() {
        return this.type;
    }
}
