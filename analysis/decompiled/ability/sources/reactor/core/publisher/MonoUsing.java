package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoUsing<T, S> extends Mono<T> implements Fuseable, SourceProducer<T> {
    final boolean eager;
    final Consumer<? super S> resourceCleanup;
    final Callable<S> resourceSupplier;
    final Function<? super S, ? extends Mono<? extends T>> sourceFactory;

    public static final class MonoUsingSubscriber<T, S> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        static final AtomicIntegerFieldUpdater<MonoUsingSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(MonoUsingSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        final boolean allowFusion;
        final boolean eager;
        int mode;

        @Nullable
        Fuseable.QueueSubscription<T> qs;
        final S resource;
        final Consumer<? super S> resourceCleanup;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5868s;
        boolean valued;
        volatile int wip;

        public MonoUsingSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super S> consumer, S s5, boolean z10, boolean z11) {
            this.actual = coreSubscriber;
            this.resourceCleanup = consumer;
            this.resource = s5;
            this.eager = z10;
            this.allowFusion = z11;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (WIP.compareAndSet(this, 0, 1)) {
                this.f5868s.cancel();
                cleanup();
            }
        }

        public void cleanup() {
            try {
                this.resourceCleanup.accept(this.resource);
            } catch (Throwable th) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // java.util.Collection
        public void clear() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                queueSubscription.clear();
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            return queueSubscription == null || queueSubscription.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (!this.valued || this.mode == 2) {
                if (this.eager && WIP.compareAndSet(this, 0, 1)) {
                    try {
                        this.resourceCleanup.accept(this.resource);
                    } catch (Throwable th) {
                        CoreSubscriber<? super T> coreSubscriber = this.actual;
                        coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
                        return;
                    }
                }
                this.actual.onComplete();
                if (this.eager || !WIP.compareAndSet(this, 0, 1)) {
                    return;
                }
                try {
                    this.resourceCleanup.accept(this.resource);
                } catch (Throwable th2) {
                    Operators.onErrorDropped(th2, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.valued && this.mode != 2) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            if (this.eager && WIP.compareAndSet(this, 0, 1)) {
                try {
                    this.resourceCleanup.accept(this.resource);
                } catch (Throwable th2) {
                    th = Exceptions.addSuppressed(Operators.onOperatorError(th2, this.actual.currentContext()), th);
                }
            }
            this.actual.onError(th);
            if (this.eager || !WIP.compareAndSet(this, 0, 1)) {
                return;
            }
            cleanup();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.mode == 2) {
                this.actual.onNext(null);
                return;
            }
            this.valued = true;
            if (this.eager && WIP.compareAndSet(this, 0, 1)) {
                try {
                    this.resourceCleanup.accept(this.resource);
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    this.actual.onError(Operators.onOperatorError(th, contextCurrentContext));
                    Operators.onDiscard(t9, contextCurrentContext);
                    return;
                }
            }
            this.actual.onNext(t9);
            this.actual.onComplete();
            if (this.eager || !WIP.compareAndSet(this, 0, 1)) {
                return;
            }
            try {
                this.resourceCleanup.accept(this.resource);
            } catch (Throwable th2) {
                Operators.onErrorDropped(th2, this.actual.currentContext());
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5868s, eVar)) {
                this.f5868s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    this.qs = (Fuseable.QueueSubscription) eVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            Fuseable.QueueSubscription<T> queueSubscription;
            if (this.mode == 0 || (queueSubscription = this.qs) == null) {
                return null;
            }
            T tPoll = queueSubscription.poll();
            if (tPoll != null) {
                this.valued = true;
                if (this.eager && WIP.compareAndSet(this, 0, 1)) {
                    try {
                        this.resourceCleanup.accept(this.resource);
                        return tPoll;
                    } catch (Throwable th) {
                        Operators.onDiscard(tPoll, this.actual.currentContext());
                        throw th;
                    }
                }
            } else if (this.mode == 1 && !this.eager && WIP.compareAndSet(this, 0, 1)) {
                try {
                    this.resourceCleanup.accept(this.resource);
                    return tPoll;
                } catch (Throwable th2) {
                    if (!this.valued) {
                        throw th2;
                    }
                    Operators.onErrorDropped(th2, this.actual.currentContext());
                    return tPoll;
                }
            }
            return tPoll;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5868s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                this.mode = 0;
                return 0;
            }
            int iRequestFusion = queueSubscription.requestFusion(i);
            this.mode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.wip == 1);
            }
            return attr == Scannable.Attr.PARENT ? this.f5868s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

    public MonoUsing(Callable<S> callable, Function<? super S, ? extends Mono<? extends T>> function, Consumer<? super S> consumer, boolean z10) {
        Objects.requireNonNull(callable, "resourceSupplier");
        this.resourceSupplier = callable;
        Objects.requireNonNull(function, "sourceFactory");
        this.sourceFactory = function;
        Objects.requireNonNull(consumer, "resourceCleanup");
        this.resourceCleanup = consumer;
        this.eager = z10;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            S sCall = this.resourceSupplier.call();
            try {
                Mono<? extends T> monoApply = this.sourceFactory.apply(sCall);
                Objects.requireNonNull(monoApply, "The sourceFactory returned a null value");
                Mono monoFromDirect = Mono.fromDirect(monoApply);
                if (monoFromDirect instanceof Fuseable) {
                    monoFromDirect.subscribe((CoreSubscriber) new MonoUsingSubscriber(coreSubscriber, this.resourceCleanup, sCall, this.eager, true));
                } else {
                    monoFromDirect.subscribe((CoreSubscriber) new MonoUsingSubscriber(coreSubscriber, this.resourceCleanup, sCall, this.eager, false));
                }
            } catch (Throwable th) {
                Throwable thAddSuppressed = th;
                try {
                    this.resourceCleanup.accept(sCall);
                } catch (Throwable th2) {
                    thAddSuppressed = Exceptions.addSuppressed(th2, Operators.onOperatorError(thAddSuppressed, coreSubscriber.currentContext()));
                }
                com.stepos.statsrpk.service.c.t(coreSubscriber, thAddSuppressed, coreSubscriber);
            }
        } catch (Throwable th3) {
            com.stepos.statsrpk.service.c.t(coreSubscriber, th3, coreSubscriber);
        }
    }
}
