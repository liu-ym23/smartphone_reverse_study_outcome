package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f28279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f28280b = 0;

    public static void a(Bitmap r100) {
    }

    public static boolean a(double r110, double r111, double r210, double r211, double r212, double r213, double r214, double r310) {
        double r100 = r210 - r110;
        double r101 = r310 - r213;
        double r102 = r211 - r111;
        double r103 = r214 - r212;
        double r104 = (r100 * r101) - (r102 * r103);
        if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        double r112 = r111 - r213;
        double r113 = r110 - r212;
        double r105 = ((r103 * r112) - (r101 * r113)) / r104;
        double r114 = ((r112 * r100) - (r113 * r102)) / r104;
        if (r105 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r105 > 1.0d) goto L13;
        if (r114 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r114 > 1.0d) goto L13;
        return true;
    L13:
        return false;
    }

    public static synchronized int a() {
        monitor-enter(w3.class);
        int r100 = f28279a + 1;     // Catch: Throwable -> L10
        f28279a = r100;     // Catch: Throwable -> L10
        if (r100 != Integer.MAX_VALUE) goto L7;
        f28279a = 0;     // Catch: Throwable -> L10
    L7:
        int r101 = f28279a;     // Catch: Throwable -> L10
        monitor-exit(w3.class);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public static w5 b() {
    L10:
        return null;
    L4:
        if (w.f28257d != null) goto L9;
        w.f28257d = new w5.a("3dmap", "11.2.101", w.f28256c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("11.2.101").a();     // Catch: Throwable -> L10
    L9:
        return w.f28257d;
    }

    static {
        FPoint.obtain();
        FPoint.obtain();
        FPoint.obtain();
        FPoint.obtain();
        new ArrayList(4);
        new ArrayList(4);
        f28279a = 0;
    }

    public static String a(int r110) {
        String r100 = p0.a(2131034404);
        String r101 = p0.a(2131034405);
        if (r110 < 8046720) goto L7;
        return "5000" + r101;
    L7:
        if (r110 < 3218688) goto L11;
        return AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_ON + r101;
    L11:
        if (r110 < 1609344) goto L15;
        return "1000" + r101;
    L15:
        if (r110 < 804672) goto L19;
        return "500" + r101;
    L19:
        if (r110 < 321869) goto L23;
        return "200" + r101;
    L23:
        if (r110 < 160934) goto L27;
        return "100" + r101;
    L27:
        if (r110 < 80467) goto L31;
        return "50" + r101;
    L31:
        if (r110 < 32187) goto L35;
        return "20" + r101;
    L35:
        if (r110 < 24140) goto L39;
        return Constants.VIA_REPORT_TYPE_WPA_STATE + r101;
    L39:
        if (r110 < 16093) goto L43;
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ + r101;
    L43:
        if (r110 < 8047) goto L47;
        return "5" + r101;
    L47:
        if (r110 < 3219) goto L51;
        return "2" + r101;
    L51:
        if (r110 < 1609) goto L55;
        return "1" + r101;
    L55:
        if (r110 < 610) goto L59;
        return AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_ON + r100;
    L59:
        if (r110 < 305) goto L63;
        return "1000" + r100;
    L63:
        if (r110 < 152) goto L67;
        return "500" + r100;
    L67:
        if (r110 < 61) goto L71;
        return "200" + r100;
    L71:
        if (r110 < 30) goto L75;
        return "100" + r100;
    L75:
        if (r110 < 15) goto L79;
        return "50" + r100;
    L79:
        if (r110 < 6) goto L83;
        return "20" + r100;
    L83:
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ + r100;
    }

    public static String b(View r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L18;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L5:
        if ((r100 instanceof TextView) == false) goto L8;
        r101 = new StringBuilder(((TextView) r100).getText().toString());     // Catch: Throwable -> L15
    L8:
        if ((r100 instanceof ViewGroup) == false) goto L18;
        int r102 = ((ViewGroup) r100).getChildCount();     // Catch: Throwable -> L15
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L18;
        String r104 = b(((ViewGroup) r100).getChildAt(r103));     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r104) == true) goto L14;
        r101.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L15
        r101.append(r104);     // Catch: Throwable -> L15
    L14:
        r103 = r103 + 1;
    L18:
        return r101.toString();
    }

    public static String c(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(FileUtil.getMapBaseStorage(r100), AeUtil.ROOT_DATA_PATH_NAME);
        if (r101.exists() == true) goto L5;
        r101.mkdir();
    L5:
        StringBuilder r102 = new StringBuilder();
        r102.append(r101.toString());
        String r103 = File.separator;
        r102.append(r103);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102.toString());
        if (r104.exists() == true) goto L9;
        r104.mkdir();
    L9:
        return r101.toString() + r103;
    }

    public static boolean d(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L8;
        return false;
    L8:
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 != null) goto L11;
        return false;
    L11:
        NetworkInfo.State r103 = r102.getState();
        if (r103 != null) goto L14;
    L20:
        return false;
    L14:
        if (r103 == NetworkInfo.State.DISCONNECTED) goto L20;
        if (r103 == NetworkInfo.State.DISCONNECTING) goto L20;
        return true;
    }

    public static Bitmap a(View r100) {
        c(r100);     // Catch: Throwable -> L8
        r100.destroyDrawingCache();     // Catch: Throwable -> L8
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L8
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());     // Catch: Throwable -> L8
        Bitmap r101 = r100.getDrawingCache();     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return r101.copy(Bitmap.Config.ARGB_8888, false);
    L7:
        return null;
    L8:
        th = move-exception;
        t6.a(th, "Utils", "getBitmapFromView");
        th.printStackTrace();
        return null;
    }

    public static String b(Context r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(FileUtil.getMapBaseStorage(r100));
        String r102 = File.separator;
        r101.append(r102);
        r101.append("data");
        r101.append(r102);
        return r101.toString();
    }

    private static void c(View r100) {
        int r101 = 0;
        if ((r100 instanceof ViewGroup) == false) goto L8;
    L4:
        ViewGroup r102 = (ViewGroup) r100;
        if (r101 >= r102.getChildCount()) goto L13;
        c(r102.getChildAt(r101));
        r101 = r101 + 1;
        goto L4
    L13:
        return;
    L8:
        if ((r100 instanceof TextView) == false) goto L12;
        ((TextView) r100).setHorizontallyScrolling(false);
        return;
    }

    public static DPoint a(LatLng r110) {
        double r100 = (r110.longitude / 360.0d) + 0.5d;
        double r101 = Math.sin(Math.toRadians(r110.latitude));
        return DPoint.obtain(r100 * 1.0d, (((Math.log((r101 + 1.0d) / (1.0d - r101)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static String a(Context r100) {
        String r101 = c(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "VMAP2");
        if (r102.exists() == true) goto L10;
        r102.mkdir();
    L10:
        return r102.toString() + File.separator;
    }

    public static String a(String... r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L9;
        r101.append(r100[r103]);
        if (r104 == (r100.length - 1)) goto L7;
        r101.append(",");
    L7:
        r104 = r104 + 1;
        r103 = r103 + 1;
        goto L3
    L9:
        return r101.toString();
    }

    public static void a(Throwable r100) {
        if (MapsInitializer.getExceptionLogger() == null) goto L9;
        MapsInitializer.getExceptionLogger().onException(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void a(Drawable r100) {
        if (r100 == null) goto L5;
        r100.setCallback(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(LatLng r310, List<LatLng> r311) {
        boolean r100 = false;
        if (r310 == null) goto L49;
        if (r311 == 0) goto L49;
        double r110 = r310.longitude;
        double r111 = r310.latitude;
        if (r311.size() >= 3) goto L10;
        return false;
    L10:
        if (((LatLng) ListProtector.get(r311, 0)).equals(ListProtector.get(r311, r311.size() - 1)) == true) goto L12;
        r311.add(ListProtector.get(r311, 0));
        boolean r210 = true;
    L13:
        int r101 = 0;
        int r211 = 0;
    L50:
    L45:
        th = move-exception;
        if (r210 == false) goto L48;
        ListProtector.remove(r311, r311.size() - 1);
    L48:
        throw th;
    L15:
        if (r101 >= (r311.size() - 1)) goto L39;
        double r102 = ((LatLng) r311.get(r101)).longitude;     // Catch: Throwable -> L45
        double r103 = ((LatLng) r311.get(r101)).latitude;     // Catch: Throwable -> L45
        r101 = r101 + 1;     // Catch: Throwable -> L45
        double r104 = ((LatLng) r311.get(r101)).longitude;     // Catch: Throwable -> L45
        double r105 = ((LatLng) r311.get(r101)).latitude;     // Catch: Throwable -> L45
        double r212 = r111;
        double r312 = r110;
        if (a(r110, r111, r102, r103, r104, r105) == true) goto L18;
        if (Math.abs(r105 - r103) >= 1.0E-9d) goto L26;
    L38:
        r111 = r212;
        r110 = r312;
        goto L50
    L26:
        if (a(r102, r103, r312, r212, 180.0d, r212) == false) goto L31;
        if (r103 <= r105) goto L38;
    L37:
        r211 = r211 + 1;     // Catch: Throwable -> L45
        goto L38
    L31:
        if (a(r104, r105, r312, r212, 180.0d, r212) == false) goto L36;
        if (r105 <= r103) goto L38;
    L36:
        if (a(r102, r103, r104, r105, r312, r212, 180.0d, r212) == false) goto L38;
    L18:
        if (r210 == false) goto L20;
        ListProtector.remove(r311, r311.size() - 1);
    L20:
        return true;
    L39:
        if ((r211 % 2) == 0) goto L42;
        r100 = true;
    L42:
        if (r210 == false) goto L44;
        ListProtector.remove(r311, r311.size() - 1);
    L44:
        return r100;
    L12:
        r210 = false;
    L49:
        return false;
    }

    public static boolean b(List<LatLng> r110, CircleHoleOptions r111) {
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L27
        int r101 = 0;
    L5:
        if (r101 >= r110.size()) goto L7;
        r100.add(r110.get(r101));     // Catch: Throwable -> L27
        r101 = r101 + 1;     // Catch: Throwable -> L27
        goto L5
    L7:
        r100.add(r110.get(0));     // Catch: Throwable -> L27
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L27
        int r102 = 0;
    L8:
        if (r102 >= r100.size()) goto L29;
        int r103 = r102 + 1;     // Catch: Throwable -> L27
        if (r103 >= r100.size()) goto L29;
        if (r111.getRadius() >= AMapUtils.calculateLineDistance(r111.getCenter(), (LatLng) r100.get(r102))) goto L26;
        if (r111.getRadius() >= AMapUtils.calculateLineDistance(r111.getCenter(), (LatLng) r100.get(r103))) goto L26;
        r112.clear();     // Catch: Throwable -> L27
        r112.add(r100.get(r102));     // Catch: Throwable -> L27
        r112.add(r100.get(r103));     // Catch: Throwable -> L27
        if (r111.getRadius() < AMapUtils.calculateLineDistance(r111.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(r112, r111.getCenter()).second)) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L24;
        r102 = r103;
        goto L8
    L24:
        return true;
    L22:
        r104 = false;
    L26:
        return true;
    L29:
        return false;
    L27:
        th = move-exception;
        t6.a(th, "Util", "isPolygon2CircleIntersect");
        th.printStackTrace();
        goto L29
    }

    public static boolean a(List<BaseHoleOptions> r110, CircleHoleOptions r111) {
        int r100 = 0;
        boolean r101 = false;
    L4:
        if (r100 >= r110.size()) goto L23;
        BaseHoleOptions r102 = (BaseHoleOptions) ListProtector.get(r110, r100);
        if ((r102 instanceof PolygonHoleOptions) == false) goto L11;
        r101 = b(((PolygonHoleOptions) r102).getPoints(), r111);
        if (r101 == false) goto L22;
        return true;
    L22:
        r100 = r100 + 1;
        goto L4
    L11:
        if ((r102 instanceof CircleHoleOptions) == false) goto L22;
        CircleHoleOptions r103 = (CircleHoleOptions) r102;
        if (AMapUtils.calculateLineDistance(r103.getCenter(), r111.getCenter()) >= (r111.getRadius() + r103.getRadius())) goto L19;
        r101 = true;
    L20:
        if (r101 == false) goto L22;
        return true;
    L19:
        r101 = false;
    L17:
        th = move-exception;
        t6.a(th, "Util", "isPolygon2CircleIntersect");
        th.printStackTrace();
        goto L19
    L23:
        return r101;
    }

    public static boolean b(List<BaseHoleOptions> r100, PolygonHoleOptions r101) {
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r102 >= r100.size()) goto L33;
        BaseHoleOptions r104 = (BaseHoleOptions) ListProtector.get(r100, r102);
        if ((r104 instanceof PolygonHoleOptions) == false) goto L28;
        List<LatLng> r105 = ((PolygonHoleOptions) r104).getPoints();
        List<LatLng> r106 = r101.getPoints();
        int r107 = 0;
    L34:
        if (r107 >= r106.size()) goto L14;
        if (a(r106.get(r107), r105) == true) goto L19;
        r107 = r107 + 1;     // Catch: Throwable -> L23
    L19:
        r103 = true;
    L25:
        if (r103 == false) goto L32;
        return true;
    L32:
        r102 = r102 + 1;
        goto L4
    L14:
        int r108 = 0;
    L16:
        if (r108 >= r105.size()) goto L21;
        if (a(r105.get(r108), r106) == true) goto L19;
        r108 = r108 + 1;     // Catch: Throwable -> L23
        goto L16
    L21:
        r103 = a(r105, r106);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        t6.a(th, "Util", "isPolygon2PolygonIntersect");
        th.printStackTrace();
        r103 = false;
        goto L25
    L28:
        if ((r104 instanceof CircleHoleOptions) == false) goto L32;
        List<LatLng> r109 = r101.getPoints();
        r103 = b(r109, (CircleHoleOptions) r104);
        if (r103 == false) goto L32;
        return true;
    L33:
        return r103;
    }

    private static boolean a(List<LatLng> r100, List<LatLng> r101) {
        int r102 = 0;
    L22:
    L19:
        th = move-exception;
        t6.a(th, "Util", "isSegmentsIntersect");
        th.printStackTrace();
    L21:
        return false;
    L4:
        if (r102 >= r100.size()) goto L21;
        int r103 = r102 + 1;     // Catch: Throwable -> L19
        if (r103 >= r100.size()) goto L21;
        int r104 = 0;
    L10:
        if (r104 >= r101.size()) goto L18;
        int r105 = r104 + 1;     // Catch: Throwable -> L19
        if (r105 >= r101.size()) goto L18;
        boolean r106 = q3.a(r100.get(r102), r100.get(r103), r101.get(r104), r101.get(r105));     // Catch: Throwable -> L19
        if (r106 == true) goto L16;
        r104 = r105;
        goto L10
    L16:
        return r106;
    L18:
        r102 = r103;
        goto L22
    }

    public static String a(String r100, Context r101) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return r100;
    L13:
        Uri r102 = Uri.parse(r100);     // Catch: Throwable -> L12
        if (r102.getAuthority() != null) goto L8;
    L10:
        p5.b(r101).a(27);     // Catch: Throwable -> L12
        return r102.buildUpon().authority(r102.getAuthority()).build().toString();
    L8:
        if (r102.getAuthority().startsWith("dualstack-") == false) goto L10;
        return r100;
    L15:
        return r100;
    }

    public static boolean a(BaseHoleOptions r100, LatLng r101) {
        if ((r100 instanceof CircleHoleOptions) == false) goto L12;
        CircleHoleOptions r102 = (CircleHoleOptions) r100;
        LatLng r103 = r102.getCenter();
        double r104 = r102.getRadius();
        if (r103 != null) goto L8;
        return false;
    L8:
        if (AMapUtils.calculateLineDistance(r103, r101) > r104) goto L11;
        return true;
    L11:
        return false;
    L12:
        List<LatLng> r105 = ((PolygonHoleOptions) r100).getPoints();
        if (r105 != null) goto L15;
    L19:
        return false;
    L15:
        if (r105.size() == 0) goto L19;
        return a(r101, r105);
    }

    public static boolean a(List<LatLng> r100, PolygonHoleOptions r101) {
        boolean r102 = false;
        int r103 = 0;
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        List<LatLng> r104 = r101.getPoints();     // Catch: Throwable -> L16
        boolean r105 = false;
    L20:
    L14:
        th = th;
        r102 = r105;
    L17:
        t6.a(th, "PolygonDelegateImp", "isPolygonInPolygon");
        th.printStackTrace();
        return r102;
    L9:
        if (r103 >= r104.size()) goto L26;
        r105 = a(r104.get(r103), r100);     // Catch: Throwable -> L14
        if (r105 == false) goto L27;
        r103 = r103 + 1;
        goto L20
    L27:
        return r105;
    L26:
        return r105;
    L16:
        th = th;
    L19:
        return false;
    }

    public static float a(IMapConfig r100, float r101) {
        if (r100 == null) goto L10;
        if (r101 <= r100.getMaxZoomLevel()) goto L7;
        return r100.getMaxZoomLevel();
    L7:
        if (r101 < r100.getMinZoomLevel()) goto L18;
        return r101;
    L18:
        return r100.getMinZoomLevel();
    L10:
        if (r101 <= 20.0f) goto L13;
        return 20.0f;
    L13:
        if (r101 >= 3.0f) goto L20;
        return 3.0f;
    L20:
        return r101;
    }

    public static LinkedHashMap<String, String> a(String r100, String r101) {
        LinkedHashMap<String, String> r102 = new LinkedHashMap();
        String[] r103 = r100.split("&");
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L12;
        String r106 = r103[r105];
        if (TextUtils.isEmpty(r106) == true) goto L11;
        String[] r107 = r106.split(r101);
        if (r107.length != 2) goto L11;
        r102.put(r107[0], r107[1]);
    L11:
        r105 = r105 + 1;
        goto L3
    L12:
        return r102;
    }

    public static Bitmap a(Bitmap r100, float r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Bitmap.createScaledBitmap(r100, (int) (r100.getWidth() * r101), (int) (r100.getHeight() * r101), true);
    }

    public static String a(String r100, Object r101) {
        return r100 + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(r101);
    }

    public static float a(IMapConfig r100, float r101, float r102) {
        boolean r103 = false;
        if (r100 == null) goto L7;
        boolean r104 = true;
        r103 = r100.isAbroadEnable();
        if (r100.getAbroadState() == 1) goto L7;
    L8:
        float r105 = 0.0f;
        if (r101 < 0.0f) goto L12;
        r105 = r101;
    L12:
        int r106 = 40;
        if (r103 == false) goto L20;
        if (r104 == false) goto L20;
        float r107 = 40;
        if (r105 > r107) goto L18;
        return r105;
    L18:
        return r107;
    L20:
        if (r100 == null) goto L28;
        if (r100.isTerrainEnable() == false) goto L28;
        float r108 = 80;
        if (r105 > r108) goto L26;
        return r105;
    L26:
        return r108;
    L28:
        if (r101 > 40.0f) goto L30;
        return r105;
    L30:
        if (r102 > 15.0f) goto L33;
    L44:
        float r109 = r106;
        if (r105 > r109) goto L47;
        return r105;
    L47:
        return r109;
    L33:
        if (r102 > 16.0f) goto L36;
        r106 = 56;
        goto L44
    L36:
        if (r102 > 17.0f) goto L39;
        r106 = 66;
        goto L44
    L39:
        if (r102 > 18.0f) goto L41;
        r106 = 74;
        goto L44
    L41:
        if (r102 > 18.0f) goto L43;
        r106 = 78;
        goto L44
    L43:
        r106 = 80;
    L7:
        r104 = false;
        goto L8
    }

    public static boolean a(double r100, LatLng r101, CircleHoleOptions r102) {
        if (AMapUtils.calculateLineDistance(r102.getCenter(), r101) <= (r100 - r102.getRadius())) goto L14;
        return false;
    L14:
        return true;
    L8:
        th = move-exception;
        t6.a(th, "CircleDelegateImp", "isCircleInCircle");
        th.printStackTrace();
        return true;
    }

    private static float a(float r100, float r101, float r102) {
        return (float) ((((double) r102) * Math.pow(2.0d, 20.0f - r101)) * ((double) r100));
    }

    public static byte[] a(byte[] r100, int r101, int r102, boolean r110) {
        Bitmap r103 = BitmapFactory.decodeByteArray(r100, 0, r100.length);     // Catch: Throwable -> L33
        Bitmap r104 = r103.copy(r103.getConfig(), true);     // Catch: Throwable -> L33
        int r105 = r103.getWidth();     // Catch: Throwable -> L33
        int r106 = r103.getHeight();     // Catch: Throwable -> L33
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L14;
        int r108 = 0;
    L5:
        if (r108 >= r106) goto L13;
        if (r107 == 0) goto L10;
        if (r108 == 0) goto L10;
        r104.setPixel(r107, r108, r101);     // Catch: Throwable -> L33
    L12:
        r108 = r108 + 1;
    L10:
        if (r110 == true) goto L12;
        r104.setPixel(r107, r108, r102);     // Catch: Throwable -> L33
        goto L12
    L13:
        r107 = r107 + 1;
        goto L3
    L14:
        byte[] r109 = null;
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();     // Catch: Throwable -> L23
        r104.compress(Bitmap.CompressFormat.PNG, 100, r111);     // Catch: Throwable -> L22
        r109 = r111.toByteArray();     // Catch: Throwable -> L22
        r111.close();     // Catch: Throwable -> L19
    L29:
        if (r109 != null) goto L31;
        r109 = r100;
    L31:
        a(r104);     // Catch: Throwable -> L33
        a(r103);     // Catch: Throwable -> L33
        return r109;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L24:
        if (r111 == null) goto L29;
        r111.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L23:
        r111 = null;
    L33:
        th = move-exception;
        th.printStackTrace();
        return r100;
    }

    public static boolean a(double r100, LatLng r101, List<BaseHoleOptions> r110, PolygonHoleOptions r111) {
        boolean r102 = true;
        List<LatLng> r112 = r111.getPoints();     // Catch: Throwable -> L25
        int r103 = 0;
        boolean r104 = true;
    L28:
        if (r103 >= r112.size()) goto L37;
        LatLng r105 = r112.get(r103);     // Catch: Throwable -> L23
        if (r110.size() <= 0) goto L17;
        Iterator<BaseHoleOptions> r106 = r110.iterator();     // Catch: Throwable -> L23
    L11:
        if (r106.hasNext() == false) goto L17;
        if (a(r106.next(), r105) == false) goto L11;
    L19:
        r104 = false;
    L20:
        if (r104 == false) goto L38;
        r103 = r103 + 1;
        goto L28
    L38:
        return r104;
    L17:
        if (r100 < AMapUtils.calculateLineDistance(r101, r105)) goto L19;
        r104 = true;
        goto L20
    L37:
        return r104;
    L23:
        th = th;
        r102 = r104;
    L26:
        t6.a(th, "CircleDelegateImp", "isPolygonInCircle");
        th.printStackTrace();
        return r102;
    L25:
        th = th;
        goto L26
    }

    public static Bitmap a(int[] r100, int r110, int r111, boolean r112) {
        int[] r101 = new int[r100.length];     // Catch: Throwable -> L14
        int r102 = 0;
    L3:
        if (r102 >= r111) goto L12;
        int r103 = 0;
    L5:
        if (r103 >= r110) goto L11;
        int r104 = (r102 * r110) + r103;     // Catch: Throwable -> L14
        int r105 = r100[r104];     // Catch: Throwable -> L14
        int r106 = ((r105 & FakePickerAvatarCreator.GREEN) | ((r105 << 16) & 16711680)) | ((r105 >> 16) & 255);     // Catch: Throwable -> L14
        if (r112 == false) goto L9;
        r101[(((r111 - r102) - 1) * r110) + r103] = r106;     // Catch: Throwable -> L14
    L10:
        r103 = r103 + 1;     // Catch: Throwable -> L14
        goto L5
    L9:
        r101[r104] = r106;     // Catch: Throwable -> L14
        goto L10
    L11:
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L3
    L12:
        Bitmap r107 = Bitmap.createBitmap(r110, r111, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L14
        r107.setPixels(r101, 0, r110, 0, 0, r110, r111);     // Catch: Throwable -> L14
        return r107;
    L14:
        th = move-exception;
        t6.a(th, "Util", "rgbaToArgb");
        th.printStackTrace();
        return null;
    }

    public static boolean a(double r100, double r101, double r110, double r111, double r112, double r113) {
        if (Math.abs(((r110 - r100) * (r113 - r101)) - ((r112 - r100) * (r111 - r101))) < 1.0E-9d) goto L5;
    L9:
        return false;
    L5:
        if (((r100 - r110) * (r100 - r112)) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        if (((r101 - r111) * (r101 - r113)) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        return true;
    }

    public static synchronized int[] a(int r100, int r101, int r110, int r111, IMapConfig r112, IGLMapState r113, int r114, int r115) {
        monitor-enter(w3.class);
        int r102 = r112.getMapWidth();     // Catch: Throwable -> L7
        int r103 = r112.getMapHeight();     // Catch: Throwable -> L7
        int r104 = r112.getAnchorX();     // Catch: Throwable -> L7
        int r105 = r112.getAnchorY();     // Catch: Throwable -> L7
        int[] r116 = {(int) Math.max(r110 + a(r112.getMapZoomScale(), r113.getMapZoomer(), r104), Math.min(r114, r100 - a(r112.getMapZoomScale(), r113.getMapZoomer(), r102 - r104))), (int) Math.max(r101 + a(r112.getMapZoomScale(), r113.getMapZoomer(), r105), Math.min(r115, r111 - a(r112.getMapZoomScale(), r113.getMapZoomer(), r103 - r105)))};     // Catch: Throwable -> L7
        monitor-exit(w3.class);
        return r116;
    L7:
        th = move-exception;
        throw th;
    }

    public static Pair<Float, LatLng> a(IMapConfig r210, IGLMapState r211, int r212, int r213, int r214, int r215, LatLngBounds r216, int r217, int r218) {
        if (r216 == null) goto L18;
        LatLng r100 = r216.northeast;
        if (r100 == null) goto L18;
        LatLng r101 = r216.southwest;
        if (r101 == null) goto L18;
        if (r210 != null) goto L11;
        return null;
    L11:
        if (r211 == null) goto L18;
        if ((r211 instanceof GLMapState) == false) goto L18;
        double[] r102 = new double[3];
        if (((GLMapState) r211).getZoomCenterInRect(r217, r218, r212, r213, r214, r215, r101.longitude, r101.latitude, r100.longitude, r100.latitude, r102) == false) goto L18;
        return new Pair(Float.valueOf((float) r102[0]), new LatLng(r102[2], r102[1]));
    L18:
        return null;
    }
}
