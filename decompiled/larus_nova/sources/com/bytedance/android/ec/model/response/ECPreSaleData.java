package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPreSaleData;", "Ljava/io/Serializable;", "originPrice", "", "depositPrice", "shopSValue", "discountDesc", "", "(JJJLjava/lang/String;)V", "getDepositPrice", "()J", "getDiscountDesc", "()Ljava/lang/String;", "getOriginPrice", "getShopSValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPreSaleData implements Serializable {

    @SerializedName("deposit_price")
    private final long depositPrice;

    @SerializedName("discount_desc")
    private final String discountDesc;

    @SerializedName("origin_price")
    private final long originPrice;

    @SerializedName("shop_svalue")
    private final long shopSValue;

    public static /* synthetic */ ECPreSaleData copy$default(ECPreSaleData r100, long r101, long r110, long r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        long r102 = r100.originPrice;
    L7:
        if ((r113 & 2) == 0) goto L9;
        long r103 = r100.depositPrice;
    L11:
        if ((r113 & 4) == 0) goto L13;
        long r104 = r100.shopSValue;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r105 = r100.discountDesc;
    L19:
        return r100.copy(r102, r103, r104, r105);
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.originPrice;
    }

    public final long component2() {
        return this.depositPrice;
    }

    public final long component3() {
        return this.shopSValue;
    }

    public final String component4() {
        return this.discountDesc;
    }

    public final ECPreSaleData copy(long r110, long r111, long r112, String r113) {
        Intrinsics.checkNotNullParameter(r113, "discountDesc");
        return new ECPreSaleData(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPreSaleData) == false) goto L14;
        ECPreSaleData r101 = (ECPreSaleData) r100;
        if (this.originPrice == r101.originPrice) goto L8;
        return false;
    L8:
        if (this.depositPrice == r101.depositPrice) goto L10;
        return false;
    L10:
        if (this.shopSValue == r101.shopSValue) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.discountDesc, r101.discountDesc) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r100 = this.originPrice;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.depositPrice;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.shopSValue;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.discountDesc;
        if (r106 == null) goto L5;
        int r107 = r106.hashCode();
    L7:
        return r105 + r107;
    L5:
        r107 = 0;
        goto L7
    }

    public String toString() {
        return "ECPreSaleData(originPrice=" + this.originPrice + ", depositPrice=" + this.depositPrice + ", shopSValue=" + this.shopSValue + ", discountDesc=" + this.discountDesc + ")";
    }

    public final long getDepositPrice() {
        return this.depositPrice;
    }

    public final String getDiscountDesc() {
        return this.discountDesc;
    }

    public final long getOriginPrice() {
        return this.originPrice;
    }

    public final long getShopSValue() {
        return this.shopSValue;
    }

    public ECPreSaleData(long r100, long r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "discountDesc");
        this.originPrice = r100;
        this.depositPrice = r101;
        this.shopSValue = r102;
        this.discountDesc = r103;
    }
}
