package reactor.core.publisher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Supplier;
import reactor.util.context.Context;

/* renamed from: reactor.core.publisher.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1886b implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5905a;

    public /* synthetic */ C1886b(int i) {
        this.f5905a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5905a) {
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
