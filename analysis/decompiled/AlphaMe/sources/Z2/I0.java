package Z2;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class I0 extends d3.u {

    /* renamed from: e, reason: collision with root package name */
    public final ThreadLocal f2180e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public I0(Continuation continuation, CoroutineContext coroutineContext) {
        J0 j02 = J0.f2183a;
        super(continuation, coroutineContext.get(j02) == null ? coroutineContext.plus(j02) : coroutineContext);
        this.f2180e = new ThreadLocal();
        if (continuation.get$context().get(ContinuationInterceptor.INSTANCE) instanceof A) {
            return;
        }
        Object objB = d3.B.b(coroutineContext, null);
        d3.B.a(coroutineContext, objB);
        b0(coroutineContext, objB);
    }

    public final boolean a0() {
        boolean z4 = this.threadLocalIsSet && this.f2180e.get() == null;
        this.f2180e.remove();
        return !z4;
    }

    public final void b0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f2180e.set(TuplesKt.to(coroutineContext, obj));
    }

    @Override // d3.u, Z2.x0
    public final void t(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.f2180e.get();
            if (pair != null) {
                d3.B.a((CoroutineContext) pair.component1(), pair.component2());
            }
            this.f2180e.remove();
        }
        Object objA = AbstractC0145t.a(obj);
        Continuation continuation = this.f12479d;
        CoroutineContext coroutineContext = continuation.get$context();
        Object objB = d3.B.b(coroutineContext, null);
        I0 i0B = objB != d3.B.f12433a ? AbstractC0149x.b(continuation, coroutineContext, objB) : null;
        try {
            this.f12479d.resumeWith(objA);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (i0B == null || i0B.a0()) {
                d3.B.a(coroutineContext, objB);
            }
        }
    }
}
