package reactor.core.publisher;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/* renamed from: reactor.core.publisher.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1901q implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5932a;
    public final /* synthetic */ Flux b;
    public final /* synthetic */ Function c;
    public final /* synthetic */ BiPredicate d;

    public /* synthetic */ C1901q(Flux flux, Function function, BiPredicate biPredicate, int i) {
        this.f5932a = i;
        this.b = flux;
        this.c = function;
        this.d = biPredicate;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5932a) {
            case 0:
                return this.b.lambda$bufferUntilChanged$8(this.c, this.d);
            default:
                return this.b.lambda$windowUntilChanged$43(this.c, this.d);
        }
    }
}
