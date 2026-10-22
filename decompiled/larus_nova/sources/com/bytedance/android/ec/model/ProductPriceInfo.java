package com.bytedance.android.ec.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JH\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/model/ProductPriceInfo;", "Ljava/io/Serializable;", "minPrice", "", "marketPrice", "discountPrice", "Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "maxPrice", "header", "", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/PromotionDiscountPrice;Ljava/lang/Long;Ljava/lang/String;)V", "getDiscountPrice", "()Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "getHeader", "()Ljava/lang/String;", "getMarketPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxPrice", "getMinPrice", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/PromotionDiscountPrice;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/android/ec/model/ProductPriceInfo;", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceInfo implements Serializable {
    private final PromotionDiscountPrice discountPrice;
    private final String header;
    private final Long marketPrice;
    private final Long maxPrice;
    private final Long minPrice;

    public static /* synthetic */ ProductPriceInfo copy$default(ProductPriceInfo r100, Long r101, Long r102, PromotionDiscountPrice r103, Long r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.minPrice;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.marketPrice;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.discountPrice;
    L11:
        PromotionDiscountPrice r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.maxPrice;
    L14:
        Long r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.header;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.minPrice;
    }

    public final Long component2() {
        return this.marketPrice;
    }

    public final PromotionDiscountPrice component3() {
        return this.discountPrice;
    }

    public final Long component4() {
        return this.maxPrice;
    }

    public final String component5() {
        return this.header;
    }

    public final ProductPriceInfo copy(Long r100, Long r101, PromotionDiscountPrice r110, Long r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "discountPrice");
        return new ProductPriceInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductPriceInfo) == false) goto L16;
        ProductPriceInfo r101 = (ProductPriceInfo) r100;
        if (Intrinsics.areEqual(this.minPrice, r101.minPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxPrice, r101.maxPrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Long r100 = this.minPrice;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.marketPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        PromotionDiscountPrice r107 = this.discountPrice;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.maxPrice;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.header;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "ProductPriceInfo(minPrice=" + this.minPrice + ", marketPrice=" + this.marketPrice + ", discountPrice=" + this.discountPrice + ", maxPrice=" + this.maxPrice + ", header=" + this.header + ")";
    }

    public final PromotionDiscountPrice getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getHeader() {
        return this.header;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public ProductPriceInfo(Long r100, Long r101, PromotionDiscountPrice r102, Long r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "discountPrice");
        this.minPrice = r100;
        this.marketPrice = r101;
        this.discountPrice = r102;
        this.maxPrice = r103;
        this.header = r104;
    }

    public /* synthetic */ ProductPriceInfo(Long r100, Long r101, PromotionDiscountPrice r110, Long r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        Long r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        String r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
