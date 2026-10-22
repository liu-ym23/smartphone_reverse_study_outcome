package kotlinx.coroutines;

import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class ResumeOnCompletion extends JobNode {
    private final b<n> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(b<? super n> bVar) {
        this.continuation = bVar;
    }

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(Throwable th) {
        this.continuation.resumeWith(n.f10413a);
    }
}
