package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReplayInfo;", "Ljava/io/Serializable;", "()V", "newReplayStyle", "", "getNewReplayStyle", "()Z", "replayIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getReplayIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "replayTipText", "", "getReplayTipText", "()Ljava/lang/String;", "replayUrl", "getReplayUrl", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionReplayInfo implements Serializable {

    @SerializedName("hit_new_replay_style")
    private final boolean newReplayStyle;

    @SerializedName("replay_icon")
    private final ECUrlModel replayIcon;

    @SerializedName("replay_text")
    private final String replayTipText;

    @SerializedName("replay_url")
    private final String replayUrl;

    public PromotionReplayInfo() {
    }

    public final boolean getNewReplayStyle() {
        return this.newReplayStyle;
    }

    public final ECUrlModel getReplayIcon() {
        return this.replayIcon;
    }

    public final String getReplayTipText() {
        return this.replayTipText;
    }

    public final String getReplayUrl() {
        return this.replayUrl;
    }
}
