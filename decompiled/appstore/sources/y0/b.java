package y0;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.apm.battery.internal.LocCallback;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.ss.thor.ThorCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.protocol.HttpRequestExecutor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends v1.a implements LocCallback, BatteryUtils.ChargeListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f25910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f25911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap f25912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f25913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f25914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f25915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f25916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f25917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f25918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y1.f f25919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CopyOnWriteArrayList f25920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ThorCallback f25921t;

    public class a implements ThorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25922a;

        public a(b r10) {
            this.f25922a = r10;
        }

        @Override // com.ss.thor.ThorCallback
        public void onStart() {
            b.u(this.f25922a);
        }

        @Override // com.ss.thor.ThorCallback
        public void onStop() {
            b.u(this.f25922a);
        }

        @Override // com.ss.thor.ThorCallback
        public void onUpdate(float r10, float r11, long r12) {
            Object r13 = b.v(this.f25922a);
            monitor-enter(r13);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (TextUtils.isEmpty(b.w(this.f25922a)) == false) goto L11;
            monitor-exit(r13);     // Catch: Throwable -> L8
            return;
        L11:
            if (b.x(this.f25922a) == false) goto L13;
        L26:
            b.z(this.f25922a);     // Catch: Throwable -> L8
            monitor-exit(r13);     // Catch: Throwable -> L8
            return;
        L13:
            if (b.y(this.f25922a) == true) goto L26;
            if (b.A(this.f25922a) != 0) goto L18;
            b.D(this.f25922a, PerfMonitorManager.o().c());     // Catch: Throwable -> L8
            b r14 = this.f25922a;     // Catch: Throwable -> L8
            b.o(r14, b.p(r14).h());     // Catch: Throwable -> L8
            b.q(this.f25922a).clear();     // Catch: Throwable -> L8
        L18:
            b.B(this.f25922a);     // Catch: Throwable -> L8
            b r15 = this.f25922a;     // Catch: Throwable -> L8
            b.s(r15, b.r(r15) + r10);     // Catch: Throwable -> L8
            if (b.A(this.f25922a) > 20) goto L21;
        L24:
            monitor-exit(r13);     // Catch: Throwable -> L8
            return;
        L21:
            if (b.r(this.f25922a) <= 200.0f) goto L23;
            float r16 = b.r(this.f25922a) / b.A(this.f25922a);     // Catch: Throwable -> L8
            C0408b r17 = new C0408b(this.f25922a);     // Catch: Throwable -> L8
            r17.h(r16);     // Catch: Throwable -> L8
            r17.g(r12);     // Catch: Throwable -> L8
            r17.f(PerfMonitorManager.o().c() - b.C(this.f25922a));     // Catch: Throwable -> L8
            r17.j(b.p(this.f25922a).h() - b.n(this.f25922a));     // Catch: Throwable -> L8
            r17.i(b.q(this.f25922a));     // Catch: Throwable -> L8
            b.t(this.f25922a).put(b.w(this.f25922a), r17);     // Catch: Throwable -> L8
        L23:
            b.u(this.f25922a);     // Catch: Throwable -> L8
            goto L24
        }
    }

    /* JADX INFO: renamed from: y0.b$b, reason: collision with other inner class name */
    public class C0408b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f25923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f25924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f25925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f25926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public StringBuilder f25927e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f25928f;

        public C0408b(b r10) {
            this.f25928f = r10;
            this.f25927e = new StringBuilder();
        }

        public long a() {
            return this.f25924b;
        }

        public long b() {
            return this.f25926d;
        }

        public float c() {
            return this.f25923a;
        }

        public String d() {
            return this.f25927e.toString();
        }

        public long e() {
            return this.f25925c;
        }

        public void f(long r10) {
            this.f25924b = r10;
        }

        public void g(long r10) {
            this.f25926d = r10;
        }

        public void h(float r10) {
            this.f25923a = r10;
        }

        public void i(List r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.size() == 0) goto L14;
            int r11 = 0;
        L8:
            if (r11 >= (r10.size() - 1)) goto L10;
            StringBuilder r12 = this.f25927e;
            r12.append(r10.get(r11));
            r12.append(',');
            r11 = r11 + 1;
            goto L8
        L10:
            this.f25927e.append(r10.get(r10.size() - 1));
            return;
        }

        public void j(long r10) {
            this.f25925c = r10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25929a = null;

        static {
            f25929a = new b(null);
        }

        public static /* synthetic */ b a() {
            return f25929a;
        }
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static /* synthetic */ long A(b r10) {
        return r10.f25914m;
    }

    public static /* synthetic */ long B(b r10) {
        long r11 = r10.f25914m + 1;
        r10.f25914m = r11;
        return r11;
    }

    public static /* synthetic */ long C(b r10) {
        return r10.f25916o;
    }

    public static /* synthetic */ long D(b r10, long r11) {
        r10.f25916o = r11;
        return r11;
    }

    public static b F() {
        return c.a();
    }

    public static /* synthetic */ long n(b r10) {
        return r10.f25917p;
    }

    public static /* synthetic */ long o(b r10, long r11) {
        r10.f25917p = r11;
        return r11;
    }

    public static /* synthetic */ y1.f p(b r10) {
        return r10.f25919r;
    }

    public static /* synthetic */ CopyOnWriteArrayList q(b r10) {
        return r10.f25920s;
    }

    public static /* synthetic */ float r(b r10) {
        return r10.f25915n;
    }

    public static /* synthetic */ float s(b r10, float r11) {
        r10.f25915n = r11;
        return r11;
    }

    public static /* synthetic */ ConcurrentHashMap t(b r10) {
        return r10.f25912k;
    }

    public static /* synthetic */ void u(b r10) {
        r10.G();
    }

    public static /* synthetic */ Object v(b r10) {
        return r10.f25913l;
    }

    public static /* synthetic */ String w(b r10) {
        return r10.f25911j;
    }

    public static /* synthetic */ boolean x(b r10) {
        return r10.d();
    }

    public static /* synthetic */ boolean y(b r10) {
        return r10.f25918q;
    }

    public static /* synthetic */ void z(b r10) {
        r10.E();
    }

    public final void E() {
        if (TextUtils.isEmpty(this.f25911j) == true) goto L6;
        this.f25911j = null;
        AsyncEventManager.e().removeTimeTask(this);
        ff.a.a();
        G();
        return;
    }

    public final void G() {
        this.f25914m = 0;
        this.f25915n = 0.0f;
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        boolean r11 = false;
        if (r10.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_ENABLE_UPLOAD, 0) != 1) goto L5;
        r11 = true;
    L5:
        this.f25908g = r11;
        if (r11 == false) goto L8;
        this.f25909h = r10.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_SAMPLE_INTERVAL, HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
        this.f25910i = r10.optLong(SlardarSettingsConsts.PERF_BATTERY_ENERGY_UPLOAD_INTERVAL, 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        AsyncEventManager.e().removeTimeTask(this);
    }

    @Override // v1.a
    public boolean e() {
        return !d();
    }

    @Override // v1.a
    public void g() {
        this.f25918q = BatteryUtils.d(w0.c.g(), this);
    }

    @Override // v1.a
    public void h() {
        super.h();
        Iterator r10 = this.f25912k.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r11 = (Map.Entry) r10.next();
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L10
        r13.put("scene", r11.getKey());     // Catch: JSONException -> L10
        r12.put(PerfConsts.KEY_CURRENT_GALVANIC, ((C0408b) r11.getValue()).c());     // Catch: JSONException -> L10
        r12.put(PerfConsts.KEY_CURRENT_CAPACITY, ((C0408b) r11.getValue()).b());     // Catch: JSONException -> L10
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L10
        r14.put("cpu_time", ((C0408b) r11.getValue()).a());     // Catch: JSONException -> L10
        r14.put("traffic", ((C0408b) r11.getValue()).e());     // Catch: JSONException -> L10
        r14.put("loc", ((C0408b) r11.getValue()).d());     // Catch: JSONException -> L10
        m1.e r15 = new m1.e("battery", "", r12, r13, r14);     // Catch: JSONException -> L10
        v1.b.a(r15, false);     // Catch: JSONException -> L10
        l1.a.p().e(r15);     // Catch: JSONException -> L10
        goto L4
    L8:
        this.f25912k.clear();
    }

    @Override // v1.a
    public void i() {
        super.i();
    }

    @Override // v1.a
    public long m() {
        return this.f25910i;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        AsyncEventManager.e().removeTimeTask(this);
        Object r11 = this.f25913l;
        monitor-enter(r11);
        E();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.util.BatteryUtils.ChargeListener
    public void onChange(boolean r10) {
        this.f25918q = r10;
        if (r10 == false) goto L12;
        Object r11 = this.f25913l;
        monitor-enter(r11);
        E();     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        super.onFront(r10);
    }

    @Override // com.bytedance.apm.battery.internal.LocCallback
    public void onLocRequest(long r10) {
        Object r11 = this.f25913l;
        monitor-enter(r11);
        this.f25920s.add(Long.valueOf(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f25912k = new ConcurrentHashMap();
        this.f25913l = new Object();
        this.f25914m = 0;
        this.f25915n = 0.0f;
        this.f25916o = 0;
        this.f25917p = 0;
        this.f25919r = y1.f.e();
        this.f25920s = new CopyOnWriteArrayList();
        this.f25921t = new a(this);
        this.f24971e = "battery";
    }
}
