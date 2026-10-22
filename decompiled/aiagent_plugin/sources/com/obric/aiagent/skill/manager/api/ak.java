package com.obric.aiagent.skill.manager.api;

import com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SkillSecurityDecisionAction f19192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f19193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19194c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ak.class) == true) goto L8;
        return false;
    L8:
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(r5, ak.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19192a, r6.f19192a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19193b, r6.f19193b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19194c, r6.f19194c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19192a.hashCode() * 31;
        Integer r1 = this.f19193b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f19194c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillSecurityResult(decisionAction=" + this.f19192a + ", riskScore=" + this.f19193b + ", riskResult=" + this.f19194c + ')';
    }

    public ak(SkillSecurityDecisionAction r3, Integer r4, String r5) {
        SkillSecurityDecisionAction r6 = (SkillSecurityDecisionAction) ZeusTransformUtils.wrapperContextForParams(r3, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "decisionAction");
        this.f19192a = r6;
        this.f19193b = r4;
        this.f19194c = r5;
    }

    public /* synthetic */ ak(SkillSecurityDecisionAction r2, Integer r3, String r4, int r5, d.h.b.h r6) {
        SkillSecurityDecisionAction r7 = (SkillSecurityDecisionAction) ZeusTransformUtils.wrapperContextForParams(r2, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r7, r3, r4);
    }

    public final SkillSecurityDecisionAction a() {
        return this.f19192a;
    }
}
