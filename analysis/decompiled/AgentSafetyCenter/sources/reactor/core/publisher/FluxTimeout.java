package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxTimeout<T, U, V> extends InternalFluxOperator<T, T> {
    final qd.c firstTimeout;
    final Function<? super T, ? extends qd.c> itemTimeout;
    final qd.c other;
    final String timeoutDescription;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface IndexedCancellable {
        void cancel();

        long index();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TimeoutMainSubscriber<T, V> extends Operators.MultiSubscriptionSubscriber<T, T> {
        final qd.c firstTimeout;
        volatile long index;
        final Function<? super T, ? extends qd.c> itemTimeout;
        final qd.c other;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10700s;
        volatile IndexedCancellable timeout;
        final String timeoutDescription;
        static final AtomicReferenceFieldUpdater<TimeoutMainSubscriber, IndexedCancellable> TIMEOUT = AtomicReferenceFieldUpdater.newUpdater(TimeoutMainSubscriber.class, IndexedCancellable.class, "timeout");
        static final AtomicLongFieldUpdater<TimeoutMainSubscriber> INDEX = AtomicLongFieldUpdater.newUpdater(TimeoutMainSubscriber.class, "index");

        public TimeoutMainSubscriber(CoreSubscriber<? super T> coreSubscriber, qd.c cVar, Function<? super T, ? extends qd.c> function, @Nullable qd.c cVar2, @Nullable String str) {
            super(Operators.serialize(coreSubscriber));
            this.itemTimeout = function;
            this.other = cVar2;
            this.timeoutDescription = str;
            this.firstTimeout = cVar;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.index = Long.MIN_VALUE;
            cancelTimeout();
            super.cancel();
        }

        public void cancelTimeout() {
            IndexedCancellable andSet;
            IndexedCancellable indexedCancellable = this.timeout;
            CancelledIndexedCancellable cancelledIndexedCancellable = CancelledIndexedCancellable.INSTANCE;
            if (indexedCancellable == cancelledIndexedCancellable || (andSet = TIMEOUT.getAndSet(this, cancelledIndexedCancellable)) == null || andSet == cancelledIndexedCancellable) {
                return;
            }
            andSet.cancel();
        }

        public void doError(long j10, Throwable th) {
            if (this.index == j10 && INDEX.compareAndSet(this, j10, Long.MIN_VALUE)) {
                super.cancel();
                this.actual.onError(th);
            }
        }

        public void doTimeout(long j10) {
            if (this.index == j10 && INDEX.compareAndSet(this, j10, Long.MIN_VALUE)) {
                handleTimeout();
            }
        }

        public void handleTimeout() {
            if (this.other == null) {
                super.cancel();
                this.actual.onError(new TimeoutException(androidx.activity.b.n(new StringBuilder("Did not observe any item or terminal signal within "), this.timeoutDescription, " (and no fallback has been configured)")));
            } else {
                set(Operators.emptySubscription());
                this.other.subscribe(new TimeoutOtherSubscriber(this.actual, this));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            long j10 = this.index;
            if (j10 != Long.MIN_VALUE && INDEX.compareAndSet(this, j10, Long.MIN_VALUE)) {
                cancelTimeout();
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            long j10 = this.index;
            if (j10 == Long.MIN_VALUE) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else if (!INDEX.compareAndSet(this, j10, Long.MIN_VALUE)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                cancelTimeout();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.timeout.cancel();
            long j10 = this.index;
            if (j10 == Long.MIN_VALUE) {
                this.f10700s.cancel();
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j11 = 1 + j10;
            if (!INDEX.compareAndSet(this, j10, j11)) {
                this.f10700s.cancel();
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            this.actual.onNext(t10);
            producedOne();
            try {
                qd.c cVarApply = this.itemTimeout.apply(t10);
                Objects.requireNonNull(cVarApply, "The itemTimeout returned a null Publisher");
                qd.c cVar = cVarApply;
                TimeoutTimeoutSubscriber timeoutTimeoutSubscriber = new TimeoutTimeoutSubscriber(this, j11);
                if (setTimeout(timeoutTimeoutSubscriber)) {
                    Operators.toFluxOrMono(cVar).subscribe((CoreSubscriber) timeoutTimeoutSubscriber);
                }
            } catch (Throwable th) {
                CoreSubscriber<? super O> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(this, th, t10, coreSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10700s, eVar)) {
                this.f10700s = eVar;
                set(eVar);
                TimeoutTimeoutSubscriber timeoutTimeoutSubscriber = new TimeoutTimeoutSubscriber(this, 0L);
                this.timeout = timeoutTimeoutSubscriber;
                this.actual.onSubscribe(this);
                this.firstTimeout.subscribe(timeoutTimeoutSubscriber);
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public boolean setTimeout(IndexedCancellable indexedCancellable) {
            IndexedCancellable indexedCancellable2;
            do {
                indexedCancellable2 = this.timeout;
                if (indexedCancellable2 == CancelledIndexedCancellable.INSTANCE) {
                    indexedCancellable.cancel();
                    return false;
                }
                if (indexedCancellable2 != null && indexedCancellable2.index() >= indexedCancellable.index()) {
                    indexedCancellable.cancel();
                    return false;
                }
            } while (!TIMEOUT.compareAndSet(this, indexedCancellable2, indexedCancellable));
            if (indexedCancellable2 == null) {
                return true;
            }
            indexedCancellable2.cancel();
            return true;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber
        public boolean shouldCancelCurrent() {
            return true;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TimeoutOtherSubscriber<T> implements InnerConsumer<T> {
        final CoreSubscriber<? super T> actual;
        final Operators.MultiSubscriptionSubscriber<T, T> arbiter;

        public TimeoutOtherSubscriber(CoreSubscriber<? super T> coreSubscriber, Operators.MultiSubscriptionSubscriber<T, T> multiSubscriptionSubscriber) {
            this.actual = coreSubscriber;
            this.arbiter = multiSubscriptionSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            this.arbiter.set(eVar);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TimeoutTimeoutSubscriber implements InnerConsumer<Object>, IndexedCancellable {
        static final AtomicReferenceFieldUpdater<TimeoutTimeoutSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(TimeoutTimeoutSubscriber.class, qd.e.class, "s");
        final long index;
        final TimeoutMainSubscriber<?, ?> main;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10701s;

        public TimeoutTimeoutSubscriber(TimeoutMainSubscriber<?, ?> timeoutMainSubscriber, long j10) {
            this.main = timeoutMainSubscriber;
            this.index = j10;
        }

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public void cancel() {
            qd.e andSet;
            if (this.f10701s == Operators.cancelledSubscription() || (andSet = S.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public long index() {
            return this.index;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.main.doTimeout(this.index);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.main.doError(this.index, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
            this.f10701s.cancel();
            this.main.doTimeout(this.index);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (S.compareAndSet(this, null, eVar)) {
                eVar.request(Long.MAX_VALUE);
                return;
            }
            eVar.cancel();
            if (this.f10701s != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxTimeout(Flux<? extends T> flux, qd.c cVar, Function<? super T, ? extends qd.c> function, qd.c cVar2) {
        super(flux);
        Objects.requireNonNull(cVar, "firstTimeout");
        this.firstTimeout = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "itemTimeout");
        this.itemTimeout = function;
        Objects.requireNonNull(cVar2, "other");
        this.other = Operators.toFluxOrMono(cVar2);
        this.timeoutDescription = null;
    }

    @Nullable
    public static String addNameToTimeoutDescription(qd.c cVar, @Nullable String str) {
        if (str == null) {
            return null;
        }
        Scannable scannableFrom = Scannable.from(cVar);
        if (!scannableFrom.isScanAvailable()) {
            return str;
        }
        StringBuilder sbV = k0.a.v(str, " in '");
        sbV.append(scannableFrom.name());
        sbV.append("'");
        return sbV.toString();
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new TimeoutMainSubscriber(coreSubscriber, this.firstTimeout, this.itemTimeout, this.other, this.timeoutDescription);
    }

    public FluxTimeout(Flux<? extends T> flux, qd.c cVar, Function<? super T, ? extends qd.c> function, String str) {
        super(flux);
        Objects.requireNonNull(cVar, "firstTimeout");
        this.firstTimeout = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "itemTimeout");
        this.itemTimeout = function;
        this.other = null;
        Objects.requireNonNull(str, "timeoutDescription is needed when no fallback");
        this.timeoutDescription = addNameToTimeoutDescription(flux, str);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum CancelledIndexedCancellable implements IndexedCancellable {
        INSTANCE;

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public long index() {
            return Long.MAX_VALUE;
        }

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public void cancel() {
        }
    }
}
