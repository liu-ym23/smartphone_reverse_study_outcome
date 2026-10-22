package k2;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.cache.LimitedQueue;
import m2.b;
import m2.c;
import m2.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21010a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile l2.a f21011b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f21012c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LimitedQueue f21013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f21014e;

    /* JADX INFO: renamed from: k2.a$a, reason: collision with other inner class name */
    public static class C0286a implements LimitedQueue.EvictListener {
        public C0286a() {
        }

        public void a(Monitorable r10) {
            if (a.a() == false) goto L6;
            s3.a.b("APM-CommonEvent", "evicted Monitorable " + r10);
            return;
        }

        @Override // com.bytedance.apm6.util.cache.LimitedQueue.EvictListener
        public /* bridge */ /* synthetic */ void onEvict(Object r10) {
            a((Monitorable) r10);
        }
    }

    static {
        LimitedQueue r10 = new LimitedQueue(1000);
        f21013d = r10;
        f21014e = true;
        r10.d(new C0286a());
    }

    public static /* synthetic */ boolean a() {
        return f21014e;
    }

    public static synchronized void b() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f21012c == true) goto L12;
        CommonEventConfigService r10 = (CommonEventConfigService) o3.a.a(CommonEventConfigService.class);     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        updateConfig(r10.getConfig());     // Catch: Throwable -> L10
        f21012c = true;     // Catch: Throwable -> L10
    L12:
        monitor-exit(a.class);
    }

    public static void c(String r10, JSONObject r11) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        d(new b(r10, r11));
        return;
    L5:
        if (r3.a.c() == false) goto L10;
        s3.a.a("APM-CommonEvent", "logType must be not empty");
        return;
    }

    public static void d(b r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (f21011b != null) goto L12;
        f21013d.c(r10);
        if (r3.a.c() == false) goto L9;
        s3.a.a("APM-CommonEvent", "Cached CommonLog: " + r10);
    L9:
        b();
        return;
    L12:
        if (f21011b.a(r10.getLogType()) == false) goto L18;
        r10.a();
        if (r3.a.c() == false) goto L16;
        s3.a.a("APM-CommonEvent", "Sampled CommonLog:" + r10);
    L16:
        l3.a.d(r10);
        return;
    L18:
        if (r3.a.c() == false) goto L22;
        r10.a();
        o1.a.b(r10.getLogType(), r10.toJsonObject(), false);
        s3.a.a("APM-CommonEvent", "UnSampled CommonLog:" + r10);
        return;
    }

    public static void e(String r10, JSONObject r11, JSONObject r12) {
        monitorEvent(new m2.a(r10, 0, r11, null, null, r12));
    }

    public static void f(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        monitorEvent(new m2.a(r10, r11, r12, r13, r14, r15));
    }

    public static void g(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        i(r10, 0, r11, r12, r13);
    }

    public static void h(String r10, int r11, JSONObject r12, JSONObject r13) {
        monitorEvent(new m2.a(r10, r11, r12, null, null, r13));
    }

    public static void i(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        f(r10, r11, null, r12, r13, r14);
    }

    public static void j(String r10, int r11, JSONObject r12) {
        i(r10, r11, null, null, r12);
    }

    public static void k(d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r3.a.c() == false) goto L7;
        s3.a.a("APM-CommonEvent", "trace_data:" + r10.toJsonObject());
    L7:
        l3.a.d(r10);
    }

    public static boolean l(String r10, Boolean r11) {
        if (f21010a == true) goto L5;
        return false;
    L5:
        if (f21011b != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return false;
    L10:
        if (r11.booleanValue() == false) goto L15;
        if (f21011b.b(r10) == true) goto L22;
    L16:
        return true;
    L22:
        return false;
    L15:
        if (f21011b.a(r10) == false) goto L16;
        return false;
    }

    public static synchronized void m(boolean r10) {
        monitor-enter(a.class);
        f21014e = r10;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void monitorEvent(m2.a r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (f21011b != null) goto L12;
        f21013d.c(r10);
        if (r3.a.c() == false) goto L9;
        s3.a.a("APM-CommonEvent", "cached CommonEvent:" + r10);
    L9:
        b();
        return;
    L12:
        if (f21011b.b(r10.e()) == false) goto L17;
        r10.a();
        l3.a.d(r10);
        if (r3.a.c() == false) goto L23;
        s3.a.a("APM-CommonEvent", "Sampled CommonEvent:" + r10);
        return;
    L23:
        return;
    L17:
        if (r3.a.c() == false) goto L20;
        s3.a.a("APM-CommonEvent", "UnSampled CommonEvent:" + r10);
    L20:
        if (r3.a.c() == false) goto L25;
        r10.a();
        o1.a.b(r10.getLogType(), r10.toJsonObject(), false);
        return;
    }

    public static void monitorLegacyEvent(c r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        l3.a.d(r10);
    }

    public static synchronized void updateConfig(l2.a r10) {
        monitor-enter(a.class);
        if (r10 != null) goto L29;
    L27:
        monitor-exit(a.class);
        return;
    L29:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f21011b == r10) goto L27;
        if (r3.a.c() == false) goto L13;
        s3.a.a("APM-CommonEvent", "updateConfig " + r10);     // Catch: Throwable -> L11
    L13:
        f21011b = r10;     // Catch: Throwable -> L11
    L14:
        if (f21013d.a() == true) goto L23;
        Monitorable r11 = (Monitorable) f21013d.b();     // Catch: Throwable -> L11
        if ((r11 instanceof m2.a) == true) goto L18;
        if ((r11 instanceof b) == false) goto L14;
        d((b) r11);     // Catch: Throwable -> L11
        goto L14
    L18:
        monitorEvent((m2.a) r11);     // Catch: Throwable -> L11
        goto L14
    L23:
        monitor-exit(a.class);
    }
}
