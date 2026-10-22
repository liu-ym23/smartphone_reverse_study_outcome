package reactor.core.publisher;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class r implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10846c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Flux f10847f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Function f10848g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ BiPredicate f10849h;

    public /* synthetic */ r(int i) {
        this.f10846c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f10846c) {
            case 0:
                return this.f10847f.lambda$bufferUntilChanged$8(this.f10848g, this.f10849h);
            default:
                return this.f10847f.lambda$windowUntilChanged$43(this.f10848g, this.f10849h);
        }
    }
}
