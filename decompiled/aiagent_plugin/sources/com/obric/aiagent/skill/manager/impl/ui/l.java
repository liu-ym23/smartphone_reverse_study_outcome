package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<j> f20796a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20796a, r6.f20796a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f20796a.hashCode();
    }

    public String toString() {
        return "InstalledSkillListPayload(fields=" + this.f20796a + ')';
    }

    public l(Set<? extends j> r3) {
        Set<j> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "fields");
        this.f20796a = r4;
    }

    public final Set<j> a() {
        return this.f20796a;
    }
}
