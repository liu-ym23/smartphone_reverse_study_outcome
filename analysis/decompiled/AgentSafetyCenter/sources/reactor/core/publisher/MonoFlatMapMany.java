package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoFlatMapMany<T, R> extends FluxFromMonoOperator<T, R> {
    final Function<? super T, ? extends qd.c> mapper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FlatMapManyInner<R> implements InnerConsumer<R> {
        final CoreSubscriber<? super R> actual;
        final FlatMapManyMain<?, R> parent;

        public FlatMapManyInner(FlatMapManyMain<?, R> flatMapManyMain, CoreSubscriber<? super R> coreSubscriber) {
            this.parent = flatMapManyMain;
            this.actual = coreSubscriber;
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
        public void onNext(R r10) {
            this.actual.onNext(r10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            this.parent.onSubscribeInner(eVar);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent.inner;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.parent.requested);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FlatMapManyMain<T, R> implements InnerOperator<T, R> {
        static final AtomicReferenceFieldUpdater<FlatMapManyMain, qd.e> INNER = AtomicReferenceFieldUpdater.newUpdater(FlatMapManyMain.class, qd.e.class, "inner");
        static final AtomicLongFieldUpdater<FlatMapManyMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(FlatMapManyMain.class, "requested");
        final CoreSubscriber<? super R> actual;
        boolean hasValue;
        volatile qd.e inner;
        qd.e main;
        final Function<? super T, ? extends qd.c> mapper;
        volatile long requested;

        public FlatMapManyMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.main.cancel();
            Operators.terminate(INNER, this);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.inner));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.hasValue) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            boolean z10 = this.hasValue;
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            if (z10) {
                Operators.onErrorDropped(th, coreSubscriber.currentContext());
            } else {
                coreSubscriber.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.hasValue = true;
            try {
                qd.c cVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher.");
                qd.c cVar = cVarApply;
                if (!(cVar instanceof Callable)) {
                    Operators.toFluxOrMono(cVar).subscribe((qd.d) new FlatMapManyInner(this, this.actual));
                    return;
                }
                try {
                    Object objCall = ((Callable) cVar).call();
                    CoreSubscriber<? super R> coreSubscriber = this.actual;
                    if (objCall == null) {
                        coreSubscriber.onComplete();
                    } else {
                        onSubscribeInner(Operators.scalarSubscription(coreSubscriber, objCall));
                    }
                } catch (Throwable th) {
                    CoreSubscriber<? super R> coreSubscriber2 = this.actual;
                    coreSubscriber2.onError(Operators.onOperatorError(this, th, t10, coreSubscriber2.currentContext()));
                }
            } catch (Throwable th2) {
                CoreSubscriber<? super R> coreSubscriber3 = this.actual;
                coreSubscriber3.onError(Operators.onOperatorError(this, th2, t10, coreSubscriber3.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.main, eVar)) {
                this.main = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void onSubscribeInner(qd.e eVar) {
            if (Operators.setOnce(INNER, this, eVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    eVar.request(andSet);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            qd.e eVar = this.inner;
            if (eVar != null) {
                eVar.request(j10);
                return;
            }
            if (Operators.validate(j10)) {
                AtomicLongFieldUpdater<FlatMapManyMain> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qd.e eVar2 = this.inner;
                if (eVar2 != null) {
                    long andSet = atomicLongFieldUpdater.getAndSet(this, 0L);
                    if (andSet != 0) {
                        eVar2.request(andSet);
                    }
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoFlatMapMany(Mono<? extends T> mono, Function<? super T, ? extends qd.c> function) {
        super(mono);
        this.mapper = function;
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        if (FluxFlatMap.trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, false, false)) {
            return null;
        }
        return new FlatMapManyMain(coreSubscriber, this.mapper);
    }
}
