package reactor.core.scheduler;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5943a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f5943a = i;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f5943a;
        Object obj = this.b;
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
