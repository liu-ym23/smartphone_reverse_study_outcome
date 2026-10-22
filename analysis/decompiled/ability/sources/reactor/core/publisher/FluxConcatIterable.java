package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
final class FluxConcatIterable<T> extends Flux<T> implements SourceProducer<T> {
    final Iterable<? extends Z9.c> iterable;

    public static final class ConcatIterableSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        static final AtomicIntegerFieldUpdater<ConcatIterableSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(ConcatIterableSubscriber.class, "wip");
        final Iterator<? extends Z9.c> it;
        long produced;
        volatile int wip;

        public ConcatIterableSubscriber(CoreSubscriber<? super T> coreSubscriber, Iterator<? extends Z9.c> it) {
            super(coreSubscriber);
            this.it = it;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (WIP.getAndIncrement(this) == 0) {
                Iterator<? extends Z9.c> it = this.it;
                while (!isCancelled()) {
                    try {
                        boolean zHasNext = it.hasNext();
                        if (isCancelled()) {
                            return;
                        }
                        if (!zHasNext) {
                            this.actual.onComplete();
                            return;
                        }
                        try {
                            Z9.c next = this.it.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            Z9.c cVar = next;
                            if (isCancelled()) {
                                return;
                            }
                            long j5 = this.produced;
                            if (j5 != 0) {
                                this.produced = 0L;
                                produced(j5);
                            }
                            Operators.toFluxOrMono(cVar).subscribe((Z9.d) this);
                            if (isCancelled() || WIP.decrementAndGet(this) == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            CoreSubscriber<? super O> coreSubscriber = this.actual;
                            coreSubscriber.onError(Operators.onOperatorError(this, th, coreSubscriber.currentContext()));
                            return;
                        }
                    } catch (Throwable th2) {
                        onError(Operators.onOperatorError(this, th2, this.actual.currentContext()));
                        return;
                    }
                }
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.produced++;
            this.actual.onNext(t9);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxConcatIterable(Iterable<? extends Z9.c> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        this.iterable = iterable;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            Iterator<? extends Z9.c> it = this.iterable.iterator();
            Objects.requireNonNull(it, "The Iterator returned is null");
            ConcatIterableSubscriber concatIterableSubscriber = new ConcatIterableSubscriber(coreSubscriber, it);
            coreSubscriber.onSubscribe(concatIterableSubscriber);
            if (concatIterableSubscriber.isCancelled()) {
                return;
            }
            concatIterableSubscriber.onComplete();
        } catch (Throwable th) {
            com.stepos.statsrpk.service.c.t(coreSubscriber, th, coreSubscriber);
        }
    }
}
