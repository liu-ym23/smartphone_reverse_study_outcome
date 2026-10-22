package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageCategoryData;", "Ljava/io/Serializable;", "()V", ReportCardMonitorPlugin.CATEGORIES, "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "showCategoryProductCount", "", "getShowCategoryProductCount", "()I", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionPageCategoryData implements Serializable {

    @SerializedName(ReportCardMonitorPlugin.CATEGORIES)
    private List<PromotionCategory> categories;

    @SerializedName("show_category_product_count")
    private final int showCategoryProductCount;

    public LivePromotionPageCategoryData() {
        this.showCategoryProductCount = 4;
    }

    public final List<PromotionCategory> getCategories() {
        return this.categories;
    }

    public final int getShowCategoryProductCount() {
        return this.showCategoryProductCount;
    }

    public final void setCategories(List<PromotionCategory> r100) {
        this.categories = r100;
    }
}
