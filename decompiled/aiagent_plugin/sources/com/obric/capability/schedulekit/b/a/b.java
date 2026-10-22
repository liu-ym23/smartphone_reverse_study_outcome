package com.obric.capability.schedulekit.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ECABuilderV3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d> f31881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f31882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<a> f31883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f31884d;

    public b() {
        this.f31881a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final b a() {
        d r0 = this.f31882b;
        if (r0 == null) goto L5;
        r0.f();
        this.f31881a.add(r0);
    L5:
        List<a> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f31883c = r1;
        d r2 = new d(r1);
        this.f31882b = r2;
        this.f31881a.add(r2);
        return this;
    }

    public static /* synthetic */ b a(b r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.a(r1, r2);
    }

    public final b a(String r4, String r5) {
        o.e(r4, "name");
        o.e(r5, "ecaId");
        List<a> r0 = this.f31883c;
        if (r0 == null) goto L7;
        a r1 = new a();
        r1.a(r4);
        r1.b(r5);
        r1.a((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin"));
        r1.a((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
        r0.add(r1);
        this.f31884d = r1;
        return this;
    L7:
        throw new IllegalStateException("no current job; use newJob() first.");
    }

    public final b a(String r3, com.obric.capabilitykit.common.execution.a.b r4) {
        o.e(r3, "paramName");
        o.e(r4, "paramValue");
        a r0 = this.f31884d;
        if (r0 == null) goto L5;
        c r1 = new c(r4);
        r0.c().put(r3, r1);
        r1.a((com.obric.capabilitykit.common.execution.a.a) ZeusTransformUtils.preCheckCast(r0, com.obric.capabilitykit.common.execution.a.a.class, "com.obric.aiagent.plugin"));
        r1.f();
    L5:
        return this;
    }

    public final b a(String r2) {
        o.e(r2, "packageName");
        a r0 = this.f31884d;
        if (r0 == null) goto L5;
        r0.d().add(r2);
    L5:
        return this;
    }

    public final e b() {
        e r0 = new e();
        r0.a(this.f31881a);
        return r0;
    }
}
