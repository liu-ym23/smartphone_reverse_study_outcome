package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fu {
    public static final com.obric.aiagent.skill.manager.api.aq.e a(JsonElement r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        r0 = false;
    L8:
        JsonObject r1 = null;
        if (r0 == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L15;
        r1 = r5.getAsJsonObject();
    L15:
        return new com.obric.aiagent.skill.manager.api.aq.e(a(r1, DbHelper.COL_ID), a(r1, "name"), d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(a(r1, "icon_url"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
    L5:
        if (r5.isJsonObject() != true) goto L7;
        goto L7
    }

    private static final String a(JsonObject r1, String r2) {
        if (r1 == null) goto L14;
        JsonElement r3 = r1.get(r2);
        if (r3 == null) goto L14;
        if (r3.isJsonPrimitive() == false) goto L14;
        if (r3.getAsJsonPrimitive().isString() == false) goto L14;
        String r4 = r3.getAsString();
        d.h.b.o.c(r4, "getAsString(...)");
        return r4;
    L14:
        return "";
    }

    public static final am a(com.obric.aiagent.skill.manager.api.e r2) {
        d.h.b.o.e(r2, "<this>");
        return new am(r2, az.e(r2));
    }
}
