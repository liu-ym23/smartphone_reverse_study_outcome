package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.pano.PanoStateError;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BaiduMapPoiSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f31735a = true;

    public static class a implements com.baidu.platform.comapi.pano.a.b<com.baidu.platform.comapi.pano.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f31736a;

        public a(Context r100) {
            this.f31736a = r100;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(com.baidu.platform.comapi.pano.b r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (b.f31737a[r100.a().ordinal()] == 4) goto L8;
            return;
        L8:
            if (r100.b() != 1) goto L17;
            String r101 = r100.c();
            BaiduMapPoiSearch.a(r101, this.f31736a);     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Override // com.baidu.platform.comapi.pano.a.b
        public void a(HttpClient.HttpStateError r100) {
            int r101 = b.f31738b[r100.ordinal()];
        }

        @Override // com.baidu.platform.comapi.pano.a.b
        public /* bridge */ /* synthetic */ void a(com.baidu.platform.comapi.pano.b r100) {
            a2(r100);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31737a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f31738b = null;

        static {
            int[] r100 = new int[HttpClient.HttpStateError.values().length];
            f31738b = r100;
            r100[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            f31738b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            int[] r101 = new int[PanoStateError.values().length];
            f31737a = r101;
            r101[PanoStateError.f33371b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            f31737a[PanoStateError.f33372c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L28:
            f31737a[PanoStateError.f33373d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L20:
            f31737a[PanoStateError.f33370a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public BaiduMapPoiSearch() {
    }

    public static void finish(Context r100) {
        if (r100 == null) goto L5;
        com.baidu.mapapi.utils.a.j(r100);
        return;
    }

    public static void setSupportWebPoi(boolean r100) {
        f31735a = r100;
    }

    private static void a(PoiParaOption r100, Context r101) {
        Uri r102 = UriProtector.parse("https://api.map.baidu.com/place/detail?uid=" + r100.f31740a + "&output=html&src=" + r101.getPackageName());
        Intent r103 = new Intent();
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.setFlags(268435456);
        r103.setData(r102);
        r101.startActivity(r103);
    }

    private static void b(String r100, Context r101) {
        if (r100 == null) goto L15;
        if (r100.length() == 0) goto L15;
        if (r101 == null) goto L13;
        StringBuilder r102 = new StringBuilder("baidumap://map/streetscape?panoid=");
        r102.append(r100);
        r102.append("&pid=");
        r102.append(r100);
        r102.append("&panotype=street&src=");
        r102.append("sdk_[" + r101.getPackageName() + "]");
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102.toString()));
        r103.setFlags(268435456);
        if (r103.resolveActivity(r101.getPackageManager()) == null) goto L11;
        r101.startActivity(r103);
        return;
    L11:
        throw new RuntimeException("BDMapSDKException: BaiduMap app is not installed.");
    L13:
        throw new RuntimeException("BDMapSDKException: context cannot be null.");
    L15:
        throw new RuntimeException("BDMapSDKException: pano id can not be null.");
    }

    public static boolean dispatchPoiToBaiduMap(List<DispathcPoiData> r100, Context r101) throws Exception {
        if (r100.isEmpty() == true) goto L15;
        if (r100.size() <= 0) goto L15;
        int r102 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r102 != 0) goto L9;
        return false;
    L9:
        if (r102 >= 840) goto L11;
        return false;
    L11:
        return com.baidu.mapapi.utils.a.a(r100, r101, 6);
    L15:
        throw new NullPointerException("BDMapSDKException: dispatch poidata is null");
    }

    public static void openBaiduMapPanoShow(String r100, Context r101) {
        new com.baidu.platform.comapi.pano.a().a(r100, new a(r101));
    }

    public static boolean openBaiduMapPoiDetialsPage(PoiParaOption r100, Context r101) {
        if (r100 == null) goto L31;
        if (r101 == null) goto L31;
        String r102 = r100.f31740a;
        if (r102 == null) goto L29;
        if (r102.equals("") == true) goto L27;
        int r103 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r103 == 0) goto L21;
        if (r103 < 810) goto L15;
        return com.baidu.mapapi.utils.a.a(r100, r101, 3);
    L15:
        if (f31735a == false) goto L19;
        a(r100, r101);
        return true;
    L19:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L21:
        if (f31735a == false) goto L25;
        a(r100, r101);
        return true;
    L25:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L27:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be empty string.");
    L29:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be null.");
    L31:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapPoiNearbySearch(PoiParaOption r100, Context r101) {
        if (r100 == null) goto L45;
        if (r101 == null) goto L45;
        String r102 = r100.f31741b;
        if (r102 == null) goto L43;
        LatLng r103 = r100.f31742c;
        if (r103 == null) goto L41;
        if (r103.longitude == AudioStats.AUDIO_AMPLITUDE_NONE) goto L39;
        if (r103.latitude == AudioStats.AUDIO_AMPLITUDE_NONE) goto L39;
        if (r100.f31743d == 0) goto L37;
        if (r102.equals("") == true) goto L35;
        int r104 = OpenClientUtil.getBaiduMapVersion(r101);
        if (r104 == 0) goto L29;
        if (r104 < 810) goto L23;
        return com.baidu.mapapi.utils.a.a(r100, r101, 4);
    L23:
        if (f31735a == false) goto L27;
        b(r100, r101);
        return true;
    L27:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
    L29:
        if (f31735a == false) goto L33;
        b(r100, r101);
        return true;
    L33:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    L35:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi key can not be empty string");
    L37:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search radius larger than 0.");
    L39:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center longitude or latitude can not be 0.");
    L41:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center can not be null.");
    L43:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search key can not be null.");
    L45:
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static /* synthetic */ void a(String r100, Context r101) {
        b(r100, r101);
    }

    private static void b(PoiParaOption r100, Context r101) {
        StringBuilder r102 = new StringBuilder("https://api.map.baidu.com/place/search?query=");
        r102.append(r100.f31741b);
        r102.append("&location=");
        LatLng r103 = r100.f31742c;
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L5;
        r103 = CoordTrans.gcjToBaidu(r103);
    L5:
        r102.append(r103.latitude);
        r102.append(",");
        r102.append(r103.longitude);
        r102.append("&radius=");
        r102.append(r100.f31743d);
        r102.append("&output=html&src=");
        r102.append(r101.getPackageName());
        Uri r104 = UriProtector.parse(r102.toString());
        Intent r105 = new Intent();
        r105.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r105.setFlags(268435456);
        r105.setData(r104);
        r101.startActivity(r105);
    }
}
