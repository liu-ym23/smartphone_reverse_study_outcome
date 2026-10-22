package com.bytedance.framwork.core.sdklib.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.obric.appintents.contacts.ContactsCreateIntent;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NetUtils {
    static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static boolean sIsReceiverRegisted;
    private static NetworkType sNetworkType;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
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

        public static NetworkType valueOf(String r1) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r1);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        static {
            NetworkType r0 = new NetworkType("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            NetworkType r1 = new NetworkType("NONE", 1, 0);
            NONE = r1;
            NetworkType r2 = new NetworkType(ContactsCreateIntent.CREATE_TEL_TYPE_MOBILE, 2, 1);
            MOBILE = r2;
            NetworkType r5 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r5;
            NetworkType r7 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r7;
            NetworkType r9 = new NetworkType("WIFI", 5, 4);
            WIFI = r9;
            NetworkType r11 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r11;
            $VALUES = new NetworkType[]{r0, r1, r2, r5, r7, r9, r11};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
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

        public boolean isWifi() {
            if (this != WIFI) goto L5;
            return true;
        L5:
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
    }

    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    public NetUtils() {
    }

    static {
        sNetworkType = NetworkType.UNKNOWN;
        sIsReceiverRegisted = false;
    }

    static void setNetworkType(NetworkType r0) {
        sNetworkType = r0;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor r0) {
        sNetworkTypeInterceptor = r0;
    }

    public static boolean is2G(Context r1) {
        NetworkType r2 = getNetworkType(r1);
        if (r2 != NetworkType.MOBILE) goto L5;
    L8:
        return true;
    L5:
        if (r2 == NetworkType.MOBILE_2G) goto L8;
        return false;
    }

    public static boolean isWifi(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) r4.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        NetworkTypeInterceptor r1 = sNetworkTypeInterceptor;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.getNetworkType() == NetworkType.NONE) goto L17;
        if (sNetworkTypeInterceptor.getNetworkType() == NetworkType.WIFI) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (1 == r5.getType()) goto L19;
        return false;
    L19:
        return true;
    L24:
        return false;
    L26:
        return false;
    }

    public static boolean isNetworkAvailable(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static NetworkType getNetworkType(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r0 == null) goto L22;
        if (r0.isAvailable() == false) goto L22;
        int r1 = r0.getType();     // Catch: Throwable -> L23
        if (1 == r1) goto L10;
        if (r1 != 0) goto L20;
        switch(((TelephonyManager) r2.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L26;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L26;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L26;
        };     // Catch: Throwable -> L23
    L26:
        return NetworkType.MOBILE;
    L16:
        return NetworkType.MOBILE_4G;
    L18:
        return NetworkType.MOBILE_3G;
    L20:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L22:
        return NetworkType.NONE;
    L24:
        return NetworkType.MOBILE;
    }

    public static String getNetworkAccessType(NetworkType r1) {
        if (r1 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r1 != NetworkType.MOBILE_2G) goto L9;
        return "2g";
    L9:
        if (r1 != NetworkType.MOBILE_3G) goto L12;
        return "3g";
    L12:
        if (r1 != NetworkType.MOBILE_4G) goto L15;
        return "4g";
    L15:
        if (r1 != NetworkType.MOBILE) goto L17;
        return "mobile";
    L17:
        return "";
    }

    public static String format(List<Pair<String, String>> r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, String>> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Pair<String, String> r1 = r6.next();
        String r2 = encode((String) r1.first, r5);
        String r3 = (String) r1.second;
        if (r3 == null) goto L8;
        String r7 = encode(r3, r5);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append(PARAMETER_SEPARATOR);
    L12:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r7);
        goto L4
    L8:
        r7 = "";
        goto L10
    L14:
        return r0.toString();
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
