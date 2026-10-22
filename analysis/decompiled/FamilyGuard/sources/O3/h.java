package O3;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import x3.p;

/* loaded from: classes.dex */
public class h extends p.c implements A3.c {

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f4412a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f4413b;

    public h(ThreadFactory threadFactory) {
        this.f4412a = n.a(threadFactory);
    }

    @Override // x3.p.c
    public A3.c b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // x3.p.c
    public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        return this.f4413b ? E3.c.INSTANCE : e(runnable, j5, timeUnit, null);
    }

    @Override // A3.c
    public void dispose() {
        if (this.f4413b) {
            return;
        }
        this.f4413b = true;
        this.f4412a.shutdownNow();
    }

    public m e(Runnable runnable, long j5, TimeUnit timeUnit, E3.a aVar) {
        m mVar = new m(S3.a.t(runnable), aVar);
        if (aVar != null && !aVar.c(mVar)) {
            return mVar;
        }
        try {
            mVar.a(j5 <= 0 ? this.f4412a.submit((Callable) mVar) : this.f4412a.schedule((Callable) mVar, j5, timeUnit));
            return mVar;
        } catch (RejectedExecutionException e6) {
            if (aVar != null) {
                aVar.a(mVar);
            }
            S3.a.r(e6);
            return mVar;
        }
    }

    public A3.c f(Runnable runnable, long j5, TimeUnit timeUnit) {
        l lVar = new l(S3.a.t(runnable));
        try {
            lVar.a(j5 <= 0 ? this.f4412a.submit(lVar) : this.f4412a.schedule(lVar, j5, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e6) {
            S3.a.r(e6);
            return E3.c.INSTANCE;
        }
    }

    @Override // A3.c
    public boolean g() {
        return this.f4413b;
    }

    public A3.c h(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        Runnable runnableT = S3.a.t(runnable);
        if (j6 <= 0) {
            e eVar = new e(runnableT, this.f4412a);
            try {
                eVar.b(j5 <= 0 ? this.f4412a.submit(eVar) : this.f4412a.schedule(eVar, j5, timeUnit));
                return eVar;
            } catch (RejectedExecutionException e6) {
                S3.a.r(e6);
                return E3.c.INSTANCE;
            }
        }
        k kVar = new k(runnableT);
        try {
            kVar.a(this.f4412a.scheduleAtFixedRate(kVar, j5, j6, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e7) {
            S3.a.r(e7);
            return E3.c.INSTANCE;
        }
    }

    public void i() {
        if (this.f4413b) {
            return;
        }
        this.f4413b = true;
        this.f4412a.shutdown();
    }
}
