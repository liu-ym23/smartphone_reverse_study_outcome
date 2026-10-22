package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/SkuBaseInfoDataModel;", "Ljava/io/Serializable;", "specId", "", "effectivePrice", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "discountPrice", "marketPrice", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;)V", "getDiscountPrice", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getEffectivePrice", "getMarketPrice", "getSpecId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBaseInfoDataModel implements Serializable {

    @SerializedName("discount_price")
    private final PriceElement discountPrice;

    @SerializedName("effective_price")
    private final PriceElement effectivePrice;

    @SerializedName("market_price")
    private final PriceElement marketPrice;

    @SerializedName("spec_id")
    private final String specId;

    public SkuBaseInfoDataModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SkuBaseInfoDataModel copy$default(SkuBaseInfoDataModel r100, String r101, PriceElement r102, PriceElement r103, PriceElement r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.specId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.effectivePrice;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.discountPrice;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.marketPrice;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.specId;
    }

    public final PriceElement component2() {
        return this.effectivePrice;
    }

    public final PriceElement component3() {
        return this.discountPrice;
    }

    public final PriceElement component4() {
        return this.marketPrice;
    }

    public final SkuBaseInfoDataModel copy(String r100, PriceElement r101, PriceElement r102, PriceElement r103) {
        return new SkuBaseInfoDataModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuBaseInfoDataModel) == false) goto L14;
        SkuBaseInfoDataModel r101 = (SkuBaseInfoDataModel) r100;
        if (Intrinsics.areEqual(this.specId, r101.specId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.effectivePrice, r101.effectivePrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.specId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PriceElement r104 = this.effectivePrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        PriceElement r107 = this.discountPrice;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        PriceElement r110 = this.marketPrice;
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
        return "SkuBaseInfoDataModel(specId=" + this.specId + ", effectivePrice=" + this.effectivePrice + ", discountPrice=" + this.discountPrice + ", marketPrice=" + this.marketPrice + ")";
    }

    public final PriceElement getDiscountPrice() {
        return this.discountPrice;
    }

    public final PriceElement getEffectivePrice() {
        return this.effectivePrice;
    }

    public final PriceElement getMarketPrice() {
        return this.marketPrice;
    }

    public final String getSpecId() {
        return this.specId;
    }

    public SkuBaseInfoDataModel(String r100, PriceElement r101, PriceElement r102, PriceElement r103) {
        this.specId = r100;
        this.effectivePrice = r101;
        this.discountPrice = r102;
        this.marketPrice = r103;
    }

    public /* synthetic */ SkuBaseInfoDataModel(String r100, PriceElement r101, PriceElement r102, PriceElement r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
