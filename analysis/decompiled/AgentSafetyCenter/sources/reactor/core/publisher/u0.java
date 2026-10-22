package reactor.core.publisher;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class u0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Supplier f10864c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f10865f;

    @Override // java.util.function.Supplier
    public final Object get() {
        return Mono.lambda$fromFuture$1(this.f10864c, this.f10865f);
    }
}
