package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.apm.util.k;
import io.reactivex.annotations.SchedulerSupport;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f10475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f10476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f10477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f10478d;

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r10 = new NetworkType("NONE", 0, 0);
            NONE = r10;
            NetworkType r11 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r11;
            NetworkType r12 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r12;
            NetworkType r13 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r13;
            NetworkType r14 = new NetworkType("WIFI", 4, 4);
            WIFI = r14;
            NetworkType r15 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r15;
            $VALUES = new NetworkType[]{r10, r11, r12, r13, r14, r15};
        }

        private NetworkType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static NetworkType valueOf(String r10) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r10);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10479a = null;

        static {
            int[] r10 = new int[NetworkType.values().length];
            f10479a = r10;
            r10[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f10479a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f10479a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f10479a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f10479a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
    }

    public static String a(Context r10) {
        long r11 = h(r10.getApplicationInfo().uid);
        if (r11 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r12 = System.currentTimeMillis();
        long r13 = ((r11 - f10475a) * 1000) / (r12 - f10477c);
        f10477c = r12;
        f10475a = r11;
        return String.valueOf(r13) + " KB/s";
    }

    public static List b(Context r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L20;
    L19:
        return r11;
    L20:
        ConnectivityManager r12 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Exception -> L15
        NetworkInfo r13 = r12.getActiveNetworkInfo();     // Catch: Exception -> L15
        Network[] r14 = r12.getAllNetworks();     // Catch: Exception -> L15
        int r15 = r14.length;     // Catch: Exception -> L15
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L19;
        Network r17 = r14[r16];     // Catch: Exception -> L15
        if (r12.getNetworkInfo(r17).getType() != r13.getType()) goto L17;
        Iterator<RouteInfo> r18 = r12.getLinkProperties(r17).getRoutes().iterator();     // Catch: Exception -> L15
    L10:
        if (r18.hasNext() == false) goto L17;
        InetAddress r19 = r18.next().getGateway();     // Catch: Exception -> L15
        if (r19 == null) goto L10;
        r11.add(r19.getHostAddress());     // Catch: Exception -> L15
    L17:
        r16 = r16 + 1;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static List c(Context r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L18;
    L17:
        return r11;
    L18:
        ConnectivityManager r12 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Exception -> L13
        NetworkInfo r13 = r12.getActiveNetworkInfo();     // Catch: Exception -> L13
        Network[] r14 = r12.getAllNetworks();     // Catch: Exception -> L13
        int r15 = r14.length;     // Catch: Exception -> L13
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L17;
        Network r17 = r14[r16];     // Catch: Exception -> L13
        if (r12.getNetworkInfo(r17).getType() != r13.getType()) goto L15;
        Iterator<InetAddress> r18 = r12.getLinkProperties(r17).getDnsServers().iterator();     // Catch: Exception -> L13
    L10:
        if (r18.hasNext() == false) goto L15;
        r11.add(r18.next().getHostAddress());     // Catch: Exception -> L13
    L15:
        r16 = r16 + 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String d() {
        String r10 = SchedulerSupport.NONE;
        Enumeration<NetworkInterface> r11 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L13
    L4:
        if (r11.hasMoreElements() == false) goto L25;
        NetworkInterface r12 = r11.nextElement();     // Catch: SocketException -> L13
        String r13 = r12.getName();     // Catch: SocketException -> L13
        if (r13 == null) goto L4;
        if (TextUtils.equals(r13.toLowerCase(), "eth0") == true) goto L15;
        if (TextUtils.equals(r13.toLowerCase(), "wlan0") == false) goto L4;
    L15:
        Enumeration<InetAddress> r14 = r12.getInetAddresses();     // Catch: SocketException -> L13
    L17:
        if (r14.hasMoreElements() == false) goto L4;
        InetAddress r15 = r14.nextElement();     // Catch: SocketException -> L13
        if ((r15 instanceof Inet4Address) == false) goto L17;
        if (r15.isLoopbackAddress() == true) goto L17;
        r10 = r15.getHostAddress();     // Catch: SocketException -> L13
    L25:
        return r10;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public static String e(Context r10) {
        return f(g(r10));
    }

    public static String f(NetworkType r10) {
        int r11 = a.f10479a[r10.ordinal()];     // Catch: Exception -> L20
        if (r11 != 1) goto L6;
        return "wifi";
    L6:
        if (r11 == 2) goto L27;
        if (r11 == 3) goto L26;
        if (r11 == 4) goto L25;
        if (r11 == 5) goto L24;
        return "";
    L24:
        return "mobile";
    L25:
        return "4g";
    L26:
        return "3g";
    L27:
        return "2g";
    L28:
        return "";
    }

    public static NetworkType g(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L26
        if (r11 == null) goto L25;
        if (r11.isAvailable() == false) goto L25;
        int r12 = r11.getType();     // Catch: Throwable -> L26
        if (1 == r12) goto L10;
        if (r12 != 0) goto L23;
        switch(((TelephonyManager) r10.getSystemService("phone")).getNetworkType()) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L15;
        };     // Catch: Throwable -> L26
    L15:
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE_2G;
    L23:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L25:
        return NetworkType.NONE;
    L27:
        return NetworkType.MOBILE;
    }

    public static long h(int r10) {
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    public static long i(int r10) {
        return TrafficStats.getTotalTxBytes() / 1024;
    }

    public static String j(Context r10) {
        long r11 = i(r10.getApplicationInfo().uid);
        if (r11 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r12 = System.currentTimeMillis();
        long r13 = ((r11 - f10476b) * 1000) / (r12 - f10478d);
        f10478d = r12;
        f10476b = r11;
        return String.valueOf(r13) + " KB/s";
    }

    public static boolean k(Context r10) {
        if (r10 != null) goto L15;
        return false;
    L15:
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L10
        if (r11 == null) goto L12;
        if (r11.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean l(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.isAvailable() == false) goto L17;
        if (1 == r11.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public static List m(String r10) {
        ArrayList r11 = new ArrayList();
        InetAddress[] r12 = InetAddress.getAllByName(r10);     // Catch: UnknownHostException -> L11
        if (r12 != null) goto L6;
    L13:
        return r11;
    L6:
        if (r12.length <= 0) goto L13;
        int r13 = r12.length;     // Catch: UnknownHostException -> L11
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        r11.add(r12[r14].getHostAddress());     // Catch: UnknownHostException -> L11
        r14 = r14 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static boolean n(String r10, JSONObject r11) {
        JSONObject r12 = new JSONObject();
        boolean r13 = false;
        HttpURLConnection r14 = null;
        r14 = k.a(r10);     // Catch: Throwable -> L9 Exception -> L11
        r14.setRequestMethod("GET");     // Catch: Throwable -> L9 Exception -> L11
        r14.setReadTimeout(30000);     // Catch: Throwable -> L9 Exception -> L11
        r14.setConnectTimeout(30000);     // Catch: Throwable -> L9 Exception -> L11
        r14.setDoInput(true);     // Catch: Throwable -> L9 Exception -> L11
        r14.setDoOutput(true);     // Catch: Throwable -> L9 Exception -> L11
        r14.setUseCaches(false);     // Catch: Throwable -> L9 Exception -> L11
        r14.setRequestProperty("Charset", ea.a.f19330b);     // Catch: Throwable -> L9 Exception -> L11
        int r15 = r14.getResponseCode();     // Catch: Throwable -> L9 Exception -> L11
        r12.put("statusCode", r15);     // Catch: Throwable -> L9 Exception -> L11
        r12.put("header", d.a(r14.getHeaderFields()));     // Catch: Throwable -> L9 Exception -> L11
        r11.put(r10, r12);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r15 != 200) goto L7;
        r13 = true;
    L7:
        r14.disconnect();
        return r13;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        r11.put(r10, e.getMessage());     // Catch: Throwable -> L9 JSONException -> L17
        if (r14 == null) goto L16;
        r14.disconnect();
    L16:
        return false;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        if (r14 == null) goto L21;
        r14.disconnect();
    L21:
        return false;
    L9:
        th = move-exception;
        if (r14 == null) goto L24;
        r14.disconnect();
    L24:
        throw th;
    }
}
