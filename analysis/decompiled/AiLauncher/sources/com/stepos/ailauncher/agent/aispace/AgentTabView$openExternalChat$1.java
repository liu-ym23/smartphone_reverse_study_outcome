package com.stepos.ailauncher.agent.aispace;

import Ua.M;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$openExternalChat$1", f = "AgentTabView.kt", l = {692}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$openExternalChat$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ IExternalAgentBindService.ConnectedDevice $device;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$openExternalChat$1(IExternalAgentBindService.ConnectedDevice connectedDevice, InterfaceC4014c<? super AgentTabView$openExternalChat$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$device = connectedDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$openExternalChat$1(this.$device, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentTabView$openExternalChat$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
            String deviceId = this.$device.getDeviceId();
            String agentType = this.$device.getAgentType();
            this.label = 1;
            if (AgentDeviceRepository.G(agentDeviceRepository, deviceId, agentType, null, null, null, this, 28, null) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ((Result) obj).getValue();
        }
        return Y8.t.f7040a;
    }
}
