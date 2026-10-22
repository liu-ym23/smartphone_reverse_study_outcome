package by5;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, Long> f21441b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static m f21442c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f21443a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f21444a = null;

        static {
            f21444a = new i();
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f21443a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f21443a = true;     // Catch: Throwable -> L14
        if (n.f21462e == false) goto L11;
        fy5.c.a("Initializing SlardarHandler...");     // Catch: Throwable -> L14
    L11:
        f21442c = new m(by5.a.e(), by5.a.a());     // Catch: Throwable -> L14
        e r100 = e.a.f21426a;     // Catch: Throwable -> L14
        r100.f21423c = f21442c;     // Catch: Throwable -> L14
        r100.a();     // Catch: Throwable -> L14
        AtomicInteger r101 = f.f21427d;     // Catch: Throwable -> L14
        f r102 = f.a.f21431a;     // Catch: Throwable -> L14
        r102.getClass();     // Catch: Throwable -> L14
        gy5.a.b.f483331a.a(r102);     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    static {
        f21441b = new ConcurrentHashMap();
    }

    public i() {
        this.f21443a = false;
    }

    public final void b(long r100, JSONObject r110) {
    L29:
        th = move-exception;
        fy5.c.c("record", th);
        return;
    L4:
        if (com.bytedance.framwork.core.sdklib.apm6.downgrade.a.C3505a.f244861a.b(r110, (int) r100) == false) goto L6;
        ConcurrentHashMap<Long, Long> r101 = f21441b;     // Catch: Throwable -> L29
        if (r101.containsKey(Long.valueOf(r100)) == true) goto L19;
        dy5.a r102 = dy5.a.c();     // Catch: Throwable -> L29
        Context r103 = n.f21458a;     // Catch: Throwable -> L29
        monitor-enter(n.class);     // Catch: Throwable -> L29
        JSONObject r104 = n.f21459b.get(Long.valueOf(r100));     // Catch: Throwable -> L16
        monitor-exit(n.class);     // Catch: Throwable -> L29
        r101.put(Long.valueOf(r100), Long.valueOf(r102.d(r100, r104)));     // Catch: Throwable -> L29
        goto L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L19:
        a();     // Catch: Throwable -> L29
        if (JSONObjectProtectorUtils.getJSONObject(r110, "_debug_self") != null) goto L23;
        r110.put("_debug_self", new JSONObject());     // Catch: Exception -> L32 Throwable -> L29
    L23:
        new JSONObject().put("sdk_report_from", "apm6");     // Catch: Exception -> L32 Throwable -> L29
    L25:
        if (n.f21462e == false) goto L27;
        fy5.c.a("record:" + r100 + " " + r110);     // Catch: Throwable -> L29
    L27:
        f21442c.c(r100, f21441b.get(Long.valueOf(r100)).longValue(), r110);     // Catch: Throwable -> L29
        return;
    L6:
        if (n.f21462e == false) goto L38;
        fy5.c.a("push failed: event(aid=" + r100 + " is downgraded: " + r110.toString());     // Catch: Throwable -> L29
        return;
    }
}
