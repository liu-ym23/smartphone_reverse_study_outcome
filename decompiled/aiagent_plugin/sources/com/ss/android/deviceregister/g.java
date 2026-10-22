package com.ss.android.deviceregister;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceRegisterManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static final String TAG = "DeviceRegisterManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f37426a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f37427b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f37428c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f37429d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile int f37430e = -1;
    private static volatile boolean f = true;
    private static volatile boolean g = false;
    private static volatile boolean h = false;
    private static volatile boolean i = false;
    private static volatile com.bytedance.bdinstall.c.b j = null;
    private static volatile l k = null;
    private static boolean l = false;
    private static volatile v m = null;
    private static volatile p n = null;
    private static int o = -1;
    private static volatile boolean p = false;
    private static volatile boolean q = false;
    private static volatile int r = 0;
    private static volatile boolean s = false;
    private static n t;
    private static n u;
    private static n v;
    private static boolean w;

    /* JADX INFO: compiled from: DeviceRegisterManager.java */
    public interface a {
        void a(String r1, String r2);

        void a(boolean r1);

        void a(boolean r1, boolean r2);
    }

    public static boolean a() {
        if (f37430e >= 0) goto L6;
        com.ss.android.common.util.e.e("DeviceRegisterManager SwitchToBdtracker has not been set!");
    L6:
        if (f37430e <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    static {
        s r0 = new s();
        t = r0;
        u = r0;
        v = new b();
        w = false;
    }

    public static boolean b() {
        return u.g();
    }

    public static void a(Context r2) {
        f37428c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static boolean c() {
        return f37427b;
    }

    static void a(Context r3, boolean r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L24;
        f37427b = true;
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == false) goto L7;
        a(true);
    L7:
        f37428c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (f37426a != null) goto L20;
        monitor-enter(g.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (f37426a != null) goto L14;
        f37426a = new g(r4, r5);     // Catch: Throwable -> L16
        f37426a.d(r6);     // Catch: Throwable -> L16
    L14:
        monitor-exit(g.class);     // Catch: Throwable -> L16
    L20:
        if (Logger.debug() == false) goto L27;
        com.ss.android.common.util.e.b("DeviceRegister init, DeviceRegister : " + f37426a.toString() + ", process : " + Process.myPid());
        return;
    L27:
        return;
    L24:
        throw new IllegalArgumentException("context = null");
    }

    private void d(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        u.c(r1);
    }

    public static void a(boolean r1) {
        u.a(r1);
    }

    public static void a(Bundle r1) {
        u.a(r1);
    }

    public static void a(String r1) {
        u.a(r1);
    }

    public static String d() {
        return f37429d;
    }

    private g(boolean r3, boolean r4) {
        u.a(f37428c, w, r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a("BDInstall", "error when init ", th);
        th.printStackTrace();
    }

    public static int e() {
        return o;
    }

    public static boolean f() {
        return i;
    }

    public static com.bytedance.bdinstall.c.b g() {
        return j;
    }

    public static String h() {
        return u.a();
    }

    public static String i() {
        return u.b();
    }

    public static void a(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        u.a(r3);
    }

    public static void a(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        u.a(r3, f37428c);
    }

    public static boolean j() {
        return s;
    }

    public static void a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (TextUtils.equals(r6, "local_test") == true) goto L8;
        if (s == true) goto L8;
        return;
    L8:
        monitor-enter(m.class);     // Catch: Exception -> L17
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L10:
        if (com.ss.android.deviceregister.b.b.a(m.class) != null) goto L12;
        com.ss.android.deviceregister.b.b.a(m.class, (m) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.ss.android.deviceregister.newuser.NewUserModeManager", "com.obric.aiagent.plugin").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r7}), m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        a("AppLog# ", "enable early register NewUserModeManager to ServiceManager.");     // Catch: Throwable -> L14
    L12:
        monitor-exit(m.class);     // Catch: Throwable -> L14
    }

    public static boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return u.b(r3);
    }

    public static void b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        u.a(r4, r3);
    }

    public static void b(boolean r1) {
        u.c(r1);
    }

    public static void c(boolean r1) {
        u.b(r1);
    }

    public static boolean k() {
        return u.e();
    }

    public static boolean a(Context r2, JSONObject r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return u.a(r5, r3, r4);
    }

    public static int l() {
        return u.f();
    }

    public static void c(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        u.b(r4, r3);
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return u.a(r3);
    }

    public static void a(com.ss.android.deviceregister.base.j r2) {
        com.ss.android.deviceregister.base.j r3 = (com.ss.android.deviceregister.base.j) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.deviceregister.base.j.class, "com.obric.aiagent.plugin");
        u.a(r3);
    }

    public static void m() {
        u.d();
    }

    public static String n() {
        return u.c();
    }

    public static boolean d(boolean r2) {
        g r0 = f37426a;
        if (c() == false) goto L8;
        if (r0 == null) goto L8;
        return u.e(r2);
    L8:
        u.d(r2);
        return false;
    }

    public static void a(boolean r2, long r3, t r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.aiagent.plugin");
        g r0 = f37426a;
        if (c() == false) goto L8;
        if (r0 == null) goto L8;
        u.a(r2, r3, r6);
        return;
    L8:
        u.d(r2);
    }

    public static boolean o() {
        return g;
    }

    public static boolean p() {
        return f;
    }

    public static l q() {
        if (k != null) goto L6;
        k = new l.a();
    L6:
        return k;
    }

    public static v r() {
        return m;
    }

    public static boolean s() {
        return h;
    }

    public static p t() {
        return n;
    }

    public static boolean u() {
        return l;
    }

    public static boolean v() {
        return q;
    }

    public static int w() {
        if (r > 0) goto L5;
        return KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L5:
        return r;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
