package stepai.aios.guiagent.event;

import C7.r;
import H7.c;
import M0.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.model.TakeoverReasonType;
import wa.C2110a;
import za.d;
import za.i;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final stepai.aios.guiagent.session.a f6028a;
    public final C2110a b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();

    public a(stepai.aios.guiagent.session.a aVar, C2110a c2110a) {
        this.f6028a = aVar;
        this.b = c2110a;
    }

    public static Object f(c cVar, String str, String str2, a aVar, i iVar) {
        TakeoverReasonType takeoverReasonType = TakeoverReasonType.f6034a;
        aVar.getClass();
        Object objJ = aVar.j(str, new TaskLifecycleManager$takeover$4(null, str2, str, aVar, iVar), cVar);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final Object a(String str, k kVar, String str2, ContinuationImpl continuationImpl) {
        Object objJ = j(str, new TaskLifecycleManager$cancel$2(kVar, str2, this, str, null), continuationImpl);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final void b(String sessionId) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        this.c.remove(sessionId);
    }

    public final Object c(String str, k kVar, d dVar, ContinuationImpl continuationImpl) {
        Object objJ = j(str, new TaskLifecycleManager$complete$2(kVar, this, str, dVar, null), continuationImpl);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final Object d(String str, k kVar, Throwable th, ContinuationImpl continuationImpl) {
        Object objJ = j(str, new TaskLifecycleManager$fail$2(kVar, th, this, str, null), continuationImpl);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final Object e(String str, k kVar, String str2, TakeoverReasonType takeoverReasonType, ContinuationImpl continuationImpl) {
        Object objJ = j(str, new TaskLifecycleManager$takeover$2(kVar, str2, takeoverReasonType, this, str, null), continuationImpl);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final Object g(String str, k kVar, za.c cVar, ContinuationImpl continuationImpl) {
        Object objJ = j(str, new TaskLifecycleManager$updateProgress$2(this, str, cVar, kVar, null), continuationImpl);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final Object h(String str, k kVar, i iVar, ContinuationImpl continuationImpl) {
        Object objJ = j(str, new TaskLifecycleManager$updateState$2(kVar, iVar, this, str, null), continuationImpl);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    public final Object i(String str, i iVar, c cVar) {
        Object objJ = j(str, new TaskLifecycleManager$updateState$4(this, str, iVar, null), cVar);
        return objJ == CoroutineSingletons.f4909a ? objJ : r.f317a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        if (r11 == r1) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [S7.k] */
    /* JADX WARN: Type inference failed for: r8v0, types: [stepai.aios.guiagent.event.a] */
    /* JADX WARN: Type inference failed for: r8v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v6, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r9, S7.k r10, H7.c r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof stepai.aios.guiagent.event.TaskLifecycleManager$withSessionLock$1
            if (r0 == 0) goto L13
            r0 = r11
            stepai.aios.guiagent.event.TaskLifecycleManager$withSessionLock$1 r0 = (stepai.aios.guiagent.event.TaskLifecycleManager$withSessionLock$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            stepai.aios.guiagent.event.TaskLifecycleManager$withSessionLock$1 r0 = new stepai.aios.guiagent.event.TaskLifecycleManager$withSessionLock$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            w9.a r8 = r0.b
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L2d
            goto L86
        L2d:
            r9 = move-exception
            goto L8a
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            int r8 = r0.c
            w9.a r9 = r0.b
            kotlin.coroutines.jvm.internal.SuspendLambda r10 = r0.f6027a
            S7.k r10 = (S7.k) r10
            kotlin.b.b(r11)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L77
        L46:
            kotlin.b.b(r11)
            t5.a r11 = new t5.a
            r2 = 23
            r11.<init>(r2)
            Ba.g r2 = new Ba.g
            r6 = 11
            r2.<init>(r11, r6)
            java.util.concurrent.ConcurrentHashMap r8 = r8.c
            java.lang.Object r8 = r8.computeIfAbsent(r9, r2)
            java.lang.String r9 = "computeIfAbsent(...)"
            kotlin.jvm.internal.k.e(r8, r9)
            w9.a r8 = (w9.InterfaceC2108a) r8
            r9 = r10
            kotlin.coroutines.jvm.internal.SuspendLambda r9 = (kotlin.coroutines.jvm.internal.SuspendLambda) r9
            r0.f6027a = r9
            r0.b = r8
            r9 = 0
            r0.c = r9
            r0.f = r4
            java.lang.Object r11 = r8.lock(r5, r0)
            if (r11 != r1) goto L77
            goto L85
        L77:
            r0.f6027a = r5     // Catch: java.lang.Throwable -> L2d
            r0.b = r8     // Catch: java.lang.Throwable -> L2d
            r0.c = r9     // Catch: java.lang.Throwable -> L2d
            r0.f = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r11 = r10.invoke(r0)     // Catch: java.lang.Throwable -> L2d
            if (r11 != r1) goto L86
        L85:
            return r1
        L86:
            r8.unlock(r5)
            return r11
        L8a:
            r8.unlock(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.event.a.j(java.lang.String, S7.k, H7.c):java.lang.Object");
    }
}
