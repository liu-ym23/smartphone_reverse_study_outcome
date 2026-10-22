package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
public class h0 extends a implements Deferred {
    public h0(CoroutineContext r10, boolean r11) {
        super(r10, true, r11);
    }

    public static /* synthetic */ Object r0(h0 r10, Continuation r11) {
        Object r12 = r10.i(r11);
        kotlin.coroutines.intrinsics.a.d();
        return r12;
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation r10) {
        return r0(this, r10);
    }

    @Override // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return w();
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1 getOnAwait() {
        SelectClause1 r10 = A();
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return r10;
    }
}
