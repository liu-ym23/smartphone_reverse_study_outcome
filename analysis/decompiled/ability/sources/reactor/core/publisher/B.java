package reactor.core.publisher;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class B implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5690a;
    public final /* synthetic */ Object b;

    public /* synthetic */ B(Object obj, int i) {
        this.f5690a = i;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f5690a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return Flux.lambda$scan$34(obj);
            default:
                return Flux.lambda$reduce$31(obj);
        }
    }
}
