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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Result;", "", "<anonymous>", "(LUa/M;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$refreshDeviceLink$1$result$1", f = "AgentTabView.kt", l = {591}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$refreshDeviceLink$1$result$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ IExternalAgentBindService.ConnectedDevice $device;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$refreshDeviceLink$1$result$1(IExternalAgentBindService.ConnectedDevice connectedDevice, InterfaceC4014c<? super AgentTabView$refreshDeviceLink$1$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$device = connectedDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$refreshDeviceLink$1$result$1(this.$device, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Result<Boolean>> interfaceC4014c) {
        return ((AgentTabView$refreshDeviceLink$1$result$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objJ;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
            String deviceId = this.$device.getDeviceId();
            String agentType = this.$device.getAgentType();
            this.label = 1;
            objJ = agentDeviceRepository.J(deviceId, agentType, this);
            if (objJ == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objJ = ((Result) obj).getValue();
        }
        return Result.a(objJ);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Result<? extends Boolean>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Result<Boolean>>) interfaceC4014c);
    }
}
