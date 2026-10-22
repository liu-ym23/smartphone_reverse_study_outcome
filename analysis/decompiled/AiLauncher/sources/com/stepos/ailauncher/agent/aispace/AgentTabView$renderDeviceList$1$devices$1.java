package com.stepos.ailauncher.agent.aispace;

import Ua.M;
import Z8.C1173v;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$renderDeviceList$1$devices$1", f = "AgentTabView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$renderDeviceList$1$devices$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super List<? extends IExternalAgentBindService.ConnectedDevice>>, Object> {
    int label;

    public AgentTabView$renderDeviceList$1$devices$1(InterfaceC4014c<? super AgentTabView$renderDeviceList$1$devices$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$renderDeviceList$1$devices$1(interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<IExternalAgentBindService.ConnectedDevice>> interfaceC4014c) {
        return ((AgentTabView$renderDeviceList$1$devices$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        List<IExternalAgentBindService.ConnectedDevice> listListConnectedDevices = iExternalAgentBindService != null ? iExternalAgentBindService.listConnectedDevices() : null;
        return listListConnectedDevices == null ? C1173v.m() : listListConnectedDevices;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends IExternalAgentBindService.ConnectedDevice>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<IExternalAgentBindService.ConnectedDevice>>) interfaceC4014c);
    }
}
