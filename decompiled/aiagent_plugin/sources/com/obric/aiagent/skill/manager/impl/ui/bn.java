package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPageAvailabilityChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f20657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ISkillManagerService f20658b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bn.class) == true) goto L8;
        return false;
    L8:
        bn r6 = (bn) ZeusTransformUtils.preCheckCast(r5, bn.class, "com.obric.aiagent.plugin");
        if (this.f20657a == r6.f20657a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20658b, r6.f20658b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f20657a) * 31;
        ISkillManagerService r1 = this.f20658b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillPageAvailabilityResult(isAvailable=" + this.f20657a + ", skillManager=" + this.f20658b + ')';
    }

    public bn(boolean r3, ISkillManagerService r4) {
        ISkillManagerService r5 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
        this.f20657a = r3;
        this.f20658b = r5;
    }

    public final boolean a() {
        return this.f20657a;
    }

    public final ISkillManagerService b() {
        return this.f20658b;
    }
}
