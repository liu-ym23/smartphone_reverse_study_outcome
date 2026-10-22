package com.obric.autogui.agents.vlm.models.impl.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: KnowledgeDebugBindingUpdater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {
    public d() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.b
    public void a(com.obric.autogui.agents.vlm.b.C0677b r2, com.obric.autogui.agents.vlm.models.c.b r3, a r4) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r2, SensitiveType.SESSION);
        o.e(r3, "preparation");
        o.e(r1, "requestEnvironment");
        String r5 = com.obric.autogui.evaluation.a.b.f29070a.a();
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return;
    L11:
        r1.a("test_knowledge_id", (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r5), JsonElement.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (d.o.o.d(r6) == true) goto L8;
        r7 = false;
        goto L9
    }
}
