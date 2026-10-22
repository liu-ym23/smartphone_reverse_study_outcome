package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import com.android.ttcjpaysdk.base.ui.data.PayNewCardReconfirmInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayBindCardReconfirmSlice;", "", "payNewCardReconfirmInfo", "Lcom/android/ttcjpaysdk/base/ui/data/PayNewCardReconfirmInfo;", "nextPage", "", "isFrontHomepageMode", "", "(Lcom/android/ttcjpaysdk/base/ui/data/PayNewCardReconfirmInfo;Ljava/lang/String;Z)V", "()Z", "getNextPage", "()Ljava/lang/String;", "getPayNewCardReconfirmInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/PayNewCardReconfirmInfo;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPrePayBindCardReconfirmSlice {
    private final boolean isFrontHomepageMode;
    private final String nextPage;
    private final PayNewCardReconfirmInfo payNewCardReconfirmInfo;

    public CJUnifyPrePayBindCardReconfirmSlice() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ CJUnifyPrePayBindCardReconfirmSlice copy$default(CJUnifyPrePayBindCardReconfirmSlice r100, PayNewCardReconfirmInfo r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.payNewCardReconfirmInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.nextPage;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isFrontHomepageMode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final PayNewCardReconfirmInfo component1() {
        return this.payNewCardReconfirmInfo;
    }

    public final String component2() {
        return this.nextPage;
    }

    public final boolean component3() {
        return this.isFrontHomepageMode;
    }

    public final CJUnifyPrePayBindCardReconfirmSlice copy(PayNewCardReconfirmInfo r100, String r101, boolean r102) {
        return new CJUnifyPrePayBindCardReconfirmSlice(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyPrePayBindCardReconfirmSlice) == true) goto L8;
        return false;
    L8:
        CJUnifyPrePayBindCardReconfirmSlice r101 = (CJUnifyPrePayBindCardReconfirmSlice) r100;
        if (Intrinsics.areEqual(this.payNewCardReconfirmInfo, r101.payNewCardReconfirmInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nextPage, r101.nextPage) == true) goto L15;
        return false;
    L15:
        if (this.isFrontHomepageMode == r101.isFrontHomepageMode) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        PayNewCardReconfirmInfo r100 = this.payNewCardReconfirmInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.nextPage;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.isFrontHomepageMode == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJUnifyPrePayBindCardReconfirmSlice(payNewCardReconfirmInfo=" + this.payNewCardReconfirmInfo + ", nextPage=" + this.nextPage + ", isFrontHomepageMode=" + this.isFrontHomepageMode + ')';
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final PayNewCardReconfirmInfo getPayNewCardReconfirmInfo() {
        return this.payNewCardReconfirmInfo;
    }

    public final boolean isFrontHomepageMode() {
        return this.isFrontHomepageMode;
    }

    public CJUnifyPrePayBindCardReconfirmSlice(PayNewCardReconfirmInfo r100, String r101, boolean r102) {
        this.payNewCardReconfirmInfo = r100;
        this.nextPage = r101;
        this.isFrontHomepageMode = r102;
    }

    public /* synthetic */ CJUnifyPrePayBindCardReconfirmSlice(PayNewCardReconfirmInfo r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
