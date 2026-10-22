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

/* loaded from: classes4.dex */
final class MonoSequenceEqual<T> extends Mono<Boolean> implements SourceProducer<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Z9.c first;
    final int prefetch;
    final Z9.c second;

    public static final class EqualSubscriber<T> implements InnerConsumer<T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<EqualSubscriber, Z9.e> f5863S = AtomicReferenceFieldUpdater.newUpdater(EqualSubscriber.class, Z9.e.class, "subscription");
        Z9.e cachedSubscription;
        volatile boolean done;
        Throwable error;
        final EqualCoordinator<T> parent;
        final int prefetch;
        final Queue<T> queue;
        volatile Z9.e subscription;

        public EqualSubscriber(EqualCoordinator<T> equalCoordinator, int i) {
            this.parent = equalCoordinator;
            this.prefetch = i;
            this.queue = (Queue) Queues.get(i).get();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.queue.offer(t9)) {
                this.parent.drain();
            } else {
                onError(Operators.onOperatorError(this.cachedSubscription, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5863S, this, eVar)) {
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

    public MonoSequenceEqual(Z9.c cVar, Z9.c cVar2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        Objects.requireNonNull(cVar, "first");
        this.first = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(cVar2, "second");
        this.second = Operators.toFluxOrMono(cVar2);
        Objects.requireNonNull(biPredicate, "comparer");
        this.comparer = biPredicate;
        if (i < 1) {
            throw new IllegalArgumentException(B7.a.h(i, "Buffer size must be strictly positive: "));
        }
        this.prefetch = i;
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

    public static final class EqualCoordinator<T> implements InnerProducer<Boolean> {
        static final AtomicIntegerFieldUpdater<EqualCoordinator> ONCE = AtomicIntegerFieldUpdater.newUpdater(EqualCoordinator.class, "once");
        static final AtomicIntegerFieldUpdater<EqualCoordinator> WIP = AtomicIntegerFieldUpdater.newUpdater(EqualCoordinator.class, "wip");
        final CoreSubscriber<? super Boolean> actual;
        volatile boolean cancelled;
        final BiPredicate<? super T, ? super T> comparer;
        final Z9.c first;
        final EqualSubscriber<T> firstSubscriber;
        volatile int once;
        final Z9.c second;
        final EqualSubscriber<T> secondSubscriber;

        /* renamed from: v1, reason: collision with root package name */
        T f5861v1;

        /* renamed from: v2, reason: collision with root package name */
        T f5862v2;
        volatile int wip;

        public EqualCoordinator(CoreSubscriber<? super Boolean> coreSubscriber, int i, Z9.c cVar, Z9.c cVar2, BiPredicate<? super T, ? super T> biPredicate) {
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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
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
            Z9.e andSet;
            if (equalSubscriber.subscription == Operators.cancelledSubscription() || (andSet = EqualSubscriber.f5863S.getAndSet(equalSubscriber, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
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
                long j5 = 0;
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
                    if (this.f5861v1 == null) {
                        this.f5861v1 = queue.poll();
                    }
                    boolean z12 = this.f5861v1 == null;
                    if (this.f5862v2 == null) {
                        this.f5862v2 = queue2.poll();
                    }
                    T t9 = this.f5862v2;
                    boolean z13 = t9 == null;
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
                            if (!this.comparer.test(this.f5861v1, t9)) {
                                cancel(equalSubscriber, queue, equalSubscriber2, queue2);
                                this.actual.onNext(Boolean.FALSE);
                                this.actual.onComplete();
                                return;
                            } else {
                                j5++;
                                this.f5861v1 = null;
                                this.f5862v2 = null;
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
                        if (j5 != 0) {
                            equalSubscriber.cachedSubscription.request(j5);
                            equalSubscriber2.cachedSubscription.request(j5);
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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5) && ONCE.compareAndSet(this, 0, 1)) {
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
