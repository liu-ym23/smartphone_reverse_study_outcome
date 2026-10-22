package com.android.ttcjpaysdk.bdpay.counter.outer.independent.ultra;

import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.android.ttcjpaysdk.bdpay.counter.outer.utils.CJPayPaymentMethodUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayAddiParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003JG\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001f\u001a\u00020-J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00062"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/ultra/OFullScreenPageState;", "", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "payMethodTuple", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/ultra/OPayMethodTuple;", "useRetainReward", "", "hasRetainRewardChange", "payAddiInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAddiParams;", "payXRecChecked", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/ultra/OPayMethodTuple;ZZLcom/android/ttcjpaysdk/thirdparty/data/CJPayAddiParams;Z)V", "getCheckoutResponseBean", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "setCheckoutResponseBean", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;)V", "getHasRetainRewardChange", "()Z", "setHasRetainRewardChange", "(Z)V", "getPayAddiInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAddiParams;", "setPayAddiInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAddiParams;)V", "getPayMethodTuple", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/ultra/OPayMethodTuple;", "setPayMethodTuple", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/ultra/OPayMethodTuple;)V", "getPayXRecChecked", "setPayXRecChecked", "getUseRetainReward", "setUseRetainReward", "changeAddiSwitch", "", "isChecked", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayPaymentMethodUtils$RetainRewardBean;", "hashCode", "", "toString", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFullScreenPageState {
    private CJPayCheckoutCounterResponseBean checkoutResponseBean;
    private boolean hasRetainRewardChange;
    private CJPayAddiParams payAddiInfo;
    private OPayMethodTuple payMethodTuple;
    private boolean payXRecChecked;
    private boolean useRetainReward;

    public static /* synthetic */ OFullScreenPageState copy$default(OFullScreenPageState r100, CJPayCheckoutCounterResponseBean r101, OPayMethodTuple r102, boolean r103, boolean r104, CJPayAddiParams r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.checkoutResponseBean;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.payMethodTuple;
    L8:
        OPayMethodTuple r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.useRetainReward;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.hasRetainRewardChange;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.payAddiInfo;
    L17:
        CJPayAddiParams r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.payXRecChecked;
    L20:
        CJPayCheckoutCounterResponseBean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final CJPayCheckoutCounterResponseBean component1() {
        return this.checkoutResponseBean;
    }

    public final OPayMethodTuple component2() {
        return this.payMethodTuple;
    }

    public final boolean component3() {
        return this.useRetainReward;
    }

    public final boolean component4() {
        return this.hasRetainRewardChange;
    }

    public final CJPayAddiParams component5() {
        return this.payAddiInfo;
    }

    public final boolean component6() {
        return this.payXRecChecked;
    }

    public final OFullScreenPageState copy(CJPayCheckoutCounterResponseBean r100, OPayMethodTuple r110, boolean r111, boolean r112, CJPayAddiParams r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "checkoutResponseBean");
        Intrinsics.checkNotNullParameter(r113, "payAddiInfo");
        return new OFullScreenPageState(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OFullScreenPageState) == true) goto L8;
        return false;
    L8:
        OFullScreenPageState r101 = (OFullScreenPageState) r100;
        if (Intrinsics.areEqual(this.checkoutResponseBean, r101.checkoutResponseBean) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.payMethodTuple, r101.payMethodTuple) == true) goto L15;
        return false;
    L15:
        if (this.useRetainReward == r101.useRetainReward) goto L18;
        return false;
    L18:
        if (this.hasRetainRewardChange == r101.hasRetainRewardChange) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.payAddiInfo, r101.payAddiInfo) == true) goto L24;
        return false;
    L24:
        if (this.payXRecChecked == r101.payXRecChecked) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.checkoutResponseBean.hashCode() * 31;
        OPayMethodTuple r101 = this.payMethodTuple;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.useRetainReward == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.hasRetainRewardChange == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r106 + r107) * 31) + this.payAddiInfo.hashCode()) * 31;
        if (this.payXRecChecked == true) goto L19;
        r104 = 1237;
    L19:
        return r108 + r104;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OFullScreenPageState(checkoutResponseBean=" + this.checkoutResponseBean + ", payMethodTuple=" + this.payMethodTuple + ", useRetainReward=" + this.useRetainReward + ", hasRetainRewardChange=" + this.hasRetainRewardChange + ", payAddiInfo=" + this.payAddiInfo + ", payXRecChecked=" + this.payXRecChecked + ')';
    }

    public final CJPayPaymentMethodUtils.RetainRewardBean getUseRetainReward() {
        return new CJPayPaymentMethodUtils.RetainRewardBean(this.useRetainReward, this.hasRetainRewardChange, this.payAddiInfo.isUseAddiVoucher());
    }

    public final CJPayCheckoutCounterResponseBean getCheckoutResponseBean() {
        return this.checkoutResponseBean;
    }

    public final boolean getHasRetainRewardChange() {
        return this.hasRetainRewardChange;
    }

    public final CJPayAddiParams getPayAddiInfo() {
        return this.payAddiInfo;
    }

    public final OPayMethodTuple getPayMethodTuple() {
        return this.payMethodTuple;
    }

    public final boolean getPayXRecChecked() {
        return this.payXRecChecked;
    }

    /* JADX INFO: renamed from: getUseRetainReward, reason: collision with other method in class */
    public final boolean m8052getUseRetainReward() {
        return this.useRetainReward;
    }

    public final void changeAddiSwitch(boolean r100) {
        CJPayAddiItemInfo r101 = this.payAddiInfo.getAddiItemInfo();
        if (r101 == null) goto L9;
        this.payAddiInfo.setInfo(r100, r101);
        CJPayAddiItemInfo r102 = this.payAddiInfo.getAddiItemInfo();
        if (r102 == null) goto L10;
        r102.choose = r100;
        return;
    L10:
        return;
    }

    public final void setCheckoutResponseBean(CJPayCheckoutCounterResponseBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.checkoutResponseBean = r100;
    }

    public final void setHasRetainRewardChange(boolean r100) {
        this.hasRetainRewardChange = r100;
    }

    public final void setPayAddiInfo(CJPayAddiParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.payAddiInfo = r100;
    }

    public final void setPayMethodTuple(OPayMethodTuple r100) {
        this.payMethodTuple = r100;
    }

    public final void setPayXRecChecked(boolean r100) {
        this.payXRecChecked = r100;
    }

    public final void setUseRetainReward(boolean r100) {
        this.useRetainReward = r100;
    }

    public OFullScreenPageState(CJPayCheckoutCounterResponseBean r100, OPayMethodTuple r101, boolean r102, boolean r103, CJPayAddiParams r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "checkoutResponseBean");
        Intrinsics.checkNotNullParameter(r104, "payAddiInfo");
        this.checkoutResponseBean = r100;
        this.payMethodTuple = r101;
        this.useRetainReward = r102;
        this.hasRetainRewardChange = r103;
        this.payAddiInfo = r104;
        this.payXRecChecked = r105;
    }

    public /* synthetic */ OFullScreenPageState(CJPayCheckoutCounterResponseBean r100, OPayMethodTuple r101, boolean r110, boolean r111, CJPayAddiParams r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        r101 = null;
    L5:
        OPayMethodTuple r102 = r101;
        if ((r114 & 4) == 0) goto L8;
        boolean r103 = false;
    L10:
        if ((r114 & 8) == 0) goto L12;
        boolean r104 = false;
    L14:
        if ((r114 & 16) == 0) goto L16;
        r112 = new CJPayAddiParams();
    L16:
        CJPayAddiParams r105 = r112;
        if ((r114 & 32) == 0) goto L19;
        boolean r106 = false;
    L20:
        this(r100, r102, r103, r104, r105, r106);
        return;
    L19:
        r106 = r113;
        goto L20
    L12:
        r104 = r111;
        goto L14
    L8:
        r103 = r110;
        goto L10
    }
}
