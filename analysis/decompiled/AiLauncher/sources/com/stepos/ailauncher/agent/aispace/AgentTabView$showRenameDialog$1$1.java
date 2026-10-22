package com.stepos.ailauncher.agent.aispace;

import Ua.M;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$showRenameDialog$1$1", f = "AgentTabView.kt", l = {623, 634}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$showRenameDialog$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ IExternalAgentBindService.ConnectedDevice $device;
    final /* synthetic */ String $newName;
    int label;
    final /* synthetic */ AgentTabView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$showRenameDialog$1$1(AgentTabView agentTabView, String str, IExternalAgentBindService.ConnectedDevice connectedDevice, InterfaceC4014c<? super AgentTabView$showRenameDialog$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentTabView;
        this.$newName = str;
        this.$device = connectedDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$showRenameDialog$1$1(this.this$0, this.$newName, this.$device, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentTabView$showRenameDialog$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        if (r7 == r0) goto L30;
     */
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
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.C4849c.b(r7)
            goto L79
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1b:
            kotlin.C4849c.b(r7)
            goto L3a
        L1f:
            kotlin.C4849c.b(r7)
            com.stepos.ailauncher.agent.aispace.AgentTabView r7 = r6.this$0
            boolean r7 = com.stepos.ailauncher.agent.aispace.AgentTabView.I(r7)
            if (r7 == 0) goto L2d
            Y8.t r6 = Y8.t.f7040a
            return r6
        L2d:
            com.stepos.agentframework.chatcore.audit.ContentAuditClient r7 = com.stepos.agentframework.chatcore.audit.ContentAuditClient.INSTANCE
            java.lang.String r1 = r6.$newName
            r6.label = r4
            java.lang.Object r7 = r7.g(r2, r1, r6)
            if (r7 != r0) goto L3a
            goto L78
        L3a:
            com.stepos.agentframework.chatcore.audit.g r7 = (com.stepos.agentframework.chatcore.audit.g) r7
            com.stepos.agentframework.chatcore.audit.g$a r1 = com.stepos.agentframework.chatcore.audit.g.a.INSTANCE
            boolean r1 = kotlin.jvm.internal.p.d(r7, r1)
            if (r1 != 0) goto L9f
            com.stepos.agentframework.chatcore.audit.g$d r1 = com.stepos.agentframework.chatcore.audit.g.d.INSTANCE
            boolean r1 = kotlin.jvm.internal.p.d(r7, r1)
            if (r1 == 0) goto L4d
            goto L9f
        L4d:
            boolean r1 = r7 instanceof com.stepos.agentframework.chatcore.audit.g.Error
            if (r1 == 0) goto L5b
            com.stepos.ailauncher.agent.aispace.AgentTabView r6 = r6.this$0
            int r7 = com.stepos.ailauncher.agent.R$string.agent_market_toast_network_unavailable
            com.stepos.ailauncher.agent.aispace.AgentTabView.R(r6, r7)
            Y8.t r6 = Y8.t.f7040a
            return r6
        L5b:
            com.stepos.agentframework.chatcore.audit.g$c r1 = com.stepos.agentframework.chatcore.audit.g.c.INSTANCE
            boolean r7 = kotlin.jvm.internal.p.d(r7, r1)
            if (r7 == 0) goto L99
            Ua.I r7 = Ua.Y.b()
            com.stepos.ailauncher.agent.aispace.AgentTabView$showRenameDialog$1$1$ok$1 r1 = new com.stepos.ailauncher.agent.aispace.AgentTabView$showRenameDialog$1$1$ok$1
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice r4 = r6.$device
            java.lang.String r5 = r6.$newName
            r1.<init>(r4, r5, r2)
            r6.label = r3
            java.lang.Object r7 = Ua.C1056g.j(r7, r1, r6)
            if (r7 != r0) goto L79
        L78:
            return r0
        L79:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L8e
            com.stepos.ailauncher.agent.aispace.AgentTabView r7 = r6.this$0
            int r0 = com.stepos.ailauncher.agent.R$string.rename_toast_done
            com.stepos.ailauncher.agent.aispace.AgentTabView.R(r7, r0)
            com.stepos.ailauncher.agent.aispace.AgentTabView r6 = r6.this$0
            com.stepos.ailauncher.agent.aispace.AgentTabView.L(r6)
            goto L96
        L8e:
            com.stepos.ailauncher.agent.aispace.AgentTabView r6 = r6.this$0
            java.lang.String r7 = "重命名失败"
            com.stepos.ailauncher.agent.aispace.AgentTabView.S(r6, r7)
        L96:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L99:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L9f:
            com.stepos.ailauncher.agent.aispace.AgentTabView r6 = r6.this$0
            int r7 = com.stepos.ailauncher.agent.R$string.rename_audit_blocked
            com.stepos.ailauncher.agent.aispace.AgentTabView.R(r6, r7)
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.AgentTabView$showRenameDialog$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
