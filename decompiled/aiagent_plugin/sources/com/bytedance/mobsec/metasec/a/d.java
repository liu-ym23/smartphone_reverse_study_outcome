package com.bytedance.mobsec.metasec.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import ms.bd.c.a0;
import ms.bd.c.b2;
import ms.bd.c.c2;
import ms.bd.c.e0;
import ms.bd.c.f1;
import ms.bd.c.g;
import ms.bd.c.j;
import ms.bd.c.j1;
import ms.bd.c.l0;
import ms.bd.c.l2;
import ms.bd.c.m1;
import ms.bd.c.n;
import ms.bd.c.n1;
import ms.bd.c.o0;
import ms.bd.c.q0;
import ms.bd.c.q1;
import ms.bd.c.r;
import ms.bd.c.t1;
import ms.bd.c.u0;
import ms.bd.c.v;
import ms.bd.c.v1;
import ms.bd.c.w1;
import ms.bd.c.x;
import ms.bd.c.y0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static JSONArray f8856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f8857b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b2 f8858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static l2 f8859d;

    static {
        f8858c = new b2();
        f8859d = new l2();
        f8856a = null;
    }

    static String A() {
        return ms.bd.c.e.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    static Object a() {
        return m1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).e();
    }

    static Object a(String r3) {
        return o0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3).a();
    }

    static String a(int r4, long r5, Object[] r7) {
        int r6 = (int) r5;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7[0], String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7[1], String.class, "com.obric.aiagent.plugin");
        if (r6 != 0) goto L9;
        Class r9 = ZeusTransformUtils.forName(r0, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        Method r10 = r9.getDeclaredMethod(r8, new Class[0]);     // Catch: Exception -> L16
        if (r4 != 1) goto L8;
        Object r11 = r10.invoke(r9, new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")});     // Catch: Exception -> L16
        Class<String> r12 = String.class;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r11, r12, "com.obric.aiagent.plugin");
    L8:
        r11 = r10.invoke(r9, new Object[0]);     // Catch: Exception -> L16
        r12 = String.class;
        goto L7
    L9:
        if (r6 != 1) goto L14;
        Class r13 = ZeusTransformUtils.forName(r0, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        Field r14 = r13.getDeclaredField(r8);     // Catch: Exception -> L16
        if (r14.getType() != String.class) goto L14;
        r14.setAccessible(true);     // Catch: Exception -> L16
        r11 = r14.get(r13);     // Catch: Exception -> L16
        r12 = String.class;
    L14:
        return null;
    }

    static String a(String r3, String r4) {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r3, 0).getString(r4, null);
    }

    static void a(String r4, String[] r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L15;
        if (r4 == null) goto L16;
        if (r5 != null) goto L7;
        return;
    L7:
        if ((r5.length % 2) != 0) goto L18;
        Intent r1 = new Intent(r4);
        r1.setPackage(r0.getPackageName());
        int r6 = 0;
    L10:
        if (r6 >= r5.length) goto L12;
        r1.putExtra(r5[r6], r5[r6 + 1]);
        r6 = r6 + 2;
        goto L10
    L12:
        r0.sendBroadcast(r1);
        return;
    L18:
        return;
    L16:
        return;
    }

    static String b() {
        return String.valueOf(f.f8863a);
    }

    static String b(String r9) {
        if (y0.a().a(r9) == false) goto L6;
        Object r10 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8d2bd0", new byte[]{120});     // Catch: Throwable -> L9
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
    L6:
        r10 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f7b2db", new byte[]{39});     // Catch: Throwable -> L9
    L10:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5c50ec", new byte[]{117}), String.class, "com.obric.aiagent.plugin");
    }

    static void b(String r9, String r10) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String[] r11 = r9.split((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f4abc5", new byte[]{75, 42}), String.class, "com.obric.aiagent.plugin"));
        String r2 = r11[0];
        String r12 = r11[1];
        SharedPreferences.Editor r1 = r0.getSharedPreferences(r2, 0).edit();
        r1.putString(r12, r10);
        r1.commit();
    }

    static String c() {
        return String.valueOf(f.f8864b);
    }

    static String d() {
        return String.valueOf(f.f8865c);
    }

    static String e() {
        return ms.bd.c.e.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    static String f() {
        return n1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).b();
    }

    static String g() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getPackageName();
    }

    static String h() {
        m1 r0 = m1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.getClass();
        monitor-enter(r0);     // Catch: Throwable -> L10 Exception -> L12
        int r1 = r0.a();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    L14:
        return "" + r1;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10 Exception -> L12
    L12:
        r1 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    static void i() {
        n1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a();
    }

    static String j() {
        Locale r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().locale;     // Catch: Throwable -> L5
        String r1 = r0.getLanguage() + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ed8705", new byte[]{75}), String.class, "com.obric.aiagent.plugin")) + r0.getCountry();     // Catch: Throwable -> L5
    L7:
        return w1.a(r1);
    L5:
        r1 = null;
        goto L7
    }

    public static String k() {
        JSONArray r1 = f8856a;
        if (r1 == null) goto L22;
        return r1.toString();
    L22:
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ms.bd.c.e.a(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) == null) goto L10;
        byte r3 = 1;
    L12:
        if (r3 == 1) goto L24;
    L16:
        JSONArray r0 = f8856a;
        if (r0 == null) goto L21;
        return r0.toString();
    L21:
        return new JSONArray().toString();
    L24:
        f8856a = new JSONArray();     // Catch: Throwable -> L15
        DhcpInfo r4 = ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2bc415", new byte[]{52, 105, 22, 73}), String.class, "com.obric.aiagent.plugin")), WifiManager.class, "com.obric.aiagent.plugin")).getDhcpInfo();     // Catch: Throwable -> L15
        f8856a.put((r4.dns1 & 255) + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8c9d7e", new byte[]{103}), String.class, "com.obric.aiagent.plugin")) + ((r4.dns1 >> 8) & 255) + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0d8fec", new byte[]{111}), String.class, "com.obric.aiagent.plugin")) + ((r4.dns1 >> 16) & 255) + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "34a09e", new byte[]{108}), String.class, "com.obric.aiagent.plugin")) + ((r4.dns1 >> 24) & 255));     // Catch: Throwable -> L15
        f8856a.put((r4.dns2 & 255) + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5e2c51", new byte[]{106}), String.class, "com.obric.aiagent.plugin")) + ((r4.dns2 >> 8) & 255) + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b2fc2f", new byte[]{61}), String.class, "com.obric.aiagent.plugin")) + ((r4.dns2 >> 16) & 255) + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "92229d", new byte[]{102}), String.class, "com.obric.aiagent.plugin")) + ((r4.dns2 >> 24) & 255));     // Catch: Throwable -> L15
    L15:
        String r2 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f6bbb9", new byte[]{122, 61, 25, 41, 89, 34}), String.class, "com.obric.aiagent.plugin");
        goto L16
    L10:
        r3 = 0;
    L11:
        r3 = -1;
        goto L12
    }

    static Boolean l() {
        Boolean r0 = Boolean.FALSE;
        TelephonyManager r1 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1fd1ae", new byte[]{48, 108, 24, 75, 91}), String.class, "com.obric.aiagent.plugin")), TelephonyManager.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (r1.getSimState() == 5) goto L8;
        return r0;
    L8:
        return Boolean.TRUE;
    }

    static void m() {
        m1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).d();
    }

    static Integer n() {
        return Integer.valueOf(m1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).b());
    }

    static Integer o() {
        return Integer.valueOf(m1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).c());
    }

    static Integer p() {
        return Integer.valueOf(m1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).f());
    }

    static Boolean q() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L10;
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6e6d1d", new byte[]{36, 104, 75, 30, 11, 112, 33, 77, 113, 61, 51, 126}), String.class, "com.obric.aiagent.plugin")), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Method r2 = r1.getClass().getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fe4d88", new byte[]{112, 98, 83, 49, 4, 59, 108, 82, 96, 26, 114, 115, 80, 31, 21, 36, 76, 74, 99, 59}), String.class, "com.obric.aiagent.plugin"), new Class[0]);     // Catch: Throwable -> L11
        r2.setAccessible(true);     // Catch: Throwable -> L11
        NetworkInfo r3 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r2.invoke(r1, new Object[0]), NetworkInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        Method r4 = r3.getClass().getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f59771", new byte[]{126, 36, 107, 85, 9, 47, 105, 21, 106, 107, 114}), String.class, "com.obric.aiagent.plugin"), new Class[0]);     // Catch: Throwable -> L11
        r4.setAccessible(true);     // Catch: Throwable -> L11
        return Boolean.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3, new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L10:
        return Boolean.FALSE;
    }

    static String r() {
        Throwable r0 = v1.a().c();
        if (r0 != null) goto L5;
        return "";
    L5:
        return Arrays.toString(r0.getStackTrace());
    }

    static ArrayList s() {
        Throwable r0 = v1.a().c();
        if (r0 != null) goto L5;
        return null;
    L5:
        StackTraceElement[] r1 = r0.getStackTrace();
        if (r1.length >= 4) goto L8;
        return null;
    L8:
        ArrayList r2 = new ArrayList();
        int r3 = 1;
    L9:
        if (r3 >= 4) goto L29;
        StackTraceElement r4 = r1[r3];
        if (r4 == null) goto L28;
        if (TextUtils.isEmpty(r4.getClassName()) == true) goto L28;
        Class r5 = ZeusTransformUtils.forName(r1[r3].getClassName(), "com.obric.aiagent.plugin");
        v1 r6 = v1.a();
        String r7 = r1[r3].getMethodName();
        r6.getClass();
        ArrayList r8 = new ArrayList();
        if (TextUtils.isEmpty(r7) == true) goto L27;
        Method[] r9 = r5.getDeclaredMethods();
        int r10 = r9.length;
        int r11 = 0;
    L19:
        if (r11 >= r10) goto L27;
        Method r12 = r9[r11];
        if (r12 == null) goto L26;
        if (r12.getName().equals(r7) == false) goto L26;
        r8.add(r12);
    L26:
        r11 = r11 + 1;
    L27:
        r2.addAll(r8);
    L28:
        r3 = r3 + 1;
        goto L9
    L29:
        return r2;
    }

    static String t() {
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ms.bd.c.e.a(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) == null) goto L6;
        byte r3 = 1;
    L8:
        if (r3 == 1) goto L20;
        Object r1 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c7ccc7", new byte[]{34});
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L20:
        f1.a();     // Catch: Throwable -> L17
    L14:
        if (TextUtils.isEmpty(null) == false) goto L16;
        r1 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b0ec75", new byte[]{35});
        goto L11
    L16:
        throw null;
    L6:
        r3 = 0;
    L7:
        r3 = -1;
        goto L8
    }

    static Long u() {
        Method r2 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "589a63", new byte[]{39, 53, 71, 91, 11, 61, 34, 28, 108, 48, 42, 57, 79, 91, 4, 43, 52, 10, 109, 50, 106, 41, 79, 27, 26, 43, 36, 87, 101, 61, 106, 23, 121, 55}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3a5bcc", new byte[]{35}), String.class, "com.obric.aiagent.plugin"), new Class[0]);     // Catch: Throwable -> L8
        if (r2 == null) goto L7;
        return (Long) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[0]), Long.class, "com.obric.aiagent.plugin");
    L7:
        return null;
    }

    static String v() {
        q1 r0 = q1.a();     // Catch: Exception -> L10
        if (r0.d() == false) goto L8;
        JSONObject r1 = r0.c();     // Catch: Exception -> L10
        if (r1 == null) goto L13;
        return r1.toString();
    L13:
        return "";
    L8:
        return "";
    L14:
        return "";
    }

    static String w() {
        if (Build.VERSION.SDK_INT < 23) goto L11;
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7bc476", new byte[]{37, 111, 30, 78, 13, 34, 32, 74, 36, 109, 50, 121}), String.class, "com.obric.aiagent.plugin")), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r0.getNetworkCapabilities(r0.getActiveNetwork()).hasTransport(4) == false) goto L7;
        Object r1 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c80854", new byte[]{35});     // Catch: Throwable -> L12
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L7:
        r1 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "43822e", new byte[]{117});     // Catch: Throwable -> L12
    L11:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "61c7c2", new byte[]{119}), String.class, "com.obric.aiagent.plugin");
    }

    static String x() {
        return c2.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    static Integer y() {
        return Integer.valueOf(n.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    }

    static Boolean z() {
        return Boolean.valueOf(e0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    }

    public static Object a(int r30, int r31, long r32, String r34, Object r35) {
        if (r30 != 16777228) goto L5;
        File r1 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ad8f4c", new byte[]{62, 107, 88, 22, 10, 96, 99}), String.class, "com.obric.aiagent.plugin"));
        if (r1.exists() == true) goto L120;
        r1.mkdirs();
    L120:
        return r1.getAbsolutePath();
    L5:
        if (r30 == 16777278) goto L189;
        if (r30 != 33554433) goto L9;
        u0.a r0 = f8858c;
    L188:
        return r0.a(r30, r31, r32, r34, r35);
    L9:
        if (r30 != 33554434) goto L11;
        r0 = f8859d;
        goto L188
    L11:
        switch(r30) {
            case 16777217: goto L45;
            case 16777218: goto L35;
            case 16777219: goto L16;
            default: goto L12;
        };
    L12:
        switch(r30) {
            case 16777221: goto L148;
            case 16777222: goto L63;
            case 16777223: goto L146;
            case 16777224: goto L145;
            case 16777225: goto L127;
            case 16777226: goto L129;
            default: goto L13;
        };
    L13:
        switch(r30) {
            case 16777232: goto L152;
            case 16777233: goto L151;
            case 16777234: goto L150;
            case 16777235: goto L149;
            default: goto L14;
        };
    L14:
        switch(r30) {
            case 16777238: goto L187;
            case 16777239: goto L186;
            case 16777240: goto L109;
            case 16777241: goto L108;
            case 16777242: goto L185;
            case 16777243: goto L184;
            case 16777244: goto L183;
            case 16777245: goto L182;
            case 16777246: goto L103;
            case 16777247: goto L181;
            case 16777248: goto L180;
            case 16777249: goto L179;
            case 16777250: goto L178;
            case 16777251: goto L98;
            case 16777252: goto L177;
            case 16777253: goto L176;
            case 16777254: goto L175;
            case 16777255: goto L174;
            case 16777256: goto L173;
            case 16777257: goto L172;
            case 16777258: goto L171;
            case 16777259: goto L170;
            case 16777260: goto L169;
            case 16777261: goto L168;
            case 16777262: goto L167;
            case 16777263: goto L166;
            case 16777264: goto L165;
            case 16777265: goto L84;
            case 16777266: goto L163;
            case 16777267: goto L162;
            case 16777268: goto L161;
            case 16777269: goto L160;
            case 16777270: goto L159;
            case 16777271: goto L158;
            case 16777272: goto L157;
            case 16777273: goto L156;
            case 16777274: goto L155;
            case 16777275: goto L154;
            case 16777276: goto L153;
            default: goto L15;
        };
    L15:
        return null;
    L84:
        int r2 = Build.VERSION.SDK_INT;
        return "";
    L98:
        b(r34, (String) ZeusTransformUtils.preCheckCast(r35, String.class, "com.obric.aiagent.plugin"));
        goto L15
    L103:
        m();
        goto L15
    L108:
        i();
        goto L15
    L109:
        a(r34, (String[]) ZeusTransformUtils.preCheckCast(r35, String[].class, "com.obric.aiagent.plugin"));
        goto L15
    L153:
        return d();
    L154:
        return c();
    L155:
        return b();
    L156:
        return A();
    L157:
        return z();
    L158:
        return Boolean.valueOf(g.a(r34));
    L159:
        return b(r34);
    L160:
        return t1.a();
    L161:
        return x.a();
    L162:
        return y();
    L163:
        return j.a();
    L165:
        return x();
    L166:
        return a(r31, r32, (Object[]) ZeusTransformUtils.preCheckCast(r35, Object[].class, "com.obric.aiagent.plugin"));
    L167:
        return n.a();
    L168:
        return w();
    L169:
        return p();
    L170:
        return v();
    L171:
        return a(r34);
    L172:
        return u();
    L173:
        return t();
    L174:
        return s();
    L175:
        return r();
    L176:
        return UUID.randomUUID().toString();
    L177:
        return q();
    L178:
        return a(r34, (String) ZeusTransformUtils.preCheckCast(r35, String.class, "com.obric.aiagent.plugin"));
    L179:
        return o();
    L180:
        return n();
    L181:
        return a();
    L182:
        return l();
    L183:
        return k();
    L184:
        return j1.a();
    L185:
        return j();
    L186:
        return h();
    L187:
        return g();
    L149:
        return f();
    L150:
        return e();
    L151:
        return ms.bd.c.e.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L152:
        return Integer.valueOf(ms.bd.c.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    L63:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Class r4 = ZeusTransformUtils.forName(new String(a0.a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d2e79b", new byte[]{35, 99, 64, 69, 80, 113, 53, 22, 98, 54, 35, 53, 64, 23, 81, 39, 49, 21, 98, 62, 35, 100, 68, 70, 80, 44, 49, 22, 99, 51, 35, 101, 65, 17, 80, 112, 49, 66, 98, 100, 39, 53, 64, 69, 81, 38, 53, 22, 97, 55, 35, 54, 65, 20, 80, 32, 48, 65, 97, 55, 34, 98, 64, 69, 80, 35, 49, 74, 98, 100, 35, 101}), String.class, "com.obric.aiagent.plugin"))), "com.obric.aiagent.plugin");     // Catch: Throwable -> L66
        Object r5 = r4.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r3});     // Catch: Throwable -> L66
        Method r6 = r4.getDeclaredMethod(new String(a0.a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bc7dfd", new byte[]{37, 54, 18, 69, 14, 39, 53, 19, 49, 98, 37, 52, 19, 66, 15, 34, 55, 21, 48, 97, 38, 49, 18, 22, 14, 36, 55, 23, 49, 102}), String.class, "com.obric.aiagent.plugin"))), new Class[]{String.class});     // Catch: Throwable -> L66
        r6.setAccessible(true);     // Catch: Throwable -> L66
        double r7 = ((Double) ZeusTransformUtils.preCheckCast(r6.invoke(r5, new Object[]{new String(a0.a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7dda46", new byte[]{112, 52, 65, 68, 92, 117, 99, 17, 99, 100, 113, 52, 64, 76, 89, 36, 98, 22, 99, 96, 113, 54, 65, 68, 93, 114, 98, 28, 98, 101, 113, 63}), String.class, "com.obric.aiagent.plugin")))}), Double.class, "com.obric.aiagent.plugin")).doubleValue();     // Catch: Throwable -> L66
    L147:
        return Integer.toString((int) r7);
    L66:
        r7 = 0.0d;
        goto L147
    L127:
        TimeZone r8 = TimeZone.getDefault();     // Catch: Throwable -> L58
        String r9 = r8.getID();     // Catch: Throwable -> L58
        int r10 = ((r8.getRawOffset() / 60) / 60) / 1000;     // Catch: Throwable -> L57
    L144:
        return r9 + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "18da13", new byte[]{108}), String.class, "com.obric.aiagent.plugin")) + r10;
    L57:
        String r11 = r9;
    L59:
        r9 = r11;
        r10 = 0;
    L58:
        r11 = null;
        goto L59
    L129:
        Locale r12 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().locale;     // Catch: Throwable -> L52
        String r13 = r12.getLanguage() + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "86eb51", new byte[]{22}), String.class, "com.obric.aiagent.plugin")) + r12.getCountry();     // Catch: Throwable -> L52
    L143:
        return w1.a(r13);
    L52:
        r13 = null;
        goto L143
    L145:
        return v.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L146:
        return Integer.valueOf(ms.bd.c.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    L148:
        return r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L16:
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        JSONArray r15 = new JSONArray();
        AccessibilityManager r16 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(r14.getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "dd846d", new byte[]{116, 101, 72, 69, 26, 96, 110, 71, 96, 104, 124, 114, 82}), String.class, "com.obric.aiagent.plugin")), AccessibilityManager.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L139;
        Method r17 = r16.getClass().getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "aed53a", new byte[]{119, 98, 3, 104, 2, 101, 118, 69, 57, 105, 117, 99, 54, 66, 15, 115, 113, 87, 60, 103, 121, 107, 30, 85, 21, 69, 103, 86, 35, 108, 115, 98, 59, 72, 31, 98}), String.class, "com.obric.aiagent.plugin"), new Class[0]);     // Catch: Throwable -> L122
        if (r17 == null) goto L23;
        List r18 = (List) ZeusTransformUtils.preCheckCast(r17.invoke(r16, new Object[0]), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L122
    L24:
        if (r18 == null) goto L139;
        if (r18.size() == 0) goto L139;
        Iterator r19 = r18.iterator();
    L30:
        if (r19.hasNext() == false) goto L139;
        AccessibilityServiceInfo r20 = (AccessibilityServiceInfo) ZeusTransformUtils.preCheckCast(r19.next(), AccessibilityServiceInfo.class, "com.obric.aiagent.plugin");
        JSONObject r21 = new JSONObject();
        r21.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8eae8b", new byte[]{44, 113}), String.class, "com.obric.aiagent.plugin"), r20.eventTypes);     // Catch: Throwable -> L121
        r21.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "343fe9", new byte[]{43, 50}), String.class, "com.obric.aiagent.plugin"), r20.getId());     // Catch: Throwable -> L121
        r15.put(r21);     // Catch: Throwable -> L121
    L23:
        r18 = null;
    L139:
        return r15.toString();
    L35:
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        PackageManager r23 = r22.getPackageManager();
        String r24 = r22.getPackageName();
        if (r34 != null) goto L38;
    L40:
        Signature[] r25 = r23.getPackageInfo(r24, 64).signatures;
        if (r25 == null) goto L15;
        if (r25.length <= 0) goto L15;
        return r25[0].toByteArray();
    L38:
        if (r34.isEmpty() == true) goto L40;
        r24 = r34;
        goto L40
    L45:
        Context r26 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ApplicationInfo r27 = r26.getPackageManager().getApplicationInfo(r26.getPackageName(), 0);
        String r28 = r27.sourceDir;
        if (r28 == null) goto L142;
        return r28;
    L142:
        return r27.publicSourceDir;
    L189:
        return l0.b();
    }
}
