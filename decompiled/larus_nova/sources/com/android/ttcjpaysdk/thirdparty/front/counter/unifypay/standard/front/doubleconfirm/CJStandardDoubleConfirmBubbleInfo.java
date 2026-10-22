package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.front.doubleconfirm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\rJ\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/front/doubleconfirm/CJStandardDoubleConfirmBubbleInfo;", "", "bubbleIconUrl", "", "bubbleText", "(Ljava/lang/String;Ljava/lang/String;)V", "getBubbleIconUrl", "()Ljava/lang/String;", "getBubbleText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStandardDoubleConfirmBubbleInfo {
    private final String bubbleIconUrl;
    private final String bubbleText;

    public static /* synthetic */ CJStandardDoubleConfirmBubbleInfo copy$default(CJStandardDoubleConfirmBubbleInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bubbleIconUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bubbleText;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.bubbleIconUrl;
    }

    public final String component2() {
        return this.bubbleText;
    }

    public final CJStandardDoubleConfirmBubbleInfo copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bubbleIconUrl");
        Intrinsics.checkNotNullParameter(r101, "bubbleText");
        return new CJStandardDoubleConfirmBubbleInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJStandardDoubleConfirmBubbleInfo) == true) goto L8;
        return false;
    L8:
        CJStandardDoubleConfirmBubbleInfo r101 = (CJStandardDoubleConfirmBubbleInfo) r100;
        if (Intrinsics.areEqual(this.bubbleIconUrl, r101.bubbleIconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bubbleText, r101.bubbleText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.bubbleIconUrl.hashCode() * 31) + this.bubbleText.hashCode();
    }

    public String toString() {
        return "CJStandardDoubleConfirmBubbleInfo(bubbleIconUrl=" + this.bubbleIconUrl + ", bubbleText=" + this.bubbleText + ')';
    }

    public final boolean isValid() {
        if (this.bubbleText.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getBubbleIconUrl() {
        return this.bubbleIconUrl;
    }

    public final String getBubbleText() {
        return this.bubbleText;
    }

    public CJStandardDoubleConfirmBubbleInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bubbleIconUrl");
        Intrinsics.checkNotNullParameter(r101, "bubbleText");
        this.bubbleIconUrl = r100;
        this.bubbleText = r101;
    }
}
