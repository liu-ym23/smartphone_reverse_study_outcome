package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Collection;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/contract/model/ListPage;", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "page", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooSkillListFragment$loadSkills$1", f = "AmooSkillListFragment.kt", l = {152, 153}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooSkillListFragment$loadSkills$1 extends SuspendLambda implements p9.p<Integer, InterfaceC4014c<? super ListPage<SkillItemBrief>>, Object> {
    final /* synthetic */ int $necessary;
    final /* synthetic */ boolean $showCli;
    final /* synthetic */ boolean $testing;
    /* synthetic */ int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmooSkillListFragment$loadSkills$1(int i10, boolean z10, boolean z11, InterfaceC4014c<? super AmooSkillListFragment$loadSkills$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$necessary = i10;
        this.$testing = z10;
        this.$showCli = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmooSkillListFragment$loadSkills$1 amooSkillListFragment$loadSkills$1 = new AmooSkillListFragment$loadSkills$1(this.$necessary, this.$testing, this.$showCli, interfaceC4014c);
        amooSkillListFragment$loadSkills$1.I$0 = ((Number) obj).intValue();
        return amooSkillListFragment$loadSkills$1;
    }

    public final Object f(int i10, InterfaceC4014c<? super ListPage<SkillItemBrief>> interfaceC4014c) {
        return ((AmooSkillListFragment$loadSkills$1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super ListPage<SkillItemBrief>> interfaceC4014c) {
        return f(num.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IAgentMarketService iAgentMarketService;
        AmooSkillListFragment$loadSkills$1 amooSkillListFragment$loadSkills$1;
        ListPage listPage;
        ListPage listPage2;
        int i10 = this.I$0;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 == 0) {
            C4849c.b(obj);
            iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
            if (iAgentMarketService == null) {
                throw new IllegalStateException("Market service unavailable");
            }
            int i12 = this.$necessary;
            boolean z10 = this.$testing;
            this.L$0 = iAgentMarketService;
            this.I$0 = i10;
            this.label = 1;
            obj = IAgentMarketService.getSkillPage$default(iAgentMarketService, i12, i10, 50, z10, null, null, null, this, 112, null);
            amooSkillListFragment$loadSkills$1 = this;
            if (obj != objG) {
            }
            return objG;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            listPage = (ListPage) this.L$2;
            listPage2 = (ListPage) this.L$1;
            C4849c.b(obj);
            return ListPage.copy$default(listPage, Z8.F.S0((Collection) obj, listPage2.getItems()), null, null, 6, null);
        }
        iAgentMarketService = (IAgentMarketService) this.L$0;
        C4849c.b(obj);
        amooSkillListFragment$loadSkills$1 = this;
        IAgentMarketService iAgentMarketService2 = iAgentMarketService;
        listPage = (ListPage) obj;
        if (i10 != 1 || !amooSkillListFragment$loadSkills$1.$showCli) {
            return listPage;
        }
        amooSkillListFragment$loadSkills$1.L$0 = g9.h.a(iAgentMarketService2);
        amooSkillListFragment$loadSkills$1.L$1 = listPage;
        amooSkillListFragment$loadSkills$1.L$2 = listPage;
        amooSkillListFragment$loadSkills$1.I$0 = i10;
        amooSkillListFragment$loadSkills$1.label = 2;
        obj = IAgentMarketService.getCliList$default(iAgentMarketService2, null, null, amooSkillListFragment$loadSkills$1, 3, null);
        if (obj != objG) {
            listPage2 = listPage;
            return ListPage.copy$default(listPage, Z8.F.S0((Collection) obj, listPage2.getItems()), null, null, 6, null);
        }
        return objG;
    }
}
