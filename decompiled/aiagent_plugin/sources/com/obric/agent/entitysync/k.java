package com.obric.agent.entitysync;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AppEntityUpdateExtCodec.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f14533a = null;

    static {
        f14533a = new k();
    }

    private k() {
    }

    public final String a(Map<String, j> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "updates");
        if (r6.isEmpty() == false) goto L6;
        return null;
    L6:
        JsonObject r8 = new JsonObject();
        Iterator r9 = r6.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        j r3 = (j) ZeusTransformUtils.preCheckCast(r1.getValue(), j.class, "com.obric.aiagent.plugin");
        JsonObject r4 = new JsonObject();
        r4.add("entity_info", (JsonElement) ZeusTransformUtils.preCheckCast(r3.a().deepCopy(), JsonElement.class, "com.obric.aiagent.plugin"));
        r4.addProperty("update_type", r3.b());
        x r5 = x.f38692a;
        r8.add(r2, (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L8
    L11:
        return r8.toString();
    }
}
