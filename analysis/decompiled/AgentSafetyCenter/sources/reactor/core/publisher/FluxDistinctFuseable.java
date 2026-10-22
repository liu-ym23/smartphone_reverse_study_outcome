package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxDistinct;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxDistinctFuseable<T, K, C> extends InternalFluxOperator<T, T> implements Fuseable {
    final Consumer<C> cleanupCallback;
    final Supplier<C> collectionSupplier;
    final BiPredicate<C, K> distinctPredicate;
    final Function<? super T, ? extends K> keyExtractor;

    public FluxDistinctFuseable(Flux<? extends T> flux, Function<? super T, ? extends K> function, Supplier<C> supplier, BiPredicate<C, K> biPredicate, Consumer<C> consumer) {
        super(flux);
        Objects.requireNonNull(function, "keyExtractor");
        this.keyExtractor = function;
        Objects.requireNonNull(supplier, "collectionSupplier");
        this.collectionSupplier = supplier;
        Objects.requireNonNull(biPredicate, "distinctPredicate");
        this.distinctPredicate = biPredicate;
        Objects.requireNonNull(consumer, "cleanupCallback");
        this.cleanupCallback = consumer;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        C c9 = this.collectionSupplier.get();
        Objects.requireNonNull(c9, "The collectionSupplier returned a null collection");
        return new FluxDistinct.DistinctFuseableSubscriber(coreSubscriber, c9, this.keyExtractor, this.distinctPredicate, this.cleanupCallback);
    }
}
