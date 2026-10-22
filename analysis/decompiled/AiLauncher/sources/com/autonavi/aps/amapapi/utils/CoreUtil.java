package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1532a1;
import com.amap.api.col.jmsl.C1541c2;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.C1569j2;
import com.amap.api.col.jmsl.C1572k1;
import com.amap.api.col.jmsl.C1604s2;
import com.amap.api.col.jmsl.L1;
import com.amap.api.col.jmsl.g5;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CoreUtil {
    public static final String AMAP_LICENSE = "S128DF1572465B890OE3F7A13167KLEI";
    public static final String AMAP_SRC = "api_serverSDK_130905";
    public static final boolean B_FILTER_GPS2LBS = false;
    public static final String CODE_UTF8 = "UTF-8";
    public static String ENGINE_VERSION = "5.3";
    public static final String HTTP_HEADER_USER_AGENT = "AMAP_Location_SDK_Android 11.2.100";
    public static final float LOCATIONDIS = 0.0f;
    public static final String PRODUCT_FIRST_LOC = "locf";
    public static final String SDK_NAME = "loc";
    public static final String STR_API_DEFAULT_DNS_HOST = "httpdns.apilocate.amap.com";
    public static final String STR_API_DNS_SERVER = "http://httpdns.apilocate.amap.com/mobile/binary";
    public static final String STR_API_INOFCN_HOST = "apilocate.amap.com";
    public static final String STR_API_INOFCN_HOST_IPV6 = "apilocate.amap.com";
    public static final String STR_API_INOFCN_IPV6_SERVER = "http://a.apilocate.amap.com/mobile/binary";
    public static final String STR_API_INOFCN_SERVER = "http://apilocate.amap.com/mobile/binary";
    public static final String STR_API_INOFCN_STATIC_HOST = "a.apilocate.amap.com";
    public static final String STR_API_OUTOFCN_HOST = "abroad.apilocate.amap.com";
    public static final String STR_API_OUTOFCN_SERVER = "http://abroad.apilocate.amap.com/mobile/binary";
    public static final String STR_CONFIG_VERSION = "11.2.100";
    public static final String STR_DEX_COLLECTION_NAME = "Collection";
    public static final String STR_DEX_COLLECTION_VERSION = "1.0.0";
    public static final String STR_DEX_GEO_FENCE_NAME = "GeoFence";
    public static final String STR_DEX_GEO_FENCE_VERSION = "1.0.0";
    public static final String STR_DEX_HTTP_DNS_NAME = "HttpDNS";
    public static final String STR_DEX_HTTP_DNS_VERSION = "1.0.0";
    public static final String STR_DEX_MAC_NAME = "mac";
    public static final String STR_DEX_MAC_VERSION = "1.0.0";
    public static final String STR_ORIGN_LICENSE = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    public static final String STR_ORIGN_SRC = "UC_nlp_20131029";
    public static final String STR_REGEO_IPV6_SERVER = "/v3/geocode/regeo";
    public static final int TIMEOUT_SECONDS = 5;
    public static final String URL_PATH_STR_REGEO_SERVER = "/v3/geocode/regeo";

    /* renamed from: a, reason: collision with root package name */
    static String f18445a = "http://apilocate.amap.com/mobile/binary";

    /* renamed from: b, reason: collision with root package name */
    static String f18446b = "http://a.apilocate.amap.com/mobile/binary";

    /* renamed from: d, reason: collision with root package name */
    static String f18448d = null;

    /* renamed from: e, reason: collision with root package name */
    static HashMap<String, String> f18449e = null;

    /* renamed from: f, reason: collision with root package name */
    private static C1569j2 f18450f = null;
    public static int iTo = 30000;
    public static String strAppSha1;
    public static String strAppname;
    public static String strImeiMeid;
    public static String strImsi;
    public static final String[] DEMOTION_ENGINE_VERSION = {"5.1"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f18447c = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};

    private static boolean a(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d12 - d10;
        double d19 = d17 - d15;
        double d20 = d13 - d11;
        double d21 = d16 - d14;
        double d22 = (d18 * d19) - (d20 * d21);
        if (d22 == 0.0d) {
            return false;
        }
        double d23 = d11 - d15;
        double d24 = d10 - d14;
        double d25 = ((d21 * d23) - (d19 * d24)) / d22;
        double d26 = ((d23 * d18) - (d24 * d20)) / d22;
        return d25 >= 0.0d && d25 <= 1.0d && d26 >= 0.0d && d26 <= 1.0d;
    }

    public static void changeUrl(Context context) {
        try {
            C1532a1 c1532a1C = C1532a1.c(context);
            String[] strArr = C1604s2.f16918a;
            if (C1572k1.a(context, false)) {
                String strA = c1532a1C.a(40);
                f18445a = strA;
                f18446b = strA;
                return;
            }
            f18445a = "http://" + c1532a1C.a(43) + ReportUtil.PATH_LOC;
            f18446b = "http://" + c1532a1C.a(44) + ReportUtil.PATH_LOC;
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "changeUrl");
        }
    }

    public static void checkUrl(Context context) {
        try {
            String strA = C1532a1.c(context).a(40);
            String[] strArr = C1604s2.f16918a;
            if (C1572k1.a(context, false)) {
                f18445a = strA;
                return;
            }
            try {
                if (f18449e == null) {
                    f18449e = new HashMap<>(16);
                }
                f18449e.clear();
                f18449e.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
                f18449e.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
                f18449e.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
            } catch (Throwable th) {
                reportError(th, "CoreUtil", "initUrlHash");
            }
            String strGeneratorKey = Encrypt.generatorKey(C1567j0.n(context));
            f18448d = strGeneratorKey;
            a(strGeneratorKey);
        } catch (Throwable th2) {
            reportError(th2, "CoreUtil", "checkUrl");
        }
    }

    public static C1569j2 getDexSDKInfo(String str, String str2) {
        try {
            return new C1569j2.a(str, str2, HTTP_HEADER_USER_AGENT).c(getPackage()).d();
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "getSDKInfo");
            return null;
        }
    }

    public static String getLocOperType() {
        return "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";
    }

    public static Bundle getOptionBundle(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
            return bundle;
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "getOptionBundle");
            return bundle;
        }
    }

    public static AMapLocationClientOption getOptionFromBundle(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static JSONObject getOptionJson(AMapLocationClientOption aMapLocationClientOption) {
        JSONObject jSONObject = new JSONObject();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            jSONObject.put("nbssid", "0");
            jSONObject.put("reversegeo", aMapLocationClientOption.isNeedAddress());
            jSONObject.put(Const.JSON_KEY_ISOFFSET, aMapLocationClientOption.isOffset());
            jSONObject.put("wifiactivescan", aMapLocationClientOption.isWifiActiveScan() ? "1" : "0");
            jSONObject.put("httptimeout", aMapLocationClientOption.getHttpTimeOut());
            jSONObject.put("isOnceLocationLatest", aMapLocationClientOption.isOnceLocationLatest());
            jSONObject.put("isKillProcess", aMapLocationClientOption.isKillProcess() ? "1" : "0");
            boolean z10 = true;
            if (aMapLocationClientOption.getLocationProtocol().ordinal() != 1) {
                z10 = false;
            }
            jSONObject.put("locationProtocol", z10);
            jSONObject.put("sensorEnable", aMapLocationClientOption.isSensorEnable());
            jSONObject.put("isWifiPassiveScan", aMapLocationClientOption.isWifiScan());
            jSONObject.put("isMock", aMapLocationClientOption.isMockEnable());
            return jSONObject;
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "getOptionJson");
            return jSONObject;
        }
    }

    public static String[] getPackage() {
        return (String[]) f18447c.clone();
    }

    public static C1569j2 getSDKInfo() {
        try {
            if (f18450f == null) {
                f18450f = new C1569j2.a("loc", STR_CONFIG_VERSION, HTTP_HEADER_USER_AGENT).c(getPackage()).a(STR_CONFIG_VERSION).d();
            }
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "getSDKInfo");
        }
        return f18450f;
    }

    public static String getScode(Context context) {
        return L1.c(C1567j0.q(context));
    }

    public static String getStrApiServer() {
        return f18445a;
    }

    public static String getStrIPV6ApiServer() {
        return f18446b;
    }

    public static boolean isChina(double d10, double d11) {
        int i10 = (int) ((d11 - 73.0d) / 0.5d);
        int i11 = (int) ((d10 - 3.5d) / 0.5d);
        if (i11 < 0 || i11 >= 101 || i10 < 0 || i10 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i11 * 124) + i10) == '1';
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "isChina");
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        if (r9 > r19) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        r20 = r13;
        r19 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b0, code lost:
    
        r20 = r13;
        r19 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c6, code lost:
    
        if (r19 > r9) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isInPolygon(com.amap.api.location.DPoint r28, java.util.List<com.amap.api.location.DPoint> r29) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.CoreUtil.isInPolygon(com.amap.api.location.DPoint, java.util.List):boolean");
    }

    public static void reportError(Throwable th, String str, String str2) {
        if ("reportError".equals(str2)) {
            return;
        }
        try {
            if (th instanceof g5) {
                return;
            }
            C1541c2.b(th, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static AMapLocation transformAddress(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null) {
            try {
                aMapLocation.setCountry(aMapLocation2.getCountry());
                aMapLocation.setRoad(aMapLocation2.getRoad());
                aMapLocation.setPoiName(aMapLocation2.getPoiName());
                aMapLocation.setStreet(aMapLocation2.getStreet());
                aMapLocation.setNumber(aMapLocation2.getStreetNum());
                String cityCode = aMapLocation2.getCityCode();
                String adCode = aMapLocation2.getAdCode();
                aMapLocation.setCityCode(cityCode);
                aMapLocation.setAdCode(adCode);
                aMapLocation.setCity(aMapLocation2.getCity());
                aMapLocation.setDistrict(aMapLocation2.getDistrict());
                aMapLocation.setProvince(aMapLocation2.getProvince());
                aMapLocation.setAoiName(aMapLocation2.getAoiName());
                aMapLocation.setAddress(aMapLocation2.getAddress());
                aMapLocation.setDescription(aMapLocation2.getDescription());
                if (aMapLocation.getExtras() != null) {
                    aMapLocation.getExtras().putString(Const.JSON_KEY_CITYCODE, aMapLocation2.getCityCode());
                    aMapLocation.getExtras().putString(Const.JSON_KEY_DESC, aMapLocation2.getExtras().getString(Const.JSON_KEY_DESC));
                    aMapLocation.getExtras().putString(Const.JSON_KEY_ADCODE, aMapLocation2.getAdCode());
                    return aMapLocation;
                }
                Bundle bundle = new Bundle();
                bundle.putString(Const.JSON_KEY_CITYCODE, aMapLocation2.getCityCode());
                bundle.putString(Const.JSON_KEY_DESC, aMapLocation2.getExtras().getString(Const.JSON_KEY_DESC));
                bundle.putString(Const.JSON_KEY_ADCODE, aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable unused) {
            }
        }
        return aMapLocation;
    }

    public static void transformLocation(AMapLocation aMapLocation, JSONObject jSONObject) {
        if (jSONObject == null || aMapLocation == null) {
            return;
        }
        try {
            double dOptDouble = jSONObject.optDouble(Const.JSON_KEY_LAT, aMapLocation.getLatitude());
            double dOptDouble2 = jSONObject.optDouble(Const.JSON_KEY_LON, aMapLocation.getLongitude());
            aMapLocation.setProvider(jSONObject.optString(Const.JSON_KEY_PROVIDER, aMapLocation.getProvider()));
            aMapLocation.setLatitude(dOptDouble);
            aMapLocation.setLongitude(dOptDouble2);
            aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
            try {
                String strOptString = jSONObject.optString(Const.JSON_KEY_ACCURACY);
                if (!TextUtils.isEmpty(strOptString)) {
                    aMapLocation.setAccuracy(Float.parseFloat(strOptString));
                }
            } catch (Throwable unused) {
            }
            try {
                String strOptString2 = jSONObject.optString(Const.JSON_KEY_SPEED);
                if (!TextUtils.isEmpty(strOptString2)) {
                    aMapLocation.setSpeed(Float.parseFloat(strOptString2));
                }
            } catch (Throwable unused2) {
            }
            try {
                String strOptString3 = jSONObject.optString(Const.JSON_KEY_BEARING);
                if (!TextUtils.isEmpty(strOptString3)) {
                    aMapLocation.setBearing(Float.parseFloat(strOptString3));
                }
            } catch (Throwable unused3) {
            }
            aMapLocation.setAdCode(jSONObject.optString(Const.JSON_KEY_ADCODE, aMapLocation.getAdCode()));
            aMapLocation.setCityCode(jSONObject.optString(Const.JSON_KEY_CITYCODE, aMapLocation.getCityCode()));
            aMapLocation.setAddress(jSONObject.optString(Const.JSON_KEY_ADDRESS, aMapLocation.getAddress()));
            String strOptString4 = jSONObject.optString(Const.JSON_KEY_DESC, "");
            aMapLocation.setCountry(jSONObject.optString("country", aMapLocation.getCountry()));
            aMapLocation.setProvince(jSONObject.optString("province", aMapLocation.getProvince()));
            aMapLocation.setCity(jSONObject.optString("city", aMapLocation.getCity()));
            aMapLocation.setDistrict(jSONObject.optString("district", aMapLocation.getDistrict()));
            aMapLocation.setRoad(jSONObject.optString(Const.JSON_KEY_ROAD, aMapLocation.getRoad()));
            aMapLocation.setStreet(jSONObject.optString(Const.JSON_KEY_STREET, aMapLocation.getStreet()));
            aMapLocation.setNumber(jSONObject.optString(Const.JSON_KEY_NUMBER, aMapLocation.getStreetNum()));
            aMapLocation.setPoiName(jSONObject.optString(Const.JSON_KEY_POINAME, aMapLocation.getPoiName()));
            aMapLocation.setAoiName(jSONObject.optString(Const.JSON_KEY_AOINAME, aMapLocation.getAoiName()));
            aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
            aMapLocation.setErrorInfo(jSONObject.optString(Const.JSON_KEY_ERRORINFO, aMapLocation.getErrorInfo()));
            aMapLocation.setLocationType(jSONObject.optInt(Const.JSON_KEY_LOCATIONTYPE, aMapLocation.getLocationType()));
            aMapLocation.setLocationDetail(jSONObject.optString(Const.JSON_KEY_LOCATIONDETAIL, aMapLocation.getLocationDetail()));
            aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
            boolean zOptBoolean = jSONObject.optBoolean(Const.JSON_KEY_ISOFFSET, aMapLocation.isOffset());
            aMapLocation.setOffset(zOptBoolean);
            aMapLocation.setBuildingId(jSONObject.optString(Const.JSON_KEY_POIID, aMapLocation.getBuildingId()));
            aMapLocation.setFloor(jSONObject.optString(Const.JSON_KEY_FLOOR, aMapLocation.getFloor()));
            aMapLocation.setDescription(jSONObject.optString("description", aMapLocation.getDescription()));
            if (jSONObject.has("coordType")) {
                aMapLocation.setCoordType(jSONObject.optString("coordType", "GCJ02"));
            } else if (isChina(dOptDouble, dOptDouble2) && zOptBoolean) {
                aMapLocation.setCoordType("GCJ02");
            } else {
                aMapLocation.setCoordType("WGS84");
            }
            Bundle bundle = new Bundle();
            bundle.putString(Const.JSON_KEY_CITYCODE, aMapLocation.getCityCode());
            bundle.putString(Const.JSON_KEY_DESC, strOptString4.toString());
            bundle.putString(Const.JSON_KEY_ADCODE, aMapLocation.getAdCode());
            aMapLocation.setExtras(bundle);
        } catch (Throwable th) {
            reportError(th, "CoreUtil", "transformLocation");
        }
    }

    public static void a(String str) {
        HashMap<String, String> map;
        String str2;
        byte[] bArr;
        if (str != null) {
            try {
                if (str.length() != 0 && (map = f18449e) != null && map.containsKey(str)) {
                    String str3 = f18449e.get(str);
                    if (str3 == null || str3.length() <= 0) {
                        str2 = null;
                    } else {
                        if (str3.length() < 2) {
                            bArr = new byte[0];
                        } else {
                            String lowerCase = str3.toLowerCase(Locale.US);
                            int length = lowerCase.length() / 2;
                            byte[] bArr2 = new byte[length];
                            for (int i10 = 0; i10 < length; i10++) {
                                int i11 = i10 * 2;
                                bArr2[i10] = (byte) (Utils.parseInt(lowerCase.substring(i11, i11 + 2), 16) & 255);
                            }
                            bArr = bArr2;
                        }
                        str2 = new String(Encrypt.aesDecrypt(bArr, str), "utf-8");
                    }
                    if (str2 == null || str2.length() <= 0 || !str2.contains(Const.HTTP_START)) {
                        return;
                    }
                    f18445a = str2;
                }
            } catch (Throwable th) {
                reportError(th, "CoreUtil", "checkUrl");
            }
        }
    }

    private static boolean a(double d10, double d11, double d12, double d13, double d14, double d15) {
        return Math.abs(((d12 - d10) * (d15 - d11)) - ((d14 - d10) * (d13 - d11))) < 1.0E-9d && (d10 - d12) * (d10 - d14) <= 0.0d && (d11 - d13) * (d11 - d15) <= 0.0d;
    }
}
