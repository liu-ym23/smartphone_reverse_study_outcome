package com.bytedance.framwork.core.sdklib.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkType f7548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7549b;

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
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
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
            $VALUES = new NetworkType[]{r10, r11, r12, r13, r14, r15, r16};
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
        f7548a = NetworkType.UNKNOWN;
        f7549b = false;
    }

    public static NetworkType a(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r11 == null) goto L23;
        if (r11.isAvailable() == false) goto L23;
        int r12 = r11.getType();     // Catch: Throwable -> L24
        if (1 == r12) goto L10;
        if (r12 != 0) goto L21;
        switch(((TelephonyManager) r10.getSystemService("phone")).getNetworkType()) {
            case 3: goto L19;
            case 4: goto L15;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L15;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L15;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L15;
        };     // Catch: Throwable -> L24
    L15:
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L23:
        return NetworkType.NONE;
    L25:
        return NetworkType.MOBILE;
    }
}
