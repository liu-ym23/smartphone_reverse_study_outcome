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

/* loaded from: classes4.dex */
final class FluxUsing<T, S> extends Flux<T> implements Fuseable, SourceProducer<T> {
    final boolean eager;
    final Consumer<? super S> resourceCleanup;
    final Callable<S> resourceSupplier;
    final Function<? super S, ? extends Z9.c> sourceFactory;

    public static final class UsingConditionalSubscriber<T, S> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        static final AtomicIntegerFieldUpdater<UsingConditionalSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(UsingConditionalSubscriber.class, "wip");
        final Fuseable.ConditionalSubscriber<? super T> actual;
        final boolean eager;
        final S resource;
        final Consumer<? super S> resourceCleanup;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5816s;
        volatile int wip;

        public UsingConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super S> consumer, S s5, boolean z10) {
            this.actual = conditionalSubscriber;
            this.resourceCleanup = consumer;
            this.resource = s5;
            this.eager = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (WIP.compareAndSet(this, 0, 1)) {
                this.f5816s.cancel();
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
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.eager && WIP.compareAndSet(this, 0, 1)) {
                try {
                    this.resourceCleanup.accept(this.resource);
                } catch (Throwable th) {
                    Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                    conditionalSubscriber.onError(Operators.onOperatorError(th, conditionalSubscriber.currentContext()));
                    return;
                }
            }
            this.actual.onComplete();
            if (this.eager || !WIP.compareAndSet(this, 0, 1)) {
                return;
            }
            cleanup();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5816s, eVar)) {
                this.f5816s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5816s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.wip == 1);
            }
            return attr == Scannable.Attr.PARENT ? this.f5816s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            return this.actual.tryOnNext(t9);
        }
    }

    public static final class UsingFuseableSubscriber<T, S> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        static final AtomicIntegerFieldUpdater<UsingFuseableSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(UsingFuseableSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        final boolean eager;
        int mode;
        final S resource;
        final Consumer<? super S> resourceCleanup;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f5817s;
        volatile int wip;

        public UsingFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super S> consumer, S s5, boolean z10) {
            this.actual = coreSubscriber;
            this.resourceCleanup = consumer;
            this.resource = s5;
            this.eager = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (WIP.compareAndSet(this, 0, 1)) {
                this.f5817s.cancel();
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
            this.f5817s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f5817s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
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
            cleanup();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
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
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5817s, eVar)) {
                this.f5817s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            T tPoll = this.f5817s.poll();
            if (tPoll == null && this.mode == 1 && WIP.compareAndSet(this, 0, 1)) {
                this.resourceCleanup.accept(this.resource);
            }
            return tPoll;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5817s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            int iRequestFusion = this.f5817s.requestFusion(i);
            this.mode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.wip == 1);
            }
            return attr == Scannable.Attr.PARENT ? this.f5817s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f5817s.size();
        }
    }

    public static final class UsingSubscriber<T, S> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        static final AtomicIntegerFieldUpdater<UsingSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(UsingSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        final boolean eager;
        final S resource;
        final Consumer<? super S> resourceCleanup;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5818s;
        volatile int wip;

        public UsingSubscriber(CoreSubscriber<? super T> coreSubscriber, Consumer<? super S> consumer, S s5, boolean z10) {
            this.actual = coreSubscriber;
            this.resourceCleanup = consumer;
            this.resource = s5;
            this.eager = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (WIP.compareAndSet(this, 0, 1)) {
                this.f5818s.cancel();
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
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
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
            cleanup();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
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
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5818s, eVar)) {
                this.f5818s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5818s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.wip == 1);
            }
            return attr == Scannable.Attr.PARENT ? this.f5818s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public FluxUsing(Callable<S> callable, Function<? super S, ? extends Z9.c> function, Consumer<? super S> consumer, boolean z10) {
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

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            S sCall = this.resourceSupplier.call();
            try {
                Z9.c cVarApply = this.sourceFactory.apply(sCall);
                Objects.requireNonNull(cVarApply, "The sourceFactory returned a null value");
                Z9.c cVar = cVarApply;
                if (cVar instanceof Fuseable) {
                    Flux.from(cVar).subscribe((CoreSubscriber) new UsingFuseableSubscriber(coreSubscriber, this.resourceCleanup, sCall, this.eager));
                } else if (coreSubscriber instanceof Fuseable.ConditionalSubscriber) {
                    Flux.from(cVar).subscribe((CoreSubscriber) new UsingConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.resourceCleanup, sCall, this.eager));
                } else {
                    Flux.from(cVar).subscribe((CoreSubscriber) new UsingSubscriber(coreSubscriber, this.resourceCleanup, sCall, this.eager));
                }
            } catch (Throwable th) {
                Throwable thOnOperatorError = Operators.onOperatorError(th, coreSubscriber.currentContext());
                try {
                    this.resourceCleanup.accept(sCall);
                } catch (Throwable th2) {
                    thOnOperatorError = Exceptions.addSuppressed(th2, thOnOperatorError);
                }
                Operators.error(coreSubscriber, thOnOperatorError);
            }
        } catch (Throwable th3) {
            com.stepos.statsrpk.service.c.t(coreSubscriber, th3, coreSubscriber);
        }
    }
}
