package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxTakeUntilOther;

/* loaded from: classes4.dex */
final class MonoTakeUntilOther<T, U> extends InternalMonoOperator<T, T> {
    private final Z9.c other;

    public MonoTakeUntilOther(Mono<? extends T> mono, Z9.c cVar) {
        super(mono);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxTakeUntilOther.TakeUntilMainSubscriber takeUntilMainSubscriber = new FluxTakeUntilOther.TakeUntilMainSubscriber(coreSubscriber);
        this.other.subscribe(new FluxTakeUntilOther.TakeUntilOtherSubscriber(takeUntilMainSubscriber));
        return takeUntilMainSubscriber;
    }
}
