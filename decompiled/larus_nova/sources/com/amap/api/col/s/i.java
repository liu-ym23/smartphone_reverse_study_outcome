package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class i {
    public static String a(LatLonPoint r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return a(r100.getLongitude()) + "," + a(r100.getLatitude());
    }

    public static void b(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L25
        if (r101.has("errcode") == false) goto L8;
        a(JSONObjectProtectorUtils.getInt(r101, "errcode"), JSONObjectProtectorUtils.getString(r101, ITTReaderViewWrapper.ERROR_MSG_KEY));     // Catch: JSONException -> L25
        return;
    L8:
        if (r101.has("status") == true) goto L10;
        return;
    L10:
        String r102 = JSONObjectProtectorUtils.getString(r101, "status");     // Catch: JSONException -> L25
        if (r102.equals("1") == false) goto L15;
        return;
    L15:
        if (r102.equals("0") == true) goto L17;
    L21:
        int r103 = JSONObjectProtectorUtils.getInt(r101, "infocode");     // Catch: JSONException -> L25
        if (r102.equals("0") == false) goto L29;
        a(r103, JSONObjectProtectorUtils.getString(r101, "info"));     // Catch: JSONException -> L25
        return;
    L29:
        return;
    L17:
        if (r101.has("infocode") == true) goto L21;
        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        a(e, "CoreUtil", "paseAuthFailurJson");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static void c(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L22
        if (r101.has("errcode") == false) goto L8;
        a(JSONObjectProtectorUtils.getInt(r101, "errcode"), JSONObjectProtectorUtils.getString(r101, ITTReaderViewWrapper.ERROR_MSG_KEY));     // Catch: JSONException -> L22
        return;
    L8:
        if (r101.has("status") == true) goto L11;
        return;
    L11:
        if (r101.optInt("status") == 0) goto L13;
    L17:
        int r102 = r101.optInt("code");     // Catch: JSONException -> L22
        if (r102 != 0) goto L20;
        return;
    L20:
        String r103 = r101.optString("message");     // Catch: JSONException -> L22
        throw new AMapException(r103, 2, r103, CastIntegerProtector.parseInt("1".concat(String.valueOf(r102))));     // Catch: JSONException -> L22
    L13:
        if (r101.has("infocode") == false) goto L16;
        a(JSONObjectProtectorUtils.getInt(r101, "infocode"), JSONObjectProtectorUtils.getString(r101, "info"));     // Catch: JSONException -> L22
        goto L17
    L16:
        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        a(e, "CoreUtil", "paseAuthFailurJson");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static Date d(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.trim().equals("") == false) goto L13;
        return null;
    L13:
        return new SimpleDateFormat("HHmm").parse(r100);
    L10:
        e = move-exception;
        a(e, "CoreUtil", "parseString2Time");
        return null;
    }

    public static Date e(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.trim().equals("") == false) goto L13;
        return null;
    L13:
        return new SimpleDateFormat("HH:mm").parse(r100);
    L10:
        e = move-exception;
        a(e, "CoreUtil", "parseTime");
        return null;
    }

    public static double a(double r100) {
        return CastDoubleProtector.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(r100));
    }

    public static String a(Date r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("HH:mm");
        if (r100 != null) goto L5;
        return "";
    L5:
        return r101.format(r100);
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.trim().length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static String a(List<LatLonPoint> r100) {
        return a(r100, com.alipay.sdk.m.u.i.f25853b);
    }

    private static void a(int r100, String r101) throws AMapException, JSONException {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (r100 == 22000) goto L82;
        if (r100 == 32200) goto L80;
        if (r100 == 32201) goto L78;
        switch(r100) {
            case 10000: goto L84;
            case 10001: goto L76;
            case 10002: goto L74;
            case 10003: goto L72;
            case 10004: goto L70;
            case 10005: goto L68;
            case 10006: goto L66;
            case 10007: goto L64;
            case 10008: goto L62;
            case 10009: goto L60;
            case 10010: goto L58;
            case 10011: goto L56;
            case 10012: goto L54;
            case 10013: goto L52;
            default: goto L10;
        };
    L10:
        switch(r100) {
            case 20000: goto L50;
            case 20001: goto L48;
            case 20002: goto L46;
            case 20003: goto L44;
            default: goto L11;
        };
    L11:
        switch(r100) {
            case 20800: goto L42;
            case 20801: goto L40;
            case 20802: goto L38;
            case 20803: goto L36;
            default: goto L12;
        };
    L12:
        switch(r100) {
            case 30000: goto L34;
            case 30001: goto L32;
            case 30002: goto L30;
            case 30003: goto L28;
            default: goto L13;
        };
    L13:
        switch(r100) {
            case 32000: goto L26;
            case 32001: goto L24;
            case 32002: goto L22;
            default: goto L15;
        };
    L15:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        if (r100 <= 0) goto L20;
        throw new AMapException(r101, 2, r101, r100);
    L20:
        throw new AMapException(r101, 2, r101);
    L22:
        throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, r101);
    L24:
        throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, r101);
    L26:
        throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, r101);
    L28:
        throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, r101);
    L30:
        throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, r101);
    L32:
        throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, r101);
    L34:
        throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, r101);
    L36:
        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, r101);
    L38:
        throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, r101);
    L40:
        throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, r101);
    L42:
        throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, r101);
    L44:
        throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, r101);
    L46:
        throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, r101);
    L48:
        throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, r101);
    L50:
        throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, r101);
    L84:
        return;
    L52:
        throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, r101);
    L54:
        throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, r101);
    L56:
        throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, r101);
    L58:
        throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, r101);
    L60:
        throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, r101);
    L62:
        throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, r101);
    L64:
        throw new AMapException("用户签名未通过", 2, r101);
    L66:
        throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, r101);
    L68:
        throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, r101);
    L70:
        throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, r101);
    L72:
        throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, r101);
    L74:
        throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, r101);
    L76:
        throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, r101);
    L78:
        throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, r101);
    L80:
        throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, r101);
    L82:
        throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, r101);
    }

    public static float a(LatLonPoint r110, LatLonPoint r210) {
        if (r110 == null) goto L11;
        if (r210 == null) goto L11;
        double r100 = r110.getLongitude();     // Catch: Throwable -> L9
        double r101 = r110.getLatitude();     // Catch: Throwable -> L9
        double r102 = r100 * 0.01745329251994329d;     // Catch: Throwable -> L9
        double r103 = r101 * 0.01745329251994329d;     // Catch: Throwable -> L9
        double r104 = r210.getLongitude() * 0.01745329251994329d;     // Catch: Throwable -> L9
        double r105 = r210.getLatitude() * 0.01745329251994329d;     // Catch: Throwable -> L9
        double r111 = Math.sin(r102);     // Catch: Throwable -> L9
        double r112 = Math.sin(r103);     // Catch: Throwable -> L9
        double r106 = Math.cos(r102);     // Catch: Throwable -> L9
        double r107 = Math.cos(r103);     // Catch: Throwable -> L9
        double r113 = Math.sin(r104);     // Catch: Throwable -> L9
        double r114 = Math.sin(r105);     // Catch: Throwable -> L9
        double r108 = Math.cos(r104);     // Catch: Throwable -> L9
        double r109 = Math.cos(r105);     // Catch: Throwable -> L9
        double[] r115 = {r106 * r107, r107 * r111, r112};     // Catch: Throwable -> L9
        double r116 = r108 * r109;     // Catch: Throwable -> L9
        double r117 = r109 * r113;     // Catch: Throwable -> L9
        double r118 = r115[0];     // Catch: Throwable -> L9
        double r119 = (r118 - r116) * (r118 - r116);     // Catch: Throwable -> L9
        double r120 = r115[1];     // Catch: Throwable -> L9
        double r121 = r115[2];     // Catch: Throwable -> L9
        return (float) (Math.asin(Math.sqrt((r119 + ((r120 - r117) * (r120 - r117))) + ((r121 - r114) * (r121 - r114))) / 2.0d) * 1.27420015798544E7d);
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        return 0.0f;
    }

    public static String a(List<LatLonPoint> r100, String r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L7:
        if (r103 >= r100.size()) goto L12;
        LatLonPoint r104 = (LatLonPoint) ListProtector.get(r100, r103);
        if (r104 == null) goto L11;
        double r105 = a(r104.getLongitude());
        double r106 = a(r104.getLatitude());
        r102.append(r105);
        r102.append(",");
        r102.append(r106);
        r102.append(r101);
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        r102.deleteCharAt(r102.length() - 1);
        return r102.toString();
    }

    public static void a(Throwable r100, String r101, String r102) {
        cg r103 = cg.d();     // Catch: Throwable -> L7
        if (r103 == null) goto L5;
        r103.b(r100, r101, r102);     // Catch: Throwable -> L7
    L5:
        r100.printStackTrace();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
