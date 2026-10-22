package com.stepos.ailauncher.chat.controller;

import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1", f = "SidebarAgentActionsController.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ SidebarAgentItem $agent;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1(SidebarAgentItem sidebarAgentItem, InterfaceC4014c<? super SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$agent = sidebarAgentItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1 sidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1 = new SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1(this.$agent, interfaceC4014c);
        sidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1.L$0 = obj;
        return sidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r3) throws java.lang.Throwable {
        /*
            r2 = this;
            java.lang.Object r0 = r2.L$0
            Ua.M r0 = (Ua.M) r0
            f9.C4063a.g()
            int r0 = r2.label
            if (r0 != 0) goto L52
            kotlin.C4849c.b(r3)
            com.stepos.ailauncher.chat.view.s8 r2 = r2.$agent
            r3 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L31
            D5.a r0 = D5.a.INSTANCE     // Catch: java.lang.Throwable -> L31
            java.lang.Class<com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService> r1 = com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.class
            java.lang.Object r0 = r0.a(r1)     // Catch: java.lang.Throwable -> L31
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService r0 = (com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService) r0     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto L2f
            java.lang.String r1 = r2.getDeviceId()     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r2.getAgentId()     // Catch: java.lang.Throwable -> L31
            boolean r2 = r0.deleteDevice(r1, r2, r3)     // Catch: java.lang.Throwable -> L31
            r0 = 1
            if (r2 != r0) goto L2f
            goto L33
        L2f:
            r0 = r3
            goto L33
        L31:
            r2 = move-exception
            goto L3c
        L33:
            java.lang.Boolean r2 = g9.C4109a.a(r0)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L31
            goto L46
        L3c:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.C4849c.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L46:
            java.lang.Throwable r0 = kotlin.Result.e(r2)
            if (r0 != 0) goto L4d
            goto L51
        L4d:
            java.lang.Boolean r2 = g9.C4109a.a(r3)
        L51:
            return r2
        L52:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
