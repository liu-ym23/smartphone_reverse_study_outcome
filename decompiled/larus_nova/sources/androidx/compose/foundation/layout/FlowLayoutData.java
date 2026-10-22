package androidx.compose.foundation.layout;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutData;", "", "fillCrossAxisFraction", "", "<init>", "(F)V", "getFillCrossAxisFraction", "()F", "setFillCrossAxisFraction", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutData {
    public static final int $stable = 8;
    private float fillCrossAxisFraction;

    public static /* synthetic */ FlowLayoutData copy$default(FlowLayoutData r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.fillCrossAxisFraction;
    L6:
        return r100.copy(r101);
    }

    public final float component1() {
        return this.fillCrossAxisFraction;
    }

    public final FlowLayoutData copy(float r100) {
        return new FlowLayoutData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowLayoutData) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.fillCrossAxisFraction, ((FlowLayoutData) r100).fillCrossAxisFraction) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.fillCrossAxisFraction);
    }

    public String toString() {
        return "FlowLayoutData(fillCrossAxisFraction=" + this.fillCrossAxisFraction + ')';
    }

    public final float getFillCrossAxisFraction() {
        return this.fillCrossAxisFraction;
    }

    public FlowLayoutData(float r100) {
        this.fillCrossAxisFraction = r100;
    }

    public final void setFillCrossAxisFraction(float r100) {
        this.fillCrossAxisFraction = r100;
    }
}
