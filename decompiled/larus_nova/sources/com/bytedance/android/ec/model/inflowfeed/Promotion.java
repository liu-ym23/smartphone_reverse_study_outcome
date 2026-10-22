package com.bytedance.android.ec.model.inflowfeed;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\t\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "Ljava/io/Serializable;", "()V", "coverTag", "", "getCoverTag", "()Ljava/lang/String;", "id", "getId", "isCurrentInLive", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "link", "getLink", "promotionInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotionInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setPromotionInfo", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "recReason", "Lcom/bytedance/android/ec/model/inflowfeed/RecReasonStruct;", "getRecReason", "()Lcom/bytedance/android/ec/model/inflowfeed/RecReasonStruct;", "recommendInfo", "getRecommendInfo", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class Promotion implements Serializable {

    @SerializedName("cover_tag")
    private final String coverTag;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f47870id;

    @SerializedName("is_current_in_live")
    private final Boolean isCurrentInLive;

    @SerializedName("link")
    private final String link;

    @SerializedName("promotion_info")
    private PromotionProductStruct promotionInfo;

    @SerializedName("rec_reason")
    private final RecReasonStruct recReason;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    public Promotion() {
    }

    public final String getCoverTag() {
        return this.coverTag;
    }

    public final String getId() {
        return this.f47870id;
    }

    public final String getLink() {
        return this.link;
    }

    public final PromotionProductStruct getPromotionInfo() {
        return this.promotionInfo;
    }

    public final RecReasonStruct getRecReason() {
        return this.recReason;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final Boolean isCurrentInLive() {
        return this.isCurrentInLive;
    }

    public final void setPromotionInfo(PromotionProductStruct r100) {
        this.promotionInfo = r100;
    }
}
