package au3;

import android.os.Process;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IFdCheck;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f16304g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bu3.a f16305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f16306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f16307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f16308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cv3.a f16309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IFdCheck f16310f;

    /* JADX INFO: loaded from: classes14.dex */
    public class a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f16311d;

        public final void a() {
            b r100 = this.f16311d;
            if (r100.f16305a == null) goto L28;
            uu3.a r101 = (uu3.a) qu3.c.a(uu3.a.class);
            int r102 = 0;
            if (r101 == null) goto L8;
            boolean r103 = r101.isForeground();
        L25:
            r102 = new PolarisFileWrapper("/proc/" + Process.myPid() + "/fd").listFiles().length;     // Catch: Exception -> L12
        L13:
            if (r102 <= 0) goto L18;
            if (r102 >= r100.f16305a.f20727a) goto L18;
            nu3.b.a(new c(r102, null, r103));
            return;
        L18:
            if (r100.f16310f != null) goto L20;
            r100.f16310f = (IFdCheck) ServiceManager.getService(IFdCheck.class);
        L20:
            IFdCheck r104 = r100.f16310f;
            if (r104 == null) goto L29;
            nu3.b.a(new c(r102, r104.getFdList(), r103));
            return;
        L29:
            return;
        L8:
            r103 = false;
            goto L25
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, long r101) {
            this.f16311d = r100;
            super(0, r101);
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f16308d == false) goto L15;
        bu3.a r100 = this.f16305a;     // Catch: Throwable -> L17
        if (r100 == null) goto L15;
        if (r100.f20729c == false) goto L15;
        if (this.f16307c == true) goto L15;
        this.f16307c = true;     // Catch: Throwable -> L17
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(new a(this, this.f16305a.f20728b));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L15:
        monitor-exit(this);
    }

    static {
        f16304g = new b();
    }

    public b() {
        this.f16308d = false;
    }

    public final synchronized void b(bu3.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        this.f16305a = r100;     // Catch: Throwable -> L13
        if (xu3.a.a() == false) goto L10;
        av3.b.a("APM-FD", "updateConfig:" + r100);     // Catch: Throwable -> L13
    L10:
        a();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
