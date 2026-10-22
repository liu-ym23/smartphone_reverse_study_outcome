package reactor.util.concurrent;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10906c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f10907f;

    public /* synthetic */ a(int i) {
        this.f10906c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f10906c;
        int i3 = this.f10907f;
        switch (i) {
            case 0:
                return Queues.lambda$unbounded$1(i3);
            default:
                return Queues.lambda$get$0(i3);
        }
    }
}
