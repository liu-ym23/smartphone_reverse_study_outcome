package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: loaded from: classes39.dex */
public final class Projection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f31329a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.b r100) {
        this.f31329a = r100;
    }

    public LatLng fromScreenLocation(Point r100) {
        if (r100 == null) goto L7;
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f31329a;
        if (r101 != null) goto L6;
        return null;
    L6:
        return CoordUtil.mc2ll(r101.a(r100.x, r100.y));
    L7:
        return null;
    }

    public float metersToEquatorPixels(float r100) {
        if (r100 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return (float) (((double) r100) / this.f31329a.F());
    }

    public Point toScreenLocation(LatLng r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (this.f31329a == null) goto L9;
        GeoPoint r101 = CoordUtil.ll2mc(r100);
        return this.f31329a.a(r101);
    L9:
        return null;
    }

    public Point geoPoint3toScreenLocation(LatLng r100, int r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (this.f31329a == null) goto L10;
        if (r101 < 0) goto L11;
        GeoPoint r102 = CoordUtil.ll2mc(r100);
        return this.f31329a.a(r102, r101);
    L11:
        return null;
    L10:
        return null;
    }

    public PointF toOpenGLLocation(LatLng r100, MapStatus r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        GeoPoint r102 = CoordUtil.ll2mc(r100);
        s r103 = r101.f31032c;
        double r104 = r103.f32203d;
        double r105 = r103.f32204e;
        return new PointF((float) (r102.getLongitudeE6() - r104), (float) (r102.getLatitudeE6() - r105));
    L9:
        return null;
    L7:
        return null;
    }

    public PointF toOpenGLNormalization(LatLng r110, MapStatus r111) {
        if (r110 == null) goto L7;
        if (r111 == null) goto L9;
        GeoPoint r112 = CoordUtil.ll2mc(r110);
        s.a r113 = r111.f31032c.f32210k;
        double r100 = Math.abs(r113.f32220b - r113.f32219a);
        double r101 = Math.abs(r113.f32221c - r113.f32222d);
        return new PointF((float) ((((r112.getLongitudeE6() - r113.f32219a) * 2.0d) / r100) - 1.0d), (float) ((((r112.getLatitudeE6() - r113.f32222d) * 2.0d) / r101) - 1.0d));
    L9:
        return null;
    L7:
        return null;
    }
}
