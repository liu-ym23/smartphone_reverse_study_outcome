package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: classes45.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f66071a = null;

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f66072a = null;
        final int nativeInt;

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4);
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r105;
            NetworkType r110 = new NetworkType("MOBILE_5G", 6, 6);
            MOBILE_5G = r110;
            f66072a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f66072a.clone();
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        public NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f66073a = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            f66073a = r100;
            r100[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f66073a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f66073a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f66073a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f66073a[NetworkType.MOBILE_5G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f66073a[NetworkType.MOBILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f66071a = TokenCert.with("bpea-live_networkutils_get_network_type");
        TokenCert.with("bpea-live_networkutils_get_network_operator");
    }

    public static boolean c(Context r100) {
        NetworkType r101 = b(r100, f66071a);
        if (NetworkType.MOBILE_2G != r101) goto L5;
    L14:
        return true;
    L5:
        if (NetworkType.MOBILE_3G == r101) goto L14;
        if (NetworkType.MOBILE_4G == r101) goto L14;
        if (NetworkType.MOBILE_5G == r101) goto L14;
        if (NetworkType.MOBILE == r101) goto L14;
        return false;
    }

    public static boolean e(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        Network[] r102 = r101.getAllNetworks();
        if (r102 != null) goto L13;
        return false;
    L13:
        int r103 = r102.length;
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L33;
        NetworkCapabilities r105 = r101.getNetworkCapabilities(r102[r104]);
        if (r105 == null) goto L21;
        if (r105.hasTransport(0) == false) goto L21;
        return true;
    L21:
        r104 = r104 + 1;
    L33:
        return false;
    L22:
        NetworkInfo[] r106 = r101.getAllNetworkInfo();
        if (r106 != null) goto L25;
        return false;
    L25:
        int r107 = r106.length;
        int r108 = 0;
    L26:
        if (r108 >= r107) goto L33;
        NetworkInfo r109 = r106[r108];
        if (r109.getType() != 0) goto L32;
        if (r109.isConnected() == false) goto L32;
        return true;
    L32:
        r108 = r108 + 1;
        goto L26
    }

    public static boolean f(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean g(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L17;
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static String a(Context r100, Cert r101) {
        NetworkType r102 = b(r100, r101);
        switch(a.f66073a[r102.ordinal()]) {
            case 1: goto L11;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L13;
        };     // Catch: Exception -> L15
    L11:
        return "wifi";
    L18:
        return "mobile";
    L19:
        return CJPayBasicUtils.NETWORK_MOBILE;
    L20:
        return CJPayBasicUtils.NETWORK_4G;
    L21:
        return CJPayBasicUtils.NETWORK_3G;
    L22:
        return CJPayBasicUtils.NETWORK_2G;
    L13:
        return "";
    }

    public static NetworkType b(Context r100, Cert r101) {
        NetworkInfo r102 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L33
        if (r102 == null) goto L32;
        if (r102.isAvailable() == false) goto L32;
        int r103 = r102.getType();     // Catch: Throwable -> L33
        if (1 == r103) goto L10;
        if (r103 != 0) goto L30;
        Integer r104 = g80.g.a(r101);     // Catch: Throwable -> L33
        if (r104 == null) goto L15;
        int r105 = r104.intValue();     // Catch: Throwable -> L33
        if (r105 == 20) goto L28;
        switch(r105) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L26;
            case 8: goto L24;
            case 9: goto L24;
            case 10: goto L24;
            case 11: goto L26;
            case 12: goto L24;
            case 13: goto L22;
            case 14: goto L24;
            case 15: goto L24;
            default: goto L20;
        };     // Catch: Throwable -> L33
    L20:
        return NetworkType.MOBILE;
    L22:
        return NetworkType.MOBILE_4G;
    L24:
        return NetworkType.MOBILE_3G;
    L26:
        return NetworkType.MOBILE_2G;
    L28:
        return NetworkType.MOBILE_5G;
    L15:
        return NetworkType.MOBILE;
    L30:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L32:
        return NetworkType.NONE;
    L34:
        return NetworkType.MOBILE;
    }

    public static boolean d(Context r100, Cert r101) {
        NetworkType r102 = b(r100, r101);
        if (NetworkType.MOBILE_2G != r102) goto L5;
    L14:
        return true;
    L5:
        if (NetworkType.MOBILE_3G == r102) goto L14;
        if (NetworkType.MOBILE_4G == r102) goto L14;
        if (NetworkType.MOBILE_5G == r102) goto L14;
        if (NetworkType.MOBILE == r102) goto L14;
        return false;
    }
}
