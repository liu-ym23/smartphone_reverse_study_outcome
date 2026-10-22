package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxRepeatWhen;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoRepeatWhen<T> extends FluxFromMonoOperator<T, T> {
    final Function<? super Flux<Long>, ? extends qd.c> whenSourceFactory;

    public MonoRepeatWhen(Mono<? extends T> mono, Function<? super Flux<Long>, ? extends qd.c> function) {
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
            qd.c cVarApply = this.whenSourceFactory.apply(repeatWhenOtherSubscriber);
            Objects.requireNonNull(cVarApply, "The whenSourceFactory returned a null Publisher");
            cVarApply.subscribe(repeatWhenOtherSubscriber);
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
