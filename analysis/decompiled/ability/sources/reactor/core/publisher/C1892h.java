package reactor.core.publisher;

import java.util.List;
import java.util.function.BiFunction;
import reactor.util.function.Tuples;

/* renamed from: reactor.core.publisher.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1892h implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5916a;

    public /* synthetic */ C1892h(int i) {
        this.f5916a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f5916a) {
            case 0:
                return Tuples.of(obj, obj2);
            case 1:
                return ParallelFlux.lambda$sorted$9((List) obj, obj2);
            default:
                return ParallelFlux.lambda$collectSortedList$1((List) obj, obj2);
        }
    }
}
