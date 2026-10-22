package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1056g;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity;
import com.stepos.ailauncher.agent.skill.detail.y0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$showSkillMd$1", f = "AgentMarketDetailFragment.kt", l = {624}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailFragment$showSkillMd$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSkillDto $skill;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ AgentMarketDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailFragment$showSkillMd$1(AgentSkillDto agentSkillDto, AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super AgentMarketDetailFragment$showSkillMd$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$skill = agentSkillDto;
        this.this$0 = agentMarketDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailFragment$showSkillMd$1(this.$skill, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailFragment$showSkillMd$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            String skillId = this.$skill.getSkillId();
            int iY0 = this.this$0.Y0();
            Ua.I iB = Ua.Y.b();
            AgentMarketDetailFragment$showSkillMd$1$fetched$1 agentMarketDetailFragment$showSkillMd$1$fetched$1 = new AgentMarketDetailFragment$showSkillMd$1$fetched$1(this.$skill, skillId, iY0, this.this$0, null);
            this.L$0 = skillId;
            this.I$0 = iY0;
            this.label = 1;
            obj = C1056g.j(iB, agentMarketDetailFragment$showSkillMd$1$fetched$1, this);
            if (obj == objG) {
                return objG;
            }
            str = skillId;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            C4849c.b(obj);
        }
        Triple triple = (Triple) obj;
        if (triple == null) {
            this.this$0.B1("加载失败，请稍后重试");
            return Y8.t.f7040a;
        }
        String str2 = (String) triple.a();
        String str3 = (String) triple.b();
        String string = (String) triple.c();
        SkillDetailActivity.Companion companion = SkillDetailActivity.INSTANCE;
        if (str2 == null) {
            str2 = "";
        }
        String string2 = La.H.D1(companion.c(str2)).toString();
        if (La.H.x0(string2)) {
            if (str3 == null) {
                str3 = "";
            }
            string2 = La.H.x0(str3) ? "—" : str3;
        }
        AgentMarketDetailFragment agentMarketDetailFragment = this.this$0;
        y0.Companion companion2 = com.stepos.ailauncher.agent.skill.detail.y0.INSTANCE;
        if (string == null) {
            string = agentMarketDetailFragment.getString(R$string.skill_detail_section_readme);
            kotlin.jvm.internal.p.h(string, "getString(...)");
        }
        com.stepos.ailauncher.sheet.nav.a.z(agentMarketDetailFragment, companion2.a(string2, string), "agent_skill_readme_" + str, null, null, null, 28, null);
        return Y8.t.f7040a;
    }
}
