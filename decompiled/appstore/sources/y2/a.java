package y2;

import android.content.SharedPreferences;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f26037e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z2.a f26038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f26039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f26040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u3.a f26041d;

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    public class C0411a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f26042d;

        public C0411a(a r10) {
            this.f26042d = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = System.currentTimeMillis();
            if (r3.a.c() == false) goto L5;
            s3.a.a("APM-Disk", "startCollect:");
        L5:
            SharedPreferences r11 = r3.a.b().getSharedPreferences(SlardarConfigConsts.MONITOR_CONFIG, 0);
            long r12 = 0;
            if (r11 == null) goto L8;
            r12 = r11.getLong(PerfConsts.DISK_SP_KEY_CHECK_TIME, 0);
        L8:
            long r13 = System.currentTimeMillis() - r12;
            if (r3.a.c() == false) goto L12;
            s3.a.a("APM-Disk", "durationMs:" + r13);
        L12:
            if (r13 < 86400000) goto L17;
            b r14 = c.w().m(a.a(this.f26042d));
            if (r3.a.c() == false) goto L16;
            s3.a.a("APM-Disk", "durationMs:" + r14.toJsonObject());
        L16:
            l3.a.d(r14);
            r11.edit().putLong(PerfConsts.DISK_SP_KEY_CHECK_TIME, System.currentTimeMillis()).commit();
        L17:
            u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(a.b(this.f26042d));
            if (r3.a.c() == false) goto L21;
            s3.a.a("APM-Disk", "collect end and cost time:" + (System.currentTimeMillis() - r10));
            return;
        }
    }

    static {
        f26037e = new a();
    }

    public a() {
    }

    public static /* synthetic */ z2.a a(a r10) {
        return r10.f26038a;
    }

    public static /* synthetic */ u3.a b(a r10) {
        return r10.f26041d;
    }

    public static a d() {
        return f26037e;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f26040c == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        z2.a r10 = this.f26038a;     // Catch: Throwable -> L20
        if (r10 != null) goto L10;
    L22:
        monitor-exit(this);
        return;
    L10:
        if (r10.k() == false) goto L22;
        if (d3.a.A() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f26040c = true;     // Catch: Throwable -> L20
        this.f26041d = new C0411a(this);     // Catch: Throwable -> L20
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f26041d);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public void e() {
        if (this.f26039b == false) goto L5;
        return;
    L5:
        this.f26039b = true;
        DiskConfigService r10 = (DiskConfigService) o3.a.a(DiskConfigService.class);
        if (r10 == null) goto L9;
        g(r10.getConfig());
        return;
    }

    public void f(IStorageCheckListener r10) {
        c.w().G(r10);
    }

    public synchronized void g(z2.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L27;
        monitor-exit(this);
        return;
    L27:
        this.f26038a = r10;     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L12;
        s3.a.a("APM-Disk", "updateConfig:" + r10);     // Catch: Throwable -> L9
    L12:
        if (this.f26039b == true) goto L15;
        monitor-exit(this);
        return;
    L15:
        ActivityLifecycleService r11 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);     // Catch: Throwable -> L9
        if (r11 != null) goto L18;
    L23:
        monitor-exit(this);
        return;
    L18:
        if (r11.isForeground() == true) goto L23;
        c();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
