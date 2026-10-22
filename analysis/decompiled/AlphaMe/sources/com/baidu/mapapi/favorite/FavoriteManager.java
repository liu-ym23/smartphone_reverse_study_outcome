package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FavoriteManager {

    /* renamed from: a, reason: collision with root package name */
    private static FavoriteManager f6003a;

    /* renamed from: b, reason: collision with root package name */
    private static com.baidu.mapsdkplatform.comapi.favrite.a f6004b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (f6003a == null) {
            f6003a = new FavoriteManager();
        }
        return f6003a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        if (f6004b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return 0;
        }
        if (favoritePoiInfo == null || favoritePoiInfo.f6007c == null) {
            Log.e("baidumapsdk", "object or pt can not be null!");
            return 0;
        }
        String str = favoritePoiInfo.f6006b;
        if (str == null || str.equals("")) {
            Log.e("baidumapsdk", "poiName can not be null or empty!");
            return -1;
        }
        FavSyncPoi favSyncPoiA = a.a(favoritePoiInfo);
        int iA = f6004b.a(favSyncPoiA.f7945b, favSyncPoiA);
        if (iA == 1) {
            favoritePoiInfo.f6005a = favSyncPoiA.f7944a;
            favoritePoiInfo.f6011g = Long.parseLong(favSyncPoiA.f7951h);
        }
        return iA;
    }

    public boolean clearAllFavPois() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6004b;
        if (aVar != null) {
            return aVar.a();
        }
        Log.e("baidumapsdk", "you may have not call init method!");
        return false;
    }

    public boolean deleteFavPoi(String str) {
        if (f6004b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        if (str == null || str.equals("")) {
            return false;
        }
        return f6004b.a(str);
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6004b;
        if (aVar != null) {
            aVar.b();
            f6004b = null;
            BMapManager.destroy();
            e.a();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6004b;
        if (aVar == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String strC = aVar.c();
        if (strC != null && !strC.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(strC);
                if (jSONObject.optInt("favpoinum") != 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("favcontents")) != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i4);
                        if (jSONObject2 != null) {
                            arrayList.add(a.a(jSONObject2));
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public FavoritePoiInfo getFavPoi(String str) {
        FavSyncPoi favSyncPoiB;
        if (f6004b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        if (str == null || str.equals("") || (favSyncPoiB = f6004b.b(str)) == null) {
            return null;
        }
        return a.a(favSyncPoiB);
    }

    public void init() {
        if (f6004b == null) {
            e.c();
            BMapManager.init();
            f6004b = com.baidu.mapsdkplatform.comapi.favrite.a.f();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        if (f6004b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        if (str != null && !str.equals("") && favoritePoiInfo != null) {
            if (favoritePoiInfo.f6007c == null) {
                Log.e("baidumapsdk", "object or pt can not be null!");
                return false;
            }
            String str2 = favoritePoiInfo.f6006b;
            if (str2 != null && !str2.equals("")) {
                favoritePoiInfo.f6005a = str;
                return f6004b.b(str, a.a(favoritePoiInfo));
            }
            Log.e("baidumapsdk", "poiName can not be null or empty!");
        }
        return false;
    }
}
