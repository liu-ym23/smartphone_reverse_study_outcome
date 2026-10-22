package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class MapViewLayoutParams extends ViewGroup.LayoutParams {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LatLng f31092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Point f31093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ELayoutMode f31094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f31095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f31096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f31097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f31098g;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f31099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f31100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LatLng f31101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Point f31102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ELayoutMode f31103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f31105g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f31106h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f31107i;

        public MapViewLayoutParams build() {
            ELayoutMode r100 = this.f31103e;
            if (r100 != ELayoutMode.mapMode) goto L8;
            if (this.f31101c == null) goto L11;
        L12:
            boolean r101 = false;
        L13:
            if (r101 == true) goto L17;
            return new MapViewLayoutParams(this.f31099a, this.f31100b, this.f31101c, this.f31102d, this.f31103e, this.f31104f, this.f31105g, this.f31106h, this.f31107i);
        L17:
            throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
        L11:
            r101 = true;
            goto L13
        L8:
            if (r100 != ELayoutMode.absoluteMode) goto L12;
            if (this.f31102d != null) goto L12;
            goto L11
        }

        public Builder() {
            this.f31103e = ELayoutMode.absoluteMode;
            this.f31104f = 4;
            this.f31105g = 16;
        }

        public Builder height(int r100) {
            this.f31100b = r100;
            return this;
        }

        public Builder layoutMode(ELayoutMode r100) {
            this.f31103e = r100;
            return this;
        }

        public Builder point(Point r100) {
            this.f31102d = r100;
            return this;
        }

        public Builder position(LatLng r100) {
            this.f31101c = r100;
            return this;
        }

        public Builder width(int r100) {
            this.f31099a = r100;
            return this;
        }

        public Builder xOffset(int r100) {
            this.f31107i = r100;
            return this;
        }

        public Builder yOffset(int r100) {
            this.f31106h = r100;
            return this;
        }

        public Builder align(int r100, int r101) {
            if (r100 != 1) goto L5;
        L8:
            this.f31104f = r100;
        L10:
            if (r101 != 8) goto L12;
        L15:
            this.f31105g = r101;
        L16:
            return this;
        L12:
            if (r101 == 16) goto L15;
            if (r101 != 32) goto L16;
        L5:
            if (r100 == 2) goto L8;
            if (r100 != 4) goto L10;
            goto L8
        }
    }

    public static final enum ELayoutMode extends Enum<ELayoutMode> {
        private static final /* synthetic */ ELayoutMode[] $VALUES = null;
        public static final ELayoutMode absoluteMode = null;
        public static final ELayoutMode mapMode = null;

        static {
            ELayoutMode r100 = new ELayoutMode("mapMode", 0);
            mapMode = r100;
            ELayoutMode r101 = new ELayoutMode("absoluteMode", 1);
            absoluteMode = r101;
            $VALUES = new ELayoutMode[]{r100, r101};
        }

        public static ELayoutMode[] values() {
            return (ELayoutMode[]) $VALUES.clone();
        }

        public static ELayoutMode valueOf(String r100) {
            return (ELayoutMode) r27.a.a(ELayoutMode.class, r100);
        }

        private ELayoutMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MapViewLayoutParams(int r100, int r101, LatLng r102, Point r103, ELayoutMode r104, int r105, int r106, int r107, int r108) {
        super(r100, r101);
        this.f31092a = r102;
        this.f31093b = r103;
        this.f31094c = r104;
        if (r105 != 1) goto L5;
        this.f31095d = 0.0f;
    L13:
        if (r106 != 8) goto L15;
        this.f31096e = 0.0f;
    L22:
        this.f31097f = r107;
        this.f31098g = r108;
        return;
    L15:
        if (r106 != 16) goto L17;
        this.f31096e = 1.0f;
        goto L22
    L17:
        if (r106 == 32) goto L19;
        this.f31096e = 1.0f;
        goto L22
    L19:
        this.f31096e = 0.5f;
        goto L22
    L5:
        if (r105 != 2) goto L7;
        this.f31095d = 1.0f;
        goto L13
    L7:
        if (r105 == 4) goto L9;
        this.f31095d = 0.5f;
        goto L13
    L9:
        this.f31095d = 0.5f;
        goto L13
    }
}
