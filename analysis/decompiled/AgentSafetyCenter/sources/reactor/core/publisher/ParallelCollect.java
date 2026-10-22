package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelCollect<T, C> extends ParallelFlux<C> implements Scannable, Fuseable {
    final BiConsumer<? super C, ? super T> collector;
    final Supplier<? extends C> initialCollection;
    final ParallelFlux<? extends T> source;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ParallelCollectSubscriber<T, C> extends Operators.BaseFluxToMonoOperator<T, C> {
        C collection;
        final BiConsumer<? super C, ? super T> collector;
        boolean done;

        public ParallelCollectSubscriber(CoreSubscriber<? super C> coreSubscriber, C c9, BiConsumer<? super C, ? super T> biConsumer) {
            super(coreSubscriber);
            this.collection = c9;
            this.collector = biConsumer;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public C accumulatedValue() {
            C c9;
            synchronized (this) {
                c9 = this.collection;
                this.collection = null;
            }
            return c9;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            C c9;
            this.f10743s.cancel();
            synchronized (this) {
                c9 = this.collection;
                this.collection = null;
            }
            if (c9 != null) {
                Operators.onDiscard(c9, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            C c9;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                c9 = this.collection;
                this.collection = null;
            }
            if (c9 == null) {
                return;
            }
            Operators.onDiscard(c9, this.actual.currentContext());
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                synchronized (this) {
                    try {
                        C c9 = this.collection;
                        if (c9 != null) {
                            this.collector.accept(c9, t10);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10743s, th, t10, this.actual.currentContext()));
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
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
    }

    public void reportError(qd.d[] dVarArr, Throwable th) {
        for (qd.d dVar : dVarArr) {
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
                    C c9 = this.initialCollection.get();
                    Objects.requireNonNull(c9, "The initialSupplier returned a null value");
                    coreSubscriberArr2[i] = new ParallelCollectSubscriber(coreSubscriberArr[i], c9, this.collector);
                } catch (Throwable th) {
                    reportError(coreSubscriberArr, Operators.onOperatorError(th, coreSubscriberArr[i].currentContext()));
                    return;
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}
