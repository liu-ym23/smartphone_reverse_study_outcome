package com.obric.agent.entitysync;

import com.google.gson.JsonElement;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f14546a = null;

    static {
        f14546a = new n();
    }

    private n() {
    }

    public final String a(i r8, AppEntity r9, boolean r10, d.h.a.m<? super String, ? super AppEntity, String> r11) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.m.class, "com.obric.aiagent.plugin");
        o.e(r8, "tracked");
        o.e(r9, "observed");
        o.e(r7, "allocateReplacement");
        boolean r3 = true;
        String r4 = null;
        if (r8.a().getType() != 501) goto L16;
        JsonElement r12 = r8.c().get("extraData");
        if (r12 != null) goto L7;
    L12:
        String r13 = null;
    L14:
        if (o.a(r13, "fictitious") == false) goto L16;
        boolean r14 = true;
    L18:
        if (r9.getType() == 501) goto L20;
    L22:
        boolean r1 = false;
    L23:
        if (r10 == false) goto L28;
        if (r14 == false) goto L28;
        if (r1 == false) goto L28;
        return (String) ZeusTransformUtils.preCheckCast(r7.invoke(r8.b(), r9), String.class, "com.obric.aiagent.plugin");
    L28:
        String r15 = r9.getEcaId();
        if (r15 == null) goto L31;
        r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L31:
        if (r4 != null) goto L33;
        r4 = "";
    L33:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r16.length() == 0) goto L37;
        r3 = false;
    L37:
        if (r3 == false) goto L40;
        r16 = r8.b();
    L40:
        return (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
    L20:
        if (o.a(r9.getExtraData(), "fictitious") == true) goto L22;
        r1 = true;
        goto L23
    L7:
        if (r12.isJsonPrimitive() == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L12;
        r13 = r12.getAsString();
    L16:
        r14 = false;
        goto L18
    }
}
