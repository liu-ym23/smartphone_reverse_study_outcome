package com.baidu.mapapi.favorite;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class FavoriteManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static FavoriteManager f30546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.baidu.mapsdkplatform.comapi.favrite.a f30547b;

    public static FavoriteManager getInstance() {
        if (f30546a != null) goto L6;
        f30546a = new FavoriteManager();
    L6:
        return f30546a;
    }

    public boolean clearAllFavPois() {
        com.baidu.mapsdkplatform.comapi.favrite.a r100 = f30547b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a r100 = f30547b;
        if (r100 == null) goto L6;
        r100.b();
        f30547b = null;
        BMapManager.destroy();
        e.a();
        return;
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        com.baidu.mapsdkplatform.comapi.favrite.a r100 = f30547b;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.c();
        if (r101 != null) goto L8;
    L28:
        return null;
    L8:
        if (r101.equals("") == true) goto L28;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L26
        if (r102.optInt("favpoinum") != 0) goto L13;
        return null;
    L13:
        JSONArray r103 = r102.optJSONArray("favcontents");     // Catch: JSONException -> L26
        if (r103 == null) goto L28;
        if (r103.length() <= 0) goto L28;
        ArrayList r104 = new ArrayList();     // Catch: JSONException -> L26
        int r105 = 0;
    L19:
        if (r105 >= r103.length()) goto L25;
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r103, r105);     // Catch: JSONException -> L26
        if (r106 == null) goto L24;
        r104.add(a.a(r106));     // Catch: JSONException -> L26
    L24:
        r105 = r105 + 1;
        goto L19
    L25:
        return r104;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public void init() {
        if (f30547b != null) goto L6;
        e.c();
        BMapManager.init();
        f30547b = com.baidu.mapsdkplatform.comapi.favrite.a.f();
        return;
    }

    private FavoriteManager() {
    }

    public int add(FavoritePoiInfo r100) {
        if (f30547b != null) goto L5;
        return 0;
    L5:
        if (r100 != null) goto L7;
    L20:
        return 0;
    L7:
        if (r100.f30550c == null) goto L20;
        String r101 = r100.f30549b;
        if (r101 != null) goto L12;
        return -1;
    L12:
        if (r101.equals("") == true) goto L21;
        FavSyncPoi r102 = a.a(r100);
        int r103 = f30547b.a(r102.f32069b, r102);
        if (r103 != 1) goto L17;
        r100.f30548a = r102.f32068a;
        r100.f30554g = CastLongProtector.parseLong(r102.f32075h);
    L17:
        return r103;
    L21:
        return -1;
    }

    public boolean deleteFavPoi(String r100) {
        if (f30547b != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L11:
        return false;
    L7:
        if (r100.equals("") == true) goto L11;
        return f30547b.a(r100);
    }

    public FavoritePoiInfo getFavPoi(String r100) {
        if (f30547b != null) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
    L13:
        return null;
    L7:
        if (r100.equals("") == true) goto L13;
        FavSyncPoi r101 = f30547b.b(r100);
        if (r101 == null) goto L13;
        return a.a(r101);
    }

    public boolean updateFavPoi(String r100, FavoritePoiInfo r101) {
        if (f30547b != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L20:
        return false;
    L7:
        if (r100.equals("") == true) goto L20;
        if (r101 == null) goto L20;
        if (r101.f30550c != null) goto L13;
        return false;
    L13:
        String r102 = r101.f30549b;
        if (r102 == null) goto L20;
        if (r102.equals("") == true) goto L20;
        r101.f30548a = r100;
        FavSyncPoi r103 = a.a(r101);
        return f30547b.b(r100, r103);
    }
}
