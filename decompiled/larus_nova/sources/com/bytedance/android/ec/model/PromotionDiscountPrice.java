package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "Ljava/io/Serializable;", "minPrice", "", "maxPrice", "header", "", "suffix", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "getMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMinPrice", "getSuffix", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionDiscountPrice implements Serializable {

    @SerializedName("header")
    private final String header;

    @SerializedName("discount_max_price")
    private final Long maxPrice;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_MIN_PRICE)
    private final Long minPrice;

    @SerializedName("suffix")
    private final String suffix;

    public PromotionDiscountPrice() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PromotionDiscountPrice copy$default(PromotionDiscountPrice r100, Long r101, Long r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.minPrice;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.maxPrice;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.header;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.suffix;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.minPrice;
    }

    public final Long component2() {
        return this.maxPrice;
    }

    public final String component3() {
        return this.header;
    }

    public final String component4() {
        return this.suffix;
    }

    public final PromotionDiscountPrice copy(Long r100, Long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "header");
        Intrinsics.checkNotNullParameter(r103, "suffix");
        return new PromotionDiscountPrice(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionDiscountPrice) == false) goto L14;
        PromotionDiscountPrice r101 = (PromotionDiscountPrice) r100;
        if (Intrinsics.areEqual(this.minPrice, r101.minPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.maxPrice, r101.maxPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Long r100 = this.minPrice;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.maxPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.header;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.suffix;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "PromotionDiscountPrice(minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", header=" + this.header + ", suffix=" + this.suffix + ")";
    }

    public final String getHeader() {
        return this.header;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public PromotionDiscountPrice(Long r100, Long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "header");
        Intrinsics.checkNotNullParameter(r103, "suffix");
        this.minPrice = r100;
        this.maxPrice = r101;
        this.header = r102;
        this.suffix = r103;
    }

    public /* synthetic */ PromotionDiscountPrice(Long r100, Long r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
