package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.operation;

import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.OptionShowInfoStorage;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.UnifyPayHomepageState;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/operation/CJOperationViewConfig;", "", "cashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "curPaymentMethodInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "optionShowInfoStorage", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/OptionShowInfoStorage;", "homepageState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "(Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/OptionShowInfoStorage;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;)V", "getCashierRenderInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "setCashierRenderInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;)V", "getCurPaymentMethodInfo", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "setCurPaymentMethodInfo", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;)V", "getHomepageState", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "setHomepageState", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;)V", "getOptionShowInfoStorage", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/OptionShowInfoStorage;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOperationViewConfig {
    private UnifyCashierRenderInfo cashierRenderInfo;
    private CJUnifyPayMethodTuple curPaymentMethodInfo;
    private UnifyPayHomepageState homepageState;
    private final OptionShowInfoStorage optionShowInfoStorage;

    public static /* synthetic */ CJOperationViewConfig copy$default(CJOperationViewConfig r100, UnifyCashierRenderInfo r101, CJUnifyPayMethodTuple r102, OptionShowInfoStorage r103, UnifyPayHomepageState r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.cashierRenderInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.curPaymentMethodInfo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.optionShowInfoStorage;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.homepageState;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final UnifyCashierRenderInfo component1() {
        return this.cashierRenderInfo;
    }

    public final CJUnifyPayMethodTuple component2() {
        return this.curPaymentMethodInfo;
    }

    public final OptionShowInfoStorage component3() {
        return this.optionShowInfoStorage;
    }

    public final UnifyPayHomepageState component4() {
        return this.homepageState;
    }

    public final CJOperationViewConfig copy(UnifyCashierRenderInfo r100, CJUnifyPayMethodTuple r101, OptionShowInfoStorage r102, UnifyPayHomepageState r103) {
        Intrinsics.checkNotNullParameter(r102, "optionShowInfoStorage");
        return new CJOperationViewConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJOperationViewConfig) == true) goto L8;
        return false;
    L8:
        CJOperationViewConfig r101 = (CJOperationViewConfig) r100;
        if (Intrinsics.areEqual(this.cashierRenderInfo, r101.cashierRenderInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.curPaymentMethodInfo, r101.curPaymentMethodInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.optionShowInfoStorage, r101.optionShowInfoStorage) == true) goto L18;
        return false;
    L18:
        if (this.homepageState == r101.homepageState) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        UnifyCashierRenderInfo r100 = this.cashierRenderInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CJUnifyPayMethodTuple r104 = this.curPaymentMethodInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.optionShowInfoStorage.hashCode()) * 31;
        UnifyPayHomepageState r107 = this.homepageState;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJOperationViewConfig(cashierRenderInfo=" + this.cashierRenderInfo + ", curPaymentMethodInfo=" + this.curPaymentMethodInfo + ", optionShowInfoStorage=" + this.optionShowInfoStorage + ", homepageState=" + this.homepageState + ')';
    }

    public final UnifyCashierRenderInfo getCashierRenderInfo() {
        return this.cashierRenderInfo;
    }

    public final CJUnifyPayMethodTuple getCurPaymentMethodInfo() {
        return this.curPaymentMethodInfo;
    }

    public final UnifyPayHomepageState getHomepageState() {
        return this.homepageState;
    }

    public final OptionShowInfoStorage getOptionShowInfoStorage() {
        return this.optionShowInfoStorage;
    }

    public final void setCashierRenderInfo(UnifyCashierRenderInfo r100) {
        this.cashierRenderInfo = r100;
    }

    public final void setCurPaymentMethodInfo(CJUnifyPayMethodTuple r100) {
        this.curPaymentMethodInfo = r100;
    }

    public final void setHomepageState(UnifyPayHomepageState r100) {
        this.homepageState = r100;
    }

    public CJOperationViewConfig(UnifyCashierRenderInfo r100, CJUnifyPayMethodTuple r101, OptionShowInfoStorage r102, UnifyPayHomepageState r103) {
        Intrinsics.checkNotNullParameter(r102, "optionShowInfoStorage");
        this.cashierRenderInfo = r100;
        this.curPaymentMethodInfo = r101;
        this.optionShowInfoStorage = r102;
        this.homepageState = r103;
    }
}
