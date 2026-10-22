package reactor.core.publisher;

import androidx.collection.SieveCacheKt;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxRange extends Flux<Integer> implements Fuseable, SourceProducer<Integer> {
    final long end;
    final long start;

    public static final class RangeSubscription implements InnerProducer<Integer>, Fuseable.SynchronousSubscription<Integer> {
        static final AtomicLongFieldUpdater<RangeSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(RangeSubscription.class, "requested");
        final CoreSubscriber<? super Integer> actual;
        volatile boolean cancelled;
        final long end;
        long index;
        volatile long requested;

        public RangeSubscription(CoreSubscriber<? super Integer> coreSubscriber, long j5, long j6) {
            this.actual = coreSubscriber;
            this.index = j5;
            this.end = j6;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Integer> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.index = this.end;
        }

        public void fastPath() {
            long j5 = this.end;
            CoreSubscriber<? super Integer> coreSubscriber = this.actual;
            for (long j6 = this.index; j6 != j5; j6++) {
                if (this.cancelled) {
                    return;
                }
                coreSubscriber.onNext(Integer.valueOf((int) j6));
            }
            if (this.cancelled) {
                return;
            }
            coreSubscriber.onComplete();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.index == this.end;
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
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isEmpty()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return (int) (this.end - this.index);
        }

        public void slowPath(long j5) {
            CoreSubscriber<? super Integer> coreSubscriber = this.actual;
            long j6 = this.end;
            long j10 = this.index;
            do {
                long j11 = 0;
                while (!this.cancelled) {
                    while (j11 != j5 && j10 != j6) {
                        coreSubscriber.onNext(Integer.valueOf((int) j10));
                        if (this.cancelled) {
                            return;
                        }
                        j11++;
                        j10++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    if (j10 == j6) {
                        coreSubscriber.onComplete();
                        return;
                    }
                    j5 = this.requested;
                    if (j5 == j11) {
                        this.index = j10;
                        j5 = REQUESTED.addAndGet(this, -j11);
                    }
                }
                return;
            } while (j5 != 0);
        }

        @Override // java.util.Queue
        @Nullable
        public Integer poll() {
            long j5 = this.index;
            if (j5 == this.end) {
                return null;
            }
            this.index = 1 + j5;
            return Integer.valueOf((int) j5);
        }
    }

    public static final class RangeSubscriptionConditional implements InnerProducer<Integer>, Fuseable.SynchronousSubscription<Integer> {
        static final AtomicLongFieldUpdater<RangeSubscriptionConditional> REQUESTED = AtomicLongFieldUpdater.newUpdater(RangeSubscriptionConditional.class, "requested");
        final Fuseable.ConditionalSubscriber<? super Integer> actual;
        volatile boolean cancelled;
        final long end;
        long index;
        volatile long requested;

        public RangeSubscriptionConditional(Fuseable.ConditionalSubscriber<? super Integer> conditionalSubscriber, long j5, long j6) {
            this.actual = conditionalSubscriber;
            this.index = j5;
            this.end = j6;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Integer> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.index = this.end;
        }

        public void fastPath() {
            long j5 = this.end;
            Fuseable.ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            for (long j6 = this.index; j6 != j5; j6++) {
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Integer.valueOf((int) j6));
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.index == this.end;
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
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isEmpty()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return (int) (this.end - this.index);
        }

        public void slowPath(long j5) {
            Fuseable.ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            long j6 = this.end;
            long j10 = this.index;
            do {
                long j11 = 0;
                while (!this.cancelled) {
                    while (j11 != j5 && j10 != j6) {
                        boolean zTryOnNext = conditionalSubscriber.tryOnNext(Integer.valueOf((int) j10));
                        if (this.cancelled) {
                            return;
                        }
                        if (zTryOnNext) {
                            j11++;
                        }
                        j10++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    if (j10 == j6) {
                        conditionalSubscriber.onComplete();
                        return;
                    }
                    j5 = this.requested;
                    if (j5 == j11) {
                        this.index = j10;
                        j5 = REQUESTED.addAndGet(this, -j11);
                    }
                }
                return;
            } while (j5 != 0);
        }

        @Override // java.util.Queue
        @Nullable
        public Integer poll() {
            long j5 = this.index;
            if (j5 == this.end) {
                return null;
            }
            this.index = 1 + j5;
            return Integer.valueOf((int) j5);
        }
    }

    public FluxRange(int i, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "count >= required but it was "));
        }
        long j5 = i;
        long j6 = i6 + j5;
        if (j6 - 1 > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException("start + count must be less than Integer.MAX_VALUE + 1");
        }
        this.start = j5;
        this.end = j6;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Integer> coreSubscriber) {
        long j5 = this.start;
        long j6 = this.end;
        if (j5 == j6) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (1 + j5 == j6) {
            coreSubscriber.onSubscribe(Operators.scalarSubscription(coreSubscriber, Integer.valueOf((int) j5)));
        } else if (coreSubscriber instanceof Fuseable.ConditionalSubscriber) {
            coreSubscriber.onSubscribe(new RangeSubscriptionConditional((Fuseable.ConditionalSubscriber) coreSubscriber, j5, j6));
        } else {
            coreSubscriber.onSubscribe(new RangeSubscription(coreSubscriber, j5, j6));
        }
    }
}
