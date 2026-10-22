package stepai.aios.guiagent.session;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.session.SessionManager$startCleanupTask$1", f = "SessionManager.kt", l = {379, 380}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class SessionManager$startCleanupTask$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6141a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$startCleanupTask$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        SessionManager$startCleanupTask$1 sessionManager$startCleanupTask$1 = new SessionManager$startCleanupTask$1(this.c, cVar);
        sessionManager$startCleanupTask$1.b = obj;
        return sessionManager$startCleanupTask$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((SessionManager$startCleanupTask$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b A[Catch: Exception -> 0x0014, CancellationException -> 0x005e, TRY_ENTER, TryCatch #2 {CancellationException -> 0x005e, Exception -> 0x0014, blocks: (B:6:0x0010, B:17:0x002b, B:20:0x0039, B:12:0x001e), top: B:28:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0043 -> B:15:0x0025). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0046 -> B:15:0x0025). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.b
            m9.z r0 = (m9.InterfaceC1733z) r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r7.f6141a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            goto L25
        L14:
            r8 = move-exception
            goto L46
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            goto L39
        L22:
            kotlin.b.b(r8)
        L25:
            boolean r8 = m9.AbstractC1683A.l(r0)
            if (r8 == 0) goto L60
            r7.b = r0     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            r7.f6141a = r4     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            r5 = 300000(0x493e0, double:1.482197E-318)
            java.lang.Object r8 = kotlinx.coroutines.a.f(r5, r7)     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            if (r8 != r1) goto L39
            goto L45
        L39:
            stepai.aios.guiagent.session.a r8 = r7.c     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            r7.b = r0     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            r7.f6141a = r3     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            java.lang.Object r8 = r8.d(r7)     // Catch: java.lang.Exception -> L14 java.util.concurrent.CancellationException -> L5e
            if (r8 != r1) goto L25
        L45:
            return r1
        L46:
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Cleanup task error: "
            r2.<init>(r5)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.String r2 = "SessionManager"
            N9.j.J(r8, r2)
            goto L25
        L5e:
            r7 = move-exception
            throw r7
        L60:
            C7.r r7 = C7.r.f317a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.session.SessionManager$startCleanupTask$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
