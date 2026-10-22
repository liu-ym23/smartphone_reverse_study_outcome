package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.d;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class StackFrameContinuation<T> implements b<T>, rb.b {
    private final d context;
    private final b<T> uCont;

    /* JADX WARN: Multi-variable type inference failed */
    public StackFrameContinuation(b<? super T> bVar, d dVar) {
        this.uCont = bVar;
        this.context = dVar;
    }

    @Override // rb.b
    public rb.b getCallerFrame() {
        b<T> bVar = this.uCont;
        if (bVar instanceof rb.b) {
            return (rb.b) bVar;
        }
        return null;
    }

    @Override // qb.b
    public d getContext() {
        return this.context;
    }

    @Override // qb.b
    public void resumeWith(Object obj) {
        this.uCont.resumeWith(obj);
    }
}
