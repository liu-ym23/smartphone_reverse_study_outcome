package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxTake<T> extends InternalFluxOperator<T, T> {

    /* renamed from: n, reason: collision with root package name */
    final long f10684n;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TakeConditionalSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<TakeConditionalSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(TakeConditionalSubscriber.class, "wip");
        final Fuseable.ConditionalSubscriber<? super T> actual;
        boolean done;

        /* renamed from: n, reason: collision with root package name */
        final long f10685n;
        long remaining;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10686s;
        volatile int wip;

        public TakeConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, long j10) {
            this.actual = conditionalSubscriber;
            this.f10685n = j10;
            this.remaining = j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10686s.cancel();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.remaining;
            if (j10 == 0) {
                this.f10686s.cancel();
                onComplete();
                return;
            }
            long j11 = j10 - 1;
            this.remaining = j11;
            boolean z10 = j11 == 0;
            this.actual.onNext(t10);
            if (z10) {
                this.f10686s.cancel();
                onComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10686s, eVar)) {
                if (this.f10685n != 0) {
                    this.f10686s = eVar;
                    this.actual.onSubscribe(this);
                } else {
                    eVar.cancel();
                    this.done = true;
                    Operators.complete(this.actual);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                this.f10686s.request(j10);
                return;
            }
            long j11 = this.f10685n;
            qd.e eVar = this.f10686s;
            if (j10 >= j11) {
                eVar.request(Long.MAX_VALUE);
            } else {
                eVar.request(j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f10686s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return true;
            }
            long j10 = this.remaining;
            if (j10 == 0) {
                this.f10686s.cancel();
                onComplete();
                return true;
            }
            long j11 = j10 - 1;
            this.remaining = j11;
            boolean z10 = j11 == 0;
            boolean zTryOnNext = this.actual.tryOnNext(t10);
            if (z10) {
                this.f10686s.cancel();
                onComplete();
            }
            return zTryOnNext;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TakeFuseableSubscriber<T> implements Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<TakeFuseableSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(TakeFuseableSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        boolean done;
        int inputMode;

        /* renamed from: n, reason: collision with root package name */
        final long f10687n;
        Fuseable.QueueSubscription<T> qs;
        long remaining;
        volatile int wip;

        public TakeFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, long j10) {
            this.actual = coreSubscriber;
            this.f10687n = j10;
            this.remaining = j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
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
        public void onNext(T t10) {
            if (this.inputMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.remaining;
            if (j10 == 0) {
                this.qs.cancel();
                onComplete();
                return;
            }
            long j11 = j10 - 1;
            this.remaining = j11;
            boolean z10 = j11 == 0;
            this.actual.onNext(t10);
            if (z10) {
                this.qs.cancel();
                onComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.qs, eVar)) {
                if (this.f10687n != 0) {
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
            long j10 = this.remaining;
            T tPoll = this.qs.poll();
            if (j10 == 0) {
                this.done = true;
                if (this.inputMode == 2) {
                    this.qs.cancel();
                    this.actual.onComplete();
                }
                return null;
            }
            if (tPoll != null) {
                long j11 = j10 - 1;
                this.remaining = j11;
                if (j11 == 0 && !this.done) {
                    this.done = true;
                    if (this.inputMode == 2) {
                        this.qs.cancel();
                        this.actual.onComplete();
                    }
                }
            }
            return tPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                this.qs.request(j10);
                return;
            }
            long j11 = this.f10687n;
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (j10 >= j11) {
                queueSubscription.request(Long.MAX_VALUE);
            } else {
                queueSubscription.request(j10);
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TakeSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicIntegerFieldUpdater<TakeSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(TakeSubscriber.class, "wip");
        final CoreSubscriber<? super T> actual;
        boolean done;

        /* renamed from: n, reason: collision with root package name */
        final long f10688n;
        long remaining;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10689s;
        volatile int wip;

        public TakeSubscriber(CoreSubscriber<? super T> coreSubscriber, long j10) {
            this.actual = coreSubscriber;
            this.f10688n = j10;
            this.remaining = j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10689s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
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
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.remaining;
            if (j10 == 0) {
                this.f10689s.cancel();
                onComplete();
                return;
            }
            long j11 = j10 - 1;
            this.remaining = j11;
            boolean z10 = j11 == 0;
            this.actual.onNext(t10);
            if (z10) {
                this.f10689s.cancel();
                onComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10689s, eVar)) {
                if (this.f10688n != 0) {
                    this.f10689s = eVar;
                    this.actual.onSubscribe(this);
                } else {
                    eVar.cancel();
                    this.done = true;
                    Operators.complete(this.actual);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (this.wip != 0 || !WIP.compareAndSet(this, 0, 1)) {
                this.f10689s.request(j10);
                return;
            }
            long j11 = this.f10688n;
            qd.e eVar = this.f10689s;
            if (j10 >= j11) {
                eVar.request(Long.MAX_VALUE);
            } else {
                eVar.request(j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f10689s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxTake(Flux<? extends T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.f10684n = j10;
        } else {
            g5.f.s(k0.a.m("n >= 0 required but it was ", j10));
            throw null;
        }
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
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new TakeConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.f10684n) : new TakeSubscriber(coreSubscriber, this.f10684n);
    }
}
