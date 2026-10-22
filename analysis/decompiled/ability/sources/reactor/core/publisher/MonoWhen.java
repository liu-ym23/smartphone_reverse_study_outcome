package reactor.core.publisher;

import androidx.collection.SieveCacheKt;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoWhen extends Mono<Void> implements SourceProducer<Void> {
    final boolean delayError;
    final Z9.c[] sources;
    final Iterable<? extends Z9.c> sourcesIterable;

    public static final class WhenCoordinator implements InnerProducer<Void>, Fuseable, Fuseable.QueueSubscription<Void> {
        static final long INTERRUPTED_FLAG = Long.MIN_VALUE;
        static final long MAX_SIGNALS_VALUE = 2147483647L;
        static final long REQUESTED_ONCE_FLAG = 4611686018427387904L;
        static final AtomicLongFieldUpdater<WhenCoordinator> STATE = AtomicLongFieldUpdater.newUpdater(WhenCoordinator.class, "state");
        final CoreSubscriber<? super Void> actual;
        final boolean delayError;
        final Z9.c[] sources;
        volatile long state;
        final WhenInner[] subscribers;

        public WhenCoordinator(Z9.c[] cVarArr, CoreSubscriber<? super Void> coreSubscriber, int i, boolean z10) {
            this.sources = cVarArr;
            this.actual = coreSubscriber;
            this.delayError = z10;
            this.subscribers = new WhenInner[i];
            for (int i6 = 0; i6 < i; i6++) {
                this.subscribers[i6] = new WhenInner(this);
            }
        }

        public static int deliveredSignals(long j5) {
            return (int) (j5 & 2147483647L);
        }

        public static boolean isInterrupted(long j5) {
            return (j5 & Long.MIN_VALUE) == Long.MIN_VALUE;
        }

        public static boolean isRequestedOnce(long j5) {
            return (j5 & 4611686018427387904L) == 4611686018427387904L;
        }

        public static long markDeliveredSignal(WhenCoordinator whenCoordinator) {
            long j5;
            int length = whenCoordinator.subscribers.length;
            while (true) {
                j5 = whenCoordinator.state;
                if (isInterrupted(j5) || length == deliveredSignals(j5)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j5, j5 + 1)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j5;
        }

        public static long markForceTerminated(WhenCoordinator whenCoordinator) {
            long j5;
            int length = whenCoordinator.subscribers.length;
            while (true) {
                j5 = whenCoordinator.state;
                if (isInterrupted(j5) || length == deliveredSignals(j5)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j5, Long.MIN_VALUE | (SieveCacheKt.NodeMetaAndPreviousMask & j5) | length)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j5;
        }

        public static long markInterrupted(WhenCoordinator whenCoordinator) {
            long j5;
            int length = whenCoordinator.subscribers.length;
            while (true) {
                j5 = whenCoordinator.state;
                if (isInterrupted(j5) || length == deliveredSignals(j5)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j5, j5 | Long.MIN_VALUE)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j5;
        }

        public static long markRequestedOnce(WhenCoordinator whenCoordinator) {
            long j5;
            while (true) {
                j5 = whenCoordinator.state;
                if (isInterrupted(j5) || isRequestedOnce(j5)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j5, j5 | 4611686018427387904L)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Void> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            long jMarkInterrupted = markInterrupted(this);
            if (isInterrupted(jMarkInterrupted) || !isRequestedOnce(jMarkInterrupted)) {
                return;
            }
            int iDeliveredSignals = deliveredSignals(jMarkInterrupted);
            WhenInner[] whenInnerArr = this.subscribers;
            if (iDeliveredSignals == whenInnerArr.length) {
                return;
            }
            for (WhenInner whenInner : whenInnerArr) {
                whenInner.cancel();
            }
        }

        public void cancelExcept(WhenInner whenInner) {
            for (WhenInner whenInner2 : this.subscribers) {
                if (whenInner2 != whenInner) {
                    whenInner2.cancel();
                }
            }
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Queue
        public Void poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            long jMarkRequestedOnce = markRequestedOnce(this);
            if (isRequestedOnce(jMarkRequestedOnce) || isInterrupted(jMarkRequestedOnce)) {
                return;
            }
            Z9.c[] cVarArr = this.sources;
            WhenInner[] whenInnerArr = this.subscribers;
            for (int i = 0; i < this.subscribers.length; i++) {
                cVarArr[i].subscribe(whenInnerArr[i]);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(deliveredSignals(this.state) == this.subscribers.length);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.subscribers.length);
            }
            if (attr == Scannable.Attr.DELAY_ERROR) {
                return Boolean.valueOf(this.delayError);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            if (attr != Scannable.Attr.CANCELLED) {
                return super.scanUnsafe(attr);
            }
            long j5 = this.state;
            if (isInterrupted(j5) && deliveredSignals(j5) != this.subscribers.length) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        public boolean signal() {
            WhenInner[] whenInnerArr = this.subscribers;
            int length = whenInnerArr.length;
            long jMarkDeliveredSignal = markDeliveredSignal(this);
            int iDeliveredSignals = deliveredSignals(jMarkDeliveredSignal);
            if (isInterrupted(jMarkDeliveredSignal) || iDeliveredSignals == length) {
                return false;
            }
            if (iDeliveredSignals + 1 != length) {
                return true;
            }
            RuntimeException runtimeExceptionMultiple = null;
            Throwable th = null;
            for (WhenInner whenInner : whenInnerArr) {
                Throwable th2 = whenInner.error;
                if (th2 != null) {
                    if (runtimeExceptionMultiple != null) {
                        runtimeExceptionMultiple.addSuppressed(th2);
                    } else if (th != null) {
                        runtimeExceptionMultiple = Exceptions.multiple(th, th2);
                    } else {
                        th = th2;
                    }
                }
            }
            if (runtimeExceptionMultiple != null) {
                this.actual.onError(runtimeExceptionMultiple);
            } else if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onComplete();
            }
            return true;
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public static final class WhenInner implements InnerConsumer<Object> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<WhenInner, Z9.e> f5869S = AtomicReferenceFieldUpdater.newUpdater(WhenInner.class, Z9.e.class, "s");
        Throwable error;
        final WhenCoordinator parent;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5870s;

        public WhenInner(WhenCoordinator whenCoordinator) {
            this.parent = whenCoordinator;
        }

        public void cancel() {
            Operators.terminate(f5869S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.parent.signal();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.error = th;
            WhenCoordinator whenCoordinator = this.parent;
            if (whenCoordinator.delayError) {
                if (whenCoordinator.signal()) {
                    return;
                }
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                if (WhenCoordinator.isInterrupted(WhenCoordinator.markForceTerminated(whenCoordinator))) {
                    return;
                }
                this.parent.cancelExcept(this);
                this.parent.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
            Operators.onDiscard(obj, currentContext());
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5869S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5870s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f5870s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public MonoWhen(boolean z10, Z9.c... cVarArr) {
        this.delayError = z10;
        Objects.requireNonNull(cVarArr, "sources");
        this.sources = cVarArr;
        this.sourcesIterable = null;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Void> coreSubscriber) {
        int length;
        Z9.c[] cVarArr = this.sources;
        if (cVarArr != null) {
            length = cVarArr.length;
        } else {
            cVarArr = new Z9.c[8];
            int i = 0;
            for (Z9.c cVar : this.sourcesIterable) {
                if (i == cVarArr.length) {
                    Z9.c[] cVarArr2 = new Z9.c[(i >> 2) + i];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                    cVarArr = cVarArr2;
                }
                cVarArr[i] = cVar;
                i++;
            }
            length = i;
        }
        if (length == 0) {
            Operators.complete(coreSubscriber);
        } else {
            Operators.toFluxOrMono(cVarArr);
            coreSubscriber.onSubscribe(new WhenCoordinator(cVarArr, coreSubscriber, length, this.delayError));
        }
    }

    @Nullable
    public Mono<Void> whenAdditionalSource(Z9.c cVar) {
        Z9.c[] cVarArr = this.sources;
        if (cVarArr == null) {
            return null;
        }
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        return new MonoWhen(this.delayError, cVarArr2);
    }

    public MonoWhen(boolean z10, Iterable<? extends Z9.c> iterable) {
        this.delayError = z10;
        this.sources = null;
        Objects.requireNonNull(iterable, "sourcesIterable");
        this.sourcesIterable = iterable;
    }
}
