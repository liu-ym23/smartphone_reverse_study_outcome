package com.obric.autogui.agents.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;

/* JADX INFO: compiled from: OpenAppWaitPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final boolean a(com.obric.autogui.agents.vlm.models.impl.g r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        com.obric.autogui.operator.e.C0780e r1 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(p.j((Iterable) ZeusTransformUtils.preCheckCast(r4.Q(), Iterable.class, "com.obric.aiagent.plugin")), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        com.obric.autogui.operator.b.EnumC0777b r2 = r1.a();
    L10:
        if (r2 == com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L12;
        return false;
    L12:
        com.obric.autogui.operator.g r5 = r4.t();
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.b() == com.obric.autogui.operator.g.c.f29925d) goto L18;
        return false;
    L18:
        if (r5.a() == false) goto L20;
        return false;
    L20:
        if (r5.d() != com.obric.autogui.operator.a.b.a.b.k.a()) goto L25;
        return true;
    L25:
        return false;
    L8:
        r2 = null;
        goto L10
    }
}
