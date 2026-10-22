package com.android.ttcjpaysdk.base.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJOuterBDPayResult;", "", "resultCode", "", "errorMsg", "extraParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "getExtraParams", "getResultCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOuterBDPayResult {
    private final String errorMsg;
    private final String extraParams;
    private final String resultCode;

    public static /* synthetic */ CJOuterBDPayResult copy$default(CJOuterBDPayResult r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.resultCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errorMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extraParams;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.resultCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final String component3() {
        return this.extraParams;
    }

    public final CJOuterBDPayResult copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        return new CJOuterBDPayResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJOuterBDPayResult) == true) goto L8;
        return false;
    L8:
        CJOuterBDPayResult r101 = (CJOuterBDPayResult) r100;
        if (Intrinsics.areEqual(this.resultCode, r101.resultCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.resultCode.hashCode() * 31) + this.errorMsg.hashCode()) * 31) + this.extraParams.hashCode();
    }

    public String toString() {
        return "CJOuterBDPayResult(resultCode=" + this.resultCode + ", errorMsg=" + this.errorMsg + ", extraParams=" + this.extraParams + ')';
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public CJOuterBDPayResult(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        this.resultCode = r100;
        this.errorMsg = r101;
        this.extraParams = r102;
    }
}
