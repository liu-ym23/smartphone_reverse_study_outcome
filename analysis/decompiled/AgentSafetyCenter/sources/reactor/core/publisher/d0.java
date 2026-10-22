package reactor.core.publisher;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class d0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10775c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Supplier f10776f;

    public /* synthetic */ d0(int i) {
        this.f10775c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f10775c;
        Supplier supplier = this.f10776f;
        switch (i) {
            case 0:
                return Flux.lambda$toIterable$38(supplier);
            default:
                return Mono.lambda$fromCompletionStage$0(supplier);
        }
    }
}
