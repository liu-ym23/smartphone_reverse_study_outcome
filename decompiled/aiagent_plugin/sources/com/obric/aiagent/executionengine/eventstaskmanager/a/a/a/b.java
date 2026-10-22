package com.obric.aiagent.executionengine.eventstaskmanager.a.a.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: KnowledgeRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("session_ids")
    private final List<String> f16637a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16637a, r6.f16637a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f16637a.hashCode();
    }

    public String toString() {
        return "KnowledgeRequest(sessionIds=" + this.f16637a + ')';
    }

    public b(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "sessionIds");
        this.f16637a = r4;
    }
}
