package com.baidu.mapapi.favorite;

import ch.qos.logback.core.joran.action.Action;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.platform.comapi.basestruct.Point;
import org.json.JSONObject;

/* loaded from: classes.dex */
class a {
    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6007c == null || (str = favoritePoiInfo.f6006b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7945b = favoritePoiInfo.f6006b;
        LatLng latLng = favoritePoiInfo.f6007c;
        favSyncPoi.f7946c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7947d = favoritePoiInfo.f6008d;
        favSyncPoi.f7948e = favoritePoiInfo.f6009e;
        favSyncPoi.f7949f = favoritePoiInfo.f6010f;
        favSyncPoi.f7952i = false;
        return favSyncPoi;
    }

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        if (favSyncPoi == null || favSyncPoi.f7946c == null || favSyncPoi.f7945b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f6005a = favSyncPoi.f7944a;
        favoritePoiInfo.f6006b = favSyncPoi.f7945b;
        Point point = favSyncPoi.f7946c;
        favoritePoiInfo.f6007c = new LatLng(point.f8601y / 1000000.0d, point.f8600x / 1000000.0d);
        favoritePoiInfo.f6009e = favSyncPoi.f7948e;
        favoritePoiInfo.f6010f = favSyncPoi.f7949f;
        favoritePoiInfo.f6008d = favSyncPoi.f7947d;
        favoritePoiInfo.f6011g = Long.parseLong(favSyncPoi.f7951h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        if (jSONObject.optJSONObject("pt") != null) {
            favoritePoiInfo.f6007c = new LatLng(r1.optInt("y") / 1000000.0d, r1.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f6006b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6011g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6008d = jSONObject.optString("addr");
        favoritePoiInfo.f6010f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6009e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6005a = jSONObject.optString(Action.KEY_ATTRIBUTE);
        return favoritePoiInfo;
    }
}
