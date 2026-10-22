package reactor.core.publisher;

import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;

/* renamed from: reactor.core.publisher.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1890f implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5912a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1890f(int i, Object obj, Object obj2) {
        this.f5912a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f5912a) {
            case 0:
                return ((ContextTrackingFunctionWrapper) this.b).lambda$apply$0((String) this.c, (Z9.c) obj, (CoreSubscriber) obj2);
            default:
                return Hooks.lambda$createOrUpdateOpErrorHook$1((BiFunction) this.b, (BiFunction) this.c, (Throwable) obj, obj2);
        }
    }
}
