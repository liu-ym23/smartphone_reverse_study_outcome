package com.stepos.ailauncher.agent.aispace;

import Ua.C1056g;
import Ua.I;
import Ua.M;
import Ua.Y;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$onDeviceCellClicked$1", f = "AgentTabView.kt", l = {MinusOneTransitionSpec.TOTAL_DURATION_MS}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$onDeviceCellClicked$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ IExternalAgentBindService.ConnectedDevice $device;
    int label;
    final /* synthetic */ AgentTabView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$onDeviceCellClicked$1(IExternalAgentBindService.ConnectedDevice connectedDevice, AgentTabView agentTabView, InterfaceC4014c<? super AgentTabView$onDeviceCellClicked$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$device = connectedDevice;
        this.this$0 = agentTabView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$onDeviceCellClicked$1(this.$device, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentTabView$onDeviceCellClicked$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            I iB = Y.b();
            AgentTabView$onDeviceCellClicked$1$result$1 agentTabView$onDeviceCellClicked$1$result$1 = new AgentTabView$onDeviceCellClicked$1$result$1(this.$device, null);
            this.label = 1;
            obj = C1056g.j(iB, agentTabView$onDeviceCellClicked$1$result$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Object value = ((Result) obj).getValue();
        IExternalAgentBindService.ConnectedDevice connectedDevice = this.$device;
        AgentTabView agentTabView = this.this$0;
        if (Result.e(value) == null) {
            boolean zBooleanValue = ((Boolean) value).booleanValue();
            w.INSTANCE.b(connectedDevice.getDeviceId(), connectedDevice.getAgentType(), zBooleanValue);
            if (zBooleanValue) {
                agentTabView.h0(connectedDevice);
            } else {
                agentTabView.devicesAdapter.e(connectedDevice.getDeviceId(), connectedDevice.getAgentType(), false);
                agentTabView.E0(R$string.connected_devices_offline_toast);
            }
        } else {
            agentTabView.h0(connectedDevice);
        }
        return Y8.t.f7040a;
    }
}
