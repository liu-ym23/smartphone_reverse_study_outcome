package Z2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public abstract class M {
    public static final Object a(long j4, Continuation continuation) {
        if (j4 <= 0) {
            return Unit.INSTANCE;
        }
        C0128h c0128h = new C0128h(1, IntrinsicsKt.intercepted(continuation));
        c0128h.u();
        if (j4 < LongCompanionObject.MAX_VALUE) {
            CoroutineContext.Element element = c0128h.get$context().get(ContinuationInterceptor.INSTANCE);
            L l4 = element instanceof L ? (L) element : null;
            if (l4 == null) {
                l4 = K.f2184a;
            }
            l4.scheduleResumeAfterDelay(j4, c0128h);
        }
        Object objT = c0128h.t();
        if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objT == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objT : Unit.INSTANCE;
    }
}
