package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\nJ0\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0013H§@¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0017H§@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/y;", "", "", "authorization", "Lcom/stepos/ailauncher/agent/aispace/market/data/w;", "body", "Lyc/v;", "Lcom/stepos/ailauncher/agent/aispace/market/data/x;", "Lcom/stepos/ailauncher/agent/aispace/market/data/v;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/w;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/q;", "Lcom/stepos/ailauncher/agent/aispace/market/data/p;", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/q;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/m;", "Lcom/stepos/ailauncher/agent/aispace/market/data/l;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/m;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/B;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/B;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/C;", "e", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/data/C;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface y {
    @Ac.o("step.agi.openclaw_migrate.OpenClawMigrate/SetAgentEnabled")
    Object a(@Ac.i("Authorization") String str, @Ac.a SetAgentEnabledRequest setAgentEnabledRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<Y8.t>>> interfaceC4014c);

    @Ac.o("step.agi.openclaw_migrate.OpenClawMigrate/GetAgentStatus")
    Object b(@Ac.i("Authorization") String str, @Ac.a GetAgentStatusRequest getAgentStatusRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetAgentStatusData>>> interfaceC4014c);

    @Ac.o("step.agi.openclaw_migrate.OpenClawMigrate/GetInstallProgress")
    Object c(@Ac.i("Authorization") String str, @Ac.a GetInstallProgressRequest getInstallProgressRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<GetInstallProgressData>>> interfaceC4014c);

    @Ac.o("step.agi.openclaw_migrate.OpenClawMigrate/InstallOrUpdateAgent")
    Object d(@Ac.i("Authorization") String str, @Ac.a InstallOrUpdateAgentRequest installOrUpdateAgentRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<InstallOrUpdateAgentData>>> interfaceC4014c);

    @Ac.o("step.agi.openclaw_migrate.OpenClawMigrate/UninstallAgent")
    Object e(@Ac.i("Authorization") String str, @Ac.a UninstallAgentRequest uninstallAgentRequest, InterfaceC4014c<? super yc.v<MarketEnvelope<InstallOrUpdateAgentData>>> interfaceC4014c);
}
