package com.bytedance.android.shopping.sku.params.schema;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", "combinationId", "", "getCombinationId", "()Ljava/lang/String;", "hotSaleSkuId", "getHotSaleSkuId", "isMulti", "", "()Ljava/lang/Boolean;", "productId", "getProductId", "promotionId", "getPromotionId", "promotionSource", "", "getPromotionSource", "()Ljava/lang/Long;", "shopId", "getShopId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuProductInfo extends SkuSchemaMapParam {
    public SkuProductInfo() {
        super("product_info");
    }

    public final Long getPromotionSource() {
        return getLong(PdpOpenThirdParam.KEY_PROMOTION_SOURCE);
    }

    public final String getCombinationId() {
        Object r100 = getMap().get(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID);
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getHotSaleSkuId() {
        Object r100 = getMap().get("hot_sale_sku_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getProductId() {
        Object r100 = getMap().get("product_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getPromotionId() {
        Object r100 = getMap().get("promotion_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getShopId() {
        Object r100 = getMap().get(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final Boolean isMulti() {
        Object r100 = getMap().get("is_multi");
        if ((r100 instanceof Boolean) == true) goto L6;
        r100 = null;
    L6:
        return (Boolean) r100;
    }
}
