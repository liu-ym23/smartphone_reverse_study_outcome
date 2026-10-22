package o5;

import android.text.TextUtils;
import com.bytedance.apm.block.EvilMethodSwitchListener;
import com.bytedance.apm.block.g;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.monitor.collector.IHyperMonitor;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.perf.collector.TraceDataUtils;
import com.bytedance.perf.monitor.IBlockListener;
import g1.e;
import g1.f;
import g5.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.block.a implements EvilMethodSwitchListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static a f22497k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static IBlockListener f22498l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f22499m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f22500n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f22501o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f22502p = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f22503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e.f f22504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.f f22505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f22506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long[] f22507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f22509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f22510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22511j;

    /* JADX INFO: renamed from: o5.a$a, reason: collision with other inner class name */
    public class RunnableC0324a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22512a;

        public RunnableC0324a(a r10) {
            this.f22512a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.d.A().K(this.f22512a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f22513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f22514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f22515c;

        public b(a r10, long[] r11, long r12) {
            this.f22515c = r10;
            this.f22513a = r11;
            this.f22514b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r10 = new LinkedList();
            TraceDataUtils.j(this.f22513a, r10, true, g5.a.f19916b);
            TraceDataUtils.f(r10, 5);
            IHyperMonitor.ILogInstance r11 = PerfMonitorManager.o().q();
            if (r11 != null) goto L6;
            return;
        L6:
            if (r10.size() > 2) goto L8;
            return;
        L8:
            r11.i("method_tracer", "in," + this.f22514b);
            Iterator r12 = r10.iterator();
        L10:
            if (r12.hasNext() == false) goto L12;
            r11.i("method_tracer", ((f) r12.next()).toString());
            goto L10
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22516a;

        public c(String r10) {
            this.f22516a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
            r10.put("evil_method_section", this.f22516a);     // Catch: JSONException -> L4
            l1.a.p().e(new m1.c("evil_method_tracing", 0, null, r10, null, null));     // Catch: JSONException -> L4
            return;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long[] f22519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long[] f22520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f22521e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f22522f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f22523g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f22524h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f22525i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f22526j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f22527k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f22528l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public LooperDispatchMonitor.h f22529m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ a f22530n;

        /* JADX INFO: renamed from: o5.a$d$a, reason: collision with other inner class name */
        public class C0325a implements TraceDataUtils.IStructuredDataFilter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f22531a;

            public C0325a(d r10) {
                this.f22531a = r10;
            }

            @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
            public void fallback(List r10, int r11) {
                if (w0.c.B() == false) goto L5;
                com.bytedance.apm.logging.a.c("EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(r11), 30, r10});
            L5:
                ListIterator r12 = r10.listIterator(Math.min(r11, 30));
            L7:
                if (r12.hasNext() == false) goto L9;
                r12.next();
                r12.remove();
                goto L7
            }

            @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
            public int getFilterMaxCount() {
                return 60;
            }

            @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
            public boolean isFilter(long r10, int r11) {
                if (r10 >= (r11 * 5)) goto L5;
                return true;
            L5:
                return false;
            }
        }

        public d(a r10, boolean r11, String r12, long[] r13, long[] r14, long r15, long r16, long r17, String r18, long r19, String r110, LooperDispatchMonitor.h r111) {
            this.f22530n = r10;
            this.f22525i = r11;
            this.f22524h = r12;
            this.f22522f = r16;
            this.f22521e = r15;
            this.f22520d = r13;
            this.f22519c = r14;
            this.f22523g = r17;
            this.f22526j = r18;
            this.f22528l = r19;
            this.f22527k = r110;
            this.f22529m = r111;
        }

        public static /* synthetic */ boolean a(d r10, boolean r11) {
            r10.f22518b = r11;
            return r11;
        }

        public static /* synthetic */ boolean b(d r10, boolean r11) {
            r10.f22517a = r11;
            return r11;
        }

        public void c() {
            LinkedList r10 = new LinkedList();     // Catch: Exception -> L14
            long[] r11 = this.f22520d;     // Catch: Exception -> L14
            if (r11.length <= 0) goto L7;
            TraceDataUtils.j(r11, r10, true, this.f22523g);     // Catch: Exception -> L14
            TraceDataUtils.m(r10, 30, new C0325a(this));     // Catch: Exception -> L14
        L7:
            if (r10.size() > 2) goto L9;
            return;
        L9:
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L14
            long r13 = Math.max(this.f22522f, TraceDataUtils.g(r10, r12));     // Catch: Exception -> L14
            String r14 = TraceDataUtils.d(r10, r13);     // Catch: Exception -> L14
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L14
            String r16 = r12.toString();     // Catch: Exception -> L14
            LooperDispatchMonitor.h r17 = this.f22529m;     // Catch: Exception -> L14
            if (r17 == null) goto L12;
            r17.f(this.f22527k, null, null, r16);     // Catch: Exception -> L14
        L12:
            r15.put("stack", r16);     // Catch: Exception -> L14
            r15.put("stack_key", r14);     // Catch: Exception -> L14
            r15.put("scene", this.f22524h);     // Catch: Exception -> L14
            r15.put("cost_time", r13);     // Catch: Exception -> L14
            r15.put("cpu_cost", this.f22521e);     // Catch: Exception -> L14
            r15.put("method_time", r13);     // Catch: Exception -> L14
            PerfMonitorManager r18 = PerfMonitorManager.o();     // Catch: Exception -> L14
            long r19 = this.f22523g;     // Catch: Exception -> L14
            JSONObject r20 = r18.f(r19 - this.f22522f, r19);     // Catch: Exception -> L14
            e r21 = e.E();     // Catch: Exception -> L14
            long r22 = this.f22523g;     // Catch: Exception -> L14
            r20.put("evil_method", r21.D(r22 - this.f22522f, r22));     // Catch: Exception -> L14
            r15.put("custom", r20);     // Catch: Exception -> L14
            r15.put("message", h.b(this.f22526j));     // Catch: Exception -> L14
            r15.put("timestamp", this.f22523g);     // Catch: Exception -> L14
            r15.put("event_type", "lag_drop_frame");     // Catch: Exception -> L14
            JSONObject r23 = new JSONObject();     // Catch: Exception -> L14
            r23.put("crash_section", w0.c.A(this.f22528l));     // Catch: Exception -> L14
            r23.put(CommonKey.KEY_BLOCK_FRAME, String.valueOf(this.f22518b));     // Catch: Exception -> L14
            r23.put(CommonKey.KEY_BLOCK_INPUT, String.valueOf(this.f22517a));     // Catch: Exception -> L14
            r23.put(CommonKey.KEY_TRACE_TYPE, "message");     // Catch: Exception -> L14
            r23.put("update_version_code", w0.c.k().optString("update_version_code"));     // Catch: Exception -> L14
            r15.put("filters", r23);     // Catch: Exception -> L14
            l1.a.p().e(new m1.d("drop_frame_stack", r15));     // Catch: Exception -> L14
            a.f("evil_method_end");     // Catch: Exception -> L14
            return;
        L14:
            a.f("evil_method_analyse_exception");
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    static {
    }

    public a(boolean r10) {
        this(false, false);
    }

    public static /* synthetic */ void f(String r10) {
        h(r10);
    }

    public static void h(String r10) {
        AsyncEventManager.e().h(new c(r10));
    }

    public static void i(IBlockListener r10) {
        f22498l = r10;
    }

    public static void j(long r10) {
        if (r10 >= 70) goto L5;
        r10 = 1000;
    L5:
        f22499m = r10;
    }

    public static void k(boolean r10) {
        f22501o = r10;
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r10) {
        super.a(r10);
        e.G(1048574, g5.a.f19916b);
        if ((g5.a.f19916b - this.f22509h) <= 300) goto L9;
        this.f22505d = this.f22504c;
        this.f22509h = g5.a.f19916b;
        this.f22504c = e.I("EvilMethodTracer#dispatchBegin", 0);
        if (this.f22503b == false) goto L9;
        if (this.f22505d == null) goto L9;
        long[] r11 = e.E().w(this.f22505d);     // Catch: Throwable -> L11
        long r12 = g5.a.f19916b;     // Catch: Throwable -> L11
        PerfMonitorManager.o().s().f(new b(this, r11, r12));     // Catch: Throwable -> L11
    L9:
        this.f22506e = r10;
    }

    @Override // com.bytedance.apm.block.a
    public void b(long r19, long r21, long r23, long r25, boolean r27) {
        super.b(r19, r21, r23, r25, r27);
        e.J(1048574, g5.a.f19916b);
        d r10 = this.f22510i;
        if (r10 == null) goto L6;
        d.a(r10, r27);
        d.b(this.f22510i, g1.d.A().f19811b.b());
        AsyncEventManager.e().h(this.f22510i);
        this.f22510i = null;
    L6:
        if (e.E().H() == true) goto L8;
        return;
    L8:
        long r11 = r23 - r19;
        if (r11 < f22499m) goto L26;
        IBlockListener r12 = f22498l;
        if (r12 == null) goto L13;
        r12.doBlock(r11, r27);
    L13:
        h("evil_method_begin");
        long[] r13 = e.E().w(this.f22504c);
        if (r13 != null) goto L16;
    L24:
        h("evil_method_data_null");
        return;
    L16:
        if (r13.length == 0) goto L24;
        long[] r14 = new long[3];
        System.arraycopy(this.f22507f, 0, r14, 0, 3);
        String r15 = g.b();
        if (TextUtils.isEmpty(r15) == false) goto L22;
        String r16 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L21:
        String r17 = r16;
        this.f22510i = new d(this, ActivityLifeObserver.getInstance().isForeground(), r17, r13, r14, r25 - r21, r11, r23, this.f22506e, System.currentTimeMillis(), "uuid", PerfMonitorManager.o().p());
        return;
    L22:
        r16 = r15 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L21
    }

    public void g() {
        if (f22502p == false) goto L5;
        return;
    L5:
        com.bytedance.apm.block.e.a(this);
        f22502p = true;
    }

    public void l(boolean r10) {
        this.f22508g = r10;
    }

    public synchronized void m() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f22511j == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (f22501o == true) goto L10;
    L14:
        this.f22511j = true;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L10:
        if (f22500n == false) goto L14;
        g1.d.A().u(this);     // Catch: Throwable -> L12
        goto L14
    }

    @Override // com.bytedance.apm.block.EvilMethodSwitchListener
    public void onRefresh(boolean r10, long r11) {
        j(r11);
        f22501o = r10;
        if (r10 == true) goto L6;
        r3.h.a(new RunnableC0324a(this));
        e.E().L();
        return;
    }

    public a(boolean r10, boolean r11) {
        this.f22503b = false;
        this.f22507f = new long[3];
        this.f22509h = 0;
        this.f22510i = null;
        this.f22511j = false;
        this.f22508g = r10;
        if (r11 == true) goto L6;
        g();
    L6:
        if (f22497k != null) goto L9;
        f22497k = this;
        return;
    }
}
