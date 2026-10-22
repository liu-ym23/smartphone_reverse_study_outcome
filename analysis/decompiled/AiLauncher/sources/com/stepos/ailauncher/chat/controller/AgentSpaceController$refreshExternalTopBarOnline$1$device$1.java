package com.stepos.ailauncher.chat.controller;

import Z8.C1173v;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.AgentSpaceController$refreshExternalTopBarOnline$1$device$1", f = "AgentSpaceController.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentSpaceController$refreshExternalTopBarOnline$1$device$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super IExternalAgentBindService.ConnectedDevice>, Object> {
    final /* synthetic */ String $agentType;
    final /* synthetic */ String $deviceId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceController$refreshExternalTopBarOnline$1$device$1(String str, String str2, InterfaceC4014c<? super AgentSpaceController$refreshExternalTopBarOnline$1$device$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$deviceId = str;
        this.$agentType = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentSpaceController$refreshExternalTopBarOnline$1$device$1 agentSpaceController$refreshExternalTopBarOnline$1$device$1 = new AgentSpaceController$refreshExternalTopBarOnline$1$device$1(this.$deviceId, this.$agentType, interfaceC4014c);
        agentSpaceController$refreshExternalTopBarOnline$1$device$1.L$0 = obj;
        return agentSpaceController$refreshExternalTopBarOnline$1$device$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super IExternalAgentBindService.ConnectedDevice> interfaceC4014c) {
        return ((AgentSpaceController$refreshExternalTopBarOnline$1$device$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            Result.Companion companion = Result.INSTANCE;
            IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
            List<IExternalAgentBindService.ConnectedDevice> listListConnectedDevices = iExternalAgentBindService != null ? iExternalAgentBindService.listConnectedDevices() : null;
            if (listListConnectedDevices == null) {
                listListConnectedDevices = C1173v.m();
            }
            objB = Result.b(listListConnectedDevices);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        String str = this.$deviceId;
        String str2 = this.$agentType;
        for (Object obj2 : (Iterable) objB) {
            IExternalAgentBindService.ConnectedDevice connectedDevice = (IExternalAgentBindService.ConnectedDevice) obj2;
            if (La.D.L(La.H.D1(connectedDevice.getDeviceId()).toString(), La.H.D1(str).toString(), true) && La.D.L(La.H.D1(connectedDevice.getAgentType()).toString(), La.H.D1(str2).toString(), true)) {
                return obj2;
            }
        }
        return null;
    }
}
