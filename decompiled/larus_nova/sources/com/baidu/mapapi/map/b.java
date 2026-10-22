package com.baidu.mapapi.map;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
abstract class b<T> extends BaseBackgroundDrawLayer {
    protected MapController mController;
    protected T mEntity;

    public b(Context r100) {
        super(r100);
    }

    public final void updateEntity(T r100) {
        this.mEntity = r100;
    }

    public final void updateMapController(MapController r100) {
        this.mController = r100;
    }

    public b(Context r100, int r101) {
        super(r100, r101);
    }

    public final void toScreenLocation(LatLng r100, Point r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        GeoPoint r102 = CoordUtil.ll2mc(r100);
        toScreenLocation((int) r102.getLongitude(), (int) r102.getLatitude(), r101);
    }

    public final void toScreenLocation(int r100, int r101, Point r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        MapController r103 = this.mController;
        if (r103 != null) goto L8;
        r102.setTo(-1.0d, -1.0d);
        return;
    L8:
        AppBaseMap r104 = r103.getBaseMap();
        if (r104 != null) goto L12;
        r102.setTo(-1.0d, -1.0d);
        return;
    L12:
        String r105 = r104.GeoPtToScrPoint(r100, r101);
        if (TextUtils.isEmpty(r105) == false) goto L20;
        r102.setTo(-1.0d, -1.0d);
        return;
    L20:
        JSONObject r106 = new JSONObject(r105);     // Catch: JSONException -> L18
        r102.setIntX(r106.optInt("scrx", -1));     // Catch: JSONException -> L18
        r102.setIntY(r106.optInt("scry", -1));     // Catch: JSONException -> L18
        return;
    L18:
        r102.setTo(-1.0d, -1.0d);
    }
}
