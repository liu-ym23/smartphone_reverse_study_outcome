package com.obric.aiagent.skill.virt.impl.c;

import com.obric.aiagent.skill.virt.api.n;
import com.obric.aiagent.skill.virt.api.p;
import com.obric.aiagent.skill.virt.api.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.k;

/* JADX INFO: compiled from: VirtShell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final /* synthetic */ n a(a.f r0) {
        return b(r0);
    }

    public static final /* synthetic */ p a(a.d r0) {
        return b(r0);
    }

    public static final /* synthetic */ z a(com.obric.aiagent.skill.virt.impl.a.c r2) {
        return b((com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin"));
    }

    private static final n b(a.f r2) {
        return new n(b(r2.a()), r2.b());
    }

    private static final p b(a.d r15) {
        return new p(r15.a(), r15.b(), r15.c(), r15.d(), r15.e(), r15.f(), r15.g(), r15.h(), r15.i(), r15.j(), r15.k());
    }

    private static final z b(com.obric.aiagent.skill.virt.impl.a.c r5) {
        com.obric.aiagent.skill.virt.impl.a.c r6 = (com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.virt.impl.a.c.a.class) == false) goto L6;
        return (z) ZeusTransformUtils.preCheckCast(new z.a(((com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin")).c(), ((com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin")).a(), ((com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin")).b()), z.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.virt.impl.a.c.b.class) == false) goto L10;
        return (z) ZeusTransformUtils.preCheckCast(new z.b(((com.obric.aiagent.skill.virt.impl.a.c.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.virt.impl.a.c.b.class, "com.obric.aiagent.plugin")).a(), ((com.obric.aiagent.skill.virt.impl.a.c.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.virt.impl.a.c.b.class, "com.obric.aiagent.plugin")).b()), z.class, "com.obric.aiagent.plugin");
    L10:
        throw new k();
    }
}
