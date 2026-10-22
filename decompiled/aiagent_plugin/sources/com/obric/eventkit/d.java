package com.obric.eventkit;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TaskKnowledgeApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f33208a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33208a, r6.f33208a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f33208a.hashCode();
    }

    public String toString() {
        return "TaskKnowledgeResponseData(knowledges=" + this.f33208a + ')';
    }

    public d(List<a> r3) {
        List<a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "knowledges");
        this.f33208a = r4;
    }

    public final List<a> a() {
        return this.f33208a;
    }
}
