package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
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

/* loaded from: classes5.dex */
public abstract class Operators {
    static final Fuseable.ConditionalSubscriber<?> EMPTY_SUBSCRIBER = new Fuseable.ConditionalSubscriber<Object>() { // from class: reactor.core.publisher.Operators.1
        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return Context.empty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onComplete should not be used"));
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onError should not be used", th));
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onNext should not be used, got " + obj));
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("onSubscribe should not be used"));
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(Object obj) {
            Operators.log.error("Unexpected call to Operators.emptySubscriber()", new IllegalStateException("tryOnNext should not be used, got " + obj));
            return false;
        }
    };
    static final Logger log = Loggers.getLogger((Class<?>) Operators.class);

    public static abstract class BaseFluxToMonoOperator<I, O> implements InnerOperator<I, O>, Fuseable, Fuseable.QueueSubscription<I> {
        static final AtomicIntegerFieldUpdater<BaseFluxToMonoOperator> STATE = AtomicIntegerFieldUpdater.newUpdater(BaseFluxToMonoOperator.class, VoiceWakeupReceiver.EXTRA_STATE);
        final CoreSubscriber<? super O> actual;
        boolean hasRequest;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39687s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39687s.cancel();
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public abstract /* synthetic */ void onComplete();

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public abstract /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public abstract /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39687s, dVar)) {
                this.f39687s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public final I poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (this.hasRequest) {
                return;
            }
            this.hasRequest = true;
            int i10 = this.state;
            if ((i10 & 1) != 1 && STATE.compareAndSet(this, i10, i10 | 1)) {
                if (i10 == 0) {
                    this.f39687s.request(Long.MAX_VALUE);
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
        public final int requestFusion(int i10) {
            return 0;
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            return attr == Scannable.Attr.PARENT ? this.f39687s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public final int size() {
            return 0;
        }
    }

    public static final class CancelledSubscription implements qc.d, Scannable {
        static final CancelledSubscription INSTANCE = new CancelledSubscription();

        @Override // qc.d
        public void cancel() {
        }

        @Override // qc.d
        public void request(long j10) {
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.delegate.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.delegate.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.delegate.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            this.delegate.onSubscribe(dVar);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            this.delegate.onNext(t10);
            return true;
        }
    }

    public static final class CorePublisherAdapter<T> implements CorePublisher<T> {
        final qc.b<T> publisher;

        public CorePublisherAdapter(qc.b<T> bVar) {
            this.publisher = bVar;
        }

        @Override // reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            this.publisher.subscribe(coreSubscriber);
        }

        @Override // reactor.core.CorePublisher, qc.b
        public void subscribe(qc.c<? super T> cVar) {
            this.publisher.subscribe(cVar);
        }
    }

    public static class DeferredSubscription implements qc.d, Scannable {
        static final AtomicLongFieldUpdater<DeferredSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(DeferredSubscription.class, "requested");
        static final int STATE_CANCELLED = -2;
        static final int STATE_SUBSCRIBED = -1;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39688s;

        @Override // qc.d
        public void cancel() {
            long andSet = REQUESTED.getAndSet(this, -2L);
            if (andSet != -2 && andSet == -1) {
                this.f39688s.cancel();
            }
        }

        public boolean isCancelled() {
            return this.requested == -2;
        }

        @Override // qc.d
        public void request(long j10) {
            DeferredSubscription deferredSubscription;
            long j11 = this.requested;
            if (j11 > -1) {
                long j12 = j11;
                while (j12 != Long.MAX_VALUE) {
                    deferredSubscription = this;
                    if (REQUESTED.compareAndSet(deferredSubscription, j12, Operators.addCap(j12, j10))) {
                        return;
                    }
                    j12 = deferredSubscription.requested;
                    if (j12 < 0) {
                        j11 = j12;
                    } else {
                        this = deferredSubscription;
                    }
                }
                return;
            }
            deferredSubscription = this;
            if (j11 == -2) {
                return;
            }
            deferredSubscription.f39688s.request(j10);
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            long j10 = this.requested;
            if (attr == Scannable.Attr.PARENT) {
                return this.f39688s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                if (j10 < 0) {
                    j10 = 0;
                }
                return Long.valueOf(j10);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isCancelled());
            }
            return null;
        }

        public final boolean set(qc.d dVar) {
            Objects.requireNonNull(dVar, "s");
            long j10 = this.requested;
            qc.d dVar2 = this.f39688s;
            if (j10 == -2) {
                dVar.cancel();
                return false;
            }
            if (dVar2 != null) {
                dVar.cancel();
                Operators.reportSubscriptionSet();
                return false;
            }
            long j11 = 0;
            while (true) {
                long j12 = this.requested;
                if (j12 == -2 || j12 == -1) {
                    break;
                }
                this.f39688s = dVar;
                long j13 = j12 - j11;
                if (j13 > 0) {
                    dVar.request(j13);
                }
                long j14 = j13 + j11;
                if (REQUESTED.compareAndSet(this, j12, -1L)) {
                    return true;
                }
                j11 = j14;
            }
            dVar.cancel();
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

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            Operators.onErrorDropped(Exceptions.errorCallbackNotImplemented(th), Context.empty());
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public static final class EmptySubscription implements Fuseable.QueueSubscription<Object>, Scannable {
        static final EmptySubscription INSTANCE = new EmptySubscription();
        static final EmptySubscription FROM_SUBSCRIBE_INSTANCE = new EmptySubscription();

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
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

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
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

    public static final class LiftFunction<I, O> implements Function<qc.b<I>, qc.b<O>> {
        final Predicate<qc.b> filter;
        final BiFunction<qc.b, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> lifter;
        final String name;

        private LiftFunction(@Nullable Predicate<qc.b> predicate, BiFunction<qc.b, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction, String str) {
            this.filter = predicate;
            Objects.requireNonNull(biFunction, "lifter");
            this.lifter = biFunction;
            Objects.requireNonNull(str, "name");
            this.name = str;
        }

        public static final <I, O> LiftFunction<I, O> liftPublisher(@Nullable Predicate<qc.b> predicate, final BiFunction<qc.b, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
            Objects.requireNonNull(biFunction, "lifter");
            return new LiftFunction<>(predicate, new BiFunction() { // from class: reactor.core.publisher.g2
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    qc.b bVar = (qc.b) obj;
                    return Operators.restoreContextOnSubscriberIfPublisherNonInternal(bVar, (CoreSubscriber) biFunction.apply(bVar, Operators.restoreContextOnSubscriberIfAutoCPEnabled(bVar, (CoreSubscriber) obj2)));
                }
            }, biFunction.toString());
        }

        public static final <I, O> LiftFunction<I, O> liftScannable(@Nullable final Predicate<Scannable> predicate, final BiFunction<Scannable, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
            Objects.requireNonNull(biFunction, "lifter");
            return new LiftFunction<>(predicate != null ? new Predicate() { // from class: reactor.core.publisher.e2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return predicate.test(Scannable.from((qc.b) obj));
                }
            } : null, new BiFunction() { // from class: reactor.core.publisher.f2
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    qc.b bVar = (qc.b) obj;
                    return Operators.restoreContextOnSubscriberIfPublisherNonInternal(bVar, (CoreSubscriber) biFunction.apply(Scannable.from(bVar), Operators.restoreContextOnSubscriberIfAutoCPEnabled(bVar, (CoreSubscriber) obj2)));
                }
            }, biFunction.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public qc.b<O> apply(qc.b<I> bVar) {
            Predicate<qc.b> predicate = this.filter;
            return (predicate == null || predicate.test(bVar)) ? bVar instanceof Fuseable ? bVar instanceof Mono ? new MonoLiftFuseable(bVar, this) : bVar instanceof ParallelFlux ? new ParallelLiftFuseable((ParallelFlux) bVar, this) : bVar instanceof ConnectableFlux ? new ConnectableLiftFuseable((ConnectableFlux) bVar, this) : bVar instanceof GroupedFlux ? new GroupedLiftFuseable((GroupedFlux) bVar, this) : new FluxLiftFuseable(bVar, this) : bVar instanceof Mono ? new MonoLift(bVar, this) : bVar instanceof ParallelFlux ? new ParallelLift((ParallelFlux) bVar, this) : bVar instanceof ConnectableFlux ? new ConnectableLift((ConnectableFlux) bVar, this) : bVar instanceof GroupedFlux ? new GroupedLift((GroupedFlux) bVar, this) : new FluxLift(bVar, this) : bVar;
        }
    }

    public static class MonoInnerProducerBase<O> implements InnerProducer<O> {
        private static final int CANCELLED = 128;
        private static final int HAS_COMPLETED = 4;
        private static final int HAS_REQUEST = 2;
        private static final int HAS_VALUE = 1;
        private static final AtomicIntegerFieldUpdater<MonoInnerProducerBase> STATE = AtomicIntegerFieldUpdater.newUpdater(MonoInnerProducerBase.class, VoiceWakeupReceiver.EXTRA_STATE);
        private final CoreSubscriber<? super O> actual;
        private volatile int state;
        private O value;

        public MonoInnerProducerBase(CoreSubscriber<? super O> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        private static boolean hasCompleted(int i10) {
            return (i10 & 4) == 4;
        }

        private static boolean hasRequest(int i10) {
            return (i10 & 2) == 2;
        }

        private static boolean hasValue(int i10) {
            return (i10 & 1) == 1;
        }

        private static boolean isCancelled(int i10) {
            return i10 == 128;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super O> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
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

        public final void complete(O o10) {
            int i10;
            do {
                i10 = this.state;
                if (isCancelled(i10)) {
                    discard(o10);
                    return;
                }
                if (hasRequest(i10) && STATE.compareAndSet(this, i10, i10 | 5)) {
                    this.value = null;
                    doOnComplete(o10);
                    this.actual.onNext(o10);
                    this.actual.onComplete();
                    return;
                }
                this.value = o10;
            } while (!STATE.compareAndSet(this, i10, i10 | 5));
        }

        public final void discard(@Nullable O o10) {
            Operators.onDiscard(o10, this.actual.currentContext());
        }

        public final void discardTheValue() {
            discard(this.value);
            this.value = null;
        }

        public void doOnCancel() {
        }

        public void doOnComplete(O o10) {
        }

        public void doOnRequest(long j10) {
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            int i10;
            if (Operators.validate(j10)) {
                do {
                    i10 = this.state;
                    if (isCancelled(i10) || hasRequest(i10)) {
                        return;
                    }
                } while (!STATE.compareAndSet(this, i10, i10 | 2));
                doOnRequest(j10);
                if (hasValue(i10) && hasCompleted(i10)) {
                    O o10 = this.value;
                    this.value = null;
                    doOnComplete(o10);
                    this.actual.onNext(o10);
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

        public final void setValue(@Nullable O o10) {
            int i10;
            this.value = o10;
            do {
                i10 = this.state;
                if (isCancelled(i10)) {
                    discardTheValue();
                    return;
                }
            } while (!STATE.compareAndSet(this, i10, i10 | 1));
        }

        public final boolean isCancelled() {
            return this.state == 128;
        }

        public final void complete() {
            while (true) {
                int i10 = this.state;
                if (isCancelled(i10)) {
                    return;
                }
                if (STATE.compareAndSet(this, i10, i10 | 4)) {
                    if (hasValue(i10) && hasRequest(i10)) {
                        O o10 = this.value;
                        this.value = null;
                        doOnComplete(o10);
                        this.actual.onNext(o10);
                        this.actual.onComplete();
                        return;
                    }
                    if (!hasValue(i10)) {
                        this.actual.onComplete();
                        return;
                    } else if (!hasRequest(i10)) {
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
        static final AtomicIntegerFieldUpdater<MonoSubscriber> STATE = AtomicIntegerFieldUpdater.newUpdater(MonoSubscriber.class, VoiceWakeupReceiver.EXTRA_STATE);
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            O o10 = this.value;
            this.value = null;
            STATE.set(this, 4);
            discard(o10);
        }

        @Override // java.util.Collection
        public final void clear() {
            this.value = null;
        }

        public final void complete(@Nullable O o10) {
            while (true) {
                int i10 = this.state;
                if ((i10 & (-3)) != 0) {
                    this.value = null;
                    discard(o10);
                    return;
                } else {
                    if (i10 == 2 && STATE.compareAndSet(this, 2, 3)) {
                        this.value = null;
                        CoreSubscriber<? super O> coreSubscriber = this.actual;
                        coreSubscriber.onNext(o10);
                        coreSubscriber.onComplete();
                        return;
                    }
                    setValue(o10);
                    if (i10 == 0 && STATE.compareAndSet(this, 0, 1)) {
                        return;
                    }
                }
            }
        }

        public void discard(@Nullable O o10) {
            Operators.onDiscard(o10, this.actual.currentContext());
        }

        public final boolean isCancelled() {
            return this.state == 4;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(I i10) {
            setValue(i10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
        }

        @Override // java.util.Queue
        @Nullable
        public final O poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                do {
                    int i10 = this.state;
                    if (i10 == 4 || (i10 & (-2)) != 0) {
                        return;
                    }
                    if (i10 == 1 && STATE.compareAndSet(this, 1, 3)) {
                        O o10 = this.value;
                        if (o10 != null) {
                            this.value = null;
                            CoreSubscriber<? super O> coreSubscriber = this.actual;
                            coreSubscriber.onNext(o10);
                            coreSubscriber.onComplete();
                            return;
                        }
                        return;
                    }
                } while (!STATE.compareAndSet(this, 0, 2));
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
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

        public void setValue(@Nullable O o10) {
            if (STATE.get(this) == 4) {
                discard(o10);
            } else {
                this.value = o10;
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
        volatile qc.d missedSubscription;
        long requested;
        qc.d subscription;
        protected boolean unbounded;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<MultiSubscriptionSubscriber, qc.d> MISSED_SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(MultiSubscriptionSubscriber.class, qc.d.class, "missedSubscription");
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
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
            long j10;
            int iAddAndGet = 1;
            long j11 = 0;
            long jAddCap = 0;
            long j12 = 0;
            qc.d dVar = null;
            while (true) {
                qc.d andSet = this.missedSubscription;
                if (andSet != null) {
                    andSet = MISSED_SUBSCRIPTION.getAndSet(this, null);
                }
                long andSet2 = this.missedRequested;
                if (andSet2 != j11) {
                    andSet2 = MISSED_REQUESTED.getAndSet(this, j11);
                }
                long andSet3 = this.missedProduced;
                if (andSet3 != j11) {
                    andSet3 = MISSED_PRODUCED.getAndSet(this, j11);
                }
                qc.d dVar2 = this.subscription;
                j10 = j11;
                if (this.cancelled) {
                    if (dVar2 != null) {
                        dVar2.cancel();
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
                            if (jAddCap2 < j10) {
                                Operators.reportMoreProduced();
                                jAddCap2 = j10;
                            }
                        }
                        this.requested = jAddCap2;
                    }
                    if (andSet != null) {
                        if (dVar2 != null && shouldCancelCurrent()) {
                            dVar2.cancel();
                        }
                        this.subscription = andSet;
                        if (jAddCap2 != j10) {
                            jAddCap = Operators.addCap(jAddCap, jAddCap2 - j12);
                            dVar = andSet;
                        }
                    } else if (andSet2 != j10 && dVar2 != null) {
                        jAddCap = Operators.addCap(jAddCap, andSet2);
                        j12 += andSet2;
                        dVar = dVar2;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    break;
                } else {
                    j11 = j10;
                }
            }
            if (jAddCap != j10) {
                dVar.request(jAddCap);
            }
        }

        public final boolean isCancelled() {
            return this.cancelled;
        }

        public final boolean isUnbounded() {
            return this.unbounded;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public abstract /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            set(dVar);
        }

        public final void produced(long j10) {
            if (this.unbounded) {
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j11 = this.requested;
                    if (j11 != Long.MAX_VALUE) {
                        long j12 = j11 - j10;
                        if (j12 < 0) {
                            Operators.reportMoreProduced();
                            j12 = 0;
                        }
                        this.requested = j12;
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
            Operators.addCap(MISSED_PRODUCED, this, j10);
            drain();
        }

        public final void producedOne() {
            if (this.unbounded) {
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j10 = this.requested;
                    if (j10 != Long.MAX_VALUE) {
                        long j11 = j10 - 1;
                        if (j11 < 0) {
                            Operators.reportMoreProduced();
                            j11 = 0;
                        }
                        this.requested = j11;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public final void request(long j10) {
            if (!Operators.validate(j10) || this.unbounded) {
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j11 = this.requested;
                    if (j11 != Long.MAX_VALUE) {
                        long jAddCap = Operators.addCap(j11, j10);
                        this.requested = jAddCap;
                        if (jAddCap == Long.MAX_VALUE) {
                            this.unbounded = true;
                        }
                    }
                    qc.d dVar = this.subscription;
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        drainLoop();
                    }
                    if (dVar != null) {
                        dVar.request(j10);
                        return;
                    }
                    return;
                }
            }
            Operators.addCap(MISSED_REQUESTED, this, j10);
            drain();
        }

        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.missedSubscription != null ? this.missedSubscription : this.subscription : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled()) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(Operators.addCap(this.requested, this.missedRequested)) : super.scanUnsafe(attr);
        }

        public final void set(qc.d dVar) {
            if (this.cancelled) {
                dVar.cancel();
                return;
            }
            Objects.requireNonNull(dVar);
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<MultiSubscriptionSubscriber> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    qc.d dVar2 = this.subscription;
                    if (dVar2 != null && shouldCancelCurrent()) {
                        dVar2.cancel();
                    }
                    this.subscription = dVar;
                    long j10 = this.requested;
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        drainLoop();
                    }
                    if (j10 != 0) {
                        dVar.request(j10);
                        return;
                    }
                    return;
                }
            }
            qc.d andSet = MISSED_SUBSCRIPTION.getAndSet(this, dVar);
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

        public ScalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t10) {
            this(coreSubscriber, t10, null);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.SynchronousSubscription, reactor.core.Fuseable.QueueSubscription, qc.d
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

        @Override // reactor.core.Fuseable.SynchronousSubscription, reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            if (Operators.validate(j10) && ONCE.compareAndSet(this, 0, 1)) {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onNext(this.value);
                if (this.once != 2) {
                    coreSubscriber.onComplete();
                }
            }
        }

        @Override // reactor.core.Fuseable.SynchronousSubscription, reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            return (i10 & 1) != 0 ? 1 : 0;
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

        public ScalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t10, String str) {
            Objects.requireNonNull(t10, UxipConstants.f30680s);
            this.value = t10;
            Objects.requireNonNull(coreSubscriber, "actual");
            this.actual = coreSubscriber;
            this.stepName = str;
        }
    }

    public static /* synthetic */ void a(Class cls, Consumer consumer, Object obj) {
        if (cls.isInstance(obj)) {
            consumer.accept(cls.cast(obj));
        }
    }

    public static long addCap(long j10, long j11) {
        long j12 = j10 + j11;
        if (j12 < 0) {
            return Long.MAX_VALUE;
        }
        return j12;
    }

    public static <T> long addCapCancellable(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t10, long j10) {
        long j11;
        while (true) {
            j11 = atomicLongFieldUpdater.get(t10);
            if (j11 == Long.MIN_VALUE || j11 == Long.MAX_VALUE) {
                break;
            }
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t11 = t10;
            if (atomicLongFieldUpdater2.compareAndSet(t11, j11, addCap(j11, j10))) {
                break;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t10 = t11;
        }
        return j11;
    }

    @Nullable
    public static <T> Fuseable.QueueSubscription<T> as(qc.d dVar) {
        if (dVar instanceof Fuseable.QueueSubscription) {
            return (Fuseable.QueueSubscription) dVar;
        }
        return null;
    }

    public static /* synthetic */ void b(Consumer consumer, Object obj) {
        try {
            consumer.accept(obj);
        } catch (Throwable th) {
            log.warn("Error while discarding item extracted from a queue element, continuing with next item", th);
        }
    }

    public static /* synthetic */ void c(Consumer consumer, Object obj) {
        try {
            consumer.accept(obj);
        } catch (Throwable th) {
            log.warn("Error while discarding a stream element, continuing with next element", th);
        }
    }

    public static boolean canAppearAfterOnSubscribe(qc.d dVar) {
        return dVar == EmptySubscription.FROM_SUBSCRIBE_INSTANCE;
    }

    public static qc.d cancelledSubscription() {
        return CancelledSubscription.INSTANCE;
    }

    public static void complete(qc.c<?> cVar) {
        cVar.onSubscribe(EmptySubscription.INSTANCE);
        cVar.onComplete();
    }

    public static /* synthetic */ void d(Consumer consumer, Object obj) {
        if (obj != null) {
            try {
                consumer.accept(obj);
            } catch (Throwable th) {
                log.warn("Error while discarding element from an Iterator, continuing with next element", th);
            }
        }
    }

    public static final <R> Function<Context, Context> discardLocalAdapter(final Class<R> cls, final Consumer<? super R> consumer) {
        Objects.requireNonNull(cls, "onDiscard must be based on a type");
        Objects.requireNonNull(consumer, "onDiscard must be provided a discardHook Consumer");
        final Consumer consumer2 = new Consumer() { // from class: reactor.core.publisher.Y1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Operators.a(cls, consumer, obj);
            }
        };
        return new Function() { // from class: reactor.core.publisher.Z1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Operators.e(consumer2, (Context) obj);
            }
        };
    }

    public static <T> CoreSubscriber<T> drainSubscriber() {
        return DrainSubscriber.INSTANCE;
    }

    public static /* synthetic */ Context e(Consumer consumer, Context context) {
        Consumer consumer2 = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        return consumer2 == null ? context.put("reactor.onDiscard.local", consumer) : context.put("reactor.onDiscard.local", consumer.andThen(consumer2));
    }

    public static <T> CoreSubscriber<T> emptySubscriber() {
        return EMPTY_SUBSCRIBER;
    }

    public static qc.d emptySubscription() {
        return EmptySubscription.INSTANCE;
    }

    public static final Context enableOnDiscard(@Nullable Context context, Consumer<?> consumer) {
        Objects.requireNonNull(consumer, "discardConsumer must be provided");
        return context == null ? Context.of("reactor.onDiscard.local", consumer) : context.put("reactor.onDiscard.local", consumer);
    }

    public static void error(qc.c<?> cVar, Throwable th) {
        cVar.onSubscribe(EmptySubscription.INSTANCE);
        cVar.onError(th);
    }

    public static /* synthetic */ void f(Consumer consumer, Object obj) {
        if (obj != null) {
            try {
                consumer.accept(obj);
            } catch (Throwable th) {
                log.warn("Error while discarding element from an Spliterator, continuing with next element", th);
            }
        }
    }

    public static <I, O> Function<? super qc.b<I>, ? extends qc.b<O>> lift(BiFunction<Scannable, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
        return LiftFunction.liftScannable(null, biFunction);
    }

    public static <I, O> Function<? super qc.b<I>, ? extends qc.b<O>> liftPublisher(BiFunction<qc.b, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super I>> biFunction) {
        return LiftFunction.liftPublisher(null, biFunction);
    }

    public static Context multiSubscribersContext(InnerProducer<?>[] innerProducerArr) {
        return innerProducerArr.length > 0 ? innerProducerArr[0].actual().currentContext() : Context.empty();
    }

    public static long multiplyCap(long j10, long j11) {
        long j12 = j10 * j11;
        if (((j10 | j11) >>> 31) == 0 || j12 / j10 == j11) {
            return j12;
        }
        return Long.MAX_VALUE;
    }

    public static <T> void onDiscard(@Nullable T t10, Context context) {
        Consumer consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        if (t10 == null || consumer == null) {
            return;
        }
        try {
            consumer.accept(t10);
        } catch (Throwable th) {
            log.warn("Error in discard hook", th);
        }
    }

    public static void onDiscardMultiple(Stream<?> stream, Context context) {
        final Consumer consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
        if (consumer != null) {
            try {
                stream.filter(new Predicate() { // from class: reactor.core.publisher.a2
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return Objects.nonNull(obj);
                    }
                }).forEach(new Consumer() { // from class: reactor.core.publisher.b2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Operators.c(consumer, obj);
                    }
                });
            } catch (Throwable th) {
                log.warn("Error while discarding stream, stopping", th);
            }
        }
    }

    public static <T> void onDiscardQueueWithClear(@Nullable Queue<T> queue, Context context, @Nullable Function<T, Stream<?>> function) {
        if (queue == null) {
            return;
        }
        final Consumer consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null);
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
                        function.apply(tPoll).forEach(new Consumer() { // from class: reactor.core.publisher.d2
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                Operators.b(consumer, obj);
                            }
                        });
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
        Function<qc.b, qc.b> function = Hooks.onLastOperatorHook;
        if (function == null) {
            return corePublisher;
        }
        qc.b bVarApply = function.apply(corePublisher);
        Objects.requireNonNull(bVarApply, "LastOperator hook returned null");
        qc.b bVar = bVarApply;
        return bVar instanceof CorePublisher ? (CorePublisher) bVar : new CorePublisherAdapter(bVar);
    }

    public static <T> void onNextDropped(T t10, Context context) {
        Objects.requireNonNull(t10, "onNext");
        Objects.requireNonNull(context, "context");
        Consumer<Object> consumer = (Consumer) context.getOrDefault("reactor.onNextDropped.local", null);
        if (consumer == null) {
            consumer = Hooks.onNextDroppedHook;
        }
        if (consumer != null) {
            consumer.accept(t10);
            return;
        }
        Logger logger = log;
        if (logger.isDebugEnabled()) {
            logger.debug("onNextDropped: " + t10);
        }
    }

    public static <T> void onNextDroppedMulticast(T t10, InnerProducer<?>[] innerProducerArr) {
        onNextDropped(t10, multiSubscribersContext(innerProducerArr));
    }

    @Nullable
    public static <T> Throwable onNextError(@Nullable T t10, Throwable th, Context context, qc.d dVar) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (!onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) t10)) {
            return onOperatorError(dVar, thUnwrapOnNextError, t10, context);
        }
        Throwable thProcess = onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, t10, context);
        if (thProcess != null) {
            dVar.cancel();
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

    public static <T> Throwable onNextInnerError(Throwable th, Context context, @Nullable qc.d dVar) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) null) && (thUnwrapOnNextError = onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, null, context)) != null && dVar != null) {
            dVar.cancel();
        }
        return thUnwrapOnNextError;
    }

    @Nullable
    public static <T> RuntimeException onNextPollError(@Nullable T t10, Throwable th, Context context) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (!onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) t10)) {
            return Exceptions.propagate(onOperatorError(null, thUnwrapOnNextError, t10, context));
        }
        Throwable thProcess = onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, t10, context);
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

    public static <T> long producedCancellable(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t10, long j10) {
        while (true) {
            long j11 = atomicLongFieldUpdater.get(t10);
            if (j11 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j11 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            long j12 = j11 - j10;
            long j13 = 0;
            if (j12 < 0) {
                reportBadRequest(j12);
            } else {
                j13 = j12;
            }
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t11 = t10;
            if (atomicLongFieldUpdater2.compareAndSet(t11, j11, j13)) {
                return j13;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t10 = t11;
        }
    }

    public static <F> boolean replace(AtomicReferenceFieldUpdater<F, qc.d> atomicReferenceFieldUpdater, F f10, qc.d dVar) {
        qc.d dVar2;
        do {
            dVar2 = atomicReferenceFieldUpdater.get(f10);
            if (dVar2 == CancelledSubscription.INSTANCE) {
                dVar.cancel();
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(f10, dVar2, dVar));
        return true;
    }

    public static void reportBadRequest(long j10) {
        Logger logger = log;
        if (logger.isDebugEnabled()) {
            logger.debug("Negative request", Exceptions.nullOrNegativeRequestException(j10));
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

    public static <T> CoreSubscriber<T> restoreContextOnSubscriber(qc.b<?> bVar, CoreSubscriber<T> coreSubscriber) {
        return bVar instanceof Fuseable ? new FluxContextWriteRestoringThreadLocalsFuseable.FuseableContextWriteRestoringThreadLocalsSubscriber(coreSubscriber, coreSubscriber.currentContext()) : new FluxContextWriteRestoringThreadLocals.ContextWriteRestoringThreadLocalsSubscriber(coreSubscriber, coreSubscriber.currentContext());
    }

    public static <T> CoreSubscriber<? super T> restoreContextOnSubscriberIfAutoCPEnabled(qc.b<?> bVar, CoreSubscriber<? super T> coreSubscriber) {
        return ContextPropagationSupport.shouldPropagateContextToThreadLocals() ? restoreContextOnSubscriber(bVar, coreSubscriber) : coreSubscriber;
    }

    public static <T> CoreSubscriber<T> restoreContextOnSubscriberIfPublisherNonInternal(qc.b<?> bVar, CoreSubscriber<T> coreSubscriber) {
        return ContextPropagationSupport.shouldWrapPublisher(bVar) ? restoreContextOnSubscriber(bVar, coreSubscriber) : coreSubscriber;
    }

    public static <T> CoreSubscriber<? super T>[] restoreContextOnSubscribers(qc.b<?> bVar, CoreSubscriber<? super T>[] coreSubscriberArr) {
        CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[coreSubscriberArr.length];
        for (int i10 = 0; i10 < coreSubscriberArr.length; i10++) {
            coreSubscriberArr2[i10] = restoreContextOnSubscriber(bVar, coreSubscriberArr[i10]);
        }
        return coreSubscriberArr2;
    }

    public static <T> qc.d scalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t10) {
        return new ScalarSubscription(coreSubscriber, t10);
    }

    public static <T> CoreSubscriber<T> serialize(CoreSubscriber<? super T> coreSubscriber) {
        return new SerializedSubscriber(coreSubscriber);
    }

    public static <F> boolean set(AtomicReferenceFieldUpdater<F, qc.d> atomicReferenceFieldUpdater, F f10, qc.d dVar) {
        qc.d dVar2;
        do {
            dVar2 = atomicReferenceFieldUpdater.get(f10);
            if (dVar2 == CancelledSubscription.INSTANCE) {
                dVar.cancel();
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(f10, dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }

    public static <F> boolean setOnce(AtomicReferenceFieldUpdater<F, qc.d> atomicReferenceFieldUpdater, F f10, qc.d dVar) {
        Objects.requireNonNull(dVar, "subscription");
        qc.d dVar2 = atomicReferenceFieldUpdater.get(f10);
        CancelledSubscription cancelledSubscription = CancelledSubscription.INSTANCE;
        if (dVar2 == cancelledSubscription) {
            dVar.cancel();
            return false;
        }
        if (dVar2 != null) {
            dVar.cancel();
            reportSubscriptionSet();
            return false;
        }
        if (atomicReferenceFieldUpdater.compareAndSet(f10, null, dVar)) {
            return true;
        }
        if (atomicReferenceFieldUpdater.get(f10) == cancelledSubscription) {
            dVar.cancel();
            return false;
        }
        dVar.cancel();
        reportSubscriptionSet();
        return false;
    }

    public static long subOrZero(long j10, long j11) {
        long j12 = j10 - j11;
        if (j12 < 0) {
            return 0L;
        }
        return j12;
    }

    public static <F> boolean terminate(AtomicReferenceFieldUpdater<F, qc.d> atomicReferenceFieldUpdater, F f10) {
        qc.d andSet;
        qc.d dVar = atomicReferenceFieldUpdater.get(f10);
        CancelledSubscription cancelledSubscription = CancelledSubscription.INSTANCE;
        if (dVar == cancelledSubscription || (andSet = atomicReferenceFieldUpdater.getAndSet(f10, cancelledSubscription)) == null || andSet == cancelledSubscription) {
            return false;
        }
        andSet.cancel();
        return true;
    }

    public static <T> Fuseable.ConditionalSubscriber<? super T> toConditionalSubscriber(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "actual");
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? (Fuseable.ConditionalSubscriber) coreSubscriber : new ConditionalSubscriberAdapter(coreSubscriber);
    }

    public static <T> CoreSubscriber<? super T> toCoreSubscriber(qc.c<? super T> cVar) {
        Objects.requireNonNull(cVar, "actual");
        return cVar instanceof CoreSubscriber ? (CoreSubscriber) cVar : new StrictSubscriber(cVar);
    }

    public static <T> CorePublisher<T> toFluxOrMono(qc.b<T> bVar) {
        return bVar instanceof Mono ? Mono.fromDirect(bVar) : Flux.from(bVar);
    }

    public static int unboundedOrLimit(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i10 - (i10 >> 2);
    }

    public static long unboundedOrPrefetch(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return i10;
    }

    private static Throwable unwrapOnNextError(Throwable th) {
        return Exceptions.isBubbling(th) ? th : Exceptions.unwrap(th);
    }

    public static boolean validate(@Nullable qc.d dVar, qc.d dVar2) {
        Objects.requireNonNull(dVar2, "Subscription cannot be null");
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        return false;
    }

    public static <T> long addCap(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t10, long j10) {
        while (true) {
            long j11 = atomicLongFieldUpdater.get(t10);
            if (j11 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t11 = t10;
            if (atomicLongFieldUpdater2.compareAndSet(t11, j11, addCap(j11, j10))) {
                return j11;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t10 = t11;
        }
    }

    public static <O> Function<? super qc.b<O>, ? extends qc.b<O>> lift(Predicate<Scannable> predicate, BiFunction<Scannable, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super O>> biFunction) {
        return LiftFunction.liftScannable(predicate, biFunction);
    }

    public static <O> Function<? super qc.b<O>, ? extends qc.b<O>> liftPublisher(Predicate<qc.b> predicate, BiFunction<qc.b, ? super CoreSubscriber<? super O>, ? extends CoreSubscriber<? super O>> biFunction) {
        return LiftFunction.liftPublisher(predicate, biFunction);
    }

    public static Throwable onOperatorError(@Nullable qc.d dVar, Throwable th, Context context) {
        return onOperatorError(dVar, th, null, context);
    }

    public static RuntimeException onRejectedExecution(Throwable th, @Nullable qc.d dVar, @Nullable Throwable th2, @Nullable Object obj, Context context) {
        if (context.hasKey("reactor.onRejectedExecution.local")) {
            context = context.put("reactor.onOperatorError.local", context.get("reactor.onRejectedExecution.local"));
        }
        RejectedExecutionException rejectedExecutionExceptionFailWithRejected = Exceptions.failWithRejected(th);
        if (th2 != null) {
            rejectedExecutionExceptionFailWithRejected.addSuppressed(th2);
        }
        return obj != null ? Exceptions.propagate(onOperatorError(dVar, rejectedExecutionExceptionFailWithRejected, obj, context)) : Exceptions.propagate(onOperatorError(dVar, rejectedExecutionExceptionFailWithRejected, context));
    }

    public static <T> qc.d scalarSubscription(CoreSubscriber<? super T> coreSubscriber, T t10, String str) {
        return new ScalarSubscription(coreSubscriber, t10, str);
    }

    public static int unboundedOrLimit(int i10, int i11) {
        if (i11 <= 0) {
            return i10;
        }
        if (i11 >= i10) {
            return unboundedOrLimit(i10);
        }
        if (i10 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i11;
    }

    public static Throwable onOperatorError(@Nullable qc.d dVar, Throwable th, @Nullable Object obj, Context context) {
        Exceptions.throwIfFatal(th);
        if (dVar != null) {
            dVar.cancel();
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

    public static boolean validate(long j10) {
        if (j10 > 0) {
            return true;
        }
        reportBadRequest(j10);
        return false;
    }

    public static <T> void toFluxOrMono(qc.b<? extends T>[] bVarArr) {
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            qc.b<? extends T> bVar = bVarArr[i10];
            if (bVar != null) {
                bVarArr[i10] = toFluxOrMono(bVar);
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
    public static <T> Throwable onNextError(@Nullable T t10, Throwable th, Context context) {
        Throwable thUnwrapOnNextError = unwrapOnNextError(th);
        OnNextFailureStrategy onNextFailureStrategyOnNextErrorStrategy = onNextErrorStrategy(context);
        if (onNextFailureStrategyOnNextErrorStrategy.test(thUnwrapOnNextError, (Object) t10)) {
            return onNextFailureStrategyOnNextErrorStrategy.process(thUnwrapOnNextError, t10, context);
        }
        return onOperatorError(null, thUnwrapOnNextError, t10, context);
    }

    public static void onDiscardMultiple(@Nullable Iterator<?> it, boolean z10, Context context) {
        final Consumer consumer;
        if (it == null || !z10 || (consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null)) == null) {
            return;
        }
        try {
            it.forEachRemaining(new Consumer() { // from class: reactor.core.publisher.c2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Operators.d(consumer, obj);
                }
            });
        } catch (Throwable th) {
            log.warn("Error while discarding Iterator, stopping", th);
        }
    }

    public static void onDiscardMultiple(@Nullable Spliterator<?> spliterator, boolean z10, Context context) {
        final Consumer consumer;
        if (spliterator == null || !z10 || (consumer = (Consumer) context.getOrDefault("reactor.onDiscard.local", null)) == null) {
            return;
        }
        try {
            spliterator.forEachRemaining(new Consumer() { // from class: reactor.core.publisher.X1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Operators.f(consumer, obj);
                }
            });
        } catch (Throwable th) {
            log.warn("Error while discarding Spliterator, stopping", th);
        }
    }
}
