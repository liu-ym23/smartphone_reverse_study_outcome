package com.stepos.ailauncher.agent.aispace.market.data;

import T4.SkillRequestBean;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\nJ0\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000bH§@¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0012H§@¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0016H§@¢\u0006\u0004\b\u0018\u0010\u0019J0\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u001aH§@¢\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@¢\u0006\u0004\b\u001f\u0010 ¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/a;", "", "", "authorization", "Lcom/stepos/ailauncher/agent/aispace/market/data/s;", "body", "Lyc/v;", "Lcom/stepos/ailauncher/agent/aispace/market/data/x;", "Lcom/stepos/ailauncher/agent/aispace/market/data/r;", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/s;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/u;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/u;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/i;", "Lcom/stepos/ailauncher/agent/aispace/market/data/h;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/i;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/k;", "Lcom/stepos/ailauncher/agent/aispace/market/data/j;", "e", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/k;Le9/c;)Ljava/lang/Object;", "LT4/a;", "Lcom/stepos/ailauncher/agent/aispace/market/data/t;", "f", "(Ljava/lang/String;LT4/a;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/o;", "Lcom/stepos/ailauncher/agent/aispace/market/data/n;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/o;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/A;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/A;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC2264a {
    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetUserInstalledAgents")
    Object a(@Ac.i("Authorization") String str, @Ac.a GetUserInstalledAgentsRequest getUserInstalledAgentsRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetOrSearchAgentListData>>> interfaceC4014c);

    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetAppList")
    Object b(@Ac.i("Authorization") String str, @Ac.a GetAppListRequest getAppListRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetAppListData>>> interfaceC4014c);

    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetOrSearchAgentList")
    Object c(@Ac.i("Authorization") String str, @Ac.a GetOrSearchAgentListRequest getOrSearchAgentListRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetOrSearchAgentListData>>> interfaceC4014c);

    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetAgentDetail")
    Object d(@Ac.i("Authorization") String str, @Ac.a GetAgentDetailRequest getAgentDetailRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetAgentDetailData>>> interfaceC4014c);

    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetAgentSkillDetails")
    Object e(@Ac.i("Authorization") String str, @Ac.a GetAgentSkillDetailRequest getAgentSkillDetailRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetAgentSkillDetailData>>> interfaceC4014c);

    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetSkillList")
    Object f(@Ac.i("Authorization") String str, @Ac.a SkillRequestBean skillRequestBean, InterfaceC4014c<? super yc.v<MarketEnvelope<GetOrSearchSkillListData>>> interfaceC4014c);

    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/SearchSkill")
    Object g(@Ac.i("Authorization") String str, @Ac.a SearchMarketSkillsRequest searchMarketSkillsRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetOrSearchSkillListData>>> interfaceC4014c);
}
