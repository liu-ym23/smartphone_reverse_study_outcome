package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: ActionEffectActionResultReason.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final String a(com.obric.autogui.operator.g r3) {
        com.obric.autogui.operator.g r4 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        com.obric.autogui.operator.f r0 = r4.g();
        if (r0 == null) goto L15;
        String r1 = r0.a();
        if (r1 == null) goto L15;
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r2 == null) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L15;
    L22:
        return com.obric.autogui.agents.a.b.a(r2, 240);
    L15:
        if (r4.a() == false) goto L18;
        r2 = "step_execution_failed";
        goto L22
    L18:
        if (r4.b() == com.obric.autogui.operator.g.c.f29925d) goto L20;
        StringBuilder r5 = new StringBuilder().append("step_execution_");
        String r6 = r4.b().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r6, "toLowerCase(...)");
        r2 = r5.append(r6).toString();
        goto L22
    L20:
        r2 = "step_execution_completed";
        goto L22
    }
}
