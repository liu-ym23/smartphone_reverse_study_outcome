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

/* loaded from: classes4.dex */
final class MonoFlatMapMany<T, R> extends FluxFromMonoOperator<T, R> {
    final Function<? super T, ? extends Z9.c> mapper;

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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(R r5) {
            this.actual.onNext(r5);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
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

    public static final class FlatMapManyMain<T, R> implements InnerOperator<T, R> {
        static final AtomicReferenceFieldUpdater<FlatMapManyMain, Z9.e> INNER = AtomicReferenceFieldUpdater.newUpdater(FlatMapManyMain.class, Z9.e.class, "inner");
        static final AtomicLongFieldUpdater<FlatMapManyMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(FlatMapManyMain.class, "requested");
        final CoreSubscriber<? super R> actual;
        boolean hasValue;
        volatile Z9.e inner;
        Z9.e main;
        final Function<? super T, ? extends Z9.c> mapper;
        volatile long requested;

        public FlatMapManyMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.main.cancel();
            Operators.terminate(INNER, this);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.inner));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.hasValue) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.hasValue) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.hasValue = true;
            try {
                Z9.c cVarApply = this.mapper.apply(t9);
                Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher.");
                Z9.c cVar = cVarApply;
                if (!(cVar instanceof Callable)) {
                    Operators.toFluxOrMono(cVar).subscribe((Z9.d) new FlatMapManyInner(this, this.actual));
                    return;
                }
                try {
                    Object objCall = ((Callable) cVar).call();
                    if (objCall == null) {
                        this.actual.onComplete();
                    } else {
                        onSubscribeInner(Operators.scalarSubscription(this.actual, objCall));
                    }
                } catch (Throwable th) {
                    CoreSubscriber<? super R> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onOperatorError(this, th, t9, coreSubscriber.currentContext()));
                }
            } catch (Throwable th2) {
                CoreSubscriber<? super R> coreSubscriber2 = this.actual;
                coreSubscriber2.onError(Operators.onOperatorError(this, th2, t9, coreSubscriber2.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.main, eVar)) {
                this.main = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void onSubscribeInner(Z9.e eVar) {
            if (Operators.setOnce(INNER, this, eVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    eVar.request(andSet);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            Z9.e eVar = this.inner;
            if (eVar != null) {
                eVar.request(j5);
                return;
            }
            if (Operators.validate(j5)) {
                AtomicLongFieldUpdater<FlatMapManyMain> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j5);
                Z9.e eVar2 = this.inner;
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

    public MonoFlatMapMany(Mono<? extends T> mono, Function<? super T, ? extends Z9.c> function) {
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
