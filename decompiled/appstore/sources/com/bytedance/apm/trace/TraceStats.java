package com.bytedance.apm.trace;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.j;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m1.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.e;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class TraceStats {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f6536f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f6539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6541e;

    public interface LockFetchListener {
        @WorkerThread
        void lockTime(long r10);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.a f6542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f6545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TraceStats f6546e;

        public a(TraceStats r10, e.a r11, int r12, String r13, String r14) {
            this.f6546e = r10;
            this.f6542a = r11;
            this.f6543b = r12;
            this.f6544c = r13;
            this.f6545d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TraceStats.a(this.f6546e) == false) goto L9;
            long r10 = com.bytedance.apm.launch.evil.a.a();
            if (r10 == 0) goto L9;
            e.a r11 = this.f6542a;
            if (r11 == null) goto L9;
            r11.E(r10);
        L9:
            TraceStats r12 = this.f6546e;
            TraceStats.c(r12, this.f6543b, this.f6544c, this.f6545d, TraceStats.b(r12), this.f6542a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f6547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f6549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f6550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f6551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f6552f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TraceStats f6553g;

        public b(TraceStats r10, long[] r11, long r12, long r13, long r14, int r15, String r16) {
            this.f6553g = r10;
            this.f6547a = r11;
            this.f6548b = r12;
            this.f6549c = r13;
            this.f6550d = r14;
            this.f6551e = r15;
            this.f6552f = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = g1.e.E().A(this.f6547a, this.f6548b);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            long r11 = this.f6549c - this.f6550d;     // Catch: Throwable -> L8
            JSONObject r12 = PerfMonitorManager.o().e();     // Catch: Throwable -> L8
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L8
            r13.put("is_main_process", c.F());     // Catch: Throwable -> L8
            r13.put("block_duration", r11);     // Catch: Throwable -> L8
            r13.put("stack", r10);     // Catch: Throwable -> L8
            r13.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
            r13.put("scene", "launchTrace");     // Catch: Throwable -> L8
            r13.put("cost_time", r11);     // Catch: Throwable -> L8
            r13.put("method_time", r11);     // Catch: Throwable -> L8
            r13.put("message", "launchTrace");     // Catch: Throwable -> L8
            r13.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
            JSONObject r14 = m3.c.a().b(true);     // Catch: Throwable -> L8
            r14.put("crash_section", c.A(System.currentTimeMillis()));     // Catch: Throwable -> L8
            r14.put(CommonKey.KEY_TRACE_TYPE, "launchTrace");     // Catch: Throwable -> L8
            r14.put("launchMode", String.valueOf(this.f6551e));     // Catch: Throwable -> L8
            r14.put("customLaunchMode", this.f6552f);     // Catch: Throwable -> L8
            r13.put("custom", r12);     // Catch: Throwable -> L8
            r13.put("filters", r14);     // Catch: Throwable -> L8
            l1.a.p().e(new d("drop_frame_stack", r13));     // Catch: Throwable -> L8
            return;
        }
    }

    static {
    }

    public TraceStats(String r10, String r11) {
        this.f6539c = new ConcurrentHashMap(4);
        if ("start_trace".equals(r10) == false) goto L5;
    L9:
        this.f6540d = r10;
        this.f6541e = r11;
        return;
    L5:
        if ("page_load_trace".equals(r10) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    public static /* synthetic */ boolean a(TraceStats r10) {
        return r10.i();
    }

    public static /* synthetic */ long b(TraceStats r10) {
        return r10.f6538b;
    }

    public static /* synthetic */ void c(TraceStats r10, int r11, String r12, String r13, long r14, e.a r15) {
        r10.j(r11, r12, r13, r14, r15);
    }

    public void d() {
        this.f6539c.clear();
    }

    public void e(String r10, String r11) {
        p1.b r12 = (p1.b) this.f6539c.get(r10 + "#" + r11);
        if (r12 != null) goto L5;
        return;
    L5:
        r12.a(System.currentTimeMillis(), Thread.currentThread().getName());
        this.f6539c.put(r10 + "#" + r11, r12);
    }

    public void f(int r10, String r11, long r12, long r13) {
        g(r10, "", r11, r12, r13);
    }

    public final void g(int r12, String r13, String r14, long r15, long r17) {
        if (r12 != (-1)) goto L12;
        if (r13.isEmpty() == false) goto L12;
        if (c.B() == false) goto L12;
        throw new IllegalArgumentException("Launch mode is both none");
    L12:
        if (i() == false) goto L15;
        e.a r10 = r1.b.a();
    L14:
        e.a r11 = r10;
        this.f6538b = System.currentTimeMillis();
        if (r17 <= 0) goto L19;
        this.f6538b = this.f6537a + r17;
    L19:
        long r16 = this.f6538b - this.f6537a;
        if (r15 <= 0) goto L25;
        if (r16 <= r15) goto L25;
        return;
    L25:
        if (i() == false) goto L32;
        if (o5.a.f22501o == false) goto L32;
        if (f6536f == false) goto L32;
        f6536f = false;
        k(r12, r13, this.f6537a, this.f6538b);
    L32:
        if (i() == true) goto L34;
    L43:
        AsyncEventManager.e().h(new a(this, r11, r12, r13, r14));
        if (i() == false) goto L49;
        LaunchSleepDetector.a();
        return;
    L49:
        return;
    L34:
        if (r1.a.b().c().b() == false) goto L43;
        if (com.bytedance.apm.internal.a.c(8) == false) goto L43;
        JSONObject r18 = new JSONObject();
        r18.put("is_launch_lock", true);     // Catch: JSONException -> L40
    L42:
        LockMonitorManager.endLockDetect(r18);
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L15:
        r10 = null;
        goto L14
    }

    public long h() {
        return this.f6537a;
    }

    public final boolean i() {
        return "start_trace".equals(this.f6540d);
    }

    public final void j(int r19, String r20, String r21, long r22, e.a r24) {
        JSONArray r10 = new JSONArray();
        int r11 = 2;
        char r12 = 1;
    L6:
        e = move-exception;
        e.printStackTrace();
    L31:
        ConcurrentHashMap r13 = this.f6539c;
        if (r13 == null) goto L34;
        r13.clear();
    L34:
        JSONObject r14 = new JSONObject();
        r14.put("name", this.f6541e);     // Catch: JSONException -> L61
        r14.put("page_type", this.f6541e);     // Catch: JSONException -> L61
        r14.put("start", this.f6537a);     // Catch: JSONException -> L61
        r14.put("end", r22);     // Catch: JSONException -> L61
        r14.put(TraceStatsConsts.STATS_KEY_SPANS, r10);     // Catch: JSONException -> L61
        r14.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 2);     // Catch: JSONException -> L61
        r14.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r21);     // Catch: JSONException -> L61
        if (r19 == (-1)) goto L39;
        r14.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, r19);     // Catch: JSONException -> L61
    L39:
        if (r20.isEmpty() == true) goto L42;
        r14.put(TraceStatsConsts.STATS_KEY_CUSTOM_LAUNCH_MODE, r20);     // Catch: JSONException -> L61
    L42:
        if (s1.a.e() == false) goto L45;
        s1.a.b("AppStartStats", r14.toString());     // Catch: JSONException -> L61
    L45:
        if (i() == true) goto L47;
    L50:
        JSONObject r15 = new JSONObject();
        r15.put(TraceStatsConsts.STATS_KEY_TRACE, r14);     // Catch: JSONException -> L63
        if (r24 == null) goto L56;
        JSONObject r16 = r1.b.b(r24);     // Catch: JSONException -> L63
        if (r16 == null) goto L56;
        r15.put(LaunchCommon.LAUNCH_DATA_PERF_DATA, r16);     // Catch: JSONException -> L63
    L56:
        m1.e r17 = new m1.e(this.f6540d, "", null, null, r15);
        m3.b.a(r17, false);
        if (c.B() == false) goto L59;
        j.a("AppStartStats", "reportAsync: " + r15);
    L59:
        l1.a.p().e(r17);
        return;
    L47:
        if (r1.a.b().a().b() == false) goto L50;
        JSONObject r18 = new JSONObject();
        com.bytedance.apm.util.d.k().f(r18, true);
        com.bytedance.apm.util.d.k().b(r18, true);
        r14.put(LaunchCommon.LAUNCH_DATA_DEVICE_DATA, r18);     // Catch: Throwable -> L62
        goto L50
    L4:
        if (TextUtils.equals(r21, AutoLaunchTraceHelper.sLauncherActivityName) == false) goto L8;
        r10 = AutoLaunchTraceHelper.assemblySpan();     // Catch: JSONException -> L6
    L8:
        ConcurrentHashMap r23 = this.f6539c;     // Catch: JSONException -> L6
        if (r23 == null) goto L31;
        if (r23.isEmpty() == true) goto L31;
        Iterator r25 = this.f6539c.entrySet().iterator();     // Catch: JSONException -> L6
    L13:
        if (r25.hasNext() == false) goto L31;
        Map.Entry r110 = (Map.Entry) r25.next();     // Catch: JSONException -> L6
        String r111 = (String) r110.getKey();     // Catch: JSONException -> L6
        p1.b r112 = (p1.b) r110.getValue();     // Catch: JSONException -> L6
        if (r112.f23279b == 0) goto L13;
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L6
        String[] r114 = r111.split("#");     // Catch: JSONException -> L6
        if (r114.length != r11) goto L26;
        if ("page_load_trace".equals(this.f6540d) == false) goto L24;
        r113.put("name", r114[r12]);     // Catch: JSONException -> L6
    L28:
        r113.put("start", r112.f23278a);     // Catch: JSONException -> L6
        r113.put("end", r112.f23279b);     // Catch: JSONException -> L6
        r113.put("thread", r112.f23280c);     // Catch: JSONException -> L6
        r10.put(r113);     // Catch: JSONException -> L6
        r11 = 2;
        r12 = 1;
        goto L13
    L24:
        r113.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, r114[0]);     // Catch: JSONException -> L6
        r113.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, r114[1]);     // Catch: JSONException -> L6
        goto L28
    L26:
        if (r114.length != 1) goto L28;
        r113.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, r114[0]);     // Catch: JSONException -> L6
        goto L28
    }

    public final void k(int r14, String r15, long r16, long r18) {
        long[] r10 = g1.e.E().t();
        long r11 = SystemClock.uptimeMillis();
        if (r10 == null) goto L6;
        AsyncEventManager.e().h(new b(this, r10, r11, r18, r16, r14, r15));
        return;
    }

    public void l(String r10, String r11) {
        m(r10, r11, false);
    }

    public void m(String r10, String r11, boolean r12) {
        if (((p1.b) this.f6539c.get(r10 + "#" + r11)) == null) goto L5;
        if (r12 == true) goto L5;
        return;
    L5:
        p1.b r13 = new p1.b(System.currentTimeMillis());
        this.f6539c.put(r10 + "#" + r11, r13);
    }

    public void n() {
        this.f6537a = System.currentTimeMillis();
    }
}
