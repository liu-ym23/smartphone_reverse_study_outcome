package reactor.core.publisher;

import java.util.function.Function;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class x0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Mono f10877c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f10878f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Function f10879g;

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f10877c.lambda$repeatWhenEmpty$34(this.f10878f, this.f10879g);
    }
}
