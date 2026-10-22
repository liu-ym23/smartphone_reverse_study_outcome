package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ProductDiscountPrice;", "Ljava/io/Serializable;", "price", "", "header", "", "(JLjava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "getPrice", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductDiscountPrice implements Serializable {

    @SerializedName("header")
    private final String header;

    @SerializedName("price")
    private final long price;

    public ProductDiscountPrice() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ ProductDiscountPrice copy$default(ProductDiscountPrice r100, long r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.price;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.header;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.price;
    }

    public final String component2() {
        return this.header;
    }

    public final ProductDiscountPrice copy(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "header");
        return new ProductDiscountPrice(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductDiscountPrice) == false) goto L10;
        ProductDiscountPrice r101 = (ProductDiscountPrice) r100;
        if (this.price == r101.price) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.price;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.header;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public String toString() {
        return "ProductDiscountPrice(price=" + this.price + ", header=" + this.header + ")";
    }

    public final String getHeader() {
        return this.header;
    }

    public final long getPrice() {
        return this.price;
    }

    public ProductDiscountPrice(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "header");
        this.price = r100;
        this.header = r101;
    }

    public /* synthetic */ ProductDiscountPrice(long r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
