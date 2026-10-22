package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1541c2;
import com.amap.api.col.jmsl.C1569j2;
import com.amap.api.col.jmsl.C1583n0;
import com.amap.api.col.jmsl.C1594q;
import com.amap.api.col.jmsl.C1602s0;
import com.amap.api.col.jmsl.C1604s2;
import com.amap.api.col.jmsl.W2;
import com.amap.api.col.jmsl.e3;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AuthUtil {

    /* renamed from: A, reason: collision with root package name */
    private static long f18410A = 0;

    /* renamed from: B, reason: collision with root package name */
    private static boolean f18411B = false;

    /* renamed from: C, reason: collision with root package name */
    private static int f18412C = 0;

    /* renamed from: D, reason: collision with root package name */
    private static boolean f18413D = false;

    /* renamed from: E, reason: collision with root package name */
    private static int f18414E = 0;

    /* renamed from: F, reason: collision with root package name */
    private static boolean f18415F = false;

    /* renamed from: G, reason: collision with root package name */
    private static String f18416G = null;

    /* renamed from: H, reason: collision with root package name */
    private static long f18417H = 0;

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f18418a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f18419b = true;

    /* renamed from: c, reason: collision with root package name */
    private static int f18420c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private static int f18421d = 200;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f18422e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f18423f = false;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f18424g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f18425h = false;

    /* renamed from: i, reason: collision with root package name */
    private static int f18426i = 20;

    /* renamed from: j, reason: collision with root package name */
    private static int f18427j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile int f18428k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f18429l = true;
    public static volatile long lastRequestConfig;

    /* renamed from: m, reason: collision with root package name */
    private static ArrayList<String> f18430m = new ArrayList<>();
    public static boolean mCarrierAble;
    public static int mCarrierInterVal;
    public static boolean mCarrierMobileUpdate;
    public static boolean mLocationDisable;
    public static int maxUpdate;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f18431n;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f18432o;

    /* renamed from: p, reason: collision with root package name */
    private static long f18433p;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f18434q;

    /* renamed from: r, reason: collision with root package name */
    private static double f18435r;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f18436s;

    /* renamed from: t, reason: collision with root package name */
    private static int f18437t;

    /* renamed from: u, reason: collision with root package name */
    private static int f18438u;

    /* renamed from: v, reason: collision with root package name */
    static long f18439v;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f18440w;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f18441x;

    /* renamed from: y, reason: collision with root package name */
    static boolean f18442y;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f18443z;

    public static class LocateObj {
    }

    static {
        new ArrayList();
        f18431n = false;
        f18432o = true;
        f18433p = 300000L;
        f18434q = false;
        f18435r = 0.618d;
        f18436s = true;
        f18437t = 80;
        f18438u = 5;
        f18439v = Const.L_WIFI_EXP;
        f18440w = true;
        f18441x = false;
        lastRequestConfig = 0L;
        f18442y = false;
        f18443z = true;
        f18410A = -1L;
        f18411B = true;
        f18412C = 1;
        f18413D = false;
        f18414E = 5;
        f18415F = false;
        f18416G = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        f18417H = 0L;
        mCarrierAble = false;
        mCarrierMobileUpdate = false;
        maxUpdate = 20480;
        mCarrierInterVal = 10800000;
        mLocationDisable = false;
    }

    private static void a(C1602s0.c cVar, SharedPreferences.Editor editor) {
        try {
            C1602s0.c.a aVar = cVar.f16897d;
            if (aVar != null) {
                boolean z10 = aVar.f16898a;
                f18419b = z10;
                SPUtil.setPrefsBoolean(editor, "exception", z10);
                JSONObject jSONObject = aVar.f16899b;
                if (jSONObject != null) {
                    f18420c = jSONObject.optInt(Const.SP_KEY_FILENUM, f18420c);
                    int iOptInt = jSONObject.optInt(Const.SP_KEY_MAX_POINT_NUM, f18421d);
                    f18421d = iOptInt;
                    if (iOptInt > 500) {
                        f18421d = 500;
                    }
                    if (f18421d < 30) {
                        f18421d = 30;
                    }
                    f18422e = C1602s0.u(jSONObject.optString(Const.SP_KEY_GSM_UPLOAD), false);
                    f18426i = jSONObject.optInt(Const.SP_KEY_GSM_UPLOAD_MXSIZE, f18426i);
                    f18428k = jSONObject.optInt(Const.SP_KEY_RECORD_OFF_LOC_TYPE, 0);
                    f18427j = jSONObject.optInt(Const.SP_KEY_PER_UPLOAD_MXSIZE, 0);
                    f18423f = C1602s0.u(jSONObject.optString(Const.SP_KEY_INFO_WRITE), false);
                    f18424g = C1602s0.u(jSONObject.optString(Const.SP_KEY_INFO_UPLOAD), false);
                    f18425h = C1602s0.u(jSONObject.optString(Const.SP_KEY_FORCED_UPLOAD), false);
                }
                e3.c(f18420c, f18422e, f18426i, f18427j);
                C1594q.f(f18422e, f18427j);
                boolean z11 = f18419b;
                boolean z12 = f18422e;
                boolean z13 = f18423f;
                boolean z14 = f18424g;
                boolean z15 = f18425h;
                List<Object> list = C1583n0.f16773a;
                try {
                    W2.c(CoreUtil.getSDKInfo()).g(z11, z12, z13, z14, null);
                    W2.c(CoreUtil.getSDKInfo()).n(z15);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                SPUtil.setPrefsInt(editor, Const.SP_KEY_FILENUM, f18420c);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_MAX_POINT_NUM, f18421d);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_GSM_UPLOAD, f18422e);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_GSM_UPLOAD_MXSIZE, f18426i);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_INFO_WRITE, f18423f);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_INFO_UPLOAD, f18424g);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_FORCED_UPLOAD, f18425h);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_RECORD_OFF_LOC_TYPE, f18428k);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_PER_UPLOAD_MXSIZE, f18427j);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("15O");
            if (jSONObjectOptJSONObject != null) {
                if (C1602s0.u(jSONObjectOptJSONObject.optString("able"), false)) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("fl");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || jSONArrayOptJSONArray.toString().contains(Build.MANUFACTURER)) {
                        f18410A = jSONObjectOptJSONObject.optInt("iv", 30) * 1000;
                    } else {
                        f18410A = -1L;
                    }
                } else {
                    f18410A = -1L;
                }
                SPUtil.setPrefsLong(editor, Const.SP_KEY_AP_WIFI_SCAN_INTERVAL, f18410A);
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("11G");
            if (jSONObjectOptJSONObject != null) {
                boolean zU = C1602s0.u(jSONObjectOptJSONObject.optString("able"), true);
                f18432o = zU;
                if (zU) {
                    f18433p = jSONObjectOptJSONObject.optInt("c", 300) * 1000;
                }
                f18434q = C1602s0.u(jSONObjectOptJSONObject.optString("fa"), false);
                f18435r = Math.min(1.0d, Math.max(0.2d, jSONObjectOptJSONObject.optDouble(Const.SP_KEY_GSM_UPLOAD_MXSIZE, 0.618d)));
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CACHEABLE, f18432o);
                SPUtil.setPrefsLong(editor, Const.SP_KEY_CACHETIME, f18433p);
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_FORCE_CACHEABLE, f18434q);
                SPUtil.setPrefsStr(editor, Const.SP_KEY_MIN_CACHE_SIM, String.valueOf(f18435r));
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("13J");
            if (jSONObjectOptJSONObject != null) {
                boolean zU = C1602s0.u(jSONObjectOptJSONObject.optString("able"), true);
                f18436s = zU;
                if (zU) {
                    f18437t = jSONObjectOptJSONObject.optInt("c", f18437t);
                    f18438u = jSONObjectOptJSONObject.optInt("t", f18438u);
                }
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_GPS_GEO_ABLE, f18436s);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_GPS_GEO_DIS, f18437t);
                SPUtil.setPrefsInt(editor, Const.SP_KEY_GPS_GEO_DELAY, f18438u);
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int i10;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("17J");
            if (jSONObjectOptJSONObject != null) {
                boolean zU = C1602s0.u(jSONObjectOptJSONObject.optString("able"), false);
                f18413D = zU;
                SPUtil.setPrefsBoolean(editor, Const.SP_KEY_DNS_ABLE, zU);
                if (zU) {
                    String strOptString = jSONObjectOptJSONObject.optString(AbstractC3297l.KEY_AUTH);
                    String strOptString2 = jSONObjectOptJSONObject.optString("ht");
                    f18416G = strOptString2;
                    SPUtil.setPrefsStr(editor, Const.SP_KEY_DNS_HOST, strOptString2);
                    C1602s0.u(strOptString, false);
                    f18415F = C1602s0.u(jSONObjectOptJSONObject.optString("nr"), false);
                    String strOptString3 = jSONObjectOptJSONObject.optString("tm");
                    if (TextUtils.isEmpty(strOptString3) || (i10 = Integer.parseInt(strOptString3)) <= 0 || i10 >= 20) {
                        return;
                    }
                    f18414E = i10;
                    SPUtil.setPrefsInt(editor, Const.SP_KEY_DNS_TIME, i10);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<String> getAMapServcieNames() {
        return f18430m;
    }

    public static long getAPWifiScanInterval() {
        return f18410A;
    }

    public static boolean getCacheAble() {
        return f18432o;
    }

    public static long getCacheValidTime() {
        return f18433p;
    }

    public static int getCheckGPSTimeOffsetYear() {
        return f18412C;
    }

    public static int getFileNum() {
        return f18420c;
    }

    public static boolean getGpsGeoAble() {
        return f18436s;
    }

    public static int getGpsGeoDelay() {
        return f18438u;
    }

    public static int getGpsGeoDis() {
        return f18437t;
    }

    public static String getHost() {
        return C1604s2.m(f18416G);
    }

    public static boolean getHttpDNSAble() {
        return f18413D;
    }

    public static int getMaxPointNum() {
        return f18421d;
    }

    public static double getMinCacheSim() {
        return f18435r;
    }

    public static boolean getNeedRefresh() {
        return f18415F;
    }

    public static int getRecordOffLogType() {
        if (f18428k < 0) {
            f18428k = 0;
        }
        return f18428k;
    }

    public static long getRequestSdkAuthInterval() {
        return f18439v;
    }

    public static long getSerTime() {
        return f18417H;
    }

    public static int getTimeOut() {
        return f18414E;
    }

    public static void initSDKLogHandler(Context context) {
        try {
            C1569j2 sDKInfo = CoreUtil.getSDKInfo();
            sDKInfo.c(f18419b);
            C1541c2.e(context, sDKInfo);
        } catch (Throwable unused) {
        }
    }

    public static boolean isCacheAble(long j10) {
        if (!f18432o) {
            return false;
        }
        long time = Utils.getTime() - j10;
        long j11 = f18433p;
        return j11 < 0 || time < j11;
    }

    public static boolean isCallAMap(Context context) {
        return false;
    }

    public static boolean isCanAlwaysScanWifi() {
        return f18443z;
    }

    public static boolean isCanUseNaviLoc() {
        return f18440w;
    }

    public static boolean isFirstReLocation() {
        return f18442y;
    }

    public static boolean isForceCacheAble() {
        return f18434q;
    }

    public static boolean isGsmUpload() {
        return f18422e;
    }

    public static boolean isInstalledHighDangerMockApp() {
        return f18441x;
    }

    public static boolean isNeedCheckGpsTime() {
        return f18411B && f18412C > 0;
    }

    public static boolean isReciveMessage() {
        return f18429l;
    }

    public static boolean isUploadLog() {
        return f18419b;
    }

    public static void loadLastAbleState(Context context) {
        loadLastAbleState(context, null);
    }

    public static void registerLoadConfig(final Context context) {
        if (f18418a) {
            return;
        }
        f18418a = true;
        C1602s0.h(context, CoreUtil.getSDKInfo(), CoreUtil.getLocOperType(), new C1602s0.b() { // from class: com.autonavi.aps.amapapi.utils.AuthUtil.1
            @Override // com.amap.api.col.jmsl.C1602s0.b
            public void onReceiveAuthConfig(C1602s0.c cVar) {
                AuthUtil.a(context, cVar);
            }
        });
    }

    public static void setReciveMessage(boolean z10) {
        f18429l = z10;
    }

    public static void loadLastAbleState(Context context, AMapLocationClientOption aMapLocationClientOption) {
        if (f18431n) {
            return;
        }
        f18431n = true;
        try {
            f18419b = SPUtil.getPrefsBoolean(context, Const.STR_PREF, "exception", f18419b);
            initSDKLogHandler(context);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f18420c = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_FILENUM, f18420c);
            f18421d = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_MAX_POINT_NUM, f18421d);
            f18422e = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_GSM_UPLOAD, f18422e);
            f18426i = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_GSM_UPLOAD_MXSIZE, f18426i);
            f18428k = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_RECORD_OFF_LOC_TYPE, 0);
            int prefsInt = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_PER_UPLOAD_MXSIZE, 0);
            f18427j = prefsInt;
            e3.c(f18420c, f18422e, f18426i, prefsInt);
            C1594q.f(f18422e, f18427j);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            f18432o = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CACHEABLE, f18432o);
            f18433p = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_CACHETIME, f18433p);
            f18434q = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_FORCE_CACHEABLE, f18434q);
            double dDoubleValue = Double.valueOf(SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_KEY_MIN_CACHE_SIM, String.valueOf(f18435r))).doubleValue();
            f18435r = dDoubleValue;
            f18435r = Math.max(0.2d, dDoubleValue);
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f18442y = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_FIRSTLOC_RELOC, f18442y);
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            f18443z = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CAN_ALWAYS_SCAN_WIFI, f18443z);
        } catch (Throwable th5) {
            CoreUtil.reportError(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            f18410A = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_AP_WIFI_SCAN_INTERVAL, f18410A);
        } catch (Throwable th6) {
            CoreUtil.reportError(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            f18411B = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CHECK_GPSTIME_ABLE, f18411B);
            f18412C = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_CHECK_GPSTIME_OFFSET_YEAR, f18412C);
            f18417H = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_SERVER_TIME, f18417H);
        } catch (Throwable th7) {
            CoreUtil.reportError(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            f18413D = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_DNS_ABLE, f18413D);
            f18414E = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_DNS_TIME, f18414E);
            f18416G = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_KEY_DNS_HOST, f18416G);
        } catch (Throwable th8) {
            CoreUtil.reportError(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            mCarrierAble = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_CARRIER_ABLE, false);
            mCarrierMobileUpdate = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_CARRIER_MOBILE, false);
            mCarrierInterVal = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_CARRIER_INTERVAL, 2) * 3600000;
            maxUpdate = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_CARRIER_MAX, 100) * 1024;
        } catch (Throwable th9) {
            CoreUtil.reportError(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            lastRequestConfig = Utils.getTimeBoot();
            f18439v = SPUtil.getPrefsLong(context, Const.STR_PREF, Const.SP_KEY_REQUEST_AUTH_INTERVAL, f18439v);
            f18440w = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_CAN_USE_NAVI_LOC, f18440w);
            f18436s = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_KEY_GPS_GEO_ABLE, f18436s);
            f18437t = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_GPS_GEO_DIS, f18437t);
            f18438u = SPUtil.getPrefsInt(context, Const.STR_PREF, Const.SP_KEY_GPS_GEO_DELAY, f18438u);
        } catch (Throwable th10) {
            CoreUtil.reportError(th10, "AuthUtil", "loadLastAbleState p10");
        }
        C1602s0.C(context);
        try {
            String prefsStr = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_KEY_MOCK_APP_LIST, null);
            if (!TextUtils.isEmpty(prefsStr) && aMapLocationClientOption != null && aMapLocationClientOption.isMockEnable()) {
                f18441x = a(context, new JSONArray(C1604s2.m(prefsStr)));
            }
        } catch (Throwable th11) {
            CoreUtil.reportError(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean prefsBoolean = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_DEMOTION_ABLE, false);
            String prefsStr2 = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_DEMOTION_SV, "");
            String prefsStr3 = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.SP_DEMOTION_TV, "");
            if (prefsBoolean && CoreUtil.ENGINE_VERSION.equals(prefsStr2)) {
                for (String str : CoreUtil.DEMOTION_ENGINE_VERSION) {
                    if (str.equals(prefsStr3)) {
                        CoreUtil.ENGINE_VERSION = prefsStr3;
                    }
                }
            }
        } catch (Throwable th12) {
            CoreUtil.reportError(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            mLocationDisable = SPUtil.getPrefsBoolean(context, Const.STR_PREF, Const.SP_LOCATION_DISABLE, mLocationDisable);
        } catch (Throwable th13) {
            CoreUtil.reportError(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    public static boolean a(Context context, C1602s0.c cVar) {
        SharedPreferences.Editor editorStartEdit;
        try {
            editorStartEdit = SPUtil.startEdit(context, Const.STR_PREF);
        } catch (Throwable unused) {
            editorStartEdit = null;
        }
        try {
            a(cVar, editorStartEdit);
            initSDKLogHandler(context);
            JSONObject jSONObject = cVar.f16896c;
            if (jSONObject == null) {
                if (editorStartEdit != null) {
                    try {
                        SPUtil.endEdit(editorStartEdit);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            a(context, jSONObject, editorStartEdit);
            c(jSONObject, editorStartEdit);
            d(jSONObject, editorStartEdit);
            b(jSONObject, editorStartEdit);
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("15U");
                if (jSONObjectOptJSONObject != null) {
                    boolean zU = C1602s0.u(jSONObjectOptJSONObject.optString("able"), true);
                    int iOptInt = jSONObjectOptJSONObject.optInt("yn", f18412C);
                    f18417H = jSONObjectOptJSONObject.optLong(Const.JSON_KEY_SYSTIME, f18417H);
                    SPUtil.setPrefsBoolean(editorStartEdit, Const.SP_KEY_CHECK_GPSTIME_ABLE, zU);
                    SPUtil.setPrefsInt(editorStartEdit, Const.SP_KEY_CHECK_GPSTIME_OFFSET_YEAR, iOptInt);
                    SPUtil.setPrefsLong(editorStartEdit, Const.SP_KEY_SERVER_TIME, f18417H);
                }
            } catch (Throwable unused3) {
            }
            a(jSONObject, editorStartEdit);
            e(jSONObject, editorStartEdit);
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("197");
                if (jSONObject2 != null) {
                    boolean zU2 = C1602s0.u(jSONObject2.optString("able"), false);
                    SPUtil.setPrefsBoolean(editorStartEdit, Const.SP_DEMOTION_ABLE, zU2);
                    if (zU2) {
                        SPUtil.setPrefsStr(editorStartEdit, Const.SP_DEMOTION_SV, jSONObject2.optString("sv", ""));
                        SPUtil.setPrefsStr(editorStartEdit, Const.SP_DEMOTION_TV, jSONObject2.optString("tv", ""));
                    } else {
                        SPUtil.setPrefsStr(editorStartEdit, Const.SP_DEMOTION_SV, "");
                        SPUtil.setPrefsStr(editorStartEdit, Const.SP_DEMOTION_TV, "");
                    }
                }
            } catch (Throwable unused4) {
            }
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject(Const.SP_LOCATION_DISABLE);
                if (jSONObject3 != null) {
                    boolean zU3 = C1602s0.u(jSONObject3.optString("ic"), false);
                    SPUtil.setPrefsBoolean(editorStartEdit, Const.SP_LOCATION_DISABLE, zU3);
                    mLocationDisable = zU3;
                }
            } catch (Throwable unused5) {
            }
            if (editorStartEdit != null) {
                try {
                    SPUtil.endEdit(editorStartEdit);
                } catch (Throwable unused6) {
                }
            }
            return true;
        } catch (Throwable unused7) {
            if (editorStartEdit != null) {
                try {
                    SPUtil.endEdit(editorStartEdit);
                } catch (Throwable unused8) {
                }
            }
            return false;
        }
    }

    public static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("13S");
            if (jSONObjectOptJSONObject != null) {
                try {
                    long jOptInt = jSONObjectOptJSONObject.optInt("at", 123) * 60000;
                    f18439v = jOptInt;
                    SPUtil.setPrefsLong(editor, Const.SP_KEY_REQUEST_AUTH_INTERVAL, jOptInt);
                } catch (Throwable th) {
                    CoreUtil.reportError(th, "AuthUtil", "requestSdkAuthInterval");
                }
                try {
                    boolean zU = C1602s0.u(jSONObjectOptJSONObject.optString("re"), false);
                    f18442y = zU;
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_FIRSTLOC_RELOC, zU);
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "AuthUtil", "checkReLocationAble");
                }
                try {
                    boolean zU2 = C1602s0.u(jSONObjectOptJSONObject.optString("nla"), true);
                    f18440w = zU2;
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CAN_USE_NAVI_LOC, zU2);
                } catch (Throwable unused) {
                }
                try {
                    boolean zU3 = C1602s0.u(jSONObjectOptJSONObject.optString(Const.SP_KEY_CAN_ALWAYS_SCAN_WIFI), true);
                    f18443z = zU3;
                    SPUtil.setPrefsBoolean(editor, Const.SP_KEY_CAN_ALWAYS_SCAN_WIFI, zU3);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("mlpl");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && context != null) {
                        SPUtil.setPrefsStr(editor, Const.SP_KEY_MOCK_APP_LIST, C1604s2.v(jSONArrayOptJSONArray.toString()));
                        f18441x = a(context, jSONArrayOptJSONArray);
                    } else {
                        f18441x = false;
                        SPUtil.removeKeyData(editor, Const.SP_KEY_MOCK_APP_LIST);
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0 && context != null) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    if (Utils.checkInstallByPkg(context, jSONArray.getString(i10))) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean zU = C1602s0.u(jSONObject2.optString("able"), false);
                mCarrierAble = zU;
                SPUtil.setPrefsBoolean(editor, Const.SP_CARRIER_ABLE, zU);
                boolean zU2 = C1602s0.u(jSONObject2.optString("mup"), false);
                mCarrierMobileUpdate = zU2;
                SPUtil.setPrefsBoolean(editor, Const.SP_CARRIER_MOBILE, zU2);
                int iOptInt = jSONObject2.optInt("max", 20);
                if (iOptInt > 0) {
                    SPUtil.setPrefsInt(editor, Const.SP_CARRIER_MAX, iOptInt);
                    maxUpdate = iOptInt * 1024;
                }
                int iOptInt2 = jSONObject2.optInt("inv", 3);
                if (iOptInt2 > 0) {
                    SPUtil.setPrefsInt(editor, Const.SP_CARRIER_INTERVAL, iOptInt2);
                    mCarrierInterVal = iOptInt2 * 3600000;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
