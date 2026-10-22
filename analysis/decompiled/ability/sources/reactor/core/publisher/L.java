package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFlatMap;
import reactor.core.publisher.FluxOnAssembly;

/* loaded from: classes4.dex */
public final /* synthetic */ class L implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5840a;

    public /* synthetic */ L(int i) {
        this.f5840a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5840a) {
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
