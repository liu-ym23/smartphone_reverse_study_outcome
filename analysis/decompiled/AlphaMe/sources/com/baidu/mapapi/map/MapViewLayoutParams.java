package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup;
import com.baidu.mapapi.model.LatLng;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class MapViewLayoutParams extends ViewGroup.LayoutParams {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* renamed from: a, reason: collision with root package name */
    LatLng f6583a;

    /* renamed from: b, reason: collision with root package name */
    Point f6584b;

    /* renamed from: c, reason: collision with root package name */
    ELayoutMode f6585c;

    /* renamed from: d, reason: collision with root package name */
    float f6586d;

    /* renamed from: e, reason: collision with root package name */
    float f6587e;

    /* renamed from: f, reason: collision with root package name */
    int f6588f;

    /* renamed from: g, reason: collision with root package name */
    int f6589g;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f6590a;

        /* renamed from: b, reason: collision with root package name */
        private int f6591b;

        /* renamed from: c, reason: collision with root package name */
        private LatLng f6592c;

        /* renamed from: d, reason: collision with root package name */
        private Point f6593d;

        /* renamed from: e, reason: collision with root package name */
        private ELayoutMode f6594e = ELayoutMode.absoluteMode;

        /* renamed from: f, reason: collision with root package name */
        private int f6595f = 4;

        /* renamed from: g, reason: collision with root package name */
        private int f6596g = 16;

        /* renamed from: h, reason: collision with root package name */
        private int f6597h;

        /* renamed from: i, reason: collision with root package name */
        private int f6598i;

        public Builder align(int i4, int i5) {
            if (i4 == 1 || i4 == 2 || i4 == 4) {
                this.f6595f = i4;
            }
            if (i5 == 8 || i5 == 16 || i5 == 32) {
                this.f6596g = i5;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f6594e;
            if (eLayoutMode != ELayoutMode.mapMode ? !(eLayoutMode == ELayoutMode.absoluteMode && this.f6593d == null) : this.f6592c != null) {
                return new MapViewLayoutParams(this.f6590a, this.f6591b, this.f6592c, this.f6593d, this.f6594e, this.f6595f, this.f6596g, this.f6597h, this.f6598i);
            }
            throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
        }

        public Builder height(int i4) {
            this.f6591b = i4;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f6594e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f6593d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f6592c = latLng;
            return this;
        }

        public Builder width(int i4) {
            this.f6590a = i4;
            return this;
        }

        public Builder xOffset(int i4) {
            this.f6598i = i4;
            return this;
        }

        public Builder yOffset(int i4) {
            this.f6597h = i4;
            return this;
        }
    }

    public enum ELayoutMode {
        mapMode,
        absoluteMode
    }

    public MapViewLayoutParams(int i4, int i5, LatLng latLng, Point point, ELayoutMode eLayoutMode, int i6, int i7, int i8, int i9) {
        super(i4, i5);
        this.f6583a = latLng;
        this.f6584b = point;
        this.f6585c = eLayoutMode;
        if (i6 == 1) {
            this.f6586d = Property.DEFAULT_FLOAT_VALUE;
        } else if (i6 == 2) {
            this.f6586d = 1.0f;
        } else if (i6 != 4) {
            this.f6586d = 0.5f;
        } else {
            this.f6586d = 0.5f;
        }
        if (i7 == 8) {
            this.f6587e = Property.DEFAULT_FLOAT_VALUE;
        } else if (i7 == 16 || i7 != 32) {
            this.f6587e = 1.0f;
        } else {
            this.f6587e = 0.5f;
        }
        this.f6588f = i8;
        this.f6589g = i9;
    }
}
