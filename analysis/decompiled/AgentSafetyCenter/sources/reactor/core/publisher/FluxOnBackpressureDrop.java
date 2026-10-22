package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxOnBackpressureDrop<T> extends InternalFluxOperator<T, T> {
    static final Consumer<Object> NOOP = new o0(1);
    final Consumer<? super T> onDrop;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class DropSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<DropSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(DropSubscriber.class, "requested");
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Consumer<? super T> onDrop;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10649s;

        public DropSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super T> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.onDrop = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10649s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                try {
                    this.onDrop.accept(t10);
                } catch (Throwable th) {
                    Operators.onErrorDropped(th, this.ctx);
                }
                Operators.onDiscard(t10, this.ctx);
                return;
            }
            long j10 = this.requested;
            if (j10 != 0) {
                this.actual.onNext(t10);
                if (j10 != Long.MAX_VALUE) {
                    Operators.produced(REQUESTED, this, 1L);
                    return;
                }
                return;
            }
            try {
                this.onDrop.accept(t10);
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f10649s, th2, t10, this.ctx));
            }
            Operators.onDiscard(t10, this.ctx);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10649s, eVar)) {
                this.f10649s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10649s : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(Reader.READ_DONE) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnBackpressureDrop(Flux<? extends T> flux, Consumer<? super T> consumer) {
        super(flux);
        Objects.requireNonNull(consumer, "onDrop");
        this.onDrop = consumer;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DropSubscriber(coreSubscriber, this.onDrop);
    }

    public FluxOnBackpressureDrop(Flux<? extends T> flux) {
        super(flux);
        this.onDrop = NOOP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Object obj) {
    }
}
