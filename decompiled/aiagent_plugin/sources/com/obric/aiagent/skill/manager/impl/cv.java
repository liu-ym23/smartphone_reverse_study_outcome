package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillLocalIdentityPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cv {
    public static final String a(da r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (r1.a().length() <= r2) goto L5;
    L8:
        bv.a((bt) ZeusTransformUtils.preCheckCast(bt.p.f19608a, bt.class, "com.obric.aiagent.plugin"), null, 2, null);
        throw new d.d();
    L5:
        if (cu.f19706a.a(r1.a()) == false) goto L8;
        return r1.a();
    }
}
