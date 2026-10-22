package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeekFuseable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoPeekFuseable<T> extends InternalMonoOperator<T, T> implements Fuseable, SignalPeek<T> {
    final Runnable onCancelCall;
    final Consumer<? super T> onNextCall;
    final LongConsumer onRequestCall;
    final Consumer<? super qc.d> onSubscribeCall;

    public MonoPeekFuseable(Mono<? extends T> mono, @Nullable Consumer<? super qc.d> consumer, @Nullable Consumer<? super T> consumer2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable) {
        super(mono);
        this.onSubscribeCall = consumer;
        this.onNextCall = consumer2;
        this.onRequestCall = longConsumer;
        this.onCancelCall = runnable;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onAfterTerminateCall() {
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCancelCall() {
        return this.onCancelCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCompleteCall() {
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Throwable> onErrorCall() {
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super T> onNextCall() {
        return this.onNextCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public LongConsumer onRequestCall() {
        return this.onRequestCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super qc.d> onSubscribeCall() {
        return this.onSubscribeCall;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxPeekFuseable.PeekFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this) : new FluxPeekFuseable.PeekFuseableSubscriber(coreSubscriber, this);
    }
}
