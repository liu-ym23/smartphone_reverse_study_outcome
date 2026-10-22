package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: OmniEventStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<Object>> f15629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<e> f15630b;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public f(ConcurrentHashMap<String, List<Object>> r3, List<e> r4) {
        List<e> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "params");
        d.h.b.o.e(r5, "timeline");
        this.f15629a = r3;
        this.f15630b = r5;
    }

    public /* synthetic */ f(ConcurrentHashMap r2, List r3, int r4, d.h.b.h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new ConcurrentHashMap();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.aiagent.plugin");
    L8:
        this(r2, r6);
    }

    public final ConcurrentHashMap<String, List<Object>> a() {
        return this.f15629a;
    }

    public final List<e> b() {
        return this.f15630b;
    }
}
