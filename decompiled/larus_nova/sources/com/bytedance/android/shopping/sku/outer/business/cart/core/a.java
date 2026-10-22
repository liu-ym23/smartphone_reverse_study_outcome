package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u00019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R*\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R*\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b9\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/cart/core/a;", "", "", "skuSessionId", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "comboNum", "c", "", "selectedIds", "Ljava/util/List;", "getSelectedIds", "()Ljava/util/List;", "Luh3/c;", "specDescs", "m", "selectedCover", ce.f26395j, "Luh3/b;", "skuItem", "Luh3/b;", ce.f26396k, "()Luh3/b;", "orderUrl", "getOrderUrl", "promotionId", RXScreenCaptureService.KEY_INDEX, "poiId", "getPoiId", "", "showDouCampaign", "Ljava/lang/Integer;", "getShowDouCampaign", "()Ljava/lang/Integer;", com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, "getInstallment", "logExtra", "getLogExtra", "originId", "f", "originType", ce.f26391f, "productId", "h", "btm", "b", "foodTakeoutCustomPropertyList", "d", "foodTakeoutSalePackageList", "e", "", "supermarketPopExtraParams", "Ljava/util/Map;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/util/Map;", "addCartExtra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183072a = 0;

    @SerializedName("add_cart_extra")
    private final Map<String, Object> addCartExtra;

    @SerializedName("btm")
    private final String btm;

    @SerializedName("combo_num")
    private final String comboNum;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO)
    private final String installment;

    @SerializedName("log_extra")
    private final String logExtra;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)
    private final String originId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE)
    private final String originType;

    @SerializedName("poi_id")
    private final String poiId;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("selected_cover")
    private final String selectedCover;

    @SerializedName("selected_ids")
    private final List<String> selectedIds;

    @SerializedName("show_dou_campaign")
    private final Integer showDouCampaign;

    @SerializedName("sku_item")
    private final uh3.b skuItem;

    @SerializedName("sku_session_id")
    private final String skuSessionId;

    @SerializedName("spec_descs")
    private final List<uh3.c> specDescs;

    @SerializedName("supermarket_pop_extra_params")
    private final Map<String, Object> supermarketPopExtraParams;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.sku.outer.business.cart.core.a$a, reason: collision with other inner class name */
    public static final class C2719a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final Map<String, Object> a() {
        return this.addCartExtra;
    }

    public final String b() {
        return this.btm;
    }

    public final String c() {
        return this.comboNum;
    }

    public final String d() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String e() {
        return this.foodTakeoutSalePackageList;
    }

    public final String f() {
        return this.originId;
    }

    public final String g() {
        return this.originType;
    }

    public final String h() {
        return this.productId;
    }

    public final String i() {
        return this.promotionId;
    }

    public final String j() {
        return this.selectedCover;
    }

    public final uh3.b k() {
        return this.skuItem;
    }

    public final String l() {
        return this.skuSessionId;
    }

    public final List<uh3.c> m() {
        return this.specDescs;
    }

    public final Map<String, Object> n() {
        return this.supermarketPopExtraParams;
    }

    public a(Object r100) {
        this.skuSessionId = null;
        this.comboNum = null;
        this.selectedIds = null;
        this.specDescs = null;
        this.selectedCover = null;
        this.skuItem = null;
        this.orderUrl = null;
        this.promotionId = null;
        this.poiId = null;
        this.showDouCampaign = null;
        this.installment = null;
        this.logExtra = null;
        this.originId = null;
        this.originType = null;
        this.productId = null;
        this.btm = null;
        this.foodTakeoutCustomPropertyList = null;
        this.foodTakeoutSalePackageList = null;
        this.supermarketPopExtraParams = null;
        this.addCartExtra = null;
    }
}
