package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFlattenIterable;

/* loaded from: classes4.dex */
final class MonoFlattenIterable<T, R> extends FluxFromMonoOperator<T, R> implements Fuseable {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Supplier<Queue<T>> queueSupplier;

    public MonoFlattenIterable(Mono<? extends T> mono, Function<? super T, ? extends Iterable<? extends R>> function, int i, Supplier<Queue<T>> supplier) {
        super(mono);
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        this.prefetch = i;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) throws Exception {
        Object obj = this.source;
        if (!(obj instanceof Callable)) {
            return new FluxFlattenIterable.FlattenIterableSubscriber(coreSubscriber, this.mapper, this.prefetch, this.queueSupplier);
        }
        Object objCall = ((Callable) obj).call();
        if (objCall == null) {
            Operators.complete(coreSubscriber);
            return null;
        }
        Spliterator<? extends R> spliterator = this.mapper.apply(objCall).spliterator();
        FluxIterable.subscribe(coreSubscriber, spliterator, FluxIterable.checkFinite(spliterator));
        return null;
    }
}
