package com.obric.eventkit;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TaskKnowledgeApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f33205c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33203a, r6.f33203a) == true) goto L12;
        return false;
    L12:
        if (this.f33204b == r6.f33204b) goto L15;
        return false;
    L15:
        if (o.a(this.f33205c, r6.f33205c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f33203a.hashCode() * 31) + Integer.hashCode(this.f33204b)) * 31) + this.f33205c.hashCode();
    }

    public String toString() {
        return "TaskKnowledgeItem(sessionId=" + this.f33203a + ", knowledgeStatus=" + this.f33204b + ", knowledges=" + this.f33205c + ')';
    }

    public a(String r3, int r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r6, "knowledges");
        this.f33203a = r3;
        this.f33204b = r4;
        this.f33205c = r6;
    }

    public final int a() {
        return this.f33204b;
    }

    public final List<String> b() {
        return this.f33205c;
    }
}
