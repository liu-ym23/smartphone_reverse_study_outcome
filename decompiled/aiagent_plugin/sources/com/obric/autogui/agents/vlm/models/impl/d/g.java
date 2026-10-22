package com.obric.autogui.agents.vlm.models.impl.d;

import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StdModelStepParserImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final Map<Integer, String> a(JsonElement r8, int r9) {
        if (r8 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        return null;
    L11:
        Set<Map.Entry<String, JsonElement>> r10 = r8.getAsJsonObject().entrySet();
        o.c(r10, "entrySet(...)");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L32;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r5);
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r7 = (JsonElement) ZeusTransformUtils.preCheckCast(r5.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        o.a(r6);
        Integer r13 = d.o.o.d(r6);
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
        if (r14 < 0) goto L20;
        if (r14 >= r9) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L28;
        if (r7.isJsonPrimitive() == false) goto L28;
        if (r7.getAsJsonPrimitive().isString() == false) goto L28;
        m r16 = s.a(Integer.valueOf(r14), r7.getAsString());
    L29:
        if (r16 == null) goto L13;
        r3.add(r16);
    L20:
        r15 = false;
    L28:
        r16 = null;
        goto L29
    L32:
        return ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L5:
        if (r8.isJsonObject() != true) goto L7;
        r2 = true;
        goto L9
    }
}
