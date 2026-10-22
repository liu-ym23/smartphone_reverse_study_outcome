package com.android.ttcjpaysdk.kmp.common.view.amount;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/ScrollPlan;", "", "digitPlans", "", "Lcom/android/ttcjpaysdk/kmp/common/view/amount/DigitScrollPlan;", "shouldAnimate", "", "<init>", "(Ljava/util/List;Z)V", "getDigitPlans", "()Ljava/util/List;", "getShouldAnimate", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ScrollPlan {
    private final List<DigitScrollPlan> digitPlans;
    private final boolean shouldAnimate;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScrollPlan copy$default(ScrollPlan r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.digitPlans;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.shouldAnimate;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<DigitScrollPlan> component1() {
        return this.digitPlans;
    }

    public final boolean component2() {
        return this.shouldAnimate;
    }

    public final ScrollPlan copy(List<DigitScrollPlan> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "digitPlans");
        return new ScrollPlan(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScrollPlan) == true) goto L8;
        return false;
    L8:
        ScrollPlan r101 = (ScrollPlan) r100;
        if (Intrinsics.areEqual(this.digitPlans, r101.digitPlans) == true) goto L12;
        return false;
    L12:
        if (this.shouldAnimate == r101.shouldAnimate) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.digitPlans.hashCode() * 31;
        if (this.shouldAnimate == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "ScrollPlan(digitPlans=" + this.digitPlans + ", shouldAnimate=" + this.shouldAnimate + ')';
    }

    public final List<DigitScrollPlan> getDigitPlans() {
        return this.digitPlans;
    }

    public final boolean getShouldAnimate() {
        return this.shouldAnimate;
    }

    public ScrollPlan(List<DigitScrollPlan> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "digitPlans");
        this.digitPlans = r100;
        this.shouldAnimate = r101;
    }
}
