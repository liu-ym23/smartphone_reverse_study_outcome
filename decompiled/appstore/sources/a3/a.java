package a3;

import android.os.Process;
import com.bytedance.apm.constant.StoreConsts;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IFdCheck;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f7g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b3.a f8a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f10c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f11d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u3.a f12e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IFdCheck f13f;

    /* JADX INFO: renamed from: a3.a$a, reason: collision with other inner class name */
    public class C0000a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f14d;

        public C0000a(a r10, long r11) {
            this.f14d = r10;
            super(r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(a.a(this.f14d));
            a.b(this.f14d, null);
            a.c(this.f14d, true);
            a.d(this.f14d);
        }
    }

    public class b extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f15d;

        public b(a r10, long r11, long r12) {
            this.f15d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.f15d);
        }
    }

    static {
        f7g = new a();
    }

    public a() {
        this.f11d = false;
    }

    public static /* synthetic */ u3.a a(a r10) {
        return r10.f12e;
    }

    public static /* synthetic */ u3.a b(a r10, u3.a r11) {
        r10.f12e = r11;
        return r11;
    }

    public static /* synthetic */ boolean c(a r10, boolean r11) {
        r10.f11d = r11;
        return r11;
    }

    public static /* synthetic */ void d(a r10) {
        r10.k();
    }

    public static /* synthetic */ void e(a r10) {
        r10.f();
    }

    public static a i() {
        return f7g;
    }

    public final void f() {
        if (this.f8a != null) goto L5;
        return;
    L5:
        ActivityLifecycleService r10 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
        if (r10 == null) goto L8;
        boolean r11 = r10.isForeground();
    L9:
        int r12 = h();
        if (r12 > 0) goto L12;
    L15:
        IFdCheck r13 = g();
        if (r13 != null) goto L18;
        return;
    L18:
        l3.a.d(new a3.b(r12, r13.getFdList(), r11));
        return;
    L12:
        if (r12 >= this.f8a.b()) goto L15;
        l3.a.d(new a3.b(r12, null, r11));
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final IFdCheck g() {
        if (this.f13f != null) goto L6;
        this.f13f = (IFdCheck) n5.b.a(IFdCheck.class);
    L6:
        return this.f13f;
    }

    public final int h() {
        return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
    L5:
        return 0;
    }

    public void j() {
        if (this.f9b == false) goto L5;
        return;
    L5:
        this.f9b = true;
        IFdConfigService r10 = (IFdConfigService) o3.a.a(IFdConfigService.class);
        if (r10 == null) goto L8;
        l(r10.getConfig());
    L8:
        this.f12e = new C0000a(this, StoreConsts.CHECK_FREE_DISK_INTERVAL_MS);
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f12e);
    }

    public final synchronized void k() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f11d == false) goto L17;
        b3.a r10 = this.f8a;     // Catch: Throwable -> L15
        if (r10 == null) goto L17;
        if (r10.c() == false) goto L17;
        if (this.f10c == true) goto L17;
        this.f10c = true;     // Catch: Throwable -> L15
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(new b(this, 0, this.f8a.a()));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L17:
        monitor-exit(this);
    }

    public synchronized void l(b3.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        this.f8a = r10;     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L11;
        s3.a.a("APM-FD", "updateConfig:" + r10);     // Catch: Throwable -> L9
    L11:
        k();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
