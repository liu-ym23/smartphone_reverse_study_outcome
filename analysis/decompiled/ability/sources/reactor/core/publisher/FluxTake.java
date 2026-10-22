package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxTake<T> extends InternalFluxOperator<T, T> {
    final long n;

    public static final class TakeConditionalSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<TakeConditionalSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(TakeConditionalSubscriber.class, "wip");
        final Fuseable.ConditionalSubscriber<? super T> actual;
        boolean done;
        final long n;
        long remaining;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5804s;
        volatile int wip;

        public TakeConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, long j5) {
            this.actual = conditionalSubscriber;
            this.n = j5;
            this.remaining = j5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5804s.cancel();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.remaining;
            if (j5 == 0) {
                this.f5804s.cancel();
                onComplete();
                return;
            }
            long j6 = j5 - 1;
            this.remaining = j6;
            boolean z10 = j6 == 0;
            this.actual.onNext(t9);
            if (z10) {
                this.f5804s.cancel();
                onComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5804s, eVar)) {
                if (this.n != 0) {
                    this.f5804s = eVar;
                    this.actual.onSubscribe(this);
                } else {
                    eVar.cancel();
                    this.done = true;
                    Operators.complete(this.actual);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                this.f5804s.request(j5);
            } else if (j5 >= this.n) {
                this.f5804s.request(Long.MAX_VALUE);
            } else {
                this.f5804s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f5804s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return true;
            }
            long j5 = this.remaining;
            if (j5 == 0) {
                this.f5804s.cancel();
                onComplete();
                return true;
            }
            long j6 = j5 - 1;
            this.remaining = j6;
            boolean z10 = j6 == 0;
            boolean zTryOnNext = this.actual.tryOnNext(t9);
            if (z10) {
                this.f5804s.cancel();
                onComplete();
            }
            return zTryOnNext;
        }
    }

    public static final class TakeFuseableSubscriber<T> implements Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<TakeFuseableSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(TakeFuseableSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        boolean done;
        int inputMode;
        final long n;
        Fuseable.QueueSubscription<T> qs;
        long remaining;
        volatile int wip;

        public TakeFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, long j5) {
            this.actual = coreSubscriber;
            this.n = j5;
            this.remaining = j5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            this.qs.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.remaining == 0 || this.qs.isEmpty();
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
            if (this.inputMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.remaining;
            if (j5 == 0) {
                this.qs.cancel();
                onComplete();
                return;
            }
            long j6 = j5 - 1;
            this.remaining = j6;
            boolean z10 = j6 == 0;
            this.actual.onNext(t9);
            if (z10) {
                this.qs.cancel();
                onComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.qs, eVar)) {
                if (this.n != 0) {
                    this.qs = (Fuseable.QueueSubscription) eVar;
                    this.actual.onSubscribe(this);
                } else {
                    eVar.cancel();
                    this.done = true;
                    Operators.complete(this.actual);
                }
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            if (this.done) {
                return null;
            }
            long j5 = this.remaining;
            T tPoll = this.qs.poll();
            if (j5 == 0) {
                this.done = true;
                if (this.inputMode == 2) {
                    this.qs.cancel();
                    this.actual.onComplete();
                }
                return null;
            }
            if (tPoll != null) {
                long j6 = j5 - 1;
                this.remaining = j6;
                if (j6 == 0 && !this.done) {
                    this.done = true;
                    if (this.inputMode == 2) {
                        this.qs.cancel();
                        this.actual.onComplete();
                    }
                }
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                this.qs.request(j5);
            } else if (j5 >= this.n) {
                this.qs.request(Long.MAX_VALUE);
            } else {
                this.qs.request(j5);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            int iRequestFusion = this.qs.requestFusion(i);
            this.inputMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.qs : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.qs.size();
        }
    }

    public static final class TakeSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<TakeSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(TakeSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        boolean done;
        final long n;
        long remaining;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5805s;
        volatile int wip;

        public TakeSubscriber(CoreSubscriber<? super T> coreSubscriber, long j5) {
            this.actual = coreSubscriber;
            this.n = j5;
            this.remaining = j5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5805s.cancel();
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
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.remaining;
            if (j5 == 0) {
                this.f5805s.cancel();
                onComplete();
                return;
            }
            long j6 = j5 - 1;
            this.remaining = j6;
            boolean z10 = j6 == 0;
            this.actual.onNext(t9);
            if (z10) {
                this.f5805s.cancel();
                onComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5805s, eVar)) {
                if (this.n != 0) {
                    this.f5805s = eVar;
                    this.actual.onSubscribe(this);
                } else {
                    eVar.cancel();
                    this.done = true;
                    Operators.complete(this.actual);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                this.f5805s.request(j5);
            } else if (j5 >= this.n) {
                this.f5805s.request(Long.MAX_VALUE);
            } else {
                this.f5805s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f5805s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxTake(Flux<? extends T> flux, long j5) {
        super(flux);
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "n >= 0 required but it was "));
        }
        this.n = j5;
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
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new TakeConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.n) : new TakeSubscriber(coreSubscriber, this.n);
    }
}
