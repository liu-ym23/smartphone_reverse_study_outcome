package reactor.core.publisher;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import reactor.core.CorePublisher;

/* renamed from: reactor.core.publisher.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1900p implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5930a;
    public final /* synthetic */ BooleanSupplier b;
    public final /* synthetic */ long c;
    public final /* synthetic */ CorePublisher d;

    public /* synthetic */ C1900p(CorePublisher corePublisher, BooleanSupplier booleanSupplier, long j5, int i) {
        this.f5930a = i;
        this.d = corePublisher;
        this.b = booleanSupplier;
        this.c = j5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5930a) {
            case 0:
                return ((Flux) this.d).lambda$repeat$32(this.b, this.c);
            default:
                return ((Mono) this.d).lambda$repeat$31(this.b, this.c);
        }
    }
}
