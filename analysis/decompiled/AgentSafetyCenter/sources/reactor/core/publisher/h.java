package reactor.core.publisher;

import java.util.function.Predicate;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10796c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Class f10797f;

    public /* synthetic */ h(int i) {
        this.f10796c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        Object obj2;
        int i = this.f10796c;
        Class cls = this.f10797f;
        switch (i) {
            case 0:
                obj2 = (Throwable) obj;
                break;
            case 1:
                return Flux.lambda$ofType$26(cls, obj);
            case 2:
                return Mono.lambda$ofType$27(cls, obj);
            default:
                obj2 = (Scannable) obj;
                break;
        }
        return cls.isInstance(obj2);
    }
}
