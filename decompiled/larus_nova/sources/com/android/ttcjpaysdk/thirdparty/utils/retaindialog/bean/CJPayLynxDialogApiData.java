package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003JI\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\bH\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogApiData;", "", "piyataResponse", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainPiyataResponse;", "contactInfo", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "commonParams", "", "", "exts", "(Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainPiyataResponse;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;Ljava/util/Map;Ljava/util/Map;)V", "getCommonParams", "()Ljava/util/Map;", "getContactInfo", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "getExts", "getPiyataResponse", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainPiyataResponse;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLynxDialogApiData {
    private final Map<String, String> commonParams;
    private final CJPayRetainContactInfo contactInfo;
    private final Map<String, Object> exts;
    private final CJPayRetainPiyataResponse piyataResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayLynxDialogApiData copy$default(CJPayLynxDialogApiData r100, CJPayRetainPiyataResponse r101, CJPayRetainContactInfo r102, Map r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.piyataResponse;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.contactInfo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.commonParams;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.exts;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final CJPayRetainPiyataResponse component1() {
        return this.piyataResponse;
    }

    public final CJPayRetainContactInfo component2() {
        return this.contactInfo;
    }

    public final Map<String, String> component3() {
        return this.commonParams;
    }

    public final Map<String, Object> component4() {
        return this.exts;
    }

    public final CJPayLynxDialogApiData copy(CJPayRetainPiyataResponse r100, CJPayRetainContactInfo r101, Map<String, String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "piyataResponse");
        Intrinsics.checkNotNullParameter(r101, "contactInfo");
        Intrinsics.checkNotNullParameter(r102, "commonParams");
        Intrinsics.checkNotNullParameter(r103, "exts");
        return new CJPayLynxDialogApiData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayLynxDialogApiData) == true) goto L8;
        return false;
    L8:
        CJPayLynxDialogApiData r101 = (CJPayLynxDialogApiData) r100;
        if (Intrinsics.areEqual(this.piyataResponse, r101.piyataResponse) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contactInfo, r101.contactInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.commonParams, r101.commonParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.exts, r101.exts) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.piyataResponse.hashCode() * 31) + this.contactInfo.hashCode()) * 31) + this.commonParams.hashCode()) * 31) + this.exts.hashCode();
    }

    public String toString() {
        return "CJPayLynxDialogApiData(growthType='" + this.piyataResponse + "', contactInfo=" + this.contactInfo + ", commonParams=" + this.commonParams + ", exts=" + this.exts + ')';
    }

    public final Map<String, String> getCommonParams() {
        return this.commonParams;
    }

    public final CJPayRetainContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final Map<String, Object> getExts() {
        return this.exts;
    }

    public final CJPayRetainPiyataResponse getPiyataResponse() {
        return this.piyataResponse;
    }

    public CJPayLynxDialogApiData(CJPayRetainPiyataResponse r100, CJPayRetainContactInfo r101, Map<String, String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "piyataResponse");
        Intrinsics.checkNotNullParameter(r101, "contactInfo");
        Intrinsics.checkNotNullParameter(r102, "commonParams");
        Intrinsics.checkNotNullParameter(r103, "exts");
        this.piyataResponse = r100;
        this.contactInfo = r101;
        this.commonParams = r102;
        this.exts = r103;
    }
}
