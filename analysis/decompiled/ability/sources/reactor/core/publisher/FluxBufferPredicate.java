package reactor.core.publisher;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxBufferPredicate<T, C extends Collection<? super T>> extends InternalFluxOperator<T, C> {
    final Supplier<C> bufferSupplier;
    final Mode mode;
    final Predicate<? super T> predicate;

    public static final class BufferPredicateSubscriber<T, C extends Collection<? super T>> extends AbstractQueue<C> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, C>, BooleanSupplier {
        static final AtomicLongFieldUpdater<BufferPredicateSubscriber> REQUESTED_BUFFERS = AtomicLongFieldUpdater.newUpdater(BufferPredicateSubscriber.class, "requestedBuffers");
        static final AtomicLongFieldUpdater<BufferPredicateSubscriber> REQUESTED_FROM_SOURCE = AtomicLongFieldUpdater.newUpdater(BufferPredicateSubscriber.class, "requestedFromSource");

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<BufferPredicateSubscriber, Z9.e> f5706S = AtomicReferenceFieldUpdater.newUpdater(BufferPredicateSubscriber.class, Z9.e.class, "s");
        final CoreSubscriber<? super C> actual;

        @Nullable
        C buffer;
        final Supplier<C> bufferSupplier;
        boolean done;
        volatile boolean fastpath;
        final Mode mode;
        final Predicate<? super T> predicate;
        volatile long requestedBuffers;
        volatile long requestedFromSource;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5707s;

        public BufferPredicateSubscriber(CoreSubscriber<? super C> coreSubscriber, C c, Supplier<C> supplier, Predicate<? super T> predicate, Mode mode) {
            this.actual = coreSubscriber;
            this.buffer = c;
            this.bufferSupplier = supplier;
            this.predicate = predicate;
            this.mode = mode;
        }

        private void onNextNewBuffer() {
            Collection collectionTriggerNewBuffer = triggerNewBuffer();
            if (collectionTriggerNewBuffer != null) {
                if (this.fastpath) {
                    this.actual.onNext(collectionTriggerNewBuffer);
                } else if (REQUESTED_BUFFERS.getAndDecrement(this) > 0) {
                    this.actual.onNext(collectionTriggerNewBuffer);
                } else {
                    cancel();
                    this.actual.onError(Exceptions.failWithOverflow("Could not emit buffer due to lack of requests"));
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super C> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            synchronized (this) {
                C c = this.buffer;
                this.buffer = null;
                Operators.onDiscardMultiple(c, this.actual.currentContext());
            }
            cleanup();
            Operators.terminate(f5706S, this);
        }

        public boolean cancelledWhileAdding(T t9) {
            synchronized (this) {
                try {
                    C c = this.buffer;
                    if (c != null && this.f5707s != Operators.cancelledSubscription()) {
                        c.add(t9);
                        return false;
                    }
                    Operators.onDiscard(t9, this.actual.currentContext());
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void cleanup() {
            Predicate<? super T> predicate = this.predicate;
            if (predicate instanceof Disposable) {
                ((Disposable) predicate).dispose();
            }
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            return this.f5707s == Operators.cancelledSubscription();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<C> iterator() {
            return isEmpty() ? Collections.emptyIterator() : Collections.singleton(this.buffer).iterator();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cleanup();
            DrainUtils.postComplete(this.actual, this, REQUESTED_BUFFERS, this, this);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            C c;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                c = this.buffer;
                this.buffer = null;
            }
            cleanup();
            Operators.onDiscardMultiple(c, this.actual.currentContext());
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (tryOnNext(t9)) {
                return;
            }
            this.f5707s.request(1L);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5706S, this, eVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                if (j5 == Long.MAX_VALUE) {
                    this.fastpath = true;
                    REQUESTED_BUFFERS.set(this, Long.MAX_VALUE);
                    REQUESTED_FROM_SOURCE.set(this, Long.MAX_VALUE);
                    this.f5707s.request(Long.MAX_VALUE);
                    return;
                }
                if (DrainUtils.postCompleteRequest(j5, this.actual, this, REQUESTED_BUFFERS, this, this)) {
                    return;
                }
                Operators.addCap(REQUESTED_FROM_SOURCE, this, j5);
                this.f5707s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5707s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(getAsBoolean());
            }
            if (attr != Scannable.Attr.CAPACITY) {
                return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requestedBuffers) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            C c = this.buffer;
            return Integer.valueOf(c != null ? c.size() : 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            C c = this.buffer;
            return (c == null || c.isEmpty()) ? 0 : 1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "FluxBufferPredicate";
        }

        @Nullable
        public C triggerNewBuffer() {
            synchronized (this) {
                C c = this.buffer;
                if (c != null && this.f5707s != Operators.cancelledSubscription()) {
                    if (c.isEmpty()) {
                        return null;
                    }
                    try {
                        C c2 = this.bufferSupplier.get();
                        Objects.requireNonNull(c2, "The bufferSupplier returned a null buffer");
                        C c5 = c2;
                        synchronized (this) {
                            try {
                                if (this.buffer == null) {
                                    return null;
                                }
                                this.buffer = c5;
                                return c;
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        onError(Operators.onOperatorError(this.f5707s, th, this.actual.currentContext()));
                        return null;
                    }
                }
                return null;
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return true;
            }
            try {
                boolean zTest = this.predicate.test(t9);
                Mode mode = this.mode;
                if (mode == Mode.UNTIL && zTest) {
                    if (cancelledWhileAdding(t9)) {
                        return true;
                    }
                    onNextNewBuffer();
                } else if (mode == Mode.UNTIL_CUT_BEFORE && zTest) {
                    onNextNewBuffer();
                    if (cancelledWhileAdding(t9)) {
                        return true;
                    }
                } else if (mode == Mode.WHILE && !zTest) {
                    onNextNewBuffer();
                } else if (cancelledWhileAdding(t9)) {
                    return true;
                }
                if (this.fastpath) {
                    return true;
                }
                AtomicLongFieldUpdater<BufferPredicateSubscriber> atomicLongFieldUpdater = REQUESTED_FROM_SOURCE;
                return (((atomicLongFieldUpdater.decrementAndGet(this) > 0L ? 1 : (atomicLongFieldUpdater.decrementAndGet(this) == 0L ? 0 : -1)) == 0) && ((REQUESTED_BUFFERS.get(this) > 0L ? 1 : (REQUESTED_BUFFERS.get(this) == 0L ? 0 : -1)) > 0) && atomicLongFieldUpdater.compareAndSet(this, 0L, 1L)) ? false : true;
            } catch (Throwable th) {
                Context contextCurrentContext = this.actual.currentContext();
                onError(Operators.onOperatorError(this.f5707s, th, t9, contextCurrentContext));
                Operators.onDiscard(t9, contextCurrentContext);
                return true;
            }
        }

        @Override // java.util.Queue
        public boolean offer(C c) {
            throw new IllegalArgumentException();
        }

        @Override // java.util.Queue
        @Nullable
        public C peek() {
            return this.buffer;
        }

        @Override // java.util.Queue
        @Nullable
        public C poll() {
            C c = this.buffer;
            if (c == null || c.isEmpty()) {
                return null;
            }
            synchronized (this) {
                this.buffer = null;
            }
            return c;
        }
    }

    public static class ChangedPredicate<T, K> implements Predicate<T>, Disposable {
        private BiPredicate<? super K, ? super K> keyComparator;
        private Function<? super T, ? extends K> keySelector;
        private K lastKey;

        public ChangedPredicate(Function<? super T, ? extends K> function, BiPredicate<? super K, ? super K> biPredicate) {
            this.keySelector = function;
            this.keyComparator = biPredicate;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            this.lastKey = null;
        }

        @Override // java.util.function.Predicate
        public boolean test(T t9) {
            K kApply = this.keySelector.apply(t9);
            K k = this.lastKey;
            if (k == null) {
                this.lastKey = kApply;
                return false;
            }
            boolean zTest = this.keyComparator.test(k, kApply);
            this.lastKey = kApply;
            return !zTest;
        }
    }

    public enum Mode {
        UNTIL,
        UNTIL_CUT_BEFORE,
        WHILE
    }

    public FluxBufferPredicate(Flux<? extends T> flux, Predicate<? super T> predicate, Supplier<C> supplier, Mode mode) {
        super(flux);
        Objects.requireNonNull(predicate, "predicate");
        this.predicate = predicate;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
        this.mode = mode;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return 1;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super C> coreSubscriber) {
        C c = this.bufferSupplier.get();
        Objects.requireNonNull(c, "The bufferSupplier returned a null initial buffer");
        return new BufferPredicateSubscriber(coreSubscriber, c, this.bufferSupplier, this.predicate, this.mode);
    }
}
