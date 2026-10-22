package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d, reason: collision with root package name */
    private LatLng f6052d;

    /* renamed from: e, reason: collision with root package name */
    private LatLng f6053e;

    /* renamed from: f, reason: collision with root package name */
    private LatLng f6054f;

    /* renamed from: g, reason: collision with root package name */
    int f6055g;

    /* renamed from: i, reason: collision with root package name */
    Bundle f6057i;

    /* renamed from: a, reason: collision with root package name */
    private int f6049a = -16777216;

    /* renamed from: b, reason: collision with root package name */
    private int f6050b = 5;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6051c = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f6056h = true;

    public ArcOptions color(int i4) {
        this.f6049a = i4;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6057i = bundle;
        return this;
    }

    public int getColor() {
        return this.f6049a;
    }

    public LatLng getEndPoint() {
        return this.f6054f;
    }

    public Bundle getExtraInfo() {
        return this.f6057i;
    }

    public LatLng getMiddlePoint() {
        return this.f6053e;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Arc arc = new Arc();
        arc.f6721d = this.f6056h;
        arc.f6720c = this.f6055g;
        arc.f6722e = this.f6057i;
        arc.f6035g = this.f6049a;
        arc.f6036h = this.f6050b;
        arc.f6037i = this.f6052d;
        arc.f6038j = this.f6053e;
        arc.f6039k = this.f6054f;
        arc.f6040l = this.f6051c;
        return arc;
    }

    public LatLng getStartPoint() {
        return this.f6052d;
    }

    public int getWidth() {
        return this.f6050b;
    }

    public int getZIndex() {
        return this.f6055g;
    }

    public boolean isVisible() {
        return this.f6056h;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.f6052d = latLng;
        this.f6053e = latLng2;
        this.f6054f = latLng3;
        return this;
    }

    public ArcOptions setClickable(boolean z4) {
        this.f6051c = z4;
        return this;
    }

    public ArcOptions visible(boolean z4) {
        this.f6056h = z4;
        return this;
    }

    public ArcOptions width(int i4) {
        if (i4 > 0) {
            this.f6050b = i4;
        }
        return this;
    }

    public ArcOptions zIndex(int i4) {
        this.f6055g = i4;
        return this;
    }
}
