package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Float> f17163a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, t.class) == true) goto L8;
        return false;
    L8:
        t r6 = (t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f17163a, r6.f17163a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f17163a.hashCode();
    }

    public String toString() {
        return "NormalizedMetrics(values=" + this.f17163a + ')';
    }

    public t(Map<String, Float> r3) {
        Map<String, Float> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "values");
        this.f17163a = r4;
    }

    public final Map<String, Float> a() {
        return this.f17163a;
    }
}
