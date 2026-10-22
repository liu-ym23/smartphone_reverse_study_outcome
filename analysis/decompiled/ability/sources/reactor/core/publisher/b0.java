package reactor.core.publisher;

import java.util.function.Predicate;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
public final /* synthetic */ class b0 implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5906a;
    public final /* synthetic */ Class b;

    public /* synthetic */ b0() {
        this.f5906a = 0;
        this.b = InnerProducer.class;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        Object obj2;
        int i = this.f5906a;
        Class cls = this.b;
        switch (i) {
            case 0:
                obj2 = (Scannable) obj;
                break;
            case 1:
                obj2 = (Throwable) obj;
                break;
            case 2:
                return Flux.lambda$ofType$26(cls, obj);
            default:
                return Mono.lambda$ofType$27(cls, obj);
        }
        return cls.isInstance(obj2);
    }

    public /* synthetic */ b0(Class cls, int i) {
        this.f5906a = i;
        this.b = cls;
    }
}
