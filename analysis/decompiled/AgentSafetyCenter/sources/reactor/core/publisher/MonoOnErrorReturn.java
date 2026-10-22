package reactor.core.publisher;

import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxOnErrorReturn;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoOnErrorReturn<T> extends InternalMonoOperator<T, T> {

    @Nullable
    final T fallbackValue;

    @Nullable
    final Predicate<? super Throwable> resumableErrorPredicate;

    public MonoOnErrorReturn(Mono<? extends T> mono, @Nullable Predicate<? super Throwable> predicate, @Nullable T t10) {
        super(mono);
        this.resumableErrorPredicate = predicate;
        this.fallbackValue = t10;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxOnErrorReturn.ReturnSubscriber(coreSubscriber, this.resumableErrorPredicate, this.fallbackValue, false);
    }
}
