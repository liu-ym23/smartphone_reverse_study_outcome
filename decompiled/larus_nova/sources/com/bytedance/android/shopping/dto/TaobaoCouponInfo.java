package com.bytedance.android.shopping.dto;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0014J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/dto/TaobaoCouponInfo;", "Ljava/io/Serializable;", "couponAmount", "", "couponWebUrl", "couponOpenUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCouponAmount", "()Ljava/lang/String;", "setCouponAmount", "(Ljava/lang/String;)V", "getCouponOpenUrl", "setCouponOpenUrl", "getCouponWebUrl", "setCouponWebUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TaobaoCouponInfo implements Serializable {

    @SerializedName("coupon_amount")
    private String couponAmount;

    @SerializedName("coupon_open_url")
    private String couponOpenUrl;

    @SerializedName("coupon_web_url")
    private String couponWebUrl;

    public TaobaoCouponInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TaobaoCouponInfo copy$default(TaobaoCouponInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.couponAmount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.couponWebUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.couponOpenUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.couponAmount;
    }

    public final String component2() {
        return this.couponWebUrl;
    }

    public final String component3() {
        return this.couponOpenUrl;
    }

    public final TaobaoCouponInfo copy(String r100, String r101, String r102) {
        return new TaobaoCouponInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TaobaoCouponInfo) == false) goto L12;
        TaobaoCouponInfo r101 = (TaobaoCouponInfo) r100;
        if (Intrinsics.areEqual(this.couponAmount, r101.couponAmount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.couponWebUrl, r101.couponWebUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponOpenUrl, r101.couponOpenUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.couponAmount;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.couponWebUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.couponOpenUrl;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TaobaoCouponInfo(couponAmount=" + this.couponAmount + ", couponWebUrl=" + this.couponWebUrl + ", couponOpenUrl=" + this.couponOpenUrl + ")";
    }

    public final boolean isValid() {
        if (TextUtils.isEmpty(this.couponAmount) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.couponWebUrl) == true) goto L7;
    L8:
        return true;
    L7:
        if (TextUtils.isEmpty(this.couponOpenUrl) == true) goto L9;
        goto L8
    }

    public final String getCouponAmount() {
        return this.couponAmount;
    }

    public final String getCouponOpenUrl() {
        return this.couponOpenUrl;
    }

    public final String getCouponWebUrl() {
        return this.couponWebUrl;
    }

    public final void setCouponAmount(String r100) {
        this.couponAmount = r100;
    }

    public final void setCouponOpenUrl(String r100) {
        this.couponOpenUrl = r100;
    }

    public final void setCouponWebUrl(String r100) {
        this.couponWebUrl = r100;
    }

    public TaobaoCouponInfo(String r100, String r101, String r102) {
        this.couponAmount = r100;
        this.couponWebUrl = r101;
        this.couponOpenUrl = r102;
    }

    public /* synthetic */ TaobaoCouponInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
