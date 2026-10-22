package com.baidu.platform.comapi.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class NetworkUtil {
    public static final int NETYPE_2G = 2;
    public static final int NETYPE_3G = 3;
    public static final int NETYPE_4G = 4;
    public static final int NETYPE_4G_UNKNOWN = 10;
    public static final int NETYPE_MOBILE_3G = 8;
    public static final int NETYPE_MOBILE_UNICOM_2G = 6;
    public static final int NETYPE_NOCON = -1;
    public static final int NETYPE_TELECOM_2G = 5;
    public static final int NETYPE_TELECOM_3G = 7;
    public static final int NETYPE_UNICOM_3G = 9;
    public static final int NETYPE_UNKNOWN = 0;
    public static final int NETYPE_WIFI = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f33392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NetworkCallbackImpl f33393b = null;
    public static String mProxyHost = "";
    public static int mProxyPort;
    public static boolean mUseProxy;

    public static boolean initConnectState() {
        return true;
    }

    public static void updateNetworkProxy(Context r100) {
    }

    public static void unregisterNetworkCallback() {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        ConnectivityManager r100 = f33392a;
        if (r100 == null) goto L11;
        NetworkCallbackImpl r101 = f33393b;
        if (r101 == null) goto L12;
        r100.unregisterNetworkCallback(r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    public NetworkUtil() {
    }

    private static String a(NetworkCapabilities r100) {
        if (r100 != null) goto L5;
        return "mobile";
    L5:
        boolean r101 = r100.hasTransport(1);
        boolean r102 = r100.hasTransport(0);
        boolean r103 = r100.hasTransport(3);
        boolean r104 = r100.hasTransport(6);
        boolean r105 = r100.hasTransport(4);
        boolean r106 = r100.hasTransport(5);
        if (r101 == false) goto L8;
        return "WIFI";
    L8:
        if (r102 == false) goto L10;
        return "CELLULAR";
    L10:
        if (r103 == false) goto L12;
        return "ETHERNET";
    L12:
        if (r104 == false) goto L14;
        return "LoWPAN";
    L14:
        if (r105 == false) goto L16;
        return "VPN";
    L16:
        if (r106 == false) goto L24;
        return "WifiAware";
    L24:
        return "mobile";
    }

    public static NetworkInfo getActiveNetworkInfo(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L11;
    L9:
        return null;
    L11:
        return r101.getActiveNetworkInfo();
    }

    public static NetworkInfo[] getAllNetworkInfo(Context r100) {
        if (r100 != null) goto L9;
        return null;
    L9:
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getAllNetworkInfo();
    L11:
        return null;
    }

    public static String getCurrentNetMode(Context r100) {
        NetworkInfo r101 = getActiveNetworkInfo(r100);
        int r102 = -1;
        if (r101 == null) goto L38;
        int r103 = r101.getType();
        if (r103 != 1) goto L12;
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        return "WIFI";
    L10:
        r102 = 1;
        goto L38
    L12:
        if (r103 == 0) goto L17;
        if (r103 == 3) goto L17;
        if (r103 == 4) goto L17;
        if (r103 != 5) goto L38;
    L17:
        if (Build.VERSION.SDK_INT <= 29) goto L24;
        ConnectivityManager r104 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r104 != null) goto L23;
        return "mobile";
    L23:
        return a(r104.getNetworkCapabilities(r104.getActiveNetwork()));
    L24:
        TelephonyManager r105 = (TelephonyManager) r100.getSystemService("phone");
        if (r105 == null) goto L38;
        switch(r105.getNetworkType()) {
            case 1: goto L36;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L35;
            case 10: goto L35;
            case 11: goto L32;
            case 12: goto L33;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L35;
            case 16: goto L32;
            case 17: goto L31;
            case 18: goto L30;
            default: goto L28;
        };
    L28:
        r102 = 0;
        goto L38
    L29:
        r102 = 3;
        goto L38
    L30:
        r102 = 4;
        goto L38
    L31:
        r102 = 8;
        goto L38
    L32:
        r102 = 2;
        goto L38
    L33:
        r102 = 7;
        goto L38
    L34:
        r102 = 5;
        goto L38
    L35:
        r102 = 9;
        goto L38
    L36:
        r102 = 6;
    L38:
        return Integer.toString(r102);
    }

    public static String getNetworkOperatorInfo(Context r100) {
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        if (r101 == null) goto L8;
        String r102 = r101.getNetworkOperator();
        if (TextUtils.isEmpty(r102) == true) goto L8;
        StringBuilder r103 = new StringBuilder(r102);     // Catch: Exception -> L9
        r103.insert(3, ":");     // Catch: Exception -> L9
        return r103.toString();
    L8:
        return "";
    }

    public static int getNetworkOperatorType(Context r100) {
        String r101 = getNetworkOperatorInfo(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return -1;
    L5:
        if (r101.startsWith("460:00") == false) goto L7;
        return 0;
    L7:
        if (r101.startsWith("460:02") == false) goto L10;
        return 0;
    L10:
        if (r101.startsWith("460:01") == false) goto L14;
        return 1;
    L14:
        if (r101.startsWith("460:03") == false) goto L22;
        return 2;
    L22:
        return -1;
    }

    public static boolean isNetworkAvailable(Context r100) {
        if (isWifiConnected(r100) == false) goto L6;
        return true;
    L6:
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r101 == null) goto L15;
        if (r101.isConnectedOrConnecting() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }

    public static boolean isWifiConnected(Context r100) {
        if (r100 != null) goto L16;
        return false;
    L16:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L15
        if (r101 == null) goto L18;
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L15
        if (r102 != null) goto L10;
        return false;
    L10:
        if (1 != r102.getType()) goto L20;
        if (r102.isConnected() == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L18:
        return false;
    L22:
        return false;
    }

    public static boolean isWifiState(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        WifiManager r101 = (WifiManager) r100.getApplicationContext().getSystemService("wifi");
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        int r102 = r101.getWifiState();     // Catch: Exception -> L13
    L15:
        if (r102 != 3) goto L22;
        return true;
    L22:
        return false;
    L9:
        if (com_baidu_platform_comapi_util_NetworkUtil_android_content_Context_checkSelfPermission(r100, "android.permission.ACCESS_WIFI_STATE") != 0) goto L14;
        r102 = r101.getWifiState();     // Catch: Exception -> L13
        goto L15
    L21:
        r102 = 1;
    L14:
        r102 = 1;
        goto L15
    }

    public static void registerNetwork(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f33392a = (ConnectivityManager) r100.getSystemService("connectivity");
        NetworkRequest r101 = new NetworkRequest.Builder().build();
        if (f33392a == null) goto L8;
        NetworkCallbackImpl r102 = new NetworkCallbackImpl();
        f33393b = r102;
        f33392a.registerNetworkCallback(r101, r102);
        return;
    }

    private static int com_baidu_platform_comapi_util_NetworkUtil_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_baidu_platform_comapi_util_NetworkUtil_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
