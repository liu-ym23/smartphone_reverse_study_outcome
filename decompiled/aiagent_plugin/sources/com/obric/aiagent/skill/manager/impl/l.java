package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<q> f20132a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20132a, r6.f20132a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f20132a.hashCode();
    }

    public String toString() {
        return "CliRefreshSummary(results=" + this.f20132a + ')';
    }

    public l(List<q> r3) {
        List<q> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "results");
        this.f20132a = r4;
    }

    public final List<q> a() {
        return this.f20132a;
    }
}
