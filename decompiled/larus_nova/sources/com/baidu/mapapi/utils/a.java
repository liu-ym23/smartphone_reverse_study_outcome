package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.navi.TruckNaviOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.verify.SignUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.space.sync.PushRoute$EType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    private static double A = 0.0d;
    private static double B = 0.0d;
    private static double C = 0.0d;
    private static double D = 0.0d;
    private static double E = 0.0d;
    private static int F = 0;
    private static boolean G = false;
    private static String H = null;
    private static int I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f31704J = 0;
    private static int K = 0;
    private static int L = 0;
    private static int M = 0;
    static ServiceConnection N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31705a = "com.baidu.mapapi.utils.a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.baidu.mapframework.open.aidl.a f31706b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static IComOpenClient f31707c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f31708d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f31709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f31710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f31711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f31712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List<DispathcPoiData> f31713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static LatLng f31714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static LatLng f31715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f31716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f31717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f31718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f31719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f31720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f31721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static RouteParaOption.EBusStrategyType f31722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f31723s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f31724t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static LatLng f31725u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f31726v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static boolean f31727w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static boolean f31728x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static Thread f31729y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f31730z;

    /* JADX INFO: renamed from: com.baidu.mapapi.utils.a$a, reason: collision with other inner class name */
    public static class BinderC0631a extends com.baidu.mapframework.open.aidl.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f31731a;

        public BinderC0631a(int r100) {
            this.f31731a = r100;
        }

        @Override // com.baidu.mapframework.open.aidl.b
        public void a(IBinder r100) throws RemoteException {
            a.a();
            if (a.b() == null) goto L5;
            a.a(null);
        L5:
            a.a(IComOpenClient.a.b(r100));
            a.a(this.f31731a);
            a.a(true);
        }
    }

    public static class b implements ServiceConnection {

        /* JADX INFO: renamed from: com.baidu.mapapi.utils.a$b$a, reason: collision with other inner class name */
        public class BinderC0632a extends com.baidu.mapframework.open.aidl.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f31732a;

            public BinderC0632a(b r100) {
                this.f31732a = r100;
            }

            @Override // com.baidu.mapframework.open.aidl.b
            public void a(IBinder r100) throws RemoteException {
                a.a();
                if (a.b() == null) goto L5;
                a.a(null);
            L5:
                a.a(IComOpenClient.a.b(r100));
                if (a.c() == true) goto L8;
                a.a(a.f31708d);
            L8:
                a.a(true);
            }
        }

        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            a.a();
            Objects.toString(r100);
            if (a.e() == null) goto L6;
            a.a(null);
            a.b(false);
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            if (a.d() == null) goto L5;
            a.d().interrupt();
        L5:
            a.a();
            Objects.toString(r100);
        L11:
            a.a();
            if (a.e() == null) goto L17;
            a.a(null);
            return;
        L17:
            return;
        L7:
            if (a.e() == null) goto L9;
            a.a(null);     // Catch: RemoteException -> L11
        L9:
            a.a(com.baidu.mapframework.open.aidl.a.AbstractBinderC0637a.b(r101));     // Catch: RemoteException -> L11
            a.e().a(new BinderC0632a(this));     // Catch: RemoteException -> L11
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f31733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f31734b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapapi_utils_a$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapapi_utils_a$c__run$___twin___() {
            long r100 = System.currentTimeMillis();
        L4:
            if ((System.currentTimeMillis() - r100) <= 3000) goto L7;
            a.j(this.f31733a);
            a.a(this.f31734b, this.f31733a);
        L7:
            if (a.d().isInterrupted() == false) goto L4;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapapi_utils_a$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_baidu_mapapi_utils_a$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(Context r100, int r101) {
            this.f31733a = r100;
            this.f31734b = r101;
        }
    }

    static {
        f31713i = new ArrayList();
        f31714j = null;
        f31715k = null;
        f31716l = null;
        f31717m = null;
        f31718n = null;
        f31719o = null;
        f31720p = null;
        f31723s = null;
        f31724t = null;
        f31725u = null;
        f31726v = 0;
        f31727w = false;
        f31728x = false;
        N = new b();
    }

    private static boolean f() {
        List<DispathcPoiData> r100 = f31713i;
        if (r100 != null) goto L5;
    L47:
        return false;
    L5:
        if (r100.size() <= 0) goto L47;
        String r101 = f31707c.a("map.android.baidu.mainmap");     // Catch: RemoteException -> L48
        if (r101 == null) goto L47;
        Bundle r102 = new Bundle();     // Catch: RemoteException -> L48
        r102.putString(PickerReporterConstants.KEY.TARGET, "favorite_page");     // Catch: RemoteException -> L48
        Bundle r103 = new Bundle();     // Catch: RemoteException -> L48
        JSONArray r104 = new JSONArray();     // Catch: RemoteException -> L48
        int r105 = 0;
        int r106 = 0;
    L11:
        if (r105 >= f31713i.size()) goto L34;
        if (((DispathcPoiData) ListProtector.get(f31713i, r105)).name == null) goto L33;
        if (((DispathcPoiData) ListProtector.get(f31713i, r105)).name.equals("") == true) goto L33;
        if (((DispathcPoiData) ListProtector.get(f31713i, r105)).f31739pt == null) goto L33;
        JSONObject r107 = new JSONObject();     // Catch: RemoteException -> L48
        r107.put("name", ((DispathcPoiData) ListProtector.get(f31713i, r105)).name);     // Catch: JSONException -> L31 RemoteException -> L48
        GeoPoint r108 = CoordUtil.ll2mc(((DispathcPoiData) ListProtector.get(f31713i, r105)).f31739pt);     // Catch: JSONException -> L31 RemoteException -> L48
        r107.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, r108.getLongitudeE6());     // Catch: JSONException -> L31 RemoteException -> L48
        r107.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, r108.getLatitudeE6());     // Catch: JSONException -> L31 RemoteException -> L48
        r107.put("addr", ((DispathcPoiData) ListProtector.get(f31713i, r105)).addr);     // Catch: JSONException -> L31 RemoteException -> L48
        r107.put("uid", ((DispathcPoiData) ListProtector.get(f31713i, r105)).uid);     // Catch: JSONException -> L31 RemoteException -> L48
        r106 = r106 + 1;     // Catch: JSONException -> L31 RemoteException -> L48
        r104.put(r107);     // Catch: JSONException -> L31 RemoteException -> L48
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: RemoteException -> L48
    L33:
        r105 = r105 + 1;
        goto L11
    L34:
        if (r106 != 0) goto L37;
        return false;
    L37:
        r103.putString("data", r104.toString());     // Catch: RemoteException -> L48
        r103.putString("from", f31711g);     // Catch: RemoteException -> L48
        r103.putString("pkg", f31710f);     // Catch: RemoteException -> L48
        r103.putString("cls", f31712h);     // Catch: RemoteException -> L48
        r103.putInt("count", r106);     // Catch: RemoteException -> L48
        r102.putBundle("base_params", r103);     // Catch: RemoteException -> L48
        Bundle r109 = new Bundle();     // Catch: RemoteException -> L48
        r109.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: RemoteException -> L48
        r102.putBundle("ext_params", r109);     // Catch: RemoteException -> L48
        return f31707c.a("map.android.baidu.mainmap", r101, r102);
    }

    private static boolean g() {
        String r100 = f31707c.a("map.android.baidu.mainmap");     // Catch: RemoteException -> L16
        if (r100 == null) goto L14;
        Bundle r101 = new Bundle();     // Catch: RemoteException -> L16
        r101.putString(PickerReporterConstants.KEY.TARGET, "request_poi_detail_page");     // Catch: RemoteException -> L16
        Bundle r102 = new Bundle();     // Catch: RemoteException -> L16
        String r103 = f31723s;     // Catch: RemoteException -> L16
        if (r103 == null) goto L9;
        r102.putString("uid", r103);     // Catch: RemoteException -> L16
    L10:
        r101.putBundle("base_params", r102);     // Catch: RemoteException -> L16
        Bundle r104 = new Bundle();     // Catch: RemoteException -> L16
        r104.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: RemoteException -> L16
        r101.putBundle("ext_params", r104);     // Catch: RemoteException -> L16
        return f31707c.a("map.android.baidu.mainmap", r100, r101);
    L9:
        r102.putString("uid", "");     // Catch: RemoteException -> L16
        goto L10
    L14:
        return false;
    L19:
        return false;
    }

    private static boolean h() {
        String r100 = f31707c.a("map.android.baidu.mainmap");     // Catch: RemoteException -> L28
        if (r100 == null) goto L26;
        Bundle r101 = new Bundle();     // Catch: RemoteException -> L28
        r101.putString(PickerReporterConstants.KEY.TARGET, "poi_search_page");     // Catch: RemoteException -> L28
        Bundle r102 = new Bundle();     // Catch: RemoteException -> L28
        String r103 = f31724t;     // Catch: RemoteException -> L28
        if (r103 == null) goto L9;
        r102.putString(Keys.API_PARAM_KEY_SEARCH_KEY, r103);     // Catch: RemoteException -> L28
    L10:
        LatLng r104 = f31725u;     // Catch: RemoteException -> L28
        if (r104 != null) goto L13;
        r102.putString(Keys.API_PARAM_KEY_SEARCH_KEY, "");     // Catch: RemoteException -> L28
    L17:
        int r105 = f31726v;     // Catch: RemoteException -> L28
        if (r105 == 0) goto L21;
        r102.putInt("search_radius", r105);     // Catch: RemoteException -> L28
    L22:
        r102.putBoolean("is_direct_search", true);     // Catch: RemoteException -> L28
        r102.putBoolean("is_direct_area_search", true);     // Catch: RemoteException -> L28
        r101.putBundle("base_params", r102);     // Catch: RemoteException -> L28
        Bundle r106 = new Bundle();     // Catch: RemoteException -> L28
        r106.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: RemoteException -> L28
        r101.putBundle("ext_params", r106);     // Catch: RemoteException -> L28
        return f31707c.a("map.android.baidu.mainmap", r100, r101);
    L21:
        r102.putInt("search_radius", 1000);     // Catch: RemoteException -> L28
        goto L22
    L13:
        r102.putInt("center_pt_x", (int) CoordUtil.ll2mc(r104).getLongitudeE6());     // Catch: RemoteException -> L28
        r102.putInt("center_pt_y", (int) CoordUtil.ll2mc(f31725u).getLatitudeE6());     // Catch: RemoteException -> L28
        goto L17
    L9:
        r102.putString(Keys.API_PARAM_KEY_SEARCH_KEY, "");     // Catch: RemoteException -> L28
        goto L10
    L26:
        return false;
    L31:
        return false;
    }

    private static boolean i() {
        String r100 = f31707c.a("map.android.baidu.mainmap");     // Catch: RemoteException -> L38
        if (r100 == null) goto L37;
        Bundle r101 = new Bundle();     // Catch: RemoteException -> L38
        r101.putString(PickerReporterConstants.KEY.TARGET, "route_search_page");     // Catch: RemoteException -> L38
        Bundle r102 = new Bundle();     // Catch: RemoteException -> L38
        if (f31709e != 102) goto L9;
        f31709e = 7;     // Catch: RemoteException -> L38
    L9:
        r102.putInt(PushRoute$EType.KEY_NAME, f31709e);     // Catch: RemoteException -> L38
        r102.putInt("bus_strategy", f31722r.ordinal());     // Catch: RemoteException -> L38
        r102.putInt("cross_city_bus_strategy", 5);     // Catch: RemoteException -> L38
        if (f31714j == null) goto L15;
        r102.putInt("start_type", 1);     // Catch: RemoteException -> L38
        r102.putInt("start_longitude", (int) CoordUtil.ll2mc(f31714j).getLongitudeE6());     // Catch: RemoteException -> L38
        r102.putInt("start_latitude", (int) CoordUtil.ll2mc(f31714j).getLatitudeE6());     // Catch: RemoteException -> L38
    L16:
        String r103 = f31718n;     // Catch: RemoteException -> L38
        if (r103 == null) goto L20;
        r102.putString("start_keyword", r103);     // Catch: RemoteException -> L38
    L22:
        r102.putString("start_uid", f31716l);     // Catch: RemoteException -> L38
        if (f31715k == null) goto L26;
        r102.putInt("end_type", 1);     // Catch: RemoteException -> L38
        r102.putInt("end_longitude", (int) CoordUtil.ll2mc(f31715k).getLongitudeE6());     // Catch: RemoteException -> L38
        r102.putInt("end_latitude", (int) CoordUtil.ll2mc(f31715k).getLatitudeE6());     // Catch: RemoteException -> L38
    L27:
        String r104 = f31719o;     // Catch: RemoteException -> L38
        if (r104 == null) goto L31;
        r102.putString("end_keyword", r104);     // Catch: RemoteException -> L38
    L33:
        r102.putString("end_uid", f31717m);     // Catch: RemoteException -> L38
        r101.putBundle("base_params", r102);     // Catch: RemoteException -> L38
        Bundle r105 = new Bundle();     // Catch: RemoteException -> L38
        r105.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: RemoteException -> L38
        r101.putBundle("ext_params", r105);     // Catch: RemoteException -> L38
        return f31707c.a("map.android.baidu.mainmap", r100, r101);
    L31:
        r102.putString("end_keyword", "地图上的点");     // Catch: RemoteException -> L38
        goto L33
    L26:
        r102.putInt("end_type", 2);     // Catch: RemoteException -> L38
        r102.putInt("end_longitude", 0);     // Catch: RemoteException -> L38
        r102.putInt("end_latitude", 0);     // Catch: RemoteException -> L38
        goto L27
    L20:
        r102.putString("start_keyword", "地图上的点");     // Catch: RemoteException -> L38
        goto L22
    L15:
        r102.putInt("start_type", 2);     // Catch: RemoteException -> L38
        r102.putInt("start_longitude", 0);     // Catch: RemoteException -> L38
        r102.putInt("start_latitude", 0);     // Catch: RemoteException -> L38
    L37:
        return false;
    }

    private static boolean j() {
        String r100 = f31707c.a("map.android.baidu.mainmap");     // Catch: RemoteException -> L40
        if (r100 == null) goto L39;
        Bundle r101 = new Bundle();     // Catch: RemoteException -> L40
        r101.putString(PickerReporterConstants.KEY.TARGET, "navigation_page");     // Catch: RemoteException -> L40
        Bundle r102 = new Bundle();     // Catch: RemoteException -> L40
        r102.putString("coord_type", CoordinateType.BD09LL);     // Catch: RemoteException -> L40
        StringBuffer r103 = new StringBuffer();     // Catch: RemoteException -> L40
        if (f31718n == null) goto L9;
        r103.append("name:" + f31718n + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: RemoteException -> L40
    L9:
        CoordType r110 = SDKInitializer.getCoordType();     // Catch: RemoteException -> L40
        CoordType r111 = CoordType.GCJ02;     // Catch: RemoteException -> L40
        if (r110 != r111) goto L12;
        f31714j = CoordTrans.gcjToBaidu(f31714j);     // Catch: RemoteException -> L40
    L12:
        r103.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(f31714j.latitude), Double.valueOf(f31714j.longitude)}));     // Catch: RemoteException -> L40
        if (TextUtils.isEmpty(f31716l) == true) goto L15;
        r103.append("|origin_uid:");     // Catch: RemoteException -> L40
        r103.append(f31716l);     // Catch: RemoteException -> L40
    L15:
        StringBuffer r104 = new StringBuffer();     // Catch: RemoteException -> L40
        if (f31719o == null) goto L19;
        r104.append("name:" + f31719o + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: RemoteException -> L40
    L19:
        if (SDKInitializer.getCoordType() != r111) goto L21;
        f31715k = CoordTrans.gcjToBaidu(f31715k);     // Catch: RemoteException -> L40
    L21:
        r104.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(f31715k.latitude), Double.valueOf(f31715k.longitude)}));     // Catch: RemoteException -> L40
        if (TextUtils.isEmpty(f31717m) == true) goto L25;
        r104.append("|destination_uid:");     // Catch: RemoteException -> L40
        r104.append(f31717m);     // Catch: RemoteException -> L40
    L25:
        r102.putString(PlayerResolution.SDKKEY.ORIGIN, r103.toString());     // Catch: RemoteException -> L40
        r102.putString(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, r104.toString());     // Catch: RemoteException -> L40
        if (TextUtils.isEmpty(f31720p) == true) goto L32;
        r102.putString("viaPoints", f31720p);     // Catch: RemoteException -> L40
    L32:
        if (TextUtils.isEmpty(f31721q) == false) goto L34;
    L35:
        r101.putBundle("base_params", r102);     // Catch: RemoteException -> L40
        Bundle r105 = new Bundle();     // Catch: RemoteException -> L40
        r105.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: RemoteException -> L40
        r101.putBundle("ext_params", r105);     // Catch: RemoteException -> L40
        return f31707c.a("map.android.baidu.mainmap", r100, r101);
    L34:
        r102.putString("type", f31721q);     // Catch: RemoteException -> L40
    L39:
        return false;
    }

    private static boolean k() {
        String r100 = f31707c.a("map.android.baidu.mainmap");     // Catch: RemoteException -> L32
        if (r100 == null) goto L31;
        Bundle r101 = new Bundle();     // Catch: RemoteException -> L32
        r101.putString(PickerReporterConstants.KEY.TARGET, "bikenavi_page");     // Catch: RemoteException -> L32
        Bundle r102 = new Bundle();     // Catch: RemoteException -> L32
        r102.putString("coord_type", CoordinateType.BD09LL);     // Catch: RemoteException -> L32
        StringBuffer r103 = new StringBuffer();     // Catch: RemoteException -> L32
        if (f31718n == null) goto L9;
        r103.append("name:" + f31718n + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: RemoteException -> L32
    L9:
        CoordType r110 = SDKInitializer.getCoordType();     // Catch: RemoteException -> L32
        CoordType r111 = CoordType.GCJ02;     // Catch: RemoteException -> L32
        if (r110 != r111) goto L12;
        f31714j = CoordTrans.gcjToBaidu(f31714j);     // Catch: RemoteException -> L32
    L12:
        r103.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(f31714j.latitude), Double.valueOf(f31714j.longitude)}));     // Catch: RemoteException -> L32
        if (TextUtils.isEmpty(f31716l) == true) goto L15;
        r103.append("|origin_uid:");     // Catch: RemoteException -> L32
        r103.append(f31716l);     // Catch: RemoteException -> L32
    L15:
        StringBuffer r104 = new StringBuffer();     // Catch: RemoteException -> L32
        if (f31719o == null) goto L19;
        r104.append("name:" + f31719o + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: RemoteException -> L32
    L19:
        if (SDKInitializer.getCoordType() != r111) goto L21;
        f31715k = CoordTrans.gcjToBaidu(f31715k);     // Catch: RemoteException -> L32
    L21:
        r104.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(f31715k.latitude), Double.valueOf(f31715k.longitude)}));     // Catch: RemoteException -> L32
        if (TextUtils.isEmpty(f31717m) == true) goto L25;
        r104.append("|destination_uid:");     // Catch: RemoteException -> L32
        r104.append(f31717m);     // Catch: RemoteException -> L32
    L25:
        r102.putString(PlayerResolution.SDKKEY.ORIGIN, r103.toString());     // Catch: RemoteException -> L32
        r102.putString(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, r104.toString());     // Catch: RemoteException -> L32
        r101.putBundle("base_params", r102);     // Catch: RemoteException -> L32
        Bundle r105 = new Bundle();     // Catch: RemoteException -> L32
        r105.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: RemoteException -> L32
        r101.putBundle("ext_params", r105);     // Catch: RemoteException -> L32
        return f31707c.a("map.android.baidu.mainmap", r100, r101);
    L31:
        return false;
    }

    private static boolean l() {
        String r100 = f31707c.a("map.android.baidu.mainmap");     // Catch: Exception -> L32
        if (r100 == null) goto L31;
        Bundle r101 = new Bundle();     // Catch: Exception -> L32
        r101.putString(PickerReporterConstants.KEY.TARGET, "walknavi_page");     // Catch: Exception -> L32
        Bundle r102 = new Bundle();     // Catch: Exception -> L32
        r102.putString("coord_type", CoordinateType.BD09LL);     // Catch: Exception -> L32
        StringBuffer r103 = new StringBuffer();     // Catch: Exception -> L32
        if (f31718n == null) goto L9;
        r103.append("name:" + f31718n + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Exception -> L32
    L9:
        CoordType r110 = SDKInitializer.getCoordType();     // Catch: Exception -> L32
        CoordType r111 = CoordType.GCJ02;     // Catch: Exception -> L32
        if (r110 != r111) goto L12;
        f31714j = CoordTrans.gcjToBaidu(f31714j);     // Catch: Exception -> L32
    L12:
        r103.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(f31714j.latitude), Double.valueOf(f31714j.longitude)}));     // Catch: Exception -> L32
        if (TextUtils.isEmpty(f31716l) == true) goto L15;
        r103.append("|origin_uid:");     // Catch: Exception -> L32
        r103.append(f31716l);     // Catch: Exception -> L32
    L15:
        StringBuffer r104 = new StringBuffer();     // Catch: Exception -> L32
        if (f31719o == null) goto L19;
        r104.append("name:" + f31719o + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Exception -> L32
    L19:
        if (SDKInitializer.getCoordType() != r111) goto L21;
        f31715k = CoordTrans.gcjToBaidu(f31715k);     // Catch: Exception -> L32
    L21:
        r104.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(f31715k.latitude), Double.valueOf(f31715k.longitude)}));     // Catch: Exception -> L32
        if (TextUtils.isEmpty(f31717m) == true) goto L25;
        r104.append("|destination_uid:");     // Catch: Exception -> L32
        r104.append(f31717m);     // Catch: Exception -> L32
    L25:
        r102.putString(PlayerResolution.SDKKEY.ORIGIN, r103.toString());     // Catch: Exception -> L32
        r102.putString(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, r104.toString());     // Catch: Exception -> L32
        r101.putBundle("base_params", r102);     // Catch: Exception -> L32
        Bundle r105 = new Bundle();     // Catch: Exception -> L32
        r105.putString("launch_from", "sdk_[" + f31710f + "]");     // Catch: Exception -> L32
        r101.putBundle("ext_params", r105);     // Catch: Exception -> L32
        return f31707c.a("map.android.baidu.mainmap", r100, r101);
    L31:
        return false;
    }

    public static String m() {
        return AppTools.getBaiduMapToken();
    }

    public static /* synthetic */ String a() {
        return f31705a;
    }

    public static /* synthetic */ IComOpenClient b() {
        return f31707c;
    }

    public static /* synthetic */ boolean c() {
        return f31727w;
    }

    public static /* synthetic */ Thread d() {
        return f31729y;
    }

    public static /* synthetic */ com.baidu.mapframework.open.aidl.a e() {
        return f31706b;
    }

    private static void a(TruckNaviOption r100) {
        f31730z = 0;
        A = AudioStats.AUDIO_AMPLITUDE_NONE;
        B = AudioStats.AUDIO_AMPLITUDE_NONE;
        C = AudioStats.AUDIO_AMPLITUDE_NONE;
        D = AudioStats.AUDIO_AMPLITUDE_NONE;
        E = AudioStats.AUDIO_AMPLITUDE_NONE;
        F = 0;
        G = false;
        H = null;
        I = 0;
        f31704J = 0;
        K = 0;
        L = 0;
        M = 0;
        if (r100.getNaviRoutePolicy() == null) goto L5;
        f31721q = r100.getNaviRoutePolicy();
    L5:
        JSONArray r101 = r100.getWayPoint();
        if (r101 == null) goto L16;
        JSONObject r102 = new JSONObject();
        r102.put("viaPoints", r101);     // Catch: Exception -> L14
        f31720p = URLEncoder.encode(r102.toString(), XML.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L11 Exception -> L14
    L18:
        goto L16
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        f31730z = r100.getTruckType();
        A = r100.getHeight();
        B = r100.getWidth();
        C = r100.getWeight();
        D = r100.getLength();
        E = r100.getAxleWeight();
        F = r100.getAxleCount();
        G = r100.getIsTrailer();
        H = r100.getPlateNumber();
        I = r100.getPlateColor();
        f31704J = r100.getDisplacement();
        K = r100.getPowerType();
        L = r100.getEmissionLimit();
        M = r100.getLoadWeight();
    }

    private static void b(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/navi?origin=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31714j = CoordTrans.gcjToBaidu(f31714j);
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L8:
        r102.append(f31714j.latitude);
        r102.append(",");
        r102.append(f31714j.longitude);
        if (TextUtils.isEmpty(f31716l) == true) goto L11;
        r102.append("&origin_uid=");
        r102.append(f31716l);
    L11:
        r102.append("&location=");
        r102.append(f31715k.latitude);
        r102.append(",");
        r102.append(f31715k.longitude);
        if (TextUtils.isEmpty(f31717m) == true) goto L14;
        r102.append("&destination_uid=");
        r102.append(f31717m);
    L14:
        r102.append("&src=");
        r102.append("sdk_[" + f31710f + "]");
        if (TextUtils.isEmpty(f31720p) == true) goto L17;
        r102.append("&viaPoints=");
        r102.append(f31720p);
    L17:
        r102.append("&type=");
        r102.append(f31721q);
        r102.append("&mode=neweng");
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r103.setFlags(268435456);
        r100.startActivity(r103);
    }

    private static void c(Context r110) {
        Thread r100 = f31729y;
        if (r100 == null) goto L5;
        r100.interrupt();
    L5:
        StringBuilder r101 = new StringBuilder("baidumap://map/truck/navigation?location=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L8:
        r101.append(f31715k.latitude);
        r101.append(",");
        r101.append(f31715k.longitude);
        if (TextUtils.isEmpty(f31716l) == true) goto L12;
        r101.append("&origin_uid=");
        r101.append(f31716l);
    L12:
        if (TextUtils.isEmpty(f31717m) == true) goto L14;
        r101.append("&destination_uid=");
        r101.append(f31717m);
    L14:
        r101.append("&src=");
        r101.append("sdk_[" + f31710f + "]");
        if (TextUtils.isEmpty(f31720p) == true) goto L17;
        r101.append("&viaPoints=");
        r101.append(f31720p);
    L17:
        r101.append("&type=");
        r101.append(f31721q);
        int r102 = f31730z;
        if (r102 <= 0) goto L98;
        if (r102 > 4) goto L98;
        r101.append("&truck_type=");
        r101.append(f31730z);
        double r103 = A;
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L96;
        if (r103 > 10.0d) goto L96;
        r101.append("&height=");
        r101.append(A);
        double r104 = B;
        if (r104 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L94;
        if (r104 > 5.0d) goto L94;
        r101.append("&width=");
        r101.append(B);
        double r105 = C;
        if (r105 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L92;
        if (r105 > 100.0d) goto L92;
        r101.append("&weight=");
        r101.append(C);
        double r106 = D;
        if (r106 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L90;
        if (r106 > 25.0d) goto L90;
        r101.append("&length=");
        r101.append(D);
        double r107 = E;
        if (r107 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
    L42:
        int r108 = F;
        if (r108 <= 1) goto L88;
        if (r108 > 8) goto L88;
        r101.append("&axle_count=");
        r101.append(F);
        if (G == false) goto L49;
        r101.append("&is_trailer=1");
    L51:
        if (TextUtils.isEmpty(H) == true) goto L86;
        if (H.length() != 7) goto L55;
    L59:
        r101.append("&plate_number=");
        r101.append(H);
        int r109 = I;
        if (r109 < 0) goto L64;
        if (r109 > 4) goto L64;
        r101.append("&plate_color=");
        r101.append(I);
    L64:
        if (f31704J <= 0) goto L66;
        r101.append("&displacement=");
        r101.append(f31704J);
    L66:
        int r111 = K;
        if (r111 <= 0) goto L84;
        if (r111 > 4) goto L84;
        r101.append("&power_type=");
        r101.append(K);
        int r112 = L;
        if (r112 < 0) goto L82;
        if (r112 > 6) goto L82;
        r101.append("&emission_limit=");
        r101.append(L);
        int r113 = M;
        if (r113 <= 0) goto L80;
        if (r113 > 100) goto L80;
        r101.append("&load_weight=");
        r101.append(M);
        Intent r114 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101.toString()));
        r114.setFlags(268435456);
        r110.startActivity(r114);
        return;
    L80:
        throw new IllegalArgumentException("BDMapSDKException: loadWeight Must be between 1 and 100");
    L82:
        throw new IllegalArgumentException("BDMapSDKException: emissionLimit Must be between 0 and 6");
    L84:
        throw new IllegalArgumentException("BDMapSDKException: powerType Must be between 1 and 4");
    L55:
        if (H.length() == 8) goto L59;
        throw new IllegalArgumentException("BDMapSDKException: plateNumber error Please fill in the correct license plate");
    L86:
        throw new IllegalArgumentException("BDMapSDKException: plateNumber Can not be null");
    L49:
        r101.append("&is_trailer=0");
    L88:
        throw new IllegalArgumentException("BDMapSDKException: axleCount Must be between 2 and 8");
    L40:
        if (r107 > 100.0d) goto L42;
        r101.append("&axle_weight=");
        r101.append(E);
    L90:
        throw new IllegalArgumentException("BDMapSDKException: length Must be between 1 and 25");
    L92:
        throw new IllegalArgumentException("BDMapSDKException: weight Must be between 1 and 100");
    L94:
        throw new IllegalArgumentException("BDMapSDKException: width Must be between 1 and 5");
    L96:
        throw new IllegalArgumentException("BDMapSDKException: height Must be between 1 and 10");
    L98:
        throw new IllegalArgumentException("BDMapSDKException: truckType Must be between 1 and 4");
    }

    private static void d(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/bikenavi?origin=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31714j = CoordTrans.gcjToBaidu(f31714j);
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L8:
        LatLng r103 = f31714j;
        if (r103 != null) goto L11;
        return;
    L11:
        if (f31715k == null) goto L22;
        r102.append(r103.latitude);
        r102.append(",");
        r102.append(f31714j.longitude);
        if (TextUtils.isEmpty(f31716l) == true) goto L16;
        r102.append("&origin_uid=");
        r102.append(f31716l);
    L16:
        r102.append("&destination=");
        r102.append(f31715k.latitude);
        r102.append(",");
        r102.append(f31715k.longitude);
        if (TextUtils.isEmpty(f31717m) == true) goto L19;
        r102.append("&destination_uid=");
        r102.append(f31717m);
    L19:
        r102.append("&src=");
        r102.append("sdk_[" + f31710f + "]");
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r104.setFlags(268435456);
        r100.startActivity(r104);
        return;
    }

    private static void e(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/navi?origin=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31714j = CoordTrans.gcjToBaidu(f31714j);
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L8:
        r102.append(f31714j.latitude);
        r102.append(",");
        r102.append(f31714j.longitude);
        if (TextUtils.isEmpty(f31716l) == true) goto L11;
        r102.append("&origin_uid=");
        r102.append(f31716l);
    L11:
        r102.append("&location=");
        r102.append(f31715k.latitude);
        r102.append(",");
        r102.append(f31715k.longitude);
        if (TextUtils.isEmpty(f31717m) == true) goto L14;
        r102.append("&destination_uid=");
        r102.append(f31717m);
    L14:
        r102.append("&src=");
        r102.append("sdk_[" + f31710f + "]");
        if (TextUtils.isEmpty(f31720p) == true) goto L17;
        r102.append("&viaPoints=");
        r102.append(f31720p);
    L17:
        r102.append("&type=");
        r102.append(f31721q);
        r102.append("&mode=driving");
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r103.setFlags(268435456);
        r100.startActivity(r103);
    }

    private static void f(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/walknavi?origin=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31714j = CoordTrans.gcjToBaidu(f31714j);
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L8:
        LatLng r103 = f31714j;
        if (r103 != null) goto L11;
        return;
    L11:
        if (f31715k == null) goto L22;
        r102.append(r103.latitude);
        r102.append(",");
        r102.append(f31714j.longitude);
        if (TextUtils.isEmpty(f31716l) == true) goto L16;
        r102.append("&origin_uid=");
        r102.append(f31716l);
    L16:
        r102.append("&destination=");
        r102.append(f31715k.latitude);
        r102.append(",");
        r102.append(f31715k.longitude);
        if (TextUtils.isEmpty(f31717m) == true) goto L19;
        r102.append("&destination_uid=");
        r102.append(f31717m);
    L19:
        r102.append("&src=");
        r102.append("sdk_[" + f31710f + "]");
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r104.setFlags(268435456);
        r100.startActivity(r104);
        return;
    }

    private static void g(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/walknavi?origin=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31714j = CoordTrans.gcjToBaidu(f31714j);
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L8:
        LatLng r103 = f31714j;
        if (r103 != null) goto L11;
        return;
    L11:
        if (f31715k == null) goto L22;
        r102.append(r103.latitude);
        r102.append(",");
        r102.append(f31714j.longitude);
        if (TextUtils.isEmpty(f31716l) == true) goto L16;
        r102.append("&origin_uid=");
        r102.append(f31716l);
    L16:
        r102.append("&destination=");
        r102.append(f31715k.latitude);
        r102.append(",");
        r102.append(f31715k.longitude);
        if (TextUtils.isEmpty(f31717m) == true) goto L19;
        r102.append("&destination_uid=");
        r102.append(f31717m);
    L19:
        r102.append("&mode=walking_ar&src=");
        r102.append("sdk_[" + f31710f + "]");
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r104.setFlags(268435456);
        r100.startActivity(r104);
        return;
    }

    private static void h(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/place/detail?uid=");
        r102.append(f31723s);
        r102.append("&show_type=detail_page&src=");
        r102.append("sdk_[" + f31710f + "]");
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r103.setFlags(268435456);
        r100.startActivity(r103);
    }

    private static void i(Context r100) {
        Thread r101 = f31729y;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("baidumap://map/nearbysearch?center=");
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L8;
        f31725u = CoordTrans.gcjToBaidu(f31725u);
    L8:
        r102.append(f31725u.latitude);
        r102.append(",");
        r102.append(f31725u.longitude);
        r102.append("&query=");
        r102.append(f31724t);
        r102.append("&radius=");
        r102.append(f31726v);
        r102.append("&src=");
        r102.append("sdk_[" + f31710f + "]");
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r103.setFlags(268435456);
        r100.startActivity(r103);
    }

    public static void j(Context r100) {
        if (f31728x == false) goto L6;
        r100.unbindService(N);
        f31728x = false;
        return;
    }

    public static boolean a(int r100) {
        if (r100 == 101) goto L22;
        if (r100 == 102) goto L22;
        switch(r100) {
            case 0: goto L22;
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            default: goto L7;
        };
    L7:
        return false;
    L10:
        return k();
    L12:
        return l();
    L14:
        return f();
    L16:
        return j();
    L18:
        return h();
    L20:
        return g();
    L22:
        return i();
    }

    public static /* synthetic */ boolean b(boolean r100) {
        f31728x = r100;
        return r100;
    }

    public static String a(Context r100) {
        ApplicationInfo r101 = null;
        PackageManager r102 = r100.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L6
        r101 = r102.getApplicationInfo(r100.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L9
    L8:
        return (String) r102.getApplicationLabel(r101);
    L6:
        r102 = null;
        goto L8
    }

    public static /* synthetic */ IComOpenClient a(IComOpenClient r100) {
        f31707c = r100;
        return r100;
    }

    public static /* synthetic */ com.baidu.mapframework.open.aidl.a a(com.baidu.mapframework.open.aidl.a r100) {
        f31706b = r100;
        return r100;
    }

    public static /* synthetic */ boolean a(boolean r100) {
        f31727w = r100;
        return r100;
    }

    public static void a(int r100, Context r101) {
        if (r100 != 0) goto L4;
    L29:
        c(r101, r100);
        return;
    L4:
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L29;
        if (r100 != 3) goto L10;
        h(r101);
        return;
    L10:
        if (r100 != 4) goto L12;
        i(r101);
        return;
    L12:
        if (r100 != 5) goto L14;
        e(r101);
        return;
    L14:
        if (r100 != 7) goto L16;
        f(r101);
        return;
    L16:
        if (r100 != 8) goto L18;
        d(r101);
        return;
    L18:
        if (r100 == 9) goto L23;
        switch(r100) {
            case 101: goto L29;
            case 102: goto L29;
            case 103: goto L22;
            case 104: goto L21;
            default: goto L39;
        };
    L21:
        c(r101);
        return;
    L22:
        b(r101);
        return;
    L39:
        return;
    L23:
        g(r101);
    }

    public static boolean b(Context r100, int r101) {
    L37:
        e = move-exception;
        e.printStackTrace();
    L39:
        return true;
    L4:
        if (SignUtils.verifySign(r100) == true) goto L6;
        return false;
    L6:
        f31727w = false;     // Catch: Exception -> L37
        switch(r101) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            default: goto L8;
        };     // Catch: Exception -> L37
    L8:
        switch(r101) {
            case 101: goto L23;
            case 102: goto L22;
            case 103: goto L21;
            case 104: goto L20;
            default: goto L24;
        };     // Catch: Exception -> L37
    L20:
        f31708d = 104;     // Catch: Exception -> L37
        goto L24
    L21:
        f31708d = 103;     // Catch: Exception -> L37
        goto L24
    L22:
        f31708d = 102;     // Catch: Exception -> L37
        goto L24
    L23:
        f31708d = 101;     // Catch: Exception -> L37
    L24:
        if (r101 != 9) goto L26;
        f31728x = false;     // Catch: Exception -> L37
    L26:
        com.baidu.mapframework.open.aidl.a r102 = f31706b;     // Catch: Exception -> L37
        if (r102 != null) goto L29;
    L35:
        a(r100, r101);     // Catch: Exception -> L37
        goto L39
    L29:
        if (f31728x == false) goto L35;
        if (f31707c == null) goto L34;
        f31727w = true;     // Catch: Exception -> L37
        return a(r101);
    L34:
        r102.a(new BinderC0631a(r101));     // Catch: Exception -> L37
        goto L39
    L10:
        f31708d = 9;     // Catch: Exception -> L37
        goto L24
    L11:
        f31708d = 8;     // Catch: Exception -> L37
        goto L24
    L12:
        f31708d = 7;     // Catch: Exception -> L37
        goto L24
    L13:
        f31708d = 6;     // Catch: Exception -> L37
        goto L24
    L14:
        f31708d = 5;     // Catch: Exception -> L37
        goto L24
    L15:
        f31708d = 4;     // Catch: Exception -> L37
        goto L24
    L16:
        f31708d = 3;     // Catch: Exception -> L37
        goto L24
    L17:
        f31708d = 2;     // Catch: Exception -> L37
        goto L24
    L18:
        f31708d = 1;     // Catch: Exception -> L37
        goto L24
    L19:
        f31708d = 0;     // Catch: Exception -> L37
        goto L24
    }

    private static void c(Context r100, int r101) {
        Thread r102 = f31729y;
        if (r102 == null) goto L6;
        r102.interrupt();
    L6:
        if (r101 != 101) goto L9;
        r101 = 3;
    L9:
        if (r101 != 102) goto L11;
        r101 = 4;
    L11:
        String[] r103 = {AppletNaviType.DRIVING, AppletNaviType.TRANSIT, AppletNaviType.WALKING, "neweng", "truck"};
        StringBuilder r104 = new StringBuilder("baidumap://map/direction?origin=");
        if (f31714j == null) goto L17;
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L17;
        f31714j = CoordTrans.gcjToBaidu(f31714j);
    L17:
        if (TextUtils.isEmpty(f31718n) == true) goto L22;
        if (f31714j == null) goto L22;
        r104.append("name:");
        r104.append(f31718n);
        r104.append("|latlng:");
        r104.append(f31714j.latitude);
        r104.append(",");
        r104.append(f31714j.longitude);
    L28:
        if (TextUtils.isEmpty(f31716l) == true) goto L30;
        r104.append("&origin_uid=");
        r104.append(f31716l);
    L30:
        r104.append("&destination=");
        if (f31715k == null) goto L36;
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L36;
        f31715k = CoordTrans.gcjToBaidu(f31715k);
    L36:
        if (TextUtils.isEmpty(f31719o) == true) goto L41;
        if (f31715k == null) goto L41;
        r104.append("name:");
        r104.append(f31719o);
        r104.append("|latlng:");
        r104.append(f31715k.latitude);
        r104.append(",");
        r104.append(f31715k.longitude);
    L47:
        if (TextUtils.isEmpty(f31717m) == true) goto L49;
        r104.append("&destination_uid=");
        r104.append(f31717m);
    L49:
        r104.append("&mode=");
        r104.append(r103[r101]);
        r104.append("&target=1&src=");
        r104.append("sdk_[" + f31710f + "]");
        Intent r105 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r104.toString()));
        r105.setFlags(268435456);
        r100.startActivity(r105);
        return;
    L41:
        if (TextUtils.isEmpty(f31719o) == true) goto L43;
        r104.append(f31719o);
        goto L47
    L43:
        LatLng r106 = f31715k;
        if (r106 == null) goto L47;
        r104.append(r106.latitude);
        r104.append(",");
        r104.append(f31715k.longitude);
    L22:
        if (TextUtils.isEmpty(f31718n) == true) goto L24;
        r104.append(f31718n);
        goto L28
    L24:
        LatLng r107 = f31714j;
        if (r107 == null) goto L28;
        r104.append(r107.latitude);
        r104.append(",");
        r104.append(f31714j.longitude);
        goto L28
    }

    private static void a(Context r100, int r101) {
        Intent r102 = new Intent();
        String r103 = m();
        if (r103 != null) goto L5;
        return;
    L5:
        r102.putExtra("api_token", r103);
        r102.setAction("com.baidu.map.action.OPEN_SERVICE");
        r102.setPackage(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP);
        if (r101 == 9) goto L9;
        f31728x = r100.bindService(r102, N, 1);
    L9:
        if (f31728x == false) goto L11;
        PthreadThreadV2 r104 = new PthreadThreadV2(new c(r100, r101), "apapi/utils/a");
        f31729y = r104;
        r104.setDaemon(true);
        ThreadMethodProxy.start(f31729y);
        return;
    L11:
        a(r101, r100);
    }

    private static void a(List<DispathcPoiData> r100, Context r101) {
        f31710f = r101.getPackageName();
        f31711g = a(r101);
        f31712h = "";
        List<DispathcPoiData> r102 = f31713i;
        if (r102 == null) goto L5;
        r102.clear();
    L5:
        Iterator<DispathcPoiData> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        DispathcPoiData r104 = r103.next();
        f31713i.add(r104);
        goto L7
    }

    public static boolean a(NaviParaOption r100, Context r101, int r102) {
        b(r100, r101, r102);
        return b(r101, r102);
    }

    private static void b(NaviParaOption r100, Context r101, int r102) {
        f31710f = r101.getPackageName();
        f31718n = null;
        f31714j = null;
        f31719o = null;
        f31715k = null;
        f31720p = null;
        f31716l = null;
        f31717m = null;
        if (r100.getStartPoint() == null) goto L6;
        f31714j = r100.getStartPoint();
    L6:
        if (r100.getEndPoint() == null) goto L9;
        f31715k = r100.getEndPoint();
    L9:
        if (r100.getStartName() == null) goto L12;
        f31718n = r100.getStartName();
    L12:
        if (r100.getEndName() == null) goto L15;
        f31719o = r100.getEndName();
    L15:
        if (TextUtils.isEmpty(r100.getStartUid()) == true) goto L18;
        f31716l = r100.getStartUid();
    L18:
        if (TextUtils.isEmpty(r100.getEndUid()) == true) goto L21;
        f31717m = r100.getEndUid();
    L21:
        if (r100.getNaviRoutePolicy() == null) goto L23;
        f31721q = r100.getNaviRoutePolicy();
    L23:
        JSONArray r103 = r100.getWayPoint();
        if (r103 == null) goto L35;
        JSONObject r104 = new JSONObject();
        r104.put("viaPoints", r103);     // Catch: Exception -> L32
        f31720p = URLEncoder.encode(r104.toString(), XML.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L29 Exception -> L32
    L38:
        goto L35
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L35:
        if ((r100 instanceof TruckNaviOption) == false) goto L43;
        a((TruckNaviOption) r100);
        return;
    }

    public static boolean a(PoiParaOption r100, Context r101, int r102) {
        b(r100, r101, r102);
        return b(r101, r102);
    }

    private static void b(RouteParaOption r100, Context r101, int r102) {
        f31718n = null;
        f31714j = null;
        f31719o = null;
        f31715k = null;
        f31716l = null;
        f31717m = null;
        f31710f = r101.getPackageName();
        if (r100.getStartPoint() == null) goto L6;
        f31714j = r100.getStartPoint();
    L6:
        if (r100.getEndPoint() == null) goto L9;
        f31715k = r100.getEndPoint();
    L9:
        if (r100.getStartName() == null) goto L12;
        f31718n = r100.getStartName();
    L12:
        if (r100.getEndName() == null) goto L15;
        f31719o = r100.getEndName();
    L15:
        if (TextUtils.isEmpty(r100.getStartPoiId()) == true) goto L18;
        f31716l = r100.getStartPoiId();
    L18:
        if (TextUtils.isEmpty(r100.getEndPoiId()) == true) goto L21;
        f31717m = r100.getEndPoiId();
    L21:
        if (r100.getBusStrategyType() == null) goto L23;
        f31722r = r100.getBusStrategyType();
    L23:
        if (r102 != 0) goto L25;
        f31709e = 0;
        return;
    L25:
        if (r102 != 1) goto L27;
        f31709e = 1;
        return;
    L27:
        if (r102 != 2) goto L29;
        f31709e = 2;
        return;
    L29:
        if (r102 != 101) goto L31;
        f31709e = 101;
        return;
    L31:
        if (r102 != 102) goto L43;
        f31709e = 102;
        return;
    }

    public static boolean a(RouteParaOption r100, Context r101, int r102) {
        b(r100, r101, r102);
        return b(r101, r102);
    }

    private static void b(PoiParaOption r100, Context r101, int r102) {
        f31723s = null;
        f31724t = null;
        f31725u = null;
        f31726v = 0;
        f31710f = r101.getPackageName();
        if (r100.getUid() == null) goto L6;
        f31723s = r100.getUid();
    L6:
        if (r100.getKey() == null) goto L9;
        f31724t = r100.getKey();
    L9:
        if (r100.getCenter() == null) goto L12;
        f31725u = r100.getCenter();
    L12:
        if (r100.getRadius() == 0) goto L15;
        f31726v = r100.getRadius();
        return;
    }

    public static boolean a(List<DispathcPoiData> r100, Context r101, int r102) {
        a(r100, r101);
        return b(r101, r102);
    }
}
