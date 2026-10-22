package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/contract/model/ListPage;", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "page", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooStoreFragment$loadSkill$1", f = "AmooStoreFragment.kt", l = {437}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooStoreFragment$loadSkill$1 extends SuspendLambda implements p9.p<Integer, InterfaceC4014c<? super ListPage<SkillItemBrief>>, Object> {
    /* synthetic */ int I$0;
    int label;

    public AmooStoreFragment$loadSkill$1(InterfaceC4014c<? super AmooStoreFragment$loadSkill$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmooStoreFragment$loadSkill$1 amooStoreFragment$loadSkill$1 = new AmooStoreFragment$loadSkill$1(interfaceC4014c);
        amooStoreFragment$loadSkill$1.I$0 = ((Number) obj).intValue();
        return amooStoreFragment$loadSkill$1;
    }

    public final Object f(int i10, InterfaceC4014c<? super ListPage<SkillItemBrief>> interfaceC4014c) {
        return ((AmooStoreFragment$loadSkill$1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super ListPage<SkillItemBrief>> interfaceC4014c) {
        return f(num.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.I$0;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService == null) {
            throw new IllegalStateException("Market service unavailable");
        }
        this.I$0 = i10;
        this.label = 1;
        Object skillPage$default = IAgentMarketService.getSkillPage$default(iAgentMarketService, 0, i10, 20, false, null, null, null, this, 120, null);
        return skillPage$default == objG ? objG : skillPage$default;
    }
}
