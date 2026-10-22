package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
class h implements Projection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapController f33311a;

    public h(MapController r100) {
        this.f33311a = r100;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public float metersToEquatorPixels(float r100) {
        return (float) (((double) r100) / this.f33311a.getZoomUnitsInMeter());
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public GeoPoint fromPixels(int r100, int r101) {
        AppBaseMap r102 = this.f33311a.getBaseMap();
        if (r102 != null) goto L5;
        return null;
    L5:
        String r103 = r102.ScrPtToGeoPoint(r100, r101);
        GeoPoint r104 = new GeoPoint(0, 0);
        if (r103 != null) goto L11;
    L9:
        return null;
    L11:
        JSONObject r105 = new JSONObject(r103);     // Catch: JSONException -> L10
        r104.setLongitude(JSONObjectProtectorUtils.getDouble(r105, "geox"));     // Catch: JSONException -> L10
        r104.setLatitude(JSONObjectProtectorUtils.getDouble(r105, "geoy"));     // Catch: JSONException -> L10
        return r104;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint r100, Point r101) {
        if (r101 != null) goto L4;
        r101 = new Point(0, 0);
    L4:
        AppBaseMap r102 = this.f33311a.getBaseMap();
        if (r102 != null) goto L7;
        return r101;
    L7:
        String r103 = r102.GeoPtToScrPoint((int) r100.getLongitude(), (int) r100.getLatitude());
        if (r103 != null) goto L12;
    L10:
        return r101;
    L12:
        JSONObject r104 = new JSONObject(r103);     // Catch: JSONException -> L11
        r101.setIntX(JSONObjectProtectorUtils.getInt(r104, "scrx"));     // Catch: JSONException -> L11
        r101.setIntY(JSONObjectProtectorUtils.getInt(r104, "scry"));     // Catch: JSONException -> L11
        goto L10
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint r100, int r101, Point r102) {
        if (r102 != null) goto L4;
        r102 = new Point(0, 0);
    L4:
        AppBaseMap r103 = this.f33311a.getBaseMap();
        if (r103 != null) goto L7;
        return r102;
    L7:
        String r104 = r103.geoPt3ToScrPoint((int) r100.getLongitude(), (int) r100.getLatitude(), r101);
        if (r104 != null) goto L12;
    L10:
        return r102;
    L12:
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L11
        r102.setIntX(JSONObjectProtectorUtils.getInt(r105, "scrx"));     // Catch: JSONException -> L11
        r102.setIntY(JSONObjectProtectorUtils.getInt(r105, "scry"));     // Catch: JSONException -> L11
        goto L10
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point world2Screen(float r100, float r101, float r102) {
        Point r103 = new Point(0, 0);
        AppBaseMap r104 = this.f33311a.getBaseMap();
        if (r104 != null) goto L5;
        return r103;
    L5:
        String r105 = r104.worldPointToScreenPoint(r100, r101, r102);
        if (r105 != null) goto L12;
        return null;
    L12:
        JSONObject r106 = new JSONObject(r105);     // Catch: JSONException -> L11
        r103.setDoubleX(r106.optDouble("scrx"));     // Catch: JSONException -> L11
        r103.setDoubleY(r106.optDouble("scry"));     // Catch: JSONException -> L11
        return r103;
    L14:
        return null;
    }
}
