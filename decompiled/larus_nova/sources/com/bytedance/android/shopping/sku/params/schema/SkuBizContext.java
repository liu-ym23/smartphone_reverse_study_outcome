package com.bytedance.android.shopping.sku.params.schema;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u0013\u0010 \u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b#\u0010\u0006R\u0013\u0010$\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\u0006R\u0013\u0010&\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b'\u0010\u0006¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()Ljava/lang/String;", "authorId", "getAuthorId", "bizIdentifier", "getBizIdentifier", "carId", "getCarId", "detailUrl", "getDetailUrl", "foodTakeoutCustomPropertyList", "getFoodTakeoutCustomPropertyList", "foodTakeoutSalePackageList", "getFoodTakeoutSalePackageList", "hotSaleType", "", "getHotSaleType", "()Ljava/lang/Integer;", "isGroupBuy", "", "()Ljava/lang/Boolean;", "itemId", "getItemId", "nGroupBuyToken", "getNGroupBuyToken", "orderUrl", "getOrderUrl", "roomId", "getRoomId", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "getSceneType", "secAuthorId", "getSecAuthorId", "skuId", "getSkuId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBizContext extends SkuSchemaMapParam {
    public SkuBizContext() {
        super("biz_context");
    }

    public final Integer getHotSaleType() {
        return getInt("hot_sale_type");
    }

    public final String getActionType() {
        Object r100 = getMap().get("action_type");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getAuthorId() {
        Object r100 = getMap().get("author_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getBizIdentifier() {
        Object r100 = getMap().get("biz_identifier");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getCarId() {
        Object r100 = getMap().get("car_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getDetailUrl() {
        Object r100 = getMap().get("detail_url");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getFoodTakeoutCustomPropertyList() {
        Object r100 = getMap().get("custom_property_list");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getFoodTakeoutSalePackageList() {
        Object r100 = getMap().get("sale_package_list");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getItemId() {
        Object r100 = getMap().get("item_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getNGroupBuyToken() {
        Object r100 = getMap().get("ngroup_buy_token");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getOrderUrl() {
        Object r100 = getMap().get("order_url");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getRoomId() {
        Object r100 = getMap().get(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID);
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getSceneType() {
        Object r100 = getMap().get("scene_type");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getSecAuthorId() {
        Object r100 = getMap().get("sec_author_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getSkuId() {
        Object r100 = getMap().get(com.bytedance.android.ec.core.event.a.KEY_SKU_ID);
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final Boolean isGroupBuy() {
        Object r100 = getMap().get("is_group_buy");
        if ((r100 instanceof Boolean) == true) goto L6;
        r100 = null;
    L6:
        return (Boolean) r100;
    }
}
