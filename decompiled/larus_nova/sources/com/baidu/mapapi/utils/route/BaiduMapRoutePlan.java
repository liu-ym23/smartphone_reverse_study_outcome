package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.a;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes39.dex */
public class BaiduMapRoutePlan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f31744a = true;

    public BaiduMapRoutePlan() {
    }

    public static void finish(Context r100) {
        if (r100 == null) goto L5;
        a.j(r100);
        return;
    }

    public static void setSupportWebRoute(boolean r100) {
        f31744a = r100;
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption r100, Context r101) {
        if (r100 == null) goto L50;
        if (r101 == null) goto L50;
        String r102 = r100.f31747c;
        if (r102 != null) goto L12;
        if (r100.f31745a != null) goto L12;
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
    L12:
        if (r100.f31748d != null) goto L19;
        if (r100.f31746b != null) goto L19;
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L23;
        if (r100.f31745a != null) goto L23;
    L27:
        return false;
    L23:
        if (TextUtils.isEmpty(r100.f31748d) == false) goto L29;
        if (r100.f31746b == null) goto L27;
    L29:
        if (r100.f31752h != null) goto L31;
        r100.f31752h = RouteParaOption.EBusStrategyType.bus_recommend_way;
    L31:
        int r103 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r103 == 0) goto L44;
        if (r103 < 810) goto L38;
        return a.a(r100, r101, 0);
    L38:
        if (f31744a == false) goto L42;
        a(r100, r101, 0);
        return true;
    L42:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L44:
        if (f31744a == false) goto L48;
        a(r100, r101, 0);
        return true;
    L48:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L50:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapNewEnergyRoute(RouteParaOption r100, Context r101) {
        if (r100 == null) goto L50;
        if (r101 == null) goto L50;
        String r102 = r100.f31747c;
        if (r102 != null) goto L12;
        if (r100.f31745a != null) goto L12;
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
    L12:
        if (r100.f31748d != null) goto L19;
        if (r100.f31746b != null) goto L19;
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L23;
        if (r100.f31745a != null) goto L23;
    L27:
        return false;
    L23:
        if (TextUtils.isEmpty(r100.f31748d) == false) goto L29;
        if (r100.f31746b == null) goto L27;
    L29:
        if (r100.f31752h != null) goto L31;
        r100.f31752h = RouteParaOption.EBusStrategyType.bus_recommend_way;
    L31:
        int r103 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r103 == 0) goto L44;
        if (r103 < 810) goto L38;
        return a.a(r100, r101, 101);
    L38:
        if (f31744a == false) goto L42;
        a(r100, r101, 101);
        return true;
    L42:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L44:
        if (f31744a == false) goto L48;
        a(r100, r101, 101);
        return true;
    L48:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L50:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption r100, Context r101) {
        if (r100 == null) goto L50;
        if (r101 == null) goto L50;
        String r102 = r100.f31747c;
        if (r102 != null) goto L12;
        if (r100.f31745a != null) goto L12;
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
    L12:
        if (r100.f31748d != null) goto L19;
        if (r100.f31746b != null) goto L19;
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L23;
        if (r100.f31745a != null) goto L23;
    L27:
        return false;
    L23:
        if (TextUtils.isEmpty(r100.f31748d) == false) goto L29;
        if (r100.f31746b == null) goto L27;
    L29:
        if (r100.f31752h != null) goto L31;
        r100.f31752h = RouteParaOption.EBusStrategyType.bus_recommend_way;
    L31:
        int r103 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r103 == 0) goto L44;
        if (r103 < 810) goto L38;
        return a.a(r100, r101, 1);
    L38:
        if (f31744a == false) goto L42;
        a(r100, r101, 1);
        return true;
    L42:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L44:
        if (f31744a == false) goto L48;
        a(r100, r101, 1);
        return true;
    L48:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L50:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapTruckRoute(RouteParaOption r100, Context r101) {
        if (r100 == null) goto L50;
        if (r101 == null) goto L50;
        String r102 = r100.f31747c;
        if (r102 != null) goto L12;
        if (r100.f31745a != null) goto L12;
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
    L12:
        if (r100.f31748d != null) goto L19;
        if (r100.f31746b != null) goto L19;
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L23;
        if (r100.f31745a != null) goto L23;
    L27:
        return false;
    L23:
        if (TextUtils.isEmpty(r100.f31748d) == false) goto L29;
        if (r100.f31746b == null) goto L27;
    L29:
        if (r100.f31752h != null) goto L31;
        r100.f31752h = RouteParaOption.EBusStrategyType.bus_recommend_way;
    L31:
        int r103 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r103 == 0) goto L44;
        if (r103 < 810) goto L38;
        return a.a(r100, r101, 102);
    L38:
        if (f31744a == false) goto L42;
        a(r100, r101, 7);
        return true;
    L42:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L44:
        if (f31744a == false) goto L48;
        a(r100, r101, 7);
        return true;
    L48:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L50:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption r100, Context r101) {
        if (r100 == null) goto L50;
        if (r101 == null) goto L50;
        String r102 = r100.f31747c;
        if (r102 != null) goto L12;
        if (r100.f31745a != null) goto L12;
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
    L12:
        if (r100.f31748d != null) goto L19;
        if (r100.f31746b != null) goto L19;
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L23;
        if (r100.f31745a != null) goto L23;
    L27:
        return false;
    L23:
        if (TextUtils.isEmpty(r100.f31748d) == false) goto L29;
        if (r100.f31746b == null) goto L27;
    L29:
        if (r100.f31752h != null) goto L31;
        r100.f31752h = RouteParaOption.EBusStrategyType.bus_recommend_way;
    L31:
        int r103 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r103 == 0) goto L44;
        if (r103 < 810) goto L38;
        return a.a(r100, r101, 2);
    L38:
        if (f31744a == false) goto L42;
        a(r100, r101, 2);
        return true;
    L42:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L44:
        if (f31744a == false) goto L48;
        a(r100, r101, 2);
        return true;
    L48:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L50:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    private static void a(RouteParaOption r110, Context r111, int r112) {
        StringBuilder r100 = new StringBuilder("https://api.map.baidu.com/direction?origin=");
        LatLng r101 = r110.f31745a;
        CoordType r102 = SDKInitializer.getCoordType();
        CoordType r103 = CoordType.GCJ02;
        if (r102 != r103) goto L7;
        if (r101 == null) goto L7;
        r101 = CoordTrans.gcjToBaidu(r101);
    L7:
        if (r110.f31745a == null) goto L15;
        String r104 = r110.f31747c;
        if (r104 == null) goto L15;
        if (r104.equals("") == true) goto L15;
        if (r101 == null) goto L15;
        r100.append("latlng:");
        r100.append(r101.latitude);
        r100.append(",");
        r100.append(r101.longitude);
        r100.append("|name:");
        r100.append(r110.f31747c);
    L20:
        if (TextUtils.isEmpty(r110.getStartPoiId()) == true) goto L22;
        r100.append("&origin_uid=");
        r100.append(r110.getStartPoiId());
    L22:
        LatLng r105 = r110.f31746b;
        if (SDKInitializer.getCoordType() != r103) goto L26;
        if (r105 == null) goto L26;
        r105 = CoordTrans.gcjToBaidu(r105);
    L26:
        r100.append("&destination=");
        if (r110.f31746b == null) goto L35;
        String r106 = r110.f31748d;
        if (r106 == null) goto L35;
        if (r106.equals("") == true) goto L35;
        if (r105 == null) goto L35;
        r100.append("latlng:");
        r100.append(r105.latitude);
        r100.append(",");
        r100.append(r105.longitude);
        r100.append("|name:");
        r100.append(r110.f31748d);
    L40:
        if (TextUtils.isEmpty(r110.getEndPoiId()) == true) goto L42;
        r100.append("&destination_uid=");
        r100.append(r110.getEndPoiId());
    L42:
        if (r112 != 0) goto L44;
        String r113 = AppletNaviType.DRIVING;
    L51:
        r100.append("&mode=");
        r100.append(r113);
        r100.append("&region=");
        if (r110.getCityName() != null) goto L54;
    L57:
        r100.append("全国");
    L58:
        r100.append("&output=html&src=");
        r100.append(r111.getPackageName());
        Uri r114 = UriProtector.parse(r100.toString());
        Intent r115 = new Intent();
        r115.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r115.setFlags(268435456);
        r115.setData(r114);
        r111.startActivity(r115);
        return;
    L54:
        if (r110.getCityName().equals("") == true) goto L57;
        r100.append(r110.getCityName());
        goto L58
    L44:
        if (r112 != 1) goto L46;
        r113 = AppletNaviType.TRANSIT;
        goto L51
    L46:
        if (r112 == 2) goto L48;
        r113 = "";
        goto L51
    L48:
        r113 = AppletNaviType.WALKING;
    L35:
        if (r110.f31746b == null) goto L38;
        if (r105 == null) goto L38;
        r100.append(r105.latitude);
        r100.append(",");
        r100.append(r105.longitude);
    L38:
        r100.append(r110.f31748d);
    L15:
        if (r110.f31745a == null) goto L18;
        if (r101 == null) goto L18;
        r100.append(r101.latitude);
        r100.append(",");
        r100.append(r101.longitude);
    L18:
        r100.append(r110.f31747c);
        goto L20
    }
}
