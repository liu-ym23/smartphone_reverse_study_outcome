package com.baidu.mapapi.map;

import com.stepos.alphame.utils.Property;
import java.util.List;

/* loaded from: classes.dex */
public final class MultiPointOption extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<MultiPointItem> f6688a;

    /* renamed from: b, reason: collision with root package name */
    private BitmapDescriptor f6689b;

    /* renamed from: c, reason: collision with root package name */
    private int f6690c;

    /* renamed from: d, reason: collision with root package name */
    private int f6691d;

    /* renamed from: e, reason: collision with root package name */
    private float f6692e = 0.5f;

    /* renamed from: f, reason: collision with root package name */
    private float f6693f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6694g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6695h = true;

    public float getAnchorX() {
        return this.f6692e;
    }

    public float getAnchorY() {
        return this.f6693f;
    }

    public BitmapDescriptor getIcon() {
        return this.f6689b;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.f6688a;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        MultiPoint multiPoint = new MultiPoint();
        multiPoint.f6679h = this.f6689b;
        List<MultiPointItem> list = this.f6688a;
        if (list == null) {
            throw new IllegalStateException("BDMapSDKException: when you add mMultiPointItems, you must set the mMultiPointItems");
        }
        multiPoint.f6678g = list;
        multiPoint.f6681j = this.f6691d;
        multiPoint.f6680i = this.f6690c;
        multiPoint.f6682k = this.f6692e;
        multiPoint.f6683l = this.f6693f;
        multiPoint.f6721d = this.f6694g;
        multiPoint.f6684m = this.f6695h;
        return multiPoint;
    }

    public int getPointSizeHeight() {
        return this.f6691d;
    }

    public int getPointSizeWidth() {
        return this.f6690c;
    }

    public boolean isVisible() {
        return this.f6694g;
    }

    public MultiPointOption setAnchor(float f4, float f5) {
        if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 <= 1.0f && f5 >= Property.DEFAULT_FLOAT_VALUE && f5 <= 1.0f) {
            this.f6692e = f4;
            this.f6693f = f5;
        }
        return this;
    }

    public MultiPointOption setClickable(boolean z4) {
        this.f6695h = z4;
        return this;
    }

    public MultiPointOption setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint icon can not be null");
        }
        if (this.f6690c == 0) {
            this.f6690c = bitmapDescriptor.getBitmap().getWidth();
        }
        if (this.f6691d == 0) {
            this.f6691d = bitmapDescriptor.getBitmap().getHeight();
        }
        this.f6689b = bitmapDescriptor;
        return this;
    }

    public MultiPointOption setMultiPointItems(List<MultiPointItem> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
        }
        this.f6688a = list;
        return this;
    }

    public MultiPointOption setPointSize(int i4, int i5) {
        if (this.f6690c <= 0 || this.f6691d <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
        }
        this.f6690c = i4;
        this.f6691d = i5;
        return this;
    }

    public MultiPointOption visible(boolean z4) {
        this.f6694g = z4;
        return this;
    }
}
