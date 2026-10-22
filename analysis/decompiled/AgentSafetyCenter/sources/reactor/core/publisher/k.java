package reactor.core.publisher;

import java.util.Collection;
import java.util.function.BiPredicate;
import reactor.core.publisher.OnNextFailureStrategy;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements BiPredicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10810c;

    public /* synthetic */ k(int i) {
        this.f10810c = i;
    }

    @Override // java.util.function.BiPredicate
    public final boolean test(Object obj, Object obj2) {
        switch (this.f10810c) {
            case 0:
                return obj.equals(obj2);
            case 1:
                return ((Collection) obj).add(obj2);
            default:
                return OnNextFailureStrategy.LambdaOnNextErrorStrategy.lambda$new$0((Throwable) obj, obj2);
        }
    }
}
