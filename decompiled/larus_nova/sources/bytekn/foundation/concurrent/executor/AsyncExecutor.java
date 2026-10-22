package bytekn.foundation.concurrent.executor;

import bytekn.foundation.concurrent.scheduler.SchedulersKt;
import bytekn.foundation.concurrent.scheduler.i;

/* JADX INFO: loaded from: classes3.dex */
public final class AsyncExecutor implements bytekn.foundation.concurrent.executor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.a f21735a;

    public static final class a {
    }

    static {
    }

    public AsyncExecutor() {
        this.f21735a = SchedulersKt.f21737b.f21899a.get().getValue().a();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable r100) {
        this.f21735a.a(0, new AnonymousClass1(r100));
    }
}
