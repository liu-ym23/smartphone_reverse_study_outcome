package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final <T> T a(u<? extends T> r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, u.b.class) == false) goto L5;
        u.b r5 = (u.b) ZeusTransformUtils.preCheckCast(r4, u.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return (T) r5.a();
    L5:
        r5 = null;
        goto L6
    }
}
