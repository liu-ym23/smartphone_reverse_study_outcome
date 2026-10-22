package com.bytedance.applog.util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.applog.ISensitiveInfoProvider;
import com.bytedance.applog.Level;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b4;
import com.bytedance.bdtracker.q4;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.z3;
import com.stepos.pps.data.util.Constants;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SensitiveUtils {
    public static final String CHANNEL_APP_KEY = "UMENG_APPKEY";
    public static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_MAC = "mac_address";
    public static final String KEY_MC = "mc";
    public static final List<String> a = Collections.singletonList("SensitiveUtils");

    public static class a implements q4.a {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.q4.a
        public String a() {
            if (!SensitiveUtils.hasReadPhoneStatePermission(this.a)) {
                return null;
            }
            LoggerImpl.global().debug(SensitiveUtils.a, "[DeviceMeta&READ_PHONE_STATE] Try to get device id.", new Object[0]);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
                return telephonyManager == null ? "" : telephonyManager.getDeviceId();
            } catch (Throwable th) {
                LoggerImpl.global().error(SensitiveUtils.a, "Get device id failed", th, new Object[0]);
                return null;
            }
        }
    }

    public static class b implements q4.a {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // com.bytedance.bdtracker.q4.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String a() {
            /*
                r7 = this;
                r0 = 0
                r1 = 0
                android.content.Context r2 = r7.a     // Catch: java.lang.Throwable -> L5d
                boolean r2 = com.bytedance.applog.util.SensitiveUtils.hasReadPhoneStatePermission(r2)     // Catch: java.lang.Throwable -> L5d
                if (r2 == 0) goto L5b
                android.content.Context r7 = r7.a     // Catch: java.lang.Throwable -> L5d
                android.telephony.SubscriptionManager r7 = android.telephony.SubscriptionManager.from(r7)     // Catch: java.lang.Throwable -> L5d
                com.bytedance.applog.log.IAppLogLogger r2 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L49
                java.util.List<java.lang.String> r3 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Throwable -> L49
                java.lang.String r4 = "[DeviceMeta&READ_PHONE_STATE] Try to get active subscription info list."
                java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L49
                r2.debug(r3, r4, r5)     // Catch: java.lang.Throwable -> L49
                java.util.List r7 = r7.getActiveSubscriptionInfoList()     // Catch: java.lang.Throwable -> L49
                if (r7 == 0) goto L48
                boolean r2 = r7.isEmpty()     // Catch: java.lang.Throwable -> L49
                if (r2 == 0) goto L2a
                goto L48
            L2a:
                int r2 = r7.size()     // Catch: java.lang.Throwable -> L49
                java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L49
                r3 = r0
            L31:
                int r4 = r7.size()     // Catch: java.lang.Throwable -> L46
                if (r3 >= r4) goto L6c
                java.lang.Object r4 = r7.get(r3)     // Catch: java.lang.Throwable -> L46
                android.telephony.SubscriptionInfo r4 = (android.telephony.SubscriptionInfo) r4     // Catch: java.lang.Throwable -> L46
                java.lang.String r4 = r4.getIccId()     // Catch: java.lang.Throwable -> L46
                r2[r3] = r4     // Catch: java.lang.Throwable -> L46
                int r3 = r3 + 1
                goto L31
            L46:
                r7 = move-exception
                goto L4b
            L48:
                return r1
            L49:
                r7 = move-exception
                r2 = r1
            L4b:
                com.bytedance.applog.log.IAppLogLogger r3 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L59
                java.util.List<java.lang.String> r4 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Throwable -> L59
                java.lang.String r5 = "Get iccid failed"
                java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L59
                r3.error(r4, r5, r7, r6)     // Catch: java.lang.Throwable -> L59
                goto L6c
            L59:
                r7 = move-exception
                goto L5f
            L5b:
                r2 = r1
                goto L6c
            L5d:
                r7 = move-exception
                r2 = r1
            L5f:
                com.bytedance.applog.log.IAppLogLogger r3 = com.bytedance.applog.log.LoggerImpl.global()
                java.util.List<java.lang.String> r4 = com.bytedance.applog.util.SensitiveUtils.a
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r5 = "Get accId failed"
                r3.error(r4, r5, r7, r0)
            L6c:
                if (r2 != 0) goto L6f
                goto L75
            L6f:
                java.lang.String r7 = ","
                java.lang.String r1 = android.text.TextUtils.join(r7, r2)
            L75:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.util.SensitiveUtils.b.a():java.lang.String");
        }
    }

    public static class c implements q4.a {
        @Override // com.bytedance.bdtracker.q4.a
        public String a() throws SocketException {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterfaceNextElement.getName())) {
                    IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
                    List<String> list = SensitiveUtils.a;
                    StringBuilder sbA = com.bytedance.bdtracker.a.a("[DeviceMeta] Try to get hardware address from ");
                    sbA.append(networkInterfaceNextElement.getName());
                    sbA.append(".");
                    iAppLogLoggerGlobal.debug(list, sbA.toString(), new Object[0]);
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            }
            return "";
        }
    }

    public static class d implements q4.a {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.q4.a
        public String a() {
            if (!SensitiveUtils.hasReadPhoneStatePermission(this.a)) {
                return null;
            }
            LoggerImpl.global().debug(SensitiveUtils.a, "[DeviceMeta&READ_PHONE_STATE] Try to get imei and meid info", new Object[0]);
            int activeSubscriptionInfoCount = SubscriptionManager.from(this.a).getActiveSubscriptionInfoCount();
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            for (int i = 0; i < activeSubscriptionInfoCount; i++) {
                String imei = "";
                try {
                    jSONArray.put(SensitiveUtils.a(telephonyManager == null ? "" : telephonyManager.getMeid(i), i, "meid"));
                } catch (Throwable unused) {
                }
                if (telephonyManager == null) {
                    jSONArray.put(SensitiveUtils.a(imei, i, "imei"));
                } else {
                    try {
                        imei = telephonyManager.getImei(i);
                        jSONArray.put(SensitiveUtils.a(imei, i, "imei"));
                    } catch (Throwable unused2) {
                    }
                }
            }
            return jSONArray.toString();
        }
    }

    public static class e implements q4.a {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.q4.a
        public String a() {
            if (this.a.getApplicationInfo().targetSdkVersion < 26 || !SensitiveUtils.hasReadPhoneStatePermission(this.a)) {
                return "";
            }
            LoggerImpl.global().debug(SensitiveUtils.a, "[DeviceMeta&READ_PHONE_STATE] Try to get build serial.", new Object[0]);
            return Build.getSerial();
        }
    }

    public static String a(Context context, int i) {
        Object objInvoke = null;
        if (!hasReadPhoneStatePermission(context)) {
            return null;
        }
        LoggerImpl.global().debug(a, "[READ_PHONE_STATE] Try to get device id.", new Object[0]);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                Method method = telephonyManager.getClass().getMethod("getDeviceId", a("getDeviceId"));
                if (i >= 0) {
                    objInvoke = method.invoke(telephonyManager, Integer.valueOf(i));
                }
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Read phone info failed.", th, new Object[0]);
        }
        return (String) objInvoke;
    }

    public static JSONObject a(String str, int i, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("id", str);
            jSONObject.put("slot_index", i);
            jSONObject.put("type", str2);
        }
        return jSONObject;
    }

    public static Class[] a(String str) throws SecurityException {
        Class<?>[] parameterTypes = null;
        try {
            for (Method method : TelephonyManager.class.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length >= 1) {
                        LoggerImpl.global().debug(a, "params length:" + parameterTypes.length, new Object[0]);
                        return parameterTypes;
                    }
                }
            }
            return parameterTypes;
        } catch (Exception e2) {
            LoggerImpl.global().error(a, "TelephonyManager reflect method:{} failed", e2, str);
            return parameterTypes;
        }
    }

    public static void addSensitiveParamsForUrlQuery(b4 b4Var, StringBuilder sb, JSONObject jSONObject) {
        z3.a(sb, KEY_BUILD_SERIAL, (String) b4Var.a(jSONObject, KEY_BUILD_SERIAL, (String) null, (Class<String>) String.class));
        JSONArray jSONArray = (JSONArray) b4Var.a(jSONObject, "sim_serial_number", (String) null, (Class<String>) JSONArray.class);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder(((JSONObject) jSONArray.get(0)).optString("sim_serial_number"));
            for (int i = 1; i < jSONArray.length(); i++) {
                String strOptString = ((JSONObject) jSONArray.get(i)).optString("sim_serial_number");
                sb2.append(",");
                sb2.append(strOptString);
            }
            z3.a(sb, "sim_serial_number", sb2.toString());
        } catch (JSONException e2) {
            LoggerImpl.global().error(a, "failed to get sim_serial_number", e2, new Object[0]);
        }
    }

    public static void appendSensitiveParams(b4 b4Var, JSONObject jSONObject, Map<String, String> map, boolean z, Level level) {
        if (level == Level.L0) {
            if (z) {
                String str = (String) b4Var.a(jSONObject, KEY_MC, (String) null, (Class<String>) String.class);
                String str2 = (String) b4Var.a(jSONObject, "udid", (String) null, (Class<String>) String.class);
                if (!TextUtils.isEmpty(str)) {
                    map.put(KEY_MAC, str);
                }
                if (r.a(str2)) {
                    map.put("uuid", str2);
                }
            }
            String str3 = (String) b4Var.a(jSONObject, KEY_ALIYUN_UUID, (String) null, (Class<String>) String.class);
            if (!TextUtils.isEmpty(str3)) {
                map.put(KEY_ALIYUN_UUID, str3);
            }
        }
        String str4 = (String) b4Var.a(jSONObject, KEY_BUILD_SERIAL, (String) null, (Class<String>) String.class);
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        map.put(KEY_BUILD_SERIAL, str4);
    }

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return q4.a(context).a("TelephonyManager.getDeviceId", new a(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Get device id failed", th, new Object[0]);
            return null;
        }
    }

    public static String getMacAddress(ISensitiveInfoProvider iSensitiveInfoProvider, Context context) {
        return iSensitiveInfoProvider != null ? iSensitiveInfoProvider.getMac() : getMacAddressFromSystem(context);
    }

    public static String getMacAddressFromSystem(Context context) {
        String strA;
        try {
            strA = q4.a(context).a("NetworkInterface.getHardwareAddress", new c());
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Get HardwareAddress failed", th, new Object[0]);
            strA = null;
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || wifiManager.getConnectionInfo() == null) ? strA : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Throwable th2) {
            LoggerImpl.global().error(a, "Get MacAddress failed", th2, new Object[0]);
            return strA;
        }
    }

    public static JSONArray getMultiImeiFallback(Context context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(a(context, 0), 0, Constants.UNKNOWN));
        jSONArray.put(a(a(context, 1), 1, Constants.UNKNOWN));
        return jSONArray;
    }

    public static JSONArray getMultiImeiFromSystem(Context context) {
        try {
            String strA = q4.a(context).a("TelephonyManager.getMultiImei", new d(context));
            return TextUtils.isEmpty(strA) ? new JSONArray() : new JSONArray(strA);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Failed to get meid 0", th, new Object[0]);
            return null;
        }
    }

    public static String getSerialNumber(Context context) {
        String strA = null;
        if (context == null) {
            return null;
        }
        try {
            strA = q4.a(context).a("Build.getSerial", new e(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Build getSerial failed.", th, new Object[0]);
        }
        if (TextUtils.isEmpty(strA) || TextUtils.equals(strA, Constants.UNKNOWN)) {
            strA = Build.SERIAL;
        }
        return (TextUtils.isEmpty(strA) || TextUtils.equals(strA, Constants.UNKNOWN)) ? "" : strA;
    }

    public static String[] getSimSerialNumbers(Context context) {
        if (context == null) {
            return new String[0];
        }
        try {
            String strA = q4.a(context).a("SubscriptionInfo.getIccid", new b(context));
            if (!TextUtils.isEmpty(strA)) {
                return strA.split(",");
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "getSimSerialNumbers failed", th, new Object[0]);
        }
        return new String[0];
    }

    public static boolean hasPermission(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "check has permission failed.", th, new Object[0]);
            return false;
        }
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        return hasPermission(context, "android.permission.READ_PRECISE_PHONE_STATE");
    }

    public static boolean validMultiImei(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return validMultiImei(new JSONArray(str));
            } catch (JSONException e2) {
                LoggerImpl.global().error(a, "JSON handle failed", e2, new Object[0]);
            }
        }
        return false;
    }

    public static boolean validMultiImei(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("id"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
