package com.bytedanceos.common.toolbox;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.utils.ReflectTool;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9978a = "";

    public static final enum Operator extends Enum<Operator> {
        private static final /* synthetic */ Operator[] $VALUES = null;
        public static final Operator CHINA_MOBILE = null;
        public static final Operator CHINA_TELECOM = null;
        public static final Operator CHINA_UNICOM = null;
        public static final Operator UNKNOWN = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f9979id;

        private static /* synthetic */ Operator[] $values() {
            return new Operator[]{UNKNOWN, CHINA_TELECOM, CHINA_MOBILE, CHINA_UNICOM};
        }

        static {
            UNKNOWN = new Operator("UNKNOWN", 0, 4);
            CHINA_TELECOM = new Operator("CHINA_TELECOM", 1, 1);
            CHINA_MOBILE = new Operator("CHINA_MOBILE", 2, 2);
            CHINA_UNICOM = new Operator("CHINA_UNICOM", 3, 3);
            $VALUES = $values();
        }

        private Operator(String r10, int r11, int r12) {
            super(r10, r11);
            this.f9979id = r12;
        }

        public static Operator valueOf(String r10) {
            return (Operator) Enum.valueOf(Operator.class, r10);
        }

        public static Operator[] values() {
            return (Operator[]) $VALUES.clone();
        }

        public int getId() {
            return this.f9979id;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type MOBILE = null;
        public static final Type MOBILE2G = null;
        public static final Type MOBILE3G = null;
        public static final Type MOBILE4G = null;
        public static final Type UNKNOWN = null;
        public static final Type WIFI = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f9980id;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{UNKNOWN, WIFI, MOBILE, MOBILE2G, MOBILE3G, MOBILE4G};
        }

        static {
            UNKNOWN = new Type("UNKNOWN", 0, 0);
            WIFI = new Type("WIFI", 1, 1);
            MOBILE = new Type("MOBILE", 2, 2);
            MOBILE2G = new Type("MOBILE2G", 3, 2);
            MOBILE3G = new Type("MOBILE3G", 4, 3);
            MOBILE4G = new Type("MOBILE4G", 5, 4);
            $VALUES = $values();
        }

        private Type(String r10, int r11, int r12) {
            super(r10, r11);
            this.f9980id = r12;
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public int getId() {
            return this.f9980id;
        }
    }

    static {
    }

    public static String a() {
        String r10 = Settings.Secure.getString(BaseApplication.c().getContentResolver(), "android_id");     // Catch: Exception -> L4
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L11;
        return null;
    L11:
        if (r10.length() >= 16) goto L13;
        r10 = AdReportParam.ClickPosType.SKIP + r10;
        goto L11
    L13:
        return r10;
    L4:
        e = move-exception;
        j.q("catch Exception when involke getAndroidId()", e);
        r10 = "";
        goto L7
    }

    public static String b() {
        TelephonyManager r10 = (TelephonyManager) BaseApplication.c().getSystemService("phone");     // Catch: Exception -> L13
        if (r10 != null) goto L7;
        return "";
    L7:
        if (r10.getSimState() == 5) goto L10;
        return "";
    L10:
        if (r10.getPhoneType() != 2) goto L16;
        return r10.getNetworkOperator();
    L16:
        return r10.getSimOperator();
    L13:
        e = move-exception;
        j.n("FATAL: " + e.getMessage());
        return "";
    }

    public static NetworkInfo c(Context r10) {
        ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Exception -> L9
        if (r11 == null) goto L7;
        NetworkInfo r12 = r11.getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r12 == null) goto L12;
        return r12;
    L12:
        return null;
    L7:
        return null;
    L13:
        return null;
    }

    public static Type d(Context r10) {
        Type r11 = Type.UNKNOWN;
        NetworkInfo r12 = c(r10);
        if (r12 == null) goto L27;
        int r13 = r12.getType();
        if (r13 != 0) goto L7;
        int r14 = r12.getSubtype();
        String r15 = r12.getSubtypeName();
        switch(r14) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L30;
            case 4: goto L26;
            case 5: goto L30;
            case 6: goto L30;
            case 7: goto L26;
            case 8: goto L30;
            case 9: goto L30;
            case 10: goto L30;
            case 11: goto L26;
            case 12: goto L30;
            case 13: goto L23;
            case 14: goto L30;
            case 15: goto L30;
            default: goto L13;
        };
    L13:
        if (r15.equalsIgnoreCase("TD-SCDMA") == true) goto L29;
        if (r15.equalsIgnoreCase("WCDMA") == true) goto L29;
        if (r15.equalsIgnoreCase("CDMA2000") == true) goto L29;
        return Type.MOBILE;
    L29:
        return Type.MOBILE3G;
    L23:
        return Type.MOBILE4G;
    L30:
        return Type.MOBILE3G;
    L26:
        return Type.MOBILE2G;
    L7:
        if (r13 == 1) goto L28;
        return r11;
    L28:
        return Type.WIFI;
    L27:
        return r11;
    }

    public static String e() {
        if (TextUtils.isEmpty(f9978a) == false) goto L5;
        String r10 = ReflectTool.getBytedanceID();
        f9978a = r10;
        return r10;
    L5:
        return f9978a;
    }

    public static int f() {
        if (DeviceType.is(DeviceType.T1) == false) goto L6;
        return 0;
    L6:
        if (DeviceType.is(DeviceType.T2) == false) goto L9;
        return 2;
    L9:
        if (DeviceType.is(DeviceType.M1) == false) goto L11;
    L35:
        return 3;
    L11:
        if (DeviceType.is(DeviceType.M1L) == true) goto L35;
        if (DeviceType.is(DeviceType.ODIN) == false) goto L17;
        return 4;
    L17:
        if (DeviceType.is(DeviceType.OSBORN) == false) goto L20;
        return 5;
    L20:
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L23;
        return 7;
    L23:
        if (DeviceType.is(DeviceType.TRIDENT) == false) goto L26;
        return 6;
    L26:
        if (DeviceType.is(DeviceType.OCEAN) == false) goto L29;
        return 8;
    L29:
        if (DeviceType.is(DeviceType.DELTA) == false) goto L32;
        return 9;
    L32:
        if (DeviceType.is(DeviceType.DARWIN) == false) goto L34;
        return 10;
    L34:
        return -1;
    }

    public static String[] g(Context r10) {
        String[] r11 = {"", ""};
        LocationManager r12 = (LocationManager) r10.getSystemService("location");
        List<String> r13 = r12.getProviders(true);
        String r14 = "gps";
        if (r13.contains("gps") == true) goto L9;
        r14 = "network";
        if (r13.contains("network") == true) goto L9;
        r14 = null;
    L9:
        if (r14 != null) goto L17;
    L16:
        return r11;
    L17:
        Location r15 = r12.getLastKnownLocation(r14);     // Catch: Exception -> L14
        if (r15 == null) goto L16;
        r11[0] = String.valueOf(r15.getLatitude());     // Catch: Exception -> L14
        r11[1] = String.valueOf(r15.getLongitude());     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static String h() {
        Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L18
    L4:
        if (r10.hasMoreElements() == false) goto L31;
        NetworkInterface r11 = r10.nextElement();     // Catch: Exception -> L18
        if (r11 == null) goto L4;
        Enumeration<InetAddress> r12 = r11.getInetAddresses();     // Catch: Exception -> L18
    L9:
        if (r12.hasMoreElements() == false) goto L4;
        InetAddress r13 = r12.nextElement();     // Catch: Exception -> L18
        if (r13.isLoopbackAddress() == true) goto L9;
        if ((r13 instanceof Inet4Address) == false) goto L9;
        return r13.getHostAddress();
    L31:
        return "0.0.0.0";
    L16:
        return "0.0.0.0";
    }

    public static Operator i(Context r10) {
        String r11 = ((TelephonyManager) r10.getSystemService("phone")).getSimOperator();
        if (r11 == null) goto L22;
        if (r11.equals("46000") == true) goto L20;
        if (r11.equals("46002") == true) goto L20;
        if (r11.equals("46007") == true) goto L20;
        if (r11.equals("46001") == false) goto L16;
        return Operator.CHINA_UNICOM;
    L16:
        if (r11.equals("46003") == false) goto L22;
        return Operator.CHINA_TELECOM;
    L20:
        return Operator.CHINA_MOBILE;
    L22:
        return Operator.UNKNOWN;
    }

    public static String j() {
        return "mobile";
    }

    public static boolean k(Context r10) {
        return false;
    }
}
