package reactor.core.publisher;

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

/* loaded from: classes5.dex */
final class FluxBufferWhen<T, OPEN, CLOSE, BUFFER extends Collection<? super T>> extends InternalFluxOperator<T, BUFFER> {
    final Supplier<BUFFER> bufferSupplier;
    final Function<? super OPEN, ? extends qc.b<CLOSE>> end;
    final Supplier<? extends Queue<BUFFER>> queueSupplier;
    final qc.b<OPEN> start;

    public static final class BufferWhenCloseSubscriber<T, BUFFER extends Collection<? super T>> implements Disposable, InnerConsumer<Object> {
        static final AtomicReferenceFieldUpdater<BufferWhenCloseSubscriber, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(BufferWhenCloseSubscriber.class, qc.d.class, "subscription");
        final long index;
        final BufferWhenMainSubscriber<T, ?, ?, BUFFER> parent;
        volatile qc.d subscription;

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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.subscription != Operators.cancelledSubscription()) {
                SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
                this.parent.close(this, this.index);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.subscription == Operators.cancelledSubscription()) {
                Operators.onErrorDropped(th, this.parent.ctx);
            } else {
                SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
                this.parent.boundaryError(this, th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
            qc.d dVar = this.subscription;
            if (dVar != Operators.cancelledSubscription()) {
                SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
                dVar.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
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

    public static final class BufferWhenMainSubscriber<T, OPEN, CLOSE, BUFFER extends Collection<? super T>> implements InnerOperator<T, BUFFER> {
        final CoreSubscriber<? super BUFFER> actual;
        final Function<? super OPEN, ? extends qc.b<? extends CLOSE>> bufferClose;
        final qc.b<? extends OPEN> bufferOpen;
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
        volatile qc.d f39479s;
        volatile int windows;
        static final AtomicLongFieldUpdater<BufferWhenMainSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, "requested");

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<BufferWhenMainSubscriber, qc.d> f39478S = AtomicReferenceFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, qc.d.class, "s");
        static final AtomicReferenceFieldUpdater<BufferWhenMainSubscriber, Throwable> ERRORS = AtomicReferenceFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, Throwable.class, "errors");
        static final AtomicIntegerFieldUpdater<BufferWhenMainSubscriber> WINDOWS = AtomicIntegerFieldUpdater.newUpdater(BufferWhenMainSubscriber.class, "windows");
        LinkedHashMap<Long, BUFFER> buffers = new LinkedHashMap<>();
        final Disposable.Composite subscribers = Disposables.composite();

        public BufferWhenMainSubscriber(CoreSubscriber<? super BUFFER> coreSubscriber, Supplier<BUFFER> supplier, Supplier<? extends Queue<BUFFER>> supplier2, qc.b<? extends OPEN> bVar, Function<? super OPEN, ? extends qc.b<? extends CLOSE>> function) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.bufferOpen = bVar;
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
            Operators.terminate(f39478S, this);
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            LinkedHashMap<Long, BUFFER> linkedHashMap;
            if (Operators.terminate(f39478S, this)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    linkedHashMap = this.buffers;
                    this.buffers = null;
                }
                if (WINDOWS.getAndIncrement(this) == 0) {
                    Operators.onDiscardQueueWithClear(this.queue, this.ctx, new C5408z0());
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
                Operators.terminate(f39478S, this);
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
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new C5408z0());
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && this.errors != null) {
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new C5408z0());
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
                        Operators.onDiscardQueueWithClear(queue, this.ctx, new C5408z0());
                        return;
                    }
                    if (this.done) {
                        if (this.errors != null) {
                            Operators.onDiscardQueueWithClear(queue, this.ctx, new C5408z0());
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39478S, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void open(OPEN open) {
            try {
                BUFFER buffer = this.bufferSupplier.get();
                Objects.requireNonNull(buffer, "The bufferSupplier returned a null Collection");
                BUFFER buffer2 = buffer;
                qc.b<? extends CLOSE> bVarApply = this.bufferClose.apply(open);
                Objects.requireNonNull(bVarApply, "The bufferClose returned a null Publisher");
                qc.b<? extends CLOSE> bVar = bVarApply;
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
                        Operators.toFluxOrMono(bVar).subscribe((qc.c) bufferWhenCloseSubscriber);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                Operators.terminate(f39478S, this);
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
                Operators.terminate(f39478S, this);
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            Operators.addCap(REQUESTED, this, j10);
            drain();
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39479s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.actual;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            return attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.buffers.values().stream().mapToInt(new C5382q0()).sum()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.ERROR ? this.errors : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class BufferWhenOpenSubscriber<OPEN> implements Disposable, InnerConsumer<OPEN> {
        static final AtomicReferenceFieldUpdater<BufferWhenOpenSubscriber, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(BufferWhenOpenSubscriber.class, qc.d.class, "subscription");
        final BufferWhenMainSubscriber<?, OPEN, ?, ?> parent;
        volatile qc.d subscription;

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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
            this.parent.openComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            SUBSCRIPTION.lazySet(this, Operators.cancelledSubscription());
            this.parent.boundaryError(this, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(OPEN open) {
            this.parent.open(open);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
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

    public FluxBufferWhen(Flux<? extends T> flux, qc.b<OPEN> bVar, Function<? super OPEN, ? extends qc.b<CLOSE>> function, Supplier<BUFFER> supplier, Supplier<? extends Queue<BUFFER>> supplier2) {
        super(flux);
        Objects.requireNonNull(bVar, "start");
        this.start = Operators.toFluxOrMono(bVar);
        Objects.requireNonNull(function, com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
        this.end = function;
        Objects.requireNonNull(supplier, "bufferSupplier");
        this.bufferSupplier = supplier;
        Objects.requireNonNull(supplier2, "queueSupplier");
        this.queueSupplier = supplier2;
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
