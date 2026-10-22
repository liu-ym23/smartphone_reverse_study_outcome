package reactor.core.publisher;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class C implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5696a;
    public final /* synthetic */ Supplier b;

    public /* synthetic */ C(int i, Supplier supplier) {
        this.f5696a = i;
        this.b = supplier;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f5696a;
        Supplier supplier = this.b;
        switch (i) {
            case 0:
                return Flux.lambda$toIterable$38(supplier);
            default:
                return Mono.lambda$fromCompletionStage$0(supplier);
        }
    }
}
