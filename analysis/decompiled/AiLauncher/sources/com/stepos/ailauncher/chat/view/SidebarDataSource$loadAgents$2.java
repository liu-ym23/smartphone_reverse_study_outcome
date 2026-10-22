package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import com.stepos.ailauncher.chat.view.SidebarDataSource;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.SidebarDataSource$loadAgents$2", f = "SidebarDataSource.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarDataSource$loadAgents$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends IExternalAgentBindService.SidebarAgent>>, Object> {
    final /* synthetic */ List<IExternalAgentBindService.SidebarAgent> $fallback;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SidebarDataSource$loadAgents$2(List<IExternalAgentBindService.SidebarAgent> list, InterfaceC4014c<? super SidebarDataSource$loadAgents$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fallback = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SidebarDataSource$loadAgents$2 sidebarDataSource$loadAgents$2 = new SidebarDataSource$loadAgents$2(this.$fallback, interfaceC4014c);
        sidebarDataSource$loadAgents$2.L$0 = obj;
        return sidebarDataSource$loadAgents$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<IExternalAgentBindService.SidebarAgent>> interfaceC4014c) {
        return ((SidebarDataSource$loadAgents$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            List<IExternalAgentBindService.SidebarAgent> listListSidebarAgents = iExternalAgentBindService != null ? iExternalAgentBindService.listSidebarAgents() : null;
            if (listListSidebarAgents == null) {
                listListSidebarAgents = C1173v.m();
            }
            objB = Result.b(listListSidebarAgents);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            SidebarDataSource.a.INSTANCE.c((List) objB);
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("SidebarDataSource", "Load sidebar Agent list failed", thE, false, 8, null);
        }
        return Result.g(objB) ? this.$fallback : objB;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends IExternalAgentBindService.SidebarAgent>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<IExternalAgentBindService.SidebarAgent>>) interfaceC4014c);
    }
}
