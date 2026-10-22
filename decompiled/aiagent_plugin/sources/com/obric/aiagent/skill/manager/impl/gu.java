package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gu {
    public static final com.obric.aiagent.skill.manager.api.e a(com.obric.aiagent.skill.manager.api.e r21, com.obric.aiagent.skill.manager.api.e r22) {
        d.h.b.o.e(r21, "<this>");
        d.h.b.o.e(r22, "remote");
        if (d.h.b.o.a(r21.a(), r22.a()) == true) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r21.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r22.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L10;
        return null;
    L10:
        return com.obric.aiagent.skill.manager.api.e.a(r21, null, r22.b(), null, r22.d(), r22.e(), r22.f(), r22.g(), null, null, 0, null, false, false, null, null, null, null, 130949, null);
    }
}
