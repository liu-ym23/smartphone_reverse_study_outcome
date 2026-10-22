package com.bytedance.perf.monitor;

import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.block.e;
import com.bytedance.apm.block.h;
import com.bytedance.apm.block.trace.f;
import com.bytedance.apm.block.trace.g;
import com.bytedance.apm.c;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.d.b.d;
import com.bytedance.apm6.util.i;
import com.bytedance.monitor.collector.k;
import com.bytedance.monitor.collector.o;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: compiled from: EvilMethodTracer.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.block.a implements e {
    private static final String TAG = "EvilMethodTracer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9044a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9045b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f9046c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f9047d = null;
    private static long k = 0;
    private static volatile boolean l = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f9048e;
    private g.a f;
    private g.a g;
    private volatile String h;
    private long[] i;
    private boolean j;
    private volatile long m;
    private RunnableC0205a n;
    private boolean o;

    /* JADX INFO: renamed from: com.bytedance.perf.monitor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EvilMethodTracer.java */
    private class RunnableC0205a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long[] f9054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long[] f9055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f9056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f9057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f9058e;
        String f;
        boolean g;
        String h;
        String i;
        long j;
        com.bytedance.monitor.collector.g.e k;
        final /* synthetic */ a l;
        private boolean m;
        private boolean n;

        static /* synthetic */ boolean a(RunnableC0205a r0, boolean r1) {
            r0.n = r1;
            return r1;
        }

        static /* synthetic */ boolean b(RunnableC0205a r0, boolean r1) {
            r0.m = r1;
            return r1;
        }

        RunnableC0205a(a r4, boolean r5, String r6, long[] r7, long[] r8, long r9, long r11, long r13, String r15, long r16, String r18, com.bytedance.monitor.collector.g.e r19) {
            this.l = r4;
            this.g = r5;
            this.f = r6;
            this.f9057d = r11;
            this.f9056c = r9;
            this.f9055b = r7;
            this.f9054a = r8;
            this.f9058e = r13;
            this.h = r15;
            this.j = r16;
            this.i = r18;
            this.k = r19;
        }

        void a() {
            LinkedList r2 = new LinkedList();     // Catch: Exception -> L14
            long[] r3 = this.f9055b;     // Catch: Exception -> L14
            if (r3.length <= 0) goto L7;
            com.bytedance.perf.a.a.a(r3, r2, true, this.f9058e);     // Catch: Exception -> L14
            com.bytedance.perf.a.a.a(r2, 30, new AnonymousClass1(this));     // Catch: Exception -> L14
        L7:
            if (r2.size() > 2) goto L9;
            return;
        L9:
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L14
            long r5 = Math.max(this.f9057d, com.bytedance.perf.a.a.a(r2, r4));     // Catch: Exception -> L14
            String r6 = com.bytedance.perf.a.a.a(r2, r5);     // Catch: Exception -> L14
            JSONObject r7 = new JSONObject();     // Catch: Exception -> L14
            String r8 = r4.toString();     // Catch: Exception -> L14
            com.bytedance.monitor.collector.g.e r9 = this.k;     // Catch: Exception -> L14
            if (r9 == null) goto L12;
            r9.a(this.i, null, null, r8);     // Catch: Exception -> L14
        L12:
            r7.put("stack", r8);     // Catch: Exception -> L14
            r7.put("stack_key", r6);     // Catch: Exception -> L14
            r7.put(DBHelper.BATTERY_COL_SCENE, this.f);     // Catch: Exception -> L14
            r7.put("cost_time", r5);     // Catch: Exception -> L14
            r7.put("cpu_cost", this.f9056c);     // Catch: Exception -> L14
            r7.put("method_time", r5);     // Catch: Exception -> L14
            k r10 = k.a();     // Catch: Exception -> L14
            long r11 = this.f9058e;     // Catch: Exception -> L14
            JSONObject r12 = r10.a(r11 - this.f9057d, r11);     // Catch: Exception -> L14
            g r13 = g.a();     // Catch: Exception -> L14
            long r14 = this.f9058e;     // Catch: Exception -> L14
            r12.put("evil_method", r13.a(r14 - this.f9057d, r14));     // Catch: Exception -> L14
            r7.put(MonitorConstants.CUSTOM, r12);     // Catch: Exception -> L14
            r7.put("message", o.a(this.h));     // Catch: Exception -> L14
            r7.put(DBHelper.COL_TIME, this.f9058e);     // Catch: Exception -> L14
            r7.put("event_type", "lag_drop_frame");     // Catch: Exception -> L14
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L14
            r15.put("crash_section", c.h(this.j));     // Catch: Exception -> L14
            r15.put("block_frame", String.valueOf(this.n));     // Catch: Exception -> L14
            r15.put("block_input", String.valueOf(this.m));     // Catch: Exception -> L14
            r15.put("trace_type", "message");     // Catch: Exception -> L14
            r15.put("update_version_code", c.p().optString("update_version_code"));     // Catch: Exception -> L14
            r7.put("filters", r15);     // Catch: Exception -> L14
            com.bytedance.apm.d.a.a.c().a(new d("drop_frame_stack", r7));     // Catch: Exception -> L14
            a.b("evil_method_end");     // Catch: Exception -> L14
            return;
        L14:
            a.b("evil_method_analyse_exception");
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static {
    }

    static /* synthetic */ void b(String r0) {
        c(r0);
    }

    public a() {
        this(false);
    }

    public a(boolean r1) {
        this(false, false);
    }

    public a(boolean r4, boolean r5) {
        this.f9048e = false;
        this.i = new long[3];
        this.m = 0;
        this.n = null;
        this.o = false;
        this.j = r4;
        if (r5 == true) goto L6;
        c();
    L6:
        if (f9046c != null) goto L9;
        f9046c = this;
        return;
    }

    public static void a(b r2) {
        f9047d = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.apm.block.e
    public void a(boolean r1, long r2) {
        a(r2);
        f9045b = r1;
        if (r1 == true) goto L6;
        i.a(new AnonymousClass1(this));
        g.a().c();
        return;
    }

    public synchronized void b() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.o == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (f9045b == true) goto L10;
    L12:
        this.o = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (f9044a == false) goto L12;
        f.a().a(this);     // Catch: Throwable -> L15
        goto L12
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r6) {
        super.a(r6);
        g.a(1048574, com.bytedance.monitor.collector.a.f8947b);
        if ((com.bytedance.monitor.collector.a.f8947b - this.m) <= 300) goto L9;
        this.g = this.f;
        this.m = com.bytedance.monitor.collector.a.f8947b;
        this.f = g.a("EvilMethodTracer#dispatchBegin", 0);
        if (this.f9048e == false) goto L9;
        if (this.g == null) goto L9;
        final long[] r0 = g.a().a(this.g);     // Catch: Throwable -> L11
        final long r1 = com.bytedance.monitor.collector.a.f8947b;     // Catch: Throwable -> L11
        k.a().i().b(new AnonymousClass2(this, r0, r1));     // Catch: Throwable -> L11
    L9:
        this.h = r6;
    }

    @Override // com.bytedance.apm.block.a
    public void a(long r19, long r21, long r23, long r25, boolean r27) {
        super.a(r19, r21, r23, r25, r27);
        g.b(1048574, com.bytedance.monitor.collector.a.f8947b);
        RunnableC0205a r1 = this.n;
        if (r1 == null) goto L6;
        RunnableC0205a.a(r1, r27);
        RunnableC0205a.b(this.n, f.a().f4428a.b());
        com.bytedance.apm.thread.b.a().a(this.n);
        this.n = null;
    L6:
        if (g.a().d() == true) goto L8;
        return;
    L8:
        long r8 = r23 - r19;
        if (r8 < k) goto L25;
        b r2 = f9047d;
        if (r2 == null) goto L13;
        r2.a(r8, r27);
    L13:
        c("evil_method_begin");
        long[] r4 = g.a().a(this.f);
        if (r4 != null) goto L16;
    L23:
        c("evil_method_data_null");
        return;
    L16:
        if (r4.length == 0) goto L23;
        long[] r5 = new long[3];
        System.arraycopy(this.i, 0, r5, 0, 3);
        String r0 = h.a();
        if (TextUtils.isEmpty(r0) == false) goto L21;
        String r3 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L22:
        String r12 = this.h;
        this.n = new RunnableC0205a(this, ActivityLifeObserver.getInstance().isForeground(), r3, r4, r5, r25 - r21, r8, r23, r12, System.currentTimeMillis(), "uuid", k.a().o());
        return;
    L21:
        r3 = r0 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L22
    }

    private static void c(final String r2) {
        com.bytedance.apm.thread.b.a().a(new AnonymousClass3(r2));
    }

    public void c() {
        if (l == false) goto L5;
        return;
    L5:
        com.bytedance.apm.block.f.a(this);
        l = true;
    }

    public static void a(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        k = r2;
    }

    public static void a(boolean r0) {
        f9045b = r0;
    }

    public void b(boolean r1) {
        this.j = r1;
    }
}
