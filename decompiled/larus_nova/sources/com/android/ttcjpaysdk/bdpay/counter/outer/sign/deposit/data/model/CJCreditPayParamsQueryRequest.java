package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/model/CJCreditPayParamsQueryRequest;", "", "merchantId", "", "appId", "tradeNo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMerchantId", "getTradeNo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCreditPayParamsQueryRequest {
    private final String appId;
    private final String merchantId;
    private final String tradeNo;

    public static /* synthetic */ CJCreditPayParamsQueryRequest copy$default(CJCreditPayParamsQueryRequest r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.merchantId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.appId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tradeNo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.merchantId;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.tradeNo;
    }

    public final CJCreditPayParamsQueryRequest copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r102, "tradeNo");
        return new CJCreditPayParamsQueryRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJCreditPayParamsQueryRequest) == true) goto L8;
        return false;
    L8:
        CJCreditPayParamsQueryRequest r101 = (CJCreditPayParamsQueryRequest) r100;
        if (Intrinsics.areEqual(this.merchantId, r101.merchantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tradeNo, r101.tradeNo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.merchantId.hashCode() * 31) + this.appId.hashCode()) * 31) + this.tradeNo.hashCode();
    }

    public String toString() {
        return "CJCreditPayParamsQueryRequest(merchantId=" + this.merchantId + ", appId=" + this.appId + ", tradeNo=" + this.tradeNo + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getTradeNo() {
        return this.tradeNo;
    }

    public CJCreditPayParamsQueryRequest(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r102, "tradeNo");
        this.merchantId = r100;
        this.appId = r101;
        this.tradeNo = r102;
    }
}
