package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
abstract class BlockingSingleSubscriber<T> extends CountDownLatch implements InnerConsumer<T>, Disposable {
    volatile boolean cancelled;
    final Context context;
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    qd.e f10583s;
    T value;

    public BlockingSingleSubscriber(Context context) {
        super(1);
        this.context = context;
    }

    @Nullable
    public final T blockingGet(long j10, TimeUnit timeUnit) {
        if (Schedulers.isInNonBlockingThread()) {
            ad.o.n(Thread.currentThread().getName(), "block()/blockFirst()/blockLast() are blocking, which is not supported in thread ");
            return null;
        }
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

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return this.context;
    }

    @Override // reactor.core.Disposable
    public final void dispose() {
        this.cancelled = true;
        qd.e eVar = this.f10583s;
        if (eVar != null) {
            this.f10583s = null;
            eVar.cancel();
        }
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.cancelled || getCount() == 0;
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public final void onComplete() {
        countDown();
    }

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    @Override // reactor.core.CoreSubscriber, qd.d
    public final void onSubscribe(qd.e eVar) {
        this.f10583s = eVar;
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
            return this.f10583s;
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(this.cancelled);
        }
        if (attr == Scannable.Attr.ERROR) {
            return this.error;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(Reader.READ_DONE);
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    @Nullable
    public final T blockingGet() throws InterruptedException {
        if (!Schedulers.isInNonBlockingThread()) {
            if (getCount() != 0) {
                try {
                    await();
                } catch (InterruptedException e10) {
                    dispose();
                    Thread.currentThread().interrupt();
                    throw Exceptions.propagate(e10);
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
        ad.o.n(Thread.currentThread().getName(), "block()/blockFirst()/blockLast() are blocking, which is not supported in thread ");
        return null;
    }
}
