package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/sku/PriceComponent;", "Ljava/io/Serializable;", "firstPrice", "Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;", "secondPrice", "regularPrice", "hotSalePrice", "Lcom/bytedance/android/ec/model/sku/HotSalePrice;", "atmosphereStyle", "", "skuPriceType", "", "(Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;Lcom/bytedance/android/ec/model/sku/HotSalePrice;Ljava/lang/Integer;Ljava/lang/Long;)V", "getAtmosphereStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFirstPrice", "()Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;", "getHotSalePrice", "()Lcom/bytedance/android/ec/model/sku/HotSalePrice;", "getRegularPrice", "getSecondPrice", "getSkuPriceType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;Lcom/bytedance/android/ec/model/sku/HotSalePrice;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/bytedance/android/ec/model/sku/PriceComponent;", "equals", "", "other", "", "hashCode", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PriceComponent implements Serializable {

    @SerializedName("atmosphere_style")
    private final Integer atmosphereStyle;

    @SerializedName("first_price")
    private final SkuPriceInfo firstPrice;

    @SerializedName("hot_sale_price")
    private final HotSalePrice hotSalePrice;

    @SerializedName(a.KEY_REGULAR_PRICE)
    private final SkuPriceInfo regularPrice;

    @SerializedName("second_price")
    private final SkuPriceInfo secondPrice;

    @SerializedName("sku_price_type")
    private final Long skuPriceType;

    public PriceComponent() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PriceComponent copy$default(PriceComponent r100, SkuPriceInfo r101, SkuPriceInfo r102, SkuPriceInfo r103, HotSalePrice r104, Integer r105, Long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.firstPrice;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.secondPrice;
    L8:
        SkuPriceInfo r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.regularPrice;
    L11:
        SkuPriceInfo r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.hotSalePrice;
    L14:
        HotSalePrice r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.atmosphereStyle;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.skuPriceType;
    L20:
        SkuPriceInfo r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final SkuPriceInfo component1() {
        return this.firstPrice;
    }

    public final SkuPriceInfo component2() {
        return this.secondPrice;
    }

    public final SkuPriceInfo component3() {
        return this.regularPrice;
    }

    public final HotSalePrice component4() {
        return this.hotSalePrice;
    }

    public final Integer component5() {
        return this.atmosphereStyle;
    }

    public final Long component6() {
        return this.skuPriceType;
    }

    public final PriceComponent copy(SkuPriceInfo r100, SkuPriceInfo r110, SkuPriceInfo r111, HotSalePrice r112, Integer r113, Long r114) {
        return new PriceComponent(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PriceComponent) == false) goto L18;
        PriceComponent r101 = (PriceComponent) r100;
        if (Intrinsics.areEqual(this.firstPrice, r101.firstPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secondPrice, r101.secondPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.regularPrice, r101.regularPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hotSalePrice, r101.hotSalePrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.atmosphereStyle, r101.atmosphereStyle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.skuPriceType, r101.skuPriceType) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        SkuPriceInfo r100 = this.firstPrice;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SkuPriceInfo r104 = this.secondPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SkuPriceInfo r107 = this.regularPrice;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        HotSalePrice r110 = this.hotSalePrice;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.atmosphereStyle;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.skuPriceType;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PriceComponent(firstPrice=" + this.firstPrice + ", secondPrice=" + this.secondPrice + ", regularPrice=" + this.regularPrice + ", hotSalePrice=" + this.hotSalePrice + ", atmosphereStyle=" + this.atmosphereStyle + ", skuPriceType=" + this.skuPriceType + ")";
    }

    public final Integer getAtmosphereStyle() {
        return this.atmosphereStyle;
    }

    public final SkuPriceInfo getFirstPrice() {
        return this.firstPrice;
    }

    public final HotSalePrice getHotSalePrice() {
        return this.hotSalePrice;
    }

    public final SkuPriceInfo getRegularPrice() {
        return this.regularPrice;
    }

    public final SkuPriceInfo getSecondPrice() {
        return this.secondPrice;
    }

    public final Long getSkuPriceType() {
        return this.skuPriceType;
    }

    public PriceComponent(SkuPriceInfo r100, SkuPriceInfo r101, SkuPriceInfo r102, HotSalePrice r103, Integer r104, Long r105) {
        this.firstPrice = r100;
        this.secondPrice = r101;
        this.regularPrice = r102;
        this.hotSalePrice = r103;
        this.atmosphereStyle = r104;
        this.skuPriceType = r105;
    }

    public /* synthetic */ PriceComponent(SkuPriceInfo r100, SkuPriceInfo r101, SkuPriceInfo r102, HotSalePrice r103, Integer r110, Long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        SkuPriceInfo r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        SkuPriceInfo r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        SkuPriceInfo r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        HotSalePrice r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Long r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
