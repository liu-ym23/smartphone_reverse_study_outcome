package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

/* JADX INFO: loaded from: classes39.dex */
public class NetworkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f30494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConnectivityManager f30495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static TelephonyManager f30496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f30497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static NetworkUpdate2MapListener f30498e;

    public static boolean initConnectState() {
        return true;
    }

    public static void unregisterNetworkCallback() {
        if (Build.VERSION.SDK_INT < 29) goto L12;
        ConnectivityManager r100 = f30495b;
        if (r100 == null) goto L13;
        b r101 = f30497d;
        if (r101 != null) goto L9;
        return;
    L9:
        if (f30494a == false) goto L15;
        r100.unregisterNetworkCallback(r101);
        f30497d = null;
        f30494a = false;
        return;
    L15:
        return;
    L13:
        return;
    }

    public static void updateNetworkInfo2Map() {
        NetworkUpdate2MapListener r100 = f30498e;
        if (r100 == null) goto L6;
        r100.networkUpdate();
        return;
    }

    public NetworkUtil() {
    }

    private static void a(Context r100) {
        if (f30495b != null) goto L6;
        f30495b = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");
    L6:
        if (f30496c != null) goto L9;
        f30496c = (TelephonyManager) r100.getApplicationContext().getSystemService("phone");
        return;
    }

    public static NetworkInfo getActiveNetworkInfo(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a(r100);
        if (Build.VERSION.SDK_INT < 29) goto L14;
        NetworkRequest r101 = new NetworkRequest.Builder().build();     // Catch: Exception -> L17
        ConnectivityManager r102 = f30495b;     // Catch: Exception -> L17
        if (r102 != null) goto L11;
        return null;
    L11:
        if (f30494a == true) goto L13;
        b r103 = new b(r100);     // Catch: Exception -> L17
        f30497d = r103;     // Catch: Exception -> L17
        f30495b.registerNetworkCallback(r101, r103);     // Catch: Exception -> L17
        f30494a = true;     // Catch: Exception -> L17
        return null;
    L13:
        NetworkInfo r104 = r102.getActiveNetworkInfo();     // Catch: Exception -> L17
    L16:
        return r104;
    L14:
        r104 = f30495b.getActiveNetworkInfo();     // Catch: Exception -> L17
        goto L16
    L21:
        return null;
    }

    public static String getCurrentNetMode(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a(r100);
        NetworkInfo r101 = getActiveNetworkInfo(r100);
        int r102 = 0;
        if (r101 == null) goto L51;
        if (r101.getType() != 1) goto L14;
        if (Build.VERSION.SDK_INT <= 29) goto L12;
        return "WIFI";
    L12:
        r102 = 1;
        goto L51
    L14:
        if (Build.VERSION.SDK_INT <= 29) goto L35;
        ConnectivityManager r103 = f30495b;
        if (r103 != null) goto L18;
        return "mobile";
    L18:
        Network r104 = r103.getActiveNetwork();
        NetworkCapabilities r105 = f30495b.getNetworkCapabilities(r104);
        if (r105 == null) goto L34;
        boolean r106 = r105.hasTransport(1);
        boolean r107 = r105.hasTransport(0);
        boolean r108 = r105.hasTransport(3);
        boolean r109 = r105.hasTransport(6);
        boolean r110 = r105.hasTransport(4);
        boolean r111 = r105.hasTransport(5);
        if (r106 == true) goto L57;
        if (r107 == false) goto L25;
        return "CELLULAR";
    L25:
        if (r108 == false) goto L27;
        return "ETHERNET";
    L27:
        if (r109 == false) goto L29;
        return "LoWPAN";
    L29:
        if (r110 == false) goto L31;
        return "VPN";
    L31:
        if (r111 == false) goto L34;
        return "WifiAware";
    L57:
        return "WIFI";
    L34:
        return "mobile";
    L35:
        TelephonyManager r112 = f30496c;
        if (r112 != null) goto L40;
        return Integer.toString(0);
    L40:
        switch(r112.getNetworkType()) {
            case 1: goto L49;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L46;
            case 7: goto L46;
            case 8: goto L45;
            case 9: goto L48;
            case 10: goto L48;
            case 11: goto L44;
            case 12: goto L46;
            case 13: goto L43;
            case 14: goto L42;
            case 15: goto L48;
            default: goto L51;
        };
    L42:
        r102 = 10;
        goto L51
    L43:
        r102 = 4;
        goto L51
    L44:
        r102 = 2;
        goto L51
    L45:
        r102 = 8;
        goto L51
    L46:
        r102 = 7;
        goto L51
    L47:
        r102 = 5;
        goto L51
    L48:
        r102 = 9;
        goto L51
    L49:
        r102 = 6;
    L51:
        return Integer.toString(r102);
    }

    public static boolean isNetworkAvailable(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        a(r100);
        if (isWifiConnected(r100) == false) goto L9;
        return true;
    L9:
        ConnectivityManager r101 = f30495b;     // Catch: Exception -> L18
        if (r101 != null) goto L12;
        return false;
    L12:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L18
        if (r102 == null) goto L21;
        if (r102.isConnectedOrConnecting() == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L23:
        return false;
    }

    public static boolean isWifiConnected(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        a(r100);
        ConnectivityManager r101 = f30495b;
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
    L22:
        return false;
    L18:
        return false;
    }

    public static void setNetworkUpdate2MapListener(NetworkUpdate2MapListener r100) {
        f30498e = r100;
    }

    public static void updateNetworkProxy(Context r100) {
        SysUpdateObservable.getInstance().updateNetworkProxy(r100);
    }

    public static boolean isWifiConnected(NetworkInfo r100) {
        if (r100 == null) goto L14;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        if (1 != r100.getType()) goto L15;
        if (r100.isConnected() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }
}
