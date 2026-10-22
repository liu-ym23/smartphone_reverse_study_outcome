package com.obric.aiagent.skill.ovirt.impl.f;

import com.obric.aiagent.skill.virt.api.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillProjector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final /* synthetic */ boolean a(z r2) {
        return c((z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Integer b(z r2) {
        return d((z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.aiagent.plugin"));
    }

    private static final boolean c(z r2) {
        z r3 = (z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, z.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.aiagent.plugin")).b() != 0) goto L7;
        return true;
    }

    private static final Integer d(z r3) {
        z r4 = (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, z.a.class) == false) goto L5;
        z.a r5 = (z.a) ZeusTransformUtils.preCheckCast(r4, z.a.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(r5.b());
    L5:
        r5 = null;
        goto L6
    }
}
