package reactor.core.publisher;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import reactor.core.CorePublisher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class q implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10839c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ BooleanSupplier f10840f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long f10841g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ CorePublisher f10842h;

    public /* synthetic */ q(int i) {
        this.f10839c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f10839c) {
            case 0:
                return ((Flux) this.f10842h).lambda$repeat$32(this.f10840f, this.f10841g);
            default:
                return ((Mono) this.f10842h).lambda$repeat$31(this.f10840f, this.f10841g);
        }
    }
}
