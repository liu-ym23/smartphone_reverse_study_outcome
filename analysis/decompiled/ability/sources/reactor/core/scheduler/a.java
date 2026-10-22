package reactor.core.scheduler;

import java.util.function.Predicate;
import reactor.core.scheduler.BoundedElasticScheduler;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5942a;

    public /* synthetic */ a(int i) {
        this.f5942a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5942a) {
            case 0:
                return BoundedElasticScheduler.lambda$inners$1((BoundedElasticScheduler.BoundedState) obj);
            case 1:
                return NonBlocking.class.isInstance((Thread) obj);
            default:
                return Schedulers.lambda$static$2((Thread) obj);
        }
    }
}
