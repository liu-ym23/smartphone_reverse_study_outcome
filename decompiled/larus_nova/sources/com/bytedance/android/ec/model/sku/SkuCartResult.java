package com.bytedance.android.ec.model.sku;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003Jm\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuCartResult;", "Ljava/io/Serializable;", "spec", "", "skuId", "comboNum", "", "price", "pricePrefix", "foodTakeoutCustomPropertyList", "foodTakeoutSalePackageList", "supermarketPopExtraParams", "", "", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getComboNum", "()J", "getFoodTakeoutCustomPropertyList", "()Ljava/lang/String;", "getFoodTakeoutSalePackageList", "getPrice", "getPricePrefix", "getSkuId", "getSpec", "getSupermarketPopExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuCartResult implements Serializable {
    private final long comboNum;
    private final String foodTakeoutCustomPropertyList;
    private final String foodTakeoutSalePackageList;
    private final long price;
    private final String pricePrefix;
    private final String skuId;
    private final String spec;
    private final Map<String, Object> supermarketPopExtraParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuCartResult copy$default(SkuCartResult r110, String r111, String r112, long r113, long r114, String r115, String r116, String r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.spec;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.skuId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.comboNum;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r103 = r110.price;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.pricePrefix;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.foodTakeoutCustomPropertyList;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r117 = r110.foodTakeoutSalePackageList;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r106 = r110.supermarketPopExtraParams;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r117, r106);
    L33:
        r106 = r211;
        goto L35
    L29:
        r117 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.spec;
    }

    public final String component2() {
        return this.skuId;
    }

    public final long component3() {
        return this.comboNum;
    }

    public final long component4() {
        return this.price;
    }

    public final String component5() {
        return this.pricePrefix;
    }

    public final String component6() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String component7() {
        return this.foodTakeoutSalePackageList;
    }

    public final Map<String, Object> component8() {
        return this.supermarketPopExtraParams;
    }

    public final SkuCartResult copy(String r110, String r111, long r112, long r113, String r114, String r210, String r211, Map<String, ? extends Object> r212) {
        Intrinsics.checkNotNullParameter(r110, "spec");
        Intrinsics.checkNotNullParameter(r111, "skuId");
        Intrinsics.checkNotNullParameter(r114, "pricePrefix");
        return new SkuCartResult(r110, r111, r112, r113, r114, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuCartResult) == false) goto L22;
        SkuCartResult r101 = (SkuCartResult) r100;
        if (Intrinsics.areEqual(this.spec, r101.spec) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L10;
        return false;
    L10:
        if (this.comboNum == r101.comboNum) goto L12;
        return false;
    L12:
        if (this.price == r101.price) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pricePrefix, r101.pricePrefix) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.foodTakeoutCustomPropertyList, r101.foodTakeoutCustomPropertyList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.foodTakeoutSalePackageList, r101.foodTakeoutSalePackageList) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.supermarketPopExtraParams, r101.supermarketPopExtraParams) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.spec;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.skuId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.comboNum;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.price;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.pricePrefix;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        String r114 = this.foodTakeoutCustomPropertyList;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.foodTakeoutSalePackageList;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        Map<String, Object> r120 = this.supermarketPopExtraParams;
        if (r120 == null) goto L26;
        r101 = r120.hashCode();
    L26:
        return r119 + r101;
    L21:
        r118 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkuCartResult(spec=" + this.spec + ", skuId=" + this.skuId + ", comboNum=" + this.comboNum + ", price=" + this.price + ", pricePrefix=" + this.pricePrefix + ", foodTakeoutCustomPropertyList=" + this.foodTakeoutCustomPropertyList + ", foodTakeoutSalePackageList=" + this.foodTakeoutSalePackageList + ", supermarketPopExtraParams=" + this.supermarketPopExtraParams + ")";
    }

    public final long getComboNum() {
        return this.comboNum;
    }

    public final String getFoodTakeoutCustomPropertyList() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String getFoodTakeoutSalePackageList() {
        return this.foodTakeoutSalePackageList;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getPricePrefix() {
        return this.pricePrefix;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final String getSpec() {
        return this.spec;
    }

    public final Map<String, Object> getSupermarketPopExtraParams() {
        return this.supermarketPopExtraParams;
    }

    public SkuCartResult(String r100, String r101, long r102, long r103, String r104, String r105, String r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        Intrinsics.checkNotNullParameter(r101, "skuId");
        Intrinsics.checkNotNullParameter(r104, "pricePrefix");
        this.spec = r100;
        this.skuId = r101;
        this.comboNum = r102;
        this.price = r103;
        this.pricePrefix = r104;
        this.foodTakeoutCustomPropertyList = r105;
        this.foodTakeoutSalePackageList = r110;
        this.supermarketPopExtraParams = r111;
    }

    public /* synthetic */ SkuCartResult(String r110, String r111, long r112, long r113, String r210, String r211, String r212, Map r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 8) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r214 & 16) == 0) goto L9;
        String r114 = "";
    L11:
        if ((r214 & 32) == 0) goto L13;
        String r115 = null;
    L15:
        if ((r214 & 64) == 0) goto L17;
        String r116 = null;
    L19:
        if ((r214 & 128) == 0) goto L21;
        Map r117 = null;
    L22:
        this(r110, r111, r112, r100, r114, r115, r116, r117);
        return;
    L21:
        r117 = r213;
        goto L22
    L17:
        r116 = r212;
        goto L19
    L13:
        r115 = r211;
        goto L15
    L9:
        r114 = r210;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
