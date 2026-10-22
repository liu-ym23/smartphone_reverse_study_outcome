package reactor.core.publisher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Supplier;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10761c;

    public /* synthetic */ b(int i) {
        this.f10761c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f10761c) {
            case 0:
                return CallSiteSupplierFactory.lambda$static$1();
            case 1:
                return ContextPropagation.contextCaptureToEmpty();
            case 2:
                return new ArrayList();
            case 3:
                return new HashSet();
            case 4:
                return Context.empty();
            case 5:
                return Flux.lambda$collectMap$11();
            case 6:
                return Flux.lambda$collectMultimap$13();
            default:
                return Mono.lambda$null$32();
        }
    }
}
