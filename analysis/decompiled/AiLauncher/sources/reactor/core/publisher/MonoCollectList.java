package reactor.core.publisher;

import java.util.ArrayList;
import java.util.List;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoCollectList<T> extends MonoFromFluxOperator<T, List<T>> implements Fuseable {

    public static final class MonoCollectListSubscriber<T> extends Operators.BaseFluxToMonoOperator<T, List<T>> {
        boolean done;
        List<T> list;

        public MonoCollectListSubscriber(CoreSubscriber<? super List<T>> coreSubscriber) {
            super(coreSubscriber);
            this.list = new ArrayList();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            List<T> list;
            this.f39687s.cancel();
            synchronized (this) {
                list = this.list;
                this.list = null;
            }
            if (list != null) {
                Operators.onDiscardMultiple(list, this.actual.currentContext());
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
            List<T> list;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                list = this.list;
                this.list = null;
            }
            if (list == null) {
                return;
            }
            Operators.onDiscardMultiple(list, this.actual.currentContext());
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            synchronized (this) {
                try {
                    List<T> list = this.list;
                    if (list != null) {
                        list.add(t10);
                    } else {
                        Operators.onDiscard(t10, this.actual.currentContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(!this.done && this.list == null);
            }
            return super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public List<T> accumulatedValue() {
            List<T> list;
            synchronized (this) {
                list = this.list;
                this.list = null;
            }
            return list;
        }
    }

    public MonoCollectList(Flux<? extends T> flux) {
        super(flux);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super List<T>> coreSubscriber) {
        return new MonoCollectListSubscriber(coreSubscriber);
    }
}
