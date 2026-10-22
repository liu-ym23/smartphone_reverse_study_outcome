package reactor.core.publisher;

import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Operators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class e1 implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10781c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ BiFunction f10782f;

    public /* synthetic */ e1(int i) {
        this.f10781c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f10781c;
        BiFunction biFunction = this.f10782f;
        qd.c cVar = (qd.c) obj;
        CoreSubscriber coreSubscriber = (CoreSubscriber) obj2;
        switch (i) {
            case 0:
                return Operators.LiftFunction.lambda$liftScannable$1(biFunction, cVar, coreSubscriber);
            default:
                return Operators.LiftFunction.lambda$liftPublisher$2(biFunction, cVar, coreSubscriber);
        }
    }
}
