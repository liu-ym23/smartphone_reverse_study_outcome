package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import j63.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/GuessULikeResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", EffectConfiguration.KEY_CURSOR, "I", "getCursor", "()I", "", "Lj63/c;", "productList", "Ljava/util/List;", "getProductList", "()Ljava/util/List;", "", "hasMore", "Z", "getHasMore", "()Z", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/GuessULikeExtraInfo;", "extra", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/GuessULikeExtraInfo;", "getExtra", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/GuessULikeExtraInfo;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeResponseDTO extends CommerceBaseResponse {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final int cursor;

    @SerializedName("extra")
    private final GuessULikeExtraInfo extra;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    @SerializedName("item_cards")
    private final List<c> productList;

    public GuessULikeResponseDTO() {
        this.productList = CollectionsKt.emptyList();
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final GuessULikeExtraInfo getExtra() {
        return this.extra;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final List<c> getProductList() {
        return this.productList;
    }
}
