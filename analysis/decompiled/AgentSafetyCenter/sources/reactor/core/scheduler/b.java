package reactor.core.scheduler;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10891c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10892f;

    public /* synthetic */ b(int i) {
        this.f10891c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f10891c;
        Object obj = this.f10892f;
        switch (i) {
            case 0:
                return ((BoundedElasticScheduler) obj).lambda$disposeGracefully$0();
            case 1:
                return ((DelegateServiceScheduler) obj).lambda$disposeGracefully$0();
            case 2:
                return ((ParallelScheduler) obj).lambda$disposeGracefully$0();
            default:
                return ((SingleScheduler) obj).lambda$disposeGracefully$0();
        }
    }
}
