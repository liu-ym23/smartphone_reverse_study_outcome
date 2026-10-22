package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.front.doubleconfirm;

import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/front/doubleconfirm/CJStandardDoubleConfirmKeepDialogData;", "", "tradeNo", "", "retainInfo", "Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;", "retainInfoV2", "Lorg/json/JSONObject;", "retainInfoBatch", "forbidRetainDefault", "", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;Lorg/json/JSONObject;Lorg/json/JSONObject;Z)V", "getForbidRetainDefault", "()Z", "getRetainInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;", "getRetainInfoBatch", "()Lorg/json/JSONObject;", "getRetainInfoV2", "getTradeNo", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStandardDoubleConfirmKeepDialogData {
    private final boolean forbidRetainDefault;
    private final RetainInfo retainInfo;
    private final JSONObject retainInfoBatch;
    private final JSONObject retainInfoV2;
    private final String tradeNo;

    public static /* synthetic */ CJStandardDoubleConfirmKeepDialogData copy$default(CJStandardDoubleConfirmKeepDialogData r100, String r101, RetainInfo r102, JSONObject r103, JSONObject r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.tradeNo;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.retainInfo;
    L8:
        RetainInfo r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.retainInfoV2;
    L11:
        JSONObject r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.retainInfoBatch;
    L14:
        JSONObject r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.forbidRetainDefault;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.tradeNo;
    }

    public final RetainInfo component2() {
        return this.retainInfo;
    }

    public final JSONObject component3() {
        return this.retainInfoV2;
    }

    public final JSONObject component4() {
        return this.retainInfoBatch;
    }

    public final boolean component5() {
        return this.forbidRetainDefault;
    }

    public final CJStandardDoubleConfirmKeepDialogData copy(String r100, RetainInfo r101, JSONObject r110, JSONObject r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "tradeNo");
        return new CJStandardDoubleConfirmKeepDialogData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJStandardDoubleConfirmKeepDialogData) == true) goto L8;
        return false;
    L8:
        CJStandardDoubleConfirmKeepDialogData r101 = (CJStandardDoubleConfirmKeepDialogData) r100;
        if (Intrinsics.areEqual(this.tradeNo, r101.tradeNo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.retainInfo, r101.retainInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.retainInfoV2, r101.retainInfoV2) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.retainInfoBatch, r101.retainInfoBatch) == true) goto L21;
        return false;
    L21:
        if (this.forbidRetainDefault == r101.forbidRetainDefault) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.tradeNo.hashCode() * 31;
        RetainInfo r101 = this.retainInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.retainInfoV2;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        JSONObject r108 = this.retainInfoBatch;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.forbidRetainDefault == false) goto L17;
        int r110 = 1231;
    L19:
        return r109 + r110;
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CJStandardDoubleConfirmKeepDialogData(tradeNo=" + this.tradeNo + ", retainInfo=" + this.retainInfo + ", retainInfoV2=" + this.retainInfoV2 + ", retainInfoBatch=" + this.retainInfoBatch + ", forbidRetainDefault=" + this.forbidRetainDefault + ')';
    }

    public final boolean getForbidRetainDefault() {
        return this.forbidRetainDefault;
    }

    public final RetainInfo getRetainInfo() {
        return this.retainInfo;
    }

    public final JSONObject getRetainInfoBatch() {
        return this.retainInfoBatch;
    }

    public final JSONObject getRetainInfoV2() {
        return this.retainInfoV2;
    }

    public final String getTradeNo() {
        return this.tradeNo;
    }

    public CJStandardDoubleConfirmKeepDialogData(String r100, RetainInfo r101, JSONObject r102, JSONObject r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "tradeNo");
        this.tradeNo = r100;
        this.retainInfo = r101;
        this.retainInfoV2 = r102;
        this.retainInfoBatch = r103;
        this.forbidRetainDefault = r104;
    }

    public /* synthetic */ CJStandardDoubleConfirmKeepDialogData(String r100, RetainInfo r101, JSONObject r102, JSONObject r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r103 = false;
    L6:
        this(r100, r101, r102, r110, r103);
        return;
    L5:
        r103 = r111;
        goto L6
    }
}
