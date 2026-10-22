package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiPredicate;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoSequenceEqual<T> extends Mono<Boolean> implements SourceProducer<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final qd.c first;
    final int prefetch;
    final qd.c second;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class EqualSubscriber<T> implements InnerConsumer<T> {
        static final AtomicReferenceFieldUpdater<EqualSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(EqualSubscriber.class, qd.e.class, "subscription");
        qd.e cachedSubscription;
        volatile boolean done;
        Throwable error;
        final EqualCoordinator<T> parent;
        final int prefetch;
        final Queue<T> queue;
        volatile qd.e subscription;

        public EqualSubscriber(EqualCoordinator<T> equalCoordinator, int i) {
            this.parent = equalCoordinator;
            this.prefetch = i;
            this.queue = (Queue) Queues.get(i).get();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.queue.offer(t10)) {
                this.parent.drain();
            } else {
                onError(Operators.onOperatorError(this.cachedSubscription, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                this.cachedSubscription = eVar;
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.subscription == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.subscription;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue.size());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public MonoSequenceEqual(qd.c cVar, qd.c cVar2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        Objects.requireNonNull(cVar, "first");
        this.first = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(cVar2, "second");
        this.second = Operators.toFluxOrMono(cVar2);
        Objects.requireNonNull(biPredicate, "comparer");
        this.comparer = biPredicate;
        if (i >= 1) {
            this.prefetch = i;
        } else {
            g5.f.s(k0.a.j(i, "Buffer size must be strictly positive: "));
            throw null;
        }
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Boolean> coreSubscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(coreSubscriber, this.prefetch, this.first, this.second, this.comparer);
        coreSubscriber.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class EqualCoordinator<T> implements InnerProducer<Boolean> {
        static final AtomicIntegerFieldUpdater<EqualCoordinator> ONCE = AtomicIntegerFieldUpdater.newUpdater(EqualCoordinator.class, "once");
        static final AtomicIntegerFieldUpdater<EqualCoordinator> WIP = AtomicIntegerFieldUpdater.newUpdater(EqualCoordinator.class, "wip");
        final CoreSubscriber<? super Boolean> actual;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final qd.c first;
        final EqualSubscriber<T> firstSubscriber;
        volatile int once;
        final qd.c second;
        final EqualSubscriber<T> secondSubscriber;

        /* renamed from: v1, reason: collision with root package name */
        T f10735v1;

        /* renamed from: v2, reason: collision with root package name */
        T f10736v2;
        volatile int wip;

        public EqualCoordinator(CoreSubscriber<? super Boolean> coreSubscriber, int i, qd.c cVar, qd.c cVar2, BiPredicate<? super T, ? super T> biPredicate) {
            this.actual = coreSubscriber;
            this.first = cVar;
            this.second = cVar2;
            this.comparer = biPredicate;
            this.firstSubscriber = new EqualSubscriber<>(this, i);
            this.secondSubscriber = new EqualSubscriber<>(this, i);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Boolean> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelInner(this.firstSubscriber);
            cancelInner(this.secondSubscriber);
            if (WIP.getAndIncrement(this) == 0) {
                this.firstSubscriber.queue.clear();
                this.secondSubscriber.queue.clear();
            }
        }

        public void cancelInner(EqualSubscriber<T> equalSubscriber) {
            qd.e andSet;
            if (equalSubscriber.subscription == Operators.cancelledSubscription() || (andSet = EqualSubscriber.S.getAndSet(equalSubscriber, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        public void drain() {
            Throwable th;
            Throwable th2;
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            EqualSubscriber<T> equalSubscriber = this.firstSubscriber;
            Queue<T> queue = equalSubscriber.queue;
            EqualSubscriber<T> equalSubscriber2 = this.secondSubscriber;
            Queue<T> queue2 = equalSubscriber2.queue;
            int iAddAndGet = 1;
            do {
                long j10 = 0;
                while (!this.cancelled) {
                    boolean z10 = equalSubscriber.done;
                    if (z10 && (th2 = equalSubscriber.error) != null) {
                        cancel(equalSubscriber, queue, equalSubscriber2, queue2);
                        this.actual.onError(th2);
                        return;
                    }
                    boolean z11 = equalSubscriber2.done;
                    if (z11 && (th = equalSubscriber2.error) != null) {
                        cancel(equalSubscriber, queue, equalSubscriber2, queue2);
                        this.actual.onError(th);
                        return;
                    }
                    if (this.f10735v1 == null) {
                        this.f10735v1 = queue.poll();
                    }
                    boolean z12 = this.f10735v1 == null;
                    if (this.f10736v2 == null) {
                        this.f10736v2 = queue2.poll();
                    }
                    T t10 = this.f10736v2;
                    boolean z13 = t10 == null;
                    if (z10 && z11 && z12 && z13) {
                        this.actual.onNext(Boolean.TRUE);
                        this.actual.onComplete();
                        return;
                    }
                    if (z10 && z11 && z12 != z13) {
                        cancel(equalSubscriber, queue, equalSubscriber2, queue2);
                        this.actual.onNext(Boolean.FALSE);
                        this.actual.onComplete();
                        return;
                    }
                    if (!z12 && !z13) {
                        try {
                            if (!this.comparer.test(this.f10735v1, t10)) {
                                cancel(equalSubscriber, queue, equalSubscriber2, queue2);
                                this.actual.onNext(Boolean.FALSE);
                                this.actual.onComplete();
                                return;
                            } else {
                                j10++;
                                this.f10735v1 = null;
                                this.f10736v2 = null;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            cancel(equalSubscriber, queue, equalSubscriber2, queue2);
                            CoreSubscriber<? super Boolean> coreSubscriber = this.actual;
                            coreSubscriber.onError(Operators.onOperatorError(th3, coreSubscriber.currentContext()));
                            return;
                        }
                    }
                    if (z12 || z13) {
                        if (j10 != 0) {
                            equalSubscriber.cachedSubscription.request(j10);
                            equalSubscriber2.cachedSubscription.request(j10);
                        }
                        iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    }
                }
                queue.clear();
                queue2.clear();
                return;
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) new EqualSubscriber[]{this.firstSubscriber, this.secondSubscriber});
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10) && ONCE.compareAndSet(this, 0, 1)) {
                this.first.subscribe(this.firstSubscriber);
                this.second.subscribe(this.secondSubscriber);
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void subscribe() {
            if (ONCE.compareAndSet(this, 0, 1)) {
                this.first.subscribe(this.firstSubscriber);
                this.second.subscribe(this.secondSubscriber);
            }
        }

        public void cancel(EqualSubscriber<T> equalSubscriber, Queue<T> queue, EqualSubscriber<T> equalSubscriber2, Queue<T> queue2) {
            this.cancelled = true;
            cancelInner(equalSubscriber);
            queue.clear();
            cancelInner(equalSubscriber2);
            queue2.clear();
        }
    }
}
