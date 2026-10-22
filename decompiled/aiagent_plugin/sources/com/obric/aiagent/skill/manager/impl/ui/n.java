package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.impl.y f20803a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20803a, r6.f20803a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        com.obric.aiagent.skill.manager.impl.y r0 = this.f20803a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "PendingSkillCoverPromotion(previous=" + this.f20803a + ')';
    }

    public n(com.obric.aiagent.skill.manager.impl.y r1) {
        this.f20803a = r1;
    }

    public final com.obric.aiagent.skill.manager.impl.y a() {
        return this.f20803a;
    }
}
