package com.android.ttcjpaysdk.kmp.common.view.amount;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/DigitTrim;", "", "topPx", "", "bottomPx", "<init>", "(FF)V", "getTopPx", "()F", "getBottomPx", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DigitTrim {
    private final float bottomPx;
    private final float topPx;

    public static /* synthetic */ DigitTrim copy$default(DigitTrim r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.topPx;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bottomPx;
    L9:
        return r100.copy(r101, r102);
    }

    public final float component1() {
        return this.topPx;
    }

    public final float component2() {
        return this.bottomPx;
    }

    public final DigitTrim copy(float r100, float r101) {
        return new DigitTrim(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DigitTrim) == true) goto L8;
        return false;
    L8:
        DigitTrim r101 = (DigitTrim) r100;
        if (Float.compare(this.topPx, r101.topPx) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.bottomPx, r101.bottomPx) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.topPx) * 31) + Float.floatToIntBits(this.bottomPx);
    }

    public String toString() {
        return "DigitTrim(topPx=" + this.topPx + ", bottomPx=" + this.bottomPx + ')';
    }

    public final float getBottomPx() {
        return this.bottomPx;
    }

    public final float getTopPx() {
        return this.topPx;
    }

    public DigitTrim(float r100, float r101) {
        this.topPx = r100;
        this.bottomPx = r101;
    }
}
