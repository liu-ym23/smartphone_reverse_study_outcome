package com.obric.autogui.agents.vlm.models.impl.e.a;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.obric.autogui.agents.scripted.a.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: OperationPlanner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements d {
    public e() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.a.d
    public List<com.obric.autogui.operator.e.C0780e> a(l r5, com.obric.autogui.agents.vlm.models.impl.e.b.d r6) {
        com.obric.autogui.agents.vlm.models.impl.e.b.d r4 = (com.obric.autogui.agents.vlm.models.impl.e.b.d) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.agents.vlm.models.impl.e.b.d.class, "com.obric.aiagent.plugin");
        o.e(r5, "stepResult");
        o.e(r4, "ctx");
        com.obric.autogui.agents.scripted.a.a r7 = r5.b();
        if (r7 == null) goto L5;
        JsonArray r8 = new Gson().toJsonTree(r7.a()).getAsJsonArray();
        String r1 = r7.getType();
        if (r1 == null) goto L9;
        com.obric.autogui.agents.vlm.models.impl.d.a r2 = r4.b();
        com.obric.autogui.agents.vlm.models.impl.d.C0690d r3 = r4.a();
        o.a(r8);
        com.obric.autogui.agents.vlm.models.impl.d.f.b r9 = (com.obric.autogui.agents.vlm.models.impl.d.f.b) ZeusTransformUtils.preCheckCast(r2.a(r3, r1, r8).a(), com.obric.autogui.agents.vlm.models.impl.d.f.b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        Collection<com.obric.autogui.operator.e.C0780e> r10 = r9.a();
        if (r10 == null) goto L17;
        List<com.obric.autogui.operator.e.C0780e> r11 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"));
        if (r11 == null) goto L17;
    L18:
        String r12 = r7.b();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r13 = false;
        if (r0 != null) goto L21;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L27;
    L33:
        return r11;
    L27:
        if (com.obric.autogui.common.a.d.f28974a.Z() == false) goto L29;
    L30:
        r13 = true;
    L31:
        if (r13 == false) goto L33;
        r4.a(r12, r11);
        goto L33
    L29:
        if (o.a(r12, r4.c()) == true) goto L31;
    L21:
        if (r0.length() == 0) goto L24;
        r14 = false;
    L17:
        r11 = p.b();
        goto L18
    L9:
        return p.b();
    L5:
        return p.b();
    }
}
