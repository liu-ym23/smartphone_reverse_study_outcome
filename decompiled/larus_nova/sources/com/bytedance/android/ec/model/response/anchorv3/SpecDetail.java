package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "Ljava/io/Serializable;", "()V", "bigImgList", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBigImgList", "()Ljava/util/List;", "discountPrice", "", "getDiscountPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "effectivePrice", "getEffectivePrice", "imgList", "getImgList", "marketPrice", "getMarketPrice", "name", "", "getName", "()Ljava/lang/String;", "specDetailId", "getSpecDetailId", "()J", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SpecDetail implements Serializable {

    @SerializedName("big_img_list")
    private final List<ECUrlModel> bigImgList;

    @SerializedName("discount_price")
    private final Long discountPrice;

    @SerializedName("effective_price")
    private final Long effectivePrice;

    @SerializedName("img_list")
    private final List<ECUrlModel> imgList;

    @SerializedName("market_price")
    private final Long marketPrice;

    @SerializedName("name")
    private final String name;

    @SerializedName("spec_detail_id")
    private final long specDetailId;

    public SpecDetail() {
    }

    public final List<ECUrlModel> getBigImgList() {
        return this.bigImgList;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final Long getEffectivePrice() {
        return this.effectivePrice;
    }

    public final List<ECUrlModel> getImgList() {
        return this.imgList;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSpecDetailId() {
        return this.specDetailId;
    }
}
