package com.bytedance.android.shopping.store.shopfeed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/ShopFeedParam;", "Ljava/io/Serializable;", "()V", "bizExtra", "", "getBizExtra", "()Ljava/lang/String;", "setBizExtra", "(Ljava/lang/String;)V", "paginationParams", "getPaginationParams", "setPaginationParams", "passThroughParams", "getPassThroughParams", "setPassThroughParams", "preloadNum", "", "getPreloadNum", "()I", "setPreloadNum", "(I)V", "scene", "getScene", "setScene", "secShopId", "getSecShopId", "setSecShopId", "tabType", "getTabType", "()Ljava/lang/Integer;", "setTabType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedParam implements Serializable {

    @SerializedName("scene_biz_params")
    private String bizExtra;

    @SerializedName("pagination_params")
    private String paginationParams;

    @SerializedName("pass_through_params")
    private String passThroughParams;

    @SerializedName("preload_num")
    private int preloadNum;

    @SerializedName("scene")
    private String scene;

    @SerializedName("sec_shop_id")
    private String secShopId;

    @SerializedName("tab_type")
    private Integer tabType;

    public ShopFeedParam() {
        this.secShopId = "";
        this.passThroughParams = "";
        this.paginationParams = "";
        this.scene = "";
        this.bizExtra = "";
        this.preloadNum = 2;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }

    public final String getPaginationParams() {
        return this.paginationParams;
    }

    public final String getPassThroughParams() {
        return this.passThroughParams;
    }

    public final int getPreloadNum() {
        return this.preloadNum;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final void setBizExtra(String r100) {
        this.bizExtra = r100;
    }

    public final void setPaginationParams(String r100) {
        this.paginationParams = r100;
    }

    public final void setPassThroughParams(String r100) {
        this.passThroughParams = r100;
    }

    public final void setPreloadNum(int r100) {
        this.preloadNum = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setSecShopId(String r100) {
        this.secShopId = r100;
    }

    public final void setTabType(Integer r100) {
        this.tabType = r100;
    }
}
