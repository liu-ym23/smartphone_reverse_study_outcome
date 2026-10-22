package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10821a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ BiFunction f10822b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10823c;

    public /* synthetic */ m(int i) {
        this.f10821a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10821a) {
            case 0:
                return ((Flux) this.f10823c).lambda$transformDeferredContextual$41(this.f10822b, (ContextView) obj);
            case 1:
                return Mono.lambda$zipWhen$40((Function) this.f10823c, this.f10822b, obj);
            case 2:
                return ((Mono) this.f10823c).lambda$transformDeferredContextual$38(this.f10822b, (ContextView) obj);
            default:
                return this.f10822b.apply(this.f10823c, obj);
        }
    }
}
