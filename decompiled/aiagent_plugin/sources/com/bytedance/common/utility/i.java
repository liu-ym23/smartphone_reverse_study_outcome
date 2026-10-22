package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f6726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f6727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f6729d;

    /* JADX INFO: compiled from: NetworkUtils.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6730a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6731b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f6732c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f6733e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f6734d;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f6733e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NONE", 0, 0);
            f6730a = r0;
            a r1 = new a("GZIP", 1, 1);
            f6731b = r1;
            a r3 = new a("DEFLATER", 2, 2);
            f6732c = r3;
            f6733e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6734d = r3;
        }
    }

    /* JADX INFO: compiled from: NetworkUtils.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6735a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f6736b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f6737c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f6738d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f6739e = null;
        public static final b f = null;
        public static final b g = null;
        public static final b h = null;
        public static final b i = null;
        public static final b j = null;
        public static final b k = null;
        public static final b l = null;
        private static final /* synthetic */ b[] n = null;
        final int m;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(n.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("UNKNOWN", 0, -1);
            f6735a = r0;
            b r1 = new b("NONE", 1, 0);
            f6736b = r1;
            b r3 = new b("MOBILE", 2, 1);
            f6737c = r3;
            b r5 = new b("MOBILE_2G", 3, 2);
            f6738d = r5;
            b r7 = new b("MOBILE_3G", 4, 3);
            f6739e = r7;
            b r9 = new b("WIFI", 5, 4);
            f = r9;
            b r11 = new b("MOBILE_4G", 6, 5);
            g = r11;
            b r13 = new b("MOBILE_5G", 7, 6);
            h = r13;
            b r15 = new b("WIFI_24GHZ", 8, 7);
            i = r15;
            b r14 = new b("WIFI_5GHZ", 9, 8);
            j = r14;
            b r12 = new b("MOBILE_3G_H", 10, 9);
            k = r12;
            b r10 = new b("MOBILE_3G_HP", 11, 10);
            l = r10;
            n = new b[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.m = r3;
        }

        public int a() {
            return this.m;
        }

        public boolean b() {
            if (this != f6737c) goto L5;
        L8:
            return true;
        L5:
            if (this == f6738d) goto L8;
            return false;
        }

        public boolean c() {
            if (this != f6739e) goto L5;
        L14:
            return true;
        L5:
            if (this == k) goto L14;
            if (this == l) goto L14;
            if (this == g) goto L14;
            if (this == h) goto L14;
            return false;
        }

        public boolean d() {
            if (this != f6735a) goto L5;
        L7:
            return false;
        L5:
            if (this == f6736b) goto L7;
            return true;
        }
    }

    /* JADX INFO: compiled from: NetworkUtils.java */
    public interface c {
        b a();
    }

    static {
        f6727b = b.f6735a;
        f6728c = false;
        f6729d = 0;
    }

    static void a(b r0) {
        f6727b = r0;
    }

    public static boolean a(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        c r1 = f6726a;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.a() == b.f6736b) goto L17;
        if (f6726a.a() == b.f) goto L15;
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

    public static boolean b(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static b c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        g(r3);
        h(r3);
        return f6727b;
    }

    public static boolean d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        g(r3);
        h(r3);
        return f6727b.d();
    }

    private static void g(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        c r0 = f6726a;
        if (r0 != null) goto L5;
    L8:
        registerReceiver(r3);
        if (f6727b != b.f6735a) goto L12;
        f6727b = e(r3);
        return;
    L12:
        return;
    L5:
        if (r0.a() == b.f6736b) goto L8;
        f6727b = f6726a.a();
    }

    private static void h(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if ((System.currentTimeMillis() - f6729d) <= 2000) goto L6;
        f6727b = e(r5);
        f6729d = System.currentTimeMillis();
        return;
    }

    private static void registerReceiver(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f6728c == true) goto L7;
        if (r4 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new h(), r0, "com.obric.aiagent.plugin");
        f6728c = true;
        return;
    L8:
        return;
    }

    public static b e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L35
        if (r0 == null) goto L34;
        if (r0.isAvailable() == false) goto L34;
        int r1 = r0.getType();     // Catch: Throwable -> L35
        if (1 == r1) goto L11;
        if (r1 != 0) goto L32;
        int r5 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getNetworkType();     // Catch: Throwable -> L35
        if (r5 == 3) goto L30;
        if (r5 == 20) goto L28;
        if (r5 == 5) goto L30;
        if (r5 == 6) goto L30;
        switch(r5) {
            case 8: goto L30;
            case 9: goto L30;
            case 10: goto L30;
            default: goto L22;
        };     // Catch: Throwable -> L35
    L22:
        switch(r5) {
            case 12: goto L30;
            case 13: goto L26;
            case 14: goto L30;
            case 15: goto L30;
            default: goto L24;
        };     // Catch: Throwable -> L35
    L24:
        return b.f6737c;
    L26:
        return b.g;
    L28:
        return b.h;
    L30:
        return b.f6739e;
    L32:
        return b.f6737c;
    L11:
        return b.f;
    L34:
        return b.f6736b;
    L36:
        return b.f6737c;
    }

    public static String f(Context r2) {
        return b(e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")));
    }

    public static String b(b r1) {
        if (r1 != b.f) goto L6;
        return "wifi";
    L6:
        if (r1 != b.i) goto L9;
        return "wifi24ghz";
    L9:
        if (r1 != b.j) goto L12;
        return "wifi5ghz";
    L12:
        if (r1 != b.f6738d) goto L15;
        return "2g";
    L15:
        if (r1 != b.f6739e) goto L18;
        return "3g";
    L18:
        if (r1 != b.k) goto L21;
        return "3gh";
    L21:
        if (r1 != b.l) goto L24;
        return "3ghp";
    L24:
        if (r1 != b.g) goto L27;
        return "4g";
    L27:
        if (r1 != b.h) goto L30;
        return "5g";
    L30:
        if (r1 != b.f6737c) goto L32;
        return SensitiveType.MOBILE;
    L32:
        return "";
    }

    public static String a(List<Pair<String, String>> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.aiagent.plugin");
        String r3 = a((String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin"), r6);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.second, String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        String r9 = a(r4, r6);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(r3);
        r0.append("=");
        r0.append(r9);
        goto L4
    L8:
        r9 = "";
        goto L10
    L14:
        return r0.toString();
    }

    private static String a(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
