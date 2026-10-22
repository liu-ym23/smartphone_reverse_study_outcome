package com.obric.aiagent.skill.ovirt.impl.c;

import com.obric.aiagent.skill.virt.api.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FileCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final /* synthetic */ boolean a(z r2) {
        return b((z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.aiagent.plugin"));
    }

    private static final boolean b(z r2) {
        z r3 = (z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, z.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.aiagent.plugin")).b() != 0) goto L7;
        return true;
    }
}
