package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.col.jmsl.C1541c2;
import com.amap.api.col.jmsl.C1558h;
import com.amap.api.col.jmsl.C1569j2;
import com.amap.api.col.jmsl.C1594q;
import com.amap.api.col.jmsl.X2;
import com.amap.api.col.jmsl.e3;
import com.amap.api.col.jmsl.g5;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReportUtil {
    public static final float BIGSHIFT_DIST = 30000.0f;
    public static final float BIGSHIFT_SPEED = 1000.0f;
    public static final long BIGSHIFT_VALIDTIME = 1800;
    public static final String DEX_NAME_HTTPDNS = "HttpDns";
    public static final int EXCEPTION_AIRPLANEMODE_WIFIOFF = 2132;
    public static final int EXCEPTION_CODE_BINDSERVICE = 2101;
    public static final int EXCEPTION_CODE_CGIINFOERROR = 2111;
    public static final int EXCEPTION_CODE_CONTEXTISNULL = 2011;
    public static final int EXCEPTION_CODE_CREATEAPSREQ = 2031;
    public static final int EXCEPTION_CODE_DESCRYPTRESPONSE = 2053;
    public static final int EXCEPTION_CODE_FUSION_LOC_FAIL = 2156;
    public static final int EXCEPTION_CODE_GPSORNLPUNABLE = 2155;
    public static final int EXCEPTION_CODE_INTT = 2091;
    public static final int EXCEPTION_CODE_LOCALLOC = 2081;
    public static final int EXCEPTION_CODE_MAYBEINTERCEPTED = 2052;
    public static final int EXCEPTION_CODE_MOCKGPSLOC = 2152;
    public static final int EXCEPTION_CODE_MOCKNETLOC = 2151;
    public static final int EXCEPTION_CODE_NEEDLOGINNETWORK = 2051;
    public static final int EXCEPTION_CODE_NET_LOC_FAIL = 2157;
    public static final int EXCEPTION_CODE_NOCGIANDWIFI = 2131;
    public static final int EXCEPTION_CODE_NOENOUGHSTATELLITES = 2141;
    public static final int EXCEPTION_CODE_NOLOCPERMISSION = 2121;
    public static final int EXCEPTION_CODE_NOMAINWIFIANDONLYONE = 2022;
    public static final int EXCEPTION_CODE_NOTAPSSERVICE = 2103;
    public static final int EXCEPTION_CODE_ONLYMAINWIFI = 2021;
    public static final int EXCEPTION_CODE_PARSERDATA = 2054;
    public static final int EXCEPTION_CODE_REDESC = 2062;
    public static final int EXCEPTION_CODE_RESPONSEBODYISNULL = 2041;
    public static final int EXCEPTION_CODE_RETYPE = 2061;
    public static final int EXCEPTION_CODE_SERVERAUTHCLIENSCODE = 2102;
    public static final int EXCEPTION_CODE_UNSUPPORTCOARSELBSLOC = 2153;
    public static final int EXCEPTION_CODE_UNSUPPORTCONTINUELOC = 2154;
    public static final int EXCEPTION_NOCGI_WIFIOFF = 2133;
    public static final String PATH_LOC = "/mobile/binary";
    public static final String STATICS_ID_COORDINATE = "O021";
    public static final String STATICS_ID_GEOFENCE = "O020";
    public static final String STATICS_ID_LOCATE_Error = "O018";
    public static final String STATICS_ID_LOCATE_PURPOSE = "O019";
    public static final String STATICS_ID_OFFLINECOUNT = "O023";
    public static final String STATISTICS_ID_LOCBATTING_MULITY = "O016";
    public static final String STATISTICS_ID_LOCTIME_COARSE = "O024";
    public static final String STATISTICS_ID_LOCTIME_GPS = "O015";
    public static final String STATISTICS_ID_LOCTIME_NETWORK = "O014";
    public static final String STATISTICS_ID_LOCTIME_NOTGPS = "O013";
    public static final String STATISTICS_ID_SERVICE_ALIVE_TIME = "O012";
    public static final String STATISTICS_KEY_BIGONSHIFT = "bigshiftstatistics";
    public static final String STATISTICS_KEY_DEXROLLBACK = "dexrollbackstatistics";
    public static final String STATISTICS_KEY_GPSFILTER = "gpsstatistics";
    public static final String STATISTICS_KEY_USENAVILOC = "useNaviLoc";
    public static final String STATISTICS_LOCTYPE_NET = "net";
    public static final int STATISTICS_RESULT_FAIL = 0;
    public static final int STATISTICS_RESULT_SUCCESS = 1;

    /* renamed from: b, reason: collision with root package name */
    private static List<C1558h> f18462b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static JSONArray f18463c = null;

    /* renamed from: d, reason: collision with root package name */
    static AMapLocation f18464d = null;

    /* renamed from: e, reason: collision with root package name */
    static boolean f18465e = false;
    public SparseArray<Long> sparseArray = new SparseArray<>();
    public int currentType = -1;
    public long locationStartTime = 0;

    /* renamed from: a, reason: collision with root package name */
    String[] f18466a = {Const.SP_KEY_ONCE_LOCATION, Const.SP_KEY_CONTINUE_LOCATION, Const.SP_KEY_GEOFEN_LOCATION, Const.SP_KEY_HIGHT_ACCURACY, Const.SP_KEY_BATTERY_SAVING, Const.SP_KEY_DEVICE_SENSORS};
    public int currentmode = -1;
    public long currentModeStartTime = -1;

    /* renamed from: com.autonavi.aps.amapapi.utils.ReportUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18467a;

        static {
            AMapLocationClientOption.AMapLocationMode.values();
            int[] iArr = new int[3];
            f18467a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18467a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18467a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void a(Context context, long j10, boolean z10, String str) {
        int iIntValue = Long.valueOf(j10).intValue();
        String str2 = !z10 ? "abroad" : "domestic";
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (iIntValue != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", iIntValue);
                    }
                    applyStatistics(context, str, jSONObject);
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void applyStatistics(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
            } finally {
            }
            if (AuthUtil.isUploadLog()) {
                C1558h c1558h = new C1558h(context, "loc", CoreUtil.STR_CONFIG_VERSION, str);
                if (jSONObject != null) {
                    c1558h.a(jSONObject.toString());
                }
                f18462b.add(c1558h);
                if (f18462b.size() >= 30) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(f18462b);
                    C1594q.e(arrayList, context);
                    f18462b.clear();
                }
            }
        }
    }

    public static void checkBigShift(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f18464d == null) {
                if (!Utils.locCorrect(aMapLocation)) {
                    f18464d = aMapLocation2;
                    return;
                }
                f18464d = aMapLocation.m9clone();
            }
            if (Utils.locCorrect(f18464d) && Utils.locCorrect(aMapLocation2)) {
                AMapLocation aMapLocationM9clone = aMapLocation2.m9clone();
                if (f18464d.getLocationType() != 1 && f18464d.getLocationType() != 9 && !"gps".equalsIgnoreCase(f18464d.getProvider()) && f18464d.getLocationType() != 7 && aMapLocationM9clone.getLocationType() != 1 && aMapLocationM9clone.getLocationType() != 9 && !"gps".equalsIgnoreCase(aMapLocationM9clone.getProvider()) && aMapLocationM9clone.getLocationType() != 7) {
                    long jAbs = Math.abs(aMapLocationM9clone.getTime() - f18464d.getTime()) / 1000;
                    if (jAbs <= 0) {
                        jAbs = 1;
                    }
                    if (jAbs <= BIGSHIFT_VALIDTIME) {
                        float fDist = Utils.dist(f18464d, aMapLocationM9clone);
                        float f10 = fDist / jAbs;
                        if (fDist > 30000.0f && f10 > 1000.0f) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(f18464d.getLatitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(f18464d.getLongitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(f18464d.getAccuracy());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(f18464d.getLocationType());
                            sb2.append(Const.STR_MART_COMMA);
                            if (aMapLocation.getTime() != 0) {
                                sb2.append(Utils.formatUTC(f18464d.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb2.append(f18464d.getTime());
                            }
                            sb2.append(Const.STR_MART_WELL);
                            sb2.append(aMapLocationM9clone.getLatitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(aMapLocationM9clone.getLongitude());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(aMapLocationM9clone.getAccuracy());
                            sb2.append(Const.STR_MART_COMMA);
                            sb2.append(aMapLocationM9clone.getLocationType());
                            sb2.append(Const.STR_MART_COMMA);
                            if (aMapLocationM9clone.getTime() != 0) {
                                sb2.append(Utils.formatUTC(aMapLocationM9clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb2.append(aMapLocationM9clone.getTime());
                            }
                            reportLog(STATISTICS_KEY_BIGONSHIFT, sb2.toString());
                            sb2.delete(0, sb2.length());
                        }
                    }
                }
                f18464d = aMapLocationM9clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean isDexDownloaded(Context context, C1569j2 c1569j2) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0033 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:4:0x0003, B:8:0x000b, B:26:0x0033, B:37:0x0046, B:39:0x004a, B:42:0x0055, B:44:0x005c, B:46:0x0069, B:48:0x007b, B:50:0x008e, B:53:0x009b, B:55:0x00a2, B:57:0x00b0, B:59:0x00bd, B:61:0x00cb, B:64:0x00df, B:66:0x00f1, B:51:0x0094), top: B:73:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void recordOfflineLocLog(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.ReportUtil.recordOfflineLocLog(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    public static void reportBatting(Context context, AMapLocation aMapLocation, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        String str;
        String str2;
        if (aMapLocation == null) {
            return;
        }
        try {
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider())) {
                return;
            }
            int i10 = 1;
            if (aMapLocation.getLocationType() == 1) {
                return;
            }
            if (Utils.locCorrect(aMapLocation)) {
                str = CoreUtil.isChina(aMapLocation.getLatitude(), aMapLocation.getLongitude()) ? "domestic" : "abroad";
            } else if (CoreUtil.STR_API_OUTOFCN_SERVER.equals(CoreUtil.f18445a)) {
            }
            String str3 = str;
            if (aMapLocation.getErrorCode() != 0) {
                int errorCode = aMapLocation.getErrorCode();
                if (errorCode == 11 || errorCode == 4 || errorCode == 5 || errorCode == 6) {
                    i10 = 0;
                } else {
                    i10 = 0;
                }
            } else {
                int locationType = aMapLocation.getLocationType();
                str2 = (locationType == 5 || locationType == 6) ? STATISTICS_LOCTYPE_NET : "cache";
            }
            a(context, STATISTICS_ID_LOCBATTING_MULITY, str2, str3, i10, aMapLocation.getErrorCode(), aMapLocationStaticsEntity);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "ReportUtil", "reportBatting");
        }
    }

    public static void reportCheckGPSTime(long j10, long j11) {
        try {
            if (f18465e) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime");
            stringBuffer.append(ServerSentEventKt.COLON);
            stringBuffer.append(Utils.formatUTC(j10, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(Const.JSON_KEY_SYSTIME);
            stringBuffer.append(ServerSentEventKt.COLON);
            stringBuffer.append(Utils.formatUTC(j11, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(Const.STR_MART_COMMA);
            long serTime = AuthUtil.getSerTime();
            String utc = 0 != serTime ? Utils.formatUTC(serTime, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime");
            stringBuffer.append(ServerSentEventKt.COLON);
            stringBuffer.append(utc);
            reportLog("checkgpstime", stringBuffer.toString());
            if (0 != serTime && Math.abs(j10 - serTime) < Const.YEAR_IN_MILLIS) {
                stringBuffer.append(", correctError");
                reportLog("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            f18465e = true;
        } catch (Throwable unused) {
        }
    }

    public static void reportCoarseLocUseTime(Context context, long j10, boolean z10) {
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    a(context, j10, z10, STATISTICS_ID_LOCTIME_COARSE);
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    public static void reportGPSLocUseTime(Context context, long j10, boolean z10) {
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    a(context, j10, z10, STATISTICS_ID_LOCTIME_GPS);
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    public static void reportLocError(String str, int i10) {
        String str2;
        String strValueOf = String.valueOf(i10);
        if (i10 == 2011) {
            str2 = "ContextIsNull";
        } else if (i10 == 2031) {
            str2 = "CreateApsReqException";
        } else if (i10 == 2041) {
            str2 = "ResponseResultIsNull";
        } else if (i10 == 2081) {
            str2 = "LocalLocException";
        } else if (i10 == 2091) {
            str2 = "InitException";
        } else if (i10 == 2111) {
            str2 = "ErrorCgiInfo";
        } else if (i10 == 2121) {
            str2 = "NotLocPermission";
        } else if (i10 == 2141) {
            str2 = "NoEnoughStatellites";
        } else if (i10 == 2021) {
            str2 = "OnlyMainWifi";
        } else if (i10 == 2022) {
            str2 = "OnlyOneWifiButNotMain";
        } else if (i10 == 2061) {
            str2 = "ServerRetypeError";
        } else if (i10 == 2062) {
            str2 = "ServerLocFail";
        } else if (i10 == 2156) {
            str2 = "EXCEPTION_FUSION_LOC_FAIL";
        } else if (i10 != 2157) {
            switch (i10) {
                case EXCEPTION_CODE_NEEDLOGINNETWORK /* 2051 */:
                    str2 = "NeedLoginNetWork\t";
                    break;
                case EXCEPTION_CODE_MAYBEINTERCEPTED /* 2052 */:
                    str2 = "MaybeIntercepted";
                    break;
                case EXCEPTION_CODE_DESCRYPTRESPONSE /* 2053 */:
                    str2 = "DecryptResponseException";
                    break;
                case EXCEPTION_CODE_PARSERDATA /* 2054 */:
                    str2 = "ParserDataException";
                    break;
                default:
                    switch (i10) {
                        case 2101:
                            str2 = "BindAPSServiceException";
                            break;
                        case EXCEPTION_CODE_SERVERAUTHCLIENSCODE /* 2102 */:
                            str2 = "AuthClientScodeFail";
                            break;
                        case EXCEPTION_CODE_NOTAPSSERVICE /* 2103 */:
                            str2 = "NotConfigAPSService";
                            break;
                        default:
                            switch (i10) {
                                case EXCEPTION_CODE_NOCGIANDWIFI /* 2131 */:
                                    str2 = "NoCgiOAndWifiInfo";
                                    break;
                                case EXCEPTION_AIRPLANEMODE_WIFIOFF /* 2132 */:
                                    str2 = "AirPlaneModeAndWifiOff";
                                    break;
                                case EXCEPTION_NOCGI_WIFIOFF /* 2133 */:
                                    str2 = "NoCgiAndWifiOff";
                                    break;
                                default:
                                    switch (i10) {
                                        case EXCEPTION_CODE_MOCKNETLOC /* 2151 */:
                                            str2 = "MaybeMockNetLoc";
                                            break;
                                        case EXCEPTION_CODE_MOCKGPSLOC /* 2152 */:
                                            str2 = "MaybeMockGPSLoc";
                                            break;
                                        case EXCEPTION_CODE_UNSUPPORTCOARSELBSLOC /* 2153 */:
                                            str2 = "UNSUPPORT_COARSE_LBSLOC";
                                            break;
                                        case EXCEPTION_CODE_UNSUPPORTCONTINUELOC /* 2154 */:
                                            str2 = "UNSUPPORT_CONTINUE_LOC";
                                            break;
                                        default:
                                            str2 = "";
                                            break;
                                    }
                            }
                    }
            }
        } else {
            str2 = "EXCEPTION_NET_LOC_FAIL";
        }
        reportLocError(str, strValueOf, str2);
    }

    public static void reportLog(String str, String str2) {
        try {
            C1541c2.f(CoreUtil.getSDKInfo(), str2, str);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "ReportUtil", "reportLog");
        }
    }

    public static void reportNetWorkError(String str, Throwable th) {
        try {
            if (th instanceof g5) {
                C1569j2 sDKInfo = CoreUtil.getSDKInfo();
                g5 g5Var = (g5) th;
                Set<Integer> set = C1541c2.f16546e;
                if (g5Var != null) {
                    C1541c2.g(sDKInfo, str, g5Var.k(), g5Var.i(), g5Var.f(), g5Var.j());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void reportServiceAliveTime(Context context, int i10, int i11, long j10, long j11) {
        if (i10 == -1 || i11 == -1 || context == null) {
            return;
        }
        try {
            if (AuthUtil.isUploadLog()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("param_int_first", i10);
                jSONObject.put("param_int_second", i11);
                jSONObject.put("param_long_first", j10);
                jSONObject.put("param_long_second", j11);
                applyStatistics(context, STATISTICS_ID_SERVICE_ALIVE_TIME, jSONObject);
            }
        } catch (Throwable th) {
            try {
                CoreUtil.reportError(th, "ReportUtil", "applyStatisticsEx");
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    public static synchronized void saveStatistics(Context context) {
        if (context != null) {
            try {
            } finally {
            }
            if (AuthUtil.isUploadLog()) {
                List<C1558h> list = f18462b;
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(f18462b);
                    C1594q.e(arrayList, context);
                    f18462b.clear();
                }
                a(context);
            }
        }
    }

    public void clearLocationModeAndType(Context context) {
        try {
            SharedPreferences.Editor editorStartEdit = SPUtil.startEdit(context, Const.STR_PREF1);
            int i10 = 0;
            while (true) {
                String[] strArr = this.f18466a;
                if (i10 >= strArr.length) {
                    SPUtil.endEdit(editorStartEdit);
                    return;
                } else {
                    SPUtil.setPrefsLong(editorStartEdit, strArr[i10], 0L);
                    i10++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public int getLocationMode(Context context) {
        try {
            long prefsLong = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[3], 0L);
            long prefsLong2 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[4], 0L);
            long prefsLong3 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[5], 0L);
            if (prefsLong == 0 && prefsLong2 == 0 && prefsLong3 == 0) {
                return -1;
            }
            return prefsLong > prefsLong2 ? prefsLong > prefsLong3 ? 3 : 5 : prefsLong2 > prefsLong3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public int getLocationType(Context context) {
        try {
            long prefsLong = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[2], 0L);
            long prefsLong2 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[0], 0L);
            long prefsLong3 = SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[1], 0L);
            if (prefsLong == 0 && prefsLong2 == 0 && prefsLong3 == 0) {
                return -1;
            }
            long j10 = prefsLong2 - prefsLong;
            long j11 = prefsLong3 - prefsLong;
            return prefsLong > j10 ? prefsLong > j11 ? 2 : 1 : j10 > j11 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public void saveLocationTypeAndMode(Context context) {
        try {
            long timeBoot = Utils.getTimeBoot() - this.locationStartTime;
            int i10 = this.currentType;
            if (i10 != -1) {
                this.sparseArray.append(this.currentType, Long.valueOf(timeBoot + this.sparseArray.get(i10, 0L).longValue()));
            }
            long timeBoot2 = Utils.getTimeBoot() - this.currentModeStartTime;
            int i11 = this.currentmode;
            if (i11 != -1) {
                this.sparseArray.append(this.currentmode, Long.valueOf(timeBoot2 + this.sparseArray.get(i11, 0L).longValue()));
            }
            SharedPreferences.Editor editorStartEdit = SPUtil.startEdit(context, Const.STR_PREF1);
            for (int i12 = 0; i12 < this.f18466a.length; i12++) {
                long jLongValue = this.sparseArray.get(i12, 0L).longValue();
                if (jLongValue > 0 && jLongValue > SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[i12], 0L)) {
                    SPUtil.setPrefsLong(editorStartEdit, this.f18466a[i12], jLongValue);
                }
            }
            SPUtil.endEdit(editorStartEdit);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public void setLocationMode(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int iOrdinal = aMapLocationClientOption.getLocationMode().ordinal();
            int i10 = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? -1 : 3 : 5 : 4;
            int i11 = this.currentmode;
            if (i11 == i10) {
                return;
            }
            if (i11 != -1 && i11 != i10) {
                this.sparseArray.append(this.currentmode, Long.valueOf((Utils.getTimeBoot() - this.currentModeStartTime) + this.sparseArray.get(this.currentmode, 0L).longValue()));
            }
            this.currentModeStartTime = Utils.getTimeBoot() - SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[i10], 0L);
            this.currentmode = i10;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "ReportUtil", "setLocationMode");
        }
    }

    public void setLocationType(Context context, int i10) {
        try {
            int i11 = this.currentType;
            if (i11 == i10) {
                return;
            }
            if (i11 != -1 && i11 != i10) {
                this.sparseArray.append(this.currentType, Long.valueOf((Utils.getTimeBoot() - this.locationStartTime) + this.sparseArray.get(this.currentType, 0L).longValue()));
            }
            this.locationStartTime = Utils.getTimeBoot() - SPUtil.getPrefsLong(context, Const.STR_PREF1, this.f18466a[i10], 0L);
            this.currentType = i10;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "ReportUtil", "setLocationType");
        }
    }

    public static void reportLocError(String str, String str2, String str3) {
        try {
            C1541c2.g(CoreUtil.getSDKInfo(), PATH_LOC, str3, str, "", str2);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str, String str2, String str3, int i10, int i11, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (context != null) {
            try {
                if (AuthUtil.isUploadLog()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i10 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i10);
                    }
                    if (i11 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i11);
                    }
                    if (aMapLocationStaticsEntity != null) {
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getDNSStaus())) {
                            jSONObject.put("dns", aMapLocationStaticsEntity.getDNSStaus());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getDominStatus())) {
                            jSONObject.put("domain", aMapLocationStaticsEntity.getDominStatus());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getLocationType())) {
                            jSONObject.put("type", aMapLocationStaticsEntity.getLocationType());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getReason())) {
                            jSONObject.put("reason", aMapLocationStaticsEntity.getReason());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getIP())) {
                            jSONObject.put("ip", aMapLocationStaticsEntity.getIP());
                        }
                        if (!TextUtils.isEmpty(aMapLocationStaticsEntity.getStackType())) {
                            jSONObject.put("stack", aMapLocationStaticsEntity.getStackType());
                        }
                        if (aMapLocationStaticsEntity.getContinueTime() > 0) {
                            jSONObject.put("ctime", String.valueOf(aMapLocationStaticsEntity.getContinueTime()));
                        }
                        if (aMapLocationStaticsEntity.getNetUseTime() > 0) {
                            jSONObject.put("ntime", String.valueOf(aMapLocationStaticsEntity.getNetUseTime()));
                        }
                    }
                    applyStatistics(context, str, jSONObject);
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context) {
        try {
            JSONArray jSONArray = f18463c;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            e3.e(new X2(context, CoreUtil.getSDKInfo(), f18463c.toString()), context);
            f18463c = null;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "ReportUtil", "writeOfflineLocLog");
        }
    }
}
