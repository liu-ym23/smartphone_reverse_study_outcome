package com.bytedance.android.shopping.deepfeed.data.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/Coupon;", "Ljava/io/Serializable;", "couponId", "", "countDown", "status", "", "deadline", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)V", "getCountDown", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCouponId", "getDeadline", "setDeadline", "(Ljava/lang/Long;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/bytedance/android/shopping/deepfeed/data/api/Coupon;", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Coupon implements Serializable {

    @SerializedName("count_down")
    private final Long countDown;

    @SerializedName("coupon_id")
    private final Long couponId;

    @SerializedName("deadline")
    private Long deadline;

    @SerializedName("status")
    private final Integer status;

    public Coupon() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Coupon copy$default(Coupon r100, Long r101, Long r102, Integer r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.couponId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.countDown;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.status;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.deadline;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.couponId;
    }

    public final Long component2() {
        return this.countDown;
    }

    public final Integer component3() {
        return this.status;
    }

    public final Long component4() {
        return this.deadline;
    }

    public final Coupon copy(Long r100, Long r101, Integer r102, Long r103) {
        return new Coupon(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Coupon) == false) goto L14;
        Coupon r101 = (Coupon) r100;
        if (Intrinsics.areEqual(this.couponId, r101.couponId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.countDown, r101.countDown) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deadline, r101.deadline) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Long r100 = this.couponId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.countDown;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.status;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.deadline;
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
        return "Coupon(couponId=" + this.couponId + ", countDown=" + this.countDown + ", status=" + this.status + ", deadline=" + this.deadline + ")";
    }

    public final Long getCountDown() {
        return this.countDown;
    }

    public final Long getCouponId() {
        return this.couponId;
    }

    public final Long getDeadline() {
        return this.deadline;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setDeadline(Long r100) {
        this.deadline = r100;
    }

    public Coupon(Long r100, Long r101, Integer r102, Long r103) {
        this.couponId = r100;
        this.countDown = r101;
        this.status = r102;
        this.deadline = r103;
    }

    public /* synthetic */ Coupon(Long r100, Long r101, Integer r102, Long r103, int r104, DefaultConstructorMarker r105) {
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
