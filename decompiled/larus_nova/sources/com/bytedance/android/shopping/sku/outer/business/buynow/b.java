package com.bytedance.android.shopping.sku.outer.business.buynow;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/buynow/b;", "", "", "comboNum", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Luh3/b;", "skuItem", "Luh3/b;", ce.f26396k, "()Luh3/b;", "orderUrl", "f", "promotionId", ce.f26395j, "poiId", ce.f26391f, com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, "e", "productId", "h", "promiseType", RXScreenCaptureService.KEY_INDEX, "foodTakeoutCustomPropertyList", "c", "foodTakeoutSalePackageList", "d", "", "extensionMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183049a = 0;

    @SerializedName("combo_num")
    private final String comboNum;

    @SerializedName("extension_map")
    private final Map<String, Object> extensionMap;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO)
    private final String installment;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("poi_id")
    private final String poiId;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promise_type")
    private final String promiseType;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("sku_item")
    private final uh3.b skuItem;

    public static final class a {
    }

    static {
    }

    public b() {
        this.comboNum = null;
        this.skuItem = null;
        this.orderUrl = null;
        this.promotionId = null;
        this.poiId = null;
        this.installment = null;
        this.productId = null;
        this.promiseType = null;
        this.foodTakeoutCustomPropertyList = null;
        this.foodTakeoutSalePackageList = null;
        this.extensionMap = null;
    }

    public final String a() {
        return this.comboNum;
    }

    public final Map<String, Object> b() {
        return this.extensionMap;
    }

    public final String c() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String d() {
        return this.foodTakeoutSalePackageList;
    }

    public final String e() {
        return this.installment;
    }

    public final String f() {
        return this.orderUrl;
    }

    public final String g() {
        return this.poiId;
    }

    public final String h() {
        return this.productId;
    }

    public final String i() {
        return this.promiseType;
    }

    public final String j() {
        return this.promotionId;
    }

    public final uh3.b k() {
        return this.skuItem;
    }
}
