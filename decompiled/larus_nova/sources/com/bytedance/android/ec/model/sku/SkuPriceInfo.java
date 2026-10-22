package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\t\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;", "Ljava/io/Serializable;", "prefix", "", "price", "", "suffix", "isUnderline", "", "isReducePrice", "supplement", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPrefix", "()Ljava/lang/String;", "getPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSuffix", "getSupplement", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/ec/model/sku/SkuPriceInfo;", "equals", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuPriceInfo implements Serializable {

    @SerializedName("is_reduce_price")
    private final Boolean isReducePrice;

    @SerializedName("is_underline")
    private final Boolean isUnderline;

    @SerializedName("prefix")
    private final String prefix;

    @SerializedName("price")
    private final Long price;

    @SerializedName("suffix")
    private final String suffix;

    @SerializedName("supplement")
    private final String supplement;

    public SkuPriceInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ SkuPriceInfo copy$default(SkuPriceInfo r100, String r101, Long r102, String r103, Boolean r104, Boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.prefix;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.price;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.suffix;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isUnderline;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isReducePrice;
    L17:
        Boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.supplement;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.prefix;
    }

    public final Long component2() {
        return this.price;
    }

    public final String component3() {
        return this.suffix;
    }

    public final Boolean component4() {
        return this.isUnderline;
    }

    public final Boolean component5() {
        return this.isReducePrice;
    }

    public final String component6() {
        return this.supplement;
    }

    public final SkuPriceInfo copy(String r100, Long r110, String r111, Boolean r112, Boolean r113, String r114) {
        return new SkuPriceInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuPriceInfo) == false) goto L18;
        SkuPriceInfo r101 = (SkuPriceInfo) r100;
        if (Intrinsics.areEqual(this.prefix, r101.prefix) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isUnderline, r101.isUnderline) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isReducePrice, r101.isReducePrice) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.supplement, r101.supplement) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.prefix;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.price;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.suffix;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isUnderline;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isReducePrice;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.supplement;
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
        return "SkuPriceInfo(prefix=" + this.prefix + ", price=" + this.price + ", suffix=" + this.suffix + ", isUnderline=" + this.isUnderline + ", isReducePrice=" + this.isReducePrice + ", supplement=" + this.supplement + ")";
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final String getSupplement() {
        return this.supplement;
    }

    public final Boolean isReducePrice() {
        return this.isReducePrice;
    }

    public final Boolean isUnderline() {
        return this.isUnderline;
    }

    public SkuPriceInfo(String r100, Long r101, String r102, Boolean r103, Boolean r104, String r105) {
        this.prefix = r100;
        this.price = r101;
        this.suffix = r102;
        this.isUnderline = r103;
        this.isReducePrice = r104;
        this.supplement = r105;
    }

    public /* synthetic */ SkuPriceInfo(String r100, Long r101, String r102, Boolean r103, Boolean r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Long r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Boolean r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        r110 = Boolean.FALSE;
    L21:
        Boolean r107 = r110;
        if ((r112 & 32) == 0) goto L24;
        String r115 = null;
    L25:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
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
