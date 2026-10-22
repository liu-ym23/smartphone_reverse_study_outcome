package com.stepos.ailauncher.agent.aispace.market;

import com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Triple;", "", "<anonymous>", "(LUa/M;)Lkotlin/Triple;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$showSkillMd$1$fetched$1", f = "AgentMarketDetailActivity.kt", l = {590, 596}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$showSkillMd$1$fetched$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Triple<? extends String, ? extends String, ? extends String>>, Object> {
    final /* synthetic */ AgentSkillDto $skill;
    final /* synthetic */ String $skillId;
    final /* synthetic */ int $testing;
    int label;
    final /* synthetic */ AgentMarketDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$showSkillMd$1$fetched$1(AgentSkillDto agentSkillDto, String str, int i10, AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$showSkillMd$1$fetched$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$skill = agentSkillDto;
        this.$skillId = str;
        this.$testing = i10;
        this.this$0 = agentMarketDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$showSkillMd$1$fetched$1(this.$skill, this.$skillId, this.$testing, this.this$0, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Triple<String, String, String>> interfaceC4014c) {
        return ((AgentMarketDetailActivity$showSkillMd$1$fetched$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        if (r7 == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            kotlin.C4849c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r7 = r8.getValue()
            goto L87
        L19:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L21:
            kotlin.C4849c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.getValue()
            goto L5b
        L2b:
            kotlin.C4849c.b(r8)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r8 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            com.stepos.ailauncher.agent.aispace.market.data.f r1 = r7.$skill
            java.lang.String r1 = r1.getAgentId()
            com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity r5 = r7.this$0
            boolean r6 = La.H.x0(r1)
            if (r6 == 0) goto L4e
            com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r1 = com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity.X(r5)
            if (r1 != 0) goto L4a
            java.lang.String r1 = "item"
            kotlin.jvm.internal.p.A(r1)
            r1 = r4
        L4a:
            java.lang.String r1 = r1.getAssetId()
        L4e:
            java.lang.String r5 = r7.$skillId
            int r6 = r7.$testing
            r7.label = r3
            java.lang.Object r8 = r8.o(r1, r5, r6, r7)
            if (r8 != r0) goto L5b
            goto L86
        L5b:
            boolean r1 = kotlin.Result.g(r8)
            if (r1 == 0) goto L62
            r8 = r4
        L62:
            com.stepos.ailauncher.agent.aispace.market.data.f r8 = (com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto) r8
            if (r8 == 0) goto L78
            kotlin.Triple r7 = new kotlin.Triple
            java.lang.String r0 = r8.getSkillMd()
            java.lang.String r1 = r8.getSkillDescription()
            java.lang.String r8 = r8.getSkillName()
            r7.<init>(r0, r1, r8)
            return r7
        L78:
            com.stepos.ailauncher.agent.skill.detail.SkillDetailRepository r8 = com.stepos.ailauncher.agent.skill.detail.SkillDetailRepository.INSTANCE
            java.lang.String r1 = r7.$skillId
            int r3 = r7.$testing
            r7.label = r2
            java.lang.Object r7 = r8.d(r1, r3, r7)
            if (r7 != r0) goto L87
        L86:
            return r0
        L87:
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto L8e
            r7 = r4
        L8e:
            com.stepos.ailauncher.agent.skill.detail.F r7 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailDto) r7
            if (r7 == 0) goto Laa
            kotlin.Triple r8 = new kotlin.Triple
            java.lang.String r0 = r7.getSkillMd()
            java.lang.String r1 = r7.getDescription()
            java.lang.String r2 = r7.getDisplayName()
            if (r2 != 0) goto La6
            java.lang.String r2 = r7.getName()
        La6:
            r8.<init>(r0, r1, r2)
            return r8
        Laa:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$showSkillMd$1$fetched$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Triple<? extends String, ? extends String, ? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Triple<String, String, String>>) interfaceC4014c);
    }
}
