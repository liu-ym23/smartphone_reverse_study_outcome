package reactor.core.publisher;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* loaded from: classes5.dex */
final class FluxName<T> extends InternalFluxOperator<T, T> {
    final String name;
    final List<Tuple2<String, String>> tagsWithDuplicates;

    public FluxName(Flux<? extends T> flux, @Nullable String str, @Nullable List<Tuple2<String, String>> list) {
        super(flux);
        this.name = str;
        this.tagsWithDuplicates = list;
    }

    public static <T> Flux<T> createOrAppend(Flux<T> flux, String str) {
        Objects.requireNonNull(str, "name");
        if (flux instanceof FluxName) {
            FluxName fluxName = (FluxName) flux;
            return new FluxName(fluxName.source, str, fluxName.tagsWithDuplicates);
        }
        if (!(flux instanceof FluxNameFuseable)) {
            return flux instanceof Fuseable ? new FluxNameFuseable(flux, str, null) : new FluxName(flux, str, null);
        }
        FluxNameFuseable fluxNameFuseable = (FluxNameFuseable) flux;
        return new FluxNameFuseable(fluxNameFuseable.source, str, fluxNameFuseable.tagsWithDuplicates);
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

    public static <T> Flux<T> createOrAppend(Flux<T> flux, String str, String str2) {
        List listSingletonList;
        List listSingletonList2;
        Objects.requireNonNull(str, "tagName");
        Objects.requireNonNull(str2, "tagValue");
        Tuple2 tuple2Of = Tuples.of(str, str2);
        if (flux instanceof FluxName) {
            FluxName fluxName = (FluxName) flux;
            if (fluxName.tagsWithDuplicates != null) {
                listSingletonList2 = new LinkedList(fluxName.tagsWithDuplicates);
                listSingletonList2.add(tuple2Of);
            } else {
                listSingletonList2 = Collections.singletonList(tuple2Of);
            }
            return new FluxName(fluxName.source, fluxName.name, listSingletonList2);
        }
        if (flux instanceof FluxNameFuseable) {
            FluxNameFuseable fluxNameFuseable = (FluxNameFuseable) flux;
            if (fluxNameFuseable.tagsWithDuplicates != null) {
                listSingletonList = new LinkedList(fluxNameFuseable.tagsWithDuplicates);
                listSingletonList.add(tuple2Of);
            } else {
                listSingletonList = Collections.singletonList(tuple2Of);
            }
            return new FluxNameFuseable(fluxNameFuseable.source, fluxNameFuseable.name, listSingletonList);
        }
        if (flux instanceof Fuseable) {
            return new FluxNameFuseable(flux, null, Collections.singletonList(tuple2Of));
        }
        return new FluxName(flux, null, Collections.singletonList(tuple2Of));
    }
}
