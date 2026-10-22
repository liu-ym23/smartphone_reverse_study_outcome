package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionShopCommentStruct;", "Ljava/io/Serializable;", "()V", "goodCount", "", "getGoodCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "praiseRate", "getPraiseRate", "shopCommentTags", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentTagStruct;", "getShopCommentTags", "()Ljava/util/List;", "totalCount", "getTotalCount", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionShopCommentStruct implements Serializable {

    @SerializedName("good_count")
    private final Long goodCount;

    @SerializedName("praise_rate")
    private final Long praiseRate;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<PromotionProductCommentTagStruct> shopCommentTags;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private final Long totalCount;

    public PromotionShopCommentStruct() {
    }

    public final Long getGoodCount() {
        return this.goodCount;
    }

    public final Long getPraiseRate() {
        return this.praiseRate;
    }

    public final List<PromotionProductCommentTagStruct> getShopCommentTags() {
        return this.shopCommentTags;
    }

    public final Long getTotalCount() {
        return this.totalCount;
    }
}
