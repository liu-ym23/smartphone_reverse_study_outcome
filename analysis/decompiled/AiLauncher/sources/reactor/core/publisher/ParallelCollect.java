package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelCollect<T, C> extends ParallelFlux<C> implements Scannable, Fuseable {
    final BiConsumer<? super C, ? super T> collector;
    final Supplier<? extends C> initialCollection;
    final ParallelFlux<? extends T> source;

    public static final class ParallelCollectSubscriber<T, C> extends Operators.BaseFluxToMonoOperator<T, C> {
        C collection;
        final BiConsumer<? super C, ? super T> collector;
        boolean done;

        public ParallelCollectSubscriber(CoreSubscriber<? super C> coreSubscriber, C c10, BiConsumer<? super C, ? super T> biConsumer) {
            super(coreSubscriber);
            this.collection = c10;
            this.collector = biConsumer;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public C accumulatedValue() {
            C c10;
            synchronized (this) {
                c10 = this.collection;
                this.collection = null;
            }
            return c10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            C c10;
            this.f39687s.cancel();
            synchronized (this) {
                c10 = this.collection;
                this.collection = null;
            }
            if (c10 != null) {
                Operators.onDiscard(c10, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            C c10;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                c10 = this.collection;
                this.collection = null;
            }
            if (c10 == null) {
                return;
            }
            Operators.onDiscard(c10, this.actual.currentContext());
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                synchronized (this) {
                    try {
                        C c10 = this.collection;
                        if (c10 != null) {
                            this.collector.accept(c10, t10);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f39687s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.collection == null && !this.done);
            }
            return super.scanUnsafe(attr);
        }
    }

    public ParallelCollect(ParallelFlux<? extends T> parallelFlux, Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.initialCollection = supplier;
        this.collector = biConsumer;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
    }

    public void reportError(qc.c<?>[] cVarArr, Throwable th) {
        for (qc.c<?> cVar : cVarArr) {
            Operators.error(cVar, th);
        }
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super C>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super Object>[] coreSubscriberArr2 = new CoreSubscriber[length];
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    C c10 = this.initialCollection.get();
                    Objects.requireNonNull(c10, "The initialSupplier returned a null value");
                    coreSubscriberArr2[i10] = new ParallelCollectSubscriber(coreSubscriberArr[i10], c10, this.collector);
                } catch (Throwable th) {
                    reportError(coreSubscriberArr, Operators.onOperatorError(th, coreSubscriberArr[i10].currentContext()));
                    return;
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}
