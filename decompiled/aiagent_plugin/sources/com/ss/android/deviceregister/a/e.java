package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.utility.Logger;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.ss.android.common.applog.y;
import com.ss.android.deviceregister.base.i;
import com.ss.android.deviceregister.base.j;
import com.ss.android.deviceregister.base.v;
import com.ss.android.deviceregister.g;
import com.ss.android.deviceregister.h;
import com.ss.android.deviceregister.t;
import com.ss.android.deviceregister.u;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: RegisterServiceController.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    private static List<WeakReference<g.a>> D = null;
    private static final ThreadLocal<Boolean> E = null;
    private static boolean G = false;
    private static final String TAG = "RegisterServiceController";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f37328a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static i f37329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f37330d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static j f37331e;
    private static volatile u f;
    private static final Bundle h = null;
    private static volatile boolean i;
    private static volatile boolean j;
    private static long q;
    private static volatile boolean v;
    private static volatile long x;
    private b A;
    private boolean B;
    private com.ss.android.deviceregister.i C;
    private b.a F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.ss.android.deviceregister.a.a.a f37332b;
    private final Object g;
    private volatile boolean k;
    private int l;
    private volatile int m;
    private final Context n;
    private final SharedPreferences o;
    private JSONObject p;
    private long r;
    private long s;
    private long t;
    private String u;
    private String w;
    private a y;
    private volatile t z;

    /* JADX INFO: compiled from: RegisterServiceController.java */
    private class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f37335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f37336b;

        a(e r1) {
            this.f37336b = r1;
            super("DeviceRegisterThread");
            this.f37335a = 0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            e.a(this.f37336b, !com.bytedance.common.utility.j.a(e.b(this.f37336b).optString("device_id", null)));
        L4:
            if (e.o() == true) goto L38;
            if (b() == true) goto L8;
            long r0 = c();
            Object r2 = e.c(this.f37336b);
            monitor-enter(r2);
            if (r0 <= 0) goto L35;
        L32:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            throw th;
        L27:
            if (e.o() == true) goto L28;
            e.c(this.f37336b).wait(r0);     // Catch: InterruptedException -> L32 Throwable -> L51
        L28:
            monitor-exit(r2);     // Catch: Throwable -> L51
        L35:
            if (e.o() == true) goto L36;
            monitor-exit(r2);     // Catch: Throwable -> L51
            monitor-enter(this);
            a();     // Catch: Throwable -> L48
            if (e.d(this.f37336b) == false) goto L46;
            e.e(this.f37336b);     // Catch: Throwable -> L48
        L46:
            monitor-exit(this);     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            throw th;
        L36:
            monitor-exit(r2);     // Catch: Throwable -> L51
            goto L38
        L8:
            Object r1 = e.c(this.f37336b);
            monitor-enter(r1);
            if (Logger.debug() == false) goto L54;
            com.ss.android.common.util.e.b("RegisterServiceController throttle by applog/settings sThrottleByAppLogConfig=" + e.f37328a + " did=" + this.f37336b.g() + " iid=" + this.f37336b.h());     // Catch: Throwable -> L19
        L54:
            e.c(this.f37336b).wait(TimeUnit.MINUTES.toMillis(1));     // Catch: InterruptedException -> L15 Throwable -> L19
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L19
            goto L4
        L15:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L38:
            if (Logger.debug() == false) goto L70;
            com.ss.android.common.util.e.b("RegisterServiceController DeviceRegisterThread finished");
            return;
        }

        private boolean b() {
            if (e.f37328a == true) goto L5;
        L11:
            return false;
        L5:
            if (y.a(this.f37336b.g()) == true) goto L11;
            if (y.a(this.f37336b.h()) == true) goto L11;
            if (e.f(this.f37336b) != v.c()) goto L11;
            return true;
        }

        private long c() {
            long r0 = System.currentTimeMillis();
            if (e.f(this.f37336b) != v.c()) goto L5;
            boolean r2 = true;
        L7:
            if (com.ss.android.deviceregister.a.a.b() == false) goto L9;
        L12:
            long r7 = 21600000;
        L13:
            if (r2 == false) goto L15;
            long r3 = 180000;
        L16:
            long r9 = e();
            if (r9 == 0) goto L19;
            r3 = 4000 * r9;
        L19:
            long r10 = r7 - (r0 - e.g(this.f37336b));
            long r4 = r3 - (r0 - e.h(this.f37336b));
            if (r10 > 0) goto L22;
        L24:
            long r5 = Math.max(r10, r4);
            if (e.d(this.f37336b) == true) goto L27;
        L29:
            r7 = r5;
        L31:
            if (Logger.debug() == true) goto L33;
        L37:
            return r7;
        L33:
            if (r7 < 0) goto L36;
            r0 = r0 + r7;
        L36:
            com.ss.android.common.util.e.b("RegisterServiceController next query time : " + DateFormat.getDateTimeInstance().format(new Date(r0)));
            goto L37
        L27:
            if (e.i(this.f37336b) != g.e()) goto L29;
            e.j(this.f37336b);
            e.a(this.f37336b, 0);
            goto L31
        L22:
            if (e.d(this.f37336b) == false) goto L24;
            e.a(this.f37336b, 0);
            goto L24
        L15:
            r3 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
            goto L16
        L9:
            if (e.p() >= 0) goto L12;
            if (r2 == false) goto L12;
            r7 = 43200000;
            goto L13
        L5:
            r2 = false;
            goto L7
        }

        void a() {
            if (e.q() == false) goto L5;
            return;
        L5:
            com.bytedance.bdinstall.c.b r0 = g.g();
            String r1 = null;
            if (r0 == null) goto L103;
            r1 = r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        L103:
            long r2 = System.currentTimeMillis();     // Catch: Exception -> L99
            if (e.r() > 0) goto L11;
            e.a(r2);     // Catch: Exception -> L99
        L11:
            e.a(this.f37336b, r2);     // Catch: Exception -> L99
            if (com.bytedance.common.utility.i.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L15;
            com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.K);     // Catch: Exception -> L99
            e.j(this.f37336b);     // Catch: Exception -> L99
            return;
        L15:
            String r3 = v.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L99
            if (com.bytedance.common.utility.j.a(r3) == true) goto L19;
            e.b(this.f37336b).put("user_agent", r3);     // Catch: Exception -> L99
        L19:
            if (com.bytedance.common.utility.j.a(e.l(this.f37336b)) == true) goto L21;
            e.b(this.f37336b).put("app_track", e.l(this.f37336b));     // Catch: Exception -> L99
        L21:
            JSONObject r4 = new JSONObject(new JSONTokener(e.b(this.f37336b).toString()));     // Catch: Exception -> L99
            r4.put("req_id", g.n());     // Catch: Exception -> L99
            if (this.f37336b.j() == false) goto L24;
            r4.put(DBHelper.BATTERY_COL_SCENE, 2);     // Catch: Exception -> L99
        L24:
            r4.put("device_platform", "android");     // Catch: Exception -> L99
            new com.ss.android.deviceregister.a.b().a(r4);     // Catch: Exception -> L99
            Bundle r5 = new Bundle();     // Catch: Throwable -> L69
            Bundle r6 = e.s();     // Catch: Throwable -> L69
            monitor-enter(r6);     // Catch: Throwable -> L69
            r5.putAll(e.s());     // Catch: Throwable -> L66
            monitor-exit(r6);     // Catch: Throwable -> L66
        L31:
            if (r5.size() <= 0) goto L38;
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L69
            Iterator<String> r8 = r5.keySet().iterator();     // Catch: Throwable -> L69
        L34:
            if (r8.hasNext() == false) goto L36;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L69
            r7.put(r9, r5.get(r9));     // Catch: Throwable -> L69
            goto L34
        L36:
            r4.put(MonitorConstants.CUSTOM, r7);     // Catch: Throwable -> L69
        L38:
            if (TextUtils.isEmpty(r1) == true) goto L40;
            r4.put("app_trait", r1);     // Catch: Throwable -> L69
        L40:
            String r10 = com.ss.android.a.a();     // Catch: Throwable -> L69
            String r11 = com.ss.android.a.b();     // Catch: Throwable -> L69
            if (this.f37336b.j() == true) goto L60;
            if (g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L60;
            if (g.f() == true) goto L60;
            Pair<String, Boolean> r12 = com.ss.android.deviceregister.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L69
            if (r12 == null) goto L60;
            if (r12.second != null) goto L51;
        L53:
            boolean r13 = false;
        L55:
            if (r13 == false) goto L57;
            int r14 = 1;
        L58:
            r4.put("gaid_limited", r14);     // Catch: Throwable -> L69
            r4.put("google_aid", r12.first);     // Catch: Throwable -> L69
            goto L60
        L57:
            r14 = 0;
            goto L58
        L51:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r12.second, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L53;
            r13 = true;
        L60:
            if (com.bytedance.common.utility.j.a(r10) == true) goto L63;
            r4.put("app_language", r10);     // Catch: Throwable -> L69
        L63:
            if (com.bytedance.common.utility.j.a(r11) == true) goto L70;
            r4.put("app_region", r11);     // Catch: Throwable -> L69
        L70:
            e.a(this.f37336b, r4);     // Catch: Exception -> L99
            r4.put("sdk_version", "3.10.5");     // Catch: Exception -> L99
            r4.put("sdk_flavor", "china");     // Catch: Exception -> L99
            if (g.f() == false) goto L73;
            int r15 = 1;
        L74:
            r4.put("guest_mode", r15);     // Catch: Exception -> L99
            v.a(r4);     // Catch: Exception -> L99
            JSONObject r16 = new JSONObject();     // Catch: Exception -> L99
            r16.put("magic_tag", "ss_app_log");     // Catch: Exception -> L99
            r16.put("header", r4);     // Catch: Exception -> L99
            r16.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L99
            e.b(true);     // Catch: Exception -> L99
            e.t().set(Boolean.TRUE);     // Catch: Exception -> L99
            boolean r17 = a(r16.toString(), r4);     // Catch: Exception -> L99
            if (r17 == false) goto L84;
            System.currentTimeMillis();     // Catch: Exception -> L99
            if (e.r() <= 0) goto L80;
            e.a(0);     // Catch: Exception -> L99
        L80:
            if (e.m(this.f37336b) == null) goto L84;
            if (e.n(this.f37336b) == null) goto L84;
            e.n(this.f37336b).b(e.m(this.f37336b));     // Catch: Exception -> L99
        L84:
            Object r18 = e.u();     // Catch: Exception -> L99
            monitor-enter(r18);     // Catch: Exception -> L99
            e.b(false);     // Catch: Throwable -> L96
            e.u().notifyAll();     // Catch: Exception -> L89 Throwable -> L96
        L91:
            monitor-exit(r18);     // Catch: Throwable -> L96
            e.c(true);     // Catch: Exception -> L99
            e.t().remove();     // Catch: Exception -> L99
            if (r17 == true) goto L111;
            e.a(this.f37336b, false, com.bytedance.common.utility.j.a(this.f37336b.f37332b.b()));     // Catch: Exception -> L99
            return;
        L111:
            return;
        L89:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L96
        L96:
            th = move-exception;
            throw th;     // Catch: Exception -> L99
        L73:
            r15 = 0;
        L66:
            th = move-exception;
            throw th;     // Catch: Throwable -> L69
        L69:
            com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);     // Catch: Exception -> L99
        L99:
            e = move-exception;
            e.printStackTrace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r18v1, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r18v10 */
        /* JADX WARN: Type inference failed for: r18v2 */
        /* JADX WARN: Type inference failed for: r18v3 */
        /* JADX WARN: Type inference failed for: r18v5 */
        /* JADX WARN: Type inference failed for: r18v9 */
        private boolean a(String r28, JSONObject r29) {
            com.ss.android.common.util.e.b("RegisterServiceController app_log_config: " + r28);     // Catch: Throwable -> L54
            byte[] r5 = r28.getBytes("UTF-8");     // Catch: Throwable -> L54
            e.b(this.f37336b, System.currentTimeMillis());     // Catch: Throwable -> L54
            String[] r15 = com.ss.android.deviceregister.a.a.a();     // Catch: Throwable -> L54
            if (r15 == null) goto L53;
            int r13 = 0;
            ?? r14 = r15.length;     // Catch: Throwable -> L54
        L6:
            if (r13 >= r14) goto L51;
            String r7 = r15[r13];     // Catch: Throwable -> L54
            r14 = (byte[]) ZeusTransformUtils.preCheckCast(r5.clone(), byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
            if (com.bytedance.common.utility.j.a(r7) == false) goto L11;
            r13 = r13;
            r14 = r14;
        L49:
            r13 = r13 + 1;     // Catch: Throwable -> L54
            r14 = r14;
            goto L6
        L11:
            if (Logger.debug() == false) goto L14;
            com.ss.android.common.util.e.b("RegisterServiceController request url : " + r7);     // Catch: Throwable -> L54
        L14:
            if (TextUtils.isEmpty(r29.optString("device_id")) == false) goto L16;
        L19:
            boolean r0 = true;
        L59:
            if (d() == true) goto L57;
            String r1 = y.a(null, r7, r5, true, "application/json; charset=utf-8", false, null, r0, false);     // Catch: Throwable -> L43
        L55:
            com.ss.android.common.util.e.a("device_register response: " + r1);     // Catch: Throwable -> L43
            if (r1 != null) goto L36;
        L41:
            com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L43
            goto L49
        L36:
            if (r1.length() == 0) goto L41;
            if (a(new JSONObject(r1)) == false) goto L49;
            return true;
        L43:
            th = th;
        L47:
            com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L54
            if (e.a(this.f37336b, th) == true) goto L49;
            throw th;     // Catch: Throwable -> L54
        L57:
            if (r7.indexOf(63) >= 0) goto L26;
            String r6 = r7 + "?";     // Catch: RuntimeException -> L29 Throwable -> L45
        L27:
            r1 = y.a(null, r6, r14, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), false, null, null, null, r0, false);     // Catch: RuntimeException -> L29 Throwable -> L45
            goto L55
        L26:
            r6 = r7 + "&";     // Catch: RuntimeException -> L29 Throwable -> L45
            goto L27
        L29:
            com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L45
            r1 = y.a(null, r7, r5, true, "application/json; charset=utf-8", false, null, r0, false);     // Catch: Throwable -> L43
        L45:
            th = th;
            r13 = r13;
            r14 = r14;
            goto L47
        L16:
            if (TextUtils.isEmpty(r29.optString("install_id")) == true) goto L19;
            r0 = false;
            goto L59
        L51:
            return false;
        L53:
            throw new IllegalArgumentException("url is null");     // Catch: Throwable -> L54
        L54:
            return false;
        }

        private boolean a(JSONObject r26) {
            if (r26 != null) goto L5;
            return false;
        L5:
            e.b(this.f37336b, v.c());
            if (r26.optInt("new_user", 0) <= 0) goto L8;
            boolean r3 = true;
        L9:
            e.d(r3);
            SharedPreferences.Editor r4 = e.o(this.f37336b).edit();
            r4.putInt("last_config_version", e.f(this.f37336b));
            r4.putString("dr_channel", v.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
            String r5 = e.p(this.f37336b);
            String r6 = this.f37336b.f37332b.b();
            boolean r7 = com.bytedance.common.utility.j.a(r6);
            final String r10 = r26.optString("install_id", null);
            final String r9 = r26.optString("device_id", null);
            String r14 = r26.optString("device_token", "");
            String r1 = r26.optString("klink_egdi", "");
            boolean r13 = y.a(r9);
            boolean r16 = y.a(r10);
            boolean r17 = y.a(r1);
            if (g.v() == false) goto L14;
            if (r13 == true) goto L14;
            if (r17 == false) goto L14;
            com.ss.android.common.util.e.b("[egdi] has no egdi, try get egdi...");
            this.f37336b.m();
        L14:
            if (r13 == true) goto L18;
            if (r16 == true) goto L18;
            e.c(this.f37336b, System.currentTimeMillis());
            r4.putLong("last_config_time", e.g(this.f37336b));
        L18:
            if (r16 == false) goto L20;
        L25:
            boolean r2 = false;
        L26:
            if (r13 == false) goto L28;
        L30:
            if (r13 == true) goto L32;
        L34:
            if (r2 == true) goto L48;
        L36:
            r4.putString("device_token", r14);
            r4.commit();
            if (r2 == false) goto L39;
            this.f37336b.f37332b.a(r9);
            e.q(this.f37336b);
        L39:
            e.a(this.f37336b, true, r7);
            if (e.a(this.f37336b) == null) goto L43;
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r9, r10));
        L43:
            return true ^ r13;
        L48:
            e.b(this.f37336b).put("install_id", e.p(this.f37336b));     // Catch: Exception -> L45
            e.b(this.f37336b).put("device_id", r9);     // Catch: Exception -> L45
            e.b(this.f37336b).put("klink_egdi", r1);     // Catch: Exception -> L45
            r4.putString("install_id", e.p(this.f37336b));     // Catch: Exception -> L45
            r4.putString("device_id", r9);     // Catch: Exception -> L45
            r4.putString("klink_egdi", r1);     // Catch: Exception -> L45
            goto L36
        L32:
            if (e.v() == null) goto L34;
            e.v().a("service_monitor", "diderror", 0, null, null);
            goto L34
        L28:
            if (r9.equals(r6) == true) goto L30;
            this.f37336b.a(r6, r9);
            r2 = true;
            goto L30
        L20:
            if (r10.equals(e.p(this.f37336b)) == true) goto L25;
            e.a(this.f37336b, r10);
            if (com.bytedance.common.utility.j.a(r5) == false) goto L46;
        L24:
            r2 = true;
            goto L26
        L46:
            JSONObject r8 = new JSONObject();     // Catch: Exception -> L44
            r8.put("old_id", r5);     // Catch: Exception -> L44
            r8.put("new_id", r10);     // Catch: Exception -> L44
            this.f37336b.a("iid_change", r8);     // Catch: Exception -> L44
            goto L24
        L8:
            r3 = false;
            goto L9
        }

        private boolean d() {
            return com.ss.android.deviceregister.a.a.c();
        }

        private int e() {
            if (y.a(this.f37336b.g()) == false) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L17;
            boolean r1 = com.bytedance.common.utility.i.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f37336b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            int r3 = this.f37335a;
            if (r1 == false) goto L13;
            int r2 = 3;
        L14:
            if (r3 <= r2) goto L16;
            r0 = true;
            goto L17
        L16:
            r0 = false;
            goto L17
        L13:
            r2 = 10;
        L17:
            if (r0 == false) goto L20;
            int r4 = this.f37335a + 1;
            this.f37335a = r4;
            return r4;
        L20:
            return 0;
        L5:
            if (y.a(this.f37336b.h()) == true) goto L8;
            r0 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: RegisterServiceController.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<WeakReference<a>> f37340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f37341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f37342c;

        /* JADX INFO: compiled from: RegisterServiceController.java */
        interface a {
            void a();
        }

        static /* synthetic */ Context a(b r0) {
            return r0.f37342c;
        }

        static /* synthetic */ void b(b r0) {
            r0.b();
        }

        public b(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f37340a = Collections.synchronizedSet(new HashSet());
            this.f37341b = new AtomicBoolean(false);
            this.f37342c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        public synchronized void a(a r3) {
            monitor-enter(this);
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            this.f37340a.add(new WeakReference(r4));     // Catch: Throwable -> L6
            a();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void a() {
            if (this.f37341b.compareAndSet(false, true) == false) goto L12;
            PluginBroadcastReceiver r0 = new AnonymousClass1(this);
            IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            ZeusTransformUtils.registerReceiver(this.f37342c, r0, r1, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        private void b() {
            Iterator<WeakReference<a>> r3 = this.f37340a.iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            a r0 = (a) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.aiagent.plugin")).get(), a.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L4;
            r0.a();
            goto L4
        }

        public synchronized void b(a r5) {
            monitor-enter(this);
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            Iterator<WeakReference<a>> r0 = this.f37340a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            if (((a) ZeusTransformUtils.preCheckCast(r1.get(), a.class, "com.obric.aiagent.plugin")) != r6) goto L5;
            r0.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r0.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public abstract void a(String r1, String r2);

    static /* synthetic */ int a(e r0, int r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ long a(long r0) {
        x = r0;
        return r0;
    }

    static /* synthetic */ long a(e r0, long r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ t a(e r0) {
        return r0.z;
    }

    static /* synthetic */ t a(e r2, t r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.aiagent.plugin");
        r2.z = r4;
        return r4;
    }

    static /* synthetic */ String a(e r0, String r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ void a(e r0, JSONObject r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(e r0, boolean r1) {
        r0.e(r1);
    }

    static /* synthetic */ void a(e r0, boolean r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ boolean a(e r0, Throwable r1) {
        return r0.a(r1);
    }

    static /* synthetic */ int b(e r0, int r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ long b(e r0, long r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ JSONObject b(e r0) {
        return r0.p;
    }

    static /* synthetic */ boolean b(boolean r0) {
        j = r0;
        return r0;
    }

    static /* synthetic */ long c(e r0, long r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ Object c(e r0) {
        return r0.g;
    }

    static /* synthetic */ boolean c(boolean r0) {
        i = r0;
        return r0;
    }

    static /* synthetic */ boolean d(e r0) {
        return r0.B;
    }

    static /* synthetic */ boolean d(boolean r0) {
        G = r0;
        return r0;
    }

    static /* synthetic */ int e(e r2) {
        int r0 = r2.m;
        r2.m = r0 + 1;
        return r0;
    }

    static /* synthetic */ int f(e r0) {
        return r0.l;
    }

    static /* synthetic */ long g(e r2) {
        return r2.r;
    }

    static /* synthetic */ long h(e r2) {
        return r2.s;
    }

    static /* synthetic */ int i(e r0) {
        return r0.m;
    }

    static /* synthetic */ void j(e r0) {
        r0.b();
    }

    static /* synthetic */ Context k(e r0) {
        return r0.n;
    }

    static /* synthetic */ String l(e r0) {
        return r0.w;
    }

    static /* synthetic */ b.a m(e r0) {
        return r0.F;
    }

    static /* synthetic */ b n(e r0) {
        return r0.A;
    }

    static /* synthetic */ SharedPreferences o(e r0) {
        return r0.o;
    }

    static /* synthetic */ boolean o() {
        return v;
    }

    static /* synthetic */ long p() {
        return q;
    }

    static /* synthetic */ String p(e r0) {
        return r0.u;
    }

    static /* synthetic */ void q(e r0) {
        r0.c();
    }

    static /* synthetic */ boolean q() {
        return j;
    }

    static /* synthetic */ long r() {
        return x;
    }

    static /* synthetic */ Bundle s() {
        return h;
    }

    static /* synthetic */ ThreadLocal t() {
        return E;
    }

    static /* synthetic */ Object u() {
        return f37330d;
    }

    static /* synthetic */ i v() {
        return f37329c;
    }

    static {
        f37330d = new Object();
        h = new Bundle();
        i = false;
        j = false;
        f37328a = false;
        q = 0;
        v = false;
        D = Collections.synchronizedList(new ArrayList());
        E = new ThreadLocal();
        G = false;
    }

    public e(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.g = new Object();
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.n = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.f37332b = h.a(r7);
        this.o = com.ss.android.deviceregister.base.b.a(r7);
        this.k = r6;
        if (g.e() == (-1)) goto L5;
        boolean r8 = true;
    L6:
        this.B = r8;
        this.C = new com.ss.android.deviceregister.i(r7);
        return;
    L5:
        r8 = false;
        goto L6
    }

    public static void a(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.size() <= 0) goto L17;
        Bundle r0 = h;
        monitor-enter(r0);
        r0.putAll(r1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void e() {
        this.p = new JSONObject();
        a();
        if (v.a(this.n, this.p, j()) == false) goto L5;
    L9:
        a r0 = new a(this);
        this.y = r0;
        r0.start();
        return;
    L5:
        if (Logger.debug() == false) goto L9;
        throw new RuntimeException("init header error.");
    }

    public void f() {
        a r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a();
    }

    private void a() {
        long r0 = System.currentTimeMillis();
        SharedPreferences r2 = com.ss.android.deviceregister.base.b.a(this.n);
        this.l = r2.getInt("last_config_version", 0);
        this.u = r2.getString("install_id", "");
        boolean r3 = TextUtils.equals(v.c(this.n), r2.getString("dr_channel", null));
        if (this.l != v.c()) goto L14;
        if (r3 == false) goto L15;
        long r4 = r2.getLong("last_config_time", 0);
        if (r4 > r0) goto L9;
        r0 = r4;
    L9:
        boolean r5 = y.a(g());
        boolean r6 = y.a(h());
        if (r5 == true) goto L16;
        if (r6 == true) goto L17;
        this.r = r0;
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public String g() {
        return this.f37332b.b();
    }

    public String h() {
        return this.u;
    }

    public static void a(g.a r2) {
        g.a r3 = (g.a) ZeusTransformUtils.wrapperContextForParams(r2, g.a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        D.add(new WeakReference(r3));
    }

    public static void a(Context r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (E.get() == null) goto L6;
        return;
    L6:
        if (com.bytedance.common.utility.j.a(a(r7)) == true) goto L8;
        return;
    L8:
        Object r0 = f37330d;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L11:
        if (i == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L15:
        if (com.bytedance.common.utility.j.a(a(r7)) == true) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L18:
        long r1 = 1500;
        if (j == false) goto L22;
        r1 = 4000;
    L22:
        if (r6 != (-1)) goto L24;
    L39:
        r0.wait(r1);     // Catch: Exception -> L38 Throwable -> L35
    L32:
        i = true;     // Catch: Throwable -> L35
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L24:
        if (r6 <= 120000) goto L27;
        r6 = 120000;
    L29:
        r1 = r6;
        goto L39
    L27:
        if (r6 >= 0) goto L29;
        r6 = 1000;
        goto L29
    }

    private static String a(Context r2) {
        return h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).b();
    L5:
        return null;
    }

    public static void a(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        f37331e = r3;
        v.a(r3);
    }

    public String i() {
        if (j() == false) goto L7;
        return "";
    L7:
        return this.f37332b.a(true);
    }

    public boolean j() {
        return this.k;
    }

    public String k() {
        return this.f37332b.a();
    }

    public void l() {
        Object r0 = this.g;
        monitor-enter(r0);
        this.g.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(boolean r4) {
        this.u = null;
        this.k = r4;
        this.f37332b.b("device_id");
        this.f37332b.b("install_id");
        this.f37332b.b("clientudid");
        com.ss.android.deviceregister.base.b.a(this.n).edit().remove("install_id").apply();
        com.ss.android.deviceregister.c.a.b(this.n);
        JSONObject r0 = new JSONObject();
        v.g();
        v.a(this.n, r0, r4);
        this.p = r0;
    }

    public void a(boolean r3, long r4, t r6) {
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        this.k = r3;     // Catch: Throwable -> L11
        this.r = 0;     // Catch: Throwable -> L11
        this.t = 0;     // Catch: Throwable -> L11
        a r5 = this.y;     // Catch: Throwable -> L11
        if (r5 == null) goto L7;
        r5.f37335a = 0;     // Catch: Throwable -> L11
    L7:
        v.g();     // Catch: Throwable -> L11
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        v.a(this.n, r8, j());     // Catch: Throwable -> L11
        this.p = r8;     // Catch: Throwable -> L11
        this.z = r7;     // Catch: Throwable -> L11
        l();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this), r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void b() {
        if (this.A != null) goto L5;
        this.A = new b(this.n);
    L5:
        b.a r0 = new AnonymousClass2(this);
        this.F = r0;
        this.A.a(r0);
    }

    private void a(JSONObject r5) {
        if (f == null) goto L19;
        r5.put("pre_installed_channel", f.a(this.n));
    L19:
        int r1 = 0;
        PackageInfo r4 = this.n.getPackageManager().getPackageInfo(this.n.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r4 == null) goto L21;
        r5.put("apk_first_install_time", r4.firstInstallTime);     // Catch: Throwable -> L16
        if ((r4.applicationInfo.flags & 1) != 1) goto L10;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r1 = 1;
    L14:
        r5.put("is_system_app", r1);     // Catch: Throwable -> L16
        return;
    L10:
        r6 = false;
        goto L12
    L21:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean a(Throwable r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.common.utility.b.class) == false) goto L15;
        int r5 = ((com.bytedance.common.utility.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.common.utility.b.class, "com.obric.aiagent.plugin")).a();
        if (this.B == false) goto L8;
        return true;
    L8:
        if (r5 < 200) goto L15;
        if (r5 == 301) goto L15;
        if (r5 == 302) goto L15;
        return false;
    L15:
        return true;
    }

    private void e(boolean r5) {
        int r4 = D.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L15;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(D.get(r0), WeakReference.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        g.a r2 = (g.a) ZeusTransformUtils.preCheckCast(r1.get(), g.a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        r2.a(r5);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r0 = r0 + 1;
        goto L3
    }

    private void c() {
        v.a(this.f37332b.b(), this.u);
        int r0 = D.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(D.get(r1), WeakReference.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        g.a r3 = (g.a) ZeusTransformUtils.preCheckCast(r2.get(), g.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L14;
        r3.a(this.f37332b.b(), this.u);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r1 = r1 + 1;
        goto L3
    }

    public void a(String r1, JSONObject r2) {
        j r0 = f37331e;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private void a(boolean r5, boolean r6) {
        int r4 = D.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L15;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(D.get(r0), WeakReference.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        g.a r2 = (g.a) ZeusTransformUtils.preCheckCast(r1.get(), g.a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        r2.a(r5, r6);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r0 = r0 + 1;
        goto L3
    }

    public void m() {
        this.C.a(this);
    }

    public String n() {
        return this.C.a();
    }
}
