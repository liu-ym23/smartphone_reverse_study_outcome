package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
final class FluxDoOnEach<T> extends InternalFluxOperator<T, T> {
    final Consumer<? super Signal<T>> onSignal;

    public static final class DoOnEachConditionalSubscriber<T> extends DoOnEachSubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        public DoOnEachConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super Signal<T>> consumer, boolean z10) {
            super(conditionalSubscriber, consumer, z10);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            boolean zTryOnNext = ((Fuseable.ConditionalSubscriber) this.actual).tryOnNext(t9);
            if (zTryOnNext) {
                this.f5732t = t9;
                this.onSignal.accept(this);
            }
            return zTryOnNext;
        }
    }

    public static final class DoOnEachFuseableConditionalSubscriber<T> extends DoOnEachFuseableSubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        public DoOnEachFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super Signal<T>> consumer, boolean z10) {
            super(conditionalSubscriber, consumer, z10);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            boolean zTryOnNext = ((Fuseable.ConditionalSubscriber) this.actual).tryOnNext(t9);
            if (zTryOnNext) {
                this.f5732t = t9;
                this.onSignal.accept(this);
            }
            return zTryOnNext;
        }
    }

    public static class DoOnEachFuseableSubscriber<T> extends DoOnEachSubscriber<T> implements Fuseable, Fuseable.QueueSubscription<T> {
        int fusionMode;

        public DoOnEachFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super Signal<T>> consumer, boolean z10) {
            super(coreSubscriber, consumer, z10);
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            return queueSubscription == null || queueSubscription.isEmpty();
        }

        @Override // reactor.core.publisher.FluxDoOnEach.DoOnEachSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.fusionMode == 2) {
                this.actual.onNext(null);
            } else {
                super.onNext(t9);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return null;
            }
            T tPoll = queueSubscription.poll();
            if (tPoll == null && this.fusionMode == 1) {
                this.state = (short) 3;
                this.onSignal.accept(Signal.complete(this.cachedContext));
                return tPoll;
            }
            if (tPoll != null) {
                this.f5732t = tPoll;
                this.onSignal.accept(this);
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            int iRequestFusion;
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null && (i & 4) == 0 && ((iRequestFusion = queueSubscription.requestFusion(i)) == 1 || iRequestFusion == 2)) {
                this.fusionMode = iRequestFusion;
                return iRequestFusion;
            }
            this.fusionMode = 0;
            return 0;
        }

        @Override // java.util.Collection
        public int size() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            return queueSubscription.size();
        }
    }

    public static class DoOnEachSubscriber<T> implements InnerOperator<T, T>, Signal<T> {
        static final short STATE_DONE = 3;
        static final short STATE_FLUX_START = 0;
        static final short STATE_MONO_START = 1;
        static final short STATE_SKIP_HANDLER = 2;
        final CoreSubscriber<? super T> actual;
        final Context cachedContext;
        final Consumer<? super Signal<T>> onSignal;

        @Nullable
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5731s;
        short state;

        /* renamed from: t, reason: collision with root package name */
        T f5732t;

        public DoOnEachSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super Signal<T>> consumer, boolean z10) {
            this.actual = coreSubscriber;
            this.cachedContext = coreSubscriber.currentContext();
            this.onSignal = consumer;
            this.state = z10 ? (short) 1 : (short) 0;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5731s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.cachedContext;
        }

        @Override // reactor.core.publisher.Signal, java.util.function.Supplier
        @Nullable
        public T get() {
            return this.f5732t;
        }

        @Override // reactor.core.publisher.Signal
        public ContextView getContextView() {
            return this.cachedContext;
        }

        @Override // reactor.core.publisher.Signal
        @Nullable
        public Z9.e getSubscription() {
            return null;
        }

        @Override // reactor.core.publisher.Signal
        @Nullable
        public Throwable getThrowable() {
            return null;
        }

        @Override // reactor.core.publisher.Signal
        public SignalType getType() {
            return SignalType.ON_NEXT;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            short s5 = this.state;
            if (s5 == 3) {
                return;
            }
            this.state = (short) 3;
            if (s5 < 2) {
                try {
                    this.onSignal.accept(Signal.complete(this.cachedContext));
                } catch (Throwable th) {
                    this.state = s5;
                    onError(Operators.onOperatorError(this.f5731s, th, this.cachedContext));
                    return;
                }
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            short s5 = this.state;
            if (s5 == 3) {
                Operators.onErrorDropped(th, this.cachedContext);
                return;
            }
            boolean z10 = s5 < 2;
            this.state = (short) 3;
            if (z10) {
                try {
                    this.onSignal.accept(Signal.error(th, this.cachedContext));
                } catch (Throwable th2) {
                    th = Operators.onOperatorError(null, th2, th, this.cachedContext);
                }
            }
            try {
                this.actual.onError(th);
            } catch (UnsupportedOperationException e) {
                if (!Exceptions.isErrorCallbackNotImplemented(e) && e.getCause() != th) {
                    throw e;
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.state == 3) {
                Operators.onNextDropped(t9, this.cachedContext);
                return;
            }
            try {
                this.f5732t = t9;
                this.onSignal.accept(this);
                if (this.state == 1) {
                    this.state = (short) 2;
                    try {
                        this.onSignal.accept(Signal.complete(this.cachedContext));
                    } catch (Throwable th) {
                        this.state = (short) 1;
                        onError(Operators.onOperatorError(this.f5731s, th, this.cachedContext));
                        return;
                    }
                }
                this.actual.onNext(t9);
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f5731s, th2, t9, this.cachedContext));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5731s, eVar)) {
                this.f5731s = eVar;
                this.qs = Operators.as(eVar);
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5731s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5731s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.state == 3);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public String toString() {
            return "doOnEach_onNext(" + this.f5732t + ")";
        }
    }

    public FluxDoOnEach(Flux<? extends T> flux, Consumer<? super Signal<T>> consumer) {
        super(flux);
        Objects.requireNonNull(consumer, "onSignal");
        this.onSignal = consumer;
    }

    public static <T> DoOnEachSubscriber<T> createSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super Signal<T>> consumer, boolean z10, boolean z11) {
        return z10 ? coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new DoOnEachFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, consumer, z11) : new DoOnEachFuseableSubscriber(coreSubscriber, consumer, z11) : coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new DoOnEachConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, consumer, z11) : new DoOnEachSubscriber<>(coreSubscriber, consumer, z11);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return createSubscriber(coreSubscriber, this.onSignal, false, false);
    }
}
