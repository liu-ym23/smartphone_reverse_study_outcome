package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class PrismOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f31321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LatLng> f31322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BitmapDescriptor f31325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f31326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f31327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f31328h;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Prism r100 = new Prism();
        r100.f31205d = this.f31326f;
        r100.f31204c = this.f31327g;
        r100.f31318n = this.f31325e;
        r100.f31311g = this.f31321a;
        List<LatLng> r101 = this.f31322b;
        if (r101 == null) goto L9;
        if (r101.size() <= 3) goto L9;
        r100.f31314j = this.f31322b;
        r100.f31317m = this.f31324d;
        r100.f31316l = this.f31323c;
        return r100;
    L9:
        throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
    }

    public PrismOptions() {
        this.f31323c = -16777216;
        this.f31324d = -16777216;
        this.f31326f = true;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.f31325e;
    }

    public float getHeight() {
        return this.f31321a;
    }

    public List<LatLng> getPoints() {
        return this.f31322b;
    }

    public int getShowLevel() {
        return this.f31328h;
    }

    public int getSideFaceColor() {
        return this.f31324d;
    }

    public int getTopFaceColor() {
        return this.f31323c;
    }

    public int getZIndex() {
        return this.f31327g;
    }

    public boolean isVisible() {
        return this.f31326f;
    }

    public PrismOptions customSideImage(BitmapDescriptor r100) {
        this.f31325e = r100;
        return this;
    }

    public PrismOptions setHeight(float r100) {
        this.f31321a = r100;
        return this;
    }

    public PrismOptions setPoints(List<LatLng> r100) {
        this.f31322b = r100;
        return this;
    }

    public PrismOptions setShowLevel(int r100) {
        this.f31328h = r100;
        return this;
    }

    public PrismOptions setSideFaceColor(int r100) {
        this.f31324d = r100;
        return this;
    }

    public PrismOptions setTopFaceColor(int r100) {
        this.f31323c = r100;
        return this;
    }

    public PrismOptions visible(boolean r100) {
        this.f31326f = r100;
        return this;
    }

    public PrismOptions zIndex(int r100) {
        this.f31327g = r100;
        return this;
    }
}
