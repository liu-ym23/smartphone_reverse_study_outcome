package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: loaded from: classes39.dex */
public final class MapStatusUpdate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31041a = "MapStatusUpdate";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    MapStatus f31043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    LatLng f31044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    LatLngBounds f31045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f31046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f31047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f31048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f31050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f31051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Point f31052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f31053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f31054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f31055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f31056p;

    private MapStatusUpdate() {
        this.f31053m = 0;
        this.f31054n = 0;
        this.f31055o = 0;
        this.f31056p = 0;
    }

    public MapStatusUpdate(int r100) {
        this.f31053m = 0;
        this.f31054n = 0;
        this.f31055o = 0;
        this.f31056p = 0;
        this.f31042b = r100;
    }

    private MapStatusUpdate a(MapStatus r100) {
        MapStatusUpdate r101 = new MapStatusUpdate();
        monitor-enter(this);
        r101.f31043c = r100;     // Catch: Throwable -> L7
        r101.f31045e = this.f31045e;     // Catch: Throwable -> L7
        r101.f31053m = this.f31053m;     // Catch: Throwable -> L7
        r101.f31054n = this.f31054n;     // Catch: Throwable -> L7
        r101.f31055o = this.f31055o;     // Catch: Throwable -> L7
        r101.f31056p = this.f31056p;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private float a(float r100) {
        return (float) (Math.pow(2.0d, 18.0f - r100) / ((double) SysOSUtil.getDensityDpi()));
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.b r210, MapStatus r211) {
        if (r210 == null) goto L79;
        if (r211 == null) goto L79;
        Point r100 = r211.targetScreen;
        Point r101 = r210.X;
        if (r101 == null) goto L17;
        if (r100 == null) goto L16;
        Point r102 = r210.W;
        if (r102 == null) goto L16;
        if (r102.x == r101.x) goto L14;
    L15:
        r100 = r102;
        goto L16
    L14:
        if (r102.y != r101.y) goto L15;
    L16:
        r210.X = null;
    L19:
        switch(this.f31042b) {
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L68;
            case 4: goto L67;
            case 5: goto L64;
            case 6: goto L62;
            case 7: goto L60;
            case 8: goto L58;
            case 9: goto L53;
            case 10: goto L33;
            case 11: goto L22;
            default: goto L20;
        };
    L20:
        return null;
    L53:
        LatLngBounds r103 = this.f31045e;
        if (r103 != null) goto L56;
        return null;
    L56:
        GeoPoint r104 = CoordUtil.ll2mc(r103.southwest);
        GeoPoint r105 = CoordUtil.ll2mc(this.f31045e.northeast);
        double r106 = r104.getLongitudeE6();
        double r107 = r105.getLatitudeE6();
        double r108 = r105.getLongitudeE6();
        float r110 = r210.a((int) r106, (int) r107, (int) r108, (int) r104.getLatitudeE6(), this.f31046f, this.f31047g);
        LatLng r111 = this.f31045e.getCenter();
        return new MapStatus(r211.rotate, r111, r211.overlook, r110, r100, null);
    L58:
        Point r112 = r100;
        return new MapStatus(r211.rotate, r211.target, r211.overlook, this.f31048h, r112, r211.b(), r211.c(), null);
    L60:
        Point r109 = this.f31052l;
        LatLng r113 = CoordUtil.mc2ll(r210.a(r109.x, r109.y));
        return new MapStatus(r211.rotate, r113, r211.overlook, r211.zoom + this.f31051k, this.f31052l, null);
    L62:
        Point r114 = r100;
        return new MapStatus(r211.rotate, r211.target, r211.overlook, r211.zoom + this.f31051k, r114, r211.b(), r211.c(), null);
    L64:
        GeoPoint r115 = r210.a((r210.E() / 2) + this.f31049i, (r210.r() / 2) + this.f31050j);
        LatLng r116 = CoordUtil.mc2ll(r115);
        Point r117 = r100;
        return new MapStatus(r211.rotate, r116, r211.overlook, r211.zoom, r117, r115.getLongitudeE6(), r115.getLatitudeE6(), null);
    L68:
        LatLngBounds r118 = this.f31045e;
        if (r118 != null) goto L71;
        return null;
    L71:
        GeoPoint r119 = CoordUtil.ll2mc(r118.southwest);
        GeoPoint r120 = CoordUtil.ll2mc(this.f31045e.northeast);
        double r121 = r119.getLongitudeE6();
        double r122 = r120.getLatitudeE6();
        double r123 = r120.getLongitudeE6();
        int r124 = (int) r119.getLatitudeE6();
        WinRound r125 = r211.f31032c.f32209j;
        float r126 = r210.a((int) r121, (int) r122, (int) r123, r124, r125.right - r125.left, r125.bottom - r125.top);
        LatLng r127 = this.f31045e.getCenter();
        return new MapStatus(r211.rotate, r127, r211.overlook, r126, r100, null);
    L75:
        MapStatus r128 = this.f31043c;
        if (r128.targetScreen != null) goto L82;
        MapStatus r129 = this.f31043c;
        Point r130 = r100;
        return new MapStatus(r129.rotate, r129.target, r129.overlook, r129.zoom, r130, r129.bound);
    L82:
        return r128;
    L22:
        if (this.f31045e != null) goto L24;
        return null;
    L24:
        int r131 = (r210.E() - this.f31053m) - this.f31055o;
        if (r131 >= 0) goto L27;
        r131 = r210.E();
    L27:
        int r132 = (r210.r() - this.f31054n) - this.f31056p;
        if (r132 >= 0) goto L30;
        r132 = r210.r();
    L30:
        GeoPoint r133 = CoordUtil.ll2mc(this.f31045e.southwest);
        GeoPoint r134 = CoordUtil.ll2mc(this.f31045e.northeast);
        double r135 = r133.getLongitudeE6();
        double r136 = r134.getLatitudeE6();
        double r137 = r134.getLongitudeE6();
        float r138 = r210.a((int) r135, (int) r136, (int) r137, (int) r133.getLatitudeE6(), r131, r132);
        r210.X = new Point(this.f31053m + (r131 / 2), this.f31054n + (r132 / 2));
        return new MapStatus(0.0f, this.f31045e.getCenter(), r211.overlook, r138, r210.X, null);
    L33:
        if (this.f31045e != null) goto L35;
        return null;
    L35:
        int r139 = (r210.E() - this.f31053m) - this.f31055o;
        if (r139 >= 0) goto L38;
        r139 = r210.E();
    L38:
        int r140 = (r210.r() - this.f31054n) - this.f31056p;
        if (r140 >= 0) goto L41;
        r140 = r210.r();
    L41:
        float r141 = a(this.f31045e, r210, r139, r140);
        float r142 = a(r141);
        LatLng r143 = a(this.f31045e, r210, r142);
        if (r143 != null) goto L44;
        return null;
    L44:
        r210.X = new Point(this.f31053m + (r139 / 2), this.f31054n + (r140 / 2));
        boolean r144 = a(this.f31045e, r210);
        boolean r145 = a(this.f31053m, this.f31054n, this.f31055o, this.f31056p, r210);
        if (r144 == true) goto L51;
        if (r145 == true) goto L51;
        if (r210.s() != null) goto L81;
        return null;
    L81:
        return r210.s().f31043c;
    L51:
        MapStatus r146 = new MapStatus(0.0f, r143, r211.overlook, r141, r210.X, null);
        r210.a(a(r146));
        return r146;
    L67:
        return new MapStatus(r211.rotate, this.f31044d, r211.overlook, this.f31048h, r100, null);
    L74:
        return new MapStatus(r211.rotate, this.f31044d, r211.overlook, r211.zoom, r100, null);
    L17:
        r210.W = r100;
    L79:
        return null;
    }

    private boolean a(LatLngBounds r110, com.baidu.mapsdkplatform.comapi.map.b r111) {
        MapStatusUpdate r100 = r111.s();
        if (r100 != null) goto L5;
        return true;
    L5:
        LatLng r101 = r110.southwest;
        double r102 = r101.latitude;
        double r103 = r101.longitude;
        LatLng r104 = r110.northeast;
        double r105 = r104.latitude;
        double r112 = r104.longitude;
        LatLngBounds r106 = r100.f31045e;
        LatLng r107 = r106.southwest;
        double r113 = r107.latitude;
        double r114 = r107.longitude;
        LatLng r108 = r106.northeast;
        double r109 = r108.latitude;
        double r115 = r108.longitude;
        if (r102 == r113) goto L8;
        return true;
    L8:
        if (r103 == r114) goto L10;
        return true;
    L10:
        if (r105 == r109) goto L12;
        return true;
    L12:
        if (r112 != r115) goto L20;
        return false;
    L20:
        return true;
    }

    private LatLng a(LatLngBounds r110, com.baidu.mapsdkplatform.comapi.map.b r111, float r112) {
        if (r110 == null) goto L20;
        if (r111 == null) goto L22;
        GeoPoint r113 = CoordUtil.ll2mc(r110.getCenter());
        int r114 = this.f31053m;
        double r100 = r114 * r112;
        int r101 = this.f31055o;
        double r102 = r101 * r112;
        double r103 = this.f31054n * r112;
        double r104 = this.f31056p * r112;
        if (r114 <= r101) goto L8;
        double r115 = r113.getLongitudeE6() - ((r100 - r102) / 2.0d);
    L11:
        int r105 = this.f31054n;
        int r106 = this.f31056p;
        if (r105 >= r106) goto L15;
        double r107 = r113.getLatitudeE6() - ((r104 - r103) / 2.0d);
    L14:
        double r108 = r107 + (r103 / 2.0d);
    L19:
        return CoordUtil.mc2ll(new GeoPoint(r108, r115));
    L15:
        if (r105 <= r106) goto L17;
        r107 = r113.getLatitudeE6();
        r103 = r103 - r104;
        goto L14
    L17:
        r108 = r113.getLatitudeE6();
        goto L19
    L8:
        if (r114 >= r101) goto L10;
        r115 = r113.getLongitudeE6() + ((r102 - r100) / 2.0d);
        goto L11
    L10:
        r115 = r113.getLongitudeE6();
        goto L11
    L22:
        return null;
    L20:
        return null;
    }

    private float a(LatLngBounds r110, com.baidu.mapsdkplatform.comapi.map.b r111, int r112, int r113) {
        GeoPoint r100 = CoordUtil.ll2mc(r110.southwest);
        GeoPoint r114 = CoordUtil.ll2mc(r110.northeast);
        int r101 = (int) r100.getLongitudeE6();
        int r102 = (int) r100.getLatitudeE6();
        int r103 = (int) r114.getLongitudeE6();
        return r111.a(r101, (int) r114.getLatitudeE6(), r103, r102, r112, r113);
    }

    private boolean a(int r100, int r101, int r102, int r103, com.baidu.mapsdkplatform.comapi.map.b r104) {
        MapStatusUpdate r105 = r104.s();
        if (r105 != null) goto L6;
        return true;
    L6:
        if (r100 == r105.f31053m) goto L8;
    L16:
        return true;
    L8:
        if (r101 != r105.f31054n) goto L16;
        if (r102 != r105.f31055o) goto L16;
        if (r103 != r105.f31056p) goto L16;
        return false;
    }
}
