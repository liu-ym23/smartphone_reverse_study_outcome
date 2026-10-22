package com.obric.capability.schedulekit.b.a;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ECAJobV3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.obric.capabilitykit.common.execution.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f31888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JsonElement f31889b;

    public d(List<a> r3) {
        List<a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "actions");
        this.f31888a = r4;
    }

    @Override // com.obric.capabilitykit.common.execution.a.c
    public List<a> a() {
        return this.f31888a;
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public boolean h() {
        return com.obric.capabilitykit.common.execution.a.c.a.a(this);
    }

    @Override // com.obric.capabilitykit.common.execution.a.c
    public boolean update(com.obric.capabilitykit.common.execution.a.c r3) {
        return com.obric.capabilitykit.common.execution.a.c.a.update(this, (com.obric.capabilitykit.common.execution.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.common.execution.a.c.class, "com.obric.aiagent.plugin"));
    }

    public void a(JsonElement r1) {
        this.f31889b = r1;
    }

    public JsonElement b() {
        return this.f31889b;
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public void f() {
        d();
        Iterator<a> r3 = a().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin")).f();
        goto L4
    }

    public JsonElement c() {
        return d();
    }

    private final JsonElement d() {
        JsonElement r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin")).g());
        goto L7
    L9:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        JsonObject r5 = new JsonObject();
        r5.add("actions", com.obric.capabilitykit.common.a.a().toJsonTree(r4));
        a((JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"));
        return (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin");
    }
}
