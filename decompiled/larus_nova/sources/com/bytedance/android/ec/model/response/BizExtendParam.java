package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/BizExtendParam;", "Ljava/io/Serializable;", "()V", "checkCallback", "", "getCheckCallback", "()Ljava/lang/String;", "setCheckCallback", "(Ljava/lang/String;)V", "detailCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDetailCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setDetailCover", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "dynamicRecommendIndex", "", "getDynamicRecommendIndex", "()Ljava/lang/Integer;", "setDynamicRecommendIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "leafCategory", "getLeafCategory", "setLeafCategory", "prefetchOrder", "Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "getPrefetchOrder", "()Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "setPrefetchOrder", "(Lcom/bytedance/android/ec/model/response/PrefetchOrder;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BizExtendParam implements Serializable {

    @SerializedName("check_callback")
    private String checkCallback;

    @SerializedName("detail_cover")
    private ECUrlModel detailCover;

    @SerializedName("dynamic_recommend_index")
    private Integer dynamicRecommendIndex;

    @SerializedName("leaf_category")
    private String leafCategory;

    @SerializedName("prefetch_order")
    private PrefetchOrder prefetchOrder;

    public BizExtendParam() {
    }

    public final String getCheckCallback() {
        return this.checkCallback;
    }

    public final ECUrlModel getDetailCover() {
        return this.detailCover;
    }

    public final Integer getDynamicRecommendIndex() {
        return this.dynamicRecommendIndex;
    }

    public final String getLeafCategory() {
        return this.leafCategory;
    }

    public final PrefetchOrder getPrefetchOrder() {
        return this.prefetchOrder;
    }

    public final void setCheckCallback(String r100) {
        this.checkCallback = r100;
    }

    public final void setDetailCover(ECUrlModel r100) {
        this.detailCover = r100;
    }

    public final void setDynamicRecommendIndex(Integer r100) {
        this.dynamicRecommendIndex = r100;
    }

    public final void setLeafCategory(String r100) {
        this.leafCategory = r100;
    }

    public final void setPrefetchOrder(PrefetchOrder r100) {
        this.prefetchOrder = r100;
    }
}
