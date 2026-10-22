package reactor.core.publisher;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class BlockingOptionalMonoSubscriber<T> extends CountDownLatch implements InnerConsumer<T>, Disposable {
    volatile boolean cancelled;
    final Context context;
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    qc.d f39454s;
    T value;

    public BlockingOptionalMonoSubscriber(Context context) {
        super(1);
        this.context = context;
    }

    public final Optional<T> blockingGet() throws InterruptedException {
        if (Schedulers.isInNonBlockingThread()) {
            throw new IllegalStateException("blockOptional() is blocking, which is not supported in thread " + Thread.currentThread().getName());
        }
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e10) {
                dispose();
                RuntimeException runtimeExceptionPropagate = Exceptions.propagate(e10);
                runtimeExceptionPropagate.addSuppressed(new Exception("#blockOptional() has been interrupted"));
                Thread.currentThread().interrupt();
                throw runtimeExceptionPropagate;
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return Optional.ofNullable(this.value);
        }
        RuntimeException runtimeExceptionPropagate2 = Exceptions.propagate(th);
        runtimeExceptionPropagate2.addSuppressed(new Exception("#block terminated with an error"));
        throw runtimeExceptionPropagate2;
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return this.context;
    }

    @Override // reactor.core.Disposable
    public final void dispose() {
        this.cancelled = true;
        qc.d dVar = this.f39454s;
        if (dVar != null) {
            this.f39454s = null;
            dVar.cancel();
        }
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.cancelled || getCount() == 0;
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public final void onComplete() {
        countDown();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public void onNext(T t10) {
        if (this.value == null) {
            this.value = t10;
            countDown();
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public final void onSubscribe(qc.d dVar) {
        this.f39454s = dVar;
        if (this.cancelled) {
            return;
        }
        dVar.request(Long.MAX_VALUE);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(getCount() == 0);
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.f39454s;
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(this.cancelled);
        }
        if (attr == Scannable.Attr.ERROR) {
            return this.error;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.MAX_VALUE;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return "blockOptional";
    }

    public final Optional<T> blockingGet(long j10, TimeUnit timeUnit) {
        if (!Schedulers.isInNonBlockingThread()) {
            if (getCount() != 0) {
                try {
                    if (!await(j10, timeUnit)) {
                        dispose();
                        String str = "Timeout on blocking read for " + j10 + " " + timeUnit;
                        throw new IllegalStateException(str, new TimeoutException(str));
                    }
                } catch (InterruptedException e10) {
                    dispose();
                    RuntimeException runtimeExceptionPropagate = Exceptions.propagate(e10);
                    runtimeExceptionPropagate.addSuppressed(new Exception("#blockOptional(timeout) has been interrupted"));
                    Thread.currentThread().interrupt();
                    throw runtimeExceptionPropagate;
                }
            }
            Throwable th = this.error;
            if (th == null) {
                return Optional.ofNullable(this.value);
            }
            RuntimeException runtimeExceptionPropagate2 = Exceptions.propagate(th);
            runtimeExceptionPropagate2.addSuppressed(new Exception("#block terminated with an error"));
            throw runtimeExceptionPropagate2;
        }
        throw new IllegalStateException("blockOptional() is blocking, which is not supported in thread " + Thread.currentThread().getName());
    }
}
