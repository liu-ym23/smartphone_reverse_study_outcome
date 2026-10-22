package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxErrorOnRequest<T> extends Flux<T> implements SourceProducer<T> {
    final Throwable error;

    public static final class ErrorSubscription implements InnerProducer {
        static final AtomicIntegerFieldUpdater<ErrorSubscription> ONCE = AtomicIntegerFieldUpdater.newUpdater(ErrorSubscription.class, "once");
        final CoreSubscriber<?> actual;
        final Throwable error;
        volatile int once;

        public ErrorSubscription(CoreSubscriber<?> coreSubscriber, Throwable th) {
            this.actual = coreSubscriber;
            this.error = th;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.once = 1;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10) && ONCE.compareAndSet(this, 0, 1)) {
                this.actual.onError(this.error);
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.CANCELLED || attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.once == 1);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxErrorOnRequest(Throwable th) {
        Objects.requireNonNull(th);
        this.error = th;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        coreSubscriber.onSubscribe(new ErrorSubscription(coreSubscriber, this.error));
    }
}
