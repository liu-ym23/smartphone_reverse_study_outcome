package reactor.core.publisher;

import androidx.autofill.HintConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxContextWriteRestoringThreadLocals;
import reactor.core.publisher.FluxContextWriteRestoringThreadLocalsFuseable;
import reactor.core.publisher.OnNextFailureStrategy;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public abstract class Operators {
    static final Fuseable.ConditionalSubscriber<?> EMPTY_SUBSCRIBER = new Fuseable.ConditionalSubscriber<Object>() { // from class: reactor.core.publisher.Operators.1
        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Context.empty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onComplete should not be used"));
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onError should not be used", th));
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException(androidx.appfunctions.metadata.a.j(obj, "onNext should not be used, got ")));
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onSubscribe should not be used"));
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(Object obj) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException(androidx.appfunctions.metadata.a.j(obj, "tryOnNext should not be used, got ")));
            return false;
        }
    };
    static final Logger log = Loggers.getLogger((Class<?>) Operators.class);

    public static abstract class BaseFluxToMonoOperator<I, O> implements InnerOperator<I, O>, Fuseable, Fuseable.QueueSubscription<I> {
        static final AtomicIntegerFieldUpdater<BaseFluxToMonoOperator> STATE = AtomicIntegerFieldUpdater.newUpdater(BaseFluxToMonoOperator.class, "state");
        final CoreSubscriber<? super O> actual;
        boolean hasRequest;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5875s;
        volatile int state;

        public BaseFluxToMonoOperator(CoreSubscriber<? super O> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Nullable
        public abstract O accumulatedValue();

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super O> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5875s.cancel();
        }

        @Override // java.util.Collection
        public final void clear() {
        }

        public final void completePossiblyEmpty() {
            O oAccumulatedValue;
            if (this.hasRequest) {
                O oAccumulatedValue2 = accumulatedValue();
                if (oAccumulatedValue2 == null) {
                    return;
                }
                this.actual.onNext(oAccumulatedValue2);
                this.actual.onComplete();
                return;
            }
            if ((this.state == 0 && STATE.compareAndSet(this, 0, 2)) || (oAccumulatedValue = accumulatedValue()) == null) {
                return;
            }
            this.actual.onNext(oAccumulatedValue);
            this.actual.onComplete();
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public abstract /* synthetic */ void onComplete();

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public abstract /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public abstract /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5875s, eVar)) {
                this.f5875s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public final I poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (this.hasRequest) {
                return;
            }
            this.hasRequest = true;
            int i = this.state;
            if ((i & 1) != 1 && STATE.compareAndSet(this, i, i | 1)) {
                if (i == 0) {
                    this.f5875s.request(Long.MAX_VALUE);
                    return;
                }
                O oAccumulatedValue = accumulatedValue();
                if (oAccumulatedValue == null) {
                    return;
                }
                this.actual.onNext(oAccumulatedValue);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public final int requestFusion(int i) {
            return 0;
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            return attr == Scannable.Attr.PARENT ? this.f5875s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public final int size() {
            return 0;
        }
    }

    public static final class CancelledSubscription implements Z9.e, Scannable {
        static final CancelledSubscription INSTANCE = new CancelledSubscription();

        @Override // Z9.e
        public void cancel() {
        }

        @Override // Z9.e
        public void request(long j5) {
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.TRUE;
            }
            return null;
        }

        @Override // reactor.core.Scannable
        public String stepName() {
            return "cancelledSubscription";
        }
    }

    public static final class ConditionalSubscriberAdapter<T> implements Fuseable.ConditionalSubscriber<T> {
        final CoreSubscriber<T> delegate;

        public ConditionalSubscriberAdapter(CoreSubscriber<T> coreSubscriber) {
            this.delegate = coreSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.delegate.currentContext();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.delegate.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.delegate.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.delegate.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            this.delegate.onSubscribe(eVar);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            this.delegate.onNext(t9);
            return true;
        }
    }

    public static final class CorePublisherAdapter<T> implements CorePublisher<T> {
        final Z9.c publisher;

        public CorePublisherAdapter(Z9.c cVar) {
            this.publisher = cVar;
        }

        @Override // reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            this.publisher.subscribe(coreSubscriber);
        }

        @Override // reactor.core.CorePublisher, Z9.c
        public void subscribe(Z9.d dVar) {
            this.publisher.subscribe(dVar);
        }
    }

    public static class DeferredSubscription implements Z9.e, Scannable {
        static final AtomicLongFieldUpdater<DeferredSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(DeferredSubscription.class, "requested");
        static final int STATE_CANCELLED = -2;
        static final int STATE_SUBSCRIBED = -1;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5876s;

        @Override // Z9.e
        public void cancel() {
            long andSet = REQUESTED.getAndSet(this, -2L);
            if (andSet != -2 && andSet == -1) {
                this.f5876s.cancel();
            }
        }

        public boolean isCancelled() {
            return this.requested == -2;
        }

        @Override // Z9.e
        public void request(long j5) {
            DeferredSubscription deferredSubscription;
            long j6 = this.requested;
            if (j6 > -1) {
                long j10 = j6;
                while (j10 != Long.MAX_VALUE) {
                    deferredSubscription = this;
                    if (REQUESTED.compareAndSet(deferredSubscription, j10, Operators.addCap(j10, j5))) {
                        return;
                    }
                    j10 = deferredSubscription.requested;
                    if (j10 < 0) {
                        j6 = j10;
                    } else {
                        this = deferredSubscription;
                    }
                }
                return;
            }
            deferredSubscription = this;
            if (j6 == -2) {
                return;
            }
            deferredSubscription.f5876s.request(j5);
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            long j5 = this.requested;
            if (attr == Scannable.Attr.PARENT) {
                return this.f5876s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                if (j5 < 0) {
                    j5 = 0;
                }
                return Long.valueOf(j5);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelled());
            }
            return null;
        }

        public final boolean set(Z9.e eVar) {
            Objects.requireNonNull(eVar, "s");
            long j5 = this.requested;
            Z9.e eVar2 = this.f5876s;
            if (j5 == -2) {
                eVar.cancel();
                return false;
            }
            if (eVar2 != null) {
                eVar.cancel();
                Operators.reportSubscriptionSet();
                return false;
            }
            long j6 = 0;
            while (true) {
                long j10 = this.requested;
                if (j10 == -2 || j10 == -1) {
                    break;
                }
                this.f5876s = eVar;
                long j11 = j10 - j6;
                if (j11 > 0) {
                    eVar.request(j11);
                }
                long j12 = j11 + j6;
                if (REQUESTED.compareAndSet(this, j10, -1L)) {
                    return true;
                }
                j6 = j12;
            }
            eVar.cancel();
            return false;
        }

        public void terminate() {
            REQUESTED.getAndSet(this, -2L);
        }
    }

    public static final class DrainSubscriber<T> implements CoreSubscriber<T> {
        static final DrainSubscriber INSTANCE = new DrainSubscriber();

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Context.empty();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            Operators.onErrorDropped(Exceptions.errorCallbackNotImplemented(th), Context.empty());
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            eVar.request(Long.MAX_VALUE);
        }
    }

    public static final class EmptySubscription implements Fuseable.QueueSubscription<Object>, Scannable {
        static final EmptySubscription INSTANCE = new EmptySubscription();
        static final EmptySubscription FROM_SUBSCRIBE_INSTANCE = new EmptySubscription();

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Queue
        @Nullable
        public Object poll() {
            return null;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.TRUE;
            }
            return null;
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        @Override // reactor.core.Scannable
        public String stepName() {
            return "emptySubscription";
        }
    }

    public static final class LiftFunction<I, O> implements Function<Z9.c, Z9.c> {
        final Predicate<Z9.c> filter;
        final BiFunction<Z9.c, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> lifter;
        final String name;

        private LiftFunction(@Nullable Predicate<Z9.c> predicate, BiFunction<Z9.c, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction, String str) {
            this.filter = predicate;
            Objects.requireNonNull(biFunction, "lifter");
            this.lifter = biFunction;
            Objects.requireNonNull(str, HintConstants.AUTOFILL_HINT_NAME);
            this.name = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ CoreSubscriber lambda$liftPublisher$2(BiFunction biFunction, Z9.c cVar, CoreSubscriber coreSubscriber) {
            return Operators.restoreContextOnSubscriberIfPublisherNonInternal(cVar, (CoreSubscriber) biFunction.apply(cVar, Operators.restoreContextOnSubscriberIfAutoCPEnabled(cVar, coreSubscriber)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$liftScannable$0(Predicate predicate, Z9.c cVar) {
            return predicate.test(Scannable.from(cVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ CoreSubscriber lambda$liftScannable$1(BiFunction biFunction, Z9.c cVar, CoreSubscriber coreSubscriber) {
            return Operators.restoreContextOnSubscriberIfPublisherNonInternal(cVar, (CoreSubscriber) biFunction.apply(Scannable.from(cVar), Operators.restoreContextOnSubscriberIfAutoCPEnabled(cVar, coreSubscriber)));
        }

        public static final <I, O> LiftFunction<I, O> liftPublisher(@Nullable Predicate<Z9.c> predicate, BiFunction<Z9.c, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
            Objects.requireNonNull(biFunction, "lifter");
            return new LiftFunction<>(predicate, new f0(biFunction, 1), biFunction.toString());
        }

        public static final <I, O> LiftFunction<I, O> liftScannable(@Nullable Predicate<Scannable> predicate, BiFunction<Scannable, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
            Objects.requireNonNull(biFunction, "lifter");
            return new LiftFunction<>(predicate != null ? new e0(predicate, 0) : null, new f0(biFunction, 0), biFunction.toString());
        }

        @Override // java.util.function.Function
        public Z9.c apply(Z9.c cVar) {
            Predicate<Z9.c> predicate = this.filter;
            return (predicate == null || predicate.test(cVar)) ? cVar instanceof Fuseable ? cVar instanceof Mono ? new MonoLiftFuseable(cVar, this) : cVar instanceof ParallelFlux ? new ParallelLiftFuseable((ParallelFlux) cVar, this) : cVar instanceof ConnectableFlux ? new ConnectableLiftFuseable((ConnectableFlux) cVar, this) : cVar instanceof GroupedFlux ? new GroupedLiftFuseable((GroupedFlux) cVar, this) : new FluxLiftFuseable(cVar, this) : cVar instanceof Mono ? new MonoLift(cVar, this) : cVar instanceof ParallelFlux ? new ParallelLift((ParallelFlux) cVar, this) : cVar instanceof ConnectableFlux ? new ConnectableLift((ConnectableFlux) cVar, this) : cVar instanceof GroupedFlux ? new GroupedLift((GroupedFlux) cVar, this) : new FluxLift(cVar, this) : cVar;
        }
    }

    public static class MonoInnerProducerBase<O> implements InnerProducer<O> {
        private static final int CANCELLED = 128;
        private static final int HAS_COMPLETED = 4;
        private static final int HAS_REQUEST = 2;
        private static final int HAS_VALUE = 1;
        private static final AtomicIntegerFieldUpdater<MonoInnerProducerBase> STATE = AtomicIntegerFieldUpdater.newUpdater(MonoInnerProducerBase.class, "state");
        private final CoreSubscriber<? super O> actual;
        private volatile int state;
        private O value;

        public MonoInnerProducerBase(CoreSubscriber<? super O> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        private static boolean hasCompleted(int i) {
            return (i & 4) == 4;
        }

        private static boolean hasRequest(int i) {
            return (i & 2) == 2;
        }

        private static boolean hasValue(int i) {
            return (i & 1) == 1;
        }

        private static boolean isCancelled(int i) {
            return i == 128;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super O> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public final void cancel() {
            int andSet = STATE.getAndSet(this, 128);
            if (isCancelled(andSet)) {
                return;
            }
            doOnCancel();
            if (!hasValue(andSet) || (andSet & 6) == 6) {
                return;
            }
            discardTheValue();
        }

        public final void complete(O o) {
            int i;
            do {
                i = this.state;
                if (isCancelled(i)) {
                    discard(o);
                    return;
                }
                if (hasRequest(i) && STATE.compareAndSet(this, i, i | 5)) {
                    this.value = null;
                    doOnComplete(o);
                    this.actual.onNext(o);
                    this.actual.onComplete();
                    return;
                }
                this.value = o;
            } while (!STATE.compareAndSet(this, i, i | 5));
        }

        public final void discard(@Nullable O o) {
            Operators.onDiscard(o, this.actual.currentContext());
        }

        public final void discardTheValue() {
            discard(this.value);
            this.value = null;
        }

        public void doOnCancel() {
        }

        public void doOnComplete(O o) {
        }

        public void doOnRequest(long j5) {
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            int i;
            if (Operators.validate(j5)) {
                do {
                    i = this.state;
                    if (isCancelled(i) || hasRequest(i)) {
                        return;
                    }
                } while (!STATE.compareAndSet(this, i, i | 2));
                doOnRequest(j5);
                if (hasValue(i) && hasCompleted(i)) {
                    O o = this.value;
                    this.value = null;
                    doOnComplete(o);
                    this.actual.onNext(o);
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelled());
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(hasCompleted(this.state));
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            return super.scanUnsafe(attr);
        }

        public final void setValue(@Nullable O o) {
            int i;
            this.value = o;
            do {
                i = this.state;
                if (isCancelled(i)) {
                    discardTheValue();
                    return;
                }
            } while (!STATE.compareAndSet(this, i, i | 1));
        }

        public final boolean isCancelled() {
            return this.state == 128;
        }

        public final void complete() {
            while (true) {
                int i = this.state;
                if (isCancelled(i)) {
                    return;
                }
                if (STATE.compareAndSet(this, i, i | 4)) {
                    if (hasValue(i) && hasRequest(i)) {
                        O o = this.value;
                        this.value = null;
                        doOnComplete(o);
                        this.actual.onNext(o);
                        this.actual.onComplete();
                        return;
                    }
                    if (!hasValue(i)) {
                        this.actual.onComplete();
                        return;
                    } else if (!hasRequest(i)) {
                        return;
                    }
                }
            }
        }
    }

    public static class MonoSubscriber<I, O> implements InnerOperator<I, O>, Fuseable, Fuseable.QueueSubscription<O> {
        static final int CANCELLED = 4;
        static final int HAS_REQUEST_HAS_VALUE = 3;
        static final int HAS_REQUEST_NO_VALUE = 2;
        static final int NO_REQUEST_HAS_VALUE = 1;
        static final int NO_REQUEST_NO_VALUE = 0;
        static final AtomicIntegerFieldUpdater<MonoSubscriber> STATE = AtomicIntegerFieldUpdater.newUpdater(MonoSubscriber.class, "state");
        protected final CoreSubscriber<? super O> actual;
        volatile int state;

        @Nullable
        protected O value;

        public MonoSubscriber(CoreSubscriber<? super O> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super O> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            O o = this.value;
            this.value = null;
            STATE.set(this, 4);
            discard(o);
        }

        @Override // java.util.Collection
        public final void clear() {
            this.value = null;
        }

        public final void complete(@Nullable O o) {
            while (true) {
                int i = this.state;
                if ((i & (-3)) != 0) {
                    this.value = null;
                    discard(o);
                    return;
                } else {
                    if (i == 2 && STATE.compareAndSet(this, 2, 3)) {
                        this.value = null;
                        CoreSubscriber<? super O> coreSubscriber = this.actual;
                        coreSubscriber.onNext(o);
                        coreSubscriber.onComplete();
                        return;
                    }
                    setValue(o);
                    if (i == 0 && STATE.compareAndSet(this, 0, 1)) {
                        return;
                    }
                }
            }
        }

        public void discard(@Nullable O o) {
            Operators.onDiscard(o, this.actual.currentContext());
        }

        public final boolean isCancelled() {
            return this.state == 4;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(I i) {
            setValue(i);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
        }

        @Override // java.util.Queue
        @Nullable
        public final O poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                do {
                    int i = this.state;
                    if (i == 4 || (i & (-2)) != 0) {
                        return;
                    }
                    if (i == 1 && STATE.compareAndSet(this, 1, 3)) {
                        O o = this.value;
                        if (o != null) {
                            this.value = null;
                            CoreSubscriber<? super O> coreSubscriber = this.actual;
                            coreSubscriber.onNext(o);
                            coreSubscriber.onComplete();
                            return;
                        }
                        return;
                    }
                } while (!STATE.compareAndSet(this, 0, 2));
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelled());
            }
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.PREFETCH) {
                    return Integer.MAX_VALUE;
                }
                return super.scanUnsafe(attr);
            }
            boolean z10 = true;
            if (this.state != 3 && this.state != 1) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }

        public void setValue(@Nullable O o) {
            if (STATE.get(this) == 4) {
                discard(o);
            } else {
                this.value = o;
            }
        }

        @Override // java.util.Collection
        public int size() {
            return !isEmpty() ? 1 : 0;
        }
    }

    public static abstract class MultiSubscriptionSubscriber<I, O> implements InnerOperator<I, O> {
        final CoreSubscriber<? super O> actual;
        volatile boolean cancelled;
        volatile long missedProduced;
        volatile long missedRequested;
        volatile Z9.e missedSubscription;
        long requested;
        Z9.e subscription;
        protected boolean unbounded;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<MultiSubscriptionSubscriber, Z9.e> MISSED_SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(MultiSubscriptionSubscriber.class, Z9.e.class, "missedSubscription");
        static final AtomicLongFieldUpdater<MultiSubscriptionSubscriber> MISSED_REQUESTED = AtomicLongFieldUpdater.newUpdater(MultiSubscriptionSubscriber.class, "missedRequested");
        static final AtomicLongFieldUpdater<MultiSubscriptionSubscriber> MISSED_PRODUCED = AtomicLongFieldUpdater.newUpdater(MultiSubscriptionSubscriber.class, "missedProduced");
        static final AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(MultiSubscriptionSubscriber.class, "wip");

        public MultiSubscriptionSubscriber(CoreSubscriber<? super O> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super O> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            drain();
        }

        public final void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            drainLoop();
        }

        public final void drainLoop() {
            long j5;
            int iAddAndGet = 1;
            long j6 = 0;
            long jAddCap = 0;
            long j10 = 0;
            Z9.e eVar = null;
            while (true) {
                Z9.e andSet = this.missedSubscription;
                if (andSet != null) {
                    andSet = MISSED_SUBSCRIPTION.getAndSet(this, null);
                }
                long andSet2 = this.missedRequested;
                if (andSet2 != j6) {
                    andSet2 = MISSED_REQUESTED.getAndSet(this, j6);
                }
                long andSet3 = this.missedProduced;
                if (andSet3 != j6) {
                    andSet3 = MISSED_PRODUCED.getAndSet(this, j6);
                }
                Z9.e eVar2 = this.subscription;
                j5 = j6;
                if (this.cancelled) {
                    if (eVar2 != null) {
                        eVar2.cancel();
                        this.subscription = null;
                    }
                    if (andSet != null) {
                        andSet.cancel();
                    }
                } else {
                    long jAddCap2 = this.requested;
                    if (jAddCap2 != Long.MAX_VALUE) {
                        jAddCap2 = Operators.addCap(jAddCap2, andSet2);
                        if (jAddCap2 != Long.MAX_VALUE) {
                            jAddCap2 -= andSet3;
                            if (jAddCap2 < j5) {
                                Operators.reportMoreProduced();
                                jAddCap2 = j5;
                            }
                        }
                        this.requested = jAddCap2;
                    }
                    if (andSet != null) {
                        if (eVar2 != null && shouldCancelCurrent()) {
                            eVar2.cancel();
                        }
                        this.subscription = andSet;
                        if (jAddCap2 != j5) {
                            jAddCap = Operators.addCap(jAddCap, jAddCap2 - j10);
                            eVar = andSet;
                        }
                    } else if (andSet2 != j5 && eVar2 != null) {
                        jAddCap = Operators.addCap(jAddCap, andSet2);
                        j10 += andSet2;
                        eVar = eVar2;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    break;
                } else {
                    j6 = j5;
                }
            }
            if (jAddCap != j5) {
                eVar.request(jAddCap);
            }
        }

        public final boolean isCancelled() {
            return this.cancelled;
        }

        public final boolean isUnbounded() {
            return this.unbounded;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public abstract /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            set(eVar);
        }

        public final void produced(long j5) {
            if (this.unbounded) {
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j6 = this.requested;
                    if (j6 != Long.MAX_VALUE) {
                        long j10 = j6 - j5;
                        if (j10 < 0) {
                            Operators.reportMoreProduced();
                            j10 = 0;
                        }
                        this.requested = j10;
                    } else {
                        this.unbounded = true;
                    }
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            Operators.addCap(MISSED_PRODUCED, this, j5);
            drain();
        }

        public final void producedOne() {
            if (this.unbounded) {
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j5 = this.requested;
                    if (j5 != Long.MAX_VALUE) {
                        long j6 = j5 - 1;
                        if (j6 < 0) {
                            Operators.reportMoreProduced();
                            j6 = 0;
                        }
                        this.requested = j6;
                    } else {
                        this.unbounded = true;
                    }
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            Operators.addCap(MISSED_PRODUCED, this, 1L);
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public final void request(long j5) {
            if (!Operators.validate(j5) || this.unbounded) {
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j6 = this.requested;
                    if (j6 != Long.MAX_VALUE) {
                        long jAddCap = Operators.addCap(j6, j5);
                        this.requested = jAddCap;
                        if (jAddCap == Long.MAX_VALUE) {
                            this.unbounded = true;
                        }
                    }
                    Z9.e eVar = this.subscription;
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        drainLoop();
                    }
                    if (eVar != null) {
                        eVar.request(j5);
                        return;
                    }
                    return;
                }
            }
            Operators.addCap(MISSED_REQUESTED, this, j5);
            drain();
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.missedSubscription != null ? this.missedSubscription : this.subscription : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled()) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(Operators.addCap(this.requested, this.missedRequested)) : super.scanUnsafe(attr);
        }

        public final void set(Z9.e eVar) {
            if (this.cancelled) {
                eVar.cancel();
                return;
            }
            Objects.requireNonNull(eVar);
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    Z9.e eVar2 = this.subscription;
                    if (eVar2 != null && shouldCancelCurrent()) {
                        eVar2.cancel();
                    }
                    this.subscription = eVar;
                    long j5 = this.requested;
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        drainLoop();
                    }
                    if (j5 != 0) {
                        eVar.request(j5);
                        return;
                    }
                    return;
                }
            }
            Z9.e andSet = MISSED_SUBSCRIPTION.getAndSet(this, eVar);
            if (andSet != null && shouldCancelCurrent()) {
                andSet.cancel();
            }
            drain();
        }

        public boolean shouldCancelCurrent() {
            return false;
        }
    }

    public static final class ScalarSubscription<T> implements Fuseable.SynchronousSubscription<T>, InnerProducer<T> {
        static final AtomicIntegerFieldUpdater<ScalarSubscription> ONCE = AtomicIntegerFieldUpdater.newUpdater(ScalarSubscription.class, "once");
        final CoreSubscriber<? super T> actual;
        volatile int once;

        @Nullable
        final String stepName;
        final T value;

        public ScalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t9) {
            this(coreSubscriber, t9, null);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.SynchronousSubscription, reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            if (this.once == 0) {
                Operators.onDiscard(this.value, this.actual.currentContext());
            }
            ONCE.lazySet(this, 2);
        }

        @Override // java.util.Collection
        public void clear() {
            if (this.once == 0) {
                Operators.onDiscard(this.value, this.actual.currentContext());
            }
            ONCE.lazySet(this, 1);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.once != 0;
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            if (this.once != 0) {
                return null;
            }
            ONCE.lazySet(this, 1);
            return this.value;
        }

        @Override // reactor.core.Fuseable.SynchronousSubscription, reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5) && ONCE.compareAndSet(this, 0, 1)) {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onNext(this.value);
                if (this.once != 2) {
                    coreSubscriber.onComplete();
                }
            }
        }

        @Override // reactor.core.Fuseable.SynchronousSubscription, reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return (i & 1) != 0 ? 1 : 0;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.once == 1);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.once == 2);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return !isEmpty() ? 1 : 0;
        }

        @Override // reactor.core.Scannable
        public String stepName() {
            String str = this.stepName;
            if (str != null) {
                return str;
            }
            return "scalarSubscription(" + this.value + ")";
        }

        public ScalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t9, String str) {
            Objects.requireNonNull(t9, "value");
            this.value = t9;
            Objects.requireNonNull(coreSubscriber, "actual");
            this.actual = coreSubscriber;
            this.stepName = str;
        }
    }

    public static long addCap(long j5, long j6) {
        long j10 = j5 + j6;
        if (j10 < 0) {
            return Long.MAX_VALUE;
        }
        return j10;
    }

    public static <T> long addCapCancellable(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t9, long j5) {
        long j6;
        while (true) {
            j6 = atomicLongFieldUpdater.get(t9);
            if (j6 == Long.MIN_VALUE || j6 == Long.MAX_VALUE) {
                break;
            }
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t10 = t9;
            if (atomicLongFieldUpdater2.compareAndSet(t10, j6, addCap(j6, j5))) {
                break;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t9 = t10;
        }
        return j6;
    }

    @Nullable
    public static <T> Fuseable.QueueSubscription<T> as(Z9.e eVar) {
        if (eVar instanceof Fuseable.QueueSubscription) {
            return (Fuseable.QueueSubscription) eVar;
        }
        return null;
    }

    public static boolean canAppearAfterOnSubscribe(Z9.e eVar) {
        return eVar == EmptySubscription.FROM_SUBSCRIBE_INSTANCE;
    }

    public static Z9.e cancelledSubscription() {
        return CancelledSubscription.INSTANCE;
    }

    public static void complete(Z9.d dVar) {
        dVar.onSubscribe(EmptySubscription.INSTANCE);
        dVar.onComplete();
    }

    public static final <R> Function<Context, Context> discardLocalAdapter(Class<R> cls, Consumer<? super R> consumer) {
        Objects.requireNonNull(cls, "onDiscard must be based on a type");
        Objects.requireNonNull(consumer, "onDiscard must be provided a discardHook Consumer");
        return new I(new T(cls, consumer, 1), 2);
    }

    public static <T> CoreSubscriber<T> drainSubscriber() {
        return DrainSubscriber.INSTANCE;
    }

    public static <T> CoreSubscriber<T> emptySubscriber() {
        return EMPTY_SUBSCRIBER;
    }

    public static Z9.e emptySubscription() {
        return EmptySubscription.INSTANCE;
    }

    public static final Context enableOnDiscard(@Nullable Context context, Consumer<?> consumer) {
        Objects.requireNonNull(consumer, "discardConsumer must be provided");
        return context == null ? Context.of("reactor.onDiscard.local", consumer) : context.put("reactor.onDiscard.local", consumer);
    }

    public static void error(Z9.d dVar, Throwable th) {
        dVar.onSubscribe(EmptySubscription.INSTANCE);
        dVar.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$discardLocalAdapter$0(Class cls, Consumer consumer, Object obj) {
        if (cls.isInstance(obj)) {
            consumer.accept(cls.cast(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$discardLocalAdapter$1(Consumer consumer, Context context) {
        Consumer consumer2 = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        return consumer2 == null ? context.put("reactor.onDiscard.local", consumer) : context.put("reactor.onDiscard.local", consumer.andThen(consumer2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDiscardMultiple$3(Consumer consumer, Object obj) {
        try {
            consumer.accept(obj);
        } catch (Throwable th) {
            log.warn("Error while discarding a stream element, continuing with next element", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDiscardMultiple$4(Consumer consumer, Object obj) {
        if (obj != null) {
            try {
                consumer.accept(obj);
            } catch (Throwable th) {
                log.warn("Error while discarding element from an Iterator, continuing with next element", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDiscardMultiple$5(Consumer consumer, Object obj) {
        if (obj != null) {
            try {
                consumer.accept(obj);
            } catch (Throwable th) {
                log.warn("Error while discarding element from an Spliterator, continuing with next element", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDiscardQueueWithClear$2(Consumer consumer, Object obj) {
        try {
            consumer.accept(obj);
        } catch (Throwable th) {
            log.warn("Error while discarding item extracted from a queue element, continuing with next item", th);
        }
    }

    public static <I, O> Function<? super Z9.c, ? extends Z9.c> lift(BiFunction<Scannable, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
        return LiftFunction.liftScannable(null, biFunction);
    }

    public static <I, O> Function<? super Z9.c, ? extends Z9.c> liftPublisher(BiFunction<Z9.c, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
        return LiftFunction.liftPublisher(null, biFunction);
    }

    public static Context multiSubscribersContext(InnerProducer<?>[] innerProducerArr) {
        return innerProducerArr.length > 0 ? innerProducerArr[0].actual().currentContext() : Context.empty();
    }

    public static long multiplyCap(long j5, long j6) {
        long j10 = j5 * j6;
        if (((j5 | j6) >>> 31) == 0 || j10 / j5 == j6) {
            return j10;
        }
        return Long.MAX_VALUE;
    }

    public static <T> void onDiscard(@Nullable T t9, Context context) {
        Consumer consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        if (t9 == null || consumer == null) {
            return;
        }
        try {
            consumer.accept(t9);
        } catch (Throwable th) {
            log.warn("Error in discard hook", th);
        }
    }

    public static void onDiscardMultiple(Stream<?> stream, Context context) {
        Consumer consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        if (consumer != null) {
            try {
                stream.filter(new L(3)).forEach(new d0(1, consumer));
            } catch (Throwable th) {
                log.warn("Error while discarding stream, stopping", th);
            }
        }
    }

    public static <T> void onDiscardQueueWithClear(@Nullable Queue<T> queue, Context context, @Nullable Function<T, Stream<?>> function) {
        if (queue == null) {
            return;
        }
        Consumer consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        if (consumer == null) {
            queue.clear();
            return;
        }
        while (true) {
            try {
                T tPoll = queue.poll();
                if (tPoll == null) {
                    return;
                }
                if (function != null) {
                    try {
                        function.apply(tPoll).forEach(new d0(3, consumer));
                    } catch (Throwable th) {
                        log.warn("Error while extracting items to discard from queue element, continuing with next queue element", th);
                    }
                } else {
                    try {
                        consumer.accept(tPoll);
                    } catch (Throwable th2) {
                        log.warn("Error while discarding a queue element, continuing with next queue element", th2);
                    }
                }
            } catch (Throwable th3) {
                log.warn("Cannot further apply discard hook while discarding and clearing a queue", th3);
                return;
            }
        }
    }

    public static void onErrorDropped(Throwable th, Context context) {
        Consumer<? super Throwable> consumer = (Consumer) context.getOrDefault("reactor.onErrorDropped.local", null);
        if (consumer == null) {
            consumer = Hooks.onErrorDroppedHook;
        }
        if (consumer == null) {
            log.error("Operator called default onErrorDropped", th);
        } else {
            consumer.accept(th);
        }
    }

    public static void onErrorDroppedMulticast(Throwable th, InnerProducer<?>[] innerProducerArr) {
        onErrorDropped(th, multiSubscribersContext(innerProducerArr));
    }

    public static <T> CorePublisher<T> onLastAssembly(CorePublisher<T> corePublisher) {
        Function<Z9.c, Z9.c> function = Hooks.onLastOperatorHook;
        if (function == null) {
            return corePublisher;
        }
        Z9.c cVarApply = function.apply(corePublisher);
        Objects.requireNonNull(cVarApply, "LastOperator hook returned null");
        Z9.c cVar = cVarApply;
        return cVar instanceof CorePublisher ? (CorePublisher) cVar : new CorePublisherAdapter(cVar);
    }

    public static <T> void onNextDropped(T t9, Context context) {
        Objects.requireNonNull(t9, "onNext");
        Objects.requireNonNull(context, "context");
        Consumer<Object> consumer = (Consumer) context.getOrDefault("reactor.onNextDropped.local", null);
        if (consumer == null) {
            consumer = Hooks.onNextDroppedHook;
        }
        if (consumer != null) {
            consumer.accept(t9);
            return;
        }
        Logger logger = log;
        if (logger.isDebugEnabled()) {
            logger.debug("onNextDropped: " + t9);
        }
    }

    public static <T> void onNextDroppedMulticast(T t9, InnerProducer<?>[] innerProducerArr) {
        onNextDropped(t9, multiSubscribersContext(innerProducerArr));
    }

    @Nullable
    public static <T> Throwable onNextError(@Nullable T t9, Throwable th, Context context, Z9.e eVar) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (!onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) t9)) {
            return onOperatorError(eVar, thUnwrapOnNextError, t9, context);
        }
        Throwable thProcess = onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, t9, context);
        if (thProcess != null) {
            eVar.cancel();
        }
        return thProcess;
    }

    public static final BiFunction<? super Throwable, Object, ? extends Throwable> onNextErrorFunction(Context context) {
        return onNextErrorStrategy(context);
    }

    public static final OnNextFailureStrategy onNextErrorStrategy(Context context) {
        OnNextFailureStrategy lambdaOnNextErrorStrategy = null;
        BiFunction biFunction = (BiFunction) context.getOrDefault(OnNextFailureStrategy.KEY_ON_NEXT_ERROR_STRATEGY, null);
        if (biFunction instanceof OnNextFailureStrategy) {
            lambdaOnNextErrorStrategy = (OnNextFailureStrategy) biFunction;
        } else if (biFunction != null) {
            lambdaOnNextErrorStrategy = new OnNextFailureStrategy.LambdaOnNextErrorStrategy(biFunction);
        }
        if (lambdaOnNextErrorStrategy == null) {
            lambdaOnNextErrorStrategy = Hooks.onNextErrorHook;
        }
        return lambdaOnNextErrorStrategy == null ? OnNextFailureStrategy.STOP : lambdaOnNextErrorStrategy;
    }

    public static <T> Throwable onNextInnerError(Throwable th, Context context, @Nullable Z9.e eVar) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) null) && (thUnwrapOnNextError = onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, null, context)) != null && eVar != null) {
            eVar.cancel();
        }
        return thUnwrapOnNextError;
    }

    @Nullable
    public static <T> RuntimeException onNextPollError(@Nullable T t9, Throwable th, Context context) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (!onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) t9)) {
            return Exceptions.propagate(onOperatorError(null, thUnwrapOnNextError, t9, context));
        }
        Throwable thProcess = onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, t9, context);
        if (thProcess != null) {
            return Exceptions.propagate(thProcess);
        }
        return null;
    }

    public static Throwable onOperatorError(Throwable th, Context context) {
        return onOperatorError(null, th, context);
    }

    public static RuntimeException onRejectedExecution(Throwable th, Context context) {
        return onRejectedExecution(th, null, null, null, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> long produced(java.util.concurrent.atomic.AtomicLongFieldUpdater<T> r6, T r7, long r8) {
        /*
        L0:
            long r2 = r6.get(r7)
            r0 = 0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L24
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto L14
            goto L24
        L14:
            long r4 = subOrZero(r2, r8)
            r0 = r6
            r1 = r7
            boolean r6 = r0.compareAndSet(r1, r2, r4)
            if (r6 == 0) goto L21
            return r4
        L21:
            r6 = r0
            r7 = r1
            goto L0
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.Operators.produced(java.util.concurrent.atomic.AtomicLongFieldUpdater, java.lang.Object, long):long");
    }

    public static <T> long producedCancellable(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t9, long j5) {
        while (true) {
            long j6 = atomicLongFieldUpdater.get(t9);
            if (j6 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j6 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            long j10 = j6 - j5;
            long j11 = 0;
            if (j10 < 0) {
                reportBadRequest(j10);
            } else {
                j11 = j10;
            }
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t10 = t9;
            if (atomicLongFieldUpdater2.compareAndSet(t10, j6, j11)) {
                return j11;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t9 = t10;
        }
    }

    public static <F> boolean replace(AtomicReferenceFieldUpdater<F, Z9.e> atomicReferenceFieldUpdater, F f, Z9.e eVar) {
        Z9.e eVar2;
        do {
            eVar2 = atomicReferenceFieldUpdater.get(f);
            if (eVar2 == CancelledSubscription.INSTANCE) {
                eVar.cancel();
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(f, eVar2, eVar));
        return true;
    }

    public static void reportBadRequest(long j5) {
        Logger logger = log;
        if (logger.isDebugEnabled()) {
            logger.debug("Negative request", Exceptions.nullOrNegativeRequestException(j5));
        }
    }

    public static void reportMoreProduced() {
        Logger logger = log;
        if (logger.isDebugEnabled()) {
            logger.debug("More data produced than requested", Exceptions.failWithOverflow());
        }
    }

    public static void reportSubscriptionSet() {
        Logger logger = log;
        if (logger.isDebugEnabled()) {
            logger.debug("Duplicate Subscription has been detected", Exceptions.duplicateOnSubscribeException());
        }
    }

    public static void reportThrowInSubscribe(CoreSubscriber<?> coreSubscriber, Throwable th) {
        try {
            coreSubscriber.onSubscribe(EmptySubscription.FROM_SUBSCRIBE_INSTANCE);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            th.addSuppressed(th2);
        }
        coreSubscriber.onError(onOperatorError(th, coreSubscriber.currentContext()));
    }

    public static <T> CoreSubscriber<T> restoreContextOnSubscriber(Z9.c cVar, CoreSubscriber<T> coreSubscriber) {
        return cVar instanceof Fuseable ? new FluxContextWriteRestoringThreadLocalsFuseable.FuseableContextWriteRestoringThreadLocalsSubscriber(coreSubscriber, coreSubscriber.currentContext()) : new FluxContextWriteRestoringThreadLocals.ContextWriteRestoringThreadLocalsSubscriber(coreSubscriber, coreSubscriber.currentContext());
    }

    public static <T> CoreSubscriber<? super T> restoreContextOnSubscriberIfAutoCPEnabled(Z9.c cVar, CoreSubscriber<? super T> coreSubscriber) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? restoreContextOnSubscriber(cVar, coreSubscriber) : coreSubscriber;
    }

    public static <T> CoreSubscriber<T> restoreContextOnSubscriberIfPublisherNonInternal(Z9.c cVar, CoreSubscriber<T> coreSubscriber) {
        return ContextPropagationSupport.shouldWrapPublisher(cVar) ? restoreContextOnSubscriber(cVar, coreSubscriber) : coreSubscriber;
    }

    public static <T> CoreSubscriber<? super T>[] restoreContextOnSubscribers(Z9.c cVar, CoreSubscriber<? super T>[] coreSubscriberArr) {
        CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[coreSubscriberArr.length];
        for (int i = 0; i < coreSubscriberArr.length; i++) {
            coreSubscriberArr2[i] = restoreContextOnSubscriber(cVar, coreSubscriberArr[i]);
        }
        return coreSubscriberArr2;
    }

    public static <T> Z9.e scalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t9) {
        return new ScalarSubscription(coreSubscriber, t9);
    }

    public static <T> CoreSubscriber<T> serialize(CoreSubscriber<? super T> coreSubscriber) {
        return new SerializedSubscriber(coreSubscriber);
    }

    public static <F> boolean set(AtomicReferenceFieldUpdater<F, Z9.e> atomicReferenceFieldUpdater, F f, Z9.e eVar) {
        Z9.e eVar2;
        do {
            eVar2 = atomicReferenceFieldUpdater.get(f);
            if (eVar2 == CancelledSubscription.INSTANCE) {
                eVar.cancel();
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(f, eVar2, eVar));
        if (eVar2 == null) {
            return true;
        }
        eVar2.cancel();
        return true;
    }

    public static <F> boolean setOnce(AtomicReferenceFieldUpdater<F, Z9.e> atomicReferenceFieldUpdater, F f, Z9.e eVar) {
        Objects.requireNonNull(eVar, "subscription");
        Z9.e eVar2 = atomicReferenceFieldUpdater.get(f);
        CancelledSubscription cancelledSubscription = CancelledSubscription.INSTANCE;
        if (eVar2 == cancelledSubscription) {
            eVar.cancel();
            return false;
        }
        if (eVar2 != null) {
            eVar.cancel();
            reportSubscriptionSet();
            return false;
        }
        if (atomicReferenceFieldUpdater.compareAndSet(f, null, eVar)) {
            return true;
        }
        if (atomicReferenceFieldUpdater.get(f) == cancelledSubscription) {
            eVar.cancel();
            return false;
        }
        eVar.cancel();
        reportSubscriptionSet();
        return false;
    }

    public static long subOrZero(long j5, long j6) {
        long j10 = j5 - j6;
        if (j10 < 0) {
            return 0L;
        }
        return j10;
    }

    public static <F> boolean terminate(AtomicReferenceFieldUpdater<F, Z9.e> atomicReferenceFieldUpdater, F f) {
        Z9.e andSet;
        Z9.e eVar = atomicReferenceFieldUpdater.get(f);
        CancelledSubscription cancelledSubscription = CancelledSubscription.INSTANCE;
        if (eVar == cancelledSubscription || (andSet = atomicReferenceFieldUpdater.getAndSet(f, cancelledSubscription)) == null || andSet == cancelledSubscription) {
            return false;
        }
        andSet.cancel();
        return true;
    }

    public static <T> Fuseable.ConditionalSubscriber<? super T> toConditionalSubscriber(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "actual");
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? (Fuseable.ConditionalSubscriber) coreSubscriber : new ConditionalSubscriberAdapter(coreSubscriber);
    }

    public static <T> CoreSubscriber<? super T> toCoreSubscriber(Z9.d dVar) {
        Objects.requireNonNull(dVar, "actual");
        return dVar instanceof CoreSubscriber ? (CoreSubscriber) dVar : new StrictSubscriber(dVar);
    }

    public static <T> CorePublisher<T> toFluxOrMono(Z9.c cVar) {
        return cVar instanceof Mono ? Mono.fromDirect(cVar) : Flux.from(cVar);
    }

    public static int unboundedOrLimit(int i) {
        if (i == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i - (i >> 2);
    }

    public static long unboundedOrPrefetch(int i) {
        if (i == Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return i;
    }

    private static Throwable unwrapOnNextError(Throwable th) {
        return Exceptions.isBubbling(th) ? th : Exceptions.unwrap(th);
    }

    public static boolean validate(@Nullable Z9.e eVar, Z9.e eVar2) {
        Objects.requireNonNull(eVar2, "Subscription cannot be null");
        if (eVar == null) {
            return true;
        }
        eVar2.cancel();
        return false;
    }

    public static <T> long addCap(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t9, long j5) {
        while (true) {
            long j6 = atomicLongFieldUpdater.get(t9);
            if (j6 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t10 = t9;
            if (atomicLongFieldUpdater2.compareAndSet(t10, j6, addCap(j6, j5))) {
                return j6;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t9 = t10;
        }
    }

    public static <O> Function<? super Z9.c, ? extends Z9.c> lift(Predicate<Scannable> predicate, BiFunction<Scannable, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super O>> biFunction) {
        return LiftFunction.liftScannable(predicate, biFunction);
    }

    public static <O> Function<? super Z9.c, ? extends Z9.c> liftPublisher(Predicate<Z9.c> predicate, BiFunction<Z9.c, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super O>> biFunction) {
        return LiftFunction.liftPublisher(predicate, biFunction);
    }

    public static Throwable onOperatorError(@Nullable Z9.e eVar, Throwable th, Context context) {
        return onOperatorError(eVar, th, null, context);
    }

    public static RuntimeException onRejectedExecution(Throwable th, @Nullable Z9.e eVar, @Nullable Throwable th2, @Nullable Object obj, Context context) {
        if (context.hasKey("reactor.onRejectedExecution.local")) {
            context = context.put("reactor.onOperatorError.local", context.get("reactor.onRejectedExecution.local"));
        }
        RejectedExecutionException rejectedExecutionExceptionFailWithRejected = Exceptions.failWithRejected(th);
        if (th2 != null) {
            rejectedExecutionExceptionFailWithRejected.addSuppressed(th2);
        }
        return obj != null ? Exceptions.propagate(onOperatorError(eVar, rejectedExecutionExceptionFailWithRejected, obj, context)) : Exceptions.propagate(onOperatorError(eVar, rejectedExecutionExceptionFailWithRejected, context));
    }

    public static <T> Z9.e scalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t9, String str) {
        return new ScalarSubscription(coreSubscriber, t9, str);
    }

    public static int unboundedOrLimit(int i, int i6) {
        if (i6 <= 0) {
            return i;
        }
        if (i6 >= i) {
            return unboundedOrLimit(i);
        }
        if (i == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i6;
    }

    public static Throwable onOperatorError(@Nullable Z9.e eVar, Throwable th, @Nullable Object obj, Context context) {
        Exceptions.throwIfFatal(th);
        if (eVar != null) {
            eVar.cancel();
        }
        Throwable thUnwrap = Exceptions.unwrap(th);
        BiFunction<? super Throwable, Object, ? extends Throwable> biFunction = (BiFunction) context.getOrDefault("reactor.onOperatorError.local", null);
        if (biFunction == null) {
            biFunction = Hooks.onOperatorErrorHook;
        }
        if (biFunction == null) {
            return (obj == null || obj == thUnwrap || !(obj instanceof Throwable)) ? thUnwrap : Exceptions.addSuppressed(thUnwrap, (Throwable) obj);
        }
        return biFunction.apply(th, obj);
    }

    public static boolean validate(long j5) {
        if (j5 > 0) {
            return true;
        }
        reportBadRequest(j5);
        return false;
    }

    public static <T> void toFluxOrMono(Z9.c[] cVarArr) {
        for (int i = 0; i < cVarArr.length; i++) {
            Z9.c cVar = cVarArr[i];
            if (cVar != null) {
                cVarArr[i] = toFluxOrMono(cVar);
            }
        }
    }

    public static void onDiscardMultiple(@Nullable Collection<?> collection, Context context) {
        Consumer consumer;
        if (collection == null || (consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null)) == null) {
            return;
        }
        try {
            if (collection.isEmpty()) {
                return;
            }
            for (Object obj : collection) {
                if (obj != null) {
                    try {
                        consumer.accept(obj);
                    } catch (Throwable th) {
                        log.warn("Error while discarding element from a Collection, continuing with next element", th);
                    }
                }
            }
        } catch (Throwable th2) {
            log.warn("Error while discarding collection, stopping", th2);
        }
    }

    @Nullable
    public static <T> Throwable onNextError(@Nullable T t9, Throwable th, Context context) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) t9)) {
            return onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, t9, context);
        }
        return onOperatorError(null, thUnwrapOnNextError, t9, context);
    }

    public static void onDiscardMultiple(@Nullable Iterator<?> it, boolean z10, Context context) {
        Consumer consumer;
        if (it == null || !z10 || (consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null)) == null) {
            return;
        }
        try {
            it.forEachRemaining(new d0(2, consumer));
        } catch (Throwable th) {
            log.warn("Error while discarding Iterator, stopping", th);
        }
    }

    public static void onDiscardMultiple(@Nullable Spliterator<?> spliterator, boolean z10, Context context) {
        Consumer consumer;
        if (spliterator == null || !z10 || (consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null)) == null) {
            return;
        }
        try {
            spliterator.forEachRemaining(new d0(0, consumer));
        } catch (Throwable th) {
            log.warn("Error while discarding Spliterator, stopping", th);
        }
    }
}
