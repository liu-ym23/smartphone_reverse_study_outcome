package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class ArcOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WidthType f30594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f30595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LatLng f30597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LatLng f30598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LatLng f30599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f30600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f30601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Bundle f30602j;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Arc r100 = new Arc();
        r100.f31205d = this.f30601i;
        r100.f31204c = this.f30600h;
        r100.f31206e = this.f30602j;
        r100.f30578g = this.f30593a;
        r100.f30579h = this.f30594b;
        r100.f30580i = this.f30595c;
        r100.f30581j = this.f30597e;
        r100.f30582k = this.f30598f;
        r100.f30583l = this.f30599g;
        r100.f30584m = this.f30596d;
        return r100;
    }

    public int getWidth() {
        return (int) this.f30595c;
    }

    public ArcOptions() {
        this.f30593a = -16777216;
        this.f30594b = WidthType.AdaptWidth;
        this.f30595c = 5.0f;
        this.f30596d = false;
        this.f30601i = true;
    }

    public int getColor() {
        return this.f30593a;
    }

    public LatLng getEndPoint() {
        return this.f30599g;
    }

    public Bundle getExtraInfo() {
        return this.f30602j;
    }

    public LatLng getMiddlePoint() {
        return this.f30598f;
    }

    public LatLng getStartPoint() {
        return this.f30597e;
    }

    public float getWidthFloat() {
        return this.f30595c;
    }

    public WidthType getWidthType() {
        return this.f30594b;
    }

    public int getZIndex() {
        return this.f30600h;
    }

    public boolean isVisible() {
        return this.f30601i;
    }

    public ArcOptions color(int r100) {
        this.f30593a = r100;
        return this;
    }

    public ArcOptions extraInfo(Bundle r100) {
        this.f30602j = r100;
        return this;
    }

    public ArcOptions setClickable(boolean r100) {
        this.f30596d = r100;
        return this;
    }

    public ArcOptions visible(boolean r100) {
        this.f30601i = r100;
        return this;
    }

    public ArcOptions width(float r100) {
        if (r100 <= 0.0f) goto L5;
        this.f30595c = r100;
    L5:
        return this;
    }

    public ArcOptions widthType(WidthType r100) {
        this.f30594b = r100;
        return this;
    }

    public ArcOptions zIndex(int r100) {
        this.f30600h = r100;
        return this;
    }

    public ArcOptions points(LatLng r100, LatLng r101, LatLng r102) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        if (r102 == null) goto L13;
        if (r100 == r101) goto L11;
        if (r100 == r102) goto L11;
        if (r101 == r102) goto L11;
        this.f30597e = r100;
        this.f30598f = r101;
        this.f30599g = r102;
        return this;
    L11:
        throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
    L13:
        throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
    }
}
