package com.android.ttcjpaysdk.kmp.common.view.amount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/FixedDecimalAmount;", "", "isNegative", "", "integerPart", "", "fractionalPart", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getIntegerPart", "()Ljava/lang/String;", "getFractionalPart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FixedDecimalAmount {
    private final String fractionalPart;
    private final String integerPart;
    private final boolean isNegative;

    public static /* synthetic */ FixedDecimalAmount copy$default(FixedDecimalAmount r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isNegative;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.integerPart;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.fractionalPart;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isNegative;
    }

    public final String component2() {
        return this.integerPart;
    }

    public final String component3() {
        return this.fractionalPart;
    }

    public final FixedDecimalAmount copy(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "integerPart");
        Intrinsics.checkNotNullParameter(r102, "fractionalPart");
        return new FixedDecimalAmount(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FixedDecimalAmount) == true) goto L8;
        return false;
    L8:
        FixedDecimalAmount r101 = (FixedDecimalAmount) r100;
        if (this.isNegative == r101.isNegative) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.integerPart, r101.integerPart) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fractionalPart, r101.fractionalPart) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isNegative == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.integerPart.hashCode()) * 31) + this.fractionalPart.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "FixedDecimalAmount(isNegative=" + this.isNegative + ", integerPart=" + this.integerPart + ", fractionalPart=" + this.fractionalPart + ')';
    }

    public final String getFractionalPart() {
        return this.fractionalPart;
    }

    public final String getIntegerPart() {
        return this.integerPart;
    }

    public final boolean isNegative() {
        return this.isNegative;
    }

    public FixedDecimalAmount(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "integerPart");
        Intrinsics.checkNotNullParameter(r102, "fractionalPart");
        this.isNegative = r100;
        this.integerPart = r101;
        this.fractionalPart = r102;
    }
}
