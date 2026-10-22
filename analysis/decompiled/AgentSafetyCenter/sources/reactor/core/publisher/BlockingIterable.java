package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class BlockingIterable<T> implements Iterable<T>, Scannable {
    final int batchSize;
    final Supplier<Context> contextSupplier;
    final Supplier<Queue<T>> queueSupplier;
    final CorePublisher<? extends T> source;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SubscriberIterator<T> implements InnerConsumer<T>, Iterator<T>, Runnable {
        static final AtomicReferenceFieldUpdater<SubscriberIterator, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(SubscriberIterator.class, qd.e.class, "s");
        final int batchSize;
        final Condition condition;
        final Context context;
        volatile boolean done;
        Throwable error;
        final int limit;
        final Lock lock;
        long produced;
        final Queue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10581s;

        public SubscriberIterator(Queue<T> queue, Context context, int i) {
            this.queue = queue;
            this.batchSize = i;
            this.limit = Operators.unboundedOrLimit(i);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
            this.context = context;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (Schedulers.isInNonBlockingThread()) {
                ad.o.n(Thread.currentThread().getName(), "Iterating over a toIterable() / toStream() is blocking, which is not supported in thread ");
                return false;
            }
            while (true) {
                boolean z10 = this.done;
                boolean zIsEmpty = this.queue.isEmpty();
                if (z10) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw Exceptions.propagate(th);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e10) {
                            run();
                            Thread.currentThread().interrupt();
                            throw Exceptions.propagate(e10);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                g5.f.k();
                return null;
            }
            T tPoll = this.queue.poll();
            if (tPoll == null) {
                run();
                od.f.e("Queue is empty: Expected one element to be available from the Reactive Streams source.");
                return null;
            }
            long j10 = this.produced + 1;
            if (j10 != this.limit) {
                this.produced = j10;
                return tPoll;
            }
            this.produced = 0L;
            this.f10581s.request(j10);
            return tPoll;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.queue.offer(t10)) {
                signalConsumer();
            } else {
                Operators.terminate(S, this);
                onError(Operators.onOperatorError(null, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Operators.unboundedOrPrefetch(this.batchSize));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Operators.terminate(S, this);
            signalConsumer();
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10581s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10581s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.batchSize);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        public void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public BlockingIterable(CorePublisher<? extends T> corePublisher, int i, Supplier<Queue<T>> supplier, Supplier<Context> supplier2) {
        this.contextSupplier = supplier2;
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "batchSize > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(corePublisher, "source");
        this.source = corePublisher;
        this.batchSize = i;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
    }

    public SubscriberIterator<T> createIterator() {
        try {
            Queue<T> queue = this.queueSupplier.get();
            Objects.requireNonNull(queue, "The queueSupplier returned a null queue");
            return new SubscriberIterator<>(queue, this.contextSupplier.get(), this.batchSize);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        SubscriberIterator<T> subscriberIteratorCreateIterator = createIterator();
        this.source.subscribe((CoreSubscriber<? super Object>) subscriberIteratorCreateIterator);
        return subscriberIteratorCreateIterator;
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(Math.min(Reader.READ_DONE, this.batchSize));
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Spliterator<T> spliterator() {
        return stream().spliterator();
    }

    public Stream<T> stream() {
        SubscriberIterator<T> subscriberIteratorCreateIterator = createIterator();
        this.source.subscribe((CoreSubscriber<? super Object>) subscriberIteratorCreateIterator);
        return (Stream) StreamSupport.stream(Spliterators.spliteratorUnknownSize(subscriberIteratorCreateIterator, 0), false).onClose(subscriberIteratorCreateIterator);
    }
}
