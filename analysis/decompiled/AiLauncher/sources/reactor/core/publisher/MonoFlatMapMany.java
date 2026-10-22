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

/* loaded from: classes5.dex */
final class MonoFlatMapMany<T, R> extends FluxFromMonoOperator<T, R> {
    final Function<? super T, ? extends qc.b<? extends R>> mapper;

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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(R r10) {
            this.actual.onNext(r10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            this.parent.onSubscribeInner(dVar);
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
        static final AtomicReferenceFieldUpdater<FlatMapManyMain, qc.d> INNER = AtomicReferenceFieldUpdater.newUpdater(FlatMapManyMain.class, qc.d.class, "inner");
        static final AtomicLongFieldUpdater<FlatMapManyMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(FlatMapManyMain.class, "requested");
        final CoreSubscriber<? super R> actual;
        boolean hasValue;
        volatile qc.d inner;
        qc.d main;
        final Function<? super T, ? extends qc.b<? extends R>> mapper;
        volatile long requested;

        public FlatMapManyMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qc.b<? extends R>> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.main.cancel();
            Operators.terminate(INNER, this);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.inner));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.hasValue) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.hasValue) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.hasValue = true;
            try {
                qc.b<? extends R> bVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(bVarApply, "The mapper returned a null Publisher.");
                qc.b<? extends R> bVar = bVarApply;
                if (!(bVar instanceof Callable)) {
                    Operators.toFluxOrMono(bVar).subscribe((qc.c) new FlatMapManyInner(this, this.actual));
                    return;
                }
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall == null) {
                        this.actual.onComplete();
                    } else {
                        onSubscribeInner(Operators.scalarSubscription(this.actual, objCall));
                    }
                } catch (Throwable th) {
                    CoreSubscriber<? super R> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onOperatorError(this, th, t10, coreSubscriber.currentContext()));
                }
            } catch (Throwable th2) {
                CoreSubscriber<? super R> coreSubscriber2 = this.actual;
                coreSubscriber2.onError(Operators.onOperatorError(this, th2, t10, coreSubscriber2.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.main, dVar)) {
                this.main = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void onSubscribeInner(qc.d dVar) {
            if (Operators.setOnce(INNER, this, dVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    dVar.request(andSet);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            qc.d dVar = this.inner;
            if (dVar != null) {
                dVar.request(j10);
                return;
            }
            if (Operators.validate(j10)) {
                AtomicLongFieldUpdater<FlatMapManyMain> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qc.d dVar2 = this.inner;
                if (dVar2 != null) {
                    long andSet = atomicLongFieldUpdater.getAndSet(this, 0L);
                    if (andSet != 0) {
                        dVar2.request(andSet);
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

    public MonoFlatMapMany(Mono<? extends T> mono, Function<? super T, ? extends qc.b<? extends R>> function) {
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
