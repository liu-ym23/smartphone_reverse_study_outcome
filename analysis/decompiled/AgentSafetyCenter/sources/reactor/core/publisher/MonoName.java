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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoName<T> extends InternalMonoOperator<T, T> {
    final String name;
    final List<Tuple2<String, String>> tagsWithDuplicates;

    public MonoName(Mono<? extends T> mono, @Nullable String str, @Nullable List<Tuple2<String, String>> list) {
        super(mono);
        this.name = str;
        this.tagsWithDuplicates = list;
    }

    public static <T> Mono<T> createOrAppend(Mono<T> mono, String str, String str2) {
        List listSingletonList;
        List listSingletonList2;
        Objects.requireNonNull(str, "tagName");
        Objects.requireNonNull(str2, "tagValue");
        Tuple2 tuple2Of = Tuples.of(str, str2);
        if (mono instanceof MonoName) {
            MonoName monoName = (MonoName) mono;
            if (monoName.tagsWithDuplicates != null) {
                LinkedList linkedList = new LinkedList(monoName.tagsWithDuplicates);
                linkedList.add(tuple2Of);
                listSingletonList2 = linkedList;
            } else {
                listSingletonList2 = Collections.singletonList(tuple2Of);
            }
            return new MonoName(monoName.source, monoName.name, listSingletonList2);
        }
        if (!(mono instanceof MonoNameFuseable)) {
            return mono instanceof Fuseable ? new MonoNameFuseable(mono, null, Collections.singletonList(tuple2Of)) : new MonoName(mono, null, Collections.singletonList(tuple2Of));
        }
        MonoNameFuseable monoNameFuseable = (MonoNameFuseable) mono;
        if (monoNameFuseable.tagsWithDuplicates != null) {
            LinkedList linkedList2 = new LinkedList(monoNameFuseable.tagsWithDuplicates);
            linkedList2.add(tuple2Of);
            listSingletonList = linkedList2;
        } else {
            listSingletonList = Collections.singletonList(tuple2Of);
        }
        return new MonoNameFuseable(monoNameFuseable.source, monoNameFuseable.name, listSingletonList);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        List<Tuple2<String, String>> list;
        return attr == Scannable.Attr.NAME ? this.name : (attr != Scannable.Attr.TAGS || (list = this.tagsWithDuplicates) == null) ? attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr) : list.stream();
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber;
    }

    public static <T> Mono<T> createOrAppend(Mono<T> mono, String str) {
        Objects.requireNonNull(str, "name");
        if (mono instanceof MonoName) {
            MonoName monoName = (MonoName) mono;
            return new MonoName(monoName.source, str, monoName.tagsWithDuplicates);
        }
        if (mono instanceof MonoNameFuseable) {
            MonoNameFuseable monoNameFuseable = (MonoNameFuseable) mono;
            return new MonoNameFuseable(monoNameFuseable.source, str, monoNameFuseable.tagsWithDuplicates);
        }
        if (mono instanceof Fuseable) {
            return new MonoNameFuseable(mono, str, null);
        }
        return new MonoName(mono, str, null);
    }
}
