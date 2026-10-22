package reactor.core.publisher;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10768c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10769f;

    public /* synthetic */ c0(int i) {
        this.f10768c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f10768c;
        Object obj = this.f10769f;
        switch (i) {
            case 0:
                return Flux.lambda$scan$34(obj);
            default:
                return Flux.lambda$reduce$31(obj);
        }
    }
}
