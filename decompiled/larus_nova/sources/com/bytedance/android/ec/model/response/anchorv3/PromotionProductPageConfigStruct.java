package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPageConfigStruct;", "Ljava/io/Serializable;", "()V", "disPlayCollectIcon", "", "getDisPlayCollectIcon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "displayDiscount", "getDisplayDiscount", "()Z", "setDisplayDiscount", "(Z)V", "displayGyl", "getDisplayGyl", "displayStoreIcon", "getDisplayStoreIcon", "purchaseQualification", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductPurchaseQualification;", "getPurchaseQualification", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductPurchaseQualification;", "setCartGray", "getSetCartGray", "shoppingCart", "getShoppingCart", "showShareIcon", "getShowShareIcon", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductPageConfigStruct implements Serializable {

    @SerializedName("display_want")
    private final Boolean disPlayCollectIcon;

    @SerializedName("display_discount")
    private boolean displayDiscount;

    @SerializedName("display_gyl")
    private final Boolean displayGyl;

    @SerializedName("store_icon")
    private final Boolean displayStoreIcon;

    @SerializedName("campaign_purchase_qualification")
    private final ProductPurchaseQualification purchaseQualification;

    @SerializedName("set_cart_gray")
    private final boolean setCartGray;

    @SerializedName("shopping_cart")
    private final boolean shoppingCart;

    @SerializedName("share_icon")
    private final boolean showShareIcon;

    public PromotionProductPageConfigStruct() {
        this.displayDiscount = true;
    }

    public final Boolean getDisPlayCollectIcon() {
        return this.disPlayCollectIcon;
    }

    public final boolean getDisplayDiscount() {
        return this.displayDiscount;
    }

    public final Boolean getDisplayGyl() {
        return this.displayGyl;
    }

    public final Boolean getDisplayStoreIcon() {
        return this.displayStoreIcon;
    }

    public final ProductPurchaseQualification getPurchaseQualification() {
        return this.purchaseQualification;
    }

    public final boolean getSetCartGray() {
        return this.setCartGray;
    }

    public final boolean getShoppingCart() {
        return this.shoppingCart;
    }

    public final boolean getShowShareIcon() {
        return this.showShareIcon;
    }

    public final void setDisplayDiscount(boolean r100) {
        this.displayDiscount = r100;
    }
}
