package com.obric.aiagent.skill.manager.impl;

import com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: GuiLinkInstallAttribution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillInstallAttributionServiceImpl implements ISkillInstallAttributionService {
    public SkillInstallAttributionServiceImpl() {
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService
    public boolean consumeGuiLinkImport(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "rootMessageIds");
        return u.f20167a.a(r1);
    }
}
