package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/feature/VqscoreData;", "", "()V", "offlineScore", "", "getOfflineScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "onlineScore", "Lcom/bytedance/android/live/core/feature/VqscoreOnline;", "getOnlineScore", "()Lcom/bytedance/android/live/core/feature/VqscoreOnline;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VqscoreData {

    @SerializedName("offline_score")
    private final Double offlineScore;

    @SerializedName("online_score")
    private final VqscoreOnline onlineScore;

    public VqscoreData() {
    }

    public final Double getOfflineScore() {
        return this.offlineScore;
    }

    public final VqscoreOnline getOnlineScore() {
        return this.onlineScore;
    }
}
