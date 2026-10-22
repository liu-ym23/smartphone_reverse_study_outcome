package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxOnErrorResume;

/* loaded from: classes5.dex */
final class MonoOnErrorResume<T> extends InternalMonoOperator<T, T> {
    final Function<? super Throwable, ? extends qc.b<? extends T>> nextFactory;

    public MonoOnErrorResume(Mono<? extends T> mono, Function<? super Throwable, ? extends Mono<? extends T>> function) {
        super(mono);
        Objects.requireNonNull(function, "nextFactory");
        this.nextFactory = function;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxOnErrorResume.ResumeSubscriber(coreSubscriber, this.nextFactory);
    }
}
