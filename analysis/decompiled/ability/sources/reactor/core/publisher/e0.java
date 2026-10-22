package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
public final /* synthetic */ class e0 implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5911a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e0(Object obj, int i) {
        this.f5911a = i;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f5911a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return Operators.LiftFunction.lambda$liftScannable$0((Predicate) obj2, (Z9.c) obj);
            default:
                return Objects.equals(obj2, obj);
        }
    }
}
