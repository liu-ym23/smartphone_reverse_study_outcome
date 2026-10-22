package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<an> f19209a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ao.class) == true) goto L8;
        return false;
    L8:
        ao r6 = (ao) ZeusTransformUtils.preCheckCast(r5, ao.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19209a, r6.f19209a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f19209a.hashCode();
    }

    public String toString() {
        return "SkillSignatureRefreshSummary(results=" + this.f19209a + ')';
    }

    public ao(List<an> r3) {
        List<an> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "results");
        this.f19209a = r4;
    }

    public final List<an> a() {
        return this.f19209a;
    }
}
