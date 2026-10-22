package com.android.ttcjpaysdk.thirdparty.payagain.data;

import com.android.ttcjpaysdk.thirdparty.data.FrontVerifyPageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/data/TradeCreateAgainWrapper;", "", "response", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontVerifyPageInfo;", "hasOptionVoucher", "", "optionVoucherChecked", "optionVoucherKey", "", "(Lcom/android/ttcjpaysdk/thirdparty/data/FrontVerifyPageInfo;ZZLjava/lang/String;)V", "getHasOptionVoucher", "()Z", "setHasOptionVoucher", "(Z)V", "getOptionVoucherChecked", "setOptionVoucherChecked", "getOptionVoucherKey", "()Ljava/lang/String;", "setOptionVoucherKey", "(Ljava/lang/String;)V", "getResponse", "()Lcom/android/ttcjpaysdk/thirdparty/data/FrontVerifyPageInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TradeCreateAgainWrapper {
    private boolean hasOptionVoucher;
    private boolean optionVoucherChecked;
    private String optionVoucherKey;
    private final FrontVerifyPageInfo response;

    public static /* synthetic */ TradeCreateAgainWrapper copy$default(TradeCreateAgainWrapper r100, FrontVerifyPageInfo r101, boolean r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.response;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.hasOptionVoucher;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.optionVoucherChecked;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.optionVoucherKey;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final FrontVerifyPageInfo component1() {
        return this.response;
    }

    public final boolean component2() {
        return this.hasOptionVoucher;
    }

    public final boolean component3() {
        return this.optionVoucherChecked;
    }

    public final String component4() {
        return this.optionVoucherKey;
    }

    public final TradeCreateAgainWrapper copy(FrontVerifyPageInfo r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r103, "optionVoucherKey");
        return new TradeCreateAgainWrapper(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TradeCreateAgainWrapper) == true) goto L8;
        return false;
    L8:
        TradeCreateAgainWrapper r101 = (TradeCreateAgainWrapper) r100;
        if (Intrinsics.areEqual(this.response, r101.response) == true) goto L12;
        return false;
    L12:
        if (this.hasOptionVoucher == r101.hasOptionVoucher) goto L15;
        return false;
    L15:
        if (this.optionVoucherChecked == r101.optionVoucherChecked) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.optionVoucherKey, r101.optionVoucherKey) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.response.hashCode() * 31;
        int r101 = 1231;
        if (this.hasOptionVoucher == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.optionVoucherChecked == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.optionVoucherKey.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "TradeCreateAgainWrapper(response=" + this.response + ", hasOptionVoucher=" + this.hasOptionVoucher + ", optionVoucherChecked=" + this.optionVoucherChecked + ", optionVoucherKey=" + this.optionVoucherKey + ')';
    }

    public final boolean getHasOptionVoucher() {
        return this.hasOptionVoucher;
    }

    public final boolean getOptionVoucherChecked() {
        return this.optionVoucherChecked;
    }

    public final String getOptionVoucherKey() {
        return this.optionVoucherKey;
    }

    public final FrontVerifyPageInfo getResponse() {
        return this.response;
    }

    public final void setHasOptionVoucher(boolean r100) {
        this.hasOptionVoucher = r100;
    }

    public final void setOptionVoucherChecked(boolean r100) {
        this.optionVoucherChecked = r100;
    }

    public final void setOptionVoucherKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.optionVoucherKey = r100;
    }

    public TradeCreateAgainWrapper(FrontVerifyPageInfo r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r103, "optionVoucherKey");
        this.response = r100;
        this.hasOptionVoucher = r101;
        this.optionVoucherChecked = r102;
        this.optionVoucherKey = r103;
    }

    public /* synthetic */ TradeCreateAgainWrapper(FrontVerifyPageInfo r100, boolean r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "";
    L11:
        this(r100, r101, r102, r103);
    }
}
