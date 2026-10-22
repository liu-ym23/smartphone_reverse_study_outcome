package com.obric.utilsLib.a;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f37025a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static InterfaceC1012b f37026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f37027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f37028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f37029e;
    private static long f;

    /* JADX INFO: compiled from: NetworkUtils.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f37030a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f37031b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f37032c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f37033d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f37034e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        public static final a k = null;
        public static final a l = null;
        private static final /* synthetic */ a[] n = null;
        final int m;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(n.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("UNKNOWN", 0, -1);
            f37030a = r0;
            a r1 = new a("NONE", 1, 0);
            f37031b = r1;
            a r3 = new a("MOBILE", 2, 1);
            f37032c = r3;
            a r5 = new a("MOBILE_2G", 3, 2);
            f37033d = r5;
            a r7 = new a("MOBILE_3G", 4, 3);
            f37034e = r7;
            a r9 = new a("WIFI", 5, 4);
            f = r9;
            a r11 = new a("MOBILE_4G", 6, 5);
            g = r11;
            a r13 = new a("MOBILE_5G", 7, 6);
            h = r13;
            a r15 = new a("WIFI_24GHZ", 8, 7);
            i = r15;
            a r14 = new a("WIFI_5GHZ", 9, 8);
            j = r14;
            a r12 = new a("MOBILE_3G_H", 10, 9);
            k = r12;
            a r10 = new a("MOBILE_3G_HP", 11, 10);
            l = r10;
            n = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.m = r3;
        }

        public boolean a() {
            if (this != f37030a) goto L5;
        L7:
            return false;
        L5:
            if (this == f37031b) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.obric.utilsLib.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NetworkUtils.java */
    public interface InterfaceC1012b {
        a a();
    }

    static {
        f37027c = a.f37030a;
        f37028d = false;
        f37029e = 2000;
        f = 0;
    }

    static void a(a r0) {
        f37027c = r0;
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d(r3);
        e(r3);
        return f37027c;
    }

    public static boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d(r3);
        e(r3);
        return f37027c.a();
    }

    private static void d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        InterfaceC1012b r0 = f37026b;
        if (r0 != null) goto L5;
    L8:
        registerReceiver(r3);
        if (f37027c != a.f37030a) goto L12;
        f37027c = f(r3);
        return;
    L12:
        return;
    L5:
        if (r0.a() == a.f37031b) goto L8;
        f37027c = f37026b.a();
    }

    private static void e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if ((System.currentTimeMillis() - f) <= f37029e) goto L6;
        f37027c = f(r5);
        f = System.currentTimeMillis();
        return;
    }

    private static void registerReceiver(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f37028d == true) goto L7;
        if (r4 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new com.obric.utilsLib.a.a(), r0, "com.obric.aiagent.plugin");
        f37028d = true;
        return;
    L8:
        return;
    }

    private static a f(Context r3) {
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
        return a.f37032c;
    L26:
        return a.g;
    L28:
        return a.h;
    L30:
        return a.f37034e;
    L32:
        return a.f37032c;
    L11:
        return a.f;
    L34:
        return a.f37031b;
    L36:
        return a.f37032c;
    }

    public static a c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f37025a == false) goto L7;
        return a(r3);
    L7:
        return f(r3);
    }
}
