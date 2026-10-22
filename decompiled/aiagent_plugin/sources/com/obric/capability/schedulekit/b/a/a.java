package com.obric.capability.schedulekit.b.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ECAAppIntentV3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.capabilitykit.common.execution.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.obric.capabilitykit.common.execution.a.b> f31876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f31877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JsonElement f31880e;

    public a() {
        this.f31878c = "";
        this.f31879d = "";
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public boolean h() {
        return com.obric.capabilitykit.common.execution.a.a.C0877a.a(this);
    }

    @Override // com.obric.capabilitykit.common.execution.a.a
    public String a() {
        return this.f31878c;
    }

    public void a(String r2) {
        o.e(r2, "<set-?>");
        this.f31878c = r2;
    }

    public String b() {
        return this.f31879d;
    }

    public void b(String r2) {
        o.e(r2, "<set-?>");
        this.f31879d = r2;
    }

    public void a(Map<String, com.obric.capabilitykit.common.execution.a.b> r3) {
        Map<String, com.obric.capabilitykit.common.execution.a.b> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f31876a = r4;
    }

    @Override // com.obric.capabilitykit.common.execution.a.a
    public Map<String, com.obric.capabilitykit.common.execution.a.b> c() {
        Map<String, com.obric.capabilitykit.common.execution.a.b> r0 = this.f31876a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("inputParams");
        return null;
    }

    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f31877b = r4;
    }

    public List<String> d() {
        List<String> r0 = this.f31877b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("impls");
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.a.a
    public void a(com.obric.capabilitykit.common.execution.a.a r3) {
        com.obric.capabilitykit.common.execution.a.a r4 = (com.obric.capabilitykit.common.execution.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.common.execution.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "withAnother");
        com.obric.capabilitykit.common.execution.a.a.C0877a.a(this, r4);
        a(true);
    }

    public void a(JsonElement r1) {
        this.f31880e = r1;
    }

    public JsonElement e() {
        return this.f31880e;
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public void f() {
        a(false);
    }

    private final void a(boolean r11) {
        JsonElement r0 = e();
        if (r0 != null) goto L5;
        r0 = (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.aiagent.plugin");
    L5:
        JsonObject r1 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.aiagent.plugin");
        r1.addProperty("actionName", a());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(b(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        r1.addProperty(DbHelper.COL_ID, b());
    L8:
        JsonElement r3 = r1.get("inputParams");
        JsonObject r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, JsonObject.class) == false) goto L11;
        JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.aiagent.plugin");
    L12:
        if (r4 != null) goto L14;
        r4 = new JsonObject();
    L14:
        Iterator<Map.Entry<String, com.obric.capabilitykit.common.execution.a.b>> r6 = c().entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        com.obric.capabilitykit.common.execution.a.b r8 = (com.obric.capabilitykit.common.execution.a.b) ZeusTransformUtils.preCheckCast(r7.getValue(), com.obric.capabilitykit.common.execution.a.b.class, "com.obric.aiagent.plugin");
        if (r11 == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.capabilitykit.common.execution.a.d.class) == false) goto L24;
        if (((com.obric.capabilitykit.common.execution.a.d) ZeusTransformUtils.preCheckCast(r8, com.obric.capabilitykit.common.execution.a.d.class, "com.obric.aiagent.plugin")).h() == false) goto L16;
    L24:
        JsonElement r9 = a(r8);
        JsonObject r10 = new JsonObject();
        r10.add("value", r9);
        r4.add((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L16
    L25:
        r1.add("inputParams", (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        JsonElement r2 = r1.get("outputParams");
        if (ZeusTransformUtils.instanceOf(r2, JsonObject.class) == false) goto L28;
        r5 = (JsonObject) ZeusTransformUtils.preCheckCast(r2, JsonObject.class, "com.obric.aiagent.plugin");
    L28:
        if (r5 != null) goto L30;
        r5 = new JsonObject();
    L30:
        r1.add("outputParams", (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"));
        JsonArray r12 = new JsonArray();
        Iterator<String> r13 = d().iterator();
    L32:
        if (r13.hasNext() == false) goto L34;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        JsonObject r15 = new JsonObject();
        r15.addProperty("pkgName", r14);
        r12.add((JsonElement) ZeusTransformUtils.preCheckCast(r15, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L32
    L34:
        r1.add("impls", (JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.aiagent.plugin"));
        a((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        r4 = null;
        goto L12
    }

    public JsonElement g() {
        return i();
    }

    private final JsonElement i() {
        JsonElement r0 = e();
        if (r0 == null) goto L5;
        return r0;
    L5:
        f();
        JsonElement r1 = e();
        o.a(r1);
        return r1;
    }

    private final JsonElement a(com.obric.capabilitykit.common.execution.a.b r2) {
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L6;
        return ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).b();
    L6:
        return (JsonElement) ZeusTransformUtils.preCheckCast(null, JsonElement.class, "com.obric.aiagent.plugin");
    }
}
