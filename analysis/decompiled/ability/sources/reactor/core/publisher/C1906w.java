package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* renamed from: reactor.core.publisher.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1906w implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5938a;
    public final /* synthetic */ BiFunction b;
    public final /* synthetic */ ContextView c;

    public /* synthetic */ C1906w(BiFunction biFunction, ContextView contextView, int i) {
        this.f5938a = i;
        this.b = biFunction;
        this.c = contextView;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5938a) {
            case 0:
                return Flux.lambda$null$40(this.b, this.c, (Z9.c) obj);
            default:
                return Mono.lambda$null$37(this.b, this.c, (Z9.c) obj);
        }
    }
}
