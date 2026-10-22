package reactor.core.scheduler;

import java.util.function.Predicate;
import reactor.core.scheduler.BoundedElasticScheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10890c;

    public /* synthetic */ a(int i) {
        this.f10890c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f10890c) {
            case 0:
                return BoundedElasticScheduler.lambda$inners$1((BoundedElasticScheduler.BoundedState) obj);
            case 1:
                return NonBlocking.class.isInstance((Thread) obj);
            default:
                return Schedulers.lambda$static$2((Thread) obj);
        }
    }
}
