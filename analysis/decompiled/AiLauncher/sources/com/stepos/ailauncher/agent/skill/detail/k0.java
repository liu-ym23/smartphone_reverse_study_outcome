package com.stepos.ailauncher.agent.skill.detail;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/k0;", "", "", "authorization", "Lcom/stepos/ailauncher/agent/skill/detail/b;", "body", "Lcom/stepos/ailauncher/agent/skill/detail/l0;", "Lcom/stepos/ailauncher/agent/skill/detail/a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/detail/b;Le9/c;)Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface k0 {
    @Ac.o("skillhub/skillmarket/step.otter.skillhub.skillmarket/GetSkill")
    Object a(@Ac.i("Authorization") String str, @Ac.a GetSkillRequest getSkillRequest, InterfaceC4014c<? super SkillHubResponse<GetSkillData>> interfaceC4014c);
}
