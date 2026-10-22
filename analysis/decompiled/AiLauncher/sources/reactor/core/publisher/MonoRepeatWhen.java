package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxRepeatWhen;

/* loaded from: classes5.dex */
final class MonoRepeatWhen<T> extends FluxFromMonoOperator<T, T> {
    final Function<? super Flux<Long>, ? extends qc.b<?>> whenSourceFactory;

    public MonoRepeatWhen(Mono<? extends T> mono, Function<? super Flux<Long>, ? extends qc.b<?>> function) {
        super(mono);
        Objects.requireNonNull(function, "whenSourceFactory");
        this.whenSourceFactory = function;
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxRepeatWhen.RepeatWhenOtherSubscriber repeatWhenOtherSubscriber = new FluxRepeatWhen.RepeatWhenOtherSubscriber();
        CoreSubscriber coreSubscriberSerialize = Operators.serialize(coreSubscriber);
        FluxRepeatWhen.RepeatWhenMainSubscriber<?> repeatWhenMainSubscriber = new FluxRepeatWhen.RepeatWhenMainSubscriber<>(coreSubscriberSerialize, repeatWhenOtherSubscriber.completionSignal, this.source);
        repeatWhenOtherSubscriber.main = repeatWhenMainSubscriber;
        coreSubscriberSerialize.onSubscribe(repeatWhenMainSubscriber);
        try {
            qc.b<?> bVarApply = this.whenSourceFactory.apply(repeatWhenOtherSubscriber);
            Objects.requireNonNull(bVarApply, "The whenSourceFactory returned a null Publisher");
            bVarApply.subscribe(repeatWhenOtherSubscriber);
            if (repeatWhenMainSubscriber.cancelled) {
                return null;
            }
            return repeatWhenMainSubscriber;
        } catch (Throwable th) {
            coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
            return null;
        }
    }
}
