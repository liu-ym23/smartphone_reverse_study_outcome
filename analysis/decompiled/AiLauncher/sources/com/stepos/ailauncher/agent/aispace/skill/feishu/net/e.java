package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/e;", "", "", "authorization", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/n;", "body", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/o;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/n;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface e {
    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetCli")
    Object a(@Ac.i("Authorization") String str, @Ac.a GetCliRequest getCliRequest, InterfaceC4014c<? super GetCliResponse> interfaceC4014c);
}
