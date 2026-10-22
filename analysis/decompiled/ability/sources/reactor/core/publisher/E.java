package reactor.core.publisher;

import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CorePublisher;

/* loaded from: classes4.dex */
public final /* synthetic */ class E implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5698a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ CorePublisher c;

    public /* synthetic */ E(CorePublisher corePublisher, Function function, int i) {
        this.f5698a = i;
        this.c = corePublisher;
        this.b = function;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5698a) {
            case 0:
                return ((Flux) this.c).lambda$transformDeferred$39(this.b);
            default:
                return ((Mono) this.c).lambda$transformDeferred$36(this.b);
        }
    }
}
