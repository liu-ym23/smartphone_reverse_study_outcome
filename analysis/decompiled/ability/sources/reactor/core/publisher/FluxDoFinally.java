package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxDoFinally<T> extends InternalFluxOperator<T, T> {
    final Consumer<SignalType> onFinally;

    public static final class DoFinallyConditionalSubscriber<T> extends DoFinallySubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        public DoFinallyConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<SignalType> consumer) {
            super(conditionalSubscriber, consumer);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            return ((Fuseable.ConditionalSubscriber) this.actual).tryOnNext(t9);
        }
    }

    public static class DoFinallySubscriber<T> implements InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<DoFinallySubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(DoFinallySubscriber.class, "once");
        final CoreSubscriber<? super T> actual;
        final Consumer<SignalType> onFinally;
        volatile int once;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5730s;

        public DoFinallySubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<SignalType> consumer) {
            this.actual = coreSubscriber;
            this.onFinally = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5730s.cancel();
            runFinally(SignalType.CANCEL);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
            runFinally(SignalType.ON_COMPLETE);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                runFinally(SignalType.ON_ERROR);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5730s, eVar)) {
                this.f5730s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5730s.request(j5);
        }

        public void runFinally(SignalType signalType) {
            if (ONCE.compareAndSet(this, 0, 1)) {
                try {
                    this.onFinally.accept(signalType);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    Operators.onErrorDropped(th, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5730s;
            }
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.once == 1);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxDoFinally(Flux<? extends T> flux, Consumer<SignalType> consumer) {
        super(flux);
        this.onFinally = consumer;
    }

    public static <T> CoreSubscriber<T> createSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<SignalType> consumer) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new DoFinallyConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, consumer) : new DoFinallySubscriber(coreSubscriber, consumer);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return createSubscriber(coreSubscriber, this.onFinally);
    }
}
