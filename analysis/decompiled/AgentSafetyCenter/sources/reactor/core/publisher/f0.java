package reactor.core.publisher;

import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CorePublisher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class f0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10786c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Function f10787f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ CorePublisher f10788g;

    public /* synthetic */ f0(int i) {
        this.f10786c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f10786c) {
            case 0:
                return ((Flux) this.f10788g).lambda$transformDeferred$39(this.f10787f);
            default:
                return ((Mono) this.f10788g).lambda$transformDeferred$36(this.f10787f);
        }
    }
}
