package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlinx.coroutines.intrinsics.CancellableKt;
import lb.n;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    private final b<n> continuation;

    public LazyStandaloneCoroutine(d dVar, p<? super CoroutineScope, ? super b<? super n>, ? extends Object> pVar) {
        super(dVar, false);
        this.continuation = jd.b.o(pVar, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void onStart() throws Throwable {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }
}
