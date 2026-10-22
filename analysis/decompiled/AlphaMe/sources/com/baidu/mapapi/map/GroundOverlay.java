package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGround;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class GroundOverlay extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    int f6370g;

    /* renamed from: h, reason: collision with root package name */
    BitmapDescriptor f6371h;

    /* renamed from: i, reason: collision with root package name */
    LatLng f6372i;

    /* renamed from: j, reason: collision with root package name */
    double f6373j;

    /* renamed from: k, reason: collision with root package name */
    double f6374k;

    /* renamed from: l, reason: collision with root package name */
    float f6375l;

    /* renamed from: m, reason: collision with root package name */
    float f6376m;

    /* renamed from: n, reason: collision with root package name */
    LatLngBounds f6377n;

    /* renamed from: o, reason: collision with root package name */
    float f6378o;

    /* renamed from: p, reason: collision with root package name */
    private BmGround f6379p;

    /* renamed from: q, reason: collision with root package name */
    boolean f6380q = false;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.f6371h.a());
        if (this.f6370g == 1) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6377n.southwest);
            double longitudeE6 = geoPointLl2mc.getLongitudeE6();
            double latitudeE6 = geoPointLl2mc.getLatitudeE6();
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6377n.northeast);
            double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
            double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
            double d4 = longitudeE62 - longitudeE6;
            this.f6373j = d4;
            double d5 = latitudeE62 - latitudeE6;
            this.f6374k = d5;
            this.f6372i = CoordUtil.mc2ll(new GeoPoint((d5 / 2.0d) + latitudeE6, (d4 / 2.0d) + longitudeE6));
            this.f6375l = 0.5f;
            this.f6376m = 0.5f;
        }
        double d6 = this.f6373j;
        if (d6 <= 0.0d || this.f6374k <= 0.0d) {
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d6);
        if (this.f6374k == 2.147483647E9d) {
            this.f6374k = (int) ((this.f6373j * this.f6371h.f6261a.getHeight()) / this.f6371h.f6261a.getWidth());
        }
        bundle.putDouble("y_distance", this.f6374k);
        GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(this.f6372i);
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc3.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f6375l);
        bundle.putFloat("anchor_y", this.f6376m);
        bundle.putFloat("transparency", this.f6378o);
        bundle.putInt("isClickable", this.f6380q ? 1 : 0);
        return bundle;
    }

    public float getAnchorX() {
        return this.f6375l;
    }

    public float getAnchorY() {
        return this.f6376m;
    }

    public LatLngBounds getBounds() {
        return this.f6377n;
    }

    public double getHeight() {
        return this.f6374k;
    }

    public BitmapDescriptor getImage() {
        return this.f6371h;
    }

    public LatLng getPosition() {
        return this.f6372i;
    }

    public float getTransparency() {
        return this.f6378o;
    }

    public double getWidth() {
        return this.f6373j;
    }

    public boolean isClickable() {
        return this.f6380q;
    }

    public void setAnchor(float f4, float f5) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f4 > 1.0f || f5 < Property.DEFAULT_FLOAT_VALUE || f5 > 1.0f) {
            return;
        }
        this.f6375l = f4;
        this.f6376m = f5;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmGround bmGround = this.f6379p;
        if (bmGround == null || this.f6723f == null) {
            return;
        }
        bmGround.b(this.f6375l);
        this.f6379p.c(this.f6376m);
        this.f6723f.b();
    }

    public void setClickable(boolean z4) {
        this.f6380q = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmGround bmGround = this.f6379p;
        if (bmGround == null || this.f6723f == null) {
            return;
        }
        bmGround.a(this.f6380q);
        this.f6723f.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDimensions(int r5) {
        /*
            r4 = this;
            if (r5 > 0) goto L9
            r0 = 0
            r4.f6373j = r0
            r4.f6374k = r0
            goto L2e
        L9:
            double r0 = (double) r5
            r4.f6373j = r0
            r2 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
            r4.f6374k = r2
            com.baidu.mapapi.map.BitmapDescriptor r5 = r4.f6371h
            if (r5 == 0) goto L2e
            android.graphics.Bitmap r5 = r5.f6261a
            if (r5 == 0) goto L2e
            int r5 = r5.getHeight()
            double r2 = (double) r5
            double r0 = r0 * r2
            com.baidu.mapapi.map.BitmapDescriptor r5 = r4.f6371h
            android.graphics.Bitmap r5 = r5.f6261a
            int r5 = r5.getWidth()
            float r5 = (float) r5
            double r2 = (double) r5
            double r0 = r0 / r2
            int r5 = (int) r0
            goto L2f
        L2e:
            r5 = 0
        L2f:
            boolean r0 = com.baidu.mapapi.map.OverlayUtil.isOverlayUpgrade()
            if (r0 == 0) goto L4e
            com.baidu.platform.comapi.bmsdk.BmGround r0 = r4.f6379p
            if (r0 == 0) goto L53
            com.baidu.platform.comapi.bmsdk.BmLayer r1 = r4.f6723f
            if (r1 == 0) goto L53
            double r1 = (double) r5
            r0.a(r1)
            com.baidu.platform.comapi.bmsdk.BmGround r5 = r4.f6379p
            double r0 = r4.f6373j
            r5.b(r0)
            com.baidu.platform.comapi.bmsdk.BmLayer r4 = r4.f6723f
            r4.b()
            goto L53
        L4e:
            com.baidu.mapapi.map.Overlay$a r5 = r4.listener
            r5.c(r4)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.GroundOverlay.setDimensions(int):void");
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        this.f6371h = bitmapDescriptor;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6379p == null || this.f6723f == null) {
            return;
        }
        this.f6379p.a(this.f6371h.f6261a != null ? (int) ((this.f6373j * r5.getHeight()) / this.f6371h.f6261a.getWidth()) : 0);
        this.f6379p.a(new BmBitmapResource(this.f6371h.getBitmap()));
        this.f6723f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f6370g = 2;
        this.f6372i = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6379p == null || this.f6723f == null) {
                return;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6372i);
            this.f6379p.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f6723f.b();
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        this.f6370g = 1;
        this.f6377n = latLngBounds;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6379p == null || this.f6723f == null) {
            return;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6377n.southwest);
        double longitudeE6 = geoPointLl2mc.getLongitudeE6();
        double latitudeE6 = geoPointLl2mc.getLatitudeE6();
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6377n.northeast);
        double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
        double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
        double d4 = longitudeE62 - longitudeE6;
        this.f6373j = d4;
        double d5 = latitudeE62 - latitudeE6;
        this.f6374k = d5;
        GeoPoint geoPoint = new GeoPoint((d5 / 2.0d) + latitudeE6, (d4 / 2.0d) + longitudeE6);
        this.f6372i = CoordUtil.mc2ll(geoPoint);
        this.f6375l = 0.5f;
        this.f6376m = 0.5f;
        this.f6379p.a(new com.baidu.platform.comapi.bmsdk.b(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()));
        this.f6379p.b(this.f6373j);
        this.f6379p.a(this.f6374k);
        this.f6379p.b(this.f6375l);
        this.f6379p.c(this.f6376m);
    }

    public void setTransparency(float f4) {
        if (f4 > 1.0f || f4 < Property.DEFAULT_FLOAT_VALUE) {
            return;
        }
        this.f6378o = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmGround bmGround = this.f6379p;
        if (bmGround == null || this.f6723f == null) {
            return;
        }
        bmGround.a(this.f6378o);
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        Bitmap bitmap;
        BmGround bmGround = new BmGround();
        this.f6379p = bmGround;
        bmGround.a(this);
        setDrawItem(this.f6379p);
        super.toDrawItem();
        if (this.f6371h == null) {
            return this.f6379p;
        }
        if (this.f6370g == 1) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6377n.southwest);
            double longitudeE6 = geoPointLl2mc.getLongitudeE6();
            double latitudeE6 = geoPointLl2mc.getLatitudeE6();
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6377n.northeast);
            double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
            double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
            double d4 = longitudeE62 - longitudeE6;
            this.f6373j = d4;
            double d5 = latitudeE62 - latitudeE6;
            this.f6374k = d5;
            this.f6372i = CoordUtil.mc2ll(new GeoPoint((d5 / 2.0d) + latitudeE6, (d4 / 2.0d) + longitudeE6));
            this.f6375l = 0.5f;
            this.f6376m = 0.5f;
        }
        if (this.f6374k == 2.147483647E9d && (bitmap = this.f6371h.f6261a) != null) {
            this.f6374k = (int) ((this.f6373j * bitmap.getHeight()) / this.f6371h.f6261a.getWidth());
        }
        LatLng latLng = this.f6372i;
        if (latLng != null) {
            GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(latLng);
            this.f6379p.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc3.getLongitudeE6(), geoPointLl2mc3.getLatitudeE6()));
        }
        this.f6379p.b(this.f6373j);
        this.f6379p.a(this.f6374k);
        this.f6379p.b(this.f6375l);
        this.f6379p.c(this.f6376m);
        this.f6379p.a(this.f6380q);
        this.f6379p.a(this.f6378o);
        this.f6379p.a(new BmBitmapResource(this.f6371h.getBitmap()));
        return this.f6379p;
    }

    public void setDimensions(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.f6373j = i4;
            this.f6374k = i5;
        } else {
            this.f6373j = 0.0d;
            this.f6374k = 0.0d;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            BmGround bmGround = this.f6379p;
            if (bmGround == null || this.f6723f == null) {
                return;
            }
            bmGround.a(this.f6374k);
            this.f6379p.b(this.f6373j);
            this.f6723f.b();
            return;
        }
        this.listener.c(this);
    }
}
