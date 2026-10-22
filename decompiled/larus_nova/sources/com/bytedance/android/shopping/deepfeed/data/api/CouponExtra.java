package com.bytedance.android.shopping.deepfeed.data.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;", "Ljava/io/Serializable;", "exchangeType", "", "exchangeAmount", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getExchangeAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExchangeType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponExtra implements Serializable {

    @SerializedName("exchange_amount")
    private final Long exchangeAmount;

    @SerializedName("exchange_type")
    private final String exchangeType;

    /* JADX WARN: Multi-variable type inference failed */
    public CouponExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CouponExtra copy$default(CouponExtra r100, String r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.exchangeType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exchangeAmount;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.exchangeType;
    }

    public final Long component2() {
        return this.exchangeAmount;
    }

    public final CouponExtra copy(String r100, Long r101) {
        return new CouponExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CouponExtra) == false) goto L10;
        CouponExtra r101 = (CouponExtra) r100;
        if (Intrinsics.areEqual(this.exchangeType, r101.exchangeType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.exchangeAmount, r101.exchangeAmount) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.exchangeType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.exchangeAmount;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CouponExtra(exchangeType=" + this.exchangeType + ", exchangeAmount=" + this.exchangeAmount + ")";
    }

    public final Long getExchangeAmount() {
        return this.exchangeAmount;
    }

    public final String getExchangeType() {
        return this.exchangeType;
    }

    public CouponExtra(String r100, Long r101) {
        this.exchangeType = r100;
        this.exchangeAmount = r101;
    }

    public /* synthetic */ CouponExtra(String r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
