package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedanceos.common.ui.animation.AnimationConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6845a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6846b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static m5.b f6847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static NetworkTypeInterceptor f6848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static NetworkType f6849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f6850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f6851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f6852h;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_3G_H = null;
        public static final NetworkType MOBILE_3G_HP = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final NetworkType WIFI_24GHZ = null;
        public static final NetworkType WIFI_5GHZ = null;
        final int nativeInt;

        static {
            NetworkType r10 = new NetworkType("UNKNOWN", 0, -1);
            UNKNOWN = r10;
            NetworkType r11 = new NetworkType("NONE", 1, 0);
            NONE = r11;
            NetworkType r12 = new NetworkType("MOBILE", 2, 1);
            MOBILE = r12;
            NetworkType r13 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r13;
            NetworkType r14 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r14;
            NetworkType r15 = new NetworkType("WIFI", 5, 4);
            WIFI = r15;
            NetworkType r16 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r16;
            NetworkType r17 = new NetworkType("MOBILE_5G", 7, 6);
            MOBILE_5G = r17;
            NetworkType r18 = new NetworkType("WIFI_24GHZ", 8, 7);
            WIFI_24GHZ = r18;
            NetworkType r19 = new NetworkType("WIFI_5GHZ", 9, 8);
            WIFI_5GHZ = r19;
            NetworkType r110 = new NetworkType("MOBILE_3G_H", 10, 9);
            MOBILE_3G_H = r110;
            NetworkType r111 = new NetworkType("MOBILE_3G_HP", 11, 10);
            MOBILE_3G_HP = r111;
            $VALUES = new NetworkType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
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

        public boolean is2G() {
            if (this != MOBILE) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_2G) goto L8;
            return false;
        }

        public boolean is3GOrHigher() {
            if (this != MOBILE_3G) goto L5;
        L14:
            return true;
        L5:
            if (this == MOBILE_3G_H) goto L14;
            if (this == MOBILE_3G_HP) goto L14;
            if (this == MOBILE_4G) goto L14;
            if (this == MOBILE_5G) goto L14;
            return false;
        }

        public boolean is4GOrHigher() {
            if (this != MOBILE_4G) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_5G) goto L8;
            return false;
        }

        public boolean isAvailable() {
            if (this != UNKNOWN) goto L5;
        L7:
            return false;
        L5:
            if (this == NONE) goto L7;
            return true;
        }

        public boolean isWifi() {
            if (this != WIFI) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    static {
        f6849e = NetworkType.UNKNOWN;
        f6850f = false;
        f6851g = AnimationConstants.DURATION_2000L;
        f6852h = 0;
    }

    public static void a(Context r10) {
        if ((System.currentTimeMillis() - f6852h) <= f6851g) goto L6;
        f6849e = h(r10);
        f6852h = System.currentTimeMillis();
        return;
    }

    public static void b(Context r10) {
        NetworkTypeInterceptor r11 = f6848d;
        if (r11 != null) goto L5;
    L8:
        n(r10);
        if (f6849e != NetworkType.UNKNOWN) goto L12;
        f6849e = h(r10);
        return;
    L12:
        return;
    L5:
        if (r11.getNetworkType() == NetworkType.NONE) goto L8;
        f6849e = f6848d.getNetworkType();
    }

    public static String c(Context r10) {
        if (f6847c != null) goto L6;
        f6847c = new m5.b(r10);
    L6:
        return f6847c.a();
    }

    public static String d(Context r10) {
        return e(f(r10));
    }

    public static String e(NetworkType r10) {
        if (r10 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r10 != NetworkType.WIFI_24GHZ) goto L9;
        return "wifi24ghz";
    L9:
        if (r10 != NetworkType.WIFI_5GHZ) goto L12;
        return "wifi5ghz";
    L12:
        if (r10 != NetworkType.MOBILE_2G) goto L15;
        return "2g";
    L15:
        if (r10 != NetworkType.MOBILE_3G) goto L18;
        return "3g";
    L18:
        if (r10 != NetworkType.MOBILE_3G_H) goto L21;
        return "3gh";
    L21:
        if (r10 != NetworkType.MOBILE_3G_HP) goto L24;
        return "3ghp";
    L24:
        if (r10 != NetworkType.MOBILE_4G) goto L27;
        return "4g";
    L27:
        if (r10 != NetworkType.MOBILE_5G) goto L30;
        return "5g";
    L30:
        if (r10 != NetworkType.MOBILE) goto L32;
        return "mobile";
    L32:
        return "";
    }

    public static NetworkType f(Context r10) {
        if (f6845a == false) goto L7;
        return g(r10);
    L7:
        return h(r10);
    }

    public static NetworkType g(Context r10) {
        b(r10);
        a(r10);
        return f6849e;
    }

    public static NetworkType h(Context r10) {
        if (f6846b == true) goto L5;
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L38
        if (r11 == null) goto L37;
        if (r11.isAvailable() == false) goto L37;
        int r12 = r11.getType();     // Catch: Throwable -> L38
        if (1 == r12) goto L14;
        if (r12 != 0) goto L35;
        int r13 = ((TelephonyManager) r10.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L38
        if (r13 == 3) goto L33;
        if (r13 == 20) goto L31;
        if (r13 == 5) goto L33;
        if (r13 == 6) goto L33;
        switch(r13) {
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            default: goto L25;
        };     // Catch: Throwable -> L38
    L25:
        switch(r13) {
            case 12: goto L33;
            case 13: goto L29;
            case 14: goto L33;
            case 15: goto L33;
            default: goto L27;
        };     // Catch: Throwable -> L38
    L27:
        return NetworkType.MOBILE;
    L29:
        return NetworkType.MOBILE_4G;
    L31:
        return NetworkType.MOBILE_5G;
    L33:
        return NetworkType.MOBILE_3G;
    L35:
        return NetworkType.MOBILE;
    L14:
        return NetworkType.WIFI;
    L37:
        return NetworkType.NONE;
    L39:
        return NetworkType.MOBILE;
    L5:
        return i(r10);
    }

    public static NetworkType i(Context r10) {
        String r11 = c(r10);     // Catch: Throwable -> L43
        boolean r12 = m(r11);     // Catch: Throwable -> L43
        if (r12 == true) goto L18;
        NetworkInfo r13 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L43
        if (r13 == null) goto L16;
        if (r13.isAvailable() == false) goto L16;
        int r14 = r13.getType();     // Catch: Throwable -> L43
        if (1 != r14) goto L13;
        r11 = "WIFI";
        goto L18
    L13:
        if (r14 != 0) goto L18;
        r11 = "MOBILE";
    L16:
        return NetworkType.NONE;
    L18:
        if ("WIFI".equals(r11) == false) goto L22;
        return NetworkType.WIFI;
    L22:
        if ("MOBILE".equals(r11) == false) goto L42;
        if (r12 == true) goto L25;
        int r15 = ((TelephonyManager) r10.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L43
    L26:
        switch(r15) {
            case 1: goto L40;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L40;
            case 8: goto L38;
            case 9: goto L38;
            case 10: goto L38;
            case 11: goto L40;
            case 12: goto L38;
            case 13: goto L32;
            case 14: goto L38;
            case 15: goto L38;
            case 16: goto L40;
            case 17: goto L38;
            case 18: goto L32;
            case 19: goto L32;
            case 20: goto L30;
            default: goto L28;
        };     // Catch: Throwable -> L43
    L28:
        return NetworkType.UNKNOWN;
    L30:
        return NetworkType.MOBILE_5G;
    L32:
        if (k(r10) == false) goto L36;
        return NetworkType.MOBILE_5G;
    L36:
        return NetworkType.MOBILE_4G;
    L38:
        return NetworkType.MOBILE_3G;
    L40:
        return NetworkType.MOBILE_2G;
    L25:
        r15 = j(r10);     // Catch: Throwable -> L43
        goto L26
    L42:
        return NetworkType.NONE;
    L44:
        return NetworkType.NONE;
    }

    public static int j(Context r10) {
        if (f6847c != null) goto L6;
        f6847c = new m5.b(r10);
    L6:
        return f6847c.b();
    }

    public static boolean k(Context r10) {
        if (f6847c != null) goto L6;
        f6847c = new m5.b(r10);
    L6:
        return f6847c.c();
    }

    public static boolean l(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        if (r11.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean m(String r10) {
        if ("NOT_REGISTERED".equals(r10) == false) goto L5;
        return false;
    L5:
        if ("NOT_SUPPORTED".equals(r10) == false) goto L7;
        return false;
    L7:
        if ("DISCONNECTED".equals(r10) == true) goto L14;
        return true;
    L14:
        return false;
    }

    public static void n(Context r10) {
        if (f6850f == true) goto L7;
        if (r10 == null) goto L8;
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r11.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r11.addAction("android.net.wifi.STATE_CHANGE");
        r10.getApplicationContext().registerReceiver(new NetworkConnectChangeReceiver(), r11);
        f6850f = true;
        return;
    L8:
        return;
    }

    public static void o(NetworkType r10) {
        f6849e = r10;
    }
}
