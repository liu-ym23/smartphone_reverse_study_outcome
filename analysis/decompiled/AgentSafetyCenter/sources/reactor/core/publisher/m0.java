package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFlatMap;
import reactor.core.publisher.FluxOnAssembly;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class m0 implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10824c;

    public /* synthetic */ m0(int i) {
        this.f10824c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f10824c) {
            case 0:
                return Objects.nonNull((FluxFlatMap.FlatMapInner) obj);
            case 1:
                return FluxOnAssembly.OnAssemblyException.lambda$add$0((Scannable) obj);
            case 2:
                return Traces.lambda$extractOperatorAssemblyInformationParts$0((String) obj);
            default:
                return Objects.nonNull(obj);
        }
    }
}
