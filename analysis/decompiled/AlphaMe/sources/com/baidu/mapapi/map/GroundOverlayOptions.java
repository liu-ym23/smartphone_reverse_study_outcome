package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f6381a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f6382b;

    /* renamed from: c, reason: collision with root package name */
    private int f6383c;

    /* renamed from: d, reason: collision with root package name */
    private int f6384d;

    /* renamed from: g, reason: collision with root package name */
    private LatLngBounds f6387g;

    /* renamed from: j, reason: collision with root package name */
    int f6390j;

    /* renamed from: l, reason: collision with root package name */
    Bundle f6392l;

    /* renamed from: e, reason: collision with root package name */
    private float f6385e = 0.5f;

    /* renamed from: f, reason: collision with root package name */
    private float f6386f = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    private float f6388h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6389i = false;

    /* renamed from: k, reason: collision with root package name */
    boolean f6391k = true;

    public GroundOverlayOptions anchor(float f4, float f5) {
        if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 <= 1.0f && f5 >= Property.DEFAULT_FLOAT_VALUE && f5 <= 1.0f) {
            this.f6385e = f4;
            this.f6386f = f5;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i4) {
        if (i4 <= 0) {
            this.f6383c = 0;
            this.f6384d = 0;
            return this;
        }
        this.f6383c = i4;
        this.f6384d = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f6392l = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.f6385e;
    }

    public float getAnchorY() {
        return this.f6386f;
    }

    public LatLngBounds getBounds() {
        return this.f6387g;
    }

    public Bundle getExtraInfo() {
        return this.f6392l;
    }

    public int getHeight() {
        int i4 = this.f6384d;
        if (i4 != Integer.MAX_VALUE) {
            return i4;
        }
        return (int) ((this.f6381a.f6261a.getHeight() * this.f6383c) / this.f6381a.f6261a.getWidth());
    }

    public BitmapDescriptor getImage() {
        return this.f6381a;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        LatLng latLng;
        int i4;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.f6721d = this.f6391k;
        groundOverlay.f6720c = this.f6390j;
        groundOverlay.f6722e = this.f6392l;
        BitmapDescriptor bitmapDescriptor = this.f6381a;
        if (bitmapDescriptor == null) {
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
        }
        groundOverlay.f6371h = bitmapDescriptor;
        LatLngBounds latLngBounds = this.f6387g;
        if (latLngBounds == null && (latLng = this.f6382b) != null) {
            int i5 = this.f6383c;
            if (i5 <= 0 || (i4 = this.f6384d) <= 0) {
                throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
            }
            groundOverlay.f6372i = latLng;
            groundOverlay.f6375l = this.f6385e;
            groundOverlay.f6376m = this.f6386f;
            groundOverlay.f6373j = i5;
            groundOverlay.f6374k = i4;
            groundOverlay.f6370g = 2;
        } else {
            if (this.f6382b != null || latLngBounds == null) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            }
            groundOverlay.f6377n = latLngBounds;
            groundOverlay.f6370g = 1;
        }
        groundOverlay.f6378o = this.f6388h;
        groundOverlay.f6380q = this.f6389i;
        return groundOverlay;
    }

    public LatLng getPosition() {
        return this.f6382b;
    }

    public float getTransparency() {
        return this.f6388h;
    }

    public int getWidth() {
        return this.f6383c;
    }

    public int getZIndex() {
        return this.f6390j;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        this.f6381a = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.f6391k;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f6382b = latLng;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        this.f6387g = latLngBounds;
        return this;
    }

    public GroundOverlayOptions setClickable(boolean z4) {
        this.f6389i = z4;
        return this;
    }

    public GroundOverlayOptions transparency(float f4) {
        if (f4 <= 1.0f && f4 >= Property.DEFAULT_FLOAT_VALUE) {
            this.f6388h = f4;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z4) {
        this.f6391k = z4;
        return this;
    }

    public GroundOverlayOptions zIndex(int i4) {
        this.f6390j = i4;
        return this;
    }

    public GroundOverlayOptions dimensions(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.f6383c = i4;
            this.f6384d = i5;
            return this;
        }
        this.f6383c = 0;
        this.f6384d = 0;
        return this;
    }
}
