package O3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class e implements Callable<Void>, A3.c {

    /* renamed from: f, reason: collision with root package name */
    static final FutureTask<Void> f4385f = new FutureTask<>(F3.a.f1738b, null);

    /* renamed from: a, reason: collision with root package name */
    final Runnable f4386a;

    /* renamed from: d, reason: collision with root package name */
    final ExecutorService f4389d;

    /* renamed from: e, reason: collision with root package name */
    Thread f4390e;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<Future<?>> f4388c = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<Future<?>> f4387b = new AtomicReference<>();

    e(Runnable runnable, ExecutorService executorService) {
        this.f4386a = runnable;
        this.f4389d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f4390e = Thread.currentThread();
        try {
            this.f4386a.run();
            c(this.f4389d.submit(this));
            this.f4390e = null;
        } catch (Throwable th) {
            this.f4390e = null;
            S3.a.r(th);
        }
        return null;
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f4388c.get();
            if (future2 == f4385f) {
                future.cancel(this.f4390e != Thread.currentThread());
                return;
            }
        } while (!this.f4388c.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f4387b.get();
            if (future2 == f4385f) {
                future.cancel(this.f4390e != Thread.currentThread());
                return;
            }
        } while (!this.f4387b.compareAndSet(future2, future));
    }

    @Override // A3.c
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f4388c;
        FutureTask<Void> futureTask = f4385f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f4390e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f4387b.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f4390e != Thread.currentThread());
    }

    @Override // A3.c
    public boolean g() {
        return this.f4388c.get() == f4385f;
    }
}
