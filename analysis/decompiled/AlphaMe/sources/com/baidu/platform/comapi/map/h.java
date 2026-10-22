package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class h implements Projection {

    /* renamed from: a, reason: collision with root package name */
    private MapController f9206a;

    public h(MapController mapController) {
        this.f9206a = mapController;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public GeoPoint fromPixels(int i4, int i5) {
        AppBaseMap baseMap = this.f9206a.getBaseMap();
        if (baseMap == null) {
            return null;
        }
        String strScrPtToGeoPoint = baseMap.ScrPtToGeoPoint(i4, i5);
        GeoPoint geoPoint = new GeoPoint(0, 0);
        if (strScrPtToGeoPoint != null) {
            try {
                JSONObject jSONObject = new JSONObject(strScrPtToGeoPoint);
                geoPoint.setLongitude(jSONObject.getDouble("geox"));
                geoPoint.setLatitude(jSONObject.getDouble("geoy"));
                return geoPoint;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public float metersToEquatorPixels(float f4) {
        return (float) (f4 / this.f9206a.getZoomUnitsInMeter());
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint geoPoint, Point point) {
        String strGeoPtToScrPoint;
        if (point == null) {
            point = new Point(0, 0);
        }
        AppBaseMap baseMap = this.f9206a.getBaseMap();
        if (baseMap != null && (strGeoPtToScrPoint = baseMap.GeoPtToScrPoint((int) geoPoint.getLongitude(), (int) geoPoint.getLatitude())) != null) {
            try {
                JSONObject jSONObject = new JSONObject(strGeoPtToScrPoint);
                point.setIntX(jSONObject.getInt("scrx"));
                point.setIntY(jSONObject.getInt("scry"));
            } catch (JSONException unused) {
            }
        }
        return point;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point world2Screen(float f4, float f5, float f6) {
        Point point = new Point(0, 0);
        AppBaseMap baseMap = this.f9206a.getBaseMap();
        if (baseMap == null) {
            return point;
        }
        String strWorldPointToScreenPoint = baseMap.worldPointToScreenPoint(f4, f5, f6);
        if (strWorldPointToScreenPoint == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strWorldPointToScreenPoint);
            point.setDoubleX(jSONObject.optDouble("scrx"));
            point.setDoubleY(jSONObject.optDouble("scry"));
            return point;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint geoPoint, int i4, Point point) {
        String strGeoPt3ToScrPoint;
        if (point == null) {
            point = new Point(0, 0);
        }
        AppBaseMap baseMap = this.f9206a.getBaseMap();
        if (baseMap != null && (strGeoPt3ToScrPoint = baseMap.geoPt3ToScrPoint((int) geoPoint.getLongitude(), (int) geoPoint.getLatitude(), i4)) != null) {
            try {
                JSONObject jSONObject = new JSONObject(strGeoPt3ToScrPoint);
                point.setIntX(jSONObject.getInt("scrx"));
                point.setIntY(jSONObject.getInt("scry"));
            } catch (JSONException unused) {
            }
        }
        return point;
    }
}
