package cn.com.chinatelecom.account;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f24442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f24443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f24444c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f24445d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f24446e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f24447f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f24448g = "0";

    static {
        f24442a = new String[]{"46000", "46002", "46004", "46007", "46008"};
        f24443b = new String[]{"46003", "46005", "46011"};
        f24444c = new String[]{"46001", "46006", "46009"};
    }

    private static int a(int r100) {
        int r101 = -101;
        if (r100 == (-101)) goto L16;
        r101 = -1;
        if (r100 == (-1)) goto L16;
        switch(r100) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L10;
            case 14: goto L12;
            case 15: goto L12;
            case 16: goto L14;
            case 17: goto L12;
            case 18: goto L10;
            case 19: goto L10;
            case 20: goto L8;
            default: goto L7;
        };
    L7:
        return r100;
    L8:
        return 4;
    L10:
        return 3;
    L12:
        return 2;
    L14:
        return 1;
    L16:
        return r101;
    }

    public static NetworkInfo a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String a() {
        if (f24446e != null) goto L5;
        return "https://open.e.189.cn/openapi/special/getTimeStamp.do";
    L5:
        return "https://open.e.189.cn/openapi/special/getTimeStamp.do".replace(h0.a(e.f24391h), f24446e);
    }

    public static String a(Context r100, boolean r101) {
        String r102 = i(r100);
        if (r102 == null) goto L31;
        String[] r103 = f24443b;
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L13;
        if (r102.equals(r103[r106]) == true) goto L8;
        r106 = r106 + 1;
        goto L5
    L8:
        if (r101 == false) goto L10;
        return "1";
    L10:
        return "CT";
    L13:
        String[] r107 = f24442a;
        int r108 = r107.length;
        int r109 = 0;
    L14:
        if (r109 >= r108) goto L22;
        if (r102.equals(r107[r109]) == true) goto L17;
        r109 = r109 + 1;
        goto L14
    L17:
        if (r101 == false) goto L19;
        return "2";
    L19:
        return "CM";
    L22:
        String[] r110 = f24444c;
        int r111 = r110.length;
    L23:
        if (r105 >= r111) goto L31;
        if (r102.equals(r110[r105]) == true) goto L26;
        r105 = r105 + 1;
        goto L23
    L26:
        if (r101 == false) goto L28;
        return "3";
    L28:
        return "CU";
    L31:
        if (r101 == false) goto L33;
        return "0";
    L33:
        return "UN";
    }

    public static void a(Context r100, long r101) {
        h.b(r100, "key_s_p_dm_time", r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Context r100, String r101) {
        h.b(r100, "key_s_p_dm", r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static String b() {
        return f24445d;
    }

    public static String b(Context r100) {
        int r101 = d(r100);
        if (r101 != (-101)) goto L5;
        return "WIFI";
    L5:
        if (r101 == (-1)) goto L20;
        if (r101 == 0) goto L20;
        if (r101 != 1) goto L10;
        return "2G";
    L10:
        if (r101 != 2) goto L12;
        return "3G";
    L12:
        if (r101 != 3) goto L14;
        return "4G";
    L14:
        if (r101 != 4) goto L23;
        return "5G";
    L23:
        return Integer.toString(r101);
    L20:
        return "null";
    }

    public static String c() {
        String r100 = f24447f;
        if (r100 != null) goto L5;
        return "https://api-e189.21cn.com/gw/client/accountMsg.do";
    L5:
        return "https://api-e189.21cn.com/gw/client/accountMsg.do".replace("e189.21cn.com", r100);
    }

    public static String c(Context r100) {
        String r101 = b(r100);
        if (r101 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r101.equals("WIFI") == false) goto L10;
        if (k(r100) == false) goto L10;
        return "BOTH";
    }

    private static int d(Context r100) {
        NetworkInfo r101 = a(r100);     // Catch: Throwable -> L15 NullPointerException -> L17
        if (r101 != null) goto L5;
    L14:
        int r102 = -1;
    L21:
        return a(r102);
    L5:
        if (r101.isAvailable() == false) goto L14;
        if (r101.isConnected() == false) goto L14;
        int r103 = r101.getType();     // Catch: Throwable -> L15 NullPointerException -> L17
        if (r103 != 1) goto L11;
        r102 = -101;
        goto L21
    L11:
        if (r103 != 0) goto L19;
        r102 = r101.getSubtype();     // Catch: Throwable -> L15 NullPointerException -> L17
    L19:
        r102 = 0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static String e(Context r100) {
        String r101 = c(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L31:
        return Constants.VIA_REPORT_TYPE_WPA_STATE;
    L5:
        if (r101.equals("null") == true) goto L31;
        if (r101.equals("2G") == false) goto L12;
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
    L12:
        if (r101.equals("3G") == false) goto L16;
        return "11";
    L16:
        if (r101.equals("4G") == false) goto L20;
        return "12";
    L20:
        if (r101.equals("5G") == false) goto L24;
        return Constants.VIA_REPORT_TYPE_START_WAP;
    L24:
        if (r101.equals("WIFI") == false) goto L28;
        return "13";
    L28:
        if (r101.equals("BOTH") == false) goto L31;
        return Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
    }

    public static String f(Context r100) {
        String r101 = g(r100);
        String r102 = t.b();
        String r103 = t.b().replace(h0.a(e.f24389f), h0.a(e.f24390g));
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r102;
    L6:
        if (r101.equals("1") == false) goto L9;
        return r102;
    L9:
        if (r101.equals("2") == false) goto L11;
        return r103;
    L11:
        return r102;
    }

    public static String g(Context r100) {
        if ((System.currentTimeMillis() - h(r100)) <= 172800000) goto L10;
        return null;
    L10:
        return h.a(r100, "key_s_p_dm", null);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static long h(Context r100) {
        Long r101 = Long.valueOf(h.a(r100, "key_s_p_dm_time", 0));     // Catch: Exception -> L4
    L7:
        return r101.longValue();
    L4:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L7
    }

    public static String i(Context r100) {
        String r101 = cn_com_chinatelecom_account_r_android_telephony_TelephonyManager_getSimOperator((TelephonyManager) r100.getSystemService("phone"));     // Catch: Throwable -> L5
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return r101;
    L11:
        return "00000";
    L5:
        th = move-exception;
        th.printStackTrace();
        return "00000";
    }

    public static String j(Context r100) {
        return a(r100, true);
    }

    public static boolean k(Context r100) {
        if (r100 != null) goto L10;
        return true;
    L10:
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L7
        Method r102 = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Throwable -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L7
        return ((Boolean) r102.invoke(r101, new Object[0])).booleanValue();
    L7:
        th = move-exception;
        CtAuth.warn("NetUtil", "isMobileEnable error ", th);
        return true;
    }

    public static boolean l(Context r100) {
        NetworkInfo r101 = a(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getType() != 0) goto L7;
        return true;
    }

    public static boolean m(Context r100) {
        NetworkInfo r101 = a(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isAvailable() == false) goto L7;
        return true;
    }

    private static String cn_com_chinatelecom_account_r_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }
}
