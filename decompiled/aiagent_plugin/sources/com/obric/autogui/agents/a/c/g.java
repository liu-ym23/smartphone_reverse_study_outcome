package com.obric.autogui.agents.a.c;

import com.obric.autogui.agents.a.f.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectExecutionResultEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f26345a = null;

    static {
        f26345a = new g();
    }

    private g() {
    }

    public final f a(com.obric.autogui.agents.a.f.h r8, String r9, com.obric.autogui.operator.g r10) {
        com.obric.autogui.operator.g r11 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        o.e(r8, "action");
        o.e(r9, "attemptId");
        o.e(r11, "originalResult");
        h r4 = new h(r11.b(), r11.d(), r11.a());
        return new f(r8, r9, r4, a(r4), b(r4));
    }

    private final k a(h r1) {
        if (r1.c() == true) goto L12;
        if (r1.b() < 0) goto L12;
        if (r1.a() != com.obric.autogui.operator.g.c.f29925d) goto L14;
        return k.f26442a;
    L14:
        return k.f;
    L12:
        return k.f26446e;
    }

    private final String b(h r1) {
        if (r1.c() == false) goto L6;
        return "execution result has error";
    L6:
        if (r1.b() >= 0) goto L9;
        return "execution result status code is negative";
    L9:
        if (r1.a() != com.obric.autogui.operator.g.c.f29925d) goto L11;
        return "execution result completed";
    L11:
        return "execution result not completed";
    }
}
