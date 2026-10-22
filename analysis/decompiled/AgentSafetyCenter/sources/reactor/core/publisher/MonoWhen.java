package reactor.core.publisher;

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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoWhen extends Mono<Void> implements SourceProducer<Void> {
    final boolean delayError;
    final qd.c[] sources;
    final Iterable<? extends qd.c> sourcesIterable;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class WhenInner implements InnerConsumer<Object> {
        static final AtomicReferenceFieldUpdater<WhenInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(WhenInner.class, qd.e.class, "s");
        Throwable error;
        final WhenCoordinator parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10741s;

        public WhenInner(WhenCoordinator whenCoordinator) {
            this.parent = whenCoordinator;
        }

        public void cancel() {
            Operators.terminate(S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.parent.signal();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
            Operators.onDiscard(obj, currentContext());
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10741s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10741s;
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

    public MonoWhen(boolean z10, qd.c... cVarArr) {
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
        qd.c[] cVarArr = this.sources;
        if (cVarArr != null) {
            length = cVarArr.length;
        } else {
            cVarArr = new qd.c[8];
            int i = 0;
            for (qd.c cVar : this.sourcesIterable) {
                if (i == cVarArr.length) {
                    qd.c[] cVarArr2 = new qd.c[(i >> 2) + i];
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
    public Mono<Void> whenAdditionalSource(qd.c cVar) {
        qd.c[] cVarArr = this.sources;
        if (cVarArr == null) {
            return null;
        }
        int length = cVarArr.length;
        qd.c[] cVarArr2 = new qd.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        return new MonoWhen(this.delayError, cVarArr2);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class WhenCoordinator implements InnerProducer<Void>, Fuseable, Fuseable.QueueSubscription<Void> {
        static final long INTERRUPTED_FLAG = Long.MIN_VALUE;
        static final long MAX_SIGNALS_VALUE = 2147483647L;
        static final long REQUESTED_ONCE_FLAG = 4611686018427387904L;
        static final AtomicLongFieldUpdater<WhenCoordinator> STATE = AtomicLongFieldUpdater.newUpdater(WhenCoordinator.class, "state");
        final CoreSubscriber<? super Void> actual;
        final boolean delayError;
        final qd.c[] sources;
        volatile long state;
        final WhenInner[] subscribers;

        public WhenCoordinator(qd.c[] cVarArr, CoreSubscriber<? super Void> coreSubscriber, int i, boolean z10) {
            this.sources = cVarArr;
            this.actual = coreSubscriber;
            this.delayError = z10;
            this.subscribers = new WhenInner[i];
            for (int i3 = 0; i3 < i; i3++) {
                this.subscribers[i3] = new WhenInner(this);
            }
        }

        public static int deliveredSignals(long j10) {
            return (int) (j10 & MAX_SIGNALS_VALUE);
        }

        public static boolean isInterrupted(long j10) {
            return (j10 & INTERRUPTED_FLAG) == INTERRUPTED_FLAG;
        }

        public static boolean isRequestedOnce(long j10) {
            return (j10 & REQUESTED_ONCE_FLAG) == REQUESTED_ONCE_FLAG;
        }

        public static long markDeliveredSignal(WhenCoordinator whenCoordinator) {
            long j10;
            int length = whenCoordinator.subscribers.length;
            while (true) {
                j10 = whenCoordinator.state;
                if (isInterrupted(j10) || length == deliveredSignals(j10)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j10, j10 + 1)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j10;
        }

        public static long markForceTerminated(WhenCoordinator whenCoordinator) {
            long j10;
            int length = whenCoordinator.subscribers.length;
            while (true) {
                j10 = whenCoordinator.state;
                if (isInterrupted(j10) || length == deliveredSignals(j10)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j10, INTERRUPTED_FLAG | ((-2147483648L) & j10) | length)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j10;
        }

        public static long markInterrupted(WhenCoordinator whenCoordinator) {
            long j10;
            int length = whenCoordinator.subscribers.length;
            while (true) {
                j10 = whenCoordinator.state;
                if (isInterrupted(j10) || length == deliveredSignals(j10)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j10, j10 | INTERRUPTED_FLAG)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j10;
        }

        public static long markRequestedOnce(WhenCoordinator whenCoordinator) {
            long j10;
            while (true) {
                j10 = whenCoordinator.state;
                if (isInterrupted(j10) || isRequestedOnce(j10)) {
                    break;
                }
                WhenCoordinator whenCoordinator2 = whenCoordinator;
                if (STATE.compareAndSet(whenCoordinator2, j10, j10 | REQUESTED_ONCE_FLAG)) {
                    break;
                }
                whenCoordinator = whenCoordinator2;
            }
            return j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Void> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
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

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            long jMarkRequestedOnce = markRequestedOnce(this);
            if (isRequestedOnce(jMarkRequestedOnce) || isInterrupted(jMarkRequestedOnce)) {
                return;
            }
            qd.c[] cVarArr = this.sources;
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
            long j10 = this.state;
            if (isInterrupted(j10) && deliveredSignals(j10) != this.subscribers.length) {
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
            } else {
                CoreSubscriber<? super Void> coreSubscriber = this.actual;
                if (th != null) {
                    coreSubscriber.onError(th);
                } else {
                    coreSubscriber.onComplete();
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.Queue
        public Void poll() {
            return null;
        }

        @Override // java.util.Collection
        public void clear() {
        }
    }

    public MonoWhen(boolean z10, Iterable<? extends qd.c> iterable) {
        this.delayError = z10;
        this.sources = null;
        Objects.requireNonNull(iterable, "sourcesIterable");
        this.sourcesIterable = iterable;
    }
}
