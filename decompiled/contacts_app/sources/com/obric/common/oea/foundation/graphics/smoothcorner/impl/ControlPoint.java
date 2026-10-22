package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import kotlin.Metadata;

/* JADX INFO: compiled from: ISmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ControlPoint;", "", "handleLarge", "", "distanceOuter", "distanceInner", "handleMedium", "curveInner", "curveOuter", "(FFFFFF)V", "getCurveInner", "()F", "getCurveOuter", "getDistanceInner", "getDistanceOuter", "getHandleLarge", "getHandleMedium", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ControlPoint {
    private final float curveInner;
    private final float curveOuter;
    private final float distanceInner;
    private final float distanceOuter;
    private final float handleLarge;
    private final float handleMedium;

    public static /* synthetic */ ControlPoint copy$default(ControlPoint r4, float r5, float r6, float r7, float r8, float r9, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.handleLarge;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.distanceOuter;
    L8:
        float r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.distanceInner;
    L11:
        float r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.handleMedium;
    L14:
        float r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.curveInner;
    L17:
        float r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.curveOuter;
    L20:
        float r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final float component1() {
        return this.handleLarge;
    }

    public final float component2() {
        return this.distanceOuter;
    }

    public final float component3() {
        return this.distanceInner;
    }

    public final float component4() {
        return this.handleMedium;
    }

    public final float component5() {
        return this.curveInner;
    }

    public final float component6() {
        return this.curveOuter;
    }

    public final ControlPoint copy(float r8, float r9, float r10, float r11, float r12, float r13) {
        return new ControlPoint(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ControlPoint) == false) goto L18;
        ControlPoint r4 = (ControlPoint) r3;
        if (Float.compare(this.handleLarge, r4.handleLarge) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.distanceOuter, r4.distanceOuter) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.distanceInner, r4.distanceInner) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.handleMedium, r4.handleMedium) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.curveInner, r4.curveInner) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.curveOuter, r4.curveOuter) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.handleLarge) * 31) + Float.hashCode(this.distanceOuter)) * 31) + Float.hashCode(this.distanceInner)) * 31) + Float.hashCode(this.handleMedium)) * 31) + Float.hashCode(this.curveInner)) * 31) + Float.hashCode(this.curveOuter);
    }

    public String toString() {
        return "ControlPoint(handleLarge=" + this.handleLarge + ", distanceOuter=" + this.distanceOuter + ", distanceInner=" + this.distanceInner + ", handleMedium=" + this.handleMedium + ", curveInner=" + this.curveInner + ", curveOuter=" + this.curveOuter + ")";
    }

    public ControlPoint(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.handleLarge = r1;
        this.distanceOuter = r2;
        this.distanceInner = r3;
        this.handleMedium = r4;
        this.curveInner = r5;
        this.curveOuter = r6;
    }

    public final float getHandleLarge() {
        return this.handleLarge;
    }

    public final float getDistanceOuter() {
        return this.distanceOuter;
    }

    public final float getDistanceInner() {
        return this.distanceInner;
    }

    public final float getHandleMedium() {
        return this.handleMedium;
    }

    public final float getCurveInner() {
        return this.curveInner;
    }

    public final float getCurveOuter() {
        return this.curveOuter;
    }
}
