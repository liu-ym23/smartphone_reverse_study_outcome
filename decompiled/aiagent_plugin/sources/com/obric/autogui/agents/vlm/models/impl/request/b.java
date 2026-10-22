package com.obric.autogui.agents.vlm.models.impl.request;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.vlm.models.omni.q;
import com.obric.autogui.common.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StdModelRequestDelegateFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f28034a = null;

    static {
        f28034a = new b();
    }

    private b() {
    }

    public final a a(k r2, com.obric.autogui.agents.vlm.b.C0677b r3) {
        o.e(r2, "cfg");
        o.e(r3, SensitiveType.SESSION);
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r2.k().d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (com.obric.autogui.agents.vlm.models.impl.request.a.a.f28021a.a() == false) goto L7;
        return (a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.a.b(r1), a.class, "com.obric.aiagent.plugin");
    L7:
        if (r3.a().c() == true) goto L9;
        if (r1 == false) goto L13;
        return (a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.c.a.a(), a.class, "com.obric.aiagent.plugin");
    L13:
        return (a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.c.b(), a.class, "com.obric.aiagent.plugin");
    L9:
        return (a) ZeusTransformUtils.preCheckCast(new q(), a.class, "com.obric.aiagent.plugin");
    }
}
