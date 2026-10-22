package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$reconcileInterruptedRoundAfterRestart$1", f = "SessionHandler.kt", l = {2807}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$reconcileInterruptedRoundAfterRestart$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession $currentSession;
    final /* synthetic */ String $sessionId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$reconcileInterruptedRoundAfterRestart$1(SessionHandler sessionHandler, AgentSession agentSession, String str, InterfaceC4014c<? super SessionHandler$reconcileInterruptedRoundAfterRestart$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$currentSession = agentSession;
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionHandler$reconcileInterruptedRoundAfterRestart$1 sessionHandler$reconcileInterruptedRoundAfterRestart$1 = new SessionHandler$reconcileInterruptedRoundAfterRestart$1(this.this$0, this.$currentSession, this.$sessionId, interfaceC4014c);
        sessionHandler$reconcileInterruptedRoundAfterRestart$1.L$0 = obj;
        return sessionHandler$reconcileInterruptedRoundAfterRestart$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$reconcileInterruptedRoundAfterRestart$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r8.label
            r3 = 1
            if (r2 == 0) goto L24
            if (r2 != r3) goto L1c
            java.lang.Object r0 = r8.L$1
            Ua.M r0 = (Ua.M) r0
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L18
            r7 = r8
            goto L4c
        L18:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L61
        L1c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L24:
            kotlin.C4849c.b(r9)
            com.stepos.agentframework.chatcore.SessionHandler r2 = r8.this$0
            r9 = r3
            com.stepos.agentframework.chatcore.session.AgentSession r3 = r8.$currentSession
            java.lang.String r4 = r8.$sessionId
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = "reconcileInterruptedRound"
            java.lang.Object r5 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L5e
            r8.L$0 = r5     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r0 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L5e
            r8.L$1 = r0     // Catch: java.lang.Throwable -> L5e
            r0 = 0
            r8.I$0 = r0     // Catch: java.lang.Throwable -> L5e
            r8.label = r9     // Catch: java.lang.Throwable -> L5e
            r5 = 0
            r7 = r8
            java.lang.Object r9 = com.stepos.agentframework.chatcore.SessionHandler.j0(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5b
            if (r9 != r1) goto L4c
            return r1
        L4c:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L5b
            boolean r8 = r9.booleanValue()     // Catch: java.lang.Throwable -> L5b
            java.lang.Boolean r8 = g9.C4109a.a(r8)     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L5b
            goto L6b
        L5b:
            r0 = move-exception
        L5c:
            r9 = r0
            goto L61
        L5e:
            r0 = move-exception
            r7 = r8
            goto L5c
        L61:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r9)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L6b:
            com.stepos.agentframework.chatcore.SessionHandler r9 = r7.this$0
            java.lang.String r0 = r7.$sessionId
            java.lang.Throwable r3 = kotlin.Result.e(r8)
            if (r3 == 0) goto L91
            java.lang.String r1 = com.stepos.agentframework.chatcore.SessionHandler.Z(r9)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "reconcileInterruptedRound failed sessionId="
            r8.append(r9)
            r8.append(r0)
            java.lang.String r2 = r8.toString()
            r5 = 8
            r6 = 0
            r4 = 0
            h8.C4148a.g(r1, r2, r3, r4, r5, r6)
        L91:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.SessionHandler$reconcileInterruptedRoundAfterRestart$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
