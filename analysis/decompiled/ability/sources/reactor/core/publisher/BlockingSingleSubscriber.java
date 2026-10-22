package reactor.core.publisher;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
abstract class BlockingSingleSubscriber<T> extends CountDownLatch implements InnerConsumer<T>, Disposable {
    volatile boolean cancelled;
    final Context context;
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    Z9.e f5695s;
    T value;

    public BlockingSingleSubscriber(Context context) {
        super(1);
        this.context = context;
    }

    @Nullable
    public final T blockingGet() throws InterruptedException {
        if (Schedulers.isInNonBlockingThread()) {
            throw new IllegalStateException("block()/blockFirst()/blockLast() are blocking, which is not supported in thread " + Thread.currentThread().getName());
        }
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                dispose();
                Thread.currentThread().interrupt();
                throw Exceptions.propagate(e);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        RuntimeException runtimeExceptionPropagate = Exceptions.propagate(th);
        runtimeExceptionPropagate.addSuppressed(new Exception("#block terminated with an error"));
        throw runtimeExceptionPropagate;
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return this.context;
    }

    @Override // reactor.core.Disposable
    public final void dispose() {
        this.cancelled = true;
        Z9.e eVar = this.f5695s;
        if (eVar != null) {
            this.f5695s = null;
            eVar.cancel();
        }
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.cancelled || getCount() == 0;
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public final void onComplete() {
        countDown();
    }

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    @Override // reactor.core.CoreSubscriber, Z9.d
    public final void onSubscribe(Z9.e eVar) {
        this.f5695s = eVar;
        if (this.cancelled) {
            return;
        }
        eVar.request(Long.MAX_VALUE);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(getCount() == 0);
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.f5695s;
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

    @Nullable
    public final T blockingGet(long j5, TimeUnit timeUnit) {
        if (!Schedulers.isInNonBlockingThread()) {
            if (getCount() != 0) {
                try {
                    if (!await(j5, timeUnit)) {
                        dispose();
                        String str = "Timeout on blocking read for " + j5 + " " + timeUnit;
                        throw new IllegalStateException(str, new TimeoutException(str));
                    }
                } catch (InterruptedException e) {
                    dispose();
                    RuntimeException runtimeExceptionPropagate = Exceptions.propagate(e);
                    runtimeExceptionPropagate.addSuppressed(new Exception("#block has been interrupted"));
                    Thread.currentThread().interrupt();
                    throw runtimeExceptionPropagate;
                }
            }
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            RuntimeException runtimeExceptionPropagate2 = Exceptions.propagate(th);
            runtimeExceptionPropagate2.addSuppressed(new Exception("#block terminated with an error"));
            throw runtimeExceptionPropagate2;
        }
        throw new IllegalStateException("block()/blockFirst()/blockLast() are blocking, which is not supported in thread " + Thread.currentThread().getName());
    }
}
