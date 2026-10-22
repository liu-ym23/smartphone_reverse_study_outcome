package com.obric.ui.popover;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OffsetInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/ui/popover/OffsetInfo;", "", "xOffset", "", "yOffset", "arrowOffset", "", "(IIF)V", "getArrowOffset", "()F", "setArrowOffset", "(F)V", "getXOffset", "()I", "setXOffset", "(I)V", "getYOffset", "setYOffset", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OffsetInfo {
    private float arrowOffset;
    private int xOffset;
    private int yOffset;

    public OffsetInfo() {
        this(0, 0, 0.0f, 7, null);
    }

    public static /* synthetic */ OffsetInfo copy$default(OffsetInfo r0, int r1, int r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.xOffset;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.yOffset;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.arrowOffset;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.xOffset;
    }

    public final int component2() {
        return this.yOffset;
    }

    public final float component3() {
        return this.arrowOffset;
    }

    public final OffsetInfo copy(int r1, int r2, float r3) {
        return new OffsetInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OffsetInfo) == true) goto L8;
        return false;
    L8:
        OffsetInfo r6 = (OffsetInfo) r5;
        if (this.xOffset == r6.xOffset) goto L12;
        return false;
    L12:
        if (this.yOffset == r6.yOffset) goto L15;
        return false;
    L15:
        if (Float.compare(this.arrowOffset, r6.arrowOffset) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.xOffset) * 31) + Integer.hashCode(this.yOffset)) * 31) + Float.hashCode(this.arrowOffset);
    }

    public String toString() {
        return "OffsetInfo(xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", arrowOffset=" + this.arrowOffset + ')';
    }

    public OffsetInfo(int r1, int r2, float r3) {
        this.xOffset = r1;
        this.yOffset = r2;
        this.arrowOffset = r3;
    }

    public /* synthetic */ OffsetInfo(int r2, int r3, float r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0.0f;
    L11:
        this(r2, r3, r4);
    }

    public final int getXOffset() {
        return this.xOffset;
    }

    public final void setXOffset(int r1) {
        this.xOffset = r1;
    }

    public final int getYOffset() {
        return this.yOffset;
    }

    public final void setYOffset(int r1) {
        this.yOffset = r1;
    }

    public final float getArrowOffset() {
        return this.arrowOffset;
    }

    public final void setArrowOffset(float r1) {
        this.arrowOffset = r1;
    }
}
