package O3;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
abstract class a extends AtomicReference<Future<?>> implements A3.c {

    /* renamed from: c, reason: collision with root package name */
    protected static final FutureTask<Void> f4346c;

    /* renamed from: d, reason: collision with root package name */
    protected static final FutureTask<Void> f4347d;

    /* renamed from: a, reason: collision with root package name */
    protected final Runnable f4348a;

    /* renamed from: b, reason: collision with root package name */
    protected Thread f4349b;

    static {
        Runnable runnable = F3.a.f1738b;
        f4346c = new FutureTask<>(runnable, null);
        f4347d = new FutureTask<>(runnable, null);
    }

    a(Runnable runnable) {
        this.f4348a = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f4346c) {
                return;
            }
            if (future2 == f4347d) {
                future.cancel(this.f4349b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // A3.c
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f4346c || future == (futureTask = f4347d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f4349b != Thread.currentThread());
    }

    @Override // A3.c
    public final boolean g() {
        Future<?> future = get();
        return future == f4346c || future == f4347d;
    }
}
