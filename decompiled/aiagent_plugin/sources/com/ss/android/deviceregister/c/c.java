package com.ss.android.deviceregister.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.utility.j;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.deviceregister.g;
import com.ss.android.deviceregister.o;
import com.ss.android.deviceregister.v;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: HardwareUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "hwinfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f<String> f37413a = null;

    static /* synthetic */ String k(Context r2) {
        return l((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    public static String a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if (r6 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
    L14:
        v r1 = g.r();
        if (g.s() == false) goto L18;
        if (r1 == null) goto L18;
        boolean r3 = true;
    L20:
        if (Build.VERSION.SDK_INT < 26) goto L29;
        if (r6.getApplicationInfo().targetSdkVersion < 26) goto L29;
        if (r3 == false) goto L25;
        String r7 = r1.a();     // Catch: SecurityException -> L27
    L26:
        r0 = r7;
        goto L29
    L25:
        r7 = Build.getSerial();     // Catch: SecurityException -> L27
    L27:
        o.a(TAG, "没有READ_PRIVILEGED_PHONE_STATE权限或者READ_PHONE_STATE权限,获取Build.SERIAL失败");
    L29:
        if (j.a(r0) == false) goto L31;
    L32:
        r0 = Build.SERIAL;
    L34:
        if (j.a(r0) == false) goto L36;
        return "";
    L36:
        if (TextUtils.equals(r0, SensitiveType.UNKNOWN) == true) goto L43;
        return r0;
    L43:
        return "";
    L31:
        if (TextUtils.equals(r0, SensitiveType.UNKNOWN) == false) goto L34;
    L18:
        r3 = false;
        goto L20
    L8:
        if (r6.getApplicationInfo().targetSdkVersion < 26) goto L14;
        if (g.u() == false) goto L14;
        if (d.a(r6) == true) goto L14;
        return null;
    }

    public static String[] b(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        String[] r0 = null;
        if (r9 != null) goto L5;
    L44:
        return r0;
    L5:
        if (e.x() == true) goto L44;
        if (g.u() == false) goto L13;
        if (d.a(r9) == true) goto L13;
        return null;
    L13:
        if (e.a(r9) == false) goto L15;
        return null;
    L15:
        v r2 = g.r();
        int r5 = 0;
        if (g.s() == false) goto L19;
        if (r2 == null) goto L19;
        boolean r3 = true;
    L45:
    L42:
        th = move-exception;
        th.printStackTrace();
        goto L44
    L21:
        if (Build.VERSION.SDK_INT < 22) goto L37;
        if (r3 == false) goto L24;
        List<SubscriptionInfo> r10 = r2.k();     // Catch: Throwable -> L42
    L25:
        if (r10 != null) goto L27;
    L36:
        return null;
    L27:
        if (r10.isEmpty() == true) goto L36;
        r0 = new String[r10.size()];     // Catch: Throwable -> L42
    L31:
        if (r5 >= r10.size()) goto L44;
        if (r3 == false) goto L34;
        String r4 = r2.a((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r10.get(r5), SubscriptionInfo.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L42
    L35:
        r0[r5] = r4;     // Catch: Throwable -> L42
        r5 = r5 + 1;     // Catch: Throwable -> L42
        goto L31
    L34:
        r4 = ((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r10.get(r5), SubscriptionInfo.class, "com.obric.aiagent.plugin")).getIccId();     // Catch: Throwable -> L42
        goto L35
    L24:
        r10 = SubscriptionManager.from(r9).getActiveSubscriptionInfoList();     // Catch: Throwable -> L42
        goto L25
    L37:
        r0 = new String[1];     // Catch: Throwable -> L42
        if (r3 == false) goto L40;
        r0[0] = r2.m();     // Catch: Throwable -> L42
        goto L44
    L40:
        r0[0] = ((TelephonyManager) ZeusTransformUtils.preCheckCast(r9.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getSimSerialNumber();     // Catch: Throwable -> L42
    L19:
        r3 = false;
        goto L45
    }

    public static String c(Context r2) {
        return Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), SensitiveType.ANDROID_ID);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (g.s() == false) goto L9;
        if (g.r() == null) goto L9;
        return g.r().b();
    L9:
        return ((TelephonyManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getNetworkOperator();
    }

    public static String e(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (g.s() == false) goto L9;
        if (g.r() == null) goto L9;
        return g.r().c();
    L9:
        return ((TelephonyManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getNetworkOperatorName();
    }

    public static String f(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (g.s() == false) goto L9;
        if (g.r() == null) goto L9;
        return g.r().d();
    L9:
        return ((TelephonyManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getSimCountryIso();
    }

    public static String g(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a("getDeviceId", "CHINA DEVICEID");
        if (r4 != null) goto L6;
        return null;
    L6:
        if (g.u() == false) goto L11;
        if (d.a(r4) == true) goto L11;
        return null;
    L11:
        if (e.a(r4) == false) goto L24;
        return null;
    L24:
    L21:
        e = move-exception;
        e.printStackTrace();
        return null;
    L14:
        if (g.s() == false) goto L20;
        if (g.r() == null) goto L20;
        return g.r().l();
    L20:
        return ((TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getDeviceId();
    }

    public static WifiInfo h(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        return null;
    L20:
        v r2 = g.r();     // Catch: Exception -> L17
        if (g.s() == false) goto L9;
        if (r2 == null) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        WifiInfo r4 = r2.i();     // Catch: Exception -> L17
        String r5 = r2.a(r4);     // Catch: Exception -> L17
    L13:
        if (((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L19;
        if (r5 == null) goto L19;
        return r4;
    L19:
        return null;
    L12:
        r4 = ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin")).getConnectionInfo();     // Catch: Exception -> L17
        r5 = r4.getSSID();     // Catch: Exception -> L17
    L9:
        r3 = false;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private static String l(Context r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        String r2 = "";
        if (e.y() == true) goto L5;
    L7:
        v r0 = g.r();
        if (g.s() == false) goto L11;
        if (r0 == null) goto L11;
        boolean r3 = true;
    L12:
        WifiInfo r17 = h(r16);
        if (r17 == null) goto L19;
        if (r3 == false) goto L16;
        String r18 = r0.b(r17);
    L17:
        r2 = r18;
        goto L19
    L16:
        r18 = r17.getMacAddress();
    L19:
        if ("02:00:00:00:00:00".equals(r2) == false) goto L21;
    L48:
        if (r0 == null) goto L24;
        Enumeration<NetworkInterface> r19 = r0.j();     // Catch: Exception -> L45
    L25:
        String r6 = b();     // Catch: Exception -> L45
    L26:
        if (r19.hasMoreElements() == false) goto L62;
        NetworkInterface r7 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r19.nextElement(), NetworkInterface.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L45
        if (r3 == false) goto L31;
        byte[] r8 = r0.a(r7);     // Catch: Exception -> L45
    L32:
        if (r8 == null) goto L26;
        if (r8.length == 0) goto L26;
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L45
        int r10 = r8.length;     // Catch: Exception -> L45
        int r11 = 0;
    L37:
        if (r11 >= r10) goto L40;
        r9.append(String.format("%02X:", new Object[]{Byte.valueOf(r8[r11])}));     // Catch: Exception -> L45
        r11 = r11 + 1;     // Catch: Exception -> L45
        goto L37
    L40:
        if (r9.length() <= 0) goto L42;
        r9.deleteCharAt(r9.length() - 1);     // Catch: Exception -> L45
    L42:
        String r12 = r9.toString();     // Catch: Exception -> L45
        if (r7.getName().equals(r6) == false) goto L26;
        return r12;
    L31:
        r8 = r7.getHardwareAddress();     // Catch: Exception -> L45
        goto L32
    L62:
        return r2;
    L24:
        r19 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
        return r2;
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L48;
        return r2;
    L11:
        r3 = false;
        goto L12
    L5:
        if (e.c(r16) == false) goto L7;
        return "";
    }

    private static String b() {
        Class r2 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return (String) ZeusTransformUtils.preCheckCast(r2.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r2, new Object[]{"wifi.interface", "wlan0"}), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        return "wlan0";
    }

    public static JSONArray i(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (g.u() == true) goto L5;
    L8:
        v r0 = g.r();
        if (g.s() == false) goto L12;
        if (r0 == null) goto L12;
        boolean r2 = true;
    L13:
        JSONArray r5 = new JSONArray();
        TelephonyManager r1 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r9.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L49;
        r5.put(a(a(r9, 0), 0, SensitiveType.UNKNOWN));
        r5.put(a(a(r9, 1), 1, SensitiveType.UNKNOWN));
    L46:
        return r5;
    L49:
        if (r2 == false) goto L18;
        String r6 = r0.g();     // Catch: Exception -> L21
    L19:
        r5.put(a(r6, 0, SensitiveType.MEID));     // Catch: Exception -> L21
    L53:
        if (r2 == false) goto L25;
        String r7 = r0.h();     // Catch: Exception -> L28
    L26:
        r5.put(a(r7, 1, SensitiveType.MEID));     // Catch: Exception -> L28
    L47:
        if (r2 == false) goto L33;
        String r10 = r0.e();     // Catch: Exception -> L36
    L34:
        r5.put(a(r10, 0, SensitiveType.IMEI));     // Catch: Exception -> L36
    L51:
        if (r2 == false) goto L40;
        String r3 = r0.f();     // Catch: Exception -> L43
    L41:
        r5.put(a(r3, 1, SensitiveType.IMEI));     // Catch: Exception -> L43
        goto L46
    L40:
        r3 = r1.getImei(1);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L33:
        r10 = r1.getImei(0);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L51
    L25:
        r7 = r1.getMeid(1);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L47
    L18:
        r6 = r1.getMeid(0);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L12:
        r2 = false;
        goto L13
    L5:
        if (d.a(r9) == true) goto L8;
        return new JSONArray();
    }

    public static boolean a(JSONArray r5) {
        if (r5 == null) goto L14;
        int r1 = r5.length();
        if (r1 <= 0) goto L19;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.optString(DbHelper.COL_ID)) == true) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    L14:
        return false;
    }

    private static JSONObject a(String r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put(DbHelper.COL_ID, r2);
        r0.put("slot_index", r3);
        r0.put("type", r4);
    L5:
        return r0;
    }

    private static Class[] a(String r6) {
        Class<?>[] r0 = null;
        Method[] r1 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L12
        int r2 = r1.length;     // Catch: Exception -> L12
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L14;
        Method r4 = r1[r3];     // Catch: Exception -> L12
        if (r6.equals(r4.getName()) == false) goto L11;
        r0 = r4.getParameterTypes();     // Catch: Exception -> L12
        if (r0.length < 1) goto L11;
        o.b(o.f37441a, "length:" + r0.length);     // Catch: Exception -> L12
    L11:
        r3 = r3 + 1;
    L14:
        return r0;
    L12:
        e = move-exception;
        e.printStackTrace();
        o.b(o.f37441a, e.getMessage(), e);
        goto L14
    }

    private static Object a(int r3, String r4, Context r5) {
        TelephonyManager r6 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (Build.VERSION.SDK_INT < 21) goto L14;
        Method r7 = r6.getClass().getMethod(r4, a(r4));     // Catch: Exception -> L9
        if (r3 < 0) goto L15;
        return r7.invoke(r6, new Object[]{Integer.valueOf(r3)});
    L15:
        return null;
    L14:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        o.b(o.f37441a, e.getMessage(), e);
        return null;
    }

    private static String a(Context r2, int r3) {
        String r4 = (String) ZeusTransformUtils.preCheckCast(a(r3, "getDeviceId", (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        o.b(o.f37441a, "getDeviceId  deviceId=" + r4);
        return r4;
    }

    public static String a() {
        return Locale.getDefault().getCountry();
    }

    static {
        f37413a = new AnonymousClass1();
    }

    public static String j(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (String) ZeusTransformUtils.preCheckCast(f37413a.c(new Object[]{r5}), String.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
