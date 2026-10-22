package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static k f8064a;

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private static Handler f8065b;

    /* renamed from: c, reason: collision with root package name */
    private AppBaseMap f8066c;

    /* renamed from: d, reason: collision with root package name */
    private o f8067d;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (k.f8064a != null) {
                k.this.f8067d.a(message);
            }
        }
    }

    private k() {
    }

    public static k f() {
        if (f8064a == null) {
            k kVar = new k();
            f8064a = kVar;
            kVar.g();
        }
        return f8064a;
    }

    private void g() {
        h();
        this.f8067d = new o();
        a aVar = new a();
        f8065b = aVar;
        MessageCenter.registMessage(65289, aVar);
    }

    private void h() {
        EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
        AppBaseMap appBaseMap = new AppBaseMap();
        this.f8066c = appBaseMap;
        appBaseMap.Create();
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        int ssgTmpStgMax = EnvironmentUtilities.getSsgTmpStgMax();
        String str = com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() >= 180 ? "/h/" : "/l/";
        String strP = AbstractC0351g.p(moduleFileName, "/cfg");
        String strP2 = AbstractC0351g.p(appSDCardPath, "/vmp");
        String strP3 = AbstractC0351g.p(strP, "/a/");
        String strP4 = AbstractC0351g.p(strP, "/a/");
        this.f8066c.Init(strP3, AbstractC0351g.p(strP, "/idrres/"), AbstractC0351g.p(strP2, str), AbstractC0351g.p(appCachePath, "/tmp/"), AbstractC0351g.p(appSecondCachePath, "/tmp/"), AbstractC0351g.p(strP2, str), strP4, com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, ssgTmpStgMax, false, false);
        this.f8066c.OnResume();
    }

    public void b() {
        MessageCenter.unregistMessage(65289, f8065b);
        this.f8066c.releaseFromOfflineMap();
        f8064a = null;
    }

    public boolean c(int i4) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null || i4 < 0) {
            return false;
        }
        return appBaseMap.OnRecordRemove(i4, false);
    }

    public boolean d(int i4) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null || i4 < 0) {
            return false;
        }
        if (i4 <= 2000 || i4 == 2912 || i4 == 2911 || i4 == 9000) {
            return appBaseMap.OnRecordStart(i4, false, 0);
        }
        return false;
    }

    public boolean e(int i4) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null || i4 < 0) {
            return false;
        }
        return appBaseMap.OnRecordSuspend(i4, false, 0);
    }

    public void a(n nVar) {
        o oVar = this.f8067d;
        if (oVar != null) {
            oVar.a(nVar);
        }
    }

    public ArrayList<j> c() {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null) {
            return null;
        }
        String strOnSchcityGet = appBaseMap.OnSchcityGet("");
        ArrayList<j> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(strOnSchcityGet).optJSONArray("dataset");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    j jVar = new j();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                    int iOptInt = jSONObjectOptJSONObject.optInt("id");
                    if (iOptInt <= 2000 || iOptInt == 2912 || iOptInt == 2911 || iOptInt == 9000) {
                        jVar.f8059a = iOptInt;
                        jVar.f8060b = jSONObjectOptJSONObject.optString("name");
                        jVar.f8061c = jSONObjectOptJSONObject.optInt("mapsize");
                        jVar.f8062d = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                        if (jSONObjectOptJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                                ArrayList<j> arrayList2 = new ArrayList<>();
                                for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                                    j jVar2 = new j();
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i5);
                                    jVar2.f8059a = jSONObjectOptJSONObject2.optInt("id");
                                    jVar2.f8060b = jSONObjectOptJSONObject2.optString("name");
                                    jVar2.f8061c = jSONObjectOptJSONObject2.optInt("mapsize");
                                    jVar2.f8062d = jSONObjectOptJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                    arrayList2.add(jVar2);
                                }
                                jVar.a(arrayList2);
                                arrayList.add(jVar);
                            }
                        } else {
                            arrayList.add(jVar);
                        }
                    }
                }
                return arrayList;
            }
        } catch (JSONException | Exception unused) {
        }
        return null;
    }

    public ArrayList<m> d() {
        String strOnRecordGetAll;
        JSONArray jSONArrayOptJSONArray;
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap != null && (strOnRecordGetAll = appBaseMap.OnRecordGetAll()) != null && !strOnRecordGetAll.equals("")) {
            ArrayList<m> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(strOnRecordGetAll);
                if (jSONObject.length() != 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset")) != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        m mVar = new m();
                        l lVar = new l();
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                        lVar.f8069a = jSONObjectOptJSONObject.optInt("id");
                        lVar.f8070b = jSONObjectOptJSONObject.optString("name");
                        lVar.f8071c = jSONObjectOptJSONObject.optString("pinyin");
                        lVar.f8076h = jSONObjectOptJSONObject.optInt("mapoldsize");
                        lVar.f8077i = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                        lVar.f8080l = jSONObjectOptJSONObject.optInt("status");
                        lVar.f8075g = new GeoPoint(jSONObjectOptJSONObject.optInt("y"), jSONObjectOptJSONObject.optInt("x"));
                        boolean z4 = true;
                        if (jSONObjectOptJSONObject.optInt("up") != 1) {
                            z4 = false;
                        }
                        lVar.f8078j = z4;
                        lVar.f8073e = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                        if (lVar.f8078j) {
                            lVar.f8079k = jSONObjectOptJSONObject.optInt("mapsize");
                        } else {
                            lVar.f8079k = 0;
                        }
                        mVar.a(lVar);
                        arrayList.add(mVar);
                    }
                    return arrayList;
                }
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<j> e() {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null) {
            return null;
        }
        String strOnHotcityGet = appBaseMap.OnHotcityGet();
        ArrayList<j> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(strOnHotcityGet).optJSONArray("dataset");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    j jVar = new j();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                    jVar.f8059a = jSONObjectOptJSONObject.optInt("id");
                    jVar.f8060b = jSONObjectOptJSONObject.optString("name");
                    jVar.f8061c = jSONObjectOptJSONObject.optInt("mapsize");
                    jVar.f8062d = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                    if (jSONObjectOptJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                            ArrayList<j> arrayList2 = new ArrayList<>();
                            for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                                j jVar2 = new j();
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i5);
                                jVar2.f8059a = jSONObjectOptJSONObject2.optInt("id");
                                jVar2.f8060b = jSONObjectOptJSONObject2.optString("name");
                                jVar2.f8061c = jSONObjectOptJSONObject2.optInt("mapsize");
                                jVar2.f8062d = jSONObjectOptJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                arrayList2.add(jVar2);
                            }
                            jVar.a(arrayList2);
                            arrayList.add(jVar);
                        }
                    } else {
                        arrayList.add(jVar);
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void b(n nVar) {
        o oVar = this.f8067d;
        if (oVar != null) {
            oVar.b(nVar);
        }
    }

    public boolean a(int i4) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null || i4 < 0) {
            return false;
        }
        if (i4 <= 2000 || i4 == 2912 || i4 == 2911 || i4 == 9000) {
            return appBaseMap.OnRecordAdd(i4);
        }
        return false;
    }

    public boolean f(int i4) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.OnRecordSuspend(0, true, i4);
    }

    public boolean g(int i4) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null || i4 < 0) {
            return false;
        }
        if (i4 <= 2000 || i4 == 2912 || i4 == 2911 || i4 == 9000) {
            return appBaseMap.OnRecordReload(i4, false);
        }
        return false;
    }

    public m b(int i4) {
        String strOnRecordGetAt;
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap != null && i4 >= 0 && (strOnRecordGetAt = appBaseMap.OnRecordGetAt(i4)) != null && !strOnRecordGetAt.equals("")) {
            m mVar = new m();
            l lVar = new l();
            try {
                JSONObject jSONObject = new JSONObject(strOnRecordGetAt);
                if (jSONObject.length() == 0) {
                    return null;
                }
                int iOptInt = jSONObject.optInt("id");
                if (iOptInt > 2000 && iOptInt != 2912 && iOptInt != 2911 && iOptInt != 9000) {
                    return null;
                }
                lVar.f8069a = iOptInt;
                lVar.f8070b = jSONObject.optString("name");
                lVar.f8071c = jSONObject.optString("pinyin");
                lVar.f8072d = jSONObject.optString("headchar");
                lVar.f8076h = jSONObject.optInt("mapoldsize");
                lVar.f8077i = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                lVar.f8080l = jSONObject.optInt("status");
                lVar.f8075g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                boolean z4 = true;
                if (jSONObject.optInt("up") != 1) {
                    z4 = false;
                }
                lVar.f8078j = z4;
                lVar.f8073e = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                if (lVar.f8078j) {
                    lVar.f8079k = jSONObject.optInt("mapsize");
                } else {
                    lVar.f8079k = 0;
                }
                lVar.f8074f = jSONObject.optInt("ver");
                mVar.a(lVar);
                return mVar;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public boolean a(boolean z4, boolean z5) {
        AppBaseMap appBaseMap = this.f8066c;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.OnRecordImport(z4, z5);
    }

    public ArrayList<j> a(String str) throws JSONException {
        AppBaseMap appBaseMap;
        String strOnSchcityGet;
        JSONArray jSONArrayOptJSONArray;
        if (!str.equals("") && (appBaseMap = this.f8066c) != null && (strOnSchcityGet = appBaseMap.OnSchcityGet(str)) != null && !strOnSchcityGet.equals("")) {
            ArrayList<j> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(strOnSchcityGet);
                if (jSONObject.length() != 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset")) != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        j jVar = new j();
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i4);
                        int iOptInt = jSONObject2.optInt("id");
                        if (iOptInt <= 2000 || iOptInt == 2912 || iOptInt == 2911 || iOptInt == 9000) {
                            jVar.f8059a = iOptInt;
                            jVar.f8060b = jSONObject2.optString("name");
                            jVar.f8061c = jSONObject2.optInt("mapsize");
                            jVar.f8062d = jSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            if (jSONObject2.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                                    ArrayList<j> arrayList2 = new ArrayList<>();
                                    for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                                        j jVar2 = new j();
                                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i5);
                                        jVar2.f8059a = jSONObjectOptJSONObject.optInt("id");
                                        jVar2.f8060b = jSONObjectOptJSONObject.optString("name");
                                        jVar2.f8061c = jSONObjectOptJSONObject.optInt("mapsize");
                                        jVar2.f8062d = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                        arrayList2.add(jVar2);
                                    }
                                    jVar.a(arrayList2);
                                    arrayList.add(jVar);
                                }
                            } else {
                                arrayList.add(jVar);
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }
}
