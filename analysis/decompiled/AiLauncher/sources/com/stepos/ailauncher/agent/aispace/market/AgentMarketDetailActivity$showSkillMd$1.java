package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1056g;
import com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$showSkillMd$1", f = "AgentMarketDetailActivity.kt", l = {589}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$showSkillMd$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSkillDto $skill;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ AgentMarketDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$showSkillMd$1(AgentSkillDto agentSkillDto, AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$showSkillMd$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$skill = agentSkillDto;
        this.this$0 = agentMarketDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$showSkillMd$1(this.$skill, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailActivity$showSkillMd$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            String skillId = this.$skill.getSkillId();
            AgentMarketItem agentMarketItem = this.this$0.item;
            if (agentMarketItem == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem = null;
            }
            boolean testing = agentMarketItem.getTesting();
            Ua.I iB = Ua.Y.b();
            AgentMarketDetailActivity$showSkillMd$1$fetched$1 agentMarketDetailActivity$showSkillMd$1$fetched$1 = new AgentMarketDetailActivity$showSkillMd$1$fetched$1(this.$skill, skillId, testing ? 1 : 0, this.this$0, null);
            this.L$0 = g9.h.a(skillId);
            this.I$0 = testing ? 1 : 0;
            this.label = 1;
            obj = C1056g.j(iB, agentMarketDetailActivity$showSkillMd$1$fetched$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Triple triple = (Triple) obj;
        if (triple == null) {
            this.this$0.e1("加载失败，请稍后重试");
            return Y8.t.f7040a;
        }
        String str = (String) triple.a();
        String str2 = (String) triple.b();
        SkillDetailActivity.Companion companion = SkillDetailActivity.INSTANCE;
        if (str == null) {
            str = "";
        }
        String string = La.H.D1(companion.c(str)).toString();
        if (La.H.x0(string)) {
            if (str2 == null) {
                str2 = "";
            }
            string = La.H.x0(str2) ? "—" : str2;
        }
        AgentMarketDetailActivity agentMarketDetailActivity = this.this$0;
        new com.stepos.ailauncher.agent.skill.detail.p0(agentMarketDetailActivity, agentMarketDetailActivity.D0(), string).show();
        return Y8.t.f7040a;
    }
}
