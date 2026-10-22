package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes39.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    public static final class Builder {
        private float mEast;
        private float mNorth;
        private float mSouth;
        private float mWest;

        public FPointBounds build() {
            return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
        }

        public Builder() {
            this.mSouth = Float.POSITIVE_INFINITY;
            this.mNorth = Float.NEGATIVE_INFINITY;
            this.mWest = Float.POSITIVE_INFINITY;
            this.mEast = Float.NEGATIVE_INFINITY;
        }

        private boolean containsx(double r100) {
            float r101 = this.mWest;
            float r102 = this.mEast;
            if (r101 > r102) goto L11;
            if (r101 <= r100) goto L7;
            return false;
        L7:
            if (r100 > r102) goto L17;
            return true;
        L17:
            return false;
        L11:
            if (r101 > r100) goto L13;
        L14:
            return true;
        L13:
            if (r100 <= r102) goto L14;
            return false;
        }

        public Builder include(FPoint r100) {
            this.mSouth = Math.min(this.mSouth, ((PointF) r100).y);
            this.mNorth = Math.max(this.mNorth, ((PointF) r100).y);
            this.mWest = Math.min(this.mWest, ((PointF) r100).x);
            this.mEast = Math.max(this.mEast, ((PointF) r100).x);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String toString() {
        return "southwest = (" + ((PointF) this.southwest).x + "," + ((PointF) this.southwest).y + ") northeast = (" + ((PointF) this.northeast).x + "," + ((PointF) this.northeast).y + ")";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    private boolean containsx(double r100) {
        float r101 = ((PointF) this.southwest).x;
        float r102 = ((PointF) this.northeast).x;
        if (r101 > r102) goto L11;
        if (r101 <= r100) goto L7;
        return false;
    L7:
        if (r100 > r102) goto L17;
        return true;
    L17:
        return false;
    L11:
        if (r101 > r100) goto L13;
    L14:
        return true;
    L13:
        if (r100 <= r102) goto L14;
        return false;
    }

    private boolean containsy(double r100) {
        if (((PointF) this.southwest).y <= r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 > ((PointF) this.northeast).y) goto L7;
        return true;
    }

    private boolean intersect(FPointBounds r110) {
        if (r110 == null) goto L19;
        FPoint r100 = r110.northeast;
        if (r100 == null) goto L20;
        FPoint r111 = r110.southwest;
        if (r111 == null) goto L21;
        FPoint r101 = this.northeast;
        if (r101 == null) goto L22;
        FPoint r102 = this.southwest;
        if (r102 == null) goto L25;
        float r103 = ((PointF) r100).x;
        float r104 = ((PointF) r111).x + r103;
        float r105 = ((PointF) r101).x;
        float r106 = ((PointF) r102).x;
        double r107 = (r104 - r105) - r106;
        double r108 = ((r105 - r106) + r103) - r106;
        float r109 = ((PointF) r100).y;
        float r112 = ((PointF) r111).y;
        float r113 = ((PointF) r101).y;
        float r114 = ((PointF) r102).y;
        double r115 = ((r109 + r112) - r113) - r114;
        double r116 = ((r113 - r114) + r109) - r112;
        if (Math.abs(r107) < r108) goto L16;
        return false;
    L16:
        if (Math.abs(r115) >= r116) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    public boolean contains(FPoint r100) {
        if (containsy(((PointF) r100).y) == true) goto L5;
    L7:
        return false;
    L5:
        if (containsx(((PointF) r100).x) == false) goto L7;
        return true;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FPointBounds) == true) goto L8;
        return false;
    L8:
        FPointBounds r101 = (FPointBounds) r100;
        if (this.southwest.equals(r101.southwest) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.northeast.equals(r101.northeast) == false) goto L13;
        return true;
    }

    public boolean intersects(FPointBounds r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (intersect(r100) == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.intersect(this) == true) goto L9;
        return false;
    }

    public boolean contains(FPointBounds r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (contains(r100.southwest) == true) goto L8;
        return false;
    L8:
        if (contains(r100.northeast) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public FPointBounds(FPoint r100, FPoint r101) {
        this(1, r100, r101);
    }

    public FPointBounds(int r100, FPoint r101, FPoint r102) {
        this.mVersionCode = r100;
        this.southwest = r101;
        this.northeast = r102;
    }
}
