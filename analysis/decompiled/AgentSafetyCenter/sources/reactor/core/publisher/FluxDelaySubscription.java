package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxDelaySubscription<T, U> extends InternalFluxOperator<T, T> implements Consumer<DelaySubscriptionOtherSubscriber<T, U>> {
    final qd.c other;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class DelaySubscriptionMainSubscriber<T> implements InnerConsumer<T> {
        final CoreSubscriber<? super T> actual;
        final DelaySubscriptionOtherSubscriber<?, ?> arbiter;

        public DelaySubscriptionMainSubscriber(CoreSubscriber<? super T> coreSubscriber, DelaySubscriptionOtherSubscriber<?, ?> delaySubscriptionOtherSubscriber) {
            this.actual = coreSubscriber;
            this.arbiter = delaySubscriptionOtherSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.arbiter.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            this.arbiter.set(eVar);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ACTUAL) {
                return this.actual;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class DelaySubscriptionOtherSubscriber<T, U> extends Operators.DeferredSubscription implements InnerOperator<U, T> {
        final CoreSubscriber<? super T> actual;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10605s;
        final Consumer<DelaySubscriptionOtherSubscriber<T, U>> source;

        public DelaySubscriptionOtherSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<DelaySubscriptionOtherSubscriber<T, U>> consumer) {
            this.actual = coreSubscriber;
            this.source = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, qd.e
        public void cancel() {
            this.f10605s.cancel();
            super.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.accept(this);
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
        public void onNext(U u10) {
            if (this.done) {
                return;
            }
            this.done = true;
            this.f10605s.cancel();
            this.source.accept(this);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10605s, eVar)) {
                this.f10605s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10605s : attr == Scannable.Attr.ACTUAL ? this.actual : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxDelaySubscription(Flux<? extends T> flux, qd.c cVar) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
    }

    @Override // java.util.function.Consumer
    public void accept(DelaySubscriptionOtherSubscriber<T, U> delaySubscriptionOtherSubscriber) {
        this.source.subscribe((CoreSubscriber) new DelaySubscriptionMainSubscriber(delaySubscriptionOtherSubscriber.actual, delaySubscriptionOtherSubscriber));
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
        this.other.subscribe(new DelaySubscriptionOtherSubscriber(coreSubscriber, this));
        return null;
    }
}
