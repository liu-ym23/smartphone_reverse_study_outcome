package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* renamed from: reactor.core.publisher.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1896l implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5923a;
    public final /* synthetic */ BiFunction b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1896l(Object obj, BiFunction biFunction) {
        this.f5923a = 3;
        this.b = biFunction;
        this.c = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5923a) {
            case 0:
                return ((Flux) this.c).lambda$transformDeferredContextual$41(this.b, (ContextView) obj);
            case 1:
                return Mono.lambda$zipWhen$40((Function) this.c, this.b, obj);
            case 2:
                return ((Mono) this.c).lambda$transformDeferredContextual$38(this.b, (ContextView) obj);
            default:
                return this.b.apply(this.c, obj);
        }
    }

    public /* synthetic */ C1896l(Object obj, BiFunction biFunction, int i) {
        this.f5923a = i;
        this.c = obj;
        this.b = biFunction;
    }
}
