package com.obric.autogui.agents.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectCompletionPlanner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26450a = null;

    static {
        f26450a = new b();
    }

    private b() {
    }

    public final a a(boolean r11, com.obric.autogui.operator.g r12, boolean r13, boolean r14) {
        com.obric.autogui.operator.g r10 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        o.e(r10, "originalResult");
        g r15 = new g(r10.b(), r10.d(), r10.a(), r10.e());
        boolean r16 = r15.g();
        d r17 = e.f26456a.a(r16, r15.e(), r11, r15.f(), r13, r14);
        if (r17 == d.f26453c) goto L5;
    L7:
        boolean r18 = false;
    L9:
        return new a(r17, r15, r18);
    L5:
        if (c.a(r16, r11) == false) goto L7;
        r18 = true;
        goto L9
    }
}
