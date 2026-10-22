package reactor.core.publisher;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoRunnable<T> extends Mono<T> implements Callable<Void>, SourceProducer<T> {
    final Runnable run;

    public MonoRunnable(Runnable runnable) {
        Objects.requireNonNull(runnable, "run");
        this.run = runnable;
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public T block(Duration duration) {
        this.run.run();
        return null;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Void call() {
        this.run.run();
        return null;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        MonoRunnableEagerSubscription monoRunnableEagerSubscription = new MonoRunnableEagerSubscription();
        coreSubscriber.onSubscribe(monoRunnableEagerSubscription);
        if (monoRunnableEagerSubscription.isCancelled()) {
            return;
        }
        try {
            this.run.run();
            coreSubscriber.onComplete();
        } catch (Throwable th) {
            coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
        }
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public T block() {
        this.run.run();
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MonoRunnableEagerSubscription extends AtomicBoolean implements qd.e {
        @Override // qd.e
        public void cancel() {
            set(true);
        }

        public boolean isCancelled() {
            return get();
        }

        @Override // qd.e
        public void request(long j10) {
        }
    }
}
