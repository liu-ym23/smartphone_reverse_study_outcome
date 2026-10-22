package com.baidu.mapapi.map;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class MultiPointOption extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<MultiPointItem> f31166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BitmapDescriptor f31167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f31170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f31172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31173h;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        MultiPoint r100 = new MultiPoint();
        r100.f31157h = this.f31167b;
        List<MultiPointItem> r101 = this.f31166a;
        if (r101 == null) goto L7;
        r100.f31156g = r101;
        r100.f31159j = this.f31169d;
        r100.f31158i = this.f31168c;
        r100.f31160k = this.f31170e;
        r100.f31161l = this.f31171f;
        r100.f31205d = this.f31172g;
        r100.f31162m = this.f31173h;
        return r100;
    L7:
        throw new IllegalStateException("BDMapSDKException: when you add mMultiPointItems, you must set the mMultiPointItems");
    }

    public MultiPointOption() {
        this.f31170e = 0.5f;
        this.f31171f = 0.5f;
        this.f31172g = true;
        this.f31173h = true;
    }

    public float getAnchorX() {
        return this.f31170e;
    }

    public float getAnchorY() {
        return this.f31171f;
    }

    public BitmapDescriptor getIcon() {
        return this.f31167b;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.f31166a;
    }

    public int getPointSizeHeight() {
        return this.f31169d;
    }

    public int getPointSizeWidth() {
        return this.f31168c;
    }

    public boolean isVisible() {
        return this.f31172g;
    }

    public MultiPointOption setClickable(boolean r100) {
        this.f31173h = r100;
        return this;
    }

    public MultiPointOption setIcon(BitmapDescriptor r100) {
        if (r100 == null) goto L12;
        if (this.f31168c != 0) goto L7;
        this.f31168c = r100.getBitmap().getWidth();
    L7:
        if (this.f31169d != 0) goto L9;
        this.f31169d = r100.getBitmap().getHeight();
    L9:
        this.f31167b = r100;
        return this;
    L12:
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint icon can not be null");
    }

    public MultiPointOption setMultiPointItems(List<MultiPointItem> r100) {
        if (r100 == null) goto L10;
        if (r100.contains(null) == true) goto L8;
        this.f31166a = r100;
        return this;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
    L10:
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
    }

    public MultiPointOption visible(boolean r100) {
        this.f31172g = r100;
        return this;
    }

    public MultiPointOption setAnchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
    L13:
        return this;
    L5:
        if (r100 > 1.0f) goto L13;
        if (r101 < 0.0f) goto L13;
        if (r101 > 1.0f) goto L13;
        this.f31170e = r100;
        this.f31171f = r101;
        goto L13
    }

    public MultiPointOption setPointSize(int r100, int r101) {
        if (this.f31168c <= 0) goto L9;
        if (this.f31169d <= 0) goto L9;
        this.f31168c = r100;
        this.f31169d = r101;
        return this;
    L9:
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
    }
}
