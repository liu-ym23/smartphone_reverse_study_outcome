package com.stepos.ailauncher.agent.aispace.connect;

import com.stepos.agentframework.chatui.view.AssistantImageCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService", f = "MockExternalAgentBindService.kt", l = {AssistantImageCardView.MAX_WIDTH_DP}, m = "resolveInstalledSidebarAgent", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MockExternalAgentBindService$resolveInstalledSidebarAgent$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MockExternalAgentBindService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockExternalAgentBindService$resolveInstalledSidebarAgent$1(MockExternalAgentBindService mockExternalAgentBindService, InterfaceC4014c<? super MockExternalAgentBindService$resolveInstalledSidebarAgent$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = mockExternalAgentBindService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
