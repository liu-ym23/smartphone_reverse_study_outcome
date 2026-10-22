package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: DataFeedbackUploadFeedbackTaskStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f28193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, n> f28194b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28193a, r6.f28193a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28194b, r6.f28194b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f28193a.hashCode() * 31) + this.f28194b.hashCode();
    }

    public String toString() {
        return "FeedbackTaskSnapshot(pendingTaskIds=" + this.f28193a + ", versionedTasks=" + this.f28194b + ')';
    }

    public m(Set<String> r3, Map<String, n> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Map<String, n> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r5, "pendingTaskIds");
        o.e(r6, "versionedTasks");
        this.f28193a = r5;
        this.f28194b = r6;
    }

    public final Set<String> a() {
        return this.f28193a;
    }

    public final Map<String, n> b() {
        return this.f28194b;
    }
}
