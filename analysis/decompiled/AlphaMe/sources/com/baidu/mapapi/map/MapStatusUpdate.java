package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class MapStatusUpdate {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6527a = "MapStatusUpdate";

    /* renamed from: b, reason: collision with root package name */
    private int f6528b;

    /* renamed from: c, reason: collision with root package name */
    MapStatus f6529c;

    /* renamed from: d, reason: collision with root package name */
    LatLng f6530d;

    /* renamed from: e, reason: collision with root package name */
    LatLngBounds f6531e;

    /* renamed from: f, reason: collision with root package name */
    int f6532f;

    /* renamed from: g, reason: collision with root package name */
    int f6533g;

    /* renamed from: h, reason: collision with root package name */
    float f6534h;

    /* renamed from: i, reason: collision with root package name */
    int f6535i;

    /* renamed from: j, reason: collision with root package name */
    int f6536j;

    /* renamed from: k, reason: collision with root package name */
    float f6537k;

    /* renamed from: l, reason: collision with root package name */
    Point f6538l;

    /* renamed from: m, reason: collision with root package name */
    int f6539m = 0;

    /* renamed from: n, reason: collision with root package name */
    int f6540n = 0;

    /* renamed from: o, reason: collision with root package name */
    int f6541o = 0;

    /* renamed from: p, reason: collision with root package name */
    int f6542p = 0;

    private MapStatusUpdate() {
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.b bVar, MapStatus mapStatus) {
        Point point;
        if (bVar == null || mapStatus == null) {
            return null;
        }
        Point point2 = mapStatus.targetScreen;
        Point point3 = bVar.f8000X;
        if (point3 != null) {
            if (point2 != null && (point = bVar.f7999W) != null && (point.x != point3.x || point.y != point3.y)) {
                point2 = point;
            }
            bVar.f8000X = null;
        } else {
            bVar.f7999W = point2;
        }
        switch (this.f6528b) {
            case 1:
                MapStatus mapStatus2 = this.f6529c;
                if (mapStatus2.targetScreen == null) {
                    MapStatus mapStatus3 = this.f6529c;
                    break;
                }
                break;
            case 3:
                LatLngBounds latLngBounds = this.f6531e;
                if (latLngBounds != null) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                    GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6531e.northeast);
                    double longitudeE6 = geoPointLl2mc.getLongitudeE6();
                    double latitudeE6 = geoPointLl2mc2.getLatitudeE6();
                    double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
                    int latitudeE62 = (int) geoPointLl2mc.getLatitudeE6();
                    WinRound winRound = mapStatus.f6517c.f8108j;
                    break;
                }
                break;
            case 5:
                GeoPoint geoPointA = bVar.a((bVar.D() / 2) + this.f6535i, (bVar.q() / 2) + this.f6536j);
                break;
            case 6:
                break;
            case 7:
                Point point4 = this.f6538l;
                break;
            case 8:
                break;
            case 9:
                LatLngBounds latLngBounds2 = this.f6531e;
                if (latLngBounds2 != null) {
                    GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                    GeoPoint geoPointLl2mc4 = CoordUtil.ll2mc(this.f6531e.northeast);
                    break;
                }
                break;
            case 10:
                if (this.f6531e != null) {
                    int iD = (bVar.D() - this.f6539m) - this.f6541o;
                    if (iD < 0) {
                        iD = bVar.D();
                        Log.e(f6527a, "Bound paddingLeft or paddingRight too larger, please check");
                    }
                    int iQ = (bVar.q() - this.f6540n) - this.f6542p;
                    if (iQ < 0) {
                        iQ = bVar.q();
                        Log.e(f6527a, "Bound paddingTop or paddingBottom too larger, please check");
                    }
                    float fA = a(this.f6531e, bVar, iD, iQ);
                    LatLng latLngA = a(this.f6531e, bVar, a(fA));
                    if (latLngA != null) {
                        bVar.f8000X = new Point((iD / 2) + this.f6539m, (iQ / 2) + this.f6540n);
                        boolean zA = a(this.f6531e, bVar);
                        boolean zA2 = a(this.f6539m, this.f6540n, this.f6541o, this.f6542p, bVar);
                        if (!zA && !zA2) {
                            if (bVar.r() != null) {
                                break;
                            }
                        } else {
                            MapStatus mapStatus4 = new MapStatus(Property.DEFAULT_FLOAT_VALUE, latLngA, mapStatus.overlook, fA, bVar.f8000X, null);
                            bVar.a(a(mapStatus4));
                            break;
                        }
                    } else {
                        Log.e(f6527a, "Bound center error");
                        break;
                    }
                }
                break;
            case 11:
                if (this.f6531e != null) {
                    int iD2 = (bVar.D() - this.f6539m) - this.f6541o;
                    if (iD2 < 0) {
                        iD2 = bVar.D();
                        Log.e(f6527a, "Bound paddingLeft or paddingRight too larger, please check");
                    }
                    int iQ2 = (bVar.q() - this.f6540n) - this.f6542p;
                    if (iQ2 < 0) {
                        iQ2 = bVar.q();
                        Log.e(f6527a, "Bound paddingTop or paddingBottom too larger, please check");
                    }
                    GeoPoint geoPointLl2mc5 = CoordUtil.ll2mc(this.f6531e.southwest);
                    GeoPoint geoPointLl2mc6 = CoordUtil.ll2mc(this.f6531e.northeast);
                    float fA2 = bVar.a((int) geoPointLl2mc5.getLongitudeE6(), (int) geoPointLl2mc6.getLatitudeE6(), (int) geoPointLl2mc6.getLongitudeE6(), (int) geoPointLl2mc5.getLatitudeE6(), iD2, iQ2);
                    bVar.f8000X = new Point((iD2 / 2) + this.f6539m, (iQ2 / 2) + this.f6540n);
                    break;
                }
                break;
        }
        return null;
    }

    public MapStatusUpdate(int i4) {
        this.f6528b = i4;
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.b bVar, int i4, int i5) {
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        int longitudeE6 = (int) geoPointLl2mc.getLongitudeE6();
        int latitudeE6 = (int) geoPointLl2mc.getLatitudeE6();
        return bVar.a(longitudeE6, (int) geoPointLl2mc2.getLatitudeE6(), (int) geoPointLl2mc2.getLongitudeE6(), latitudeE6, i4, i5);
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.b bVar) {
        MapStatusUpdate mapStatusUpdateR = bVar.r();
        if (mapStatusUpdateR == null) {
            return true;
        }
        LatLng latLng = latLngBounds.southwest;
        double d4 = latLng.latitude;
        double d5 = latLng.longitude;
        LatLng latLng2 = latLngBounds.northeast;
        double d6 = latLng2.latitude;
        double d7 = latLng2.longitude;
        LatLngBounds latLngBounds2 = mapStatusUpdateR.f6531e;
        LatLng latLng3 = latLngBounds2.southwest;
        double d8 = latLng3.latitude;
        double d9 = latLng3.longitude;
        LatLng latLng4 = latLngBounds2.northeast;
        return (d4 == d8 && d5 == d9 && d6 == latLng4.latitude && d7 == latLng4.longitude) ? false : true;
    }

    private boolean a(int i4, int i5, int i6, int i7, com.baidu.mapsdkplatform.comapi.map.b bVar) {
        MapStatusUpdate mapStatusUpdateR = bVar.r();
        return (mapStatusUpdateR != null && i4 == mapStatusUpdateR.f6539m && i5 == mapStatusUpdateR.f6540n && i6 == mapStatusUpdateR.f6541o && i7 == mapStatusUpdateR.f6542p) ? false : true;
    }

    private LatLng a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.b bVar, float f4) {
        double longitudeE6;
        double latitudeE6;
        double latitudeE62;
        if (latLngBounds == null || bVar == null) {
            return null;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
        int i4 = this.f6539m;
        double d4 = i4 * f4;
        int i5 = this.f6541o;
        double d5 = i5 * f4;
        double d6 = this.f6540n * f4;
        double d7 = this.f6542p * f4;
        if (i4 > i5) {
            longitudeE6 = geoPointLl2mc.getLongitudeE6() - ((d4 - d5) / 2.0d);
        } else if (i4 < i5) {
            longitudeE6 = geoPointLl2mc.getLongitudeE6() + ((d5 - d4) / 2.0d);
        } else {
            longitudeE6 = geoPointLl2mc.getLongitudeE6();
        }
        int i6 = this.f6540n;
        int i7 = this.f6542p;
        if (i6 < i7) {
            latitudeE62 = geoPointLl2mc.getLatitudeE6() - ((d7 - d6) / 2.0d);
        } else if (i6 > i7) {
            latitudeE62 = geoPointLl2mc.getLatitudeE6();
            d6 -= d7;
        } else {
            latitudeE6 = geoPointLl2mc.getLatitudeE6();
            return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
        }
        latitudeE6 = (d6 / 2.0d) + latitudeE62;
        return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
        synchronized (this) {
            mapStatusUpdate.f6529c = mapStatus;
            mapStatusUpdate.f6531e = this.f6531e;
            mapStatusUpdate.f6539m = this.f6539m;
            mapStatusUpdate.f6540n = this.f6540n;
            mapStatusUpdate.f6541o = this.f6541o;
            mapStatusUpdate.f6542p = this.f6542p;
        }
        return mapStatusUpdate;
    }

    private float a(float f4) {
        return (float) (Math.pow(2.0d, 18.0f - f4) / SysOSUtil.getDensityDpi());
    }
}
