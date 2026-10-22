package com.obric.capability.schedulekit.b.a;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ECAScriptV3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.capabilitykit.common.execution.a.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JsonElement f31891c;

    public e() {
        this.f31890b = 3;
    }

    public JsonElement a() {
        return this.f31891c;
    }

    public void a(JsonElement r1) {
        this.f31891c = r1;
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public void f() {
        JsonElement r0 = a();
        if (r0 != null) goto L6;
        r0 = (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r0, JsonObject.class) == false) goto L8;
        JsonObject r1 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.aiagent.plugin");
    L9:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L18;
        com.obric.capabilitykit.common.execution.a.c r5 = (com.obric.capabilitykit.common.execution.a.c) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.capabilitykit.common.execution.a.c.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, d.class) == false) goto L15;
        JsonElement r6 = ((d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin")).c();
    L16:
        if (r6 == null) goto L11;
        r4.add(r6);
        goto L11
    L15:
        r6 = null;
        goto L16
    L18:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L21;
        r1.add("jobs", com.obric.capabilitykit.common.a.a().toJsonTree(r7));
    L21:
        a((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r1 = null;
        goto L9
    }

    public JsonElement b() {
        return d();
    }

    private final JsonElement d() {
        f();
        JsonElement r0 = a();
        o.a(r0);
        return r0;
    }
}
