package s0;

import Z2.r0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n implements D1.a {

    /* renamed from: a, reason: collision with root package name */
    public final D0.j f14208a;

    public n(r0 job) {
        D0.j underlying = new D0.j();
        Intrinsics.checkNotNullExpressionValue(underlying, "create()");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(underlying, "underlying");
        this.f14208a = underlying;
        job.K(false, true, new S.s(2, this));
    }

    @Override // D1.a
    public final void a(Runnable runnable, Executor executor) {
        this.f14208a.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        return this.f14208a.cancel(z4);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f14208a.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f14208a.f390a instanceof D0.a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f14208a.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return this.f14208a.get(j4, timeUnit);
    }
}
