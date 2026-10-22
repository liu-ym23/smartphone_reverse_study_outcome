package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.send.LocalExecResult;
import com.stepos.agentframework.chatcore.send.SendContext;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$reportSlaLocalExecuted$1", f = "SessionHandler.kt", l = {4244}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$reportSlaLocalExecuted$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ SendContext $ctx;
    final /* synthetic */ LocalExecResult $result;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$reportSlaLocalExecuted$1(SessionHandler sessionHandler, SendContext sendContext, LocalExecResult localExecResult, InterfaceC4014c<? super SessionHandler$reportSlaLocalExecuted$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$ctx = sendContext;
        this.$result = localExecResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionHandler$reportSlaLocalExecuted$1 sessionHandler$reportSlaLocalExecuted$1 = new SessionHandler$reportSlaLocalExecuted$1(this.this$0, this.$ctx, this.$result, interfaceC4014c);
        sessionHandler$reportSlaLocalExecuted$1.L$0 = obj;
        return sessionHandler$reportSlaLocalExecuted$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$reportSlaLocalExecuted$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r6.label
            r3 = 1
            if (r2 == 0) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r0 = r6.L$1
            Ua.M r0 = (Ua.M) r0
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L17
            goto L4b
        L17:
            r0 = move-exception
            r7 = r0
            goto L54
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L22:
            kotlin.C4849c.b(r7)
            com.stepos.agentframework.chatcore.SessionHandler r7 = r6.this$0
            com.stepos.agentframework.chatcore.send.e r2 = r6.$ctx
            com.stepos.agentframework.chatcore.send.b r4 = r6.$result
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L17
            com.stepos.agentframework.chatcore.session.AgentSession r7 = com.stepos.agentframework.chatcore.SessionHandler.Y(r7)     // Catch: java.lang.Throwable -> L17
            if (r7 == 0) goto L4e
            java.lang.Object r5 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L17
            r6.L$0 = r5     // Catch: java.lang.Throwable -> L17
            java.lang.Object r0 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L17
            r6.L$1 = r0     // Catch: java.lang.Throwable -> L17
            r0 = 0
            r6.I$0 = r0     // Catch: java.lang.Throwable -> L17
            r6.label = r3     // Catch: java.lang.Throwable -> L17
            java.lang.Object r7 = r7.f2(r2, r4, r6)     // Catch: java.lang.Throwable -> L17
            if (r7 != r1) goto L4b
            return r1
        L4b:
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L17
            goto L4f
        L4e:
            r7 = 0
        L4f:
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L17
            goto L5e
        L54:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L5e:
            com.stepos.agentframework.chatcore.SessionHandler r6 = r6.this$0
            java.lang.Throwable r2 = kotlin.Result.e(r7)
            if (r2 == 0) goto L73
            java.lang.String r0 = com.stepos.agentframework.chatcore.SessionHandler.Z(r6)
            r4 = 8
            r5 = 0
            java.lang.String r1 = "reportSlaLocalExecuted failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        L73:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.SessionHandler$reportSlaLocalExecuted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
