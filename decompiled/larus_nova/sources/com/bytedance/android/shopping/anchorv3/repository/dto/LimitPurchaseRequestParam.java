package com.bytedance.android.shopping.anchorv3.repository.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/LimitPurchaseRequestParam;", "Ljava/io/Serializable;", "productId", "", "skuId", "num", "", "activeId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getActiveId", "()Ljava/lang/String;", "getNum", "()J", "getProductId", "getSkuId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LimitPurchaseRequestParam implements Serializable {
    private final String activeId;
    private final long num;
    private final String productId;
    private final String skuId;

    public LimitPurchaseRequestParam() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ LimitPurchaseRequestParam copy$default(LimitPurchaseRequestParam r100, String r101, String r102, long r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.productId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.skuId;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.num;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.activeId;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.skuId;
    }

    public final long component3() {
        return this.num;
    }

    public final String component4() {
        return this.activeId;
    }

    public final LimitPurchaseRequestParam copy(String r100, String r101, long r110, String r111) {
        return new LimitPurchaseRequestParam(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LimitPurchaseRequestParam) == false) goto L14;
        LimitPurchaseRequestParam r101 = (LimitPurchaseRequestParam) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L10;
        return false;
    L10:
        if (this.num == r101.num) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activeId, r101.activeId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.productId;
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
        long r107 = this.num;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.activeId;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LimitPurchaseRequestParam(productId=" + this.productId + ", skuId=" + this.skuId + ", num=" + this.num + ", activeId=" + this.activeId + ")";
    }

    public final String getActiveId() {
        return this.activeId;
    }

    public final long getNum() {
        return this.num;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public LimitPurchaseRequestParam(String r100, String r101, long r102, String r103) {
        this.productId = r100;
        this.skuId = r101;
        this.num = r102;
        this.activeId = r103;
    }

    public /* synthetic */ LimitPurchaseRequestParam(String r100, String r101, long r102, String r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = 1;
    L13:
        long r105 = r102;
        if ((r110 & 8) == 0) goto L16;
        String r113 = null;
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L9:
        r104 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
