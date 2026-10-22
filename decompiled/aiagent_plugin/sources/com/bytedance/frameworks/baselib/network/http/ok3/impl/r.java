package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Locale;
import okhttp3.internal.Version;
import okhttp3.z;

/* JADX INFO: compiled from: SsOkHttp3Client.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends com.bytedance.frameworks.baselib.network.http.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile r f8558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f8559b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f8560c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f8561d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Proxy f8562e = null;
    private static final Object f = null;
    private static int g = 0;
    private static volatile String h = "";
    private static String i = "tt-ok/3.10.0.2";
    private static volatile com.bytedance.frameworks.baselib.network.http.ok3.a j;
    private static Context k;
    private static i l;
    private static g m;

    static /* synthetic */ Context j() {
        return k;
    }

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.ok3.a k() {
        return j;
    }

    static {
        f = new Object();
    }

    public static r a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f8558a != null) goto L15;
        monitor-enter(r.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8558a != null) goto L9;
        f8558a = new r(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r.class);     // Catch: Throwable -> L11
    L15:
        return f8558a;
    }

    private r(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        String r0 = null;
        r0 = Version.userAgent();     // Catch: Throwable -> L5
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L12;
    L16:
        k = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        l = new i();
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().b(k);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.e.getService().a(new AnonymousClass1(this));
        return;
    L12:
        if (r0.startsWith("okhttp/") == false) goto L14;
        String r1 = r0.replaceFirst("okhttp/", "tt-ok/");
    L15:
        i = r1;
        goto L16
    L14:
        r1 = "tt-ok/" + r0;
    L5:
        Field r2 = ZeusTransformUtils.forName("okhttp3.internal.Util", "com.obric.aiagent.plugin").getDeclaredField("userAgent");     // Catch: Throwable -> L7
        r2.setAccessible(true);     // Catch: Throwable -> L7
        r0 = (String) ZeusTransformUtils.preCheckCast(r2.get(null), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static z a() {
        return l.a(false);
    }

    @Override // com.bytedance.retrofit2.b.a
    public com.bytedance.retrofit2.b.e a(com.bytedance.retrofit2.b.c r1) {
        com.bytedance.retrofit2.b.c r0 = com.bytedance.frameworks.baselib.network.http.h.b.a().a(r1);     // Catch: Throwable -> L10
        if (r0 == null) goto L5;
        r1 = r0;
    L5:
        com.bytedance.retrofit2.b.c r2 = com.bytedance.frameworks.baselib.network.e.d.a().a(r1);
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        return new f(r1);
    }

    public static String b() {
        if (TextUtils.isEmpty(h) == false) goto L12;
        StringBuilder r0 = new StringBuilder();
        r0.append(k.getPackageName());
        r0.append('/');
        r0.append(b(k));
        r0.append(" (Linux; U; Android ");
        r0.append(Build.VERSION.RELEASE);
        r0.append("; ");
        r0.append(Locale.getDefault().toString());
        String r2 = Build.MODEL;
        if (r2.length() <= 0) goto L7;
        r0.append("; ");
        r0.append(r2);
    L7:
        String r1 = Build.ID;
        if (r1.length() <= 0) goto L10;
        r0.append("; Build/");
        r0.append(r1);
    L10:
        r0.append(";");
        r0.append(i);
        r0.append(')');
        h = r0.toString();
    L12:
        return h;
    }

    private static int b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Object r0 = f;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (g == 0) goto L18;
    L9:
        int r5 = g;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r5;
    L18:
        g = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    public void a(g r2) {
        m = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
    }

    public static g c() {
        return m;
    }

    public static boolean d() {
        return f8559b;
    }

    public static void a(int r0) {
        f8560c = r0;
    }

    public static int e() {
        return f8560c;
    }

    public static void b(String r0) {
        f8561d = r0;
    }

    public static String f() {
        return f8561d;
    }

    public static void c(String r7) {
        if (r7 != null) goto L5;
        f8562e = null;
        return;
    L5:
        String[] r0 = r7.split(";");
        if (r0.length <= 0) goto L30;
        String[] r1 = r0[0].trim().split("=");
        if (r1.length != 2) goto L28;
        String r3 = r1[0].trim().toLowerCase();
        String[] r2 = r1[1].trim().split(":");
        if (r2.length != 2) goto L26;
        InetSocketAddress r4 = new InetSocketAddress(r2[0], Integer.parseInt(r2[1]));
        if (r3.equals("http") == false) goto L14;
    L23:
        f8562e = new Proxy(Proxy.Type.HTTP, r4);
        return;
    L14:
        if (r3.equals("https") == true) goto L23;
        if (r3.equals("socks") == false) goto L19;
    L22:
        f8562e = new Proxy(Proxy.Type.SOCKS, r4);
        return;
    L19:
        if (r3.equals("socks4") == true) goto L22;
        if (r3.equals("socks5") == true) goto L22;
        return;
    L26:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L28:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L30:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    }

    public static Proxy g() {
        return f8562e;
    }

    public static void a(com.bytedance.frameworks.baselib.network.http.ok3.a r2) {
        j = (com.bytedance.frameworks.baselib.network.http.ok3.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.frameworks.baselib.network.http.ok3.a.class, "com.obric.aiagent.plugin");
    }

    public static String h() {
        return i;
    }

    public static com.bytedance.frameworks.baselib.network.http.ok3.a i() {
        return j;
    }

    public static Context getContext() {
        return k;
    }

    public static String b(com.bytedance.retrofit2.b.c r4) {
        if (r4 != null) goto L4;
        return "null-metrics";
    L4:
        if (r4.p() != null) goto L7;
        return "null-metrics";
    L7:
        return "fallback_reason=" + f8560c + ",fallback-message=" + Base64.encodeToString(f8561d.getBytes(), 2) + ",request-fallback-reason=" + r4.p().i + ",request-fallback-message=" + Base64.encodeToString(r4.p().j.getBytes(), 2);
    }
}
