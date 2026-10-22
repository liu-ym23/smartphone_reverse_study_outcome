package com.obric.performance.power.monitor;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.obric.performance.power.monitor.constants.d;
import com.obric.performance.power.monitor.constants.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.f.k;
import d.g;
import d.h.b.o;
import d.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: PowerMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final c A = null;
    private static final b B = null;
    private static final String TAG = "PowerMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f36933b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f36934c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ObricPerformancePowerMonitorConfig f36935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Context f36936e;
    private static d f;
    private static com.obric.performance.power.monitor.constants.c g;
    private static e h;
    private static boolean i;
    private static boolean j;
    private static boolean k;
    private static volatile boolean l;
    private static boolean m;
    private static volatile boolean n;
    private static boolean o;
    private static volatile boolean p;
    private static int q;
    private static volatile boolean r;
    private static final f s = null;
    private static com.obric.performance.power.monitor.cpu.a t;
    private static float u;
    private static int v;
    private static float w;
    private static int x;
    private static final f y = null;
    private static final C1008a z = null;

    /* JADX INFO: renamed from: com.obric.performance.power.monitor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PowerMonitor.kt */
    public static final class C1008a implements com.obric.performance.power.monitor.c.a.b {
        C1008a() {
        }

        @Override // com.obric.performance.power.monitor.c.a.b
        public void a(boolean r3) {
            if (a.b() == true) goto L5;
        L7:
            ILogDepend.Companion.d(a.TAG, "reportRunnable onChargeChanged " + r3);
            return;
        L5:
            if (a.c() == r3) goto L7;
            a r2 = a.f36932a;
            a.a(true);
            goto L7
        }
    }

    /* JADX INFO: compiled from: PowerMonitor.kt */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.b() == false) goto L6;
            a.e(a.f36932a);
            a.b(a.f36932a).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), a.e().getCollectCurrentIntervalMillis());
            return;
        }
    }

    /* JADX INFO: compiled from: PowerMonitor.kt */
    public static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.b() == false) goto L5;
            a.a(a.f36932a);
        L5:
            a r0 = a.f36932a;
            boolean r1 = true;
            if (a.d() == false) goto L11;
            if (new Random().nextFloat() < a.e().getBackgroundSampledRate()) goto L14;
        L13:
            r1 = false;
        L14:
            a.b(r1);
            if (IRuntimeContext.Companion.isMainProcess() == false) goto L17;
            a.b(a.f36932a).removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(a.f(), Runnable.class, "com.obric.aiagent.plugin"));
        L17:
            a.c(a.f36932a).e();
            a.c(a.f36932a).b((com.obric.performance.power.monitor.c.a.b) ZeusTransformUtils.preCheckCast(a.g(), com.obric.performance.power.monitor.c.a.b.class, "com.obric.aiagent.plugin"));
            if (a.b() == false) goto L29;
            ILogDepend.Companion.d(a.TAG, "reportRunnable sampled");
            a r2 = a.f36932a;
            a.c(a.d());
            a r3 = a.f36932a;
            a.d(false);
            a r4 = a.f36932a;
            a.e(a.h());
            a r5 = a.f36932a;
            a.f(false);
            com.obric.performance.power.monitor.cpu.a r6 = a.i();
            if (r6 == null) goto L23;
            r6.c();
        L23:
            if (IRuntimeContext.Companion.isMainProcess() == false) goto L25;
            a.b(a.f36932a).post((Runnable) ZeusTransformUtils.preCheckCast(a.f(), Runnable.class, "com.obric.aiagent.plugin"));
        L25:
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.j(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L28;
            a.c(a.f36932a).a(r7);
            a.c(a.f36932a).a((com.obric.performance.power.monitor.c.a.b) ZeusTransformUtils.preCheckCast(a.g(), com.obric.performance.power.monitor.c.a.b.class, "com.obric.aiagent.plugin"));
        L28:
            a r8 = a.f36932a;
            a.g(a.c(a.f36932a).b());
            a r9 = a.f36932a;
            a.a(false);
        L30:
            a.b(a.f36932a).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), a.e().getReportIntervalMillis());
            return;
        L29:
            ILogDepend.Companion.d(a.TAG, "reportRunnable not sampled");
            a.d(a.f36932a);
            goto L30
        L11:
            if (new Random().nextFloat() >= a.e().getFrontSampledRate()) goto L13;
            goto L13
        }
    }

    public static /* synthetic */ x lambda$4h0IGOrX_7VhdCCcFSp929s5n_Q(boolean r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$79t8j2erELW-lxIjlePDFA19afU, reason: not valid java name */
    public static /* synthetic */ x m1245lambda$79t8j2erELWlxIjlePDFA19afU(boolean r0) {
        return h(r0);
    }

    public static /* synthetic */ HandlerThread lambda$Pp5kVUMnk2G5uXC6EqPoqUrumZc() {
        return r();
    }

    public static /* synthetic */ Handler lambda$a7RR9euvucIjVH0Xu7mXruHcPU0() {
        return s();
    }

    public static /* synthetic */ String lambda$gCefYDlVGwcBFSRQRUtfmX5awhU() {
        return u();
    }

    /* JADX INFO: renamed from: lambda$wnDasXVI84UZA-Kb7wE_LxUMZIY, reason: not valid java name */
    public static /* synthetic */ com.obric.performance.power.monitor.c.a m1246lambda$wnDasXVI84UZAKb7wE_LxUMZIY() {
        return t();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.p();
    }

    public static final /* synthetic */ void a(boolean r0) {
        p = r0;
    }

    public static final /* synthetic */ Handler b(a r0) {
        return r0.l();
    }

    public static final /* synthetic */ void b(boolean r0) {
        r = r0;
    }

    public static final /* synthetic */ boolean b() {
        return r;
    }

    public static final /* synthetic */ com.obric.performance.power.monitor.c.a c(a r0) {
        return r0.m();
    }

    public static final /* synthetic */ void c(boolean r0) {
        k = r0;
    }

    public static final /* synthetic */ boolean c() {
        return o;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.o();
    }

    public static final /* synthetic */ void d(boolean r0) {
        l = r0;
    }

    public static final /* synthetic */ boolean d() {
        return i;
    }

    public static final /* synthetic */ ObricPerformancePowerMonitorConfig e() {
        return f36935d;
    }

    public static final /* synthetic */ void e(a r0) {
        r0.q();
    }

    public static final /* synthetic */ void e(boolean r0) {
        m = r0;
    }

    public static final /* synthetic */ b f() {
        return B;
    }

    public static final /* synthetic */ void f(boolean r0) {
        n = r0;
    }

    public static final /* synthetic */ C1008a g() {
        return z;
    }

    public static final /* synthetic */ void g(boolean r0) {
        o = r0;
    }

    public static final /* synthetic */ boolean h() {
        return j;
    }

    public static final /* synthetic */ com.obric.performance.power.monitor.cpu.a i() {
        return t;
    }

    public static final /* synthetic */ Context j() {
        return f36936e;
    }

    static {
        f36932a = new a();
        f36933b = g.a($$Lambda$a$Pp5kVUMnk2G5uXC6EqPoqUrumZc.INSTANCE);
        f36934c = g.a($$Lambda$a$a7RR9euvucIjVH0Xu7mXruHcPU0.INSTANCE);
        f36935d = new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null);
        g = (com.obric.performance.power.monitor.constants.c) ZeusTransformUtils.preCheckCast(com.obric.performance.power.monitor.constants.a.f36950a, com.obric.performance.power.monitor.constants.c.class, "com.obric.aiagent.plugin");
        h = (e) ZeusTransformUtils.preCheckCast(com.obric.performance.power.monitor.constants.b.f36951a, e.class, "com.obric.aiagent.plugin");
        i = true;
        k = true;
        q = 1;
        s = g.a($$Lambda$a$wnDasXVI84UZAKb7wE_LxUMZIY.INSTANCE);
        y = g.a($$Lambda$a$gCefYDlVGwcBFSRQRUtfmX5awhU.INSTANCE);
        z = new C1008a();
        A = new c();
        B = new b();
    }

    private final HandlerThread k() {
        return (HandlerThread) ZeusTransformUtils.preCheckCast(f36933b.b(), HandlerThread.class, "com.obric.aiagent.plugin");
    }

    private static final HandlerThread r() {
        HandlerThread r0 = new HandlerThread("power-monitor");
        r0.start();
        return r0;
    }

    private final Handler l() {
        return (Handler) ZeusTransformUtils.preCheckCast(f36934c.b(), Handler.class, "com.obric.aiagent.plugin");
    }

    private static final Handler s() {
        return new Handler(f36932a.k().getLooper());
    }

    public final boolean a() {
        if (f36935d.getEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (r == false) goto L7;
        return true;
    }

    private final com.obric.performance.power.monitor.c.a m() {
        return (com.obric.performance.power.monitor.c.a) ZeusTransformUtils.preCheckCast(s.b(), com.obric.performance.power.monitor.c.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.performance.power.monitor.c.a t() {
        return com.obric.performance.power.monitor.c.a.f36945a;
    }

    private final String n() {
        return (String) ZeusTransformUtils.preCheckCast(y.b(), String.class, "com.obric.aiagent.plugin");
    }

    private static final String u() {
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return "";
    L7:
        return Application.getProcessName();
    }

    private final void o() {
        com.obric.performance.power.monitor.cpu.c.f36970a.b();
        com.obric.performance.power.monitor.d.a.f36990a.b();
        com.obric.performance.power.monitor.e.a.f36995a.b();
        com.obric.performance.power.monitor.h.b.f37007a.b();
        com.obric.performance.power.monitor.g.a.f37000a.c();
        com.obric.performance.power.monitor.b.a.f36941a.b();
        com.obric.performance.power.monitor.a.a.f36937a.b();
    }

    public final void a(com.obric.performance.power.monitor.constants.f r12) {
        o.e(r12, "config");
        ObricPerformancePowerMonitorConfig r0 = r12.a();
        f36935d = r0;
        if (r0.getEnabled() == true) goto L6;
        ILogDepend.Companion.d(TAG, "disabled, return");
        return;
    L6:
        f36936e = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f = r12.b();
        g = r12.c();
        h = r12.d();
        r12.c().a($$Lambda$a$79t8j2erELWlxIjlePDFA19afU.INSTANCE);
        r12.d().a($$Lambda$a$4h0IGOrX_7VhdCCcFSp929s5n_Q.INSTANCE);
        i = r12.c().a();
        j = r12.d().a();
        ILogDepend.Companion.d(TAG, "init, isBackground: " + i);
        t = new com.obric.performance.power.monitor.cpu.a(true, false, false, null, true, 8, null);
        l().post((Runnable) ZeusTransformUtils.preCheckCast(A, Runnable.class, "com.obric.aiagent.plugin"));
    }

    private static final x h(boolean r2) {
        if (r == true) goto L5;
    L7:
        i = r2;
        ILogDepend.Companion.d(TAG, "OnAppBackGroundListener isBackground: " + i);
        return x.f38692a;
    L5:
        if (k == r2) goto L7;
        l = true;
        goto L7
    }

    private static final x i(boolean r2) {
        if (r == true) goto L5;
    L7:
        j = r2;
        ILogDepend.Companion.d(TAG, "OnScreenStateListener isScreenOn: " + j);
        return x.f38692a;
    L5:
        if (m == r2) goto L7;
        n = true;
        goto L7
    }

    private final void p() {
        ILogDepend.Companion.d(TAG, "performTask start");
        com.obric.performance.power.monitor.cpu.a r0 = t;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        com.obric.performance.power.monitor.cpu.a r1 = t;
        if (r1 == null) goto L8;
        int r2 = r1.b();
    L9:
        com.obric.performance.power.monitor.cpu.a r3 = t;
        long r4 = -1;
        if (r3 == null) goto L14;
        com.obric.performance.power.monitor.cpu.b r5 = r3.a();
        if (r5 == null) goto L14;
        long r6 = r5.d();
    L15:
        com.obric.performance.power.monitor.cpu.a r7 = t;
        if (r7 == null) goto L20;
        com.obric.performance.power.monitor.cpu.b r8 = r7.a();
        if (r8 == null) goto L20;
        long r9 = r8.e();
    L21:
        com.obric.performance.power.monitor.cpu.a r10 = t;
        if (r10 == null) goto L26;
        com.obric.performance.power.monitor.cpu.b r11 = r10.a();
        if (r11 == null) goto L26;
        long r12 = r11.h();
    L27:
        JSONObject r13 = new JSONObject();
        int r14 = x;
        if (r14 <= 0) goto L30;
        r13.put("device_current", Float.valueOf(w / r14));
    L30:
        a r15 = f36932a;
        r13.put("battery_temperature", Float.valueOf(r15.m().c()));
        r13.put("battery_level", Float.valueOf(r15.m().a()));
        if (u <= 0.0f) goto L33;
        r13.put("battery_level_change", Float.valueOf(r15.m().a() - u));
    L33:
        u = r15.m().a();
        r13.put("battery_change_counter_uah", r15.m().d());
        if (v <= 0) goto L36;
        r13.put("battery_change_counter_uah_change", r15.m().d() - v);
    L36:
        v = r15.m().d();
        r13.put("cpu_core_count", r2);
        r13.put("device_cpu_time", r6);
        r13.put("device_idle_time", r9);
        com.obric.performance.power.monitor.cpu.a r16 = t;
        if (r16 == null) goto L41;
        com.obric.performance.power.monitor.cpu.b r17 = r16.a();
        if (r17 == null) goto L41;
        Object r18 = Double.valueOf(r17.c());
    L42:
        r13.put("device_cpu_usage", r18);
        if (r12 <= 0) goto L46;
        if (r2 <= 0) goto L46;
        r13.put("device_cpu_speed", Float.valueOf(((r6 - r9) / r12) / r2));
    L46:
        com.obric.performance.power.monitor.cpu.a r19 = t;
        if (r19 == null) goto L51;
        com.obric.performance.power.monitor.cpu.b r20 = r19.a();
        if (r20 == null) goto L51;
        r4 = r20.g();
    L51:
        r13.put("process_cpu_time", r4);
        r13.put("process_wall_time", r12);
        com.obric.performance.power.monitor.cpu.a r21 = t;
        if (r21 == null) goto L56;
        com.obric.performance.power.monitor.cpu.b r22 = r21.a();
        if (r22 == null) goto L56;
        Object r23 = Double.valueOf(r22.a());
    L57:
        r13.put("process_cpu_usage", r23);
        com.obric.performance.power.monitor.cpu.a r24 = t;
        if (r24 == null) goto L62;
        com.obric.performance.power.monitor.cpu.b r25 = r24.a();
        if (r25 == null) goto L62;
        Object r26 = Double.valueOf(r25.b());
    L63:
        r13.put("process_cpu_speed", r26);
        r13.put("process_thread_count", com.obric.performance.power.monitor.i.a.f37011a.a());
        r13.put("process_wake_lock_count", com.obric.performance.power.monitor.cpu.c.f36970a.a());
        r13.put("process_wake_lock_walltime", com.obric.performance.power.monitor.cpu.c.f36970a.c());
        r13.put("process_gps_request_count", com.obric.performance.power.monitor.g.a.f37000a.e());
        r13.put("process_gps_listener_count", com.obric.performance.power.monitor.g.a.f37000a.b());
        r13.put("process_gps_listener_time", com.obric.performance.power.monitor.g.a.f37000a.d());
        r13.put("process_sensor_listener_count", com.obric.performance.power.monitor.h.b.f37007a.a());
        r13.put("process_sensor_listener_time", com.obric.performance.power.monitor.h.b.f37007a.c());
        r13.put("process_camera_count", com.obric.performance.power.monitor.e.a.f36995a.a());
        r13.put("process_camera_time", com.obric.performance.power.monitor.e.a.f36995a.c());
        r13.put("process_audio_in_count", com.obric.performance.power.monitor.b.a.f36941a.a());
        r13.put("process_audio_in_time", com.obric.performance.power.monitor.b.a.f36941a.c());
        r13.put("process_audio_count", com.obric.performance.power.monitor.a.a.f36937a.a());
        r13.put("process_audio_time", com.obric.performance.power.monitor.a.a.f36937a.c());
        r13.put("process_bluetooth_scan_count", com.obric.performance.power.monitor.d.a.f36990a.a());
        r13.put("process_bluetooth_scan_time", com.obric.performance.power.monitor.d.a.f36990a.c());
        r13.put("process_name", r15.n());
        String r27 = g.b();
        if (r27 != null) goto L66;
        r27 = "";
    L66:
        r13.put("activity", r27);
        r13.put("is_background", i);
        boolean r28 = true;
        boolean r29 = !l;
        if (r29 == true) goto L69;
    L71:
        boolean r30 = false;
    L72:
        r13.put("is_all_foreground", r30);
        if (r29 == true) goto L75;
    L77:
        boolean r31 = false;
    L78:
        r13.put("is_all_background", r31);
        r13.put("is_screen_on", j);
        boolean r32 = !n;
        if (r32 == true) goto L81;
    L83:
        boolean r33 = false;
    L84:
        r13.put("is_all_screen_on", r33);
        if (r32 == true) goto L87;
    L89:
        boolean r34 = false;
    L90:
        r13.put("is_all_screen_off", r34);
        int r35 = q;
        q = r35 + 1;
        r13.put("report_index", r35);
        r13.put("is_charging", r15.m().b());
        boolean r36 = !p;
        if (r36 == true) goto L93;
    L95:
        boolean r37 = false;
    L96:
        r13.put("is_all_charging", r37);
        if (r36 == true) goto L99;
    L101:
        r28 = false;
    L102:
        r13.put("is_all_not_charging", r28);
        d r38 = f;
        if (r38 == null) goto L105;
        r38.a("obric_performance_power", r13);
    L105:
        a(r13);
        w = 0.0f;
        x = 0;
        return;
    L99:
        if (o == true) goto L101;
    L93:
        if (o == false) goto L95;
        r37 = true;
        goto L96
    L87:
        if (m == true) goto L89;
        r34 = true;
        goto L90
    L81:
        if (m == false) goto L83;
        r33 = true;
        goto L84
    L75:
        if (k == false) goto L77;
        r31 = true;
        goto L78
    L69:
        if (k == true) goto L71;
        r30 = true;
    L62:
        r26 = -1;
    L56:
        r23 = -1;
    L41:
        r18 = -1;
    L26:
        r12 = -1;
    L20:
        r9 = -1;
    L14:
        r6 = -1;
        goto L15
    L8:
        r2 = -1;
        goto L9
    }

    private final void a(JSONObject r6) {
        Context r1 = f36936e;     // Catch: Exception -> L11
        if (r1 != null) goto L6;
        return;
    L6:
        String r5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date()) + "  " + Process.myPid() + "  " + n() + "  " + r6 + '\n';     // Catch: Exception -> L11
        File r7 = new File(r1.getFilesDir(), "performance");     // Catch: Exception -> L11
        if (r7.exists() == true) goto L9;
        r7.mkdirs();     // Catch: Exception -> L11
    L9:
        k.b(new File(r7, "power.txt"), r5, null, 2, null);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ILogDepend.Companion.d(TAG, "writePowerToFile failed: " + e.getMessage());
    }

    private final void q() {
        Context r3 = f36936e;     // Catch: Exception -> L7
        if (r3 != null) goto L5;
        return;
    L5:
        w += com.obric.performance.power.monitor.f.a.f36999a.a(r3);     // Catch: Exception -> L7
        x++;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ILogDepend.Companion.d(TAG, "onCollectOnlyFront: " + e.getMessage());
    }
}
