package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGround;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;

/* JADX INFO: loaded from: classes39.dex */
public final class GroundOverlay extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f30889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    BitmapDescriptor f30890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    LatLng f30891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    double f30892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    double f30893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f30894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f30895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    LatLngBounds f30896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f30897o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BmGround f30898p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f30899q;

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmGround r100 = new BmGround();
        this.f30898p = r100;
        r100.a(this);
        setDrawItem(this.f30898p);
        super.toDrawItem();
        if (this.f30890h != null) goto L7;
        return this.f30898p;
    L7:
        if (this.f30889g != 1) goto L10;
        GeoPoint r101 = CoordUtil.ll2mc(this.f30896n.southwest);
        double r102 = r101.getLongitudeE6();
        double r103 = r101.getLatitudeE6();
        GeoPoint r104 = CoordUtil.ll2mc(this.f30896n.northeast);
        double r105 = r104.getLongitudeE6();
        double r106 = r104.getLatitudeE6();
        double r107 = r105 - r102;
        this.f30892j = r107;
        double r108 = r106 - r103;
        this.f30893k = r108;
        this.f30891i = CoordUtil.mc2ll(new GeoPoint(r103 + (r108 / 2.0d), r102 + (r107 / 2.0d)));
        this.f30894l = 0.5f;
        this.f30895m = 0.5f;
    L10:
        if (this.f30893k != 2.147483647E9d) goto L14;
        Bitmap r109 = this.f30890h.f30786a;
        if (r109 == null) goto L14;
        this.f30893k = (int) ((this.f30892j * ((double) r109.getHeight())) / ((double) this.f30890h.f30786a.getWidth()));
    L14:
        LatLng r110 = this.f30891i;
        if (r110 == null) goto L17;
        GeoPoint r111 = CoordUtil.ll2mc(r110);
        this.f30898p.a(new com.baidu.platform.comapi.bmsdk.b(r111.getLongitudeE6(), r111.getLatitudeE6()));
    L17:
        this.f30898p.b(this.f30892j);
        this.f30898p.a(this.f30893k);
        this.f30898p.b(this.f30894l);
        this.f30898p.c(this.f30895m);
        this.f30898p.a(this.f30899q);
        this.f30898p.a(this.f30897o);
        this.f30898p.a(new BmBitmapResource(this.f30890h.getBitmap()));
        return this.f30898p;
    }

    public GroundOverlay() {
        this.f30899q = false;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32144d;
    }

    public float getAnchorX() {
        return this.f30894l;
    }

    public float getAnchorY() {
        return this.f30895m;
    }

    public LatLngBounds getBounds() {
        return this.f30896n;
    }

    public double getHeight() {
        return this.f30893k;
    }

    public BitmapDescriptor getImage() {
        return this.f30890h;
    }

    public LatLng getPosition() {
        return this.f30891i;
    }

    public float getTransparency() {
        return this.f30897o;
    }

    public double getWidth() {
        return this.f30892j;
    }

    public boolean isClickable() {
        return this.f30899q;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r110) {
        super.a(r110);
        r110.putBundle("image_info", this.f30890h.a());
        if (this.f30889g != 1) goto L5;
        GeoPoint r100 = CoordUtil.ll2mc(this.f30896n.southwest);
        double r101 = r100.getLongitudeE6();
        double r102 = r100.getLatitudeE6();
        GeoPoint r103 = CoordUtil.ll2mc(this.f30896n.northeast);
        double r104 = r103.getLongitudeE6();
        double r105 = r103.getLatitudeE6();
        double r106 = r104 - r101;
        this.f30892j = r106;
        double r107 = r105 - r102;
        this.f30893k = r107;
        this.f30891i = CoordUtil.mc2ll(new GeoPoint(r102 + (r107 / 2.0d), r101 + (r106 / 2.0d)));
        this.f30894l = 0.5f;
        this.f30895m = 0.5f;
    L5:
        double r108 = this.f30892j;
        if (r108 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        if (this.f30893k <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r110.putDouble("x_distance", r108);
        if (this.f30893k != 2.147483647E9d) goto L12;
        this.f30893k = (int) ((this.f30892j * ((double) this.f30890h.f30786a.getHeight())) / ((double) this.f30890h.f30786a.getWidth()));
    L12:
        r110.putDouble("y_distance", this.f30893k);
        GeoPoint r109 = CoordUtil.ll2mc(this.f30891i);
        r110.putDouble("location_x", r109.getLongitudeE6());
        r110.putDouble("location_y", r109.getLatitudeE6());
        r110.putFloat("anchor_x", this.f30894l);
        r110.putFloat("anchor_y", this.f30895m);
        r110.putFloat("transparency", this.f30897o);
        r110.putInt("isClickable", this.f30899q ? 1 : 0);
        return r110;
    L15:
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
    }

    public void setClickable(boolean r100) {
        this.f30899q = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmGround r101 = this.f30898p;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(this.f30899q);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setDimensions(int r100) {
        if (r100 > 0) goto L4;
        this.f30892j = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f30893k = AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        int r101 = 0;
    L11:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L17;
        BmGround r102 = this.f30898p;
        if (r102 != null) goto L15;
        return;
    L15:
        if (this.f31207f == null) goto L20;
        r102.a(r101);
        this.f30898p.b(this.f30892j);
        this.f31207f.b();
        return;
    L20:
        return;
    L17:
        this.listener.c(this);
        return;
    L4:
        double r103 = r100;
        this.f30892j = r103;
        this.f30893k = 2.147483647E9d;
        BitmapDescriptor r104 = this.f30890h;
        if (r104 == null) goto L9;
        Bitmap r105 = r104.f30786a;
        if (r105 == null) goto L9;
        r101 = (int) ((r103 * ((double) r105.getHeight())) / ((double) this.f30890h.f30786a.getWidth()));
        goto L11
    }

    public void setImage(BitmapDescriptor r100) {
        if (r100 == null) goto L17;
        this.f30890h = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    L6:
        if (this.f30898p != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L19;
        Bitmap r101 = this.f30890h.f30786a;
        if (r101 == null) goto L12;
        int r102 = (int) ((this.f30892j * ((double) r101.getHeight())) / ((double) this.f30890h.f30786a.getWidth()));
    L13:
        this.f30898p.a(r102);
        this.f30898p.a(new BmBitmapResource(this.f30890h.getBitmap()));
        this.f31207f.b();
        return;
    L12:
        r102 = 0;
        goto L13
    L19:
        return;
    L17:
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public void setPosition(LatLng r100) {
        if (r100 == null) goto L13;
        this.f30889g = 2;
        this.f30891i = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    L6:
        if (this.f30898p != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        GeoPoint r101 = CoordUtil.ll2mc(this.f30891i);
        this.f30898p.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
        this.f31207f.b();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public void setPositionFromBounds(LatLngBounds r110) {
        if (r110 == null) goto L13;
        this.f30889g = 1;
        this.f30896n = r110;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    L6:
        if (this.f30898p != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        GeoPoint r111 = CoordUtil.ll2mc(this.f30896n.southwest);
        double r100 = r111.getLongitudeE6();
        double r101 = r111.getLatitudeE6();
        GeoPoint r112 = CoordUtil.ll2mc(this.f30896n.northeast);
        double r102 = r112.getLongitudeE6();
        double r103 = r112.getLatitudeE6();
        double r104 = r102 - r100;
        this.f30892j = r104;
        double r105 = r103 - r101;
        this.f30893k = r105;
        GeoPoint r113 = new GeoPoint(r101 + (r105 / 2.0d), r100 + (r104 / 2.0d));
        this.f30891i = CoordUtil.mc2ll(r113);
        this.f30894l = 0.5f;
        this.f30895m = 0.5f;
        this.f30898p.a(new com.baidu.platform.comapi.bmsdk.b(r113.getLongitudeE6(), r113.getLatitudeE6()));
        this.f30898p.b(this.f30892j);
        this.f30898p.a(this.f30893k);
        this.f30898p.b(this.f30894l);
        this.f30898p.c(this.f30895m);
        this.f31207f.b();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
    }

    public void setTransparency(float r100) {
        if (r100 <= 1.0f) goto L5;
        return;
    L5:
        if (r100 < 0.0f) goto L20;
        this.f30897o = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L14;
        BmGround r101 = this.f30898p;
        if (r101 != null) goto L12;
        return;
    L12:
        if (this.f31207f == null) goto L18;
        r101.a(this.f30897o);
        this.f31207f.b();
        return;
    L18:
        return;
    L14:
        this.listener.c(this);
        return;
    }

    public void setAnchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 <= 1.0f) goto L8;
        return;
    L8:
        if (r101 >= 0.0f) goto L10;
        return;
    L10:
        if (r101 > 1.0f) goto L27;
        this.f30894l = r100;
        this.f30895m = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L19;
        BmGround r102 = this.f30898p;
        if (r102 != null) goto L17;
        return;
    L17:
        if (this.f31207f == null) goto L24;
        r102.b(this.f30894l);
        this.f30898p.c(this.f30895m);
        this.f31207f.b();
        return;
    L24:
        return;
    L19:
        this.listener.c(this);
        return;
    }

    public void setDimensions(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L6;
        this.f30892j = r100;
        this.f30893k = r101;
    L8:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L14;
        BmGround r102 = this.f30898p;
        if (r102 != null) goto L12;
        return;
    L12:
        if (this.f31207f == null) goto L17;
        r102.a(this.f30893k);
        this.f30898p.b(this.f30892j);
        this.f31207f.b();
        return;
    L17:
        return;
    L14:
        this.listener.c(this);
        return;
    L6:
        this.f30892j = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f30893k = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L8
    }

    public void setImage(BitmapDescriptor r100, boolean r101) {
        if (r100 == null) goto L18;
        this.f30890h = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        return;
    L6:
        if (this.f30898p != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L21;
        if (r101 == false) goto L15;
        Bitmap r102 = this.f30890h.f30786a;
        if (r102 == null) goto L13;
        int r103 = (int) ((this.f30892j * ((double) r102.getHeight())) / ((double) this.f30890h.f30786a.getWidth()));
    L14:
        this.f30898p.a(r103);
        goto L15
    L13:
        r103 = 0;
    L15:
        this.f30898p.a(new BmBitmapResource(this.f30890h.getBitmap()));
        this.f31207f.b();
        return;
    L21:
        return;
    L18:
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }
}
