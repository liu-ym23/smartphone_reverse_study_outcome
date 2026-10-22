package reactor.core.publisher;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h1 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10800a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Comparator f10801b;

    public /* synthetic */ h1(int i) {
        this.f10800a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10800a;
        Comparator comparator = this.f10801b;
        List list = (List) obj;
        switch (i) {
            case 0:
                return ParallelFlux.lambda$sorted$10(comparator, list);
            default:
                return ParallelFlux.lambda$collectSortedList$2(comparator, list);
        }
    }
}
