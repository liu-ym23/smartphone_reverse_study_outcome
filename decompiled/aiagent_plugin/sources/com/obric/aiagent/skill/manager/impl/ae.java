package com.obric.aiagent.skill.manager.impl;

import androidx.core.internal.view.SupportMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ae implements cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ac f19443a;

    public ae(ac r2) {
        d.h.b.o.e(r2, "manifestReader");
        this.f19443a = r2;
    }

    @Override // com.obric.aiagent.skill.manager.impl.cr
    public cq a(com.obric.aiagent.skill.manager.api.e r23, String r24) {
        d.h.b.o.e(r23, "skill");
        ab r15 = this.f19443a.a(r23.a());
        if (d.h.b.o.a(r15, ab.b.f19436a) == false) goto L6;
        return (cq) ZeusTransformUtils.preCheckCast(new cq.b(r23), cq.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r15, ab.c.class) == false) goto L10;
        return (cq) ZeusTransformUtils.preCheckCast(new cq.b(com.obric.aiagent.skill.manager.api.e.a(r23, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, this.f19443a.a(r23.a(), (ab.c) ZeusTransformUtils.preCheckCast(r15, ab.c.class, "com.obric.aiagent.plugin")), SupportMenu.USER_MASK, null)), cq.class, "com.obric.aiagent.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r15, ab.a.class) == false) goto L14;
        throw new IllegalArgumentException("Invalid Obric Skill manifest: " + ((ab.a) ZeusTransformUtils.preCheckCast(r15, ab.a.class, "com.obric.aiagent.plugin")).a(), ((ab.a) ZeusTransformUtils.preCheckCast(r15, ab.a.class, "com.obric.aiagent.plugin")).b());
    L14:
        throw new d.k();
    }
}
