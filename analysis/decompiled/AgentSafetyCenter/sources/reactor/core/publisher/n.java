package reactor.core.publisher;

import java.util.function.Function;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10826a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ ContextView f10827b;

    public /* synthetic */ n(int i) {
        this.f10826a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10826a;
        ContextView contextView = this.f10827b;
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
