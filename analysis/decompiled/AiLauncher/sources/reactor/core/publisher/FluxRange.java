package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
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

        public RangeSubscription(CoreSubscriber<? super Integer> coreSubscriber, long j10, long j11) {
            this.actual = coreSubscriber;
            this.index = j10;
            this.end = j11;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Integer> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.index = this.end;
        }

        public void fastPath() {
            long j10 = this.end;
            CoreSubscriber<? super Integer> coreSubscriber = this.actual;
            for (long j11 = this.index; j11 != j10; j11++) {
                if (this.cancelled) {
                    return;
                }
                coreSubscriber.onNext(Integer.valueOf((int) j11));
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

        @Override // reactor.core.publisher.InnerProducer, qc.d
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
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isEmpty()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return (int) (this.end - this.index);
        }

        public void slowPath(long j10) {
            CoreSubscriber<? super Integer> coreSubscriber = this.actual;
            long j11 = this.end;
            long j12 = this.index;
            do {
                long j13 = 0;
                while (!this.cancelled) {
                    while (j13 != j10 && j12 != j11) {
                        coreSubscriber.onNext(Integer.valueOf((int) j12));
                        if (this.cancelled) {
                            return;
                        }
                        j13++;
                        j12++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    if (j12 == j11) {
                        coreSubscriber.onComplete();
                        return;
                    }
                    j10 = this.requested;
                    if (j10 == j13) {
                        this.index = j12;
                        j10 = REQUESTED.addAndGet(this, -j13);
                    }
                }
                return;
            } while (j10 != 0);
        }

        @Override // java.util.Queue
        @Nullable
        public Integer poll() {
            long j10 = this.index;
            if (j10 == this.end) {
                return null;
            }
            this.index = 1 + j10;
            return Integer.valueOf((int) j10);
        }
    }

    public static final class RangeSubscriptionConditional implements InnerProducer<Integer>, Fuseable.SynchronousSubscription<Integer> {
        static final AtomicLongFieldUpdater<RangeSubscriptionConditional> REQUESTED = AtomicLongFieldUpdater.newUpdater(RangeSubscriptionConditional.class, "requested");
        final Fuseable.ConditionalSubscriber<? super Integer> actual;
        volatile boolean cancelled;
        final long end;
        long index;
        volatile long requested;

        public RangeSubscriptionConditional(Fuseable.ConditionalSubscriber<? super Integer> conditionalSubscriber, long j10, long j11) {
            this.actual = conditionalSubscriber;
            this.index = j10;
            this.end = j11;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Integer> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.index = this.end;
        }

        public void fastPath() {
            long j10 = this.end;
            Fuseable.ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            for (long j11 = this.index; j11 != j10; j11++) {
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Integer.valueOf((int) j11));
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

        @Override // reactor.core.publisher.InnerProducer, qc.d
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
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isEmpty()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return (int) (this.end - this.index);
        }

        public void slowPath(long j10) {
            Fuseable.ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            long j11 = this.end;
            long j12 = this.index;
            do {
                long j13 = 0;
                while (!this.cancelled) {
                    while (j13 != j10 && j12 != j11) {
                        boolean zTryOnNext = conditionalSubscriber.tryOnNext(Integer.valueOf((int) j12));
                        if (this.cancelled) {
                            return;
                        }
                        if (zTryOnNext) {
                            j13++;
                        }
                        j12++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    if (j12 == j11) {
                        conditionalSubscriber.onComplete();
                        return;
                    }
                    j10 = this.requested;
                    if (j10 == j13) {
                        this.index = j12;
                        j10 = REQUESTED.addAndGet(this, -j13);
                    }
                }
                return;
            } while (j10 != 0);
        }

        @Override // java.util.Queue
        @Nullable
        public Integer poll() {
            long j10 = this.index;
            if (j10 == this.end) {
                return null;
            }
            this.index = 1 + j10;
            return Integer.valueOf((int) j10);
        }
    }

    public FluxRange(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= required but it was " + i11);
        }
        long j10 = i10;
        long j11 = i11 + j10;
        if (j11 - 1 > 2147483647L) {
            throw new IllegalArgumentException("start + count must be less than Integer.MAX_VALUE + 1");
        }
        this.start = j10;
        this.end = j11;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Integer> coreSubscriber) {
        long j10 = this.start;
        long j11 = this.end;
        if (j10 == j11) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (1 + j10 == j11) {
            coreSubscriber.onSubscribe(Operators.scalarSubscription(coreSubscriber, Integer.valueOf((int) j10)));
        } else if (coreSubscriber instanceof Fuseable.ConditionalSubscriber) {
            coreSubscriber.onSubscribe(new RangeSubscriptionConditional((Fuseable.ConditionalSubscriber) coreSubscriber, j10, j11));
        } else {
            coreSubscriber.onSubscribe(new RangeSubscription(coreSubscriber, j10, j11));
        }
    }
}
