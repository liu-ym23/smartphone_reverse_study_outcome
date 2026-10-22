package com.android.ttcjpaysdk.kmp.common.view.amount;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/DigitScrollPlan;", "", "digits", "", "", "isStatic", "", "<init>", "(Ljava/util/List;Z)V", "getDigits", "()Ljava/util/List;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DigitScrollPlan {
    private final List<Integer> digits;
    private final boolean isStatic;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DigitScrollPlan copy$default(DigitScrollPlan r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.digits;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isStatic;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<Integer> component1() {
        return this.digits;
    }

    public final boolean component2() {
        return this.isStatic;
    }

    public final DigitScrollPlan copy(List<Integer> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "digits");
        return new DigitScrollPlan(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DigitScrollPlan) == true) goto L8;
        return false;
    L8:
        DigitScrollPlan r101 = (DigitScrollPlan) r100;
        if (Intrinsics.areEqual(this.digits, r101.digits) == true) goto L12;
        return false;
    L12:
        if (this.isStatic == r101.isStatic) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.digits.hashCode() * 31;
        if (this.isStatic == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "DigitScrollPlan(digits=" + this.digits + ", isStatic=" + this.isStatic + ')';
    }

    public final List<Integer> getDigits() {
        return this.digits;
    }

    public final boolean isStatic() {
        return this.isStatic;
    }

    public DigitScrollPlan(List<Integer> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "digits");
        this.digits = r100;
        this.isStatic = r101;
    }
}
