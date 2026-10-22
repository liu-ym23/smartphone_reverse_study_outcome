package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class NoOpContinuation implements b<Object> {
    public static final NoOpContinuation INSTANCE = new NoOpContinuation();
    private static final d context = EmptyCoroutineContext.f10057a;

    private NoOpContinuation() {
    }

    @Override // qb.b
    public d getContext() {
        return context;
    }

    @Override // qb.b
    public void resumeWith(Object obj) {
    }
}
