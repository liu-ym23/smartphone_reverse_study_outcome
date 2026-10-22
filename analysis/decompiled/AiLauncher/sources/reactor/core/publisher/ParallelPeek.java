package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeek;
import reactor.core.publisher.FluxPeekFuseable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelPeek<T> extends ParallelFlux<T> implements SignalPeek<T> {
    final Consumer<? super T> onAfterNext;
    final Runnable onAfterTerminated;
    final Runnable onCancel;
    final Runnable onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final LongConsumer onRequest;
    final Consumer<? super qc.d> onSubscribe;
    final ParallelFlux<T> source;

    public ParallelPeek(ParallelFlux<T> parallelFlux, @Nullable Consumer<? super T> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable Consumer<? super qc.d> consumer4, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.onNext = consumer;
        this.onAfterNext = consumer2;
        this.onError = consumer3;
        this.onComplete = runnable;
        this.onAfterTerminated = runnable2;
        this.onSubscribe = consumer4;
        this.onRequest = longConsumer;
        this.onCancel = runnable3;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return this.source.getPrefetch();
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super T> onAfterNextCall() {
        return this.onAfterNext;
    }

    @Override // reactor.core.publisher.SignalPeek
    public Runnable onAfterTerminateCall() {
        return this.onAfterTerminated;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCancelCall() {
        return this.onCancel;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCompleteCall() {
        return this.onComplete;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Throwable> onErrorCall() {
        return this.onError;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super T> onNextCall() {
        return this.onNext;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public LongConsumer onRequestCall() {
        return this.onRequest;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super qc.d> onSubscribeCall() {
        return this.onSubscribe;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
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
    public void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[length];
            boolean z10 = coreSubscriberArr[0] instanceof Fuseable.ConditionalSubscriber;
            for (int i10 = 0; i10 < length; i10++) {
                if (z10) {
                    coreSubscriberArr2[i10] = new FluxPeekFuseable.PeekConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriberArr[i10], this);
                } else {
                    coreSubscriberArr2[i10] = new FluxPeek.PeekSubscriber(coreSubscriberArr[i10], this);
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}
