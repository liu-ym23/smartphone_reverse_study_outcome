package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class DotOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f30862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f30865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f30866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Bundle f30867f;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Dot r100 = new Dot();
        r100.f31205d = this.f30866e;
        r100.f31204c = this.f30865d;
        r100.f31206e = this.f30867f;
        r100.f30860h = this.f30863b;
        r100.f30859g = this.f30862a;
        r100.f30861i = this.f30864c;
        return r100;
    }

    public DotOptions() {
        this.f30863b = -16777216;
        this.f30864c = 5;
        this.f30866e = true;
    }

    public LatLng getCenter() {
        return this.f30862a;
    }

    public int getColor() {
        return this.f30863b;
    }

    public Bundle getExtraInfo() {
        return this.f30867f;
    }

    public int getRadius() {
        return this.f30864c;
    }

    public int getZIndex() {
        return this.f30865d;
    }

    public boolean isVisible() {
        return this.f30866e;
    }

    public DotOptions center(LatLng r100) {
        if (r100 == null) goto L6;
        this.f30862a = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public DotOptions color(int r100) {
        this.f30863b = r100;
        return this;
    }

    public DotOptions extraInfo(Bundle r100) {
        this.f30867f = r100;
        return this;
    }

    public DotOptions radius(int r100) {
        if (r100 <= 0) goto L4;
        this.f30864c = r100;
    L4:
        return this;
    }

    public DotOptions visible(boolean r100) {
        this.f30866e = r100;
        return this;
    }

    public DotOptions zIndex(int r100) {
        this.f30865d = r100;
        return this;
    }
}
