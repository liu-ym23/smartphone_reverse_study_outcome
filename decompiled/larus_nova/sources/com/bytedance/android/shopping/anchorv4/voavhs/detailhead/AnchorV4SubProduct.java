package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4SubProduct;", "Ljava/io/Serializable;", "combineNum", "", "subProductId", "", "productFormatGroup", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormatGroup;", "(ILjava/lang/String;Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormatGroup;)V", "getCombineNum", "()I", "getProductFormatGroup", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormatGroup;", "getSubProductId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4SubProduct implements Serializable {
    private final int combineNum;
    private final ProductFormatGroup productFormatGroup;
    private final String subProductId;

    public AnchorV4SubProduct() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ AnchorV4SubProduct copy$default(AnchorV4SubProduct r100, int r101, String r102, ProductFormatGroup r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.combineNum;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.subProductId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.productFormatGroup;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.combineNum;
    }

    public final String component2() {
        return this.subProductId;
    }

    public final ProductFormatGroup component3() {
        return this.productFormatGroup;
    }

    public final AnchorV4SubProduct copy(int r100, String r101, ProductFormatGroup r102) {
        return new AnchorV4SubProduct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4SubProduct) == false) goto L12;
        AnchorV4SubProduct r101 = (AnchorV4SubProduct) r100;
        if (this.combineNum == r101.combineNum) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subProductId, r101.subProductId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productFormatGroup, r101.productFormatGroup) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.combineNum * 31;
        String r101 = this.subProductId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ProductFormatGroup r105 = this.productFormatGroup;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4SubProduct(combineNum=" + this.combineNum + ", subProductId=" + this.subProductId + ", productFormatGroup=" + this.productFormatGroup + ")";
    }

    public final int getCombineNum() {
        return this.combineNum;
    }

    public final ProductFormatGroup getProductFormatGroup() {
        return this.productFormatGroup;
    }

    public final String getSubProductId() {
        return this.subProductId;
    }

    public AnchorV4SubProduct(int r100, String r101, ProductFormatGroup r102) {
        this.combineNum = r100;
        this.subProductId = r101;
        this.productFormatGroup = r102;
    }

    public /* synthetic */ AnchorV4SubProduct(int r100, String r101, ProductFormatGroup r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
