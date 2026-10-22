package com.bytedance.android.shopping.sku.outer.business.confirm;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import uh3.c;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/confirm/a;", "", "", "comboNum", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "Luh3/c;", "specDescs", "Ljava/util/List;", "e", "()Ljava/util/List;", "Luh3/b;", "skuItem", "Luh3/b;", "d", "()Luh3/b;", "foodTakeoutCustomPropertyList", "b", "foodTakeoutSalePackageList", "c", "", "supermarketPopExtraParams", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183094a = 0;

    @SerializedName("combo_num")
    private final String comboNum;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName("sku_item")
    private final uh3.b skuItem;

    @SerializedName("spec_descs")
    private final List<c> specDescs;

    @SerializedName("supermarket_pop_extra_params")
    private final Map<String, Object> supermarketPopExtraParams;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.sku.outer.business.confirm.a$a, reason: collision with other inner class name */
    public static final class C2720a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final String a() {
        return this.comboNum;
    }

    public final String b() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String c() {
        return this.foodTakeoutSalePackageList;
    }

    public final uh3.b d() {
        return this.skuItem;
    }

    public final List<c> e() {
        return this.specDescs;
    }

    public final Map<String, Object> f() {
        return this.supermarketPopExtraParams;
    }

    public a(Object r100) {
        this.comboNum = null;
        this.specDescs = null;
        this.skuItem = null;
        this.foodTakeoutCustomPropertyList = null;
        this.foodTakeoutSalePackageList = null;
        this.supermarketPopExtraParams = null;
    }
}
