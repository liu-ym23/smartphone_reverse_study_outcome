package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RandomStrategyParams;", "", "()V", "maxRandomMS", "", "getMaxRandomMS", "()Ljava/lang/Long;", "Ljava/lang/Long;", "minRandomMS", "getMinRandomMS", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RandomStrategyParams {

    @SerializedName("max_random_ms")
    private final Long maxRandomMS;

    @SerializedName("min_random_ms")
    private final Long minRandomMS;

    public RandomStrategyParams() {
    }

    public final Long getMaxRandomMS() {
        return this.maxRandomMS;
    }

    public final Long getMinRandomMS() {
        return this.minRandomMS;
    }
}
