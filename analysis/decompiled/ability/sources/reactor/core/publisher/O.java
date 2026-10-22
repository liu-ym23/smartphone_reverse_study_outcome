package reactor.core.publisher;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* loaded from: classes4.dex */
public final /* synthetic */ class O implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5874a;
    public final /* synthetic */ Object b;

    public /* synthetic */ O(Object obj, int i) {
        this.f5874a = i;
        this.b = obj;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f5874a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                return FluxGenerate.lambda$new$1((Consumer) obj3, obj, (SynchronousSink) obj2);
            default:
                return ParallelFlux.lambda$collectSortedList$3((Comparator) obj3, (List) obj, (List) obj2);
        }
    }
}
