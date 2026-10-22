package reactor.core.publisher;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class i0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5918a;
    public final /* synthetic */ Comparator b;

    public /* synthetic */ i0(Comparator comparator, int i) {
        this.f5918a = i;
        this.b = comparator;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5918a;
        Comparator comparator = this.b;
        List list = (List) obj;
        switch (i) {
            case 0:
                return ParallelFlux.lambda$sorted$10(comparator, list);
            default:
                return ParallelFlux.lambda$collectSortedList$2(comparator, list);
        }
    }
}
