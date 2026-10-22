package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

/* loaded from: classes.dex */
public class NetworkUtil {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f5953a = false;

    /* renamed from: b, reason: collision with root package name */
    private static a f5954b;

    /* renamed from: c, reason: collision with root package name */
    private static ConnectivityManager f5955c;

    /* renamed from: d, reason: collision with root package name */
    private static NetworkUpdate2MapListener f5956d;

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo = null;
        if (context == null) {
            return null;
        }
        f5955c = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = f5955c;
            if (connectivityManager != null) {
                if (f5953a) {
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                } else {
                    a aVar = new a(context);
                    f5954b = aVar;
                    f5955c.registerNetworkCallback(networkRequestBuild, aVar);
                    f5953a = true;
                }
            }
        } catch (Exception unused) {
        }
        return activeNetworkInfo;
    }

    public static String getCurrentNetMode(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i4 = 0;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
                    return "mobile";
                }
                return networkCapabilities.hasTransport(1) ? "WIFI" : networkCapabilities.hasTransport(0) ? "CELLULAR" : networkCapabilities.hasTransport(3) ? "ETHERNET" : networkCapabilities.hasTransport(6) ? "LoWPAN" : networkCapabilities.hasTransport(4) ? "VPN" : networkCapabilities.hasTransport(5) ? "WifiAware" : "mobile";
            }
            i4 = 1;
        }
        return Integer.toString(i4);
    }

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        try {
            if (1 == networkInfo.getType()) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static void setNetworkUpdate2MapListener(NetworkUpdate2MapListener networkUpdate2MapListener) {
        f5956d = networkUpdate2MapListener;
    }

    public static void unregisterNetworkCallback() {
        a aVar;
        ConnectivityManager connectivityManager = f5955c;
        if (connectivityManager == null || (aVar = f5954b) == null || !f5953a) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(aVar);
        f5953a = false;
    }

    public static void updateNetworkInfo2Map() {
        NetworkUpdate2MapListener networkUpdate2MapListener = f5956d;
        if (networkUpdate2MapListener != null) {
            networkUpdate2MapListener.networkUpdate();
        }
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }
}
