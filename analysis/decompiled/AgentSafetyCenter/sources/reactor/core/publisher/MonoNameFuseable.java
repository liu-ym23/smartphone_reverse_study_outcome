package reactor.core.publisher;

import java.util.List;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoNameFuseable<T> extends InternalMonoOperator<T, T> implements Fuseable {
    final String name;
    final List<Tuple2<String, String>> tagsWithDuplicates;

    public MonoNameFuseable(Mono<? extends T> mono, @Nullable String str, @Nullable List<Tuple2<String, String>> list) {
        super(mono);
        this.name = str;
        this.tagsWithDuplicates = list;
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
}
