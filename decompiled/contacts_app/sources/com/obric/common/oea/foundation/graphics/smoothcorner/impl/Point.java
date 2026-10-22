package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/Point;", "", MaterialConfigFormatNames.X, "", MaterialConfigFormatNames.Y, "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class Point {
    private final float x;
    private final float y;

    public static /* synthetic */ Point copy$default(Point r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.x;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.y;
    L9:
        return r0.copy(r1, r2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final Point copy(float r1, float r2) {
        return new Point(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Point) == false) goto L10;
        Point r4 = (Point) r3;
        if (Float.compare(this.x, r4.x) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.y, r4.y) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "Point(x=" + this.x + ", y=" + this.y + ")";
    }

    public Point(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }
}
