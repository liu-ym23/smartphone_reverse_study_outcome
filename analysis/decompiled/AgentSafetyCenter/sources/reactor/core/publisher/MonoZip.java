package reactor.core.publisher;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxZip;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoZip<T, R> extends Mono<R> implements SourceProducer<R> {
    final boolean delayError;
    final Mono<?>[] sources;
    final Iterable<? extends Mono<?>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipInner<R> implements InnerConsumer<Object> {
        static final AtomicReferenceFieldUpdater<ZipInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(ZipInner.class, qd.e.class, "s");
        Throwable error;
        final ZipCoordinator<R> parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10742s;
        Object value;

        public ZipInner(ZipCoordinator<R> zipCoordinator) {
            this.parent = zipCoordinator;
        }

        public boolean cancel() {
            return !Operators.terminate(S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.value != null) {
                return;
            }
            ZipCoordinator<R> zipCoordinator = this.parent;
            if (zipCoordinator.delayError) {
                zipCoordinator.signal();
            } else {
                if (ZipCoordinator.isInterrupted(ZipCoordinator.markForceTerminated(zipCoordinator))) {
                    return;
                }
                this.parent.cancelExcept(this);
                this.parent.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.value != null) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
                return;
            }
            this.error = th;
            ZipCoordinator<R> zipCoordinator = this.parent;
            if (zipCoordinator.delayError) {
                if (zipCoordinator.signal()) {
                    return;
                }
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                if (ZipCoordinator.isInterrupted(ZipCoordinator.markForceTerminated(zipCoordinator))) {
                    return;
                }
                this.parent.cancelExcept(this);
                this.parent.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
            if (this.value == null) {
                this.value = obj;
                this.parent.signal();
                qd.e eVar = this.f10742s;
                if (eVar == Operators.cancelledSubscription() || !S.compareAndSet(this, eVar, Operators.cancelledSubscription())) {
                    Operators.onDiscard(obj, this.parent.actual.currentContext());
                }
            }
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
                return Boolean.valueOf(this.f10742s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10742s;
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

    public <U> MonoZip(boolean z10, Mono<? extends T> mono, Mono<? extends U> mono2, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(biFunction, "zipper2");
        FluxZip.PairwiseZipper pairwiseZipper = new FluxZip.PairwiseZipper(new BiFunction[]{biFunction});
        Objects.requireNonNull(mono, "p1");
        Objects.requireNonNull(mono2, "p2");
        this(z10, pairwiseZipper, (Mono<?>[]) new Mono[]{mono, mono2});
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super R> coreSubscriber) {
        int length;
        Mono<?>[] monoArr = this.sources;
        if (monoArr != null) {
            length = monoArr.length;
        } else {
            monoArr = new Mono[8];
            int i = 0;
            for (Mono<?> mono : this.sourcesIterable) {
                if (i == monoArr.length) {
                    Mono<?>[] monoArr2 = new Mono[(i >> 2) + i];
                    System.arraycopy(monoArr, 0, monoArr2, 0, i);
                    monoArr = monoArr2;
                }
                monoArr[i] = mono;
                i++;
            }
            length = i;
        }
        Mono<?>[] monoArr3 = monoArr;
        if (length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        for (int i3 = 0; i3 < length; i3++) {
            monoArr3[i3] = Mono.fromDirect(monoArr3[i3]);
        }
        coreSubscriber.onSubscribe(new ZipCoordinator(monoArr3, coreSubscriber, length, this.delayError, this.zipper));
    }

    @Nullable
    public Mono<R> zipAdditionalSource(Mono mono, BiFunction biFunction) {
        Mono<?>[] monoArr = this.sources;
        if (monoArr == null || !(this.zipper instanceof FluxZip.PairwiseZipper)) {
            return null;
        }
        int length = monoArr.length;
        Mono[] monoArr2 = new Mono[length + 1];
        System.arraycopy(monoArr, 0, monoArr2, 0, length);
        monoArr2[length] = mono;
        return new MonoZip(this.delayError, ((FluxZip.PairwiseZipper) this.zipper).then(biFunction), (Mono<?>[]) monoArr2);
    }

    public MonoZip(boolean z10, Function<? super Object[], ? extends R> function, Mono<?>... monoArr) {
        this.delayError = z10;
        Objects.requireNonNull(function, "zipper");
        this.zipper = function;
        Objects.requireNonNull(monoArr, "sources");
        this.sources = monoArr;
        this.sourcesIterable = null;
    }

    public MonoZip(boolean z10, Function<? super Object[], ? extends R> function, Iterable<? extends Mono<?>> iterable) {
        this.delayError = z10;
        Objects.requireNonNull(function, "zipper");
        this.zipper = function;
        this.sources = null;
        Objects.requireNonNull(iterable, "sourcesIterable");
        this.sourcesIterable = iterable;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipCoordinator<R> implements InnerProducer<R>, Fuseable, Fuseable.QueueSubscription<R> {
        static final long INTERRUPTED_FLAG = Long.MIN_VALUE;
        static final long MAX_SIGNALS_VALUE = 2147483647L;
        static final long REQUESTED_ONCE_FLAG = 4611686018427387904L;
        static final AtomicLongFieldUpdater<ZipCoordinator> STATE = AtomicLongFieldUpdater.newUpdater(ZipCoordinator.class, "state");
        final CoreSubscriber<? super R> actual;
        final boolean delayError;
        final Mono<?>[] sources;
        volatile long state;
        final ZipInner<R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Mono<?>[] monoArr, CoreSubscriber<? super R> coreSubscriber, int i, boolean z10, Function<? super Object[], ? extends R> function) {
            this.sources = monoArr;
            this.actual = coreSubscriber;
            this.delayError = z10;
            this.zipper = function;
            ZipInner<R>[] zipInnerArr = new ZipInner[i];
            this.subscribers = zipInnerArr;
            for (int i3 = 0; i3 < i; i3++) {
                zipInnerArr[i3] = new ZipInner<>(this);
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

        public static <T> long markDeliveredSignal(ZipCoordinator<T> zipCoordinator) {
            long j10;
            int length = zipCoordinator.subscribers.length;
            while (true) {
                j10 = zipCoordinator.state;
                if (isInterrupted(j10) || length == deliveredSignals(j10)) {
                    break;
                }
                ZipCoordinator<T> zipCoordinator2 = zipCoordinator;
                if (STATE.compareAndSet(zipCoordinator2, j10, j10 + 1)) {
                    break;
                }
                zipCoordinator = zipCoordinator2;
            }
            return j10;
        }

        public static <T> long markForceTerminated(ZipCoordinator<T> zipCoordinator) {
            long j10;
            int length = zipCoordinator.subscribers.length;
            while (true) {
                j10 = zipCoordinator.state;
                if (isInterrupted(j10) || length == deliveredSignals(j10)) {
                    break;
                }
                ZipCoordinator<T> zipCoordinator2 = zipCoordinator;
                if (STATE.compareAndSet(zipCoordinator2, j10, INTERRUPTED_FLAG | ((-2147483648L) & j10) | length)) {
                    break;
                }
                zipCoordinator = zipCoordinator2;
            }
            return j10;
        }

        public static <T> long markInterrupted(ZipCoordinator<T> zipCoordinator) {
            long j10;
            int length = zipCoordinator.subscribers.length;
            while (true) {
                j10 = zipCoordinator.state;
                if (isInterrupted(j10) || length == deliveredSignals(j10)) {
                    break;
                }
                ZipCoordinator<T> zipCoordinator2 = zipCoordinator;
                if (STATE.compareAndSet(zipCoordinator2, j10, j10 | INTERRUPTED_FLAG)) {
                    break;
                }
                zipCoordinator = zipCoordinator2;
            }
            return j10;
        }

        public static <T> long markRequestedOnce(ZipCoordinator<T> zipCoordinator) {
            long j10;
            while (true) {
                j10 = zipCoordinator.state;
                if (isInterrupted(j10) || isRequestedOnce(j10)) {
                    break;
                }
                ZipCoordinator<T> zipCoordinator2 = zipCoordinator;
                if (STATE.compareAndSet(zipCoordinator2, j10, j10 | REQUESTED_ONCE_FLAG)) {
                    break;
                }
                zipCoordinator = zipCoordinator2;
            }
            return j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            long jMarkInterrupted = markInterrupted(this);
            if (isInterrupted(jMarkInterrupted) || !isRequestedOnce(jMarkInterrupted) || deliveredSignals(jMarkInterrupted) == this.subscribers.length) {
                return;
            }
            Context contextCurrentContext = this.actual.currentContext();
            for (ZipInner<R> zipInner : this.subscribers) {
                if (zipInner.cancel()) {
                    Operators.onDiscard(zipInner.value, contextCurrentContext);
                }
            }
        }

        public void cancelExcept(ZipInner<R> zipInner) {
            Context contextCurrentContext = this.actual.currentContext();
            for (ZipInner<R> zipInner2 : this.subscribers) {
                if (zipInner2 != zipInner && zipInner2.cancel()) {
                    Operators.onDiscard(zipInner2.value, contextCurrentContext);
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

        @Override // java.util.Queue
        public R poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            long jMarkRequestedOnce = markRequestedOnce(this);
            if (isRequestedOnce(jMarkRequestedOnce) || isInterrupted(jMarkRequestedOnce)) {
                return;
            }
            Mono<?>[] monoArr = this.sources;
            ZipInner<R>[] zipInnerArr = this.subscribers;
            for (int i = 0; i < this.subscribers.length; i++) {
                monoArr[i].subscribe((CoreSubscriber<? super Object>) zipInnerArr[i]);
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
            ZipInner<R>[] zipInnerArr = this.subscribers;
            int length = zipInnerArr.length;
            long jMarkDeliveredSignal = markDeliveredSignal(this);
            int iDeliveredSignals = deliveredSignals(jMarkDeliveredSignal);
            if (isInterrupted(jMarkDeliveredSignal) || iDeliveredSignals == length) {
                return false;
            }
            if (iDeliveredSignals + 1 != length) {
                return true;
            }
            Object[] objArr = new Object[length];
            boolean z10 = false;
            RuntimeException runtimeExceptionMultiple = null;
            Throwable th = null;
            for (int i = 0; i < zipInnerArr.length; i++) {
                ZipInner<R> zipInner = zipInnerArr[i];
                Object obj = zipInner.value;
                if (obj != null) {
                    objArr[i] = obj;
                } else {
                    Throwable th2 = zipInner.error;
                    if (th2 == null) {
                        z10 = true;
                    } else if (runtimeExceptionMultiple != null) {
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
            } else if (z10) {
                this.actual.onComplete();
            } else {
                try {
                    R rApply = this.zipper.apply(objArr);
                    Objects.requireNonNull(rApply, "zipper produced a null value");
                    this.actual.onNext(rApply);
                    this.actual.onComplete();
                } catch (Throwable th3) {
                    Operators.onDiscardMultiple(Arrays.asList(objArr), this.actual.currentContext());
                    CoreSubscriber<? super R> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onOperatorError(null, th3, objArr, coreSubscriber.currentContext()));
                    return true;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.Collection
        public void clear() {
        }
    }
}
