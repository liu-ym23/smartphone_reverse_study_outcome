package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxArray<T> extends Flux<T> implements Fuseable, SourceProducer<T> {
    final T[] array;

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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
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
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t9 = tArr[i];
                if (t9 == null) {
                    conditionalSubscriber.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i, "The ", "th array element was null")));
                    return;
                }
                conditionalSubscriber.onNext(t9);
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
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
            T t9 = tArr[i];
            Objects.requireNonNull(t9, "Array returned null value");
            this.index = i + 1;
            return t9;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5) && Operators.addCap(REQUESTED, this, j5) == 0) {
                if (j5 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j5);
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

        public void slowPath(long j5) {
            T[] tArr = this.array;
            int length = tArr.length;
            Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            int i = this.index;
            do {
                int i6 = 0;
                while (!this.cancelled) {
                    while (i != length && i6 != j5) {
                        T t9 = tArr[i];
                        if (t9 == null) {
                            conditionalSubscriber.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i, "The ", "th array element was null")));
                            return;
                        }
                        boolean zTryOnNext = conditionalSubscriber.tryOnNext(t9);
                        if (this.cancelled) {
                            return;
                        }
                        i++;
                        if (zTryOnNext) {
                            i6++;
                        }
                    }
                    if (i == length) {
                        conditionalSubscriber.onComplete();
                        return;
                    }
                    j5 = this.requested;
                    if (j5 == i6) {
                        this.index = i;
                        j5 = REQUESTED.addAndGet(this, -i6);
                    }
                }
                return;
            } while (j5 != 0);
        }
    }

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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
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
            for (int i = this.index; i != length; i++) {
                if (this.cancelled) {
                    return;
                }
                T t9 = tArr[i];
                if (t9 == null) {
                    coreSubscriber.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i, "The ", "th array element was null")));
                    return;
                }
                coreSubscriber.onNext(t9);
            }
            if (this.cancelled) {
                return;
            }
            coreSubscriber.onComplete();
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
            T t9 = tArr[i];
            Objects.requireNonNull(t9);
            this.index = i + 1;
            return t9;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5) && Operators.addCap(REQUESTED, this, j5) == 0) {
                if (j5 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j5);
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

        public void slowPath(long j5) {
            T[] tArr = this.array;
            int length = tArr.length;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            int i = this.index;
            do {
                int i6 = 0;
                while (!this.cancelled) {
                    while (i != length && i6 != j5) {
                        T t9 = tArr[i];
                        if (t9 == null) {
                            coreSubscriber.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i, "The ", "th array element was null")));
                            return;
                        }
                        coreSubscriber.onNext(t9);
                        if (this.cancelled) {
                            return;
                        }
                        i++;
                        i6++;
                    }
                    if (i == length) {
                        coreSubscriber.onComplete();
                        return;
                    }
                    j5 = this.requested;
                    if (j5 == i6) {
                        this.index = i;
                        j5 = REQUESTED.addAndGet(this, -i6);
                    }
                }
                return;
            } while (j5 != 0);
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
