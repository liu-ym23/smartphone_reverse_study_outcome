package kotlinx.coroutines;

import kotlin.coroutines.d;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class StandaloneCoroutine extends AbstractCoroutine<n> {
    public StandaloneCoroutine(d dVar, boolean z) {
        super(dVar, true, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }
}
