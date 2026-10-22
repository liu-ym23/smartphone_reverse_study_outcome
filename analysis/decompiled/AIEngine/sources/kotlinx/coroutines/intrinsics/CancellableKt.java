package kotlinx.coroutines.intrinsics;

import kotlin.c;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import lb.n;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CancellableKt {
    private static final void dispatcherFailure(b<?> bVar, Throwable th) throws Throwable {
        bVar.resumeWith(c.a(th));
        throw th;
    }

    public static final <R, T> void startCoroutineCancellable(p<? super R, ? super b<? super T>, ? extends Object> pVar, R r, b<? super T> bVar) {
        try {
            DispatchedContinuationKt.resumeCancellableWith(jd.b.w(jd.b.o(pVar, r, bVar)), n.f10413a);
        } catch (Throwable th) {
            dispatcherFailure(bVar, th);
        }
    }

    public static final void startCoroutineCancellable(b<? super n> bVar, b<?> bVar2) throws Throwable {
        try {
            DispatchedContinuationKt.resumeCancellableWith(jd.b.w(bVar), n.f10413a);
        } catch (Throwable th) {
            dispatcherFailure(bVar2, th);
        }
    }
}
