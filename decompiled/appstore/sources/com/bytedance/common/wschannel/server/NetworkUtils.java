package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkUtils {

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

    public static int a(Context r10) {
        boolean r11 = c(r10);
        NetworkType r12 = b(r10);
        if (r11 == true) goto L6;
        return 2;
    L6:
        if (NetworkType.WIFI != r12) goto L9;
        return 3;
    L9:
        if (NetworkType.NONE == r12) goto L11;
        return 4;
    L11:
        return 1;
    }

    public static NetworkType b(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L47
        if (r11 == null) goto L46;
        if (r11.isAvailable() == false) goto L46;
        int r12 = r11.getType();     // Catch: Throwable -> L47
        if (1 == r12) goto L10;
        if (r12 != 0) goto L44;
        TelephonyManager r13 = (TelephonyManager) r10.getSystemService("phone");     // Catch: Throwable -> L47
        if (r13 != null) goto L17;
        return NetworkType.MOBILE;
    L17:
        if (r13.getNetworkType() == 3) goto L42;
        if (r13.getNetworkType() == 5) goto L42;
        if (r13.getNetworkType() == 6) goto L42;
        if (r13.getNetworkType() == 8) goto L42;
        if (r13.getNetworkType() == 9) goto L42;
        if (r13.getNetworkType() == 10) goto L42;
        if (r13.getNetworkType() == 12) goto L42;
        if (r13.getNetworkType() == 14) goto L42;
        if (r13.getNetworkType() == 15) goto L42;
        if (r13.getNetworkType() != 13) goto L40;
        return NetworkType.MOBILE_4G;
    L40:
        return NetworkType.MOBILE;
    L42:
        return NetworkType.MOBILE_3G;
    L44:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L46:
        return NetworkType.NONE;
    L48:
        return NetworkType.MOBILE;
    }

    public static boolean c(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        if (r11.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
