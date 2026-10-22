package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxOnBackpressureDrop<T> extends InternalFluxOperator<T, T> {
    static final Consumer<Object> NOOP = new Consumer() { // from class: reactor.core.publisher.Q0
        @Override // java.util.function.Consumer
        public final void accept(Object obj) {
            FluxOnBackpressureDrop.h0(obj);
        }
    };
    final Consumer<? super T> onDrop;

    public static final class DropSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<DropSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(DropSubscriber.class, "requested");
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Consumer<? super T> onDrop;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39539s;

        public DropSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super T> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.onDrop = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39539s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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
                onError(Operators.onOperatorError(this.f39539s, th2, t10, this.ctx));
            }
            Operators.onDiscard(t10, this.ctx);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39539s, dVar)) {
                this.f39539s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39539s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnBackpressureDrop(Flux<? extends T> flux) {
        super(flux);
        this.onDrop = NOOP;
    }

    public static /* synthetic */ void h0(Object obj) {
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DropSubscriber(coreSubscriber, this.onDrop);
    }

    public FluxOnBackpressureDrop(Flux<? extends T> flux, Consumer<? super T> consumer) {
        super(flux);
        Objects.requireNonNull(consumer, "onDrop");
        this.onDrop = consumer;
    }
}
