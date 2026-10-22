package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxContextWrite<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final Function<Context, Context> doOnContext;

    public static final class ContextWriteSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;
        final Context context;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5717s;

        public ContextWriteSubscriber(CoreSubscriber<? super T> coreSubscriber, Context context) {
            this.actual = coreSubscriber;
            this.context = context;
            if (coreSubscriber instanceof Fuseable.ConditionalSubscriber) {
                this.actualConditional = (Fuseable.ConditionalSubscriber) coreSubscriber;
            } else {
                this.actualConditional = null;
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5717s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                queueSubscription.clear();
            }
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            return queueSubscription == null || queueSubscription.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5717s, eVar)) {
                this.f5717s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    this.qs = (Fuseable.QueueSubscription) eVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                return queueSubscription.poll();
            }
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5717s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            return queueSubscription.requestFusion(i);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5717s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                return queueSubscription.size();
            }
            return 0;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actualConditional;
            if (conditionalSubscriber != null) {
                return conditionalSubscriber.tryOnNext(t9);
            }
            this.actual.onNext(t9);
            return true;
        }
    }

    public FluxContextWrite(Flux<? extends T> flux, Function<Context, Context> function) {
        super(flux);
        Objects.requireNonNull(function, "doOnContext");
        this.doOnContext = function;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new ContextWriteSubscriber(coreSubscriber, this.doOnContext.apply(coreSubscriber.currentContext()));
    }
}
