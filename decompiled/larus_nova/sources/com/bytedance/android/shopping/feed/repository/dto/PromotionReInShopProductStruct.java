package com.bytedance.android.shopping.feed.repository.dto;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/PromotionReInShopProductStruct;", "Ljava/io/Serializable;", "()V", "imageMonitorMeta", "Lcom/bytedance/android/shopping/feed/repository/dto/ImageMonitorMeta;", "getImageMonitorMeta", "()Lcom/bytedance/android/shopping/feed/repository/dto/ImageMonitorMeta;", "setImageMonitorMeta", "(Lcom/bytedance/android/shopping/feed/repository/dto/ImageMonitorMeta;)V", "images", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImages", "()Ljava/util/List;", "productId", "", "getProductId", "()Ljava/lang/String;", SalesInfoStruct.SALES, "", "getSales", "()Ljava/lang/Long;", "setSales", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "shopId", "", "getShopId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "title", "getTitle", d.f25925o, "(Ljava/lang/String;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionReInShopProductStruct implements Serializable {
    private ImageMonitorMeta imageMonitorMeta;

    @SerializedName("images")
    private final List<ECUrlModel> images;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName(SalesInfoStruct.SALES)
    private Long sales;

    @SerializedName(a.KEY_SHOP_ID)
    private final Integer shopId;

    @SerializedName("title")
    private String title;

    public PromotionReInShopProductStruct() {
    }

    public final ImageMonitorMeta getImageMonitorMeta() {
        return this.imageMonitorMeta;
    }

    public final List<ECUrlModel> getImages() {
        return this.images;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Long getSales() {
        return this.sales;
    }

    public final Integer getShopId() {
        return this.shopId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setImageMonitorMeta(ImageMonitorMeta r100) {
        this.imageMonitorMeta = r100;
    }

    public final void setSales(Long r100) {
        this.sales = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
