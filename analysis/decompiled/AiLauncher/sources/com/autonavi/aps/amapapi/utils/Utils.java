package com.autonavi.aps.amapapi.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.col.jmsl.C1562i;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.C1568j1;
import com.amap.api.col.jmsl.C1604s2;
import com.amap.api.col.jmsl.S0;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.Aps;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f18470a;

    /* renamed from: b, reason: collision with root package name */
    static WifiManager f18471b;

    /* renamed from: c, reason: collision with root package name */
    private static String f18472c;

    private Utils() {
    }

    private static boolean a(Context context, String str) throws Throwable {
        return ((Integer) Reflect.invokeStaticMethod(str, "getInt", new Object[]{context.getContentResolver(), ((String) Reflect.getStaticProp(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static boolean airPlaneModeOn(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return getSdk() < 17 ? a(context, "android.provider.Settings$System") : a(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int amapErrorCode2OpenErrorCode(String str, int i10) {
        if (TextUtils.equals(str, Const.OPEN_ERROR_CAUSE)) {
            return i10;
        }
        if (TextUtils.equals(str, Const.NETLOC_FAIL_CAUSE)) {
            switch (i10) {
                case -13:
                    return 12;
                case -12:
                    return 20;
                case -11:
                    return 18;
                default:
                    switch (i10) {
                        case 0:
                            return 8;
                        case 1:
                            return 2;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 8:
                            return 4;
                        case 7:
                            return 6;
                        default:
                            return 0;
                    }
            }
        }
        if (!TextUtils.equals(str, Const.SIGNAL_WEAK_CAUSE)) {
            return 0;
        }
        if (i10 == 40 || i10 == 41 || i10 == -3) {
            return 14;
        }
        if (i10 == -2 || i10 == -1) {
            return 12;
        }
        if (i10 == 0 || i10 == 1) {
            return 14;
        }
        switch (i10) {
            case 11:
            case 12:
            case 13:
            case 14:
                return 14;
            default:
                switch (i10) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        return 14;
                    default:
                        switch (i10) {
                            case 30:
                                return 8;
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                                return 14;
                            default:
                                return 0;
                        }
                }
        }
    }

    public static int asu2Dbm(int i10) {
        return (i10 * 2) + Const.I_DEF_CGI_SIG;
    }

    private static boolean b(Context context) {
        try {
            int i10 = context.getApplicationInfo().targetSdkVersion;
            return false;
        } catch (Throwable unused) {
            DebugUtils.writeCat("tv e", false);
            return false;
        }
    }

    public static int ba2IntB(byte[] bArr) {
        int length = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            length |= (bArr[i10] & 255) << (((bArr.length - 1) - i10) * 8);
        }
        return length;
    }

    public static int ba2IntL(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            i10 |= (bArr[i11] & 255) << (i11 * 8);
        }
        return i10;
    }

    public static String ba2hex(byte[] bArr) {
        return C1604s2.d(bArr);
    }

    public static String base642Str(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "base642Str");
            return null;
        }
    }

    public static byte[] byteReverse(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = 0;
        for (int i10 = 1; i10 <= bArr.length; i10++) {
            bArr2[i10] = bArr[bArr.length - i10];
        }
        return bArr2;
    }

    public static final int bytesToInt(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            i10 = (i10 << 8) | (bArr[i11] & 255);
        }
        return i10;
    }

    public static final long bytesToLong(byte[] bArr) {
        long j10 = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            j10 = (j10 << 8) | (bArr[i10] & 255);
        }
        return j10;
    }

    public static final int bytesToUnsignedShort(byte[] bArr) {
        return (bArr[1] & 255) | ((bArr[0] & 255) << 8);
    }

    public static boolean checkBackGroundLocPerm(Context context) {
        int iInvokeIntMethod;
        if (context.getApplicationInfo().targetSdkVersion >= 29) {
            try {
                iInvokeIntMethod = Reflect.invokeIntMethod(((Application) context).getBaseContext(), "checkSelfPermission", Aps.locBackGroundPermissions);
            } catch (Throwable unused) {
                iInvokeIntMethod = 0;
            }
            if (iInvokeIntMethod != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDirExists(String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory() && file2.getName().equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkInstallByPkg(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean checkLoc(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static boolean checkLocPerm(Context context) {
        int iInvokeIntMethod;
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : Aps.locPermissions) {
                try {
                    iInvokeIntMethod = Reflect.invokeIntMethod(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    iInvokeIntMethod = 0;
                }
                if (iInvokeIntMethod != 0) {
                    return false;
                }
            }
        } else {
            for (String str2 : Aps.locPermissions) {
                if (context.checkCallingOrSelfPermission(str2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte[] copyOf(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11 - i10];
        System.arraycopy(bArr, i10, bArr2, 0, Math.min(i11, bArr.length) - i10);
        return bArr2;
    }

    public static void delDir(String str) {
        try {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        delDir(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static float dist(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static String encodeLicense() {
        try {
            return C1568j1.g(CoreUtil.AMAP_LICENSE.getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean extMemAvl() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static double fmatCoordinates(double d10) {
        return formatDoubleKeep6Point(d10);
    }

    public static double formatDoubleKeep2Point(double d10) {
        return ((long) (d10 * 100.0d)) / 100.0d;
    }

    public static double formatDoubleKeep6Point(double d10) {
        return ((long) (d10 * 1000000.0d)) / 1000000.0d;
    }

    public static float formatFloatKeep2Point(float f10) {
        return (float) (((long) (f10 * 100.0d)) / 100.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String formatUTC(long r3, java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L8
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
        L8:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L15
            java.util.Locale r1 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L15
            r0.<init>(r5, r1)     // Catch: java.lang.Throwable -> L15
            r0.applyPattern(r5)     // Catch: java.lang.Throwable -> L13
            goto L1e
        L13:
            r5 = move-exception
            goto L17
        L15:
            r5 = move-exception
            r0 = 0
        L17:
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r5, r1, r2)
        L1e:
            r1 = 0
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L28
            long r3 = getTime()
        L28:
            if (r0 != 0) goto L2d
            java.lang.String r3 = "NULL"
            goto L35
        L2d:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r0.format(r3)
        L35:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.formatUTC(long, java.lang.String):java.lang.String");
    }

    public static byte[] get2BaFromInt(int i10, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i10 & 255);
        bArr[1] = (byte) ((i10 & 65280) >> 8);
        return bArr;
    }

    public static byte[] get2BaFromStr(String str, byte[] bArr) {
        return get2BaFromInt(parseInt(str), bArr);
    }

    public static byte[] get4BaFromInt(int i10, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) ((i10 >> (i11 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] get4BaFromStr(String str, byte[] bArr) {
        return get4BaFromInt(parseInt(str), bArr);
    }

    public static byte[] get6BaFromMac(String str) {
        byte[] bArr = new byte[6];
        String[] strArrSplit = str.split(ServerSentEventKt.COLON);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            bArr[i10] = (byte) parseInt(strArrSplit[i10], 16);
        }
        return bArr;
    }

    public static byte[] get8BaFromLong(long j10) {
        byte[] bArr = new byte[8];
        for (int i10 = 0; i10 < 8; i10++) {
            bArr[i10] = (byte) ((j10 >> (i10 * 8)) & 255);
        }
        return bArr;
    }

    public static String getAppName(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(CoreUtil.strAppname)) {
            return CoreUtil.strAppname;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(C1567j0.p(context), 64);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(CoreUtil.strAppSha1)) {
                CoreUtil.strAppSha1 = null;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Utils", "getAppName");
        }
        StringBuilder sb2 = new StringBuilder();
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            CharSequence charSequenceLoadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
            if (charSequenceLoadLabel != null) {
                sb2.append(charSequenceLoadLabel.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb2.append(packageInfo.versionName);
            }
        }
        String strP = C1567j0.p(context);
        if (!TextUtils.isEmpty(strP)) {
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(strP);
        }
        if (!TextUtils.isEmpty(CoreUtil.strAppSha1)) {
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(CoreUtil.strAppSha1);
        }
        String string = sb2.toString();
        CoreUtil.strAppname = string;
        return string;
    }

    public static String getDeviceMac(Context context) {
        String strK = S0.k();
        if (TextUtils.isEmpty(strK) || strK.equals(Const.STR_DEF_SMAC)) {
            strK = SPUtil.getSmac(context);
        }
        return TextUtils.isEmpty(strK) ? Const.STR_DEF_SMAC : strK;
    }

    public static boolean getHUAWEICoarseSwitch(Context context) {
        if (context != null) {
            try {
                try {
                    if (context.checkSelfPermission(Const.HUAWEI_APPROXIMATELY_PERMISSION) == 0) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                DebugUtils.writeCat("hwcs e", false);
            }
        }
        return false;
    }

    public static String getLocDetail(int i10) {
        if (i10 == 0) {
            return "success";
        }
        if (i10 == 2) {
            return C1562i.a("O105493_13");
        }
        if (i10 == 33) {
            return C1562i.a("O105493_19");
        }
        switch (i10) {
            case 10:
                return C1562i.a("O105493_09");
            case 11:
                return "get cgi failure#1101";
            case 12:
                return C1562i.a("O105493_14");
            case 13:
                return C1562i.a("O105493_15");
            case 14:
                return C1562i.a("O105493_16");
            case 15:
                return "networkLocation has been mocked!#1502";
            default:
                switch (i10) {
                    case 18:
                        return C1562i.a("O105493_17") + "#1801";
                    case 19:
                        return C1562i.a("O105493_18");
                    case 20:
                        return C1562i.a("O105493_20");
                    default:
                        return "";
                }
        }
    }

    public static String getLocErrorInfo(String str, int i10) {
        if (TextUtils.equals(str, Const.NETLOC_FAIL_CAUSE)) {
            switch (i10) {
                case -13:
                    return "定位开关未开启";
                case -12:
                    return "定位权限Coarse未开启";
                case -11:
                    return "飞行模式";
                default:
                    switch (i10) {
                        case 0:
                            return AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
                        case 1:
                            return "指纹不足";
                        case 2:
                            return "客户端限流";
                        case 3:
                            return "服务端限流";
                        case 4:
                            return "请求间隔过快";
                        case 5:
                            return "在线定位-网络异常";
                        case 6:
                            return "在线定位-请求超时";
                        case 7:
                            return "在线定位-定位无效";
                        case 8:
                            return "在线定位-服务返回失败";
                        default:
                            return "其他错误";
                    }
            }
        }
        if (!TextUtils.equals(str, Const.SIGNAL_WEAK_CAUSE)) {
            return "其他错误";
        }
        if (i10 == 40 || i10 == 41) {
            return "卫星信号弱";
        }
        if (i10 == -3 || i10 == -2 || i10 == -1) {
            return "无卫星信号";
        }
        if (i10 == 0) {
            return "卫星信号弱";
        }
        if (i10 == 1) {
            return "卫星信号正常";
        }
        switch (i10) {
            case 11:
                return "疑似卫星信号被遮挡";
            case 12:
            case 13:
                return "卫星信号受到干扰";
            case 14:
                return "卫星信号被遮挡";
            default:
                switch (i10) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        return "卫星信号被遮挡";
                    default:
                        switch (i10) {
                            case 30:
                                return "疑似系统异常";
                            case 31:
                                return "系统异常";
                            case 32:
                            case 33:
                            case 34:
                                return "卫星信号弱";
                            default:
                                return "其他错误";
                        }
                }
        }
    }

    public static String[] getMccMnc(TelephonyManager telephonyManager) {
        int i10;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i11 = 0;
            while (i11 < charArray.length && Character.isDigit(charArray[i11])) {
                i11++;
            }
            strArr2[1] = networkOperator.substring(3, i11 + 3);
        }
        try {
            i10 = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "getMccMnc");
            i10 = 0;
        }
        if (i10 == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = f18470a) != null) ? strArr : strArr2;
        }
        f18470a = strArr2;
        return strArr2;
    }

    public static String getNetMode(Context context, ConnectivityManager connectivityManager) {
        int subtype = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    subtype = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused) {
            }
        }
        switch (subtype) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static int getNetT(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        try {
            return S0.x(context);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static String getNetWorkTypeStr(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo == null || !netWorkInfo.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = netWorkInfo.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = netWorkInfo.getSubtypeName();
        switch (netWorkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                return "GSM".equalsIgnoreCase(subtypeName) ? "2G" : ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
        }
    }

    public static String getPackageNameMD5(Context context) {
        if (f18472c == null) {
            f18472c = Encrypt.encode("MD5", C1567j0.p(context));
        }
        return f18472c;
    }

    public static int getSdk() {
        try {
            try {
                return Reflect.getStaticIntProp("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return 0;
            }
        } catch (Throwable unused2) {
            return Integer.parseInt(Reflect.getStaticProp("android.os.Build$VERSION", "SDK").toString());
        }
    }

    public static Object getServ(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "getServ");
            return null;
        }
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }

    public static long getTimeBoot() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean getVIVOCoarseSwitch(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = r8.getPackageName()     // Catch: java.lang.Throwable -> L40
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = "content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = "package_name"
            java.lang.String r4 = "selected_fuzzy"
            java.lang.String[] r4 = new java.lang.String[]{r8, r4}     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "package_name=?"
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L40
            r7 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L40
            r1 = r0
        L23:
            if (r8 == 0) goto L3a
            boolean r2 = r8.moveToNext()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3a
            java.lang.String r2 = r8.getString(r0)     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L23
            r2 = 1
            int r3 = r8.getInt(r2)     // Catch: java.lang.Throwable -> L42
            if (r3 != r2) goto L23
            r1 = r2
            goto L23
        L3a:
            if (r8 == 0) goto L3f
            r8.close()
        L3f:
            return r1
        L40:
            r8 = 0
            r1 = r0
        L42:
            java.lang.String r2 = "vvcs e"
            com.autonavi.aps.amapapi.utils.DebugUtils.writeCat(r2, r0)     // Catch: java.lang.Throwable -> L4d
            if (r8 == 0) goto L50
        L49:
            r8.close()
            goto L50
        L4d:
            if (r8 == 0) goto L50
            goto L49
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.getVIVOCoarseSwitch(android.content.Context):boolean");
    }

    public static ArrayList<String> getWifiListFromStrNb(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split(Const.STR_MART_WELL);
            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                if (strArrSplit[i10].contains(",nb") || strArrSplit[i10].contains(",access")) {
                    arrayList.add(strArrSplit[i10]);
                }
            }
        }
        return arrayList;
    }

    public static byte[] gz(byte[] bArr) {
        return C1604s2.u(bArr);
    }

    public static boolean hasPerminssion(Context context, String str) {
        if (context != null) {
            try {
                if (context.checkSelfPermission(C1604s2.m(str)) == 0) {
                    return true;
                }
            } catch (Throwable unused) {
                DebugUtils.writeCat("hasPerm err", false);
            }
        }
        return false;
    }

    public static boolean isAppInstalled(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static boolean isCoarsePermOpen(Context context) {
        try {
            if (a(context)) {
                return true;
            }
            if (a(Const.BRAND_VIVO) && b(context) && getVIVOCoarseSwitch(context)) {
                return true;
            }
            if (a(Const.BRAND_HUAWEI) && b(context)) {
                if (getHUAWEICoarseSwitch(context)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            DebugUtils.writeCat("icpo e", false);
            return false;
        }
    }

    public static boolean isGpsMock(Location location, int i10) {
        boolean zIsFromMockProvider;
        Bundle extras;
        try {
            zIsFromMockProvider = location.isFromMockProvider();
        } catch (Throwable unused) {
            zIsFromMockProvider = false;
        }
        if (zIsFromMockProvider) {
            return true;
        }
        try {
            extras = location.getExtras();
        } catch (Throwable unused2) {
        }
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        if (i10 == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f) {
            if (location.getSpeed() == 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHadApsService(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static boolean isNetworkAvaliable(Context context) {
        try {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            if (netWorkInfo != null) {
                if (netWorkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isSameDay(long j10, long j11) {
        String utc = formatUTC(j10, "yyyyMMdd");
        String utc2 = formatUTC(j11, "yyyyMMdd");
        if ("NULL".equals(utc) || "NULL".equals(utc2)) {
            return false;
        }
        return utc.equals(utc2);
    }

    public static boolean isSameDayAndPart(long j10, long j11) {
        if (!isSameDay(j10, j11)) {
            return false;
        }
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTimeInMillis(j10);
        int i10 = calendar.get(11);
        calendar.setTimeInMillis(j11);
        int i11 = calendar.get(11);
        if (i10 > 12) {
            if (i11 > 12) {
                return true;
            }
        } else if (i11 <= 12) {
            return true;
        }
        return false;
    }

    public static boolean isSameHour(long j10, long j11) {
        String utc = formatUTC(j10, "yyyyMMddHH");
        String utc2 = formatUTC(j11, "yyyyMMddHH");
        if ("NULL".equals(utc) || "NULL".equals(utc2)) {
            return false;
        }
        return utc.equals(utc2);
    }

    public static boolean isTargetAndroidP(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static String isVIVOOverSea(Context context) {
        try {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, "ro.vivo.product.overseas");
            } catch (Throwable unused) {
                DebugUtils.writeCat("vvos", false);
                return "no";
            }
        } catch (Throwable unused2) {
            return "no";
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean isWifiAble(Context context) {
        boolean z10;
        boolean zIsWifiEnabled;
        if (context == null) {
            return true;
        }
        if (f18471b == null) {
            f18471b = (WifiManager) getServ(context, "wifi");
        }
        try {
            if (hasPerminssion(context, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                zIsWifiEnabled = f18471b.isWifiEnabled();
            } else {
                CoreUtil.reportError(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                zIsWifiEnabled = false;
            }
        } catch (Throwable th) {
            th = th;
            z10 = false;
        }
        try {
            DebugUtils.writeCat("iwfal = " + zIsWifiEnabled, false);
        } catch (Throwable th2) {
            z10 = zIsWifiEnabled;
            th = th2;
            DebugUtils.printE(th);
            zIsWifiEnabled = z10;
            return zIsWifiEnabled ? zIsWifiEnabled : zIsWifiEnabled;
        }
        if (zIsWifiEnabled && getSdk() > 17) {
            try {
                return "true".equals(String.valueOf(Reflect.invokeMethod(f18471b, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused) {
                return zIsWifiEnabled;
            }
        }
    }

    public static boolean joHasK(JSONObject jSONObject, String str) {
        return C1604s2.j(jSONObject, str);
    }

    public static boolean locCorrect(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer == null || "8".equals(aMapLocationServer.getRetype()) || UxipConstants.EVENT_UPLOAD_MIN_VERSION.equals(aMapLocationServer.getRetype()) || "6".equals(aMapLocationServer.getRetype())) {
            return false;
        }
        return checkLoc(aMapLocationServer);
    }

    public static boolean nbWifiSimiMem(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> wifiListFromStrNb = getWifiListFromStrNb(str);
            String[] strArrSplit = str2.toString().split(Const.STR_MART_WELL);
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < strArrSplit.length; i12++) {
                if (strArrSplit[i12].contains(",nb") || strArrSplit[i12].contains(",access")) {
                    i11++;
                    if (wifiListFromStrNb.contains(strArrSplit[i12])) {
                        i10++;
                    }
                }
            }
            if (i10 * 2 >= (wifiListFromStrNb.size() + i11) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static byte parseByte(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static double parseDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static float parseFloat(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int parseInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static int randomInt(int i10, int i11) {
        return new Random().nextInt((i11 - i10) + 1) + i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[Catch: IOException -> 0x003b, TryCatch #4 {IOException -> 0x003b, blocks: (B:18:0x0037, B:22:0x003f, B:24:0x0044), top: B:38:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044 A[Catch: IOException -> 0x003b, TRY_LEAVE, TryCatch #4 {IOException -> 0x003b, blocks: (B:18:0x0037, B:22:0x003f, B:24:0x0044), top: B:38:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> readLines(java.io.File r4) throws java.io.IOException {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r4 = a(r4)     // Catch: java.lang.Throwable -> L33
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L34
            java.nio.charset.Charset r3 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.Throwable -> L34
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L34
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L35
        L18:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L22
            r0.add(r1)     // Catch: java.lang.Throwable -> L31
            goto L18
        L22:
            r3.close()     // Catch: java.io.IOException -> L2c
            r2.close()     // Catch: java.io.IOException -> L2c
            r4.close()     // Catch: java.io.IOException -> L2c
            return r0
        L2c:
            r4 = move-exception
            r4.printStackTrace()
            goto L4b
        L31:
            r1 = r3
            goto L35
        L33:
            r4 = r1
        L34:
            r2 = r1
        L35:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L3d
        L3b:
            r4 = move-exception
            goto L48
        L3d:
            if (r2 == 0) goto L42
            r2.close()     // Catch: java.io.IOException -> L3b
        L42:
            if (r4 == 0) goto L4b
            r4.close()     // Catch: java.io.IOException -> L3b
            goto L4b
        L48:
            r4.printStackTrace()
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.Utils.readLines(java.io.File):java.util.List");
    }

    public static String str2Base64(String str) {
        return str2Base64(str, 0);
    }

    public static boolean tableExisted(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery;
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplace = Const.STR_VER.replace(".", "");
        if (sQLiteDatabase != null) {
            boolean z11 = true;
            try {
            } catch (Throwable unused) {
                cursorQuery = null;
            }
            if (sQLiteDatabase.isOpen()) {
                cursorQuery = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + strReplace + "'", null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            if (cursorQuery.getInt(0) > 0) {
                                z10 = true;
                            }
                        }
                    } catch (Throwable unused2) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return z11;
                    }
                }
                if (cursorQuery == null) {
                    return z10;
                }
                z11 = z10;
                cursorQuery.close();
                return z11;
            }
        }
        return false;
    }

    public static void unZip(String str, String str2) {
        Throwable th;
        File file;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        String name;
        ZipInputStream zipInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                file = new File(str);
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (file.exists() && !file.isDirectory()) {
            String str3 = File.separator;
            if (!str2.endsWith(str3)) {
                str2 = str2 + str3;
            }
            ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(file));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    try {
                        bArr = new byte[1024];
                        name = nextEntry.getName();
                    } catch (Exception unused2) {
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    if (TextUtils.isEmpty(name) || name.contains("../")) {
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        File file2 = new File(str2 + name);
                        File file3 = new File(file2.getParent());
                        if (!file3.exists()) {
                            file3.mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file2);
                        while (true) {
                            try {
                                int i10 = zipInputStream2.read(bArr, 0, 1024);
                                if (i10 == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i10);
                                }
                            } catch (Exception unused3) {
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                throw th;
                            }
                        }
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = zipInputStream2;
                    try {
                        CoreUtil.reportError(th, "Utils", "unZip");
                        if (zipInputStream != null) {
                            zipInputStream.closeEntry();
                            zipInputStream2 = zipInputStream;
                            zipInputStream2.close();
                        }
                        return;
                    } catch (Throwable th6) {
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.closeEntry();
                                zipInputStream.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        throw th6;
                    }
                }
            }
            zipInputStream2.closeEntry();
            zipInputStream2.close();
        }
    }

    public static byte[] ungz(byte[] bArr) {
        byte[] bArr2 = new byte[10240];
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            DataInputStream dataInputStream = new DataInputStream(gZIPInputStream);
            int i10 = 0;
            while (true) {
                int i11 = dataInputStream.read(bArr2, i10, i10 + 2048);
                if (i11 == -1) {
                    byte[] bArr3 = new byte[i10];
                    System.arraycopy(bArr2, 0, bArr3, 0, i10);
                    dataInputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return bArr3;
                }
                i10 += i11;
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "ungz");
            return null;
        }
    }

    public static boolean wifiUseful(String str) {
        return (TextUtils.isEmpty(str) || Const.STR_DEF_SMAC.equals(str) || Const.STR_DEF_NOPERM_SMAC.equals(str) || str.contains(" :")) ? false : true;
    }

    public static void writeStringToFile(File file, String str, boolean z10) throws IOException {
        FileOutputStream fileOutputStreamA = null;
        try {
            try {
                try {
                    fileOutputStreamA = a(file, z10);
                    if (str != null) {
                        fileOutputStreamA.write(str.getBytes());
                    }
                    fileOutputStreamA.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                    if (fileOutputStreamA != null) {
                        fileOutputStreamA.close();
                    }
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } catch (Throwable th) {
            if (fileOutputStreamA != null) {
                try {
                    fileOutputStreamA.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static int parseInt(String str, int i10) throws NumberFormatException {
        return Integer.parseInt(str, i10);
    }

    public static String str2Base64(String str, int i10) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Utils", "str2Base64");
            bytes = null;
        }
        return Base64.encodeToString(bytes, i10);
    }

    public static String getLocErrorInfo(int i10) {
        String strA = C1562i.a("O105493_21");
        if (i10 != 33) {
            switch (i10) {
                case 0:
                    return "success";
                case 1:
                    return C1562i.a("O105493_22");
                case 2:
                    return C1562i.a("O105493_23");
                case 3:
                    return C1562i.a("O105493_24");
                case 4:
                    return C1562i.a("O105493_25");
                case 5:
                    return C1562i.a("O105493_26");
                case 6:
                    return C1562i.a("O105493_27");
                case 7:
                    return C1562i.a("O105493_28");
                case 8:
                    return C1562i.a("O105493_21");
                case 9:
                    return C1562i.a("O105493_29");
                case 10:
                    return C1562i.a("O105493_30");
                case 11:
                    return C1562i.a("O105493_32");
                case 12:
                    return C1562i.a("O105493_31");
                case 13:
                    return C1562i.a("O105493_15");
                case 14:
                    return C1562i.a("O105493_16");
                case 15:
                    return C1562i.a("O105493_33");
                default:
                    switch (i10) {
                        case 18:
                            return C1562i.a("O105493_34");
                        case 19:
                            return C1562i.a("O105493_35");
                        case 20:
                            return C1562i.a("O105493_36");
                        default:
                            return strA;
                    }
            }
        }
        return C1562i.a("O105493_19");
    }

    public static float dist(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return dist(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static boolean locCorrect(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return checkLoc(aMapLocation);
        }
        return false;
    }

    private static FileInputStream a(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static float dist(DPoint dPoint, DPoint dPoint2) {
        return dist(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    private static FileOutputStream a(File file, boolean z10) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        }
        return new FileOutputStream(file, z10);
    }

    private static boolean a(Context context) {
        if (context != null) {
            try {
                if (context.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) != 0) {
                    if (context.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 0) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
                DebugUtils.writeCat("isCoarsePermSORAbove", false);
            }
        }
        return false;
    }

    private static boolean a(String str) {
        try {
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
            return str3.toLowerCase().contains(str);
        } catch (Throwable unused) {
            DebugUtils.writeCat("tdb e", false);
            return false;
        }
    }
}
