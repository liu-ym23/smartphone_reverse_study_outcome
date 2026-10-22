package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayResponseSlice;", "", "bindCardReconfirm", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayBindCardReconfirmSlice;", "tradeVerify", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayTradeVerifySlice;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayBindCardReconfirmSlice;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayTradeVerifySlice;)V", "getBindCardReconfirm", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayBindCardReconfirmSlice;", "getTradeVerify", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayTradeVerifySlice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPrePayResponseSlice {
    private final CJUnifyPrePayBindCardReconfirmSlice bindCardReconfirm;
    private final CJUnifyPrePayTradeVerifySlice tradeVerify;

    /* JADX WARN: Multi-variable type inference failed */
    public CJUnifyPrePayResponseSlice() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CJUnifyPrePayResponseSlice copy$default(CJUnifyPrePayResponseSlice r100, CJUnifyPrePayBindCardReconfirmSlice r101, CJUnifyPrePayTradeVerifySlice r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bindCardReconfirm;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tradeVerify;
    L9:
        return r100.copy(r101, r102);
    }

    public final CJUnifyPrePayBindCardReconfirmSlice component1() {
        return this.bindCardReconfirm;
    }

    public final CJUnifyPrePayTradeVerifySlice component2() {
        return this.tradeVerify;
    }

    public final CJUnifyPrePayResponseSlice copy(CJUnifyPrePayBindCardReconfirmSlice r100, CJUnifyPrePayTradeVerifySlice r101) {
        return new CJUnifyPrePayResponseSlice(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyPrePayResponseSlice) == true) goto L8;
        return false;
    L8:
        CJUnifyPrePayResponseSlice r101 = (CJUnifyPrePayResponseSlice) r100;
        if (Intrinsics.areEqual(this.bindCardReconfirm, r101.bindCardReconfirm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tradeVerify, r101.tradeVerify) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CJUnifyPrePayBindCardReconfirmSlice r100 = this.bindCardReconfirm;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CJUnifyPrePayTradeVerifySlice r104 = this.tradeVerify;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJUnifyPrePayResponseSlice(bindCardReconfirm=" + this.bindCardReconfirm + ", tradeVerify=" + this.tradeVerify + ')';
    }

    public final CJUnifyPrePayBindCardReconfirmSlice getBindCardReconfirm() {
        return this.bindCardReconfirm;
    }

    public final CJUnifyPrePayTradeVerifySlice getTradeVerify() {
        return this.tradeVerify;
    }

    public CJUnifyPrePayResponseSlice(CJUnifyPrePayBindCardReconfirmSlice r100, CJUnifyPrePayTradeVerifySlice r101) {
        this.bindCardReconfirm = r100;
        this.tradeVerify = r101;
    }

    public /* synthetic */ CJUnifyPrePayResponseSlice(CJUnifyPrePayBindCardReconfirmSlice r100, CJUnifyPrePayTradeVerifySlice r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
