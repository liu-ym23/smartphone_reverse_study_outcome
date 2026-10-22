package androidx.compose.material3.carousel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/carousel/ShiftPointRange;", "", "fromStepIndex", "", "toStepIndex", "steppedInterpolation", "", "<init>", "(IIF)V", "getFromStepIndex", "()I", "getToStepIndex", "getSteppedInterpolation", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ShiftPointRange {
    private final int fromStepIndex;
    private final float steppedInterpolation;
    private final int toStepIndex;

    public static /* synthetic */ ShiftPointRange copy$default(ShiftPointRange r100, int r101, int r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.fromStepIndex;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.toStepIndex;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.steppedInterpolation;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.fromStepIndex;
    }

    public final int component2() {
        return this.toStepIndex;
    }

    public final float component3() {
        return this.steppedInterpolation;
    }

    public final ShiftPointRange copy(int r100, int r101, float r102) {
        return new ShiftPointRange(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShiftPointRange) == true) goto L8;
        return false;
    L8:
        ShiftPointRange r101 = (ShiftPointRange) r100;
        if (this.fromStepIndex == r101.fromStepIndex) goto L12;
        return false;
    L12:
        if (this.toStepIndex == r101.toStepIndex) goto L15;
        return false;
    L15:
        if (Float.compare(this.steppedInterpolation, r101.steppedInterpolation) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.fromStepIndex * 31) + this.toStepIndex) * 31) + Float.floatToIntBits(this.steppedInterpolation);
    }

    public String toString() {
        return "ShiftPointRange(fromStepIndex=" + this.fromStepIndex + ", toStepIndex=" + this.toStepIndex + ", steppedInterpolation=" + this.steppedInterpolation + ')';
    }

    public final int getFromStepIndex() {
        return this.fromStepIndex;
    }

    public final float getSteppedInterpolation() {
        return this.steppedInterpolation;
    }

    public final int getToStepIndex() {
        return this.toStepIndex;
    }

    public ShiftPointRange(int r100, int r101, float r102) {
        this.fromStepIndex = r100;
        this.toStepIndex = r101;
        this.steppedInterpolation = r102;
    }
}
