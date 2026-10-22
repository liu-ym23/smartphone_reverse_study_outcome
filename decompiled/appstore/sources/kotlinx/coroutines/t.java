package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
public final class t extends JobSupport implements CompletableDeferred {
    public t(Job r10) {
        super(true);
        H(r10);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean B() {
        return true;
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation r10) {
        Object r11 = i(r10);
        kotlin.coroutines.intrinsics.a.d();
        return r11;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean complete(Object r10) {
        return M(r10);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean completeExceptionally(Throwable r10) {
        return M(new w(r10, false, 2, null));
    }

    @Override // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return w();
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1 getOnAwait() {
        SelectClause1 r10 = A();
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return r10;
    }
}
