package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.BaseInfo;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.CombinationComponent;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.ImageComponent;
import com.bytedance.android.shopping.threed.repository.dto.BuyButtonComponent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchasePageComponentDTO;", "Ljava/io/Serializable;", "()V", "baseInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/BaseInfo;", "getBaseInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/BaseInfo;", "buyButtonComponent", "Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "getBuyButtonComponent", "()Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "imageComponent", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;", "getImageComponent", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;", "productItems", "", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationComponent;", "getProductItems", "()Ljava/util/List;", "shopComponent", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/ShopComponent;", "getShopComponent", "()Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/ShopComponent;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchasePageComponentDTO implements Serializable {

    @SerializedName("base_info")
    private final BaseInfo baseInfo;

    @SerializedName("buy_button_component")
    private final BuyButtonComponent buyButtonComponent;

    @SerializedName("image_component")
    private final ImageComponent imageComponent;

    @SerializedName("product_items")
    private final List<CombinationComponent> productItems;

    @SerializedName("shop_component")
    private final ShopComponent shopComponent;

    public MatchPurchasePageComponentDTO() {
    }

    public final BaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public final BuyButtonComponent getBuyButtonComponent() {
        return this.buyButtonComponent;
    }

    public final ImageComponent getImageComponent() {
        return this.imageComponent;
    }

    public final List<CombinationComponent> getProductItems() {
        return this.productItems;
    }

    public final ShopComponent getShopComponent() {
        return this.shopComponent;
    }
}
