package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/core/feature/DynamicDataRespItem;", "", "()V", "anchorInteraction", "", "getAnchorInteraction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "anchorLayer", "getAnchorLayer", "cae", "", "", "getCae", "()Ljava/util/Map;", "roomId", "", "getRoomId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "timeStrap", "getTimeStrap", "()J", "setTimeStrap", "(J)V", "tone", "getTone", "vqScoreData", "Lcom/bytedance/android/live/core/feature/VqscoreData;", "getVqScoreData", "()Lcom/bytedance/android/live/core/feature/VqscoreData;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicDataRespItem {

    @SerializedName("anchor_interaction")
    private final Integer anchorInteraction;

    @SerializedName("anchor_layer")
    private final Integer anchorLayer;

    @SerializedName("cae")
    private final Map<String, Object> cae;

    @SerializedName("room_id")
    private final Long roomId;
    private long timeStrap;

    @SerializedName("tone")
    private final Map<String, Object> tone;

    @SerializedName("vqscore")
    private final VqscoreData vqScoreData;

    public DynamicDataRespItem() {
    }

    public final Integer getAnchorInteraction() {
        return this.anchorInteraction;
    }

    public final Integer getAnchorLayer() {
        return this.anchorLayer;
    }

    public final Map<String, Object> getCae() {
        return this.cae;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public final long getTimeStrap() {
        return this.timeStrap;
    }

    public final Map<String, Object> getTone() {
        return this.tone;
    }

    public final VqscoreData getVqScoreData() {
        return this.vqScoreData;
    }

    public final void setTimeStrap(long r100) {
        this.timeStrap = r100;
    }
}
