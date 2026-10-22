package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: reactor.core.publisher.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1895k implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5921a;
    public final /* synthetic */ BiFunction b;

    public /* synthetic */ C1895k(BiFunction biFunction, int i) {
        this.f5921a = i;
        this.b = biFunction;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5921a;
        BiFunction biFunction = this.b;
        Object[] objArr = (Object[]) obj;
        switch (i) {
            case 0:
                return Flux.lambda$zipWith$44(biFunction, objArr);
            default:
                return Flux.lambda$combineLatest$2(biFunction, objArr);
        }
    }
}
