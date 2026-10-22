package reactor.core.publisher;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class p0 implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10837c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10838f;

    public /* synthetic */ p0(int i) {
        this.f10837c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f10837c;
        Object obj3 = this.f10838f;
        switch (i) {
            case 0:
                return FluxGenerate.lambda$new$1((Consumer) obj3, obj, (SynchronousSink) obj2);
            default:
                return ParallelFlux.lambda$collectSortedList$3((Comparator) obj3, (List) obj, (List) obj2);
        }
    }
}
