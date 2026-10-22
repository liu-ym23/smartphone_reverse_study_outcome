package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.t;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSearchHint;", "Ljava/io/Serializable;", "", "hintText", "Ljava/lang/String;", "getHintText", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "tagIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTagIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/model/live/t;", "showTrackInfo", "Lcom/bytedance/android/ec/model/live/t;", "getShowTrackInfo", "()Lcom/bytedance/android/ec/model/live/t;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionSearchHint implements Serializable {

    @SerializedName("hint_text")
    private final String hintText;

    @SerializedName("show_track_info")
    private final t showTrackInfo;

    @SerializedName("tag_icon")
    private final ECUrlModel tagIcon;

    public ECPromotionSearchHint() {
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final t getShowTrackInfo() {
        return this.showTrackInfo;
    }

    public final ECUrlModel getTagIcon() {
        return this.tagIcon;
    }
}
