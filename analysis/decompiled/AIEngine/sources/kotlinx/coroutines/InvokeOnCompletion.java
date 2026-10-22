package kotlinx.coroutines;

import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class InvokeOnCompletion extends JobNode {
    private final l<Throwable, n> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCompletion(l<? super Throwable, n> lVar) {
        this.handler = lVar;
    }

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }
}
