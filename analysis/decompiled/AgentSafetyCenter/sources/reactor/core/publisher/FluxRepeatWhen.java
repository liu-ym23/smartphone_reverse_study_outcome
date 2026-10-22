package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxRepeatWhen<T> extends InternalFluxOperator<T, T> {
    final Function<? super Flux<Long>, ? extends qd.c> whenSourceFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RepeatWhenMainSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        static final AtomicIntegerFieldUpdater<RepeatWhenMainSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(RepeatWhenMainSubscriber.class, "wip");
        Context context;
        final Operators.DeferredSubscription otherArbiter;
        long produced;
        final Sinks.Many<Long> signaller;
        final CorePublisher<? extends T> source;
        volatile int wip;

        public RepeatWhenMainSubscriber(CoreSubscriber<? super T> coreSubscriber, Sinks.Many<Long> many, CorePublisher<? extends T> corePublisher) {
            super(coreSubscriber);
            this.signaller = many;
            this.source = corePublisher;
            this.otherArbiter = new Operators.DeferredSubscription();
            this.context = coreSubscriber.currentContext();
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

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) new Scannable[]{Scannable.from(this.signaller), this.otherArbiter});
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                produced(j10);
            }
            this.signaller.emitNext(Long.valueOf(j10), Sinks.EmitFailureHandler.FAIL_FAST);
            this.otherArbiter.request(1L);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.otherArbiter.cancel();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
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

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void setWhen(qd.e eVar) {
            this.otherArbiter.set(eVar);
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

    public FluxRepeatWhen(Flux<? extends T> flux, Function<? super Flux<Long>, ? extends qd.c> function) {
        super(flux);
        Objects.requireNonNull(function, "whenSourceFactory");
        this.whenSourceFactory = function;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        RepeatWhenOtherSubscriber repeatWhenOtherSubscriber = new RepeatWhenOtherSubscriber();
        CoreSubscriber coreSubscriberSerialize = Operators.serialize(coreSubscriber);
        RepeatWhenMainSubscriber<?> repeatWhenMainSubscriber = new RepeatWhenMainSubscriber<>(coreSubscriberSerialize, repeatWhenOtherSubscriber.completionSignal, this.source);
        repeatWhenOtherSubscriber.main = repeatWhenMainSubscriber;
        coreSubscriberSerialize.onSubscribe(repeatWhenMainSubscriber);
        try {
            qd.c cVarApply = this.whenSourceFactory.apply(repeatWhenOtherSubscriber);
            Objects.requireNonNull(cVarApply, "The whenSourceFactory returned a null Publisher");
            Operators.toFluxOrMono(cVarApply).subscribe((qd.d) repeatWhenOtherSubscriber);
            if (repeatWhenMainSubscriber.cancelled) {
                return null;
            }
            return repeatWhenMainSubscriber;
        } catch (Throwable th) {
            coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RepeatWhenOtherSubscriber extends Flux<Long> implements InnerConsumer<Object>, OptimizableOperator<Long, Long> {
        final Sinks.Many<Long> completionSignal = Sinks.many().multicast().onBackpressureBuffer();
        RepeatWhenMainSubscriber<?> main;

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.OptimizableOperator
        public OptimizableOperator<?, ? extends Long> nextOptimizableSource() {
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
            this.main.setWhen(eVar);
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
        public CorePublisher<? extends Long> source() {
            return this.completionSignal.asFlux();
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super Long> coreSubscriber) {
            this.completionSignal.asFlux().subscribe(coreSubscriber);
        }

        @Override // reactor.core.publisher.OptimizableOperator
        public CoreSubscriber<? super Long> subscribeOrReturn(CoreSubscriber<? super Long> coreSubscriber) {
            return coreSubscriber;
        }
    }
}
