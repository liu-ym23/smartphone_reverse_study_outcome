package com.stepos.ailauncher.agent.aispace.market;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2299u0 {
    public static final AgentMarketItem b(MarketAgentBrief marketAgentBrief) {
        return new AgentMarketItem(marketAgentBrief.getAssetId(), marketAgentBrief.getReversionId(), marketAgentBrief.getVersion(), marketAgentBrief.getName(), marketAgentBrief.getDescription(), marketAgentBrief.getDeveloper(), marketAgentBrief.getDownloadCount(), marketAgentBrief.getInstallVersion(), marketAgentBrief.getNeedUpdate(), marketAgentBrief.getInstalled() ? AgentMarketStatus.INSTALLED_ENABLED : AgentMarketStatus.NOT_INSTALLED, marketAgentBrief.getIconUrl(), marketAgentBrief.getTesting(), marketAgentBrief.getEnv());
    }
}
