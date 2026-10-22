package reactor.core.publisher;

import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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

/* loaded from: classes5.dex */
final class MonoWhen extends Mono<Void> implements SourceProducer<Void> {
    final boolean delayError;
    final qc.b<?>[] sources;
    final Iterable<? extends qc.b<?>> sourcesIterable;

    public static final class WhenCoordinator implements InnerProducer<Void>, Fuseable, Fuseable.QueueSubscription<Void> {
        static final long INTERRUPTED_FLAG = Long.MIN_VALUE;
        static final long MAX_SIGNALS_VALUE = 2147483647L;
        static final long REQUESTED_ONCE_FLAG = 4611686018427387904L;
        static final AtomicLongFieldUpdater<WhenCoordinator> STATE = AtomicLongFieldUpdater.newUpdater(WhenCoordinator.class, VoiceWakeupReceiver.EXTRA_STATE);
        final CoreSubscriber<? super Void> actual;
        final boolean delayError;
        final qc.b<?>[] sources;
        volatile long state;
        final WhenInner[] subscribers;

        public WhenCoordinator(qc.b<?>[] bVarArr, CoreSubscriber<? super Void> coreSubscriber, int i10, boolean z10) {
            this.sources = bVarArr;
            this.actual = coreSubscriber;
            this.delayError = z10;
            this.subscribers = new WhenInner[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.subscribers[i11] = new WhenInner(this);
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

        @Override // reactor.core.publisher.InnerProducer, qc.d
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

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            long jMarkRequestedOnce = markRequestedOnce(this);
            if (isRequestedOnce(jMarkRequestedOnce) || isInterrupted(jMarkRequestedOnce)) {
                return;
            }
            qc.b<?>[] bVarArr = this.sources;
            WhenInner[] whenInnerArr = this.subscribers;
            for (int i10 = 0; i10 < this.subscribers.length; i10++) {
                bVarArr[i10].subscribe(whenInnerArr[i10]);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
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
        static final AtomicReferenceFieldUpdater<WhenInner, qc.d> f39673S = AtomicReferenceFieldUpdater.newUpdater(WhenInner.class, qc.d.class, "s");
        Throwable error;
        final WhenCoordinator parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39674s;

        public WhenInner(WhenCoordinator whenCoordinator) {
            this.parent = whenCoordinator;
        }

        public void cancel() {
            Operators.terminate(f39673S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.parent.signal();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
            Operators.onDiscard(obj, currentContext());
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39673S, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39674s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f39674s;
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

    public MonoWhen(boolean z10, qc.b<?>... bVarArr) {
        this.delayError = z10;
        Objects.requireNonNull(bVarArr, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
        this.sources = bVarArr;
        this.sourcesIterable = null;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Void> coreSubscriber) {
        int length;
        qc.b<?>[] bVarArr = this.sources;
        if (bVarArr != null) {
            length = bVarArr.length;
        } else {
            bVarArr = new qc.b[8];
            int i10 = 0;
            for (qc.b<?> bVar : this.sourcesIterable) {
                if (i10 == bVarArr.length) {
                    qc.b<?>[] bVarArr2 = new qc.b[(i10 >> 2) + i10];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, i10);
                    bVarArr = bVarArr2;
                }
                bVarArr[i10] = bVar;
                i10++;
            }
            length = i10;
        }
        if (length == 0) {
            Operators.complete(coreSubscriber);
        } else {
            Operators.toFluxOrMono(bVarArr);
            coreSubscriber.onSubscribe(new WhenCoordinator(bVarArr, coreSubscriber, length, this.delayError));
        }
    }

    @Nullable
    public Mono<Void> whenAdditionalSource(qc.b<?> bVar) {
        qc.b<?>[] bVarArr = this.sources;
        if (bVarArr == null) {
            return null;
        }
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        bVarArr2[length] = bVar;
        return new MonoWhen(this.delayError, (qc.b<?>[]) bVarArr2);
    }

    public MonoWhen(boolean z10, Iterable<? extends qc.b<?>> iterable) {
        this.delayError = z10;
        this.sources = null;
        Objects.requireNonNull(iterable, "sourcesIterable");
        this.sourcesIterable = iterable;
    }
}
