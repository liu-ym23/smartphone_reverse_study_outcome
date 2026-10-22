package com.bytedance.android.live.core.monitor.trace;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.p1;
import com.bytedance.android.livesdk.monitor.trace.TraceEventSenderImpl;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasSceneSensor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class TraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f64964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b60.b f64965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c60.a f64966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f64967d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile List<a60.d> f64968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f64969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f64970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile ExecutorService f64971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Handler f64972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f64973j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f64974k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f64975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile int f64976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile long f64977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f64978o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f64979p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f64980q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static CopyOnWriteArrayList<a> f64981r;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f64982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f64983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f64984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f64985d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f64982a, r101.f64982a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f64983b, r101.f64983b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f64984c, r101.f64984c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f64985d, r101.f64985d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            e r100 = this.f64982a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            JSONObject r104 = this.f64983b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            JSONObject r107 = this.f64984c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            JSONObject r110 = this.f64985d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MonitorData(traceMeta=" + this.f64982a + ", category=" + this.f64983b + ", metric=" + this.f64984c + ", extra=" + this.f64985d + ")";
        }

        public a(e r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "traceMeta");
            this.f64982a = r100;
            this.f64983b = null;
            this.f64984c = null;
            this.f64985d = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f64986a = null;

        static {
            f64986a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TraceMonitor.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f64987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f64988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f64989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f64990d;

        public c(e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            this.f64987a = r100;
            this.f64988b = r101;
            this.f64989c = r102;
            this.f64990d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = TraceMonitor.f64964a;     // Catch: Throwable -> L4
            TraceMonitor.c(this.f64987a, this.f64988b, this.f64989c, this.f64990d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public TraceMonitor() {
    }

    static {
        f64967d = new Object();
        f64968e = new ArrayList();
        f64973j = LazyKt.lazy(TraceMonitor$handlerThread$2.INSTANCE);
        f64974k = LazyKt.lazy(TraceMonitor$azyncHandler$2.INSTANCE);
        f64978o = LazyKt.lazy(TraceMonitor$traceMonitorSceneOpt$2.INSTANCE);
        f64979p = LazyKt.lazy(TraceMonitor$enableUselessLoopOpt$2.INSTANCE);
        f64980q = LazyKt.lazy(TraceMonitor$maxUselessLoopCount$2.INSTANCE);
    }

    public static final void a() {
        Object r100 = f64967d;
        monitor-enter(r100);
        long r101 = e();     // Catch: Throwable -> L9
        if (r101 > 0) goto L11;
        f64975l = false;     // Catch: Throwable -> L9
        ALogger.i("TraceClientMonitor", "stop delay send. maxCacheTime=" + r101);     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L11:
        long r102 = r101 * ((long) 1000);
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L9
        long r104 = r103 - f64977n;     // Catch: Throwable -> L9
        boolean r105 = true;
        if (r104 < r102) goto L15;
        boolean r110 = true;
    L17:
        if (((Boolean) f64978o.getValue()).booleanValue() == true) goto L19;
    L21:
        boolean r111 = false;
    L22:
        if (r110 == false) goto L34;
        if (r111 == true) goto L34;
        if ((!((ArrayList) f64968e).isEmpty()) == false) goto L32;
        f64976m = 0;     // Catch: Throwable -> L9
        List<a60.d> r112 = f64968e;     // Catch: Throwable -> L9
        f64968e = new ArrayList();     // Catch: Throwable -> L9
        b60.b r113 = f64965b;     // Catch: Throwable -> L9
        if (r113 == null) goto L31;
        TraceEventSenderImpl r114 = r113.b();     // Catch: Throwable -> L9
        if (r114 == null) goto L31;
        r114.b(r112);     // Catch: Throwable -> L9
    L31:
        ALogger.i("TraceClientMonitor", "delay send " + ((ArrayList) r112).size() + " events. gap=" + r104 + "ms. maxCacheTime=" + r102 + "ms");     // Catch: Throwable -> L9
    L33:
        f64977n = r103;     // Catch: Throwable -> L9
    L38:
        if (((Boolean) f64979p.getValue()).booleanValue() == true) goto L40;
    L43:
        if (r105 == false) goto L47;
        Handler r106 = f64972i;     // Catch: Throwable -> L9
        if (r106 == null) goto L48;
        r106.postDelayed(f.f65022a, r102);     // Catch: Throwable -> L9
    L48:
        monitor-exit(r100);
        return;
    L47:
        f64976m = 0;     // Catch: Throwable -> L9
        f64975l = false;     // Catch: Throwable -> L9
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L9
        goto L48
    L40:
        if (f64976m < ((Number) f64980q.getValue()).intValue()) goto L43;
        r105 = false;
        goto L43
    L32:
        f64976m++;     // Catch: Throwable -> L9
    L34:
        if (r111 == false) goto L36;
        f64977n = r103;     // Catch: Throwable -> L9
        goto L38
    L36:
        f64976m++;     // Catch: Throwable -> L9
        r102 = (f64977n + r102) - r103;     // Catch: Throwable -> L9
        goto L38
    L19:
        if (AtlasSceneSensor.INSTANCE.isAtlasCoreScene() == false) goto L21;
        r111 = true;
        goto L22
    L15:
        r110 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public static a60.e f() {
        return LiveInfraSettingKeys.LIVE_TRACE_MONITOR_CONFIG.getValue();
    }

    public static void k() {
        CopyOnWriteArrayList<a> r100 = f64981r;
        if (r100 == null) goto L10;
        Iterator<a> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        a r102 = r101.next();
        if (r102 == null) goto L6;
        ALogger.i("TraceClientMonitor", "report cache monitor: " + d(r102.f64982a));
        i(r102.f64982a, r102.f64983b, r102.f64984c, r102.f64985d);
    L10:
        CopyOnWriteArrayList<a> r103 = f64981r;
        if (r103 == null) goto L13;
        r103.clear();
    L13:
        f64981r = null;
    }

    public static int e() {
        int r100 = -1;
        if (f().j() == 1) goto L10;
        boolean r101 = z50.a.f570045a;
        a60.a r102 = f().b();
        if (r102 == null) goto L8;
        r100 = r102.b();
    L8:
        if (z50.a.f570045a == false) goto L17;
        ALogger.d("LiveTraceScheduleAtomicAbility", "judgeScheduleTraceTime:" + z50.a.f570046b);
        return z50.a.f570046b;
    L17:
        return r100;
    L10:
        boolean r103 = z50.a.f570045a;
        a60.b r104 = f().c();
        if (r104 == null) goto L14;
        r100 = r104.a();
    L14:
        if (z50.a.f570045a == false) goto L19;
        ALogger.d("LiveTraceScheduleAtomicAbility", "judgeScheduleTraceTime:" + z50.a.f570046b);
        return z50.a.f570046b;
    L19:
        return r100;
    }

    public static boolean b(a60.d r100) {
        if (f().h() > 0) goto L5;
        return false;
    L5:
        Object r101 = f64967d;
        monitor-enter(r101);
        String r102 = d60.a.a(CollectionsKt.listOf(r100)).toString();     // Catch: Throwable -> L20
        Charset r103 = Charsets.UTF_8;     // Catch: Throwable -> L20
        if (r102 == null) goto L19;
        int r104 = r102.getBytes(r103).length;     // Catch: Throwable -> L20
        r100.f1938e = r104;     // Catch: Throwable -> L20
        if (r104 <= f().h()) goto L15;
        ALogger.i("TraceMonitor", "trace size = " + r104 + " drop!!");     // Catch: Throwable -> L20
        monitor-exit(r101);
        return true;
    L15:
        f64969f += r104;     // Catch: Throwable -> L20
        monitor-exit(r101);
        return false;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static String d(e r100) {
        return "productId=" + r100.f65002e + " businessType=" + r100.f64999b + " eventType=" + r100.f64998a + " traceId=" + r100.f65000c + " step=" + r100.f65003f + " logId=" + r100.f65001d;
    }

    @JvmStatic
    public static final void g(com.bytedance.android.livesdk.monitor.trace.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = f64967d;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f64964a == true) goto L7;
        f64965b = r100;     // Catch: Throwable -> L10
        f64966c = new c60.a();     // Catch: Throwable -> L10
        f64970g = r100.getConfig().k();     // Catch: Throwable -> L10
        f64975l = false;     // Catch: Throwable -> L10
        f64971h = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("/TraceMonitor"));     // Catch: Throwable -> L10
        f64972i = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
        f64964a = true;     // Catch: Throwable -> L10
        k();     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }

    @JvmStatic
    public static final void h(e r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        i(r100, null, null, r101);
    }

    public static void j(e r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        if (f64964a == true) goto L10;
        ALogger.i("TraceClientMonitor", "init false, monitor event before init. " + d(r100));
        if (f64981r != null) goto L7;
        f64981r = new CopyOnWriteArrayList();
    L7:
        CopyOnWriteArrayList<a> r102 = f64981r;
        if (r102 == null) goto L12;
        r102.add(new a(r100, r101));
        return;
    L12:
        return;
    L10:
        ALogger.i("TraceClientMonitor", "init true, report: " + d(r100));
        i(r100, null, null, r101);
    }

    public static void c(e r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        String r100 = r110.f64998a;
        if (com.bytedance.android.live.core.monitor.trace.a.f64991a != null) goto L5;
        com.bytedance.android.live.core.monitor.trace.a.f64991a = p1.f65380a.getValue();
    L5:
        com.bytedance.android.live.core.monitor.trace.a.C1069a r101 = com.bytedance.android.live.core.monitor.trace.a.f64991a;
        if (r101 != null) goto L8;
    L40:
        b60.b r102 = f64965b;
        if (r102 != null) goto L43;
        return;
    L43:
        a60.e r103 = r102.getConfig();
        if (r103.e() == true) goto L46;
        return;
    L46:
        com.bytedance.android.livesdk.monitor.trace.a.b r104 = r102.a();
        if (r104 == null) goto L49;
        r104.a(r110);
    L49:
        if (r113 != null) goto L51;
        r113 = new JSONObject();
    L51:
        d60.b.a(r113, "timestamp", Long.valueOf(System.currentTimeMillis()));
        a60.d r105 = new a60.d(r110, r111, r112, r113);
        c60.a r114 = f64966c;
        if (r114 != null) goto L54;
    L56:
        r102.c();
        if (b(r105) == false) goto L59;
        return;
    L59:
        int r115 = r103.k();
        List<a60.d> r116 = null;
        if (r115 == 0) goto L116;
        if (r115 != 1) goto L161;
        a60.a r117 = r103.b();
        a60.b r118 = r103.c();
        if (f64970g != 1) goto L68;
        if (f64975l == false) goto L68;
    L87:
        Object r106 = f64967d;
        monitor-enter(r106);
        ((ArrayList) f64968e).add(r105);     // Catch: Throwable -> L112
        if (f().j() == 0) goto L97;
        int r119 = f64969f;     // Catch: Throwable -> L112
        if (r118 == null) goto L94;
        int r120 = r118.b();     // Catch: Throwable -> L112
    L95:
        if (r119 < r120) goto L103;
        List<a60.d> r121 = f64968e;     // Catch: Throwable -> L112
        f64968e = new ArrayList();     // Catch: Throwable -> L112
        f64977n = System.currentTimeMillis();     // Catch: Throwable -> L112
        ALogger.i("TraceClientMonitor", "batch send trace data");     // Catch: Throwable -> L112
    L104:
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L112
        monitor-exit(r106);
        if (r121 != null) goto L108;
        return;
    L108:
        if ((!r121.isEmpty()) == false) goto L110;
        r116 = r121;
    L110:
        if (r116 == null) goto L159;
        f64969f = 0;
        r102.b().b(r116);
        ALogger.i("TraceClientMonitor", "batch send " + r116.size() + " events");
        return;
    L159:
        return;
    L103:
        r121 = null;
        goto L104
    L94:
        r120 = 0;
        goto L95
    L97:
        int r123 = ((ArrayList) f64968e).size();     // Catch: Throwable -> L112
        if (r117 == null) goto L100;
        int r124 = r117.a();     // Catch: Throwable -> L112
    L101:
        if (r123 < r124) goto L103;
        r121 = f64968e;     // Catch: Throwable -> L112
        f64968e = new ArrayList();     // Catch: Throwable -> L112
        f64977n = System.currentTimeMillis();     // Catch: Throwable -> L112
        goto L104
    L100:
        r124 = 0;
    L112:
        th = move-exception;
        throw th;
    L68:
        if (e() <= 0) goto L87;
        Object r107 = f64967d;
        monitor-enter(r107);
    L84:
        th = move-exception;
        throw th;
    L72:
        if (f64970g != 1) goto L76;
        if (f64975l == false) goto L76;
    L81:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L84
        monitor-exit(r107);
    L76:
        if (e() <= 0) goto L81;
        ALogger.i("TraceClientMonitor", "switch from REAL_TIME to BATCH");     // Catch: Throwable -> L84
        f64970g = 1;     // Catch: Throwable -> L84
        int r109 = e();     // Catch: Throwable -> L84
        Handler r125 = f64972i;     // Catch: Throwable -> L84
        if (r125 == null) goto L80;
        r125.postDelayed(b.f64986a, ((long) r109) * 1000);     // Catch: Throwable -> L84
    L80:
        f64975l = true;     // Catch: Throwable -> L84
        goto L81
    L161:
        return;
    L116:
        if (f64970g != 1) goto L137;
        Object r126 = f64967d;
        monitor-enter(r126);
    L134:
        th = move-exception;
        throw th;
    L120:
        if (f64970g != 1) goto L125;
        ALogger.i("TraceClientMonitor", "switch from BATCH to REAL_TIME");     // Catch: Throwable -> L134
        Handler r127 = f64972i;     // Catch: Throwable -> L134
        if (r127 == null) goto L124;
        r127.removeCallbacksAndMessages(null);     // Catch: Throwable -> L134
    L124:
        List<a60.d> r128 = f64968e;     // Catch: Throwable -> L134
        f64968e = new ArrayList();     // Catch: Throwable -> L134
        f64977n = System.currentTimeMillis();     // Catch: Throwable -> L134
        f64970g = 0;     // Catch: Throwable -> L134
    L126:
        Unit r129 = Unit.INSTANCE;     // Catch: Throwable -> L134
        monitor-exit(r126);
        if (r128 == null) goto L137;
        if ((!r128.isEmpty()) == false) goto L132;
        r116 = r128;
    L132:
        if (r116 == null) goto L137;
        r102.b().b(r116);
        goto L137
    L125:
        r128 = null;
    L137:
        r102.b().b(CollectionsKt.listOf(r105));
        return;
    L54:
        if (r114.b(r105, r102) == true) goto L56;
        return;
    L8:
        if (r101.enable == false) goto L40;
        if (TextUtils.isEmpty(r100) == true) goto L40;
        if (com.bytedance.android.live.core.monitor.trace.a.f64993c.containsKey(r100) == true) goto L40;
        ConcurrentHashMap<String, Integer> r130 = com.bytedance.android.live.core.monitor.trace.a.f64992b;
        Integer r131 = r130.get(r100);
        if (r131 != null) goto L19;
        r130.put(r100, 1);
    L20:
        long r132 = SystemClock.uptimeMillis();
        if (com.bytedance.android.live.core.monitor.trace.a.f64994d != 0) goto L23;
        com.bytedance.android.live.core.monitor.trace.a.f64994d = r132;
        goto L40
    L23:
        long r133 = r132 - com.bytedance.android.live.core.monitor.trace.a.f64994d;
        if (r133 < r101.a()) goto L40;
        int r134 = (int) (r101.frequencyThreshold * (r133 / 60000.0f));
        HashMap r135 = new HashMap();
        Iterator<Map.Entry<String, Integer>> r136 = r130.entrySet().iterator();
    L28:
        if (r136.hasNext() == false) goto L32;
        Map.Entry<String, Integer> r137 = r136.next();
        if (r137.getValue().intValue() < r134) goto L28;
        com.bytedance.android.live.core.monitor.trace.a.f64993c.put(r137.getKey(), Boolean.TRUE);
        r135.put(r137.getKey(), r137.getValue());
        goto L28
    L32:
        com.bytedance.android.live.core.monitor.trace.a.f64992b.clear();
        com.bytedance.android.live.core.monitor.trace.a.f64994d = SystemClock.uptimeMillis();
        Iterator r138 = r135.entrySet().iterator();
    L34:
        if (r138.hasNext() == false) goto L40;
        Map.Entry r139 = (Map.Entry) r138.next();
        String r140 = (String) r139.getKey();
        JSONObject r141 = new JSONObject();
        r141.put("type", "trace_too_frequent");     // Catch: JSONException -> L139
        r141.put("event_type", r140);     // Catch: JSONException -> L139
    L37:
        int r142 = ((Integer) r139.getValue()).intValue();
        JSONObject r143 = new JSONObject();
        r143.put("count_per_minute", r142);     // Catch: JSONException -> L140
    L39:
        LiveTracingMonitor.i("ttlive_trace_metrics", r141, r143, new JSONObject());
        goto L34
    L19:
        r130.put(r100, Integer.valueOf(r131.intValue() + 1));
        goto L20
    }

    @JvmStatic
    public static final void i(e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        if (f64964a == true) goto L6;
        ALogger.i("TraceClientMonitor", "monitor event before init. " + d(r100));
        return;
    L6:
        b60.b r104 = f64965b;
        if (r104 != null) goto L10;
        return;
    L10:
        if (r104.getConfig().a() == false) goto L12;
        ((Handler) f64974k.getValue()).post(new c(r100, r101, r102, r103));
        return;
    L12:
        c(r100, r101, r102, r103);
    }
}
