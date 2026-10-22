package Z2;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class P {
    public static final boolean a(int i4) {
        return i4 == 1 || i4 == 2;
    }

    public static final void b(O o4, Continuation continuation, boolean z4) {
        Object objE;
        Object objK = o4.k();
        Throwable thD = o4.d(objK);
        if (thD != null) {
            Result.Companion companion = Result.INSTANCE;
            objE = ResultKt.createFailure(thD);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objE = o4.e(objK);
        }
        Object objM22constructorimpl = Result.m22constructorimpl(objE);
        if (!z4) {
            continuation.resumeWith(objM22constructorimpl);
            return;
        }
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        d3.i iVar = (d3.i) continuation;
        Continuation continuation2 = iVar.f12456e;
        CoroutineContext coroutineContext = continuation2.get$context();
        Object objB = d3.B.b(coroutineContext, iVar.f12458g);
        I0 i0B = objB != d3.B.f12433a ? AbstractC0149x.b(continuation2, coroutineContext, objB) : null;
        try {
            iVar.f12456e.resumeWith(objM22constructorimpl);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (i0B == null || i0B.a0()) {
                d3.B.a(coroutineContext, objB);
            }
        }
    }
}
