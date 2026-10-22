package O;

import g3.InterfaceFutureC4095a;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class b<I, O> extends d<O> implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public O.a<? super I, ? extends O> f5100c;

    /* renamed from: d, reason: collision with root package name */
    public final BlockingQueue<Boolean> f5101d = new LinkedBlockingQueue(1);

    /* renamed from: e, reason: collision with root package name */
    public final CountDownLatch f5102e = new CountDownLatch(1);

    /* renamed from: f, reason: collision with root package name */
    public InterfaceFutureC4095a<? extends I> f5103f;

    /* renamed from: g, reason: collision with root package name */
    public volatile InterfaceFutureC4095a<? extends O> f5104g;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceFutureC4095a f5105a;

        public a(InterfaceFutureC4095a interfaceFutureC4095a) {
            this.f5105a = interfaceFutureC4095a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [O.b] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    try {
                        b.this.c(f.e(this.f5105a));
                    } catch (CancellationException unused) {
                        b.this.cancel(false);
                    }
                } catch (ExecutionException e10) {
                    b.this.d(e10.getCause());
                }
            } finally {
                b.this.f5104g = null;
            }
        }
    }

    public b(O.a<? super I, ? extends O> aVar, InterfaceFutureC4095a<? extends I> interfaceFutureC4095a) {
        this.f5100c = (O.a) B0.h.f(aVar);
        this.f5103f = (InterfaceFutureC4095a) B0.h.f(interfaceFutureC4095a);
    }

    @Override // O.d, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        if (!super.cancel(z10)) {
            return false;
        }
        h(this.f5101d, Boolean.valueOf(z10));
        g(this.f5103f, z10);
        g(this.f5104g, z10);
        return true;
    }

    public final void g(Future<?> future, boolean z10) {
        if (future != null) {
            future.cancel(z10);
        }
    }

    @Override // O.d, java.util.concurrent.Future
    public O get() throws ExecutionException, InterruptedException {
        if (!isDone()) {
            InterfaceFutureC4095a<? extends I> interfaceFutureC4095a = this.f5103f;
            if (interfaceFutureC4095a != null) {
                interfaceFutureC4095a.get();
            }
            this.f5102e.await();
            InterfaceFutureC4095a<? extends O> interfaceFutureC4095a2 = this.f5104g;
            if (interfaceFutureC4095a2 != null) {
                interfaceFutureC4095a2.get();
            }
        }
        return (O) super.get();
    }

    public final <E> void h(BlockingQueue<E> blockingQueue, E e10) {
        boolean z10 = false;
        while (true) {
            try {
                blockingQueue.put(e10);
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public final <E> E i(BlockingQueue<E> blockingQueue) {
        E eTake;
        boolean z10 = false;
        while (true) {
            try {
                eTake = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return eTake;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [O.a<? super I, ? extends O>, g3.a<? extends I>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [O.b, O.b<I, O>, O.d] */
    /* JADX WARN: Type inference failed for: r4v1, types: [O.b] */
    /* JADX WARN: Type inference failed for: r4v3, types: [O.d] */
    /* JADX WARN: Type inference failed for: r4v6, types: [O.d] */
    /* JADX WARN: Type inference failed for: r4v7, types: [O.d] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.concurrent.CountDownLatch] */
    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        ?? r02 = (O.a<? super I, ? extends O>) null;
        try {
            try {
                try {
                    try {
                        try {
                            InterfaceFutureC4095a<? extends O> interfaceFutureC4095aApply = this.f5100c.apply(f.e(this.f5103f));
                            this.f5104g = interfaceFutureC4095aApply;
                            if (isCancelled()) {
                                interfaceFutureC4095aApply.cancel(((Boolean) i(this.f5101d)).booleanValue());
                                this.f5104g = null;
                            } else {
                                interfaceFutureC4095aApply.a(new a(interfaceFutureC4095aApply), N.a.a());
                            }
                        } catch (Exception e10) {
                            this.d(e10);
                            bVar = this;
                        }
                    } catch (Error e11) {
                        this.d(e11);
                        bVar = this;
                    }
                } finally {
                    this.f5100c = null;
                    this.f5103f = null;
                    this.f5102e.countDown();
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e12) {
                d(e12.getCause());
            }
        } catch (UndeclaredThrowableException e13) {
            this.d(e13.getCause());
            bVar = this;
        }
    }

    @Override // O.d, java.util.concurrent.Future
    public O get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j10 = timeUnit2.convert(j10, timeUnit);
                timeUnit = timeUnit2;
            }
            InterfaceFutureC4095a<? extends I> interfaceFutureC4095a = this.f5103f;
            if (interfaceFutureC4095a != null) {
                long jNanoTime = System.nanoTime();
                interfaceFutureC4095a.get(j10, timeUnit);
                j10 -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (this.f5102e.await(j10, timeUnit)) {
                j10 -= Math.max(0L, System.nanoTime() - jNanoTime2);
                InterfaceFutureC4095a<? extends O> interfaceFutureC4095a2 = this.f5104g;
                if (interfaceFutureC4095a2 != null) {
                    interfaceFutureC4095a2.get(j10, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return (O) super.get(j10, timeUnit);
    }
}
