package reactor.core.publisher;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i1 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10804c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f10805f;

    public /* synthetic */ i1(int i) {
        this.f10804c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f10804c;
        int i3 = this.f10805f;
        switch (i) {
            case 0:
                return ParallelFlux.lambda$collectSortedList$0(i3);
            default:
                return ParallelFlux.lambda$sorted$8(i3);
        }
    }
}
