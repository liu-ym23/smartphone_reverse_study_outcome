package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.common.utility.Logger;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.sliver.Sliver;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f6409w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f6410x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f6411y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile j f6412z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d2.d f6413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f6420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StringBuilder f6421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StringBuilder f6422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StringBuilder f6423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.apm.block.d f6424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.apm.block.d f6425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f6426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f6427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinkedList f6430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6431s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public IBlockListener f6432t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f6433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f6434v;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f6435a;

        public a(j r10) {
            this.f6435a = r10;
        }

        public final void a(StackTraceElement[] r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            TimeoutException r11 = new TimeoutException("main thread task execute more than " + j.a(this.f6435a) + "ms");
            r11.setStackTrace(r10);
            Logger.e("StackThread", "block detected", r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.b(this.f6435a) != null) goto L44;
            return;
        L44:
            j.b(this.f6435a).b();     // Catch: Throwable -> L23
            int r10 = 0;
            if (j.g(this.f6435a) == false) goto L31;
            String r11 = Sliver.getStackTrace(Looper.getMainLooper().getThread());     // Catch: Throwable -> L23
            if (r11.contains(j.h(this.f6435a)) == false) goto L11;
            return;
        L11:
            String[] r12 = r11.split("\\)\\n");     // Catch: Throwable -> L23
            j.i(this.f6435a).setLength(0);     // Catch: Throwable -> L23
            int r13 = r12.length;     // Catch: Throwable -> L23
        L12:
            if (r10 >= r13) goto L27;
            String r14 = r12[r10];     // Catch: Throwable -> L23
            String r15 = "";
            char[] r16 = r14.toCharArray();     // Catch: Throwable -> L23
            if (r16 == null) goto L26;
            if (r16.length == 0) goto L26;
            if (r16[r16.length - 1] != '(') goto L25;
            String[] r17 = r14.split("\\.");     // Catch: Throwable -> L23
            int r18 = r17.length;     // Catch: Throwable -> L23
            if (r18 <= 2) goto L25;
            r15 = r17[r18 - 2];     // Catch: Throwable -> L23
        L25:
            StringBuilder r19 = j.i(this.f6435a);     // Catch: Throwable -> L23
            r19.append("\tat " + r14);     // Catch: Throwable -> L23
            r19.append(r15);     // Catch: Throwable -> L23
            r19.append(".java:1");     // Catch: Throwable -> L23
            r19.append(")\n");     // Catch: Throwable -> L23
        L26:
            r10 = r10 + 1;     // Catch: Throwable -> L23
            goto L12
        L27:
            j.b(this.f6435a).f6387r = j.i(this.f6435a).toString();     // Catch: Throwable -> L23
            if (w0.c.B() == false) goto L50;
            Logger.e("StackThread", "block detected: " + j.i(this.f6435a).toString());     // Catch: Throwable -> L23
            return;
        L50:
            return;
        L31:
            StackTraceElement[] r20 = Looper.getMainLooper().getThread().getStackTrace();     // Catch: Throwable -> L23
            if (r20[0].getClassName().startsWith(j.h(this.f6435a)) == false) goto L34;
            return;
        L34:
            j.b(this.f6435a).f6383n = System.currentTimeMillis();     // Catch: Throwable -> L23
            j.b(this.f6435a).f6385p = r20;     // Catch: Throwable -> L23
            if (w0.c.B() == false) goto L37;
            a(r20);     // Catch: Throwable -> L23
        L37:
            j.i(this.f6435a).setLength(0);     // Catch: Throwable -> L23
            int r21 = r20.length;     // Catch: Throwable -> L23
        L38:
            if (r10 >= r21) goto L40;
            StackTraceElement r22 = r20[r10];     // Catch: Throwable -> L23
            StringBuilder r23 = j.i(this.f6435a);     // Catch: Throwable -> L23
            r23.append("\tat " + r22.getClassName());     // Catch: Throwable -> L23
            r23.append(LibrarianImpl.Constants.DOT);     // Catch: Throwable -> L23
            r23.append(r22.getMethodName());     // Catch: Throwable -> L23
            r23.append("(");     // Catch: Throwable -> L23
            r23.append(r22.getFileName());     // Catch: Throwable -> L23
            r23.append(":");     // Catch: Throwable -> L23
            r23.append(r22.getLineNumber());     // Catch: Throwable -> L23
            r23.append(")\n");     // Catch: Throwable -> L23
            r10 = r10 + 1;     // Catch: Throwable -> L23
            goto L38
        L40:
            j.b(this.f6435a).f6387r = j.i(this.f6435a).toString();     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            MonitorCoreExceptionManager.e().d(th, "block_deal_exception");
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f6436a;

        public b(j r10) {
            this.f6436a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L22:
            th = move-exception;
            MonitorCoreExceptionManager.e().d(th, "serious_block_deal_exception");
            return;
        L3:
            if (j.b(this.f6436a) != null) goto L5;
            return;
        L5:
            int r10 = 0;
            if (j.g(this.f6436a) == false) goto L28;
            String r11 = Sliver.getStackTrace(Looper.getMainLooper().getThread());     // Catch: Throwable -> L22
            if (r11.contains(j.h(this.f6436a)) == false) goto L10;
            return;
        L10:
            String[] r12 = r11.split("\\)\\n");     // Catch: Throwable -> L22
            j.j(this.f6436a).setLength(0);     // Catch: Throwable -> L22
            int r13 = r12.length;     // Catch: Throwable -> L22
        L11:
            if (r10 >= r13) goto L26;
            String r14 = r12[r10];     // Catch: Throwable -> L22
            String r15 = "";
            char[] r16 = r14.toCharArray();     // Catch: Throwable -> L22
            if (r16 == null) goto L25;
            if (r16.length == 0) goto L25;
            if (r16[r16.length - 1] != '(') goto L24;
            String[] r17 = r14.split("\\.");     // Catch: Throwable -> L22
            int r18 = r17.length;     // Catch: Throwable -> L22
            if (r18 <= 2) goto L24;
            r15 = r17[r18 - 2];     // Catch: Throwable -> L22
        L24:
            StringBuilder r19 = j.j(this.f6436a);     // Catch: Throwable -> L22
            r19.append("\tat " + r14);     // Catch: Throwable -> L22
            r19.append(r15);     // Catch: Throwable -> L22
            r19.append(".java:1");     // Catch: Throwable -> L22
            r19.append(")\n");     // Catch: Throwable -> L22
        L25:
            r10 = r10 + 1;     // Catch: Throwable -> L22
            goto L11
        L26:
            j.b(this.f6436a).f6387r = j.j(this.f6436a).toString();     // Catch: Throwable -> L22
            j.b(this.f6436a).f6384o = System.currentTimeMillis();     // Catch: Throwable -> L22
            j.b(this.f6436a).f6391v = v1.d.b().a();     // Catch: Throwable -> L22
            j.b(this.f6436a).f6392w = j.k(this.f6436a);     // Catch: Throwable -> L22
            j.b(this.f6436a).f6379j = true;     // Catch: Throwable -> L22
            return;
        L28:
            StackTraceElement[] r20 = Looper.getMainLooper().getThread().getStackTrace();     // Catch: Throwable -> L22
            if (r20[0].getClassName().startsWith(j.h(this.f6436a)) == false) goto L31;
            return;
        L31:
            j.b(this.f6436a).f6384o = System.currentTimeMillis();     // Catch: Throwable -> L22
            j.b(this.f6436a).f6386q = r20;     // Catch: Throwable -> L22
            j.b(this.f6436a).f6391v = v1.d.b().a();     // Catch: Throwable -> L22
            j.b(this.f6436a).f6392w = j.k(this.f6436a);     // Catch: Throwable -> L22
            j.b(this.f6436a).f6379j = true;     // Catch: Throwable -> L22
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm.block.d f6437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f6438b;

        public c(j r10, com.bytedance.apm.block.d r11) {
            this.f6438b = r10;
            this.f6437a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.block.d r10 = this.f6437a;
            if ((r10.f6377h - r10.f6376g) <= j.l(this.f6438b)) goto L8;
            if (b2.b.e("serious_block_monitor") == false) goto L8;
            com.bytedance.apm.block.d r11 = j.b(this.f6438b);
            PerfMonitorManager r12 = PerfMonitorManager.o();
            com.bytedance.apm.block.d r13 = this.f6437a;
            r11.f6393x = r12.f(r13.f6376g, r13.f6377h);
        L8:
            if (this.f6437a.f6381l == true) goto L14;
            com.bytedance.apm.block.d r14 = this.f6437a;
            if (r14.f6387r == null) goto L14;
            if (r14.f6382m == true) goto L14;
        L17:
            com.bytedance.apm.block.d r15 = this.f6437a;
            if ((r15.f6377h - r15.f6376g) > j.l(this.f6438b)) goto L20;
        L24:
            boolean r16 = false;
        L35:
            String r17 = g5.h.b(this.f6437a.f6371b);     // Catch: Exception -> L34
            j r18 = this.f6438b;     // Catch: Exception -> L34
            com.bytedance.apm.block.d r19 = this.f6437a;     // Catch: Exception -> L34
            j.c(r18, r19.f6373d, r19, r17);     // Catch: Exception -> L34
            if (this.f6437a.f6379j == true) goto L28;
        L32:
            j.f(this.f6438b, this.f6437a, r17);     // Catch: Exception -> L34
            return;
        L28:
            if (j.d(this.f6438b) == false) goto L32;
            if (j.n(this.f6438b) == false) goto L32;
            j.e(this.f6438b, this.f6437a, r17, r16);     // Catch: Exception -> L34
        L37:
            return;
        L20:
            if (this.f6437a.f6379j == true) goto L24;
            if (j.n(this.f6438b) == false) goto L24;
            com.bytedance.apm.block.d r20 = this.f6437a;
            r20.f6392w = j.k(this.f6438b);
            com.bytedance.apm.block.d r21 = this.f6437a;
            r21.f6391v = v1.d.b().a();
            r16 = true;
            this.f6437a.f6379j = true;
        L14:
            if (j.m(this.f6438b) == false) goto L16;
            return;
        L16:
            this.f6437a.f6387r = "Invalid Stack\n";
            goto L17
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm.block.d f6439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f6440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f6441c;

        public d(j r10, com.bytedance.apm.block.d r11, boolean r12) {
            this.f6441c = r10;
            this.f6439a = r11;
            this.f6440b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new JSONObject();
            PerfMonitorManager r11 = PerfMonitorManager.o();
            com.bytedance.apm.block.d r12 = this.f6439a;
            String r13 = r11.j(r12.f6376g, r12.f6377h);
            StringBuilder r14 = new StringBuilder();
            com.bytedance.apm.block.d r15 = this.f6439a;
            long r16 = r15.f6377h - r15.f6376g;
            if (TextUtils.isEmpty(r13) == false) goto L5;
            return;
        L5:
            String r17 = g5.f.d(r13, r14, 1000, r16);
            if (w0.c.B() == false) goto L13;
            com.bytedance.apm.logging.a.c("StackThread", "%s", new Object[]{r13});
        L13:
            r10.put("stack", r14.toString());     // Catch: JSONException -> L10
            r10.put("stack_key", r17);     // Catch: JSONException -> L10
            r10.put("scene", this.f6439a.f6389t);     // Catch: JSONException -> L10
            r10.put("cost_time", r16);     // Catch: JSONException -> L10
            r10.put("method_time", r16);     // Catch: JSONException -> L10
            r10.put("monitor_type", "sampling");     // Catch: JSONException -> L10
            r10.put("message", g5.h.b(this.f6439a.f6371b));     // Catch: JSONException -> L10
            r10.put("event_type", "lag_drop_frame");     // Catch: JSONException -> L10
            JSONObject r18 = m3.c.a().b(true);     // Catch: JSONException -> L10
            r18.put("crash_section", w0.c.A(j.b(this.f6441c).f6378i));     // Catch: JSONException -> L10
            r18.put("belong_frame", String.valueOf(this.f6440b));     // Catch: JSONException -> L10
            r18.put("monitor_type", "sample");     // Catch: JSONException -> L10
            r10.put("filters", r18);     // Catch: JSONException -> L10
            l1.a.p().e(new m1.d("drop_frame_stack", r10));     // Catch: JSONException -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }

    public j() {
        this.f6414b = false;
        this.f6415c = false;
        this.f6416d = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
        this.f6417e = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
        this.f6418f = false;
        this.f6419g = true;
        this.f6421i = new StringBuilder(1200);
        this.f6422j = new StringBuilder(1200);
        this.f6423k = new StringBuilder(1200);
        this.f6425m = null;
        this.f6426n = false;
        this.f6427o = false;
        this.f6428p = true;
        this.f6429q = true;
        this.f6430r = new LinkedList();
        this.f6431s = false;
        this.f6432t = null;
        this.f6433u = new a(this);
        this.f6434v = new b(this);
        this.f6420h = j.class.getName();
    }

    public static boolean A(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static void M(long r10) {
        if (r10 >= 70) goto L5;
        r10 = 1000;
    L5:
        f6409w = r10;
    }

    public static /* synthetic */ long a(j r10) {
        return r10.f6416d;
    }

    public static /* synthetic */ com.bytedance.apm.block.d b(j r10) {
        return r10.f6424l;
    }

    public static /* synthetic */ void c(j r10, boolean r11, com.bytedance.apm.block.d r12, String r13) {
        r10.E(r11, r12, r13);
    }

    public static /* synthetic */ boolean d(j r10) {
        return r10.f6414b;
    }

    public static /* synthetic */ void e(j r10, com.bytedance.apm.block.d r11, String r12, boolean r13) {
        r10.G(r11, r12, r13);
    }

    public static /* synthetic */ void f(j r10, com.bytedance.apm.block.d r11, String r12) {
        r10.F(r11, r12);
    }

    public static /* synthetic */ boolean g(j r10) {
        return r10.f6431s;
    }

    public static /* synthetic */ String h(j r10) {
        return r10.f6420h;
    }

    public static /* synthetic */ StringBuilder i(j r10) {
        return r10.f6421i;
    }

    public static /* synthetic */ StringBuilder j(j r10) {
        return r10.f6422j;
    }

    public static /* synthetic */ JSONObject k(j r10) {
        return r10.w();
    }

    public static /* synthetic */ long l(j r10) {
        return r10.f6417e;
    }

    public static /* synthetic */ boolean m(j r10) {
        return r10.f6415c;
    }

    public static /* synthetic */ boolean n(j r10) {
        return r10.f6419g;
    }

    public static j v() {
        if (f6412z != null) goto L16;
        monitor-enter(j.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6412z != null) goto L11;
        f6412z = new j();     // Catch: Throwable -> L9
    L11:
        monitor-exit(j.class);     // Catch: Throwable -> L9
    L16:
        return f6412z;
    }

    public static boolean z(StackTraceElement r10, StackTraceElement r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == null) goto L18;
        if (r11 == null) goto L18;
        if (r10.getClassName().equals(r11.getClassName()) == false) goto L17;
        if (A(r10.getMethodName(), r11.getMethodName()) == false) goto L17;
        if (A(r10.getFileName(), r11.getFileName()) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public final JSONObject B(com.bytedance.apm.block.d r10) {
        long r11 = r10.f6377h - r10.f6376g;
        JSONObject r12 = new JSONObject();
        r12.put("timestamp", r10.f6378i);     // Catch: JSONException -> L5
        r12.put(CommonKey.KEY_CRASH_TIME, r10.f6378i);     // Catch: JSONException -> L5
        r12.put("is_main_process", w0.c.F());     // Catch: JSONException -> L5
        r12.put("process_name", w0.c.h());     // Catch: JSONException -> L5
        r12.put("block_duration", r11);     // Catch: JSONException -> L5
        r12.put("last_scene", r10.f6389t);     // Catch: JSONException -> L5
    L7:
        return r12;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void C(boolean r10) {
        if (this.f6413a.e() == false) goto L55;
        com.bytedance.apm.block.d r11 = this.f6425m;     // Catch: Exception -> L52
        if (r11 == null) goto L9;
        if (r10 == false) goto L8;
        r11.f6375f = true;     // Catch: Exception -> L52
    L8:
        r(r11);     // Catch: Exception -> L52
        this.f6425m = null;     // Catch: Exception -> L52
    L9:
        com.bytedance.apm.block.d r12 = this.f6424l;     // Catch: Exception -> L52
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.f6376g >= 0) goto L14;
        return;
    L14:
        if (r12.f6377h != (-1)) goto L58;
        r12.f6377h = g5.a.f19916b;     // Catch: Exception -> L52
        if (this.f6419g == false) goto L19;
        this.f6413a.h(this.f6433u);     // Catch: Exception -> L52
        this.f6413a.h(this.f6434v);     // Catch: Exception -> L52
    L19:
        com.bytedance.apm.block.d r13 = this.f6424l;     // Catch: Exception -> L52
        if ((r13.f6377h - r13.f6376g) <= this.f6416d) goto L31;
        s(r13);     // Catch: Exception -> L52
        com.bytedance.apm.block.d r14 = this.f6424l;     // Catch: Exception -> L52
        r14.f6378i = System.currentTimeMillis();     // Catch: Exception -> L52
        if (this.f6419g == true) goto L24;
        this.f6424l.f6382m = true;     // Catch: Exception -> L52
    L24:
        com.bytedance.apm.block.d r15 = this.f6424l;     // Catch: Exception -> L52
        r15.f6373d = r10;     // Catch: Exception -> L52
        r15.f6372c = this.f6426n;     // Catch: Exception -> L52
        x(this.f6424l.a());     // Catch: Exception -> L52
        com.bytedance.apm.block.d r16 = this.f6424l;     // Catch: Exception -> L52
        if ((r16.f6377h - r16.f6376g) <= this.f6417e) goto L31;
        if (r10 == false) goto L31;
        if (this.f6427o == false) goto L31;
        h.a();     // Catch: Exception -> L52
    L31:
        if (f6410x == false) goto L42;
        com.bytedance.apm.block.d r17 = this.f6424l;     // Catch: Exception -> L52
        if ((r17.f6377h - r17.f6376g) <= f6409w) goto L42;
        if (TextUtils.isEmpty(r17.f6389t) == false) goto L37;
        s(this.f6424l);     // Catch: Exception -> L52
    L37:
        com.bytedance.apm.block.d r18 = this.f6424l;     // Catch: Exception -> L52
        if (r18.f6378i != 0) goto L40;
        r18.f6378i = System.currentTimeMillis();     // Catch: Exception -> L52
    L40:
        H(r10, this.f6424l.a());     // Catch: Exception -> L52
    L42:
        if (f6411y == false) goto L59;
        Message r19 = g5.c.b(g5.c.a());     // Catch: Exception -> L52
        if (r19 != null) goto L46;
        return;
    L46:
        long r20 = SystemClock.uptimeMillis();     // Catch: Exception -> L52
        if (r19.getTarget() != null) goto L49;
        return;
    L49:
        if (r19.getWhen() >= r20) goto L61;
        this.f6418f = true;     // Catch: Exception -> L52
        this.f6424l.c(r20, null);     // Catch: Exception -> L52
        this.f6413a.g(this.f6433u, this.f6416d);     // Catch: Exception -> L52
        return;
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L55:
        return;
    }

    public void D(String r10) {
        if (this.f6413a.e() == true) goto L5;
        return;
    L5:
        if (f6411y == false) goto L12;
        if (this.f6418f == false) goto L12;
        com.bytedance.apm.block.d r11 = this.f6424l;     // Catch: Exception -> L28
        long r12 = g5.a.f19916b;     // Catch: Exception -> L28
        r11.f6377h = r12;     // Catch: Exception -> L28
        if ((r12 - r11.f6376g) <= this.f6416d) goto L12;
        r11.f6380k = true;     // Catch: Exception -> L28
        r11.f6373d = false;     // Catch: Exception -> L28
        r11.f6372c = this.f6426n;     // Catch: Exception -> L28
        x(this.f6424l.a());     // Catch: Exception -> L28
    L12:
        if (this.f6425m != null) goto L14;
    L16:
        com.bytedance.apm.block.d r13 = this.f6424l;     // Catch: Exception -> L28
        if (r13 != null) goto L19;
        this.f6424l = new com.bytedance.apm.block.d(g5.a.f19916b, r10);     // Catch: Exception -> L28
    L21:
        if (this.f6419g == false) goto L32;
        this.f6413a.g(this.f6433u, this.f6416d);     // Catch: Exception -> L28
        if (this.f6414b == true) goto L25;
        return;
    L25:
        if (this.f6429q == false) goto L34;
        this.f6413a.g(this.f6434v, this.f6417e);     // Catch: Exception -> L28
        return;
    L34:
        return;
    L32:
        return;
    L19:
        r13.c(g5.a.f19916b, r10);     // Catch: Exception -> L28
        goto L21
    L14:
        if (g1.d.A().f19811b.b() == false) goto L16;
        this.f6425m.f6374e = true;     // Catch: Exception -> L28
    }

    public final void E(boolean r10, com.bytedance.apm.block.d r11, String r12) {
        if (this.f6428p == true) goto L5;
        return;
    L5:
        JSONObject r13 = B(r11);
        r13.put("stack", r11.f6387r);
        r13.put("message", r12);
        r13.put("ignore_stack", this.f6424l.f6382m);
        r13.put("event_type", "lag");
        r13.put("filters", u(r10, r11, r12));
        r13.put("custom", t());
        m1.d r14 = new m1.d("block_monitor", r13, r11.f6376g);
        p(r14);
        l1.a.p().e(r14);
        IBlockListener r15 = this.f6432t;
        if (r15 == null) goto L9;
        r15.onBlockDetect(r11.f6371b, r11.f6377h - r11.f6376g, r11.f6389t, r11.f6387r);
        return;
    }

    public final void F(com.bytedance.apm.block.d r10, String r11) {
        if (PerfConfig.a() == false) goto L6;
        JSONObject r12 = B(r10);
        JSONObject r13 = m3.c.a().b(true);
        r13.put("crash_section", w0.c.A(r10.f6378i));
        r13.put("belong_frame", String.valueOf(r10.f6373d));
        r13.put("belong_dump", String.valueOf(r10.f6372c));
        r13.put("block_stack_type", "messageKey");
        r12.put("filters", r13);
        r12.put("event_type", "lag");
        r12.put("stack", "at " + r11 + ".*(a.java:-1)");
        m1.d r14 = new m1.d("block_monitor", r12);
        r14.b();
        l1.a.p().e(r14);
        return;
    }

    public final void G(com.bytedance.apm.block.d r18, String r19, boolean r20) {
        if (this.f6429q == true) goto L5;
        return;
    L5:
        Logger.e("StackThread", "reportSeriousBlock :" + r18.f6387r);
        JSONObject r10 = u(r18.f6373d, r18, r19);
        r10.put("sbuuid", "empty");
        JSONObject r11 = B(r18);
        r11.put("message", r19);
        StackTraceElement[] r12 = r18.f6385p;
        if (r12 == null) goto L43;
        StackTraceElement[] r13 = r18.f6386q;
        if (r13 == null) goto L43;
        int r14 = r12.length;
        int r15 = r13.length;
        int r16 = 0;
        int r17 = 0;
    L11:
        if (r16 >= Math.min(r14, r15)) goto L19;
        int r110 = (r14 - r16) - 1;
        int r111 = (r15 - r16) - 1;
        if (r18.f6385p[r110].equals(r18.f6386q[r111]) == false) goto L15;
        r17 = r17 + 1;
        r16 = r16 + 1;
        goto L11
    L15:
        if (z(r18.f6385p[r110], r18.f6386q[r111]) == false) goto L19;
        r17 = r17 + 1;
    L19:
        if (r17 != 0) goto L22;
        r10.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, SchedulerSupport.NONE);
    L21:
        JSONObject r112 = r10;
    L34:
        this.f6423k.setLength(0);
    L35:
        if (r17 <= 0) goto L38;
        StringBuilder r21 = this.f6423k;
        r21.append("\tat ");
        int r22 = r14 - r17;
        r21.append(r18.f6385p[r22].getClassName());
        r21.append(LibrarianImpl.Constants.DOT);
        r21.append(r18.f6385p[r22].getMethodName());
        r21.append("(");
        r21.append(r18.f6385p[r22].getFileName());
        r21.append(":");
        r21.append(r18.f6385p[r22].getLineNumber());
        r21.append(")\n");
        r17 = r17 - 1;
        goto L35
    L38:
        if (this.f6423k.length() != 0) goto L40;
        String r23 = r18.f6387r;
    L41:
        r11.put("stack", r23);
        r10 = r112;
        r10.put("sbuuid", r18.f6388s);
        goto L43
    L40:
        r23 = this.f6423k.toString();
        goto L41
    L22:
        if (r17 != r14) goto L25;
        if (r17 != r15) goto L25;
        r10.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "full");
    L25:
        r10.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "part");
        this.f6423k.setLength(0);
        int r24 = 0;
    L27:
        if (r24 > (r14 - r17)) goto L29;
        StringBuilder r113 = this.f6423k;
        r113.append("\tat ");
        r113.append(r18.f6385p[r24].getClassName());
        r113.append(LibrarianImpl.Constants.DOT);
        r113.append(r18.f6385p[r24].getMethodName());
        r113.append("(");
        r113.append(r18.f6385p[r24].getFileName());
        r113.append(":");
        r113.append(r18.f6385p[r24].getLineNumber());
        r113.append(")\n");
        r24 = r24 + 1;
        r10 = r10;
        goto L27
    L29:
        r112 = r10;
        r11.put(CommonKey.KEY_STACK1, this.f6423k.toString());
        this.f6423k.setLength(0);
        int r114 = 0;
    L31:
        if (r114 > (r15 - r17)) goto L33;
        StringBuilder r25 = this.f6423k;
        r25.append("\tat ");
        r25.append(r18.f6386q[r114].getClassName());
        r25.append(LibrarianImpl.Constants.DOT);
        r25.append(r18.f6386q[r114].getMethodName());
        r25.append("(");
        r25.append(r18.f6386q[r114].getFileName());
        r25.append(":");
        r25.append(r18.f6386q[r114].getLineNumber());
        r25.append(")\n");
        r114 = r114 + 1;
        goto L31
    L33:
        r11.put(CommonKey.KEY_STACK2, this.f6423k.toString());
    L43:
        if (this.f6431s == false) goto L45;
        r11.put("stack", r18.f6387r);
        r10.put("sbuuid", r18.f6388s);
    L45:
        r11.put(CommonKey.KEY_STACK_COST, r18.f6384o - r18.f6383n);
        r11.put("filters", r10);
        r11.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_SERIOUS_LAG);
        r11.put("block_looper_info", r18.f6390u);
        r11.put(CommonKey.KEY_BLOCK_CPU_INFO, r18.f6391v);
        r11.put(CommonKey.KEY_BLOCK_MEMORY_INFO, r18.f6392w);
        r11.put("custom", r18.f6393x);
        r11.put(CommonKey.KEY_BLOCK_ERROR_INFO, r20);
        m1.d r26 = new m1.d("serious_block_monitor", r11, r18.f6376g);
        p(r26);
        l1.a.p().e(r26);
        IBlockListener r27 = this.f6432t;
        if (r27 == null) goto L54;
        r27.onSeriousBlockDetect(r18.f6371b, r18.f6377h - r18.f6376g, r18.f6389t, r18.f6387r);
        return;
    }

    public final void H(boolean r10, com.bytedance.apm.block.d r11) {
        AsyncEventManager.e().h(new d(this, r11, r10));
    }

    public void I(long r10) {
        if (r10 >= 70) goto L5;
        r10 = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
    L5:
        this.f6416d = r10;
        q();
    }

    public void J(IBlockListener r10) {
        this.f6432t = r10;
    }

    public void K(boolean r10) {
        this.f6419g = r10;
    }

    public void L(boolean r10) {
        this.f6427o = r10;
    }

    public void N(boolean r10) {
        this.f6415c = r10;
    }

    public void O(boolean r10) {
        this.f6428p = r10;
    }

    public void P(boolean r10) {
        this.f6429q = r10;
    }

    public void Q(long r10) {
        if (r10 >= this.f6416d) goto L5;
        r10 = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
    L5:
        this.f6417e = r10;
        q();
    }

    public void R(boolean r10) {
        this.f6431s = r10;
    }

    public void S(boolean r10) {
        this.f6414b = r10;
    }

    public final StackTraceElement[] o(StackTraceElement[] r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", "a", "a.java", 1)};
    }

    public final void p(m1.d r10) {
    L3:
        if (this.f6430r.size() == 0) goto L13;
        if ((r10.a() - ((m1.d) this.f6430r.getFirst()).a()) < 0) goto L12;
        if ((r10.a() - ((m1.d) this.f6430r.getFirst()).a()) > 60000) goto L12;
        if (this.f6430r.size() <= 60) goto L13;
        this.f6430r.removeFirst();
    L12:
        this.f6430r.removeFirst();
    L13:
        this.f6430r.addLast(r10);
    }

    public final void q() {
        long r10 = this.f6417e;
        long r11 = this.f6416d;
        if (r10 >= r11) goto L6;
        this.f6417e = r11 + 50;
        return;
    }

    public final void r(com.bytedance.apm.block.d r10) {
        AsyncEventManager.e().h(new c(this, r10));
    }

    public final void s(com.bytedance.apm.block.d r10) {
        String r11 = FpsTracer.w();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r10.f6389t = ActivityLifeObserver.getInstance().getTopActivityClassName();
        return;
    L5:
        r10.f6389t = r11 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    public final JSONObject t() {
        JSONObject r10 = new JSONObject();
        Map r11 = com.bytedance.apm.block.c.a();     // Catch: JSONException -> L13
        if (r11 == null) goto L12;
        if (r11.isEmpty() == true) goto L12;
        Iterator r12 = r11.entrySet().iterator();     // Catch: JSONException -> L13
    L9:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L13
        r10.put((String) r13.getKey(), r13.getValue());     // Catch: JSONException -> L13
    L12:
        return r10;
    }

    public final JSONObject u(boolean r10, com.bytedance.apm.block.d r11, String r12) {
        JSONObject r13 = m3.c.a().b(true);
        r13.put("crash_section", w0.c.A(r11.f6378i));
        r13.put("belong_frame", String.valueOf(r10));
        r13.put("belong_dump", String.valueOf(r11.f6372c));
        r13.put(CommonKey.KEY_BLOCK_INPUT, String.valueOf(r11.f6374e));
        r13.put(CommonKey.KEY_BLOCK_FRAME, String.valueOf(r11.f6375f));
        r13.put(CommonKey.KEY_BLOCK_MESSAGE, r12);
        r13.put("block_stack_type", "stack");
        r13.put("buuid", r11.f6388s);
        r13.put(CommonKey.KEY_BELONG_POLL_ONCE, String.valueOf(r11.f6380k));
        Map r14 = com.bytedance.apm.block.c.a();
        if (r14 != null) goto L5;
    L10:
        return r13;
    L5:
        if (r14.isEmpty() == true) goto L10;
        Iterator r15 = r14.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Map.Entry r16 = (Map.Entry) r15.next();
        r13.put((String) r16.getKey(), r16.getValue());
        goto L8
    }

    public final JSONObject w() {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L7
        Context r11 = w0.c.g();     // Catch: Exception -> L7
        if (r11 == null) goto L5;
        ActivityManager r12 = (ActivityManager) r11.getSystemService("activity");     // Catch: Exception -> L7
        ActivityManager.MemoryInfo r13 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L7
        r12.getMemoryInfo(r13);     // Catch: Exception -> L7
        r10.put("availMem", r13.availMem);     // Catch: Exception -> L7
        r10.put("lowMemory", r13.lowMemory);     // Catch: Exception -> L7
        r10.put("threshold", r13.threshold);     // Catch: Exception -> L7
        r10.put("totalMem", v3.a.a(r13));     // Catch: Exception -> L7
    L5:
        Runtime r14 = Runtime.getRuntime();     // Catch: Exception -> L7
        r10.put("max_memory", r14.maxMemory());     // Catch: Exception -> L7
        r10.put("free_memory", r14.freeMemory());     // Catch: Exception -> L7
        r10.put("total_memory", r14.totalMemory());     // Catch: Exception -> L7
        return r10;
    L7:
        return null;
    }

    public final void x(com.bytedance.apm.block.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f6370a == true) goto L8;
        r10.b();
    L8:
        if ((r10.f6377h - r10.f6376g) < this.f6417e) goto L10;
        boolean r11 = true;
    L11:
        r10.f6379j = r11;
        LooperDispatchMonitor.h r12 = PerfMonitorManager.o().p();
        if (r12 == null) goto L19;
        StackTraceElement[] r13 = o(r10.f6385p);
        if (r10.f6379j == false) goto L16;
        StackTraceElement[] r14 = o(r10.f6386q);
    L17:
        r12.f("uuid", r13, r14, null);
        goto L19
    L16:
        r14 = null;
    L19:
        if (r10.f6380k == false) goto L21;
        r(r10);
        return;
    L21:
        this.f6425m = r10;
        return;
    L10:
        r11 = false;
        goto L11
    }

    public void y() {
        d2.d r10 = new d2.d("StackThread");
        this.f6413a = r10;
        r10.k();
    }
}
