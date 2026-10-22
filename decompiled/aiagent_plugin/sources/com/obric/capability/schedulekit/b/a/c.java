package com.obric.capability.schedulekit.b.a;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ECAInputParamWrapperV3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.capabilitykit.common.execution.a.b implements com.obric.capabilitykit.common.execution.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.capabilitykit.common.execution.a.b f31885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f31886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JsonElement f31887c;

    public c(com.obric.capabilitykit.common.execution.a.b r2) {
        o.e(r2, "original");
        this.f31885a = r2;
    }

    public JsonElement a() {
        return this.f31887c;
    }

    public void a(JsonElement r1) {
        this.f31887c = r1;
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public void f() {
        com.obric.capabilitykit.common.execution.a.b r0 = this.f31885a;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.capabilitykit.common.execution.a.a.b.class) == false) goto L6;
        JsonElement r1 = a((com.obric.capabilitykit.common.execution.a.a.b) ZeusTransformUtils.preCheckCast(this.f31885a, com.obric.capabilitykit.common.execution.a.a.b.class, "com.obric.aiagent.plugin"));
    L12:
        a(r1);
        this.f31886b = true;
        com.obric.capabilitykit.common.execution.a.a r2 = c();
        if (r2 == null) goto L15;
        r2.f();
    L15:
        this.f31886b = false;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.capabilitykit.common.execution.a.a.c.class) == false) goto L9;
        r1 = ((com.obric.capabilitykit.common.execution.a.a.c) ZeusTransformUtils.preCheckCast(this.f31885a, com.obric.capabilitykit.common.execution.a.a.c.class, "com.obric.aiagent.plugin")).a();
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.capabilitykit.common.execution.a.a.a.class) == false) goto L11;
        r1 = a((com.obric.capabilitykit.common.execution.a.a.a) ZeusTransformUtils.preCheckCast(this.f31885a, com.obric.capabilitykit.common.execution.a.a.a.class, "com.obric.aiagent.plugin"));
        goto L12
    L11:
        r1 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin");
        goto L12
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public boolean h() {
        return this.f31886b;
    }

    private final JsonElement a(com.obric.capabilitykit.common.execution.a.a.b r3) {
        Object r2 = r3.a();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L6;
        Object r4 = r3.a();
        o.a(r4, "null cannot be cast to non-null type kotlin.String");
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L9;
        Object r5 = r3.a();
        o.a(r5, "null cannot be cast to non-null type kotlin.Number");
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L12;
        Object r6 = r3.a();
        o.a(r6, "null cannot be cast to non-null type kotlin.Boolean");
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L12:
        return (JsonElement) ZeusTransformUtils.preCheckCast(null, JsonElement.class, "com.obric.aiagent.plugin");
    }

    private final JsonElement a(com.obric.capabilitykit.common.execution.a.a.a r6) {
        String r5 = ".outputParams." + r6.d();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        String r7 = "$id_" + r6.a() + r5;
    L19:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r7), JsonElement.class, "com.obric.aiagent.plugin");
    L11:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L20;
        r7 = '$' + r6.b() + r5;
        goto L19
    L20:
        return null;
    L14:
        if (d.o.o.d(r3) == false) goto L16;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    public JsonElement b() {
        return d();
    }

    private final JsonElement d() {
        JsonElement r0 = a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        f();
        JsonElement r1 = a();
        o.a(r1);
        return r1;
    }
}
