package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f32165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f32166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppBaseMap f32167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o f32168d;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f32169a;

        public a(k r100) {
            this.f32169a = r100;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (k.a() == null) goto L6;
            k.a(this.f32169a).a(r100);
            return;
        }
    }

    public static k f() {
        if (f32165a != null) goto L6;
        k r100 = new k();
        f32165a = r100;
        r100.g();
    L6:
        return f32165a;
    }

    private void h() {
        EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
        AppBaseMap r100 = new AppBaseMap();
        this.f32167c = r100;
        r100.Create();
        String r101 = SysOSUtil.getModuleFileName();
        String r102 = EnvironmentUtilities.getAppSDCardPath();
        String r103 = EnvironmentUtilities.getAppCachePath();
        String r104 = EnvironmentUtilities.getAppSecondCachePath();
        int r110 = EnvironmentUtilities.getMapTmpStgMax();
        int r111 = EnvironmentUtilities.getDomTmpStgMax();
        int r112 = EnvironmentUtilities.getItsTmpStgMax();
        int r113 = EnvironmentUtilities.getSsgTmpStgMax();
        if (com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() < 180) goto L5;
        String r105 = "/h/";
    L6:
        String r106 = r101 + "/cfg";
        String r107 = r102 + "/vmp";
        String r108 = r106 + "/idrres/";
        String r109 = r107 + r105;
        String r114 = r107 + r105;
        String r115 = r103 + "/tmp/";
        String r116 = r104 + "/tmp/";
        this.f32167c.Init(r106 + "/a/", r108, r109, r115, r116, r114, r106 + "/a/", com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), r110, r111, r112, r113, false, false);
        this.f32167c.OnResume();
        return;
    L5:
        r105 = "/l/";
        goto L6
    }

    public void b() {
        MessageCenter.unregistMessage(65289, f32166b);
        this.f32167c.releaseFromOfflineMap();
        f32165a = null;
    }

    public ArrayList<j> c() {
        AppBaseMap r100 = this.f32167c;
        ArrayList<j> r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = r100.OnSchcityGet("");
        ArrayList<j> r103 = new ArrayList();
        JSONArray r104 = new JSONObject(r102).optJSONArray("dataset");     // Catch: Exception -> L43 JSONException -> L45
        if (r104 == null) goto L42;
        if (r104.length() == 0) goto L42;
        int r110 = 0;
    L13:
        if (r110 >= r104.length()) goto L40;
        j r111 = new j();     // Catch: Exception -> L43 JSONException -> L45
        JSONObject r112 = r104.optJSONObject(r110);     // Catch: Exception -> L43 JSONException -> L45
        int r113 = r112.optInt("id");     // Catch: Exception -> L43 JSONException -> L45
        if (r113 > 9999) goto L17;
    L23:
        r111.f32160a = r113;     // Catch: Exception -> L43 JSONException -> L45
        r111.f32161b = r112.optString("name");     // Catch: Exception -> L43 JSONException -> L45
        r111.f32162c = r112.optInt("mapsize");     // Catch: Exception -> L43 JSONException -> L45
        r111.f32163d = r112.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: Exception -> L43 JSONException -> L45
        if (r112.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD) == false) goto L36;
        JSONArray r114 = r112.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);     // Catch: Exception -> L43 JSONException -> L45
        if (r114 == null) goto L37;
        if (r114.length() == 0) goto L37;
        ArrayList<j> r115 = new ArrayList();     // Catch: Exception -> L43 JSONException -> L45
        int r116 = 0;
    L32:
        if (r116 >= r114.length()) goto L35;
        j r117 = new j();     // Catch: Exception -> L43 JSONException -> L45
        JSONObject r105 = r114.optJSONObject(r116);     // Catch: Exception -> L43 JSONException -> L45
        r117.f32160a = r105.optInt("id");     // Catch: Exception -> L38 JSONException -> L39
        r117.f32161b = r105.optString("name");     // Catch: Exception -> L38 JSONException -> L39
        r117.f32162c = r105.optInt("mapsize");     // Catch: Exception -> L38 JSONException -> L39
        r117.f32163d = r105.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: Exception -> L38 JSONException -> L39
        r115.add(r117);     // Catch: Exception -> L38 JSONException -> L39
        r116 = r116 + 1;     // Catch: Exception -> L38 JSONException -> L39
        r101 = null;
    L39:
        return null;
    L38:
        return null;
    L35:
        r111.a(r115);     // Catch: Exception -> L38 JSONException -> L39
    L37:
        r110 = r110 + 1;
        r101 = null;
    L36:
        r103.add(r111);     // Catch: Exception -> L38 JSONException -> L39
        goto L37
    L17:
        if (r113 == 2912) goto L23;
        if (r113 == 2911) goto L23;
        if (r113 == 9000) goto L23;
    L40:
        return r103;
    L42:
        return null;
    L46:
        return r101;
    L44:
        return r101;
    }

    public ArrayList<m> d() {
        AppBaseMap r100 = this.f32167c;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.OnRecordGetAll();
        if (r101 != null) goto L8;
    L36:
        return null;
    L8:
        if (r101.equals("") == true) goto L36;
        ArrayList<m> r102 = new ArrayList();
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L34
        if (r103.length() != 0) goto L14;
        return null;
    L14:
        JSONArray r104 = r103.optJSONArray("dataset");     // Catch: Exception -> L34
        if (r104 != null) goto L17;
    L33:
        return null;
    L17:
        if (r104.length() == 0) goto L33;
        int r105 = 0;
    L20:
        if (r105 >= r104.length()) goto L32;
        m r106 = new m();     // Catch: Exception -> L34
        l r107 = new l();     // Catch: Exception -> L34
        JSONObject r108 = r104.optJSONObject(r105);     // Catch: Exception -> L34
        r107.f32170a = r108.optInt("id");     // Catch: Exception -> L34
        r107.f32171b = r108.optString("name");     // Catch: Exception -> L34
        r107.f32172c = r108.optString("pinyin");     // Catch: Exception -> L34
        r107.f32177h = r108.optInt("mapoldsize");     // Catch: Exception -> L34
        r107.f32178i = r108.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);     // Catch: Exception -> L34
        r107.f32181l = r108.optInt("status");     // Catch: Exception -> L34
        r107.f32176g = new GeoPoint(r108.optInt("y"), r108.optInt("x"));     // Catch: Exception -> L34
        boolean r109 = true;
        if (r108.optInt("up") == 1) goto L26;
        r109 = false;
    L26:
        r107.f32179j = r109;     // Catch: Exception -> L34
        r107.f32174e = r108.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);     // Catch: Exception -> L34
        if (r107.f32179j == false) goto L29;
        r107.f32180k = r108.optInt("mapsize");     // Catch: Exception -> L34
    L30:
        r106.a(r107);     // Catch: Exception -> L34
        r102.add(r106);     // Catch: Exception -> L34
        r105 = r105 + 1;
        goto L20
    L29:
        r107.f32180k = 0;     // Catch: Exception -> L34
        goto L30
    L32:
        return r102;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }

    public ArrayList<j> e() {
        AppBaseMap r100 = this.f32167c;
        ArrayList<j> r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = r100.OnHotcityGet();
        ArrayList<j> r103 = new ArrayList();
        JSONArray r104 = new JSONObject(r102).optJSONArray("dataset");     // Catch: JSONException -> L34
        if (r104 == null) goto L33;
        if (r104.length() == 0) goto L33;
        int r110 = 0;
    L13:
        if (r110 >= r104.length()) goto L31;
        j r111 = new j();     // Catch: JSONException -> L34
        JSONObject r112 = r104.optJSONObject(r110);     // Catch: JSONException -> L34
        r111.f32160a = r112.optInt("id");     // Catch: JSONException -> L34
        r111.f32161b = r112.optString("name");     // Catch: JSONException -> L34
        r111.f32162c = r112.optInt("mapsize");     // Catch: JSONException -> L34
        r111.f32163d = r112.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: JSONException -> L34
        if (r112.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD) == false) goto L27;
        JSONArray r113 = r112.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);     // Catch: JSONException -> L34
        if (r113 == null) goto L28;
        if (r113.length() == 0) goto L28;
        ArrayList<j> r114 = new ArrayList();     // Catch: JSONException -> L34
        int r115 = 0;
    L23:
        if (r115 >= r113.length()) goto L26;
        j r116 = new j();     // Catch: JSONException -> L34
        JSONObject r105 = r113.optJSONObject(r115);     // Catch: JSONException -> L34
        r116.f32160a = r105.optInt("id");     // Catch: JSONException -> L29
        r116.f32161b = r105.optString("name");     // Catch: JSONException -> L29
        r116.f32162c = r105.optInt("mapsize");     // Catch: JSONException -> L29
        r116.f32163d = r105.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: JSONException -> L29
        r114.add(r116);     // Catch: JSONException -> L29
        r115 = r115 + 1;     // Catch: JSONException -> L29
        r101 = null;
    L29:
        e = e;
        ArrayList<j> r106 = null;
    L36:
        e.printStackTrace();
        return r106;
    L26:
        r111.a(r114);     // Catch: JSONException -> L29
    L28:
        r110 = r110 + 1;
        r101 = null;
    L27:
        r103.add(r111);     // Catch: JSONException -> L29
        goto L28
    L31:
        return r103;
    L33:
        return null;
    L34:
        e = e;
        r106 = r101;
        goto L36
    }

    private void g() {
        h();
        this.f32168d = new o();
        a r100 = new a(this);
        f32166b = r100;
        MessageCenter.registMessage(65289, r100);
    }

    private k() {
    }

    public static /* synthetic */ k a() {
        return f32165a;
    }

    public ArrayList<j> a(String r110) {
        if (r110.equals("") == true) goto L57;
        AppBaseMap r100 = this.f32167c;
        if (r100 == null) goto L57;
        String r101 = r100.OnSchcityGet(r110);
        if (r101 == null) goto L54;
        if (r101.equals("") == true) goto L54;
        ArrayList<j> r102 = new ArrayList();
        JSONObject r103 = new JSONObject(r101);     // Catch: JSONException -> L50
        if (r103.length() != 0) goto L16;
        return null;
    L16:
        JSONArray r104 = r103.optJSONArray("dataset");     // Catch: JSONException -> L50
        if (r104 == null) goto L49;
        if (r104.length() == 0) goto L49;
        int r111 = 0;
    L22:
        if (r111 >= r104.length()) goto L47;
        j r112 = new j();     // Catch: JSONException -> L50
        JSONObject r113 = JSONArrayProtectorUtils.getJSONObject(r104, r111);     // Catch: JSONException -> L50
        int r114 = r113.optInt("id");     // Catch: JSONException -> L50
        if (r114 > 9999) goto L27;
    L33:
        r112.f32160a = r114;     // Catch: JSONException -> L50
        r112.f32161b = r113.optString("name");     // Catch: JSONException -> L50
        r112.f32162c = r113.optInt("mapsize");     // Catch: JSONException -> L50
        r112.f32163d = r113.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: JSONException -> L50
        if (r113.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD) == false) goto L45;
        JSONArray r115 = r113.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);     // Catch: JSONException -> L50
        if (r115 == null) goto L46;
        if (r115.length() == 0) goto L46;
        ArrayList<j> r116 = new ArrayList();     // Catch: JSONException -> L50
        int r117 = 0;
    L42:
        if (r117 >= r115.length()) goto L44;
        j r118 = new j();     // Catch: JSONException -> L50
        JSONObject r105 = r115.optJSONObject(r117);     // Catch: JSONException -> L50
        r118.f32160a = r105.optInt("id");     // Catch: JSONException -> L50
        r118.f32161b = r105.optString("name");     // Catch: JSONException -> L50
        r118.f32162c = r105.optInt("mapsize");     // Catch: JSONException -> L50
        r118.f32163d = r105.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: JSONException -> L50
        r116.add(r118);     // Catch: JSONException -> L50
        r117 = r117 + 1;     // Catch: JSONException -> L50
        goto L42
    L44:
        r112.a(r116);     // Catch: JSONException -> L50
    L46:
        r111 = r111 + 1;
    L45:
        r102.add(r112);     // Catch: JSONException -> L50
        goto L46
    L27:
        if (r114 == 2912) goto L33;
        if (r114 == 2911) goto L33;
        if (r114 == 9000) goto L33;
    L47:
        return r102;
    L49:
        return null;
    L50:
        e = move-exception;
        e.printStackTrace();
        return null;
    L54:
        return null;
    L57:
        return null;
    }

    public m b(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 == null) goto L36;
        if (r100 < 0) goto L36;
        String r102 = r101.OnRecordGetAt(r100);
        if (r102 == null) goto L36;
        if (r102.equals("") == true) goto L36;
        m r103 = new m();
        l r104 = new l();
        JSONObject r105 = new JSONObject(r102);     // Catch: JSONException -> L34
        if (r105.length() != 0) goto L15;
        return null;
    L15:
        int r106 = r105.optInt("id");     // Catch: JSONException -> L34
        if (r106 > 9999) goto L18;
    L24:
        r104.f32170a = r106;     // Catch: JSONException -> L34
        r104.f32171b = r105.optString("name");     // Catch: JSONException -> L34
        r104.f32172c = r105.optString("pinyin");     // Catch: JSONException -> L34
        r104.f32173d = r105.optString("headchar");     // Catch: JSONException -> L34
        r104.f32177h = r105.optInt("mapoldsize");     // Catch: JSONException -> L34
        r104.f32178i = r105.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);     // Catch: JSONException -> L34
        r104.f32181l = r105.optInt("status");     // Catch: JSONException -> L34
        r104.f32176g = new GeoPoint(r105.optInt("y"), r105.optInt("x"));     // Catch: JSONException -> L34
        boolean r107 = true;
        if (r105.optInt("up") == 1) goto L28;
        r107 = false;
    L28:
        r104.f32179j = r107;     // Catch: JSONException -> L34
        r104.f32174e = r105.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);     // Catch: JSONException -> L34
        if (r104.f32179j == false) goto L31;
        r104.f32180k = r105.optInt("mapsize");     // Catch: JSONException -> L34
    L32:
        r104.f32175f = r105.optInt("ver");     // Catch: JSONException -> L34
        r103.a(r104);     // Catch: JSONException -> L34
        return r103;
    L31:
        r104.f32180k = 0;     // Catch: JSONException -> L34
        goto L32
    L18:
        if (r106 == 2912) goto L24;
        if (r106 == 2911) goto L24;
        if (r106 == 9000) goto L24;
        return null;
    L34:
        e = move-exception;
        e.printStackTrace();
    L36:
        return null;
    }

    public boolean c(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 == null) goto L8;
        if (r100 < 0) goto L8;
        return r101.OnRecordRemove(r100, false);
    L8:
        return false;
    }

    public boolean d(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 == null) goto L17;
        if (r100 < 0) goto L17;
        if (r100 <= 9999) goto L16;
        if (r100 == 2912) goto L16;
        if (r100 == 2911) goto L16;
        if (r100 == 9000) goto L16;
        return false;
    L16:
        return r101.OnRecordStart(r100, false, 0);
    L17:
        return false;
    }

    public boolean e(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 == null) goto L8;
        if (r100 < 0) goto L8;
        return r101.OnRecordSuspend(r100, false, 0);
    L8:
        return false;
    }

    public boolean f(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.OnRecordSuspend(0, true, r100);
    }

    public boolean g(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 == null) goto L17;
        if (r100 < 0) goto L17;
        if (r100 <= 9999) goto L16;
        if (r100 == 2912) goto L16;
        if (r100 == 2911) goto L16;
        if (r100 == 9000) goto L16;
        return false;
    L16:
        return r101.OnRecordReload(r100, false);
    L17:
        return false;
    }

    public boolean a(int r100) {
        AppBaseMap r101 = this.f32167c;
        if (r101 == null) goto L17;
        if (r100 < 0) goto L17;
        if (r100 <= 9999) goto L16;
        if (r100 == 2912) goto L16;
        if (r100 == 2911) goto L16;
        if (r100 == 9000) goto L16;
        return false;
    L16:
        return r101.OnRecordAdd(r100);
    L17:
        return false;
    }

    public void b(n r100) {
        o r101 = this.f32168d;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void a(n r100) {
        o r101 = this.f32168d;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public static /* synthetic */ o a(k r100) {
        return r100.f32168d;
    }

    public boolean a(boolean r100, boolean r101) {
        AppBaseMap r102 = this.f32167c;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.OnRecordImport(r100, r101);
    }
}
