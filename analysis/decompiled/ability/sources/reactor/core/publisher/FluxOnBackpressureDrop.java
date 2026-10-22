package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxOnBackpressureDrop<T> extends InternalFluxOperator<T, T> {
    static final Consumer<Object> NOOP = new N(1);
    final Consumer<? super T> onDrop;

    public static final class DropSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<DropSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(DropSubscriber.class, "requested");
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Consumer<? super T> onDrop;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5769s;

        public DropSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super T> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.onDrop = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5769s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                try {
                    this.onDrop.accept(t9);
                } catch (Throwable th) {
                    Operators.onErrorDropped(th, this.ctx);
                }
                Operators.onDiscard(t9, this.ctx);
                return;
            }
            long j5 = this.requested;
            if (j5 != 0) {
                this.actual.onNext(t9);
                if (j5 != Long.MAX_VALUE) {
                    Operators.produced(REQUESTED, this, 1L);
                    return;
                }
                return;
            }
            try {
                this.onDrop.accept(t9);
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f5769s, th2, t9, this.ctx));
            }
            Operators.onDiscard(t9, this.ctx);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5769s, eVar)) {
                this.f5769s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5769s;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Object obj) {
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
