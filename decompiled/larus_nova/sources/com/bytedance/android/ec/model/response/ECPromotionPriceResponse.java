package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionPriceResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/model/response/PromotionPriceInfo;", "priceInfoList", "Ljava/util/List;", "getPriceInfoList", "()Ljava/util/List;", "setPriceInfoList", "(Ljava/util/List;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionPriceResponse extends com.bytedance.android.ec.model.g implements Serializable {

    @SerializedName("promotion_price_info_list")
    private List<PromotionPriceInfo> priceInfoList;

    public ECPromotionPriceResponse() {
    }

    public final List<PromotionPriceInfo> getPriceInfoList() {
        return this.priceInfoList;
    }

    public final void setPriceInfoList(List<PromotionPriceInfo> r100) {
        this.priceInfoList = r100;
    }
}
