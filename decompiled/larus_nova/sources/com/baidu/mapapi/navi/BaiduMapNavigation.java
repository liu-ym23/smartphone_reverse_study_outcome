package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class BaiduMapNavigation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f31673a = true;

    public BaiduMapNavigation() {
    }

    private static String a(Context r100) {
        ApplicationInfo r101 = null;
        PackageManager r102 = r100.getApplicationContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L6
        r101 = r102.getApplicationInfo(r100.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L9
    L8:
        return (String) r102.getApplicationLabel(r101);
    L6:
        r102 = null;
        goto L8
    }

    public static void finish(Context r100) {
        if (r100 == null) goto L5;
        a.j(r100);
        return;
    }

    public static void setSupportWebNavi(boolean r100) {
        f31673a = r100;
    }

    private static void a(NaviParaOption r110, Context r111) throws IllegalNaviArgumentException {
        if (r110 == null) goto L35;
        if (r111 == null) goto L35;
        LatLng r100 = r110.f31674a;
        if (r100 == null) goto L33;
        if (r110.f31677d == null) goto L33;
        GeoPoint r101 = CoordUtil.ll2mc(r100);
        GeoPoint r102 = CoordUtil.ll2mc(r110.f31677d);
        StringBuilder r103 = new StringBuilder("https://app.navi.baidu.com/mobile/#navi/naving/&sy=0&endp=&start=&startwd=&endwd=&fromprod=map_sdk&app_version=7_6_7");
        JSONArray r104 = new JSONArray();
        JSONObject r112 = new JSONObject();
        JSONObject r113 = new JSONObject();
        r112.put("type", "1");     // Catch: JSONException -> L25
        String r114 = r110.f31675b;     // Catch: JSONException -> L25
        if (r114 != null) goto L14;
    L16:
        r112.put("keyword", "");     // Catch: JSONException -> L25
    L17:
        r112.put("xy", String.valueOf(r101.getLongitudeE6()) + "," + String.valueOf(r101.getLatitudeE6()));     // Catch: JSONException -> L25
        r104.put(r112);     // Catch: JSONException -> L25
        r113.put("type", "1");     // Catch: JSONException -> L25
        String r105 = r110.f31678e;     // Catch: JSONException -> L25
        if (r105 != null) goto L20;
    L22:
        r112.put("keyword", "");     // Catch: JSONException -> L25
    L23:
        r113.put("xy", String.valueOf(r102.getLongitudeE6()) + "," + String.valueOf(r102.getLatitudeE6()));     // Catch: JSONException -> L25
        r104.put(r113);     // Catch: JSONException -> L25
    L28:
        if (r104.length() <= 0) goto L30;
        r103.append("&positions=");
        r103.append(r104.toString());
    L30:
        r103.append("&ctrl_type=&mrsl=/vt=map&state=entry");
        Uri r106 = UriProtector.parse(r103.toString());
        Intent r107 = new Intent();
        r107.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r107.setFlags(268435456);
        r107.setData(r106);
        r111.startActivity(r107);
        return;
    L20:
        if (r105.equals("") == true) goto L22;
        r112.put("keyword", r110.f31678e);     // Catch: JSONException -> L25
        goto L23
    L14:
        if (r114.equals("") == true) goto L16;
        r112.put("keyword", r110.f31675b);     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L33:
        throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point.");
    L35:
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapBikeNavi(NaviParaOption r100, Context r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r100.f31677d == null) goto L16;
        if (r100.f31674a == null) goto L16;
        int r102 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r102 != 0) goto L11;
    L14:
        return false;
    L11:
        if (r102 < 869) goto L14;
        return a.a(r100, r101, 8);
    L16:
        throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    L18:
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapNavi(NaviParaOption r100, Context r101) {
        if (r100 == null) goto L29;
        if (r101 == null) goto L29;
        if (r100.f31677d == null) goto L27;
        if (r100.f31674a == null) goto L27;
        int r102 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r102 == 0) goto L21;
        if (r102 < 830) goto L15;
        return a.a(r100, r101, 5);
    L15:
        if (f31673a == false) goto L19;
        a(r100, r101);
        return true;
    L19:
        throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.2");
    L21:
        if (f31673a == false) goto L25;
        a(r100, r101);
        return true;
    L25:
        throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: BaiduMap app is not installed.");
    L27:
        throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    L29:
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapWalkNavi(NaviParaOption r100, Context r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r100.f31677d == null) goto L16;
        if (r100.f31674a == null) goto L16;
        int r102 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r102 != 0) goto L11;
    L14:
        return false;
    L11:
        if (r102 < 869) goto L14;
        return a.a(r100, r101, 7);
    L16:
        throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    L18:
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapWalkNaviAR(NaviParaOption r100, Context r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r100.f31677d == null) goto L16;
        if (r100.f31674a == null) goto L16;
        int r102 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r102 != 0) goto L11;
    L14:
        return false;
    L11:
        if (r102 < 869) goto L14;
        return a.a(r100, r101, 9);
    L16:
        throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    L18:
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static void openWebBaiduMapNavi(NaviParaOption r100, Context r101) throws IllegalNaviArgumentException {
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        LatLng r102 = r100.f31674a;
        if (r102 != null) goto L7;
    L9:
        String r103 = r100.f31675b;
        if (r103 == null) goto L20;
        if (r103.equals("") == true) goto L20;
        String r104 = r100.f31678e;
        if (r104 == null) goto L20;
        if (r104.equals("") == true) goto L20;
        Uri r105 = UriProtector.parse("https://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$" + r100.f31675b + "$$$$$$&en=2$$$$$$" + r100.f31678e + "$$$$$$&fromprod=" + a(r101));
        Intent r106 = new Intent();
        r106.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r106.setData(r105);
        r101.startActivity(r106);
        return;
    L20:
        throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point or set the start and end name.");
    L7:
        if (r100.f31677d == null) goto L9;
        GeoPoint r107 = CoordUtil.ll2mc(r102);
        GeoPoint r108 = CoordUtil.ll2mc(r100.f31677d);
        Uri r109 = UriProtector.parse("https://daohang.map.baidu.com/mobile/#navi/naving/start=" + r107.getLongitudeE6() + "," + r107.getLatitudeE6() + "&endp=" + r108.getLongitudeE6() + "," + r108.getLatitudeE6() + "&fromprod=" + a(r101) + "/vt=map&state=entry");
        Intent r110 = new Intent();
        r110.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r110.setFlags(268435456);
        r110.setData(r109);
        r101.startActivity(r110);
        return;
    L22:
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }
}
