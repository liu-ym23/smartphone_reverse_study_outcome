package reactor.core.publisher;

import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10783c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10784f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10785g;

    public /* synthetic */ f(int i) {
        this.f10783c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f10783c) {
            case 0:
                return ((ContextTrackingFunctionWrapper) this.f10784f).lambda$apply$0((String) this.f10785g, (qd.c) obj, (CoreSubscriber) obj2);
            default:
                return Hooks.lambda$createOrUpdateOpErrorHook$1((BiFunction) this.f10784f, (BiFunction) this.f10785g, (Throwable) obj, obj2);
        }
    }
}
