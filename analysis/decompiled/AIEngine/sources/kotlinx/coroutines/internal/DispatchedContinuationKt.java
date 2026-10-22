package kotlinx.coroutines.internal;

import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DispatchedContinuationKt {
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:28:0x0087 A[Catch: all -> 0x0060, DONT_GENERATE, TryCatch #0 {all -> 0x0060, blocks: (B:12:0x003d, B:14:0x004b, B:16:0x0051, B:29:0x008a, B:19:0x0062, B:21:0x0072, B:26:0x0081, B:28:0x0087, B:34:0x0097, B:37:0x00a0, B:36:0x009d, B:24:0x0078), top: B:46:0x003d, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void resumeCancellableWith(qb.b<? super T> r6, java.lang.Object r7) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto Lab
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            java.lang.Object r0 = kotlinx.coroutines.CompletionStateKt.toState(r7)
            kotlinx.coroutines.CoroutineDispatcher r1 = r6.dispatcher
            kotlin.coroutines.d r2 = r6.getContext()
            boolean r1 = r1.isDispatchNeeded(r2)
            r2 = 1
            if (r1 == 0) goto L25
            r6._state = r0
            r6.resumeMode = r2
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.dispatcher
            kotlin.coroutines.d r0 = r6.getContext()
            r7.dispatch(r0, r6)
            return
        L25:
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.getEventLoop$kotlinx_coroutines_core()
            boolean r3 = r1.isUnconfinedLoopActive()
            if (r3 == 0) goto L3a
            r6._state = r0
            r6.resumeMode = r2
            r1.dispatchUnconfined(r6)
            goto La5
        L3a:
            r1.incrementUseCount(r2)
            kotlin.coroutines.d r3 = r6.getContext()     // Catch: java.lang.Throwable -> L60
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key     // Catch: java.lang.Throwable -> L60
            kotlin.coroutines.d$a r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L60
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L62
            boolean r4 = r3.isActive()     // Catch: java.lang.Throwable -> L60
            if (r4 != 0) goto L62
            java.util.concurrent.CancellationException r7 = r3.getCancellationException()     // Catch: java.lang.Throwable -> L60
            r6.cancelCompletedResult$kotlinx_coroutines_core(r0, r7)     // Catch: java.lang.Throwable -> L60
            kotlin.Result$Failure r7 = kotlin.c.a(r7)     // Catch: java.lang.Throwable -> L60
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L60
            goto L8a
        L60:
            r7 = move-exception
            goto La1
        L62:
            qb.b<T> r0 = r6.continuation     // Catch: java.lang.Throwable -> L60
            java.lang.Object r3 = r6.countOrElement     // Catch: java.lang.Throwable -> L60
            kotlin.coroutines.d r4 = r0.getContext()     // Catch: java.lang.Throwable -> L60
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r4, r3)     // Catch: java.lang.Throwable -> L60
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch: java.lang.Throwable -> L60
            if (r3 == r5) goto L77
            kotlinx.coroutines.UndispatchedCoroutine r0 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r0, r4, r3)     // Catch: java.lang.Throwable -> L60
            goto L78
        L77:
            r0 = 0
        L78:
            qb.b<T> r5 = r6.continuation     // Catch: java.lang.Throwable -> L94
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L94
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L87
            boolean r7 = r0.clearThreadContext()     // Catch: java.lang.Throwable -> L60
            if (r7 == 0) goto L8a
        L87:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r4, r3)     // Catch: java.lang.Throwable -> L60
        L8a:
            boolean r7 = r1.processUnconfinedEvent()     // Catch: java.lang.Throwable -> L60
            if (r7 != 0) goto L8a
        L90:
            r1.decrementUseCount(r2)
            goto La5
        L94:
            r7 = move-exception
            if (r0 == 0) goto L9d
            boolean r0 = r0.clearThreadContext()     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto La0
        L9d:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r4, r3)     // Catch: java.lang.Throwable -> L60
        La0:
            throw r7     // Catch: java.lang.Throwable -> L60
        La1:
            r6.handleFatalException$kotlinx_coroutines_core(r7)     // Catch: java.lang.Throwable -> La6
            goto L90
        La5:
            return
        La6:
            r6 = move-exception
            r1.decrementUseCount(r2)
            throw r6
        Lab:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(qb.b, java.lang.Object):void");
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super n> dispatchedContinuation) {
        n nVar = n.f10413a;
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = nVar;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
