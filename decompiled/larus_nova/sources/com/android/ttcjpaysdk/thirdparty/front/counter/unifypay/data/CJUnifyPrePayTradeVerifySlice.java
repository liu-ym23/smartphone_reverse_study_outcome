package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayTradeVerifySlice;", "", "processInfo", "Lorg/json/JSONObject;", "tradeNo", "", "merchantId", "appId", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMerchantId", "getProcessInfo", "()Lorg/json/JSONObject;", "getTradeNo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPrePayTradeVerifySlice {
    private final String appId;
    private final String merchantId;
    private final JSONObject processInfo;
    private final String tradeNo;

    public CJUnifyPrePayTradeVerifySlice() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CJUnifyPrePayTradeVerifySlice copy$default(CJUnifyPrePayTradeVerifySlice r100, JSONObject r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.processInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.tradeNo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.merchantId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.appId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final JSONObject component1() {
        return this.processInfo;
    }

    public final String component2() {
        return this.tradeNo;
    }

    public final String component3() {
        return this.merchantId;
    }

    public final String component4() {
        return this.appId;
    }

    public final CJUnifyPrePayTradeVerifySlice copy(JSONObject r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "tradeNo");
        Intrinsics.checkNotNullParameter(r102, "merchantId");
        Intrinsics.checkNotNullParameter(r103, "appId");
        return new CJUnifyPrePayTradeVerifySlice(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyPrePayTradeVerifySlice) == true) goto L8;
        return false;
    L8:
        CJUnifyPrePayTradeVerifySlice r101 = (CJUnifyPrePayTradeVerifySlice) r100;
        if (Intrinsics.areEqual(this.processInfo, r101.processInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tradeNo, r101.tradeNo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.merchantId, r101.merchantId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        JSONObject r100 = this.processInfo;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.tradeNo.hashCode()) * 31) + this.merchantId.hashCode()) * 31) + this.appId.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "CJUnifyPrePayTradeVerifySlice(processInfo=" + this.processInfo + ", tradeNo=" + this.tradeNo + ", merchantId=" + this.merchantId + ", appId=" + this.appId + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final JSONObject getProcessInfo() {
        return this.processInfo;
    }

    public final String getTradeNo() {
        return this.tradeNo;
    }

    public CJUnifyPrePayTradeVerifySlice(JSONObject r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "tradeNo");
        Intrinsics.checkNotNullParameter(r102, "merchantId");
        Intrinsics.checkNotNullParameter(r103, "appId");
        this.processInfo = r100;
        this.tradeNo = r101;
        this.merchantId = r102;
        this.appId = r103;
    }

    public /* synthetic */ CJUnifyPrePayTradeVerifySlice(JSONObject r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
