package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxBufferWhen<T, OPEN, CLOSE, BUFFER extends Collection<? super T>> extends InternalFluxOperator<T, BUFFER> {
    final Supplier<BUFFER> bufferSupplier;
    final Function<? super OPEN, ? extends qd.c> end;
    final Supplier<? extends Queue<BUFFER>> queueSupplier;
    final qd.c start;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferWhenCloseSubscriber<T, BUFFER extends Collection<? super T>> implements Disposable, InnerConsumer<Object> {
        static final AtomicReferenceFieldUpdater<BufferWhenCloseSubscriber, qd.e> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(BufferWhenCloseSubscriber.class, qd.e.class, "subscription");
        final long index;
        final BufferWhenMainSubscriber<T, ?, ?, BUFFER> parent;
        volatile qd.e subscription;

        public BufferWhenCloseSubscriber(BufferWhenMainSubscriber<T, ?, ?, BUFFER> bufferWhenMainSubscriber, long j10) {
            this.parent = bufferWhenMainSubscriber;
            this.index = j10;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.subscription == Operators.cancelledSubscription();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.subscription != Operators.cancelledSubscription()) {
                SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
                this.parent.close(this, this.index);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.subscription == Operators.cancelledSubscription()) {
                Operators.onErrorDropped(th, this.parent.ctx);
            } else {
                SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
                this.parent.boundaryError(this, th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
            qd.e eVar = this.subscription;
            if (eVar != Operators.cancelledSubscription()) {
                SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
                eVar.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, eVar)) {
                this.subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.subscription;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.MAX_VALUE;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferWhenMainSubscriber<T, OPEN, CLOSE, BUFFER extends Collection<? super T>> implements InnerOperator<T, BUFFER> {
        final CoreSubscriber<? super BUFFER> actual;
        final Function<? super OPEN, ? extends qd.c> bufferClose;
        final qd.c bufferOpen;
        final Supplier<BUFFER> bufferSupplier;
        volatile boolean cancelled;
        final Context ctx;
        volatile boolean done;
        long emitted;
        volatile Throwable errors;
        long index;
        final Queue<BUFFER> queue;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10592s;
        volatile int windows;
        static final AtomicLongFieldUpdater<BufferWhenMainSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<BufferWhenMainSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, qd.e.class, "s");
        static final AtomicReferenceFieldUpdater<BufferWhenMainSubscriber, Throwable> ERRORS = AtomicReferenceFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, Throwable.class, "errors");
        static final AtomicIntegerFieldUpdater<BufferWhenMainSubscriber> WINDOWS = AtomicIntegerFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, "windows");
        LinkedHashMap<Long, BUFFER> buffers = new LinkedHashMap<>();
        final Disposable.Composite subscribers = Disposables.composite();

        public BufferWhenMainSubscriber(CoreSubscriber<? super BUFFER> coreSubscriber, Supplier<BUFFER> supplier, Supplier<? extends Queue<BUFFER>> supplier2, qd.c cVar, Function<? super OPEN, ? extends qd.c> function) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.bufferOpen = cVar;
            this.bufferClose = function;
            this.bufferSupplier = supplier;
            this.queue = supplier2.get();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super BUFFER> actual() {
            return this.actual;
        }

        public void boundaryError(Disposable disposable, Throwable th) {
            LinkedHashMap<Long, BUFFER> linkedHashMap;
            Operators.terminate(S, this);
            this.subscribers.remove(disposable);
            if (!Exceptions.addThrowable(ERRORS, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.subscribers.dispose();
            synchronized (this) {
                linkedHashMap = this.buffers;
                this.buffers = null;
            }
            this.done = true;
            drain();
            if (linkedHashMap != null) {
                Iterator<BUFFER> it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    Operators.onDiscardMultiple(it.next(), this.ctx);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            LinkedHashMap<Long, BUFFER> linkedHashMap;
            if (Operators.terminate(S, this)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    linkedHashMap = this.buffers;
                    this.buffers = null;
                }
                if (WINDOWS.getAndIncrement(this) == 0) {
                    Operators.onDiscardQueueWithClear(this.queue, this.ctx, new a(15));
                }
                if (linkedHashMap == null || linkedHashMap.isEmpty()) {
                    return;
                }
                Iterator<BUFFER> it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    Operators.onDiscardMultiple(it.next(), this.ctx);
                }
            }
        }

        public void close(BufferWhenCloseSubscriber<T, BUFFER> bufferWhenCloseSubscriber, long j10) {
            boolean z10;
            this.subscribers.remove(bufferWhenCloseSubscriber);
            if (this.subscribers.size() == 0) {
                Operators.terminate(S, this);
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (this) {
                try {
                    LinkedHashMap<Long, BUFFER> linkedHashMap = this.buffers;
                    if (linkedHashMap == null) {
                        return;
                    }
                    this.queue.offer(linkedHashMap.remove(Long.valueOf(j10)));
                    if (z10) {
                        this.done = true;
                    }
                    drain();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void drain() {
            if (WINDOWS.getAndIncrement(this) != 0) {
                return;
            }
            long j10 = this.emitted;
            CoreSubscriber<? super BUFFER> coreSubscriber = this.actual;
            Queue<BUFFER> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j11 = this.requested;
                while (j10 != j11) {
                    if (this.cancelled) {
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new a(15));
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && this.errors != null) {
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new a(15));
                        coreSubscriber.onError(Exceptions.terminate(ERRORS, this));
                        return;
                    }
                    BUFFER bufferPoll = queue.poll();
                    boolean z11 = bufferPoll == null;
                    if (z10 && z11) {
                        coreSubscriber.onComplete();
                        return;
                    } else {
                        if (z11) {
                            break;
                        }
                        coreSubscriber.onNext(bufferPoll);
                        j10++;
                    }
                }
                if (j10 == j11) {
                    if (this.cancelled) {
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new a(15));
                        return;
                    }
                    if (this.done) {
                        if (this.errors != null) {
                            Operators.onDiscardQueueWithClear(queue, this.ctx, new a(15));
                            coreSubscriber.onError(Exceptions.terminate(ERRORS, this));
                            return;
                        } else if (queue.isEmpty()) {
                            coreSubscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j10;
                iAddAndGet = WINDOWS.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                try {
                    LinkedHashMap<Long, BUFFER> linkedHashMap = this.buffers;
                    if (linkedHashMap == null) {
                        return;
                    }
                    Iterator<BUFFER> it = linkedHashMap.values().iterator();
                    while (it.hasNext()) {
                        this.queue.offer(it.next());
                    }
                    this.buffers = null;
                    this.done = true;
                    drain();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            LinkedHashMap<Long, BUFFER> linkedHashMap;
            if (!Exceptions.addThrowable(ERRORS, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.subscribers.dispose();
            synchronized (this) {
                linkedHashMap = this.buffers;
                this.buffers = null;
            }
            this.done = true;
            drain();
            if (linkedHashMap != null) {
                Iterator<BUFFER> it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    Operators.onDiscardMultiple(it.next(), this.ctx);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            synchronized (this) {
                try {
                    LinkedHashMap<Long, BUFFER> linkedHashMap = this.buffers;
                    if (linkedHashMap == null) {
                        return;
                    }
                    if (linkedHashMap.isEmpty()) {
                        Operators.onDiscard(t10, this.ctx);
                        return;
                    }
                    Iterator<BUFFER> it = linkedHashMap.values().iterator();
                    while (it.hasNext()) {
                        it.next().add(t10);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void open(OPEN open) {
            try {
                BUFFER buffer = this.bufferSupplier.get();
                Objects.requireNonNull(buffer, "The bufferSupplier returned a null Collection");
                BUFFER buffer2 = buffer;
                qd.c cVarApply = this.bufferClose.apply(open);
                Objects.requireNonNull(cVarApply, "The bufferClose returned a null Publisher");
                qd.c cVar = cVarApply;
                long j10 = this.index;
                this.index = 1 + j10;
                synchronized (this) {
                    try {
                        LinkedHashMap<Long, BUFFER> linkedHashMap = this.buffers;
                        if (linkedHashMap == null) {
                            return;
                        }
                        linkedHashMap.put(Long.valueOf(j10), buffer2);
                        BufferWhenCloseSubscriber bufferWhenCloseSubscriber = new BufferWhenCloseSubscriber(this, j10);
                        this.subscribers.add(bufferWhenCloseSubscriber);
                        Operators.toFluxOrMono(cVar).subscribe((qd.d) bufferWhenCloseSubscriber);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                Operators.terminate(S, this);
                if (!Exceptions.addThrowable(ERRORS, this, th2)) {
                    Operators.onErrorDropped(th2, this.ctx);
                    return;
                }
                this.subscribers.dispose();
                synchronized (this) {
                    LinkedHashMap<Long, BUFFER> linkedHashMap2 = this.buffers;
                    this.buffers = null;
                    this.done = true;
                    drain();
                    if (linkedHashMap2 != null) {
                        Iterator<BUFFER> it = linkedHashMap2.values().iterator();
                        while (it.hasNext()) {
                            Operators.onDiscardMultiple(it.next(), this.ctx);
                        }
                    }
                }
            }
        }

        public void openComplete(BufferWhenOpenSubscriber<OPEN> bufferWhenOpenSubscriber) {
            this.subscribers.remove(bufferWhenOpenSubscriber);
            if (this.subscribers.size() == 0) {
                Operators.terminate(S, this);
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            Operators.addCap(REQUESTED, this, j10);
            drain();
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10592s : attr == Scannable.Attr.ACTUAL ? this.actual : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(Reader.READ_DONE) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.buffers.values().stream().mapToInt(new g0()).sum()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.ERROR ? this.errors : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BufferWhenOpenSubscriber<OPEN> implements Disposable, InnerConsumer<OPEN> {
        static final AtomicReferenceFieldUpdater<BufferWhenOpenSubscriber, qd.e> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(BufferWhenOpenSubscriber.class, qd.e.class, "subscription");
        final BufferWhenMainSubscriber<?, OPEN, ?, ?> parent;
        volatile qd.e subscription;

        public BufferWhenOpenSubscriber(BufferWhenMainSubscriber<?, OPEN, ?, ?> bufferWhenMainSubscriber) {
            this.parent = bufferWhenMainSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.subscription == Operators.cancelledSubscription();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
            this.parent.openComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
            this.parent.boundaryError(this, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(OPEN open) {
            this.parent.open(open);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, eVar)) {
                this.subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.subscription;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.MAX_VALUE;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxBufferWhen(Flux<? extends T> flux, qd.c cVar, Function<? super OPEN, ? extends qd.c> function, Supplier<BUFFER> supplier, Supplier<? extends Queue<BUFFER>> supplier2) {
        super(flux);
        Objects.requireNonNull(cVar, "start");
        this.start = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "end");
        this.end = function;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
        Objects.requireNonNull(supplier2, "queueSupplier");
        this.queueSupplier = supplier2;
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super BUFFER> coreSubscriber) {
        BufferWhenMainSubscriber bufferWhenMainSubscriber = new BufferWhenMainSubscriber(coreSubscriber, this.bufferSupplier, this.queueSupplier, this.start, this.end);
        coreSubscriber.onSubscribe(bufferWhenMainSubscriber);
        BufferWhenOpenSubscriber bufferWhenOpenSubscriber = new BufferWhenOpenSubscriber(bufferWhenMainSubscriber);
        if (!bufferWhenMainSubscriber.subscribers.add(bufferWhenOpenSubscriber)) {
            return null;
        }
        this.start.subscribe(bufferWhenOpenSubscriber);
        return bufferWhenMainSubscriber;
    }
}
