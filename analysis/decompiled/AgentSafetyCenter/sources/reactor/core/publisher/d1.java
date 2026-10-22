package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.publisher.Operators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class d1 implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10777c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10778f;

    public /* synthetic */ d1(int i) {
        this.f10777c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f10777c;
        Object obj2 = this.f10778f;
        switch (i) {
            case 0:
                return Operators.LiftFunction.lambda$liftScannable$0((Predicate) obj2, (qd.c) obj);
            default:
                return Objects.equals(obj2, obj);
        }
    }
}
