package com.stepos.ailauncher.chat.controller;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.AgentSpaceController$refreshExternalTopBarOnline$1", f = "AgentSpaceController.kt", l = {618}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentSpaceController$refreshExternalTopBarOnline$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agentType;
    final /* synthetic */ String $deviceId;
    int label;
    final /* synthetic */ AgentSpaceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceController$refreshExternalTopBarOnline$1(AgentSpaceController agentSpaceController, String str, String str2, InterfaceC4014c<? super AgentSpaceController$refreshExternalTopBarOnline$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSpaceController;
        this.$deviceId = str;
        this.$agentType = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSpaceController$refreshExternalTopBarOnline$1(this.this$0, this.$deviceId, this.$agentType, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSpaceController$refreshExternalTopBarOnline$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            kotlin.C4849c.b(r7)
            goto L31
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L18:
            kotlin.C4849c.b(r7)
            Ua.I r7 = Ua.Y.b()
            com.stepos.ailauncher.chat.controller.AgentSpaceController$refreshExternalTopBarOnline$1$device$1 r1 = new com.stepos.ailauncher.chat.controller.AgentSpaceController$refreshExternalTopBarOnline$1$device$1
            java.lang.String r4 = r6.$deviceId
            java.lang.String r5 = r6.$agentType
            r1.<init>(r4, r5, r2)
            r6.label = r3
            java.lang.Object r7 = Ua.C1056g.j(r7, r1, r6)
            if (r7 != r0) goto L31
            return r0
        L31:
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice r7 = (com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.ConnectedDevice) r7
            if (r7 == 0) goto L44
            java.lang.String r0 = r7.getDeviceName()
            if (r0 == 0) goto L44
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L42
            r2 = r0
        L42:
            if (r2 != 0) goto L4e
        L44:
            com.stepos.ailauncher.chat.controller.AgentSpaceController r0 = r6.this$0
            java.lang.String r2 = com.stepos.ailauncher.chat.controller.AgentSpaceController.D0(r0)
            if (r2 != 0) goto L4e
            java.lang.String r2 = r6.$deviceId
        L4e:
            com.stepos.ailauncher.chat.controller.AgentSpaceController r0 = r6.this$0
            com.stepos.ailauncher.chat.view.y r0 = com.stepos.ailauncher.chat.controller.AgentSpaceController.Q0(r0)
            java.lang.String r1 = r6.$deviceId
            java.lang.String r6 = r6.$agentType
            r4 = 0
            if (r7 == 0) goto L62
            boolean r7 = r7.getOnline()
            if (r7 != r3) goto L62
            goto L63
        L62:
            r3 = r4
        L63:
            com.stepos.ailauncher.chat.view.C2996w.c(r0, r1, r6, r2, r3)
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.AgentSpaceController$refreshExternalTopBarOnline$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
