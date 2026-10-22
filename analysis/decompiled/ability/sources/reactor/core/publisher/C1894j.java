package reactor.core.publisher;

import java.util.Collection;
import java.util.function.BiPredicate;
import reactor.core.publisher.OnNextFailureStrategy;

/* renamed from: reactor.core.publisher.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1894j implements BiPredicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5919a;

    public /* synthetic */ C1894j(int i) {
        this.f5919a = i;
    }

    @Override // java.util.function.BiPredicate
    public final boolean test(Object obj, Object obj2) {
        switch (this.f5919a) {
            case 0:
                return obj.equals(obj2);
            case 1:
                return ((Collection) obj).add(obj2);
            default:
                return OnNextFailureStrategy.LambdaOnNextErrorStrategy.lambda$new$0((Throwable) obj, obj2);
        }
    }
}
