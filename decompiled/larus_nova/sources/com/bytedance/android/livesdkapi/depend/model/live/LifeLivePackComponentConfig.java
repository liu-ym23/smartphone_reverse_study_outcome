package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LifeLivePackComponentConfig;", "", "()V", "firstMeetEffectiveType", "", "getFirstMeetEffectiveType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "randomStrategyParams", "Lcom/bytedance/android/livesdkapi/depend/model/live/RandomStrategyParams;", "getRandomStrategyParams", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RandomStrategyParams;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifeLivePackComponentConfig {

    @SerializedName("first_meet_effective_type")
    private final Integer firstMeetEffectiveType;

    @SerializedName("random_strategy_params")
    private final RandomStrategyParams randomStrategyParams;

    public LifeLivePackComponentConfig() {
    }

    public final Integer getFirstMeetEffectiveType() {
        return this.firstMeetEffectiveType;
    }

    public final RandomStrategyParams getRandomStrategyParams() {
        return this.randomStrategyParams;
    }
}
