package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry;

/* JADX INFO: loaded from: classes44.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f57177a = null;

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f57178a = null;
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
            f57178a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f57178a.clone();
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
        public static final /* synthetic */ int[] f57179a = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            f57179a = r100;
            r100[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f57179a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f57179a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f57179a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f57179a[NetworkType.MOBILE_5G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f57179a[NetworkType.MOBILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f57177a = TokenCert.with("bpea-live_networkutils_get_network_type");
        TokenCert.with("bpea-live_networkutils_get_network_operator");
    }

    public static String a(NetworkType r100) {
        switch(a.f57179a[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L16;
        };     // Catch: Exception -> L13
    L11:
        return "wifi";
    L16:
        return "";
    L17:
        return "mobile";
    L18:
        return CJPayBasicUtils.NETWORK_MOBILE;
    L19:
        return CJPayBasicUtils.NETWORK_4G;
    L20:
        return CJPayBasicUtils.NETWORK_3G;
    L21:
        return CJPayBasicUtils.NETWORK_2G;
    L22:
        return "";
    }

    public static boolean c(Context r100) {
        NetworkType r101 = b(r100, f57177a);
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

    public static boolean f(Context r100) {
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

    public static NetworkType b(Context r100, Cert r101) {
        NetworkInfo r102 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L36
        if (r102 == null) goto L35;
        if (r102.isAvailable() == false) goto L35;
        int r103 = r102.getType();     // Catch: Throwable -> L36
        if (1 == r103) goto L10;
        if (r103 != 0) goto L33;
        int r104 = gv.c.f482809a;     // Catch: Throwable -> L36
        Object r105 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getSystemService("phone");     // Catch: Throwable -> L36
        if (r105 == null) goto L31;
        TelephonyManagerEntry.Companion.getClass();     // Catch: Throwable -> L36
        Integer r106 = TelephonyManagerEntry.Companion.b((TelephonyManager) r105, r101);     // Catch: Throwable -> L36
        if (r106 == null) goto L17;
        int r107 = r106.intValue();     // Catch: Throwable -> L36
        if (r107 == 20) goto L29;
        switch(r107) {
            case 1: goto L27;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L23;
            case 14: goto L25;
            case 15: goto L25;
            default: goto L39;
        };     // Catch: Throwable -> L36
    L39:
        return NetworkType.MOBILE;
    L23:
        return NetworkType.MOBILE_4G;
    L25:
        return NetworkType.MOBILE_3G;
    L27:
        return NetworkType.MOBILE_2G;
    L29:
        return NetworkType.MOBILE_5G;
    L17:
        return NetworkType.MOBILE;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Throwable -> L36
    L33:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L35:
        return NetworkType.NONE;
    L37:
        return NetworkType.MOBILE;
    }

    public static boolean d(Context r100, TokenCert r101) {
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
