package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class Projection {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f6875a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.f6875a = bVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        if (point == null || (bVar = this.f6875a) == null) {
            return null;
        }
        return CoordUtil.mc2ll(bVar.a(point.x, point.y));
    }

    public Point geoPoint3toScreenLocation(LatLng latLng, int i4) {
        if (latLng == null || this.f6875a == null || i4 < 0) {
            return null;
        }
        return this.f6875a.a(CoordUtil.ll2mc(latLng), i4);
    }

    public float metersToEquatorPixels(float f4) {
        return f4 <= Property.DEFAULT_FLOAT_VALUE ? Property.DEFAULT_FLOAT_VALUE : (float) (f4 / this.f6875a.E());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        s sVar = mapStatus.f6517c;
        return new PointF((float) (geoPointLl2mc.getLongitudeE6() - sVar.f8102d), (float) (geoPointLl2mc.getLatitudeE6() - sVar.f8103e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        s.a aVar = mapStatus.f6517c.f8109k;
        return new PointF((float) ((((geoPointLl2mc.getLongitudeE6() - aVar.f8118a) * 2.0d) / Math.abs(aVar.f8119b - aVar.f8118a)) - 1.0d), (float) ((((geoPointLl2mc.getLatitudeE6() - aVar.f8121d) * 2.0d) / Math.abs(aVar.f8120c - aVar.f8121d)) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f6875a == null) {
            return null;
        }
        return this.f6875a.a(CoordUtil.ll2mc(latLng));
    }
}
