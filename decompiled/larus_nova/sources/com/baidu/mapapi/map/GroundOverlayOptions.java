package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

/* JADX INFO: loaded from: classes39.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f30900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLng f30901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f30904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f30905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LatLngBounds f30906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f30907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f30908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f30909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f30910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Bundle f30911l;

    public int getHeight() {
        int r100 = this.f30903d;
        if (r100 == Integer.MAX_VALUE) goto L5;
        return r100;
    L5:
        return (int) ((this.f30902c * this.f30900a.f30786a.getHeight()) / this.f30900a.f30786a.getWidth());
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        GroundOverlay r100 = new GroundOverlay();
        r100.f31205d = this.f30910k;
        r100.f31204c = this.f30909j;
        r100.f31206e = this.f30911l;
        BitmapDescriptor r101 = this.f30900a;
        if (r101 == null) goto L24;
        r100.f30890h = r101;
        LatLngBounds r102 = this.f30906g;
        if (r102 != null) goto L16;
        LatLng r103 = this.f30901b;
        if (r103 == null) goto L16;
        int r104 = this.f30902c;
        if (r104 <= 0) goto L14;
        int r105 = this.f30903d;
        if (r105 <= 0) goto L14;
        r100.f30891i = r103;
        r100.f30894l = this.f30904e;
        r100.f30895m = this.f30905f;
        r100.f30892j = r104;
        r100.f30893k = r105;
        r100.f30889g = 2;
    L19:
        r100.f30897o = this.f30907h;
        r100.f30899q = this.f30908i;
        return r100;
    L14:
        throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
    L16:
        if (this.f30901b != null) goto L22;
        if (r102 == null) goto L22;
        r100.f30896n = r102;
        r100.f30889g = 1;
    L22:
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
    L24:
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions() {
        this.f30904e = 0.5f;
        this.f30905f = 0.5f;
        this.f30907h = 1.0f;
        this.f30908i = false;
        this.f30910k = true;
    }

    public float getAnchorX() {
        return this.f30904e;
    }

    public float getAnchorY() {
        return this.f30905f;
    }

    public LatLngBounds getBounds() {
        return this.f30906g;
    }

    public Bundle getExtraInfo() {
        return this.f30911l;
    }

    public BitmapDescriptor getImage() {
        return this.f30900a;
    }

    public LatLng getPosition() {
        return this.f30901b;
    }

    public float getTransparency() {
        return this.f30907h;
    }

    public int getWidth() {
        return this.f30902c;
    }

    public int getZIndex() {
        return this.f30909j;
    }

    public boolean isVisible() {
        return this.f30910k;
    }

    public GroundOverlayOptions dimensions(int r100) {
        if (r100 > 0) goto L5;
        this.f30902c = 0;
        this.f30903d = 0;
        return this;
    L5:
        this.f30902c = r100;
        this.f30903d = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle r100) {
        this.f30911l = r100;
        return this;
    }

    public GroundOverlayOptions image(BitmapDescriptor r100) {
        if (r100 == null) goto L6;
        this.f30900a = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public GroundOverlayOptions position(LatLng r100) {
        if (r100 == null) goto L6;
        this.f30901b = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds r100) {
        if (r100 == null) goto L6;
        this.f30906g = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
    }

    public GroundOverlayOptions setClickable(boolean r100) {
        this.f30908i = r100;
        return this;
    }

    public GroundOverlayOptions transparency(float r100) {
        if (r100 <= 1.0f) goto L5;
    L8:
        return this;
    L5:
        if (r100 < 0.0f) goto L8;
        this.f30907h = r100;
        goto L8
    }

    public GroundOverlayOptions visible(boolean r100) {
        this.f30910k = r100;
        return this;
    }

    public GroundOverlayOptions zIndex(int r100) {
        this.f30909j = r100;
        return this;
    }

    public GroundOverlayOptions anchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
    L13:
        return this;
    L5:
        if (r100 > 1.0f) goto L13;
        if (r101 < 0.0f) goto L13;
        if (r101 > 1.0f) goto L13;
        this.f30904e = r100;
        this.f30905f = r101;
        goto L13
    }

    public GroundOverlayOptions dimensions(int r100, int r101) {
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L7;
        this.f30902c = r100;
        this.f30903d = r101;
        return this;
    L7:
        this.f30902c = 0;
        this.f30903d = 0;
        return this;
    }
}
