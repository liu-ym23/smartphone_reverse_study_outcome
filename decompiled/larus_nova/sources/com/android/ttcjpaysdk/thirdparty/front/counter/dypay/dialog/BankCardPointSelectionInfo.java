package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "", "leftTitle", "", "rightTitle", "isChecked", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getLeftTitle", "()Ljava/lang/String;", "getRightTitle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BankCardPointSelectionInfo {
    private final boolean isChecked;
    private final String leftTitle;
    private final String rightTitle;

    public static /* synthetic */ BankCardPointSelectionInfo copy$default(BankCardPointSelectionInfo r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.leftTitle;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.rightTitle;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isChecked;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.leftTitle;
    }

    public final String component2() {
        return this.rightTitle;
    }

    public final boolean component3() {
        return this.isChecked;
    }

    public final BankCardPointSelectionInfo copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "leftTitle");
        Intrinsics.checkNotNullParameter(r101, "rightTitle");
        return new BankCardPointSelectionInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BankCardPointSelectionInfo) == true) goto L8;
        return false;
    L8:
        BankCardPointSelectionInfo r101 = (BankCardPointSelectionInfo) r100;
        if (Intrinsics.areEqual(this.leftTitle, r101.leftTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightTitle, r101.rightTitle) == true) goto L15;
        return false;
    L15:
        if (this.isChecked == r101.isChecked) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.leftTitle.hashCode() * 31) + this.rightTitle.hashCode()) * 31;
        if (this.isChecked == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "BankCardPointSelectionInfo(leftTitle=" + this.leftTitle + ", rightTitle=" + this.rightTitle + ", isChecked=" + this.isChecked + ')';
    }

    public final String getLeftTitle() {
        return this.leftTitle;
    }

    public final String getRightTitle() {
        return this.rightTitle;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public BankCardPointSelectionInfo(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "leftTitle");
        Intrinsics.checkNotNullParameter(r101, "rightTitle");
        this.leftTitle = r100;
        this.rightTitle = r101;
        this.isChecked = r102;
    }
}
