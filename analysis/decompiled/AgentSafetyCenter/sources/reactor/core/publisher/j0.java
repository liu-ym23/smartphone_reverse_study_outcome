package reactor.core.publisher;

import java.util.function.Function;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10806a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10807b;

    public /* synthetic */ j0(int i) {
        this.f10806a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10806a;
        Object obj2 = this.f10807b;
        switch (i) {
            case 0:
                return ((FluxCombineLatest) obj2).lambda$subscribe$0(obj);
            case 1:
                return Flux.lambda$timeout$35((Mono) obj2, obj);
            default:
                return Operators.lambda$discardLocalAdapter$1((t0) obj2, (Context) obj);
        }
    }
}
