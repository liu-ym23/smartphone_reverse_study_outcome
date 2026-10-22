package com.obric.autogui.agents.vlm.models.omni.upload;

import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniDataFeedbackSessionGuard.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final boolean a(com.obric.autogui.session.a r3, String r4) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "logTag");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(Boolean.valueOf(r3.c()));     // Catch: Throwable -> L5
    L7:
        Throwable r1 = d.n.c(r5);
        if (r1 == null) goto L11;
        OmniDataFeedbackLog.INSTANCE.e(r4, "failed to check Omni session", r1);
    L11:
        if (d.n.b(r5) == false) goto L14;
        r5 = false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }
}
