package com.baidu.mapapi.favorite;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.platform.comapi.basestruct.Point;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
class a {
    public static FavoritePoiInfo a(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FavoritePoiInfo r101 = new FavoritePoiInfo();
        JSONObject r102 = r100.optJSONObject(GXTemplateKey.GAIAX_PT);
        if (r102 == null) goto L8;
        int r103 = r102.optInt("x");
        r101.f30550c = new LatLng(((double) r102.optInt("y")) / 1000000.0d, ((double) r103) / 1000000.0d);
    L8:
        r101.f30549b = r100.optString("uspoiname");
        r101.f30554g = CastLongProtector.parseLong(r100.optString("addtimesec"));
        r101.f30551d = r100.optString("addr");
        r101.f30553f = r100.optString("uspoiuid");
        r101.f30552e = r100.optString("ncityid");
        r101.f30548a = r100.optString("key");
        return r101;
    }

    public static FavoritePoiInfo a(FavSyncPoi r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.f32070c != null) goto L6;
        return null;
    L6:
        if (r100.f32069b.equals("") == true) goto L13;
        FavoritePoiInfo r101 = new FavoritePoiInfo();
        r101.f30548a = r100.f32068a;
        r101.f30549b = r100.f32069b;
        Point r102 = r100.f32070c;
        r101.f30550c = new LatLng(((double) r102.f32738y) / 1000000.0d, ((double) r102.f32737x) / 1000000.0d);
        r101.f30552e = r100.f32072e;
        r101.f30553f = r100.f32073f;
        r101.f30551d = r100.f32071d;
        r101.f30554g = CastLongProtector.parseLong(r100.f32075h);
        return r101;
    L13:
        return null;
    }

    public static FavSyncPoi a(FavoritePoiInfo r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.f30550c == null) goto L14;
        String r101 = r100.f30549b;
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.equals("") == true) goto L16;
        FavSyncPoi r102 = new FavSyncPoi();
        r102.f32069b = r100.f30549b;
        LatLng r103 = r100.f30550c;
        r102.f32070c = new Point((int) (r103.longitude * 1000000.0d), (int) (r103.latitude * 1000000.0d));
        r102.f32071d = r100.f30551d;
        r102.f32072e = r100.f30552e;
        r102.f32073f = r100.f30553f;
        r102.f32076i = false;
        return r102;
    L16:
        return null;
    L14:
        return null;
    }
}
