package com.stepos.ailauncher;

import Ua.M;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.GlobalApplication$warmUpNetworkServices$2", f = "GlobalApplication.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GlobalApplication$warmUpNetworkServices$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public GlobalApplication$warmUpNetworkServices$2(InterfaceC4014c<? super GlobalApplication$warmUpNetworkServices$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        GlobalApplication$warmUpNetworkServices$2 globalApplication$warmUpNetworkServices$2 = new GlobalApplication$warmUpNetworkServices$2(interfaceC4014c);
        globalApplication$warmUpNetworkServices$2.L$0 = obj;
        return globalApplication$warmUpNetworkServices$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((GlobalApplication$warmUpNetworkServices$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            Result.Companion companion = Result.INSTANCE;
            IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
            Result.b(iExternalAgentBindService != null ? iExternalAgentBindService.listConnectedDevices() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return Y8.t.f7040a;
    }
}
