package reactor.core.publisher;

import java.util.List;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;

/* loaded from: classes4.dex */
final class FluxNameFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final String name;
    final List<Tuple2<String, String>> tagsWithDuplicates;

    public FluxNameFuseable(Flux<? extends T> flux, @Nullable String str, @Nullable List<Tuple2<String, String>> list) {
        super(flux);
        this.name = str;
        this.tagsWithDuplicates = list;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        List<Tuple2<String, String>> list;
        return attr == Scannable.Attr.NAME ? this.name : (attr != Scannable.Attr.TAGS || (list = this.tagsWithDuplicates) == null) ? attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr) : list.stream();
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber;
    }
}
