package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxArray<T> extends Flux<T> implements Fuseable, SourceProducer<T> {
    final T[] array;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ArrayConditionalSubscription<T> implements InnerProducer<T>, Fuseable.SynchronousSubscription<T> {
        static final AtomicLongFieldUpdater<ArrayConditionalSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(ArrayConditionalSubscription.class, "requested");
        final Fuseable.ConditionalSubscriber<? super T> actual;
        final T[] array;
        volatile boolean cancelled;
        int index;
        volatile long requested;

        public ArrayConditionalSubscription(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            this.actual = conditionalSubscriber;
            this.array = tArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.index = this.array.length;
        }

        public void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            int i = this.index;
            while (true) {
                boolean z10 = this.cancelled;
                if (i == length) {
                    if (z10) {
                        return;
                    }
                    conditionalSubscriber.onComplete();
                    return;
                } else {
                    if (z10) {
                        return;
                    }
                    T t10 = tArr[i];
                    if (t10 == null) {
                        conditionalSubscriber.onError(new NullPointerException(k0.a.k(i, "The ", "th array element was null")));
                        return;
                    } else {
                        conditionalSubscriber.onNext(t10);
                        i++;
                    }
                }
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            T t10 = tArr[i];
            Objects.requireNonNull(t10, "Array returned null value");
            this.index = i + 1;
            return t10;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10) && Operators.addCap(REQUESTED, this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j10);
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isEmpty()) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.array.length - this.index;
        }

        public void slowPath(long j10) {
            T[] tArr = this.array;
            int length = tArr.length;
            Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            int i = this.index;
            do {
                int i3 = 0;
                while (!this.cancelled) {
                    while (i != length && i3 != j10) {
                        T t10 = tArr[i];
                        if (t10 == null) {
                            conditionalSubscriber.onError(new NullPointerException(k0.a.k(i, "The ", "th array element was null")));
                            return;
                        }
                        boolean zTryOnNext = conditionalSubscriber.tryOnNext(t10);
                        if (this.cancelled) {
                            return;
                        }
                        i++;
                        if (zTryOnNext) {
                            i3++;
                        }
                    }
                    if (i == length) {
                        conditionalSubscriber.onComplete();
                        return;
                    }
                    j10 = this.requested;
                    if (j10 == i3) {
                        this.index = i;
                        j10 = REQUESTED.addAndGet(this, -i3);
                    }
                }
                return;
            } while (j10 != 0);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ArraySubscription<T> implements InnerProducer<T>, Fuseable.SynchronousSubscription<T> {
        static final AtomicLongFieldUpdater<ArraySubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(ArraySubscription.class, "requested");
        final CoreSubscriber<? super T> actual;
        final T[] array;
        volatile boolean cancelled;
        int index;
        volatile long requested;

        public ArraySubscription(CoreSubscriber<? super T> coreSubscriber, T[] tArr) {
            this.actual = coreSubscriber;
            this.array = tArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.index = this.array.length;
        }

        public void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            int i = this.index;
            while (true) {
                boolean z10 = this.cancelled;
                if (i == length) {
                    if (z10) {
                        return;
                    }
                    coreSubscriber.onComplete();
                    return;
                } else {
                    if (z10) {
                        return;
                    }
                    T t10 = tArr[i];
                    if (t10 == null) {
                        coreSubscriber.onError(new NullPointerException(k0.a.k(i, "The ", "th array element was null")));
                        return;
                    } else {
                        coreSubscriber.onNext(t10);
                        i++;
                    }
                }
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            T t10 = tArr[i];
            Objects.requireNonNull(t10);
            this.index = i + 1;
            return t10;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10) && Operators.addCap(REQUESTED, this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j10);
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isEmpty()) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.array.length - this.index;
        }

        public void slowPath(long j10) {
            T[] tArr = this.array;
            int length = tArr.length;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            int i = this.index;
            do {
                int i3 = 0;
                while (!this.cancelled) {
                    while (i != length && i3 != j10) {
                        T t10 = tArr[i];
                        if (t10 == null) {
                            coreSubscriber.onError(new NullPointerException(k0.a.k(i, "The ", "th array element was null")));
                            return;
                        }
                        coreSubscriber.onNext(t10);
                        if (this.cancelled) {
                            return;
                        }
                        i++;
                        i3++;
                    }
                    if (i == length) {
                        coreSubscriber.onComplete();
                        return;
                    }
                    j10 = this.requested;
                    if (j10 == i3) {
                        this.index = i;
                        j10 = REQUESTED.addAndGet(this, -i3);
                    }
                }
                return;
            } while (j10 != 0);
        }
    }

    @SafeVarargs
    public FluxArray(T... tArr) {
        Objects.requireNonNull(tArr, "array");
        this.array = tArr;
    }

    public static <T> void subscribe(CoreSubscriber<? super T> coreSubscriber, T[] tArr) {
        if (tArr.length == 0) {
            Operators.complete(coreSubscriber);
        } else if (coreSubscriber instanceof Fuseable.ConditionalSubscriber) {
            coreSubscriber.onSubscribe(new ArrayConditionalSubscription((Fuseable.ConditionalSubscriber) coreSubscriber, tArr));
        } else {
            coreSubscriber.onSubscribe(new ArraySubscription(coreSubscriber, tArr));
        }
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.array.length) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        subscribe(coreSubscriber, this.array);
    }
}
