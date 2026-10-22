package com.bytedance.bdinstall;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SstInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, al> f6157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static al f6158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f6159c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f6160d;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.ay$1, reason: invalid class name */
    /* JADX INFO: compiled from: SstInfoCompat.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: SstInfoCompat.java */
    private static final class a implements al {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.bdinstall.al
        public String b(Context r2, an r3) {
        L13:
            t.b("no get_phone_state permission,getDeviceId return null");
            return null;
        L4:
            if (com.bytedance.bdinstall.j.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")) == false) goto L10;
            if (ay.a().compareAndSet(false, true) == false) goto L10;
            return r3.aa().e();
        L10:
            if (ay.a().get() == false) goto L17;
            t.a("getDefaultImeiOrMeid# get Meid from memory cache： " + ay.b());     // Catch: Exception -> L13
            return ay.b();
        L17:
            return null;
        }

        @Override // com.bytedance.bdinstall.al
        public String a(Context r7, an r8) {
            WifiInfo r6 = ay.a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8);
            com.bytedance.bdinstall.f.b r9 = r8.aa();
            String r10 = r9.b(r6);
            if ("02:00:00:00:00:00".equals(r10) == false) goto L5;
        L29:
            Enumeration<NetworkInterface> r11 = r9.c();     // Catch: Exception -> L26
            String r1 = a();     // Catch: Exception -> L26
        L8:
            if (r11.hasMoreElements() == false) goto L43;
            NetworkInterface r2 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r11.nextElement(), NetworkInterface.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
            if (r2.getName().equals(r1) == false) goto L8;
            byte[] r3 = r9.a(r2);     // Catch: Exception -> L26
            if (r3 == null) goto L8;
            if (r3.length == 0) goto L8;
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L26
            int r13 = r3.length;     // Catch: Exception -> L26
            int r4 = 0;
        L19:
            if (r4 >= r13) goto L22;
            r12.append(String.format("%02X:", new Object[]{Byte.valueOf(r3[r4])}));     // Catch: Exception -> L26
            r4 = r4 + 1;     // Catch: Exception -> L26
            goto L19
        L22:
            if (r12.length() <= 0) goto L24;
            r12.deleteCharAt(r12.length() - 1);     // Catch: Exception -> L26
        L24:
            return r12.toString();
        L43:
            return r10;
        L26:
            e = move-exception;
            e.printStackTrace();
            return r10;
        L5:
            if (TextUtils.isEmpty(r10) == true) goto L29;
            return r10;
        }

        @Override // com.bytedance.bdinstall.al
        public String a(Context r2, int r3, an r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return r4.aa().b(r3);
        }

        @Override // com.bytedance.bdinstall.al
        public String b(Context r2, int r3, an r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return r4.aa().a(r3);
        }

        @Override // com.bytedance.bdinstall.al
        public String a(Context r2, int r3) {
            String r1 = (String) ZeusTransformUtils.preCheckCast(a(r3, "getDeviceId", (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
            t.a("getDeviceId  deviceId=" + r1);
            return r1;
        }

        @Override // com.bytedance.bdinstall.al
        public String c(Context r2, an r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            com.bytedance.bdinstall.f.b r4 = r3.aa();
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L8:
            String r5 = null;
        L10:
            if (TextUtils.isEmpty(r5) == false) goto L12;
        L13:
            r5 = Build.SERIAL;
        L15:
            if (TextUtils.isEmpty(r5) == false) goto L17;
            return "";
        L17:
            if (TextUtils.equals(r5, SensitiveType.UNKNOWN) == true) goto L25;
            return r5;
        L25:
            return "";
        L12:
            if (TextUtils.equals(r5, SensitiveType.UNKNOWN) == false) goto L15;
        L5:
            if (r1.getApplicationInfo().targetSdkVersion < 26) goto L8;
            r5 = r4.a();     // Catch: Throwable -> L22
            goto L10
        }

        @Override // com.bytedance.bdinstall.al
        public String[] d(Context r5, an r6) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            com.bytedance.bdinstall.f.b r7 = r6.aa();
        L20:
            th = move-exception;
            th.printStackTrace();
            return null;
        L4:
            int r2 = 0;
            if (Build.VERSION.SDK_INT < 22) goto L27;
            List<SubscriptionInfo> r8 = r7.d();     // Catch: SecurityException -> L17 Throwable -> L20
            if (r8 == null) goto L16;
            if (r8.isEmpty() == true) goto L16;
            String[] r9 = new String[r8.size()];     // Catch: SecurityException -> L17 Throwable -> L20
        L13:
            if (r2 >= r8.size()) goto L28;
            r9[r2] = r7.a((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r8.get(r2), SubscriptionInfo.class, "com.obric.aiagent.plugin"));     // Catch: SecurityException -> L17 Throwable -> L20
            r2 = r2 + 1;     // Catch: SecurityException -> L17 Throwable -> L20
            goto L13
        L28:
            return r9;
        L16:
            return new String[0];
        L17:
            t.a("getSSN , no permission, ignore");     // Catch: Throwable -> L20
            return null;
        L27:
            return new String[]{r7.f()};
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
            t.b(e.getMessage(), e);
            return null;
        }

        private static Class<?>[] a(String r6) {
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
            t.a("length:" + r0.length);     // Catch: Exception -> L12
        L11:
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            e = move-exception;
            e.printStackTrace();
            t.b(e.getMessage(), e);
            goto L14
        }

        private static String a() {
            String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.j.u.a("wifi.interface"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return "wlan0";
        L7:
            return r1;
        L8:
            e = move-exception;
            e.printStackTrace();
            return "wlan0";
        }

        @Override // com.bytedance.bdinstall.al
        public JSONArray a(Context r13) {
            Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
            JSONArray r15 = new JSONArray();
        L44:
            e = move-exception;
            e.printStackTrace();
        L46:
            return r15;
        L4:
            if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
            Iterator r0 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L44
        L9:
            if (r0.hasNext() == false) goto L46;
            NetworkInterface r2 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r0.next(), NetworkInterface.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L44
            String r3 = r2.getName();     // Catch: Exception -> L44
            if ("dummy0".equals(r3) == true) goto L16;
            if ("wlan0".equals(r3) == false) goto L9;
        L16:
            Iterator r4 = Collections.list(r2.getInetAddresses()).iterator();     // Catch: Exception -> L44
        L18:
            if (r4.hasNext() == false) goto L9;
            String r5 = ((InetAddress) ZeusTransformUtils.preCheckCast(r4.next(), InetAddress.class, "com.obric.aiagent.plugin")).getHostAddress();     // Catch: Exception -> L44
            if (TextUtils.isEmpty(r5) == true) goto L18;
            if (r5.indexOf(58) >= 0) goto L24;
            boolean r6 = true;
        L25:
            if (r6 == true) goto L18;
            int r7 = r5.indexOf(37);     // Catch: Exception -> L44
            if ("dummy0".equals(r3) == true) goto L29;
            if ("wlan0".equals(r3) == true) goto L38;
            if ("fe80".equalsIgnoreCase(r5.split("::")[0]) == false) goto L18;
        L38:
            JSONObject r8 = new JSONObject();     // Catch: Exception -> L44
            r8.put("type", "client_anpi");     // Catch: Exception -> L44
            if (r7 < 0) goto L42;
            r5 = r5.substring(0, r7);     // Catch: Exception -> L44
        L42:
            r8.put("value", r5.toUpperCase());     // Catch: Exception -> L44
            r15.put(r8);     // Catch: Exception -> L44
            goto L18
        L29:
            JSONObject r9 = new JSONObject();     // Catch: Exception -> L44
            r9.put("type", "client_tun");     // Catch: Exception -> L44
            if (r7 < 0) goto L33;
            r5 = r5.substring(0, r7);     // Catch: Exception -> L44
        L33:
            r9.put("value", r5.toUpperCase());     // Catch: Exception -> L44
            r15.put(r9);     // Catch: Exception -> L44
            goto L18
        L24:
            r6 = false;
            goto L25
        L6:
            return new JSONArray();
        }
    }

    static /* synthetic */ WifiInfo a(Context r2, an r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ AtomicBoolean a() {
        return f6159c;
    }

    static /* synthetic */ String b() {
        return f6160d;
    }

    static {
        f6158b = new a(null);
        f6159c = new AtomicBoolean(false);
        f6160d = null;
        f6157a = new ConcurrentHashMap();
    }

    public static al a(String r2) {
        al r3 = (al) ZeusTransformUtils.preCheckCast(f6157a.get(r2), al.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        return r3;
    L6:
        return f6158b;
    }

    static void a(String r2, al r3) {
        al r4 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, al> r0 = f6157a;
        if (r0.containsKey(r2) == true) goto L6;
        r0.put(r2, r4);
        return;
    }

    private static WifiInfo b(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        com.bytedance.bdinstall.f.b r7 = r5.aa();     // Catch: Exception -> L9
        WifiInfo r2 = r7.b();     // Catch: Exception -> L9
        String r8 = r7.a(r2);     // Catch: Exception -> L9
        if (((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L11;
        if (r8 == null) goto L11;
        return r2;
    L11:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
