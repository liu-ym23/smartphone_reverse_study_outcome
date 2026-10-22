package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionListABConfig;", "Ljava/io/Serializable;", "()V", "addCartOpt", "", "getAddCartOpt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "addCartToastOrder", "getAddCartToastOrder", "()I", "headerStoreMerge", "getHeaderStoreMerge", "listProductCardStyle", "getListProductCardStyle", "liteListStyle", "getLiteListStyle", "shortenedBuyNowButton", "getShortenedBuyNowButton", "showAuthorConnect", "getShowAuthorConnect", "storeMergeSlideZone", "getStoreMergeSlideZone", "storeSchema", "", "getStoreSchema", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListABConfig implements Serializable {

    @SerializedName("show_cart_num")
    private final Integer addCartOpt;

    @SerializedName("add_cart_toast_order")
    private final int addCartToastOrder;

    @SerializedName("header_store_merge")
    private final int headerStoreMerge;

    @SerializedName("list_product_card_style")
    private final int listProductCardStyle;

    @SerializedName("lite_list_style")
    private final Integer liteListStyle;

    @SerializedName("shortened_buy_now_button")
    private final int shortenedBuyNowButton;

    @SerializedName("show_author_connect")
    private final int showAuthorConnect;

    @SerializedName("store_merge_slide_zone")
    private final int storeMergeSlideZone;

    @SerializedName("store_schema")
    private final String storeSchema;

    public LivePromotionListABConfig() {
    }

    public final Integer getAddCartOpt() {
        return this.addCartOpt;
    }

    public final int getAddCartToastOrder() {
        return this.addCartToastOrder;
    }

    public final int getHeaderStoreMerge() {
        return this.headerStoreMerge;
    }

    public final int getListProductCardStyle() {
        return this.listProductCardStyle;
    }

    public final Integer getLiteListStyle() {
        return this.liteListStyle;
    }

    public final int getShortenedBuyNowButton() {
        return this.shortenedBuyNowButton;
    }

    public final int getShowAuthorConnect() {
        return this.showAuthorConnect;
    }

    public final int getStoreMergeSlideZone() {
        return this.storeMergeSlideZone;
    }

    public final String getStoreSchema() {
        return this.storeSchema;
    }
}
