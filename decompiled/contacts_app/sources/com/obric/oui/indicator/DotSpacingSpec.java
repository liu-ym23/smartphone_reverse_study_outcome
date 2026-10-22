package com.obric.oui.indicator;

import kotlin.Metadata;

/* JADX INFO: compiled from: OBaseIndicator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/indicator/DotSpacingSpec;", "", "startMargin", "", "endMargin", "(II)V", "getEndMargin", "()I", "getStartMargin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DotSpacingSpec {
    private final int endMargin;
    private final int startMargin;

    public static /* synthetic */ DotSpacingSpec copy$default(DotSpacingSpec r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.startMargin;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.endMargin;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.startMargin;
    }

    public final int component2() {
        return this.endMargin;
    }

    public final DotSpacingSpec copy(int r1, int r2) {
        return new DotSpacingSpec(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DotSpacingSpec) == true) goto L8;
        return false;
    L8:
        DotSpacingSpec r6 = (DotSpacingSpec) r5;
        if (this.startMargin == r6.startMargin) goto L12;
        return false;
    L12:
        if (this.endMargin == r6.endMargin) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.startMargin) * 31) + Integer.hashCode(this.endMargin);
    }

    public String toString() {
        return "DotSpacingSpec(startMargin=" + this.startMargin + ", endMargin=" + this.endMargin + ')';
    }

    public DotSpacingSpec(int r1, int r2) {
        this.startMargin = r1;
        this.endMargin = r2;
    }

    public final int getStartMargin() {
        return this.startMargin;
    }

    public final int getEndMargin() {
        return this.endMargin;
    }
}
