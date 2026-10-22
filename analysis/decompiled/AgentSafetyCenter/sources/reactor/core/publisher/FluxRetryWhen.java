package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxRetryWhen<T> extends InternalFluxOperator<T, T> {
    final Retry whenSourceFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RetryWhenMainSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> implements Retry.RetrySignal {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final AtomicIntegerFieldUpdater<RetryWhenMainSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(RetryWhenMainSubscriber.class, "wip");
        Context context;

        @Nullable
        Throwable lastFailure;
        final Operators.DeferredSubscription otherArbiter;
        long produced;
        final ContextView retryContext;
        final Sinks.Many<Retry.RetrySignal> signaller;
        final CorePublisher<? extends T> source;
        long subsequentFailureIndex;
        long totalFailureIndex;
        volatile int wip;

        public RetryWhenMainSubscriber(CoreSubscriber<? super T> coreSubscriber, Sinks.Many<Retry.RetrySignal> many, CorePublisher<? extends T> corePublisher, ContextView contextView) {
            super(coreSubscriber);
            this.totalFailureIndex = 0L;
            this.subsequentFailureIndex = 0L;
            this.lastFailure = null;
            this.signaller = many;
            this.source = corePublisher;
            this.otherArbiter = new Operators.DeferredSubscription();
            this.context = coreSubscriber.currentContext();
            this.retryContext = contextView;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.otherArbiter.cancel();
            super.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        @Override // reactor.util.retry.Retry.RetrySignal
        public Throwable failure() {
            return this.lastFailure;
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) new Scannable[]{Scannable.from(this.signaller), this.otherArbiter});
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.lastFailure = null;
            this.otherArbiter.cancel();
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.totalFailureIndex++;
            this.subsequentFailureIndex++;
            this.lastFailure = th;
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                produced(j10);
            }
            this.signaller.emitNext(this, Sinks.EmitFailureHandler.FAIL_FAST);
            this.otherArbiter.request(1L);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.subsequentFailureIndex = 0L;
            this.actual.onNext(t10);
            this.produced++;
        }

        public void resubscribe(Object obj) {
            if (WIP.getAndIncrement(this) == 0) {
                while (!this.cancelled) {
                    if (obj instanceof ContextView) {
                        this.context = this.context.putAll((ContextView) obj);
                    }
                    this.source.subscribe((CoreSubscriber<? super Object>) this);
                    if (WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                }
            }
        }

        @Override // reactor.util.retry.Retry.RetrySignal
        public ContextView retryContextView() {
            return this.retryContext;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void swap(qd.e eVar) {
            this.otherArbiter.set(eVar);
        }

        @Override // reactor.util.retry.Retry.RetrySignal
        public long totalRetries() {
            return this.totalFailureIndex - 1;
        }

        @Override // reactor.util.retry.Retry.RetrySignal
        public long totalRetriesInARow() {
            return this.subsequentFailureIndex - 1;
        }

        public void whenComplete() {
            super.cancel();
            this.actual.onComplete();
        }

        public void whenError(Throwable th) {
            super.cancel();
            this.actual.onError(th);
        }
    }

    public FluxRetryWhen(Flux<? extends T> flux, Retry retry) {
        super(flux);
        Objects.requireNonNull(retry, "whenSourceFactory");
        this.whenSourceFactory = retry;
    }

    public static <T> void subscribe(CoreSubscriber<? super T> coreSubscriber, Retry retry, CorePublisher<? extends T> corePublisher) {
        CorePublisher fluxOrMono = Operators.toFluxOrMono(corePublisher);
        RetryWhenOtherSubscriber retryWhenOtherSubscriber = new RetryWhenOtherSubscriber();
        CoreSubscriber coreSubscriberSerialize = Operators.serialize(coreSubscriber);
        RetryWhenMainSubscriber<?> retryWhenMainSubscriber = new RetryWhenMainSubscriber<>(coreSubscriberSerialize, retryWhenOtherSubscriber.completionSignal, fluxOrMono, retry.retryContext());
        retryWhenOtherSubscriber.main = retryWhenMainSubscriber;
        coreSubscriberSerialize.onSubscribe(retryWhenMainSubscriber);
        try {
            qd.c cVarGenerateCompanion = retry.generateCompanion(retryWhenOtherSubscriber);
            Objects.requireNonNull(cVarGenerateCompanion, "The whenSourceFactory returned a null Publisher");
            Operators.toFluxOrMono(cVarGenerateCompanion).subscribe((qd.d) retryWhenOtherSubscriber);
            if (retryWhenMainSubscriber.cancelled) {
                return;
            }
            fluxOrMono.subscribe((CoreSubscriber) retryWhenMainSubscriber);
        } catch (Throwable th) {
            coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
        }
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        subscribe(coreSubscriber, this.whenSourceFactory, this.source);
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RetryWhenOtherSubscriber extends Flux<Retry.RetrySignal> implements InnerConsumer<Object>, OptimizableOperator<Retry.RetrySignal, Retry.RetrySignal> {
        final Sinks.Many<Retry.RetrySignal> completionSignal = Sinks.many().multicast().onBackpressureBuffer();
        RetryWhenMainSubscriber<?> main;

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.OptimizableOperator
        public OptimizableOperator<?, ? extends Retry.RetrySignal> nextOptimizableSource() {
            return null;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.main.whenComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.main.whenError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
            this.main.resubscribe(obj);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            this.main.swap(eVar);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.main.otherArbiter;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.main;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            if (attr == InternalProducerAttr.INSTANCE) {
                return Boolean.TRUE;
            }
            return null;
        }

        @Override // reactor.core.publisher.OptimizableOperator
        public CorePublisher<? extends Retry.RetrySignal> source() {
            return this.completionSignal.asFlux();
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super Retry.RetrySignal> coreSubscriber) {
            this.completionSignal.asFlux().subscribe(coreSubscriber);
        }

        @Override // reactor.core.publisher.OptimizableOperator
        public CoreSubscriber<? super Retry.RetrySignal> subscribeOrReturn(CoreSubscriber<? super Retry.RetrySignal> coreSubscriber) {
            return coreSubscriber;
        }
    }
}
