package kotlinx.coroutines.internal;

import b6.f;
import com.stepos.core.common.log.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.ThreadContextElement;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThreadContextKt {
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
    private static final p<Object, d.a, Object> countAll = new c(3);
    private static final p<ThreadContextElement<?>, d.a, ThreadContextElement<?>> findOne = new f(4);
    private static final p<ThreadState, d.a, ThreadState> updateState = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object countAll$lambda$0(Object obj, d.a aVar) {
        if (!(aVar instanceof ThreadContextElement)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? aVar : Integer.valueOf(iIntValue + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadContextElement<?> findOne$lambda$1(ThreadContextElement<?> threadContextElement, d.a aVar) {
        if (threadContextElement != null) {
            return threadContextElement;
        }
        if (aVar instanceof ThreadContextElement) {
            return (ThreadContextElement) aVar;
        }
        return null;
    }

    public static final void restoreThreadContext(d dVar, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).restore(dVar);
            return;
        }
        Object objFold = dVar.fold(null, findOne);
        g.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) objFold).restoreThreadContext(dVar, obj);
    }

    public static final Object threadContextElements(d dVar) {
        Object objFold = dVar.fold(0, countAll);
        g.c(objFold);
        return objFold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadState updateState$lambda$2(ThreadState threadState, d.a aVar) {
        if (aVar instanceof ThreadContextElement) {
            ThreadContextElement<?> threadContextElement = (ThreadContextElement) aVar;
            threadState.append(threadContextElement, threadContextElement.updateThreadContext(threadState.context));
        }
        return threadState;
    }

    public static final Object updateThreadContext(d dVar, Object obj) {
        if (obj == null) {
            obj = threadContextElements(dVar);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return dVar.fold(new ThreadState(dVar, ((Number) obj).intValue()), updateState);
        }
        g.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(dVar);
    }
}
