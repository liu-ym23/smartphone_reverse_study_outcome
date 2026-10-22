package n2;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableHandler;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements MonitorableHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile e f22374d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q2.c f22375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o2.a f22376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f22377c;

    static {
        f22374d = new e();
    }

    public e() {
        this.f22377c = false;
    }

    public static e c() {
        return f22374d;
    }

    public final void a(JSONObject r10, boolean r11) {
    L6:
        e = move-exception;
        Log.e(a.f22354a, "addExtension", e);
        return;
    L4:
        if (TextUtils.isEmpty(d3.a.s()) == true) goto L9;
        r10.put(CommonKey.KEY_SESSION_ID, d3.a.s());     // Catch: Exception -> L6
    L9:
        if (r10.isNull("network_type") == false) goto L18;
        NetworkUtils.NetworkType r12 = NetworkUtils.g(r3.a.b());     // Catch: Exception -> L6
        r10.put("network_type", r12.getValue());     // Catch: Exception -> L6
        if (r12.is2G() == false) goto L13;
    L14:
        int r13 = r3.f.a(r3.a.b());     // Catch: Exception -> L6
        if (r13 == (-10000)) goto L18;
        r10.put(CommonKey.KEY_NET_TYPE_CODE, r13);     // Catch: Exception -> L6
        goto L18
    L13:
        if (r12.is3GOrHigher() == true) goto L14;
    L18:
        if (r10.isNull("timestamp") == false) goto L20;
    L21:
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L6
    L23:
        if (r10.isNull("sid") == false) goto L25;
        r10.put("sid", d3.a.u());     // Catch: Exception -> L6
    L25:
        r10.put("process_name", d3.a.m());     // Catch: Exception -> L6
        if (r11 == false) goto L33;
        r10.put(CommonKey.KEY_SEQ_NO, d.a().b());     // Catch: Exception -> L6
        return;
    L33:
        return;
    L20:
        if (r10.optLong("timestamp") > 0) goto L23;
        goto L21
    }

    public final synchronized void b() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f22377c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r3.a.c() == false) goto L13;
        s3.a.a(a.f22354a, "Initializing SlardarHandler...");     // Catch: Throwable -> L10
    L13:
        if (s1.a.c() == null) goto L15;
        s1.a.c().d(a.f22354a, "ensureInited");     // Catch: Throwable -> L10
    L15:
        p2.b.f().g();     // Catch: Throwable -> L10
        com.bytedance.apm6.consumer.slardar.send.downgrade.a.a().b(r3.a.b());     // Catch: Throwable -> L10
        SlardarHandlerConfigService r10 = (SlardarHandlerConfigService) o3.a.a(SlardarHandlerConfigService.class);     // Catch: Throwable -> L10
        if (r10 == null) goto L18;
        f(r10.getConfig());     // Catch: Throwable -> L10
    L18:
        this.f22375a = new q2.c(p2.d.c(), b.d(), b.b());     // Catch: Throwable -> L10
        c.e().p(this.f22375a);     // Catch: Throwable -> L10
        s2.b.g().f(c.e());     // Catch: Throwable -> L10
        s2.b.g().f(com.bytedance.apm6.consumer.slardar.send.c.g());     // Catch: Throwable -> L10
        s2.b.g().h();     // Catch: Throwable -> L10
        c.e().f();     // Catch: Throwable -> L10
        com.bytedance.apm6.consumer.slardar.send.c.g().h();     // Catch: Throwable -> L10
        this.f22377c = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public void d() {
        if (r3.a.c() == false) goto L5;
        s3.a.a(a.f22354a, "pause");
    L5:
        c.e().h();
        com.bytedance.apm6.consumer.slardar.send.c.g().i();
    }

    public void e() {
        if (r3.a.c() == false) goto L5;
        s3.a.a(a.f22354a, "resume");
    L5:
        c.e().l();
        com.bytedance.apm6.consumer.slardar.send.c.g().k();
    }

    public synchronized void f(o2.a r10) {
        monitor-enter(this);
        this.f22376b = r10;     // Catch: Throwable -> L6
        if (r10 == null) goto L9;
        com.bytedance.apm6.consumer.slardar.send.b.e().t(r10);     // Catch: Throwable -> L6
        c.e().n(r10.g());     // Catch: Throwable -> L6
        c.e().o(r10.f());     // Catch: Throwable -> L6
        s2.b.g().j(r10.d(), r10.c(), r10.e());     // Catch: Throwable -> L6
        com.bytedance.apm6.consumer.slardar.send.d.k(r10.a());     // Catch: Throwable -> L6
    L9:
        if (r3.a.c() == false) goto L11;
        s3.a.a(a.f22354a, "setSlardarHandlerConfig:" + r10);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.monitor.MonitorableHandler
    public void handle(Monitorable r10) {
        if (this.f22377c == true) goto L5;
        b();
    L5:
        JSONObject r11 = r10.toJsonObject();
        if (a.f22355b.contains(r10.getLogType()) == false) goto L8;
    L17:
        a(r11, false);
    L19:
        if (r3.a.c() == false) goto L21;
        o1.a.b(r10.getLogType(), r11, true);
    L21:
        this.f22375a.i(r11);
        return;
    L8:
        if ("tracing".equals(r10.getLogType()) == true) goto L17;
        if (com.bytedance.apm6.consumer.slardar.send.downgrade.a.a().d(r11, d3.a.h()) == false) goto L13;
        a(r11, true);
        goto L19
    L13:
        if (r3.a.c() == false) goto L23;
        o1.a.a(r10.getLogType(), r11);
        s3.a.a(a.f22354a, "push failed: event(aid=" + d3.a.h() + " is downgraded: " + r11.toString());
        return;
    }
}
