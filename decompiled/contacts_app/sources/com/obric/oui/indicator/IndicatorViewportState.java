package com.obric.oui.indicator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: IndicatorViewportState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/indicator/IndicatorViewportState;", "", "totalCount", "", "selectedIndex", "visibleRange", "Lkotlin/ranges/IntRange;", "(IILkotlin/ranges/IntRange;)V", "getSelectedIndex", "()I", "getTotalCount", "getVisibleRange", "()Lkotlin/ranges/IntRange;", "component1", "component2", "component3", "copy", "dotVisualStateAt", "Lcom/obric/oui/indicator/IndicatorDotVisualState;", "index", "equals", "", "other", "hashCode", "isVisible", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorViewportState {
    private final int selectedIndex;
    private final int totalCount;
    private final IntRange visibleRange;

    public static /* synthetic */ IndicatorViewportState copy$default(IndicatorViewportState r0, int r1, int r2, IntRange r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.totalCount;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.selectedIndex;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.visibleRange;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.totalCount;
    }

    public final int component2() {
        return this.selectedIndex;
    }

    public final IntRange component3() {
        return this.visibleRange;
    }

    public final IndicatorViewportState copy(int r1, int r2, IntRange r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleRange");
        return new IndicatorViewportState(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IndicatorViewportState) == true) goto L8;
        return false;
    L8:
        IndicatorViewportState r6 = (IndicatorViewportState) r5;
        if (this.totalCount == r6.totalCount) goto L12;
        return false;
    L12:
        if (this.selectedIndex == r6.selectedIndex) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.visibleRange, r6.visibleRange) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.totalCount) * 31) + Integer.hashCode(this.selectedIndex)) * 31) + this.visibleRange.hashCode();
    }

    public String toString() {
        return "IndicatorViewportState(totalCount=" + this.totalCount + ", selectedIndex=" + this.selectedIndex + ", visibleRange=" + this.visibleRange + ')';
    }

    public IndicatorViewportState(int r2, int r3, IntRange r4) {
        Intrinsics.checkNotNullParameter(r4, "visibleRange");
        this.totalCount = r2;
        this.selectedIndex = r3;
        this.visibleRange = r4;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final IntRange getVisibleRange() {
        return this.visibleRange;
    }

    public final IndicatorDotVisualState dotVisualStateAt(int r6) {
        IntRange r0 = this.visibleRange;
        int r1 = r0.getFirst();
        boolean r3 = true;
        if (r6 > r0.getLast()) goto L6;
        if (r1 > r6) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L11;
        return IndicatorDotVisualState.HIDDEN;
    L11:
        if (r6 != this.selectedIndex) goto L15;
        return IndicatorDotVisualState.ACTIVE;
    L15:
        if (r6 == r0.getFirst()) goto L17;
    L19:
        boolean r4 = false;
    L21:
        if (r6 == r0.getLast()) goto L23;
    L25:
        r3 = false;
    L26:
        if (r4 == true) goto L31;
        if (r3 == true) goto L31;
        return IndicatorDotVisualState.NORMAL;
    L31:
        return IndicatorDotVisualState.EDGE;
    L23:
        if (r0.getLast() >= (this.totalCount - 1)) goto L25;
    L17:
        if (r0.getFirst() <= 0) goto L19;
        r4 = true;
    L6:
        r2 = false;
        goto L7
    }

    public final boolean isVisible(int r3) {
        IntRange r2 = this.visibleRange;
        int r0 = r2.getFirst();
        if (r3 > r2.getLast()) goto L7;
        if (r0 > r3) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }
}
