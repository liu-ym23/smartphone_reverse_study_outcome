package reactor.core.publisher;

import java.util.List;
import java.util.function.BiFunction;
import reactor.util.function.Tuples;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10802c;

    public /* synthetic */ i(int i) {
        this.f10802c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f10802c) {
            case 0:
                return Tuples.of(obj, obj2);
            case 1:
                return ParallelFlux.lambda$sorted$9((List) obj, obj2);
            default:
                return ParallelFlux.lambda$collectSortedList$1((List) obj, obj2);
        }
    }
}
