package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0003HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECApplyCouponResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/g;", "", "component1", "couponId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getCouponId", "()Ljava/lang/String;", "setCouponId", "(Ljava/lang/String;)V", "<init>", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECApplyCouponResponse extends g implements Serializable {

    @SerializedName("coupon_ids")
    private String couponId;

    /* JADX WARN: Multi-variable type inference failed */
    public ECApplyCouponResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECApplyCouponResponse copy$default(ECApplyCouponResponse r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.couponId;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.couponId;
    }

    public final ECApplyCouponResponse copy(String r100) {
        return new ECApplyCouponResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECApplyCouponResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.couponId, ((ECApplyCouponResponse) r100).couponId) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.couponId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ECApplyCouponResponse(couponId=" + this.couponId + ")";
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public ECApplyCouponResponse(String r100) {
        this.couponId = r100;
    }

    public final void setCouponId(String r100) {
        this.couponId = r100;
    }

    public /* synthetic */ ECApplyCouponResponse(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
