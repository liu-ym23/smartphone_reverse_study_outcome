package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.mapcore.util.j0;
import com.amap.api.mapcore.util.k0;
import com.amap.api.mapcore.util.l0;
import com.amap.api.mapcore.util.m0;
import com.amap.api.mapcore.util.n0;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* JADX INFO: loaded from: classes28.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate zoomIn() {
        m0 r100 = new m0();
        r100.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        r100.amount = 1.0f;
        return new CameraUpdate(r100);
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(n0.a());
    }

    public CameraUpdateFactory() {
    }

    public static CameraUpdate changeBearing(float r100) {
        return new CameraUpdate(n0.a(r100 % 360.0f));
    }

    public static CameraUpdate changeLatLng(LatLng r100) {
        if (r100 != null) goto L6;
        return new CameraUpdate(new k0());
    L6:
        return new CameraUpdate(n0.a(VirtualEarthProjection.latLongToPixels(r100.latitude, r100.longitude, 20)));
    }

    public static CameraUpdate changeTilt(float r100) {
        k0 r101 = new k0();
        r101.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        r101.tilt = r100;
        return new CameraUpdate(r101);
    }

    public static CameraUpdate newCameraPosition(CameraPosition r100) {
        if (r100 != null) goto L6;
        return new CameraUpdate(new k0());
    L6:
        return new CameraUpdate(n0.a(r100));
    }

    public static CameraUpdate newLatLng(LatLng r100) {
        if (r100 != null) goto L6;
        return new CameraUpdate(new k0());
    L6:
        return new CameraUpdate(n0.a(CameraPosition.builder().target(r100).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build()));
    }

    public static CameraUpdate zoomBy(float r100) {
        return new CameraUpdate(n0.a(r100, null));
    }

    public static CameraUpdate zoomTo(float r100) {
        k0 r101 = new k0();
        r101.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        r101.zoom = r100;
        return new CameraUpdate(r101);
    }

    public static CameraUpdate changeBearingGeoCenter(float r100, IPoint r101) {
        if (r101 == null) goto L4;
        Point r102 = new Point(((Point) r101).x, ((Point) r101).y);
        k0 r103 = new k0();
        r103.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        r103.geoPoint = new DPoint(r102.x, r102.y);
        r103.bearing = r100 % 360.0f;
        return new CameraUpdate(r103);
    L4:
        return new CameraUpdate(new k0());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds r100, int r101) {
        if (r100 == null) goto L4;
        j0 r102 = new j0();
        r102.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        r102.bounds = r100;
        r102.paddingLeft = r101;
        r102.paddingRight = r101;
        r102.paddingTop = r101;
        r102.paddingBottom = r101;
        return new CameraUpdate(r102);
    L4:
        return new CameraUpdate(new k0());
    }

    public static CameraUpdate newLatLngZoom(LatLng r100, float r101) {
        if (r100 != null) goto L6;
        return new CameraUpdate(new k0());
    L6:
        return new CameraUpdate(n0.a(CameraPosition.builder().target(r100).zoom(r101).bearing(Float.NaN).tilt(Float.NaN).build()));
    }

    public static CameraUpdate scrollBy(float r100, float r101) {
        l0 r102 = new l0();
        r102.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        r102.xPixel = r100;
        r102.yPixel = r101;
        return new CameraUpdate(r102);
    }

    public static CameraUpdate zoomBy(float r100, Point r101) {
        return new CameraUpdate(n0.a(r100, r101));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds r100, int r101, int r102, int r103) {
        if (r100 == null) goto L4;
        j0 r104 = new j0();
        r104.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        r104.bounds = r100;
        r104.paddingLeft = r103;
        r104.paddingRight = r103;
        r104.paddingTop = r103;
        r104.paddingBottom = r103;
        r104.width = r101;
        r104.height = r102;
        return new CameraUpdate(r104);
    L4:
        return new CameraUpdate(new k0());
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds r100, int r101, int r102, int r103, int r104) {
        if (r100 == null) goto L4;
        j0 r105 = new j0();
        r105.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        r105.bounds = r100;
        r105.paddingLeft = r101;
        r105.paddingRight = r102;
        r105.paddingTop = r103;
        r105.paddingBottom = r104;
        return new CameraUpdate(r105);
    L4:
        return new CameraUpdate(new k0());
    }
}
