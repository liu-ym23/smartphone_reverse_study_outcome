package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public class PrismOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private float f6867a;

    /* renamed from: b, reason: collision with root package name */
    private List<LatLng> f6868b;

    /* renamed from: e, reason: collision with root package name */
    private BitmapDescriptor f6871e;

    /* renamed from: g, reason: collision with root package name */
    int f6873g;

    /* renamed from: h, reason: collision with root package name */
    int f6874h;

    /* renamed from: c, reason: collision with root package name */
    private int f6869c = -16777216;

    /* renamed from: d, reason: collision with root package name */
    private int f6870d = -16777216;

    /* renamed from: f, reason: collision with root package name */
    boolean f6872f = true;

    public PrismOptions customSideImage(BitmapDescriptor bitmapDescriptor) {
        this.f6871e = bitmapDescriptor;
        return this;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.f6871e;
    }

    public float getHeight() {
        return this.f6867a;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Prism prism = new Prism();
        prism.f6721d = this.f6872f;
        prism.f6720c = this.f6873g;
        prism.f6864n = this.f6871e;
        prism.f6857g = this.f6867a;
        List<LatLng> list = this.f6868b;
        if (list == null || list.size() <= 3) {
            throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
        }
        prism.f6860j = this.f6868b;
        prism.f6863m = this.f6870d;
        prism.f6862l = this.f6869c;
        return prism;
    }

    public List<LatLng> getPoints() {
        return this.f6868b;
    }

    public int getShowLevel() {
        return this.f6874h;
    }

    public int getSideFaceColor() {
        return this.f6870d;
    }

    public int getTopFaceColor() {
        return this.f6869c;
    }

    public int getZIndex() {
        return this.f6873g;
    }

    public boolean isVisible() {
        return this.f6872f;
    }

    public PrismOptions setHeight(float f4) {
        this.f6867a = f4;
        return this;
    }

    public PrismOptions setPoints(List<LatLng> list) {
        this.f6868b = list;
        return this;
    }

    public PrismOptions setShowLevel(int i4) {
        this.f6874h = i4;
        return this;
    }

    public PrismOptions setSideFaceColor(int i4) {
        this.f6870d = i4;
        return this;
    }

    public PrismOptions setTopFaceColor(int i4) {
        this.f6869c = i4;
        return this;
    }

    public PrismOptions visible(boolean z4) {
        this.f6872f = z4;
        return this;
    }

    public PrismOptions zIndex(int i4) {
        this.f6873g = i4;
        return this;
    }
}
