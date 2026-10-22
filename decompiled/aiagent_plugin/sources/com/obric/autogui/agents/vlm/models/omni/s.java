package com.obric.autogui.agents.vlm.models.omni;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: OmniSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static final /* synthetic */ Integer a(int r0, boolean r1) {
        return b(r0, r1);
    }

    private static final Integer b(int r3, boolean r4) {
        if (r4 == true) goto L5;
        return null;
    L5:
        boolean r5 = true;
        if (r3 == 1) goto L15;
        switch(r3) {
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L15;
            case 8: goto L15;
            default: goto L8;
        };
    L8:
        switch(r3) {
            case 100001: goto L15;
            case 100002: goto L15;
            case 100003: goto L15;
            default: goto L9;
        };
    L9:
        switch(r3) {
            case 101001: goto L15;
            case 101002: goto L15;
            default: goto L10;
        };
    L10:
        switch(r3) {
            case 103001: goto L15;
            case 103002: goto L15;
            case 103003: goto L15;
            case 103004: goto L15;
            default: goto L11;
        };
    L11:
        switch(r3) {
            case 104001: goto L15;
            case 104002: goto L15;
            case 104003: goto L15;
            case 104004: goto L15;
            case 104005: goto L15;
            default: goto L12;
        };
    L12:
        switch(r3) {
            case 107001: goto L15;
            case 107002: goto L15;
            default: goto L13;
        };
    L13:
        switch(r3) {
            case 200000: goto L15;
            case 200001: goto L15;
            default: goto L14;
        };
    L14:
        r5 = false;
    L15:
        Integer r6 = Integer.valueOf(r3);
        ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r5 == true) goto L18;
        return null;
    L18:
        return r6;
    }

    public static final String a(com.obric.autogui.agents.vlm.models.omni.intent.j r4, JsonObject r5) {
        d.h.b.o.e(r5, "stepJson");
        JsonElement r6 = r5.get("action_list");
        if (r6 != null) goto L5;
    L10:
        JsonArray r7 = null;
    L11:
        if (r7 == null) goto L28;
        JsonArray r8 = new JsonArray();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L27;
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r1.isJsonObject() == true) goto L19;
        r1 = null;
    L19:
        if (r1 == null) goto L23;
        JsonObject r2 = r1.getAsJsonObject();
        if (r2 == null) goto L23;
        JsonElement r3 = r2.get("action_args");
    L24:
        if (r3 != null) goto L26;
        r3 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin");
    L26:
        r8.add(r3);
    L23:
        r3 = null;
        goto L24
    L27:
        String r10 = r8.toString();
    L33:
        if (r10 != null) goto L35;
        return null;
    L35:
        return a(r10);
    L28:
        if (r4 == null) goto L32;
        JsonArray r11 = r4.b();
        if (r11 == null) goto L32;
        r10 = r11.toString();
    L32:
        r10 = null;
        goto L33
    L5:
        if (r6.isJsonArray() == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L10;
        r7 = r6.getAsJsonArray();
        goto L11
    }

    private static final String a(String r2) {
        if (r2.length() > 1024) goto L6;
        return r2;
    L6:
        return d.o.o.e(r2, 1010) + "...[TRUNCATED]";
    }
}
