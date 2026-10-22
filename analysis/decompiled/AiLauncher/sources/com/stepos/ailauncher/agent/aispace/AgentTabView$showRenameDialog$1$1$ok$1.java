package com.stepos.ailauncher.agent.aispace;

import Ua.M;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.AgentTabView$showRenameDialog$1$1$ok$1", f = "AgentTabView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentTabView$showRenameDialog$1$1$ok$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ IExternalAgentBindService.ConnectedDevice $device;
    final /* synthetic */ String $newName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentTabView$showRenameDialog$1$1$ok$1(IExternalAgentBindService.ConnectedDevice connectedDevice, String str, InterfaceC4014c<? super AgentTabView$showRenameDialog$1$1$ok$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$device = connectedDevice;
        this.$newName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentTabView$showRenameDialog$1$1$ok$1(this.$device, this.$newName, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((AgentTabView$showRenameDialog$1$1$ok$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        boolean z10 = false;
        if (iExternalAgentBindService != null && iExternalAgentBindService.renameDevice(this.$device.getDeviceId(), this.$device.getAgentType(), this.$newName)) {
            z10 = true;
        }
        return C4109a.a(z10);
    }
}
