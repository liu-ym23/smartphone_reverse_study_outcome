package reactor.core.publisher;

import java.util.function.Function;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* renamed from: reactor.core.publisher.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1897m implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5925a;
    public final /* synthetic */ ContextView b;

    public /* synthetic */ C1897m(ContextView contextView, int i) {
        this.f5925a = i;
        this.b = contextView;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5925a;
        ContextView contextView = this.b;
        Context context = (Context) obj;
        switch (i) {
            case 0:
                return Flux.lambda$contextWriteSkippingContextPropagation$18(contextView, context);
            case 1:
                return Flux.lambda$contextWrite$17(contextView, context);
            case 2:
                return Mono.lambda$contextWriteSkippingContextPropagation$19(contextView, context);
            default:
                return Mono.lambda$contextWrite$18(contextView, context);
        }
    }
}
