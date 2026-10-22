package reactor.core.publisher;

import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
public final /* synthetic */ class f0 implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5913a;
    public final /* synthetic */ BiFunction b;

    public /* synthetic */ f0(BiFunction biFunction, int i) {
        this.f5913a = i;
        this.b = biFunction;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f5913a;
        Z9.c cVar = (Z9.c) obj;
        CoreSubscriber coreSubscriber = (CoreSubscriber) obj2;
        BiFunction biFunction = this.b;
        switch (i) {
            case 0:
                return Operators.LiftFunction.lambda$liftScannable$1(biFunction, cVar, coreSubscriber);
            default:
                return Operators.LiftFunction.lambda$liftPublisher$2(biFunction, cVar, coreSubscriber);
        }
    }
}
