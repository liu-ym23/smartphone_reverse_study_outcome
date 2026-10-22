package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class l implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10814a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ BiFunction f10815b;

    public /* synthetic */ l(int i) {
        this.f10814a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10814a;
        BiFunction biFunction = this.f10815b;
        Object[] objArr = (Object[]) obj;
        switch (i) {
            case 0:
                return Flux.lambda$zipWith$44(biFunction, objArr);
            default:
                return Flux.lambda$combineLatest$2(biFunction, objArr);
        }
    }
}
