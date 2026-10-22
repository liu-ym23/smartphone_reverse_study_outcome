package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6343a;

    /* renamed from: d, reason: collision with root package name */
    int f6346d;

    /* renamed from: f, reason: collision with root package name */
    Bundle f6348f;

    /* renamed from: b, reason: collision with root package name */
    private int f6344b = -16777216;

    /* renamed from: c, reason: collision with root package name */
    private int f6345c = 5;

    /* renamed from: e, reason: collision with root package name */
    boolean f6347e = true;

    public DotOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
        }
        this.f6343a = latLng;
        return this;
    }

    public DotOptions color(int i4) {
        this.f6344b = i4;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6348f = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6343a;
    }

    public int getColor() {
        return this.f6344b;
    }

    public Bundle getExtraInfo() {
        return this.f6348f;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Dot dot = new Dot();
        dot.f6721d = this.f6347e;
        dot.f6720c = this.f6346d;
        dot.f6722e = this.f6348f;
        dot.f6341h = this.f6344b;
        dot.f6340g = this.f6343a;
        dot.f6342i = this.f6345c;
        return dot;
    }

    public int getRadius() {
        return this.f6345c;
    }

    public int getZIndex() {
        return this.f6346d;
    }

    public boolean isVisible() {
        return this.f6347e;
    }

    public DotOptions radius(int i4) {
        if (i4 > 0) {
            this.f6345c = i4;
        }
        return this;
    }

    public DotOptions visible(boolean z4) {
        this.f6347e = z4;
        return this;
    }

    public DotOptions zIndex(int i4) {
        this.f6346d = i4;
        return this;
    }
}
