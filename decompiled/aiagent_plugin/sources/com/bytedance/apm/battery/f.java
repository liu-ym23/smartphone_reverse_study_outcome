package com.bytedance.apm.battery;

import android.app.Activity;
import android.app.Application;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProcessEnergyCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.apm.perf.a {
    private static final String TAG = "ProcessEnergyCollector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f4339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f4340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f4343e;
    long f;
    private boolean h;
    private long i;
    private long j;
    private long k;
    private final ConcurrentHashMap<String, Long> l;
    private final LinkedList<b> m;
    private final LinkedList<b> n;
    private int o;
    private long p;

    /* JADX INFO: compiled from: ProcessEnergyCollector.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f4344a = null;

        static /* synthetic */ f a() {
            return f4344a;
        }

        static {
            f4344a = new f();
        }
    }

    /* JADX INFO: compiled from: ProcessEnergyCollector.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f4346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f4348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f4349e;

        private b() {
        }

        public long a() {
            return this.f4348d - this.f4346b;
        }

        public long b() {
            return this.f4349e - this.f4347c;
        }

        public double c() {
            double r0 = a() / 1000.0d;
            if (r0 > 0.0d) goto L5;
            return 0.0d;
        L5:
            return (Math.round(b() / r0) * 100) / 100.0d;
        }

        public String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", new Object[]{this.f4345a, Long.valueOf(b()), Long.valueOf(a()), Double.valueOf(c())});
        }
    }

    public static f a() {
        return a.a();
    }

    public f() {
        this.l = new ConcurrentHashMap();
        this.m = new LinkedList();
        this.n = new LinkedList();
        this.o = 0;
        this.f4339a = 0;
        this.f4340b = 0;
        this.f4341c = 0;
        this.f4342d = 0;
        this.f4343e = 0;
        this.f = 0;
        this.g = Scraps.BATTERY;
    }

    @Override // com.bytedance.apm.perf.a
    public void a(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.h = r1;
        if (r1 == false) goto L11;
        this.i = r5.optLong("power_cpu_monitor_interval", 60000);
        this.j = r5.optLong("power_battery_monior_interval", 300000);
        this.k = r5.optLong("power_proc_cpu_upload_interval", 120000);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.thread.b.a().b(this);
        return;
    L5:
        if (r5.optInt("power_monitor_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.apm.api.d
    public void onFront(Activity r3) {
        super.onFront((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        this.o++;
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.apm.api.d
    public void onBackground(Activity r3) {
        super.onBackground((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        this.o++;
    }

    @Override // com.bytedance.apm.perf.a
    public void c_() {
        super.c_();
    }

    @Override // com.bytedance.apm.perf.a
    public void e() {
        super.e();
        g();
        h();
        i();
    }

    public void g() {
        long r0 = com.bytedance.apm.util.b.c();
        long r2 = SystemClock.uptimeMillis();
        long r4 = this.f4340b;
        if (r4 != 0) goto L5;
    L14:
        this.f4341c = this.o;
        this.f4339a = r0;
        this.f4340b = r2;
        return;
    L5:
        if (this.f4341c != this.o) goto L14;
        double r5 = (r2 - r4) / 60000.0d;
        if (r5 <= 0.0d) goto L14;
        double r6 = Math.round(((r0 - this.f4339a) / r5) * 100.0d) / 100.0d;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L16
        if (n() == false) goto L12;
        String r8 = "background";
    L13:
        r7.put("status", r8);     // Catch: Exception -> L16
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L16
        r9.put("cpu_speed_min", r6);     // Catch: Exception -> L16
        com.bytedance.apm6.commonevent.a.a("apm_cpu_speed", r7, r9, null);     // Catch: Exception -> L16
        goto L14
    L12:
        r8 = "foreground";
        goto L13
    }

    private void h() {
        long r0 = SystemClock.uptimeMillis();
        long r2 = this.f4343e;
        if ((this.j + r2) <= r0) goto L5;
        return;
    L5:
        long r3 = r0 - r2;
        this.f4343e = r0;
        int r1 = ((BatteryManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("batterymanager"), BatteryManager.class, "com.obric.aiagent.plugin")).getIntProperty(4);
        int r4 = r1 - this.f4342d;
        if (this.f == this.o) goto L8;
    L13:
        this.f4342d = r1;
        this.f = this.o;
        return;
    L8:
        if (n() == true) goto L13;
        if (r4 > 0) goto L13;
        int r5 = Math.abs(r4);
        if (r5 > 100) goto L13;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L15
        r6.put(Scraps.BATTERY, Math.abs(r5));     // Catch: Exception -> L15
        r6.put("duraion", r3);     // Catch: Exception -> L15
        com.bytedance.apm6.commonevent.a.a("apm_battery_monitor", null, r6, null);     // Catch: Exception -> L15
        goto L13
    }

    private void i() {
        long r0 = SystemClock.uptimeMillis();
        if ((this.p + this.k) <= r0) goto L5;
        return;
    L5:
        this.p = r0;
        LinkedList<b> r1 = this.n;
        monitor-enter(r1);
        Iterator<b> r2 = this.n.iterator();     // Catch: Throwable -> L16
    L9:
        if (r2.hasNext() == false) goto L13;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r4.put(DBHelper.BATTERY_COL_SCENE, r3.f4345a);     // Catch: Exception -> L19 Throwable -> L16
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r5.put("cpu_speed", r3.c());     // Catch: Exception -> L19 Throwable -> L16
        com.bytedance.apm6.commonevent.a.a("apm_proc_cpu_info", r4, r5, null);     // Catch: Exception -> L19 Throwable -> L16
        goto L9
    L13:
        this.n.clear();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.perf.a
    public boolean c() {
        return this.h;
    }

    @Override // com.bytedance.apm.perf.a
    public long d() {
        return this.i;
    }
}
