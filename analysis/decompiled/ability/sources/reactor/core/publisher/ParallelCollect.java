package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class ParallelCollect<T, C> extends ParallelFlux<C> implements Scannable, Fuseable {
    final BiConsumer<? super C, ? super T> collector;
    final Supplier<? extends C> initialCollection;
    final ParallelFlux<? extends T> source;

    public static final class ParallelCollectSubscriber<T, C> extends Operators.BaseFluxToMonoOperator<T, C> {
        C collection;
        final BiConsumer<? super C, ? super T> collector;
        boolean done;

        public ParallelCollectSubscriber(CoreSubscriber<? super C> coreSubscriber, C c, BiConsumer<? super C, ? super T> biConsumer) {
            super(coreSubscriber);
            this.collection = c;
            this.collector = biConsumer;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public C accumulatedValue() {
            C c;
            synchronized (this) {
                c = this.collection;
                this.collection = null;
            }
            return c;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            C c;
            this.f5875s.cancel();
            synchronized (this) {
                c = this.collection;
                this.collection = null;
            }
            if (c != null) {
                Operators.onDiscard(c, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            C c;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                c = this.collection;
                this.collection = null;
            }
            if (c == null) {
                return;
            }
            Operators.onDiscard(c, this.actual.currentContext());
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            try {
                synchronized (this) {
                    try {
                        C c = this.collection;
                        if (c != null) {
                            this.collector.accept(c, t9);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5875s, th, t9, this.actual.currentContext()));
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

    public void reportError(Z9.d[] dVarArr, Throwable th) {
        for (Z9.d dVar : dVarArr) {
            Operators.error(dVar, th);
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
            for (int i = 0; i < length; i++) {
                try {
                    C c = this.initialCollection.get();
                    Objects.requireNonNull(c, "The initialSupplier returned a null value");
                    coreSubscriberArr2[i] = new ParallelCollectSubscriber(coreSubscriberArr[i], c, this.collector);
                } catch (Throwable th) {
                    reportError(coreSubscriberArr, Operators.onOperatorError(th, coreSubscriberArr[i].currentContext()));
                    return;
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}
