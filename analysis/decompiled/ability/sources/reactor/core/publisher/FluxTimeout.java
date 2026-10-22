package reactor.core.publisher;

import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
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

/* loaded from: classes4.dex */
final class FluxTimeout<T, U, V> extends InternalFluxOperator<T, T> {
    final Z9.c firstTimeout;
    final Function<? super T, ? extends Z9.c> itemTimeout;
    final Z9.c other;
    final String timeoutDescription;

    public enum CancelledIndexedCancellable implements IndexedCancellable {
        INSTANCE;

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public void cancel() {
        }

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public long index() {
            return Long.MAX_VALUE;
        }
    }

    public interface IndexedCancellable {
        void cancel();

        long index();
    }

    public static final class TimeoutMainSubscriber<T, V> extends Operators.MultiSubscriptionSubscriber<T, T> {
        final Z9.c firstTimeout;
        volatile long index;
        final Function<? super T, ? extends Z9.c> itemTimeout;
        final Z9.c other;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5813s;
        volatile IndexedCancellable timeout;
        final String timeoutDescription;
        static final AtomicReferenceFieldUpdater<TimeoutMainSubscriber, IndexedCancellable> TIMEOUT = AtomicReferenceFieldUpdater.newUpdater(TimeoutMainSubscriber.class, IndexedCancellable.class, InjectExperienceResult.REASON_TIMEOUT);
        static final AtomicLongFieldUpdater<TimeoutMainSubscriber> INDEX = AtomicLongFieldUpdater.newUpdater(TimeoutMainSubscriber.class, "index");

        public TimeoutMainSubscriber(CoreSubscriber<? super T> coreSubscriber, Z9.c cVar, Function<? super T, ? extends Z9.c> function, @Nullable Z9.c cVar2, @Nullable String str) {
            super(Operators.serialize(coreSubscriber));
            this.itemTimeout = function;
            this.other = cVar2;
            this.timeoutDescription = str;
            this.firstTimeout = cVar;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
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

        public void doError(long j5, Throwable th) {
            if (this.index == j5 && INDEX.compareAndSet(this, j5, Long.MIN_VALUE)) {
                super.cancel();
                this.actual.onError(th);
            }
        }

        public void doTimeout(long j5) {
            if (this.index == j5 && INDEX.compareAndSet(this, j5, Long.MIN_VALUE)) {
                handleTimeout();
            }
        }

        public void handleTimeout() {
            if (this.other == null) {
                super.cancel();
                this.actual.onError(new TimeoutException(B7.a.q(new StringBuilder("Did not observe any item or terminal signal within "), this.timeoutDescription, " (and no fallback has been configured)")));
            } else {
                set(Operators.emptySubscription());
                this.other.subscribe(new TimeoutOtherSubscriber(this.actual, this));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            long j5 = this.index;
            if (j5 != Long.MIN_VALUE && INDEX.compareAndSet(this, j5, Long.MIN_VALUE)) {
                cancelTimeout();
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            long j5 = this.index;
            if (j5 == Long.MIN_VALUE) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else if (!INDEX.compareAndSet(this, j5, Long.MIN_VALUE)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                cancelTimeout();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.timeout.cancel();
            long j5 = this.index;
            if (j5 == Long.MIN_VALUE) {
                this.f5813s.cancel();
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j6 = 1 + j5;
            if (!INDEX.compareAndSet(this, j5, j6)) {
                this.f5813s.cancel();
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            this.actual.onNext(t9);
            producedOne();
            try {
                Z9.c cVarApply = this.itemTimeout.apply(t9);
                Objects.requireNonNull(cVarApply, "The itemTimeout returned a null Publisher");
                Z9.c cVar = cVarApply;
                TimeoutTimeoutSubscriber timeoutTimeoutSubscriber = new TimeoutTimeoutSubscriber(this, j6);
                if (setTimeout(timeoutTimeoutSubscriber)) {
                    Operators.toFluxOrMono(cVar).subscribe((CoreSubscriber) timeoutTimeoutSubscriber);
                }
            } catch (Throwable th) {
                CoreSubscriber<? super O> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(this, th, t9, coreSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5813s, eVar)) {
                this.f5813s = eVar;
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
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

    public static final class TimeoutTimeoutSubscriber implements InnerConsumer<Object>, IndexedCancellable {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<TimeoutTimeoutSubscriber, Z9.e> f5814S = AtomicReferenceFieldUpdater.newUpdater(TimeoutTimeoutSubscriber.class, Z9.e.class, "s");
        final long index;
        final TimeoutMainSubscriber<?, ?> main;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5815s;

        public TimeoutTimeoutSubscriber(TimeoutMainSubscriber<?, ?> timeoutMainSubscriber, long j5) {
            this.main = timeoutMainSubscriber;
            this.index = j5;
        }

        @Override // reactor.core.publisher.FluxTimeout.IndexedCancellable
        public void cancel() {
            Z9.e andSet;
            if (this.f5815s == Operators.cancelledSubscription() || (andSet = f5814S.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.main.doTimeout(this.index);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.main.doError(this.index, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
            this.f5815s.cancel();
            this.main.doTimeout(this.index);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (f5814S.compareAndSet(this, null, eVar)) {
                eVar.request(Long.MAX_VALUE);
                return;
            }
            eVar.cancel();
            if (this.f5815s != Operators.cancelledSubscription()) {
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

    public FluxTimeout(Flux<? extends T> flux, Z9.c cVar, Function<? super T, ? extends Z9.c> function, String str) {
        super(flux);
        Objects.requireNonNull(cVar, "firstTimeout");
        this.firstTimeout = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "itemTimeout");
        this.itemTimeout = function;
        this.other = null;
        Objects.requireNonNull(str, "timeoutDescription is needed when no fallback");
        this.timeoutDescription = addNameToTimeoutDescription(flux, str);
    }

    @Nullable
    public static String addNameToTimeoutDescription(Z9.c cVar, @Nullable String str) {
        if (str == null) {
            return null;
        }
        Scannable scannableFrom = Scannable.from(cVar);
        if (!scannableFrom.isScanAvailable()) {
            return str;
        }
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, " in '");
        sbX.append(scannableFrom.name());
        sbX.append("'");
        return sbX.toString();
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new TimeoutMainSubscriber(coreSubscriber, this.firstTimeout, this.itemTimeout, this.other, this.timeoutDescription);
    }

    public FluxTimeout(Flux<? extends T> flux, Z9.c cVar, Function<? super T, ? extends Z9.c> function, Z9.c cVar2) {
        super(flux);
        Objects.requireNonNull(cVar, "firstTimeout");
        this.firstTimeout = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "itemTimeout");
        this.itemTimeout = function;
        Objects.requireNonNull(cVar2, "other");
        this.other = Operators.toFluxOrMono(cVar2);
        this.timeoutDescription = null;
    }
}
