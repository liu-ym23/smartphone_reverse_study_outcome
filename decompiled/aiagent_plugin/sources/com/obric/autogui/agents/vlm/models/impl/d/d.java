package com.obric.autogui.agents.vlm.models.impl.d;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MultiActionsStepParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final JsonObject a(JsonObject r4, JsonObject r5) {
        o.e(r4, "rootParams");
        o.e(r5, "action");
        JsonObject r6 = r4.deepCopy();
        Set<Map.Entry<String, JsonElement>> r7 = r5.entrySet();
        o.c(r7, "entrySet(...)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r0);
        r6.add((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        o.c(r6, "apply(...)");
        return r6;
    }
}
