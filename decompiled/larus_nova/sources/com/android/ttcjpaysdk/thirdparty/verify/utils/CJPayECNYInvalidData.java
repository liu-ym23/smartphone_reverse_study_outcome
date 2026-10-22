package com.android.ttcjpaysdk.thirdparty.verify.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/utils/CJPayECNYInvalidData;", "", "toastText", "", "statusText", "(Ljava/lang/String;Ljava/lang/String;)V", "getStatusText", "()Ljava/lang/String;", "getToastText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayECNYInvalidData {
    private final String statusText;
    private final String toastText;

    public static /* synthetic */ CJPayECNYInvalidData copy$default(CJPayECNYInvalidData r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.toastText;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.statusText;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.toastText;
    }

    public final String component2() {
        return this.statusText;
    }

    public final CJPayECNYInvalidData copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "toastText");
        Intrinsics.checkNotNullParameter(r101, "statusText");
        return new CJPayECNYInvalidData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayECNYInvalidData) == true) goto L8;
        return false;
    L8:
        CJPayECNYInvalidData r101 = (CJPayECNYInvalidData) r100;
        if (Intrinsics.areEqual(this.toastText, r101.toastText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusText, r101.statusText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.toastText.hashCode() * 31) + this.statusText.hashCode();
    }

    public String toString() {
        return "CJPayECNYInvalidData(toastText=" + this.toastText + ", statusText=" + this.statusText + ')';
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getToastText() {
        return this.toastText;
    }

    public CJPayECNYInvalidData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "toastText");
        Intrinsics.checkNotNullParameter(r101, "statusText");
        this.toastText = r100;
        this.statusText = r101;
    }
}
